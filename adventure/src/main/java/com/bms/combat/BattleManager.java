package com.bms.combat;

import com.bms.adventure.characters.PlayerCharacter;
import com.bms.adventure.utils.Dice;

/**
 * Handles turn based combat among players and adversaries.
 * @author Gabriel Zingle
 */
public class BattleManager {
	
	private PlayerCharacter player;
	private PlayerCharacter opponent; // Can change into ArrayList for multiple combatants
	
	public BattleManager (PlayerCharacter player, PlayerCharacter opponent) {
		this.player = player;
		this.opponent = opponent;
	}
	
	public void battle() {
		int round = 0;
		boolean fighting = false;
		int playerInitiative;
		int opponentInitiative;
		
		while (fighting) {
			playerInitiative = Dice.rollDice(1, 20, (player.getDexterity() - 10) / 2);
			opponentInitiative = Dice.rollDice(1, 20, (player.getDexterity() - 10) / 2);
			fighting  = turn();
			if (player.getHp() <= 0 || opponent.getHp() <= 0) {
				fighting = true;
				break;
			}
			round++; // End round
		}
	}
	
	public boolean turn() {
		if (player.getHp() <= 0 || opponent.getHp() <= 0) {
			return false;
		}
		return true;
	}

}
