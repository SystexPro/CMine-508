

package Bulby.io;


import Bulby.Server;
import Bulby.Engine;
import Bulby.players.Player;
import Bulby.util.Misc;
import Bulby.io.packets.*;
import Bulby.Skills.*;
import Bulby.players.Magic;


public class PacketManager {
	public void AcceptCape(Player p,int Npc, String Name, int Hood, int Cape)
	{
		Engine.playerItems.addItem(p, Hood, 1);
		if(p.SkillCapes > 2) { Engine.playerItems.addItem(p, Cape+1, 1); } else { Engine.playerItems.addItem(p, Cape, 1); }
		p.Dialogue = 0;
		p.frames.showChatboxInterface(p, 241);
		p.frames.animateInterfaceId(p, 9850, 241, 2);
		p.frames.setNPCId(p, Npc, 241, 2);
		p.frames.setString(p, Name, 241, 3);
		p.frames.setString(p, "accept this cape as a reward.", 241, 4);
	}
	public void YouShould(Player p, int Npc, String Name, String Should)
	{
		p.Dialogue = 0;
		p.frames.showChatboxInterface(p, 241);
		p.frames.animateInterfaceId(p, 9760, 241, 2);
		p.frames.setNPCId(p, Npc, 241, 2);
		p.frames.setString(p, Name, 241, 3);
		p.frames.setString(p, Should, 241, 4);
	}
	/*
	 * Create all the packets for use.
	 */
	public Walking walk = new Walking();
	public PublicChat publicChat = new PublicChat();
	public Commands command = new Commands();
	public SwitchItems switchItems = new SwitchItems();
	public ActionButtons actionButtons = new ActionButtons();
	public Equipment equipment = new Equipment();
	public ItemOption1 itemOption1 = new ItemOption1();
	public ItemOperate itemOperate = new ItemOperate();
	public DropItem dropItem = new DropItem();
	public PickupItem pickupItem = new PickupItem();
	public PlayerOption1 playerOption1 = new PlayerOption1();
	public PlayerOption2 playerOption2 = new PlayerOption2();
	public PlayerOption3 playerOption3 = new PlayerOption3();
	public NPCAttack npcAttack = new NPCAttack();
	public MagicOnNPC magicOnNPC = new MagicOnNPC();
	public NPCOption1 npcOption1 = new NPCOption1();
	public NPCOption2 npcOption2 = new NPCOption2();
	public ItemOnItem itemOnItem = new ItemOnItem();
	public NPCOption3 npcOption3 = new NPCOption3();
	public MagicOnPlayer magicOnPlayer = new MagicOnPlayer();
	public ItemSelect itemSelect = new ItemSelect();
	public ObjectOption1 objectOption1 = new ObjectOption1();
	public ObjectOption2 objectOption2 = new ObjectOption2();
	public SwitchItems2 switchItems2 = new SwitchItems2();
	public Shopbuyconfig Shopbuyconfig = new Shopbuyconfig();
	public ItemOnObject ItemOnObject = new ItemOnObject();
	public ItemGive ItemGive = new ItemGive();

	/**
	 * Handle any packets.
	 * <p>Handles all packets within the range of 0 - 255. Not every
	 * packet has been setup, you'll have to do some yourself.
	 * @param p The Player which the frame should be created for.
	 * @param packetId The packet id to handle.
	 * @param packetSize The number of bytes the packet contains.
	 */
	public void parsePacket(Player p, int packetId, int packetSize) {
		if (p == null) {
			return;
		}
		if (p.clickDelay > 0 && packetId != 222) {

			/*
			 * When delayed only allow chatting.
			 */
			return;
		}
		//Misc.println("[" + p.username + "] Unhandled packet: " + packetId);
		switch (packetId) {
		case 24://magic on npc by I loot I aka Lootface
			MagicOnNPC.magicAop(p, packetId, packetSize);
			break;
		case 43:
			p.input.setInput(p.stream.readDWord());
			break;
		case 30:
			long name = p.stream.readQWord();
			if(p.friends.size() >= 200) {
				p.frames.sendMessage(p, "Your friends list is full.");
				break;
			}
			if(p.friends.contains((Long) name)) {
				p.frames.sendMessage(p, "Already on your friends list.");
				break;
			}
			p.friends.add((Long) name);
			p.frames.sendFriend(p, name, p.getWorld(name));
			break;
		case 61:
			name = p.stream.readQWord();
			if(p.ignores.size() >= 100) {
				p.frames.sendMessage(p, "Your ignore list is full.");
				break;
			}
			if(p.ignores.contains((Long) name)) {
				p.frames.sendMessage(p, "Already on your ignore list.");
				break;
			}
			p.ignores.add((Long) name);
			break;
		case 132:
			name = p.stream.readQWord();
			p.friends.remove((Long) name);
			break;
		case 2:
			name = p.stream.readQWord();
			p.ignores.remove((Long) name);
			break;
		case 178:
			name = p.stream.readQWord();
			int numChars = p.stream.readUnsignedByte();
			String text = Misc.decryptPlayerChat(p.stream, numChars);
			for(Player p2 : Engine.players) {
				if(p2 != null && p2.online) {
					if(Misc.stringToLong(p2.username) == name) {
						p2.frames.sendReceivedPrivateMessage(p2, Misc.stringToLong(p.username), p.rights, text);
						p.frames.sendSentPrivateMessage(p, name, text);
						return;
					}
				}
			}
			p.frames.sendMessage(p, "Player is currently offline.");
			break;
		case 115:

			/*
			 * This packet is constantly sent almost like a ping to verify the still exists.
			 */
			break;
		case 62: //Used to spawn objects.

			p.objects();
			break;

		case 40:
			itemOnItem.handlePacket(p, packetId, packetSize);
			break;
		case 22:

			/*
			 * Recieved every time updateReq is set to true.
			 */
			p.stream.readDWord(); // Junk? Same value every time.
			break;

		case 60:

			p.objects();
			break; 


		case 99:

			/*
			 * Unknown.
			 */
			p.stream.readUnsignedWordBigEndianA();
			p.stream.readUnsignedWordA();
			break;



		case 117:
		case 248:
		case 247: // Possibly a packet sent if the login  is successful.
			if(p.SkillCapes > 1) { //  AUTO SKILL CAPE TRIMMING



				if(Engine.playerItems.HasItemAmount(p, 9747, 1) == true)
				{
					Engine.playerItems.deleteItem(p, 9747, Engine.playerItems.getItemSlot(p, 9747), 1);
					Engine.playerItems.addItem(p, 9748, 1); 
				}
				if(Engine.playerItems.HasItemAmount(p, 9750, 1) == true)
				{
					Engine.playerItems.deleteItem(p, 9750, Engine.playerItems.getItemSlot(p, 9750), 1);
					Engine.playerItems.addItem(p, 9751, 1); 
				}
				if(Engine.playerItems.HasItemAmount(p, 9753, 1) == true)
				{
					Engine.playerItems.deleteItem(p, 9753, Engine.playerItems.getItemSlot(p, 9753), 1);
					Engine.playerItems.addItem(p, 9754, 1); 
				}
				if(Engine.playerItems.HasItemAmount(p, 9756, 1) == true)
				{
					Engine.playerItems.deleteItem(p, 9756, Engine.playerItems.getItemSlot(p, 9756), 1);
					Engine.playerItems.addItem(p, 9757, 1); 
				}
				if(Engine.playerItems.HasItemAmount(p, 9759, 1) == true)
				{
					Engine.playerItems.deleteItem(p, 9759, Engine.playerItems.getItemSlot(p, 9759), 1);
					Engine.playerItems.addItem(p, 9760, 1); 
				}
				if(Engine.playerItems.HasItemAmount(p, 9762, 1) == true)
				{
					Engine.playerItems.deleteItem(p, 9762, Engine.playerItems.getItemSlot(p, 9762), 1);
					Engine.playerItems.addItem(p, 9763, 1); 
				}
				if(Engine.playerItems.HasItemAmount(p, 9765, 1) == true)
				{
					Engine.playerItems.deleteItem(p, 9765, Engine.playerItems.getItemSlot(p, 9765), 1);
					Engine.playerItems.addItem(p, 9766, 1); 
				}
				if(Engine.playerItems.HasItemAmount(p, 9768, 1) == true)
				{
					Engine.playerItems.deleteItem(p, 9768, Engine.playerItems.getItemSlot(p, 9768), 1);
					Engine.playerItems.addItem(p, 9769, 1); 
				}
				if(Engine.playerItems.HasItemAmount(p, 9771, 1) == true)
				{
					Engine.playerItems.deleteItem(p, 9771, Engine.playerItems.getItemSlot(p, 9771), 1);
					Engine.playerItems.addItem(p, 9772, 1); 
				}
				if(Engine.playerItems.HasItemAmount(p, 9774, 1) == true)
				{
					Engine.playerItems.deleteItem(p, 9774, Engine.playerItems.getItemSlot(p, 9774), 1);
					Engine.playerItems.addItem(p, 9775, 1); 
				}
				if(Engine.playerItems.HasItemAmount(p, 9777, 1) == true)
				{
					Engine.playerItems.deleteItem(p, 9777, Engine.playerItems.getItemSlot(p, 9777), 1);
					Engine.playerItems.addItem(p, 9778, 1); 
				}
				if(Engine.playerItems.HasItemAmount(p, 9780, 1) == true)
				{
					Engine.playerItems.deleteItem(p, 9780, Engine.playerItems.getItemSlot(p, 9780), 1);
					Engine.playerItems.addItem(p, 9781, 1); 
				}
				if(Engine.playerItems.HasItemAmount(p, 9783, 1) == true)
				{
					Engine.playerItems.deleteItem(p, 9783, Engine.playerItems.getItemSlot(p, 9783), 1);
					Engine.playerItems.addItem(p, 9784, 1); 
				}
				if(Engine.playerItems.HasItemAmount(p, 9786, 1) == true)
				{
					Engine.playerItems.deleteItem(p, 9786, Engine.playerItems.getItemSlot(p, 9786), 1);
					Engine.playerItems.addItem(p, 9787, 1); 
				}
				if(Engine.playerItems.HasItemAmount(p, 9789, 1) == true)
				{
					Engine.playerItems.deleteItem(p, 9789, Engine.playerItems.getItemSlot(p, 9789), 1);
					Engine.playerItems.addItem(p, 9790, 1); 
				}
				if(Engine.playerItems.HasItemAmount(p, 9792, 1) == true)
				{
					Engine.playerItems.deleteItem(p, 9792, Engine.playerItems.getItemSlot(p, 9792), 1);
					Engine.playerItems.addItem(p, 9793, 1); 
				}
				if(Engine.playerItems.HasItemAmount(p, 9795, 1) == true)
				{
					Engine.playerItems.deleteItem(p, 9795, Engine.playerItems.getItemSlot(p, 9795), 1);
					Engine.playerItems.addItem(p, 9796, 1); 
				}
				if(Engine.playerItems.HasItemAmount(p, 9798, 1) == true)
				{
					Engine.playerItems.deleteItem(p, 9798, Engine.playerItems.getItemSlot(p, 9798), 1);
					Engine.playerItems.addItem(p, 9799, 1); 
				}
				if(Engine.playerItems.HasItemAmount(p, 9801, 1) == true)
				{
					Engine.playerItems.deleteItem(p, 9801, Engine.playerItems.getItemSlot(p, 9801), 1);
					Engine.playerItems.addItem(p, 9802, 1); 
				}
				if(Engine.playerItems.HasItemAmount(p, 9804, 1) == true)
				{
					Engine.playerItems.deleteItem(p, 9804, Engine.playerItems.getItemSlot(p, 9804), 1);
					Engine.playerItems.addItem(p, 9805, 1); 
				}
				if(Engine.playerItems.HasItemAmount(p, 9807, 1) == true)
				{
					Engine.playerItems.deleteItem(p, 9807, Engine.playerItems.getItemSlot(p, 9807), 1);
					Engine.playerItems.addItem(p, 9808, 1); 
				}
				if(Engine.playerItems.HasItemAmount(p, 9810, 1) == true)
				{
					Engine.playerItems.deleteItem(p, 9810, Engine.playerItems.getItemSlot(p, 9810), 1);
					Engine.playerItems.addItem(p, 9811, 1); 
				}
				if(Engine.playerItems.HasItemAmount(p, 9948, 1) == true)
				{
					Engine.playerItems.deleteItem(p, 9948, Engine.playerItems.getItemSlot(p, 9948), 1);
					Engine.playerItems.addItem(p, 9949, 1); 
				}
				if(Engine.playerItems.HasItemAmount(p, 12169, 1) == true)
				{
					Engine.playerItems.deleteItem(p, 12169, Engine.playerItems.getItemSlot(p, 12169), 1);
					Engine.playerItems.addItem(p, 12170, 1); 
				}
			}
			/*
			 * Unknown.
			 */
			break;

		case 59: 
			//Misc.println("[" + p.username + "] Unhandled packet: " + packetId);
			/*
			 * Send every time you click your mouse.
			 */
			p.stream.readUnsignedWord();
			p.stream.readDWord_v1();
			break;

		case 253:
			int playerId = p.stream.readUnsignedWord();
			playerId -= 33024;
			playerId = playerId / 256;
			playerId++;
			if (playerId < 0 || playerId >= Engine.players.length || Engine.players[playerId] == null) {
				return;
			}
			if (Engine.players[playerId].pTrade.getPartner() == p) {
				p.pTrade.tradePlayer(Engine.players[playerId]);
			}

			break;

		case 49:

			p.Dialogue = 0;
			p.wc.resetWoodcutting();
			p.mi.resetMining();
			p.ResetSkillSuff();
			p.viewings = 0;
			p.frames.removeShownInterface(p);
			p.frames.setTab(p, 84, 261); // Setting tab
			p.frames.removeChatboxInterface(p);

			/*
			 * Main map walking.
			 */
		case 119:
			if(
					p.interfaceId==762 || 
					p.interfaceId==335 || 
					p.interfaceId==334 || 
					p.interfaceId==620) {
				return;
			}

			/*
			 * Minimap walking.
			 */
		case 138:

			/*
			 * Other walking.
			 */
			 p.Dialogue = 0;
			 p.wc.resetWoodcutting();
			 p.mi.resetMining();
			 p.ResetSkillSuff();
			 p.viewings = 0;
			 p.frames.removeShownInterface(p);
			 p.frames.setTab(p, 84, 261); // Setting tab
			 p.frames.removeChatboxInterface(p);




			 p.followPlayer = 0; // This Will make the following stop when you walk away
			 p.followingPlayer = false;

			 walk.handlePacket(p, packetId, packetSize);
			 break;

		case 222:

			/*
			 * Public chatting.
			 */
			publicChat.handlePacket(p, packetId, packetSize);
			break;

		case 107:

			/*
			 * When you type text starting with ::, its sent with this packet Id rather than as 
			 * Normal chat.
			 */
			command.handlePacket(p, packetId, packetSize);
			break;

		case 167:

			/*
			 * Switching items on interfaces.
			 */
			switchItems.handlePacket(p, packetId, packetSize);
			break;

		case 233:
		case 113:
		case 21:
		case 169:
		case 232:
		case 214:
		case 90:
		case 173:
		case 133:
		case 226:
		case 102:
			/*
			 * When you click an interface button this packet is sent.
			 */
			actionButtons.handlePacket(p, packetId, packetSize);
			break;

		case 3:

			/*
			 * Equipping an item.
			 */
			equipment.handlePacket(p, packetId, packetSize);
			break;

		case 203:
		case 152:

			/*
			 * Item options 1.
			 */
			itemOption1.handlePacket(p, packetId, packetSize);
			break;

		case 131:
			ItemGive.handlePacket(p, packetId, packetSize);
			break;

		case 186:
			/*
			 * Item operating.
			 */
			if(p.viewings == 0) {
				itemOperate.handlePacket(p, packetId, packetSize);
			} else {

				Shopbuyconfig.handlePacket(p, packetId, packetSize);
			}

		case 211:

			/*
			 * Dropping an item.
			 */
			dropItem.handlePacket(p, packetId, packetSize);
			break;

		case 201:

			/*
			 * Picking an item up.
			 */
			pickupItem.handlePacket(p, packetId, packetSize);
			break;

		case 160:

			/*
			 * First option on a player.
			 */
			playerOption1.handlePacket(p, packetId, packetSize);
			break;

		case 37:

			/*
			 * Second option on a player.
			 */
			playerOption2.handlePacket(p, packetId, packetSize);
			break;

		case 46:
			p.frames.showInterface(p, 109);
			break;

		case 227:

			/*
			 * Third option on a player.
			 */
			playerOption3.handlePacket(p, packetId, packetSize);
			break;

		case 123:

			/*
			 * NPC attack option.
			 */
			npcAttack.handlePacket(p, packetId, packetSize);
			break;

		case 7:

			/*
			 * NPC first option.
			 */
			npcOption1.handlePacket(p, packetId, packetSize);
			break;


		case 220:
		case 134:

			/*
			 * Item eating, drinking, etc.
			 */
			itemSelect.handlePacket(p, packetId, packetSize);
			break;

		case 158:

			/*
			 * Object first option.
			 */
			objectOption1.handlePacket(p, packetId, packetSize);
			break;

		case 154:



			Magic.MagicOnItemHandle(p, packetId, packetSize);

			break;
		case 70:

			Magic.magicAop(p, packetId, packetSize);
			break;

		case 165:

			/*
			 * Settings buttons, such as music volume.
			 */
			p.stream.readDWord_v2();
			break;

		case 108:
			/*
			 * Remove open interfaces.
			 */
			if(p.Update == 0)
			{
				p.Update = 1;
				p.frames.showInterface(p, 132);
				p.frames.setString(p, "NineScape has been updated!", 132, 45);
				p.frames.setString(p, "100% Working Trade!!!!", 132, 1);
				p.frames.setString(p, "After you trade you must bank and click the x", 132, 2);
				p.frames.setString(p, "in order to get back to your invintory", 132, 3);
				p.frames.setString(p, "New home added", 132, 4);
				p.frames.setString(p, "Commands Added! ::edge, ::godwars and ::bh", 132, 5);
				p.frames.setString(p, "Added ::bandosarmor, ::armadylarmor, ::xrichie", 132, 6);
				p.frames.setString(p, "Added ::shop command!", 132, 7);
				p.frames.setString(p, "", 132, 8);
				p.frames.setString(p, "", 132, 9);
				p.frames.setString(p, "", 132, 10);
				p.frames.setString(p, "", 132, 11);

				p.frames.setString(p, "1:", 132, 13);
				p.frames.setString(p, "", 132, 16);
				p.frames.setString(p, "", 132, 19);
				p.frames.setString(p, "2:", 132, 22);
				p.frames.setString(p, "3:", 132, 25);
				p.frames.setString(p, "4:", 132, 28);
				p.frames.setString(p, "5:", 132, 31);
				p.frames.setString(p, "", 132, 34);
				p.frames.setString(p, "", 132, 37);
				p.frames.setString(p, "", 132, 40);
				p.frames.setString(p, "", 132, 43);
			}
			else
				if(p.Update == 1)
				{
					p.Update = 2;
					p.frames.showInterface(p, 132);
					p.frames.setString(p, "NineScape has been updated", 132, 45);
					p.frames.setString(p, "Amulet of Glory can teleport you!", 132, 1);
					p.frames.setString(p, "added kalphiete queen.", 132, 2);
					p.frames.setString(p, "added full lumbridge!", 132, 3);
					p.frames.setString(p, "::reportbug [message]", 132, 4);
					p.frames.setString(p, "::reportabuse [who and why]", 132, 5);
					p.frames.setString(p, "::suggestion [suggestion for server]", 132, 6);
					p.frames.setString(p, "Added More Commands", 132, 7);
					p.frames.setString(p, "Added ::shop command!", 132, 8);
					p.frames.setString(p, "", 132, 9);
					p.frames.setString(p, "", 132, 10);
					p.frames.setString(p, "", 132, 11);

					p.frames.setString(p, "1:", 132, 13);
					p.frames.setString(p, "2:", 132, 16);
					p.frames.setString(p, "3:", 132, 19);
					p.frames.setString(p, "4:", 132, 22);
					p.frames.setString(p, "5:", 132, 25);
					p.frames.setString(p, "6:", 132, 28);
					p.frames.setString(p, "", 132, 31);
					p.frames.setString(p, "", 132, 34);
					p.frames.setString(p, "", 132, 37);
					p.frames.setString(p, "", 132, 40);
					p.frames.setString(p, "", 132, 43);
				}
				else
				{
					p.viewings = 0;
					p.frames.removeShownInterface(p);
					p.frames.setTab(p, 84, 261); // Setting tab
				}
			break;

		case 63:
			//Misc.println("[" + p.username + "] Unhandled packet: " + packetId);



			if(p.Dialogue == 1) { AcceptCape(p, 2270, "Martin Thwait", 9779, 9777); }
			else
				if(p.Dialogue == 2) { YouShould(p, 2270, "Martin Thwait", "steal from these people here, if you know what I mean..."); }
				else
					if(p.Dialogue == 3) { AcceptCape(p, 1658, "Robe Store Owner", 9764, 9762); }
					else
						if(p.Dialogue == 4) { YouShould(p, 1658, "Robe Store Owner", "High alch, its a great way to level up!"); }
						else
							if(p.Dialogue == 5) { AcceptCape(p, 7950, "Melee Tutor", 9755, 9753); }
							else
								if(p.Dialogue == 6) { YouShould(p, 7950, "Melee Tutor", "Train it by yourself."); }
								else
									if(p.Dialogue == 7) { AcceptCape(p, 4288, "Ajjat", 9749, 9747); }
									else
										if(p.Dialogue == 8) { YouShould(p, 4288, "Ajjat", "Train it by yourself."); }
										else
											if(p.Dialogue == 9) { AcceptCape(p, 4297, "Sloane", 9752, 9750); }
											else
												if(p.Dialogue == 10) { YouShould(p, 4297, "Sloane", "Train it by yourself."); }
												else
													if(p.Dialogue == 11) { AcceptCape(p, 961, "Surgeon General Tafani", 9770, 9768); }
													else
														if(p.Dialogue == 12) { YouShould(p, 961, "Surgeon General Tafani", "Train it by yourself."); }
														else
															if(p.Dialogue == 13) { AcceptCape(p, 308, "Master Fisher", 9800, 9798); }
															else
																if(p.Dialogue == 14) {
																	Engine.playerItems.addItem(p, 305, 1);
																	Engine.playerItems.addItem(p, 307, 1);
																	Engine.playerItems.addItem(p, 301, 1);
																	Engine.playerItems.addItem(p, 311, 1);
																	p.Dialogue = 0;
																	p.frames.showChatboxInterface(p, 241);
																	p.frames.animateInterfaceId(p, 9760, 241, 2);
																	p.frames.setNPCId(p, 308, 241, 2);
																	p.frames.setString(p, "Master Fisher", 241, 3);
																	p.frames.setString(p, "take these supplies, and go fish outside...", 241, 4);
																}
																else
																	if(p.Dialogue == 15) { AcceptCape(p, 4906, "Woodcutting Tutor", 9809, 9807); }
																	else
																		if(p.Dialogue == 16) {
																			Engine.playerItems.addItem(p, 1359, 1);
																			p.Dialogue = 0;
																			p.frames.showChatboxInterface(p, 241);
																			p.frames.animateInterfaceId(p, 9760, 241, 2);
																			p.frames.setNPCId(p, 4906, 241, 2);
																			p.frames.setString(p, "Woodcutting Tutor", 241, 3);
																			p.frames.setString(p, "take this axe, and cut some trees...", 241, 4);
																		}
																		else
																			if(p.Dialogue == 17) { AcceptCape(p, 3295, "Dwarf", 9794, 9792); }
																			else
																				if(p.Dialogue == 18) {
																					Engine.playerItems.addItem(p, 1275, 1);
																					p.Dialogue = 0;
																					p.frames.showChatboxInterface(p, 241);
																					p.frames.animateInterfaceId(p, 9850, 241, 2);
																					p.frames.setNPCId(p, 3295, 241, 2);
																					p.frames.setString(p, "Dwarf", 241, 3);
																					p.frames.setString(p, "take this pickaxe, and mine some rocks!", 241, 4);
																				}
																				else
																					if(p.Dialogue == 19) { AcceptCape(p, 802, "Brother Jered", 9761, 9759); }
																					else
																						if(p.Dialogue == 20) {
																							if(p.skillLvl[5] > 69)
																							{
																								Engine.playerItems.addItem(p, 536, 28);
																							}
																							else
																							{
																								Engine.playerItems.addItem(p, 526, 28);
																							}
																							p.Dialogue = 0;
																							p.frames.showChatboxInterface(p, 241);
																							p.frames.animateInterfaceId(p, 9850, 241, 2);
																							p.frames.setNPCId(p, 802, 241, 2);
																							p.frames.setString(p, "Brother Jered", 241, 3);
																							p.frames.setString(p, "bury this load of bones I found.", 241, 4);
																						}
																						else
																							if(p.Dialogue == 21) { AcceptCape(p, 553, "Aubury", 9767, 9765); }
																							else
																								if(p.Dialogue == 22) { YouShould(p, 553, "Aubury", "craft runes at the rune altar. I can teleport you there."); }
																								else
																									if(p.Dialogue == 23) { AcceptCape(p, 682, "Armour salesman", 9758, 9756); }
																									else
																										if(p.Dialogue == 24) { YouShould(p, 682, "Armour salesman", "talk to the Range Tutor..."); }
																										else
																											if(p.Dialogue == 25) { 
																												p.Dialogue = 0;
																												p.frames.showChatboxInterface(p, 241);
																												p.frames.animateInterfaceId(p, 9760, 241, 2);
																												p.frames.setNPCId(p, 1861, 241, 2);
																												p.frames.setString(p, "Range Tutor", 241, 3);
																												p.frames.setString(p, "and attack enemys with your bow and arrows.", 241, 4);
																											}
																											else
																												if(p.Dialogue == 26) { AcceptCape(p, 4946, "Ignatius Vulcan", 9806, 9804); }
																												else
																													if(p.Dialogue == 27) {
																														Engine.playerItems.addItem(p, 590, 1);
																														p.Dialogue = 0;
																														p.frames.showChatboxInterface(p, 241);
																														p.frames.animateInterfaceId(p, 9850, 241, 2);
																														p.frames.setNPCId(p, 4946, 241, 2);
																														p.frames.setString(p, "Ignatius Vulcan", 241, 3);
																														p.frames.setString(p, "take this tinderbox, and light some logs!", 241, 4);
																													}
																													else
																														if(p.Dialogue == 28) { AcceptCape(p, 575, "Hickton", 9785, 9783); }
																														else
																															if(p.Dialogue == 29) {
																																Engine.playerItems.addItem(p, 946, 1);
																																p.Dialogue = 0;
																																p.frames.showChatboxInterface(p, 241);
																																p.frames.animateInterfaceId(p, 9760, 241, 2);
																																p.frames.setNPCId(p, 575, 241, 2);
																																p.frames.setString(p, "Hickton", 241, 3);
																																p.frames.setString(p, "take this knife, and carve some logs.", 241, 4);
																															}
																															else
																																if(p.Dialogue == 800) {
																																	p.Dialogue = 801;
																																	p.frames.showChatboxInterface(p, 242);
																																	p.frames.animateInterfaceId(p, 9775, 242, 2);
																																	p.frames.setNPCId(p, 5925, 242, 2);
																																	p.frames.setString(p, "Benny", 242, 3);
																																	p.frames.setString(p, "It's located in the Wilderniss.", 242, 4);
																																	p.frames.setString(p, "Be carefull!", 242, 5);
																																}
																																else
																																	if(p.Dialogue == 32) { AcceptCape(p, 437, "Cap'n Izzy No-Beard", 9773, 9771); }
																																	else
																																		if(p.Dialogue == 33) { YouShould(p, 437, "Cap'n Izzy No-Beard", "do this agility course alot..."); }
																																		else
																																			if(p.Dialogue == 34) { AcceptCape(p, 805, "Master Crafter", 9782, 9780); }
																																			else
																																				if(p.Dialogue == 35) { YouShould(p, 805, "Master Crafter", "buy some crafting suplies from the crafting tutor."); }
																																				else
																																					if(p.Dialogue == 36) { AcceptCape(p, 455, "Kaqemeex", 9776, 9774); }
																																					else
																																						if(p.Dialogue == 37) {
																																							if(p.skillLvl[5] > 69)
																																							{
																																								Engine.playerItems.addItem(p, 207, 28);
																																							}
																																							else
																																							{
																																								Engine.playerItems.addItem(p, 199, 28);
																																							}
																																							p.Dialogue = 0;
																																							p.frames.showChatboxInterface(p, 241);
																																							p.frames.animateInterfaceId(p, 9850, 241, 2);
																																							p.frames.setNPCId(p, 455, 241, 2);
																																							p.frames.setString(p, "Kaqemeex", 241, 3);
																																							p.frames.setString(p, "clean these leaves for me.", 241, 4);
																																						}
																																						else
																																							if(p.Dialogue == 38) { AcceptCape(p, 5113, "Hunting Expert", 9950, 9948); }
																																							else
																																								if(p.Dialogue == 39) {
																																									Engine.playerItems.addItem(p, 11259, 1);
																																									p.Dialogue = 0;
																																									p.frames.showChatboxInterface(p, 241);
																																									p.frames.animateInterfaceId(p, 9760, 241, 2);
																																									p.frames.setNPCId(p, 5113, 241, 2);
																																									p.frames.setString(p, "Hunting Expert", 241, 3);
																																									p.frames.setString(p, "take this net, and catch the implings around here.", 241, 4);
																																								}
																																								else
																																									if(p.Dialogue == 40) { AcceptCape(p, 847, "Head Chef", 9803, 9801); }
																																									else
																																										if(p.Dialogue == 41) { YouShould(p, 847, "Head Chef", "cook fish at the cooking range right there..."); }
																																										else
																																											if(p.Dialogue == 42) { AcceptCape(p, 604, "Thurgo", 9797, 9795); }
																																											else
																																												if(p.Dialogue == 43) { YouShould(p, 604, "Thurgo", "use your ores with pottery oven to smelt them..."); }
																																												else
																																													if(p.Dialogue == 44) { AcceptCape(p, 1599, "Duradel", 9788, 9786); }
																																													else
																																														if(p.Dialogue == 45) { YouShould(p, 1599, "Duradel", "kill monsters from the slayer task I give you..."); }
																																														else
																																															if(p.Dialogue == 50) {
																																																p.Dialogue = 0;
																																																if(p.skillLvl[19] < 40)
																																																{
																																																	Engine.playerItems.addItem(p, 5096, 1);
																																																	p.frames.showChatboxInterface(p, 241);
																																																	p.frames.animateInterfaceId(p, 9760, 241, 2);
																																																	p.frames.setNPCId(p, 3299, 241, 2);
																																																	p.frames.setString(p, "Master Gardener", 241, 3);
																																																	p.frames.setString(p, "I need you to plant this Marigold seed on the flower patch.", 241, 4);
																																																}
																																																if(p.skillLvl[19] < 60 && p.skillLvl[19] > 39)
																																																{
																																																	Engine.playerItems.addItem(p, 5283, 1);
																																																	p.frames.showChatboxInterface(p, 241);
																																																	p.frames.animateInterfaceId(p, 9760, 241, 2);
																																																	p.frames.setNPCId(p, 3299, 241, 2);
																																																	p.frames.setString(p, "Master Gardener", 241, 3);
																																																	p.frames.setString(p, "I need you to plant this Apple seed on the herb patch.", 241, 4);
																																																}
																																																if(p.skillLvl[19] < 80 && p.skillLvl[19] > 59)
																																																{
																																																	Engine.playerItems.addItem(p, 5100, 1);
																																																	p.frames.showChatboxInterface(p, 241);
																																																	p.frames.animateInterfaceId(p, 9760, 241, 2);
																																																	p.frames.setNPCId(p, 3299, 241, 2);
																																																	p.frames.setString(p, "Master Gardener", 241, 3);
																																																	p.frames.setString(p, "I need you to plant this Limpwurt seed on the flower patch.", 241, 4);
																																																}
																																																if(p.skillLvl[19] > 79)
																																																{
																																																	Engine.playerItems.addItem(p, 5288, 1);
																																																	p.frames.showChatboxInterface(p, 241);
																																																	p.frames.animateInterfaceId(p, 9760, 241, 2);
																																																	p.frames.setNPCId(p, 3299, 241, 2);
																																																	p.frames.setString(p, "Master Gardener", 241, 3);
																																																	p.frames.setString(p, "I need you to plant this Papaya seed on the herb patch.", 241, 4);
																																																}
																																															}
																																															else
																																																if(p.Dialogue == 51) { AcceptCape(p, 3299, "Master Gardener", 9812, 9810); }
																																																else
																																																	if(p.Dialogue == 52) { AcceptCape(p, 4247, "Estate Agent", 9791, 9789); }
																																																	else
																																																		if(p.Dialogue == 53) { YouShould(p, 4247, "Estate Agent", "go in your house, turn building mode on, and build!"); }
																																																		else
																																																			if(p.Dialogue == 54) { AcceptCape(p, 6970, "Pikkupstix", 12171, 12169); }
																																																			else
																																																				if(p.Dialogue == 55) { YouShould(p, 6970, "Pikkupstix", "purchase my pouches and summon them for xp!"); }
																																																				else
																																																					if(p.Dialogue == 100) {
																																																						p.Dialogue = 101;
																																																						p.frames.showChatboxInterface(p, 241);
																																																						p.frames.animateInterfaceId(p, 9850, 241, 2);
																																																						p.frames.setNPCId(p, 198, 241, 2);
																																																						p.frames.setString(p, "Guildmaster", 241, 3);
																																																						p.frames.setString(p, "Well then speak to Oziach in Edgeville.", 241, 4);
																																																					}
																																																					else
																																																						if(p.Dialogue == 101) {
																																																							p.Dialogue = 0;
																																																							p.DragonSlayer = 1;
																																																							p.frames.showChatboxInterface(p, 241);
																																																							p.frames.animateInterfaceId(p, 9850, 241, 2);
																																																							p.frames.setNPCId(p, 198, 241, 2);
																																																							p.frames.setString(p, "Guildmaster", 241, 3);
																																																							p.frames.setString(p, "He should have a mighty quest for you!", 241, 4);
																																																						}
																																																						else
																																																							if(p.Dialogue == 102) {
																																																								p.Dialogue = 103;
																																																								p.frames.showChatboxInterface(p, 241);
																																																								p.frames.animateInterfaceId(p, 9850, 241, 2);
																																																								p.frames.setNPCId(p, 198, 241, 2);
																																																								p.frames.setString(p, "Guildmaster", 241, 3);
																																																								p.frames.setString(p, "You will need a map, ship, and somthing to", 241, 4);
																																																							}
																																																							else
																																																								if(p.Dialogue == 103) {
																																																									p.Dialogue = 104;
																																																									p.DragonSlayer = 3;
																																																									p.frames.showChatboxInterface(p, 241);
																																																									p.frames.animateInterfaceId(p, 9850, 241, 2);
																																																									p.frames.setNPCId(p, 198, 241, 2);
																																																									p.frames.setString(p, "Guildmaster", 241, 3);
																																																									p.frames.setString(p, "protect you from dragon fire breath.", 241, 4);
																																																								}
																																																								else
																																																									if(p.Dialogue == 104) {
																																																										p.Dialogue = 0;
																																																										p.frames.setString(p, "How can I find a route to Crandor?", 458, 1);
																																																										p.frames.setString(p, "Where can I find the right ship?", 458, 2);
																																																										p.frames.setString(p, "How can I protect myself from the dragon's breath?", 458, 3);
																																																										p.frames.showChatboxInterface(p, 458);
																																																										p.Smithing = false;
																																																										p.Cooking = false;
																																																										p.TalkAgent = false;
																																																										p.DecorChange = false;
																																																										p.Choice = 1;
																																																									}
																																																									else
																																																										if(p.Dialogue == 105) {
																																																											p.Dialogue = 106;
																																																											p.frames.showChatboxInterface(p, 241);
																																																											p.frames.animateInterfaceId(p, 9850, 241, 2);
																																																											p.frames.setNPCId(p, 747, 241, 2);
																																																											p.frames.setString(p, "Oziach", 241, 3);
																																																											p.frames.setString(p, "There is somthing you could do...", 241, 4);
																																																										}
																																																										else
																																																											if(p.Dialogue == 106) {
																																																												p.Dialogue = 0;
																																																												p.QuestPoints = 3;
																																																												p.frames.showChatboxInterface(p, 241);
																																																												p.frames.animateInterfaceId(p, 9850, 241, 2);
																																																												p.frames.setNPCId(p, 8000, 241, 2);
																																																												p.frames.setString(p, "Goth leprechaun", 241, 3);
																																																												p.frames.setString(p, "You've gotten your points go away.", 241, 4);
																																																											}
																																																											else
																																																												if(p.Dialogue == 106) {
																																																													p.Dialogue = 107;
																																																													p.frames.showChatboxInterface(p, 241);
																																																													p.frames.animateInterfaceId(p, 9850, 241, 2);
																																																													p.frames.setNPCId(p, 747, 241, 2);
																																																													p.frames.setString(p, "Oziach", 241, 3);
																																																													p.frames.setString(p, "Kill Elvarg the dragon on crandor island.", 241, 4);
																																																												}
																																																												else
																																																													if(p.Dialogue == 107) {
																																																														p.Dialogue = 0;
																																																														p.DragonSlayer = 2;
																																																														p.frames.showChatboxInterface(p, 241);
																																																														p.frames.animateInterfaceId(p, 9850, 241, 2);
																																																														p.frames.setNPCId(p, 747, 241, 2);
																																																														p.frames.setString(p, "Oziach", 241, 3);
																																																														p.frames.setString(p, "Go back to the guild master, he can help.", 241, 4);
																																																													}
																																																													else
																																																														if(p.Dialogue == 108) {
																																																															p.Dialogue = 0;
																																																															Engine.playerItems.addItem(p, 1538, 1);
																																																															p.frames.showChatboxInterface(p, 241);
																																																															p.frames.animateInterfaceId(p, 9850, 241, 2);
																																																															p.frames.setNPCId(p, 746, 241, 2);
																																																															p.frames.setString(p, "Oracle", 241, 3);
																																																															p.frames.setString(p, "Well here it is...good thing I didnt loose it.", 241, 4);
																																																														}
																																																														else
																																																															if(p.Dialogue == 109) {
																																																																p.setCoords(3048, 3208, 1);
																																																																p.Dialogue = 0;
																																																																p.BoatTimer = 6;
																																																																p.frames.showInterface(p, 544);
																																																																p.frames.removeChatboxInterface(p);
																																																															}
																																																															else
																																																																if(p.Dialogue == 110) {
																																																																	p.Dialogue = 0;
																																																																	p.QuestPoints += 2;
																																																																	p.DragonSlayer = 5;
																																																																	p.addSkillXP(30000 ,0);
																																																																	p.addSkillXP(30000 ,2);
																																																																	p.frames.showInterface(p, 277);
																																																																	p.frames.setString(p, "Congratulations!", 277, 3);
																																																																	p.frames.setString(p, "You have completed the Dragon Slayer quest!", 277, 4);
																																																																	p.frames.setString(p, "Quest Points: 2", 277, 6);
																																																																	p.frames.setString(p, ""+p.QuestPoints, 277, 7);
																																																																	p.frames.setString(p, "2 Quest Points", 277, 10);
																																																																	p.frames.setString(p, "Ability to wear rune platebody", 277, 11);
																																																																	p.frames.setString(p, "Ability to wear dragon chainbody", 277, 12);
																																																																	p.frames.setString(p, "30,000 Strength XP", 277, 13);
																																																																	p.frames.setString(p, "30,000 Attack XP", 277, 14);
																																																																	p.frames.setString(p, "", 277, 15);
																																																																	p.frames.setString(p, "", 277, 16);
																																																																	p.frames.setString(p, "", 277, 17);
																																																																	p.frames.removeChatboxInterface(p);
																																																																}
																																																																else
																																																																	if(p.Dialogue == 111) {
																																																																		Engine.playerItems.addItem(p, 9814, 1);
																																																																		Engine.playerItems.addItem(p, 9813, 1);
																																																																		p.Dialogue = 0;
																																																																		p.frames.showChatboxInterface(p, 241);
																																																																		p.frames.animateInterfaceId(p, 9850, 241, 2);
																																																																		p.frames.setNPCId(p, 2567, 241, 2);
																																																																		p.frames.setString(p, "Wise Old Man", 241, 3);
																																																																		p.frames.setString(p, "Take this cape as a reward!", 241, 4);
																																																																	}
																																																																	else
																																																																	{


																																																																		p.Dialogue = 0;

																																																																		if(p.chatboxInterfaceId == 740) {
																																																																			//p.frames.setConfig(p, 1179, Misc.getFlashingIcon(p.leveledUpSkill));
																																																																		}
																																																																		p.frames.removeChatboxInterface(p);
																																																																	}
			break;

		case 224:

			/*
			 * Item on Object
			 */
			ItemOnObject.handlePacket(p, packetId, packetSize);
			break;

		case 228:

			/*
			 * Second object option.
			 */
			objectOption2.handlePacket(p, packetId, packetSize);
			break;

		case 199:
			npcOption3.handlePacket(p, packetId, packetSize);
			break;

		case 52:



			/*
			 * Second NPC option.
			 */
			npcOption2.handlePacket(p, packetId, packetSize);
			break;

		case 250: //quick chat!
			actionButtons.handlePacket(p, packetId, packetSize);
			break;

		case 38:


			/*
			 * Item examining.
			 */
			p.frames.sendMessage(p,
					Engine.items.getItemDescription(
							p.stream.readUnsignedWordBigEndianA()));
			break;

		case 88:


			/*
			 * NPC examining.
			 */
			p.frames.sendMessage(p,
					Server.engine.getNPCDescription(p.stream.readUnsignedWord()));
			break;

		case 84:


			/*
			 * Object examining.
			 */
			int objectId = p.stream.readUnsignedWordA();

			p.frames.sendMessage(p, "An object.");
			break;

		case 47:


			/*
			 * Idle packet.
			 */
			p.disconnected[0] = false;
			break;

		case 111:
			int rank = p.stream.readUnsignedByte();
			long cpName = p.stream.readBigQWord();

			String rankPlayer = Misc.longToString(cpName).replaceAll("_", " ");
			Engine.clanChat.setRank(p, rankPlayer, rank);
			break;

		case 42:
			long chatName = p.stream.readQWord();
			if (p.clanRoom.length() > 0) {
				Engine.clanChat.leave(p);
			} else {
				Engine.clanChat.join(p, Misc.longToString(chatName));  
			}
			break;

		case 179:


			/*
			 * Switching items on interfaces.
			 */
			 switchItems2.handlePacket(p, packetId, packetSize);
			 break;
		case 94://Object Select 2? Such as "Guide" patches.

			//p.openHis();
			break;
		case 190:

			p.openSets();
			break;  


		default:
			Misc.println("[" + p.username + "] Unhandled packet: " + packetId);
			break;
		}
	}
}
