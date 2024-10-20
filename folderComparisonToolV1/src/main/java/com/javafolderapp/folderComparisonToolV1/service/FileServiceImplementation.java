package com.javafolderapp.folderComparisonToolV1.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javafolderapp.folderComparisonToolV1.model.FileModel;
import com.javafolderapp.folderComparisonToolV1.repository.FileRepository;

// @Service annotation is used with classes
// that provide some business functionalities
@Service
public class FileServiceImplementation implements FileService {

	// @Autowired annotation used to inject 
	// the object dependency of FileRepository
	@Autowired
	FileRepository fileRepository;

	@Override
	public List<FileModel> getAllFiles() {
		// fetch all the files form database
		return fileRepository.findAll();
	}
	public void saveAllFilesList(List<FileModel> fileList) {
		// Save all the files into database
		for (FileModel fileModal : fileList)
			fileRepository.save(fileModal);
	}
}

