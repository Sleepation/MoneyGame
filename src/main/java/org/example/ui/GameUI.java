package org.example.ui;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.util.Duration;

import org.example.buttons.Action;
import org.example.buttons.ActionButton;

public class GameUI extends VBox {

    private final HungerBar hungerBar;
    private Timeline hungerDrain;
    private ActionButton workBtn = new ActionButton(Action.WORK);
    private ActionButton investBtn = new ActionButton(Action.INVEST);
    private ActionButton shopBtn = new ActionButton(Action.SHOP);
    private ActionButton eatBtn = new ActionButton(Action.EAT);
    private ActionButton bankBtn = new ActionButton(Action.BANK);
    private ActionButton restBtn = new ActionButton(Action.REST);

    public void setOnRoll(EventHandler<ActionEvent> handler){
        workBtn.setOnAction(handler);
        investBtn.setOnAction(handler);
        shopBtn.setOnAction(handler);
        eatBtn.setOnAction(handler);
        bankBtn.setOnAction(handler);
        restBtn.setOnAction(handler);
    }

    public GameUI(double money, HungerBar hungerBar) {

        // ── Top bar ──────────────────────────────────────────────────────
        Label playerName = new Label("Player  •  $" + money);
        playerName.setFont(Font.font("Georgia", FontWeight.BOLD, 14));
        playerName.setTextFill(Color.web("#9A6C00"));

        HBox topBar = new HBox(playerName);
        topBar.setPadding(new Insets(12, 20, 12, 20));
        topBar.setAlignment(Pos.CENTER_LEFT);
        topBar.setStyle("-fx-background-color: #FFFDF5; -fx-border-color: #DAA520; -fx-border-width: 0 0 1 0;");

        // ── Hunger bar ───────────────────────────────────────────────────
        this.hungerBar = hungerBar;

        // ── Action buttons ───────────────────────────────────────────────
        styledButton(workBtn, "Work",   200, 44);
        styledButton(investBtn, "Invest", 200, 44);
        styledButton(shopBtn, "Shop",   200, 44);
        styledButton(eatBtn, "Eat",    200, 44);
        styledButton(bankBtn, "Bank",   200, 44);
        styledButton(restBtn, "Rest",   200, 44);

        GridPane grid = new GridPane();
        grid.setHgap(12);
        grid.setVgap(12);
        grid.setAlignment(Pos.CENTER);
        grid.add(workBtn,   0, 0);  grid.add(investBtn, 1, 0);
        grid.add(shopBtn,   0, 1);  grid.add(eatBtn,    1, 1);
        grid.add(bankBtn,   0, 2);  grid.add(restBtn,   1, 2);

        // ── Layout ───────────────────────────────────────────────────────
        VBox center = new VBox(20, hungerBar, grid);
        center.setAlignment(Pos.CENTER);
        center.setPadding(new Insets(24));

        this.getChildren().addAll(topBar, center);
        this.setStyle("-fx-background-color: white;");

        hungerDrain = new Timeline(new KeyFrame(Duration.seconds(0.1), e -> hungerBar.drain(0.05)));
        hungerDrain.setCycleCount(Animation.INDEFINITE);
        hungerDrain.play();
    }

    private void startHungerDrain() {
        hungerDrain.play();
    }

    private void stopHungerDrain(){
        hungerDrain.stop();
    }




    private ActionButton styledButton(ActionButton btn, String text, double width, double height) {
        btn.setText(text);
        btn.setFont(Font.font("Georgia", FontWeight.BOLD, 13));
        btn.setPrefWidth(width);
        btn.setPrefHeight(height);
        btn.getStyleClass().add("btn");
        return btn;
    }
}