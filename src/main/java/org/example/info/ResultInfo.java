package org.example.info;

import org.example.buttons.Action;
import org.example.ui.StatBar;

public class ResultInfo {


    public static String getInfo(Action action, int number, StatBar bar) {
        switch (action) {
            case APPLIANCES_TECHNOLOGY -> {
                switch (number) {
                    case 1 -> { bar.feed(50);
                        return ResultText.APPLIANCES_TECHNOLOGY_1; }
                    case 2 -> { bar.feed(50);
                        return ResultText.APPLIANCES_TECHNOLOGY_2; }
                    case 3 -> { bar.feed(50);
                        return ResultText.APPLIANCES_TECHNOLOGY_3; }
                    case 4 -> { bar.feed(50);
                        return ResultText.APPLIANCES_TECHNOLOGY_4; }
                    case 5 -> { bar.feed(50);
                        return ResultText.APPLIANCES_TECHNOLOGY_5; }
                    case 6 -> { bar.feed(50);
                        return ResultText.APPLIANCES_TECHNOLOGY_6; }
                }
            }
            case SERVICE -> {
                switch (number) {
                    case 1 -> { bar.feed(50);
                        return ResultText.SERVICE_1; }
                    case 2 -> { bar.feed(40);
                        return ResultText.SERVICE_2; }
                    case 3 -> { bar.feed(30);
                        return ResultText.SERVICE_3; }
                    case 4 -> { bar.feed(30);
                        return ResultText.SERVICE_4; }
                    case 5 -> { bar.feed(30);
                        return ResultText.SERVICE_5; }
                    case 6 -> { bar.feed(30);
                        return ResultText.SERVICE_6; }
                }
            }
            case TRANSPORT -> {
                switch (number) {
                    case 1 -> { bar.feed(50);
                        return ResultText.TRANSPORT_1; }
                    case 2 -> { bar.feed(50);
                        return ResultText.TRANSPORT_2; }
                    case 3 -> { bar.feed(50);
                        return ResultText.TRANSPORT_3; }
                    case 4 -> { bar.feed(20);
                        return ResultText.TRANSPORT_4; }
                    case 5 -> { bar.feed(30);
                        return ResultText.TRANSPORT_5; }
                    case 6 -> { bar.feed(30);
                        return ResultText.TRANSPORT_6; }
                }
            }
            case FOOD -> {
                switch (number) {
                    case 1 -> { bar.feed(0);
                        return ResultText.FOOD_1; }
                    case 2 -> { bar.feed(20);
                        return ResultText.FOOD_2; }
                    case 3 -> { bar.feed(10);
                        return ResultText.FOOD_3; }
                    case 4 -> { bar.feed(7.5);
                        return ResultText.FOOD_4; }
                    case 5 -> { bar.feed(10);
                        return ResultText.FOOD_5;}
                    case 6 -> { bar.feed(20);
                        return ResultText.FOOD_6; }
                }
            }
        }
        return "";
    }
    public static double getLostMoney(Action action, int number) {
        switch (action) {
            case APPLIANCES_TECHNOLOGY -> {
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
                    case 3 -> { return 4000; }
                    case 4 -> { return 1000; }
                    case 5 -> { return 200; }
                    case 6 -> { return 150; }
                }
            }
            case FOOD -> {
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

    public static String getShortDescription(Action action, int number){
        switch (action) {
            case APPLIANCES_TECHNOLOGY -> {
                switch (number) {
                    case 1 -> { return "Smart Fridge"; }
                    case 2 -> { return "Newest Iphone"; }
                    case 3 -> { return "Office Chair"; }
                    case 4 -> { return "Apple Smart Watch"; }
                    case 5 -> { return "Television"; }
                    case 6 -> { return "Computer"; }
                }
            }
            case SERVICE -> {
                switch (number) {
                    case 1 -> { return "Netflix, Disney+, and Crave Subscription"; }
                    case 2 -> { return "Sports Subscription"; }
                    case 3 -> { return "Cellphone Plan"; }
                    case 4 -> { return "Internet"; }
                    case 5 -> { return "Netflix Subscription"; }
                    case 6 -> { return "Youtube With No Subscription"; }
                }
            }
            case TRANSPORT -> {
                switch (number) {
                    case 1 -> { return "Airplane Travel"; }
                    case 2 -> { return "Cruise Ship Travel"; }
                    case 3 -> { return "Used SUV"; }
                    case 4 -> { return "Car Accident"; }
                    case 5 -> { return "Public Transport"; }
                    case 6 -> { return "Bike"; }
                }
            }
            case FOOD -> {
                switch (number) {
                    case 1 -> { return "Coffee"; }
                    case 2 -> { return "Restaurant"; }
                    case 3 -> { return "10 Chocolate Bars"; }
                    case 4 -> { return "3 Bags of Chips"; }
                    case 5 -> { return "McDonalds Uber Eats"; }
                    case 6 -> { return "Sandwiches"; }
                }
            }
        }
        return null;
    }

}
