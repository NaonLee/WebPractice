package com.spring.function.ex02;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.coobird.thumbnailator.Thumbnails;

@Controller
public class FileDownloadController {
	private static String CURR_IMAGE_REPO_PATH = "c:\\spring\\image_repo";
	
	@RequestMapping("/download")
	public void download(@RequestParam("imageFileName") String imageFileName, 
			HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String filePath = CURR_IMAGE_REPO_PATH + "\\" + imageFileName;
		File image = new File(filePath);

		int lastIndex = imageFileName.lastIndexOf(".");
		String fileName = imageFileName.substring(0, lastIndex);
		
		File thumbnail = new File(CURR_IMAGE_REPO_PATH+"\\"+"thumbnail"+"\\"+fileName+".jpg");
		
		if(image.exists()) {
			thumbnail.getParentFile().mkdirs();
			Thumbnails.of(image).size(50, 50).outputFormat("jpg").toFile(thumbnail);
			
			//print the thumbnails directly without files 
			//Thumbnails.of(image).size(50, 50).outputFormat("jpg").toOutputStream(out);
		}
		
		FileInputStream in = new FileInputStream(thumbnail);
		byte[] buffer = new byte[1024 * 8];
		//print the thumbnails directly without files 
		//out.write(buffer);
		while(true) {
			int count = in.read(buffer);	//number of character in buffer
			if( count == -1 )			//end of buffer
				break;
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
	}
}
