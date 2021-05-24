package com.anilcodes.springbootblogjwtauthenticationRESTapi.fileupload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.anilcodes.springbootblogjwtauthenticationRESTapi.common.ResponseHandler;

@Service
public class FileUploadService {
	
	@Value("${file.upload-dir}")
	private String FILE_DIRECTORY;	
	
	@Autowired
	private FileMetaDataRepository fileMetaRepository;
	
	private boolean isValidFile(MultipartFile file) {
		String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
		return fileExtension.equalsIgnoreCase("png") || fileExtension.equalsIgnoreCase("jpg") || fileExtension.equalsIgnoreCase("jpeg");
	}

	public ResponseEntity<Object> uploadFile(MultipartFile file) {
		if(!isValidFile(file))
			return ResponseHandler.response(HttpStatus.BAD_REQUEST, false,  "Invalid file");
		
		String fileUrl = upload(file);
		FileMetaData fileMetaData = new FileMetaData( 
				file.getOriginalFilename(),fileUrl,FilenameUtils.getExtension(file.getOriginalFilename()),file.getContentType(),file.getSize()
				);
		fileMetaRepository.save(fileMetaData);
		Map<String, Object> fileData = new TreeMap<>();
		fileData.put("id", fileMetaData.getId());
		fileData.put("fileName", fileMetaData.getFileName());
		fileData.put("fileUrl", fileMetaData.getFileUrl());
		
		return ResponseHandler.response(HttpStatus.OK, true,  fileData);

	}
	
	private String upload(MultipartFile file){
		String newName = String.valueOf(System.currentTimeMillis());
		String extension = FilenameUtils.getExtension(file.getOriginalFilename());
		try {
			File myFile = new File(FILE_DIRECTORY + newName + "." + extension);
			myFile.createNewFile();
			FileOutputStream fout = new FileOutputStream(myFile);
			fout.write(file.getBytes());
			fout.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return FILE_DIRECTORY + newName + "." + extension;
	}
	

}
