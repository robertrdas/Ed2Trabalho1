package algoritmosDeOrdenacao;

import apps.*;

public class HeapSort {
	public static void metodoPrincipal() {
		int opcHeap;
		Menus.menuElementos();
		opcHeap = Ler.inteiro();
		switch (opcHeap) {
		case 1:
			sorteio(1000); // chama o metodo sorteio passando a entrda da opc 1
			break;
		case 2:
			sorteio(100000);  // chama o metodo sorteio passando a entrda da opc 2
			break;
		case 3:
			sorteio(1000000); // chama o metodo sorteio passando a entrda da opc 3
			break;
		default:
			System.out.println("Opcao invalida!");
			break;
		}
	}

	private static void sorteio(int nmrElementos) {
		String resposta;
		long inicio, fim;
		int porcentagem, percento;
		Componente[] vetor = new Componente[nmrElementos];

		// preenche o vetor com componentes com chaves aleatorias
		FuncoesAux.PreencherVet(vetor, nmrElementos);

		System.out.println("Escolha a forma de ordenamento: C -Crescente ou D -Decrescente");
		resposta = Ler.linha();
		
		// testa forma de ordenamento
		if (resposta.equals("C") || resposta.equals("c")) {

			System.out.println("Qual a porcentagem vc deseja que esteja ordenada incialmente?");
			// recebe a porcentagem que ja sera ordenada no inicio do vetor
			porcentagem = Ler.inteiro();
			percento = (porcentagem * nmrElementos) / 100;
			if(percento ==nmrElementos){
				QuickSort.quickCPivoE(vetor,0,vetor.length-1);
			}else{
				FuncoesAux.QuickAuxCres(vetor, 0, percento-1);
			}

			inicio = System.currentTimeMillis();
			// vetor sera ordenado em ordem crescente
			HeapC(vetor);
			fim = System.currentTimeMillis();
			System.out.printf("Tempo de processamento HeapSort: %.3f ms%n\n", (fim - inicio) / 1000d);

		} else if (resposta.equals("D") || resposta.equals("d")) {

			System.out.println("Qual a porcentagem vc deseja que esteja ordenada incialmente?");
			// recebe a porcentagem que ja sera ordenada no inicio do vetor
			porcentagem = Ler.inteiro();
			percento = (porcentagem * nmrElementos) / 100;
			// metodo auxliar para ordenar referente a porcentagem
			if(percento ==nmrElementos){
				QuickSort.quickCPivoE(vetor,0,vetor.length-1);
			}else{
				FuncoesAux.QuickAuxDecres(vetor, 0, percento - 1);
			}

			// para verificar o tempo execução
			inicio = System.currentTimeMillis();
			// vetor sera ordenado em ordem decrescente
			 HeapD(vetor);
			fim = System.currentTimeMillis();
			System.out.printf("Tempo de processamento HeapSort: %.3f ms%n\n", (fim - inicio) / 1000d);
		} else {
			System.out.println("comando nn reconhecido");
		}
	}

	/* heapSort em ordem crescente */
	static void HeapC(Componente a[]) {
		ConstroiHeap(a);
		for (int i = a.length - 1; i >= 1; i--) {
			Componente temp = a[0];
			a[0] = a[i];
			a[i]= temp;
			heapify(a, i, 0);
		}
	}

	static void heapify(Componente a[], int n, int i) {
		int max, child;
		child = 2 * i + 1;
		max = i;
		if (child < n)
			if (a[child].getKey() > a[max].getKey())
				max = child;
		if (child + 1 < n)
			if (a[child + 1].getKey() > a[max].getKey())
				max = child + 1;
		if (max != i) {
			Componente temp = a[i];
			a[i] = a[max];
			a[max] = temp;
			heapify(a, n, max);
		}
	}

	static void ConstroiHeap(Componente a[]) {
		for (int i = a.length / 2 - 1; i >= 0; i--)
			heapify(a, a.length, i);
	}

	/* heapSort em ordem decrescente */
	static void HeapD(Componente a[]) {
		ConstroiHeap(a);
		for (int i = a.length - 1; i >= 1; i--) {
			Componente temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			heapify(a, i, 0);
		}
	}

	static void heapify1(Componente a[], int n, int i) {
		int max, child;
		child = 2 * i + 1;
		max = i;
		if (child < n)
			if (a[child].getKey() < a[max].getKey())
				max = child;
		if (child + 1 < n)
			if (a[child + 1].getKey() < a[max].getKey())
				max = child + 1;
		if (max != i) {
			Componente temp = a[i];
			a[i] = a[max];
			a[max] = temp;
			heapify(a, n, max);
		}
	}

	static void ConstroiHeap1(Componente a[]) {
		for (int i = a.length / 2 - 1; i >= 0; i--)
			heapify(a, a.length, i);
	}

}
