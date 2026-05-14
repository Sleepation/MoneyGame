package org.example.ui;

import javafx.animation.*;
import javafx.geometry.*;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.util.Duration;

public class StatBar extends VBox {

    private double value = 100.0;
    private final Rectangle fill;
    private final Label percentLabel;
    private final double barWidth = 400; //weird design
    private LinearGradient customGradient;


    public StatBar(String title, Color labelColor, Color borderColor, LinearGradient customGradient) {

        this.customGradient = customGradient;

        Label titleLabel = new Label(title);
        titleLabel.setFont(Font.font("Georgia", FontWeight.BOLD, 13));
        titleLabel.setTextFill(Color.web("#555555"));

        percentLabel = new Label("100%");
        percentLabel.setFont(Font.font("Georgia", 11));
        percentLabel.setTextFill(labelColor);

        HBox header = new HBox(8, titleLabel, percentLabel);
        header.setAlignment(Pos.CENTER_LEFT);

        //Bar track
        Rectangle track = new Rectangle(barWidth, 18);
        track.setArcWidth(18); track.setArcHeight(18);
        track.setFill(Color.web("#F0F0F0"));
        track.setStroke(borderColor);
        track.setStrokeWidth(1.5);

        //Filled part (originally 100%)
        fill = new Rectangle(barWidth, 18);
        fill.setArcWidth(18); fill.setArcHeight(18);
        fill.setFill(customGradient);

        Group bar = new Group(track, fill);

        this.setSpacing(6);
        this.getChildren().addAll(header, bar);
    }

    /** Increase hunger (e.g. after eating). Capped at 100. */
    public void feed(double amount) {
        value = Math.min(100, value + amount);
        refresh();
    }

    /** Decrease hunger. Capped at 0. */
    public void drain(double amount) {
        value = Math.max(0, value - amount);
        refresh();
    }

    public double getHunger() {
        return value;
    }

    public boolean isStarving() {
        return value == 0;
    }

    private void refresh() {
        fill.setWidth(Math.max(0, value / 100.0 * barWidth));
        percentLabel.setText((int) value + "%");
        fill.setFill(value < 25 ? redGradient() : customGradient);
    }





    private LinearGradient redGradient() {
        return new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("#FF6B6B")),
                new Stop(1, Color.web("#CC0000")));
    }


}