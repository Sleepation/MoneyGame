package org.example.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import org.example.buttons.Action;

public class RollUI extends VBox {
    private EventHandler<ActionEvent> onBack;

    public void setOnBack(EventHandler<ActionEvent> handler) {
        this.onBack = handler;
    }


    public RollUI(Action action) {
        Label title = new Label("Pick a Number");
        title.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
        title.setTextFill(Color.web("#9A6C00"));

        HBox buttons = new HBox(12);
        buttons.setAlignment(Pos.CENTER);

        for (int i = 1; i <= 6; i++) {
            Button btn = new Button(String.valueOf(i));
            btn.setFont(Font.font("Georgia", FontWeight.BOLD, 16));
            btn.setPrefWidth(60);
            btn.setPrefHeight(60);
            btn.getStyleClass().add("btn");
            buttons.getChildren().add(btn);
        }

        Button backBtn = new Button("Back");
        backBtn.setFont(Font.font("Georgia", FontWeight.BOLD, 13));
        backBtn.setPrefWidth(100);
        backBtn.setPrefHeight(40);
        backBtn.getStyleClass().add("btn");
        backBtn.setOnAction(e -> { if (onBack != null) onBack.handle(e); });

        this.setSpacing(24);
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: white;");
        this.getChildren().addAll(title, buttons, backBtn);
    }
}
