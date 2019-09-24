package com.company;

public class Dining implements Expense {
    private Destination destination;
    private int numDays;

    public Dining(Destination destination, int numDays) {
        this.destination = destination;
        this.numDays = numDays;
    }

    public float getCost() {
        switch (destination) {
            case Japan:
                return numDays * 30;
            case Europe:
                return numDays * 20;
            case Mexico:
                return numDays * 10;
        }
        return 0;
    }
}
