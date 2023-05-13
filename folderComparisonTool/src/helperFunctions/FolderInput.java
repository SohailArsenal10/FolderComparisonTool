package helperFunctions;

import java.io.*;
import java.util.*;

public class FolderInput {
	
	public FolderInput()
	{
		
	}

	public Object[] folderinput(){
	
	try {
	Scanner infolder1 = new Scanner(System.in);
	Scanner outfolder1 = new Scanner(System.in);
	Scanner infolder2 = new Scanner(System.in);
	Scanner outfolder2 = new Scanner(System.in);
	
	System.out.println("Enter an input folder1");
    String inputfolder1 = infolder1.nextLine();
    
    System.out.println("Enter an output folder1");
    String outputfolder1 = outfolder1.nextLine();
    
    System.out.println("Enter an input folder2");
    String inputfolder2 = infolder2.nextLine();
    
    System.out.println("Enter an output folder2");
    String outputfolder2 = outfolder2.nextLine();
    
	/*ProcessBuilder builder = new ProcessBuilder(
            "cmd.exe", "/c", "cd C:\\Program Files\\Java && dir /b /a-h-s > C:\\Users\\Sohail\\website\\test1.txt");*/
    ProcessBuilder builder1 = new ProcessBuilder(
            "cmd.exe", "/c", "cd "+inputfolder1+" && dir /b /a-h-s > "+outputfolder1);
        builder1.redirectErrorStream(true).start();
        
    ProcessBuilder builder2 = new ProcessBuilder(
            "cmd.exe", "/c", "cd "+inputfolder2+" && dir /b /a-h-s > "+outputfolder2);
        builder2.redirectErrorStream(true).start();    
        
        /*System.out.println("Input folder1 is" + inputfolder1);
        System.out.println("Output folder1 is" + outputfolder1);
        System.out.println("Input folder2 is" + inputfolder2);
        System.out.println("Output folder2 is" + outputfolder2);*/
      
      //infolder1.close();
      //outfolder1.close();
      //infolder2.close();
      //outfolder2.close();
      return new Object[]{outputfolder1,outputfolder2};
	}
	catch(IOException ioe)
	{
		//System.out.println(ioe);
		ioe.printStackTrace();
	}
	return null;
	} 
	}
