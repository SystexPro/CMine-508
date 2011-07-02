/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bulby.clanchat;

import java.util.LinkedList;
import Bulby.players.Player;
import Bulby.util.Misc;

/**
 *
 * @author Gravediggah
 */
public class ClanChat {

    private LinkedList<Room> clanRooms = new LinkedList<Room>();

    public ClanChat() {
    }

    public void join(Player p, String name) {
        if (createRoom(p, name)) {
            for (Room r : clanRooms) {
                if (r.getName().equalsIgnoreCase(name)) {
                    r.join(p);
                }
            }
        }
    }

    public void joinPlayer(Player p, String name) {
        if (Misc.player(name) != null) {
            Player o = Misc.player(name);
            if (o.clanRoom.length() > 0) {
                for (Room r : clanRooms) {
                    if (r.getName().equalsIgnoreCase(o.clanRoom)) {
                        r.join(p);
                    }
                }
            }
        }
    }

    public void leave(Player p) {
        for (Room r : clanRooms) {
            if (r.getName().equalsIgnoreCase(p.clanRoom)) {
                r.leave(p);
                clear(p);
            }
        }
    }

    public void kick(Player p, String name) {
        for (Room r : clanRooms) {
            if (r.getName().equalsIgnoreCase(p.clanRoom)) {
                r.kick(p, name);
            }
        }
    }
    
    public void setRank(Player p, String name, int rank) {
        for (Room r : clanRooms) {
            if (r.getName().equalsIgnoreCase(p.clanRoom)) {
                r.setRank(p, name, rank);
            }
        }
    }

    public void sendMessage(Player p, String message) {
        for (Room r : clanRooms) {
            if (r.getName().equalsIgnoreCase(p.clanRoom)) {
                if (message.startsWith("kick ")) {
                    r.kick(p, message.replace("kick ", ""));
                } else if (message.startsWith("ban")) {
                    r.ban(p, message.replace("ban ", ""));
                } else if (message.startsWith("unban")) {
                    r.unban(p, message.replace("unban ", ""));
                } else {
                    r.sendMessage(p, message);
                }
            }
        }
    }

    public void logout(Player p) {
        if (p != null) {
            if (p.clanRoom.length() > 0) {
                for (Room r : clanRooms) {
                    if (r.getName().equalsIgnoreCase(p.clanRoom)) {
                        r.leave(p);
                        r.updateRoom();
                    }
                }
            }
        }
    }

    public boolean createRoom(Player p, String name) {
        for (Room r : clanRooms) {
            if (r.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        clanRooms.add(new Room(name, p.username));
        return false;
    }

    public void clear(Player p) {
        p.clanRoom = "";
        p.stream.createFrameVarSizeWord(82);
        p.stream.writeQWord(Misc.stringToLong("None")); // Chatroom owner
        p.stream.writeQWord(Misc.stringToLong("Not in chat")); //Chatroom name
        p.stream.writeByte(1);
        p.stream.writeByte(0);
        p.stream.endFrameVarSize();
    }
    
}