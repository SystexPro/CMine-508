/*
 * Class Tester
 *
 * Version 0.1B
 *
 * 01:52 27/09/2008
 *
 * Created by T X
 */

package palidino76.rs2.Quests;


import java.io.*;
import palidino76.rs2.net.SocketListener;
import palidino76.rs2.players.PlayerSave;
import palidino76.rs2.util.Misc;
import palidino76.rs2.Quests.*;
import palidino76.rs2.Server;
import palidino76.rs2.Engine;
import palidino76.rs2.players.Player;
import palidino76.rs2.util.Misc;
import palidino76.rs2.io.*;


public abstract class Tester extends Quests {

public Tester(Player owner, Integer uid) {
		super(owner, UID);
}
    	protected String name = "";

    	protected int uid = 1;

    	protected int stage = -1;

    	protected int finalStage = 50;

	/**
	 * This is an abstract Method, and as such
	 * must be overwritten by every subclass of 
	 * Quest. It defines the unique features of
	 * each quest - its name, its 'completion stage',
	 * any items, npcs, objects that are associated
	 * with it.
	 */
	public void define()
	{
		setName("Tester"); // Sets the name of this quest.
		setFinalStage(100); // The stage at which this quest ends.
	}

	/**
	 * Also an abstract Method that must be overwritten.
	 * This is called when the getFinalStage() is met.
	 */
	public void completeQuest(Player p)
	{
                Engine.playerItems.addItem(p, 995, 500); // gives 500 coins on complete
		
		sleep(2500); // waits 2500 mil secounds
		
		p.frames.sendMessage(p, "You have completed " + getName() + "!"); // send message
		p.frames.sendMessage(p, "@gre@You just gained 1 quest point!"); // send message
		}
	}