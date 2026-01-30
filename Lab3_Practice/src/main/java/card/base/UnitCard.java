package card.base;

import player.Player;

//You CAN modify the first line
public abstract class UnitCard extends Card {
    private int power;
    private int health;

    public UnitCard(String name, String flavorText, int bloodCost, int power, int health) {
        super(name, flavorText, bloodCost);
        setPower(power);
        setHealth(health);
    }
    public abstract int attackUnit(UnitCard u);

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        if (power < 0) {
            this.power = 0;

        } else {
            this.power = power;
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health<0){
            this.health = 0;
        }else{
            this.health = health;
        }
    }

    public int attackPlayer(Player opponent) {
		opponent.takeDamage(getPower());
        return getPower();
    }

    @Override
    public  String toString() {
        // TODO Auto-generated method stub
        return super.getName() + "\tCost: " + this.getBloodCost() + "\t(POW: " + this.getPower() + ", HP: " + this.getHealth() + ")";
    }

}
