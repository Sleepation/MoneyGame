package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;
import org.example.buttons.Action;
import org.example.buttons.ActionButton;
import org.example.info.ResultInfo;
import org.example.ui.*;


public class GameInitialization extends Application {
    private GameUI gameUI;
    private MainUI mainUI;
    private RollUI rollUI;
    private ResultUI resultUI;
    private StatBar appliancesAndTechnologyBar;
    private StatBar serviceBar;
    private StatBar transportBar;
    private StatBar hungerBar;
    private Scene scene;
    private static Color gray = Color.web("#555555");

    @Override
    public void start(Stage primaryStage){



        reset();

        mainUI = new MainUI();
        scene = new Scene(mainUI, 1000, 1000);

        mainUI.setOnStartGame(e -> {if (!mainUI.isMoneyEmpty())showGame();});

        mainUI.setOnExitGame(e -> {
            primaryStage.close();
        });


        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void showGame() {
        gameUI = new GameUI(mainUI.getMoneyInitial(), appliancesAndTechnologyBar, serviceBar, transportBar, hungerBar);

        //Rolling
        gameUI.setOnRoll(e -> {
            Action action = ((ActionButton)e.getSource()).getAction();
            gameUI.stopDrain(action);
            showRoll(action);
        });

        // RESET
        gameUI.setOnForfeit(e -> {
            reset();
            scene.setRoot(mainUI);
        });
        scene.setRoot(gameUI);
    }

    private void showRoll(Action action){
        rollUI = new RollUI(action,
                (e -> {
                    gameUI.startDrain(action);
                    scene.setRoot(gameUI);
                }),
                (e -> showResult(action, Integer.valueOf(((Button) e.getSource()).getId()))));

        scene.setRoot(rollUI);
    }

    private void showResult(Action action, int id){
        resultUI = new ResultUI(action, id,  gameUI.getCurrentMoney(), hungerBar.getHunger(), hungerBar , e -> {scene.setRoot(gameUI); gameUI.startDrain(action); gameUI.loseMoney(ResultInfo.getLostMoney(action, id));});
        scene.setRoot(resultUI);
    }

    private void reset(){
        appliancesAndTechnologyBar = new StatBar("Appliances & Technology", gray, gray, blueGradient());
        serviceBar                 = new StatBar("Service",                 gray, gray, greenGradient());
        transportBar               = new StatBar("Transport",               gray, gray, orangeGradient());
        hungerBar = new StatBar("Hunger", gray, gray, goldGradient());
    }

    // Hunger - Gold
    private LinearGradient goldGradient() {
        return new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("#FFD700")),
                new Stop(1, Color.web("#DAA520")));
    }

    // Appliances & Technology - Blue
    private LinearGradient blueGradient() {
        return new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("#87CEEB")),
                new Stop(1, Color.web("#1E90FF")));
    }

    // Service - Green
    private LinearGradient greenGradient() {
        return new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("#90EE90")),
                new Stop(1, Color.web("#228B22")));
    }

    // Transport - Orange
    private LinearGradient orangeGradient() {
        return new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("#FFB347")),
                new Stop(1, Color.web("#FF8C00")));
    }


}
