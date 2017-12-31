package com.bms.adventure.characters;

public class Fighter extends CharacterClass {

	Fighter() {
		setBab(1.0);
		setHpGain(10);
		setFortitude(2.0);
		setWill(1.0);
		setReflex(1.0);
		setWeaponProficiency("Fighter");
	}
	
	protected static PlayerCharacter levelCharacter(PlayerCharacter pc) {
		//pc.setHp(pc.getHp()+getHpGain()); Static refference issue
		return pc;
	}

}
