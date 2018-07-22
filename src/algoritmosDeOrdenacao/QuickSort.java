package algoritmosDeOrdenacao;
import apps.*;

/* classe que trabalha com o quicksort*/

public class QuickSort {
	public static void metodoPrincipal() {
		int opcPivo, opcElm;
		Menus.menuPivo();
		opcPivo = Ler.inteiro();
		switch (opcPivo) {
		// primeiro elemento a esquerda
		case 1:
			Menus.menuElementos();
			opcElm = Ler.inteiro();
			switch (opcElm) {
			case 1:
				sorteio(1000, 1); 
				break;
			case 2:
				sorteio(100000, 1);
				break;
			case 3:
				sorteio(1000000, 1);
				break;
			default:
				System.out.println("Opcao invalida!");
				break;
			}
			break;
		// pivo como ultimo elemento a direita
		case 2:
			Menus.menuElementos();
			opcElm = Ler.inteiro();
			switch (opcElm) {
			case 1:
				sorteio(1000, 2);
				break;
			case 2:
				sorteio(100000, 2);
				break;
			case 3:
				sorteio(1000000, 2);
				break;
			case 0:
				System.out.println("execução abortada");
				break;
			default:
				System.out.println("Opcao invalida!");
				break;
			}
			break;
		// pivo como elemento mediano
		case 3:
			Menus.menuElementos();
			opcElm = Ler.inteiro();
			switch (opcElm) {
			case 1:
				sorteio(1000, 3);
				break;
			case 2:
				sorteio(100000, 3);
				break;
			case 3:
				sorteio(1000000, 3);
				break;
			default:
				System.out.println("Opcao invalida!");
				break;
			}
			break;
		default:
			System.out.println("Opcao invalida");
		}
	}

	public static void sorteio(int nmrElementos, int escPivo) {
		String resposta;
		long inicio, fim;
		int porcentagem, percento;
		// cria o vetor
		Componente[] vetor = new Componente[nmrElementos];

		// preenche o vetor com componentes com chaves aleatorias
		vetor = FuncoesAux.PreencherVet(vetor, nmrElementos);

		System.out.println("Escolha a forma de ordenamento: C -Crescente ou D -Decrescente");
		resposta = Ler.linha();
		if (resposta.equals("C") || resposta.equals("c")) {
			System.out.println("Qual a porcentagem vc deseja que esteja ordenada incialmente?");
			// recebe a porcentagem que ja sera ordenada no inicio do vetor
			porcentagem = Ler.inteiro();
			percento = (porcentagem * nmrElementos) / 100;
			
			//FuncoesAux.QuickAuxCres(vetor, 0, percento - 1);
			if(percento ==nmrElementos){
				quickCPivoE(vetor,0,vetor.length-1);
			}else{
				FuncoesAux.QuickAuxCres(vetor, 0, percento-1);
			}
				
			
			if (escPivo == 1) {
				/*
				 * ordenação em ordem crescente e pivo como o primeiro da
				 * esquerda
				 */
				// auxilia o calculo do tempo de execuçãao do metodo
				inicio = System.currentTimeMillis();
				// vetor sera ordenado em ordem crescente
				quickCPivoE(vetor, 0, vetor.length - 1);
				fim = System.currentTimeMillis();
				System.out.printf("QuickSort tempo de processamento: %.3f ms%n\n", (fim - inicio) / 1000d);
			} else if (escPivo == 2) {
				// ordenação crescente e pivo como o ultimo da direita
				// auxilia o calculo do tempo de execuçãao do metodo
				inicio = System.currentTimeMillis();
				// vetor sera ordenado em ordem crescente
				quickCPivoD(vetor, 0, vetor.length - 1);
				fim = System.currentTimeMillis();
				System.out.printf("QuickSort tempo de processamento: %.3f ms%n", (fim - inicio) / 1000d);
			} else if (escPivo == 3) {
				inicio = System.currentTimeMillis();
				// vetor sera ordenado em ordem decrescente
				quickCPivoM(vetor);
				fim = System.currentTimeMillis();
				System.out.printf("QuickSort tempo de processamento: %.3f ms%n", (fim - inicio) / 1000d);
			}

		} else if (resposta.equals("D") || resposta.equals("d")) {
			System.out.println("Qual a porcentagem vc deseja que esteja ordenada incialmente?");
			// recebe a porcentagem que ja sera ordenada no inicio do vetor
			porcentagem = Ler.inteiro();
			percento = (porcentagem * nmrElementos) / 100;
			if(percento ==nmrElementos){
				QuickSort.quickCPivoE(vetor,0,vetor.length-1);
			}else{
				FuncoesAux.QuickAuxDecres(vetor, 0, percento - 1);
			}

			if (escPivo == 1) {
				// ordenação em ordem decrescente e pivo como o primeiro da
				// esquerda
				// auxilia o calculo do tempo de execuçãao do metodo
				inicio = System.currentTimeMillis();
				// vetor sera ordenado em ordem decrescente
				quickDPivoE(vetor, 0, vetor.length - 1);
				fim = System.currentTimeMillis();
				System.out.printf("QuickSort tempo de processamento: %.3f ms%n", (fim - inicio) / 1000d);
			} else if (escPivo == 2) {
				/*ordenação em ordem decrescente e pivo como o ultimo da
				* direita
				* ordenação em ordem decrescente e pivo como o primeiro da
				* esquerda
				 auxilia o calculo do tempo de execuçãao do metodo */
				inicio = System.currentTimeMillis();
				// vetor sera ordenado em ordem decrescente
				quickDPivoD(vetor, 0, vetor.length - 1);
				fim = System.currentTimeMillis();
				System.out.printf("QuickSort tempo de processamento: %.3f ms%n", (fim - inicio) / 1000d);
			} else if (escPivo == 3) {
				inicio = System.currentTimeMillis();
				// vetor sera ordenado em ordem decrescente
				quickDPivoM(vetor);
				fim = System.currentTimeMillis();
				System.out.printf("%.3f ms%n", (fim - inicio) / 1000d);
			}
		} else {
			System.out.println("comando nn reconhecido");
		}
	}

	/*
	 * quick sort para ordenação em ordem crescente e pivo como primeiro a
	 * esquerda(quickSortCrescentePivoEsquerda)
	 */
	public static void quickCPivoE(Componente[] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int posicaoPivo = separar(vetor, inicio, fim);
			quickCPivoE(vetor, inicio, posicaoPivo - 1);
			quickCPivoE(vetor, posicaoPivo + 1, fim);
		}
	}

	// pivô como elemento mais a esquerda
	private static int separar(Componente[] vetor, int inicio, int fim) {
		Componente pivo = vetor[inicio];
		int i = inicio + 1, f = fim;
		while (i <= f) {
			if (vetor[i].getKey() <= pivo.getKey())
				i++;
			else if (pivo.getKey() < vetor[f].getKey())
				f--;
			else {
				Componente troca = vetor[i];
				vetor[i] = vetor[f];
				vetor[f] = troca;
				i++;
				f--;
			}
		}
		vetor[inicio] = vetor[f];
		vetor[f] = pivo;
		return f;
	}

	/*
	 * quick sort para ordenação em ordem Decrescente e pivo como primeiro a
	 * esquerda(quickSortDecrescetePivoEsquerda)
	 */
	private static void quickDPivoE(Componente[] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int posicaoPivo = separar1(vetor, inicio, fim);
			quickDPivoE(vetor, inicio, posicaoPivo - 1);
			quickDPivoE(vetor, posicaoPivo + 1, fim);
		}
	}

	// pivô como elemento mais a esquerda
	private static int separar1(Componente[] vetor, int inicio, int fim) {
		Componente pivo = vetor[inicio];
		int i = inicio + 1, f = fim;
		while (i <= f) {
			if (vetor[i].getKey() >= pivo.getKey())
				i++;
			else if (pivo.getKey() > vetor[f].getKey())
				f--;
			else {
				Componente troca = vetor[i];
				vetor[i] = vetor[f];
				vetor[f] = troca;
				i++;
				f--;
			}
		}
		vetor[inicio] = vetor[f];
		vetor[f] = pivo;
		return f;
	}

	/*
	 * quick sort para ordenação em ordem crescente e pivo como ultimo da
	 * direita(quickSortCrescentePivoDireita)
	 */
	private static void quickCPivoD(Componente[] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int posicaoPivo = separar2(vetor, inicio, fim);
			quickCPivoD(vetor, inicio, posicaoPivo - 1);
			quickCPivoD(vetor, posicaoPivo + 1, fim);
		}
	}

	// pivô como elemento mais a direita
	private static int separar2(Componente[] vetor, int inicio, int fim) {
		Componente pivo = vetor[fim];
		int i = inicio + 1, f = fim;
		while (i <= f) {
			if (vetor[i].getKey() <= pivo.getKey())
				i++;
			else if (pivo.getKey() < vetor[f].getKey())
				f--;
			else {
				Componente troca = vetor[i];
				vetor[i] = vetor[f];
				vetor[f] = troca;
				i++;
				f--;
			}
		}
		vetor[inicio] = vetor[f];
		vetor[f] = pivo;
		return f;
	}

	/*
	 * quick sort para ordenação em ordem Decrescente e pivo como ultimo da
	 * direita(quickSortDecrescentePivoDireita)
	 */
	private static void quickDPivoD(Componente[] vetor, final int inicio, final int fim) {
		if (inicio < fim) {
			int posicaoPivo = separar3(vetor, inicio, fim);
			quickDPivoD(vetor, inicio, posicaoPivo - 1);
			quickDPivoD(vetor, posicaoPivo + 1, fim);
		}
	}

	// pivô como elemento mais a direita
	private static int separar3(Componente[] vetor, int inicio, int fim) {
		Componente pivo = vetor[fim];
		int i = inicio + 1, f = fim;
		while (i <= f) {
			if (vetor[i].getKey() >= pivo.getKey())
				i++;
			else if (pivo.getKey() > vetor[f].getKey())
				f--;
			else {
				Componente troca = vetor[i];
				vetor[i] = vetor[f];
				vetor[f] = troca;
				i++;
				f--;
				
			}
		}
		vetor[inicio] = vetor[f];
		vetor[f] = pivo;
		return f;
	}

	/*
	 * quick sort para ordenação em ordem crescente e com pivô mediano
	 * QuickSortCPivoMediano
	 */
	public static void quickCPivoM(Componente[] v) {
		creQuickMeddium(v, 0, v.length - 1);
	}

	private static Componente[] creQuickMeddium(Componente[] v, int inicio, int fim) {
		int positionpivot;
		if (inicio < fim) {
			positionpivot = crePartitionMeddium(v, inicio, fim);
			creQuickMeddium(v, inicio, positionpivot - 1);
			creQuickMeddium(v, positionpivot + 1, fim);
		}
		return v;
	}

	private static int crePartitionMeddium(Componente[] v, int inicio, int fim) {
		int meio = meddiumTerm(v, inicio, fim);
		Componente pivo = v[meio];
		Componente temp = v[inicio];
		v[meio] = v[inicio];
		v[inicio] = pivo;
		int i = inicio + 1, f = fim;
		while (i <= f) {
			if (v[i].getKey() <= pivo.getKey()) {
				i++;
			} else if (v[f].getKey() > pivo.getKey()) {
				f--;
			} else {
				temp = v[i];
				v[i] = v[f];
				v[f] = temp;
				i++;
				f--;
			}
		}
		v[inicio] = v[f];
		v[f] = pivo;
		return f;
	}

	private static int meddiumTerm(Componente[] v, int inicio, int fim) {
		int meio = (fim + inicio) / 2;
		if (v[inicio].getKey() <= v[ meio].getKey() && v[inicio].getKey() >= v[inicio].getKey()) {
			return inicio;
		} else if (v[inicio].getKey() >= v[ meio].getKey() && v[inicio].getKey() <= v[fim].getKey()) {
			return inicio;
		} else if (v[fim].getKey() <= v[ meio].getKey() && v[fim].getKey() >= v[inicio].getKey()) {
			return fim;
		} else if (v[fim].getKey() >= v[ meio].getKey() && v[fim].getKey() <= v[inicio].getKey()) {
			return fim;
		}
		return meio;
	}
	/*quick sort com pivo mediano 
	 * quickSortDecrescentePivoMedio
	 * */
	public static void quickDPivoM(Componente[] v) {
		creQuickMeddium1(v, 0, v.length - 1);
	}

	private static Componente[] creQuickMeddium1(Componente[] v, int inicio, int fim) {
		int positionpivot;
		if (inicio < fim) {
			positionpivot = crePartitionMeddium1(v, inicio, fim);
			creQuickMeddium(v, inicio, positionpivot - 1);
			creQuickMeddium(v, positionpivot + 1, fim);
		}
		return v;
	}

	private static int crePartitionMeddium1(Componente[] v, int inicio, int fim) {
		int meio = meddiumTerm1(v, inicio, fim);
		Componente pivo = v[meio];
		Componente temp = v[inicio];
		v[meio] = v[inicio];
		v[inicio] = pivo;
		int i = inicio + 1, f = fim;
		while (i <= f) {
			if (v[i].getKey() >= pivo.getKey()) {
				i++;
			} else if (v[f].getKey() < pivo.getKey()) {
				f--;
			} else {
				temp = v[i];
				v[i] = v[f];
				v[f] = temp;
				i++;
				f--;
			}
		}
		v[inicio] = v[f];
		v[f] = pivo;
		return f;
	}

	private static int meddiumTerm1(Componente[] v, int inicio, int fim) {
		int meio = (fim + inicio) / 2;
		if (v[inicio].getKey() <= v[ meio].getKey() && v[inicio].getKey() >= v[inicio].getKey()) {
			return inicio;
		} else if (v[inicio].getKey() >= v[ meio].getKey() && v[inicio].getKey() <= v[fim].getKey()) {
			return inicio;
		} else if (v[fim].getKey() <= v[ meio].getKey() && v[fim].getKey() >= v[inicio].getKey()) {
			return fim;
		} else if (v[fim].getKey() >= v[ meio].getKey() && v[fim].getKey() <= v[inicio].getKey()) {
			return fim;
		}
		return meio;
	}
	
	
}
