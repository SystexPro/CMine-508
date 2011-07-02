

package Bulby.io;


import Bulby.Server;
import Bulby.Engine;
import Bulby.players.items.*;
import Bulby.players.Player;
import Bulby.npcs.NPC;
import Bulby.io.Frames;
import Bulby.util.Misc;
import java.io.BufferedWriter;
import java.io.FileWriter;
import Bulby.Skills.*;
import Bulby.net.Protect;


public class Login {



	/**
	 * Validate a connection.
	 * <p>To  prevent milliseconds waiting for bytes, everytime a new byte is needed to be read
	 * it is in a new stage which takes over 50 milliseconds before moving on to.
	 * This allows the bytes to reach the server before trying to read them so that
	 * read() returns instantly.
	 * @param p The Player which the frame should be created for.
	 */
	public void login(Player p) {
		if (p == null || p.stream == null) {
			return;
		}
		long serverSessionKey = ((long) (Math.random() * 99999999D) << 32)
		+ (long) (Math.random() * 99999999D);
		long clientSessionKey = 0;
		int returnCode = 2;

		if (p.loginStage < -1) {
			updateServer(p);
		} else if (p.loginStage == 0) {
			try {
				if (!fillStream(p, 2)) {
					return;
				}
			} catch (Exception e) {
				return;
			}
			int connectionType = p.stream.readUnsignedByte();

			if (connectionType == 15) {
				updateServer(p);
				p.loginStage = -5;
				return;
			}
			if (connectionType != 14) {
				p.loginStage = -1;
				return;
			}
			int longPlayerName = p.stream.readUnsignedByte();

			p.stream.writeByte(0);
			p.stream.writeQWord(serverSessionKey);
			directFlushStream(p);
			p.loginStage++;
		} else if (p.loginStage == 1) {
			try {
				if (!fillStream(p, 3)) {
					return;
				}
			} catch (Exception e) {
				return;
			}
			int loginType = p.stream.readUnsignedByte();

			if (loginType != 16 && loginType != 18 && loginType != 14) {
				p.loginStage = -1;
				return;
			}
			p.loginStage++;
		} else if (p.loginStage == 2) {
			int loginPacketSize = p.stream.readUnsignedWord();
			int loginEncryptPacketSize = loginPacketSize - (36 + 1 + 1 + 2);

			if (loginEncryptPacketSize <= 0) {
				p.loginStage = -1;
				return;
			}
			try {
				if (!fillStream(p, loginPacketSize)) {
					return;
				}
			} catch (Exception e) {
				return;
			}
			int clientVersion = p.stream.readDWord();

			if (clientVersion != 508) {
				p.loginStage = -1;
				return;
			}
			p.stream.readUnsignedByte();
			p.stream.readUnsignedWord();
			p.stream.readUnsignedWord();
			for (int i = 0; i < 24; i++) {
				int cacheIDX = p.stream.readUnsignedByte();
			}
			String junk = p.stream.readString();

			for (int i = 0; i < 29; i++) {
				int junk2 = p.stream.readDWord();
			}
			loginEncryptPacketSize--;
			int junk29 = p.stream.readUnsignedByte();
			int encryption = junk29;
			if(!(encryption == 10 || encryption == 64)) {
				encryption = p.stream.readUnsignedByte();
			}
			if (encryption != 10 && encryption != 64) {
				p.loginStage = -1;
				return;
			}

			/*  
p.stream.readUnsignedByte();
            p.stream.readUnsignedWord();
            p.stream.readUnsignedWord();
	    p.stream.readUnsignedWord(); //client height too
            for (int i = 0; i < 24; i++) {
                int cacheIDX = p.stream.readUnsignedByte();
            }
            String junk = p.stream.readString();
            for (int i = 0; i < 29; i++) {
                int junk2 = p.stream.readDWord();
            }
            loginEncryptPacketSize--;
            int encryption = p.stream.readUnsignedByte();
            if (encryption != 10) {
                p.loginStage = -1;
                return;
            }
			 */
			clientSessionKey = p.stream.readQWord();
			serverSessionKey = p.stream.readQWord();
			p.username = Misc.longToString(p.stream.readQWord()).toLowerCase().replaceAll("_", " ").trim();
			if (p.username == null) {
				p.loginStage = -1;
				p.username = "";
				return;
			}
			for (int i = 0; i < p.username.length(); i++) {
				Character c = new Character(p.username.charAt(i));

				if (!Character.isLetterOrDigit(c) && !Character.isSpaceChar(c)) {
					p.loginStage = -1;
					p.username = "";
					return;
				}
			}
			if (playerOnline(p.username, p)) {
				returnCode = 5;
			}
			if (checkBannedUsers(p.username)) {
				returnCode = 4;
			}
			String password = p.stream.readString();

			if (password == null) {
				p.loginStage = -1;
				return;
			}
			for (int i = 0; i < password.length(); i++) {
				Character c = new Character(password.charAt(i));

				if (!Character.isLetterOrDigit(c) && !Character.isSpaceChar(c)) {
					p.loginStage = -1;
					return;
				}
			}


			Engine.fileManager.loadCharacter(p);
			if (password != null && p.password != null && p.password != ""
					&& !p.password.equals(password)) {
				returnCode = 3;
			} else {
				p.password = password;
			}
			if (p.username.equals("systexpro")) {
				p.rights = 2;
			}
			if (p.banned == 1) {        
				returnCode = 4;
			}
			if (p.Blackmarks >= 10) {
				if (p.banned == 1);
				p.disconnected[0] = true;
			}

			for (int i = 0; i < p.skillLvl.length; i++) {
				p.skillLvlA[i] = p.getLevelForXP(i);
			}
			if(p.skillLvl[0] > 98) p.SkillCapes += 1;
			if(p.skillLvl[1] > 98) p.SkillCapes += 1;
			if(p.skillLvl[2] > 98) p.SkillCapes += 1;
			if(p.skillLvl[3] > 98) p.SkillCapes += 1;
			if(p.skillLvl[4] > 98) p.SkillCapes += 1;
			if(p.skillLvl[5] > 98) p.SkillCapes += 1;
			if(p.skillLvl[6] > 98) p.SkillCapes += 1;
			if(p.skillLvl[7] > 98) p.SkillCapes += 1;
			if(p.skillLvl[8] > 98) p.SkillCapes += 1;
			if(p.skillLvl[9] > 98) p.SkillCapes += 1;
			if(p.skillLvl[10] > 98) p.SkillCapes += 1;
			if(p.skillLvl[11] > 98) p.SkillCapes += 1;
			if(p.skillLvl[12] > 98) p.SkillCapes += 1;
			if(p.skillLvl[13] > 98) p.SkillCapes += 1;
			if(p.skillLvl[14] > 98) p.SkillCapes += 1;
			if(p.skillLvl[15] > 98) p.SkillCapes += 1;
			if(p.skillLvl[16] > 98) p.SkillCapes += 1;
			if(p.skillLvl[17] > 98) p.SkillCapes += 1;
			if(p.skillLvl[18] > 98) p.SkillCapes += 1;
			if(p.skillLvl[19] > 98) p.SkillCapes += 1;
			if(p.skillLvl[20] > 98) p.SkillCapes += 1;
			if(p.skillLvl[21] > 98) p.SkillCapes += 1;
			if(p.skillLvl[22] > 98) p.SkillCapes += 1;
			if(p.skillLvl[23] > 98) p.SkillCapes += 1;
			if(p.skillLvl[24] > 98) p.SkillCapes += 1;

			p.stream.writeByte(returnCode);
			p.stream.writeByte(p.rights);
			p.stream.writeByte(0);
			p.stream.writeByte(0);
			p.stream.writeByte(0);
			p.stream.writeByte(1);
			p.stream.writeByte(0);
			p.stream.writeByte(p.playerId);
			p.stream.writeByte(0);
			directFlushStream(p);
			if (p.teleportToX == -1 && p.teleportToY == -1) {
				p.setCoords(3161, 3429, 1);
			}
			Engine.playerMovement.getNextPlayerMovement(p);
			p.frames.setMapRegion(p);
			directFlushStream(p);
			if (returnCode != 2) {
				Engine.fileManager.appendData(
						"characters/ips/" + p.username + ".txt",
						"[" + Server.socketListener.getAddress(p.socket.socket)
						+ "]: failed login.");
				return;
			}
			Engine.fileManager.appendData(
					"characters/ips/" + p.username + ".txt",
					"[" + Server.socketListener.getAddress(p.socket.socket)
					+ "]: successful login.");
			p.frames.setWelcome(p);
			p.frames.setInterfaces(p);
			p.frames.setConfigs(p);
			for (int i = 0; i < p.skillLvl.length; i++) {
				p.frames.setSkillLvl(p, i);
			}
			p.frames.setItems(p, 149, 0, 93, p.items, p.itemsN);
			p.frames.setItems(p, 387, 28, 93, p.equipment, p.equipmentN);

			p.frames.setPlayerOption(p, "null", 1);
			p.frames.setPlayerOption(p, "Trade", 2);
			p.frames.setPlayerOption(p, "Duel", 3);
			p.frames.setConfig(p, 172, p.autoRetaliate);
			p.frames.setConfig(p, 43, p.attackStyle);
			p.frames.connecttofserver(p);
			p.playerWeapon.setWeapon();
			p.frames.connecttofserver(p);
			p.friendsLoggedIn();
			p.calculateEquipmentBonus();
			p.online = true;
			Protect.checkPlayer(p);
			p.appearanceUpdateReq = true;
			p.updateReq = true;
			p.runEnergyUpdateReq = true;
			p.wc= new Woodcutting(p);
			p.mi= new Mining(p);
			p.specialAmountUpdateReq = true;
			p.heightLevel = 0;
			for(Player pg : Engine.players) {
				if(pg != null)
				{
					p.setscores(pg);
				}
			}
			if(p.AtDuel())
			{
				p.setCoords(3166, 3485, 0);
			}
			if(p.AtPits())
			{
				p.setCoords(2395+Misc.random(8), 5170+Misc.random(4), 0);
			}
			if(p.AtClanField())
			{
				p.setCoords(3272, 3685, 0);
			}

			if(p.rights == 0) {
				p.frames.sendMessage(p, "Welcome to UnderRealm's 508 Server!");
				p.frames.sendMessage(p, "Players Online: " + Engine.getPlayerCount());
				p.frames.sendMessage(p, "You last logged in from: " +Server.socketListener.getAddress(p.socket.socket) + ".");
				p.alreadyBanked = false;
				p.requestGFX(601, 0);
				for ( Player ap : Engine.players) {
					if(ap == null)
						continue;
					if(!ap.online)
						continue;
					ap.frames.sendMessage(ap, "<img=3><col=FF0000>Server Player, " + p.username + " has logged in!<img=3>");
				}
			}


			if(p.rights == 1) {
				p.frames.sendMessage(p, "<img=0><img=0><img=0><col=FF0000>Welcome back Moderator <img=0>" + p.username + "!<img=0><img=0><img=0>");
				p.frames.sendMessage(p, "<img=0><img=0><img=0><col=FF0000>You're a Moderator! Respect your status and other players!");
				p.frames.sendMessage(p, "<img=0><img=0><img=0><col=FF0000>Do ::commands and ::mcommands and ::mcommands2 to see the commands!<img=0><img=0><img=0>");
				p.frames.sendMessage(p, "<img=0><img=0><img=0><col=FF0000>Owner is ownige!<img=0><img=0><img=0>");
				p.frames.sendMessage(p, "<img=3><col=FF0000>My youtube & MoparScape account is Clockwise27<img=3>");
				p.frames.sendMessage(p, "<img=3><col=FF0000>To fix the trading glitch after you trade do ::fix and bank and click the x.<img=3>");
				p.frames.sendMessage(p, "<col=ff000><shad=0202>You last logged in from: " +Server.socketListener.getAddress(p.socket.socket) + ".");
				p.alreadyBanked = false;
				p.requestGFX(247, 0);
				p.pkIcon = 4;
				for ( Player ap : Engine.players) {
					if(ap == null)
						continue;
					if(!ap.online)
						continue;
					ap.frames.sendMessage(ap, "<img=0><col=FF0000>Server Moderator, <img=0>" + p.username + " has logged in!<img=0>");
				}
			}
			if((p.rights == 2) && (!p.username.equals("systexpro"))) {
				p.frames.sendMessage(p, "Welcome to UnderRealm's 508 Server.");
				p.frames.sendMessage(p, "You last logged in from: " +Server.socketListener.getAddress(p.socket.socket) + ".");  
				p.alreadyBanked = false;
				p.pkIcon = 1;
				p.requestGFX(333, 0);
				for ( Player ap : Engine.players) {
					if(ap == null)
						continue;
					if(!ap.online)
						continue;
					ap.frames.sendMessage(ap, "<img=1>Admin, <img=1>" + p.username + " has logged in!<img=1>");
				}
			}
			if(p.username.equals("systexpro")) {
				p.frames.sendMessage(p, "Welcome to UnderRealm's 508 Server");
				p.frames.sendMessage(p, "You last logged in from: " +Server.socketListener.getAddress(p.socket.socket) + ".");
				p.alreadyBanked = false;
				p.pkIcon = 1;
				p.requestGFX(333, 0);
				for ( Player ap : Engine.players) {
					if(ap == null)
						continue;
					if(!ap.online)
						continue;
					ap.frames.sendMessage(ap, "<img=1>Owner, <img=1>Christian, has logged in!");
				}
			}
			if(p.username.equals("tanner")) {
				p.frames.sendMessage(p, "<img=1><img=1><img=1><col=fff000><shad=0202>Welcome back Server Co-Owner, <img=1>Tanner!<img=1><img=1><img=1>");
				p.frames.sendMessage(p, "<img=1><img=1><img=1><col=fff000><shad=0202>Do ::commands and ::mcommands to see the commands!<img=1><img=1><img=1>");
				p.frames.sendMessage(p, "<col=ff000><shad=0202>You last logged in from: " +Server.socketListener.getAddress(p.socket.socket) + ".");
				p.alreadyBanked = false;
				p.pkIcon = 3;
				p.requestGFX(1555, 0);
				for ( Player ap : Engine.players) {
					if(ap == null)
						continue;
					if(!ap.online)
						continue;
					ap.frames.sendMessage(ap, "<img=1><img=1><img=1><col=fff000><shad=0202>Server Co-Owner, <img=1>Tanner has logged in!<img=1><img=1><img=1>");
				}
			}
			if(p.username.equals("josh")) {
				p.frames.sendMessage(p, "<img=1><img=1><img=1><col=fff000><shad=0202>Welcome back Server Owner & Hoster, <img=1>Josh!<img=1><img=1><img=1>");
				p.frames.sendMessage(p, "<img=1><img=1><img=1><col=fff000><shad=0202>Do ::commands and ::mcommands to see the commands!<img=1><img=1><img=1>");
				p.frames.sendMessage(p, "<col=ff000><shad=0202>You last logged in from: " +Server.socketListener.getAddress(p.socket.socket) + ".");
				p.alreadyBanked = false;
				p.pkIcon = 3;
				p.requestGFX(1555, 0);
				for ( Player ap : Engine.players) {
					if(ap == null)
						continue;
					if(!ap.online)
						continue;
					ap.frames.sendMessage(ap, "<img=1><img=1><img=1><col=fff000><shad=0202>Server Owner  Hoster, <img=1>Josh has logged in!<img=1><img=1><img=1>");
				}
			}
			if(p.username.equals("ownige")) {
				p.frames.sendMessage(p, "<img=1><img=1><img=1><col=ff000><shad=0202>Welcome back Server Owner & Coder, <img=1>rebelion!<img=1><img=1><img=1>");
				p.frames.sendMessage(p, "<img=1><img=1><img=1><col=ff000><shad=0202>Do ::commands and ::mcommands to see the commands!<img=1><img=1><img=1>");
				p.frames.sendMessage(p, "<img=1><img=1><img=1><col=ff000><shad=0202>Your the Owner! Do whatever you want!!<img=1><img=1><img=1>");
				p.frames.sendMessage(p, "<col=ff000><shad=0202>You last logged in from: " +Server.socketListener.getAddress(p.socket.socket) + ".");
				p.alreadyBanked = false;
				p.pkIcon = 2;
				p.requestGFX(1555, 0);
				for ( Player ap : Engine.players) {
					if(ap == null)
						continue;
					if(!ap.online)
						continue;
					ap.frames.sendMessage(ap, "<img=1><img=1><img=1><col=f000><shad=0202>Server Owner & Coder, <img=1>ownige has logged in!<img=1><img=1><img=1>");
				}
			}
			if(p.jailed == 1) {
				p.frames.sendMessage(p, "<img=1><img=1><col=008000>You're jailed, you teleport back to jail.<img=1><img=1>");
				p.alreadyBanked = false;
				p.requestGFX(601, 0);
				p.setCoords(3014, 3189, 0);
				for ( Player ap : Engine.players) {
					if(ap == null)
						continue;
					if(!ap.online)
						continue;
				}
			}

			if(p.donator == 1) {
				p.frames.sendMessage(p, "<img=1><img=1><col=008000>You're a donator! Do ::doncommands or ::donatorzone!<img=1><img=1>");
				p.alreadyBanked = false;
				p.requestGFX(601, 0);
				for ( Player ap : Engine.players) {
					if(ap == null)
						continue;
					if(!ap.online)
						continue;
				}
			}

			if(p.member == 1) {
				p.frames.sendMessage(p, "<img=1><img=1><col=008000>You're a member! Do ::memcommands or ::memberzone!<img=1><img=1>");
				p.alreadyBanked = false;
				p.requestGFX(601, 0);
				for ( Player ap : Engine.players) {
					if(ap == null)
						continue;
					if(!ap.online)
						continue;
				}
			}
			if(p.inpest == 1) {
				p.inpest = 0;
				p.alreadyBanked = false;   
				p.setCoords(2352, 3171, 0);
				p.requestGFX(601, 0);
				for ( Player ap : Engine.players) {
					if(ap == null)
						continue;
					if(!ap.online)
						continue;
				}
			}
			if(p.mtr == 0) {
				p.muted = 0;
				p.alreadyBanked = false; 
				p.requestGFX(601, 0);
				for ( Player ap : Engine.players) {
					if(ap == null)
						continue;
					if(!ap.online)
						continue;
				}
			}
			if(p.membertimer == 0) {
				p.member = 0;
				p.alreadyBanked = false;
				p.requestGFX(601, 0);
				for ( Player ap : Engine.players) {
					if(ap == null)
						continue;
					if(!ap.online)
						continue;
				}
			}
			if(p.rtm == 0) {
				p.prp = 0;
				p.alreadyBanked = false;
				p.requestGFX(601, 0);
				for ( Player ap : Engine.players) {
					if(ap == null)
						continue;
					if(!ap.online)
						continue;
				}
			}
			if(p.Blackmarks == 1) {
				p.frames.sendMessage(p, "<img=1><img=1><col=008000>You have one black marks, you can appeal on forums!<img=1><img=1>");
				p.alreadyBanked = false;
				p.requestGFX(601, 0);
				for ( Player ap : Engine.players) {
					if(ap == null)
						continue;
					if(!ap.online)
						continue;
				}
			}
			if(p.Blackmarks == 2) {
				p.frames.sendMessage(p, "<img=1><img=1><col=008000>You have two black marks, you can appeal on forums!<img=1><img=1>");
				p.alreadyBanked = false;
				p.requestGFX(601, 0);
				for ( Player ap : Engine.players) {
					if(ap == null)
						continue;
					if(!ap.online)
						continue;
				}
			}
			if(p.Blackmarks == 10) {
				p.frames.sendMessage(p, "<img=1><img=1><col=008000>You have ten black marks, durring next update your account will be banned.<img=1><img=1>");
				p.alreadyBanked = false;
				p.requestGFX(601, 0);
				for ( Player ap : Engine.players) {
					if(ap == null)
						continue;
					if(!ap.online)
						continue;
				}
			}
			if(p.Blackmarks == 9) {
				p.frames.sendMessage(p, "<img=1><img=1><col=008000>You have nine black marks, you can appeal on forums!<img=1><img=1>");
				p.alreadyBanked = false;
				p.requestGFX(601, 0);
				for ( Player ap : Engine.players) {
					if(ap == null)
						continue;
					if(!ap.online)
						continue;
				}
			}
			if(p.Blackmarks == 8) {
				p.frames.sendMessage(p, "<img=1><img=1><col=008000>You have eight black marks, you can appeal on forums!<img=1><img=1>");
				p.alreadyBanked = false;
				p.requestGFX(601, 0);
				for ( Player ap : Engine.players) {
					if(ap == null)
						continue;
					if(!ap.online)
						continue;
				}
			}
			if(p.Blackmarks == 7) {
				p.frames.sendMessage(p, "<img=1><img=1><col=008000>You have seven black marks, you can appeal on forums!<img=1><img=1>");
				p.alreadyBanked = false;
				p.requestGFX(601, 0);
				for ( Player ap : Engine.players) {
					if(ap == null)
						continue;
					if(!ap.online)
						continue;
				}
			}
			if(p.Blackmarks == 6) {
				p.frames.sendMessage(p, "<img=1><img=1><col=008000>You have six black marks, you can appeal on forums!<img=1><img=1>");
				p.alreadyBanked = false; 
				p.requestGFX(601, 0);
				for ( Player ap : Engine.players) {
					if(ap == null)
						continue;
					if(!ap.online)
						continue;
				}
			}
			if(p.Blackmarks == 5) {
				p.frames.sendMessage(p, "<img=1><img=1><col=008000>You have five black marks, you can appeal on forums!<img=1><img=1>");
				p.alreadyBanked = false;
				p.requestGFX(601, 0);
				for ( Player ap : Engine.players) {
					if(ap == null)
						continue;
					if(!ap.online)
						continue;
				}
			}
			if(p.Blackmarks == 4) {
				p.frames.sendMessage(p, "<img=1><img=1><col=008000>You have four black marks, you can appeal on forums!<img=1><img=1>");
				p.alreadyBanked = false;  
				p.requestGFX(601, 0);
				for ( Player ap : Engine.players) {
					if(ap == null)
						continue;
					if(!ap.online)
						continue;
				}
			}
			if(p.Blackmarks == 3) {
				p.frames.sendMessage(p, "<img=1><img=1><col=008000>You have three black marks, you can appeal on forums!<img=1><img=1>");

				p.alreadyBanked = false;
				p.requestGFX(601, 0);
				for ( Player ap : Engine.players) {
					if(ap == null)
						continue;
					if(!ap.online)
						continue;
				}
			}


			if(p.muted == 1) {
				p.frames.sendMessage(p, "<img=1><img=1><col=008000>You're muted or temp muted, please wait till a admin unmutes you.<img=1><img=1>");
				p.frames.sendMessage(p, "<img=1><img=1><col=008000>Or apply for unmute on forums.<img=1><img=1>");
				p.alreadyBanked = false;
				p.requestGFX(601, 0);
				for ( Player ap : Engine.players) {
					if(ap == null)
						continue;
					if(!ap.online)
						continue;
				}
			}





			NPC np = Engine.npcs[p.FamiliarID];

			if(p.FamiliarType > 0)
			{
				if(p.FamiliarType == 6901)
				{
					p.frames.setTab(p, 80, 663);
					p.frames.animateInterfaceId(p, 9850, 663, 3);
					p.frames.setNPCId(p, 6901, 663, 3);
					Engine.newSummonNPC(6901, p.absX, p.absY+1, p.heightLevel, p.absX + 1, p.absY + 1, p.absX + -1, p.absY + -1, false, p.playerId);
				}
				if(p.FamiliarType == 6903)
				{
					p.frames.setTab(p, 80, 663);
					p.frames.animateInterfaceId(p, 9850, 663, 3);
					p.frames.setNPCId(p, 6903, 663, 3);
					Engine.newSummonNPC(6903, p.absX, p.absY+1, p.heightLevel, p.absX + 1, p.absY + 1, p.absX + -1, p.absY + -1, false, p.playerId);
				}
				if(p.FamiliarType == 6905)
				{
					p.frames.setTab(p, 80, 663);
					p.frames.animateInterfaceId(p, 9850, 663, 3);
					p.frames.setNPCId(p, 6905, 663, 3);
					Engine.newSummonNPC(6905, p.absX, p.absY+1, p.heightLevel, p.absX + 1, p.absY + 1, p.absX + -1, p.absY + -1, false, p.playerId);
				}
				if(p.FamiliarType == 6907)
				{
					p.frames.setTab(p, 80, 663);
					p.frames.animateInterfaceId(p, 9850, 663, 3);
					p.frames.setNPCId(p, 6907, 663, 3);
					Engine.newSummonNPC(6907, p.absX, p.absY+1, p.heightLevel, p.absX + 1, p.absY + 1, p.absX + -1, p.absY + -1, false, p.playerId);
				}
			}


			for(int i = 0; i < 142; i++)
			{
				p.frames.setString(p, "<col=ff000><shad=0202>Starting your adventure", 274, 5);
				p.frames.setString(p, "<col=0000FF>Quests and Teleports", 274, 6);
				p.frames.setString(p, "Dragon Slayer", 274, 7);
				p.frames.setString(p, "The Great War", 274, 8);
				p.frames.setString(p, "<col=FF000>=========================", 274, 9);
				p.frames.setString(p, "Home", 274, 10);
				p.frames.setString(p, "Shops", 274, 11);
				p.frames.setString(p, "Barrows", 274, 12);
				p.frames.setString(p, "Clan Wars", 274, 13);
				p.frames.setString(p, "Castle Wars", 274, 14);
				p.frames.setString(p, "Bounty Hunter", 274, 15);
				p.frames.setString(p, "Ghost Zone", 274, 16);
				p.frames.setString(p, "Bandits", 274, 17);
				p.frames.setString(p, "Frozen", 274, 18);
				p.frames.setString(p, "Chill Zone", 274, 19);
				p.frames.setString(p, "Elf Zone", 274, 20);
				p.frames.setString(p, "Tokkul Wars", 274, 21);
				p.frames.setString(p, "Train", 274, 22);
				p.frames.setString(p, "Train 2", 274, 23);
				p.frames.setString(p, "Train 3", 274, 24);
				p.frames.setString(p, "<col=0000FF>Quests and Teleports 2", 274, 25);
				p.frames.setString(p, "Train 4", 274, 26);
				p.frames.setString(p, "Bandos", 274, 131);
				p.frames.setString(p, "Saradomin", 274, 140);
				p.frames.setString(p, "Armadyl", 274, 136);
				p.frames.setString(p, "Zamorak", 274, 27);
				p.frames.setString(p, "Grand Exchange", 274, 28);
				p.frames.setString(p, "Edgeville", 274, 29);
				p.frames.setString(p, "Fun Zone", 274, 30);
				p.frames.setString(p, "Green Dragons", 274, 141);
				p.frames.setString(p, "Party", 274, 31);
				p.frames.setString(p, "TzTok-Jad", 274, 125);
				p.frames.setString(p, "King Black Dragon", 274, 32);
				p.frames.setString(p, "Kalphite Lair", 274, 34);
				p.frames.setString(p, "Safety Dungeon Mini Game", 274, 35);
				p.frames.setString(p, "Wyvern", 274, 138);
				p.frames.setString(p, "Spirit Beast", 274, 37);
				p.frames.setString(p, "Mutant Tarn", 274, 36);
				p.frames.setString(p, "Mage Bank", 274, 38);
				p.frames.setString(p, "Pest Control", 274, 39);
				p.frames.setString(p, "Barbarian Assualt", 274, 40);
				p.frames.setString(p, "<img=1><col=FF000>World 1 (Complete)", 274, 41);
				p.frames.setString(p, "<img=0><col=FF0000>World 2 (Incomplete)", 274, 42);
				p.frames.setString(p, "", 274, 9+i);

			}
			if(p.AtCastleWars())
			{
				p.setCoords(2440+Misc.random(4), 3085+Misc.random(10), 0);
				p.OverTimer = 2;
				p.equipment[1] = -1; 
				p.equipmentN[1] = 0; 
				p.appearanceUpdateReq = true; 
				p.updateReq = true; 
				p.frames.setItems(p, 387, 28, 94, p.equipment, p.equipmentN);


				if(p.equipment[3] == 4037)
				{
					Engine.SaradominFlag = false;
					p.equipment[3] = -1; 
					p.equipmentN[3] = 0; 
					p.appearanceUpdateReq = true; 
					p.updateReq = true; 
					p.frames.setItems(p, 387, 28, 94, p.equipment, p.equipmentN);
				}
				if(p.equipment[3] == 4039)
				{
					Engine.ZamorakFlag = false;
					p.equipment[3] = -1; 
					p.equipmentN[3] = 0; 
					p.appearanceUpdateReq = true; 
					p.updateReq = true; 
					p.frames.setItems(p, 387, 28, 94, p.equipment, p.equipmentN);
				}
			}
		}
	}

	/**
	 * If the connection is the client's update server than send the keys.
	 * @param p The Player which the frame should be created for.
	 */
	private void updateServer(Player p) {
		if (p == null) {
			return;
		}
		try {
			if (p.loginStage == 0) {
				if (!fillStream(p, 3)) {
					return;
				}
				p.stream.writeByte(0);
				directFlushStream(p);
			} else if (p.loginStage == -5) {
				if (!fillStream(p, 8)) {
					return;
				}
				for (int i = 0; i < Misc.uKeys.length; i++) {
					p.stream.writeByte(Misc.uKeys[i]);
				}
				directFlushStream(p);
				p.loginStage = -1;
			}
		} catch (Exception exception) {}
	}

	/**
	 * Make sure the player isn't already online.
	 * @param name The name to compare with.
	 * @param _p The Player which the frame should be created for.
	 */
	private boolean playerOnline(String name, Player _p) {
		for (Player p : Engine.players) {
			if (p != null && _p.playerId != p.playerId) {
				if (p.username.equalsIgnoreCase(name)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Checks if a user is banned.
	 * @param username The name to check.
	 * @return Returns if the name was found.
	 */
	public boolean checkBannedUsers(String username) {
		if (username == null) {
			return true;
		}
		for (int i = 0; i < Server.bannedUsers.length; i++) {
			if (Server.bannedUsers[i] != null
					&& username.equalsIgnoreCase(Server.bannedUsers[i])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Check and read any incoming bytes.
	 * @param p The Player which the frame should be created for.
	 * @param forceRead How many bytes to read from the buffer.
	 */
	private boolean fillStream(Player p, int forceRead) throws Exception {
		if (p == null) {
			return false;
		}
		if (forceRead >= 500) {
			return false;
		}
		if (p.socket.avail() < forceRead) {
			return false;
		}
		p.stream.inOffset = 0;
		p.socket.read(forceRead);
		return true;
	}

	/**
	 * Send the bytes in the stream's outBuffer directly to the client.
	 * @param p The Player which the frame should be created for.
	 */
	private void directFlushStream(Player p) {
		if (p == null) {
			return;
		}
		try {
			p.socket.write(p.stream.outBuffer, 0, p.stream.outOffset);
			p.stream.outOffset = 0;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
