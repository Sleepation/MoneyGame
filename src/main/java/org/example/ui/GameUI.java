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

    private final StatBar appliancesAndTechnologyBar;
    private final StatBar serviceBar;
    private final StatBar transportBar;
    private final StatBar hungerBar;
    private Timeline appliancesAndTechnologyDrain;
    private Timeline serviceDrain;
    private Timeline transportDrain;
    private Timeline hungerDrain;
    private Label playerName;
    private ActionButton appliancesAndTechnologyBtn = new ActionButton(Action.APPLIANCES_TECHNOLOGY);
    private ActionButton serviceBtn = new ActionButton(Action.SERVICE);
    private ActionButton transportBtn = new ActionButton(Action.TRANSPORT);
    private ActionButton eatBtn = new ActionButton(Action.FOOD);
    private Button forfeitBtn = new Button();
    private EventHandler<ActionEvent> onForfeit;
    private double currentMoney = 0;
    private double initialMoney = 0;
    private EventHandler<ActionEvent> onGameOver;

    public void setOnGameOver(EventHandler<ActionEvent> handler) {
        onGameOver = handler;
    }

    public void setOnRoll(EventHandler<ActionEvent> handler){
        appliancesAndTechnologyBtn.setOnAction(handler);
        serviceBtn.setOnAction(handler);
        transportBtn.setOnAction(handler);
        eatBtn.setOnAction(handler);
    }

    public void setOnForfeit(EventHandler<ActionEvent> handler){
        onForfeit = handler;
        forfeitBtn.setOnAction(onForfeit);
    }

    public GameUI(double money, StatBar appliancesAndTechnologyBar, StatBar serviceBar, StatBar transportBar, StatBar hungerBar) {
        initialMoney = money;
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
        this.appliancesAndTechnologyBar = appliancesAndTechnologyBar;
        this.serviceBar = serviceBar;
        this.transportBar = transportBar;
        this.hungerBar = hungerBar;

        // ── Action buttons ───────────────────────────────────────────────
        styleButton(forfeitBtn, "Forfeit", 200, 44);
        forfeitBtn.setLayoutX(0);
        forfeitBtn.setLayoutY(0);

        styleButton(appliancesAndTechnologyBtn, "Appliances & Technology",   400, 88);
        styleButton(serviceBtn, "Service", 400, 88);
        styleButton(transportBtn, "Transport",   400, 88);
        styleButton(eatBtn, "Food",    400, 88);

        GridPane grid = new GridPane();
        grid.setHgap(12);
        grid.setVgap(12);
        grid.setAlignment(Pos.CENTER);
        grid.add(appliancesAndTechnologyBtn,   0, 0);  grid.add(serviceBtn, 1, 0);
        grid.add(transportBtn,   0, 1);  grid.add(eatBtn,    1, 1);

        // ── Layout ───────────────────────────────────────────────────────
        Pane forfeitPane = new Pane();
        forfeitPane.getChildren().add(forfeitBtn);
        VBox center = new VBox(20, appliancesAndTechnologyBar, serviceBar, transportBar, hungerBar, grid);
        center.setAlignment(Pos.CENTER);
        center.setPadding(new Insets(24));

        this.getChildren().addAll(forfeitPane, topBar, center);
        this.setStyle("-fx-background-color: #FAF7F0;");

        setTimeline(Action.APPLIANCES_TECHNOLOGY);
        setTimeline(Action.SERVICE);
        setTimeline(Action.TRANSPORT);
        setTimeline(Action.FOOD);
    }

    private void setTimeline(Action action){
        switch (action){
            case APPLIANCES_TECHNOLOGY -> {
                appliancesAndTechnologyDrain = new Timeline(
                        new KeyFrame(Duration.seconds(0.01), e -> {

                            appliancesAndTechnologyBar.drain(0.03);

                            if (appliancesAndTechnologyBar.getValue() <= 0) {
                                createGameOver();
                            }
                        })
                );

                appliancesAndTechnologyDrain.setCycleCount(Animation.INDEFINITE);
                appliancesAndTechnologyDrain.play();
            }

            case SERVICE -> {
                serviceDrain = new Timeline(
                        new KeyFrame(Duration.seconds(0.01), e -> {

                            serviceBar.drain(0.03);

                            if (serviceBar.getValue() <= 0) {
                                createGameOver();
                            }
                        })
                );

                serviceDrain.setCycleCount(Animation.INDEFINITE);
                serviceDrain.play();
            }

            case TRANSPORT -> {
                transportDrain = new Timeline(
                        new KeyFrame(Duration.seconds(0.01), e -> {

                            transportBar.drain(0.02);

                            if (transportBar.getValue() <= 0) {
                                createGameOver();
                            }
                        })
                );

                transportDrain.setCycleCount(Animation.INDEFINITE);
                transportDrain.play();
            }

            case FOOD -> {
                hungerDrain = new Timeline(
                        new KeyFrame(Duration.seconds(0.01), e -> {

                            hungerBar.drain(0.05);

                            if (hungerBar.getValue() <= 0) {
                                createGameOver();
                            }
                        })
                );

                hungerDrain.setCycleCount(Animation.INDEFINITE);
                hungerDrain.play();
            }
        }
    }

    public void startDrain(Action action) {
        switch (action) {
            case APPLIANCES_TECHNOLOGY        -> appliancesAndTechnologyDrain.play();
            case SERVICE    -> serviceDrain.play();
            case TRANSPORT  -> transportDrain.play();
            case FOOD        -> hungerDrain.play();
        }
    }

    public void stopDrain(Action action) {
        switch (action) {
            case APPLIANCES_TECHNOLOGY        -> appliancesAndTechnologyDrain.stop();
            case SERVICE    -> serviceDrain.stop();
            case TRANSPORT  -> transportDrain.stop();
            case FOOD        -> hungerDrain.stop();
        }
    }

    public double getCurrentMoney(){
        return currentMoney;
    }

    public void loseMoney(double amount){
        this.currentMoney -= amount;
        if (currentMoney >= 0){
            this.playerName.setText("Player  •  $" + currentMoney);
        } else {
            createGameOver();
        }

    }

    private void createGameOver(){
        appliancesAndTechnologyDrain.stop();
        serviceDrain.stop();
        transportDrain.stop();
        hungerDrain.stop();

        if (onGameOver != null) {
            onGameOver.handle(new ActionEvent());
        }
    }


    public double getMoneyDifference(){
        return initialMoney - currentMoney;
    }

    private void styleButton(Button btn, String text, double width, double height) {
        btn.setText(text);
        btn.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
        btn.setPrefWidth(width);
        btn.setPrefHeight(height);
        MainUI.styleExitButton(btn);
    }
}