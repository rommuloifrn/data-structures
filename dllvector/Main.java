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
					
					break;
				}
				case 2: { 
					
					break;
				}
				case 3: {
					
					break;
				}
				case 4: {
					
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