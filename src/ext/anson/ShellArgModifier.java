package ext.anson;

public class ShellArgModifier {
	public String removeSpaces(String str)
	{
		String newPath = "";
		int i = 0;
		while(i<str.length())
		{
			if(str.charAt(i) == ' ' || str.charAt(i) == '\t')
				i++;
			else
			{
				newPath = str.substring(i);
				return newPath;
				// i-th subscript.
				//      CSI\ 201
			}
		}
		return newPath;
	}
}
