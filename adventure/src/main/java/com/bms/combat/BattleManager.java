package com.bms.combat;

import java.util.ArrayList;

import com.bms.adventure.characters.PlayerCharacter;

/**
 * Handles turn based combat among players and adversaries.
 * @author Gabriel Zingle
 */
public class BattleManager {
	
	private ArrayList<PlayerCharacter> characters;
	private PlayerCharacter player;
	
	public BattleManager (ArrayList<PlayerCharacter> characters, PlayerCharacter player) {
		this.characters = characters;
		this.player = player;
	}
	
	public void battle() {
		boolean enemiesDefeated = false;
		while (player.getHp() > 0 && !enemiesDefeated) {
			
		}
	}

}
