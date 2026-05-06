package org.example.buttons;

import javafx.scene.control.Button;

public class ActionButton extends Button {
    private Action action;


    public ActionButton(Action action){
        this.action = action;
    }

    public Action getAction(){
        return this.action;
    }
}
