package org.example.info;

import org.example.buttons.Action;
import org.example.ui.HungerBar;

public class ResultInfo {


    public static String getInfo(Action action, int number, HungerBar hungerBar) {
        switch (action) {
            case WORK -> {
                switch (number) {
                    case 1 -> { return "Bad day at work. You earned $100."; }
                    case 2 -> { return "Slow day. You earned $200."; }
                    case 3 -> { return "Average day. You earned $300."; }
                    case 4 -> { return "Good day. You earned $400."; }
                    case 5 -> { return "Great day! You earned $500."; }
                    case 6 -> { return "Promotion! You earned $600."; }
                }
            }
            case INVEST -> {
                switch (number) {
                    case 1 -> { return "Market crashed. You lost $200."; }
                    case 2 -> { return "Bad investment. You lost $100."; }
                    case 3 -> { return "Break even. Nothing gained."; }
                    case 4 -> { return "Small return. You gained $150."; }
                    case 5 -> { return "Good return. You gained $300."; }
                    case 6 -> { return "Jackpot! You gained $500."; }
                }
            }
            case SHOP -> {
                switch (number) {
                    case 1 -> { return "Nothing useful. You spent $50."; }
                    case 2 -> { return "Basic supplies. You spent $100."; }
                    case 3 -> { return "Decent haul. You spent $150."; }
                    case 4 -> { return "Good deal. You spent $100 and got a bonus."; }
                    case 5 -> { return "Great find! You spent $50 and got a big bonus."; }
                    case 6 -> { return "Mega sale! You spent nothing and got a bonus."; }
                }
            }
            case EAT -> {
                switch (number) {
                    case 1 -> { hungerBar.feed(0);
                        return ResultText.EAT_1; }
                    case 2 -> { return "Small snack. Hunger +20."; }
                    case 3 -> { return "Decent meal. Hunger +30."; }
                    case 4 -> { return "Good meal. Hunger +40."; }
                    case 5 -> { return "Great feast! Hunger +50."; }
                    case 6 -> { return "Banquet! Hunger fully restored."; }
                }
            }
            case BANK -> {
                switch (number) {
                    case 1 -> { return "Bank fee charged. You lost $50."; }
                    case 2 -> { return "Low interest. You gained $20."; }
                    case 3 -> { return "Standard interest. You gained $50."; }
                    case 4 -> { return "Good interest. You gained $100."; }
                    case 5 -> { return "High yield! You gained $200."; }
                    case 6 -> { return "Bonus rate! You gained $400."; }
                }
            }
            case REST -> {
                switch (number) {
                    case 1 -> { return "Poor sleep. No benefit."; }
                    case 2 -> { return "Light rest. Slight recovery."; }
                    case 3 -> { return "Decent sleep. Hunger +10."; }
                    case 4 -> { return "Good rest. Hunger +20."; }
                    case 5 -> { return "Great sleep! Hunger +30."; }
                    case 6 -> { return "Perfect rest! Full recovery."; }
                }
            }
        }
        return "";
    }
}
