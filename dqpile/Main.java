package dqpile;

import java.util.Scanner;

import piles.DoubleQueuePile;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DoubleQueuePile myPile = new DoubleQueuePile();
		
		while (true) {
			System.out.println("1 - push | 2 - pop | 3 - top");
			myPile.mimDaAPilaMano();
			
			int response = sc.nextInt();
			
			switch (response) {
				case 1: {
					myPile.push(sc.next());
					break;
				}
				case 2: {
					myPile.pop();
					break;
				}
				case 3: {
					System.out.println("top: " + myPile.top());
					break;
				}
				case 0: {
					sc.close();
					break;
				}
			}
		}
	}

}
