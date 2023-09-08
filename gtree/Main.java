package gtree;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		GTree myTree = new GTree();
		
		while (true) {
			System.out.println("-------------------------------------");
			System.out.println("1 - add | 2 -  | 3 - parent | 4 - printElements | 5 - isInternal | 6 - depth");
			myTree.printaEssaTree();
			
			int response = sc.nextInt();
			
			switch (response) {
				case 1: {
					if ( myTree.isEmpty() )
						myTree.addRoot(sc.next());
					else
						myTree.add(myTree.getNodeByString(myTree.root(), sc.next()), sc.next());
					break;
				}
				case 2: {
					
					break;
				}
				case 3: {
					GTNode node = myTree.getNodeByString(myTree.root(), sc.next());
					System.out.printf("%s\n", myTree.parent(node).getValue());
					break;
				}
				case 4: {
					myTree.printElements();
					break;
				}
				case 5: {
					System.out.println(myTree.isInternal(myTree.getNodeByString(myTree.root(), sc.next())));
					break;
				}
				case 6: {
					System.out.println(myTree.height(myTree.getNodeByString(myTree.root(), sc.next())));
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
