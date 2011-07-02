package Bulby.npcs.update;

import Bulby.players.Player;

public class Followers {
	Player p;

	/**
	 * Class constructor.
	 * @param p the player which the constructor should be made for.
	 */
	public Followers(Player p) {
		this.p = p;
	}

	/**
	 * Holds values to get pet type which is gonna be summoned
	 * @param droppedId the item which is dropped to summon the pet.
	 */
	public int getSummonNpc(int droppedId) {
		switch (droppedId) {

		case 7581: return 3503;

		default:
			return 0;
		}
	}

	/**
	 * Sets if player has a follower (pet) or not.
	 * @param summonedPet the pet summoned variable.
	 */
	public void setSummonedNpc(boolean summonedPet) {
		p.summonedPet = summonedPet;
	}

}