

package Bulby.npcs;

import Bulby.util.*;
import Bulby.npcs.update.*;
import Bulby.players.combat.*;
import Bulby.Engine;
import Bulby.io.Frames;
import Bulby.util.Stream;
import java.io.*;
import java.util.*;
import Bulby.util.Misc;
import Bulby.players.Player;

public class NPC {
public Stream update = new Stream(500, 5000);
public int followPlayer = 0;
public int gfxHeight;

 public void appendPlayerFollowing(NPC n)
  {
    for (Player p : Engine.players) {
    if (p == null)
      return;

    int i = p.absX;
    int j = p.absY;
    if ((j < n.absY) && (i == n.absX)) {
      n.moveX = 0;
      n.moveY = Engine.npcMovement.getMove(n.absY, j + 1);
    } else if ((j > n.absY) && (i == n.absX)) {
      n.moveX = 0;
      n.moveY = Engine.npcMovement.getMove(n.absY, j - 1);
    } else if ((i < n.absX) && (j == n.absY)) {
      n.moveX = Engine.npcMovement.getMove(n.absX, i + 1);
      n.moveY = 0;
    } else if ((i > n.absX) && (j == n.absY)) {
      n.moveX = Engine.npcMovement.getMove(n.absX, i - 1);
      n.moveY = 0;
    } else if ((i < absX) && (j < n.absY)) {
      n.moveX = Engine.npcMovement.getMove(n.absX, i + 1);
      n.moveY = Engine.npcMovement.getMove(n.absY, j + 1);
    } else if ((i > n.absX) && (j > n.absY)) {
      n.moveX = Engine.npcMovement.getMove(n.absX, i - 1);
      n.moveY = Engine.npcMovement.getMove(n.absY, j - 1);
    } else if ((i < n.absX) && (j > n.absY)) {
      n.moveX = Engine.npcMovement.getMove(n.absX, i + 1);
      n.moveY = Engine.npcMovement.getMove(n.absY, j - 1);
    } else if ((i > n.absX) && (j < n.absY)) {
      n.moveX = Engine.npcMovement.getMove(n.absX, i - 1);
      n.moveY = Engine.npcMovement.getMove(n.absY, j + 1);
    }
    Engine.npcMovement.getNextNPCMovement(n);
  }
}

private void npcAggression(int j) {
        for (Player p3 : Engine.players) {
            if (p3 != null && !p3.isDead) {
                if (!p3.isDead && !Engine.npcs[j].isDead) {
                    if (Misc.getDistance(Engine.npcs[j].absX, Engine.npcs[j].absY, p3.absX, p3.absY) <= 1) {
                        Engine.npcs[j].attackPlayer = p3.playerId;
                        Engine.npcs[j].attackingPlayer = true;
                        p3.attackNPC = j;
                        p3.attackingNPC = true;
                    } else if (Misc.getDistance(Engine.npcs[j].absX, Engine.npcs[j].absY, p3.absX, p3.absY) >= 5 && Misc.getDistance(Engine.npcs[j].absX, Engine.npcs[j].absY, p3.absX, p3.absY) < 6) {
                        if (j != 2745) {
                    } else if (Misc.getDistance(Engine.npcs[j].absX, Engine.npcs[j].absY, p3.absX, p3.absY) >= 6) {
                        Engine.npcs[j].attackingPlayer = false;
                        break;
                    }
                }
            }
        }
}
}

private void checkNPC() {
    switch (npcType) {
case 6222: 
npcAggression(npcId);
case 6218: 
npcAggression(npcId);
case 6269: 
npcAggression(npcId);
case 6210: 
npcAggression(npcId);
case 6212: 
npcAggression(npcId);
case 5253: 
npcAggression(npcId);
case 6220: 
npcAggression(npcId);
case 6229: 
npcAggression(npcId);
case 6230: 
npcAggression(npcId);
case 6231: 
npcAggression(npcId);
case 6998: 
npcAggression(npcId);
case 3752: 
npcAggression(npcId);
case 3753: 
npcAggression(npcId);
case 3754: 
npcAggression(npcId);
case 3755: 
npcAggression(npcId);
case 3756: 
npcAggression(npcId);
case 3757:
npcAggression(npcId);
case 3758: 
npcAggression(npcId);
case 3759: 
npcAggression(npcId);
case 3760: 
npcAggression(npcId);
case 3761:
npcAggression(npcId);
case 3747:
npcAggression(npcId);
case 3748: 
npcAggression(npcId);
case 3749: 
npcAggression(npcId);
case 3750: 
npcAggression(npcId);
case 3751:  
npcAggression(npcId);
case 3727:
npcAggression(npcId);
case 3728: 
npcAggression(npcId);
case 3729: 
npcAggression(npcId);
case 3730: 
npcAggression(npcId);
case 3731:
npcAggression(npcId);
case 3762:
npcAggression(npcId);
case 7997: 
npcAggression(npcId);
case 3763: 
npcAggression(npcId);
case 3764: 
npcAggression(npcId);
case 3765: 
npcAggression(npcId);
case 3766:
npcAggression(npcId);
case 3767:
npcAggression(npcId);
case 3768: 
npcAggression(npcId);
case 3769: 
npcAggression(npcId);
case 3770: 
npcAggression(npcId);
case 3771:
npcAggression(npcId);
case 3732:
npcAggression(npcId);
case 3733: 
npcAggression(npcId);
case 3734: 
npcAggression(npcId);
case 3735: 
npcAggression(npcId);
case 3736:
npcAggression(npcId);
case 3737:
npcAggression(npcId);
case 3738: 
npcAggression(npcId);
case 3739: 
npcAggression(npcId);
case 3740: 
npcAggression(npcId);
case 3741:  
npcAggression(npcId);
case 3772:
npcAggression(npcId);
case 3773: 
npcAggression(npcId);
case 3774: 
npcAggression(npcId);
case 3775: 
npcAggression(npcId);
case 3776:
npcAggression(npcId);
case 3742:
npcAggression(npcId);
case 3743: 
npcAggression(npcId);
case 3744: 
npcAggression(npcId);
case 3745: 
npcAggression(npcId);
case 3746:
npcAggression(npcId);
case 6999:
npcAggression(npcId);
case 7995:
npcAggression(npcId);
case 5421:
npcAggression(npcId);
case 6729: 
npcAggression(npcId);
case 6625: 
npcAggression(npcId);
case 6691: 
npcAggression(npcId);
case 1153: 
npcAggression(npcId);
case 1154: 
npcAggression(npcId);
case 1156:
npcAggression(npcId);
case 1157: 
npcAggression(npcId);
case 1155: 
npcAggression(npcId);
case 1158: 
npcAggression(npcId);
case 6223: 
npcAggression(npcId);
case 6225: 
npcAggression(npcId);
case 6227: 
npcAggression(npcId);
case 6239: 
npcAggression(npcId);
case 6203: 
npcAggression(npcId);
case 6204: 
npcAggression(npcId);
case 6206: 
npcAggression(npcId);
case 6208: 
npcAggression(npcId);
case 6247: 
npcAggression(npcId);
case 6248: 
npcAggression(npcId);
case 6250: 
npcAggression(npcId);
case 6252: 
npcAggression(npcId);
case 6257: 
npcAggression(npcId);
case 6255: 
npcAggression(npcId);
case 6260: 
npcAggression(npcId);
case 6261: 
npcAggression(npcId);
case 50: 
npcAggression(npcId);
case 6263: 
npcAggression(npcId);
case 6265: 
npcAggression(npcId);
case 115:
npcAggression(npcId);
        case 2745:
            npcAggression(npcId);
        break;
        default:
return;
    }
}

public boolean npccanloot=false;
	
	public void npcDied(Player p, int npcID, int abSX, int abSY) {	
		Random rand = new Random();
		try {
			
	        BufferedReader in = new BufferedReader(new FileReader("./data/npcs/npcdrops.cfg"));
	        String input;
	        int on = 0;
	        String[] splitEQL;
	        String[] splitCOM;
	        String[] splitDSH;
	        String[] splitCLN;
	        String[] splitSCL;
while ((input = in.readLine()) != null) {
splitEQL = null; splitEQL = null; splitDSH = null; splitCLN = null; splitSCL = null;
					if (!input.startsWith("/") && input.contains("=") && input.contains(",") && input.contains("-") && input.contains(":")) {
try {
						splitEQL = input.split("=");
						if (Integer.parseInt(splitEQL[0]) == npcID) {
								splitSCL = splitEQL[1].split(";");
								int Wealth=0;

for (int i = Wealth; i < splitSCL.length; i++) {
										splitCOM = splitSCL[i].split(",");
										splitDSH = splitCOM[1].split("-");
										splitCLN = splitCOM[2].split(":");
int item = Integer.parseInt(splitCOM[0]);
										int min = Integer.parseInt(splitDSH[0]);
										int max = Integer.parseInt(splitDSH[1]);
										int chance = Integer.parseInt(splitCLN[0]);
										int outOf = Integer.parseInt(splitCLN[1]);
										int amount = rand.nextInt((max - min)+1) + min; 
										int ifDrop = rand.nextInt(outOf)+1;
											if (ifDrop <= chance && npccanloot == true) {
												Engine.items.createGroundItem(item, amount, abSX, abSY, heightLevel, p.username);
												npccanloot = false;
											}
}
							}
						} catch (Exception e) {							
							System.out.println("Exception dropping item:\n"+e);
						}
++on;
					}
				}
				in.close();
			} catch (IOException e) {
				System.out.println(e);
			}
	}



    /**
     * The position this NPC is stored in the npc array in the Engine class.
     */
    public int npcId = -1;

    /**
     * The NPC's id, such as 50 for king black dragon.
     */
    public int npcType = 0;

    /**
     * The name of this NPC.
     */
    public String name = "";

    /**
     * If it should hit 0 HP, how long it should take to respawn.
     */
    public int respawnDelay = 60;

    /**
     * Emotes attacking, blocking and death.
     */
public int attackEmote = 0;



    public int defendEmote = 0;
    public int deathEmote = 0;

    /**
     * Delay between attacking.
     */
    public int attackDelay = 5;

    /**
     * Its combat level, used for calculating its accuracy and defence.
     */
    public int combatLevel = 0;

    /**
     * Max hitpoints it can have.
     */
    public int maxHP = 100;

    /**
     * The basic max hit it can have, with an attack method you  can get more specific.
     */
    public int maxHit = Misc.random(3);

    /**
     * Attack type, 0 for melee, 1 for range, 2 for magic.
     */
    public int atkType = 0;

    /**
     * The weakness, same setup as atkType.
     */
    public int weakness = 0;

    /**
     * The current HP this NPC has.
     */
    public int currentHP = 100;

    /**
     * The direction this NPC is moving in.
     */
    public int direction = -1;

    /**
     * The height level its at.
     */
    public int heightLevel = 0;

    /**
     * Request for updating facing.
     */
    public boolean faceToUpdateReq = false;
    public int faceToRequest = -1;

    /**
     * If the NPC is dead or not.
     */
    public boolean isDead = false;

    /**
     * If the death emote has been requested, move on to the next part of the death process.
     */
    public boolean deadEmoteDone = true;

    /**
     * Hide the NPC until it is ready to respawn.
     */
    public boolean hiddenNPC = false;

    /**
     * Absolute positioning.
     */
    public int absX = 0, absY = 0;

    /**
     * If false, the NPC will not respawn if it dies.
     */
    public boolean needsRespawn = false;

    /**
     * If set to true, this NPC will randomly walk around.
     */
    public boolean randomWalk = true;

    /**
     * If an update is needed.
     */
    public boolean updateReq = false;

    /**
     * If the NPC should speak.
     */
    public boolean speakTextUpdateReq = false;
    public String speakText = "";

    /**
     * Hit requests.
     */
    public boolean hit1UpdateReq = false;
    public boolean hit2UpdateReq = false;
    public int hitDiff1 = 0;
    public int posionHit1 = 0;
    public int hitDiff2 = 0;
    public int posionHit2 = 0;

    /**
     * Animation request.
     */
    public boolean animUpdateReq = false;
    public int animRequest = 65535;
    public int animDelay = 0;

    /**
     * Graphic request.
     */
    public boolean gfxUpdateReq = false;
    public int gfxRequest = 65535;
    public int gfxDelay = 0;

    /**
     * Facing request.
     */
    public boolean faceCoordsUpdateReq = false;
    public int faceCoordsX = -1;
    public int faceCoordsY = -1;

    /**
     * The area this NPC can randomly walk around.
     */
    public int moveRangeX1 = 0;
    public int moveRangeY1 = 0;
    public int moveRangeX2 = 0;
    public int moveRangeY2 = 0;

    /**
     * What should be added onto the absolute positioning if this NPC moves.
     */
    public int moveX = 0;
    public int moveY = 0;

    /**
     * The original position the NPC spawned at.
     */
    public int makeX = 0;
    public int makeY = 0;

    /**
     * Delay before the NPC can attack again.
     */
    public int combatDelay = 0;
    public int attackPlayer = 0;
    public boolean attackingPlayer = false;

    /**
     * Gives quick access to the frame class.
     */
    public Frames frames = Engine.frames;


    /**
     * Constructs a new NPC class.
     * @param type The type of NPC.
     * @param index The position the NPC is at.
     */
    public NPC(int type, int index) {
        npcType = type;
        npcId = index;
    }

    /**
     * This method is called every 600 milliseconds.
     */
public void appendPlayerFollowing(Player p, NPC n) {
        	if(p == null) {
            		return;
        	}
        	int pX = p.absX;
        	int pY = p.absY;

requestFaceCoords(pX, pY);

if(n.absX > pX+15 || n.absY > pY+15 || n.absX < pX-15 || n.absY < pY-15 || n.heightLevel < p.heightLevel || n.heightLevel > p.heightLevel)
{
if(p.FamiliarID > 0 || p.FamiliarType > 0)
{
requestGFX(1315, 0);
}
n.absX = pX;
n.absY = pY+1;
heightLevel = p.heightLevel;
}
        	if(pY < n.absY && pX == n.absX) {
            		n.moveX = 0;
            		n.moveY = Engine.npcMovement.getMove(n.absY, pY + 1);
        	}
        	else if(pY > n.absY && pX == n.absX) {
           		n.moveX = 0;
            		n.moveY = Engine.npcMovement.getMove(n.absY, pY - 1);
        	}
        	else if(pX < n.absX && pY == n.absY) {
            		n.moveX = Engine.npcMovement.getMove(n.absX, pX + 1);
            		n.moveY = 0;
        	}
        	else if(pX > n.absX && pY == n.absY) {
            		n.moveX = Engine.npcMovement.getMove(n.absX, pX - 1);
            		n.moveY = 0;
        	}
       		else if(pX < n.absX && pY < n.absY) {
            		n.moveX = Engine.npcMovement.getMove(n.absX, pX + 1);
            		n.moveY = Engine.npcMovement.getMove(n.absY, pY + 1);
        	}
        	else if(pX > n.absX && pY > n.absY) {
            		n.moveX = Engine.npcMovement.getMove(n.absX, pX - 1);
            		n.moveY = Engine.npcMovement.getMove(n.absY, pY - 1);
        	}
        	else if(pX < n.absX && pY > n.absY) {
            		n.moveX = Engine.npcMovement.getMove(n.absX, pX + 1);
            		n.moveY = Engine.npcMovement.getMove(n.absY, pY - 1);
        	}
        	else if(pX > n.absX && pY < n.absY) {
           		n.moveX = Engine.npcMovement.getMove(n.absX, pX - 1);
           		n.moveY = Engine.npcMovement.getMove(n.absY, pY + 1);
        	}
		Engine.npcMovement.getNextNPCMovement(n);
    	}
    public void process() {
checkNPC();
if(followPlayer != 0)
{
Player fp = Engine.players[followPlayer];
if(fp != null)
{
appendPlayerFollowing(fp, this);
}
else
{
isDead = true;
}

}
        if (respawnDelay > 0 && isDead) {
            respawnDelay--;
        }
        if (combatDelay > 0) {
            combatDelay--;
        }
if (npcType == 398) {
	requestText("Welcome to Mezzy-Scape");
requestAnim(-1, 1);
}
if (npcType == 2575) {
	requestText("Welcome to Mezzy-Scape World 2!");
requestAnim(-1, 1);
}
if (npcType == 945) {
	requestText("World 2 Portal infront of me!");
requestAnim(-1, 1);
}
if (npcType == 949) {
	requestText("World 1 Portal infront of me!");
requestAnim(-1, 1);
}
if (npcType == 3784) {
	requestText("Low level pest control portal!");
requestAnim(-1, 1);
}
if (npcType == 3788) {
	requestText("Go Go Go!!!");
requestAnim(-1, 1);
}
if (npcType == 3786) {
	requestText("Buy all your void armor here!!");
requestAnim(-1, 1);
}
if (npcType == 3782) {
	requestText("Your in pest control!! Defend us!");
requestAnim(-1, 1);
}
if (npcType == 3348) {
	requestText("Welcome to Falador Drop Party Room!");
requestAnim(866, 1);
}
if (npcType == 19) {
	requestText("Welcome to Falador Drop Party Room!");
requestAnim(866, 1);
}
if (npcType == 3350) {
	requestText("Welcome to Falador Drop Party Room!");
requestAnim(866, 1);
}
if (npcType == 3349) {
	requestText("Welcome to Falador Drop Party Room!");
requestAnim(866, 1);
}
if (npcType == 1092) {
	requestText("Welcome to Falador Drop Party Room!");
requestAnim(866, 1);
}
        if (attackingPlayer) {
            Engine.npcPlayerCombat.attackPlayer(this);
        }
    }

    /**
     * Request an animation for this NPC.
     * @param animId The amination to perform.
     * @param animD The delay before doing the animation.
     */
    public void requestAnim(int animId, int animD) {
        animRequest = animId;
        animDelay = animD;
        animUpdateReq = true;
        updateReq = true;
    }

    /**
     * Request text for this NPC.
     * @param message The message to make the NPC say.
     */
    public void requestText(String message) {
        speakText = message;
        animUpdateReq = true;
        speakTextUpdateReq = true;
    }

    /**
     * Request an graphic for this NPC.
     * @param gfxId The graphic to perform.
     * @param gfxD The delay or height or the gfx depending on the value.
     */
    public void requestGFX(int gfxId, int gfxD) {
        if (gfxD >= 100) {
            gfxD += 6553500;
        }
        gfxRequest = gfxId;
        gfxDelay = gfxD;
        gfxUpdateReq = true;
        updateReq = true;
    }

    /**
     * Request this NPC faces two coordinates.
     * @param x The x coordinate to face.
     * @param y The y coordinate to face.
     */
    public void requestFaceCoords(int x, int y) {
        faceCoordsX = 2 * x + 1;
        faceCoordsY = 2 * y + 1;
        faceCoordsUpdateReq = true;
        updateReq = true;
    }

    /**
     * Request this NPC faces another NPC or player.
     * @param faceId The target to face.
     */
    public void requestFaceTo(int faceId) {
        faceToRequest = faceId;
        faceToUpdateReq = true;
        updateReq = true;
    }

    /**
     * Add damage to this NPC.
     * @param damage To amount of damage.
     * @param posion 0 for normal damage, 1 for posion.
     */
    public void appendHit(int damage, int posion) {
        if (damage > currentHP) {
            damage = currentHP;
        }
        currentHP -= damage;
        if (currentHP <= 0) {
            currentHP = 0;
            attackingPlayer = false;
            isDead = true;
        }
        if (!hit1UpdateReq) {
            hitDiff1 = damage;
            posionHit1 = posion;
            hit1UpdateReq = true;
        } else {
            hitDiff2 = damage;
            posionHit2 = posion;
            hit2UpdateReq = true;
        }
        updateReq = true;
    }
}