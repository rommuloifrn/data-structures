package dllvector;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DLLVector myVector = new DLLVector();
		
		while (true) {
			System.out.println("1 - elemAtRank | 2 - replaceAtRank | 3 - InsertAtRank | 4 - removeAtRank // size, isEmpty");
			myVector.mimDaOVectorMano();
			
			int response = sc.nextInt();
			
			switch (response) {
				case 1: {
					int x = sc.nextInt();
					System.out.printf("no rank x: %s%n", myVector.elemAtRank(x));
					
					break;
				}
				case 2: {
					System.out.printf("substituído: %s%n", myVector.replaceAtRank(sc.nextInt(), sc.next()));
					break;
				}
				case 3: {
					myVector.insertAtRank(sc.nextInt(), sc.next());
					break;
				}
				case 4: {
					System.out.printf("removido: %s%n", myVector.removeAtRank(sc.nextInt()));
					break;
				}
				case 0: {
					sc.close();
					break;
				}
				
			}
		}
		
		
		//sc.close();
	}

}