

package Bulby.io.packets;


import Bulby.Engine;
import Bulby.players.Player;
import Bulby.players.items.PlayerItems;
import Bulby.util.Misc;


public class ItemSelect implements Packet {
    public static int regbone = 75;
    public static int burntbone = 50;
    public static int batbone = 50;
    public static int wolfbone = 50;
    public static int monkeybone = 50;
    public static int bigbone = 500;
    public static int shaikbone = 500;
    public static int jogrebone = 500;
    public static int burntjogrebone = 500;
    public static int babydragonbone = 3500;
    public static int dragonbone = 150;
    public static int zogrebone = 7500;
    public static int fayrgbone = 7500;
    public static int raurgbone = 7500;
    public static int ourgbone = 7500;
    public static int dagbone = 10000;
    public static int wyvbone = 10000;
    public void handlePacket(Player p, int packetId, int packetSize) {
        if (p == null || p.stream == null) {
            return;
        }
        PlayerItems pi = new PlayerItems();
        int junk = p.stream.readUnsignedByte();
        int interfaceId = p.stream.readUnsignedWord();

        junk = p.stream.readUnsignedByte();
        int itemId = p.stream.readUnsignedWordBigEndian();
        int itemSlot = p.stream.readUnsignedWordA();

        p.attackPlayer = 0;
        p.attackingPlayer = false;
        if (itemSlot < 0 || itemSlot > p.items.length
                || p.items[itemSlot] != itemId) {
            return;
        }
        if (p.isDead || p.skillLvl[3] < 1) {
            return;
        }

        if (interfaceId == 149) {
            switch (itemId) {
            case 8013: //Runecrafting
            p.teleportTo(2142, 4835, 0, 4, 4, 7391, 7391, 678, 0, 678, 0);
            pi.deleteItem(p, itemId, itemSlot, 1);
            p.addSkillXP(100,6);
            break;
            case 8008: //Lumby
            p.teleportTo(3222, 3218, 0, 4, 4, 7391, 7391, 678, 0, 678, 0);
            pi.deleteItem(p, itemId, itemSlot, 1);
            p.addSkillXP(100,6);
            break;
            case 8010://Camelot
            p.teleportTo(2757, 3477, 0, 4, 4, 7391, 7391, 678, 0, 678, 0);
            pi.deleteItem(p, itemId, itemSlot, 1);
            p.addSkillXP(100,6);
            break;
            case 8009://Falador
            p.teleportTo(2964, 3378, 0, 4, 4, 7391, 7391, 678, 0, 678, 0);
            pi.deleteItem(p, itemId, itemSlot, 1);
            p.addSkillXP(100,6);
            break;
            case 8007://Varrock
            p.teleportTo(3210, 3424, 0, 4, 4, 7391, 7391, 678, 0, 678, 0);
            pi.deleteItem(p, itemId, itemSlot, 1);
            p.addSkillXP(100,6);
            break;
            case 8011://Ardougne
            p.teleportTo(2661, 3305, 0, 4, 4, 7391, 7391, 678, 0, 678, 0);
            pi.deleteItem(p, itemId, itemSlot, 1);
            p.addSkillXP(100,6);
            break;
            case 8012://Watchtower
            pi.deleteItem(p, itemId, itemSlot, 1);
            p.teleportTo(2548, 3114, 0, 4, 4, 7391, 7391, 678, 0, 678, 0);
            p.addSkillXP(100,6);
            break;
          case 526: //Regular Bone Burying
            	if (p.buryDelay <= 0) {
            		p.buryDelay = 3;
            		pi.deleteItem(p, itemId, itemSlot, 1);
            		p.addSkillXP(regbone*p.skillLvl[5], 5);
            		p.requestAnim(827, 0);
            	}
            	break;
            	
            case 528: //Burnt Bone Burying
            	if (p.buryDelay <= 0) {
            		p.buryDelay = 3;
            		pi.deleteItem(p, itemId, itemSlot, 1);
            		p.addSkillXP(burntbone*p.skillLvl[5], 5);
            		p.requestAnim(827, 0);
            	}
            	break;

case 1538:
p.frames.showInterface(p, 547);
break;

case 7633:
p.frames.showInterface(p, 275);
p.frames.setString(p, "The Great War", 275, 2);
p.frames.setString(p, "Kill a Mithril Dragon, and get the dragon piece and use it on the chest", 275, 11);
break;

case 2677:
p.frames.showInterface(p, 255);
p.frames.setString(p, "Dear " + p.username + ", your task now is too go to Netiznot and talk to King Gjuki Sorvott IV. The portal is located in Falador or near it.", 255, 3);
break;

case 10890:
p.frames.showInterface(p, 275);
p.frames.setString(p, "The Great War", 275, 2);
p.frames.setString(p, "You must travel to the land of ice and kill the spirits", 275, 11);
p.frames.setString(p, "that lurk there. Maybe you will just meet your dimise.", 275, 12);
break;

case 10562:
p.frames.showInterface(p, 275);
p.frames.setString(p, "The Great War", 275, 2);
p.frames.setString(p, "Okay well first head back to Netiznot, then go", 275, 11);
p.frames.setString(p, "through the paths and fight the Spirit Beast!", 275, 12);
p.frames.setString(p, "You should have plenty of prayer pots, food, super sets,", 275, 13);
p.frames.setString(p, "and pletny of weapons.", 275, 14);
break;

case 9003:
p.frames.showInterface(p, 275);
p.frames.setString(p, "<col=fff000><shad=0202>Mezzy-Scape's Rules", 275, 2);
p.frames.setString(p, "<col=fff000><shad=0202>Rule Book", 275, 11);
p.frames.setString(p, "<col=fff000><shad=0202>Hello guys this is the Rule book!", 275, 12);
p.frames.setString(p, "<col=fff000><shad=0202>1. No pjing! ", 275, 13);
p.frames.setString(p, "<col=fff000><shad=0202>2. If you want it to be a gbs fight then agree to it", 275, 14);
p.frames.setString(p, "<col=fff000><shad=0202>before you start the fight!", 275, 15);
p.frames.setString(p, "<col=fff000><shad=0202>3. No trading/selling/buying RuneScape accounts!! Will lead", 275, 16);
p.frames.setString(p, "<col=fff000><shad=0202>to a mute!", 275, 17);
p.frames.setString(p, "<col=fff000><shad=0202>4. No duping no matter what!! Will lead to a ipban!", 275, 18);
p.frames.setString(p, "<col=fff000><shad=0202>5. No impersinating Staff!!", 275, 19);
p.frames.setString(p, "<col=fff000><shad=0202>6. All players Respect all staff!!", 275, 20);
p.frames.setString(p, "<col=fff000><shad=0202>7. All staff Respect all players!!", 275, 21);
p.frames.setString(p, "<col=fff000><shad=0202>8. Staff cannot give away items for money, items in real life,", 275, 22);
p.frames.setString(p, "<col=fff000><shad=0202>runescape accounts, or just basiclly anything!", 275, 23);
p.frames.setString(p, "<col=fff000><shad=0202>9. Do NOT share your password with anyone!", 275, 24);
p.frames.setString(p, "<col=fff000><shad=0202>10. Password scamming can lead up to ipban for 48 hours!", 275, 25);
p.frames.setString(p, "<col=fff000><shad=0202>11. Keep swearing to a minimum!", 275, 26);
p.frames.setString(p, "<col=fff000><shad=0202>12. No Advertising any other websites or servers!", 275, 27);
p.frames.setString(p, "<col=fff000><shad=0202>13. No using autoers! Such as auto woodcut! Will get you 24 hour banned!", 275, 28);
p.frames.setString(p, "<col=fff000><shad=0202>14. No asking for personal details! Will lead to 48 hour mute! ", 275, 29);
p.frames.setString(p, "<col=fff000><shad=0202>15. Maximum accounts on at once is 2! If any more or trading starters,", 275, 30);
p.frames.setString(p, "<col=fff000><shad=0202>you will Be BANNED PERM!", 275, 31);
p.frames.setString(p, "<col=fff000><shad=0202>17. No encuraging others to break any of these rules!", 275, 32);
p.frames.setString(p, "<col=fff000><shad=0202>18. If anyone breaks these rules report it and you could get", 275, 33);
p.frames.setString(p, "<col=fff000><shad=0202>rewarded!! Report enough people correctly and you could become Mod!", 275, 34);
p.frames.setString(p, "<col=fff000><shad=0202>You can report by doing ::reportabuse (username) (what they did)", 275, 35);
p.frames.setString(p, "<col=fff000><shad=0202>Thank you for reading the Rules Book!", 275, 36);
break;

case 13151:
p.frames.showInterface(p, 275);
p.frames.setString(p, "<col=fff000><shad=0202>Safety Dungeons Guide Book", 275, 2);
p.frames.setString(p, "<col=fff000><shad=0202>Please read this to get an understanding.", 275, 11);
p.frames.setString(p, "<col=fff000><shad=0202>If you don't read this book you will not get this new mini game.", 275, 12);
p.frames.setString(p, "<col=fff000><shad=0202>Okay, so for this you have to kill monsters to get Safety Dungeon", 275, 13);
p.frames.setString(p, "<col=fff000><shad=0202>Kill Count. You can check my doing ::sd or ::myinfo.", 275, 14);
p.frames.setString(p, "<col=fff000><shad=0202>There's a shortcut to the third floor BUT you would need more", 275, 15);
p.frames.setString(p, "<col=fff000><shad=0202>Safety Dungeon Kill Count to go down.", 275, 16);
p.frames.setString(p, "<col=fff000><shad=0202>To go to Second floor you need 10 kill count.", 275, 17);
p.frames.setString(p, "<col=fff000><shad=0202>To go to Third floor you need 20 kill count.", 275, 18);
p.frames.setString(p, "<col=fff000><shad=0202>On Second floor there's a leve, takes 30 kill count, you go to", 275, 19);
p.frames.setString(p, "<col=fff000><shad=0202>the Third floor. To recieve your item from chest takes 5 Safety Dungeon", 275, 20);
p.frames.setString(p, "<col=fff000><shad=0202>Kill Count.", 275, 21);
break;

case 600:
p.frames.showInterface(p, 275);
p.frames.setString(p, "<col=fff000><shad=0202>Mezzy-Scape's Information", 275, 2);
p.frames.setString(p, "<col=fff000><shad=0202>1. To train any skill, just click it to train!", 275, 11);
p.frames.setString(p, "<col=fff000><shad=0202>2. All skills are trainable!!", 275, 12);
p.frames.setString(p, "<col=fff000><shad=0202>3. There's one quest at the momment that can be done!", 275, 13);
p.frames.setString(p, "<col=fff000><shad=0202>4. To make money just kill things to get items!", 275, 14);
p.frames.setString(p, "<col=fff000><shad=0202>5. There are teleports by quest tab!", 275, 15);
p.frames.setString(p, "<col=fff000><shad=0202>6. To sell items from events or a whip just do ::sellwhip!", 275, 16);
p.frames.setString(p, "<col=fff000><shad=0202>7. For commands just do ::commands or ::mcommands!", 275, 17);
p.frames.setString(p, "<col=fff000><shad=0202>8. All prayer's work 100%!", 275, 18);
p.frames.setString(p, "<col=fff000><shad=0202>9. When you fight in wild you will get a Pking Skull!", 275, 19);
p.frames.setString(p, "<col=fff000><shad=0202>10. Only one of the teleport's by mage tab works at the momment!", 275, 20);
p.frames.setString(p, "<col=fff000><shad=0202>11. Just incase of any confuision, you don't need to pay to play!", 275, 21);
p.frames.setString(p, "<col=fff000><shad=0202>12. 100% Working npc drops!", 275, 22);
p.frames.setString(p, "<col=fff000><shad=0202>13. 100% Working Godwars!", 275, 23);
p.frames.setString(p, "<col=fff000><shad=0202>14. We have the biggest Ghost Zone ever created!", 275, 24);
p.frames.setString(p, "<col=fff000><shad=0202>15. Trading is now 100% working! (Going to finish it soon!)", 275, 25);
p.frames.setString(p, "<col=fff000><shad=0202>16. Grand Exchange is only 40% Working (If I can I'll get it working!)", 275, 26);
p.frames.setString(p, "<col=fff000><shad=0202>17. There's four training area's! All fully coded!", 275, 27);
p.frames.setString(p, "<col=fff000><shad=0202>18. Shops work 100%!", 275, 28);
p.frames.setString(p, "<col=fff000><shad=0202>19. This server is a main server/economy server/pking server!", 275, 29);
p.frames.setString(p, "<col=fff000><shad=0202>20. There are Jc-Scape teleports!", 275, 30);
p.frames.setString(p, "<col=fff000><shad=0202>21. 100% Working emotes and skillcape emotes!", 275, 31);
p.frames.setString(p, "<col=fff000><shad=0202>22. Server's still under construction!", 275, 32);
p.frames.setString(p, "<col=fff000><shad=0202>23. Chris is the Server Owner and Coder!", 275, 33);
p.frames.setString(p, "", 275, 34);
p.frames.setString(p, "", 275, 35);
p.frames.setString(p, "", 275, 36);
break;

case 4447:
Engine.playerItems.deleteItem(p,4447, Engine.playerItems.getItemSlot(p, 4447), 1);
p.addSkillXP(80000*p.skillLvl[0] ,0);
p.addSkillXP(80000*p.skillLvl[1] ,1);
p.addSkillXP(80000*p.skillLvl[2] ,2);
p.frames.sendMessage(p, "u just gain exp in att,def,stre");
break;

case 4155:
if(p.SlayerAm == 0)
{
p.frames.showChatboxInterface(p, 241);
p.frames.animateInterfaceId(p, 9850, 241, 2);
p.frames.setNPCId(p, 1599, 241, 2);
p.frames.setString(p, "Duradel", 241, 3);
 p.frames.setString(p, "Talk to me again for another task.", 241, 4);
}
else
{
p.frames.showChatboxInterface(p, 241);
p.frames.animateInterfaceId(p, 9850, 241, 2);
p.frames.setNPCId(p, 1599, 241, 2);
p.frames.setString(p, "Duradel", 241, 3);
if(p.SlayerTask == 0) { p.frames.setString(p, "You still need to slay "+p.SlayerAm+" more Dragons.", 241, 4); }
if(p.SlayerTask == 1) { p.frames.setString(p, "You still need to slay "+p.SlayerAm+" more Guards.", 241, 4); }
if(p.SlayerTask == 2) { p.frames.setString(p, "You still need to slay "+p.SlayerAm+" more Giants.", 241, 4); }
if(p.SlayerTask == 3) { p.frames.setString(p, "You still need to slay "+p.SlayerAm+" more Ghosts.", 241, 4); }
if(p.SlayerTask == 4) { p.frames.setString(p, "You still need to slay "+p.SlayerAm+" more Heroes.", 241, 4); }
}
break;
case 12844:
p.requestAnim(8990, 0);
break;
case 11256:
Engine.playerItems.deleteItem(p,11256, Engine.playerItems.getItemSlot(p, 11256), 1);
Engine.playerItems.addItem(p, 995, Misc.random(30));
break;
case 199:
Engine.playerItems.deleteItem(p,199, Engine.playerItems.getItemSlot(p, 199), 1);
Engine.playerItems.addItem(p, 249, 1);
p.addSkillXP(25*p.skillLvl[15] ,15);
p.frames.sendMessage(p, "You clean the guam leaf.");
break;

case 207:
Engine.playerItems.deleteItem(p,207, Engine.playerItems.getItemSlot(p, 207), 1);
Engine.playerItems.addItem(p, 257, 1);
p.addSkillXP(75*p.skillLvl[15] ,15);
p.frames.sendMessage(p, "You clean the ranarr weed.");
break;


            	
            case 530: //Bat Bone Burying
            	if (p.buryDelay <= 0) {
            		p.buryDelay = 3;
            		pi.deleteItem(p, itemId, itemSlot, 1);
            		p.addSkillXP(batbone*p.skillLvl[5], 5);
            		p.requestAnim(827, 0);
            	}
            	break;
            	
            case 532: //Big Bone Burying
            	if (p.buryDelay <= 0) {
            		p.buryDelay = 3;
            		pi.deleteItem(p, itemId, itemSlot, 1);
            		p.addSkillXP(bigbone*p.skillLvl[5], 5);
            		p.requestAnim(827, 0);
            	}
            	break;
            	
            case 534: //Baby Dragon Bone Burying
            	if (p.buryDelay <= 0) {
            		p.buryDelay = 3;
            		pi.deleteItem(p, itemId, itemSlot, 1);
            		p.addSkillXP(babydragonbone*p.skillLvl[5], 5);
            		p.requestAnim(827, 0);
            	}
            	break;
            	
            case 536: //Dragon Bone Burying
            	if (p.buryDelay <= 0) {
            		p.buryDelay = 3;
            		pi.deleteItem(p, itemId, itemSlot, 1);
            		p.addSkillXP(dragonbone*p.skillLvl[5], 5);
            		p.requestAnim(827, 0);
            	}
            	break;
            	
            case 2859: //Wolf Bone Burying
            	if (p.buryDelay <= 0) {
            		p.buryDelay = 3;
            		pi.deleteItem(p, itemId, itemSlot, 1);
            		p.addSkillXP(wolfbone*p.skillLvl[5], 5);
            		p.requestAnim(827, 0);
            	}
            	break;
            	
            case 3123: //Shaikahan Bone Burying
            	if (p.buryDelay <= 0) {
            		p.buryDelay = 3;
            		pi.deleteItem(p, itemId, itemSlot, 1);
            		p.addSkillXP(shaikbone*p.skillLvl[5], 5);
            		p.requestAnim(827, 0);
            	}
            	break;
            	
            case 3125: //Jogre Bone Burying
            	if (p.buryDelay <= 0) {
            		p.buryDelay = 3;
            		pi.deleteItem(p, itemId, itemSlot, 1);
            		p.addSkillXP(jogrebone*p.skillLvl[5], 5);
            		p.requestAnim(827, 0);
            	}
            	break;
            	
            case 3127: //Burnt Jogre Bone Burying
            	if (p.buryDelay <= 0) {
            		p.buryDelay = 3;
            		pi.deleteItem(p, itemId, itemSlot, 1);
            		p.addSkillXP(burntjogrebone*p.skillLvl[5], 5);
            		p.requestAnim(827, 0);
            	}
            	break;
            	
            case 3179: //Monkey Bone Burying
            	if (p.buryDelay <= 0) {
            		p.buryDelay = 3;
            		pi.deleteItem(p, itemId, itemSlot, 1);
            		p.addSkillXP(monkeybone*p.skillLvl[5], 5);
            		p.requestAnim(827, 0);
            	}
            	break;
            	
            case 4812: //Zogre Bone Burying
            	if (p.buryDelay <= 0) {
            		p.buryDelay = 3;
            		pi.deleteItem(p, itemId, itemSlot, 1);
            		p.addSkillXP(zogrebone*p.skillLvl[5], 5);
            		p.requestAnim(827, 0);
            	}
            	break;
            	
            case 4830: //Fayrg Bone Burying
            	if (p.buryDelay <= 0) {
            		p.buryDelay = 3;
            		pi.deleteItem(p, itemId, itemSlot, 1);
            		p.addSkillXP(fayrgbone*p.skillLvl[5], 5);
            		p.requestAnim(827, 0);
            	}
            	break;
            	
            case 4832: //Raurg Bone Burying
            	if (p.buryDelay <= 0) {
            		p.buryDelay = 3;
            		pi.deleteItem(p, itemId, itemSlot, 1);
            		p.addSkillXP(raurgbone*p.skillLvl[5], 5);
            		p.requestAnim(827, 0);
            	}
            	break;
            	
            case 4834: //Ourg Bone Burying
            	if (p.buryDelay <= 0) {
            		p.buryDelay = 3;
            		pi.deleteItem(p, itemId, itemSlot, 1);
            		p.addSkillXP(ourgbone*p.skillLvl[5], 5);
            		p.requestAnim(827, 0);
            	}
            	break;
            	
            case 6729: //Dagganoth Bone Burying
            	if (p.buryDelay <= 0) {
            		p.buryDelay = 3;
            		pi.deleteItem(p, itemId, itemSlot, 1);
            		p.addSkillXP(dagbone*p.skillLvl[5], 5);
            		p.requestAnim(827, 0);
            	}
            	break;
            	
            case 6812: //Wyvern Bone Burying
            	if (p.buryDelay <= 0) {
            		p.buryDelay = 3;
            		pi.deleteItem(p, itemId, itemSlot, 1);
            		p.addSkillXP(wyvbone*p.skillLvl[5], 5);
            		p.requestAnim(827, 0);
            	}
            	break;
            case 391:
                if (p.eatDelay <= 0) {
                    p.eatDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.updateHP(22, true);
                    p.requestAnim(829, 0);
                }
                break;
            case 4558:
                if (p.eatDelay <= 0) {
                    p.eatDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.updateHP(3, true);
                    p.requestAnim(829, 0);
                }
                break;
            case 4559:
                if (p.eatDelay <= 0) {
                    p.eatDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.updateHP(4, true);
                    p.requestAnim(829, 0);
                }
                break;

            case 4560:
                if (p.eatDelay <= 0) {
                    p.eatDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.updateHP(3, true);
                    p.requestAnim(829, 0);
                }
                break;

            case 4561:
                if (p.eatDelay <= 0) {
                    p.eatDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.updateHP(4, true);
                    p.requestAnim(829, 0);
                }
                break;

            case 4562:
                if (p.eatDelay <= 0) {
                    p.eatDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.updateHP(3, true);
                    p.requestAnim(829, 0);
                }
                break;

            case 4563:
                if (p.eatDelay <= 0) {
                    p.eatDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.updateHP(4, true);
                    p.requestAnim(829, 0);
                }
                break;

            case 4564:
                if (p.eatDelay <= 0) {
                    p.eatDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.updateHP(3, true);
                    p.requestAnim(829, 0);
                }
                break;

            case 10476:
                if (p.eatDelay <= 0) {
                    p.eatDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.updateHP(4, true);
                    p.requestAnim(829, 0);
                }
                break;

            case 385:
            case 397:
                if (p.eatDelay <= 0) {
                    p.eatDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.updateHP(20, true);
                    p.requestAnim(829, 0);
                }
                break;

            case 315:
                if (p.eatDelay <= 0) {
                    p.eatDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.updateHP(3, true);
                    p.requestAnim(829, 0);
                }
                break;

            case 319:
                if (p.eatDelay <= 0) {
                    p.eatDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.updateHP(1, true);
                    p.requestAnim(829, 0);
                }
                break;

            case 325:
                if (p.eatDelay <= 0) {
                    p.eatDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.updateHP(4, true);
                    p.requestAnim(829, 0);
                }
                break;

            case 329:
                if (p.eatDelay <= 0) {
                    p.eatDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.updateHP(9, true);
                    p.requestAnim(829, 0);
                }
                break;
				case 4049:
                if (p.eatDelay <= 0) {
                    p.eatDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.updateHP(8, true);
                }
                break;

            case 339:
            case 333:
                if (p.eatDelay <= 0) {
                    p.eatDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.updateHP(7, true);
                    p.requestAnim(829, 0);
                }
                break;

            case 347:
                if (p.eatDelay <= 0) {
                    p.eatDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.updateHP(5, true);
                    p.requestAnim(829, 0);
                }
                break;

            case 351:
                if (p.eatDelay <= 0) {
                    p.eatDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.updateHP(8, true);
                    p.requestAnim(829, 0);
                }
                break;

            case 355:
                if (p.eatDelay <= 0) {
                    p.eatDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.updateHP(6, true);
                    p.requestAnim(829, 0);
                }
                break;

            case 361:
                if (p.eatDelay <= 0) {
                    p.eatDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.updateHP(10, true);
                    p.requestAnim(829, 0);
                }
                break;

            case 365:
                if (p.eatDelay <= 0) {
                    p.eatDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.updateHP(13, true);
                    p.requestAnim(829, 0);
                }
                break;

            case 7946:
                if (p.eatDelay <= 0) {
                    p.eatDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.updateHP(16, true);
                    p.requestAnim(829, 0);
                }
                break;

            case 379:
                if (p.eatDelay <= 0) {
                    p.eatDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.updateHP(12, true);
                    p.requestAnim(829, 0);
                }
                break;

            case 373:
                if (p.eatDelay <= 0) {
                    p.eatDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.updateHP(16, true);
                    p.requestAnim(829, 0);
                }
                break;

            case 3024:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 0, (int) (p.getLevelForXP(0) * 0.26) + 8, 0,
                            true);
                    changeStat(p, 2, (int) (p.getLevelForXP(2) * 0.26) + 8, 0,
                            true);
                    changeStat(p, 1, (int) (p.getLevelForXP(1) * 0.26) + 8, 0,
                            true);
                    changeStat(p, 4, (int) (p.getLevelForXP(4) * 0.26) + 8, 0,
                            true);
                    changeStat(p, 6, (int) (p.getLevelForXP(6) * 0.26) + 8, 0,
                            true);
                    changeStat(p, 5, (int) (p.getLevelForXP(5) * 0.26) + 8, 0,
                            true);
                    pi.addItem(p, 3026, 1);
                }
                break;

            case 3026:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 0, (int) (p.getLevelForXP(0) * 0.26) + 8, 0,
                            true);
                    changeStat(p, 2, (int) (p.getLevelForXP(2) * 0.26) + 8, 0,
                            true);
                    changeStat(p, 1, (int) (p.getLevelForXP(1) * 0.26) + 8, 0,
                            true);
                    changeStat(p, 4, (int) (p.getLevelForXP(4) * 0.26) + 8, 0,
                            true);
                    changeStat(p, 6, (int) (p.getLevelForXP(6) * 0.26) + 8, 0,
                            true);
                    changeStat(p, 5, (int) (p.getLevelForXP(5) * 0.26) + 8, 0,
                            true);
                    pi.addItem(p, 3028, 1);
                }
                break;

            case 3028:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 0, (int) (p.getLevelForXP(0) * 0.26) + 8, 0,
                            true);
                    changeStat(p, 2, (int) (p.getLevelForXP(2) * 0.26) + 8, 0,
                            true);
                    changeStat(p, 1, (int) (p.getLevelForXP(1) * 0.26) + 8, 0,
                            true);
                    changeStat(p, 4, (int) (p.getLevelForXP(4) * 0.26) + 8, 0,
                            true);
                    changeStat(p, 6, (int) (p.getLevelForXP(6) * 0.26) + 8, 0,
                            true);
                    changeStat(p, 5, (int) (p.getLevelForXP(5) * 0.26) + 8, 0,
                            true);
                    pi.addItem(p, 3030, 1);
                }
                break;

            case 3030:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 0, (int) (p.getLevelForXP(0) * 0.26) + 8, 0,
                            true);
                    changeStat(p, 2, (int) (p.getLevelForXP(2) * 0.26) + 8, 0,
                            true);
                    changeStat(p, 1, (int) (p.getLevelForXP(1) * 0.26) + 8, 0,
                            true);
                    changeStat(p, 4, (int) (p.getLevelForXP(4) * 0.26) + 8, 0,
                            true);
                    changeStat(p, 6, (int) (p.getLevelForXP(6) * 0.26) + 8, 0,
                            true);
                    changeStat(p, 5, (int) (p.getLevelForXP(5) * 0.26) + 8, 0,
                            true);
                    pi.addItem(p, 229, 1);
                }
                break;

case 11949:
p.frames.showInterface(p, 659);
p.frames.sendMessage(p,"You shake the snow globe.");
Engine.playerItems.addItem(p, 11951, 28);
break;

            case 2430:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 0, (int) (p.getLevelForXP(0) * 0.3) + 10, 0,
                            true);
                    changeStat(p, 2, (int) (p.getLevelForXP(2) * 0.3) + 10, 0,
                            true);
                    changeStat(p, 1, (int) (p.getLevelForXP(1) * 0.3) + 10, 0,
                            true);
                    changeStat(p, 4, (int) (p.getLevelForXP(4) * 0.3) + 10, 0,
                            true);
                    changeStat(p, 6, (int) (p.getLevelForXP(6) * 0.3) + 10, 0,
                            true);
                    pi.addItem(p, 127, 1);
                }
                break;

            case 127:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 0, (int) (p.getLevelForXP(0) * 0.3) + 10, 0,
                            true);
                    changeStat(p, 2, (int) (p.getLevelForXP(2) * 0.3) + 10, 0,
                            true);
                    changeStat(p, 1, (int) (p.getLevelForXP(1) * 0.3) + 10, 0,
                            true);
                    changeStat(p, 4, (int) (p.getLevelForXP(4) * 0.3) + 10, 0,
                            true);
                    changeStat(p, 6, (int) (p.getLevelForXP(6) * 0.3) + 10, 0,
                            true);
                    pi.addItem(p, 129, 1);
                }
                break;

            case 129:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 0, (int) (p.getLevelForXP(0) * 0.3) + 10, 0,
                            true);
                    changeStat(p, 2, (int) (p.getLevelForXP(2) * 0.3) + 10, 0,
                            true);
                    changeStat(p, 1, (int) (p.getLevelForXP(1) * 0.3) + 10, 0,
                            true);
                    changeStat(p, 4, (int) (p.getLevelForXP(4) * 0.3) + 10, 0,
                            true);
                    changeStat(p, 6, (int) (p.getLevelForXP(6) * 0.3) + 10, 0,
                            true);
                    pi.addItem(p, 131, 1);
                }
                break;

            case 131:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 0, (int) (p.getLevelForXP(0) * 0.3) + 10, 0,
                            true);
                    changeStat(p, 2, (int) (p.getLevelForXP(2) * 0.3) + 10, 0,
                            true);
                    changeStat(p, 1, (int) (p.getLevelForXP(1) * 0.3) + 10, 0,
                            true);
                    changeStat(p, 4, (int) (p.getLevelForXP(4) * 0.3) + 10, 0,
                            true);
                    changeStat(p, 6, (int) (p.getLevelForXP(6) * 0.3) + 10, 0,
                            true);
                    pi.addItem(p, 229, 1);
                }
                break;

            case 6685:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    p.updateHP((int) (p.getLevelForXP(3) * 0.15) + 2, true);
                    changeStat(p, 0, (int) (p.getLevelForXP(0) * 0.1) + 2, 0,
                            false);
                    changeStat(p, 2, (int) (p.getLevelForXP(2) * 0.1) + 2, 0,
                            false);
                    changeStat(p, 1, (int) (p.getLevelForXP(1) * 0.2) + 2, 1,
                            true);
                    changeStat(p, 4, (int) (p.getLevelForXP(4) * 0.1) + 2, 0,
                            false);
                    changeStat(p, 6, (int) (p.getLevelForXP(6) * 0.1) + 2, 0,
                            false);
                    pi.addItem(p, 6687, 1);
                }
                break;

            case 6687:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    p.updateHP((int) (p.getLevelForXP(3) * 0.15) + 2, true);
                    changeStat(p, 0, (int) (p.getLevelForXP(0) * 0.1) + 2, 0,
                            false);
                    changeStat(p, 2, (int) (p.getLevelForXP(2) * 0.1) + 2, 0,
                            false);
                    changeStat(p, 1, (int) (p.getLevelForXP(1) * 0.2) + 2, 1,
                            true);
                    changeStat(p, 4, (int) (p.getLevelForXP(4) * 0.1) + 2, 0,
                            false);
                    changeStat(p, 6, (int) (p.getLevelForXP(6) * 0.1) + 2, 0,
                            false);
                    pi.addItem(p, 6689, 1);
                }
                break;

            case 6689:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    p.updateHP((int) (p.getLevelForXP(3) * 0.15) + 2, true);
                    changeStat(p, 0, (int) (p.getLevelForXP(0) * 0.1) + 2, 0,
                            false);
                    changeStat(p, 2, (int) (p.getLevelForXP(2) * 0.1) + 2, 0,
                            false);
                    changeStat(p, 1, (int) (p.getLevelForXP(1) * 0.2) + 2, 1,
                            true);
                    changeStat(p, 4, (int) (p.getLevelForXP(4) * 0.1) + 2, 0,
                            false);
                    changeStat(p, 6, (int) (p.getLevelForXP(6) * 0.1) + 2, 0,
                            false);
                    pi.addItem(p, 6691, 1);
                }
                break;

            case 6691:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    p.updateHP((int) (p.getLevelForXP(3) * 0.15) + 2, true);
                    changeStat(p, 0, (int) (p.getLevelForXP(0) * 0.1) + 2, 0,
                            false);
                    changeStat(p, 2, (int) (p.getLevelForXP(2) * 0.1) + 2, 0,
                            false);
                    changeStat(p, 1, (int) (p.getLevelForXP(1) * 0.2) + 2, 1,
                            true);
                    changeStat(p, 4, (int) (p.getLevelForXP(4) * 0.1) + 2, 0,
                            false);
                    changeStat(p, 6, (int) (p.getLevelForXP(6) * 0.1) + 2, 0,
                            false);
                    pi.addItem(p, 229, 1);
                }
                break;

            case 113:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 2, (int) (p.getLevelForXP(2) * 0.1) + 3, 1,
                            true);
                    pi.addItem(p, 115, 1);
                }
                break;

            case 2434:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 5, (int) (p.getLevelForXP(5) * 0.1) + 3, 1,
                            true);
                    pi.addItem(p, 139, 1);
                }
                break;

            case 143:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 5, (int) (p.getLevelForXP(5) * 0.1) + 3, 1,
                            true);
                    pi.addItem(p, 229, 1);
                }
                break;

            case 141:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 5, (int) (p.getLevelForXP(5) * 0.1) + 3, 1,
                            true);
                    pi.addItem(p, 143, 1);
                }
                break;

            case 139:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 5, (int) (p.getLevelForXP(5) * 0.1) + 3, 1,
                            true);
                    pi.addItem(p, 141, 1);
                }
                break;

            case 3040:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 6, (int) (p.getLevelForXP(6) * 0.1) + 3, 1,
                            true);
                    pi.addItem(p, 3042, 1);
                }
                break;

            case 3042:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 6, (int) (p.getLevelForXP(6) * 0.1) + 3, 1,
                            true);
                    pi.addItem(p, 3044, 1);
                }
                break;

            case 3044:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 6, (int) (p.getLevelForXP(6) * 0.1) + 3, 1,
                            true);
                    pi.addItem(p, 3046, 1);
                }
                break;

            case 3046:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 6, (int) (p.getLevelForXP(6) * 0.1) + 3, 1,
                            true);
                    pi.addItem(p, 229, 1);
                }
                break;

            case 115:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 2, (int) (p.getLevelForXP(2) * 0.1) + 3, 1,
                            true);
                    pi.addItem(p, 117, 1);
                }
                break;

            case 119:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 2, (int) (p.getLevelForXP(2) * 0.1) + 3, 1,
                            true);
                    pi.addItem(p, 229, 1);
                }
                break;

            case 2432:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 1, (int) (p.getLevelForXP(1) * 0.1) + 3, 1,
                            true);
                    pi.addItem(p, 115, 1);
                }
                break;

            case 133:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 1, (int) (p.getLevelForXP(1) * 0.1) + 3, 1,
                            true);
                    pi.addItem(p, 135, 1);
                }
                break;

            case 135:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 1, (int) (p.getLevelForXP(1) * 0.1) + 3, 1,
                            true);
                    pi.addItem(p, 137, 1);
                }
                break;

            case 137:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 1, (int) (p.getLevelForXP(1) * 0.1) + 3, 1,
                            true);
                    pi.addItem(p, 229, 1);
                }
                break;

            case 2444:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 4, (int) (p.getLevelForXP(4) * 0.1) + 4, 1,
                            true);
                    pi.addItem(p, 169, 1);
                }
                break;

            case 169:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 4, (int) (p.getLevelForXP(4) * 0.1) + 4, 1,
                            true);
                    pi.addItem(p, 171, 1);
                }
                break;

            case 171:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 4, (int) (p.getLevelForXP(4) * 0.1) + 4, 1,
                            true);
                    pi.addItem(p, 173, 1);
                }
                break;

            case 173:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 4, (int) (p.getLevelForXP(4) * 0.1) + 4, 1,
                            true);
                    pi.addItem(p, 229, 1);
                }
                break;

            case 2428:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 0, (int) (p.getLevelForXP(0) * 0.1) + 3, 1,
                            true);
                    pi.addItem(p, 121, 1);
                }
                break;

            case 121:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 0, (int) (p.getLevelForXP(0) * 0.1) + 3, 1,
                            true);
                    pi.addItem(p, 123, 1);
                }
                break;

            case 123:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 0, (int) (p.getLevelForXP(0) * 0.1) + 3, 1,
                            true);
                    pi.addItem(p, 125, 1);
                }
                break;

            case 125:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 0, (int) (p.getLevelForXP(0) * 0.1) + 3, 1,
                            true);
                    pi.addItem(p, 229, 1);
                }
                break;

            case 2440:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 2, (int) (p.getLevelForXP(2) * 0.15) + 5, 1,
                            true);
                    pi.addItem(p, 157, 1);
                }
                break;

            case 157:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 2, (int) (p.getLevelForXP(2) * 0.15) + 5, 1,
                            true);
                    pi.addItem(p, 159, 1);
                }
                break;

            case 159:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 2, (int) (p.getLevelForXP(2) * 0.15) + 5, 1,
                            true);
                    pi.addItem(p, 161, 1);
                }
                break;

            case 161:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 2, (int) (p.getLevelForXP(2) * 0.15) + 5, 1,
                            true);
                    pi.addItem(p, 229, 1);
                }
                break;

            case 2442:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 1, (int) (p.getLevelForXP(1) * 0.15) + 5, 1,
                            true);
                    pi.addItem(p, 163, 1);
                }
                break;

            case 163:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 1, (int) (p.getLevelForXP(1) * 0.15) + 5, 1,
                            true);
                    pi.addItem(p, 165, 1);
                }
                break;

            case 165:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 1, (int) (p.getLevelForXP(1) * 0.15) + 5, 1,
                            true);
                    pi.addItem(p, 167, 1);
                }
                break;

            case 167:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 1, (int) (p.getLevelForXP(1) * 0.15) + 5, 1,
                            true);
                    pi.addItem(p, 229, 1);
                }
                break;

            case 2436:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 0, (int) (p.getLevelForXP(0) * 0.15) + 5, 1,
                            true);
                    pi.addItem(p, 145, 1);
                }
                break;

            case 145:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 0, (int) (p.getLevelForXP(0) * 0.15) + 5, 1,
                            true);
                    pi.addItem(p, 147, 1);
                }
                break;

            case 147:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 0, (int) (p.getLevelForXP(0) * 0.15) + 5, 1,
                            true);
                    pi.addItem(p, 149, 1);
                }
                break;

            case 149:
                if (p.drinkDelay <= 0) {
                    p.drinkDelay = 3;
                    p.combatDelay += 2;
                    pi.deleteItem(p, itemId, itemSlot, 1);
                    p.requestAnim(829, 0);
                    changeStat(p, 0, (int) (p.getLevelForXP(0) * 0.15) + 5, 1,
                            true);
                    pi.addItem(p, 229, 1);
                }
                break;

            default:
                Misc.println(
                        "[" + p.username + "] Unhandled item selected: "
                        + interfaceId + ":" + itemId + ":" + itemSlot);
                break;
            }
        } else {
            Misc.println(
                    "[" + p.username + "] Unhandled item select " + interfaceId
                    + ":" + itemId);
        }

        pi = null;
    }
	
    public void changeStat(Player p, int stat, int amt, int type, boolean bol) {
        if (p == null) {
            return;
        }
        if (bol) {
            if (p.skillLvl[stat] >= (p.getLevelForXP(stat) + amt)) {
                return;
            }
            p.skillLvl[stat] += amt;
            if (p.skillLvl[stat] >= (p.getLevelForXP(stat) + amt)) {
                p.skillLvl[stat] = (p.getLevelForXP(stat) + amt);
            }
            if (type == 0) {
                if (p.skillLvl[stat] > p.getLevelForXP(stat)) {
                    p.skillLvl[stat] = p.getLevelForXP(stat);
                }
            }
        } else if (!bol) {
            p.skillLvl[stat] -= amt;
            if (p.skillLvl[stat] < 1) {
                p.skillLvl[stat] = 1;
            }
        }
        p.frames.setSkillLvl(p, stat);
    }
}
