package gtree;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//DQPile myPile = new DQPile();
		
		while (true) {
			System.out.println("1 - push | 2 - pop | 3 - top");
			//myPile.mimDaAPilaMano();
			
			int response = sc.nextInt();
			
			switch (response) {
				case 1: {
					
					break;
				}
				case 2: {
					
					break;
				}
				case 3: {
					
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
