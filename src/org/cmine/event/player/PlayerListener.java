package org.cmine.event.player;

import org.cmine.event.Listener;

import Bulby.players.Player;

public class PlayerListener extends PlayerEvent {

	public PlayerListener(Type type, Player who) {
		super(type, who);
	}

	/**
	 * When a Player Joins the game
	 * @param event
	 */
	public void onPlayerJoin(PlayerJoinEvent event) {}
	
	/**
	 * Fires when a Player picks up a Item
	 */
	public void onPlayerItemPickup(PlayerItempickupEvent event) {}
}
