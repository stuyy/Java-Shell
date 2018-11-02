package node.shell;

import java.io.IOException;

public class NodeTest {
	public static void main(String[] args) throws IOException
	{
		
		ProcessBuilder pb = new ProcessBuilder("node", "C:\\Users\\Anson\\Documents\\Projects\\TutorialBot\\bot.js");
		pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
		pb.redirectError(ProcessBuilder.Redirect.INHERIT);
		Process p = pb.start();
	}
}
