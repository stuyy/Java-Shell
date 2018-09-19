import java.util.*;
import ext.anson.*;
public class Main {
	public static void main(String[] args)
	{
		Shell shell = new Shell();
		Scanner key = new Scanner(System.in);
		String commandInput;
		boolean running = true;
		while(running)
		{
			
			commandInput = key.nextLine().trim();
			
			if(commandInput.equals("q") || commandInput.equals("quit"))
				running = false;
			
			else if(commandInput.startsWith("ls"))
			{
				if(commandInput.equals("ls"))
				{
					shell.listDirectoryFiles();
				}
				else
				{
					String command = new String(commandInput.substring(0, 2));
					String path = new String(commandInput.substring(3));
					path = WordModifier.removeSpaces(path);
					shell.listDirectoryFiles(path);
				}
			}
			else if(commandInput.startsWith("cd"))
			{
				if(commandInput.equals("cd"))
				{
					
				}
				else 
				{
					String command = new String(commandInput.substring(0, 2));
					String dir = new String(commandInput.substring(3));
					System.setProperty("user.dir", dir);
					String newDir = System.getProperty("user.dir");
					shell.setDir(newDir);
				}
			}
			else if(commandInput.startsWith("pwd"))
			{
				System.out.println(shell.getCWD());
			}
		}
		
	}
	
}
