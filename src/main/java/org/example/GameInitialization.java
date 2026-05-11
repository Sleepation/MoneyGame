package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private HungerBar hungerBar;
    private Scene scene;

    @Override
    public void start(Stage primaryStage){




        hungerBar = new HungerBar();
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
        gameUI = new GameUI(mainUI.getMoneyInitial(), hungerBar);

        //Rolling
        gameUI.setOnRoll(e -> {
            Action action = ((ActionButton)e.getSource()).getAction();
            gameUI.stopHungerDrain();
            showRoll(action);
        });

        // RESET
        gameUI.setOnForfeit(e -> {
            hungerBar = new HungerBar();
            scene.setRoot(mainUI);
        });
        scene.setRoot(gameUI);
    }

    private void showRoll(Action action){
        rollUI = new RollUI(action,
                (e -> {
                    gameUI.startHungerDrain();
                    scene.setRoot(gameUI);
                }),
                (e -> showResult(action, Integer.valueOf(((Button) e.getSource()).getId()))));

        scene.setRoot(rollUI);
    }

    private void showResult(Action action, int id){
        resultUI = new ResultUI(action, id,  gameUI.getCurrentMoney(), hungerBar.getHunger(), hungerBar , e -> {scene.setRoot(gameUI); gameUI.startHungerDrain(); gameUI.loseMoney(ResultInfo.getLostMoney(action, id));});
        scene.setRoot(resultUI);
    }

}
