package com.anilcodes.springbootblogjwtauthenticationRESTapi.fileupload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;

@Api
@RestController
public class FileUploadController {
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@PostMapping()
	public ResponseEntity<Object> fileUpload(@RequestHeader String authorization,@RequestPart("file") MultipartFile file){
		return fileUploadService.uploadFile(file);
	}

}
