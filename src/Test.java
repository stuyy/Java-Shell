import java.io.File;
import java.util.*;

public class Test {
	public static void main(String[] args)
	{	
		Scanner key = new Scanner(System.in);
		/*
		System.setProperty("user.dir", "C:\\Users\\Anson\\Desktop");
		System.out.println(System.getProperty("user.dir"));
		File file = new File(System.getProperty("user.dir"));
		
		if(file.exists())
		{
			File [] allFiles = file.listFiles();
			
			int i = 0;
			while(i<allFiles.length)
			{
				if(allFiles[i].isFile())
					System.out.println("File: " + allFiles[i].getName());
				else if(allFiles[i].isDirectory())
					System.out.println("Directory: " + allFiles[i].getName());
				i++;
			}
		}
		else
			System.out.println("File does not exist.");
		*/
		String command;
		boolean flag = true;
		while(flag)
		{
			command = key.nextLine();
			if(command.equals("q"))
				flag = false;
			else if(command.startsWith("cd"))
			{
				String [] arguments = command.split(" ");
				
				String prevDir = System.getProperty("user.dir");
				System.setProperty("user.dir", arguments[1]);
				System.setProperty("user.dir", "C://Users//Anson//Desktop");
				
				if(new File(System.getProperty("user.dir")).exists())
				{
					File [] files = new File(System.getProperty("user.dir")).listFiles();
					int i = 0;
					while(i<files.length)
						System.out.println(files[i++].getName());
				}
				if(new File(System.getProperty("user.dir")).exists())
					System.out.println("Exists");
				else
				{
					System.out.println("Directory not found");
					System.setProperty("user.dir", prevDir); // Set the directory back to the previous one.
				}
			}
			else if(command.equals("pwd"))
			{
				System.out.println(System.getProperty("user.dir"));
			}
		}
			
	}
}
