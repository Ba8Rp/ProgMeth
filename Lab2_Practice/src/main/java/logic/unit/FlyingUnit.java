package logic.unit;

public class FlyingUnit extends BaseUnit {
    public FlyingUnit(int startColumn, int startRow, boolean isWhite, String name) {
        super(startColumn, startRow, isWhite, name);
        setHp(2);
        this.isFlying = true;
    }

    @Override
    public boolean move(int direction) {
        if (direction >= 0 && direction <= 3) {
            if (direction == 0 && this.getRow() + 2 < 5) {
                this.setRow(getRow() + 2);
                return true;
            } else if (direction == 1 && this.getColumn() + 2 < 5) {
                this.setColumn(getColumn() + 2);
                return true;
            } else if (direction == 2 && this.getRow() - 2 >= 0) {
                this.setRow(getRow() - 2);
                return true;
            } else if (direction == 3 && this.getColumn() - 2 >= 0) {
                this.setColumn(getColumn() - 2);
                return true;
            }
        }
        return false;
    }
}

