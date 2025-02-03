package com.ssafy.mvc.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FileDownloadView extends AbstractView {

	// 스프링에서 파일이나 클래스 등등 리소스를 로드할때는 ResourceLoader 인터페이스를 이용해서 가져온다
	private ResourceLoader resourceLoader;

// 	@Autowired : 이거 없어도 들어있는거야! 왜냐면 생성자가 하나밖에 없으니까
	public FileDownloadView(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String fileName = (String) model.get("fileName");
		Resource resource = resourceLoader.getResource("classpath:/static/img");
		File file = new File(resource.getFile(), fileName);
		//////////////////////////////////////////////////// 응답 Header 설정
		
		
		fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1"); //한글 같은게 다른 브라우저 혹은 어딘가에서 꺠질 수 있따.
		response.setHeader("Content-Disposition", "attachment; fileName=\""+fileName+"\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		/////////////////////////////////////////////////////
		
		try(FileInputStream fis = new FileInputStream(file);
				OutputStream os = response.getOutputStream()){
			FileCopyUtils.copy(fis, os);
		}
		
	}
	
	
	
	

}
