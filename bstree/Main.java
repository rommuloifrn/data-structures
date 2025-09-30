package bstree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BSTree tree = new BSTree();

        while (true) {
            System.out.println("Opções\n");
            System.out.println("1: Inserção\n2: Busca\n3: Remoção\n");
            tree.Show();
            System.out.println(String.format("altura: %d", tree.height(tree.root())));
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Digite o elemento a ser adicionado:\n");

                    tree.insert(
                        sc.nextInt()
                    );
                    break;
                case 2:
                    System.out.println("Digite o elemento a ser procurado:\n");
                    BSTNode node = tree.find(sc.nextInt());
                    sc.nextLine();
                    if (node != null) {
                        System.out.print(
                            String.format("elemento: %s, parent: %s, left: %s, right: %s\n",
                            node.getElement(),
                            node.getParent(),
                            node.hasLeftChild(),
                            node.hasRightChild())
                        );
                    } else {
                        System.out.println("é nulo");
                    }
                    break;

                case 3:
                    System.out.println("Digite o elemento a ser removido:\n");
                    tree.remove(sc.nextInt());
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
