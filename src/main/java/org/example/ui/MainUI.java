package org.example.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;


//DONE :D
//10K IS LIMIT
public class MainUI extends VBox {

    private Button playBtn = new Button("▶  Play Now");
    private Button exitBtn = new Button("Exit");
    private TextField moneyField = new TextField();

    private static final double MONEY_LIMIT = 10000;


    public void setOnStartGame(EventHandler<ActionEvent> handler){
        playBtn.setOnAction(handler);
    }

    public void setOnExitGame(EventHandler<ActionEvent> handler){
        exitBtn.setOnAction(handler);
    }

    public double getMoneyInitial(){
        return Double.parseDouble(moneyField.getText());
    }

    public MainUI(){
        Label title = new Label("How quickly can you lose money?");
        title.setFont(Font.font("Georgia", FontWeight.BOLD, 36));
        title.setTextFill(Color.web("#9A6C00"));

        Label subtitle = new Label("Avoid spending too much!");
        subtitle.setFont(Font.font("Georgia", 14));
        subtitle.setTextFill(Color.web("#555555"));

        HBox questionBox = new HBox(10);
        Label moneyInitial = new Label("Initial money:");

        TextFormatter<Double> formatter = new TextFormatter<>(change -> {
            String newText = change.getControlNewText();

            // allow empty (user still typing)
            if (newText.isEmpty()) {
                return change;
            }

            // allow intermediate states like "0." or "."
            if (newText.matches("\\d*\\.\\d*") || newText.matches("\\d+")) {
                try {
                    double value = Double.parseDouble(newText);

                    if (value > 0 && value < MONEY_LIMIT) { // or > 0 if strictly positive
                        return change;
                    }
                } catch (NumberFormatException ignored) {
                }
            }

            return null;
        });
        moneyField.setTextFormatter(formatter);


        questionBox.getChildren().addAll(moneyInitial, moneyField);
        questionBox.setAlignment(Pos.CENTER);

        playBtn.setFont(Font.font("Georgia", FontWeight.BOLD, 16));
        playBtn.setPrefWidth(200);
        playBtn.setPrefHeight(48);

        exitBtn.setFont(Font.font("Georgia", 14));
        exitBtn.setPrefWidth(200);

        this.setSpacing(16);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(40));
        this.setStyle("-fx-background-color: white;");


        this.getChildren().addAll(title, subtitle, questionBox, playBtn, exitBtn);
    }
}