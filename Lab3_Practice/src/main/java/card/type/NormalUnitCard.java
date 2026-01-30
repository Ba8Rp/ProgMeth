package card.type;

import card.base.UnitCard;
import player.Player;

//You CAN modify the first line
public class NormalUnitCard extends UnitCard {
	
	public NormalUnitCard(String name, String flavorText, int bloodCost, int power, int health) {
		super(name,flavorText,bloodCost,power,health);
	}
	public int attackUnit(UnitCard unitCard){
		int rd =this.getPower();
		if(unitCard.getHealth()<this.getPower()){
			rd = unitCard.getHealth();
		}
		unitCard.setHealth(unitCard.getHealth()-getPower());
		return rd;
	}

}

