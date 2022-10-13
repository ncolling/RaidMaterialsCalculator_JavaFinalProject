package application;

public class Dps extends CharacterClass
{
	//variable declarations
	private int potionType, weaponAugmentType, weaponCount;
	
	//no-arg constructor
	Dps()
	{
		potionType = 1;
		weaponAugmentType = 1;
		weaponCount = 0;
		getFlask();
	}
	
	//arg constructor
	Dps(int potionType, int weaponAugmentType, int weaponCount, int flask)
	{
		this.potionType = potionType;
		this.weaponAugmentType = weaponAugmentType;
		this.weaponCount = weaponCount;
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

	public int getWeaponCount() {
		return weaponCount;
	}

	public void setWeaponCount(int weaponCount) {
		this.weaponCount = weaponCount;
	}
	
	
}
