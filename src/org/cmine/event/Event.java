package org.cmine.event;

public class Event {

	private final Type type;
    private final String name;

    protected Event(final Type type) {
        this.type = type;
        this.name = null;
    }

   

	public enum Type {
		PLAYER_ATTACK,
		PLAYER_PICKUPITEM,
		PLAYER_DROPITEM,
		PLAYER_DEAD,
		PLAYER_MAGIC,
		PLAYER_CHAT,
		PLAYER_COMMAND,
		NPC_ATTACK,
		NPC_DEAD,
		NPC_DROPITEM;
	}
	
	
}
