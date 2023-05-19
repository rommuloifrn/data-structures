package dpqueue;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DPQueue myQueue = new DPQueue();
		
		while (true) {
			System.out.println("1 - enqueue | 2 - dequeue | 3 - first");
			myQueue.mimDaAFilaMano();
			
			int response = sc.nextInt();
			
			switch (response) {
				case 1: {
					myQueue.enqueue(sc.next());
					break;
				}
				case 2: {
					myQueue.dequeue();
					break;
				}
				case 3: {
					System.out.println("FIRST: " + myQueue.first());
					break;
				}
				case 4: {
					System.out.println(myQueue.size());
				}
				case 0: {
					sc.close();
					break;
				}
			}
		}
	}

}