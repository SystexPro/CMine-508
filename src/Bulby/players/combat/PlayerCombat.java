

package Bulby.players.combat;


import Bulby.Engine;
import Bulby.players.Player;
import Bulby.players.items.PlayerWeapon;
import Bulby.players.*;
import Bulby.util.Misc;


public class PlayerCombat {
    int wildLvl(Player p) {
	return (p.absY - 3520)/8+1;
    }
boolean isInWildRange(Player p) {
	Player p2 = Engine.players[p.attackPlayer]; 
	if(p.combatLevel > p2.combatLevel) {
	 if(p.combatLevel - p2.combatLevel <= wildLvl(p2)) {
		return true;
	 }
	} else if(p.combatLevel < p2.combatLevel) {
	   if(p2.combatLevel - p.combatLevel <= wildLvl(p2)) {
		return true;
	   }
	  } else if(p.combatLevel == p2.combatLevel) {
		return true;
                  }
    return false;
    }


    public void attackPlayer(Player p) {

        Player p2 = Engine.players[p.attackPlayer];			
		
        int hitDamage = Misc.random(maxMeleeHit(p));
            if (p2.vengOn) {
                p.appendHit((int) ((hitDamage / 4) * 3), 0);
                p2.chatText = "Taste Vengeance!";
                p.chatTextUpdateReq = true;
                p.updateReq = true;
                p2.vengOn = false;
        	p2.appendHit(hitDamage, 0);
            }
        int hitDamage2 = Misc.random(hitDamage);

        int offsetX = (p.absX - p2.absX) * -1;
        int offsetY = (p.absY - p2.absY) * -1;
int CombatXPRate = 0;	
  


	

        if (p.attackPlayer <= 0 || p.isDead
                || p.attackPlayer >= Engine.players.length
                || Engine.players[p.attackPlayer] == null
                || Engine.players[p.attackPlayer].isDead || p2.disconnected[1]) {
            resetAttack(p);
        }
        if (p.combatDelay > 0) {
            return;
        }
	if (!isInWildRange(p)) {
	   p.frames.sendMessage(p, "You need to move deeper into the wilderness!");
	   resetAttack(p);
	   return;
	}
		
		/*if(p.bountyArea() && p.bountyOpp != p2.playerId){
			p.frames.sendMessage(p,"This is not your opponent");
			resetAttack(p);
			return;


		}*/

if(p.AtDuel() && p.DuelPartner != p2.playerId)
{
p.frames.sendMessage(p,"This is not your opponent");
 resetAttack(p);
return;
}

if(p.AtCastleWars() && p.CWTeam == p2.CWTeam)
{
p.frames.sendMessage(p,"You can't attack your team mate.");
 resetAttack(p);
return;
}

if(p.AtPits() && p.GameStarted == false)
{
p.frames.sendMessage(p,p.PitGame+" till game begins.");
 resetAttack(p);
return;
}

if(p.DuelCan == false && p.AtDuel() == true)
{
p.frames.sendMessage(p,"You cannot fight just yet.");
 resetAttack(p);
return;
}

if(p.AtClanField() && p2.Opposing == p.Opposing)
{
p.frames.sendMessage(p,"This is your team mate.");
 resetAttack(p);
return;
}
if(p.AtClanField() && p.ClanTimer > 0)
{
p.frames.sendMessage(p,"The game has not begun yet.");
 resetAttack(p);
return;
}
if(p.AtJail() || p.AtClanLobby())
{
p.frames.sendMessage(p,"You cannot attack some one here.");
 resetAttack(p);
return;
}

		if (!isInWildRange(p) && p.AtDuel() == false && p.AtClanField() == false && p.AtCastleWars() == false) {
	   //p.frames.sendMessage(p, "You need to move deeper into the wilderness!");
	   resetAttack(p);
	   return;
	}
        if (p.canAttackPlayer(p)) {
p.followPlayer = p2.playerId;
p.followingPlayer = true;

            if (Misc.getDistance(p2.absX, p2.absY, p.absX, p.absY) >= 1
                    && UsingABow(p.equipment[3])) {
                p.teleportToX = p.absX;
                p.teleportToY = p.absY;
                if (p.equipment[3] == 4214) {
                    p.requestAnim(p.attackEmote, 0);
                    p.requestGFX(250, 100);
                    p.combatDelay = p.attackDelay;
                    p.requestGFX(250, 100);				     			
                    p.requestFaceTo(p2.playerId + 32768);
                    p.frames.createGlobalProjectile(p.absY, p.absX, offsetY,
                            offsetX, 249, 20, 31, 70, p2.playerId);
                    p2.appendHit(Misc.random(30), 0);
                    p2.requestAnim(424, 0);
                    p2.freezeDelay = 10;
                    p2.requestGFX(8, 100);
                } else if (arrowNot(p.equipment[13])) {
                    if (!p.usingSpecial) {
                        p.requestAnim(p.attackEmote, 0);
                        p.requestGFX(fetchArrowBack(p.equipment[13]), 100); 
                        p.frames.createGlobalProjectile(p.absY, p.absX, offsetY,
                                offsetX, fetchArrowAir(p.equipment[13]), 43, 31,
                                70, p2.playerId); 
                    } else if (p.usingSpecial) {
                        p.usingSpecial = false;
                        p.frames.setConfig(p, 301, 0); 
                        p.requestAnim(p.attackEmote, 0);
                        p.requestGFX(fetchArrowBack(p.equipment[13]), 100); 
                        p.frames.createGlobalProjectile(p.absY, p.absX, offsetY,
                                offsetX, fetchArrowAir(p.equipment[13]), 43, 31,
                                70, p2.playerId); 
                    }			
                    p.combatDelay = p.attackDelay;				
                    p.requestFaceTo(p2.playerId + 32768);
if(p2.prayerIcon == 1) 
{
if(p2.Hitter > 0)
{
p2.Hitter -= 1;
hitDamage = 0;	
}
else
{
p2.Hitter = 2+Misc.random(4);
}
}

                    		if (Defence(p)) {
		p2.appendHit(hitDamage, 0);
		} else {
		p2.appendHit(0, 0);
		}

   
                    p2.requestAnim(424, 0);	
                    if (p2.autoRetaliate == 0) {
                        p2.requestFaceTo(p.playerId + 32768);
                        p2.attackPlayer = p.playerId;
                        p2.attackingPlayer = true;
                    }
                } else {
                    p.frames.sendMessage(p,
                            "You need some arrows to attack a player");
                    resetAttack(p);
                }
            } else if (Misc.getDistance(p2.absX, p2.absY, p.absX, p.absY) <= 1
                    && UsingABow(p.equipment[3]) == false) {
                if (!p.usingSpecial) {
                    p.requestAnim(p.attackEmote, 0);
                } else if (p.usingSpecial) {
                    p.frames.setConfig(p, 301, 0); 
                    if (p.equipment[3] == 11694 && p.specialAmount >= 50) { // Armadyl godsword.
                        hitDamage = Misc.random((int) (maxMeleeHit(p) * 1.25));
                        p.usingSpecial = false;
                        p.specialAmount -= 50;
                        p.requestAnim(7074, 0);
                        p.requestGFX(1222, 0);
                    } else if (p.equipment[3] == 11730 && p.specialAmount >= 100) { // Saradomin Sword
                        p.usingSpecial = false;
                        p.specialAmount -= 100;
                        p.requestAnim(7072, 0);
                        p.requestGFX(1224, 100);
                        p2.requestGFX(1194, 100);
                        p2.appendHit(Misc.random(42), 0);
                        p.usingSpecial = false;
                    } else if (p.equipment[3] == 11730 && p.specialAmount >= 100) { // Saradomin Sword
                        p.usingSpecial = false;
                        p.specialAmount -= 100;
                        p.requestAnim(7072, 0);
                        p.requestGFX(1224, 100);
                        p2.requestGFX(1194, 100);
                        p2.appendHit(Misc.random(42), 0);
                        p.usingSpecial = false;
                } else if (p.equipment[3] == 861 && p.specialAmount == 50) { // Magic Shortbow
                    hitDamage = Misc.random(
                            (int) (maxMeleeHit(p) * 1.1));
                    p.usingSpecial = true;
                    p.specialAmount -= 50;
                    p.requestAnim(426, 0);
                    p.requestGFX(472, 0);
                    } else if (p.equipment[3] == 11696 && p.specialAmount == 100) { // Bandos godsword.
                        hitDamage = Misc.random(
                                (int) (maxMeleeHit(p) * 1.1));
                        p.usingSpecial = false;
                        p.specialAmount -= 100;
                        p.requestAnim(7073, 0);
                        p.requestGFX(1223, 0);
                    } else if (p.equipment[3] == 11698 && p.specialAmount >= 50) { // Saradomin godsword.
                       hitDamage = Misc.random(
                               (int) (maxMeleeHit(p) * 1.1));
                        p.usingSpecial = false;
                        p.specialAmount -= 50;
                        p.requestAnim(7071, 0);
                        p.requestGFX(1220, 0);
                        p.updateHP((hitDamage/2), true);
                        p.updatePRAY((hitDamage/4), true);
                    } else if (p.equipment[3] == 11700 && p.specialAmount >= 75) { // Zamorak godsword.
                        hitDamage = Misc.random(
                                (int) (maxMeleeHit(p) * 1.1));
                        p.usingSpecial = false;
                        p.specialAmount -= 50;
                        p.requestAnim(7070, 0);
                        p.requestGFX(1221, 0);
                    } else if (p.equipment[3] == 4151 && p.specialAmount >= 50) { // Abyssal whip.
                        hitDamage = Misc.random(
                                (int) (maxMeleeHit(p) * 0.9));
                        p.usingSpecial = false;
                        p.specialAmount -= 50;
                        p.requestAnim(1658, 0);
                        p2.requestGFX(341, 100);
                    } else if (p.equipment[3] == 1215 && p.specialAmount >= 25) { // Vesta Longsword.
                        hitDamage = Misc.random(
                                (int) (maxMeleeHit(p) * 0.9));
                        p.usingSpecial = false;
                        p.specialAmount -= 25;
                        p.requestAnim(7181, 0);
                    } else if (p.equipment[3] == 7158 && p.specialAmount >= 50) { // Dragon godsword.
                        hitDamage = Misc.random(
                                (int) (maxMeleeHit(p) * 0.9));
                        p.usingSpecial = false;
                        p.specialAmount -= 50;
                        p.requestAnim(7181, 0);
                        p2.requestGFX(1555, 0);
                    } else if (p.equipment[3] == 1305 && p.specialAmount >= 25) { // Dragon longsword.
                        hitDamage = Misc.random(
                                (int) (maxMeleeHit(p) * 1.0));
                        p.usingSpecial = false;
                        p.specialAmount -= 25;
                        p.requestAnim(1058, 0);
                        p.requestGFX(248, 100);
                        p.requestAnim(1658, 0);
                    } else if (p.equipment[3] == 4587 && p.specialAmount >= 70) { // Dragon scimitar.
                        hitDamage = Misc.random(
                                (int) (maxMeleeHit(p) * 1.0));
                        p.usingSpecial = false;
                        p.specialAmount -= 70;
                        p.requestAnim(2081, 0);
                        p.requestGFX(347, 100);
                    } else if (p.equipment[3] == 1434 && p.specialAmount >= 40) { // Dragon mace.
                        hitDamage = Misc.random(
                                (int) (maxMeleeHit(p) * 1.1));
                        p.usingSpecial = false;
                        p.specialAmount -= 40;
                        p.requestAnim(1060, 0);
                        p.requestGFX(251, 100);
                    } else if (p.equipment[3] == 3204 && p.specialAmount >= 100) { // Dragon halberd.
                        hitDamage2 = Misc.random(
                                (int) (maxMeleeHit(p) * 1.1));
                        p.usingSpecial = false;
                        p.specialAmount -= 100;
                        p.requestAnim(1665, 0);
                        p.requestGFX(282, 100);
                        p2.appendHit(hitDamage2, 0);
                    } else if (p.equipment[3] == 5698 && p.specialAmount >= 25) { // Dragon dagger(s).
                        p.usingSpecial = false;
                        p.specialAmount -= 25;
                        p.requestAnim(1062, 0);
                        p.requestGFX(252, 100);
                        p2.appendHit(Misc.random(42), 0);
                        p.usingSpecial = false;
                        p.frames.sendMessage(p,
                                "You don't have enough special energy.");
                    } else if (p.equipment[3] == 4153 && p.specialAmount >= 25) { // Dragon dagger(s).
                        p.usingSpecial = false;
                        p.specialAmount -= 25;
                        p.requestAnim(1667, 0);
                        p.requestGFX(340, 100);
                        p2.appendHit(Misc.random(42), 0);
                        p.usingSpecial = false;
                        p.frames.sendMessage(p,
                                "You don't have enough special energy.");
                    } else if (p.equipment[3] == 3101 && p.specialAmount >= 50) { // dragon claws
                        hitDamage = Misc.random(
                                (int) (maxMeleeHit(p) * 1.5));
            p.usingSpecial = false;
            p.secHit2 = hitDamage/2;
            p.thirdHit2 = Misc.random((int) (maxMeleeHit(p) * 0.75));
            if (p.thirdHit2 != 0) {
            p.fourHit2 = p.thirdHit2+2;
        }else{
            p.fourHit2 = 9;
        }
            p2.appendHit(p.secHit2, 0);
            p.clawTimer2 = 1;
            p.UseClaws3 = true;
            p.specialAmount -= 50;
            p.requestAnim(2068, 0);
            p.requestGFX(274, 100);
                        p.frames.sendMessage(p,
                                "You don't have enough special energy.");

}
}

                p.combatDelay = p.attackDelay;
                p.requestFaceTo(p2.playerId + 32768);
if(p2.prayerIcon == 0) 
{
if(p2.Hitter > 0)
{
p2.Hitter -= 1;
hitDamage = 0;	
}
else
{
p2.Hitter = 2+Misc.random(4);
}
}

                		if (Defence(p)) {
       if(p2.vengOn) {
		p.appendHit((int)((hitDamage/4)*3), 0);
		p2.chatText = "Taste Vengeance!";
        p2.chatTextUpdateReq = true;
        p.updateReq = true;
		p2.vengOn = false;
		}
        p2.appendHit(hitDamage, 0);
		} else {
		p2.appendHit(0, 0);
		}
				
								 if(p.attackStyle == 0) {
  		p.addSkillXP(4 * hitDamage * CombatXPRate ,0);
      } 
	  if(p.attackStyle == 1) {
   		p.addSkillXP(4 * hitDamage * CombatXPRate ,2);
      } if(p.attackStyle == 2) {
   		p.addSkillXP(4 * hitDamage * CombatXPRate ,1);
      } if(p.attackStyle == 3) {
   		p.addSkillXP((4 * hitDamage * CombatXPRate)/3 ,0);
   		p.addSkillXP((4 * hitDamage * CombatXPRate)/3 ,1);
   		p.addSkillXP((4 * hitDamage * CombatXPRate)/3 ,2);
      }
                p2.requestAnim(1659, 0);
                p.specialAmountUpdateReq = true;
                if (p2.autoRetaliate == 0) {
                    p2.requestFaceTo(p.playerId + 32768);
                    p2.attackPlayer = p.playerId;
                    p2.attackingPlayer = true;
                }
            }
        } else if (!Engine.wildernessArea(p.absX, p.absY)) {
            //p.frames.sendMessage(p, "You are not in the wild.");
            resetAttack(p);
        } else if (!Engine.wildernessArea(p2.absX, p2.absY)) {
            //p.frames.sendMessage(p, "This player is not in the wild.");
            resetAttack(p);
        } else {
            resetAttack(p);
        }
    }

    public static boolean UsingABow(int bow) {
        for (int i = 0; i < Bows.length; i++) {
            if (bow == Bows[i]) {
                return true;
            }
        }
        return false;
    }
    public int BestAttackBonus(Player p)
    {
        if(p.equipmentBonus[0] > p.equipmentBonus[1] && p.equipmentBonus[0] > p.equipmentBonus[2]) {
            return 0;
	}
        if(p.equipmentBonus[1] > p.equipmentBonus[0] && p.equipmentBonus[1] > p.equipmentBonus[2]) {
            return 1;
	}
	if(p.equipmentBonus[2] > p.equipmentBonus[1] ||  p.equipmentBonus[2] > p.equipmentBonus[0]) {
	    return 2;
	}
	return 1;
    }

    public boolean Defence(Player p) {
	int att_def =  BestAttackBonus(p);
	int BestAttack = p.equipmentBonus[BestAttackBonus(p)] + p.skillLvl[0] + Misc.random(25);
	int DefenceBonus = Engine.players[p.attackPlayer].equipmentBonus[att_def+5] + (Engine.players[p.attackPlayer].skillLvl[1]) ;
        if ((Misc.random(BestAttack)) > Misc.random(DefenceBonus)){
   return true;
	}
   return false;
    }
    public static int Bows[] = {
        4212, 4214, 4215, 4216, 4217, 4218, 4219, 4220, 4221, 4222, 4223, 837,
        767, 4734, 9185, 839, 841, 843, 845, 847, 849, 851, 853, 855, 857, 859, 861,
        2883, 4827, 6724
    };
	
    public boolean arrowNot(int id) {
        if (id == 882) {
            return true;
        }
        if (id == 884) {
            return true;
        }
        if (id == 886) {
            return true;
        }
        if (id == 888) {
            return true;
        }
        if (id == 890) {
            return true;
        }
        if (id == 892) {
            return true;
        }	
        return false;
    }

    public int fetchArrowAir(int id) {
        if (id == 882) {
            return 10;
        }
        if (id == 884) {
            return 11;
        }
        if (id == 886) {
            return 12;
        }
        if (id == 888) {
            return 13;
        }
        if (id == 890) {
            return 14;
        }
        if (id == 892) {
            return 15;
        } else {
            return 500;
        }
    }
	
    public int fetchArrowBack(int id) {
        if (id == 882) {
            return 19;
        }
        if (id == 884) {
            return 18;
        }
        if (id == 886) {
            return 20;
        }
        if (id == 888) {
            return 21;
        }
        if (id == 890) {
            return 22;
        }
        if (id == 892) {
            return 24;
        } else {
            return 500;
        }
    }
	
    public int maxMeleeHit(Player p) {
        int a = p.skillLvl[2];
        int b = p.equipmentBonus[10];
        double c = (double) a;
        double d = (double) b;
        double f = 0;
        double h = 0;

        f = (d * 0.00175) + 0.1;
        h = Math.floor(c * f + 2.05);
        return (int) h;
    }

   

    public void resetAttack(Player p) {
        if (p == null) {
            return;
        }
        p.attackingPlayer = false;
        if (p.faceToReq != 65535) {
            p.requestFaceTo(65535);
        }
    }
}
