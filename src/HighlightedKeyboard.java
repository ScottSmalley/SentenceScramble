import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import java.util.TreeMap;

/**
 * @author Scott Smalley
 * B.S. Software Engineering Fall 2020
 * scottsmalley90@gmail.com | 801-651-9808
 */

//To build out the Keyboard GUI
public class HighlightedKeyboard
{
    private static Insets vboxInsets = new Insets(0, 0, 0, 0);
    private static Insets hboxInsets = new Insets(5, 5, 5, 5);
    private static Insets keyboardInsets = new Insets(0, 0, 0, 0);

    private TextField inputText;
    private Label answerLbl;
    private TreeMap<String, Button> buttonsMap;

    public HighlightedKeyboard(VBox solutionBox)
    {

        //Buttons Row
        HBox buttonsBox = new HBox();
        buttonsBox.setSpacing(1);

        Button prevBtn = new Button("PREV");
        prevBtn.setPrefSize(solutionBox.getPrefWidth()/4, solutionBox.getPrefHeight()*0.1);
        prevBtn.setOnAction(event -> {
            System.out.println("Prev button");
            clearInputText();
            switchAnswer();
        });

        answerLbl = new Label("Orig");
        answerLbl.setPrefSize(solutionBox.getPrefWidth()/2, solutionBox.getPrefHeight()*0.1);
        answerLbl.setAlignment(Pos.CENTER);
        answerLbl.setTextFill(Paint.valueOf("WHITE"));

        Button nextBtn = new Button("NEXT");
        nextBtn.setPrefSize(solutionBox.getPrefWidth()/4, solutionBox.getPrefHeight()*0.1);
        nextBtn.setOnAction(event -> System.out.println("Next button"));

        buttonsBox.getChildren().addAll(prevBtn, answerLbl, nextBtn);
        buttonsBox.setMargin(prevBtn, hboxInsets);
        buttonsBox.setMargin(answerLbl, hboxInsets);
        buttonsBox.setMargin(nextBtn, hboxInsets);

        solutionBox.getChildren().add(buttonsBox);
        solutionBox.setMargin(buttonsBox, vboxInsets);

        //Answer Box Row
        HBox answerBox = new HBox();
        answerBox.setSpacing(1);

        inputText = new TextField();
        inputText.setPrefSize(solutionBox.getPrefWidth()/2, solutionBox.getPrefHeight()*0.1);
        inputText.setEditable(false);
        inputText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                //ABRITRARY NUMBER NEEDS A WAY TO HAVE ACCESS, GLOBAL??
                //newValue.length() >= currentWord.length()(Global?) && newValue.equals(currentWord)
                if (newValue.length() >= 4)
                {
                    //Change answerLbl to Correct!
//                    System.out.println("Correct!");
                    answerLbl.setText("Correct!");
                }
                else
                {
                    answerLbl.setText("INCORRECT");
                }
            }
        });

        answerBox.getChildren().addAll(inputText);
        answerBox.setMargin(inputText, new Insets(5, solutionBox.getPrefWidth()/4, 5, solutionBox.getPrefWidth()/4));

        solutionBox.getChildren().add(answerBox);
        solutionBox.setMargin(answerBox, vboxInsets);

        double buttonWidth = solutionBox.getPrefWidth();
        double buttonHeight = solutionBox.getPrefHeight()*0.2;

        //Keyboard Layer 1
        HBox keyboardLayerOneBox = new HBox();
        keyboardLayerOneBox.setSpacing(0);
        keyboardLayerOneBox.setPrefSize(solutionBox.getPrefWidth(), solutionBox.getPrefHeight()*0.2);

        double buttonWidthModifier = 0.1;

        Button letterQ = new Button("Q");
        letterQ.setPrefSize(buttonWidth * buttonWidthModifier, buttonHeight);
        letterQ.setOnAction(event -> inputText.appendText("Q"));

        Button letterW = new Button("W");
        letterW.setPrefSize(buttonWidth * buttonWidthModifier, buttonHeight);
        letterW.setOnAction(event -> inputText.appendText("W"));

        Button letterE = new Button("E");
        letterE.setPrefSize(buttonWidth * buttonWidthModifier, buttonHeight);
        letterE.setOnAction(event -> inputText.appendText("E"));

        Button letterR = new Button("R");
        letterR.setPrefSize(buttonWidth * buttonWidthModifier, buttonHeight);
        letterR.setOnAction(event -> inputText.appendText("R"));

        Button letterT = new Button("T");
        letterT.setPrefSize(buttonWidth * buttonWidthModifier, buttonHeight);
        letterT.setOnAction(event -> inputText.appendText("T"));

        Button letterY = new Button("Y");
        letterY.setPrefSize(buttonWidth * buttonWidthModifier, buttonHeight);
        letterY.setOnAction(event -> inputText.appendText("Y"));

        Button letterU = new Button("U");
        letterU.setPrefSize(buttonWidth * buttonWidthModifier, buttonHeight);
        letterU.setOnAction(event -> inputText.appendText("U"));

        Button letterI = new Button("I");
        letterI.setPrefSize(buttonWidth * buttonWidthModifier, buttonHeight);
        letterI.setOnAction(event -> inputText.appendText("I"));

        Button letterO = new Button("O");
        letterO.setPrefSize(buttonWidth * buttonWidthModifier, buttonHeight);
        letterO.setOnAction(event -> inputText.appendText("O"));

        Button letterP = new Button("P");
        letterP.setPrefSize(buttonWidth * buttonWidthModifier, buttonHeight);
        letterP.setOnAction(event -> inputText.appendText("P"));

        keyboardLayerOneBox.getChildren().addAll(letterQ, letterW, letterE, letterR, letterT, letterY, letterU, letterI, letterO, letterP);
        keyboardLayerOneBox.setMargin(letterQ, keyboardInsets);
        keyboardLayerOneBox.setMargin(letterW, keyboardInsets);
        keyboardLayerOneBox.setMargin(letterE, keyboardInsets);
        keyboardLayerOneBox.setMargin(letterR, keyboardInsets);
        keyboardLayerOneBox.setMargin(letterT, keyboardInsets);
        keyboardLayerOneBox.setMargin(letterY, keyboardInsets);
        keyboardLayerOneBox.setMargin(letterU, keyboardInsets);
        keyboardLayerOneBox.setMargin(letterI, keyboardInsets);
        keyboardLayerOneBox.setMargin(letterO, keyboardInsets);
        keyboardLayerOneBox.setMargin(letterP, keyboardInsets);

        solutionBox.getChildren().add(keyboardLayerOneBox);
        solutionBox.setMargin(keyboardLayerOneBox, new Insets(0, solutionBox.getPrefWidth() * 0.00625, 0, solutionBox.getPrefWidth() * 0.00625));

        //Keyboard Layer 2
        HBox keyboardLayerTwoBox = new HBox();
        keyboardLayerTwoBox.setSpacing(0);

        Button letterA = new Button("A");
        letterA.setPrefSize(buttonWidth * buttonWidthModifier, buttonHeight);
        letterA.setOnAction(event -> inputText.appendText("A"));

        Button letterS = new Button("S");
        letterS.setPrefSize(buttonWidth * buttonWidthModifier, buttonHeight);
        letterS.setOnAction(event -> inputText.appendText("S"));

        Button letterD = new Button("D");
        letterD.setPrefSize(buttonWidth * buttonWidthModifier, buttonHeight);
        letterD.setOnAction(event -> inputText.appendText("D"));

        Button letterF = new Button("F");
        letterF.setPrefSize(buttonWidth * buttonWidthModifier, buttonHeight);
        letterF.setOnAction(event -> inputText.appendText("F"));

        Button letterG = new Button("G");
        letterG.setPrefSize(buttonWidth * buttonWidthModifier, buttonHeight);
        letterG.setOnAction(event -> inputText.appendText("G"));

        Button letterH = new Button("H");
        letterH.setPrefSize(buttonWidth * buttonWidthModifier, buttonHeight);
        letterH.setOnAction(event -> inputText.appendText("H"));

        Button letterJ = new Button("J");
        letterJ.setPrefSize(buttonWidth * buttonWidthModifier, buttonHeight);
        letterJ.setOnAction(event -> inputText.appendText("J"));

        Button letterK = new Button("K");
        letterK.setPrefSize(buttonWidth * buttonWidthModifier, buttonHeight);
        letterK.setOnAction(event -> inputText.appendText("K"));

        Button letterL = new Button("L");
        letterL.setPrefSize(buttonWidth * buttonWidthModifier, buttonHeight);
        letterL.setOnAction(event -> inputText.appendText("L"));

        keyboardLayerTwoBox.getChildren().addAll(letterA, letterS, letterD, letterF, letterG, letterH, letterJ, letterK, letterL);
        keyboardLayerTwoBox.setMargin(letterA, keyboardInsets);
        keyboardLayerTwoBox.setMargin(letterS, keyboardInsets);
        keyboardLayerTwoBox.setMargin(letterD, keyboardInsets);
        keyboardLayerTwoBox.setMargin(letterF, keyboardInsets);
        keyboardLayerTwoBox.setMargin(letterG, keyboardInsets);
        keyboardLayerTwoBox.setMargin(letterH, keyboardInsets);
        keyboardLayerTwoBox.setMargin(letterJ, keyboardInsets);
        keyboardLayerTwoBox.setMargin(letterK, keyboardInsets);
        keyboardLayerTwoBox.setMargin(letterL, keyboardInsets);

        solutionBox.getChildren().add(keyboardLayerTwoBox);
        solutionBox.setMargin(keyboardLayerTwoBox, new Insets(0, solutionBox.getPrefWidth() * 0.05, 0, solutionBox.getPrefWidth() * 0.05));

        //Keyboard Layer 3
        HBox keyboardLayerThreeBox = new HBox();
        keyboardLayerThreeBox.setSpacing(0);

        Button letterZ = new Button("Z");
        letterZ.setPrefSize(buttonWidth * buttonWidthModifier, buttonHeight);
        letterZ.setOnAction(event -> inputText.appendText("Z"));

        Button letterX = new Button("X");
        letterX.setPrefSize(buttonWidth * buttonWidthModifier, buttonHeight);
        letterX.setOnAction(event -> inputText.appendText("X"));

        Button letterC = new Button("C");
        letterC.setPrefSize(buttonWidth * buttonWidthModifier, buttonHeight);
        letterC.setOnAction(event -> inputText.appendText("C"));

        Button letterV = new Button("V");
        letterV.setPrefSize(buttonWidth * buttonWidthModifier, buttonHeight);
        letterV.setOnAction(event -> inputText.appendText("V"));

        Button letterB = new Button("B");
        letterB.setPrefSize(buttonWidth * buttonWidthModifier, buttonHeight);
        letterB.setOnAction(event -> inputText.appendText("B"));

        Button letterN = new Button("N");
        letterN.setPrefSize(buttonWidth * buttonWidthModifier, buttonHeight);
        letterN.setOnAction(event -> inputText.appendText("N"));

        Button letterM = new Button("M");
        letterM.setPrefSize(buttonWidth * buttonWidthModifier, buttonHeight);
        letterM.setOnAction(event -> inputText.appendText("M"));

        keyboardLayerThreeBox.getChildren().addAll(letterZ, letterX, letterC, letterV, letterB, letterN, letterM);
        keyboardLayerThreeBox.setMargin(letterZ, keyboardInsets);
        keyboardLayerThreeBox.setMargin(letterX, keyboardInsets);
        keyboardLayerThreeBox.setMargin(letterC, keyboardInsets);
        keyboardLayerThreeBox.setMargin(letterV, keyboardInsets);
        keyboardLayerThreeBox.setMargin(letterB, keyboardInsets);
        keyboardLayerThreeBox.setMargin(letterN, keyboardInsets);
        keyboardLayerThreeBox.setMargin(letterM, keyboardInsets);

        solutionBox.getChildren().add(keyboardLayerThreeBox);
        solutionBox.setMargin(keyboardLayerThreeBox, new Insets(0, solutionBox.getPrefWidth() * 0.15, 0, solutionBox.getPrefWidth() * 0.15));

        //Map to create access for interactivity. We highlight the letters that are used for a current scrambled word.
        //This Map gives us order 1 access to the letters needed, as other assets will know which letters needed.
        //No need to add linear search complexity unnecessarily.
        buttonsMap = new TreeMap<>();
        buttonsMap.put("Q", letterQ);
        buttonsMap.put("W", letterW);
        buttonsMap.put("E", letterE);
        buttonsMap.put("R", letterR);
        buttonsMap.put("T", letterT);
        buttonsMap.put("Y", letterY);
        buttonsMap.put("U", letterU);
        buttonsMap.put("I", letterI);
        buttonsMap.put("O", letterO);
        buttonsMap.put("P", letterP);

        buttonsMap.put("A", letterA);
        buttonsMap.put("S", letterS);
        buttonsMap.put("D", letterD);
        buttonsMap.put("F", letterF);
        buttonsMap.put("G", letterG);
        buttonsMap.put("H", letterH);
        buttonsMap.put("J", letterJ);
        buttonsMap.put("K", letterK);
        buttonsMap.put("L", letterL);

        buttonsMap.put("Z", letterZ);
        buttonsMap.put("X", letterX);
        buttonsMap.put("C", letterC);
        buttonsMap.put("V", letterV);
        buttonsMap.put("B", letterB);
        buttonsMap.put("N", letterN);
        buttonsMap.put("M", letterM);


    }


    public TextField getInput()
    {
        return inputText;
    }

    public void clearInputText()
    {
        inputText.clear();
    }

    //Ternary operator, if text says "Correct!" switch to "Incorrect", else keep it "Correct!".
    public void switchAnswer()
    {
        answerLbl.setText(answerLbl.getText().equals("Correct!") ? "Incorrect" : "Correct!");
    }

    public void highlightKeyboardKey(String letter)
    {
        buttonsMap.get(letter).setOpacity(buttonsMap.get(letter).getOpacity() == 1 ? 0.25 : 1);
    }
}
