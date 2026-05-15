package org.example.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import org.example.buttons.Action;
import org.example.info.ResultInfo;

public class ResultUI extends VBox {

    public ResultUI(Action action, int number, double currentMoney, double currentValue, StatBar bar, EventHandler<ActionEvent> setOnBackHandler) {
        Label title = new Label("Result");
        title.setFont(Font.font("Georgia", FontWeight.BOLD, 30));
        title.setTextFill(Color.web("#9A6C00"));

        Label actionLabel = new Label("Action: " + action.name());
        actionLabel.setFont(Font.font("Georgia", 24));
        actionLabel.setTextFill(Color.web("#555555"));

        Label resultLabel = new Label(ResultInfo.getInfo(action, number, bar));
        resultLabel.setFont(Font.font("Georgia", 20));
        resultLabel.setAlignment(Pos.CENTER);
        resultLabel.setTextFill(Color.web("#555555"));
        resultLabel.setLineSpacing(10);
        resultLabel.setWrapText(true);
        resultLabel.setMaxWidth(1200);
        resultLabel.setTextAlignment(TextAlignment.CENTER);

        Label moneyLabel = new Label("Money Left: $" + String.format("%.2f",currentMoney - ResultInfo.getLostMoney(action, number)));
        moneyLabel.setFont(Font.font("Georgia", 14));
        moneyLabel.setTextFill(Color.web("#555555"));

        Button backBtn = new Button("Back");
        backBtn.setFont(Font.font("Georgia", FontWeight.BOLD, 13));
        backBtn.setPrefWidth(100);
        backBtn.setPrefHeight(40);
        MainUI.styleExitButton(backBtn);
        backBtn.setOnAction(setOnBackHandler);

        this.setSpacing(24);
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: #FAF7F0;");
        this.getChildren().addAll(title, actionLabel, resultLabel, moneyLabel, backBtn);
    }
}