import java.io.File;

public class Test {
	public static void main(String[] args)
	{
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
			
	}
}
