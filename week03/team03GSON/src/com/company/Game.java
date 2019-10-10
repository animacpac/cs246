package com.company;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Game {
    private Player player;

    Game(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void saveGame(String filename) {
        Gson g = new Gson();
        String gPlayer = g.toJson(player);

        try {
            File save = new File(filename);
            if (save.createNewFile()) {
                System.out.printf("Created new file.%n");
            }

            FileWriter writer = new FileWriter(filename);
            writer.write(gPlayer);
            writer.close();
            System.out.printf("File saved.%n");

        } catch (IOException e) {
            System.out.printf("Something went wrong...%n");
            e.printStackTrace();
        }
    }

    public static Game loadGame(String filename) {
        File load = new File(filename);
        StringBuilder json = new StringBuilder();
        try {
            Scanner read = new Scanner(load);
            while (read.hasNextLine()) {
                json.append(read.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Gson g = new Gson();
        Player player = g.fromJson(json.toString(), Player.class);
        Game game = new Game(player);

        return game;
    }
}
