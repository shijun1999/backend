//Auto Generated

package com.kootour.model;

import java.io.File;
import java.util.List;

public class UploadImageModel extends BaseModel {
	private File file;
	private String fileFileName;
	private List<String> uploadedFileName;
	private String coursePictureIdentiNo;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public List<String> getUploadedFileName() {
		return uploadedFileName;
	}

	public void setUploadedFileName(List<String> uploadedFileName) {
		this.uploadedFileName = uploadedFileName;
	}

	public String getCoursePictureIdentiNo() {
		return coursePictureIdentiNo;
	}

	public void setCoursePictureIdentiNo(String coursePictureIdentiNo) {
		this.coursePictureIdentiNo = coursePictureIdentiNo;
	}
}
