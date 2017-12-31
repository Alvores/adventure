package com.bms.adventure.characters;

public class Rogue extends CharacterClass{
	
	Rogue() {
		setBab(0.7);
		setHpGain(6);
		setFortitude(1.0);
		setWill(1.0);
		setReflex(2.0);
		setWeaponProficiency("Rogue");
	}

	protected static PlayerCharacter levelCharacter(PlayerCharacter pc) {
		return pc;
	}

}
