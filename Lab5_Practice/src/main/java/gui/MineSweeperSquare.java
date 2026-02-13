package gui;

import javafx.event.EventType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import logic.GameLogic;
import logic.SquareMark;
import logic.SquareState;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

public class MineSweeperSquare extends Pane {
    private boolean isDrawn;
    private Color baseColor;
    private int xPosition;
    private int yPosition;
    private final String oURL;
    private final String oneURL;
    private final String mineURL;
    private final String flagURL;

    public MineSweeperSquare(int x, int y) {
        this.oURL = "o.png";
        this.oneURL = "one.png";
        this.mineURL = "mine.png";
        this.flagURL = "flag.png";
        this.setxPosition(x);
        this.setyPosition(y);
        this.setPrefHeight(100);
        this.setPrefWidth(100);
        this.setMinWidth(100);
        this.setMinHeight(100);
        this.setBaseColor(Color.MOCCASIN);

        initializeCellColor();//wait
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                onClickHandler(); //wait
            }
        });

    }

    public boolean isDrawn() {
        return isDrawn;
    }

    public void setDrawn(boolean drawn) {
        isDrawn = drawn;
    }

    public Color getBaseColor() {
        return baseColor;
    }

    public void setBaseColor(Color baseColor) {
        this.baseColor = baseColor;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public String getoURL() {
        return oURL;
    }

    public String getOneURL() {
        return oneURL;
    }

    public String getMineURL() {
        return mineURL;
    }

    public String getFlagURL() {
        return flagURL;
    }

    private void draw(Image image, Color backgroundColor) {
        BackgroundFill bgFill = new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY);
        BackgroundFill[] bgFillA = {bgFill};
        BackgroundSize bgSize = new BackgroundSize(100, 100, false, false, false, false);
        BackgroundImage bgImg = new BackgroundImage(image, null, null, null, bgSize);
        BackgroundImage[] bgImgA = {bgImg};
        this.setBackground(new Background(bgFillA, bgImgA));

        setDrawn(true);
    }

    private void onClickHandler() {
        if (GameLogic.getInstance().isGameEnd()) return;
        if (!GameLogic.getInstance().isSecureMode() && GameLogic.getInstance().getBoardState()[xPosition][yPosition] != SquareState.REVEALED) {
            SquareMark B = GameLogic.getInstance().getBoardMark()[xPosition][yPosition];
            if(B == SquareMark.ONE){
                draw(new Image(oneURL),Color.ORANGE);
            }else if(B == SquareMark.NOTHING){
                draw(new Image(oURL),Color.YELLOW);
            }else if (B== SquareMark.MINE){
                draw(new Image(mineURL),Color.RED);
            }
            GameLogic.getInstance().updateState(xPosition,yPosition,SquareState.REVEALED);
        }
        if(GameLogic.getInstance().isSecureMode()&& !this.isDrawn()&&GameLogic.getInstance().getBoardState()[xPosition][yPosition] != SquareState.REVEALED){
            draw(new Image(flagURL),Color.GREEN);
            GameLogic.getInstance().updateState(xPosition,yPosition,SquareState.SECURED);
        }
    }
    public  void initializeCellColor(){
        this.setBackground(new Background(new BackgroundFill(getBaseColor(),CornerRadii.EMPTY,Insets.EMPTY)));
        setDrawn(false);
    }

}
