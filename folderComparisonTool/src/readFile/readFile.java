package readFile;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.lang.Object;

public class readFile {

	public readFile()
	{
		
	}
	
	public void readLines(File f) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line;
		while((line = br.readLine()) != null)
		{
			System.out.println(line);
		}
		br.close();
	}
	
	
	 public int countLines(File f) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line;
		int lineCount = 0;
		while((line = br.readLine()) != null)
		{
			lineCount++;
		}
		br.close();
		return lineCount;
	}
	 
	 
	  public String[] readLinesIntoArray(File f, int lines1) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line;
		int i = 0;
		String[] arr1 = new String[lines1];
		while((line = br.readLine()) != null)
		{
			arr1[i] = line;
			i++;
		}
		br.close();
		//System.out.println(arr1);
		//Arrays.stream(arr1).forEach(System.out::println);
        return arr1;
	}
	  
	  public static Object[] returnArraysBasedOnOption(File f1, File f2) throws IOException
		{
		readFile rf = new readFile();
		try
		{
			int lines1 = rf.countLines(f1);			
			String[] arr1 = rf.readLinesIntoArray(f1,lines1);
                                             
            int lines2 = rf.countLines(f2);
            String[] arr2 = rf.readLinesIntoArray(f2,lines2);
            
    		return new Object[]{arr1, arr2, lines1, lines2};
            
             /*Object[] arrayObjects = new Object[2];
             arrayObjects [0] = arr1;
             arrayObjects [1] = arr2;
             return arrayObjects;*/
                        
		}
		catch(IOException ioe)
		{
		   //System.out.println(ioe);
		   ioe.printStackTrace();
		}
		return null;

		}
	  
	  public static String[] returnOutputArrayBasedOnOption(String[] arr1, String[] arr2,int i,int j) throws IOException
		{
		String outarr[] = new String[i];
      //To clear any null values in output
      Arrays.fill(outarr, "");
      int k = 0;
      
      for(i = 0; i < arr1.length; i++)
      {
      	boolean ignorevalue = false;
      	for(j = 0; j < arr2.length; j++)
      	{
      		if(arr1[i].equals(arr2[j]))
      		{
      			ignorevalue = true;
      			break;
      		}        		
      	}
      	if(!ignorevalue)
      	{
      	outarr[k] = arr1[i];
			k++;
      	}
      }
      return outarr;
		}
	  
	 
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an option for folder order");
		int option = sc.nextInt();
        switch(option){
        case 1: 
        File folder1_c1_file = new File("<filepath1>");
        File folder2_c1_file = new File("<filepath2>"); 
        try
        {
        Object[] obj = returnArraysBasedOnOption(folder1_c1_file,folder2_c1_file);
        String[] folder1_c1_arr = (String[])obj[0];
        String[] folder2_c1_arr = (String[])obj[1];
        //i and j are the number of lines in folder1 and folder2 respectively
        int i = (int)obj[2];      
        int j = (int)obj[3];
        String outarr1[] = new String[i];
        //To clear any null values in output
        Arrays.fill(outarr1, "");
        int k = 0;
        
        for(i = 0; i < folder1_c1_arr.length; i++)
        {
        	boolean ignorevalue = false;
        	for(j = 0; j < folder2_c1_arr.length; j++)
        	{
        		if(folder1_c1_arr[i].equals(folder2_c1_arr[j]))
        		{
        			ignorevalue = true;
        			break;
        		}        		
        	}
        	if(!ignorevalue)
        	{
        	outarr1[k] = folder1_c1_arr[i];
			k++;
        	}
        }
        
        System.out.println("Below is the File2 content");
        System.out.println();
        Arrays.stream(folder1_c1_arr).forEach(System.out::println);
        
        System.out.println("Below is the File1 content");
        System.out.println();
        Arrays.stream(folder2_c1_arr).forEach(System.out::println);
        
        
        System.out.println("Files which are present in folder1 but not in folder2 are");
        System.out.println();
        Arrays.stream(outarr1).forEach(System.out::println);
        /*System.out.println();
        System.out.println(outarr1.length);*/
         
        }
        catch(IOException ioe)
		{
		   //System.out.println(ioe);
		   ioe.printStackTrace();
		}
        break;
        
        case 2: 
        File folder2_c2_file = new File("<filepath1>");
        File folder1_c2_file = new File("<filepath2>"); 
        try
        {
        Object[] obj = returnArraysBasedOnOption(folder2_c2_file,folder1_c2_file);
        String[] folder2_c2_arr = (String[])obj[0];
        String[] folder1_c2_arr = (String[])obj[1];
        //i and j are the number of lines in folder1 and folder2 respectively
        int i = (int)obj[2];      
        int j = (int)obj[3];
        
        String[] outarr2 = returnOutputArrayBasedOnOption(folder2_c2_arr,folder1_c2_arr,i,j);
        System.out.println("Below is the File2 content");
        System.out.println();
        Arrays.stream(folder2_c2_arr).forEach(System.out::println);
        
        System.out.println("Below is the File1 content");
        System.out.println();
        Arrays.stream(folder1_c2_arr).forEach(System.out::println);
        
        System.out.println("Files which are present in folder2 but not in folder1 are");
        System.out.println();
        Arrays.stream(outarr2).forEach(System.out::println);
        /*System.out.println();
        System.out.println(outarr1.length);*/
        }
        catch(IOException ioe)
		{
		   //System.out.println(ioe);
		   ioe.printStackTrace();
		}
        break;
        case 3: 
        	int a[][] = new int[5][5];        	
        	IntStream stream = Arrays.stream(a).flatMapToInt(Arrays::stream);
        	System.out.println();
        	System.out.println(stream);
        	Arrays.stream(a).flatMapToInt(Arrays::stream).forEach(System.out::println);
        	break;        	        	
	}
        sc.close();
	}
}