import edu.princeton.cs.introcs.*;

public class SkunkUI implements UI
{
	public SkunkController skunkController;

	public void setDomain(SkunkController skunkController)
	{
		this.skunkController = skunkController;
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