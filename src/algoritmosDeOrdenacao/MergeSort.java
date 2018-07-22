package algoritmosDeOrdenacao;

import apps.Componente;
import apps.FuncoesAux;
import apps.Ler;
import apps.Menus;

public class MergeSort {
	public static void metodoPrincipal() {
		int opcMerge;
		Menus.menuElementos();
		opcMerge = Ler.inteiro();
		switch (opcMerge) {
		case 1:
			sorteio(1000); // chama o metodo sorteio passando a entrda da opc 1
			break;
		case 2:
			sorteio(100000); // chama o metodo sorteio passando a entrda da opc 2
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
		long inicio,fim;
		int porcentagem, percento;
		Componente[] vetor = new Componente[nmrElementos];
		//preenche o vetor com componentes com chaves aleatorias
		FuncoesAux.PreencherVet(vetor, nmrElementos);
		
		System.out.println("Escolha a forma de ordenamento: C -Crescente ou D -Decrescente");
		resposta = Ler.linha();
		
		//testa a forma de ordenamento
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
			
			inicio = System.currentTimeMillis(); // para verificar o tempo de										
			// vetor sera ordenado em ordem crescente
			vetor = MergeSortC(vetor);
			fim = System.currentTimeMillis();
			System.out.printf("Tempo de processamento MergeSort: %.3f ms%n\n", (fim - inicio) / 1000d);

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
			vetor = MergeSortD(vetor);
			fim = System.currentTimeMillis();
			System.out.printf("Tempo de processamento MergeSort: %.3f ms%n\n", (fim - inicio) / 1000d);
		} else {
			System.out.println("comando nn reconhecido");
		}
	}

	// merge sort em ordem crescente
	private static Componente[] MergeSortC(Componente[] a) {
		Componente[] Temp = new Componente[a.length];
		return MergeMainC(a, Temp, 0, a.length - 1);
	}

	private static Componente[] MergeMainC(Componente[] a, Componente[] T, int esq, int dir) {
		int meio;
		if (esq < dir) {
			meio = (esq + dir) / 2;
			MergeMainC(a, T, esq, meio);
			MergeMainC(a, T, meio + 1, dir);
			MergeC(a, T, esq, meio + 1, dir);
		}
		return a;
	}

	private static void MergeC(Componente[] a, Componente[] T, int esqPos, int dirPos, int dirFim) {
		int esqFim = dirPos - 1;
		int tempPos = esqPos;
		int numElem = dirFim - esqPos + 1;

		while (esqPos <= esqFim && dirPos <= dirFim) {
			if (a[esqPos].getKey() <= a[dirPos].getKey()) {
				T[tempPos++] = a[esqPos++];
			} else {
				T[tempPos++] = a[dirPos++];
			}
		}
		while (esqPos <= esqFim)
			T[tempPos++] = a[esqPos++];
		while (dirPos <= dirFim)
			T[tempPos++] = a[dirPos++];

		for (int i = 0; i < numElem; i++) {
			a[dirFim] = T[dirFim];
			dirFim--;
		}
	}

	// merge sort decrescente
	private static Componente[] MergeSortD(Componente[] a) {
		Componente[] Temp = new Componente[a.length];
		return MergeMainD(a, Temp, 0, a.length - 1);
	}

	private static Componente[] MergeMainD(Componente[] a, Componente[] T, int esq, int dir) {
		int meio;
		if (esq < dir) {
			meio = (esq + dir) / 2;
			MergeMainD(a, T, esq, meio);
			MergeMainD(a, T, meio + 1, dir);
			MergeD(a, T, esq, meio + 1, dir);
		}
		return a;
	}

	private static void MergeD(Componente[] a, Componente[] T, int esqPos, int dirPos, int dirFim) {
		int esqFim = dirPos - 1;
		int tempPos = esqPos;
		int numElem = dirFim - esqPos + 1;

		while (esqPos <= esqFim && dirPos <= dirFim) {
			if (a[esqPos].getKey() >= a[dirPos].getKey()) {
				T[tempPos++] = a[esqPos++];
			} else {
				T[tempPos++] = a[dirPos++];
			}
		}
		while (esqPos <= esqFim)
			T[tempPos++] = a[esqPos++];
		while (dirPos <= dirFim)
			T[tempPos++] = a[dirPos++];

		for (int i = 0; i < numElem; i++) {
			a[dirFim] = T[dirFim];
			dirFim--;
		}
	}
}
