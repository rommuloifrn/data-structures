package gtree;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		GTree myTree = new GTree();
		
		while (true) {
			System.out.println("1 - add | 2 -  | 3 - ");
			myTree.preOrder(myTree.getRoot(), 0);
			
			int response = sc.nextInt();
			
			switch (response) {
				case 1: {
					myTree.add(myTree.getNodeByString(myTree.getRoot(), sc.next()), sc.next());
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
