package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static String[][] board = new String[4][4];
    public static String[][] cards = new String[4][4];
    public static Scanner scanner;

    public Main() {
    }

    public static void printBoard() {
        for(int i = 0; i < 4; ++i) {
            System.out.print("|");

            for(int j = 0; j < 4; ++j) {
                System.out.print(board[i][j]);
                System.out.print("|");
            }

            System.out.println();
        }

    }

    public static void shuffleCards() {
        Random random = new Random();
        ArrayList<String> sortingOptions = new ArrayList();
        sortingOptions.add("Gryffindor");
        sortingOptions.add("Ravenclaw");
        sortingOptions.add("Hufflepuff");
        sortingOptions.add("Slytherin");
        sortingOptions.add("Gryffindor");
        sortingOptions.add("Ravenclaw");
        sortingOptions.add("Hufflepuff");
        sortingOptions.add("Slytherin");
        sortingOptions.add("Gryffindor");
        sortingOptions.add("Ravenclaw");
        sortingOptions.add("Hufflepuff");
        sortingOptions.add("Slytherin");
        sortingOptions.add("Gryffindor");
        sortingOptions.add("Ravenclaw");
        sortingOptions.add("Hufflepuff");
        sortingOptions.add("Slytherin");

        for(int i = 0; i < 4; ++i) {
            for(int j = 0; j < 4; ++j) {
                int index = random.nextInt(sortingOptions.size());
                cards[i][j] = (String)sortingOptions.get(index);
                sortingOptions.remove(index);
            }
        }

    }

    public static void checkInput(String[][] cards) {
        while(!avadacadvra()) {
            System.out.println("Row: (1-4)");
            int row1 = scanner.nextInt();
            System.out.println("Column: (1-4)");
            int column1 = scanner.nextInt();
            if (!board[row1 - 1][column1 - 1].equals(" _ ")) {
                System.out.println("Already sorted!!");
                System.out.println();
                printBoard();
            } else {
                board[row1 - 1][column1 - 1] = " " + cards[row1 - 1][column1 - 1] + " ";
                printBoard();
                System.out.println("Row: (1-4)");
                int row2 = scanner.nextInt();
                System.out.println("Column: (1-4)");
                int column2 = scanner.nextInt();
                if (!board[row2 - 1][column2 - 1].equals(" _ ")) {
                    System.out.println("Already sorted!!");
                    board[row1 - 1][column1 - 1] = " _ ";
                    System.out.println();
                    printBoard();
                } else {
                    board[row2 - 1][column2 - 1] = " " + cards[row2 - 1][column2 - 1] + " ";
                    if (board[row1 - 1][column1 - 1].equals(board[row2 - 1][column2 - 1])) {
                        printBoard();
                        System.out.println("Splendid!!");
                    } else {
                        printBoard();
                        System.out.println("Sorry no...");
                        board[row1 - 1][column1 - 1] = " _ ";
                        board[row2 - 1][column2 - 1] = " _ ";
                        printBoard();
                    }
                }
            }
        }

        System.out.println("Avadakadavra!!!");
    }

    public static boolean avadacadvra() {
        for(int i = 0; i < 4; ++i) {
            for(int j = 0; j < 4; ++j) {
                if (board[i][j].equals(" _ ")) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        while(true) {
            System.out.println("Press n to begin your new adventure, q to quit.");
            String nq = scanner.nextLine();
            if (nq.equals("q")) {
                System.out.println("See you next school year!!");
            } else {
                if (nq.equals("n")) {
                    shuffleCards();

                    for(int i = 0; i < 4; ++i) {
                        for(int j = 0; j < 4; ++j) {
                            board[i][j] = " _ ";
                        }
                    }

                    printBoard();
                    checkInput(cards);
                    return;
                }

                System.out.println("Invalid option selected!");
            }
        }
    }

    static {
        scanner = new Scanner(System.in);
    }
}
