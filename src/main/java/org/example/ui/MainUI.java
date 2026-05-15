package org.example.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;


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

                    if (value > 0 && value <= MONEY_LIMIT) { // or > 0 if strictly positive
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
        playBtn.setStyle(
                "-fx-background-color: #9A6C00;" +
                        "-fx-background-radius: 8;" +
                        "-fx-text-fill: white;" +
                        "-fx-cursor: hand;" +
                        "-fx-effect: dropshadow(gaussian, rgba(154,108,0,0.28), 10, 0, 0, 3);"
        );
        stylePlayButton(playBtn);



        exitBtn.setFont(Font.font("Georgia", 14));
        exitBtn.setPrefWidth(200);
        styleExitButton(exitBtn);

        this.setSpacing(16);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(40));
        this.setStyle("-fx-background-color: #FAF7F0;");


        this.getChildren().addAll(title, subtitle, questionBox, playBtn, exitBtn);
    }

    public boolean isMoneyEmpty(){
        if(moneyField.getText().equals("")){
            return true;
        }
        return false;
    }

    public static void stylePlayButton(Button button){
        button.setOnMouseEntered(e -> button.setStyle(
                "-fx-background-color: #B07D00;" +
                        "-fx-background-radius: 8;" +
                        "-fx-text-fill: white;" +
                        "-fx-cursor: hand;" +
                        "-fx-effect: dropshadow(gaussian, rgba(154,108,0,0.40), 12, 0, 0, 4);"
        ));
        button.setOnMouseExited(e  -> button.setStyle(
                "-fx-background-color: #9A6C00;" +
                        "-fx-background-radius: 8;" +
                        "-fx-text-fill: white;" +
                        "-fx-cursor: hand;" +
                        "-fx-effect: dropshadow(gaussian, rgba(154,108,0,0.28), 10, 0, 0, 3);"
        ));
    }

    public static void styleExitButton(Button button){
        button.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-border-color: #CCCCCC;" +
                        "-fx-border-width: 1.5;" +
                        "-fx-border-radius: 8;" +
                        "-fx-background-radius: 8;" +
                        "-fx-cursor: hand;"
        );
    }






}