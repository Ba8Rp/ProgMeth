package card.type;

import card.base.UnitCard;
import player.Player;

//You CAN modify the first line
public class DebuffUnitCard extends UnitCard {
    private int debuffPower;

    public DebuffUnitCard(String name, String flavorText, int bloodCost, int power, int health, int debuffPower) {
        super(name, flavorText, bloodCost, power, health);
        setDebuffPower(debuffPower);
    }

    public int getDebuffPower() {
        return debuffPower;
    }

    public void setDebuffPower(int level) {
        if(level<0){
            this.debuffPower =0;

        }else {
            this.debuffPower= level;
        }
    }

    @Override
    public int attackUnit(UnitCard unitCard) {
        int ans = (unitCard.getHealth() < this.getPower()) ? unitCard.getHealth() : this.getPower();
        unitCard.setHealth(unitCard.getHealth() - getPower());
        unitCard.setPower(unitCard.getPower() - getDebuffPower());
        return ans;
    }
}
