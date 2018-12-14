/**
 * 
 */
package com.tenze.pms.servlet;

import com.tenze.common.utils.ConfigUtils;
import com.tenze.utils.BaseDto;
import com.tenze.utils.Dto;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;

//import com.sun.image.codec.jpeg.JPEGCodec;
//import com.sun.image.codec.jpeg.JPEGEncodeParam;
//import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 随机生成验证图片
 * 
 * @author  TenzeTseng
 *        
 * 
 */
public class ImageServlet extends HttpServlet {


	@Override
	public void doGet(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		// 设置页面不缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		// response.setContentType("image/png");

		String name = request.getParameter("name");

		if(!name.isEmpty()){
			String ROOT = ConfigUtils.getValue("file.upload.path");
			ROOT += name.substring(name.lastIndexOf(".") + 1) + "/";
			String filepath = Paths.get(ROOT, name).toString();
			File file=new File(filepath);
			if(!file.exists()){
				Dto jsonDto = new BaseDto();
				jsonDto.put("success", "true");
				jsonDto.put("msg", "没有找到文件");
				OutputStream out = response.getOutputStream();
				out.write(jsonDto.toJson().getBytes("UTF-8"));
				out.flush();
			}else
			{
				BufferedImage img = ImageIO.read(file);
				ImageIO.write(img, "JPEG", response.getOutputStream());
			}
		}
	}

	@Override
	public void doPost(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		doGet(request, response);
	}


}

