package com.javafolderapp.folderComparisonToolV1.service;

import java.util.List;
import com.javafolderapp.folderComparisonToolV1.model.FileModel;

public interface FileService {
	List<FileModel> getAllFiles();
	void saveAllFilesList(List<FileModel> fileList);
}
