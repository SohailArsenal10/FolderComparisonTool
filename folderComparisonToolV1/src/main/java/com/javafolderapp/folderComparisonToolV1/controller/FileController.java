package com.javafolderapp.folderComparisonToolV1.controller;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.javafolderapp.folderComparisonToolV1.service.FileService;
//import com.javafolderapp.folderComparisonToolV1.model.FileModel;
//import com.javafolderapp.folderComparisonToolV1.service.FileServiceImplementation;

// @Controller annotation is used to 
// mark any java class as a controller class
@Controller
public class FileController {

	@Autowired
	//FileServiceImplementation fileServiceImplementation;

	// @GetMapping annotation for 
	// mapping HTTP GET requests onto
	// specific handler methods. */
	@GetMapping("/") 
	public String getData() {
		return "File";
	}

	// @PostMapping annotation maps HTTP POST 
	// requests onto specific handler methods
	@PostMapping("/") 
	public String uploadMultipartFile(@RequestParam("files1") MultipartFile[] files1, @RequestParam("files2") MultipartFile[] files2,@RequestParam("folder") String folder) {  //Model model
	try {
		// Declare empty list for collect the files data 
		// which will come from UI
		//List<FileModel> fileList = new ArrayList<FileModel>();
		List<String> fileList1 = new ArrayList<String>();
		List<String> fileList2 = new ArrayList<String>();
		FileService fs = new FileService();
		
		for (MultipartFile file : files1) {
			/*String fileContentType = file.getContentType();
			String sourceFileContent = new String(file.getBytes(), StandardCharsets.UTF_8);*/
			String fileName = file.getOriginalFilename();
			int i = fileName.indexOf("/");
			fileName = fileName.substring(i+1);
           //FileModel FileModel = new FileModel(fileName, sourceFileContent, fileContentType);
			
			// Adding file into fileList
			fileList1.add(fileName);
			System.out.println("Files1 is " + fileName);
			}
		for (MultipartFile file : files2) {
			/*String fileContentType = file.getContentType();
			String sourceFileContent = new String(file.getBytes(), StandardCharsets.UTF_8);*/
			String fileName = file.getOriginalFilename();
			int i = fileName.indexOf("/");
			fileName = fileName.substring(i+1);
           //FileModel FileModel = new FileModel(fileName, sourceFileContent, fileContentType);
			
			// Adding file into fileList
			fileList2.add(fileName);
			System.out.println("Files2 is " + fileName);
			}
		System.out.println("folder value is " + folder);

		switch(folder){
        case "folder1":
        {
        	fs.f1f2(fileList1.toArray(),fileList2.toArray());
            System.out.println();
        }break;
        case "folder2":
        {
        	fs.f2f1(fileList2.toArray(),fileList1.toArray());
            System.out.println();
        }break;
        	default:
        		break;        		
        }	        
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		// Send file list to View using modal class 
		// fileServiceImplementation.getAllFiles() used to 
		// fetch all file list from DB
		//model.addAttribute("allFiles", fileServiceImplementation.getAllFiles());
	
		//return "FileList";
		return "File";
	}
}
