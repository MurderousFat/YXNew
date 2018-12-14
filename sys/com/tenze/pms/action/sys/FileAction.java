package com.tenze.pms.action.sys;


import com.tenze.action.common.BaseAction;
import com.tenze.common.utils.ConfigUtils;
import com.tenze.utils.BaseDto;
import com.tenze.utils.Dto;
import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.util.UUID;

/**
 * Created by mac on 2017/6/7.
 */

@Controller("FileAction")
@Scope(value="prototype")
public class FileAction extends BaseAction {


    private File  file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    private String FileFileName;

    public String getFileFileName() {
        return FileFileName;
    }

    public void setFileFileName(String fileFileName) {
        FileFileName = fileFileName;
    }

    private String imgFile;

    public String getImgFile() {
        return imgFile;
    }

    public void setImgFile(String imgFile) {
        this.imgFile = imgFile;
    }

    public String handleFileUpload() {
        if (file.exists()) {
            try {
                String path = ConfigUtils.getValue("file.upload.path");// "//Users//mac//uploads/";
                //String path ="F://uploads//";
                //存放到指定文件夹(依据文件后缀)
                path += FileFileName.substring(FileFileName.lastIndexOf(".") + 1) + "/";
                File fpath = new File(path);
                if (!fpath.exists()) {
                    fpath.mkdirs();
                }
                String  fileNameNew= UUID.randomUUID().toString().trim().toUpperCase() + "." + FileFileName.substring(FileFileName.lastIndexOf(".") + 1);
                File localFile = new File(path + File.separator + fileNameNew);
                FileUtils.copyFile(file,localFile);

                Dto jsonDto = new BaseDto();
                jsonDto.put("success", "true");
                jsonDto.put("msg", fileNameNew);
                write(jsonDto.toJson());

                return SUCCESS;

            } catch (Exception e) {
                e.printStackTrace();
                return "error|" + e.getMessage();
            }
        } else {
            return "error|上传失败，因为文件是空的.";
        }
    }


//    public String getImgFiles() {
////        String ROOT = ConfigUtils.getValue("file.upload.path");
//        if(!imgFile.isEmpty()){
//            String ROOT ="F://uploads//";
//            ROOT += imgFile.substring(imgFile.lastIndexOf(".") + 1) + "/";
//            String filepath = Paths.get(ROOT, imgFile).toString();
//
//            HttpServletResponse response = null;
//            try {
//                response = ServletActionContext.getResponse();
////                response.setContentType("multipart/form-data");
////                response.setContentType("image/jpeg");
////                response.setContentType("image/pjpeg");
//                response.setHeader("Pragma", "No-cache");
//                response.setHeader("Cache-Control", "no-cache");
//                response.setDateHeader("Expires", 0);
//
//                File file=new File(filepath);
//                if(!file.exists()){
//                    return SUCCESS;
//                }
//                BufferedImage img = ImageIO.read(file);
//                ImageIO.write(img, "JPEG", response.getOutputStream());
//                return SUCCESS;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//        return SUCCESS;
//    }
}
