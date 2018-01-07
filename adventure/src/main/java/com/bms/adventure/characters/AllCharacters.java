package com.bms.adventure.characters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import com.bms.adventure.storage.PlayerRecordIO;

public class AllCharacters {
	private static HashMap<String, PlayerCharacter> playerList = new HashMap<String, PlayerCharacter>();
	private static ArrayList<PlayerCharacter> players = new ArrayList<>();
	
	public static void addMember(PlayerCharacter pc) {
		playerList.put(pc.getName(), pc);
		players.add(pc); // Used for saving the characters to a file
	}
	
	public static String listPlayers() {
		Set<String> partyNames = playerList.keySet();
		String party = "";
		
		for (String pc: partyNames) {
			party += playerList.get(pc).styledToString() + "\n\n";
		}
		
		return party;
	}
	
	public static String playerInformation (String name) {
		return playerList.get(name).styledToString();
	}
	
	
	public static PlayerCharacter retrievePlayer(String name) {
		return playerList.get(name);
	}
	
	public static ArrayList<PlayerCharacter> getPlayersArray() {
		return players;
	}
}
