/*
 * Class ObjectOption2
 *
 * Version 1.0
 *
 * Saturday, August 23, 2008
 *
 * Created by Palidino76
 */


package Bulby.io.packets;


import Bulby.players.Player;
import Bulby.util.Misc;
import Bulby.Engine;


public class ObjectOption2 implements Packet {

    /*
     * make sure to document EVERY coordinate to go with each object unless an un-important object(wilderness ditch lol).
     * This will prevent people from spawning an object client side and actually using it.
     * So make sure to include with the id, objectX == # && objectY == #
     */

    /**
     * Handles the second option on objects.
     * @param p The Player which the frame should be handled for.
     * @param packetId The packet id this belongs to.
     * @param packetSize The amount of bytes being recieved for this packet.
     */
    public void handlePacket(Player p, int packetId, int packetSize) {
        if (p == null || p.stream == null) {
            return;
        }
        if (!p.objectOption2) {
            p.clickY = p.stream.readUnsignedWordA();
            p.clickId = p.stream.readUnsignedWordBigEndian();
            p.clickX = p.stream.readUnsignedWordBigEndianA();
            if (Misc.getDistance(p.absX, p.absY, p.clickX, p.clickY) > 30) {
                return;
            }
            p.objectOption2 = true;
        }
        int distance = Misc.getDistance(p.clickX, p.clickY, p.absX, p.absY);

        if (p.walkDir != -1 || p.runDir != -1
                || distance > objectSize(p.clickId)) {
            return;
        }
        p.objectOption2 = false;
        switch (p.clickId) {
        default:
            Misc.println("[" + p.username + "] Unhandled object 2: " + p.clickId);
            break;
case 3045:	
case 5276:
case 6084:
case 10517:
case 11338:
case 11402:
case 11758:
case 12798:
case 12799:
case 12800:
case 12801:
case 14367:
case 14368:
case 16700:
case 18491:
case 19230:
case 20325:
case 20326:
case 20327:
case 20328:
case 22819:
case 2213:
case 24914:
case 25808:
case 26972:
case 29085:
case 30015:
case 30016:
case 34205:
case 34752:
case 35647:
case 35648:
case 36262:
case 36786:
case 2214:
	if (p.alreadyBanked) {
	    p.openBank();
	} else if (p.hasBankPin == 1) {
	    p.bankpin();
	    p.frames.showInterface(p, 13);
	    p.frames.sendMessage(p, "Please enter in your bank pin.");
	} else if (p.hasBankPin == 0) {
	    p.openBank();
	    p.frames.sendMessage(p, "You do not have a bank pin, do '::bankpin # # # #'(#'s 0-9) to set one.");
	}
break;
        }
    }

    private int objectSize(int id) {
        switch (id) {
        default:
            return 1;
        }
    }
}
