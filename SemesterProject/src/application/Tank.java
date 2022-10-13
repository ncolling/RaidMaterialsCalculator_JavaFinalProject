package application;

public class Tank extends CharacterClass
{
	//variable declarations
	private int potionType, weaponAugmentType, weaponCount;
	
	//no-arg constructor
	Tank()
	{
		potionType = 0;
		weaponAugmentType = 0;
		weaponCount = 0;
		getFlask();
	}
	
	//arg constructor
	Tank(int potionType, int weaponAugmentType, int weaponCount, int flask)
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
