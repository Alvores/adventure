package com.bms.adventure.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.bms.adventure.equiptment.Armor;
import com.bms.adventure.equiptment.ArmorSpecifications;

/**
 * The ArmorRecordIO class reads and writes files with information
 * regarding a piece of armor.
 * @author Gabriel Zingle
 */
public class ArmorRecordIO {

	public static ArrayList<Armor> readArmorRecords(String file) throws FileNotFoundException {
		ArrayList<Armor> armors = new ArrayList<Armor>();
		try (Scanner fileReader = new Scanner(new FileInputStream(file))) {
			while (fileReader.hasNextLine()) {
				try {
					Armor armor = readArmor(fileReader.nextLine());
					armors.add(armor);
				} catch (IllegalArgumentException e) {
					e.getMessage(); // Check error, invalid armor
				}
			}
			return armors;
		}
	}

	private static Armor readArmor(String line) {
		String[] record = line.split(",");
		if (record.length != 10) {
			throw new IllegalArgumentException("Improper armor parameters.");
		}
		
		String name = record[0];
		int weight = Integer.parseInt(record[1]);
		int cost = Integer.parseInt(record[2]);
		int ac = Integer.parseInt(record[3]);
		int maxDexterityAC = Integer.parseInt(record[4]);
		int enhancementBonus = Integer.parseInt(record[5]);
		String description = record[6];
		
		ArmorSpecifications armorSpecifications = new ArmorSpecifications(name, ac, maxDexterityAC, weight, cost);
		Armor armor = new Armor(description, enhancementBonus, armorSpecifications);
		return armor;
	}

	// ArmorRecords
	public static void writeArmorRecords(String file, ArrayList<Armor> armors) throws IOException {
		try (PrintStream output = new PrintStream(new File(file))) {
			for (Armor w : armors) {
				output.print(w.toString());
			}
		}
	}

}
