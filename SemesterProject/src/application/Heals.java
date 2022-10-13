package application;

public class Heals extends CharacterClass
{
	//variable declarations
	private int potionType, weaponAugmentType;
	
	//no-arg constructor
	Heals()
	{
		potionType = 0;
		weaponAugmentType = 0;
		getFlask();
	}
	
	//arg constructor
	Heals(int potionType, int weaponAugmentType, int flask)
	{
		this.potionType = potionType;
		this.weaponAugmentType = weaponAugmentType;
		setFlask(flask);
	}

	//getters and setters
	public int getPotionType() {
		return potionType;
	}

	public void setPotionType(int potionType) {
		this.potionType = potionType;
	}

	public int getWeaponAugmentType() {
		return weaponAugmentType;
	}

	public void setWeaponAugmentType(int weaponAugmentType) {
		this.weaponAugmentType = weaponAugmentType;
	}
	
}
