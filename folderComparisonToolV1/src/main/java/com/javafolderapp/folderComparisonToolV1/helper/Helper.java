/*package com.javafolderapp.folderComparisonToolV1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.javafolderapp.folderComparisonToolV1.model.FileModel;

// @Repository annotation is used to 
// indicate that the class provides the mechanism 
// for storage, retrieval, search,update and delete 
// operation on objects.
@Repository
public interface FileRepository extends JpaRepository<FileModel, Long> {

}*/

package com.javafolderapp.folderComparisonToolV1.helper;

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


