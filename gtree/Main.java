package gtree;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		GTree myTree = new GTree();
		
		while (true) {
			System.out.println("-------------------------------------");
			System.out.println("1 - add | 2 -  | 3 - | 4 - printElements");
			myTree.printaEssaTree();
			
			int response = sc.nextInt();
			
			switch (response) {
				case 1: {
					if ( myTree.isEmpty() )
						myTree.addRoot(sc.next());
					else
						myTree.add(myTree.getNodeByString(myTree.getRoot(), sc.next()), sc.next());
					break;
				}
				case 2: {
					
					break;
				}
				case 3: {
					
					break;
				}
				case 4: {
					myTree.printElements();
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
