package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingList {
    List<ListItem> list;

    ShoppingList() {
        list = new ArrayList<ListItem>();
    }

    ShoppingList(List<ListItem> list) {
       this.list = list;
    }

    public void addItem(ListItem item) {
        list.add(item);
    }

    public void displayList() {
        System.out.format("------------%n");
        for (ListItem x: list) {
            System.out.format("Name: %s%nPrice: %.2f%nTotal Price: %.2f%nQuantity: %d%n------------%n",
                    x.getName(), x.getBasePrice(), x.getTotalPrice(), x.getQuantity());
        }
    }

    public void sortListByName() {
       Collections.sort(list, new SortByName());
    }

    public void sortListByBasePrice() {
        Collections.sort(list, new SortByBasePrice());
    }

    public void sortListByTotalPrice() {
        Collections.sort(list, new SortByTotalPrice());
    }
}
