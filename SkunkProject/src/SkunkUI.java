import edu.princeton.cs.introcs.*;
//import java.util.Scanner;

public class SkunkUI implements UI
{
	public SkunkDomain skunkDomain;

	public void setDomain(SkunkDomain skunkDomain)
	{
		this.skunkDomain = skunkDomain;
	}

	public String promptReadAndReturn(String question)
	{
		StdOut.print(question + " => ");
		String result = StdIn.readLine();
		return result;
	}

	public static void main(String[] args)
	{
		
	}

	public void print(String toPrint)
	{
		StdOut.print(toPrint);	
	}

	public void println(String toPrint)
	{
		StdOut.println(toPrint);
	}
}