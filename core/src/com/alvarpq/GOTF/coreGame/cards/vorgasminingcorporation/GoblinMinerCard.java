package com.alvarpq.GOTF.coreGame.cards.vorgasminingcorporation;
import com.alvarpq.GOTF.coreGame.Element;
import com.alvarpq.GOTF.coreGame.Player;
import com.alvarpq.GOTF.coreGame.cards.UnitCard;
import com.alvarpq.GOTF.coreGame.cards.UnitFactory;
import com.alvarpq.GOTF.coreGame.units.vorgasminingcorporation.GoblinMiner;
public class GoblinMinerCard extends UnitCard
{
	public GoblinMinerCard(Player owner)
	{
		super(110116, "Goblin Miner", 1, new Element[]{Element.EARTH}, "When Goblin Miner deals damage to an idol, increase your resources and Earth by 1.", owner, new UnitFactory(GoblinMiner.class));
	}
}
