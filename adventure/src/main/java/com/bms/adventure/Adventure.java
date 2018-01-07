package com.bms.adventure;

import java.io.IOException;
import java.util.ArrayList;

import com.bms.adventure.characters.*;
import com.bms.adventure.combat.BattleManager;
import com.bms.adventure.storage.PlayerRecordIO;

public class Adventure {
	
	private static final String resourceFile = "Resources/player_records.txt";
	private ArrayList<PlayerCharacter> players = new ArrayList<>();
	
	public static void main(String[] args) {
		System.out.println("Adventure Begins!\n");
		makePlayerCharacter();
		BattleManager bm = new BattleManager(AllCharacters.retrievePlayer("Baldur"),
				AllCharacters.retrievePlayer("Anduril"));
		saveCharacters();
		
	}
	
	// Generates a new player with name and attributes
	private static void makePlayerCharacter() {
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
	
	private static void saveCharacters() {
		try {
			PlayerRecordIO.writePlayerRecords(resourceFile, AllCharacters.getPlayersArray());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
