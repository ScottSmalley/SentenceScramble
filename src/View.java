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
        VBox solutionPane = new VBox();
        solutionPane.setSpacing(1);
        solutionPane.setStyle("-fx-background-color: grey");
        solutionPane.setPrefSize(WIDTH, HEIGHT*0.33);
        solutionPane.setMinSize(WIDTH, HEIGHT*0.33);

        //Buttons Row
        HBox buttonsBox = new HBox();
        buttonsBox.setSpacing(1);

        Button prevBtn = new Button("PREV");
        prevBtn.setPrefSize(solutionPane.getPrefWidth()/4, solutionPane.getPrefHeight()*0.1);

        Label answerLbl = new Label("Correct!");
        answerLbl.setPrefSize(solutionPane.getPrefWidth()/2, solutionPane.getPrefHeight()*0.1);
        answerLbl.setAlignment(Pos.CENTER);
        answerLbl.setTextFill(Paint.valueOf("WHITE"));

        Button nextBtn = new Button("NEXT");
        nextBtn.setPrefSize(solutionPane.getPrefWidth()/4, solutionPane.getPrefHeight()*0.1);

        buttonsBox.getChildren().addAll(prevBtn, answerLbl, nextBtn);
        buttonsBox.setMargin(prevBtn, hboxInsets);
        buttonsBox.setMargin(answerLbl, hboxInsets);
        buttonsBox.setMargin(nextBtn, hboxInsets);

        solutionPane.getChildren().add(buttonsBox);
        solutionPane.setMargin(buttonsBox, vboxInsets);

        //Answer Box Row
        HBox answerBox = new HBox();
        answerBox.setSpacing(1);

        TextField inputText = new TextField();
        inputText.setPrefSize(solutionPane.getPrefWidth()/2, solutionPane.getPrefHeight()*0.1);

        answerBox.getChildren().addAll(inputText);
        answerBox.setMargin(inputText, new Insets(5, solutionPane.getPrefWidth()/4, 5, solutionPane.getPrefWidth()/4));

        solutionPane.getChildren().add(answerBox);
        solutionPane.setMargin(answerBox, vboxInsets);

        double buttonWidth = solutionPane.getPrefWidth();
        double buttonHeight = solutionPane.getPrefHeight()*0.2;

        //Keyboard Layer 1
        HBox keyboardLayerOneBox = new HBox();
        keyboardLayerOneBox.setSpacing(0);
        keyboardLayerOneBox.setPrefSize(solutionPane.getPrefWidth(), solutionPane.getPrefHeight()*0.2);

        double buttonWidthModifier = 0.1;

        Button letterQ = new Button("Q");
        letterQ.setPrefSize(buttonWidth*buttonWidthModifier, buttonHeight);
        Button letterW = new Button("W");
        letterW.setPrefSize(buttonWidth*buttonWidthModifier, buttonHeight);
        Button letterE = new Button("E");
        letterE.setPrefSize(buttonWidth*buttonWidthModifier, buttonHeight);
        Button letterR = new Button("R");
        letterR.setPrefSize(buttonWidth*buttonWidthModifier, buttonHeight);
        Button letterT = new Button("T");
        letterT.setPrefSize(buttonWidth*buttonWidthModifier, buttonHeight);
        Button letterY = new Button("Y");
        letterY.setPrefSize(buttonWidth*buttonWidthModifier, buttonHeight);
        Button letterU = new Button("U");
        letterU.setPrefSize(buttonWidth*buttonWidthModifier, buttonHeight);
        Button letterI = new Button("I");
        letterI.setPrefSize(buttonWidth*buttonWidthModifier, buttonHeight);
        Button letterO = new Button("O");
        letterO.setPrefSize(buttonWidth*buttonWidthModifier, buttonHeight);
        Button letterP = new Button("P");
        letterP.setPrefSize(buttonWidth*buttonWidthModifier, buttonHeight);

        keyboardLayerOneBox.getChildren().addAll(letterQ, letterW, letterE, letterR, letterT, letterY, letterU, letterI, letterO, letterP);
        Insets lol = new Insets(0, 0, 0, 0);
        keyboardLayerOneBox.setMargin(letterQ, lol);
        keyboardLayerOneBox.setMargin(letterW, lol);
        keyboardLayerOneBox.setMargin(letterE, lol);
        keyboardLayerOneBox.setMargin(letterR, lol);
        keyboardLayerOneBox.setMargin(letterT, lol);
        keyboardLayerOneBox.setMargin(letterY, lol);
        keyboardLayerOneBox.setMargin(letterU, lol);
        keyboardLayerOneBox.setMargin(letterI, lol);
        keyboardLayerOneBox.setMargin(letterO, lol);
        keyboardLayerOneBox.setMargin(letterP, lol);

        solutionPane.getChildren().add(keyboardLayerOneBox);
        solutionPane.setMargin(keyboardLayerOneBox, vboxInsets);

        //Keyboard Layer 2
        HBox keyboardLayerTwoBox = new HBox();
        keyboardLayerTwoBox.setSpacing(0);
//        keyboardLayerTwoBox.setPrefSize(solutionPane.getPrefWidth(), solutionPane.getPrefHeight()*0.2);

        Button letterA = new Button("A");
        Button letterS = new Button("S");
        Button letterD = new Button("D");
        Button letterF = new Button("F");
        Button letterG = new Button("G");
        Button letterH = new Button("H");
        Button letterJ = new Button("J");
        Button letterK = new Button("K");
        Button letterL = new Button("L");

        keyboardLayerTwoBox.getChildren().addAll(letterA, letterS, letterD, letterF, letterG, letterH, letterJ, letterK, letterL);
        Insets lolTwo = new Insets(0, 0, 0, 0);
        keyboardLayerTwoBox.setMargin(letterA, lolTwo);
        keyboardLayerTwoBox.setMargin(letterS, lolTwo);
        keyboardLayerTwoBox.setMargin(letterD, lolTwo);
        keyboardLayerTwoBox.setMargin(letterF, lolTwo);
        keyboardLayerTwoBox.setMargin(letterG, lolTwo);
        keyboardLayerTwoBox.setMargin(letterH, lolTwo);
        keyboardLayerTwoBox.setMargin(letterJ, lolTwo);
        keyboardLayerTwoBox.setMargin(letterK, lolTwo);
        keyboardLayerTwoBox.setMargin(letterL, lolTwo);

        solutionPane.getChildren().add(keyboardLayerTwoBox);
        solutionPane.setMargin(keyboardLayerTwoBox, vboxInsets);

        //Keyboard Layer 3
        HBox keyboardLayerThreeBox = new HBox();
        keyboardLayerThreeBox.setSpacing(0);
//        keyboardLayerThreeBox.setPrefSize(solutionPane.getPrefWidth(), solutionPane.getPrefHeight()*0.2);

        Button letterZ = new Button("Z");
        Button letterX = new Button("X");
        Button letterC = new Button("C");
        Button letterV = new Button("V");
        Button letterB = new Button("B");
        Button letterN = new Button("N");
        Button letterM = new Button("M");

        keyboardLayerThreeBox.getChildren().addAll(letterZ, letterX, letterC, letterV, letterB, letterN, letterM);
        Insets lolThree = new Insets(0, 0, 0, 0);
        keyboardLayerThreeBox.setMargin(letterZ, lolThree);
        keyboardLayerThreeBox.setMargin(letterX, lolThree);
        keyboardLayerThreeBox.setMargin(letterC, lolThree);
        keyboardLayerThreeBox.setMargin(letterV, lolThree);
        keyboardLayerThreeBox.setMargin(letterB, lolThree);
        keyboardLayerThreeBox.setMargin(letterN, lolThree);
        keyboardLayerThreeBox.setMargin(letterM, lolThree);

        solutionPane.getChildren().add(keyboardLayerThreeBox);
        solutionPane.setMargin(keyboardLayerThreeBox, vboxInsets);


        BorderPane root = new BorderPane();
        root.setPrefSize(WIDTH, HEIGHT);
        root.setMinSize(WIDTH, HEIGHT);
        root.setCenter(sentencePane);
        root.setBottom(solutionPane);

        //375x667 is half iphone 6/S Resolution 750x1334
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        primaryStage.setTitle("Sentence Scramble - Scott Smalley");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
