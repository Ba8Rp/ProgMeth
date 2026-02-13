package gui;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import logic.Command;
import logic.GameSystem;

import static javax.swing.text.StyleConstants.Background;

public class CommandArrowPane extends StackPane {

    public CommandArrowPane(Command command) {
        ArrowPane imagePane = new ArrowPane(command);
        this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY,new CornerRadii(30),null)));
        this.getChildren().addAll(imagePane);

       this.setOnMouseClicked(new EventHandler<MouseEvent>() {
           @Override
           public void handle(MouseEvent mouseEvent) {
               GameSystem.getInstance().addCommand(command);
           }
       });



    }
}
