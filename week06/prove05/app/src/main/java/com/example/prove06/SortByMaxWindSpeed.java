package com.company;

import java.util.Comparator;

public class SortByMaxWindSpeed implements Comparator<CityInfo> {
    public int compare(CityInfo a, CityInfo b) {
        return (int)(a.getMaxWindSpeed() - b.getMaxWindSpeed());
    }
}
