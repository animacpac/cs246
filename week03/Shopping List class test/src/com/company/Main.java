package com.company;

import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    System.out.printf("Enter your choice: %n   " +
                "1. Create a list of items %n   " +
                "2. Test sortByBasePrice %n   " +
                "3. Test sortByTotalPrice %n   " +
                "4. Test sortByName %n>>");
        Scanner scanner = new Scanner(System.in);

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                createList();
                break;
            case 2:
                sortPrice();
                break;
            case 3:
                sortTotal();
                break;
            case 4:
                sortName();
                break;
            default:
        }
    }

    private static void sortName() {
        ShoppingList list = generateList();

        System.out.println("Unsorted list:");
        list.displayList();

        list.sortListByName();

        System.out.println("Sorted by name:");
        list.displayList();
    }

    private static void sortTotal() {
        ShoppingList list = generateList();

        System.out.println("Unsorted list:");
        list.displayList();

        list.sortListByTotalPrice();

        System.out.println("Sorted by total:");
        list.displayList();
    }

    private static void sortPrice() {
        ShoppingList list = generateList();

        System.out.println("Unsorted list:");
        list.displayList();

        list.sortListByBasePrice();

        System.out.println("Sorted by price:");
        list.displayList();
    }

    private static void createList() {
        ShoppingList list = new ShoppingList();
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many items? ");
        int numItems = scanner.nextInt();

        for (int i = 0; i < numItems; i++) {
            //Clear the buffer
            scanner.nextLine();
            // Get the name
            ListItem item = new ListItem();
            System.out.printf("Name: ");
            item.setName(scanner.nextLine());
            // Get the quantity
            System.out.print("Quantity: ");
            item.setQuantity(scanner.nextInt());
            // Get the price
            System.out.print("Price: ");
            item.setPrice(scanner.nextFloat());
            // Add the item to the list
            list.addItem(item);
        }

        list.displayList();
    }

    private static ShoppingList generateList() {
        ListItem item1 = new ListItem("Cheese", 4, (float)2.99);
        ListItem item2 = new ListItem("Bologna", 9, (float)5.46);
        ListItem item3 = new ListItem("Bread", 2, (float)5.47);
        ListItem item4 = new ListItem("Milk", 3, (float)2.99);
        ListItem item5 = new ListItem("Milk", 5, (float)2.99);

        ShoppingList list = new ShoppingList();

        list.addItem(item1);
        list.addItem(item2);
        list.addItem(item3);
        list.addItem(item4);
        list.addItem(item5);

        return list;
    }
}
