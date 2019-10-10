package com.company;

public class Cruise implements Expense {
    private Destination destination;
    public Cruise(Destination destination) {
        this.destination = destination;
    }
    public float getCost() {
        switch(destination) {
            case Mexico:
                return 1000;
            case Europe:
                return 2000;
            case Japan:
                return 3000;
        }
        return 0;
    }
}
