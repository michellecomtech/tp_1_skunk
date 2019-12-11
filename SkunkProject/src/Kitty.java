public class Kitty 
{
	private int kittyChip;
	
	public Kitty()
	{
		this.kittyChip = 0;
	}
	
	public Kitty(int chip)
	{
		this.kittyChip = chip;
	}

	public void addChipToKitty(int chip)
	{
		this.kittyChip = this.kittyChip + chip;
	}
	
	public void removeChipFromKitty(int chip)
	{
		this.kittyChip = this.kittyChip - chip;
	}
	
	public int getChipTotal()
	{
		return this.kittyChip;
	}
	
	public String toString()
	{
		return "" + getChipTotal();
	}
}

