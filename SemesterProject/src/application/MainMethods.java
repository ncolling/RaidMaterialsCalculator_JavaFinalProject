/**
 * Raid Materials Generator
 * Nicholas Colling
 * A program that takes input from the user for properties of their raid, including: raid size, raid nights, boss pulls,
 * and raid composition and prints a material list for making all necessary consumables for that week of raiding.
 */
package application;

public class MainMethods 
{
	public static void MainMethod(Integer[] getData)
	{
		
		//Calls the method for user input and returns specifications for raid
		Integer[] userInput = getData; 
		
		/**
		 * Creates all class objects to be used to gain personal consumables
		 * such as potion type and weapon augment type
		 */
			Heals heals = new Heals(0, 0, 1); 

			Dps caster = new Dps(1, 1, 1, 1); 
		
			Dps rangedAgi = new Dps(2, 1, 1, 1); 
			
			Dps meleeAgi = new Dps(2, 2, 2, 1);  
			
			Dps melee1HStr = new Dps(3, 3, 1, 1); 
			
			Dps melee2HStr = new Dps(3, 3, 2, 1);
			
			Tank strTank = new Tank(3, 3, 1, 1); 
			
			Tank agiTank = new Tank(2, 2, 2, 1);
		
		//Generates an array that stores the count of how many of each type of potion
		Integer[] potionCounts = potionCounts(userInput, heals.getPotionType(), caster.getPotionType(), rangedAgi.getPotionType(),
				meleeAgi.getPotionType(), melee1HStr.getPotionType(), melee2HStr.getPotionType(),
				strTank.getPotionType(), agiTank.getPotionType());
		
		//Generates an array that stores the count of how many of each type of weapon augment
		Integer[] weaponAugmentCounts = weaponAugmentCounts(userInput, heals.getWeaponAugmentType(), caster.getWeaponAugmentType(), 
				rangedAgi.getWeaponAugmentType(), meleeAgi.getWeaponAugmentType(), meleeAgi.getWeaponCount(), melee1HStr.getWeaponAugmentType(),
				melee2HStr.getWeaponAugmentType(), melee2HStr.getWeaponCount(), strTank.getWeaponAugmentType(), agiTank.getWeaponAugmentType(),
				agiTank.getWeaponCount());
		
		//Generates an array that combines all counts from previous arrays for material list
		Integer[] consumablesCounts = consumablesCounts(userInput, potionCounts, weaponAugmentCounts);
		
		//Generates an array that stores the counts of each material needed for consumables
		Integer[] materialList = materialList(consumablesCounts);
		
		//prints the required materials for the week of raid from user input
		toOutput(materialList);
	}	
	
	public static Integer[] houseKeeping()
	{
		Integer[] userInput = new Integer[11];
		
		
		
		return userInput;
	}
	
	public static Integer[] potionCounts(Integer[] userInput, int heals, int casters, int rangedAgis, int meleeAgis, int melee1HStrs,
			int melee2HStrs, int strTanks, int agiTanks)
	{
		//Variable declarations and initializations
		Integer[] potionCounts = new Integer[4];
		int heal = readPotion(heals);
		int caster = readPotion(casters);
		int rangedAgi = readPotion(rangedAgis);
		int meleeAgi = readPotion(meleeAgis);
		int agiTank = readPotion(agiTanks);
		int melee1HStr = readPotion(melee1HStrs);
		int melee2HStr = readPotion(melee2HStrs);
		int strTank = readPotion(strTanks);
		
		//Array assignment with the counts of each type of potion
		potionCounts[0] = userInput[2] * userInput[1] * heal * userInput[3]; //Mana Potion
		potionCounts[1] = userInput[2] * userInput[1] * caster * userInput[4]; //Intellect Potion
		potionCounts[2] = userInput[2] * userInput[1] * (rangedAgi * userInput[5] + meleeAgi * userInput[6] + agiTank * userInput[10]); //Agility Potion
		potionCounts[3] = userInput[2] * userInput[1] * (melee1HStr * userInput[7] + melee2HStr * userInput[8] + strTank * userInput[9]); //Strength Potion
		
		
		return potionCounts;
	}
	
	public static Integer[] weaponAugmentCounts(Integer[] userInput, int heals, int casters, int rangedAgis, int meleeAgis, int agiWeaponCount,
			int melee1HStrs, int melee2HStrs, int strWeaponCount, int strTanks, int agiTanks, int agiTankWeaponCount)
	{
		//Variable declarations and initializations
		Integer[] weaponAugmentCounts = new Integer[4];
		int heal = readWeapon(heals);
		int caster = readWeapon(casters);
		int rangedAgi = readWeapon(rangedAgis);
		int meleeAgi = readWeapon(meleeAgis);
		int melee1HStr = readWeapon(melee1HStrs);
		int melee2HStr = readWeapon(melee2HStrs);
		int strTank = readWeapon(strTanks);
		int agiTank = readWeapon(agiTanks);
		
		//Array assignment with the counts of each type of weapon augment
		weaponAugmentCounts[0] = 3 * userInput[1] * (heal * userInput[3]); //Embalmer's Oil
		weaponAugmentCounts[1] = 3 * userInput[1] * (caster * userInput[4] + rangedAgi * userInput[5]); //Shadowcore Oil
		weaponAugmentCounts[2] = 3 * userInput[1] * (meleeAgi * userInput[6] * agiWeaponCount + agiTank * userInput[10] * agiWeaponCount); //Sharpened Shadestone
		weaponAugmentCounts[3] = 3 * userInput[1] * (melee1HStr * userInput[7] + melee2HStr * userInput[8] * strWeaponCount + 
				strTank * userInput[9]); //Weighted Shadestone
		
		return weaponAugmentCounts;
	}
	
	//A method to take the potion type and say if it exists
	public static int readPotion(int potionType)
	{
		int potion = 0;
		if (potionType >= 0)
			potion = 1;
		
		return potion;
	}
	
	//A method to take the augment type and say if it exists
	public static int readWeapon(int augmentType)
	{
		int weaponAugmentType = 0;
		if (augmentType >= 0)
			weaponAugmentType = 1;
		
		return weaponAugmentType;
	}
	
	//Method for generating number of cauldrons needed
	public static int getCauldron(int raidSize, int raidNights)
	{
		int cauldronCount = 2;
		if (raidSize > 20)
			cauldronCount = 3;
		if (raidSize > 30)
			cauldronCount = 6;
		
		return cauldronCount * raidNights;
	}
	
	//Method for generating number of feasts needed
	public static int getFeasts(int pullCounts, int raidNights)
	{
		int feasts = pullCounts * raidNights;
		
		return feasts;
	}
	
	//Method to build the array for Consumables Counts
	public static Integer[] consumablesCounts(Integer[] userInput, Integer[] potionCounts, Integer[] weaponAugmentCounts)
	{
		//variable declarations and initializations
		Integer[] consumablesCounts = new Integer[10];
		consumablesCounts[0] = getCauldron(userInput[0], userInput[1]); // 0
		consumablesCounts[1] = getFeasts(userInput[2], userInput[1]); // 1
		
		//for loops assign consumablesCounts array from potionCounts and weaponAugmentCounts 
		for (int i = 2, j = 0; j < 4; i++, j++)
		{
			consumablesCounts[i] = potionCounts[j]; //2 - 5
		}
		
		for (int i = 6, j = 0; j < 4; i++, j++ ) // 6 - 9
		{
			consumablesCounts[i] = weaponAugmentCounts[j];
		}
		/**
		 * Consumables List Index:
		 * 0 - # of Cauldrons
		 * 1 - # of Feasts
		 * 2 - Mana Potion
		 * 3 - Intellect Potion
		 * 4 - Agility Potion
		 * 5 - Strength Potion
		 * 6 - Embalmer's Oil
		 * 7 - Shadowcore Oil
		 * 8 - Sharpened Shadestone
		 * 9 - Weighted Shadestone
		 */
		
		return consumablesCounts;
	}
	
	//Method to generate material list array
	public static Integer[] materialList(Integer[] consumablesCounts)
	{
		Integer[] materialList = new Integer[12];
		
		//array assignments
		materialList[0] = 2 * consumablesCounts[2] + 2 * consumablesCounts[6] + 2 * consumablesCounts[7]; //Deathblossom
		materialList[1] = 32 * consumablesCounts[0] + 5 * consumablesCounts[3]; //MarrowRoot
		materialList[2] = 32 * consumablesCounts[0] + 5 * consumablesCounts[4]; //Widowbloom
		materialList[3] = 32 * consumablesCounts[0] + 5 * consumablesCounts[5]; //RisingGlory
		materialList[4] = 32 * consumablesCounts[0]; //VigilsTorch
		materialList[5] = 24 * consumablesCounts[0]; //Nightshade
		materialList[6] = 2 * consumablesCounts[0]; //Shadestone
		materialList[7] = 1 * consumablesCounts[1] + 2 * consumablesCounts[8] + 1 * consumablesCounts[9]; //ShadedStone
		materialList[8] = 1 * consumablesCounts[1]; //EmptyKettle
		materialList[9] = 5 * consumablesCounts[1]; //RefreshingSpringWater
		materialList[10] = 50 * consumablesCounts[1]; //Protoflesh
		materialList[11] = 1 * consumablesCounts[9]; //LightlessSilk
		
		return materialList;
	}
	
	//method to display output of needed materials for weekly raid
	public static void toOutput(Integer[] materialList)
	{
		
		SemesterProjectGUI.tfDeathBlossom.setText(materialList[0].toString());
		SemesterProjectGUI.tfMarrowroot.setText(materialList[1].toString());
		SemesterProjectGUI.tfWidowbloom.setText(materialList[2].toString());
		SemesterProjectGUI.tfRisingGlory.setText(materialList[3].toString());
		SemesterProjectGUI.tfVigilsTorch.setText(materialList[4].toString());
		SemesterProjectGUI.tfNightshade.setText(materialList[5].toString());
		SemesterProjectGUI.tfShadestone.setText(materialList[6].toString());
		SemesterProjectGUI.tfShadedStone.setText(materialList[7].toString());
		SemesterProjectGUI.tfEmptyKettle.setText(materialList[8].toString());
		SemesterProjectGUI.tfSpringWater.setText(materialList[9].toString());
		SemesterProjectGUI.tfProtoFlesh.setText(materialList[10].toString());
		SemesterProjectGUI.tfLightlessSilk.setText(materialList[11].toString());
		
	}
}
