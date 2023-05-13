package mainClass;


import java.util.Scanner;
import caseMethods.CaseMethods;
//import helperFunctions.FolderInput;
//import java.util.stream.IntStream;

public class MainClass {

	public static void main(String[] args) 
	{
		/*FolderInput fi = new FolderInput();
		Object[] obj = fi.folderinput();
		String outputfolder1 = (String)obj[0];
		String outputfolder2 = (String)obj[1];
		System.out.println("outputfolders are: "+ outputfolder1 + "\n"+ outputfolder2);*/
		try {
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		CaseMethods cm = new CaseMethods();
		System.out.println("Enter an option for folder order");
		//System.out.println("Before 2nd scanner call "+System.in.available());
		int option = sc.nextInt();
		
        switch(option){
        case 1: 
        	String[] outarr1 = cm.f1f2();
            System.out.println();
        	System.out.println("To continue checking in terms of folder2, press Y else any other key");
        	//System.out.println("After 2nd scanner call "+System.in.available());
        	String option1 = sc1.next();
        	
        	switch(option1) 
        	{
        	case "y":
        	case "Y":
        		String[] outarr2 = cm.f2f1();
        		sc1.close();
        		break;
        	default:
        		break;
        		
        	}
        break;	        
        case 2:
        	String[] outarr3 = cm.f2f1();
        	System.out.println();
        	System.out.println("To continue checking in terms of folder1, press Y else any other key");
        	String option2 = sc2.next();
        	switch(option2) 
        	{
        	case "y":
        	case "Y":
        		String[] outarr4= cm.f1f2();
        		sc2.close();
        		break;
        	default:
        		break;
        		
        	}        
        break;
        /*case 3: 
        	int a[][] = new int[5][5];        	
        	IntStream stream = Arrays.stream(a).flatMapToInt(Arrays::stream);
        	System.out.println();
        	System.out.println(stream);
        	Arrays.stream(a).flatMapToInt(Arrays::stream).forEach(System.out::println);
        	break;  */      	        	
	}
        sc.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}


