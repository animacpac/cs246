package com.company;

import java.util.Comparator;

public class SortByName implements Comparator<ListItem> {
    @Override
    public int compare(ListItem o1, ListItem o2) {
        if (!o1.getName().equals(o2.getName())) {
            return o1.getName().compareTo(o2.getName());
        } else if (o1.getBasePrice() != o2.getBasePrice()) {
            return (int) ((o1.getBasePrice() * 100) - (o2.getBasePrice() * 100));
        } else if (o1.getTotalPrice() != o2.getTotalPrice()){
            return (int) ((o1.getTotalPrice() * 100) - (o2.getTotalPrice() * 100));
        }

        return 0;
    }
}
