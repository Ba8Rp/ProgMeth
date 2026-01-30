package card.type;

import card.base.UnitCard;
import player.Player;

//You CAN modify the first line
public class LeaderUnitCard extends UnitCard {
    private int buffPower;
    private int buffHealth;

    public LeaderUnitCard(String name, String flavorText, int bloodCost, int power, int health, int buffPower, int buffHealth) {
        super(name, flavorText, bloodCost, power, health);
        this.setBuffHealth(buffHealth);
        this.setBuffPower(buffPower);

    }

    @Override
    public int attackUnit(UnitCard unitCard) {
        int rd = this.getPower();
        if (unitCard.getHealth() < this.getPower()) {
            rd = unitCard.getHealth();
        }
        unitCard.setHealth(unitCard.getHealth() - getPower());
        return rd;
    }

    public void setBuffPower(int buffPower) {
        this.buffPower = (buffPower < 0 ? 0 : buffPower);
    }

    public void setBuffHealth(int buffHealth) {
        this.buffHealth = (buffHealth < 0 ? 0 : buffHealth);
    }

    public int getBuffPower() {
        return buffPower;
    }

    public int getBuffHealth() {
        return buffHealth;
    }

    public void buffUnit(UnitCard[] alliesCard) {
        for (UnitCard u : alliesCard) {
            if (u == null) continue;
            u.setPower(u.getPower() + getBuffPower());
            u.setHealth(u.getHealth() + getBuffHealth());
        }
    }

    @Override
    public String toString() {
        return super.getName() + " (POW: " + super.getPower() + ", HP: " + super.getHealth() +
                " | POW Inc: " + this.getBuffPower() + ", HP Inc: " + this.getBuffHealth() + ")";
    }

}