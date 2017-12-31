package com.bms.adventure.characters;

public class Wizard extends CharacterClass{
	
	Wizard() {
		setBab(0.4);
		setHpGain(4);
		setFortitude(1.0);
		setWill(2.0);
		setReflex(1.0);
		setWeaponProficiency("Wizard");
	}

	protected static PlayerCharacter levelCharacter(PlayerCharacter pc) {
		return pc;
	}

}
