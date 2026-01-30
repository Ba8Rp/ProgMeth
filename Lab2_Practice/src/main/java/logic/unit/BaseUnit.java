package logic.unit;

import java.util.ArrayList;

public class BaseUnit {
    private int row;
    private int column;
    private boolean isWhite;
    private String name;
    protected int hp;
    protected int power;
    protected boolean isFlying;

    public BaseUnit(int startColumn, int startRow, boolean isWhite, String name) {
        this.power = 1;
        this.isFlying = false;
        setHp(2);
        setColumn(startColumn);
        setRow(startRow);
        setisWhite(isWhite);
        setName(name);

    }

    public boolean move(int direction) {
        if (direction >= 0 && direction <= 3) {
            if (direction == 0 && row + 1 < 5) {
                this.row++;
                return true;
            } else if (direction == 1 && column + 1 < 5) {
                this.column++;
                return true;
            } else if (direction == 2 && row - 1 >= 0) {
                this.row--;
                return true;
            } else if (direction == 3 && column - 1 >= 0) {
                this.column--;
                return true;
            }
        }
        return false;
    }
    public void attack(ArrayList<BaseUnit>targetPieces){
        for(BaseUnit bb:targetPieces){
            if(!bb.isFlying&&bb.row==this.row&&bb.column==this.column){
                System.out.println(this.getName()+" attacks "+bb.getName());
                bb.hp-=this.power;
            }
        }
    }
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        if(row<0){
            this.row = 0;
        }
        else if(row>4){
            this.row = 4;
        }else{
            this.row=row;
        }
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        if(column<0){
            this.column = 0;
        }
        else if(column>4){
            this.column = 4;
        }else{
            this.column=column;
        }
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setisWhite(boolean white) {
        isWhite = white;
    }

    public int getPower() {
        return power;
    }

    public boolean isFlying() {
        return isFlying;
    }
}
