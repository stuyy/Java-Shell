import java.util.*;
public class Main {
	public static void main(String[] args)
	{
		Shell shell = new Shell();
		Scanner key = new Scanner(System.in);
		String commandInput;
		boolean running = true;
		while(running)
		{
			commandInput = key.nextLine();
			if(commandInput.equals("q") || commandInput.equals("quit"))
				running = false;
			
			else if(commandInput.startsWith("ls"))
			{
				String command = new String(commandInput.substring(0, 3));
				String path = new String(commandInput.substring(3));
				System.out.println(command);
				System.out.println(path);
			}
			
		}
		
	}
	public static void removeSpaces(String str)
	{
		
	}
}
