import java.io.*;
import java.util.*;
import java.util.Calendar;
import ext.anson.LinkedList;
public class Shell implements ListSegments{
	
	
	LinkedList dirList = new LinkedList();
	
	public Shell()
	{
		
	}
	@Override
	public void listDirectoryFiles()
	{
		
		Calendar cal = Calendar.getInstance();
		
		File folder = new File(this.dirList.buildPath());
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
		String args [] = dir.split("/");
		
		if(args[0].equals("~"))
		{
			int j = 1;
			StringBuilder dirName = new StringBuilder();
			dirName.append("C:\\Users\\" + System.getProperty("user.name"));
			while(j<args.length)
				dirName.append("\\" + args[j++]);
		
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
		}
		else if(args[0].equals("."))
		{
			listDirectoryFiles();
		}
			
	}
	
}

