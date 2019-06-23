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
    public static Insets vboxInsets = new Insets(0, 0, 0, 0);
    public static Insets hboxInsets = new Insets(5, 5, 5, 5);
    public static int textFieldWidthMod = 3;
    public static int textFieldHeightMod = 3;


    public static void main (String [] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {

        //Center Pane
        VBox sentenceBox = new VBox();
        sentenceBox.setStyle("-fx-background-color: lightgrey");
        sentenceBox.setPrefSize(WIDTH, HEIGHT*0.67);
        sentenceBox.setMinSize(WIDTH, HEIGHT*0.67);
        sentenceBox.setMaxSize(WIDTH, HEIGHT*0.67);
        sentenceBox.setSpacing(1);

        HBox rowOneSentence = new HBox();
        rowOneSentence.setSpacing(1);

        TextField wordOne = new TextField("word1");
        wordOne.setPrefSize(sentenceBox.getPrefWidth()/textFieldWidthMod, sentenceBox.getPrefHeight()/textFieldHeightMod);

        TextField wordTwo = new TextField("word2");
        wordTwo.setPrefSize(sentenceBox.getPrefWidth()/textFieldWidthMod, sentenceBox.getPrefHeight()/textFieldHeightMod);

        TextField wordThree = new TextField("word3");
        wordThree.setPrefSize(sentenceBox.getPrefWidth()/textFieldWidthMod, sentenceBox.getPrefHeight()/textFieldHeightMod);

        rowOneSentence.getChildren().addAll(wordOne, wordTwo, wordThree);
        rowOneSentence.setMargin(wordOne, hboxInsets);
        rowOneSentence.setMargin(wordTwo, hboxInsets);
        rowOneSentence.setMargin(wordThree, hboxInsets);


        sentenceBox.getChildren().add(rowOneSentence);
        sentenceBox.setMargin(rowOneSentence, vboxInsets);


        /**
         * hbox to be the holder of each row
         * each row contains N vbox's which represent
         * each word
         * each word contains a textfield for the scramble
         * and a textfield for the correct word to fit.
         *
         * OR
         *
         * we could do hbox for each row
         * one textbox per word, shows as scramble.
         * then when the user gets the correct word,
         * we change it to the correct word?!
         *
         * Also
         * we could include the punctuation?
         *
         * Also how do we want ot hold these words?
         * I'm thinking a JSON file, and if we have time
         * learn SQLite to switch over the DB.
         *
         *
         * Also, where do we want to put the logic?
         * I'm thinking in the keyboard, since we have to already worry
         * about listeners n such. That way the sentenceBox is just a display.
         * One thing to consider is how do we end the game, we need a way to
         * know we've completed the sentence.
         *
         *
         * CONCLUSION:
         * I believe option 2 would be better for coding purposes.
         * Less padding/margin/spacing to deal with. Also makes logical
         * sense, the sentence is the focus, and when they get it correct they
         * move on.
         *
         * Let's use JSON files for now to represent each phrase or writing.
         *
         * Logic will be focused in the solutionBox, not the sentenceBox.
         */


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
        root.setStyle("-fx-background-color: lightgrey");
        root.setCenter(sentenceBox);
        root.setBottom(solutionBox);

        //375x667 is half iphone 6/S Resolution 750x1334
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        primaryStage.setTitle("Sentence Scramble - Scott Smalley");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
