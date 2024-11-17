package com.javafolderapp.folderComparisonToolV1.helper;

import java.io.File;
import java.io.IOException;
//import java.util.Arrays;
import java.lang.Object;

public class ReadFile {

	public ReadFile()
	{
		
	}
	
	Helper hr = new Helper();
	
	  
	  public Object[] returnArraysBasedOnOption(File f1, File f2) throws IOException
		{
		try
		{
			int lines1 = hr.countLines(f1);			
			String[] arr1 = hr.readLinesIntoArray(f1,lines1);
                                             
            int lines2 = hr.countLines(f2);
            String[] arr2 = hr.readLinesIntoArray(f2,lines2);
            
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
	  
	  public Object[] returnOutputArrayBasedOnOption(Object[] arr1, Object[] arr2) throws IOException
	{
		String outarr[] = new String[arr1.length];
      //To clear any null values in output
      //Arrays.fill(outarr, "");
      int k = 0,i,j;
      
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
      	outarr[k] = (String) arr1[i];
			k++;
      	}
      }
      return new Object[]{outarr,k};
	}
	  
}
