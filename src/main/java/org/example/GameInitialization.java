package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.buttons.Action;
import org.example.buttons.ActionButton;
import org.example.ui.GameUI;
import org.example.ui.HungerBar;
import org.example.ui.MainUI;
import org.example.ui.RollUI;

public class GameInitialization extends Application {
    private GameUI gameUI;
    private MainUI mainUI;
    private RollUI rollUI;
    private HungerBar hungerBar;
    private Scene scene;

    @Override
    public void start(Stage primaryStage){




        hungerBar = new HungerBar();
        mainUI = new MainUI();
        scene = new Scene(mainUI, 1000, 1000);

        mainUI.setOnStartGame(e -> showGame());

        mainUI.setOnExitGame(e -> {
            primaryStage.close();
        });


        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void showGame() {
        gameUI = new GameUI(mainUI.getMoneyInitial(), hungerBar);
        gameUI.setOnRoll(e -> {
            Action action = ((ActionButton)e.getSource()).getAction();
            showRoll(action);
        });
        scene.setRoot(gameUI);
    }

    private void showRoll(Action action){
        rollUI = new RollUI(action);
        rollUI.setOnBack(e -> scene.setRoot(gameUI));
        scene.setRoot(rollUI);
    }
}
