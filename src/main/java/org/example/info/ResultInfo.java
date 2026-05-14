package org.example.info;

import org.example.buttons.Action;
import org.example.ui.StatBar;

public class ResultInfo {


    public static String getInfo(Action action, int number, StatBar hungerBar) {
        switch (action) {
            case A_T -> {
                switch (number) {
                    case 1 -> { return ResultText.A_T_1; }
                    case 2 -> { return ResultText.A_T_2; }
                    case 3 -> { return ResultText.A_T_3; }
                    case 4 -> { return ResultText.A_T_4; }
                    case 5 -> { return ResultText.A_T_5; }
                    case 6 -> { return ResultText.A_T_6; }
                }
            }
            case SERVICE -> {
                switch (number) {
                    case 1 -> { return ResultText.SERVICE_1; }
                    case 2 -> { return ResultText.SERVICE_2; }
                    case 3 -> { return ResultText.SERVICE_3; }
                    case 4 -> { return ResultText.SERVICE_4; }
                    case 5 -> { return ResultText.SERVICE_5; }
                    case 6 -> { return ResultText.SERVICE_6; }
                }
            }
            case TRANSPORT -> {
                switch (number) {
                    case 1 -> { return ResultText.TRANSPORT_1; }
                    case 2 -> { return ResultText.TRANSPORT_2; }
                    case 3 -> { return ResultText.TRANSPORT_3; }
                    case 4 -> { return ResultText.TRANSPORT_4; }
                    case 5 -> { return ResultText.TRANSPORT_5; }
                    case 6 -> { return ResultText.TRANSPORT_6; }
                }
            }
            case EAT -> {
                switch (number) {
                    case 1 -> { hungerBar.feed(0);
                        return ResultText.EAT_1; }
                    case 2 -> { hungerBar.feed(20);
                        return ResultText.EAT_2; }
                    case 3 -> { hungerBar.feed(10);
                        return ResultText.EAT_3; }
                    case 4 -> { hungerBar.feed(7.5);
                        return ResultText.EAT_4; }
                    case 5 -> { hungerBar.feed(10);
                        return ResultText.EAT_5;}
                    case 6 -> { hungerBar.feed(20);
                        return ResultText.EAT_6; }
                }
            }
        }
        return "";
    }
    public static double getLostMoney(Action action, int number) {
        switch (action) {
            case A_T -> {
                switch (number) {
                    case 1 -> { return 3000; }
                    case 2 -> { return 1500; }
                    case 3 -> { return 500; }
                    case 4 -> { return 300; }
                    case 5 -> { return 1000; }
                    case 6 -> { return 1000; }
                }
            }
            case SERVICE -> {
                switch (number) {
                    case 1 -> { return 150; }
                    case 2 -> { return 50; }
                    case 3 -> { return 50; }
                    case 4 -> { return 50; }
                    case 5 -> { return 10; }
                    case 6 -> { return 0; }
                }
            }
            case TRANSPORT -> {
                switch (number) {
                    case 1 -> { return 6000; }
                    case 2 -> { return 5000; }
                    case 3 -> { return 1000; }
                    case 4 -> { return 4000; }
                    case 5 -> { return 200; }
                    case 6 -> { return 150; }
                }
            }
            case EAT -> {
                switch (number) {
                    case 1 -> { return 5; }
                    case 2 -> { return 60; }
                    case 3 -> { return 20; }
                    case 4 -> { return 10; }
                    case 5 -> { return 15; }
                    case 6 -> { return 10; }
                }
            }
        }
        return 0;
    }

}
