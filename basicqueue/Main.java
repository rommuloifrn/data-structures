package basicqueue;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Me dê o tamanho, o tamanho dessa pilha:");
		Queue myQueue = new Queue(sc.nextInt());
		
		while (true) {
			System.out.println("1 - enqueue | 2 - dequeue | 3 - first");
			myQueue.mimDaAQueueMano();
			
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
			}
		}
		
		
		//sc.close();
	}

}
