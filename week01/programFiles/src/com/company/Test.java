package com.company;

import java.util.Scanner;

public class Test {

    public static Scanner scanner = new Scanner ( System.in );

    public static void main(String[] args) {

        User user = new User(getNewPassword("Enter your new password: "));

        System.out.format("Password: " + user.getPassword() + "%nSalt: " + user.getSalt() +
                "%nHash: " + user.getHashedPassword() + "%n");

        boolean passwordValid = false;
        do {
            passwordValid = false;
            try {
                NSALoginController.hashUserPassword(user);
                passwordValid = true;
            } catch (WeakPasswordException e) {
                System.out.format(e.getMessage());
                user.setPassword(getNewPassword("Enter a valid password: "));
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.format("passwordValid: " + passwordValid + "%n");
        } while (!passwordValid);

        System.out.format("Password: " + user.getPassword() + "%nSalt: " + user.getSalt() +
                "%nHash: " + user.getHashedPassword() + "%n");

        user.setPassword(getNewPassword("Verify password: "));

        try {
            if (NSALoginController.verifyPassword(user)) {
                System.out.print("Passwords match.");
            } else {
                System.out.print("Passwords do not match.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getNewPassword(String message) {
        System.out.print(message);

        String password = scanner.nextLine();

        return password;
    }
}
