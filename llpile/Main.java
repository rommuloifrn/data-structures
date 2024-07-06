package llpile;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Pile myPile = new Pile();
		
		while (true) {
			System.out.println("1 - push | 2 - pop ");
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
				case 0: {
					sc.close();
					break;
				}
			}
		}
	}

}
