public class SkunkApp
{
	public SkunkUI skunkUI;
	public SkunkController skunkController;
	
	public SkunkApp()
	{
		skunkUI = new SkunkUI();
		skunkController = new SkunkController(skunkUI);
		skunkUI.setDomain(skunkController); 		
	}

	public boolean run()
	{
		return skunkController.run();	
	}
	
	public static void main(String[] args)
	{
		new SkunkApp().run();
	}
}
