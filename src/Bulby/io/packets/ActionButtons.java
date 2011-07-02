

package Bulby.io.packets;


import Bulby.Engine;
import Bulby.players.Player;
import Bulby.npcs.NPC;
import Bulby.util.Misc;
import Bulby.io.packets.Prayer;
import Bulby.players.Magic;




public class ActionButtons implements Packet {

public void GetSkillCape(Player p,int Dialogue, int Npc, String Name, String Skill)
{
p.Dialogue = Dialogue;
p.frames.showChatboxInterface(p, 241);
p.frames.animateInterfaceId(p, 9850, 241, 2);
p.frames.setNPCId(p, Npc, 241, 2);
p.frames.setString(p, Name, 241, 3);
p.frames.setString(p, "Aha! it seems you are a master of "+Skill+"...", 241, 4);
}



public void OnlyLevel(Player p,int Dialogue, int Npc, String Name, int Skill, String Nskill)
{
p.Dialogue = Dialogue;
p.frames.showChatboxInterface(p, 241);
p.frames.animateInterfaceId(p, 9845, 241, 2);
p.frames.setNPCId(p, Npc, 241, 2);
p.frames.setString(p, Name, 241, 3);
p.frames.setString(p, "Your "+Nskill+" level is only level "+p.skillLvl[Skill]+". You should..", 241, 4);
}
    /**
     * Handles buttons on interfaces.
     * @param p The Player which the frame should be handled for.
     * @param packetId The packet id this belongs to.
     * @param packetSize The amount of bytes being recieved for this packet.
     */
    public void handlePacket(Player p, int packetId, int packetSize) {
        if (p == null || p.stream == null) {
            return;
        }
        int interfaceId = p.stream.readUnsignedWord();
        int buttonId = p.stream.readUnsignedWord();
        int buttonId2 = 0;
		Magic m = new Magic();

if (packetId == 233 || packetId == 21 || packetId == 169 || packetId == 232 || packetId == 214 || packetId == 90 || packetId == 173 || packetId == 133 || packetId == 226 || packetId == 102) {
buttonId2 = p.stream.readUnsignedWord();
}
        if (buttonId2 == 65535) {
            buttonId2 = 0;
        }
		
Player plr = Engine.players[p.TradeWithPerson];

        if (packetId == 173) {
            buttonId2 = p.stream.readUnsignedWord();
        }

        switch (interfaceId) {


case 274:

switch(buttonId)
{
case 7://Dragon Slayer
for(int i = 0; i < 30; i++)
{
if(p.DragonSlayer == 0)
{
p.frames.showInterface(p, 275);
p.frames.setString(p, "Dragon Slayer", 275, 2);
p.frames.setString(p, "", 275, 11);
p.frames.setString(p, "To start this quest, speak to the Guildmaster.", 275, 12);
p.frames.setString(p, "He is located in the champions guild.", 275, 13);
p.frames.setString(p, "Southwest of Varrock's South gates.", 275, 14);
p.frames.setString(p, "", 275, 14+i);
}
if(p.DragonSlayer == 1)
{
p.frames.showInterface(p, 275);
p.frames.setString(p, "Dragon Slayer", 275, 2);
p.frames.setString(p, "", 275, 11);
p.frames.setString(p, "The Guildmaster told me to speak to Oziach.", 275, 12);
p.frames.setString(p, "He is located in Edgeville.", 275, 13);
p.frames.setString(p, "", 275, 13+i);
}
if(p.DragonSlayer == 2)
{
p.frames.showInterface(p, 275);
p.frames.setString(p, "Dragon Slayer", 275, 2);
p.frames.setString(p, "", 275, 11);
p.frames.setString(p, "Oziach put me on a quest to slay Elvarg the dragon.", 275, 12);
p.frames.setString(p, "The guildmaster will give me more information.", 275, 13);
p.frames.setString(p, "", 275, 13+i);
}
if(p.DragonSlayer == 3)
{
p.frames.showInterface(p, 275);
p.frames.setString(p, "Dragon Slayer", 275, 2);
p.frames.setString(p, "", 275, 11);
p.frames.setString(p, "The dragon is located on Crandor Island.", 275, 12);
p.frames.setString(p, "", 275, 13);
p.frames.setString(p, "I will need a map from the Oracle on Ice Mountain.", 275, 14);
p.frames.setString(p, "I will need a shield to protect me.", 275, 15);
p.frames.setString(p, "I will need a ship to get there.", 275, 16);
p.frames.setString(p, "", 275, 16+i);
}
if(p.DragonSlayer == 4)
{
p.frames.showInterface(p, 275);
p.frames.setString(p, "Dragon Slayer", 275, 2);
p.frames.setString(p, "", 275, 11);
p.frames.setString(p, "I slayed the dragon!", 275, 12);
p.frames.setString(p, "", 275, 13);
p.frames.setString(p, "I should return to Oziach and tell him.", 275, 14);
p.frames.setString(p, "", 275, 14+i);
}
if(p.DragonSlayer == 5)
{
p.frames.showInterface(p, 275);
p.frames.setString(p, "Dragon Slayer", 275, 2);
p.frames.setString(p, "", 275, 11);
p.frames.setString(p, "<col=66FF33>QUEST COMPLETE", 275, 12);
p.frames.setString(p, "", 275, 13);
p.frames.setString(p, "I now can wear rune platebodies, dragon platebodies,", 275, 14);
p.frames.setString(p, "and dragon chainbodies", 275, 15);
p.frames.setString(p, "", 275, 14+i);
}
}
break;
case 8://The Great War
for(int i = 0; i < 30; i++)
{
if(p.GreatWar == 0)
{
p.frames.showInterface(p, 275);
p.frames.setString(p, "The Great War", 275, 2);
p.frames.setString(p, "", 275, 11);
p.frames.setString(p, "Please talk to the Barricade guard", 275, 12);
p.frames.setString(p, "You can find him at Varrock.", 275, 13); 
p.frames.setString(p, "", 275, 13+i);
}
if(p.GreatWar == 1)
{
p.frames.showInterface(p, 275);
p.frames.setString(p, "The Great War", 275, 2);
p.frames.setString(p, "", 275, 11);
p.frames.setString(p, "The war is between humans and monsters? I should", 275, 12);
p.frames.setString(p, "find out where to start.. Perhaps I could find out", 275, 13); 
p.frames.setString(p, "where to start off if I kill some monsters, and look", 275, 14);
p.frames.setString(p, "for a clue scroll drop.", 275, 15);
p.frames.setString(p, "", 275, 15+i);
}
if(p.GreatWar == 2)
{
p.frames.showInterface(p, 275);
p.frames.setString(p, "The Great War", 275, 2);
p.frames.setString(p, "", 275, 11);
p.frames.setString(p, "I should kill a Mithril Dragon and get part of the dragon piece", 275, 12);
p.frames.setString(p, "and use it on a chest.", 275, 13); 
p.frames.setString(p, "", 275, 13+i);
}
if(p.GreatWar == 3)
{
p.frames.showInterface(p, 275);
p.frames.setString(p, "The Great War", 275, 2);
p.frames.setString(p, "", 275, 11);
p.frames.setString(p, "The Mage of Zamorak has given me a book with all the correct tools", 275, 12);
p.frames.setString(p, "to win the battle and end The Great War.", 275, 13); 
p.frames.setString(p, "", 275, 13+i);
}
if(p.GreatWar == 4)
{
p.frames.showInterface(p, 275);
p.frames.setString(p, "The Great War", 275, 2);
p.frames.setString(p, "", 275, 11);
p.frames.setString(p, "I have killed the beast, I should return and tell", 275, 12);
p.frames.setString(p, "Goth leprechaun about my victory.", 275, 13); 
p.frames.setString(p, "", 275, 13+i);
}
if(p.GreatWar == 5)
{
p.frames.showInterface(p, 275);
p.frames.setString(p, "The Great War", 275, 2);
p.frames.setString(p, "", 275, 11);
p.frames.setString(p, "<col=66FF33>QUEST COMPLETE", 275, 12);
p.frames.setString(p, "I have completed the quest.. I can now", 275, 13);
p.frames.setString(p, "wear Dragon Platebody, dragon claws, and wear quest cape.", 275, 14); 
p.frames.setString(p, "", 275, 14+i);
}
}
break;
case 32://King Black Dragon
if (p.jailed == (0)) {
 p.teleportTo(3140, 3819, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You have teleported to kbd area! Watch out!<img=1>");
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>King Black Dragon straight ahead!! Just walk forward!<img=1>");
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>NO PKING HERE OR YOU WILL BE BANNED OR IPBANNED!<img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 40://Barbarian Assualt
if (p.jailed == (0)) {
 p.teleportTo(2604, 3156, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You teleported to Barbarian Assualt.<img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 38://Mage Bank
if (p.jailed == (0)) {
 p.teleportTo(2540, 4717, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You teleported to mage bank.<img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 39://Pest Control
if (p.jailed == (0)) {
 p.teleportTo(2352, 3171, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You teleported to pest control.<img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 125://TzTok-Jad
if (p.jailed == (0)) {
 p.teleportTo(2443, 5170, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Kill TzTok-Jad for a firecape!! Be careful!<img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 37://Spirit Beast
if (p.jailed == (0)) {
 p.teleportTo(2525, 3045, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0); 
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You have teleported to the Spirit Beast!<img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 36://Mutant Tarn
if (p.jailed == (0)) {
 p.teleportTo(3497, 3485, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><col=ff000><shad=0202>You have teleported to Mutant Tarn..<img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 34://Kalphite Lair
if (p.jailed == (0)) {
 p.teleportTo(3475, 9494, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "Kill kalphiete Queen for Drag-full helm chinebody and d.platelegs!");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 138://Wyvern
if (p.jailed == (0)) {
 p.teleportTo(3052, 9582, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You have teleported to the Wyvern area!<img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 21://Tokkul Wars
if (p.jailed == (0)) {
 p.teleportTo(2932, 3249, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You have just teleported to Tokkul Wars!<img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 35://Safety Dungeon Mini Game
if (p.jailed == (0)) {
 p.teleportTo(3175, 4239, 2, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You have just teleported to Safety Dungeon's Mini Game!<img=1>");
Engine.playerItems.addItem(p, 13151, 1);
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 41://World 1
if (p.jailed == (0)) {
 p.teleportTo(3212, 3429, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You have just teleported to World 1!<img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 42://World 2
if (p.jailed == (0)) {
 p.teleportTo(3087, 3491, 4, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You have just teleported to World 2!<img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 30://Fun Zone
if (p.jailed == (0)) {
 p.teleportTo(3045, 3378, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You have just teleported to the Fun Zone!! So have fun!<img=1>");
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>DO NOT ATTACK THE NPC'S IN HERE!!!!!!<img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 141://Green Dragons
if (p.jailed == (0)) {
 p.teleportTo(3328, 3674, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You have came to Green Dragons!!<img=1>");
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>DO NOT PK HERE!! OR YOU WILL BE BANNED OR IPBANNED!<img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 29://Edgeville
if (p.jailed == (0)) {
 p.teleportTo(3093, 3493, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You have just teleported to Edgeville! Go to Wild and pk!<img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 22://Train
if (p.jailed == (0)) {
 p.teleportTo(3276, 9894, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Welcome to Low level training! For levels 1-50!<img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 23://Train 2
if (p.jailed == (0)) {
 p.teleportTo(3237, 9906, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Welcome to Medium level training! For levels 50-90!<img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 24://Train 3
if (p.jailed == (0)) {
 p.teleportTo(3171, 9891, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Welcome to High level training! For levels 90-126!<img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 26://Train 4
if (p.jailed == (0)) {
 p.teleportTo(2973, 3343, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Welcome to training for all levels!<img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 31://Party
if (p.jailed == (0)) {
 p.teleportTo(2833, 3423, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Drop Party's Will be hosted here!<img=1>");
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Anyone can host Drop Party's here!<img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 5://Starting your adventure
if (p.jailed == (0)) {
Engine.playerItems.addItem(p, 9003, 1); p.teleportTo(3123, 3242, 0, 4, 0, 8939, 8941, 1118, 0, 1119, 0);
Engine.playerItems.addItem(p, 600, 1);
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Read the Rule Book & Information book before anything!<img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 131://Bandos
if (p.jailed == (0)) {
 p.teleportTo(2862, 5354, 2, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Click on door to fight! The bandos drop rate is 25%<img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 136://Armadyl
if (p.jailed == (0)) {
 p.teleportTo(2839, 5287, 2, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You have just teleported to the Armadyl lair!<img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 140://Saradomin
if (p.jailed == (0)) {
 p.teleportTo(2915, 5269, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Click on the door to fight the Saradomin boss!<img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 27://Zamorak
if (p.jailed == (0)) {
 p.teleportTo(2925, 5346, 2, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Click on the door to fight the Zamorak Boss!<img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 10://Home
if (p.jailed == (0)) {
 p.teleportTo(3212, 3429, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You have just teleported to Home!<img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 11://Shops
if (p.jailed == (0)) {
 p.teleportTo(3160, 3488, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You have just teleported to the Shops area!!<img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 28://Grand Exchange
if (p.jailed == (0)) {
 p.teleportTo(3160, 3488, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You teleport to the Grand Exchange!<img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 13://Clan Wars
if (p.jailed == (0)) {
 p.teleportTo(3271, 3687, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You teleport to Clan Wars! Be careful over there!<img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 14://Castle Wars
if (p.jailed == (0)) {
 p.teleportTo(2442, 3090, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Welcome to Castle Wars! Have fun!<img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 12://Barrows
if (p.jailed == (0)) {
 p.teleportTo(3567, 3290, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>Barrows drop rate is NOW <img=2>80%<img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 15://Bounty Hunter
if (p.jailed == (0)) {
 p.teleportTo(3180, 3685, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><col=fff000><shad=0202>You teleport to Bounty Hunter! Be careful out there!<img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 16://Ghost Zone
if (p.jailed == (0)) {
 p.teleportTo(3222, 3737, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><img=1><img=1><col=fff000><shad=0202>You enter the realm of the Ghost Town!!<img=1><img=1><img=1>");
p.frames.sendMessage(p, "<img=1><img=1><img=1><col=fff000><shad=0202>Beware! Your death might just be here!!<img=1><img=1><img=1>");
p.frames.sendMessage(p, "<img=1><img=1><img=1><col=fff000><shad=0202>Talk to the shop keeper for supplies!<img=1><img=1><img=1>");
p.frames.sendMessage(p, "<img=1><img=1><img=1><col=fff000><shad=0202>The rev dragons max hit is 10, they have 2k hp! They drop the rarest items!<img=1><img=1><img=1>");
p.frames.sendMessage(p, "<img=1><img=1><img=1><col=fff000><shad=0202>You pk here and you will be banned or ipbanned!<img=1><img=1><img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 18://Frozen
if (p.jailed == (0)) {
 p.teleportTo(2531, 3025, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><img=1><img=1><col=fff000><shad=0202>The Frozen Wastelands of an old battle field!<img=1><img=1><img=1>");
p.frames.sendMessage(p, "<img=1><img=1><img=1><col=fff000><shad=0202>Some Frozen monsters spirits still may lurk here! Be careful!<img=1><img=1><img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 20://Elf Zone
if (p.jailed == (0)) {
 p.teleportTo(2197, 3252, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><img=1><img=1><col=fff000><shad=0202>You teleport to the Elf training area!<img=1><img=1><img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 19://Chill
if (p.jailed == (0)) {
 p.teleportTo(2464, 4845, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><img=1><img=1><col=fff000><shad=0202>Welcome " + p.username + " to the Chill Area.<img=1><img=1><img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
case 17://Bandits
if (p.jailed == (0)) {
 p.teleportTo(2996, 3468, 0, 4, 0, 8939, 8941, 1678, 0, 1679, 0);
p.frames.sendMessage(p, "<img=1><img=1><img=1><col=fff000><shad=0202>You teleport to the bandits area! Awesome for training!<img=1><img=1><img=1>");
p.frames.sendMessage(p, "<img=1><img=1><img=1><col=fff000><shad=0202>Select talk to Bandit to get gear for here!<img=1><img=1><img=1>");
} else {
p.frames.sendMessage(p, "You can't teleport while in jail.");
p.frames.sendMessage(p, "Next time be more careful!");
}
break;
}
break;




//=======================CONSTRUCTION BUTTONS======================================
case 402:
switch(buttonId)
{
case 160://Parlour
if(p.absX >= 3093 && p.absY >= 3920 && p.absX <= 3120 && p.absY <= 3950 && p.heightLevel == p.HouseHeight)
{
if(Engine.playerItems.HasItemAmount(p, 995, 200) == false)
{
p.frames.sendMessage(p,"You need 200 coins to build this.");
}
else
{
Engine.playerItems.deleteItem(p, 995, Engine.playerItems.getItemSlot(p, 995), 200);
if(p.RoomDir == 0)
{
p.Garden = 0;
p.Room0Type = 1;
if(p.Room0 == 1) { p.frames.sendMessage(p,"You already have a room there.");}
else{
p.NewRoom(p, 3104, 3931, p.RoomDir, p.HouseHeight, p.HouseDecor, 1,0);
p.requestAnim(898, 0);
p.addSkillXP(3000*p.skillLvl[22], 22); }
}
if(p.RoomDir == 4)
{
p.Garden4 = 0;
p.Room4Type = 1;
if(p.Room4 == 1) { p.frames.sendMessage(p,"You already have a room there.");}
else{
p.NewRoom(p, 3104, 3923, p.RoomDir, p.HouseHeight, p.HouseDecor, 1,0);
p.requestAnim(898, 0);
p.addSkillXP(3000*p.skillLvl[22], 22); }
}

if(p.RoomDir == 1)
{
p.Garden1 = 0;
p.Room1Type = 1;
if(p.Room1 == 1) { p.frames.sendMessage(p,"You already have a room there.");}
else{
p.NewRoom(p, 3104, 3939, p.RoomDir, p.HouseHeight, p.HouseDecor, 1,0);
p.requestAnim(898, 0);
p.addSkillXP(3000*p.skillLvl[22], 22); }
}
if(p.RoomDir == 2)
{
p.Garden2 = 0;
p.Room2Type = 1;
if(p.Room2 == 1) { p.frames.sendMessage(p,"You already have a room there."); }
else{
p.NewRoom(p, 3112, 3931, p.RoomDir, p.HouseHeight, p.HouseDecor, 1,0);
p.requestAnim(898, 0);
p.addSkillXP(3000*p.skillLvl[22], 22); }
}
if(p.RoomDir == 3)
{
p.Garden3 = 0;
p.Room3Type = 1;
if(p.Room3 == 1) { p.frames.sendMessage(p,"You already have a room there."); }
else{
p.NewRoom(p, 3096, 3931, p.RoomDir, p.HouseHeight, p.HouseDecor, 1,0);
p.requestAnim(898, 0);
p.addSkillXP(3000*p.skillLvl[22], 22); }
}
}
}
else
{
p.RoomDir = 0;
p.frames.sendMessage(p,"You are not in your house!");
}
break;

case 161: //Garden
if(p.absX >= 3093 && p.absY >= 3920 && p.absX <= 3120 && p.absY <= 3950 && p.heightLevel == p.HouseHeight)
{
if(Engine.playerItems.HasItemAmount(p, 995, 250) == false)
{
p.frames.sendMessage(p,"You need 250 coins to build this.");
}
else
{
Engine.playerItems.deleteItem(p, 995, Engine.playerItems.getItemSlot(p, 995), 250);

if(p.RoomDir == 0)
{
p.Garden = 1;
p.Room0Type = 7;
if(p.Room0 == 1) { p.frames.sendMessage(p,"You already have a room there.");}
else{
p.NewRoom(p, 3104, 3931, p.RoomDir, p.HouseHeight, p.HouseDecor, 7,1);
p.requestAnim(898, 0); 
p.addSkillXP(10000*p.skillLvl[22], 22);}
}
if(p.RoomDir == 4)
{
p.Garden4 = 1;
p.Room4Type = 7;
if(p.Room4 == 1) { p.frames.sendMessage(p,"You already have a room there.");}
else{
p.NewRoom(p, 3104, 3923, p.RoomDir, p.HouseHeight, p.HouseDecor, 7,1);
p.requestAnim(898, 0);
p.addSkillXP(10000*p.skillLvl[22], 22); }
}

if(p.RoomDir == 1)
{
p.Garden1 = 1;
p.Room1Type = 7;
if(p.Room1 == 1) { p.frames.sendMessage(p,"You already have a room there.");}
else{
p.NewRoom(p, 3104, 3939, p.RoomDir, p.HouseHeight, p.HouseDecor, 7,1);
p.requestAnim(898, 0);
p.addSkillXP(10000*p.skillLvl[22], 22); }
}
if(p.RoomDir == 2)
{
p.Garden2 = 1;
p.Room2Type = 7;
if(p.Room2 == 1) { p.frames.sendMessage(p,"You already have a room there."); }
else{
p.NewRoom(p, 3112, 3931, p.RoomDir, p.HouseHeight, p.HouseDecor, 7,1);
p.requestAnim(898, 0);
p.addSkillXP(10000*p.skillLvl[22], 22); }
}
if(p.RoomDir == 3)
{
p.Garden3 = 1;
p.Room3Type = 7;
if(p.Room3 == 1) { p.frames.sendMessage(p,"You already have a room there."); }
else{
p.NewRoom(p, 3096, 3931, p.RoomDir, p.HouseHeight, p.HouseDecor, 7,1);
p.requestAnim(898, 0);
p.addSkillXP(10000*p.skillLvl[22], 22); }
}
}
}
else
{
p.RoomDir = 0;
p.frames.sendMessage(p,"You are not in your house!");
}
break;
case 162: //Kitchen
if(p.absX >= 3093 && p.absY >= 3920 && p.absX <= 3120 && p.absY <= 3950 && p.heightLevel == p.HouseHeight)
{
if(Engine.playerItems.HasItemAmount(p, 995, 350) == false)
{
p.frames.sendMessage(p,"You need 350 coins to build this.");
}
else
{
Engine.playerItems.deleteItem(p, 995, Engine.playerItems.getItemSlot(p, 995), 350);

if(p.RoomDir == 0)
{
p.Garden = 0;
p.Room0Type = 2;
if(p.Room0 == 1) { p.frames.sendMessage(p,"You already have a room there.");}
else{
p.NewRoom(p, 3104, 3931, p.RoomDir, p.HouseHeight, p.HouseDecor, 2,0);
p.requestAnim(898, 0);
p.addSkillXP(3000*p.skillLvl[22], 22);  }
}
if(p.RoomDir == 4)
{
p.Garden4 = 0;
p.Room4Type = 2;
if(p.Room4 == 1) { p.frames.sendMessage(p,"You already have a room there.");}
else{
p.NewRoom(p, 3104, 3923, p.RoomDir, p.HouseHeight, p.HouseDecor, 2,0);
p.requestAnim(898, 0);
p.addSkillXP(3000*p.skillLvl[22], 22);  }
}

if(p.RoomDir == 1)
{
p.Garden1 = 0;
p.Room1Type = 2;
if(p.Room1 == 1) { p.frames.sendMessage(p,"You already have a room there.");}
else{
p.NewRoom(p, 3104, 3939, p.RoomDir, p.HouseHeight, p.HouseDecor, 2,0);
p.requestAnim(898, 0);
p.addSkillXP(4000*p.skillLvl[22], 22); }
}
if(p.RoomDir == 2)
{
p.Garden2 = 0;
p.Room2Type = 2;
if(p.Room2 == 1) { p.frames.sendMessage(p,"You already have a room there."); }
else{
p.NewRoom(p, 3112, 3931, p.RoomDir, p.HouseHeight, p.HouseDecor, 2,0);
p.requestAnim(898, 0);
p.addSkillXP(4000*p.skillLvl[22], 22); }
}
if(p.RoomDir == 3)
{
p.Garden3 = 0;
p.Room3Type = 2;
if(p.Room3 == 1) { p.frames.sendMessage(p,"You already have a room there."); }
else{
p.NewRoom(p, 3096, 3931, p.RoomDir, p.HouseHeight, p.HouseDecor, 2,0);
p.requestAnim(898, 0);
p.addSkillXP(4000*p.skillLvl[22], 22); }
}
}
}
else
{
p.RoomDir = 0;
p.frames.sendMessage(p,"You are not in your house!");
}
break;
case 163: //Dining Room
p.frames.sendMessage(p,"Not Available.");
break;
case 164: //Work Shop
p.frames.sendMessage(p,"Not Available.");
break;
case 165: //Bedroom
if(p.absX >= 3093 && p.absY >= 3920 && p.absX <= 3120 && p.absY <= 3950 && p.heightLevel == p.HouseHeight)
{
if(Engine.playerItems.HasItemAmount(p, 995, 450) == false)
{
p.frames.sendMessage(p,"You need 1000 coins to build this.");
}
else
{
Engine.playerItems.deleteItem(p, 995, Engine.playerItems.getItemSlot(p, 995), 450);

if(p.RoomDir == 0)
{
p.Garden = 0;
p.Room0Type = 3;
if(p.Room0 == 1) { p.frames.sendMessage(p,"You already have a room there.");}
else{
p.NewRoom(p, 3104, 3931, p.RoomDir, p.HouseHeight, p.HouseDecor, 3,0);
p.requestAnim(898, 0);
p.addSkillXP(5000*p.skillLvl[22], 22); }
}
if(p.RoomDir == 4)
{
p.Garden4 = 0;
p.Room4Type = 3;
if(p.Room4 == 1) { p.frames.sendMessage(p,"You already have a room there.");}
else{
p.NewRoom(p, 3104, 3923, p.RoomDir, p.HouseHeight, p.HouseDecor, 3,0);
p.requestAnim(898, 0); 
p.addSkillXP(5000*p.skillLvl[22], 22);}
}

if(p.RoomDir == 1)
{
p.Garden1 = 0;
p.Room1Type = 3;
if(p.Room1 == 1) { p.frames.sendMessage(p,"You already have a room there.");}
else{
p.NewRoom(p, 3104, 3939, p.RoomDir, p.HouseHeight, p.HouseDecor, 3,0);
p.requestAnim(898, 0);
p.addSkillXP(5000*p.skillLvl[22], 22); }
}
if(p.RoomDir == 2)
{
p.Garden2 = 0;
p.Room2Type = 3;
if(p.Room2 == 1) { p.frames.sendMessage(p,"You already have a room there."); }
else{
p.NewRoom(p, 3112, 3931, p.RoomDir, p.HouseHeight, p.HouseDecor, 3,0);
p.requestAnim(898, 0);
p.addSkillXP(5000*p.skillLvl[22], 22); }
}
if(p.RoomDir == 3)
{
p.Garden3 = 0;
p.Room3Type = 3;
if(p.Room3 == 1) { p.frames.sendMessage(p,"You already have a room there."); }
else{
p.NewRoom(p, 3096, 3931, p.RoomDir, p.HouseHeight, p.HouseDecor, 3,0);
p.requestAnim(898, 0);
p.addSkillXP(5000*p.skillLvl[22], 22); }
}
}
}
else
{
p.RoomDir = 0;
p.frames.sendMessage(p,"You are not in your house!");
}
break;
case 166: //Hall
p.frames.sendMessage(p,"Not Available.");
break;
case 167: //Games Room
p.frames.sendMessage(p,"Not Available.");
break;
case 168: //Combat Room
p.frames.sendMessage(p,"Not Available.");
break;
case 169: //Hall
p.frames.sendMessage(p,"Not Available.");
break;
case 170: //Study
if(p.absX >= 3093 && p.absY >= 3920 && p.absX <= 3120 && p.absY <= 3950 && p.heightLevel == p.HouseHeight)
{


if(p.RoomDir == 0)
{
p.Garden = 0;
p.Room0Type = 6;
if(p.Room0 == 1) { p.frames.sendMessage(p,"You already have a room there.");}
else{
p.NewRoom(p, 3104, 3931, p.RoomDir, p.HouseHeight, p.HouseDecor, 6,0);
p.requestAnim(898, 0); }
}
if(p.RoomDir == 4)
{
p.Garden4 = 0;
p.Room4Type = 6;
if(p.Room4 == 1) { p.frames.sendMessage(p,"You already have a room there.");}
else{
p.NewRoom(p, 3104, 3923, p.RoomDir, p.HouseHeight, p.HouseDecor, 6,0);
p.requestAnim(898, 0); }
}


if(p.RoomDir == 1)
{
p.Garden1 = 0;
p.Room1Type = 6;
if(p.Room1 == 1) { p.frames.sendMessage(p,"You already have a room there.");}
else{
p.NewRoom(p, 3104, 3939, p.RoomDir, p.HouseHeight, p.HouseDecor, 6,0);
p.requestAnim(898, 0); }
}
if(p.RoomDir == 2)
{
p.Garden2 = 0;
p.Room2Type = 6;
if(p.Room2 == 1) { p.frames.sendMessage(p,"You already have a room there."); }
else{
p.NewRoom(p, 3112, 3931, p.RoomDir, p.HouseHeight, p.HouseDecor, 6,0);
p.requestAnim(898, 0); }
}
if(p.RoomDir == 3)
{
p.Garden3 = 0;
p.Room3Type = 6;
if(p.Room3 == 1) { p.frames.sendMessage(p,"You already have a room there."); }
else{
p.NewRoom(p, 3096, 3931, p.RoomDir, p.HouseHeight, p.HouseDecor, 6,0);
p.requestAnim(898, 0);
}
}
}
break;
case 171: //Costume
p.frames.sendMessage(p,"Not Available.");
break;
case 172: //Chapel
if(p.absX >= 3093 && p.absY >= 3920 && p.absX <= 3120 && p.absY <= 3950 && p.heightLevel == p.HouseHeight)
{
if(Engine.playerItems.HasItemAmount(p, 995, 600) == false)
{
p.frames.sendMessage(p,"You need 600 coins to build this.");
}
else
{
Engine.playerItems.deleteItem(p, 995, Engine.playerItems.getItemSlot(p, 995), 600);

if(p.RoomDir == 0)
{
p.Garden = 0;
p.Room0Type = 4;
if(p.Room0 == 1) { p.frames.sendMessage(p,"You already have a room there.");}
else{
p.NewRoom(p, 3104, 3931, p.RoomDir, p.HouseHeight, p.HouseDecor, 4,0);
p.requestAnim(898, 0);
p.addSkillXP(8000*p.skillLvl[22], 22);  }
}
if(p.RoomDir == 4)
{
p.Garden4 = 0;
p.Room4Type = 4;
if(p.Room4 == 1) { p.frames.sendMessage(p,"You already have a room there.");}
else{
p.NewRoom(p, 3104, 3923, p.RoomDir, p.HouseHeight, p.HouseDecor, 4,0);
p.requestAnim(898, 0);
p.addSkillXP(8000*p.skillLvl[22], 22);  }
}

if(p.RoomDir == 1)
{
p.Garden1 = 0;
p.Room1Type = 4;
if(p.Room1 == 1) { p.frames.sendMessage(p,"You already have a room there.");}
else{
p.NewRoom(p, 3104, 3939, p.RoomDir, p.HouseHeight, p.HouseDecor, 4,0);
p.requestAnim(898, 0);
p.addSkillXP(8000*p.skillLvl[22], 22); }
}
if(p.RoomDir == 2)
{
p.Garden2 = 0;
p.Room2Type = 4;
if(p.Room2 == 1) { p.frames.sendMessage(p,"You already have a room there."); }
else{
p.NewRoom(p, 3112, 3931, p.RoomDir, p.HouseHeight, p.HouseDecor, 4,0);
p.requestAnim(898, 0);
p.addSkillXP(8000*p.skillLvl[22], 22); }
}
if(p.RoomDir == 3)
{
p.Garden3 = 0;
p.Room3Type = 4;
if(p.Room3 == 1) { p.frames.sendMessage(p,"You already have a room there."); }
else{
p.NewRoom(p, 3096, 3931, p.RoomDir, p.HouseHeight, p.HouseDecor, 4,0);
p.requestAnim(898, 0);
p.addSkillXP(8000*p.skillLvl[22], 22); }
}
}
}
else
{
p.RoomDir = 0;
p.frames.sendMessage(p,"You are not in your house!");
}
break;

case 173: //Portal
p.frames.sendMessage(p,"Not Available.");
break;
case 174: //Formal Garden
p.frames.sendMessage(p,"Not Available.");
break;

case 175: //Throne
if(p.absX >= 3093 && p.absY >= 3920 && p.absX <= 3120 && p.absY <= 3950 && p.heightLevel == p.HouseHeight)
{
if(Engine.playerItems.HasItemAmount(p, 995, 1500) == false)
{
p.frames.sendMessage(p,"You need 1500 coins to build this.");
}
else
{
Engine.playerItems.deleteItem(p, 995, Engine.playerItems.getItemSlot(p, 995), 1500);

if(p.RoomDir == 0)
{
p.Garden = 0;
p.Room0Type = 5;
if(p.Room0 == 1) { p.frames.sendMessage(p,"You already have a room there.");}
else{
p.NewRoom(p, 3104, 3931, p.RoomDir, p.HouseHeight, p.HouseDecor, 5,0);
p.requestAnim(898, 0);
p.addSkillXP(10000*p.skillLvl[22], 22); }
}
if(p.RoomDir == 4)
{
p.Garden4 = 0;
p.Room4Type = 5;
if(p.Room4 == 1) { p.frames.sendMessage(p,"You already have a room there.");}
else{
p.NewRoom(p, 3104, 3923, p.RoomDir, p.HouseHeight, p.HouseDecor, 5,0);
p.requestAnim(898, 0);
p.addSkillXP(10000*p.skillLvl[22], 22); }
}

if(p.RoomDir == 1)
{
p.Garden1 = 0;
p.Room1Type = 5;
if(p.Room1 == 1) { p.frames.sendMessage(p,"You already have a room there.");}
else{
p.NewRoom(p, 3104, 3939, p.RoomDir, p.HouseHeight, p.HouseDecor, 5,0);
p.requestAnim(898, 0);
p.addSkillXP(10000*p.skillLvl[22], 22); }
}
if(p.RoomDir == 2)
{
p.Garden2 = 0;
p.Room2Type = 5;
if(p.Room2 == 1) { p.frames.sendMessage(p,"You already have a room there."); }
else{
p.NewRoom(p, 3112, 3931, p.RoomDir, p.HouseHeight, p.HouseDecor, 5,0);
p.requestAnim(898, 0);
p.addSkillXP(10000*p.skillLvl[22], 22); }
}
if(p.RoomDir == 3)
{
p.Garden3 = 0;
p.Room3Type = 5;
if(p.Room3 == 1) { p.frames.sendMessage(p,"You already have a room there."); }
else{
p.NewRoom(p, 3096, 3931, p.RoomDir, p.HouseHeight, p.HouseDecor, 5,0);
p.requestAnim(898, 0);
p.addSkillXP(10000*p.skillLvl[22], 22); }
}
}
}
else
{
p.RoomDir = 0;
p.frames.sendMessage(p,"You are not in your house!");
}
break;

case 176: //Oubliette
p.frames.sendMessage(p,"Not Available.");
break;

case 177: //Dungeon
p.frames.sendMessage(p,"Not Available.");
break;

case 178: //Dungeon
p.frames.sendMessage(p,"Not Available.");
break;

case 179: //Dungeon Stairs
p.frames.sendMessage(p,"Not Available.");
break;

case 180: //Treasure ROom
p.frames.sendMessage(p,"Not Available.");
break;




}
p.frames.removeShownInterface(p);
p.frames.removeChatboxInterface(p);
break;

//=================================END OF CONSTRUCTION BUTTONS============================
        	case 589:
        		if(buttonId == 9) {
        			p.frames.showInterface(p, 590);
        		}
        		break;
case 669:
if(buttonId == 18) {
		p.frames.showInterface(p, 666);
}
break;
case 300:
if(buttonId == 25) { // dragon platebody
}
 if (Engine.playerItems.invItemCount(p, 11550) > 1 && Engine.playerItems.invItemCount(p, 11551) > 1 && Engine.playerItems.invItemCount(p, 11552) > 1) {
Engine.playerItems.deleteItem(p, 11550, 1);
Engine.playerItems.deleteItem(p, 11551, 1);
Engine.playerItems.deleteItem(p, 11552, 1);
Engine.playerItems.addItem(p, 1121, 1);
}
break;
case 45:
if(buttonId == 87) { // fire
p.setCoords(2587, 4836, 0);
}
if(buttonId == 89) { // water
p.setCoords(3482, 4838, 0);
}
if(buttonId == 90) { // earth
p.setCoords(2657, 4830, 0);
}
if(buttonId == 91) { // air
p.frames.sendMessage(p, "The alter is near by");
}
if(buttonId == 92) { // mind
p.frames.sendMessage(p, "The alter is near by");
}
if(buttonId == 93) { // body
p.setCoords(2522, 4842, 0);
}
if(buttonId == 94) { // nature
p.setCoords(2400, 4844, 0);
}
if(buttonId == 95) { // chaos
p.setCoords(2269, 4840, 0);
}
if(buttonId == 96) { // law
p.setCoords(2466, 4833, 0);
}
if(buttonId == 97) { // cosmic
p.setCoords(2142, 4836, 0);
}
if(buttonId == 98) { // blood
p.frames.sendMessage(p, "The alter is near by");
}
if(buttonId == 99) { // soul
p.setCoords(2200, 4836, 0);
}
break;

case 1024:
if(buttonId == 1) {
p.requestForceChat("<img=3>My Agility level is, " + p.skillLvl[16] + ".");
}
if(buttonId == 8) {
p.requestForceChat("<img=3>My Attack level is, " + p.skillLvl[0] + ".");
}
if(buttonId == 13) {
p.requestForceChat("<img=3>My Construction level is, " + p.skillLvl[22] + ".");
}
if(buttonId == 16) {
p.requestForceChat("<img=3>My Cooking level is, " + p.skillLvl[7] + ".");
}
if(buttonId == 23) {
p.requestForceChat("<img=3>My Crafting level is, " + p.skillLvl[12] + ".");
}
if(buttonId == 30) {
p.requestForceChat("<img=3>My Defence level is, " + p.skillLvl[1] + ".");
}
if(buttonId == 34) {
p.requestForceChat("<img=3>My Farming level is, " + p.skillLvl[19] + ".");
}
if(buttonId == 41) {
p.requestForceChat("<img=3>My Firemaking level is, " + p.skillLvl[11] + ".");
}
if(buttonId == 47) {
p.requestForceChat("<img=3>My Fishing level is, " + p.skillLvl[10] + ".");
}
if(buttonId == 55) {
p.requestForceChat("<img=3>My Fletching level is, " + p.skillLvl[9] + ".");
}
if(buttonId == 62) {
p.requestForceChat("<img=3>My Herblore level is, " + p.skillLvl[15] + ".");
}
if(buttonId == 70) {
p.requestForceChat("<img=3>My Hitpoints level is, " + p.skillLvl[3] + ".");
}
if(buttonId == 74) {
p.requestForceChat("<img=3>My Hunter level is, " + p.skillLvl[21] + ".");
}
if(buttonId == 135) {
p.requestForceChat("<img=3>My Magic level is, " + p.skillLvl[6] + ".");
}
if(buttonId == 127) {
p.requestForceChat("<img=3>My Mining level is, " + p.skillLvl[14] + ".");
}
if(buttonId == 120) {
p.requestForceChat("<img=3>My Prayer level is, " + p.skillLvl[5] + ".");
}
if(buttonId == 116) {
p.requestForceChat("<img=3>My Range level is, " + p.skillLvl[4] + ".");
}
if(buttonId == 111) {
p.requestForceChat("<img=3>My Runecrafting level is, " + p.skillLvl[20] + ".");
}
if(buttonId == 103) {
p.requestForceChat("<img=3>My Slayer level is, " + p.skillLvl[18] + ".");
}
if(buttonId == 96) {
p.requestForceChat("<img=3>My Smithing level is, " + p.skillLvl[13] + ".");
}
if(buttonId == 92) {
p.requestForceChat("<img=3>My Strength level is, " + p.skillLvl[2] + ".");
}
if(buttonId == 85) {
p.requestForceChat("<img=3>My Summoning level is, " + p.skillLvl[23] + ".");
}
if(buttonId == 79) {
p.requestForceChat("<img=3>My Theiving level is, " + p.skillLvl[17] + ".");
}
if(buttonId == 142) {
p.requestForceChat("<img=3>My Woodcutting level is, " + p.skillLvl[80] + ".");
}
break;



case 768:
if(buttonId == 153) {
p.requestForceChat("<img=3>Yes");
}
if(buttonId == 154) {
p.requestForceChat("<img=3>No");
}
if(buttonId == 155) {
p.requestForceChat("<img=3>Okay");
}
if(buttonId == 156) {
p.requestForceChat("<img=3>Maybe");
}
if(buttonId == 157) {
p.requestForceChat("<img=3>I Don't Know");
}
if(buttonId == 158) {
p.requestForceChat("<img=3>Thank You!");
}
if(buttonId == 159) {
p.requestForceChat("<img=3>Your Welcome");
}
if(buttonId == 160) {
p.requestForceChat("<img=3>Sorry");
}
if(buttonId == 147) {
p.requestForceChat("<img=3>Hello!");
}
if(buttonId == 148) {
p.requestForceChat("<img=3>Hi");
}
if(buttonId == 149) {
p.requestForceChat("<img=3>Good Day");
}
if(buttonId == 150) {
p.requestForceChat("<img=3>Nice To Meet You!");
}
if(buttonId == 151) {
p.requestForceChat("<img=3>How Are you?");
}
if(buttonId == 161) {
p.requestForceChat("<img=3>Bye!");
}
if(buttonId == 162) {
p.requestForceChat("<img=3>See You Later.");
}
if(buttonId == 163) {
p.requestForceChat("<img=3>Be right back.");
}
if(buttonId == 164) {
p.requestForceChat("<img=3>I've got to go.");
}
if(buttonId == 165) {
p.requestForceChat("<img=3>Goodnight");
}
if(buttonId == 166) {
p.requestForceChat("<img=3>I have to log off.");
}
if(buttonId == 167) {
p.requestForceChat("<img=3>Please Stop that.");
}
if(buttonId == 168) {
p.requestForceChat("<img=3>That's Good.");
}
if(buttonId == 169) {
p.requestForceChat("<img=3>That's Bad.");
}
if(buttonId == 170) {
p.requestForceChat("<img=3>Please Run.");
}
if(buttonId == 171) {
p.requestForceChat("<img=3>Hang on a second.");
}
if(buttonId == 172) {
p.requestForceChat("<img=3>I can't do that.");
}
if(buttonId == 173) {
p.requestForceChat("<img=3>w00t!");
}
if(buttonId == 174) {
p.requestForceChat("<img=3>Not right now.");
}
if(buttonId == 175) {
p.requestForceChat("<img=3>I'm happy.");
}
if(buttonId == 176) {
p.requestForceChat("<img=3>I'm sad.");
}
if(buttonId == 177) {
p.requestForceChat("<img=3>I'm great!");
}
if(buttonId == 178) {
p.requestForceChat("<img=3>I'm good.");
}
if(buttonId == 179) {
p.requestForceChat("<img=3>I'm okay.");
}
if(buttonId == 180) {
p.requestForceChat("<img=3>Meh.");
}
if(buttonId == 181) {
p.requestForceChat("<img=3>I've been beter.");
}
if(buttonId == 182) {
p.requestForceChat("<img=3>I'm having a bad day.");
}
if(buttonId == 183) {
p.requestForceChat("<img=3>:-)");
}
if(buttonId == 184) {
p.requestForceChat("<img=3>:-(");
}
if(buttonId == 185) {
p.requestForceChat("<img=3>:-|");
}
if(buttonId == 186) {
p.requestForceChat("<img=3>:-D");
}
if(buttonId == 187) {
p.requestForceChat("<img=3>:-S");
}
if(buttonId == 188) {
p.requestForceChat("<img=3>:-O");
} 
if(buttonId == 189) {
p.requestForceChat("<img=3>:-P.");
}
if(buttonId == 190) {
p.requestForceChat("<img=3>;-)");
}
if(buttonId == 191) {
p.requestForceChat("<img=3>I won!");
}
if(buttonId == 192) {
p.requestForceChat("<img=3>Aww, I lost.");
}
if(buttonId == 193) {
p.requestForceChat("<img=3>Good game, all.");
}
if(buttonId == 194) {
p.requestForceChat("<img=3>Who wants a rematch?");
}
if(buttonId == 195) {
p.requestForceChat("<img=3>Well done.");
}
if(buttonId == 196) {
p.requestForceChat("<img=3>Unlucky, maybe next time.");
}
if(buttonId == 197) {
p.requestForceChat("<img=3>Got you with that one!");
}
if(buttonId == 198) {
p.requestForceChat("<img=3>Buh bye.");
}
if(buttonId == 199) {
p.requestForceChat("<img=3>That's gotta hurt.");
}
if(buttonId == 200) {
p.requestForceChat("<img=3>Another one bites the dust.");
}
if(buttonId == 201) {
p.requestForceChat("<img=3>I have you now!");
}
if(buttonId == 202) {
p.requestForceChat("<img=3>Fear my leet skills.");
}
if(buttonId == 203) {
p.requestForceChat("<img=3>I'll get you!");
}
if(buttonId == 204) {
p.requestForceChat("<img=3>I'm coming for ya.");
}
if(buttonId == 205) {
p.requestForceChat("<img=3>Run and hide, pal.");
}
if(buttonId == 206) {
p.requestForceChat("<img=3>Don't hurt me!");
}
if(buttonId == 207) {
p.requestForceChat("<img=3>I love this game!");
}
if(buttonId == 208) {
p.requestForceChat("<img=3>I Don't like this game.");
}
if(buttonId == 210) {
p.requestForceChat("<img=3>Nicely done.");
}
if(buttonId == 211) {
p.requestForceChat("<img=3>Nice hit.");
}
if(buttonId == 212) {
p.requestForceChat("<img=3>I like yours familiar.");
}
if(buttonId == 213) {
p.requestForceChat("<img=3>I like your pet.");
}
if(buttonId == 214) {
p.requestForceChat("<img=3>You look cool.");
}
if(buttonId == 215) {
p.requestForceChat("<img=3>Nice levels.");
}
if(buttonId == 217) {
p.requestForceChat("<img=3>Help!");
}
if(buttonId == 219) {
p.requestForceChat("<img=3>Would you protect my gravestone,please?");
}
if(buttonId == 221) {
p.requestForceChat("<img=3>Try looking in the Game Guide.");
}
if(buttonId == 231) {
p.requestForceChat("<img=3>Where are you?");
} 
if(buttonId == 235) {
p.requestForceChat("<img=3>What are you doing?");
}
if(buttonId == 239) {
p.requestForceChat("<img=3>I am doing a treasure trail.");
}
if(buttonId == 493) {
p.requestForceChat("<img=3>Bank sale!");
}
if(buttonId == 496) {
p.requestForceChat("<img=3>That's too much would you accept less?");
}
if(buttonId == 497) {
p.requestForceChat("<img=3>That's not enough would you offer more?");
}
if(buttonId == 498) {
p.requestForceChat("<img=3>No deal, sorry.");
}
if(buttonId == 499) {
p.requestForceChat("<img=3>It's a deal");
}
if(buttonId == 503) {
p.requestForceChat("<img=3>Could i please have some antipoision?");
}
if(buttonId == 504) {
p.requestForceChat("<img=3>Could i please have some food?");
}
if(buttonId == 505) {
p.requestForceChat("<img=3>Hang on; my inventory is full.");
}
if(buttonId == 545) {
p.requestForceChat("<img=3>I'm planning to log out; this will end the loan..");
}


case 666:
if(buttonId == 18) {
		p.frames.showInterface(p, 669);
}
break;
case 458:

switch(buttonId)
{
case 1:
if(p.Choice == 1)
{
p.Choice = 0;
p.Dialogue = 104;
p.frames.showChatboxInterface(p, 241);
p.frames.animateInterfaceId(p, 9850, 241, 2);
p.frames.setNPCId(p, 198, 241, 2);
p.frames.setString(p, "Guildmaster", 241, 3);
p.frames.setString(p, "I think the oracle on ice mountain has a map.", 241, 4);
}
else
if(p.Choice == 2)
{
if(Engine.playerItems.HasItemAmount(p, 1538, 1) == true)
{
p.Choice = 0;
p.Dialogue = 109;
p.frames.showChatboxInterface(p, 241);
p.frames.animateInterfaceId(p, 9850, 241, 2);
p.frames.setNPCId(p, 744, 241, 2);
p.frames.setString(p, "Klarense", 241, 3);
p.frames.setString(p, "Looks like you have a map! Lets go.", 241, 4);
}
else
{
p.Choice = 0;
p.Dialogue = 0;
p.frames.showChatboxInterface(p, 241);
p.frames.animateInterfaceId(p, 9827, 241, 2);
p.frames.setNPCId(p, 744, 241, 2);
p.frames.setString(p, "Klarense", 241, 3);
p.frames.setString(p, "Sorry mate, I need a map to do that.", 241, 4);
}
}
else
if(p.Choice == 3)
{
p.Choice = 0;
p.Dialogue = 0;
p.setCoords(2399, 5178, 0);
p.frames.removeShownInterface(p);
p.frames.removeChatboxInterface(p);
}
else
if(p.ClanGame == true)
{
p.ClanGame = false;
p.clanheight = 4;
p.Opposing = 2;
p.ClanSide = 0;
p.setCoords(3291,3830,4);
p.clanchat = 1;
p.ClanCount = 1;
p.ClanTimer = 90;
p.ClanBattle = true;
p.frames.sendMessage(p, "<col=fff000><shad=0202> You have been brought to a server clan wars game.");
p.frames.removeShownInterface(p);
p.frames.removeChatboxInterface(p);
}

else if(p.Cooking == true)
{
p.CookAmount = 1;
p.CookThat(p, p.CookXP, p.CookID, p.CookGet);
p.frames.removeShownInterface(p);
p.frames.removeChatboxInterface(p);
}
else if(p.Smithing == true)
{
p.SmithingAmount = 1;
p.SmeltThat(p, p.SmithingXP, p.SmithingID, p.SmithingGet);
p.frames.removeShownInterface(p);
p.frames.removeChatboxInterface(p);
}
else if(p.Runecrafting == true)
{
p.RunecraftingAmount = 1;
p.RunecraftThat(p, p.RunecraftingXP, p.RunecraftingID, p.RunecraftingGet);
p.frames.removeShownInterface(p);
p.frames.removeChatboxInterface(p);
}
else
if(p.TalkAgent == true)
{
if(p.skillLvl[22] > 98)
{ GetSkillCape(p, 52, 4247, "Estate Agent", "Construction"); }
else { OnlyLevel(p, 53, 4247, "Estate Agent", 22, "Construction"); }
}
else
if(p.DecorChange == true)
{
if(Engine.playerItems.HasItemAmount(p, 995, 500) == true)
{
Engine.playerItems.deleteItem(p, 995, Engine.playerItems.getItemSlot(p, 995), 500);
p.HouseDecor = 1585;
p.frames.removeShownInterface(p);
p.frames.removeChatboxInterface(p);
p.frames.sendMessage(p,"You purchased Stone decoration!");
}
else
{
p.frames.removeShownInterface(p);
p.frames.removeChatboxInterface(p);
p.frames.sendMessage(p,"You do not have enough coins.");
}
}
else
{
if(p.skillLvl[18] > 98)
{ GetSkillCape(p, 44, 1599, "Duradel", "Slayer"); }
else { OnlyLevel(p, 45, 1599, "Duradel", 18, "Slayer"); }
}

break;


case 2:

if(p.Choice == 1)
{
p.Choice = 0;
p.Dialogue = 104;
p.frames.showChatboxInterface(p, 241);
p.frames.animateInterfaceId(p, 9850, 241, 2);
p.frames.setNPCId(p, 198, 241, 2);
p.frames.setString(p, "Guildmaster", 241, 3);
p.frames.setString(p, "Klarense at port sarim may have a boat for sale.", 241, 4);
}
else
if(p.Choice == 2)
{
p.Choice = 0;
p.Dialogue = 0;
p.frames.showChatboxInterface(p, 241);
p.frames.animateInterfaceId(p, 9827, 241, 2);
p.frames.setNPCId(p, 744, 241, 2);
p.frames.setString(p, "Klarense", 241, 3);
p.frames.setString(p, "Uhh..yeah I guess they're pretty cool.", 241, 4);
}
else
if(p.Choice == 3)
{
p.Choice = 0;
p.Dialogue = 0;
p.setCoords(2442, 3090, 0);
p.frames.removeShownInterface(p);
p.frames.removeChatboxInterface(p);
}
else
if(p.ClanGame == true)
{
p.ClanGame = false;
p.clanheight = 4;
p.Opposing = 1;
p.ClanSide = 1;
p.setCoords(3299,3722,4);
p.clanchat = 2;
p.ClanCount = 1;
p.ClanTimer = 90;
p.ClanBattle = true;
p.frames.sendMessage(p, "<col=fff000><shad=0202> You have been brought to a server clan wars game.");
p.frames.removeShownInterface(p);
p.frames.removeChatboxInterface(p);
}
else if(p.Cooking == true)
{
p.CookAmount = 5;
p.CookThat(p, p.CookXP, p.CookID, p.CookGet);
p.frames.removeShownInterface(p);
p.frames.removeChatboxInterface(p);
}
else if(p.Smithing == true)
{
p.SmithingAmount = 5;
p.SmeltThat(p, p.SmithingXP, p.SmithingID, p.SmithingGet);
p.frames.removeShownInterface(p);
p.frames.removeChatboxInterface(p);
}
else if(p.Runecrafting == true)
{
p.RunecraftingAmount = 5;
p.RunecraftThat(p, p.RunecraftingXP, p.RunecraftingID, p.RunecraftingGet);
p.frames.removeShownInterface(p);
p.frames.removeChatboxInterface(p);
}
else
if(p.TalkAgent == true)
{
p.frames.showChatboxInterface(p, 241);
p.frames.animateInterfaceId(p, 9850, 241, 2);
p.frames.setNPCId(p, 4247, 241, 2);
p.frames.setString(p, "EstateAgent", 241, 3);
p.frames.setString(p, "Just type ::goinhouse [player name].", 241, 4); 
}
else
if(p.DecorChange == true)
{
if(p.skillLvl[22] < 50)
{
p.frames.sendMessage(p,"You need level 50 construction for this.");
p.frames.removeShownInterface(p);
p.frames.removeChatboxInterface(p);
}
else
{
if(Engine.playerItems.HasItemAmount(p, 995, 1000) == true)
{
Engine.playerItems.deleteItem(p, 995, Engine.playerItems.getItemSlot(p, 995), 1000);
p.HouseDecor = 1588;
p.frames.removeShownInterface(p);
p.frames.removeChatboxInterface(p);
p.frames.sendMessage(p,"You purchased Dark Stone decoration!");
}
else
{
p.frames.removeShownInterface(p);
p.frames.removeChatboxInterface(p);
p.frames.sendMessage(p,"You do not have enough coins.");
}
}
}
else
{
p.SlayerTask = Misc.random(4);
p.SlayerAm = 1+ Misc.random(9);
p.frames.showChatboxInterface(p, 241);
p.frames.animateInterfaceId(p, 9850, 241, 2);
p.frames.setNPCId(p, 1599, 241, 2);
p.frames.setString(p, "Duradel", 241, 3);
if(p.SlayerTask == 0) { p.frames.setString(p, "You must slay "+p.SlayerAm+" Dragons.", 241, 4); }
if(p.SlayerTask == 1) { p.frames.setString(p, "You must slay "+p.SlayerAm+" Guards.", 241, 4); }
if(p.SlayerTask == 2) { p.frames.setString(p, "You must slay "+p.SlayerAm+" Giants.", 241, 4); }
if(p.SlayerTask == 3) { p.frames.setString(p, "You must slay "+p.SlayerAm+" Ghosts.", 241, 4); }
if(p.SlayerTask == 4) { p.frames.setString(p, "You must slay "+p.SlayerAm+" Heroes.", 241, 4); }
}
break;

case 3:
if(p.Choice == 1)
{
p.Choice = 0;
p.Dialogue = 104;
p.frames.showChatboxInterface(p, 241);
p.frames.animateInterfaceId(p, 9850, 241, 2);
p.frames.setNPCId(p, 198, 241, 2);
p.frames.setString(p, "Guildmaster", 241, 3);
p.frames.setString(p, "I think the Duke of lumbridge has some sort of shield.", 241, 4);
}
else
if(p.Choice == 2)
{
p.Choice = 0;
p.Dialogue = 0;
p.setCoords(2442, 3090, 0);
p.frames.removeShownInterface(p);
p.frames.removeChatboxInterface(p);
}
else
if(p.Choice == 3)
{
p.Choice = 0;
p.Dialogue = 0;
p.setCoords(3048, 3203, 0);
p.frames.removeShownInterface(p);
p.frames.removeChatboxInterface(p);
}
else
if(p.ClanGame == true)
{
p.frames.removeShownInterface(p);
p.frames.removeChatboxInterface(p);
p.ClanGame = false;
}
else if(p.Cooking == true)
{
p.CookAmount = 28;
p.CookThat(p, p.CookXP, p.CookID, p.CookGet);
p.frames.removeShownInterface(p);
p.frames.removeChatboxInterface(p);
}
else
if(p.Runecrafting == true)
{
p.RunecraftingAmount = 28;
p.RunecraftThat(p, p.RunecraftingXP, p.RunecraftingID, p.RunecraftingGet);
p.frames.removeShownInterface(p);
p.frames.removeChatboxInterface(p);
}
else
if(p.Smithing == true)
{
p.SmithingAmount = 28;
p.SmeltThat(p, p.SmithingXP, p.SmithingID, p.SmithingGet);
p.frames.removeShownInterface(p);
p.frames.removeChatboxInterface(p);
}
else
if(p.TalkAgent == true)
{
p.Runecrafting = false;
p.Smithing = false;
p.Cooking = false;
p.TalkAgent = false;
p.DecorChange = true;
p.frames.setString(p, "Stone 500", 458, 1);
p.frames.setString(p, "Dark Stone 1000", 458, 2);
p.frames.setString(p, "White Stone 2500", 458, 3);
p.frames.showChatboxInterface(p, 458);
}
else
if(p.DecorChange == true)
{
if(p.skillLvl[22] < 80)
{
p.frames.sendMessage(p,"You need level 80 construction for this.");
p.frames.removeShownInterface(p);
p.frames.removeChatboxInterface(p);
}
else
{
if(Engine.playerItems.HasItemAmount(p, 995, 2500) == true)
{
Engine.playerItems.deleteItem(p, 995, Engine.playerItems.getItemSlot(p, 995), 2500);
p.HouseDecor = 13116;
p.frames.removeShownInterface(p);
p.frames.removeChatboxInterface(p);
p.frames.sendMessage(p,"You purchased White Stone decoration!");
}
else
{
p.frames.removeShownInterface(p);
p.frames.removeChatboxInterface(p);
p.frames.sendMessage(p,"You do not have enough coins.");
}
}
}
else
{
 p.frames.showInterface(p, 120);
p.SlayerCaveTimer = 4; 
p.frames.showChatboxInterface(p, 241);
p.frames.animateInterfaceId(p, 9780, 241, 2);
p.frames.setNPCId(p, 1599, 241, 2);
p.frames.setString(p, "", 241, 3);
p.frames.setString(p, "Be careful in there...", 241, 4);
}




break;
}

break;

case 596://MALES
switch(buttonId) {

case 160:
p.frames.removeShownInterface(p);
p.frames.sendMessage(p,"You didn't pay a thing!.");
break;

case 245:
p.colour[2] = 2;
break;
case 167: //Bald
p.look[0] = 0;
break;
case 168: //Dreadlochs
p.look[0] = 1;
break;
case 169: //Long Hair
p.look[0] = 2;
break;
case 170: //medium hair
p.look[0] = 3;
break;
case 171: //short
p.look[0] = 4;
break;
case 172: //monk
p.look[0] = 5;
break;
case 173: //Closed cropped
p.look[0] = 6;
break;
case 174: //wild spikes
p.look[0] = 7;
break;
case 175: //spikes
p.look[0] = 8;
break;
case 176: //mohawk
p.look[0] = 91;
break;
case 177: //Wind braids
p.look[0] = 92;
break;
case 178: //Quiff
p.look[0] = 93;
break;
case 179: //samurai
p.look[0] = 94;
break;
case 180: //prince
p.look[0] = 95;
break;
case 181: //curtains
p.look[0] = 96;
break;
case 182: //long curtains
p.look[0] = 97;
break;

case 183: //Goatee
p.look[1] = 10;
break;
case 184: //Long Beard
p.look[1] = 11;
break;
case 185: //Med Beard
p.look[1] = 12;
break;
case 186: //Mustouche
p.look[1] = 13;
break;
case 187: //Clean Shaven
p.look[1] = 14;
break;
case 188: //Short Beard
p.look[1] = 15;
break;
case 189: //Short Full
p.look[1] = 16;
break;
case 190: //Split
p.look[1] = 17;
break;
case 191: //Handle Bar 
p.look[1] = 98;
break;
case 192: //Mutton
p.look[1] = 99;
break;
case 193: //Full Mutton
p.look[1] = 100;
break;
case 194: //Full Mustouche
p.look[1] = 101;
break;
case 195: //Waxed
p.look[1] = 102;
break;
case 196: //Dali
p.look[1] = 103;
break;
case 197: //Visier
p.look[1] = 104;
break;







}
p.appearanceUpdateReq = true;
		p.updateReq = true;
break;
case 592://FEMALES
switch(buttonId) {

case 21:
p.frames.removeShownInterface(p);
p.frames.sendMessage(p,"You didn't pay a thing!.");
break;

case 168: //Bald
p.look[0] = 45;
break;
case 169: //Bun
p.look[0] = 46;
break;
case 170: //DreadLocks 
p.look[0] = 47;
break;
case 171: //Long 
p.look[0] = 48;
break;
case 172: //Short 51
p.look[0] = 51;
break;
case 173: //PigTails 50
p.look[0] = 50;
break;
case 174: //CrewCut
p.look[0] = 52;
break;
case 175: //ClosedCropped
p.look[0] = 53;
break;
case 176: //Wild Spikes 54
p.look[0] = 54;
break;
case 177: //Spikes 55
p.look[0] = 55;
break;
case 178: //Side pony tail
p.look[0] = 135;
break;
case 179: //curls
p.look[0] = 136;
break;
case 180: //Wind braids
p.look[0] = 137;
break;
case 181: //poneytail
p.look[0] = 138;
break;
case 182: //braids
p.look[0] = 139;
break;
case 183: //4 poneys 140
p.look[0] = 140;
break;
case 184: //bob
p.look[0] = 141;
break;
case 185: //layered
p.look[0] = 142;
break;
case 186: //straight
p.look[0] = 143;
break;
case 187: //long braids
p.look[0] = 144;
break;
case 188: //curtains
p.look[0] = 145;
break;
case 189: //ear muffs
p.look[0] = 146;
break;




}



p.appearanceUpdateReq = true;
		p.updateReq = true;
break;

case 591:
switch(buttonId) {

case 180:
p.frames.removeShownInterface(p);
p.frames.sendMessage(p,"You didn't pay a thing!.");
break;

case 185: //Striped Sweater
p.look[2] = 111;
break;
case 186://Woollen Vest
p.look[2] = 113;
break;
case 187://Princely Vest
p.look[2] = 114;
break;
case 188://Tattered WaistCoat
p.look[2] = 115;
break;
case 189://Fine Shirt
p.look[2] = 112;
break;
case 190://Waist Coat
p.look[2] = 116;
break;
case 191://Plain Top 18
p.look[2] = 18;
break;
case 192://Light Buttons 19
p.look[2] = 19;
break;
case 193://Dark Buttons 20
p.look[2] = 20;
break;
case 194://Jacket 21
p.look[2] = 21;
break;
case 195://Shirt22
p.look[2] = 22;
break;
case 196://Stitching 23
p.look[2] = 23;
break;
case 197://Ragged Top 24
p.look[2] = 24;
break;
case 198://Two Toned 25
p.look[2] = 25;
break;

case 199: //Striped Arms
p.look[3] = 105;
break;
case 200: //Princley Sleeves 108
p.look[3] = 108;
break;
case 201: //Fine Cuffs 106
p.look[3] = 106;
break;
case 202: //Woollen Sleeves 107
p.look[3] = 107;
break;
case 203: //Ragged Arms
p.look[3] = 109;
break;

case 204: //Tattered Sleeves
p.look[3] = 110;
break;

case 205: //LooseSleeve 28
p.look[3] = 28;
break;

case 206: //Regular 26
p.look[3] = 26;
break;

case 207: //Muscle Bound 27
p.look[3] = 27;
break;

case 208: //Large Cuffed
p.look[3] = 29;
break;

case 209: //Thin Sleeved
p.look[3] = 30;
break;

case 210: //Shoulder Pads
p.look[3] = 31;
break;

case 211: //Plain Trousers
p.look[5] = 36;
break;
case 212: //Princley Breeches
p.look[5] = 85;
break;
case 213: //shorts 37
p.look[5] = 37;
break;
case 214: //Ragged Breeches 89
p.look[5] = 89;
break;
case 215: //Tattered Breeches90
p.look[5] = 90;
break;
case 216: //Torn Trousers
p.look[5] = 41;
break;
case 217: //Breeches
p.look[5] = 86;
break;
case 218: //Striped Trousers 88
p.look[5] = 88;
break;
case 219: //Turn ups 39
p.look[5] = 39;
break;
case 220: //Flares 38
p.look[5] = 38;
break;

case 221: //Fine Breeches 87
p.look[5] = 87;
break;

}
p.appearanceUpdateReq = true;
p.updateReq = true;
break;
		case 751:
		switch(buttonId) {

		case 27:
		p.frames.showInterface(p, 553);
		break;
		}
		break;
		
		case 320: // Skills Tab.
				boolean lvlup = false;

if(p.AtDuel())
{
p.frames.sendMessage(p, "You cannot teleport out of a duel!");
}
else
{
				switch(buttonId) {
					case 125: //Attack
p.setCoords(3237, 9861, 0); 
/*
						if(!p.leveledUp[0]){
							p.skillMenu = 1;
							p.frames.setConfig(p, 965, 1);
						} else {
							lvlup = true;
							p.frames.setConfig(p, 1230, 10);
						}
*/
				        break;
				    case 126: //Strength
p.setCoords(3237, 9861, 0); 
/*
						if(!p.leveledUp[2]){
							p.skillMenu = 2;
							p.frames.setConfig(p, 965, 2);
						} else {
							lvlup = true;
							p.frames.setConfig(p, 1230, 20);
						}
*/
				        break;
				    case 127: //Defence
p.setCoords(3237, 9861, 0); 
/*
						if(!p.leveledUp[1]){
							p.skillMenu = 5;
							p.frames.setConfig(p, 965, 5);
						} else {
							lvlup = true;
							p.frames.setConfig(p, 1230, 40);
						}
*/
				        break;
				    case 128: //Ranged
p.setCoords(3237, 9861, 0); 
/*
						if(!p.leveledUp[4]){
							p.skillMenu = 3;
							p.frames.setConfig(p, 965, 3);
						} else {
							lvlup = true;
							p.frames.setConfig(p, 1230, 30);
						}
*/
				        break;
				    case 129: //Prayer
p.setCoords(3059, 3491, 1); 
/*
						if(!p.leveledUp[5]){
							p.skillMenu = 7;
							p.frames.setConfig(p, 965, 7);
						} else {
							lvlup = true;
							p.frames.setConfig(p, 1230, 60);
						}
*/
				        break;
				    case 130: //Magic
p.setCoords(2595, 3087, 1); 
/*
						if(!p.leveledUp[6]){
							p.skillMenu = 4;
							p.frames.setConfig(p, 965, 4);
						} else {
							lvlup = true;
							p.frames.setConfig(p, 1230, 33);
						}
*/
				        break;
				    case 131: //Runecrafting
p.setCoords(2609, 3092, 0); 
/*
						if(!p.leveledUp[20]){
							p.skillMenu = 12;
							p.frames.setConfig(p, 965, 12);
						} else {
							lvlup = true;
							p.frames.setConfig(p, 1230, 100);
						}
*/
				        break;
				    case 132: //Construction
p.setCoords(2544, 3095, 0); 
/*
						if(!p.leveledUp[21]){
							p.skillMenu = 22;
							p.frames.setConfig(p, 965, 22);
						} else {
							lvlup = true;
							p.frames.setConfig(p, 1230, 698);
						}
*/
				        break;
				    case 133: //Hitpoints
p.setCoords(3237, 9861, 0); 
/*
						if(!p.leveledUp[3]){
							p.skillMenu = 6;
							p.frames.setConfig(p, 965, 6);
						} else {
							lvlup = true;
							p.frames.setConfig(p, 1230, 50);
						}
*/
				        break;
				    case 134: //Agility
p.setCoords(2552, 3556, 0); 
/*
						if(!p.leveledUp[16]){
							p.skillMenu = 8;
							p.frames.setConfig(p, 965, 8);
						} else {
							lvlup = true;
							p.frames.setConfig(p, 1230, 65);
						}
*/
				        break;
				    case 135: //Herblore
p.setCoords(2924, 3483, 0); 
/*
						if(!p.leveledUp[15]){
							p.skillMenu = 9;
							p.frames.setConfig(p, 965, 9);
						} else {
							lvlup = true;
							p.frames.setConfig(p, 1230, 75);
						}
*/
				        break;
				    case 136: //Thieving
p.setCoords(2663, 3307, 0); 
/*
						if(!p.leveledUp[17]){
							p.skillMenu = 10;
							p.frames.setConfig(p, 965, 10);
						} else {
							lvlup = true;
							p.frames.setConfig(p, 1230, 80);
						}
*/
				        break;
				    case 137: //Crafting
p.setCoords(2933, 3285, 0); 
/*
						if(!p.leveledUp[12]){
							p.skillMenu = 11;
							p.frames.setConfig(p, 965, 11);
						} else {
							lvlup = true;
							p.frames.setConfig(p, 1230, 90);
						}
*/
				        break;
				    case 138: //Fletching
p.setCoords(2822, 3440, 0); 
/*
						if(!p.leveledUp[9]){
							p.skillMenu = 19;
							p.frames.setConfig(p, 965, 19);
						} else {
							lvlup = true;
							p.frames.setConfig(p, 1230, 665);
						}
*/
				        break;
				    case 139: //Slayer
p.setCoords(3412, 3550, 2); 
/*
						if(!p.leveledUp[18]){
							p.skillMenu = 20;
							p.frames.setConfig(p, 965, 20);
						} else {
							lvlup = true;
							p.frames.setConfig(p, 1230, 673);
						}
*/
				        break;
				    case 140: //Hunter
p.setCoords(2199, 3224, 0); 
/*
						if(!p.leveledUp[22]){
							p.skillMenu = 23;
							p.frames.setConfig(p, 965, 23);
						} else {
							lvlup = true;
							p.frames.setConfig(p, 1230, 689);
						}
*/
				        break;
				    case 141: //Mining
p.setCoords(2941, 3281, 0); 
/*
						if(!p.leveledUp[14]){
							p.skillMenu = 13;
							p.frames.setConfig(p, 965, 13);
						} else {
							lvlup = true;
							p.frames.setConfig(p, 1230, 110);
						}
*/
				        break;
				    case 142: //Smithing
p.setCoords(3000, 3144, 0); 
/*
						if(!p.leveledUp[13]){
							p.skillMenu = 14;
							p.frames.setConfig(p, 965, 14);
						} else {
							lvlup = true;
							p.frames.setConfig(p, 1230, 115);
						}
*/
				        break;
				    case 143: //Fishing
p.setCoords(2507, 3519, 0); 
/*
						if(!p.leveledUp[10]){
							p.skillMenu = 15;
							p.frames.setConfig(p, 965, 15);
						} else {
							lvlup = true;
							p.frames.setConfig(p, 1230, 120);
						}
*/
				        break;
				    case 144: //Cooking
p.setCoords(2813, 3436, 0); 
/*
						if(!p.leveledUp[7]){
							p.skillMenu = 16;
							p.frames.setConfig(p, 965, 16);
						} else {
							lvlup = true;
							p.frames.setConfig(p, 1230, 641);
						}
*/
				        break;
				    case 145: //Firemaking
p.setCoords(2702, 3424, 0); 
/*
						if(!p.leveledUp[11]){
							p.skillMenu = 17;
							p.frames.setConfig(p, 965, 17);
						} else {
							lvlup = true;
							p.frames.setConfig(p, 1230, 649);
						}
*/
				        break;
				    case 146: //Woodcutting
p.setCoords(3228, 3245, 0); 
/*
						if(!p.leveledUp[8]){
							p.skillMenu = 18;
							p.frames.setConfig(p, 965, 18);
						} else {
							lvlup = true;
							p.frames.setConfig(p, 1230, 660);
						}
*/
				        break;
				    case 147: //Farming
p.setCoords(2812, 3464, 0); 
/*
						if(!p.leveledUp[19]){
							p.skillMenu = 21;
							p.frames.setConfig(p, 965, 21);
						} else {
							lvlup = true;
							p.frames.setConfig(p, 1230, 681);
						}
*/
				        break;
				    case 148: //Summoning
p.setCoords(2924, 3444, 0); 

						/*if(!p.leveledUp[23]){
							p.skillMenu = 24;
							p.frames.setConfig(p, 965, 24);
						} else {
							lvlup = true;
							p.frames.setConfig(p, 1230, 705);
						}
p.frames.showInterface(p, 499);*/
				        break;
				}}
				if(!lvlup){
					//p.frames.showInterface(p, 499);
				} else {
					//p.frames.showInterface(p, 741);
				}
				lvlup = false;
				for(int i = 0; i < 24; i++)
					p.leveledUp[i] = false;
				break;
				
			case 499: // Skill Information.
				switch(buttonId) {
					case 10:
		                p.frames.setConfig(p, 965, p.skillMenu);
						break;
		            case 11:
		                p.frames.setConfig(p, 965, 1024 + p.skillMenu);
			            break;
		            case 12:
		                p.frames.setConfig(p, 965, 2048 + p.skillMenu);
						break;
		            case 13:
		                p.frames.setConfig(p, 965, 3072 + p.skillMenu);
						break;
		            case 14:
		                p.frames.setConfig(p, 965, 4096 + p.skillMenu);
						break;
		            case 15:
		                p.frames.setConfig(p, 965, 5120 + p.skillMenu);
						break;
		            case 16:
		                p.frames.setConfig(p, 965, 6144 + p.skillMenu);
						break;
		            case 17:
		                p.frames.setConfig(p, 965, 7168 + p.skillMenu);
						break;
		            case 18:
		                p.frames.setConfig(p, 965, 8192 + p.skillMenu);
						break;
		            case 19:
		                p.frames.setConfig(p, 965, 9216 + p.skillMenu);
						break;
		            case 20:
		                p.frames.setConfig(p, 965, 10240 + p.skillMenu);
						break;
		            case 21:
		                p.frames.setConfig(p, 965, 11264 + p.skillMenu);
						break;
		            case 22:
		                p.frames.setConfig(p, 965, 12288 + p.skillMenu);
						break;
		            case 23:
		                p.frames.setConfig(p, 965, 13312 + p.skillMenu);
						break;
					default:
			            break;
				}
				break;


case 663:
NPC np = Engine.npcs[p.FamiliarID];
switch(buttonId)
{
case 23://Dismiss
if(np != null)
{
p.FamiliarType = 0;
np.isDead = true;
p.FamiliarID = 0;
p.frames.setTab(p, 80, 18);
}
break;

case 21://call
if(np != null)
{
np.absX = p.absX;
np.absY = p.absY+1;
np.heightLevel = p.heightLevel;
p.requestGFX(1315, 0);
}
break;
}

break;
				case 192:
            m.modernMagicAB(p, buttonId);
            break;
case 193:        
            m.ancientMagicAB(p, buttonId);
            break;
        case 387:

            /*
             * Equipment tab.
             */
            if (buttonId == 55) {
                p.frames.showInterface(p, 667);
                p.frames.setInventory(p, 670);
                p.frames.setItems(p, -1, 64209, 93, p.items, p.itemsN);
                p.frames.setItems(p, -1, 64208, 94, p.equipment, p.equipmentN);
                p.setEquipmentBonus();
            }
            break;
			
			case 154:
            Magic.MagicOnItemHandle(p, packetId, packetSize);
            break;
case 70:
            Magic.magicAop(p, packetId, packetSize);
            break;



        case 771:
	    /*
	     * Character Design Screen
	     */
		p.design(p, buttonId);
	break;

case 13:
	if (buttonId == 1) {
	    if (p.pinNumOne == 1) {
		p.frames.showInterface(p, 13);
		p.frames.sendMessage(p, "You entered your first bank pin number correctly, enter your next one.");
		p.bankpin();
	    } else if (p.pinNumTwo == 1) {
		p.frames.showInterface(p, 13);
		p.frames.sendMessage(p, "You entered your second bank pin number correctly, enter your next one.");
		p.bankpin();
	    } else if (p.pinNumThree == 1) {
		p.frames.showInterface(p, 13);
		p.frames.sendMessage(p, "You entered your third bank pin number correctly, enter your next one.");
		p.bankpin();
	    } else if (p.pinNumFour == 1) {
		p.frames.sendMessage(p, "You entered all bank pins correctly.");
		p.openBank();
		p.alreadyBanked = true;
	    } else {
		p.frames.sendMessage(p, "You entered your pin in wrong.");
	    }
	}
	if (buttonId == 2) {
	    if (p.pinNumOne == 2) {
		p.frames.showInterface(p, 13);
		p.frames.sendMessage(p, "You entered your first bank pin number correctly, enter your next one.");
		p.bankpin();
	    } else if (p.pinNumTwo == 2) {
		p.frames.showInterface(p, 13);
		p.frames.sendMessage(p, "You entered your second bank pin number correctly, enter your next one.");
		p.bankpin();
	    } else if (p.pinNumThree == 2) {
		p.frames.showInterface(p, 13);
		p.frames.sendMessage(p, "You entered your third bank pin number correctly, enter your next one.");
		p.bankpin();
	    } else if (p.pinNumFour == 2) {
		p.frames.sendMessage(p, "You entered all bank pins correctly.");
		p.openBank();
		p.alreadyBanked = true;
	    } else {
		p.frames.sendMessage(p, "You entered your pin in wrong.");
	    }
	}
	if (buttonId == 3) {
	    if (p.pinNumOne == 3) {
		p.frames.showInterface(p, 13);
		p.frames.sendMessage(p, "You entered your first bank pin number correctly, enter your next one.");
		p.bankpin();
	    } else if (p.pinNumTwo == 3) {
		p.frames.showInterface(p, 13);
		p.frames.sendMessage(p, "You entered your second bank pin number correctly, enter your next one.");
		p.bankpin();
	    } else if (p.pinNumThree == 3) {
		p.frames.showInterface(p, 13);
		p.frames.sendMessage(p, "You entered your third bank pin number correctly, enter your next one.");
		p.bankpin();
	    } else if (p.pinNumFour == 3) {
		p.frames.sendMessage(p, "You entered all bank pins correctly.");
		p.openBank();
		p.alreadyBanked = true;
	    } else {
		p.frames.sendMessage(p, "You entered your pin in wrong.");
	    }
	}
	if (buttonId == 4) {
	    if (p.pinNumOne == 4) {
		p.frames.showInterface(p, 13);
		p.frames.sendMessage(p, "You entered your first bank pin number correctly, enter your next one.");
		p.bankpin();
	    } else if (p.pinNumTwo == 4) {
		p.frames.showInterface(p, 13);
		p.frames.sendMessage(p, "You entered your second bank pin number correctly, enter your next one.");
		p.bankpin();
	    } else if (p.pinNumThree == 4) {
		p.frames.showInterface(p, 13);
		p.frames.sendMessage(p, "You entered your third bank pin number correctly, enter your next one.");
		p.bankpin();
	    } else if (p.pinNumFour == 4) {
		p.frames.sendMessage(p, "You entered all bank pins correctly.");
		p.openBank();
		p.alreadyBanked = true;
	    } else {
		p.frames.sendMessage(p, "You entered your pin in wrong.");
	    }
	}
	if (buttonId == 5) {
	    if (p.pinNumOne == 5) {
		p.frames.showInterface(p, 13);
		p.frames.sendMessage(p, "You entered your first bank pin number correctly, enter your next one.");
		p.bankpin();
	    } else if (p.pinNumTwo == 5) {
		p.frames.showInterface(p, 13);
		p.frames.sendMessage(p, "You entered your second bank pin number correctly, enter your next one.");
		p.bankpin();
	    } else if (p.pinNumThree == 5) {
		p.frames.showInterface(p, 13);
		p.frames.sendMessage(p, "You entered your third bank pin number correctly, enter your next one.");
		p.bankpin();
	    } else if (p.pinNumFour == 5) {
		p.frames.sendMessage(p, "You entered all bank pins correctly.");
		p.openBank();
		p.alreadyBanked = true;
	    } else {
		p.frames.sendMessage(p, "You entered your pin in wrong.");
	    }
	}
	if (buttonId == 6) {
	    if (p.pinNumOne == 6) {
		p.frames.showInterface(p, 13);
		p.frames.sendMessage(p, "You entered your first bank pin number correctly, enter your next one.");
		p.bankpin();
	    } else if (p.pinNumTwo == 6) {
		p.frames.showInterface(p, 13);
		p.frames.sendMessage(p, "You entered your second bank pin number correctly, enter your next one.");
		p.bankpin();
	    } else if (p.pinNumThree == 6) {
		p.frames.showInterface(p, 13);
		p.frames.sendMessage(p, "You entered your third bank pin number correctly, enter your next one.");
		p.bankpin();
	    } else if (p.pinNumFour == 6) {
		p.frames.sendMessage(p, "You entered all bank pins correctly.");
		p.openBank();
		p.alreadyBanked = true;
	    } else {
		p.frames.sendMessage(p, "You entered your pin in wrong.");
	    }
	}
	if (buttonId == 7) {
	    if (p.pinNumOne == 7) {
		p.frames.showInterface(p, 13);
		p.frames.sendMessage(p, "You entered your first bank pin number correctly, enter your next one.");
		p.bankpin();
	    } else if (p.pinNumTwo == 7) {
		p.frames.showInterface(p, 13);
		p.frames.sendMessage(p, "You entered your second bank pin number correctly, enter your next one.");
		p.bankpin();
	    } else if (p.pinNumThree == 7) {
		p.frames.showInterface(p, 13);
		p.frames.sendMessage(p, "You entered your third bank pin number correctly, enter your next one.");
		p.bankpin();
	    } else if (p.pinNumFour == 7) {
		p.frames.sendMessage(p, "You entered all bank pins correctly.");
		p.openBank();
		p.alreadyBanked = true;
	    } else {
		p.frames.sendMessage(p, "You entered your pin in wrong.");
	    }
	}
	if (buttonId == 8) {
	    if (p.pinNumOne == 8) {
		p.frames.showInterface(p, 13);
		p.frames.sendMessage(p, "You entered your first bank pin number correctly, enter your next one.");
		p.bankpin();
	    } else if (p.pinNumTwo == 8) {
		p.frames.showInterface(p, 13);
		p.frames.sendMessage(p, "You entered your second bank pin number correctly, enter your next one.");
		p.bankpin();
	    } else if (p.pinNumThree == 8) {
		p.frames.showInterface(p, 13);
		p.frames.sendMessage(p, "You entered your third bank pin number correctly, enter your next one.");
		p.bankpin();
	    } else if (p.pinNumFour == 8) {
		p.frames.sendMessage(p, "You entered all bank pins correctly.");
		p.openBank();
		p.alreadyBanked = true;
	    } else {
		p.frames.sendMessage(p, "You entered your pin in wrong.");
	    }
	}
	if (buttonId == 9) {
	    if (p.pinNumOne == 9) {
		p.frames.showInterface(p, 13);
		p.frames.sendMessage(p, "You entered your first bank pin number correctly, enter your next one.");
		p.bankpin();
	    } else if (p.pinNumTwo == 9) {
		p.frames.showInterface(p, 13);
		p.frames.sendMessage(p, "You entered your second bank pin number correctly, enter your next one.");
		p.bankpin();
	    } else if (p.pinNumThree == 9) {
		p.frames.showInterface(p, 13);
		p.frames.sendMessage(p, "You entered your third bank pin number correctly, enter your next one.");
		p.bankpin();
	    } else if (p.pinNumFour == 9) {
		p.frames.sendMessage(p, "You entered all bank pins correctly.");
		p.openBank();
		p.alreadyBanked = true;
	    } else {
		p.frames.sendMessage(p, "You entered your pin in wrong.");
	    }
	}
	if (buttonId == 10) {
	    if (p.pinNumOne == 0) {
		p.frames.showInterface(p, 13);
		p.frames.sendMessage(p, "You entered your first bank pin number correctly, enter your next one.");
		p.bankpin();
	    } else if (p.pinNumTwo == 0) {
		p.frames.showInterface(p, 13);
		p.frames.sendMessage(p, "You entered your second bank pin number correctly, enter your next one.");
		p.bankpin();
	    } else if (p.pinNumThree == 0) {
		p.frames.showInterface(p, 13);
		p.frames.sendMessage(p, "You entered your third bank pin number correctly, enter your next one.");
		p.bankpin();
	    } else if (p.pinNumFour == 0) {
		p.frames.sendMessage(p, "You entered all bank pins correctly.");
		p.openBank();
		p.alreadyBanked = true;
	    } else {
		p.frames.sendMessage(p, "You entered your pin in wrong.");
	    }
	}
break;

case 430:
if(buttonId == 14) {
if(p.skillLvl[6] >= 94) {
 if (Engine.playerItems.invItemCount(p, 557) > 10 && Engine.playerItems.invItemCount(p, 560) > 2 && Engine.playerItems.invItemCount(p, 9075) > 4) {
if(!p.vengOn) {
if(System.currentTimeMillis() - p.lastVeng >= 30) {
p.requestAnim(4410, 0);
p.requestGFX(726, 0);
p.vengOn = true;
p.lastVeng = System.currentTimeMillis();
Engine.playerItems.deleteItem(p, 557, Engine.playerItems.getItemSlot(p, 557), 10);
Engine.playerItems.deleteItem(p, 560, Engine.playerItems.getItemSlot(p, 560), 2);
Engine.playerItems.deleteItem(p, 9075, Engine.playerItems.getItemSlot(p, 9075), 4);
}
else {
p.frames.sendMessage(p, "You can only cast vengeance spells every 30 seconds.");
}
}
else {
p.frames.sendMessage(p, "You already have vengeance casted.");
}
}
else {
p.frames.sendMessage(p, "You don't have enough runes to cast this spell.");
}
}
else {
p.frames.sendMessage(p, "You need a magic level of 94 to cast this spell.");
}
}
break;
case 398:

switch(buttonId)
{
case 1:
if(p.absX >= 3093 && p.absY >= 3920 && p.absX <= 3120 && p.absY <= 3950 && p.OwnHouse == true)
{
p.KickPlayers = false;
p.BuildingMode = false;
p.frames.sendMessage(p, "You leave building mode.");
}
else
{
p.frames.sendMessage(p, "You need to be in your house to do this.");
}
break;
case 14:
if(p.absX >= 3093 && p.absY >= 3920 && p.absX <= 3120 && p.absY <= 3950 && p.OwnHouse == true)
{
p.KickPlayers = true;
p.BuildingMode = true;
p.frames.sendMessage(p, "You are now in building mode.");
p.frames.sendMessage(p, "Start with ::newroom (0 1 2 3 or 4). or ::deleteroom (0 1 2 3 or 4)");
p.frames.sendMessage(p, "Room buildable: Parlour, Garden, Kitchen, Bedroom, Chapel, Throne Room.");
}
else
{
p.frames.sendMessage(p, "You need to be in your house to do this.");
}
break;
case 15:
if(p.absX >= 3093 && p.absY >= 3920 && p.absX <= 3120 && p.absY <= 3950 && p.OwnHouse == true)
{
p.KickPlayers = true;
p.frames.sendMessage(p, "You expel your guests.");
}
else
{
p.frames.sendMessage(p, "You need to be in your house to do this.");
}
break;
case 13:
p.KickPlayers = false;
p.BuildingMode = false;
p.frames.sendMessage(p, "You leave the house");
p.setCoords(2544, 3096, 0);
break;
}
break;

        case 750:

        /*
         * Running button next to minimap.
         */


        case 261:

if (buttonId == 3) {
        p.splitChat = !p.splitChat;
        p.frames.setConfig(p, 287, p.splitChat ? 1 : 0);
    if(p.splitChat) {
        p.stream.createFrameVarSizeWord(152);
        p.stream.writeString("s");
        p.stream.writeDWord(83);
        p.stream.endFrameVarSize();
    }
}


            /*
             * Settings tab.
             */
            if (buttonId == 1) {
                if (!p.isRunning) {
                    p.isRunning = true;
                    p.frames.setConfig(p, 173, 1);
                } else {
                    p.isRunning = false;
                    p.frames.setConfig(p, 173, 0);
                }
            } else if (buttonId == 14) {
                p.frames.showInterface(p, 742);
            } else if (buttonId == 6) {
if(p.absX >= 3093 && p.absY >= 3920 && p.absX <= 3120 && p.absY <= 3950 && p.OwnHouse == true)
{
                p.frames.setTab(p, 84, 398); 
}
else
{
p.frames.sendMessage(p, "You need to be in your house to do this.");
}
            } else if (buttonId == 16) {
                p.frames.showInterface(p, 743);
            }
            break;

case 335:
case 334:
case 336:
                p.pTrade.buttons.handleButton(interfaceId, packetId, buttonId, buttonId2);
                break;

        case 271:

            /*
             * Prayer tab.
             */
            Prayer pr = new Prayer();

            pr.Prayer(p, buttonId);
            break;



        case 464:

            /*
             * Emote tab.
             */
            if (buttonId == 2) { // Yes
                p.requestAnim(855, 0);
            } else if (buttonId == 3) { // No
                p.requestAnim(856, 0);
            } else if (buttonId == 4) { // Bow
                p.requestAnim(858, 0);
            } else if (buttonId == 5) { // Angry
                p.requestAnim(859, 0);
            } else if (buttonId == 6) { // Think
                p.requestAnim(857, 0);
            } else if (buttonId == 7) { // Wave
                p.requestAnim(863, 0);
            } else if (buttonId == 8) { // Shrug
                p.requestAnim(2113, 0);
            } else if (buttonId == 9) { // Cheer
                p.requestAnim(862, 0);
            } else if (buttonId == 10) { // Beckon
                p.requestAnim(864, 0);
            } else if (buttonId == 11) { // Laugh
                p.requestAnim(861, 0);
            } else if (buttonId == 12) { // Joy jump
                p.requestAnim(2109, 0);
            } else if (buttonId == 13) { // Yawn
                p.requestAnim(2111, 0);
            } else if (buttonId == 14) { // Dance
                p.requestAnim(866, 0);
            } else if (buttonId == 15) { // Jig
                p.requestAnim(2106, 0);
            } else if (buttonId == 16) { // Spin
                p.requestAnim(2107, 0);
            } else if (buttonId == 17) { // Headbang
                p.requestAnim(2108, 0);
            } else if (buttonId == 18) { // Cry
                p.requestAnim(860, 0);
            } else if (buttonId == 19) { // Blow kiss
                p.requestGFX(574, 0);
                p.requestAnim(0x558, 0);
            } else if (buttonId == 20) { // Panic
                p.requestAnim(2105, 0);
            } else if (buttonId == 21) { // Raspberry
                p.requestAnim(2110, 0);
            } else if (buttonId == 22) { // Clap
                p.requestAnim(865, 0);
            } else if (buttonId == 23) { // Salute
                p.requestAnim(2112, 0);
            } else if (buttonId == 24) { // Goblin bow
                p.requestAnim(0x84F, 0);
            } else if (buttonId == 25) { // Goblin salute
                p.requestAnim(0x850, 0);
            } else if (buttonId == 26) { // Glass box
                p.requestAnim(1131, 0);
            } else if (buttonId == 27) { // Climb rope
                p.requestAnim(1130, 0);
            } else if (buttonId == 28) { // Lean
                p.requestAnim(1129, 0);
            } else if (buttonId == 29) { // Glass wall
                p.requestAnim(1128, 0);
            } else if (buttonId == 30) { // Head slap
                p.requestAnim(4275, 0);
            } else if (buttonId == 31) { // Stomp
                p.requestAnim(1745, 0);
            } else if (buttonId == 32) { // Flap
                p.requestAnim(4280, 0);
            } else if (buttonId == 33) { // Idea
                p.requestAnim(4276, 0);
            } else if (buttonId == 34) { // Zombie walk
                p.requestAnim(3544, 0);
            } else if (buttonId == 35) { // Dombie dance
                p.requestAnim(3543, 0);
            } else if (buttonId == 36) { // Zombie hand grab
                p.requestGFX(1244, 0);
                p.requestAnim(7272, 0);
            } else if (buttonId == 37) { // Scared
                p.requestAnim(2836, 0);
            } else if (buttonId == 38) { // Rabbit hop
                p.requestAnim(6111, 0);
            } else if (buttonId == 39) {// Skillcape emotes
if (buttonId == 39 && p.equipment[1] == 9747) {
p.requestGFX(823,1);
p.requestAnim(4959,1);
}
if (buttonId == 39 && p.equipment[1] == 9748) {
p.requestGFX(823,1);
p.requestAnim(4959,1);
}
if (buttonId == 39 && p.equipment[1] == 9753) { 
p.requestGFX(824,1);
p.requestAnim(4961,1);
}
if (buttonId == 39 && p.equipment[1] == 9754) { 
p.requestGFX(824,1);
p.requestAnim(4961,1);
}
if (buttonId == 39 && p.equipment[1] == 9750) { 
p.requestGFX(828,1);
p.requestAnim(4981,1);
}
if (buttonId == 39 && p.equipment[1] == 9751) { 
p.requestGFX(828,1);
p.requestAnim(4981,1);
}
if (buttonId == 39 && p.equipment[1] == 9768) {
p.requestGFX(833,1);
p.requestAnim(4971,1);
}
if (buttonId == 39 && p.equipment[1] == 9769) {
p.requestGFX(833,1);
p.requestAnim(4971,1);
}
if (buttonId == 39 && p.equipment[1] == 9756) {
p.requestGFX(832,1);
p.requestAnim(4973,1);
}
if (buttonId == 39 && p.equipment[1] == 9757) {
p.requestGFX(832,1);
p.requestAnim(4973,1);
}
if (buttonId == 39 && p.equipment[1] == 9759) {
p.requestGFX(829,1);
p.requestAnim(4979,1);
}
if (buttonId == 39 && p.equipment[1] == 9760) {
p.requestGFX(829,1);
p.requestAnim(4979,1);
}
if (buttonId == 39 && p.equipment[1] == 9762) {
p.requestGFX(813,1);
p.requestAnim(4939,1);
}
if (buttonId == 39 && p.equipment[1] == 9763) {
p.requestGFX(813,1);
p.requestAnim(4939,1);
}
if (buttonId == 39 && p.equipment[1] == 9801) {
p.requestGFX(821,1);
p.requestAnim(4955,1);
}
if (buttonId == 39 && p.equipment[1] == 9802) {
p.requestGFX(821,1);
p.requestAnim(4955,1);
}
if (buttonId == 39 && p.equipment[1] == 9807) {
p.requestGFX(822,1);
p.requestAnim(4957,1);
}
if (buttonId == 39 && p.equipment[1] == 9808) {
p.requestGFX(822,1);
p.requestAnim(4957,1);
}
if (buttonId == 39 && p.equipment[1] == 9783) {
p.requestGFX(812,1);
p.requestAnim(4937,1);
}
if (buttonId == 39 && p.equipment[1] == 9784) {
p.requestGFX(812,1);
p.requestAnim(4937,1);
}
if (buttonId == 39 && p.equipment[1] == 9798) {
p.requestGFX(819,1);
p.requestAnim(4951,1);
}
if (buttonId == 39 && p.equipment[1] == 9799) {
p.requestGFX(819,1);
p.requestAnim(4951,1);
}
if (buttonId == 39 && p.equipment[1] == 9804) {
p.requestGFX(831,1);
p.requestAnim(4975,1);
}
if (buttonId == 39 && p.equipment[1] == 9805) {
p.requestGFX(831,1);
p.requestAnim(4975,1);
}
if (buttonId == 39 && p.equipment[1] == 9780) {
p.requestGFX(818,1);
p.requestAnim(4949,1);
}
if (buttonId == 39 && p.equipment[1] == 9781) {
p.requestGFX(818,1);
p.requestAnim(4949,1);
}
if (buttonId == 39 && p.equipment[1] == 9795) {
p.requestGFX(815,1);
p.requestAnim(4943,1);
}
if (buttonId == 39 && p.equipment[1] == 9796) {
p.requestGFX(815,1);
p.requestAnim(4943,1);
}
if (buttonId == 39 && p.equipment[1] == 9792) {
p.requestGFX(814,1);
p.requestAnim(4941,1);
}
if (buttonId == 39 && p.equipment[1] == 9793) {
p.requestGFX(814,1);
p.requestAnim(4941,1);
}
if (buttonId == 39 && p.equipment[1] == 9774) {
p.requestGFX(835,1);
p.requestAnim(4969,1);
}
if (buttonId == 39 && p.equipment[1] == 9775) {
p.requestGFX(835,1);
p.requestAnim(4969,1);
}
if (buttonId == 39 && p.equipment[1] == 9771) {
p.requestGFX(830,1);
p.requestAnim(4977,1);
}
if (buttonId == 39 && p.equipment[1] == 9772) {
p.requestGFX(830,1);
p.requestAnim(4977,1);
}
if (buttonId == 39 && p.equipment[1] == 9777) {
p.requestGFX(826,1);
p.requestAnim(4965,1);
}
if (buttonId == 39 && p.equipment[1] == 9778) {
p.requestGFX(826,1);
p.requestAnim(4965,1);
}
if (buttonId == 39 && p.equipment[1] == 9786) {
p.requestGFX(1656,1);
p.requestAnim(4967,1);
}
if (buttonId == 39 && p.equipment[1] == 9787) {
p.requestGFX(1656,1);
p.requestAnim(4967,1);
}
if (buttonId == 39 && p.equipment[1] == 9810) {
p.requestGFX(825,1);
p.requestAnim(4963,1);
}
if (buttonId == 39 && p.equipment[1] == 9811) {
p.requestGFX(825,1);
p.requestAnim(4963,1);
}
if (buttonId == 39 && p.equipment[1] == 9765) {
p.requestGFX(817,1);
p.requestAnim(4947,1);
}
if (buttonId == 39 && p.equipment[1] == 9766) {
p.requestGFX(817,1);
p.requestAnim(4947,1);
}
if (buttonId == 39 && p.equipment[1] == 9810) {
p.requestGFX(825,1);
p.requestAnim(4963,1);
}
if (buttonId == 39 && p.equipment[1] == 9811) {
p.requestGFX(825,1);
p.requestAnim(4963,1);
}
if (buttonId == 39 && p.equipment[1] == 9813) {
p.requestGFX(816,1);
p.requestAnim(4945,1);
}
if (buttonId == 39 && p.equipment[1] == 9814) {
p.requestGFX(816,1);
p.requestAnim(4945,1);
}
if (buttonId == 39 && p.equipment[1] == 9789) {
p.requestGFX(820,1);
p.requestAnim(4953,1);
}
if (buttonId == 39 && p.equipment[1] == 9790) {
p.requestGFX(820,1);
p.requestAnim(4953,1);
}
if (buttonId == 39 && p.equipment[1] == 9948) {
p.requestGFX(907,1);
p.requestAnim(5158,1);
}
if (buttonId == 39 && p.equipment[1] == 9949) {
p.requestGFX(907,1);
p.requestAnim(5158,1);
}
if (buttonId == 39 && p.equipment[1] == 12169) {
p.requestGFX(1515,1);
p.requestAnim(8525,1);
}
if (buttonId == 39 && p.equipment[1] == 1007) {
p.requestGFX(547,1);
p.requestAnim(2820,1);
p.npcType = 2862;
p.frames.sendMessage(p, "Do ::regemote to get back to regular emote.");
}
if (buttonId == 39 && p.equipment[1] == 4375) {
p.requestGFX(59,1);
p.requestAnim(2819,1);
p.frames.sendMessage(p, "Do ::regemote to get back to regular emote.");
}
if (buttonId == 39 && p.equipment[1] == 12170) {
p.requestGFX(1515,1);
p.requestAnim(8525,1);
}
if (buttonId == 39 && p.equipment[1] == 10662) {
p.requestGFX(816,1);
p.requestAnim(4945,1);
}
if (buttonId == 39 && p.equipment[1] == -1) {
p.frames.sendMessage(p, "You need to be wearing a skillcape in order to perform this emote.");
            }
            } else if (buttonId == 40) { // Snowman dance
                p.requestAnim(7531, 0);
            } else if (buttonId == 41) { // Air guitar
                p.requestAnim(2414, 0);
                p.requestGFX(1537, 0);
            } else if (buttonId == 42) { // Safety first
                p.requestAnim(8770, 0); 
                p.requestGFX(1553, 0);
            } else if (buttonId == 43) { // Explore
                p.requestAnim(9990, 0); 
                p.requestGFX(1734, 0);
            }
            break;



        case 75: // Dragon baxe special
            if (buttonId == 10 && !p.usingSpecial && p.equipment[3] == 1377
                    && p.specialAmount >= 100) {
                p.specialAmount -= 100;
                p.specialAmountUpdateReq = true;
                p.requestAnim(1056, 0);
                p.requestGFX(246, 0);
                p.skillLvl[2] = ((p.getLevelForXP(3) / 5) + p.skillLvl[2]);
                if (p.skillLvl[2] >= 125) {
                    p.skillLvl[2] = 125;
                }
                p.chatText = "Aarrrgggghhhh!";
                p.chatTextUpdateReq = true;
                p.updateReq = true;
                p.frames.setSkillLvl(p, 2);
            } else if (buttonId == 10 && !p.usingSpecial
                    && p.equipment[3] == 1377 && p.specialAmount <= 99) {
                p.frames.sendMessage(p, "You don't have enough special energy.");
            }
            if (buttonId == 26 && p.autoRetaliate == 0) {
                p.autoRetaliate = 1;
                p.frames.setConfig(p, 172, 1);
            } else if (buttonId == 26 && p.autoRetaliate == 1) {
                p.autoRetaliate = 0;
                p.frames.setConfig(p, 172, 0);
            }
            break;
	  case 77:
            if (buttonId == 11 && !p.usingSpecial) {
                p.usingSpecial = true;
                p.frames.setConfig(p, 301, 1);
            } else if (buttonId == 11 && p.usingSpecial) {
                p.usingSpecial = false;
                p.frames.setConfig(p, 301, 0);
            }
            if (buttonId == 24 && p.autoRetaliate == 0) {
                p.autoRetaliate = 1;
                p.frames.setConfig(p, 172, 1);
            } else if (buttonId == 24 && p.autoRetaliate == 1) {
                p.autoRetaliate = 0;
                p.frames.setConfig(p, 172, 0);
            }
            break;

        case 76:
        case 79:
        case 84: 
        case 85:
        case 91:
        case 92: 
        case 93:
            if (buttonId == 2) {
                p.attackStyle = 0;
            }
            if (buttonId == 3) {
                p.attackStyle = 1;
            }
            if (buttonId == 4) {
                p.attackStyle = 2;
            }
            if (buttonId == 8 && !p.usingSpecial) {
                p.usingSpecial = true;
                p.frames.setConfig(p, 301, 1);
            } else if (buttonId == 8 && p.usingSpecial) {
                p.usingSpecial = false;
                p.frames.setConfig(p, 301, 0);
            }
            if (buttonId == 24 && p.autoRetaliate == 0) {
                p.autoRetaliate = 1;
                p.frames.setConfig(p, 172, 1);
            } else if (buttonId == 24 && p.autoRetaliate == 1) {
                p.autoRetaliate = 0;
                p.frames.setConfig(p, 172, 0);
            }
            break;

        case 78:
        case 81: 
        case 82:
        case 83:
        case 86:
        case 87:
        case 88:  
        case 89:  
            if (buttonId == 2) {
                p.attackStyle = 0;
            }
            if (buttonId == 3) {
                p.attackStyle = 1;
            }
            if (buttonId == 4) {
                p.attackStyle = 2;
            }
            if (buttonId == 5) {
                p.attackStyle = 3;
            }
            if (buttonId == 10 && !p.usingSpecial) {
                p.usingSpecial = true;
                p.frames.setConfig(p, 301, 1);
            } else if (buttonId == 10 && p.usingSpecial) {
                p.usingSpecial = false;
                p.frames.setConfig(p, 301, 0);
            }
            if (buttonId == 26 && p.autoRetaliate == 0) {
                p.autoRetaliate = 1;
                p.frames.setConfig(p, 172, 1);
            } else if (buttonId == 26 && p.autoRetaliate == 1) {
                p.autoRetaliate = 0;
                p.frames.setConfig(p, 172, 0);
            }


        case 90: // mage casting staff
            if (buttonId == 1) {
                p.attackStyle = 0;
            }
            if (buttonId == 2) {
                p.attackStyle = 1;
            }
            if (buttonId == 3) {
                p.attackStyle = 2;
            }
                if (buttonId == 5) {
                    p.frames.setOverlay(p, 319);
                }
            if (buttonId == 9 && p.autoRetaliate == 0) {
                p.autoRetaliate = 1;
                p.frames.setConfig(p, 172, 1);
            } else if (buttonId == 9 && p.autoRetaliate == 1) {
                p.autoRetaliate = 0;
                p.frames.setConfig(p, 172, 0);
            }
            break;

       case 378:

            if (buttonId == 140) {
                p.frames.setWindowPane(p, 548);
            if (p.started == 1) {
       // Place Your Own Custom Starter Message Code For 
       // Players That Have Been On Your Server Before Here!
        } else if (p.started == 0) {
      // Place Your Own Custom Starter Message Code For 
       // Players That Have NOT Been On Your Server Before Here! 
Engine.playerItems.addItem(p, 9003, 1); 
Engine.playerItems.addItem(p, 600, 1);
Engine.playerItems.addItem(p, 995, 5000000);
Engine.playerItems.addItem(p, 6529, 10000);
Engine.playerItems.addItem(p, 386, 1000);
Engine.playerItems.addItem(p, 1050, 1);
Engine.playerItems.addItem(p, 554, 500); 
Engine.playerItems.addItem(p, 555, 500);
Engine.playerItems.addItem(p, 556, 500);
Engine.playerItems.addItem(p, 557, 500);
Engine.playerItems.addItem(p, 563, 500);
Engine.playerItems.addItem(p, 882, 5000);
Engine.playerItems.addItem(p, 853, 1);
Engine.playerItems.addItem(p, 1325, 1);
p.frames.sendMessage(p, "<col=2E8B57>Please type ::home to go to home.");
p.frames.sendMessage(p, "<col=2E8B57>Welcome to the server!");


        p.requestAnim(6297, 0);
        p.requestGFX(1300, 0);
        p.started = 1;
            }
        }
            break;

        case 182:


		if ((p.absY >= 3072) && (p.absY <= 3132) && (p.absX >= 2368) && (p.absX <= 2428)) {
			p.setCoords(2442, 3090, 0);
			}
		if ((p.absY >= 5313) && (p.absY <= 5305) && (p.absX >= 2886) && (p.absX <= 2878)) {
			p.setCoords(3221, 3218, 0);
			}

            /*
             * Logout interface.
             */
if(p.logmessage == false)
{
p.logmessage = true;
for(Player pz : Engine.players) {
p.frames.sendMessage(pz, "<col=fff000><shad=0202>"+Misc.optimizeText(p.username) + " has logged out.");
p.setscores(pz);
}
}

            p.frames.logout(p);
            break;




        case 548:

            

            /*
             * Main interface.
             */
            break;

        case 763:
            /*
             * Inventory interface with banking.
             */
            if (buttonId == 0) {
                if (packetId == 233)		//1
                    Engine.playerBank.bankItem(p, buttonId2, 1);
                else if (packetId == 21)	//5
                    Engine.playerBank.bankItem(p, buttonId2, 5);
                else if (packetId == 169)	//10
                    Engine.playerBank.bankItem(p, buttonId2, 10);
				else if (packetId == 214)	//lastX
					Engine.playerBank.bankItem(p, buttonId2, p.bankX);
                else if (packetId == 232)	//all
                    Engine.playerBank.bankItem(p, buttonId2, Engine.playerItems.invItemCount(p, p.items[buttonId2]));
				else if (packetId == 173)	//X
					p.input.request(3, buttonId2);
				else if (packetId == 90)	//examine
				    p.frames.sendMessage(p, Engine.items.getItemDescription(p.items[buttonId2]));
            }
            break;
        case 762:
            /*
             * Bank interface.
             */
            if (buttonId == 73) {
                if (packetId == 233)	//1
                    Engine.playerBank.bankWithdraw(p, buttonId2, 1);
                else if (packetId == 21)	//5
                    Engine.playerBank.bankWithdraw(p, buttonId2, 5);
                else if (packetId == 169)	//10
                    Engine.playerBank.bankWithdraw(p, buttonId2, 10);
				else if (packetId == 214)	//lastX
					Engine.playerBank.bankWithdraw(p, buttonId2, p.bankX);
				else if (packetId == 173) {	//X
					//p.input.request(2, buttonId2); This is mine, replace with yours
				} else if (packetId == 232)	//all
                    Engine.playerBank.bankWithdraw(p, buttonId2, p.bankItemsN[buttonId2]);
				else if (packetId == 133)	//all but one
					Engine.playerBank.bankWithdraw(p, buttonId2, p.bankItemsN[buttonId2] -1);
				else if (packetId == 90)	//examine
				    p.frames.sendMessage(p, Engine.items.getItemDescription(p.bankItems[buttonId2]));
                break;
            } else if (buttonId == 22) {
				//p.frames.restoreTabs(p); This is mine, close interface button, you might have other methods to show inventory again
			} else if (buttonId == 16) {
				p.withdrawNote = !p.withdrawNote;
			} else if (buttonId == 14) {
				p.insertMode = !p.insertMode;
			} else if (buttonId == 41 || buttonId == 39 || buttonId == 37 || buttonId == 35 || buttonId == 33 || buttonId == 31 || buttonId == 29 || buttonId == 27 || buttonId == 25) { //Tab buttons
				if(packetId == 21) { //Collapse
					Engine.playerBank.collapseTab(p, Engine.playerBank.getArrayIndex(buttonId)); //This method will be added later, dont worry
				} else if(packetId == 233) { //View tab
					p.viewingBankTab = Engine.playerBank.getArrayIndex(buttonId);
				}
			}
            break;
case 659:
if (buttonId == 2) {
               if (packetId == 63)
p.requestAnim(1745, 0);
p.frames.removeShownInterface(p);
p.requestAnim(1745, 0);
p.frames.createGlobalObject(28297, p.heightLevel, p.absX, p.absY, 0, 10);
p.frames.createGlobalObject(28297, p.heightLevel, p.absX - 1, p.absY + 2, 0, 10);
p.frames.createGlobalObject(28297, p.heightLevel, p.absX + 2, p.absY - 1, 0, 10);
p.requestAnim(1745, 0);
Engine.playerItems.addItem(p, 11951, 27);
                p.frames.sendMessage(p, "The snow globe fills your inventory with snow!");
}
break;

        default:
            Misc.println(
                    "[" + p.username + "] Unhandled button: " + interfaceId
                    + ", " + buttonId + ":" + buttonId2);
            break;
        }
    }
}
