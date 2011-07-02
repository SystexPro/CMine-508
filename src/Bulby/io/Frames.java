
package Bulby.io;


import Bulby.players.Player;
import Bulby.npcs.NPC;
import Bulby.Engine;
import Bulby.util.Misc;


public class Frames {




	public static int random(int range) { //0 till range (range INCLUDED)
		return (int)(java.lang.Math.random() * (range+1));
	}
/**
     * Sets item options allowed
     * @param p The Player which the frame should be created for.
     * @param set The access mask
     * @param window The window or child interface id
     * @param inter The main interface id
     * @param off The item offset to start with
     * @param len The item count to set
     */
    public void setAccessMask(Player p, int set, int window, int inter, int off, int len) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrame(223);
        p.stream.writeWord(len);
        p.stream.writeWordBigEndianA(off);
        p.stream.writeWordBigEndian(window);
        p.stream.writeWordBigEndian(inter);
        p.stream.writeWordBigEndian(set);
        p.stream.writeWordBigEndian(0);
    }

/**
	 * Creates a GFX on an absolute X and Y
	 * @param p The player for which the frame should be created for.
	 * @param x The X coordinate that the GFX should be created on.
	 * @param y The Y coordinate that the GFX should be created on.
	 * @param gfx The GFX ID that should be shown.
	 * Made by Lumby http://**************
	 */
	public void gfx(Player p, int x, int y, int gfx){
		if(p == null || p.stream == null || p.disconnected[0]){
			return;
		}
		sendCoords(p, (x - ((p.mapRegionX - 6) * 8)), (y - ((p.mapRegionY - 6) * 8)));
		p.stream.createFrame(248);
		p.stream.writeByte(0);
		p.stream.writeWord(gfx);
		p.stream.writeByte(0);
		p.stream.writeWord(0);
	}

    /**
     * Runs an ClientScript2 script
     * @param p The Player which the frame should be created for.
     * @param id The script id
     * @param o The script arguments
     * @param valstring The argument types
     */
    public void runScript(Player p, int id, Object[] o, String valstring) {
        if (valstring.length() != o.length) {
            throw new IllegalArgumentException("Argument array size mismatch");
        }
        p.stream.createFrameVarSizeWord(152);
        p.stream.writeString(valstring);
        int j = 0;
        for (int i = (valstring.length() - 1); i >= 0; i--) {
            if (valstring.charAt(i) == 115) {
                p.stream.writeString((String) o[j]);
            } else {
                p.stream.writeDWord((Integer) o[j]);
            }
            j++;
        }
        p.stream.writeDWord(id);
        p.stream.endFrameVarSize();
    }
/**
     * Connects to the friend and ignore servers
     * @param p The player which the frame should be created for.
     */
	 public void yell(String s) {
		for (Player p5 : Engine.players) {
			if(p5 == null)
				continue;
			if(!p5.online)
				continue;
			sendMessage(p5,s);
		}
	}


public void createGlobalObject(Player p, int objectId, int height, int objectX, int objectY, int face, int type) {
sendCoords(p, (objectX - ((p.mapRegionX - 6) * 8)), (objectY - ((p.mapRegionY - 6) * 8)));
int ot = ((type << 2) + (face & 3));
p.stream.createFrame(30);
p.stream.writeWordBigEndian(objectId);
p.stream.writeByteA(0);
p.stream.writeByteC(ot);

}


public void createGlobalObject(int objectId, int height, int objectX, int objectY, int face, int type) {
for (Player p : Engine.players) {
if (p == null) {
continue;
}
createGlobalObject(p, 10517, 0, 2347, 3878, 0, 10);
createGlobalObject(p, 10517, 0, 2348, 3878, 0, 10);
createGlobalObject(p, 10517, 0, 2349, 3878, 0, 10);
createGlobalObject(p, 10517, 0, 2350, 3878, 0, 10);
createGlobalObject(p, 10517, 0, 2339, 3864, 1, 10);
createGlobalObject(p, 10517, 0, 2339, 3863, 1, 10);
createGlobalObject(p, 10517, 0, 2339, 3862, 1, 10);
createGlobalObject(p, 10517, 0, 2339, 3861, 1, 10);
createGlobalObject(p, 10517, 0, 2339, 3860, 1, 10);
createGlobalObject(p, 10517, 0, 2339, 3859, 1, 10);
createGlobalObject(p, 10517, 0, 2339, 3858, 1, 10);
createGlobalObject(p, 10517, 0, 2339, 3857, 1, 10);
createGlobalObject(p, 10517, 0, 2339, 3856, 1, 10);
createGlobalObject(p, 10517, 0, 2339, 3855, 1, 10);
createGlobalObject(p, 10517, 0, 2419, 3837, 0, 10);
createGlobalObject(p, 10517, 0, 2420, 3837, 0, 10);
createGlobalObject(p, 27254, 0, 2407, 3866, 0, 10);
createGlobalObject(p, 2995, 0, 3066, 9542, 0, 10);
createGlobalObject(p, 7273, 0, 3210, 3435, 0, 10);
createGlobalObject(p, 2567, 0, 3015, 3369, 0, 10);
createGlobalObject(p, 7319, 0, 2970, 3277, 0, 10);
createGlobalObject(p, 16687, 0, 2114, 3922, 0, 10);
createGlobalObject(p, 16687, 0, 2113, 3924, 0, 10);
createGlobalObject(p, 16687, 0, 2114, 3920, 0, 10);
createGlobalObject(p, 16687, 0, 2115, 3927, 0, 10);
createGlobalObject(p, 16687, 0, 2115, 3924, 0, 10);
createGlobalObject(p, 2479, 0, 2118, 3917, 0, 10);
createGlobalObject(p, 2489, 0, 2119, 3923, 0, 10);
createGlobalObject(p, 2478, 0, 2118, 3920, 0, 10);
createGlobalObject(p, 7289, 0, 2113, 3915, 0, 10);
createGlobalObject(p, 2476, 0, 3087, 3487, 1, 10);
createGlobalObject(p, 2477, 0, 3086, 3487, 1, 10);
createGlobalObject(p, 848, 0, 2342, 3101, 1, 10);
createGlobalObject(p, 36579, 0, 2347, 3102, 0, 10);
createGlobalObject(p, 36579, 0, 2346, 3099, 1, 10);
createGlobalObject(p, 7288, 0, 2341, 3173, 0, 10);
createGlobalObject(p, 10517, 0, 3046, 9543, 1, 10);
createGlobalObject(p, 10517, 0, 3046, 9544, 1, 10);
createGlobalObject(p, 10517, 0, 3046, 9545, 1, 10);
createGlobalObject(p, 10517, 0, 3046, 9546, 1, 10);
createGlobalObject(p, 10517, 0, 3046, 9547, 1, 10);
createGlobalObject(p, 10517, 0, 3029, 9582, 1, 10);
createGlobalObject(p, 11356, 0, 2464, 4847, 4, 10);
createGlobalObject(p, 10436, 0, 2469, 4846, 4, 10);
createGlobalObject(p, 20228, 0, 2467, 4838, 4, 10);
createGlobalObject(p, 20228, 0, 2471, 4838, 4, 10);
createGlobalObject(p, 20228, 0, 2471, 4842, 2, 10);
createGlobalObject(p, 20228, 0, 2467, 4842, 2, 10);
createGlobalObject(p, 10517, 0, 2471, 4841, 3, 10);
createGlobalObject(p, 10517, 0, 2471, 4840, 3, 10);
createGlobalObject(p, 10517, 0, 2471, 4839, 3, 10);
createGlobalObject(p, 10517, 0, 2470, 4838, 4, 10);
createGlobalObject(p, 10517, 0, 2469, 4838, 4, 10);
createGlobalObject(p, 10517, 0, 2468, 4838, 4, 10);
createGlobalObject(p, 10517, 0, 2467, 4839, 3, 10);
createGlobalObject(p, 10517, 0, 2467, 4840, 3, 10);
createGlobalObject(p, 10517, 0, 2467, 4841, 3, 10);
createGlobalObject(p, 10517, 0, 2470, 4842, 4, 10);
createGlobalObject(p, 10517, 0, 2468, 4842, 4, 10);
createGlobalObject(p, 10517, 0, 2469, 4842, 4, 10);
createGlobalObject(p, 10517, 0, 3252, 3741, 3, 10);
createGlobalObject(p, 10517, 0, 3246, 3726, 4, 10);
createGlobalObject(p, 10517, 0, 3247, 3726, 4, 10);
createGlobalObject(p, 10517, 0, 3223, 3726, 4, 10);
createGlobalObject(p, 10517, 0, 3224, 3726, 4, 10);
createGlobalObject(p, 10517, 0, 3225, 3726, 4, 10);
createGlobalObject(p, 10517, 0, 3212, 3726, 4, 10);
createGlobalObject(p, 10517, 0, 3220, 3751, 4, 10);
createGlobalObject(p, 10517, 0, 3221, 3751, 4, 10);
createGlobalObject(p, 10517, 0, 3030, 3474, 3, 10);
createGlobalObject(p, 10517, 0, 3030, 3473, 3, 10);
createGlobalObject(p, 10517, 0, 3030, 3472, 3, 10);
createGlobalObject(p, 13292, 0, 2842, 3425, 4, 10);
createGlobalObject(p, 13291, 0, 2843, 3425, 3, 10);
createGlobalObject(p, 13292, 0, 2843, 3424, 3, 10);
createGlobalObject(p, 13291, 0, 2843, 3423, 3, 10);
createGlobalObject(p, 13292, 0, 2842, 3423, 2, 10);
createGlobalObject(p, 13291, 0, 2841, 3425, 1, 10);
createGlobalObject(p, 13292, 0, 2841, 3424, 1, 10);
createGlobalObject(p, 13291, 0, 2841, 3423, 1, 10);
createGlobalObject(p, 2151, 0, 2828, 3425, 1, 10);
createGlobalObject(p, 2151, 0, 2521, 3009, 1, 10);
createGlobalObject(p, 2151, 0, 2513, 3027, 1, 10);
createGlobalObject(p, 2151, 0, 2528, 3021, 1, 10);
createGlobalObject(p, 26284, 0, 2519, 3012, 1, 10);
createGlobalObject(p, 26380, 0, 2530, 3026, 0, 10);
createGlobalObject(p, 26381, 0, 2531, 3026, 0, 10);
createGlobalObject(p, 26271, 0, 2531, 3020, 3, 10);
createGlobalObject(p, 26381, 0, 2517, 3011, 3, 10);
createGlobalObject(p, 26380, 0, 2517, 3012, 3, 10);
createGlobalObject(p, 26272, 0, 2522, 3015, 3, 10);
createGlobalObject(p, 26274, 0, 2529, 3020, 3, 10);
createGlobalObject(p, 26283, 0, 2521, 3010, 3, 10);
createGlobalObject(p, 26282, 0, 2514, 3024, 3, 10);
createGlobalObject(p, 26281, 0, 2513, 3038, 3, 10);
createGlobalObject(p, 26278, 0, 2518, 3040, 3, 10);
createGlobalObject(p, 26286, 0, 2508, 3037, 3, 10);
createGlobalObject(p, 26287, 0, 2513, 3046, 3, 10);
createGlobalObject(p, 26288, 0, 2965, 3337, 3, 10);
createGlobalObject(p, 10517, 0, 3045, 3372, 2, 10);
createGlobalObject(p, 10517, 0, 3046, 3372, 2, 10);
createGlobalObject(p, 10517, 0, 3007, 3391, 1, 10);
createGlobalObject(p, 10517, 0, 3007, 3390, 1, 10);
createGlobalObject(p, 10517, 0, 3007, 3389, 1, 10);
createGlobalObject(p, 10517, 0, 2994, 3373, 2, 10);
createGlobalObject(p, 10517, 0, 2981, 3387, 1, 10);
createGlobalObject(p, 10517, 0, 2981, 3388, 1, 10);
createGlobalObject(p, 10517, 0, 2995, 3373, 2, 10);
createGlobalObject(p, 10157, 0, 2965, 3364, 2, 10);
createGlobalObject(p, 10157, 0, 2964, 3364, 2, 10);
createGlobalObject(p, 10517, 0, 2965, 3354, 2, 10);
createGlobalObject(p, 10517, 0, 2964, 3354, 2, 10);
createGlobalObject(p, 13615, 0, 2964, 3356, 2, 10);
}
}
   
public void sendPlayerCoords(Player p, int x, int y)
{
if(p == null || p.stream == null || p.disconnected[0])
{
return;
}
p.stream.createFrame(218);
p.stream.writeByteA(x);
p.stream.writeByte(y);
}
public int getDistance(int coordX1, int coordY1, int coordX2, int coordY2)
{
int deltaX = coordX2 - coordX1;
int deltaY = coordY2 - coordY1;
return ((int)Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
}
    public void connecttofserver(Player p){
        if(p == null || p.stream == null || p.disconnected[0]){
            return;
        }
        p.stream.createFrame(115);
        p.stream.writeByte(2);
    }

	 public void sendSentPrivateMessage(Player p, long name, String message)
	 {
		 byte[] bytes = new byte[message.length()];
		 Misc.encryptPlayerChat(bytes, 0, 0, message.length(), message.getBytes());
		 p.stream.createFrameVarSize(89);
		 p.stream.writeQWord(name);
		 p.stream.writeByte(message.length());
		 p.stream.writeBytes(bytes, bytes.length, 0);
		 p.stream.endFrameVarSize();
	 }

	 private static int messageCounter = 1;
	 public void sendReceivedPrivateMessage(Player p, long name, int rights, String message)
	 {
		 int id = messageCounter++;
		 if (id > 16000000)
		 {
			 id = 1;
		 }
		 byte[] bytes = new byte[message.length()+1];
		 bytes[0] = (byte)message.length();
		 Misc.encryptPlayerChat(bytes, 0, 1, message.length(), message.getBytes());
		 p.stream.createFrameVarSize(178);
		 p.stream.writeQWord(name);
		 p.stream.writeWord(1);
		 p.stream.writeByte(((id << 16) & 0xFF));
		 p.stream.writeByte(((id << 8) & 0xFF));
		 p.stream.writeByte(((id) & 0xFF));
		 p.stream.writeByte(rights);
		 p.stream.writeBytes(bytes, bytes.length, 0);
		 p.stream.endFrameVarSize();
	 }

	 public void sendFriend(Player p, long name, int world)
	 {
		 p.stream.createFrameVarSize(154);
		 p.stream.writeQWord(name);
		 p.stream.writeWord(world);
		 p.stream.writeByte(1);
		 if (world != 0)
		 {
			 if (world == 1)
			 {
				 p.stream.writeString("Online");
			 }
			 else
			 {
				 p.stream.writeString("Mezzy-Scape Online");
			 }
		 }
		 p.stream.endFrameVarSize();
	 }

	 public void sendIgnores(Player p, long[] ignores) {
        p.stream.createFrameVarSizeWord(240);
	for(long ignore : ignores) {
            p.stream.writeQWord(ignore);
	}
	p.stream.endFrameVarSizeWord();
    }

    /**
     * Set either fullscreen or normal.
     * @param p The Player which the frame should be created for.
     * @param set The frame set, 548 for the default setup.
     */
    public void setWindowPane(Player p, int set) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrame(239);
        p.stream.writeWord(set);
        p.stream.writeByteA(0);
    }

    /**
     * Logs a player out.
     * @param p The Player which the frame should be created for.
     */
    public void logout(Player p) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrame(104);
    }

    /**
     * Display an interface.
     * <p>The various ids determines how the interface is displayed, from an overlay, to covering the chatbox, etc.
     * @param p The Player which the frame should be created for.
     * @param showId Sets the interface such as an overlay, etc.
     * @param windowId What type of window you used, default should be 548.
     * @param interfaceId Where to display it on the screen.
     * @param childId The interface id to display.
     */
    public void setInterface(Player p, int showId, int windowId, int interfaceId, int childId) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrame(93);
        p.stream.writeWord(childId);
        p.stream.writeByteA(showId);
        p.stream.writeWord(windowId);
        p.stream.writeWord(interfaceId);
    }

    /**
     * Set a players click option.
     * <p>The slot cannot be below 0 and cannot be above 8.
     * @param p The Player which the frame should be created for.
     * @param option The string to set the option to.
     * @param slot The position to set the option on the player.
     */
    public void setPlayerOption(Player p, String option, int slot) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrameVarSize(252);
        p.stream.writeByteC(1);
        p.stream.writeString(option);
        p.stream.writeByteC(slot);
        p.stream.endFrameVarSize();
    }

    public void setNPCId(Player p, int npcId, int interfaceId, int childId) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrame(6);
        p.stream.writeWordBigEndian(interfaceId);
        p.stream.writeWordBigEndian(childId);
        p.stream.writeWordBigEndian(npcId);
    }


    public void animateInterfaceId(Player p, int emoteId, int interfaceId, int childId) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrame(245);
        p.stream.writeWordBigEndian(interfaceId);
        p.stream.writeWordBigEndian(childId);
        p.stream.writeWord(emoteId);
    }

    /**
     * Setting client configs.
     * <p>This is used for setting prayers, running, etc.
     * @param p The Player which the frame should be created for.
     * @param id The config id to set.
     * @param set What to set the config.
     */
    public void setConfig(Player p, int id, int set) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        if (set < 128) {
            setConfig1(p, id, set);
        } else {
            setConfig2(p, id, set);
        }
    }

    public void setConfig1(Player p, int id, int set) {
        p.stream.createFrame(100);
        p.stream.writeWordA(id);
        p.stream.writeByteA(set);
    }

    public void setConfig2(Player p, int id, int set) {
        p.stream.createFrame(161);
        p.stream.writeWord(id);
        p.stream.writeDWord_v1(set);
    }

    /**
     * Creates a projectile. Can be used for magic, range etc.
     * @param p The Player which the frame should be created for.
     * @param CasterY The caster absY
     * @param CasterX The caster absX
     * @param offsetY The distance between caster and enemy Y
     * @param offsetX The distance between caster and enemy X
     * @param angle The starting place of the projectile
     * @param speed The speed minus the distance making it set.
     * @param gfxMoving The moving graphic ID
     * @param startHeight The starting height
     * @param endHeight The destination height
     * @param lockon The NPC the missile is locked onto.
     * */
    public void createProjectile(Player p, int casterY, int casterX, int offsetY, int offsetX, int angle,
            int speed, int gfxMoving, int startHeight, int endHeight, int lockon) {
        if (p == null || p.stream == null) {
            return;
        }
        sendCoords(p, (casterX - ((p.mapRegionX - 6) * 8)) - 3,
                (casterY - ((p.mapRegionY - 6) * 8)) - 2);
        p.stream.createFrame(112);
        p.stream.writeByte(angle);
        p.stream.writeByte(offsetX);
        p.stream.writeByte(offsetY); 
        p.stream.writeRShort(lockon); 
        p.stream.writeWord(gfxMoving); 
        p.stream.writeByte(startHeight); 
        p.stream.writeByte(endHeight); 
        p.stream.writeWord(51); 
        p.stream.writeWord(speed); 
        p.stream.writeByte(16);
        p.stream.writeByte(64);							
    }
	
    /**
     * Creates a Global Projectiles.
     * @param Objectid The Id of the Object to spawn.
     * @param Heigh The Height to spawn the Object on.
     * @param ObjectX The AbsX to spawn the Object on.
     * @param ObjectY The AbsY to spawn the Object on.
     * @param Face The Position for the OBject to face 
     * @param Type Object Type
     * */
    public void createGlobalProjectile(int casterY, int casterX, int offsetY, int offsetX, int gfxMoving, int startHeight, int endHeight, int speed, int atkIndex) {
        for (Player p : Engine.players) {
            if (p == null || p.disconnected[0]) {
                continue;
            }
            // createProjectile(p, casterY, casterX, offsetY, offsetX, angle, speed, gfxMoving, startHeight, endHeight, lockon)
            p.frames.createProjectile(p, casterY, casterX, offsetY, offsetX, 50,
                    speed, gfxMoving, startHeight, endHeight, atkIndex);
        }
    }

    public void setBankOptions(Player p) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrame(223);
        p.stream.writeWord(496);
        p.stream.writeWordBigEndianA(0);
        p.stream.writeWordBigEndian(73);
        p.stream.writeWordBigEndian(762);
        p.stream.writeWordBigEndian(1278);
        p.stream.writeWordBigEndian(20);
        p.stream.createFrame(223);
        p.stream.writeWord(27);
        p.stream.writeWordBigEndianA(0);
        p.stream.writeWordBigEndian(0);
        p.stream.writeWordBigEndian(763);
        p.stream.writeWordBigEndian(1150);
        p.stream.writeWordBigEndian(18);
    }

    /**
     * Set the run energy on the client.
     * @param p The Player which the frame should be created for.
     */
    public void setEnergy(Player p) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrame(99);
        p.stream.writeByte(p.runEnergy);
    }

    /**
     * Setting a tab.
     * @param p The Player which the frame should be created for.
     * @param tabId Which tab to display the interface on.
     * @param childId The interface to display on the tab.
     */
    public void setTab(Player p, int tabId, int childId) {
        setInterface(p, 1, childId == 137 ? 752 : 548, tabId, childId);
    }

    /**
     * Set the overlay to be displayed.
     * @param p The Player which the frame should be created for.
     * @param childId The interface id to display as an overlay.
     */
    public void setOverlay(Player p, int childId) {
        setInterface(p, 1, 548, 5, childId);
    }

    /**
     * Remove any overlays that might be set.
     * @param p The Player which the frame should be created for.
     */
    public void removeOverlay(Player p) {
        setInterface(p, 1, 548, 5, 56);
    }

    /**
     * Display an interface on the main area in the screen.
     * @param p The Player which the frame should be created for.
     * @param childId the interface id to display.
     */
    public void showInterface(Player p, int childId) {
        setInterface(p, 0, 548, 8, childId);
        p.interfaceId = childId;
    }

    /**
     * Remove an interface on the main screen.
     * @param p The Player which the frame should be created for.
     */
    public void removeShownInterface(Player p) {
        setInterface(p, 1, 548, 8, 56);
        p.interfaceId = -1;
        p.input.resetInput();
    }

    
    /**
     * Display an interface on the chatbox.
     * @param p The Player which the frame should be created for.
     * @param childId The interface to display on the chatbox.
     */
    public void showChatboxInterface(Player p, int childId) {
        setInterface(p, 0, 752, 12, childId);
        p.chatboxInterfaceId = childId;
    }

    /**
     * Set the chatbox back removing any interfaces on it.
     * @param p The Player which the frame should be created for.
     */
    public void removeChatboxInterface(Player p) {
        setConfig(p, 334, 1);
        p.stream.createFrame(246);
        p.stream.writeWord(752);
        p.stream.writeWord(12);
        p.chatboxInterfaceId = -1;
    }

    /**
     * Set the inventory.
     * @param p The Player which the frame should be created for.
     * @param childId The interface to display on the inventory.
     */
    public void setInventory(Player p, int childId) {
        setInterface(p, 0, 548, 71, childId);
    }

    /**
     * Set interface defaults at login.
     * @param p The Player which the frame should be created for.
     */
    public void setInterfaces(Player p) {
        if (p == null || p.disconnected[0]) {
            return;
        }
        setTab(p, 6, 745);
        setTab(p, 11, 751); // Chat options
        setTab(p, 68, 752); // Chatbox
        setTab(p, 64, 748); // HP bar
        setTab(p, 65, 749); // Prayer bar
        setTab(p, 66, 750); // Energy bar
        setTab(p, 67, 747); // Summoning bar
        setTab(p, 8, 137); // Playername on chat
        setTab(p, 73, 92); // Attack tab
        setTab(p, 74, 320); // Skill tab
        setTab(p, 75, 274); // Quest tab
        setTab(p, 7, 754); // Split Chat
        setTab(p, 76, 149); // Inventory tab
        setTab(p, 77, 387); // Equipment tab
        setTab(p, 78, 271); // Prayer tab
        setTab(p, 79, 192); // Magic tab
        setTab(p, 81, 550); // Friend tab
        setTab(p, 82, 551); // Ignore tab
        setTab(p, 83, 589); // Clan tab
        setTab(p, 84, 261); // Setting tab
        setTab(p, 85, 464); // Emote tab
        setTab(p, 86, 187); // Music tab
        setTab(p, 87, 182); // Logout tab
        setString(p, "Mezzy-Scape's Friend List", 550, 3);
        setString(p, "Mezzy-Scape's Ignore List", 551, 3);
        setString(p, "Mezzy-Scape 508 Clan Chat", 589, 7);
        setString(p, "Add Ignore", 551, 4);
        setString(p, "Del Ignore", 551, 5);
        setString(p, "Once you are finished playing Mezzy-Scape, please use the log out button to log out safetly.", 182, 0);
        setString(p, "Click here to logout", 182, 6);
    }


    /**
     * Set interface defaults at login.
     * @param p The Player which the frame should be created for.
     */
    public void setConfigs(Player p) {
        if (p == null || p.disconnected[0]) {
            return;
        }
        // setConfig(p, 1021, 1); tab flashing
        setConfig(p, 1160, -1);
        setConfig(p, 173, 0);
        setConfig(p, 313, -1);
        setConfig(p, 465, -1);
        setConfig(p, 802, -1);
        setConfig(p, 1085, 249852);
    }

    /**
     * Set welcome interface.
     * @param p The Player which the frame should be created for.
     */
    public void setWelcome(Player p) {
        if (p == null || p.disconnected[0]) {
            return;
        }
        setWindowPane(p, 549);
        setInterface(p, 1, 549, 2, 378);
        setInterface(p, 1, 549, 3, 17); // can use 15 - string 0 and 4, 17 - string 0 and 3, and 447 - string 0, 1 and 2.



if(p.RandomMessage == 0)
{
        setString(p, "Message of the week!", 17, 0);   
}



        setString(p, "Join The Forums!! http://Mezzy-Scape.com/",
                17, 3);
        setString(p, "Respect All Players!!", 378, 37);
        setString(p, p.messageCount + "", 378, 39);
        setString(p, "Don't need to pay to play!", 378, 94);
        setString(p,
                "You have " + p.memberCount
                + " days of member credit remaining. Please click here to extend your credit",
                378,
                93);
        setString(p, "9999", 378, 96);
        setString(p, "Welcome to Mezzy-Scape!!", 378, 115);
        setString(p, "The Server Owners are Vicky and Chris!! ", 378, 116);
    }

    /**
     * Send coordinates, used with other frames.
     * @param p The Player which the frame should be created for.
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    public void sendCoords(Player p, int x, int y) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrame(177);
        p.stream.writeByte(y);
        p.stream.writeByteS(x);
    }

    /**
     * Creates an item on the ground at itemX and itemY.
     * @param p The Player which the frame should be created for.
     * @param itemId The item id to be displayed.
     * @param itemAmt The amount the item stack size is.
     * @param itemX The absolute x coordinate to display the item.
     * @param itemY The absolute y coordinate to display the item.
     * @param itemHeight The height level to set the item.
     */
    public void createGroundItem(Player p, int itemId, int itemAmt, int itemX, int itemY, int itemHeight) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        if (Misc.getDistance(itemX, itemY, p.absX, p.absY) <= 60
                && p.heightLevel == itemHeight) {
            sendCoords(p, (itemX - ((p.mapRegionX - 6) * 8)),
                    (itemY - ((p.mapRegionY - 6) * 8)));
            p.stream.createFrame(25);
            p.stream.writeWordBigEndianA(itemAmt);
            p.stream.writeByte(0);
            p.stream.writeWordBigEndianA(itemId);
        }
    }

    /**
     * Removes an item on the ground at itemX and itemY.
     * @param p The Player which the frame should be created for.
     * @param itemId The item id to remove.
     * @param itemX The absolute x coordinate to remove the item.
     * @param itemY The absolute y coordinate to remove the item.
     * @param itemHeight The height level toe remove the item at.
     */
    public void removeGroundItem(Player p, int itemId, int itemX, int itemY, int itemHeight) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        if (Misc.getDistance(itemX, itemY, p.absX, p.absY) <= 60
                && p.heightLevel == itemHeight) {
            sendCoords(p, (itemX - ((p.mapRegionX - 6) * 8)),
                    (itemY - ((p.mapRegionY - 6) * 8)));
            p.stream.createFrame(201);
            p.stream.writeByte(0);
            p.stream.writeWord(itemId);
        }
    }

    /**
     * Send players stat.
     * @param p The Player which the frame should be created for.
     * @param lvlId The stat id to send.
     */
    public void setSkillLvl(Player p, int lvlId) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrame(217);
        p.stream.writeByteC(p.skillLvl[lvlId]);
        p.stream.writeDWord_v2(p.skillXP[lvlId]);
        p.stream.writeByteC(lvlId);
    }

    /**
     * Set item display on an interface.
     * @param p The Player which the frame should be created for.
     * @param interfaceId The interface to display the items on.
     * @param childId The child interface on the main interface.
     * @param itemArray The item id array to set on the interface.
     * @param itemAmt The item array to go with the itemArray.
     */
    public void setItems(Player p, int interfaceId, int childId, int type, int[] itemArray, int[] itemAmt) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrameVarSizeWord(255);
        p.stream.writeWord(interfaceId);
        p.stream.writeWord(childId);
        p.stream.writeWord(type);
        p.stream.writeWord(itemArray.length);
        for (int i = 0; i < itemArray.length; i++) {
            if (itemAmt[i] > 254) {
                p.stream.writeByteS(255);
                p.stream.writeDWord_v2(itemAmt[i]);
            } else {
                p.stream.writeByteS(itemAmt[i]);
            }
            p.stream.writeWordBigEndian(itemArray[i] + 1);
        }
        p.stream.endFrameVarSizeWord();
    }



    /**
     * Set interface configs.
     * <p>This is used to do things such as hiding and displaying the special attack bar.
     * @param p The Player which the frame should be created for.
     * @param interfaceId The interface to the set the config with.
     * @param childId The child that belongs to the interface to change.
     * @param 1 for true, 0 for false.
     */
    public void setInterfaceConfig(Player p, int interfaceId, int childId, boolean set) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrame(59);
        p.stream.writeByteC(set ? 1 : 0);
        p.stream.writeWord(childId);
        p.stream.writeWord(interfaceId);
    }

    /**
     * Display a message in the chatbox.
     * @param p The Player which the frame should be created for.
     * @param s The message to display in the chatbox.
     */
    public void sendMessage(Player p, String s) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrameVarSize(218);
        p.stream.writeString(s);
        p.stream.endFrameVarSize();
    }

    /**
     * Set a string on an interface.
     * @param p The Player which the frame should be created for.
     * @param str The string to set on the interface.
     * @param interfaceId The interface to set the text on.
     * @param childId The interface's child to set the text on.
     */
    public void setString(Player p, String str, int interfaceId, int childId) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        int sSize = str.length() + 5;

        p.stream.createFrame(179);
        p.stream.writeByte(sSize / 256);
        p.stream.writeByte(sSize % 256);
        p.stream.writeString(str);
        p.stream.writeWord(childId);
        p.stream.writeWord(interfaceId);
    }

    /**
     * Send this player's updated coordinates.
     * @param p The Player which the frame should be created for.
     */
    public void updateMovement(Player p) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrameVarSizeWord(216);
        p.stream.initBitAccess();
        p.stream.writeBits(1, 1);
        if (p.runDir == -1) {
            p.stream.writeBits(2, 1);
            p.stream.writeBits(3, p.walkDir);
            p.stream.writeBits(1, p.updateReq ? 1 : 0);
        } else {
            p.stream.writeBits(2, 2);
            p.stream.writeBits(3, p.runDir);
            p.stream.writeBits(3, p.walkDir);
            p.stream.writeBits(1, p.updateReq ? 1 : 0);
            if (p.runEnergy > 0) {
                p.runEnergyUpdateReq = true;
                p.runEnergy--;
            } else {
                p.isRunning = false;
            }
        }
    }

    /**
     * Tell the client this player isn't moving.
     * @param p The Player which the frame should be created for.
     */
    public void noMovement(Player p) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrameVarSizeWord(216);
        p.stream.initBitAccess();
        p.stream.writeBits(1, p.updateReq ? 1 : 0);
        if (p.updateReq) {
            p.stream.writeBits(2, 0);
        }
    }

    /**
     * Changes the coordinates this player is standing at.
     * @param p The Player which the frame should be created for.
     */
    public void teleport(Player p) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrameVarSizeWord(216);
        p.stream.initBitAccess();
        p.stream.writeBits(1, 1);
        p.stream.writeBits(2, 3);
        p.stream.writeBits(7, p.currentX);
        p.stream.writeBits(1, 1);
        p.stream.writeBits(2, p.heightLevel);
        p.stream.writeBits(1, p.updateReq ? 1 : 0);
        p.stream.writeBits(7, p.currentY);
    }

    /**
     * Send the map region and other positioning info to the client.
     * @param p The Player which the frame should be created for.
     */
    public void setMapRegion(Player p) {
        if (p == null || p.stream == null || p.disconnected[0]) {
            return;
        }
        p.stream.createFrameVarSizeWord(142);
        p.stream.writeWordA(p.mapRegionX);
        p.stream.writeWordBigEndianA(p.currentY);
        p.stream.writeWordA(p.currentX);
        boolean forceSend = true;
		p.rebuildNPCList = true;

        if ((((p.mapRegionX / 8) == 48) || ((p.mapRegionX / 8) == 49))
                && ((p.mapRegionY / 8) == 48)) {
            forceSend = false;
        }
        if (((p.mapRegionX / 8) == 48) && ((p.mapRegionY / 8) == 148)) {
            forceSend = false;
        }
        for (int xCalc = (p.mapRegionX - 6) / 8; xCalc
                <= ((p.mapRegionX + 6) / 8); xCalc++) {
            for (int yCalc = (p.mapRegionY - 6) / 8; yCalc
                    <= ((p.mapRegionY + 6) / 8); yCalc++) {
                int region = yCalc + (xCalc << 1786653352);

                if (forceSend
                        || ((yCalc != 49) && (yCalc != 149) && (yCalc != 147)
                        && (xCalc != 50) && ((xCalc != 49) || (yCalc != 47)))) {
                    int[] mapData = Engine.mapData.getData(region);

                    p.stream.writeDWord(mapData[0]);
                    p.stream.writeDWord(mapData[1]);
                    p.stream.writeDWord(mapData[2]);
                    p.stream.writeDWord(mapData[3]);
                }
            }
        }
        p.stream.writeByteC(p.heightLevel);
        p.stream.writeWord(p.mapRegionY);
        p.stream.endFrameVarSizeWord();
    }
}
