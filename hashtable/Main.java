package hashtable;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashTable myTable = new HashTable(true);
		
		while (true) {
			System.out.println("1 - findElement / 2 - insertItem / 3 - removeElement");
			myTable.print();
			
			int response = sc.nextInt();
			
			switch (response) {
			case 1:
				System.out.println(myTable.findElement(sc.nextInt()));
				break;
			
			case 2:
				myTable.insertItem(sc.nextInt());
				break;
				
			case 3:
				myTable.removeElement(sc.nextInt());
				break;
				
			case 00:
				sc.close();
				break;
			}
						
		}

	}

}
