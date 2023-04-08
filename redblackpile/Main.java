package redblackpile;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Me dê. Me dê o tamanho dessa pilha:");
		RBPile myPile = new RBPile(sc.nextInt());
		
		while(true) {
			System.out.println("Escolha sua opção:");
			System.out.println("1 - redPush | 2 - redPop | 3 - redTop | 5 - blackPush | 6 - blackPop | 7 - blackTop");
			myPile.mimDaAPilaMano();
			int response = sc.nextInt();
			switch (response) {
			case 1:
				System.out.println("Digite o elemento para o redPush:");
				myPile.redPush(sc.next());
				break;
			case 2:
				myPile.redPop();
				break;
			case 3:
				System.out.println("No topo da pilha vermelha: " + myPile.redTop());
				break;
			case 5:
				System.out.println("Digite o elemento para o blackPush:");
				myPile.blackPush(sc.next());
				break;
			case 6:
				myPile.blackPop();
				break;
			case 7:
				System.out.println("No topo da pilha preta: " + myPile.blackTop());
				break;
			default:
				sc.close();
				break;
			}
			
				
		}
		
		//sc.close();
	}

}
