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
    private Label playerName;
    private ActionButton workBtn = new ActionButton(Action.WORK);
    private ActionButton investBtn = new ActionButton(Action.INVEST);
    private ActionButton shopBtn = new ActionButton(Action.SHOP);
    private ActionButton eatBtn = new ActionButton(Action.EAT);
    private ActionButton bankBtn = new ActionButton(Action.BANK);
    private ActionButton restBtn = new ActionButton(Action.REST);
    private Button forfeitBtn = new Button();
    private EventHandler<ActionEvent> onForfeit;
    private double currentMoney = 0;

    public void setOnRoll(EventHandler<ActionEvent> handler){
        workBtn.setOnAction(handler);
        investBtn.setOnAction(handler);
        shopBtn.setOnAction(handler);
        eatBtn.setOnAction(handler);
        bankBtn.setOnAction(handler);
        restBtn.setOnAction(handler);
    }

    public void setOnForfeit(EventHandler<ActionEvent> handler){
        onForfeit = handler;
        forfeitBtn.setOnAction(onForfeit);
    }

    public GameUI(double money, HungerBar hungerBar) {
        currentMoney = money;
        // ── Top bar ──────────────────────────────────────────────────────
        this.playerName = new Label("Player  •  $" + currentMoney);
        playerName.setFont(Font.font("Georgia", FontWeight.BOLD, 14));
        playerName.setTextFill(Color.web("#9A6C00"));

        HBox topBar = new HBox(playerName);
        topBar.setPadding(new Insets(12, 20, 12, 20));
        topBar.setAlignment(Pos.CENTER_LEFT);
        topBar.setStyle("-fx-background-color: #FFFDF5; -fx-border-color: #DAA520; -fx-border-width: 0 0 1 0;");

        // ── Hunger bar ───────────────────────────────────────────────────
        this.hungerBar = hungerBar;

        // ── Action buttons ───────────────────────────────────────────────
        styleButton(forfeitBtn, "Forfeit", 100, 44);
        forfeitBtn.setLayoutX(0);
        forfeitBtn.setLayoutY(0);

        styleButton(workBtn, "Work",   200, 44);
        styleButton(investBtn, "Invest", 200, 44);
        styleButton(shopBtn, "Shop",   200, 44);
        styleButton(eatBtn, "Eat",    200, 44);
        styleButton(bankBtn, "Bank",   200, 44);
        styleButton(restBtn, "Rest",   200, 44);

        GridPane grid = new GridPane();
        grid.setHgap(12);
        grid.setVgap(12);
        grid.setAlignment(Pos.CENTER);
        grid.add(workBtn,   0, 0);  grid.add(investBtn, 1, 0);
        grid.add(shopBtn,   0, 1);  grid.add(eatBtn,    1, 1);
        grid.add(bankBtn,   0, 2);  grid.add(restBtn,   1, 2);

        // ── Layout ───────────────────────────────────────────────────────
        Pane forfeitPane = new Pane();
        forfeitPane.getChildren().add(forfeitBtn);
        VBox center = new VBox(20, hungerBar, grid);
        center.setAlignment(Pos.CENTER);
        center.setPadding(new Insets(24));

        this.getChildren().addAll(forfeitPane, topBar, center);
        this.setStyle("-fx-background-color: white;");

        hungerDrain = new Timeline(new KeyFrame(Duration.seconds(0.1), e -> hungerBar.drain(0.05)));
        hungerDrain.setCycleCount(Animation.INDEFINITE);
        hungerDrain.play();
    }

    public void startHungerDrain() {
        hungerDrain.play();
    }

    public void stopHungerDrain(){
        hungerDrain.stop();
    }

    public double getCurrentMoney(){
        return currentMoney;
    }

    public void loseMoney(double amount){
        this.currentMoney -= amount;
        if (currentMoney >= 0){
            this.playerName.setText("Player  •  $" + currentMoney);
        } else {
            this.getChildren().clear();
            forfeitBtn.setText("Game Over!");
            //GET A SUMMARY OF WHAT WAS LOST!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

            this.getChildren().add(forfeitBtn);
            this.setAlignment(Pos.CENTER);
        }

    }




    private void styleButton(Button btn, String text, double width, double height) {
        btn.setText(text);
        btn.setFont(Font.font("Georgia", FontWeight.BOLD, 13));
        btn.setPrefWidth(width);
        btn.setPrefHeight(height);
        btn.getStyleClass().add("btn");
    }
}