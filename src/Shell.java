import java.io.*;
import java.util.*;
import java.util.Calendar;
import ext.anson.LinkedList;
public class Shell implements ListSegments, ChangeDirectory {
	
	String currDir;
	private String currentWorkingDirectory;
	
	LinkedList dirList = new LinkedList();
	
	public Shell()
	{
		
	}
	@Override
	public void changeDirectory(String dirName)
	{
		if(dirName.startsWith("~"))
		{
			String [] args = dirName.split("/");
			System.out.println(args[0]);
			// We know we're going to start all the way from the beginning.
		}
		else
		{
			String [] args = dirName.split("/");
			for(int i = 0; i < args.length; i++)
				dirList.addNode(args[i]);
			
			File file = new File(dirList.getPath());
			System.out.println(file.getAbsolutePath());
			if(file.exists())
			{
				
			}
			
			else
			{
				System.out.println("Directory not found");
				String firstNodeAdded = new String(args[0]);
				dirList.currentDir(firstNodeAdded, true);
				// If directory is not found, we're going to delete every single node up to the first
				// argument in the array.
			}
		}
	}
	@Override
	public void listDirectoryFiles()
	{
		System.out.println(dirList.getPath());
		Calendar cal = Calendar.getInstance();
		
		File folder = new File(dirList.getPath());
		File [] files = folder.listFiles();
		for(int i = 0; i < files.length; i++)
		{
			cal.setTimeInMillis(files[i].lastModified());
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH) + 1;
			int day = cal.get(Calendar.DAY_OF_MONTH);
			int hour = cal.get(Calendar.HOUR_OF_DAY);
			int minute = cal.get(Calendar.MINUTE);
			int second = cal.get(Calendar.SECOND);
			//System.out.println(month + "/" + day + "/" + year + "\t " + hour + ":" + minute + ":" + second + "\t" + files[i].getName());
			String str = String.format("%02d/%02d/%02d\t%02d:%02d:%02d\t%s", month, day, year, hour, minute, second, files[i].getName());
			System.out.println(str);
		}
	}
	@Override
	public void listDirectoryFiles(String dir)
	{
		this.currDir = dirList.pathWithoutSlash();
		if(currDir.equals("C:")) 
			System.out.println("YEET");
		System.out.println("The current working directory is: " + currDir);
		String args [] = dir.split("/");
		
		if(args[0].equals("~"))
		{
			dirList.addNode("Users");
			dirList.addNode(System.getProperty("user.name"));
			
			int j = 1;
			while(j<args.length)
				dirList.addNode(args[j++]);
			
			String dirName = dirList.getPath();
			System.out.println(dirName);
			Calendar cal = Calendar.getInstance();
			
			
			File folder = new File(dirName.toString());
			File [] files = folder.listFiles();
			for(int i = 0; i < files.length; i++)
			{
				cal.setTimeInMillis(files[i].lastModified());
				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH) + 1;
				int day = cal.get(Calendar.DAY_OF_MONTH);
				int hour = cal.get(Calendar.HOUR_OF_DAY);
				int minute = cal.get(Calendar.MINUTE);
				int second = cal.get(Calendar.SECOND);
				//System.out.println(month + "/" + day + "/" + year + "\t " + hour + ":" + minute + ":" + second + "\t" + files[i].getName());
				String str = String.format("%02d/%02d/%02d\t%02d:%02d:%02d\t%s", month, day, year, hour, minute, second, files[i].getName());
				System.out.println(str);
			}
			
			dirList.currentDir(currDir, false);
		}
		else if(args[0].equals("."))
		{
			listDirectoryFiles();
		}
			
	}
	/**
	 * previousDir changes the directory back to the previous one after listDirectory.
	 * @param dir
	 */
	
	public void previousDir(String dir)
	{
		
	}
	
}

