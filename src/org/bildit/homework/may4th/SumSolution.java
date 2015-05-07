package org.bildit.homework.may4th;

import java.util.Scanner;
/**
 * @author Branislav Lazic*
 */
public class SumSolution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;

		for (int i = 0; i < 10; i++) {
			System.out.println("Insert a number:");
			int num = sc.nextInt();
			sum += num;
			System.out.println("Sum:" + sum);
		}
		sc.close();
	}
}
