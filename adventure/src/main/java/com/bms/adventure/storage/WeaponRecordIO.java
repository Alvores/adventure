package com.bms.adventure.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.bms.adventure.equiptment.Weapon;
import com.bms.adventure.equiptment.WeaponSpecifications;

/**
 * The WeaponRecordIO class reads and writes files with information
 * regarding a weapon.
 * @author Gabriel Zingle
 */
public class WeaponRecordIO {
	
	public static ArrayList<Weapon> readWeaponRecords(String file) throws FileNotFoundException {
		ArrayList<Weapon> weapons = new ArrayList<Weapon>();
		try (Scanner fileReader = new Scanner(new FileInputStream(file))) {
			while (fileReader.hasNextLine()) {
				try {
					Weapon weapon = readWeapon(fileReader.nextLine());
					weapons.add(weapon);
				} catch (IllegalArgumentException e) {
					e.getMessage(); // Check error, invalid weapon
				}
			}
			return weapons;
		}

	}
	
	
	private static Weapon readWeapon(String line) {
		String[] record = line.split(",");
		if (record.length != 10) {
			throw new IllegalArgumentException("Improper weapon parameters.");
		}
		String name = record[0];
		int weight = Integer.parseInt(record[1]);
		int cost = Integer.parseInt(record[2]);
		int ndice = Integer.parseInt(record[3]);
		int nsides = Integer.parseInt(record[4]);
		int critThreshold = Integer.parseInt(record[5]);
		int critMultiplier = Integer.parseInt(record[6]);
		int attackRange = Integer.parseInt(record[7]);
		int enhancementBonus = Integer.parseInt(record[8]);
		String description = record[9];
		
		WeaponSpecifications weaponSpecifications = new WeaponSpecifications(name, ndice, nsides,
				critThreshold, critMultiplier, attackRange, weight, cost);
		Weapon weapon = new Weapon(description, enhancementBonus, weaponSpecifications);
		return weapon;
	}
	
	public static void writeWeaponRecords(String file, ArrayList<Weapon> weapons) throws 	IOException {
		try (PrintStream output = new PrintStream(new File(file))) {
			for (Weapon w: weapons) {
				output.print(w.toString());
			}
		}
	}

}
