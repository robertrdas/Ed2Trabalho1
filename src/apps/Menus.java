package apps;

/*Classe de menus*/

public class Menus {
	//menu principal
	public static void menu(){
        System.out.println("\tEscolha o algoritmo de ordenacao:");
        System.out.println("1. SelectionSort");
        System.out.println("2. InserctionSort");
        System.out.println("3. QuickSort");
        System.out.println("4. HeapSort");
        System.out.println("5. MergeSort");
        System.out.println("6. ContingSort");
        System.out.println("0. Sair");
        System.out.println("Opcao:");
    }
	//menu para escolha do numero de elementos
	public static void menuElementos(){
        System.out.println("\tEscolha o tamanho do vetor");
        System.out.println("1. 1.000 elementos");
        System.out.println("2. 100.000 elementos");
        System.out.println("3. 1.000.000 elementos");
        System.out.println("0. Abortar");
        System.out.println("Opcao:");
    }
	// menu para escolha do pivô do metodo Quicksort
	public static void menuPivo(){
		System.out.println("\tEscolha a posicao do pivo");
		System.out.println("1. Elemento mais a esquerda");
		System.out.println("2. Elemento mais a direita");
		System.out.println("3. Elemento mediano");
		System.out.println("0. Abortar");
	}
}
