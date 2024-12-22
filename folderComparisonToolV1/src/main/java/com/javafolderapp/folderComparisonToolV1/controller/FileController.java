package com.javafolderapp.folderComparisonToolV1.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javafolderapp.folderComparisonToolV1.service.FileService;
//import com.javafolderapp.folderComparisonToolV1.service.GoogleSheetsLive;
//import com.javafolderapp.folderComparisonToolV1.model.FileModel;
//import com.javafolderapp.folderComparisonToolV1.service.FileServiceImplementation;

// @Controller annotation is used to 
// mark any java class as a controller class
@Controller
public class FileController {

	//@Autowired
	//FileServiceImplementation fileServiceImplementation;
	/*@Autowired
	GoogleSheetsLive gsl;*/

	// @GetMapping annotation for 
	// mapping HTTP GET requests onto
	// specific handler methods. */
	
	  @GetMapping("/")
	  public String homepage() {
	    return "redirect:/UploadFiles";
	  }
	
	@GetMapping("/error")
	  public String errorpage() {
	    return "error";
	  }
	
	@GetMapping("/UploadFiles") 
	public String UploadFiles() {
		return "UploadFiles";
	}
	
	@GetMapping("/UploadFolders") 
	public String UploadFolders() {
		return "UploadFolders";
	}
	
	@GetMapping("/contact") 
	public String contactpage() {
		return "contact";
	}
	
	@GetMapping("/contact1") 
	public String contactpage1() {
		return "contact1";
	}

	// @PostMapping annotation maps HTTP POST 
	// requests onto specific handler methods
	@PostMapping("/files/result") 
	public String uploadMultipartFile(@RequestParam("files1") MultipartFile[] files1, @RequestParam("files2") MultipartFile[] files2, Model model) {
	
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
		//System.out.println("folder value is " + folder);

		/*switch(folder){
        case "folder1extra":
        {
        	fs.f1f2(fileList1.toArray(),fileList2.toArray());
            System.out.println();
        }break;
        case "folder1missing":
        {
        	fs.f2f1(fileList2.toArray(),fileList1.toArray());
            System.out.println();
        }break;
        	default:
        		break;        		
        }*/	
		
		Object[] obj1 = fs.f1f2(fileList1.toArray(),fileList2.toArray());
		String[] outarr1 = (String[])obj1[0];
        int outarr1_length = (int)obj1[1];
        System.out.println();
        
        Object[] obj2 = fs.f2f1(fileList2.toArray(),fileList1.toArray());
        String[] outarr2 = (String[])obj2[0];
        int outarr2_length = (int)obj2[1];
        System.out.println();
        
        model.addAttribute("filesarr1", outarr1);
        model.addAttribute("filesarr2", outarr2);
        model.addAttribute("filesarr1length", outarr1_length);
        model.addAttribute("filesarr2length", outarr2_length);
        System.out.println("outarr1_length= " + outarr1_length);
        System.out.println("outarr2_length= " + outarr2_length);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		// Send file list to View using modal class 
		// fileServiceImplementation.getAllFiles() used to 
		// fetch all file list from DB
		//model.addAttribute("allFiles", fileServiceImplementation.getAllFiles());
	
		return "FileList";
	}
	
	/*@PostMapping("/review") 
	public String contactreview()
	{
		try {
			System.out.println("contactreview called");
		gsl.setup();
		gsl.whenWriteSheet_thenReadSheetOk();
		}
		catch(Exception e)
		{
		  e.printStackTrace();
		}
		finally
		{
			
		}
		return "contact";
	}*/
}
