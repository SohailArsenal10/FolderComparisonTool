package helperFunctions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Helper {
	
	public Helper()
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
}
