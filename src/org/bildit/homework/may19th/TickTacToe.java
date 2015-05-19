package org.bildit.homework.may19th;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Ognjen Lazic
 */
public class TickTacToe {

    public static String[] tick = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
    public static String whoWon = null;
    public static int inputs = 0;
    public static boolean result = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int consoleInput = 0;
        boolean inputIsOk;

        do {
            drawGrid();
            System.out.print("Choose field: ");
            do {
                try {
                    consoleInput = scanner.nextInt();
                    if (consoleInput > 9 || consoleInput <= 0) {
                        System.out.println("Imposible position");
                        System.out.print("Try again: ");
                        inputIsOk = false;
                    } else {
                        inputs++;
                        inputIsOk = true;
                    }
                } catch (InputMismatchException exception) {
                    System.out.println("Use numbers only!");
                    scanner.nextLine();
                    inputIsOk = false;
                }
            } while (!inputIsOk);
            if (isTaken(consoleInput)) {
                if (inputs % 2 == 0) {
                    tick[consoleInput - 1] = "o";
                } else if (isTaken(consoleInput)) {
                    tick[consoleInput - 1] = "x";
                }
            } else {
                inputs--;
                System.out.println("That place is taken, try another one!");
            }

        } while (!gameOver());
        System.out.println("---------------------------");
        System.out.println("Game is over");
        System.out.println("---------------------------");
        if (!(whoWon.equals("I'ts a tie!"))) {
            System.out.println("Player: "
                    + whoWon.substring(0, whoWon.length() - 2)+" won!");
        } else {
            System.out.println(whoWon);
        }
        drawGrid();
        scanner.close();
    }

    public static boolean isTaken(int n) {

        return (!("x".equals(tick[n - 1]) || "o".equals(tick[n - 1])));

    }

    public static boolean gameOver() {
        for (int i = 0, a = 0; i < 9; i = i + 3, a++) {

            if (wonDiagonal("xxx") || wonDiagonal("ooo")) {
                break;
            } else if (wonHorizontalOrVertical("xxx", i, a)
                    || wonHorizontalOrVertical("ooo", i, a)) {
                break;
            } else if (inputs > 8) {
                whoWon = "It's a tie!";
                result = true;
            }
        }
        return result;
    }

    public static void drawGrid() {
        System.out.println("---------------------------");
        System.out.println("[" + tick[0] + "]" + "[" + tick[1] + "]" + "["
                + tick[2] + "]");
        System.out.println("[" + tick[3] + "]" + "[" + tick[4] + "]" + "["
                + tick[5] + "]");
        System.out.println("[" + tick[6] + "]" + "[" + tick[7] + "]" + "["
                + tick[8] + "]");
        System.out.println("---------------------------");
    }

    public static boolean wonDiagonal(String player) {

        if (player.equals(String.valueOf(tick[0] + tick[4] + tick[8]))
                || player.equals(String.valueOf(tick[2] + tick[4] + tick[6]))) {
            whoWon = player;
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public static boolean wonHorizontalOrVertical(String player, int i, int a) {
        if (player.equals(String.valueOf(tick[i] + tick[i + 1] + tick[i + 2]))
                || player.equals(String.valueOf(tick[a] + tick[a + 3]
                + tick[a + 6]))) {
            whoWon = player;
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}