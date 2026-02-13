package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.GameLogic;

public class ControlPane extends VBox {
    private Text gameText;
    private Button newGameButton;
    private Button secureModeButton;
    private MineSweeperPane mineSweeperPane;

    public ControlPane(MineSweeperPane mineSweeperPane) {
        this.mineSweeperPane = mineSweeperPane;
        setAlignment(Pos.CENTER);
        setPrefWidth(300);
        setSpacing(20);
        initializeGameText();
        initializeNewGameButton();
        initializeSecureModeButton();
        this.getChildren().addAll(gameText, newGameButton, secureModeButton);


    }

    private void initializeGameText() {
        gameText = new Text(" Tiles left : " + GameLogic.getInstance().getTileCount());
        gameText.setFont(new Font(35));
    }

    public void updateGameText(String text) {
        gameText.setText(text);
    }

    private void initializeNewGameButton() {
        newGameButton = new Button("New Game");
        newGameButton.setPrefWidth(100);
        newGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                newGameButtonHandler();
            }
        });
    }

    private void initializeSecureModeButton() {
        secureModeButton = new Button("Secure mode : OFF");
        secureModeButton.setPrefWidth(150);
        secureModeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                secureModeButtonHandler();
            }
        });
    }

    private void newGameButtonHandler() {
        GameLogic.getInstance().newGame();
        secureModeButton.setText("Secure mode : OFF");
        gameText.setText("Tiles left : " + GameLogic.getInstance().getTileCount());
        for(MineSweeperSquare cell : mineSweeperPane.getAllCells()) cell.initializeCellColor();
    }
    private  void secureModeButtonHandler(){
        GameLogic.getInstance().toggleSecureMode();
        if(GameLogic.getInstance().isSecureMode()){
            secureModeButton.setText("Secure mode : ON");
        }else{
            secureModeButton.setText("Secure mode : OFF");
        }
    }
}
