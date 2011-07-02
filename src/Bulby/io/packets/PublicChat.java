

package Bulby.io.packets;


import Bulby.players.Player;
import Bulby.util.Misc;
import Bulby.Engine;
import Bulby.util.Censor;

public class PublicChat implements Packet {

	/**
	 * Handles player chatting.
	 * @param p The Player which the frame should be handled for.
	 * @param packetId The packet id this belongs to.
	 * @param packetSize The amount of bytes being recieved for this packet.
	 */
	public void handlePacket(Player p, int packetId, int packetSize) {
		if (p == null || p.stream == null) {
			return;
		}
		if(p.muted == 1){
			p.frames.sendMessage(p, "You are muted and cannot talk!");
			return;
		}

		int chatTextEffects = p.stream.readUnsignedWord();
		int numChars = p.stream.readUnsignedByte();
		String chatText = Misc.decryptPlayerChat(p.stream, numChars);
		if (chatText.startsWith("/")) {
			if (p.clanRoom.length() > 0) {
				Engine.clanChat.sendMessage(p, chatText.substring(1));
			}
		} else {

			p.chatTextEffects = chatTextEffects;
			p.chatText = chatText;
			p.chatTextUpdateReq = true;
			p.updateReq = true;
		}


		// Misc.appendData("ChatLogs/" + p.username + ".txt", "[" + Misc.getDate() + "] " + p.username + ": " + p.chatText);
	}
}
