package avector;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AVector myVector = new AVector();
		
		while (true) {
			System.out.println("1 - elemAtRank | 2 - replaceAtRank | 3 - InsertAtRank | 4 - removeAtRank // size, isEmpty");
			myVector.mimDaEssaDiamba();
			
			int response = sc.nextInt();
			
			switch (response) {
				case 1: {
					System.out.println(myVector.elemAtRank(sc.nextInt()));
					break;
				}
				case 2: { 
					myVector.replaceAtRank(sc.nextInt(), sc.next());
					break;
				}
				case 3: {
					myVector.insertAtRank(sc.nextInt(), sc.next());
					break;
				}
				case 4: {
					System.out.printf("removido %s%n", myVector.removeAtRank(sc.nextInt()));
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