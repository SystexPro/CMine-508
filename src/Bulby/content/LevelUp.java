package Bulby.content;

import Bulby.players.*;
import Bulby.util.Misc;

public class LevelUp {
	public LevelUp(){
	}
	
	public LevelUp(Player p, int skillID) {
		if(p == null || skillID < 0 || skillID > 23) {
			return;
		}
		p.leveledUpSkill = skillID;
		p.leveledUp[skillID] = true;
		p.requestGFX(199,100);
	//	p.frames.sendMessage(p, "You've just advanced a " + Misc.getSkillName(skillID) + " level! You have reached level " + p.skillLvl[i] + ".");
//		p.frames.setString(p, "Congratulations, you have just advanced a " + Misc.getSkillName(i) + " level!", 740, 0);
		p.frames.setString(p, "You have now reached level " + p.skillLvl[skillID] + "!", 740, 1);
		p.frames.setConfig(p, 1179, Misc.getSkillIcon(skillID));
		p.frames.showChatboxInterface(p, 740);
    }
}