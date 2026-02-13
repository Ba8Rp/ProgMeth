package entity.ingredient;

import entity.base.Cookable;
import entity.base.Ingredient;
import logic.StringUtil;

public class Egg extends Ingredient implements Cookable {

    private int cookedPercentage;

    public Egg() {
        super("Egg");
        setCookedPercentage(0);
    }

    @Override
    public void cook() {
        setCookedPercentage(getCookedPercentage() + 12);
        int x = getCookedPercentage();
        if (0<x && x <= 50) {
            setName("Raw Egg");
            setEdible(false);
        } else if (50 < x && x <= 80) {
            setName("Sunny Side Egg");
            setEdible(true);
        } else if (80 < x && x <= 100) {
            setEdible(true);
            setName("Fried Egg");
        } else if (x > 100){
            setName("Burnt Egg");
            setEdible(false);
        }
    }

    @Override
    public boolean isBurnt() {
        return getCookedPercentage()>100;
    }

    public int getCookedPercentage() {
        return cookedPercentage;
    }

    public void setCookedPercentage(int cookedPercentage) {
        this.cookedPercentage = cookedPercentage;
    }

    @Override
    public String toString() {
        return StringUtil.formatNamePercentage(getName(),getCookedPercentage());
    }
}
