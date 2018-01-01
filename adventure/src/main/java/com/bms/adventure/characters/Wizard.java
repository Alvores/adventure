package com.bms.adventure.characters;

public class Wizard implements CharacterClass {
	
	private static final int hpGain = 6;	// 1dx hit point gain on level up
	private static final double fortitude = 1.0;
	private static final double will = 1.5;
	private static final double reflex = 1.0;
	private static final double bab = 0.5;		// Base attack bonus (attacks per round = 1+(bab-1)/5)
	private static final String weaponProficiency = "Wizard";	// What weapons can be utilized by class
	
	public int getHpGain() {
		return hpGain;
	}
	
	public double getFortitude() {
		return fortitude;
	}
	
	public double getWill() {
		return will;
	}

	public double getReflex() {
		return reflex;
	}

	public double getBab() {
		return bab;
	}

	public String getWeaponProficiency() {
		return weaponProficiency;
	}

	public static PlayerCharacter levelUp (PlayerCharacter pc) {
		pc.setFortitude(pc.getFortitude()+fortitude); /////////Try THIS out
		pc.setWill(pc.getWill()+will);
		pc.setReflex(pc.getReflex()+reflex);
		pc.setHp(pc.getHp()+hpGain);
		pc.setBab(pc.getBab()+bab);
		return pc;
	}

}
