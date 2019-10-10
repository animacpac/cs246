package com.company;

public class Lodging implements Expense {
    private Destination destination;
    private int numDays;

    public Lodging(Destination destination, int numDays) {
        this.destination = destination;
        this.numDays = numDays;
    }

    public float getCost() {
        switch (destination) {
            case Mexico:
                return numDays * 100;
            case Europe:
                return (float)1.1 * (numDays * 200);
            case Japan:
                return (float)1.3 * (numDays * 300);
        }
        return 0;
    }
}
