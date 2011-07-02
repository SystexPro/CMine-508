
package Bulby.io.packets;


import Bulby.Engine;
import Bulby.players.Player;
import Bulby.util.Misc;
import Bulby.Server;


public class MagicOnPlayer implements Packet {

    /**
     * Handles magic on players.
     * @param p The Player which the frame should be handled for.
     * @param packetId The packet id this belongs to.
     * @param packetSize The amount of bytes being recieved for this packet.
     */
    public void handlePacket(Player p, int packetId, int packetSize) {
     
        p.attackPlayer = p.stream.readSignedWordA();
        int playerId = p.stream.readSignedWordBigEndian();
        int interfaceId = p.stream.readUnsignedWord();

        p.clickId = p.stream.readUnsignedWord();
        Player p2 = Server.engine.players[playerId];

if(p.AtDuel() && p.DuelPartner != p2.playerId)
{
p.frames.sendMessage(p,"This is not your opponent");
}

else if(p.DuelCan == false && p.AtDuel() == true)
{
p.frames.sendMessage(p,"You cannot fight just yet.");
}

else if(p.AtClanField() && p2.clanchat == p.clanchat)
{
p.frames.sendMessage(p,"This is your team mate.");
}
else if(p.AtClanField() && p.ClanTimer > 0)
{
p.frames.sendMessage(p,"The game has not begun yet.");
}
else if(p.AtJail() || p.AtClanLobby())
{
p.frames.sendMessage(p,"You cannot attack some one here.");
}
else
{

        switch (interfaceId) {

case 3:
   if(p.magicDelay > 0) {
        p.stopMovement(p);
        return;
     }
     if (p.skillLvl[6] < 94) //ice barrage Created by Antimated from Rune-Server.org
     {
         p.stopMovement(p);
  p.frames.sendMessage(p,"You need a magic level of 94 to cast this spell.");
  return;
     }
     if (Engine.playerItems.invItemCount(p, 560) < 3
         || Engine.playerItems.invItemCount(p, 555) < 5
         || Engine.playerItems.invItemCount(p, 565) < 1) 
     {
         p.stopMovement(p);
         p.frames.sendMessage(p,
"You don't have enough runes to cast this spell.");
  return;
     }
             p.stopMovement(p);
      p.requestFaceTo(p2.playerId + 32768);
             p.magicDelay = 7;
             p.requestAnim(1979, 0);
             p.requestGFX(368, 0);
      p.combatDelay = p.attackDelay;
             Engine.playerItems.deleteItem(p, 560,
             Engine.playerItems.getItemSlot(p, 560), 4);
             Engine.playerItems.deleteItem(p, 555,
             Engine.playerItems.getItemSlot(p, 555), 6);
             Engine.playerItems.deleteItem(p, 556,
             Engine.playerItems.getItemSlot(p, 556), 2);
     for (Player AoEvictim : Engine.players) 
  {
  if (AoEvictim == null || (Misc.getDistance(AoEvictim.absX, AoEvictim.absY, p2.absX, p2.absY) > 1) 
  || AoEvictim == p) 
  {
   continue;
  }
  if (AoEvictim == null || AoEvictim.isDead) {
   return;
  }
                AoEvictim.projectileTimer = 4;
                AoEvictim.requestGFX(369, 90); 
  AoEvictim.mageDamage = Misc.random(30);
  AoEvictim.frames.sendMessage(AoEvictim, "You have been frozen!");
  p.frames.sendMessage(p, "You freeze the enemy!");
  AoEvictim.freezeDelay = 20;
     }
  break;

        case 430:
            if (p.magicDelay == 0) {
                if (p.clickId == 19 && p.skillLvl[6] >= 93) {
                    if (Engine.playerItems.invItemCount(p, 9075) > 3
                            && Engine.playerItems.invItemCount(p, 560) > 2
                            && Engine.playerItems.invItemCount(p, 557) > 10) {
		    if(!p2.vengOn) {
                        p.stopMovement(p);
                        p.magicDelay = 7;
                        p.requestAnim(4411, 0);
                        p2.requestGFX(725, 0);
			p2.vengOn = true;
                        Engine.playerItems.deleteItem(p, 9075,
                                Engine.playerItems.getItemSlot(p, 9075), 3);
                        Engine.playerItems.deleteItem(p, 560,
                                Engine.playerItems.getItemSlot(p, 560), 2);
                        Engine.playerItems.deleteItem(p, 557,
                                Engine.playerItems.getItemSlot(p, 557), 10);
		    } else {
			p.frames.sendMessage(p, 
				"That person already has vengeance casted.");
			}
                    } else {
                        p.frames.sendMessage(p,
                                "You don't have enough runes to cast this spell.");
                    }
                } else {
                    p.frames.sendMessage(p,
                            "You need a magic level of 93 to cast this spell.");
                }
            } else {
                p.stopMovement(p);
            }
            break;


        case 193:

        if (p.magicDelay == 0) {

                if (p.clickId == 3 || p.skillLvl[6] >= 94) {
                    if (Engine.playerItems.invItemCount(p, 560) > 3
                            && Engine.playerItems.invItemCount(p, 555) > 5
                            && Engine.playerItems.invItemCount(p, 565) > 1) {
                        p.requestFaceTo(p2.playerId + 32768);
                        p.stopMovement(p);
                        p.magicDelay = 5;
                        p.requestAnim(1979, 0);
                        p.frames.sendMessage(p, "You cast ice barrage on this failure");
                        p2.requestGFX(369, 0);
                        p2.appendHit(Misc.random(30), 0);
                        p2.requestFaceTo(p.playerId + 32768);
                        p2.freezeDelay = 10;
                        p2.frames.sendMessage(p2, " You are Frozen!!");
                        p.combatDelay += p.attackDelay;
                        Engine.playerItems.deleteItem(p, 560,
                                Engine.playerItems.getItemSlot(p, 560), 4);
                        Engine.playerItems.deleteItem(p, 555,
                                Engine.playerItems.getItemSlot(p, 555), 6);
                        Engine.playerItems.deleteItem(p, 556,
                                Engine.playerItems.getItemSlot(p, 556), 2);
                    } else {
                        p.frames.sendMessage(p,
                                "You don't have enough runes to cast this spell.");
                    }
                } else {
                    p.frames.sendMessage(p,
                            "You need a magic level of 94 to cast this spell.");
                }
            } else {
                p.stopMovement(p);
            }

            break;

default:
            Misc.println(
                    "PlayerID " + playerId + " - InterfaceID " + interfaceId
                    + " - ButtonID " + p.clickId + ".");
            break;

        }
}
    } 
}
