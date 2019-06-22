/**
 * @author Scott Smalley
 * B.S. Software Engineering Fall 2020
 * scottsmalley90@gmail.com | 801-651-9808
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class View extends Application
{

    public static int WIDTH = 375;
    public static int HEIGHT = 667;
//    public static Insets vboxInsets = new Insets(0, 0, 0, 0);
//    public static Insets hboxInsets = new Insets(5, 5, 5, 5);

    public static void main (String [] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {

        //Center Pane
        GridPane sentencePane = new GridPane();
        sentencePane.setStyle("-fx-background-color: lightgrey");
        sentencePane.setPrefSize(WIDTH, HEIGHT*0.67);
        sentencePane.setMinSize(WIDTH, HEIGHT*0.67);
//        sentencePane.setMaxSize(WIDTH, HEIGHT*0.67);

        //Bottom Pane
        VBox solutionBox = new VBox();
        solutionBox.setSpacing(1);
        solutionBox.setStyle("-fx-background-color: grey");
        solutionBox.setPrefSize(WIDTH, HEIGHT*0.33);
        solutionBox.setMinSize(WIDTH, HEIGHT*0.33);

        //Do i actually need to make a var for the instantiation?
        HighlightedKeyboard keyboard = new HighlightedKeyboard(solutionBox);

        BorderPane root = new BorderPane();
        root.setPrefSize(WIDTH, HEIGHT);
        root.setMinSize(WIDTH, HEIGHT);
        root.setCenter(sentencePane);
        root.setBottom(solutionBox);

        //375x667 is half iphone 6/S Resolution 750x1334
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        primaryStage.setTitle("Sentence Scramble - Scott Smalley");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
