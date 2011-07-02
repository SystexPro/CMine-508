package org.cmine.event.player;

import Bulby.players.Player;

public class PlayerJoinEvent {

	public String joinMessage;
	
	public void setJoinMessage(Player p, String text) {
		p.frames.sendMessage(p, text);
	}
	
	public String getJoinMessage() {
		return joinMessage;
	}
}
