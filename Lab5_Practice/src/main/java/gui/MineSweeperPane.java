package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class MineSweeperPane extends GridPane {
    private ArrayList<MineSweeperSquare> allCells;

    public MineSweeperPane() {
        allCells= new ArrayList<>();
        setHgap(8);
        setVgap(8);
        setPadding(new Insets(8));
        setPrefWidth(500);
        setAlignment(Pos.CENTER);
        setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,BorderWidths.DEFAULT)));
        setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY,Insets.EMPTY)));

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                MineSweeperSquare sq = new MineSweeperSquare(i,j);
                allCells.add(sq);
                this.add(sq,i,j);
            }
        }
    }

    public ArrayList<MineSweeperSquare> getAllCells() {
        return allCells;
    }
}
