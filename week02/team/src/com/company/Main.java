package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Main vc = new Main();

	    // Calculate some vacation costs...
        float japanCost = vc.calculateVacationCost(Destination.Japan);

        System.out.format("Cost: $%1$5.2f", japanCost);
    }

    public float calculateVacationCost(Destination dest) {
        List<Expense> expenses = new ArrayList<Expense>();
        expenses.add(new Cruise(dest));
        expenses.add(new Dining(dest, 5));
        expenses.add(new Lodging(dest, 5));
        return tallyExpenses(expenses);
    }

    float tallyExpenses(List<Expense> expenses) {
        float sum = 0;
        for (Expense x : expenses) {
            sum += x.getCost();
        }
        return sum;
    }
}
