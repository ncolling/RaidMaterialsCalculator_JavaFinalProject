package application;

public abstract class CharacterClass 
{
	//variable declarations and initialization
	private int flask = 1;
	
	//no-arg constructor
	protected CharacterClass()
	{
		flask = 1;
	}
	
	//arg constructor
	protected CharacterClass(int flask)
	{
		this.flask = flask;
	}

	//getters and setters
	public int getFlask() 
	{
		return flask;
	}

	public void setFlask(int flask) 
	{
		this.flask = flask;
	}
	
	//abstract methods for children
	public abstract int getPotionType();
	public abstract int getWeaponAugmentType();
}
