package Bulby.io.packets;


import Bulby.Engine;
import Bulby.players.Player;
import Bulby.players.items.PlayerItems;
import Bulby.util.Misc;
public class Shopbuyconfig implements Packet {
    /**
     * Handles operating equipped items.
     * @param p The Player which the frame should be handled for.
     * @param packetId The packet id this belongs to.
     * @param packetSize The amount of bytes being recieved for this packet.
     */

	public void handlePacket(Player p, int packetId, int packetSize) {
        if (p == null || p.stream == null) {
            return;
        }
		PlayerItems pi = new PlayerItems();
		NPCOption1 N1 = new NPCOption1();
        int junk = p.stream.readDWord();
        int itemId = p.stream.readUnsignedWordA();
        int itemSlot = p.stream.readUnsignedWordBigEndianA();      

//if (itemSlot < 0 || itemSlot >= p.equipment.length || p.equipment[itemSlot] != itemId) {
        //    return;
	//}



		if (p.shopid == 2 && Engine.playerItems.HasItemAmount(p, 995, p.shop2p[itemSlot]))
		 {
			pi.deleteItem(p, 995, pi.getItemSlot(p, 995), p.shop2p[itemSlot]);
			pi.addItem(p, p.shop2[itemSlot], 1);
		}
		else if (p.shopid == 3 && Engine.playerItems.HasItemAmount(p, 995, p.shop3p[itemSlot]))
		 {
			pi.deleteItem(p, 995, pi.getItemSlot(p, 995), p.shop3p[itemSlot]);
			pi.addItem(p, p.shop3[itemSlot], 1);
		}
		else if (p.shopid == 4 && Engine.playerItems.HasItemAmount(p, 995, p.shop4p[itemSlot]))
		 {
			pi.deleteItem(p, 995, pi.getItemSlot(p, 995), p.shop4p[itemSlot]);
			pi.addItem(p, p.shop4[itemSlot], 1);
		}
		else if (p.shopid == 5 && Engine.playerItems.HasItemAmount(p, 995, p.shop5p[itemSlot]))
		 {
			pi.deleteItem(p, 995, pi.getItemSlot(p, 995), p.shop5p[itemSlot]);
			pi.addItem(p, p.shop5[itemSlot], 1);
		}
		else if (p.shopid == 6 && Engine.playerItems.HasItemAmount(p, 995, p.shop6p[itemSlot]))
		 {
			pi.deleteItem(p, 995, pi.getItemSlot(p, 995), p.shop6p[itemSlot]);
			pi.addItem(p, p.shop6[itemSlot], 1);
		}
		else if (p.shopid == 7 && Engine.playerItems.HasItemAmount(p, 995, p.shop7p[itemSlot]))
		 {
			pi.deleteItem(p, 995, pi.getItemSlot(p, 995), p.shop7p[itemSlot]);
			pi.addItem(p, p.shop7[itemSlot], 1);
		}
		else if (p.shopid == 8 && Engine.playerItems.HasItemAmount(p, 995, p.shop8p[itemSlot]))
		 {
			pi.deleteItem(p, 995, pi.getItemSlot(p, 995), p.shop8p[itemSlot]);
			pi.addItem(p, p.shop8[itemSlot], 1);
		}
		else if (p.shopid == 9 && p.pestpoints > p.shop9p[itemSlot])
		 {
			p.pestpoints -= p.shop9p[itemSlot];
			pi.addItem(p, p.shop9[itemSlot], 1);
		} 
	else if (p.shopid == 10 && Engine.playerItems.HasItemAmount(p, 995, p.shop10p[itemSlot]))
		 {
			pi.deleteItem(p, 995, pi.getItemSlot(p, 995), p.shop10p[itemSlot]);
			pi.addItem(p, p.shop10[itemSlot], 1);
		}
	else if (p.shopid == 11 && Engine.playerItems.HasItemAmount(p, 995, p.shop11p[itemSlot]))
		 {
			pi.deleteItem(p, 995, pi.getItemSlot(p, 995), p.shop11p[itemSlot]);
			pi.addItem(p, p.shop11[itemSlot], 1);
		}
	else if (p.shopid == 12 && Engine.playerItems.HasItemAmount(p, 995, p.shop12p[itemSlot]))
		 {
			pi.deleteItem(p, 995, pi.getItemSlot(p, 995), p.shop12p[itemSlot]);
			pi.addItem(p, p.shop12[itemSlot], 1);
		}
       else if (p.shopid == 13 && Engine.playerItems.HasItemAmount(p, 995, p.shop13p[itemSlot]))
		 {
			pi.deleteItem(p, 995, pi.getItemSlot(p, 995), p.shop13p[itemSlot]);
			pi.addItem(p, p.shop13[itemSlot], 1);
		}
      else if (p.shopid == 14 && Engine.playerItems.HasItemAmount(p, 6529, p.shop14p[itemSlot]))
		 {
			pi.deleteItem(p, 6529, pi.getItemSlot(p, 6529), p.shop14p[itemSlot]);
			pi.addItem(p, p.shop14[itemSlot], 1);
		}
      else if (p.shopid == 15 && Engine.playerItems.HasItemAmount(p, 995, p.shop15p[itemSlot]))
		 {
			pi.deleteItem(p, 995, pi.getItemSlot(p, 995), p.shop15p[itemSlot]);
			pi.addItem(p, p.shop15[itemSlot], 1);
		}
      else if (p.shopid == 16 && Engine.playerItems.HasItemAmount(p, 995, p.shop16p[itemSlot]))
		 {
			pi.deleteItem(p, 995, pi.getItemSlot(p, 995), p.shop16p[itemSlot]);
			pi.addItem(p, p.shop16[itemSlot], 1);
		}
      else if (p.shopid == 17 && Engine.playerItems.HasItemAmount(p, 6529, p.shop17p[itemSlot]))
		 {
			pi.deleteItem(p, 6529, pi.getItemSlot(p, 6529), p.shop17p[itemSlot]);
			pi.addItem(p, p.shop17[itemSlot], 1);
		}
      else if (p.shopid == 18 && Engine.playerItems.HasItemAmount(p, 995, p.shop18p[itemSlot]))
		 {
			pi.deleteItem(p, 995, pi.getItemSlot(p, 995), p.shop18p[itemSlot]);
			pi.addItem(p, p.shop18[itemSlot], 1);
		}
      else if (p.shopid == 19 && Engine.playerItems.HasItemAmount(p, 995, p.shop19p[itemSlot]))
		 {
			pi.deleteItem(p, 995, pi.getItemSlot(p, 995), p.shop19p[itemSlot]);
			pi.addItem(p, p.shop19[itemSlot], 1);
		}
      else if (p.shopid == 20 && Engine.playerItems.HasItemAmount(p, 995, p.shop20p[itemSlot]))
		 {
			pi.deleteItem(p, 995, pi.getItemSlot(p, 995), p.shop20p[itemSlot]);
			pi.addItem(p, p.shop20[itemSlot], 1);
		}
      else if (p.shopid == 21 && Engine.playerItems.HasItemAmount(p, 995, p.shop21p[itemSlot]))
		 {
			pi.deleteItem(p, 995, pi.getItemSlot(p, 995), p.shop21p[itemSlot]);
			pi.addItem(p, p.shop21[itemSlot], 1);
		}
      else if (p.shopid == 22 && Engine.playerItems.HasItemAmount(p, 995, p.shop22p[itemSlot]))
		 {
			pi.deleteItem(p, 995, pi.getItemSlot(p, 995), p.shop22p[itemSlot]);
			pi.addItem(p, p.shop22[itemSlot], 1);
		}
      else if (p.shopid == 23 && Engine.playerItems.HasItemAmount(p, 995, p.shop23p[itemSlot]))
		 {
			pi.deleteItem(p, 995, pi.getItemSlot(p, 995), p.shop23p[itemSlot]);
			pi.addItem(p, p.shop23[itemSlot], 1);
		}
      else if (p.shopid == 24 && p.pestpoints > p.shop24p[itemSlot])
		 {
			p.barpoints -= p.shop24p[itemSlot];
			pi.addItem(p, p.shop24[itemSlot], 1);
		}
      else if (p.shopid == 25 && Engine.playerItems.HasItemAmount(p, 995, p.shop25p[itemSlot]))
		 {
			pi.deleteItem(p, 995, pi.getItemSlot(p, 995), p.shop25p[itemSlot]);
			pi.addItem(p, p.shop25[itemSlot], 1);
		} 






      
      
      
			
		else 
		{
			p.frames.sendMessage(p,"You don't have enough coins/tokuls for this item!");
		}


}
}