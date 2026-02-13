package entity.container;

import entity.base.Container;
import entity.base.Ingredient;
import logic.StringUtil;

public class Dish extends Container {
    private int dirty;

    public Dish() {
        super("Dish", 4);
        setDirty(0);
    }

    public Dish(int dirty) {
        super("Dish", 4);
        setDirty(dirty);
    }

    public int getDirty() {
        return dirty;
    }

    public void setDirty(int dirty) {
        if (dirty < 0) {
            this.dirty = 0;
            setName("Dish");
        } else {
            this.dirty = dirty;
            setName("Dish");
            if (dirty > 0) {
                setName("Dirty Dish");
            }
        }

    }

    public boolean isDirty() {
        return getDirty() > 0;
    }

    @Override
    public boolean verifyContent(Ingredient i) {
        if (!this.isDirty() && i.isEdible()) return true;
        return false;
    }

    public void clean(int amount) {
        setDirty(getDirty() - amount);
    }

    @Override
    public String toString() {
       if(dirty>0)return StringUtil.formatNamePercentage(getName(),getDirty());
       else return super.toString();
    }
}
