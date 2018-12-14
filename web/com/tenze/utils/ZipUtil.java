package com.tenze.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import com.agile.zip.CnZipInputStream;
import com.agile.zip.CnZipOutputStream;
import com.agile.zip.ZipEntry;

/**
 * 压缩/解压缩zip包处理类
 * 
 * @author hubo
 * @date 2014-01-15
 */
public class ZipUtil {

	/**
	 * 将文件（或文件夹）进行压缩为指定的zip文件
	 * 
	 * @param inputFileName
	 *            要压缩的文件或文件夹
	 * @param outputFileName
	 *            压缩后的zip文件
	 * @throws Exception
	 */
	public static void zip(String inputFileName, String outputFileName)
			throws IOException {
		File file = new File(outputFileName);
		if (file.exists()) {// 如果要压缩后的zip文件已经存在，则先将该文件删除
			file.delete();
		}
		CnZipOutputStream out = new CnZipOutputStream(new FileOutputStream(
				outputFileName), "GBK");
		zip(out, new File(inputFileName), "");
		out.close();
	}

	private static void zip(CnZipOutputStream out, File f, String base)
			throws IOException {
		if (f.isDirectory()) {// 文件夹
			File[] fl = f.listFiles();
			out.putNextEntry(new ZipEntry(base + "/"));
			base = base.length() == 0 ? "" : base + "/";
			for (int i = 0; i < fl.length; i++) {
				zip(out, fl[i], base + fl[i].getName());
			}
		} else {// 文件
			if (base.length() == 0) {// 当base为空时，表示是压缩指定的一个文件，否则就是压缩文件夹下的所有文件
				base = f.getName();
			}
			out.putNextEntry(new ZipEntry(base));
			FileInputStream in = new FileInputStream(f);
			int b;
			byte[] buffer = new byte[1024];// 提高文件压缩的速度
			while ((b = in.read(buffer)) != -1) {
				out.write(buffer, 0, b);
			}
			in.close();
		}
	}

	/**
	 * 将指定的zip文件解压到指定的目录下,如果文件已存在则覆盖。
	 * 
	 * @param compress
	 *            zip压缩文件,如 D:/doc_c06_net.zip
	 * @param decompression
	 *            解压路径,如 D:/doc_redcome_com/
	 */
	public static void dezip(String compress, String decompression) {
		File infile = new File(compress);
		dezip(infile, decompression);
	}

	/**
	 * 将指定的zip文件解压到指定的目录下,如果文件已存在则覆盖。
	 * 
	 * @param infile
	 *            zip压缩文件
	 * @param decompression
	 *            解压路径,如 D:/doc_redcome_com/
	 */
	public static void dezip(File infile, String decompression) {
		File dir = new File(decompression);

		try {
			// 检查是否是ZIP文件
			ZipFile zip = new ZipFile(infile);
			zip.close();
			// 建立与目标文件的输入连接
			CnZipInputStream in = new CnZipInputStream(new FileInputStream(
					infile), "GBK");
			ZipEntry file = in.getNextEntry();
			byte[] c = new byte[1024];
			int slen;
			while (file != null) {
				String zename = file.getName();
				if (file.isDirectory()) {
					File files = new File(dir.getAbsolutePath() + "/" + zename); // 在指定解压路径下建子文件夹
					files.mkdirs();// 新建文件夹
				} else {
					File files = new File(dir.getAbsolutePath() + "/" + zename)
							.getParentFile();// 当前文件所在目录
					if (!files.exists()) {// 如果目录文件夹不存在，则创建
						files.mkdirs();
					}
					FileOutputStream out = new FileOutputStream(
							dir.getAbsolutePath() + "/" + zename);
					while ((slen = in.read(c, 0, c.length)) != -1)
						out.write(c, 0, slen);
					out.close();
				}
				file = in.getNextEntry();
			}
			in.close();
		} catch (ZipException zipe) {
			zipe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception i) {
			i.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("11111111111111111111111");
		long begin = System.currentTimeMillis();
		String version = "1.0.2014060717";
		try {
			// 压缩SQL文件
			// zip("F:/deploy/GX_WEB_ERP/ZIP/2014-06//" + version + "/SQL",
			// "F:/deploy/GX_WEB_ERP/ZIP/2014-06//" + version + "/sql_"
			// + version + ".zip");//
			// 压缩程序文件
			zip("C:/Users/Administrator/Desktop/will_delete/module-cron-facade",
					"C:/Users/Administrator/Desktop/test_"+begin+".zip");// 压缩文件
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis() - begin);
		System.out.println("11111111111111111111111");
	}
}
