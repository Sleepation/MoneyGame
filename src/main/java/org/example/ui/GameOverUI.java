package org.example.ui;

import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.event.*;

import java.util.List;

public class GameOverUI extends VBox {

    public GameOverUI(double finalMoney, List<String> rollHistory, EventHandler<ActionEvent> onRestart, double moneyDifference) {

        Label title = new Label("Game Over");
        title.setFont(Font.font("Georgia", FontWeight.BOLD, 24));
        title.setTextFill(Color.web("#9A6C00"));

        Label moneyLabel = new Label("Final balance: $" + String.format("%.2f", finalMoney));
        moneyLabel.setFont(Font.font("Georgia", FontWeight.BOLD, 16));
        moneyLabel.setTextFill(Color.web("#555555"));

        Label historyTitle = new Label("Purchase History");
        historyTitle.setFont(Font.font("Georgia", FontWeight.BOLD, 14));
        historyTitle.setTextFill(Color.web("#555555"));

        VBox historyList = new VBox(6);
        historyList.setAlignment(Pos.CENTER_LEFT);
        for (int i = 0; i < rollHistory.size(); i++) {
            Label entry = new Label((i + 1) + ".  " + rollHistory.get(i));
            entry.setFont(Font.font("Georgia", 13));
            entry.setTextFill(Color.web("#555555"));
            entry.setWrapText(true);
            entry.setMaxWidth(700);
            historyList.getChildren().add(entry);
        }
        Label total = new Label("Total: $" + String.format("%.2f",moneyDifference));
        total.setFont(Font.font("Georgia", FontWeight.BOLD, 16));
        total.setTextFill(Color.web("#555555"));
        total.setWrapText(true);
        total.setMaxWidth(700);
        historyList.getChildren().add(total);

        ScrollPane scroll = new ScrollPane(historyList);
        scroll.setFitToWidth(true);
        scroll.setPrefHeight(400);
        scroll.setStyle("-fx-background: white; -fx-border-color: #DAA520;");

        Button restartBtn = new Button("Back to Menu");
        restartBtn.setFont(Font.font("Georgia", FontWeight.BOLD, 13));
        restartBtn.setPrefWidth(150);
        restartBtn.setPrefHeight(44);
        restartBtn.getStyleClass().add("btn");
        restartBtn.setOnAction(onRestart);

        this.setSpacing(20);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(40));
        this.setStyle("-fx-background-color: white;");
        this.getChildren().addAll(title, moneyLabel, historyTitle, scroll, restartBtn);
    }
}