package com.anilcodes.springbootblogjwtauthenticationRESTapi.fileupload;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tbl_file_meta_data")
public class FileMetaData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, updatable = false)
	private Long id;
	
	@Column(name = "file_name", nullable = false)
	private String fileName;
	
	@Column(name = "file_url", nullable = false)
	private String fileUrl;
	
	@Column(name = "mime_Type", nullable = false)
	private String mimeType;
	
	@Column(name = "extension", nullable = false)
	private String extension;
	
	@Column(name = "file_size", nullable = false)
	private Long fileSize;
	
	@Column(name = "created_date", nullable = false)
	@CreationTimestamp
	private LocalDateTime createdDate;

	@Column(name = "modified_date", nullable = false)
	@UpdateTimestamp
	private LocalDateTime modifiedDate;
	
	public FileMetaData() {
	}

	public FileMetaData(String fileName, String fileUrl, String mimeType, String extension, Long fileSize) {
		super();
		this.fileName = fileName;
		this.fileUrl = fileUrl;
		this.mimeType = mimeType;
		this.extension = extension;
		this.fileSize = fileSize;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Long getId() {
		return id;
	}
	
}
