package com.bms.adventure.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.bms.adventure.characters.PlayerCharacter;

/**
 * The PlayerRecordIO class reads and writes files with information
 * regarding a player character.
 * @author Gabriel Zingle
 */
public class PlayerRecordIO {
	
	public static ArrayList<PlayerCharacter> readPlayerRecords(String file) throws FileNotFoundException {
		ArrayList<PlayerCharacter> players = new ArrayList<PlayerCharacter>();
		try (Scanner fileReader = new Scanner(new FileInputStream(file))) {
			while (fileReader.hasNextLine()) {
				try {
					PlayerCharacter player = readPlayer(fileReader.nextLine());
					players.add(player);
				} catch (IllegalArgumentException e) {
					e.getMessage(); // Check error, invalid player
				}
			}
			return players;
		}
	}

	private static PlayerCharacter readPlayer(String line) {
		String[] record = line.split(",");
		if (record.length != 10) {
			throw new IllegalArgumentException("Improper player parameters.");
		}
//		name + "," + charClass + "," + hp + "," + currentHp + "," + getAc()  + "," + level
//		+ "," + xp + "," + strength + "," + intellect + "," + wisdom + "," + dexterity
//		+ "," + charisma + "," + constitution + "," + bab + "," + fortitude
//		+ "," + will  + "," + reflex + "," + faction;
		String name = record[0];
		String charClass = record[1];
		int hp = Integer.parseInt(record[2]);
		int currentHp = Integer.parseInt(record[3]);
		int acBonus = Integer.parseInt(record[4]);
		int level = Integer.parseInt(record[5]);
		int xp = Integer.parseInt(record[6]);
		int strength = Integer.parseInt(record[7]);
		int intellect = Integer.parseInt(record[8]);
		int wisdom = Integer.parseInt(record[9]);
		int dexterity = Integer.parseInt(record[10]);
		int charisma = Integer.parseInt(record[11]);
		int constitution = Integer.parseInt(record[12]);
		int bab = Integer.parseInt(record[13]);
		double fortitude = Double.parseDouble(record[14]);
		double will = Double.parseDouble(record[15]);
		double reflex = Double.parseDouble(record[16]);
		String faction = record[17];
		return null;
		
//		String name = record[0];
//		int weight = Integer.parseInt(record[1]);
//		int cost = Integer.parseInt(record[2]);
//		int ac = Integer.parseInt(record[3]);
//		int maxDexterityAC = Integer.parseInt(record[4]);
//		int enhancementBonus = Integer.parseInt(record[5]);
//		String description = record[6];
//		
//		ArmorSpecifications armorSpecifications = new ArmorSpecifications(name, ac, maxDexterityAC, weight, cost);
//		Armor armor = new Armor(description, enhancementBonus, armorSpecifications);
//		return armor;
	}

	// PlayerRecords
	public static void writePlayerRecords(String file, ArrayList<PlayerCharacter> players) throws IOException {
		try (PrintStream output = new PrintStream(new File(file))) {
			for (PlayerCharacter p : players) {
				output.print(p.toString());
			}
		}
	}

}
