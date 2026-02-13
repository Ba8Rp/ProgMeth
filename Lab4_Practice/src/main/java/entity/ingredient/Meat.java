package entity.ingredient;

import entity.base.Choppable;
import entity.base.Cookable;
import entity.base.Ingredient;
import logic.StringUtil;

public class Meat extends Ingredient implements Choppable, Cookable {
    private boolean chopState;
    private int cookedPercentage;

    public Meat() {
        super("Meat");
        this.setChopState(false);
        this.setCookedPercentage(0);
    }

    @Override
    public void chop() {
        if (isChopped()) return;
        this.setChopState(true);
        this.setName("Minced Meat");
    }

    @Override
    public boolean isChopped() {
        return isChopState();
    }

    @Override
    public void cook() {
        if (!isChopped()) {
            setCookedPercentage(getCookedPercentage() + 10);
            int x = getCookedPercentage();
            if (0 < x && x <= 50) {
                setName("Raw Meat");
                setEdible(false);
            } else if (50 < x && x <= 80) {
                setName("Medium Rare Steak");
                setEdible(true);
            } else if (80 < x && x <= 100) {
                setEdible(true);
                setName("Well Done Steak");
            } else if (x > 100) {
                setName("Burnt Steak");
                setEdible(false);
            }
        } else {
            setCookedPercentage(getCookedPercentage() + 15);
            int x = getCookedPercentage();
            if (0 < x && x <= 80) {
                setName("Raw Burger");
                setEdible(false);
            } else if (80 < x && x <= 100) {
                setEdible(true);
                setName("Cooked Burger");
            } else if (x > 100) {
                setName("Burnt Burger");
                setEdible(false);
            }
        }
    }

    @Override
    public boolean isBurnt() {
        return getCookedPercentage() > 100;
    }

    public int getCookedPercentage() {
        return cookedPercentage;
    }

    public void setCookedPercentage(int cookedPercentage) {
        this.cookedPercentage = cookedPercentage;
    }

    public boolean isChopState() {
        return chopState;
    }

    public void setChopState(boolean chopState) {
        this.chopState = chopState;
    }

    @Override
    public String toString() {
        return StringUtil.formatNamePercentage(getName(), getCookedPercentage());
    }
}
