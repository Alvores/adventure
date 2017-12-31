package com.bms.adventure.characters;

public abstract class CharacterClass {
	protected static int hpGain;	// 1dx hit point gain on level up
	protected static double fortitude;
	protected static double will;
	protected static double reflex;
	protected static double bab;		// Base attack bonus (attacks per round = 1+(bab-1)/5)
	protected static String weaponProficiency;	// What weapons can be utilized by class
	
	protected int getHpGain() {
		return hpGain;
	}

	protected void setHpGain(int hpGain) {
		this.hpGain = hpGain;
	}

	protected double getFortitude() {
		return fortitude;
	}

	protected void setFortitude(double fortitude) {
		this.fortitude = fortitude;
	}
	
	protected double getWill() {
		return will;
	}

	protected void setWill(double will) {
		this.will = will;
	}

	protected double getReflex() {
		return reflex;
	}

	protected void setReflex(double reflex) {
		this.reflex = reflex;
	}

	protected double getBab() {
		return bab;
	}

	protected void setBab(double bab) {
		this.bab = bab;
	}

	protected String getWeaponProficiency() {
		return weaponProficiency;
	}

	protected void setWeaponProficiency(String weaponProficiency) {
		this.weaponProficiency = weaponProficiency;
	}
	
	protected PlayerCharacter levelUp (PlayerCharacter pc) {
		pc.setHp(pc.getHp()+this.hpGain); /////////Try THIS out
		return pc;
	}
	
	public void levelUp(PlayerCharacter pc, String charClass) {
		switch (charClass) {
			case "Fighter":
				pc = Fighter.levelCharacter(pc);
				break;
			case "Rogue":
				pc = Rogue.levelCharacter(pc);
				break;
			case "Wizard":
				pc = Wizard.levelCharacter(pc);
				break;
		}
	}
}
