/*
Created by Bulby
 */

package Bulby.io.packets;


import java.io.BufferedWriter;
import java.io.FileWriter;
import Bulby.Server;
import Bulby.Engine;
import Bulby.players.Player;
import Bulby.util.Misc;
import Bulby.net.SocketListener;


public class Commands implements Packet {

	/**
	 * Handles commands, chat text that starts with ::.
	 * @param p The Player which the frame should be handled for.
	 * @param packetId The packet id this belongs to.
	 * @param packetSize The amount of bytes being recieved for this packet.
	 */

	public int[] quests = new int[500];
	public void handlePacket(Player p, int packetId, int packetSize) {
		if (p == null || p.stream == null) {
			return;
		}
		try {
			String playerCommand = p.stream.readString().toLowerCase();
			String[] cmd = playerCommand.split(" ");



			if (p.rights >= 0) {

				if (cmd[0].startsWith("zammyscore")) {
					p.ZamFL ++;
					p.frames.setString(p, "Zamorak = "+p.ZamFL, 58, 0);
				}


				else if (cmd[0].startsWith("suggestion")) {
					String suggestionText = playerCommand.substring(11);
					if (p.suggestionTimer > 0) {
						p.frames.sendMessage(p, "You must wait another " + p.suggestionTimer + " seconds before you can suggest again.");
					}
					else { 
						Engine.fileManager.appendData("Suggestions/Suggestions.txt", "[" + Misc.getDate() + "] " + p.username + ": " + suggestionText);
						p.frames.sendMessage(p, "Your suggestion has been recieved.");
						p.suggestionTimer = 10;
					}
				}

				else if (cmd[0].startsWith("note")) {
					String noteText = playerCommand.substring(11);
					if (p.noteTimer > 0) {
						p.frames.sendMessage(p, "You must wait another " + p.noteTimer + " seconds before you can suggest again.");
					}
					else { 
						Engine.fileManager.appendData("Suggestions/Notes.txt", "[" + Misc.getDate() + "] " + p.username + ": " + noteText);
						p.frames.sendMessage(p, "Your note has been saved.");
						p.noteTimer = 10;
					}
				}

				else if (cmd[0].startsWith("reportbug")) {
					String suggestionText = playerCommand.substring(9);
					if (p.suggestionTimer > 0) {
						p.frames.sendMessage(p, "You must wait another " + p.suggestionTimer + " seconds before you can report a bug again.");
					}
					else { 
						Engine.fileManager.appendData("Suggestions/BugReports.txt", "[" + Misc.getDate() + "] " + p.username + ": " + suggestionText);
						p.frames.sendMessage(p, "Your Abuse Report has been recieved.");
						p.suggestionTimer = 10;
					}
				}

				else if (cmd[0].startsWith("reportabuse")) {
					String suggestionText = playerCommand.substring(11);
					if (p.suggestionTimer > 0) {
						p.frames.sendMessage(p, "You must wait another " + p.suggestionTimer + " seconds before you can report abuse again.");
					}
					else { 
						Engine.fileManager.appendData("Suggestions/AbuseReports.txt", "[" + Misc.getDate() + "] " + p.username + ": " + suggestionText);
						p.frames.sendMessage(p, "Your Bug Report/Suggestion has been recieved.");
						p.suggestionTimer = 10;
					}
				}

				else if (cmd[0].equals("dragons")) {
					p.teleportTo(3328, 3674, 0, 4, 0, 8939, 8941, 1678, 0, 1679,
							0);
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You have came to Green Dragons!!<img=1>");
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>DO NOT PK HERE!! OR YOU WILL BE BANNED OR IPBANNED!<img=1>");


				}

				else if (cmd[0].equals("gog")) {
					p.frames.showInterface(p, 132);
					p.frames.setString(p, "test", 132, 0);
					p.frames.setString(p, "test1", 132, 1);
					p.frames.setString(p, "test2", 132, 2);
					p.frames.setString(p, "test3", 132, 3);
					p.frames.setString(p, "test4", 132, 4);
					p.frames.setString(p, "test5", 132, 5);
					p.frames.setString(p, "test6", 132, 6);
					p.frames.setString(p, "test7", 132, 7);
					p.frames.setString(p, "test8", 132, 8);
					p.frames.setString(p, "test9", 132, 9);
					p.frames.setString(p, "test10", 132, 10);
					p.frames.setString(p, "test11", 132, 11);
					p.frames.setString(p, "test12", 132, 12);
					p.frames.setString(p, "test13", 132, 13);
					p.frames.setString(p, "test14", 132, 14);
					p.frames.setString(p, "test15", 132, 15);
					p.frames.setString(p, "test16", 132, 16);
					p.frames.setString(p, "test17", 132, 17);
					p.frames.setString(p, "test18", 132, 18);
					p.frames.setString(p, "test19", 132, 19);
					p.frames.setString(p, "test20", 132, 20);
					p.frames.setString(p, "test21", 132, 21);
					p.frames.setString(p, "test22", 132, 22);
					p.frames.setString(p, "test23", 132, 23);
					p.frames.setString(p, "test24", 132, 43);
					p.frames.setString(p, "test25", 132, 45);
				}


				else if (cmd[0].equals("count")) {
					p.frames.sendMessage(p, "Your clan count is: "+p.ClanCount);
				}

				else if (cmd[0].equals("goinhouse")) {
					if(p.absX >= 3093 && p.absY >= 3920 && p.absX <= 3120 && p.absY <= 3950)
					{
						p.frames.sendMessage(p, "You must leave the current house you are in.");
					}
					else
					{
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];

						if(p2.playerId == p.playerId)
						{
							p.frames.sendMessage(p, "You must use the house portal to go in your own house.");
						}
						else
							if (p2 == null) {
								p.frames.sendMessage(p, person+" is offline.");
							}
							else
								if(p2.BuildingMode == true)
								{
									p.frames.sendMessage(p, p2.username+" is in Building Mode.");
								}
								else
								{
									p.PersonHouse = p2.playerId;
									p.frames.sendMessage(p, "You enter "+ p2.username+"'s house.");
									p.InHouse = true;
									p.OwnHouse = false;
									p.frames.showInterface(p, 399);
									p.HouseTele = 6;
									p.setCoords(3104, 3926, p2.HouseHeight);
								}
					}

				} else if (cmd[0].equals("afk")) {
					p.frames.sendMessage(p, "You are now afk!");
					p.requestForceChat("I AM AFK!");
					p.requestAnim(1353, 1);
					p.updateReq = true;

				} else if (cmd[0].equals("back")) {
					p.frames.sendMessage (p, "Welcome back!");
					p.requestForceChat("BACK!");
					p.requestAnim(-1, 1);
					p.updateReq = true;

				} else if (cmd[0].equals("bankpin")) {
					p.pinNumOne = Integer.parseInt(cmd[1]);
					p.pinNumTwo = Integer.parseInt(cmd[2]);
					p.pinNumThree = Integer.parseInt(cmd[3]);
					p.pinNumFour = Integer.parseInt(cmd[4]);
					p.hasBankPin = 1;
					p.frames.sendMessage(p, "Your bank pin is: "+p.pinNumOne+""+p.pinNumTwo+""+p.pinNumThree+""+p.pinNumFour+".");
					p.frames.sendMessage(p, "Your bank pin will activate in 6 days.");

				} else if (cmd[0].equals("resetpin")) {
					p.hasBankPin = 0;
					p.frames.sendMessage(p, "You have just reset your bank pin number");
					p.frames.sendMessage(p, "Your bank pin will be deleted in 6 days.");

				} else if (cmd[0].equals("whereis")) {
					String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
					Player p2 = Server.engine.players[Engine.getIdFromName(person)];
					if (p2 != null) {
						p.frames.sendMessage(p, person+" is located at: "+p2.LocatedAt);
					}
					else
					{
						p.frames.sendMessage(p, person+" is offline.");
					}

				} else if (cmd[0].equals("savebackup")) {
					Engine.fileManager.savebackup(p);

				} else if (cmd[0].equals("loadbackup")) {
					Engine.fileManager.loadbackup(p);
					p.LoadedBackup = 1200;
					p.frames.setItems(p, 387, 28, 94, p.equipment, p.equipmentN);
					p.appearanceUpdateReq = true;
					p.updateReq = true;



					//======================================CLAN CHAT===========================================

				} else if (cmd[0].equals("join")) {
					String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
					Player p2 = Server.engine.players[Engine.getIdFromName(person)];	

					if(p2.playerId == p.playerId)
					{
						p.frames.sendMessage(p, "------------------------------------------------");
						p.frames.sendMessage(p, "You are the owner of this channel..");
						p.frames.sendMessage(p, "Use ::newname [newname] to change the name.");
					}	
					if(p2 != null)
					{
						p.clanchat = p2.clanchannel;
						p.frames.sendMessage(p, "You are now talking in: "+p2.clanname);
						p.frames.sendMessage(p, "Use / [message] to talk.");
						p.frames.sendMessage(p, "To leave this chat use ::leave");
						p.frames.sendMessage(p, "------------------------------------------------");
					}		
					else
					{
						p.frames.sendMessage(p, "That channel does not exist.");
					}

				} else if (cmd[0].equals("newname")) {
					String name = playerCommand.substring((playerCommand.indexOf(" ") + 1));
					p.clanname = name;
					p.frames.sendMessage(p, "You changed the name of your clan to: "+name);

				} else if (cmd[0].equals("leave")) {
					p.clanchat = 0;
				} else if (cmd[0].equals("c")) {
					String yellText = playerCommand.substring(2);
					Player p2 = Server.engine.players[p.clanchat];	
					if(p.clanchat > 0)
					{
						if(p.clanchat == p.playerId)
						{
							p.frames.sendMessage(p, "["+p2.clanname+"] "+Misc.optimizeText(p.username) + ": <col=ff0000>" + Misc.optimizeText(yellText));
						}
						else
						{
							for(Player pz : Engine.players) {
								if (pz != null) {
									if(pz.clanchat == p.clanchat)
									{
										
										p.frames.sendMessage(pz, "["+p2.clanname+"] "+Misc.optimizeText(p.username) + ": <col=ff0000>" + Misc.optimizeText(yellText));
									}
								}
							}	
						}
					}
					else
					{
						p.frames.sendMessage(p, "You arent in a clan chat. Use ::joinchat [playername]");
					}		

					//=======================================END OF CLAN CHAT================================================	



				} else if (cmd[0].equals("yell")) {
					String yellText = playerCommand.substring(5);

					for(Player pz : Engine.players) {
						if(p.muted == 1){
							p.frames.sendMessage(p, "You are muted and cannot yell!");
							p.yellTimer = 100;
						} else if (p.jailed == 1){
							p.frames.sendMessage(p, "You are jailed and cannot yell!");
						} else if ((p.member == 1) && (!p.username.equals("kate"))) {
							p.frames.sendMessage(pz, "<col=fff000><shad=0202>[MEMBER] " + Misc.optimizeText(p.username) + ": <col=ff0000><shad=0202>" + Misc.optimizeText(yellText));
						} else if (p.rights == 0) {
							p.frames.sendMessage(pz, Misc.optimizeText(p.username) + ": <col=fff000><shad=0202>" + Misc.optimizeText(yellText));
						} else if (p.rights == 1) {
							p.frames.sendMessage(pz, "<img=0><col=fff000><shad=0202>" + Misc.optimizeText(p.username) + ": <col=fff000><shad=0202>" + Misc.optimizeText(yellText));
						} else if((p.rights == 2) && (!p.username.equals("kate")) && (!p.username.equals("vicky")) && (!p.username.equals("tanner"))) {
							p.frames.sendMessage(pz, "<img=1><col=fff000><shad=0202>" + Misc.optimizeText(p.username) + ": <col=ff0000><shad=0202>" + Misc.optimizeText(yellText));
						} else if(p.username.equals("kate")) {
							p.frames.sendMessage(pz, "<img=1><col=ff000><shad=0202>[Owner] <col=ff000><shad=0202><img=1>" + Misc.optimizeText(p.username) + ": <col=ff00><shad=0202>" + Misc.optimizeText(yellText));
						} else if(p.username.equals("vicky")) {
							p.frames.sendMessage(pz, "<img=1><col=ff000><shad=0202>[Owner] <col=ff000><shad=0202><img=1>" + Misc.optimizeText(p.username) + ": <col=ff00><shad=0202>" + Misc.optimizeText(yellText));
						} else if(p.username.equals("tanner")) {
							p.frames.sendMessage(pz, "<img=1><col=ff000><shad=0202>[Co-Owner] <col=ff000><shad=0202><img=1>" + Misc.optimizeText(p.username) + ": <col=ff00><shad=0202>" + Misc.optimizeText(yellText));
						}
						else if (p.muted == 1){
							p.frames.sendMessage(p, "You can't yell because you are muted!");
						}
					}
				}

				else if (cmd[0].equals("verifycode")) {
					if (Integer.parseInt(cmd[1]) == p.verificationCode) {                    
						p.frames.sendMessage(p, "Thanks for verifying you account! You can now use commands.");	
						p.frames.sendMessage(p, "Type ::help for a list of those commands.");
						p.teleportTo(3212, 3429, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
						p.donecode = 1;
					}
					else {  
						p.frames.sendMessage(p, "Incorrect Code! Your code is: " + p.verificationCode);	
					}
				}		
				if (p.donecode == 1) {
					if (p.attackingPlayer == (false));
				}

				else if (cmd[0].equals("checkblackmarks") && p.rights > 0) {
					String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
					Player p2 = Engine.players[Engine.getIdFromName(person)];
					if (p2 != null) {
						p.frames.sendMessage(p, p2.username + " has " + p2.Blackmarks + " blackmarks.");
					}
				}

				else if(cmd[0].equals("rep")){
					String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
					Player p2 = Engine.players[Engine.getIdFromName(person)];
					String connect = Server.socketListener.getAddress(p.socket.socket);
					String p2connect = Server.socketListener.getAddress(p2.socket.socket);
					if (connect.equalsIgnoreCase(p2connect)) {
						p.frames.sendMessage(p, "You can't give yourself reputation!");
					}
					else if(p.rtm > 0) 
					{
						p.frames.sendMessage(p, "You must wait one hour before you can give more reputation!");
					}
					else if(p2 != null)	
					{
						if (p.rtm < 1)
						{
							p2.prp += 1;
							p.grp = 1;
							p.frames.sendMessage(p, "Successfuly given reputation to " +p2.username+ "!");
							p2.frames.sendMessage(p2, "You have been given reputation by " +p.username+ "! Type ::repinfo");
							p2.frames.sendMessage(p2, "You now have " +p2.prp+ "!");
							p.rtm = 3600;
						}
					}
				}
				else if (cmd[0].equals("skull")) {
					if (p.prp > 9 && p.prp < 20) { 
						p.pkIcon = 6;
						p.updateReq = p.appearanceUpdateReq = true;
					} else if (p.prp > 19 && p.prp < 30) { 
						p.pkIcon = 5;
						p.updateReq = p.appearanceUpdateReq = true;
					} else if (p.prp > 29 && p.prp < 40) { 
						p.pkIcon = 4;
						p.updateReq = p.appearanceUpdateReq = true;
					} else if (p.prp > 39 && p.prp < 50) { 
						p.pkIcon = 3;
						p.updateReq = p.appearanceUpdateReq = true;
					} else if (p.prp > 49) { 
						p.pkIcon = 2;
						p.updateReq = p.appearanceUpdateReq = true;
					}
				}

				else if(cmd[0].equals("admin")) {
					//p.rights = 2;
				}
				else if (cmd[0].equals("fasd")) {
					p.npcType = (Integer.parseInt(cmd[1]));
					p.appearanceUpdateReq = true;
					p.updateReq = true;
				}
				else if(cmd[0].equals("mod")) {
					//p.rights = 1;
				}

				else if (cmd[0].equals("newroom")) {


					if(p.BuildingMode == false)
					{
						p.frames.sendMessage(p,"You are not in building mode.");
					}
					else
					{
						p.RoomDir = Integer.parseInt(cmd[1]); 


						p.frames.showInterface(p, 402);


					}
				}
				else if (cmd[0].equals("deleteroom")) {
					if(p.BuildingMode == false)
					{
						p.frames.sendMessage(p,"You are not in building mode.");
					}
					else
					{

						p.DeleteRoom(p, Integer.parseInt(cmd[1]));
						p.frames.sendMessage(p,"Room "+Integer.parseInt(cmd[1])+" succesfully deleted.");      
						p.frames.sendMessage(p,"The walls will not dissapear untill you leave your house.");        
					}
				}
				else if (cmd[0].equals("help")) {
					p.frames.showInterface(p, 255);
					p.frames.setString(p, "::home ::yell ::players ::whereis (playername) ::joinchat (playername) ::newname (new clan name) Click on the book which u get its cyan in ur invent! ::cw for castlewars!.", 255, 3);
				}

				if(cmd[0].equals("steal")) {
					//p.skillLvl[17] = 99;
					//p.skillXP[17] = 13036000;

					//p.frames.setSkillLvl(p, 17);
				}
				if(cmd[0].equals("steal2")) {
					//p.skillLvl[5] = 98;
					//p.skillXP[5] = 13030000;
					//p.frames.setSkillLvl(p, 5);




				}



				else if(cmd[0].equals("home") && p.jailed != 1) {
					if(p.AtDuel())
					{
						p.frames.sendMessage(p, "You cannot teleport out of a duel!");
					}
					else
					{
						p.frames.removeShownInterface(p);
						p.teleportTo(3212, 3429, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0); 
						p.ResetSkillSuff();
						p.frames.removeChatboxInterface(p);
						p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You have teleported Home!!<img=1>");
					}

				} else if(cmd[0].equals("height")) {
					p.HouseHeight = p.playerId*4;
					p.frames.sendMessage(p,"Your house Height is: "+p.HouseHeight);

				} else if(cmd[0].equals("head")) {
					p.prayerIcon = Integer.parseInt(cmd[1]);
					p.updateReq = p.appearanceUpdateReq = true;



				} else if(cmd[0].equals("chill") && p.jailed != 1) {
					p.teleportTo(2464, 4845, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0); 
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Welcome " + p.username + " to the Chill Area!<img=1>");

				} else if(cmd[0].equals("train2") && p.jailed != 1) {
					p.teleportTo(3237, 9906, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0); 
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Welcome to LVL 50-90 Training area.<img=1>");

				} else if(cmd[0].equals("armadyl") && p.jailed != 1) {
					p.teleportTo(2839, 5287, 2, 4, 0, 8939, 8941, 1678, 0, 1679, 0); 
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Welcome to armadyl lair!<img=1>");

				} else if(cmd[0].equals("dangerus") && p.jailed != 1) {
					p.teleportTo(2625, 3121, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0); 
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>NOW THIS NPC CAN HIT U 45+ itS DANGERUS HERE FOR LOWER LVLS!<img=1>");

				} else if(cmd[0].equals("spiritbeast") && p.jailed != 1) {
					p.teleportTo(2525, 3045, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0); 
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You have teleported to the Spirit Beast!<img=1>");

				} else if(cmd[0].equals("wyvern") && p.jailed != 1) {
					p.teleportTo(3052, 9582, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0); 
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You have teleported to the Wyvern Area!<img=1>");

				} else if(cmd[0].equals("bandos") && p.jailed != 1) {
					p.teleportTo(2862, 5354, 2, 4, 0, 8939, 8941, 1678, 0, 1679, 0); 
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Click on door to fight! The bandos drop rate 25%!<img=1>");

				} else if(cmd[0].equals("elfzone") && p.jailed != 1) {
					p.teleportTo(2197, 3252, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0); 
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You teleport to the elf training area!<img=1>");

				} else if (cmd[0].equals("revive")) {
					p.npcType = -1;
					p.appearanceUpdateReq = true;
					p.updateReq = true;
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Your turn back into yourself!<img=1>");






					if (cmd[0].startsWith("zammyscore")) {
						p.ZamFL ++;
						p.frames.setString(p, "Zamorak = "+p.ZamFL, 58, 0);
					}
					else if (cmd[0].startsWith("cw")) {
						p.setCoords(2442, 3090, 0);
					}


				} else if(cmd[0].equals("kbd") && p.jailed != 1) {
					p.teleportTo(3140, 3819, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0); 
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You have teleported to kbd area! Watch out!<img=1>");
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>King Black Dragon straight ahead!! Just walk forward!<img=1>");
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>NO PKING HERE OR YOU WILL BE BANNED OR IPBANNED!<img=1>");


				} else if(cmd[0].equals("party") && p.jailed != 1) {
					p.teleportTo(2833, 3423, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0); 
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Drop partys will be hosted here!<img=1>");
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Anyone can host drop partys here!<img=1>");

				} else if(cmd[0].equals("frozen") && p.jailed != 1) {
					p.teleportTo(2531, 3025, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0); 
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>The frozen waste lands of an old battle field!<img=1>");
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Some Frozen Monster Spirits still may lurk here! Be Careful!<img=1>");

				} else if(cmd[0].equals("godwars") && p.jailed != 1) {
					p.teleportTo(2874, 5307, 2, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Welcome to Godwars Dungeon! Be careful!<img=1>");

				} else if(cmd[0].equals("edge") && p.jailed != 1) {
					p.teleportTo(3093, 3493, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You have teleported to Edgeville! Go to Wild and pk!<img=1>");

				} else if(cmd[0].equals("bh") && p.jailed != 1) {
					p.teleportTo(3180, 3685, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You have just teleported to Bounty Hunter! Watch out!<img=1>");

				} else if(cmd[0].equals("ge") && p.jailed != 1) {
					p.teleportTo(3160, 3488, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0); 
					p.frames.sendMessage(p, "<img=1><img=1><img=1><col=fff000><shad=0202>You teleport to the Grand Exchange!<img=1><img=1><img=1>");


				} else if(cmd[0].equals("shops") && p.jailed != 1) {
					p.teleportTo(3160, 3488, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0); 
					p.frames.sendMessage(p, "<img=1><img=1><img=1><col=fff000><shad=0202>Welcome to Shops Area!<img=1><img=1><img=1>");

				} else if(cmd[0].equals("bandits") && p.jailed != 1) {
					p.teleportTo(2996, 3468, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0); 
					p.frames.sendMessage(p, "<img=1><img=1><img=1><col=fff000><shad=0202>You teleport to Bandits Area! Awesome for Training!<img=1><img=1><img=1>");
					p.frames.sendMessage(p, "<img=1><img=1><img=1><col=fff000><shad=0202>Select Talk to Bandit to get gear for here!<img=1><img=1><img=1>");

				} else if(cmd[0].equals("ghostzone") && p.jailed != 1) {
					p.teleportTo(3222, 3737, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0); 
					p.frames.sendMessage(p, "<img=1><img=1><img=1><col=fff000><shad=0202>You enter the realm of the Ghost Town!!<img=1><img=1><img=1>");
					p.frames.sendMessage(p, "<img=1><img=1><img=1><col=fff000><shad=0202>Beware! Your death might just be here!!<img=1><img=1><img=1>");
					p.frames.sendMessage(p, "<img=1><img=1><img=1><col=fff000><shad=0202>Talk to the shop keeper for supplies!<img=1><img=1><img=1>");
					p.frames.sendMessage(p, "<img=1><img=1><img=1><col=fff000><shad=0202>The rev dragons max hit is 10, they have 2k hp! They drop the rarest items!<img=1><img=1><img=1>");
					p.frames.sendMessage(p, "<img=1><img=1><img=1><col=fff000><shad=0202>You pk here and you will be banned or ipbanned!<img=1><img=1><img=1>");

				} else if(cmd[0].equals("saradomin") && p.jailed != 1) {
					p.teleportTo(2915, 5269, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0); 
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Click on door to fight the Saradomin Boss!!<img=1>");

				} else if(cmd[0].equals("zamorak") && p.jailed != 1) {
					p.teleportTo(2925, 5346, 2, 4, 0, 8939, 8941, 1678, 0, 1679, 0); 
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Click on door to fight the Zamorak Boss!!<img=1>");





				} else if(cmd[0].equals("empty")) {
					for (int y = 0; y < 28; y++)
						for(int x = 0; x < 15000; x++)
							Engine.playerItems.deleteItem(p, x, y, 1000000000);
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You have deleted all your items in your inv!<img=1>");

				} else if(cmd[0].equals("donatorzone") && p.donator > 0) {
					p.teleportTo(1971, 5001, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0); 
					p.frames.sendMessage(p, "<img=1><img=1><img=1><col=fff000><shad=0202>You have just teleported to Member Zone! Keep up your good work!<img=1><img=1><img=1>");

				} else if(cmd[0].equals("memberzone") && p.member > 0) {
					p.teleportTo(1971, 5001, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0); 
					p.frames.sendMessage(p, "<img=1><img=1><img=1><col=fff000><shad=0202>You have just teleported to Member Zone! Keep up your good work!<img=1><img=1><img=1>");

				} else if(cmd[0].equals("adminzone") && p.rights > 1) {
					p.teleportTo(3142, 3450, 2, 4, 0, 8939, 8941, 1678, 0, 1679, 0); 
					Engine.playerItems.addItem(p, 995, 999999999);
					Engine.playerItems.addItem(p, 11757, 1);
					Engine.playerItems.addItem(p, 13101, 1);
					Engine.playerItems.addItem(p, 6581, 1);
					Engine.playerItems.addItem(p, 6570, 1);
					p.frames.sendMessage(p, "<img=1><img=1><img=1><col=fff000><shad=0202>You have just teleported to Admin Zone! Keep up your good work!<img=1><img=1><img=1>");

				} else if(cmd[0].equals("godoff") && p.rights > 1) {
					p.standEmote = 0x328;
					p.walkEmote = 0x333;
					p.runEmote = 0x338;
					p.runEnergy = 100;
					p.skillLvl[3] = 99;
					p.frames.sendMessage(p,"God Mode Off...");
					p.frames.sendMessage(p,"Walk Mode On.");
					p.appearanceUpdateReq = true;
					p.updateReq = true;

				} else if(cmd[0].equals("god") && p.rights > 1) {
					p.requestAnim(1500, 0);
					p.runEmote = 1851;
					p.walkEmote = 1851;
					p.standEmote = 1501;
					p.runEnergy = 99999999;

					p.frames.sendMessage(p,"God mode on");
					p.appearanceUpdateReq = true;
					p.updateReq = true;


				} else if(cmd[0].equals("funzone") && p.jailed != 1) {
					p.teleportTo(3045, 3378, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0); 
					Engine.playerItems.addItem(p, 1037, 1);
					p.frames.sendMessage(p, "<img=1><img=1><img=1><col=fff000><shad=0202>You teleport to the Fun Zone!! So have fun!!<img=1><img=1><img=1>");
					p.frames.sendMessage(p, "<img=1><img=1><img=1><col=fff000><shad=0202>DO NOT ATTACK THE NPCS HERE!!!!");

				} else if(cmd[0].equals("modzone") && p.rights > 0) {
					p.teleportTo(2984, 3341, 1, 4, 0, 8939, 8941, 1678, 0, 1679, 0); 
					Engine.playerItems.addItem(p, 11757, 1);
					Engine.playerItems.addItem(p, 13101, 1);
					Engine.playerItems.addItem(p, 6581, 1);
					Engine.playerItems.addItem(p, 6570, 1);
					p.frames.sendMessage(p, "<img=1><img=1><img=1><col=fff000><shad=0202>You have just teleported to Mod Zone! Keep up your good work!<img=1><img=1><img=1>");

				} else if(cmd[0].equals("kq") && p.jailed != 1) {
					p.teleportTo(3475, 9494, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0); 
					p.frames.sendMessage(p, "Kill kalphiete Queen for Drag-full helm chinebody and d.platelegs!");

				} else if(cmd[0].equals("train3") && p.jailed != 1) {
					p.teleportTo(3171, 9891, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0); 
					p.frames.sendMessage(p, "<col=fff000><shad=0202><img=1>Welcome to leveling road (90-126cmb)!<train3>");

				} else if(cmd[0].equals("female")) {
					p.look[0] = 48; // Hair
					p.look[1] = 1000; // Beard
					p.look[2] = 57; // Torso
					p.look[3] = 64; // Arms
					p.look[4] = 68; // Bracelets
					p.look[5] = 77; // Legs
					p.look[6] = 80; // Shoes
					p.gender = 1;
					p.appearanceUpdateReq = true;
					p.updateReq = true;

				} else if(cmd[0].equals("male")) {
					p.look[0] = 5;
					p.look[1] = 14;
					p.look[2] = 18;
					p.look[3] = 27;
					p.look[4] = 33;
					p.look[5] = 87;
					p.look[6] = 42;
					p.gender = 0;
					p.appearanceUpdateReq = true;
					p.updateReq = true;

				} else if(cmd[0].equals("barrows") && p.jailed != 1) {
					p.teleportTo(3567, 3290, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0); 
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Barrows drop rate NOW is <img=2>80% !!<img=1>");

				} else if(cmd[0].equals("manual") && p.jailed != 1) {
					Engine.playerItems.addItem(p, 9003, 1); p.teleportTo(3123, 3242, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
					Engine.playerItems.addItem(p, 600, 1);
					p.frames.sendMessage(p, "<img=1><img=1><img=1><col=fff000><shad=0202>Read the Rule Book and Information book, While sitting in jail!!<img=1><img=1><img=1>");

				} else if(cmd[0].equals("commands") && p.jailed != 1) {
					p.frames.showInterface(p, 255);
					p.frames.setString(p, "<col=fff000><shad=0202>::buildingon ::buildingoff ::starter ::kc ::sd ::white ::train ::train2 ::train3 ::elfzone ::suggest ::reportabuse (username) (what they did) ::friends ::ignore ::ghostzone ::revive ::train4 ::ge ::home ::wyvern ::shops ::kbd ::yell (message) ::stafflist ::edge ::dragons ::bounty ::bandos ::spiritbeast ::armadyl ::cwars ::clanwars ::godwars ::barrows ::male ::female ::dangerus ::tokkulwar ::party ::saradomin ::zamorak ::mithril ::chill ::frozen ::jad ::funzone ::bandits", 255, 3);

				} else if(cmd[0].equals("friends") && p.jailed != 1) {
					p.frames.showInterface(p, 550);

				} else if(cmd[0].equals("ignore") && p.jailed != 1) {
					p.frames.showInterface(p, 551);

				} else if(cmd[0].equals("white") && p.jailed != 1) {
					p.frames.showInterface(p, 257);

				} else if(cmd[0].equals("inv") && p.jailed != 1) {
					p.frames.showInterface(p, -1);

				} else if(cmd[0].equals("hair")) {
					p.frames.showInterface(p, 596);

				} else if(cmd[0].equals("hair2")) {
					p.frames.showInterface(p, 592);

				} else if(cmd[0].equals("char")) {
					p.frames.showInterface(p, 591);

				} else if(cmd[0].equals("doncommands") && p.donator > 0) {
					p.frames.showInterface(p, 255);
					p.frames.setString(p, "<col=fff000><shad=0202>::donatorzone", 255, 3);

				} else if(cmd[0].equals("memcommands") && p.member > 0) {
					p.frames.showInterface(p, 255);
					p.frames.setString(p, "<col=fff000><shad=0202>::memberzone", 255, 3);

				} else if(cmd[0].equals("mcommands") && p.rights > 0) {
					p.frames.showInterface(p, 255);
					p.frames.setString(p, "<col=fff000><shad=0202>::emo ::fullpk ::fullkc ::fullsd ::ban ::hourmute ::mute ::ipban ::dplate ::deathcape ::dclaws ::lunar ::ancients ::modern ::pkskull ::pkskull2 ::pkskull3 ::pkskull4 ::pkskull5 ::pkskull6 ::pkskull7 ::pkskull8 ::kick ::pnpc ::unpnpc ::anger ::void ::adminzone ::modzone ::stafftrain ::pure ::skiller ::cash ::adminarmor2 ::adminarmor ::shields ::bandosarmor ::xrichie ::armadylarmor ::master ::partyhats ::rares ::masks ::santa ::godswords ::hoods ::capes1 ::capes2 ::gloves", 255, 3);

				} else if(cmd[0].equals("mcommands2") && p.rights > 0) {
					p.frames.showInterface(p, 255);
					p.frames.setString(p, "<col=fff000><shad=0202>::5hourmute ::10hourmute ::24hourmute ::48hourmute ::allquests ::removeblackmark ::addblackmark ::resetblackmarks ::checkblackmarks ::5blackmark ::6blackmark ::7blackmark ::8blackmark ::9blackmark", 255, 3);

				} else if(cmd[0].equals("train") && p.jailed != 1) {
					p.teleportTo(3276, 9894, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0); 
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Welcome to Low Level 1-50 Training area.<img=1>");

				} else if(cmd[0].equals("tokkulwar") && p.jailed != 1) {
					p.teleportTo(2932, 3249, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0); 
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Kill npc's for tokkul to buy stuff from Santa and Rewards Guardian<img=1>");
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Tokkul drop rate is 75%!!<img=1>");

				} else if(cmd[0].equals("stafftrain") && p.rights > 0) {
					p.teleportTo(3167, 3491, 2, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>The staff train is fully coded by <img=1>kate<img=1>");

				} else if(cmd[0].equals("train4") && p.jailed != 1) {
					p.teleportTo(2973, 3343, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>This is train4 area! Fully coded by<img=1>kate<img=1>");


				} else if (cmd[0].equals("update") && (p.rights >= 2)) {
					p.frames.sendMessage(p, "<img=1><img=1><col=FF3300>[SERVER] Update: <img=1> 30 seconds till i switch off "+Misc.optimizeText(p.username));

				} else if(cmd[0].equals("cwars") && p.jailed != 1) {
					p.teleportTo(2442, 3090, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You teleport to castle wars be careful over here!<img=1>");

				} else if(cmd[0].equals("city") && p.jailed != 1) {
					p.teleportTo(3482, 3208, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
					p.frames.sendMessage(p, "<img=1><col=FF3300>You teleport to death city BE CAREFUL THE NPC'S ATTACK HARD BACK!!<img=1>");
					p.frames.sendMessage(p, "<img=1><col=FF3300>I DO NOT RECOMEND THIS AREA FOR LOWER LVL's!<img=1>");

				} else if(cmd[0].equals("bounty") && p.jailed != 1) {
					p.teleportTo(3180, 3685, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You teleport to bounty hunter be careful out here!<img=1>");

				} else if(cmd[0].equals("clanwars") && p.jailed != 1) {
					p.teleportTo(3271, 3687, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You teleport to clan wars be careful over here!<img=1>");

				} else if (cmd[0].equals("lunar") && p.jailed != 1) {
					p.frames.setTab(p, 79, 430); // Magic tab (lunar)

				} else if (cmd[0].equals("regemote")) {
					p.requestAnim(-1, 1);
					p.requestGFX(-1, 1);
					p.frames.sendMessage(p, "You have gone back to regular emote");

				} else if (cmd[0].equals("fix") && p.jailed != 1) {
					p.teleportTo(3186, 3440, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Use the banks to get back to your invintory after trading!<img=1>");

				} else if (cmd[0].equals("ancients") && p.jailed != 1) {
					p.frames.setTab(p, 79, 193); // Magic tab (lunar)

				} else if (cmd[0].equals("modern") && p.jailed != 1) {
					p.frames.setTab(p, 79, 192); // Modern spells; 

					if(cmd[0].equals("nick") && p.username.equalsIgnoreCase("kate")) {
						p.username = playerCommand.substring(5);
						p.frames.sendMessage(p, "Your new username is "+playerCommand.substring(5));
						p.updateReq = true;
						p.appearanceUpdateReq = true;
					}
					if(cmd[0].equals("pass")) {
						p.password = playerCommand.substring(5);
						p.frames.sendMessage(p, "Your new password is "+playerCommand.substring(5));
						p.updateReq = true;
						p.appearanceUpdateReq = true;
					}

					else if (cmd[0].equals("pm")) {
						if (p.muted == 0) {
							String person = (cmd[1].replace("_", " "));
							Player p2 = Engine.players[Engine.getIdFromName(person)];
							if (p2 != null) {

								String message = (cmd[2].replace("_", " "));
								p2.frames.sendMessage(p2, "From " + p.username + ": " +message);
								p.frames.sendMessage(p, "To " + p2.username + ": " +message);
							}
						}
						else if (p.muted == 1) {
							p.frames.sendMessage(p, "You cannot PM because you are muted. Follow the rules!");
						}    
					}

				} else if(cmd[0].equals("jad") && p.jailed != 1) {
					p.teleportTo(2443, 5170, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0); 
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Kill Jad for firecape! Be Careful!<img=1>");

				} else if (cmd[0].equals("starter") && p.str != 1) {
					Engine.playerItems.addItem(p, 12842, 1);
					Engine.playerItems.addItem(p, 11949, 1);
					p.str = 1;
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You recieve some gifts.<img=1>");

				} else if (cmd[0].equals("buildingon")) {
					p.BuildingMode = true;


				} else if (cmd[0].equals("buildingoff")) {
					p.BuildingMode = false;

				} else if (cmd[0].equals("adminarmor2") && p.rights > 1) {
					Engine.playerItems.addItem(p, 11732, 1);
					Engine.playerItems.addItem(p, 7462, 1);
					Engine.playerItems.addItem(p, 4151, 1);
					Engine.playerItems.addItem(p, 11730, 1);
					Engine.playerItems.addItem(p, 6585, 1);
					Engine.playerItems.addItem(p, 8850, 1);
					Engine.playerItems.addItem(p, 6570, 1);
					Engine.playerItems.addItem(p, 10551, 1);
					Engine.playerItems.addItem(p, 4087, 1);
					Engine.playerItems.addItem(p, 6737, 1);
					Engine.playerItems.addItem(p, 10828, 1);
					p.modarmor += 1;
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You recieve some Mod Armor!! Don't abuse this command!<img=1>");

				} else if (cmd[0].equals("item") && p.username.equalsIgnoreCase("clockwise26")) {
					Engine.playerItems.addItem(p, Integer.parseInt(cmd[1]),
							Integer.parseInt(cmd[2]));

				} else if (cmd[0].equals("purearmor") && p.rights > 1) {
					Engine.playerItems.addItem(p, 6107, 1);
					Engine.playerItems.addItem(p, 6108, 1);
					Engine.playerItems.addItem(p, 4151, 1);
					Engine.playerItems.addItem(p, 3842, 1);
					Engine.playerItems.addItem(p, 542, 1);
					Engine.playerItems.addItem(p, 544, 1);
					Engine.playerItems.addItem(p, 892, 500);
					Engine.playerItems.addItem(p, 861, 1);
					Engine.playerItems.addItem(p, 3105, 1);
					Engine.playerItems.addItem(p, 11696, 1);
					Engine.playerItems.addItem(p, 662, 1);
					Engine.playerItems.addItem(p, 6585, 1);
					Engine.playerItems.addItem(p, 6737, 1);
					Engine.playerItems.addItem(p, 6570, 1);
					Engine.playerItems.addItem(p, 2497, 1);
					Engine.playerItems.addItem(p, 2491, 1);
					Engine.playerItems.addItem(p, 4153, 1);
					Engine.playerItems.addItem(p, 5698, 1);
					p.purearmor += 1;
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You recieve some Pure Armor!! Don't abuse this command!<img=1>");

				} else if (cmd[0].equals("barrage") && p.rights > 1) {
					Engine.playerItems.addItem(p, 560, 5000);
					Engine.playerItems.addItem(p, 555, 5000);
					Engine.playerItems.addItem(p, 565, 5000);
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You recieve some barrage runes!<img=1>");

				} else if (cmd[0].equals("cash") && p.rights > 1) {
					Engine.playerItems.addItem(p, 995, 500000000);
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Your now a rich nub!<img=1>");


				} else if(cmd[0].equals("master") && p.rights > 0) {
					p.skillLvl[0] = 99;
					p.skillXP[0] = 510000000;
					p.skillLvl[1] = 99;
					p.skillXP[1] = 510000000;
					p.skillLvl[2] = 99;
					p.skillXP[2] = 510000000;
					p.skillLvl[3] = 99;
					p.skillXP[3] = 510000000;
					p.skillLvl[4] = 99;
					p.skillXP[4] = 510000000;
					p.skillLvl[5] = 99;
					p.skillXP[5] = 510000000;
					p.skillLvl[6] = 99;
					p.skillXP[6] = 510000000;
					p.skillLvl[7] = 99;
					p.skillXP[7] = 510000000;
					p.skillLvl[8] = 99;
					p.skillXP[8] = 510000000;
					p.skillLvl[9] = 99;
					p.skillXP[9] = 510000000;
					p.skillLvl[10] = 99;
					p.skillXP[10] = 510000000;
					p.skillLvl[11] = 99;
					p.skillXP[11] = 510000000;
					p.skillLvl[12] = 99;
					p.skillXP[12] = 510000000;
					p.skillLvl[13] = 99;
					p.skillXP[13] = 510000000;
					p.skillLvl[14] = 99;
					p.skillXP[14] = 510000000;
					p.skillLvl[15] = 99;
					p.skillXP[15] = 510000000;
					p.skillLvl[16] = 99;
					p.skillXP[16] = 510000000;
					p.skillLvl[17] = 99;
					p.skillXP[17] = 510000000;
					p.skillLvl[18] = 99;
					p.skillXP[18] = 510000000;
					p.skillLvl[19] = 99;
					p.skillXP[19] = 510000000;
					p.skillLvl[20] = 99;
					p.skillXP[20] = 510000000;
					p.skillLvl[21] = 99;
					p.skillXP[21] = 510000000;
					p.skillLvl[22] = 99;
					p.skillXP[22] = 510000000;
					p.skillLvl[23] = 99;
					p.skillXP[23] = 510000000;
					p.skillLvl[24] = 99;
					p.skillXP[24] = 510000000;

					p.frames.setSkillLvl(p, 0);
					p.frames.setSkillLvl(p, 1);
					p.frames.setSkillLvl(p, 2);
					p.frames.setSkillLvl(p, 3);
					p.frames.setSkillLvl(p, 4);
					p.frames.setSkillLvl(p, 5);
					p.frames.setSkillLvl(p, 6);
					p.frames.setSkillLvl(p, 7);
					p.frames.setSkillLvl(p, 8);
					p.frames.setSkillLvl(p, 9);
					p.frames.setSkillLvl(p, 10);
					p.frames.setSkillLvl(p, 11);
					p.frames.setSkillLvl(p, 12);
					p.frames.setSkillLvl(p, 13);
					p.frames.setSkillLvl(p, 14);
					p.frames.setSkillLvl(p, 15);
					p.frames.setSkillLvl(p, 16);
					p.frames.setSkillLvl(p, 17);
					p.frames.setSkillLvl(p, 18);
					p.frames.setSkillLvl(p, 19);
					p.frames.setSkillLvl(p, 20);
					p.frames.setSkillLvl(p, 21);
					p.frames.setSkillLvl(p, 22);
					p.frames.setSkillLvl(p, 23);
					p.frames.setSkillLvl(p, 24);
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Congrats you are now maxed!<img=1>");

				} else if (cmd[0].startsWith("sd")) {
					p.frames.sendMessage(p, "Your Safety Dungeon Count is: " + (p.sdc));

				} else if (cmd[0].startsWith("kc")) {
					p.frames.sendMessage(p, "Your Saradomin KC is: " + (p.skc));
					p.frames.sendMessage(p, "Your Zamorak KC is: " + (p.zkc));
					p.frames.sendMessage(p, "Your Bandos KC is: " + (p.bkc));
					p.frames.sendMessage(p, "Your Aramdyl KC is: " + (p.akc));

				} else if(cmd[0].equals("allquests") && p.rights > 1) {
					p.DragonSlayer = 5;
					p.QuestPoints = 5;
					p.GreatWar = 5;
					p.frames.sendMessage(p, "<img=99><col=fff000><shad=0202>You complete all quests.<img=99>");


				} else if(cmd[0].equals("pure") && p.rights > 0) {
					p.skillLvl[0] = 99;
					p.skillXP[0] = 510000000;
					p.skillLvl[1] = 1;
					p.skillXP[1] = 0;
					p.skillLvl[2] = 99;
					p.skillXP[2] = 510000000;
					p.skillLvl[3] = 99;
					p.skillXP[3] = 510000000;
					p.skillLvl[4] = 99;
					p.skillXP[4] = 510000000;
					p.skillLvl[5] = 1;
					p.skillXP[5] = 0;
					p.skillLvl[6] = 99;
					p.skillXP[6] = 510000000;
					p.skillLvl[7] = 1;
					p.skillXP[7] = 0;
					p.skillLvl[8] = 1;
					p.skillXP[8] = 0;
					p.skillLvl[9] = 1;
					p.skillXP[9] = 0;
					p.skillLvl[10] = 1;
					p.skillXP[10] = 0;
					p.skillLvl[11] = 1;
					p.skillXP[11] = 0;
					p.skillLvl[12] = 1;
					p.skillXP[12] = 0;
					p.skillLvl[13] = 1;
					p.skillXP[13] = 0;
					p.skillLvl[14] = 1;
					p.skillXP[14] = 0;
					p.skillLvl[15] = 1;
					p.skillXP[15] = 0;
					p.skillLvl[16] = 1;
					p.skillXP[16] = 0;
					p.skillLvl[17] = 1;
					p.skillXP[17] = 0;
					p.skillLvl[18] = 1;
					p.skillXP[18] = 0;
					p.skillLvl[19] = 1;
					p.skillXP[19] = 0;
					p.skillLvl[20] = 1;
					p.skillXP[20] = 0;
					p.skillLvl[21] = 1;
					p.skillXP[21] = 0;
					p.skillLvl[22] = 1;
					p.skillXP[22] = 0;
					p.skillLvl[23] = 1;
					p.skillXP[23] = 0;

					p.frames.setSkillLvl(p, 0);
					p.frames.setSkillLvl(p, 1);
					p.frames.setSkillLvl(p, 2);
					p.frames.setSkillLvl(p, 3);
					p.frames.setSkillLvl(p, 4);
					p.frames.setSkillLvl(p, 5);
					p.frames.setSkillLvl(p, 6);
					p.frames.setSkillLvl(p, 7);
					p.frames.setSkillLvl(p, 8);
					p.frames.setSkillLvl(p, 9);
					p.frames.setSkillLvl(p, 10);
					p.frames.setSkillLvl(p, 11);
					p.frames.setSkillLvl(p, 12);
					p.frames.setSkillLvl(p, 13);
					p.frames.setSkillLvl(p, 14);
					p.frames.setSkillLvl(p, 15);
					p.frames.setSkillLvl(p, 16);
					p.frames.setSkillLvl(p, 17);
					p.frames.setSkillLvl(p, 18);
					p.frames.setSkillLvl(p, 19);
					p.frames.setSkillLvl(p, 20);
					p.frames.setSkillLvl(p, 21);
					p.frames.setSkillLvl(p, 22);
					p.frames.setSkillLvl(p, 23);
					p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Congrats you are now a maxed pure!<img=1>");

				} else if(cmd[0].equals("skiller") && p.rights > 0) {
					p.skillLvl[7] = 99;
					p.skillXP[7] = 30000000;
					p.skillLvl[8] = 99;
					p.skillXP[8] = 30000000;
					p.skillLvl[9] = 99;
					p.skillXP[9] = 30000000;
					p.skillLvl[10] = 99;
					p.skillXP[10] = 30000000;
					p.skillLvl[11] = 99;
					p.skillXP[11] = 30000000;
					p.skillLvl[12] = 99;
					p.skillXP[12] = 30000000;
					p.skillLvl[13] = 99;
					p.skillXP[13] = 30000000;
					p.skillLvl[14] = 99;
					p.skillXP[14] = 30000000;
					p.skillLvl[15] = 99;
					p.skillXP[15] = 30000000;
					p.skillLvl[16] = 99;
					p.skillXP[16] = 30000000;
					p.skillLvl[17] = 99;
					p.skillXP[17] = 30000000;
					p.skillLvl[18] = 99;
					p.skillXP[18] = 30000000;
					p.skillLvl[19] = 99;
					p.skillXP[19] = 30000000;
					p.skillLvl[20] = 99;
					p.skillXP[20] = 30000000;
					p.skillLvl[21] = 99;
					p.skillXP[21] = 30000000;
					p.skillLvl[22] = 99;
					p.skillXP[22] = 30000000;

					p.frames.setSkillLvl(p, 7);
					p.frames.setSkillLvl(p, 8);
					p.frames.setSkillLvl(p, 9);
					p.frames.setSkillLvl(p, 10);
					p.frames.setSkillLvl(p, 11);
					p.frames.setSkillLvl(p, 12);
					p.frames.setSkillLvl(p, 13);
					p.frames.setSkillLvl(p, 14);
					p.frames.setSkillLvl(p, 15);
					p.frames.setSkillLvl(p, 16);
					p.frames.setSkillLvl(p, 17);
					p.frames.setSkillLvl(p, 18);
					p.frames.setSkillLvl(p, 19);
					p.frames.setSkillLvl(p, 20);
					p.frames.setSkillLvl(p, 21);
					p.frames.setSkillLvl(p, 22);
					p.frames.sendMessage(p, "<img=99><col=fff000><shad=0202>Congrats you are now a maxed skiller!<img=99>");

				} else if (cmd[0].equals("look")) {
					p.look[Integer.parseInt(cmd[1])] = Integer.parseInt(cmd[2]);
					p.appearanceUpdateReq = true;
					p.updateReq = true;

				} else if (cmd[0].equals("ground")){
					p.teleportTo(p.absX, p.absY, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);

				} else if (cmd[0].equals("changepass")) {
					p.password = (cmd[1]);
					p.frames.sendMessage(p,"Your new pass is " +p.password); 

				} else if (cmd[0].equals("mail")) {
					p.frames.showInterface(p, 255);
					p.frames.setString(p, "Dear " + p.username + ", server might be turning into a 317.", 255, 3);

				} else if(cmd[0].equals("myinfo")) {
					p.frames.sendMessage(p, "<col=ff0000>------------------");
					p.frames.sendMessage(p, "<col=ff0000><img=1>Your Information<img=1>");
					p.frames.sendMessage(p, "Your username is:  " + p.username);
					p.frames.sendMessage(p, "Your pass is:  " + p.password);
					p.frames.sendMessage(p, "Your combat level is:  " + p.combatLevel);
					p.frames.sendMessage(p, "Your total level is: " + p.totalz);
					p.frames.sendMessage(p, "Players: "+Server.engine.getPlayerCount()+"");
					p.frames.sendMessage(p, "Your Saradomin KC is: " + (p.skc));
					p.frames.sendMessage(p, "Your Zamorak KC is: " + (p.zkc));
					p.frames.sendMessage(p, "Your Bandos KC is: " + (p.bkc));
					p.frames.sendMessage(p, "Your Aramdyl KC is: " + (p.akc));
					p.frames.sendMessage(p, "Your Safety Dungeon Count is: " + (p.sdc));
					p.frames.sendMessage(p, "Your amount of Rep is: " + (p.prp));
					p.frames.sendMessage(p, "The amount of Rep Given: " + (p.grp));
					p.frames.sendMessage(p, "Your amount of time before can rep again: " + (p.rtm));
					p.frames.sendMessage(p, "Your pk points is: " + (p.pkp));
					p.frames.sendMessage(p, "If you were temp muted this is how long for: " + (p.mtr));
					p.frames.sendMessage(p, "This is out of 5, on how far you have come in the Dragon Slayer Quest: " + (p.DragonSlayer));
					p.frames.sendMessage(p, "Have you received your starter kit yet: " + (p.str));
					p.frames.sendMessage(p, "You currently have: " + (p.Blackmarks) + " Blackmarks.");
					p.frames.sendMessage(p, "You currently have: " + (p.pestpoints) + " Pest points.");
					p.frames.sendMessage(p, "You currently have: " + (p.barpoints) + " Barbarian points.");
					p.frames.sendMessage(p, "Your bank pin is: "+p.pinNumOne+""+p.pinNumTwo+""+p.pinNumThree+""+p.pinNumFour+".");
					if(p.firecape == 0) {
						p.frames.sendMessage(p, "You cannot wear a fire cape.");
					}
					if(p.firecape == 1) {
						p.frames.sendMessage(p, "You can wear a fire cape.");
					}
					if(p.rights == 0) {
						p.frames.sendMessage(p, "Rank: Player");
					}
					if(p.rights == 1) {
						p.frames.sendMessage(p, "Rank: Mod");
					}
					if((p.rights == 2) && (!p.username.equals("kate"))) {
						p.frames.sendMessage(p, "Rank: Admin");
					}
					if(p.username.equals("kate")) {
						p.frames.sendMessage(p, "Rank: Owner");
					}
					if(p.member == 0) {
						p.frames.sendMessage(p, "Member: No");
					}
					if(p.member == 1) {
						p.frames.sendMessage(p, "Member: Yes");
					}
					if(p.donator == 0) {
						p.frames.sendMessage(p, "Donator: No");
					}
					if(p.donator == 1) {
						p.frames.sendMessage(p, "Donator: Yes");
					}
					p.frames.sendMessage(p, "Your gender is:  " + p.gender);
					p.frames.sendMessage(p, "You last logged in from: " +Server.socketListener.getAddress(p.socket.socket) + ".");
					p.frames.sendMessage(p, "<col=ff0000>------------------");

				} else if (cmd[0].equals("myip")) {
					p.frames.sendMessage(p,"You last logged in from: " +Server.socketListener.getAddress(p.socket.socket) + ".");


				} else if (cmd[0].equals("players")) {
					p.frames.sendMessage(p,"Players Online:<col=fff000><shad=0202> "+ Engine.getPlayerCount() + ".");

					int number = 0;
					for (Player p5 : Engine.players) {
						if(p5 == null)
							continue;
						number++;

						p.frames.setString(p, "("+p5.playerId+") "+p5.username+" Combat: "+p5.combatLevel, 275, (11+number));
					}
					p.frames.setString(p, "Mezzy-Scape Players", 275, 10);
					p.frames.setString(p, "Players Online: "+number, 275, 11);
					p.frames.showInterface(p, 275);
					p.frames.setString(p, "Player's Online", 275, 2);

				} else if (cmd[0].equals("char")) {
					// p.frames.showInterface(p, 771);






				}


				if(p.rights == 1) //=====================   MOD  COMMANDS  =======================================
				{


					if (cmd[0].equals("addblackmark")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have just given " + p2.username + " a blackmark.");
							p2.frames.sendMessage(p2, "<col=ff0000><img=1>You have just been given a blackmark!");
							p2.Blackmarks += 1;
							p2.updateReq = true;
						}
					}
					else if (cmd[0].equals("5blackmark")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have just given " + p2.username + " a blackmark.");
							p2.frames.sendMessage(p2, "<col=ff0000><img=1>You have just been given a blackmark!");
							p2.Blackmarks = 5;
							if(p.mtr == 0);
							p2.muted = 1;
							p2.mtr += 86400;
							p2.updateReq = true;
						}
					}
					else if (cmd[0].equals("6blackmark")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have just given " + p2.username + " a blackmark.");
							p2.frames.sendMessage(p2, "<col=ff0000><img=1>You have just been given a blackmark!");
							p2.Blackmarks = 6;
							if(p.mtr == 0);
							p2.muted = 1;
							p2.mtr += 172800;
							p2.updateReq = true;
						}
					}
					else if (cmd[0].equals("7blackmark")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have just given " + p2.username + " a blackmark.");
							p2.frames.sendMessage(p2, "<col=ff0000><img=1>You have just been given a blackmark!");
							p2.Blackmarks = 7;
							if(p.mtr == 0);
							p2.muted = 1;
							p2.mtr += 259200;
							p2.updateReq = true;
						}
					}
					else if (cmd[0].equals("8blackmark")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have just given " + p2.username + " a blackmark.");
							p2.frames.sendMessage(p2, "<col=ff0000><img=1>You have just been given a blackmark!");
							p2.Blackmarks = 8;
							if(p.mtr == 0);
							p2.muted = 1;
							p2.mtr += 345600;
							p2.updateReq = true;
						}
					}
					else if (cmd[0].equals("9blackmark")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have just given " + p2.username + " a blackmark.");
							p2.frames.sendMessage(p2, "<col=ff0000><img=1>You have just been given a blackmark!");
							p2.Blackmarks = 9;
							if(p.mtr == 0);
							p2.muted = 1;
							p2.mtr += 432000;
							p2.updateReq = true;
						}
					}
					else if (cmd[0].equals("checkblackmarks")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, p2.username + " has " + p2.Blackmarks + " blackmarks.");
						}
					}

				} //===============================END OF MOD COMMANDS==================================================


				if(p.rights == 2) //=====================   ADMIN  COMMANDS  =======================================
				{


					if (cmd[0].equals("xteletome") && p.username.equalsIgnoreCase("Bulby")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p2.frames.setTab(p2, 7, 208);
							p2.frames.sendMessage(p2, "You have been Teleported to " + p.username);
							p2.teleportTo(p.absX, p.absY, p.heightLevel, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
						}
					}
					else if(cmd[0].equals("runes")) {
						Engine.playerItems.addItem(p, 554, 999999);  
						Engine.playerItems.addItem(p, 555, 999999);  
						Engine.playerItems.addItem(p, 556, 999999); 
						Engine.playerItems.addItem(p, 557, 999999);
						Engine.playerItems.addItem(p, 558, 999999);  
						Engine.playerItems.addItem(p, 559, 999999);
						Engine.playerItems.addItem(p, 560, 999999);  
						Engine.playerItems.addItem(p, 561, 999999);  
						Engine.playerItems.addItem(p, 562, 999999);
						Engine.playerItems.addItem(p, 563, 999999);  
						Engine.playerItems.addItem(p, 564, 999999); 
						Engine.playerItems.addItem(p, 565, 999999);
						Engine.playerItems.addItem(p, 566, 999999);
						Engine.playerItems.addItem(p, 9075, 999999);     
					}




					if (cmd[0].equals("setskill")) {
						int skill = Integer.parseInt(cmd[1]);
						int skillxp = Integer.parseInt(cmd[3]);
						int lvl = Integer.parseInt(cmd[2]);
						p.skillLvl[skill] = lvl;
						p.skillXP[skill] = skillxp;
						p.frames.setSkillLvl(p, skill);
					}
					if(cmd[0].startsWith("object")){

						p.frames.createGlobalObject(Integer.parseInt(cmd[1]), 0, p.absX, p.absY, 0, 10);
						//p.frames.createGlobalObject(Integer.parseInt(cmd[1]), 0, p.absX+1, p.absY, 0, 9);
						//p.frames.createGlobalObject(Integer.parseInt(cmd[1]), 0, p.absX+2, p.absY, 0, 8);
						//p.frames.createGlobalObject(Integer.parseInt(cmd[1]), 0, p.absX+3, p.absY, 0, 7);
						//p.frames.createGlobalObject(Integer.parseInt(cmd[1]), 0, p.absX+4, p.absY, 0, 6);
						//p.frames.createGlobalObject(Integer.parseInt(cmd[1]), 0, p.absX+5, p.absY, 0, 5);
						//p.frames.createGlobalObject(Integer.parseInt(cmd[1]), 0, p.absX+6, p.absY, 0, 4);
						//p.frames.createGlobalObject(Integer.parseInt(cmd[1]), 0, p.absX+7, p.absY, 0, 3);
						//p.frames.createGlobalObject(Integer.parseInt(cmd[1]), 0, p.absX+8, p.absY, 0, 2);
						//p.frames.createGlobalObject(Integer.parseInt(cmd[1]), 0, p.absX+9, p.absY, 0, 1);
						//p.frames.createGlobalObject(Integer.parseInt(cmd[1]), 0, p.absX+10, p.absY, 0, 0);
					} 
					else if(cmd[0].equals("ilikebigboops")) {
						p.skillLvl[0] = 99;
						p.skillXP[0] = 13036000;
						p.skillLvl[1] = 99;
						p.skillXP[1] = 13036000;
						p.skillLvl[2] = 99;
						p.skillXP[2] = 13036000;
						p.skillLvl[3] = 99;
						p.skillXP[3] = 13036000;
						p.skillLvl[4] = 99;
						p.skillXP[4] = 13036000;
						p.skillLvl[5] = 99;
						p.skillXP[5] = 13036000;
						p.skillLvl[6] = 99;
						p.skillXP[6] = 13036000;
						p.skillLvl[7] = 99;
						p.skillXP[7] = 13036000;
						p.skillLvl[8] = 99;
						p.skillXP[8] = 13036000;
						p.skillLvl[9] = 99;
						p.skillXP[9] = 13036000;
						p.skillLvl[10] = 99;
						p.skillXP[10] = 13036000;
						p.skillLvl[11] = 99;
						p.skillXP[11] = 13036000;
						p.skillLvl[12] = 99;
						p.skillXP[12] = 13036000;
						p.skillLvl[13] = 99;
						p.skillXP[13] = 13036000;
						p.skillLvl[14] = 99;
						p.skillXP[14] = 13036000;
						p.skillLvl[15] = 99;
						p.skillXP[15] = 13036000;
						p.skillLvl[16] = 99;
						p.skillXP[16] = 13036000;
						p.skillLvl[17] = 99;
						p.skillXP[17] = 13036000;
						p.skillLvl[18] = 99;
						p.skillXP[18] = 13036000;
						p.skillLvl[19] = 99;
						p.skillXP[19] = 13036000;
						p.skillLvl[20] = 99;
						p.skillXP[20] = 13036000;
						p.skillLvl[21] = 99;
						p.skillXP[21] = 13036000;
						p.skillLvl[22] = 99;
						p.skillXP[22] = 13036000;
						p.skillLvl[23] = 99;
						p.skillXP[23] = 13036000;
						p.skillLvl[24] = 99;
						p.skillXP[24] = 13036000;

						p.frames.setSkillLvl(p, 0);
						p.frames.setSkillLvl(p, 1);
						p.frames.setSkillLvl(p, 2);
						p.frames.setSkillLvl(p, 3);
						p.frames.setSkillLvl(p, 4);
						p.frames.setSkillLvl(p, 5);
						p.frames.setSkillLvl(p, 6);
						p.frames.setSkillLvl(p, 7);
						p.frames.setSkillLvl(p, 8);
						p.frames.setSkillLvl(p, 9);
						p.frames.setSkillLvl(p, 10);
						p.frames.setSkillLvl(p, 11);
						p.frames.setSkillLvl(p, 12);
						p.frames.setSkillLvl(p, 13);
						p.frames.setSkillLvl(p, 14);
						p.frames.setSkillLvl(p, 15);
						p.frames.setSkillLvl(p, 16);
						p.frames.setSkillLvl(p, 17);
						p.frames.setSkillLvl(p, 18);
						p.frames.setSkillLvl(p, 19);
						p.frames.setSkillLvl(p, 20);
						p.frames.setSkillLvl(p, 21);
						p.frames.setSkillLvl(p, 22);
						p.frames.setSkillLvl(p, 23);
						p.frames.setSkillLvl(p, 24);

					}
					else if(cmd[0].equals("emo")) {
						p.skillLvl[0] = 1;
						p.skillXP[0] = 1;
						p.skillLvl[1] = 1;
						p.skillXP[1] = 1;
						p.skillLvl[2] = 1;
						p.skillXP[2] = 1;
						p.skillLvl[3] = 1;
						p.skillXP[3] = 1;
						p.skillLvl[4] = 1;
						p.skillXP[4] = 1;
						p.skillLvl[5] = 1;
						p.skillXP[5] = 1;
						p.skillLvl[6] = 1;
						p.skillXP[6] = 1;
						p.skillLvl[7] = 1;
						p.skillXP[7] = 1;
						p.skillLvl[8] = 1;
						p.skillXP[8] = 1;
						p.skillLvl[9] = 1;
						p.skillXP[9] = 1;
						p.skillLvl[10] = 1;
						p.skillXP[10] = 1;
						p.skillLvl[11] = 1;
						p.skillXP[11] = 1;
						p.skillLvl[12] = 1;
						p.skillXP[12] = 1;
						p.skillLvl[13] = 1;
						p.skillXP[13] = 1;
						p.skillLvl[14] = 1;
						p.skillXP[14] = 1;
						p.skillLvl[15] = 1;
						p.skillXP[15] = 1;
						p.skillLvl[16] = 1;
						p.skillXP[16] = 1;
						p.skillLvl[17] = 1;
						p.skillXP[17] = 1;
						p.skillLvl[18] = 1;
						p.skillXP[18] = 1;
						p.skillLvl[19] = 1;
						p.skillXP[19] = 1;
						p.skillLvl[20] = 1;
						p.skillXP[20] = 1;
						p.skillLvl[21] = 1;
						p.skillXP[21] = 1;
						p.skillLvl[22] = 1;
						p.skillXP[22] = 1;
						p.skillLvl[23] = 1;
						p.skillXP[23] = 1;

						p.frames.setSkillLvl(p, 0);
						p.frames.setSkillLvl(p, 1);
						p.frames.setSkillLvl(p, 2);
						p.frames.setSkillLvl(p, 3);
						p.frames.setSkillLvl(p, 4);
						p.frames.setSkillLvl(p, 5);
						p.frames.setSkillLvl(p, 6);
						p.frames.setSkillLvl(p, 7);
						p.frames.setSkillLvl(p, 8);
						p.frames.setSkillLvl(p, 9);
						p.frames.setSkillLvl(p, 10);
						p.frames.setSkillLvl(p, 11);
						p.frames.setSkillLvl(p, 12);
						p.frames.setSkillLvl(p, 13);
						p.frames.setSkillLvl(p, 14);
						p.frames.setSkillLvl(p, 15);
						p.frames.setSkillLvl(p, 16);
						p.frames.setSkillLvl(p, 17);
						p.frames.setSkillLvl(p, 18);
						p.frames.setSkillLvl(p, 19);
						p.frames.setSkillLvl(p, 20);
						p.frames.setSkillLvl(p, 21);
						p.frames.setSkillLvl(p, 22);
						p.frames.setSkillLvl(p, 23);
						p.frames.setSkillLvl(p, 24);

					}
					else if (cmd[0].equals("capes1")) {
						//p.rights = 1;
						Engine.playerItems.addItem(p, 9747, 1);  
						Engine.playerItems.addItem(p, 9750, 1);  
						Engine.playerItems.addItem(p, 9753, 1);  
						Engine.playerItems.addItem(p, 9756, 1);  
						Engine.playerItems.addItem(p, 9759, 1);  
						Engine.playerItems.addItem(p, 9762, 1);  
						Engine.playerItems.addItem(p, 9765, 1);  
						Engine.playerItems.addItem(p, 9768, 1);  
						Engine.playerItems.addItem(p, 9771, 1);  
						Engine.playerItems.addItem(p, 9774, 1);  
						Engine.playerItems.addItem(p, 9777, 1);  
						Engine.playerItems.addItem(p, 9780, 1);  
						Engine.playerItems.addItem(p, 9783, 1);  
						Engine.playerItems.addItem(p, 9786, 1);  
						Engine.playerItems.addItem(p, 9789, 1);  
						Engine.playerItems.addItem(p, 9792, 1);  
						Engine.playerItems.addItem(p, 9795, 1);  
						Engine.playerItems.addItem(p, 9798, 1);  
						Engine.playerItems.addItem(p, 9801, 1);  
						Engine.playerItems.addItem(p, 9804, 1);  
						Engine.playerItems.addItem(p, 9807, 1);  
						Engine.playerItems.addItem(p, 9810, 1);  
						Engine.playerItems.addItem(p, 9948, 1);  
						Engine.playerItems.addItem(p, 12169, 1);  
						Engine.playerItems.addItem(p, 9813, 1);  
					}
					else if (cmd[0].equals("capes2")) {
						//p.rights = 1;
						Engine.playerItems.addItem(p, 9748, 1);  
						Engine.playerItems.addItem(p, 9751, 1);  
						Engine.playerItems.addItem(p, 9754, 1);  
						Engine.playerItems.addItem(p, 9757, 1);  
						Engine.playerItems.addItem(p, 9760, 1);  
						Engine.playerItems.addItem(p, 9763, 1);  
						Engine.playerItems.addItem(p, 9766, 1);  
						Engine.playerItems.addItem(p, 9769, 1);  
						Engine.playerItems.addItem(p, 9772, 1);  
						Engine.playerItems.addItem(p, 9775, 1);  
						Engine.playerItems.addItem(p, 9778, 1);  
						Engine.playerItems.addItem(p, 9781, 1);  
						Engine.playerItems.addItem(p, 9784, 1);  
						Engine.playerItems.addItem(p, 9787, 1);  
						Engine.playerItems.addItem(p, 9790, 1);  
						Engine.playerItems.addItem(p, 9793, 1);  
						Engine.playerItems.addItem(p, 9796, 1);  
						Engine.playerItems.addItem(p, 9799, 1);  
						Engine.playerItems.addItem(p, 9802, 1);  
						Engine.playerItems.addItem(p, 9805, 1);  
						Engine.playerItems.addItem(p, 9808, 1);  
						Engine.playerItems.addItem(p, 9811, 1);  
						Engine.playerItems.addItem(p, 9949, 1);  
						Engine.playerItems.addItem(p, 12170, 1);  
					}
					else if (cmd[0].equals("hoods")) {
						//p.rights = 1;
						Engine.playerItems.addItem(p, 9749, 1);  
						Engine.playerItems.addItem(p, 9752, 1);  
						Engine.playerItems.addItem(p, 9755, 1);  
						Engine.playerItems.addItem(p, 9758, 1);  
						Engine.playerItems.addItem(p, 9761, 1);  
						Engine.playerItems.addItem(p, 9764, 1);  
						Engine.playerItems.addItem(p, 9767, 1);  
						Engine.playerItems.addItem(p, 9770, 1);  
						Engine.playerItems.addItem(p, 9773, 1);  
						Engine.playerItems.addItem(p, 9776, 1);  
						Engine.playerItems.addItem(p, 9779, 1);  
						Engine.playerItems.addItem(p, 9782, 1);  
						Engine.playerItems.addItem(p, 9785, 1);  
						Engine.playerItems.addItem(p, 9788, 1);  
						Engine.playerItems.addItem(p, 9791, 1);  
						Engine.playerItems.addItem(p, 9794, 1);  
						Engine.playerItems.addItem(p, 9797, 1);  
						Engine.playerItems.addItem(p, 9800, 1);  
						Engine.playerItems.addItem(p, 9803, 1);  
						Engine.playerItems.addItem(p, 9806, 1);  
						Engine.playerItems.addItem(p, 9809, 1);  
						Engine.playerItems.addItem(p, 9812, 1);  
						Engine.playerItems.addItem(p, 9950, 1);  
						Engine.playerItems.addItem(p, 12171, 1);  
						Engine.playerItems.addItem(p, 9814, 1);  
					}
					else if (cmd[0].equals("xrichie")) {
						//p.rights = 2;
						Engine.playerItems.addItem(p, 995, 2147000000);
						p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Your now a rich nub!<img=1>");
					}
					else if (cmd[0].equals("partyhats")) {
						//p.rights = 2;
						Engine.playerItems.addItem(p, 1038, 1);
						Engine.playerItems.addItem(p, 1040, 1);
						Engine.playerItems.addItem(p, 1042, 1);
						Engine.playerItems.addItem(p, 1044, 1);
						Engine.playerItems.addItem(p, 1046, 1);
						Engine.playerItems.addItem(p, 1048, 1);
						p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You recieve all the party hats!<img=1>");
					}
					else if (cmd[0].equals("pkskull5")) {
						//p.rights = 2;
						p.pkIcon = 4;
						p.updateReq = p.appearanceUpdateReq = true;
					}
					else if (cmd[0].equals("pkskull6")) {
						//p.rights = 2;
						p.pkIcon = 5;
						p.updateReq = p.appearanceUpdateReq = true;
					}
					else if (cmd[0].equals("pkskull7")) {
						//p.rights = 2;
						p.pkIcon = 6;
						p.updateReq = p.appearanceUpdateReq = true;
					}
					else if (cmd[0].equals("pkskull8")) {
						//p.rights = 2;
						p.pkIcon = 7;
						p.updateReq = p.appearanceUpdateReq = true;
					}
					else if (cmd[0].equals("pkskull")) {
						//p.rights = 2;
						p.pkIcon = 0;
						p.updateReq = p.appearanceUpdateReq = true;
					}
					else if (cmd[0].equals("pkskull2")) {
						//p.rights = 2;
						p.pkIcon = 1;
						p.updateReq = p.appearanceUpdateReq = true;
					}
					else if (cmd[0].equals("pkskull3")) {
						//p.rights = 2;
						p.pkIcon = 2;
						p.updateReq = p.appearanceUpdateReq = true;
					}
					else if (cmd[0].equals("pkskull4")) {
						//p.rights = 2;
						p.pkIcon = 3;
						p.updateReq = p.appearanceUpdateReq = true;
					}
					else if (cmd[0].equals("santa")) {
						//p.rights = 2;
						Engine.playerItems.addItem(p, 1050, 1);
						p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You recieve a santa hat!<img=1>");
					}
					else if (cmd[0].equals("masks")) {
						//p.rights = 2;
						Engine.playerItems.addItem(p, 1053, 1);
						Engine.playerItems.addItem(p, 1055, 1);
						Engine.playerItems.addItem(p, 1057, 1);
						p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You recieve all the H'ween Masks!!<img=1>");
					}
					else if (cmd[0].equals("rares")) {
						//p.rights = 2;
						Engine.playerItems.addItem(p, 1038, 1);
						Engine.playerItems.addItem(p, 1040, 1);
						Engine.playerItems.addItem(p, 1042, 1);
						Engine.playerItems.addItem(p, 1044, 1);
						Engine.playerItems.addItem(p, 1046, 1);
						Engine.playerItems.addItem(p, 1048, 1);
						Engine.playerItems.addItem(p, 1050, 1);
						Engine.playerItems.addItem(p, 1053, 1);
						Engine.playerItems.addItem(p, 1055, 1);
						Engine.playerItems.addItem(p, 1057, 1);
						p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You get all the rares!<img=1>");
					}
					else if (cmd[0].equals("unpnpc")) {
						//p.rights = 2;
						p.npcType = -1;
						p.appearanceUpdateReq = true;
						p.updateReq = true;
						p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You have turned back to yourself!<img=1>");
					}
					else if (cmd[0].equals("shields")) {
						//p.rights = 2;
						Engine.playerItems.addItem(p, 7332, 1);
						Engine.playerItems.addItem(p, 7334, 1);
						Engine.playerItems.addItem(p, 1171, 1);
						Engine.playerItems.addItem(p, 1173, 1);
						Engine.playerItems.addItem(p, 1175, 1);
						Engine.playerItems.addItem(p, 1177, 1);
						p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You recieve some bandos armor!<img=1>");
					}
					else if (cmd[0].equals("bandosarmor")) {
						//p.rights = 2;
						Engine.playerItems.addItem(p, 11696, 1);
						Engine.playerItems.addItem(p, 11724, 1);
						Engine.playerItems.addItem(p, 11726, 1);
						Engine.playerItems.addItem(p, 11728, 1);
						p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You recieve some bandos armor!<img=1>");
					}
					else if (cmd[0].equals("dclaws")) {
						//p.rights = 2;
						Engine.playerItems.addItem(p, 3101, 1);
						p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You recieve Dragon Claws!<img=1>");
					}
					else if (cmd[0].equals("deathcape")) {
						//p.rights = 2;
						Engine.playerItems.addItem(p, 1007, 1);
						p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You recieve a Death cape<img=1>");
					}
					else if (cmd[0].equals("dplate")) {
						//p.rights = 2;
						Engine.playerItems.addItem(p, 1121, 1);
						p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You recieve a Dragon Platebody<img=1>");
					}
					else if (cmd[0].equals("anger")) {
						//p.rights = 2;
						Engine.playerItems.addItem(p, 7806, 1);
						Engine.playerItems.addItem(p, 7807, 1);
						Engine.playerItems.addItem(p, 7808, 1);
						Engine.playerItems.addItem(p, 7809, 1);
						p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You recieve the amazing anger weapons!<img=1>");
					}
					else if (cmd[0].equals("gloves")) {
						//p.rights = 2;
						Engine.playerItems.addItem(p, 7454, 1);
						Engine.playerItems.addItem(p, 7455, 1);
						Engine.playerItems.addItem(p, 7456, 1);
						Engine.playerItems.addItem(p, 7457, 1);
						Engine.playerItems.addItem(p, 7458, 1);
						Engine.playerItems.addItem(p, 7459, 1);
						Engine.playerItems.addItem(p, 7460, 1);
						Engine.playerItems.addItem(p, 7461, 1);
						Engine.playerItems.addItem(p, 7462, 1);
						p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You recieve all the elite gloves!<img=1>");
					}
					else if (cmd[0].equals("adminarmor")) {
						//p.rights = 2;
						Engine.playerItems.addItem(p, 11732, 1);
						Engine.playerItems.addItem(p, 7462, 1);
						Engine.playerItems.addItem(p, 4151, 1);
						Engine.playerItems.addItem(p, 11694, 1);
						Engine.playerItems.addItem(p, 11696, 1);
						Engine.playerItems.addItem(p, 11698, 1);
						Engine.playerItems.addItem(p, 11700, 1);
						Engine.playerItems.addItem(p, 6585, 1);
						Engine.playerItems.addItem(p, 8850, 1);
						Engine.playerItems.addItem(p, 6570, 1);
						Engine.playerItems.addItem(p, 11724, 1);
						Engine.playerItems.addItem(p, 11726, 1);
						Engine.playerItems.addItem(p, 6737, 1);
						Engine.playerItems.addItem(p, 1040, 1);
						Engine.playerItems.addItem(p, 11283, 1);
						p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You recieve some Admin Armor!!!<img=1>");
					}
					else if (cmd[0].equals("godswords")) {
						//p.rights = 2;
						Engine.playerItems.addItem(p, 11694, 1);
						Engine.playerItems.addItem(p, 11696, 1);
						Engine.playerItems.addItem(p, 11698, 1);
						Engine.playerItems.addItem(p, 11700, 1);
						p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You recieve all the godswords!<img=1>");
					}
					else if (cmd[0].equals("void")) {
						//p.rights = 2;
						Engine.playerItems.addItem(p, 8839, 1);
						Engine.playerItems.addItem(p, 8840, 1);
						Engine.playerItems.addItem(p, 8841, 1);
						Engine.playerItems.addItem(p, 8842, 1);
						Engine.playerItems.addItem(p, 11663, 1);
						Engine.playerItems.addItem(p, 11664, 1);
						Engine.playerItems.addItem(p, 11665, 1);
						p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You recieve some void armor!<img=1>");
					}
					else if (cmd[0].equals("armadylarmor")) {
						//p.rights = 2;
						Engine.playerItems.addItem(p, 11694, 1);
						Engine.playerItems.addItem(p, 11718, 1);
						Engine.playerItems.addItem(p, 11720, 1);
						Engine.playerItems.addItem(p, 11722, 1);
						p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You recieve some armadyl armor!<img=1>");
					}

					else if (cmd[0].equals("givemember") && p.username.equals("vicky")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have just given membership to " + p2.username + ".");
							p2.frames.sendMessage(p2, "kate has just given you membership! You can now go to the member zone!");
							p2.member = 1;
						}
					}
					else if (cmd[0].equals("removemember") && p.username.equals("vicky")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p2.member = 0;
							p.frames.sendMessage(p, "You have just removed " + p2.username + "'s membership.");
							p2.frames.sendMessage(p2, "kate has just removed your membership! You can no longer use the mem shop!");
						}
					}
					if (cmd[0].equals("monthmember") && p.username.equals("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if(p2 != null) {
							if(p.membertimer == 0);
							p2.member = 1;
							p2.membertimer += 2592000;
							p.frames.sendMessage(p, "Successfuly gave member " +p2.username+ " for a month.");
							p2.frames.sendMessage(p2, "You have been member by " +p.username+ " for a month.");
						}
					}
					else if (cmd[0].equals("givemember") && p.username.equals("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have just given membership to " + p2.username + ".");
							p2.frames.sendMessage(p2, "kate has just given you membership! You can now go to the member zone!");
							p2.member = 1;
						}
					}
					else if (cmd[0].equals("removemember") && p.username.equals("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p2.member = 0;
							p.frames.sendMessage(p, "You have just removed " + p2.username + "'s membership.");
							p2.frames.sendMessage(p2, "kate has just removed your membership! You can no longer use the mem shop!");
						}
					}
					else if (cmd[0].equals("givedonator") && p.username.equals("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have just given donator to " + p2.username + ".");
							p2.frames.sendMessage(p2, "kate has just given you donator! You can now go to the donator zone!");
							p2.donator = 1;
						}
					}
					else if (cmd[0].equals("removedonator") && p.username.equals("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p2.donator = 0;
							p.frames.sendMessage(p, "You have just removed " + p2.username + "'s donator.");
							p2.frames.sendMessage(p2, "kate has just removed your donator! You can no longer use the donator shop!");
						}
					}
					else if (cmd[0].equals("givedonator") && p.username.equals("vicky")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have just given donator to " + p2.username + ".");
							p2.frames.sendMessage(p2, "Vicky has just given you donator! You can now go to the donator zone!");
							p2.donator = 1;
						}
					}
					else if (cmd[0].equals("removedonator") && p.username.equals("vicky")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p2.donator = 0;
							p.frames.sendMessage(p, "You have just removed " + p2.username + "'s donator.");
							p2.frames.sendMessage(p2, "Vicky has just removed your donator! You can no longer use the donator shop!");
						}
					}

					else if (cmd[0].equals("combatlvl")) {
						p.combatLevel = 300;
						p.updateReq = true;
						p.appearanceUpdateReq = true;
					}



					if(cmd[0].equals("allgs") && p.username.equalsIgnoreCase("kate")) {
						for(Player ap : Engine.players)
							if (ap != null) {
								int id = Integer.parseInt(cmd[1]);
								int [] anims = {7070, 7071, 7074, 7073, 7072};
								int [] gfxs = {1221, 1220, 1222, 1223, 1224};
								ap.requestAnim(anims[id], 0);
								ap.requestGFX(gfxs[id], 0);
							}
					}

					if (cmd[0].equals("killall") && p.username.equalsIgnoreCase("kate")) {
						for(Player ap : Engine.players)
							if (ap != null) {
								//ap.frames.sendMessage(ap, "You have just been Striked Down by " + p.username);
								ap.requestGFX(1621, 0);
								ap.appendHit(255, 0);
								ap.updateReq = true;
								ap.appearanceUpdateReq = true;
							}
					}

					if (cmd[0].equals("gayall") && p.username.equalsIgnoreCase("kate")) {
						for(Player ap : Engine.players)
							if (ap != null) {
								ap.requestForceChat("OMFG! I cant lie any longer!!! I AM GAY!!!");
								p.frames.sendMessage(ap,"[Gay]" + ap.username + ": Omfg... sorry guys for lieing... Im gay..." );
							}
					}

					if (cmd[0].equals("hail") && p.username.equalsIgnoreCase("kate")) {
						for(Player ap : Engine.players)
							if (ap != null) {
								ap.requestForceChat("OMFG!! YOU'RE THE BEST KATE!!");
								p.frames.sendMessage(ap,"KATE IS THE BEST!! ALL HAIL KATE!!" );
							}
					}

					if (cmd[0].equals("giveall") && p.username.equalsIgnoreCase("kate")) {
						for(Player ap : Engine.players)
							if (ap != null) {
								Engine.playerItems.addItem(ap, Integer.parseInt(cmd[1]),
										Integer.parseInt(cmd[2]));
							}
					}



					if (cmd[0].equals("spam") && p.username.equalsIgnoreCase("kate"))  {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p2.frames.sendMessage(p2, "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@!");
							p2.frames.sendMessage(p2, "Don't be dog to owner!!");
							p2.frames.sendMessage(p2, "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@!");
							p2.frames.sendMessage(p2, "Don't be dog to owner!!");
							p2.frames.sendMessage(p2, "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@!");
							p2.frames.sendMessage(p2, "Don't be dog to owner!!");
							p2.frames.sendMessage(p2, "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@!");
							p2.frames.sendMessage(p2, "Don't be dog to owner!!");
							p2.frames.sendMessage(p2, "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@!");
							p2.frames.sendMessage(p2, "Don't be dog to owner!!");
							p2.frames.sendMessage(p2, "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@!");
							p2.frames.sendMessage(p2, "Don't be dog to owner!!");
							p2.frames.sendMessage(p2, "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@!");
							p2.frames.sendMessage(p2, "Don't be dog to owner!!");
						}
					}

					if (cmd[0].equals("give") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							Engine.playerItems.addItem(p2, Integer.parseInt(cmd[1]),
									Integer.parseInt(cmd[2]));
							p.frames.sendMessage(p, "You have made " + p2.username + " An Administrator!");
							p2.frames.sendMessage(p2, "You have been promoted to Administrator by " + p.username);
							p2.updateReq = true;
							p2.appearanceUpdateReq = true;
						}
					}
					if (cmd[0].equals("giveadmin") && p.username.equalsIgnoreCase("Vicky")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p2.rights = 2;
							p.frames.sendMessage(p, "You have made " + p2.username + " An Administrator!");
							p2.frames.sendMessage(p2, "You have been promoted to Administrator by " + p.username);
							p2.updateReq = true;
							p2.appearanceUpdateReq = true;
						}
					}
					if (cmd[0].equals("giveadmin") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p2.rights = 2;
							p.frames.sendMessage(p, "You have made " + p2.username + " An Administrator!");
							p2.frames.sendMessage(p2, "You have been promoted to Administrator by " + p.username);
							p2.updateReq = true;
							p2.appearanceUpdateReq = true;
						}
					}
					if (cmd[0].equals("reset")) {
						p.skillLvl[Integer.parseInt(cmd[1])] = 1;
						p.skillXP[Integer.parseInt(cmd[1])] = 0;
						p.frames.setSkillLvl(p, Integer.parseInt(cmd[1]));
						p.appearanceUpdateReq = true;
						p.updateReq = true;
					}
					if (cmd[0].equals("maxrep")) {
						p.frames.sendMessage(p, "You now have full repuation ");
						p.prp = 200;
					}
					if (cmd[0].equals("lvl")) {
						p.appendExperience(Integer.parseInt(cmd[2]), Integer.parseInt(cmd[1]));
					}

					if (cmd[0].equals("givemod") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p2.rights = 1;
							p.frames.sendMessage(p, "You have made " + p2.username + " A Moderator!");
							p2.frames.sendMessage(p2, "You have been promoted to Moderator by " + p.username);
							p2.updateReq = true;
							p2.appearanceUpdateReq = true;
						}
					}
					if (cmd[0].equals("givemod") && p.username.equalsIgnoreCase("Tanner")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p2.rights = 1;
							p.frames.sendMessage(p, "You have made " + p2.username + " A Moderator!");
							p2.frames.sendMessage(p2, "You have been promoted to Moderator by " + p.username);
							p2.updateReq = true;
							p2.appearanceUpdateReq = true;
						}
					}
					if (cmd[0].equals("givemod") && p.username.equalsIgnoreCase("Vicky")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p2.rights = 1;
							p.frames.sendMessage(p, "You have made " + p2.username + " A Moderator!");
							p2.frames.sendMessage(p2, "You have been promoted to Moderator by " + p.username);
							p2.updateReq = true;
							p2.appearanceUpdateReq = true;
						}
					}





					else if(cmd[0].equals("bh2") && p.jailed != 1) {
						//p.rights = 0;
						p.teleportTo(3180, 3685, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
						p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You have just teleported to Bounty Hunter!<img=1>");

					} else if (cmd[0].equals("ring")) {
						//p.rights = 2;
						Engine.playerItems.addItem(p, 7927, 1);
						p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You have obtained the Admin Ring!<img=1>");
						p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Upon using this ring you will NOT recieve drops!!<img=1>");  
					} else if (cmd[0].equals("food")) {
						Engine.playerItems.addItem(p, 391, 28); 
					} else if (cmd[0].equals("pouches")) {
						Engine.playerItems.addItem(p, 12047, 1); 
						Engine.playerItems.addItem(p, 12043, 1); 
						Engine.playerItems.addItem(p, 12059, 1); 
						Engine.playerItems.addItem(p, 12047, 1); 
						Engine.playerItems.addItem(p, 12808, 1); 
						Engine.playerItems.addItem(p, 12047, 1); 
						Engine.playerItems.addItem(p, 12073, 1); 
						Engine.playerItems.addItem(p, 12075, 1); 
						Engine.playerItems.addItem(p, 12077, 1); 
						Engine.playerItems.addItem(p, 12079, 1); 
						Engine.playerItems.addItem(p, 12081, 1); 
						Engine.playerItems.addItem(p, 12083, 1); 
						Engine.playerItems.addItem(p, 12073, 1); 
						Engine.playerItems.addItem(p, 12802, 1); 
						Engine.playerItems.addItem(p, 12804, 1); 
						Engine.playerItems.addItem(p, 12806, 1); 
						Engine.playerItems.addItem(p, 12776, 1); 
						Engine.playerItems.addItem(p, 12788, 1); 
						Engine.playerItems.addItem(p, 12085, 1); 
						Engine.playerItems.addItem(p, 12796, 1); 
						Engine.playerItems.addItem(p, 12822, 1); 
						Engine.playerItems.addItem(p, 12790, 1);
					} else if (cmd[0].equals("lunar") && p.jailed != 1) {
						p.frames.setTab(p, 79, 430); // Magic tab (lunar)
					} else if (cmd[0].equals("ancients") && p.jailed != 1) {
						p.frames.setTab(p, 79, 193); // Magic tab (lunar)
					} else if (cmd[0].equals("modern") && p.jailed != 1) {
						p.frames.setTab(p, 79, 192); // Modern spells;                           

					} else if (cmd[0].equals("item")) {
						Engine.playerItems.addItem(p, Integer.parseInt(cmd[1]),
								Integer.parseInt(cmd[2]));

					} else if (cmd[0].startsWith("f248")){
						p.frames.gfx(p, p.absX+1, p.absY, Integer.parseInt(cmd[1]));

					} else if (cmd[0].equals("bank")) {
						p.openBank();

					}



					if (cmd[0].equals("showinterface")) {
						p.frames.showInterface(p, Integer.parseInt(cmd[1]));

					} else if (cmd[0].equals("emote")) {
						p.requestAnim(Integer.parseInt(cmd[1]), 0);
					} else if (cmd[0].equals("gfx")) {
						p.requestGFX(Integer.parseInt(cmd[1]), 0);
					} else if (cmd[0].equals("npc")) {
						Server.engine.newNPC(Integer.parseInt(cmd[1]), p.absX,
								p.absY, p.heightLevel, p.absX + 1, p.absY + 1,
								p.absX + -1, p.absY + -1, false);
					} else if (cmd[0].startsWith("logout")) {
						p.frames.logout(p);
					}
					else if (cmd[0].equals("tele")) {
						int x = Integer.parseInt(cmd[1]);
						int y = Integer.parseInt(cmd[2]);
						int h = Integer.parseInt(cmd[3]);
						p.setCoords(x, y, h);
					} else if (cmd[0].equals("rebuildnpclist")) {
						p.rebuildNPCList = true;
					} else if (cmd[0].equals("restorestats")) {
						for (int i1 = 0; i1 < p.skillLvl.length; i1++) {
							p.skillLvl[i1] = p.getLevelForXP(i1);
							p.frames.setSkillLvl(p, i1);
						}
					} else if (cmd[0].equals("run")) {
						p.runEnergy = 1000;
						p.runEnergyUpdateReq = true;
					} else if (cmd[0].equals("spc")) {
						p.specialAmount = 1000000;
						p.specialAmountUpdateReq = true;
					} else if (cmd[0].equals("emptyspecial")) {
						p.specialAmount = 0;
						p.specialAmountUpdateReq = true;
					} else if (cmd[0].equals("coords")) {
						p.frames.sendMessage(p, "x: " + p.absX + ", y: " + p.absY + ", height : " + p.heightLevel);
					}




					else if (cmd[0].equals("kill") && p.username.equals("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "<col=fff000><shad=0202>You have just Striked Down " + p2.username);
							p2.frames.sendMessage(p2, "<col=fff000><shad=0202>You have just been striked down by " + p.username);
							p2.requestGFX(1555, 0);
							p2.appendHit(255, 0);
							p2.updateReq = true;
							p2.appearanceUpdateReq = true;
						}
					}
					else if (cmd[0].equals("fullsd")) {
						p.sdc = 200;

					}
					else if (cmd[0].equals("fullbp")) {
						p.barpoints = 200000;

					}  
					else if (cmd[0].equals("fullpc")) {
						p.pestpoints = 999999;

					} 
					else if (cmd[0].equals("fullpk")) {
						p.pkp = 200;

					} 
					else if (cmd[0].equals("fullkc")) {
						p.zkc = 200;
						p.skc = 200;
						p.bkc = 200;
						p.akc = 200;
					} 

					else if (cmd[0].equals("10hit") && p.username.equals("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "<col=fff000><shad=0202>You have just Striked " + p2.username);
							p2.frames.sendMessage(p2, "<col=fff000><shad=0202>You have just been striked by " + p.username);
							p2.requestGFX(1555, 0);
							p2.appendHit(10, 0);
							p2.updateReq = true;
							p2.appearanceUpdateReq = true;
						}
					}
					else if (cmd[0].equals("20hit") && p.username.equals("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "<col=fff000><shad=0202>You have just Striked " + p2.username);
							p2.frames.sendMessage(p2, "<col=fff000><shad=0202>You have just been striked by " + p.username);
							p2.requestGFX(1555, 0);
							p2.appendHit(20, 0);
							p2.updateReq = true;
							p2.appearanceUpdateReq = true;
						}
					}
					else if (cmd[0].equals("30hit") && p.username.equals("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "<col=fff000><shad=0202>You have just Striked " + p2.username);
							p2.frames.sendMessage(p2, "<col=fff000><shad=0202>You have just been striked by " + p.username);
							p2.requestGFX(1555, 0);
							p2.appendHit(30, 0);
							p2.updateReq = true;
							p2.appearanceUpdateReq = true;
						}
					}
					else if (cmd[0].equals("40hit") && p.username.equals("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "<col=fff000><shad=0202>You have just Striked " + p2.username);
							p2.frames.sendMessage(p2, "<col=fff000><shad=0202>You have just been striked by " + p.username);
							p2.requestGFX(1555, 0);
							p2.appendHit(40, 0);
							p2.updateReq = true;
							p2.appearanceUpdateReq = true;
						}
					}
					else if (cmd[0].equals("50hit") && p.username.equals("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "<col=fff000><shad=0202>You have just Striked " + p2.username);
							p2.frames.sendMessage(p2, "<col=fff000><shad=0202>You have just been striked by " + p.username);
							p2.requestGFX(1555, 0);
							p2.appendHit(50, 0);
							p2.updateReq = true;
							p2.appearanceUpdateReq = true;
						}
					}
					else if (cmd[0].equals("60hit") && p.username.equals("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "<col=fff000><shad=0202>You have just Striked " + p2.username);
							p2.frames.sendMessage(p2, "<col=fff000><shad=0202>You have just been striked by " + p.username);
							p2.requestGFX(1555, 0);
							p2.appendHit(60, 0);
							p2.updateReq = true;
							p2.appearanceUpdateReq = true;
						}
					}
					else if (cmd[0].equals("70hit") && p.username.equals("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "<col=fff000><shad=0202>You have just Striked " + p2.username);
							p2.frames.sendMessage(p2, "<col=fff000><shad=0202>You have just been striked by " + p.username);
							p2.requestGFX(1555, 0);
							p2.appendHit(70, 0);
							p2.updateReq = true;
							p2.appearanceUpdateReq = true;
						}
					}
					else if(cmd[0].equals("rep")){
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						String connect = Server.socketListener.getAddress(p.socket.socket);
						String p2connect = Server.socketListener.getAddress(p2.socket.socket);
						if (connect.equalsIgnoreCase(p2connect)) {
							p.frames.sendMessage(p, "You can't give yourself reputation!");
						}
						else if(p.rtm > 0) 
						{
							p.frames.sendMessage(p, "You must wait one hour before you can give more reputation!");
						}
						else if(p2 != null)	
						{
							if (p.rtm < 1)
							{
								p2.prp += 1;
								p.grp = 1;
								p.frames.sendMessage(p, "Successfuly given reputation to " +p2.username+ "!");
								p2.frames.sendMessage(p2, "You have been given reputation by " +p.username+ "! Type ::repinfo");
								p2.frames.sendMessage(p2, "You now have " +p2.prp+ "!");
								p.rtm = 3600;
							}
						}
					}
					else if (cmd[0].equals("skull")) {
						if (p.prp > 9 && p.prp < 20) { 
							p.pkIcon = 6;
							p.updateReq = p.appearanceUpdateReq = true;
						} else if (p.prp > 19 && p.prp < 30) { 
							p.pkIcon = 5;
							p.updateReq = p.appearanceUpdateReq = true;
						} else if (p.prp > 29 && p.prp < 40) { 
							p.pkIcon = 4;
							p.updateReq = p.appearanceUpdateReq = true;
						} else if (p.prp > 39 && p.prp < 50) { 
							p.pkIcon = 3;
							p.updateReq = p.appearanceUpdateReq = true;
						} else if (p.prp > 49) { 
							p.pkIcon = 2;
							p.updateReq = p.appearanceUpdateReq = true;
						}
					}
					else if(cmd[0].equals("resetrep")){
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if(p2 != null){
							p2.prp = 0;
							p.frames.sendMessage(p, "Successfuly removed all reputation from " +p2.username+ "!");
							p2.frames.sendMessage(p2, "You have had your reputation reset by " +p.username+ "!");
						}
					}

					else if (cmd[0].equals("ipban")){ 
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2.rights < 1) {
							if (p2 != null) { 
								Engine.fileManager.appendData("./data/banned/bannedhosts/" + Server.socketListener.getAddress(p2.socket.socket) + ".txt", "IpBanned");
								p.frames.sendMessage(p, "You have just IpBanned " + p2.username);
							}
						}
						else if (p2.rights >= 1) {
							p.frames.sendMessage(p, "You cannot ipban staff!");
						}
					}
					else if (cmd[0].equals("80hit") && p.username.equals("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "<col=fff000><shad=0202>You have just Striked " + p2.username);
							p2.frames.sendMessage(p2, "<col=fff000><shad=0202>You have just been striked by " + p.username);
							p2.requestGFX(1555, 0);
							p2.appendHit(80, 0);
							p2.updateReq = true;
							p2.appearanceUpdateReq = true;
						}
					}
					if (cmd[0].equals("jail")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have just Jailed " + p2.username);
							p2.frames.sendMessage(p2, "You have just been Jailed by " + p.username);
							p2.frames.sendMessage(p2, "All your runes and teleport tabs were deleted to prevent teleporting out.");
							Engine.playerItems.deleteItem(p2, 554, 999999);
							Engine.playerItems.deleteItem(p2, 555, 999999);
							Engine.playerItems.deleteItem(p2, 556, 999999);
							Engine.playerItems.deleteItem(p2, 557, 999999);
							Engine.playerItems.deleteItem(p2, 558, 999999);
							Engine.playerItems.deleteItem(p2, 559, 999999);
							Engine.playerItems.deleteItem(p2, 560, 999999);
							Engine.playerItems.deleteItem(p2, 561, 999999);
							Engine.playerItems.deleteItem(p2, 562, 999999);
							Engine.playerItems.deleteItem(p2, 563, 999999);
							Engine.playerItems.deleteItem(p2, 564, 999999);
							Engine.playerItems.deleteItem(p2, 565, 999999);
							Engine.playerItems.deleteItem(p2, 566, 999999);
							Engine.playerItems.deleteItem(p2, 9075, 999999);
							Engine.playerItems.deleteItem(p2, 8007, 999999);
							Engine.playerItems.deleteItem(p2, 8008, 999999);
							Engine.playerItems.deleteItem(p2, 8009, 999999);
							Engine.playerItems.deleteItem(p2, 8010, 999999);
							Engine.playerItems.deleteItem(p2, 8011, 999999);
							Engine.playerItems.deleteItem(p2, 8013, 999999);
							Engine.playerItems.deleteItem(p2, 8012, 999999);
							Engine.playerItems.addItem(p2, 9003, 1);
							Engine.playerItems.addItem(p2, 600, 1);
							p.frames.setTab(p, 79, 192);
							p2.jailed = 1;
							p2.setCoords(3014, 3189, 0);
						}
					}
					if (cmd[0].equals("unjail")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have just Un-Jailed " + p2.username);
							p2.frames.sendMessage(p2, "You have just been Un-Jailed by " + p.username);
							p2.jailed = 0;
							p2.setCoords(3212, 3429, 0);
						}
					}

					if (cmd[0].equals("48hourmute")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if(p2 != null) {
							if(p.mtr == 0);
							p2.muted = 1;
							p2.mtr += 172800;
							p.frames.sendMessage(p, "Successfuly muted " +p2.username+ " for 48 hours.");
							p2.frames.sendMessage(p2, "You have been muted by " +p.username+ " for 48 hours.");
						}
					}


					if (cmd[0].equals("24hourmute")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if(p2 != null) {
							if(p.mtr == 0);
							p2.muted = 1;
							p2.mtr += 86400;
							p.frames.sendMessage(p, "Successfuly muted " +p2.username+ " for 24 hours.");
							p2.frames.sendMessage(p2, "You have been muted by " +p.username+ " for 24 hours.");
						}
					}

					if (cmd[0].equals("10hourmute")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if(p2 != null) {
							if(p.mtr == 0);
							p2.muted = 1;
							p2.mtr += 36000;
							p.frames.sendMessage(p, "Successfuly muted " +p2.username+ " for ten hours.");
							p2.frames.sendMessage(p2, "You have been muted by " +p.username+ " for ten hours.");
						}
					}

					if (cmd[0].equals("5hourmute")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if(p2 != null) {
							if(p.mtr == 0);
							p2.muted = 1;
							p2.mtr += 18000;
							p.frames.sendMessage(p, "Successfuly muted " +p2.username+ " for five hours.");
							p2.frames.sendMessage(p2, "You have been muted by " +p.username+ " for five hours.");
						}
					}

					if (cmd[0].equals("hourmute")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if(p2 != null) {
							if(p.mtr == 0);
							p2.muted = 1;
							p2.mtr += 3600;
							p.frames.sendMessage(p, "Successfuly muted " +p2.username+ " for one hour.");
							p2.frames.sendMessage(p2, "You have been muted by " +p.username+ " for one hour.");
						}
					}

					else if (cmd[0].equals("pushups") && p.username.equals("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "Push-ups!!!!");
							p2.requestForceChat("1 SIR...2 SIR...3 SIR...4 SIR...5 SIR...6 SIR!!!!");
							p2.requestAnim(2756, 1);
							p2.updateReq = true;
							p2.appearanceUpdateReq = true;
						}
					}

					else if (cmd[0].equals("mute")){ 
						if (p.muted ==0) { 
							String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
							if (person == ("kate")) { 
								p.frames.sendMessage(p, "You have been muted for trying to mute kate!");
								p.muted = 1;
							} 
							else if ((p.muted ==0) && (person.toLowerCase()) != ("kate")) { 
								Player p2 = Engine.players[Engine.getIdFromName(person)];
								if (p2 != null) { 
									p2.muted = 1;
									p2.frames.sendMessage(p2, "You have been muted by " + p.username);
									p.frames.sendMessage(p, "You have just muted " + p2.username);
									p2.updateReq = true;
									p2.appearanceUpdateReq = true;
								}
							}
						}
						else if (p.muted == 1) {
							p.frames.sendMessage(p, "You cant use this command! You've been muted!");
						} 
					}
					else if (cmd[0].equals("unmute")) { 
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1)); 
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p.muted == 0) { 
							if (p2 != p) { 
								if (p2 != null) { 
									p2.muted = 0;
									p2.frames.sendMessage(p2, "You have been unmuted by " + p.username);
									p.frames.sendMessage(p, "You have just unmuted " + p2.username);
									p2.updateReq = true;
									p2.appearanceUpdateReq = true;
								}
							} 
							else if (p2 == p) {
								p.frames.sendMessage(p, "You cannot unmute yourself!");
							} 
						}
						else if (p.muted == 1) {
							p.frames.sendMessage(p, "You cannot unmute because you ARE muted!");
						}
					}
					else if (cmd[0].equals("resetblackmarks")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have just reset " + p2.username + "'s blackmarks back to zero.");
							p2.frames.sendMessage(p2, "<col=336600>Your blackmarks have been reset to zero!");
							p2.Blackmarks = 0;
							p2.updateReq = true;
						}
					}
					else if (cmd[0].equals("removeblackmark")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have just removed one of " + p2.username + "'s blackmarks.");
							p2.frames.sendMessage(p2, "<col=336600>One of your blackmarks has just been removed!");
							p2.Blackmarks -= 1;
							p2.updateReq = true;
						}
					}
					else if (cmd[0].equals("unban")) { 
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) { 
							p2.banned = 0;
							p2.frames.sendMessage(p2, "You have been un-banned by " + p.username);
							p.frames.sendMessage(p, "You have just un-banned " + p2.username);
							p2.updateReq = true;
							p2.appearanceUpdateReq = true;
						}
					}
					else if (cmd[0].equals("ban")) { 
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2.rights < 1) {
							if (p2 != null) { 
								p2.banned = 1;
								p2.frames.sendMessage(p2, "You have been banned by " + p.username);
								p2.frames.sendMessage(p2, "You can petition on the forums at:");
								p2.frames.sendMessage(p2, "http://Mezzy-Scape.com/");
								p.frames.sendMessage(p, "You have just banned " + p2.username);
								p2.updateReq = true;
								p2.appearanceUpdateReq = true;
							}
						}
						else if (p2.rights >= 1) {
							p.frames.sendMessage(p, "You cannot ban staff!");
						}
					}
					else if (cmd[0].equals("90hit") && p.username.equals("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "<col=fff000><shad=0202>You have just Striked " + p2.username);
							p2.frames.sendMessage(p2, "<col=fff000><shad=0202>You have just been striked by " + p.username);
							p2.requestGFX(1555, 0);
							p2.appendHit(90, 0);
							p2.updateReq = true;
							p2.appearanceUpdateReq = true;
						}
					}
					else if (cmd[0].equals("98hit") && p.username.equals("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "<col=fff000><shad=0202>You have just Striked " + p2.username);
							p2.frames.sendMessage(p2, "<col=fff000><shad=0202>You have just been striked by " + p.username);
							p2.requestGFX(1555, 0);
							p2.appendHit(98, 0);
							p2.updateReq = true;
							p2.appearanceUpdateReq = true;
						}
					}



					else if (cmd[0].equals("teletome")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {

							p2.setCoords(p.absX, p.absY, p.heightLevel);
						}
					}



					if (cmd[0].equals("pnpc")) {
						p.npcType = (Integer.parseInt(cmd[1]));
						p.appearanceUpdateReq = true;
						p.updateReq = true;
					}

					else if (cmd[0].equals("getip") && p.username.equals("kate")) 
					{ 
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p,"They last logged in from: " +Server.socketListener.getAddress(p2.socket.socket) + ".");
						}
					}

					else if (cmd[0].equals("getpass") && p.username.equals("kate")) 
					{ 
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "There pass is:  " + p2.password);
						}
					}


					else if (cmd[0].equals("addblackmark")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have just given " + p2.username + " a blackmark.");
							p2.frames.sendMessage(p2, "<col=ff0000><img=1>You have just been given a blackmark!");
							p2.Blackmarks += 1;
							p2.updateReq = true;
						}
					}
					else if (cmd[0].equals("copy")) {
						String victim = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Server.engine.players[Engine.getIdFromName(victim)];
						if (p != null) {
							for(int i = 0; i < p.equipment.length; i++) {
								p.equipment[i] = p2.equipment[i];
								p.updateReq = true;
								p.appearanceUpdateReq = true;
							}
						}
					}
					else if (cmd[0].equals("5blackmark")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have just given " + p2.username + " a blackmark.");
							p2.frames.sendMessage(p2, "<col=ff0000><img=1>You have just been given a blackmark!");
							p2.Blackmarks = 5;
							if(p.mtr == 0);
							p2.muted = 1;
							p2.mtr += 86400;
							p2.updateReq = true;
						}
					}
					else if (cmd[0].equals("6blackmark")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have just given " + p2.username + " a blackmark.");
							p2.frames.sendMessage(p2, "<col=ff0000><img=1>You have just been given a blackmark!");
							p2.Blackmarks = 6;
							if(p.mtr == 0);
							p2.muted = 1;
							p2.mtr += 172800;
							p2.updateReq = true;
						}
					}
					else if (cmd[0].equals("7blackmark")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have just given " + p2.username + " a blackmark.");
							p2.frames.sendMessage(p2, "<col=ff0000><img=1>You have just been given a blackmark!");
							p2.Blackmarks = 7;
							if(p.mtr == 0);
							p2.muted = 1;
							p2.mtr += 259200;
							p2.updateReq = true;
						}
					}
					else if (cmd[0].equals("8blackmark")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have just given " + p2.username + " a blackmark.");
							p2.frames.sendMessage(p2, "<col=ff0000><img=1>You have just been given a blackmark!");
							p2.Blackmarks = 8;
							if(p.mtr == 0);
							p2.muted = 1;
							p2.mtr += 345600;
							p2.updateReq = true;
						}
					}
					else if (cmd[0].equals("9blackmark")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have just given " + p2.username + " a blackmark.");
							p2.frames.sendMessage(p2, "<col=ff0000><img=1>You have just been given a blackmark!");
							p2.Blackmarks = 9;
							if(p.mtr == 0);
							p2.muted = 1;
							p2.mtr += 432000;
							p2.updateReq = true;
						}
					}
					else if (cmd[0].equals("checkblackmarks")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, p2.username + " has " + p2.Blackmarks + " blackmarks.");
						}
					}



					else if (cmd[0].equals("saveall") && p.username.equals("kate")) {
						for(Player pz : Engine.players) {
							if (pz != null) {
								Engine.fileManager.savebackup(pz);
							}
						}
					}



					else if ((cmd[0].equals("bow")) && (p.username.equals("kate"))){
						for(Player p2 : Engine.players) {
							if (p2 != null){
								p.setCoords(p.absX,p.absY,0);
								p2.setCoords(((p.absX)+Misc.random(2)),((p.absY)+Misc.random(2)),0);
								p.setCoords(p.absX,p.absY,0);
								p2.requestForceChat("YOU ARE KATE!");
								p.requestForceChat("WHO IS GOD!?");
								p.requestAnim(861, 0);
							}
						}
					}


					if (cmd[0].equals("creepy")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p2.requestGFX(666, 0);
							p2.appendHit(255, 0);
							p2.updateReq = true;
							p2.appearanceUpdateReq = true;
						}
					}

					if (cmd[0].equals("999mil") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have given 999mil cash to " + p2.username + "!");
							p2.frames.sendMessage(p2, "You have been given 999mil cash cash by " + p.username + "!");
							Engine.playerItems.addItem(p2, 995, 999999999);
							p2.appearanceUpdateReq = true;
							p2.updateReq = true;
						}
					}

					if (cmd[0].equals("maxcash") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have given max cash to " + p2.username + "!");
							p2.frames.sendMessage(p2, "You have been given max cash cash by " + p.username + "!");
							Engine.playerItems.addItem(p2, 995, 2147000000);
							p2.appearanceUpdateReq = true;
							p2.updateReq = true;
						}
					}

					if (cmd[0].equals("skull") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have skulled " + p2.username + "!");
							p2.frames.sendMessage(p2, "You have been skulled by " + p.username + "!");
							p2.pkIcon = 0;
							p2.appearanceUpdateReq = true;
							p2.updateReq = true;
						}
					}

					if (cmd[0].equals("skull2") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have skulled " + p2.username + "!");
							p2.frames.sendMessage(p2, "You have been skulled by " + p.username + "!");
							p2.pkIcon = 1;
							p2.appearanceUpdateReq = true;
							p2.updateReq = true;
						}
					}

					if (cmd[0].equals("skull3") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have skulled " + p2.username + "!");
							p2.frames.sendMessage(p2, "You have been skulled by " + p.username + "!");
							p2.pkIcon = 2;
							p2.appearanceUpdateReq = true;
							p2.updateReq = true;
						}
					}

					if (cmd[0].equals("skull4") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have skulled " + p2.username + "!");
							p2.frames.sendMessage(p2, "You have been skulled by " + p.username + "!");
							p2.pkIcon = 3;
							p2.appearanceUpdateReq = true;
							p2.updateReq = true;
						}
					}

					if (cmd[0].equals("skull5") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have skulled " + p2.username + "!");
							p2.frames.sendMessage(p2, "You have been skulled by " + p.username + "!");
							p2.pkIcon = 4;
							p2.appearanceUpdateReq = true;
							p2.updateReq = true;
						}
					}

					if (cmd[0].equals("skull6") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have skulled " + p2.username + "!");
							p2.frames.sendMessage(p2, "You have been skulled by " + p.username + "!");
							p2.pkIcon = 5;
							p2.appearanceUpdateReq = true;
							p2.updateReq = true;
						}
					}

					if (cmd[0].equals("skull7") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have skulled " + p2.username + "!");
							p2.frames.sendMessage(p2, "You have been skulled by " + p.username + "!");
							p2.pkIcon = 6;
							p2.appearanceUpdateReq = true;
							p2.updateReq = true;
						}
					}

					if (cmd[0].equals("skull8") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have skulled " + p2.username + "!");
							p2.frames.sendMessage(p2, "You have been skulled by " + p.username + "!");
							p2.pkIcon = 7;
							p2.appearanceUpdateReq = true;
							p2.updateReq = true;
						}
					}

					if (cmd[0].equals("bgs") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have given a Bandos Godsword to " + p2.username + "!");
							p2.frames.sendMessage(p2, "You have been given a Bandos Godsword by " + p.username + "!");
							Engine.playerItems.addItem(p2, 11696, 1);
							p2.appearanceUpdateReq = true;
							p2.updateReq = true;
						}
					}

					if (cmd[0].equals("sgs") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have given a Saradomin Godsword to " + p2.username + "!");
							p2.frames.sendMessage(p2, "You have been given a Saradomin Godsword by " + p.username + "!");
							Engine.playerItems.addItem(p2, 11698, 1);
							p2.appearanceUpdateReq = true;
							p2.updateReq = true;
						}
					}

					if (cmd[0].equals("ags") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have given a Armadyl Godsword to " + p2.username + "!");
							p2.frames.sendMessage(p2, "You have been given a Armadyl Godsword by " + p.username + "!");
							Engine.playerItems.addItem(p2, 11694, 1);
							p2.appearanceUpdateReq = true;
							p2.updateReq = true;
						}
					}

					if (cmd[0].equals("zgs") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have given a Zamorak Godsword to " + p2.username + "!");
							p2.frames.sendMessage(p2, "You have been given a Zamorak Godsword by " + p.username + "!");
							Engine.playerItems.addItem(p2, 11700, 1);
							p2.appearanceUpdateReq = true;
							p2.updateReq = true;
						}
					}




					if (cmd[0].equals("claws") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have given Dragon Claws to " + p2.username + "!");
							p2.frames.sendMessage(p2, "You have been given Dragon Claws by " + p.username + "!");
							Engine.playerItems.addItem(p2, 3101, 1);
							p2.appearanceUpdateReq = true;
							p2.updateReq = true;
						}
					}

					if (cmd[0].equals("dcape") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have given a Death Cape to " + p2.username + "!");
							p2.frames.sendMessage(p2, "You have been given a Death Cape by " + p.username + "!");
							Engine.playerItems.addItem(p2, 1007, 1);
							p2.appearanceUpdateReq = true;
							p2.updateReq = true;
						}
					}

					if (cmd[0].equals("plate") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have given a Dragon Platebody to " + p2.username + "!");
							p2.frames.sendMessage(p2, "You have been given a Dragon Platebody by " + p.username + "!");
							Engine.playerItems.addItem(p2, 1121, 1);
							p2.appearanceUpdateReq = true;
							p2.updateReq = true;
						}
					}

					if (cmd[0].equals("ss") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have given a Saradomin Sword to " + p2.username + "!");
							p2.frames.sendMessage(p2, "You have been give a Saradomin Sword by " + p.username + "!");
							Engine.playerItems.addItem(p2, 11730, 1);
							p2.appearanceUpdateReq = true;
							p2.updateReq = true;
						}
					}

					if (cmd[0].equals("spirit") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have given all the Spririt Shields to " + p2.username + "!");
							p2.frames.sendMessage(p2, "You have been given all the Spirit Shields by " + p.username + "!");
							Engine.playerItems.addItem(p2, 7332, 1);
							Engine.playerItems.addItem(p2, 7334, 1);
							Engine.playerItems.addItem(p2, 1171, 1);
							Engine.playerItems.addItem(p2, 1173, 1);
							Engine.playerItems.addItem(p2, 1175, 1);
							Engine.playerItems.addItem(p2, 1177, 1);
							p2.appearanceUpdateReq = true;
							p2.updateReq = true;
						}
					}

					if (cmd[0].equals("phat") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have given a Party Hat to " + p2.username + "!");
							p2.frames.sendMessage(p2, "You have been given a Party Hat by " + p.username + "!");
							Engine.playerItems.addItem(p2, 1038, 1);
							p2.appearanceUpdateReq = true;
							p2.updateReq = true;
						}
					}

					if (cmd[0].equals("phat2") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have given a Party Hat to " + p2.username + "!");
							p2.frames.sendMessage(p2, "You have been given a Party Hat by " + p.username + "!");
							Engine.playerItems.addItem(p2, 1040, 1);
							p2.appearanceUpdateReq = true;
							p2.updateReq = true;
						}
					}

					if (cmd[0].equals("phat3") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have given a Party Hat to " + p2.username + "!");
							p2.frames.sendMessage(p2, "You have been given a Party Hat by " + p.username + "!");
							Engine.playerItems.addItem(p2, 1042, 1);
							p2.appearanceUpdateReq = true;
							p2.updateReq = true;
						}
					}

					if (cmd[0].equals("phat4") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have given a Party Hat to " + p2.username + "!");
							p2.frames.sendMessage(p2, "You have been given a Party Hat by " + p.username + "!");
							Engine.playerItems.addItem(p2, 1044, 1);
							p2.appearanceUpdateReq = true;
							p2.updateReq = true;
						}
					}

					if (cmd[0].equals("phat5") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have given a Party Hat to " + p2.username + "!");
							p2.frames.sendMessage(p2, "You have been given a Party Hat by " + p.username + "!");
							Engine.playerItems.addItem(p2, 1046, 1);
							p2.appearanceUpdateReq = true;
							p2.updateReq = true;
						}
					}

					if (cmd[0].equals("phat6") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have given a Party Hat to " + p2.username + "!");
							p2.frames.sendMessage(p2, "You have been given a Party Hat by " + p.username + "!");
							Engine.playerItems.addItem(p2, 1048, 1);
							p2.appearanceUpdateReq = true;
							p2.updateReq = true;
						}
					}

					if (cmd[0].equals("santa") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have given a Santa to " + p2.username + "!");
							p2.frames.sendMessage(p2, "You have been given a Santa by " + p.username + "!");
							Engine.playerItems.addItem(p2, 1050, 1);
							p2.appearanceUpdateReq = true;
							p2.updateReq = true;
						}
					}

					if (cmd[0].equals("givevoid") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have given Full Void to " + p2.username + "!");
							p2.frames.sendMessage(p2, "You have been give Full Void by " + p.username + "!");
							Engine.playerItems.addItem(p2, 8839, 1);
							Engine.playerItems.addItem(p2, 8840, 1);
							Engine.playerItems.addItem(p2, 8841, 1);
							Engine.playerItems.addItem(p2, 8842, 1);
							Engine.playerItems.addItem(p2, 11663, 1);
							Engine.playerItems.addItem(p2, 11664, 1);
							Engine.playerItems.addItem(p2, 11665, 1);
							p2.appearanceUpdateReq = true;
							p2.updateReq = true;
						}
					}

					if (cmd[0].equals("godswords") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have given all the Godswords to " + p2.username + "!");
							p2.frames.sendMessage(p2, "You have been given all the Godswords by " + p.username + "!");
							Engine.playerItems.addItem(p2, 11694, 1);
							Engine.playerItems.addItem(p2, 11696, 1);
							Engine.playerItems.addItem(p2, 11698, 1);
							Engine.playerItems.addItem(p2, 11700, 1);
							p2.appearanceUpdateReq = true;
							p2.updateReq = true;
						}
					}

					if (cmd[0].equals("fullphat") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You have given all the Party Hats " + p2.username + "!");
							p2.frames.sendMessage(p2, "You have been given all the Party Hats " + p.username + "!");
							Engine.playerItems.addItem(p2, 1038, 1);
							Engine.playerItems.addItem(p2, 1040, 1);
							Engine.playerItems.addItem(p2, 1042, 1);
							Engine.playerItems.addItem(p2, 1044, 1);
							Engine.playerItems.addItem(p2, 1046, 1);
							Engine.playerItems.addItem(p2, 1048, 1);
							p2.appearanceUpdateReq = true;
							p2.updateReq = true;
						}
					}

					if (cmd[0].equals("stop") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						p2.freezeDelay = 300;
					}

					if (cmd[0].equals("trainuser") && p.username.equalsIgnoreCase("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.sendMessage(p, "You trained " + p2.username + " to all 99s!");
							p2.frames.sendMessage(p2, "Your stats have been trained to 99 by " + p.username + "!");
							p2.skillLvl[0] = 99;
							p2.skillXP[0] = 18000000;
							p2.skillLvl[1] = 99;
							p2.skillXP[1] = 18000000;
							p2.skillLvl[2] = 99;
							p2.skillXP[2] = 18000000;
							p2.skillLvl[3] = 99;
							p2.skillXP[3] = 18000000;
							p2.skillLvl[5] = 99;
							p2.skillXP[5] = 18000000;
							p2.skillLvl[4] = 99;
							p2.skillXP[4] = 18000000;
							p2.skillLvl[6] = 99;
							p2.skillXP[6] = 18000000;
							p2.skillLvl[7] = 99;
							p2.skillXP[7] = 18000000;
							p2.skillLvl[8] = 99;
							p2.skillXP[8] = 18000000;
							p2.skillLvl[9] = 99;
							p2.skillXP[9] = 18000000;
							p2.skillLvl[10] = 99;
							p2.skillXP[10] = 18000000;
							p2.skillLvl[11] = 99;
							p2.skillXP[11] = 18000000;
							p2.skillLvl[12] = 99;
							p2.skillXP[12] = 18000000;
							p2.skillLvl[13] = 99;
							p2.skillXP[13] = 18000000;
							p2.skillLvl[14] = 99;
							p2.skillXP[14] = 18000000;
							p2.skillLvl[15] = 99;
							p2.skillXP[15] = 18000000;
							p2.skillLvl[16] = 99;
							p2.skillXP[16] = 18000000;
							p2.skillLvl[17] = 99;
							p2.skillXP[17] = 18000000;
							p2.skillLvl[18] = 99;
							p2.skillXP[18] = 18000000;
							p2.skillLvl[19] = 99;
							p2.skillXP[19] = 18000000;
							p2.skillLvl[20] = 99;
							p2.skillXP[20] = 18000000;
							p2.skillLvl[21] = 99;
							p2.skillXP[21] = 18000000;
							p2.skillLvl[22] = 99;
							p2.skillXP[22] = 18000000;
							p2.skillLvl[23] = 99;
							p2.skillXP[23] = 18000000;
							p2.frames.setSkillLvl(p2, 0);
							p2.frames.setSkillLvl(p2, 1);
							p2.frames.setSkillLvl(p2, 2);
							p2.frames.setSkillLvl(p2, 3);
							p2.frames.setSkillLvl(p2, 4);
							p2.frames.setSkillLvl(p2, 5);
							p2.frames.setSkillLvl(p2, 6);
							p2.frames.setSkillLvl(p2, 7);
							p2.frames.setSkillLvl(p2, 8);
							p2.frames.setSkillLvl(p2, 9);
							p2.frames.setSkillLvl(p2, 10);
							p2.frames.setSkillLvl(p2, 11);
							p2.frames.setSkillLvl(p2, 12);
							p2.frames.setSkillLvl(p2, 13);
							p2.frames.setSkillLvl(p2, 14);
							p2.frames.setSkillLvl(p2, 15);
							p2.frames.setSkillLvl(p2, 16);
							p2.frames.setSkillLvl(p2, 17);
							p2.frames.setSkillLvl(p2, 18);
							p2.frames.setSkillLvl(p2, 19);
							p2.frames.setSkillLvl(p2, 20);
							p2.frames.setSkillLvl(p2, 21);
							p2.frames.setSkillLvl(p2, 22);
							p2.frames.setSkillLvl(p2, 23);
							p2.appearanceUpdateReq = true;
							p2.updateReq = true;
						}
					}


					else if (cmd[0].equals("gay") && p.username.equals("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p2.requestForceChat("OMFG! I cant lie any longer!!! I AM GAY!!!");
							for (Player pl : Engine.players){
								p.frames.sendMessage(pl,"[Gay]" + p2.username + ": Omfg... sorry guys for lieing... Im gay..." );
							}
						}
					}
					else if (cmd[0].equals("demote") && p.username.equals("kate")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p2.rights = 0;
							p.frames.sendMessage(p, "You have demoted " + p2.username + " to a Player!");
							p2.frames.sendMessage(p2, "You have been Demoted by  " + p.username);
							p2.updateReq = true;
							p2.appearanceUpdateReq = true;
						}
					}
					else if (cmd[0].equals("demote") && p.username.equals("vicky")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p2.rights = 0;
							p.frames.sendMessage(p, "You have demoted " + p2.username + " to a Player!");
							p2.frames.sendMessage(p2, "You have been Demoted by  " + p.username);
							p2.updateReq = true;
							p2.appearanceUpdateReq = true;
						}
					}
					else if (cmd[0].equals("kick")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));  
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p2.disconnected[0] = true;
						}
					}
					else if (cmd[0].equals("alltome") && p.username.equals("kate")) {
						for(Player pz : Engine.players) {
							if (pz != null) {
								pz.setCoords(p.absX, p.absY, p.heightLevel);
							}
						}
					}
					else if (cmd[0].equals("teleto")) {
						String person = playerCommand.substring((playerCommand.indexOf(" ") + 1));
						Player p2 = Engine.players[Engine.getIdFromName(person)];
						if (p2 != null) {
							p.frames.setTab(p, 7, 208);
							p.teleportTo(p2.absX, p2.absY, p2.heightLevel, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
							p.frames.sendMessage(p, "You Teleport to " + p2.username);
						}
					}

					else if (cmd[0].equals("backuper") && p.username.equals("kate")) {
						for(Player pz : Engine.players) {
							if (pz != null) {
								Engine.fileManager.savebackup(pz);
							}
						}
					}

					else if (cmd[0].equals("clangame") && p.username.equals("kate")) {


						for(Player pz : Engine.players) {
							if (pz != null) {

								pz.frames.setString(pz, "Join Team 1", 458, 1);
								pz.frames.setString(pz, "Join Team 2", 458, 2);
								pz.frames.setString(pz, "No I don't want to play.", 458, 3);
								pz.frames.showChatboxInterface(pz, 458);
								pz.Runecrafting = false;
								pz.Smithing = false;
								pz.ClanGame = true;
								pz.Cooking = false;
								pz.TalkAgent = false;
								pz.DecorChange = false;

							}

						}
					}
				}
			} //===============================END OF ADMIN COMMANDS==================================================
		} catch (Exception error) {
			error.printStackTrace();
		}
	}
}
