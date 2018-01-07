package com.bms.adventure;

import com.bms.adventure.characters.*;

public class Adventure {
	
	public static void main(String[] args) {
		System.out.println("Adventure Begins!\n");
		makePlayerCharacter(4);

	}
	
	// Generates a new player with name and attributes
	private static void makePlayerCharacter(int numChars) {
		String name;
		
		name = "Baldur";
		AllCharacters.addMember(new PlayerCharacter(name, "Fighter"));
//		AllCharacters.addMember(PlayerCharacter.makeNewPlayerCharacter(name, "Fighter"));
		name = "Anduril";
		AllCharacters.addMember(new PlayerCharacter(name, "Rogue"));
//		AllCharacters.addMember(PlayerCharacter.makeNewPlayerCharacter(name, "Rogue"));
		name = "Finnr";
		AllCharacters.addMember(new PlayerCharacter(name, "Wizard"));
//		AllCharacters.addMember(PlayerCharacter.makeNewPlayerCharacter(name, "Wizard"));	
		
		System.out.println(AllCharacters.listPlayers());
//		System.out.println(AllCharacters.playerInformation("Baldur"));
		
		// TODO make a PlayerCharacter with the 6 base ability scores (roll the dice), and the given name
		// print out the resulting Player Character. 
	}

}
