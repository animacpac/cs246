package com.company;

public class ListItem {
    private String name;
    private int quantity;
    private float price;
    private String store;

    ListItem() {

    }

    ListItem(String name, int quantity, float price/*, String store*/) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        //this.store = store;
    }

    ListItem(ListItem rhs) {
        this.name = rhs.name;
        this.price = rhs.price;
        this.quantity = rhs.quantity;
        this.store = rhs.store;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getBasePrice() {
        return price;
    }

    public float getTotalPrice() {
        return price * quantity;
    }

    public String getStore() {
        return store;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setStore(String store) {
        this.store = store;
    }
}
