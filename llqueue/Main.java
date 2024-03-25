package llqueue;

import java.util.Scanner;

import queues.LinkedListQueue;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		LinkedListQueue myQueue = new LinkedListQueue();
		
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
