package org.bildit.homework.may6th;

import java.util.Scanner;

/**
 * @author Goran Arsenic
 */
public class ConsonantsRemoval {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert a word or a sentence: ");

        String str = scanner.nextLine();
        String strUpper = str.toUpperCase();

        for (int i = 0; i < str.length(); i++) {
            char characterUpper = strUpper.charAt(i);
            char character = str.charAt(i);
            if (characterUpper == 'A' || characterUpper == 'E' || characterUpper == 'I' || characterUpper == 'O' ||
                    characterUpper == 'U' || characterUpper == ' ') {

                System.out.print(character);
            }
        }
        scanner.close();
    }
}
