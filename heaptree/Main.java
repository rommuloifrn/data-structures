package heaptree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HeapTree tree = new HeapTree();

        while (true) {
            System.out.println("Opções\n");
            tree.Show();
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Digite o elemento a ser adicionado:\n");

                    tree.insert(
                        sc.nextInt()
                    );


                    break;

                case 0:
                    sc.close();
                    break;

                default:
                    break;
            }
        }
    }
}
