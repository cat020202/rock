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
	//��ȡ�������ļ���ַ
	  String realpath = req.getSession().getServletContext().getRealPath("/upload");
	  //�ж�file���鲻��Ϊ�ղ��ҳ��ȴ���0  
      if(files!=null&&files.length>0){  
          //ѭ����ȡfile�����е��ļ�  
          for(int i = 0;i<files.length;i++){  
              MultipartFile file = files[i];  
              //�����ļ�  
              boolean is =saveFile(file, realpath);
              if(is){
              	req.setAttribute("info", "�ϴ��ɹ�");
              }else{
              	req.setAttribute("info", "�ϴ�ʧ��");
              }
          }  
         
      }else{
      	req.setAttribute("info", "û���ҵ��ļ�");
      }

      return "file";
	}
	//�����ļ�
	 private boolean saveFile(MultipartFile file, String path) {  
         // �ж��ļ��Ƿ�Ϊ��  
         if (!file.isEmpty()) {  
             try {  
                 File filepath = new File(path);
                 if (!filepath.exists()) 
                     filepath.mkdirs();
                 // �ļ�����·��  
                 String savePath = path +"/"+ file.getOriginalFilename();  
                 // ת���ļ�  
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
		  //��ȡ�������ĵ���ַ			 
		  String localPath = req.getSession().getServletContext().getRealPath("/upload");
			try {
				//ת��file�ļ�
				File file = new File(localPath+"/"+filePath);
				//ת������������
				InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
				//���buffer,����ҳ�治����
			    response.reset();
			    //���÷���ҳ���ͷ meta ��Ϣ
			    response.setHeader("Content-disposition", "attachment; filename="+filePath+"");
			    //�����ļ�����
			    response.setContentType("application/msexcel");
			    //�������������Ƹ����������
				FileCopyUtils.copy(inputStream, response.getOutputStream());
		
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	  }

}
