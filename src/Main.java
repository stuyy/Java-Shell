import java.util.*;
import ext.anson.*;
public class Main {
	public static void main(String[] args)
	{
		Shell shell = new Shell();
		Scanner key = new Scanner(System.in);
		ShellArgModifier modify = new ShellArgModifier();
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
					if(shell.dirList.isEmpty())
					{
						String command = new String(commandInput.substring(0, 2));
						String path = new String(commandInput.substring(3));
						path = modify.removeSpaces(path);
						shell.listDirectoryFiles(path);
					}
					else
					{
						shell.dirList.destroyList();
						String command = new String(commandInput.substring(0, 2));
						String path = new String(commandInput.substring(3));
						path = modify.removeSpaces(path);
						shell.listDirectoryFiles(path);
					}
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
					// Changing the directory isn't possible, so we will just change the "path"
					System.out.println("The directory we're trying to change to is: " + dir);
					shell.changeDirectory(dir);
				}
			}
			else if(commandInput.startsWith("pwd"))
			{
				System.out.println(shell.dirList.getPath());
			}
		}
	}
}
