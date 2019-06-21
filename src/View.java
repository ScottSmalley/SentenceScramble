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

        System.out.println(solutionPane.getWidth());
        System.out.println(solutionPane.getPrefWidth());

        HBox buttonsBox = new HBox();
        buttonsBox.setSpacing(1);

        Button prevBtn = new Button("PREV");
        prevBtn.setPrefSize(solutionPane.getPrefWidth()/4, solutionPane.getPrefHeight()/4);

        Label answerLbl = new Label("Correct!");
        answerLbl.setPrefSize(solutionPane.getPrefWidth()/2, solutionPane.getPrefHeight()/4);
        answerLbl.setAlignment(Pos.CENTER);
        answerLbl.setTextFill(Paint.valueOf("WHITE"));

        Button nextBtn = new Button("NEXT");
        nextBtn.setPrefSize(solutionPane.getPrefWidth()/4, solutionPane.getPrefHeight()/4);

        buttonsBox.getChildren().addAll(prevBtn, answerLbl, nextBtn);
        buttonsBox.setMargin(prevBtn, hboxInsets);
        buttonsBox.setMargin(answerLbl, hboxInsets);
        buttonsBox.setMargin(nextBtn, hboxInsets);

        solutionPane.getChildren().add(buttonsBox);
        solutionPane.setMargin(buttonsBox, vboxInsets);

        HBox answerBox = new HBox();
        answerBox.setSpacing(1);

        Rectangle leftRectInput = new Rectangle();
        leftRectInput.setWidth(solutionPane.getPrefWidth()/4);
        leftRectInput.setHeight(solutionPane.getPrefHeight()/4);
        leftRectInput.setFill(Paint.valueOf("grey"));

        TextField inputText = new TextField();
        inputText.setPrefSize(solutionPane.getPrefWidth()/2, solutionPane.getPrefHeight()/4);

        Rectangle rightRectInput = new Rectangle();
        rightRectInput.setWidth(solutionPane.getPrefWidth()/4);
        rightRectInput.setHeight(solutionPane.getPrefHeight()/4);
        rightRectInput.setFill(Paint.valueOf("grey"));

        answerBox.getChildren().addAll(leftRectInput, inputText, rightRectInput);
        answerBox.setMargin(leftRectInput, hboxInsets);
        answerBox.setMargin(inputText, hboxInsets);
        answerBox.setMargin(rightRectInput, hboxInsets);

        solutionPane.getChildren().add(answerBox);
        solutionPane.setMargin(answerBox, vboxInsets);


        HBox lettersBox = new HBox();
        lettersBox.setSpacing(1);

        //Look into if needing these, maybe play with margins?
        Rectangle leftRectLetters = new Rectangle();
        leftRectLetters.setWidth(solutionPane.getPrefWidth()/4);
        leftRectLetters.setHeight(solutionPane.getPrefHeight()/2);
        leftRectLetters.setFill(Paint.valueOf("grey"));

        //Change to a Hbox for the possible letters
        TextField inputTextd = new TextField();
        inputTextd.setPrefSize(solutionPane.getPrefWidth()/2, solutionPane.getPrefHeight()/2);

        //Maybe keep? HBox decides?
        Rectangle rightRectLetters = new Rectangle();
        rightRectLetters.setWidth(solutionPane.getPrefWidth()/4);
        rightRectLetters.setHeight(solutionPane.getPrefHeight()/2);
        rightRectLetters.setFill(Paint.valueOf("grey"));

        lettersBox.getChildren().addAll(leftRectLetters, inputTextd, rightRectLetters);
        lettersBox.setMargin(leftRectLetters, hboxInsets);
        lettersBox.setMargin(inputTextd, hboxInsets);
        lettersBox.setMargin(rightRectLetters, hboxInsets);

        solutionPane.getChildren().add(lettersBox);
        solutionPane.setMargin(lettersBox, vboxInsets);



//        Button prevBtn = new Button("PREV");
//        prevBtn.setPrefSize(solutionPane.getWidth()/3, solutionPane.getHeight()/3);
//        solutionPane.add(prevBtn, 0, 0);
//
//        Label answerLbl = new Label("Correct!");
//        answerLbl.setPrefSize(solutionPane.getWidth()/3, solutionPane.getHeight()/3);
//        answerLbl.setAlignment(Pos.CENTER);
//        answerLbl.setTextFill(Paint.valueOf("WHITE"));
//        solutionPane.add(answerLbl, 1, 0);
//
//        Button nextBtn = new Button("NEXT");
//        nextBtn.setPrefSize(solutionPane.getWidth()/3, solutionPane.getHeight()/3);
//
//        Pane blankLeftPane = new Pane();
//        blankLeftPane.setPrefSize(solutionPane.getWidth()/3, solutionPane.getHeight()/3);
//        blankLeftPane.setMinSize(solutionPane.getWidth()/3, solutionPane.getHeight()/3);
//
//        Rectangle blankLeftBox = new Rectangle(solutionPane.getWidth()/3, solutionPane.getHeight()/3);
//        blankLeftBox.setFill(Paint.valueOf("blue"));
//        blankLeftPane.getChildren().add(blankLeftBox);
//
//        solutionPane.add(blankLeftPane, 0, 1);

        BorderPane root = new BorderPane();
        root.setPrefSize(WIDTH, HEIGHT);
        root.setMinSize(WIDTH, HEIGHT);
//        root.setMaxSize(WIDTH, HEIGHT);
        root.setCenter(sentencePane);
        root.setBottom(solutionPane);

        //375x667 is half iphone 6/S Resolution 750x1334
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        primaryStage.setTitle("Sentence Scramble - Scott Smalley");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
