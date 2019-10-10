package com.company;

import java.util.Comparator;

public class SortByMaxTemp implements Comparator<CityInfo> {
    public int compare(CityInfo a, CityInfo b) {
        return (int)(a.getMaxTemp() - b.getMaxTemp());
    }
}
