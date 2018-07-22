package apps;

import java.util.Random;

/*Funçoes que são usadas por varias classe ao decorrer do programa,
 *  evitando assim repetição de codigo */
public class FuncoesAux {
	// preenche o vetor com componentes de keys de valores aleatorios
	public static Componente[] PreencherVet(Componente[] vetor, int nElms) {
		int i;
		Random gerador = new Random(); // para gerar os valores aleatorios
		// preenche o vetor
		for (i = 0; i < nElms; i++) {
			Componente x = new Componente(gerador.nextInt(nElms * 2));
			vetor[i] = x;
		}
		return vetor;
	}

	// retorna maior elemento do vetor,usado no metodo countingsort
	public static int descobreMaior(Componente[]v){
		int maior = v[0].getKey();
		for(int i=0;i<v.length;i++){
			if(maior < v[i].getKey()){
				maior =v[i].getKey();
			}
		}
		return maior;
	}
	

	/* metodo para auxiliar na ordenação inicial na ordem crescente */
	public static void QuickAuxCres(Componente[] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int posicaoPivo = separar(vetor, inicio, fim);
			QuickAuxCres(vetor, inicio, posicaoPivo - 1);
			QuickAuxCres(vetor, posicaoPivo + 1, fim);
		}
	}

	// pivô como elemento mais a esquerda
	public static int separar(Componente[] vetor, int inicio, int fim) {
		int pivo = vetor[inicio].getKey();
		int i = inicio + 1, f = fim;
		while (i <= f) {
			if (vetor[i].getKey() <= pivo)
				i++;
			else if (pivo < vetor[f].getKey())
				f--;
			else {
				int troca = vetor[i].getKey();
				vetor[i].setKey(vetor[f].getKey());
				vetor[f].setKey(troca);
				i++;
				f--;
			}
		}
		vetor[inicio].setKey(vetor[f].getKey());
		vetor[f].setKey(pivo);
		return f;
	}

	/* metodo para auxiliar na ordenação inicial na forma decrescente */
	public static void QuickAuxDecres(Componente[] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int posicaoPivo = separar1(vetor, inicio, fim);
			QuickAuxDecres(vetor, inicio, posicaoPivo - 1);
			QuickAuxDecres(vetor, posicaoPivo + 1, fim);
		}
	}

	// pivô como elemento mais a esquerda
	public static int separar1(Componente[] vetor, int inicio, int fim) {
		int pivo = vetor[inicio].getKey();
		int i = inicio + 1, f = fim;
		while (i <= f) {
			if (vetor[i].getKey() >= pivo)
				i++;
			else if (pivo < vetor[f].getKey())
				f--;
			else {
				int troca = vetor[i].getKey();
				vetor[i].setKey(vetor[f].getKey());
				vetor[f].setKey(troca);
				i++;
				f--;
			}
		}
		vetor[inicio].setKey(vetor[f].getKey());
		vetor[f].setKey(pivo);
		return f;
	}
	

}
