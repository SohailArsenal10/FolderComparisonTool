/*package com.javafolderapp.folderComparisonToolV1.service;

import java.util.List;
import com.javafolderapp.folderComparisonToolV1.model.FileModel;

public interface FileService {
	List<FileModel> getAllFiles();
	void saveAllFilesList(List<FileModel> fileList);
}*/

package com.javafolderapp.folderComparisonToolV1.service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import com.javafolderapp.folderComparisonToolV1.helper.Helper;
import com.javafolderapp.folderComparisonToolV1.helper.ReadFile;


public class FileService {
	
	public FileService()
	{
		
	}
	
	ReadFile rf = new ReadFile();
	
	public Object[] f1f2(Object[] folder1_c1_arr, Object[] folder2_c1_arr)
	{
		/*FolderInput fi = new FolderInput();
		Object[] oobj = fi.folderinput();
		String outputfolder1 = (String)oobj[0];
		String outputfolder2 = (String)oobj[1];
		System.out.println("outputfolders are: "+ outputfolder1 + "\n"+ outputfolder2);
		        
        File folder1_c1_file = new File(outputfolder1);
        File folder2_c1_file = new File(outputfolder2);
        System.out.println("input files are: "+ folder1_c1_file + "\n"+ folder2_c1_file);*/
		String[] outarr1 = new String[folder1_c1_arr.length];
		Object[] obj1 = null;
        try
        {
        /*//Passing file names of each folder and getting those in the form of arrays
        Object[] obj = rf.returnArraysBasedOnOption(folder1_c1_file,folder2_c1_file);
        String[] folder1_c1_arr = (String[])obj[0];
        String[] folder2_c1_arr = (String[])obj[1];
        //i and j are the number of lines in folder1 and folder2 respectively
        int i = (int)obj[2];      
        int j = (int)obj[3];*/
        	
        
        //Getting output array after comparing 2 arrays having list of filenames(case1)
        obj1 = rf.returnOutputArrayBasedOnOption(folder1_c1_arr,folder2_c1_arr);        
        outarr1 = (String[])obj1[0];
        int outarr1_length = (int)obj1[1];
        
        System.out.println("Below is the Folder1 content");
        System.out.println();
        Arrays.stream(folder1_c1_arr).forEach(System.out::println);
        System.out.println();
        
        System.out.println("Below is the Folder2 content");
        System.out.println();
        Arrays.stream(folder2_c1_arr).forEach(System.out::println);
        System.out.println();
                
        if(outarr1_length == 0)
        {
        	System.out.println("All files in folder1 are present in folder2");
        	Arrays.stream(outarr1).filter(Objects::nonNull).forEach(System.out::println);
        }
        else
        {
        System.out.println("Extra files present in folder1 are");
        System.out.println();
        
        //Filtering out null values from the array returned
        Arrays.stream(outarr1).filter(Objects::nonNull).forEach(System.out::println);
        }        
        }
        catch(IOException ioe)
		{
		   //System.out.println(ioe);
		   ioe.printStackTrace();
		}
        return obj1;
	}
	
	public Object[] f2f1(Object[] folder2_c2_arr, Object[] folder1_c2_arr)
	{
		String[] outarr2 = new String[folder2_c2_arr.length];
		Object[] obj2 = null;
        try
        {
        /*//Passing file names of each folder and getting those in the form of arrays	
        Object[] obj = rf.returnArraysBasedOnOption(folder2_c2_file,folder1_c2_file);
        String[] folder2_c2_arr = (String[])obj[0];
        String[] folder1_c2_arr = (String[])obj[1];
        //i and j are the number of lines in folder1 and folder2 respectively
        int i = (int)obj[2];      
        int j = (int)obj[3];*/        
        
      //Getting output array after comparing 2 arrays having list of filenames(case2)
        obj2 = rf.returnOutputArrayBasedOnOption(folder2_c2_arr,folder1_c2_arr);        
        outarr2 = (String[])obj2[0];
        int outarr2_length = (int)obj2[1];
           
        System.out.println("Below is the Folder1 content");
        System.out.println();
        Arrays.stream(folder2_c2_arr).forEach(System.out::println);
        System.out.println();
        
        System.out.println("Below is the Folder2 content");
        System.out.println();
        Arrays.stream(folder1_c2_arr).forEach(System.out::println);
        System.out.println();
        
        
        if(outarr2_length == 0)
        {
        	System.out.println("All files in folder2 are present in folder1");
        	Arrays.stream(outarr2).filter(Objects::nonNull).forEach(System.out::println);
        }
        else
        {
        System.out.println("Missing files present in folder1 are");
        System.out.println();
        
      //Filtering out null values from the array returned
        Arrays.stream(outarr2).filter(Objects::nonNull).forEach(System.out::println);
        }              
        }
        catch(IOException ioe)
		{
		   //System.out.println(ioe);
		   ioe.printStackTrace();
		}
        return obj2;
	}
}



