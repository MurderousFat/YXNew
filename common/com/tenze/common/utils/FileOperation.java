package com.tenze.common.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;


/**
 * 文件操作类,文件上传、生成缩略图
 * 
 * @author 
 * 
 */
public class FileOperation {

	private String webRoot;// 网站根路径

	private String fileROOT = "upload";// 文件上传时,保存在"网站根目录/upload/"下面

	private String fileDirectory = "image";// 文件上传后,保存在"网站根目录/upload/image/"下面

	private boolean putByDate = true;// 上传的文件是否按日期分别存放,如果是,最终图片路径为/upload/image/20090101/这个样子,缩略图路径为/upload/image/20090101/smallimg这个样子

	private boolean img = true;// 上传的是否是图片

	private int maxFileSize = 999999999;// 上传文件的最大文件大小

	private static final int BUFFER_SIZE = 16 * 1024;// 缓冲区大小

	private String allowExt = "jpg|jpeg|gif|png|bmp|txt|doc|docx|xls|xlsx|ppt|pptx|pdf|rar|zip|csv|tbi";// 允许上传的文件格式

	public static final String FILESEPARATOR = "/";

	public FileOperation(String webRoot) {
		this.webRoot = webRoot;
	}

	public FileOperation(String webRoot, String fileDirectory) {
		super();
		this.webRoot = webRoot;
		this.fileDirectory = fileDirectory;
	}

	public FileOperation(String webRoot, String fileROOT, String fileDirectory) {
		super();
		this.webRoot = webRoot;
		this.fileROOT = fileROOT;
		this.fileDirectory = fileDirectory;
	}

	public FileOperation(String webRoot, String fileROOT, String fileDirectory,
			boolean putByDate) {
		super();
		this.webRoot = webRoot;
		this.fileROOT = fileROOT;
		this.fileDirectory = fileDirectory;
		this.putByDate = putByDate;
	}

	public FileOperation(String webRoot, String fileROOT, String fileDirectory,
			boolean putByDate, boolean img) {
		super();
		this.webRoot = webRoot;
		this.fileROOT = fileROOT;
		this.fileDirectory = fileDirectory;
		this.putByDate = putByDate;
		this.img = img;
	}

	public FileOperation(String webRoot, String fileROOT, String fileDirectory,
			boolean putByDate, boolean img, int maxFileSize, String allowExt) {
		super();
		this.webRoot = webRoot;
		this.fileROOT = fileROOT;
		this.fileDirectory = fileDirectory;
		this.putByDate = putByDate;
		this.img = img;
		this.maxFileSize = maxFileSize;
		this.allowExt = allowExt;
	}

	/**
	 * 创建文件需放置的所有文件夹
	 * 
	 */
	private String createNewDirectory() {
		StringBuilder builder = new StringBuilder(this.getWebRoot());
		builder.append(this.getFileROOT()).append(FILESEPARATOR)
				.append(this.getFileDirectory()).append(FILESEPARATOR);
		if (putByDate) {
			builder.append(this.getDateString("yyyyMMdd", new Date()))
					.append(FILESEPARATOR);
		}
		File f = new File(builder.toString());
		if (!f.exists()) {
			f.mkdirs();
		}
		return builder.toString();
	}

	/**
	 * 生成文件名,以当前时间毫秒数和随机数组成
	 * 
	 * @param ext
	 *            当前文件扩展名
	 * @return 新文件名
	 */
	private String createNewFileName(String ext) {
		Random rnd = new Random();
		return this.getDateString("yyyyMMddHHmmss", new Date()) + "_"
				+ rnd.nextInt(10000000) + "." + ext;
	}

	/**
	 * 取出当前文件扩展名
	 * 
	 * @param fileName
	 *            文件名
	 * @return 扩展名
	 */
	private String getFileExt(String fileName) {
		if (fileName == null)
			return null;
		String exts[] = fileName.split("\\.");

		if (exts.length < 2)
			return null;
		return exts[exts.length - 1].toLowerCase();// exts[exts.length-1]);
	}

	/**
	 * 对文件进行复制,上传
	 * 
	 * @param src
	 *            文件源
	 * @param fileName
	 *            上传的源文件名
	 * @param 上传生成的目标文件名
	 *            ，如果传null或"",则随机生成
	 * @parma targetFileDir 文件存放的相对路径(可以为null或者空，如果不为空，必须以"/"结尾且不能以"/"开头)
	 *        如：普通文件夹/普通文件夹1/普通文件夹2/，<br />
	 *        设定了此参数后，最终的存放路径为ROOT/upload/this.getFileDirectory()/targetFileDir/
	 * 
	 * @return 最终要存入数据库的路径
	 * @throws IOException
	 */
	public String upload(File srcFile, String fileName, String targetFileName,
			String targetFileDir) throws CommonException, IOException {
		if (!srcFile.exists()) {
			throw new CommonException("FileNotExists");
		}
		if (srcFile.length() > this.getMaxFileSize())
			throw new CommonException("FileTooLarge");
		String ext = this.getFileExt(fileName);
		if (!Pattern.matches(this.getAllowExt(), ext)) {
			throw new CommonException("InvalidFileType");
		}

		if (this.isImg()) {
			try {
				ImageIO.read(srcFile);
			} catch (IOException e) {
				e.printStackTrace();
				throw new CommonException("NotAImage");
			}
		}
		String path = null;
		if (targetFileDir==null || targetFileDir.trim().length()==0) {// 如果没有传相对路径
			path = this.createNewDirectory();
		} else {
			targetFileDir = targetFileDir.replace(" ", "");// 去空格
			// 按自定义路径处理
			StringBuilder builder = new StringBuilder(this.getWebRoot());
			builder.append(this.getFileROOT()).append(FILESEPARATOR)
					.append(this.getFileDirectory()).append(FILESEPARATOR);
			builder.append(targetFileDir);
			File f = new File(builder.toString());
			if (!f.exists()) {
				f.mkdirs();
			}
			path = builder.toString();
		}

		String filePath = "";
		if (targetFileName == null || targetFileName.trim().equals("")) {
			String newFileName = this.createNewFileName(ext);
			filePath = path.concat(newFileName);
		} else {
			targetFileName = targetFileName.replace(" ", "");
			filePath = path.concat(targetFileName);
		}
		File targetFile = new File(filePath);

		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(targetFile);
		int temp = 0;
		try {
			byte[] buffer = new byte[1024];
			while ((temp = in.read(buffer)) != -1) {
				out.write(buffer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return filePath.replace(this.getWebRoot(), FILESEPARATOR);
	}

	/**
	 * 生成图片缩略图
	 * 
	 * @param path
	 *            源文件路径 ，如：/upload/image/2xxxx.jpg
	 * @param resizeHeight
	 *            生成缩略图的高度
	 * @return 返回最终的缩略图路径
	 * @throws IOException
	 * @throws CommonException
	 *             源文件不存在
	 */
	public String resize(String path, int resizeHeight) throws IOException,
			CommonException {
		StringBuilder builder = new StringBuilder(this.getWebRoot());
		String finalPath = builder.append(path.substring(1)).toString();
		File srcFile = new File(finalPath);
		if (!srcFile.exists()) {
			throw new CommonException("FileNotExists");
		}
		String absPath = srcFile.getAbsolutePath();
		String fileName = srcFile.getName();
		StringBuilder targetBuilder = new StringBuilder(absPath);
		targetBuilder.append(".").append(resizeHeight).append("x")
				.append(resizeHeight).append(".").append(getFileExt(fileName));
		String finalTargetPath = targetBuilder.toString();
		File targetFile = new File(finalTargetPath);

		NewScaleImage nsi = new NewScaleImage(srcFile, targetFile);
		nsi.resizeByHeight(resizeHeight);
		finalTargetPath = finalTargetPath.replace(this.getWebRoot(),
				FILESEPARATOR);
		finalTargetPath = finalTargetPath.replace("\\", FILESEPARATOR);
		return finalTargetPath;
	}

	/**
	 * 剪切文件
	 * 
	 * @param srcFile
	 *            剪切源文件
	 * @param webroot
	 * @return
	 */
	public String copyAndDel(String srcFilePath) throws IOException {
		String path = this.createNewDirectory();
		File srcFile = new File(this.getWebRoot().concat(
				srcFilePath.substring(1)));
		if (srcFile.exists()) {
			String newFileName = this.createNewFileName("jpg");
			File targetFile = new File(path.concat(newFileName));

			InputStream in = null;
			OutputStream out = null;
			try {
				in = new BufferedInputStream(new FileInputStream(srcFile),
						BUFFER_SIZE);
				out = new BufferedOutputStream(
						new FileOutputStream(targetFile), BUFFER_SIZE);
				byte[] buffer = new byte[BUFFER_SIZE];
				while (in.read(buffer) > 0) {
					out.write(buffer);
				}
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
			path = path.replace(this.getWebRoot(), FILESEPARATOR).concat(
					newFileName);
		} else {
			String filename = "";
			String[] src = srcFilePath.split("/");
			if (src != null && src.length > 0) {
				filename = src[src.length - 1];
				throw new IOException(filename);
			}
		}

		return path;
	}

	/**
	 * 删除文件夹
	 * 
	 * @param path
	 */
	public void deleteFile(File path) {
		if (path.isDirectory()) {
			File[] files = path.listFiles();
			for (File file : files) {
				deleteFile(file);
			}
			path.delete();
		} else {
			path.delete();
		}
	}

	/**
	 * @return allowExt
	 */
	public String getAllowExt() {
		return allowExt;
	}

	/**
	 * @param allowExt
	 *            要设置的 allowExt
	 */
	public void setAllowExt(String allowExt) {
		this.allowExt = allowExt;
	}

	/**
	 * @return fileDirectory
	 */
	public String getFileDirectory() {
		return fileDirectory;
	}

	/**
	 * @param fileDirectory
	 *            要设置的 fileDirectory
	 */
	public void setFileDirectory(String fileDirectory) {
		this.fileDirectory = fileDirectory;
	}

	/**
	 * @return fileROOT
	 */
	public String getFileROOT() {
		return fileROOT;
	}

	/**
	 * @param fileROOT
	 *            要设置的 fileROOT
	 */
	public void setFileROOT(String fileROOT) {
		this.fileROOT = fileROOT;
	}

	/**
	 * @return webRoot
	 */
	public String getWebRoot() {
		return webRoot;
	}

	/**
	 * @param webRoot
	 *            要设置的 webRoot
	 */
	public void setWebRoot(String webRoot) {
		this.webRoot = webRoot;
	}

	/**
	 * @return isImg
	 */
	public boolean isImg() {
		return img;
	}

	/**
	 * @param isImg
	 *            要设置的 isImg
	 */
	public void setImg(boolean isImg) {
		this.img = isImg;
	}

	/**
	 * @return maxFileSize
	 */
	public int getMaxFileSize() {
		return maxFileSize;
	}

	/**
	 * @param maxFileSize
	 *            要设置的 maxFileSize
	 */
	public void setMaxFileSize(int maxFileSize) {
		this.maxFileSize = maxFileSize;
	}

	/**
	 * @return putByDate
	 */
	public boolean isPutByDate() {
		return putByDate;
	}

	/**
	 * @param putByDate
	 *            要设置的 putByDate
	 */
	public void setPutByDate(boolean putByDate) {
		this.putByDate = putByDate;
	}

	private String getDateString(String format, Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(d);
	}
}
