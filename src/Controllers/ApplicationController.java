package Controllers;

import client.Client;

import java.util.Scanner;

public class ApplicationController {
    Scanner in;
    Client user;
    public void startApp() {
        in = new Scanner(System.in);
        System.out.println("=========================================================================");
        System.out.println("Hello! Welcome to our console shop app!");
        account();
    }

    private void account() {
        System.out.println("=========================================================================");
        System.out.println("Please, choose an action:");
        System.out.println("1. Log in");
        System.out.println("2. Log on (not available");
        System.out.println("0. Close app");

        int input = in.nextInt();

        if(input == 0) {
            exit();
            account();
        }
        if(input == 1) {
            register();
        }
        else if(input == 2) {
            System.out.println("Sorry, this function not available yet");
            account();
        }
        else {
            System.out.println("Sorry, try again");
            account();
        }
    }

    private void register() {
        System.out.println("=========================================================================");
        System.out.println("Register page");
        System.out.println("0. Back");
        System.out.println("Write your email:");
        String input = in.next();
        if(input.equals("0")) {
            account();
            return;
        }
        String email = input;
        System.out.println("=========================================================================");
        System.out.println("0. Back");
        System.out.println("1. Skip");
        System.out.println("Write your name:");
        input = in.next();
        if(input.equals("0")) {
            account();
            return;
        }
        if(input.equals("1")) {
            user = new Client(email);
        }
        else {
            user = new Client(input, email);
        }
        System.out.println(user.getName() + " account with email " + user.getEmail() + " created");
        mainMenu();
    }

    private void mainMenu() {
        System.out.println("=========================================================================");
        System.out.println("0. Close app");
        System.out.println("1. Log out");
        System.out.println("2. ");

        int input = in.nextInt();

        if(input == 0) {
            exit();
            mainMenu();
        }
        if(input == 1) {
            logOut();
            mainMenu();
        }
        System.out.println("Try again");
        mainMenu();
    }

    private void exit() {
        System.out.println("=========================================================================");
        System.out.println("Are you sure you want to close app?");
        System.out.println("0. Yes");
        System.out.println("1. No");

        int input = in.nextInt();

        if(input == 0) {
            System.exit(0);
        }
        if(input == 1) {
            return;
        }
        System.out.println("Try again");
        exit();
    }

    private void logOut() {
        System.out.println("=========================================================================");
        System.out.println("Are you sure that you want to log out?");
        System.out.println("0. Yes");
        System.out.println("1. No");

        int input = in.nextInt();

        if(input == 0) {
            user = null;
            account();
        }
        if(input == 1) {
            return;
        }
        System.out.println("Try again");
        logOut();
    }
}
