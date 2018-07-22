package algoritmosDeOrdenacao;
import apps.*;

/*classe que trabalha com o insertionsort*/
public class InsertionSort {
	public static void metodoPrincipal() {
		int opcInsertion;
		Menus.menuElementos();
		opcInsertion = Ler.inteiro();
		switch (opcInsertion) {
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

	/*
	 * metodo que calculará a porcentagem, sorteará os valores e preencherá o
	 * vetor
	 */
	public static void sorteio(int nmrElementos) {
		String resposta;
		int porcentagem, percento;
		long inicio, fim;
		//cria o vetor
		Componente[] vetor = new Componente[nmrElementos];

		//preenche o vetor com componentes com chaves aleatorias
		FuncoesAux.PreencherVet(vetor, nmrElementos);

		System.out.println("Escolha a forma de ordenamento: C -Crescente ou D -Decrescente");
		resposta = Ler.linha();
		if (resposta.equals("C") || resposta.equals("c")) {
			System.out.println("Qual a porcentagem vc deseja que esteja ordenada incialmente?");
			// recebe a porcentagem que ja sera ordenada no inicio do vetor
			porcentagem = Ler.inteiro();
			// calcula a porcentagem de ordenação inicial
			percento = (porcentagem * nmrElementos) / 100;
			if(percento ==nmrElementos){
				QuickSort.quickCPivoE(vetor,0,vetor.length-1);
			}else{
				FuncoesAux.QuickAuxCres(vetor, 0, percento-1);
			}

			// para verificar otempo execução
			inicio = System.currentTimeMillis();
			// vetor sera ordenado em ordem crescente
			vetor = InsertionSortC(vetor);
			fim = System.currentTimeMillis();
			System.out.printf("Tempo de processamento InsertionSort: %.3f ms%n\n", (fim - inicio) / 1000d);

		} else if (resposta.equals("D") || resposta.equals("d")) {
			System.out.println("Qual a porcentagem vc deseja que esteja ordenada incialmente?");
			// recebe a porcentagem que ja sera ordenada no inicio do vetor
			porcentagem = Ler.inteiro();
			// calcula a porcentagem de ordenação inicial
			percento = (porcentagem * nmrElementos) / 100;
			// metodo auxliar para ordenar referente a porcentagem
			if(percento ==nmrElementos){
				QuickSort.quickCPivoE(vetor,0,vetor.length-1);
			}else{
				FuncoesAux.QuickAuxDecres(vetor, 0, percento - 1);
			}

			// para verificar o tempo deexecução
			inicio = System.currentTimeMillis();
			// vetor sera ordenado em ordem decrescente
			vetor = InsertionSortD(vetor);
			fim = System.currentTimeMillis();
			System.out.printf("Tempo de processamento InsertionSort: %.3f ms%n\n", (fim - inicio) / 1000d);
		} else {
			System.out.println("comando nn reconhecido");
		}
	}

	// ordena usando o metodo de inserção na ordem crescente
	public static Componente[] InsertionSortC(Componente[] vet) {
		int i, j;
		Componente chave;

		for (j = 1; j < vet.length; j++) {
			chave = vet[j];

			i = j - 1;
			while (i >= 0 && vet[i].getKey() > chave.getKey()) {
				vet[i + 1]= vet[i];
				i--;
			}
			vet[i + 1] = chave;
		}
		return vet;
	}

	// ordena usando o metodo de inserção na ordem decrescente
	public static Componente[] InsertionSortD(Componente[] vet) {
		int i, j;
		Componente chave;

		for (j = 1; j < vet.length; j++) {
			chave = vet[j];

			i = j - 1;
			while (i >= 0 && vet[i].getKey() < chave.getKey()) {
				vet[i + 1] = vet[i];
				i--;
			}
			vet[i + 1] = chave;
		}
		return vet;
	}
}
