package com.tenze.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.LinkedList;
import java.util.List;

public class FileUtil {
	//写文件,文件头插入

	
		public static boolean copyFile(String source,String target){
			File file = new File(source);
			if(!file.exists())return false;
			File destFile = new File(target);
        	if(!destFile.getParentFile().exists()){
        		destFile.getParentFile().mkdirs();
        	}
        	FileInputStream fis = null;
        	FileOutputStream fos = null;
			try {
				fis = new FileInputStream(file);
				fos = new FileOutputStream(destFile);
				int idx;
				byte[] buffer = new byte[1024];
				while((idx=fis.read(buffer))!=-1){
					fos.write(buffer,0,idx);
				}
				fos.flush();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}  finally{
        		try {
        			if(fos!=null){
        				fos.close();
        			}
        			if(fis!=null){
        				fis.close();
        			}
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
        }
			return true;
		}
		
		
		public static boolean writeStrToFile(String content, String path){
			FileOutputStream fos = null;
			Writer os = null;
	        try {  
	        	File file = new File(path.substring(0, path.lastIndexOf("/")));
	        	if(!file.exists()){
	        		file.mkdirs();
	        	}
	            fos = new FileOutputStream(new File(path));
	            os = new OutputStreamWriter(fos, "UTF8");
	            os.write(content);
	            os.flush();
	            return true;
	        } catch (FileNotFoundException e) {  
	            e.printStackTrace();  
	            return false;
	        } catch (IOException e) {  
	            e.printStackTrace();
	            return false;
	        }  finally{
	        		try {
	        			if(fos!=null){
	        				fos.close();
	        			}
	        			if(os!=null){
	        				os.close();
	        			}
					} catch (IOException e) {
						e.printStackTrace();
						return false;
					}
	        }
		}
	
		public static void write(String filename,String value) throws IOException
		{
			File output=new File(filename);
			if (!output.exists()) {
			    output.createNewFile();
			   }
			RandomAccessFile   raf   =   new   RandomAccessFile(output,   "rw"); 
	        FileChannel   fc   =   raf.getChannel();   
	        FileLock   fl   =   fc.tryLock();   
	  
	        if   (fl.isValid())   {   
	            raf.seek(0);
	            raf.writeBytes(String.valueOf(value));
	            fl.release();   
	        }   
	        raf.close();  
		}
		
		//读取文件
		public static List<String> read(String filename) throws IOException
		{
			List<String> list = new LinkedList<String>();
			File input=new File(filename);
			InputStreamReader read = new InputStreamReader(new FileInputStream(input),"UTF8");
		    BufferedReader reader=new BufferedReader(read);
		    String line="";
		    while((line=reader.readLine())!=null){
		    	list.add(line);
		    }
		    reader.close();
		    return list;
		}
		
		//删除文件
		public static boolean delete(String filename) throws IOException
		{
			boolean   success = (new File(filename)).delete();
			return success;
		}
		
		public static boolean deleteAbsolute(File file)
		{
			boolean   success = file.delete();
			return success;
		}
		
		public static boolean deleteAbsolute(String filename)
		{
			return deleteAbsolute(new File(filename));
		}
		
		public static String readAbsolute(String filename){
			return readAbsolute(new File(filename));
		}
		
		public static String readAbsolute(File file)
		{
			InputStreamReader read = null;
			BufferedReader reader = null;
			StringBuilder builder  = new StringBuilder();
			try {
				read = new InputStreamReader(new FileInputStream(file),"UTF8");
				reader=new BufferedReader(read);
				String line="";
				while((line=reader.readLine())!=null){
					builder.append(line).append("\r\n");
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					if(read!=null){
							read.close();
					}
					if(reader!=null){
						reader.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		    return builder.toString();
		}
		
		public static boolean buildParent(String src){
			return buildParent(new File(src));
		}
		
		public static boolean buildParent(File file){
			if(!file.getParentFile().exists())file.mkdirs();
			return true;
		}
		
		public static void main(String[] args) {
		}


		public static boolean transfer(File f, String content, String path,
				String parent) {
			if(writeStrToFile(content, path+"/"+parent+"/"+f.getName()))
			{
				return f.delete();
			}
			return false;
		}
}
