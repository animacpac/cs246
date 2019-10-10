package com.company;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private String name;
    private int health;
    private int mana;
    private int gold;
    private Map<String, Integer> equipment;

    Player() {
        name = "<name>";
        health = 20;
        mana = 10;
        gold = 50;
    }

    Player(String name, int health, int mana, int gold) {
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.gold = gold;
        equipment = new HashMap<String, Integer>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void display() {
        System.out.format("Player: %s%n", name);
        System.out.format("Health: %d%n", health);
        System.out.format("Mana: %d%n", mana);
        System.out.format("Gold: %d%n", gold);
        System.out.format("Equipment:%n");
        for (Map.Entry<String, Integer> x : equipment.entrySet()) {
            System.out.format("%d %s%n", x.getValue(), x.getKey());
        }
    }

    public void addEquipment(String piece, int number) {
        equipment.put(piece, number);
    }
}
