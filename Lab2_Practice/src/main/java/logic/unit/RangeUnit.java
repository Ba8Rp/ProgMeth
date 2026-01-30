package logic.unit;

import java.util.ArrayList;

public class RangeUnit extends BaseUnit {

    public RangeUnit(int startColumn, int startRow, boolean isWhite, String name) {
        super(startColumn, startRow, isWhite, name);
        setHp(2);
    }

    @Override
    public void attack(ArrayList<BaseUnit> targetPieces) {
        for (BaseUnit bb : targetPieces) {
            if (this.isWhite() && bb.getRow()  == this.getRow()+1 && bb.getColumn() == this.getColumn()) {
                System.out.println(this.getName() + " attacks " + bb.getName());
                bb.setHp(bb.getHp() - this.power);
            }
            if (!this.isWhite() && bb.getRow()  == this.getRow()-1 && bb.getColumn() == this.getColumn()) {
                System.out.println(this.getName() + " attacks " + bb.getName());
                bb.setHp(bb.getHp() - this.power);
            }
        }
    }
}