

package Bulby;


import java.io.*;

import org.cmine.CMine;

import Bulby.net.SocketListener;
import Bulby.players.Player;
import Bulby.players.PlayerSave;
import Bulby.util.Misc;


public class Server {

    /**
     * The engine used to update almost everything, such as players, items, and NPCs.
     */
    public static Engine engine;

    /**
     * Listens for incoming connections and accepts them.
     */
    public static SocketListener socketListener;

    /**
     * Save character files.
     */
    private static PlayerSave playerSave;

    /**
     * This method is used to add a given username to the
     * loaded bannedusers array.
     *
     * @param username The username to add.
     */
    public static void banUser(String username) {
        for (int i = 0; i < bannedUsers.length; i++) {
            if (bannedUsers[i] == null) {
                bannedUsers[i] = username;
            }
        }
    }

    /**
     * Banned accounts list.
     */
    public static String[] bannedUsers = new String[1000];

    /**
     * Main method for running the server.
     * <p>While specifying port 0 will select a random open port, it is not suggested as
     * you will not be informed on what port was selected. If you pick a port already
     * in use, the server will shut down.
     * @param args The port to run the server on, or 0 for a random port.
     */
    public static void main(String[] args) {
        try {
        	//CMine Start
        	new Thread(new CMine(), "Main Thread").start();
        	//CMine End
        	//Listen to port
            socketListener = new SocketListener(43594);
        } catch (Exception e) {

            /*
             * If this happens then the specified port is most likely already in use.
             */
            e.printStackTrace();
            return;
        }
        loadBannedUsers();
        engine = new Engine();
        playerSave = new PlayerSave();
        socketListener.run();
    }

    public static void broadcastMessage(String text) {
    	for(Player pz : Engine.players) {
    		pz.frames.sendMessage(pz, text);
    	}
    }
    /**
     * Loads all banned users at startup.
     */
    private static void loadBannedUsers() {
        int index = 0;

        try {
            BufferedReader in = new BufferedReader(
                    new FileReader("./data/banned/bannedusers.dat"));
            String loggedUser = null;

            while ((loggedUser = in.readLine()) != null) {
                bannedUsers[index] = loggedUser;
                index++;
            }
        } catch (Exception e) {
            Misc.println("Error loading banned users list.");
        }
    }
}
