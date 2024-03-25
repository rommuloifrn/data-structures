package alist;

import java.util.Scanner;

import collections.ArrayList;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList myList = new ArrayList();
		
		while (true) {
			System.out.printf("1 - first | 2 - last | 3 - before | 4 - after | 5 - replaceElement |%n 6 - swapElements | 7 - insertBefore | 8 - insertAfter | 9 - insertFirst | 10 - insertLast | 11 - remove%n");
			myList.mePrintaEssaListaMano();
			
			int response = sc.nextInt();
			
			switch (response) {
				case 1: {
					System.out.println(myList.first());
					break;
				}
				case 2: {
					System.out.println(myList.last());
					break;
				}
				case 3: {
					System.out.println(myList.before(myList.getPos(sc.next())));
					break;
				}
				case 4: {
					System.out.println(myList.after(myList.getPos(sc.next())));
					break;
				}
				case 5: {
					myList.replaceElement(myList.getPos(sc.next()), sc.next());
					break;
				}
				case 6: {
					myList.swapElements(myList.getPos(sc.next()), myList.getPos(sc.next()));
					break;
				}
				case 7: {
					myList.insertBefore(myList.getPos(sc.next()), sc.next());
					break;
				}
				case 8: {
					myList.insertAfter(myList.getPos(sc.next()), sc.next());
					break;
				}
				case 9: {
					myList.insertFirst(sc.next());
					break;
				}
				case 10: {
					myList.insertLast(sc.next());
					break;
				}
				case 11: {
					myList.remove(myList.getPos(sc.next()));
					break;
				}
				case 12: {
					System.out.printf("%b%n", (myList.getPos(sc.next()) != null));
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