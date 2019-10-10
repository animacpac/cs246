package com.company;

import java.util.Scanner;

public class Main {

    private static String getFileName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Filename: ");
        String filename = scanner.nextLine();

        return filename;
    }

    public static void main(String[] args) {
        //Initialize player
        Scanner scanner = new Scanner(System.in);
        System.out.print("Player name: ");
        String name = scanner.nextLine();
        System.out.print("Health: ");
        int health = scanner.nextInt();
        System.out.print("Mana: ");
        int mana = scanner.nextInt();
        System.out.print("Gold: ");
        int gold = scanner.nextInt();

        Player player = new Player(name, health, mana, gold);

        // Add some equipment
        player.addEquipment("sword", 3);
        player.addEquipment("rope", 1);
        player.addEquipment("book", 2);
        // Initialize game
        Game game = new Game(player);

        // Save/Load the game
        game.saveGame(getFileName());
        Game newGame = Game.loadGame(getFileName());

        //Check if it all loaded correctly
        System.out.printf("Old player: %n");
        game.getPlayer().display();
        System.out.printf("New player: %n");
        newGame.getPlayer().display();
    }
}
