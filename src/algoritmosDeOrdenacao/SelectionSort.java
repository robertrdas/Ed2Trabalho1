package algoritmosDeOrdenacao;

import apps.*;

/*Classe que faz todas as operações refrentes ao selectionsort*/

public class SelectionSort {
	public static void metodoPrincipal() {
		int opcSelection; // variavel para salvar a escolha do menu
		Menus.menuElementos();
		opcSelection = Ler.inteiro();
		switch (opcSelection) {
		case 1:
			// chama o metodo que sorteara e preenchera o vetor
			sorteio(1000);
			break;
		case 2:
			// chama o metodo que sorteara e preenchera o vetor
			sorteio(100000);
			break;
		case 3:
			// chama o metodo que sorteara e preenchera o vetor
			sorteio(1000000);
			break;
		default:
			System.out.println("Opção inválida.");
			break;
		}
	}

	
	 //metodo que calculará a porcentagem, sorteará os valores e preencherá o  vetor
	 
	public static void sorteio(int nmrElementos) {
		String resposta;
		int porcentagem, percento;
		long inicio, fim;
		Componente[] vetor = new Componente[nmrElementos];

		// preenche o vetor com componentes com chaves aleatorias
		FuncoesAux.PreencherVet(vetor, nmrElementos);
		
		//distingue a forma de ordenção
		System.out.println("Escolha a forma de ordenamento: C -Crescente ou D -Decrescente");
		resposta = Ler.linha();
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

			// para verificar o tempo de execução
			inicio = System.currentTimeMillis();
			// vetor sera ordenado em ordem crescente
			vetor = SelectionSortC(vetor);
			fim = System.currentTimeMillis();
			System.out.printf("Tempo de processamento SelectionSort: %.3f ms%n\n", (fim - inicio) / 1000d);

		} else if (resposta.equals("D") || resposta.equals("d")) {
			System.out.println("Qual a porcentagem vc deseja que esteja ordenada incialmente?");
			// recebe a porcentagem que ja sera ordenada no inicio do vetor
			porcentagem = Ler.inteiro();
			percento = (porcentagem * nmrElementos) / 100;
			//função de ordenamento parcial
			if(percento ==nmrElementos){
				QuickSort.quickCPivoE(vetor,0,vetor.length-1);
			}else{
				FuncoesAux.QuickAuxDecres(vetor, 0, percento - 1);
			}

			// Para verificar o tempo de execução
			inicio = System.currentTimeMillis();
			// vetor sera ordenado em ordem decrescente
			vetor = SelectionSortD(vetor);
			fim = System.currentTimeMillis();
			System.out.printf("Tempo de processamento SelectionSort: %.3f ms%n\n", (fim - inicio) / 1000d);
		} else {
			System.out.println("comando nn reconhecido");
		}
	}

	// metodo de ordenação em ordem crescente
	public static Componente[] SelectionSortC(Componente[] vet) {

		for (int i = 0; i < vet.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < vet.length; j++) {
				if (vet[j].getKey() < vet[min].getKey()) {
					min = j;
				}
			}
			Componente temp = vet[min];
			vet[min] = vet[i];
			vet[i] = temp;
		}
		return vet;
	}

	// metodo de ordenação em ordem decrescente
	public static Componente[] SelectionSortD(Componente[] vet) {

		for (int i = 0; i < vet.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < vet.length; j++) {
				if (vet[j].getKey() > vet[min].getKey()) {
					min = j;
				}
			}
			Componente temp = vet[min];
			vet[min] = vet[i];
			vet[i] = temp;
		}
		return vet;
	}

}
