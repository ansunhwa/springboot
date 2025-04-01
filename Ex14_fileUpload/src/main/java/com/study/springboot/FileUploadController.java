package com.study.springboot;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

@Controller
public class FileUploadController {
	
	@RequestMapping("/")
	public String root() {
		return "index";
	}
	
	@RequestMapping("/uploadOk")   //static/upload를 만들어야 하고 실제로는 bin에 들어간다
	public @ResponseBody String uploadOk(HttpServletRequest request) {
		JSONObject obj = new JSONObject();
		
		//upload폴더의 경로 얻어오기  / 오류가 날 수 있으므로 trycatch
		try {
			String filePath = ResourceUtils.getFile("classpath:static/upload").toPath().toString();
			System.out.println("파일 경로" + filePath);
			
			List<Part> fileParts = request.getParts().stream()   //가지고 온 Parts를 stream으로 변환 <Part>import
									.filter(part -> "files".equals(part.getName()) && part.getSize() > 0)
									.collect(Collectors.toList()) ;    
			
			for(Part filePart : fileParts) {
				String fileName = Paths.get(filePart.getSubmittedFileName())
					.getFileName().toString();
				// 파일을 저장할 전체경로와 이름
				String dst = filePath + "\\" + fileName;
				
				try(BufferedInputStream fin = new BufferedInputStream(filePart.getInputStream());
						BufferedOutputStream fout = new BufferedOutputStream(new FileOutputStream(dst));  //스트림을 통해 내보내야 한다
						)
				{
					int data;
					while(true) {
						data = fin.read();
						if(data == -1)  //읽다가 맨마지막 이면 break;빠져나옴
							break;
						fout.write(data);
					}
					
				} catch(IOException e) {
					e.printStackTrace();
				}
				System.out.println("upload : FileName = " + dst + "<br>");
			}
			obj.put("success", "1");
			obj.put("desc", "업로드 성공");
		} catch (Exception e) {
			e.printStackTrace();
			obj.put("success", "0");
			obj.put("desc", "업로드 실패");
		}
		return obj.toJSONString();
		
		
		
	}

}
