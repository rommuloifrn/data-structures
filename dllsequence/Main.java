package dllsequence;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DLLSequence mySeq = new DLLSequence();
		
		while (true) {
			System.out.printf("1 - first | 2 - last | 3 - before | 4 - after | 5 - replaceElement | 6 - swapElements %n7 - insertBefore | 8 - insertAfter | 9 - insertFirst | 10 - insertLast | 11 - remove%n");
			System.out.println("12 - elemAtRank | 13 - replaceAtRank | 14 - insertAtRank | 15 - removeAtRank");
			mySeq.mePrintaEssaSeqMano();
			
			int response = sc.nextInt();
			
			switch (response) {
				case 1: {
					System.out.println(mySeq.first());
					break;
				}
				case 2: {
					System.out.println(mySeq.last());
					break;
				}
				case 3: {
					System.out.println(mySeq.before(mySeq.getNodeByValue(sc.next())));
					break;
				}
				case 4: {
					System.out.println(mySeq.after(mySeq.getNodeByValue(sc.next())));
					break;
				}
				case 5: {
					mySeq.replaceElement(mySeq.getNodeByValue(sc.next()), sc.next());
					break;
				}
				case 6: {
					mySeq.swapElements(mySeq.getNodeByValue(sc.next()), mySeq.getNodeByValue(sc.next()));
					break;
				}
				case 7: {
					mySeq.insertBefore(mySeq.getNodeByValue(sc.next()), sc.next());
					break;
				}
				case 8: {
					mySeq.insertAfter(mySeq.getNodeByValue(sc.next()), sc.next());
					break;
				}
				case 9: {
					mySeq.insertFirst(sc.next());
					break;
				}
				case 10: {
					mySeq.insertLast(sc.next());
					break;
				}
				case 11: {
					mySeq.remove(mySeq.getNodeByValue(sc.next()));
					break;
				}
				case 12: {
					System.out.printf("no rank: %s%n", mySeq.elemAtRank(sc.nextInt()));
					break;
				}
				case 13: {
					mySeq.replaceAtRank(sc.nextInt(), sc.next());
					break;
				}
				case 14: {
					mySeq.insertAtRank(sc.nextInt(), sc.next());
					break;
				}
				case 15: {
					mySeq.removeAtRank(sc.nextInt());
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