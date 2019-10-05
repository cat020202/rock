package com.hqyj.springmvctest.controller;

import java.io.BufferedInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	
	@RequestMapping(value="file.do",method=RequestMethod.GET)
	public String index(){
		
		return "file";
	}
	@RequestMapping(value="download.do",method=RequestMethod.GET)
	public String download(){
		
		return "download";
	}

	@RequestMapping("/springUpload.do")  
	 public String filesUpload(@RequestParam("files") MultipartFile[] files,HttpServletRequest req) {
	//获取服务器文件地址
	  String realpath = req.getSession().getServletContext().getRealPath("/upload");
	  //判断file数组不能为空并且长度大于0  
      if(files!=null&&files.length>0){  
          //循环获取file数组中得文件  
          for(int i = 0;i<files.length;i++){  
              MultipartFile file = files[i];  
              //保存文件  
              boolean is =saveFile(file, realpath);
              if(is){
              	req.setAttribute("info", "上传成功");
              }else{
              	req.setAttribute("info", "上传失败");
              }
          }  
         
      }else{
      	req.setAttribute("info", "没有找到文件");
      }

      return "file";
	}
	//保存文件
	 private boolean saveFile(MultipartFile file, String path) {  
         // 判断文件是否为空  
         if (!file.isEmpty()) {  
             try {  
                 File filepath = new File(path);
                 if (!filepath.exists()) 
                     filepath.mkdirs();
                 // 文件保存路径  
                 String savePath = path +"/"+ file.getOriginalFilename();  
                 // 转存文件  
                 file.transferTo(new File(savePath));  
                 return true;  
             } catch (Exception e) {  
                 e.printStackTrace();  
             }  
         }  
         return false;  
     }
	 
	 
	  @RequestMapping("/download")
	public void download(String filePath, HttpServletResponse response,HttpServletRequest req){
		  //获取服务器文档地址			 
		  String localPath = req.getSession().getServletContext().getRealPath("/upload");
			try {
				//转成file文件
				File file = new File(localPath+"/"+filePath);
				//转成输入流对象
				InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
				//清空buffer,设置页面不缓存
			    response.reset();
			    //设置返回页面的头 meta 信息
			    response.setHeader("Content-disposition", "attachment; filename="+filePath+"");
			    //设置文件类型
			    response.setContentType("application/msexcel");
			    //把输入流对象复制给输出流对象
				FileCopyUtils.copy(inputStream, response.getOutputStream());
		
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	  }

}
