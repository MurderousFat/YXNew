package com.tenze.pms.action.sys;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tenze.action.common.BaseAction;
import com.tenze.common.utils.CommonException;
import com.tenze.common.utils.FileOperation;
import com.tenze.utils.BaseDto;
import com.tenze.utils.Dto;
import com.tenze.utils.SysConstants;
import com.tenze.utils.helper.JsonHelper;

/**
 * 产品图片上传Action
 * 
 * @author 郑腾志
 * 
 */
@Controller(value = "UploadAction")
@Scope(value = "prototype")
public class UploadAction extends BaseAction {

	private static final long serialVersionUID = 1557002648239441724L;

	public static final String FILEROOT = "upload";

	public static final String DIRECTORY = "product";

	public static final String ALLOWEXT = "jpg|jpeg|png";

	/**
	 * 文件保存目录
	 */
	private String directory;

	private String inputid;

	private String imageid;

	private String filenameid;

	/**
	 * 用于工作流表单设计器，上传之后，生成图片，进行改变大小和拖拽
	 */
	private int resizeImage = 0;

	/**
	 * 允许上传的文件扩展名
	 */
	private String allowExt;

	/**
	 * 文件对象
	 */
	private File[] file;

	/**
	 * 文件名称
	 */
	private String[] fileName;

	private String[] finalPath;
	
	private String json;

	public String upimg() throws IOException {
		if (directory==null || directory.trim().length()==0) {
			directory = DIRECTORY;
		}
		if (allowExt==null || allowExt.trim().length()==0) {
			allowExt = ALLOWEXT;
		}
		try {
			FileOperation fo = new FileOperation(this.getReq()
					.getServletContext().getRealPath("/"), FILEROOT, directory,
					true);
			String rtnPath = "";
			if (file != null && file.length > 0 && file[0] != null
					&& file[0].exists()) {
				fo.setAllowExt(allowExt);
				rtnPath = fo.upload(file[0], fileName[0], null, null);
				String resize = this.getRequestDto().getAsString(
						"file_upload_is_resize");
				String smallPath = "";
				if (resize!=null 
						&& SysConstants.FLAG_ON.equals(resize)) {
					smallPath = fo.resize(rtnPath, 300);
				}
				Dto outDto = new BaseDto(SysConstants.SUCCESS, "true");
				outDto.put("file_path", this.getReq().getContextPath()+rtnPath);// 传回上传的最终路径
				if (StringUtils.isNotEmpty(smallPath)) {
					outDto.put("small_path", smallPath);// 传回缩略图路径
				}
				outDto.put("file_name", fileName[0]);// 传回文件名称
				write(outDto.toJson(), this.getRes());
			} else {
				setFailureTipMsg(getText("Choose.file"));
			}
		} catch (CommonException e) {
			e.printStackTrace();
			setFailureTipMsg(getText(e.getErrMessage()));
		}
		return NULL_SUCCESS;
	}
	
	/**
	 * 通用的单独文件上传(前台接收为JQUERY)
	 * 
	 * @return
	 * @throws IOException
	 */
	public String upfile() throws IOException {
		if (isGetMethod()) {
			return INPUT_RESULT;
		}
		String infoStr;
		Map<String,String> map = new HashMap<String,String>();
		try {
			FileOperation fo = new FileOperation(this.getReq()
					.getServletContext().getRealPath("/"), "upload", directory,
					true);
			fo.setAllowExt(allowExt);
			String rtnPath = "";
			if (file != null && file.length > 0) {
				if (file[0] != null) {
					if (file[0] != null && file[0].exists()) {
						rtnPath = fo.upload(file[0], fileName[0], null, null);
						map.put("file_name", fileName[0]);
						map.put("file_path", this.getReq().getContextPath()+rtnPath);
					}
				}
			} else {
				infoStr = getText("Choose.file");
			}
		} catch (CommonException e) {
			e.printStackTrace();
				setFailureTipMsg( getText(e.getErrMessage()));
				return NULL_SUCCESS;
		}
			this.write(JsonHelper.encodeObject2Json(map));
			return NULL_SUCCESS;
	}


	public File[] getFile() {
		return file;
	}

	public void setFile(File[] file) {
		this.file = file;
	}

	public String[] getFileName() {
		return fileName;
	}

	public void setFileFileName(String[] fileName) {
		this.fileName = fileName;
	}

	public String[] getFinalPath() {
		return finalPath;
	}

	public void setFinalPath(String[] finalPath) {
		this.finalPath = finalPath;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public String getInputid() {
		return inputid;
	}

	public void setInputid(String inputid) {
		this.inputid = inputid;
	}

	public String getImageid() {
		return imageid;
	}

	public void setImageid(String imageid) {
		this.imageid = imageid;
	}

	public String getFilenameid() {
		return filenameid;
	}

	public void setFilenameid(String filenameid) {
		this.filenameid = filenameid;
	}

	public String getAllowExt() {
		return allowExt;
	}

	public void setAllowExt(String allowExt) {
		this.allowExt = allowExt;
	}

	public int getResizeImage() {
		return resizeImage;
	}

	public void setResizeImage(int resizeImage) {
		this.resizeImage = resizeImage;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	
}
