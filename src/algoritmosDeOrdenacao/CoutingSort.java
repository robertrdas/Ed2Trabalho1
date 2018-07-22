package algoritmosDeOrdenacao;

import apps.*;
/*classe que trabalha com o metodo countingsort*/

public class CoutingSort {
	public static void metodoPrincipal() {
		int opcCount;
		Menus.menuElementos();
		opcCount = Ler.inteiro();
		switch (opcCount) {
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
		int porcentagem, percento,maior;
		Componente[] vetor = new Componente[nmrElementos];

		// preenche o vetor com componentes com chaves aleatorias
		FuncoesAux.PreencherVet(vetor, nmrElementos);
		maior = FuncoesAux.descobreMaior(vetor);

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
			countingC(vetor,maior);
			fim = System.currentTimeMillis();
			System.out.printf("Tempo de processamento CountingSort: %.3f ms%n\n", (fim - inicio) / 1000d);
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
			countingD(vetor,maior);
			fim = System.currentTimeMillis();
			System.out.printf("Tempo de processamento CountingSort: %.3f ms%n\n", (fim - inicio) / 1000d);
		} else {
			System.out.println("comando nn reconhecido");
		}
	}

	public static void countingC(Componente[] A, int maior) {
		int[] aux = new int[maior + 1];
		// preenche aux com zeros (java já faz isso automaticamente)
		Componente[] resp = new Componente[A.length];
		
		for (int i = 0; i < A.length; i++) {
			aux[A[i].getKey()]++;
		}

		for (int i = 1; i < aux.length; i++) {
			aux[i] += aux[i - 1];
		}

		for (int i = A.length - 1; i >= 0; i--) {
			resp[aux[A[i].getKey()]-1]= A[i];
			aux[A[i].getKey()]--;
		}
		for (int i = 0; i < A.length; i++) {
			A[i] = resp[i];
		}
	}
	/*countingsort em ordem decrescente*/
	public static void countingD(Componente[] A, int maior) {
		int[] aux = new int[maior + 1];
		Componente[] resp = new Componente[A.length];
		// preenche aux com zeros (java já faz isso automaticamente)
		for (int i = 0; i < A.length; i++) {
			aux[A[i].getKey()]++;
		}

		for (int i = aux.length -2; i >=0; i--) {
			aux[i] += aux[i + 1];
			
		}
		

		for (int i = A.length - 1; i >= 0; i--) {
			//resp[aux[A[i]] - 1] = A[i];
			resp[aux[A[i].getKey()]-1]= A[i];
			//aux[A[i]]--;
			aux[A[i].getKey()]--;
		}
		for (int i = 0; i < A.length; i++) {
			A[i] = resp[i];
		}
	}

}
