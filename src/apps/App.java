/*UNIVERSIDADE FEDERAL DO MARANHÃO-UFMA
 *DEPARTAMENTO DE INFORMATICA-DEINF
 *discente: Robert Douglas de Araujo Santos
 *Atividade Pratica 1 
 */
package apps;
import apps.Ler;
import algoritmosDeOrdenacao.*;

/*Classe principal para iniciar o programa*/

public class App {

	public static void main(String[] args) {
		int opcao;
        
        do{
        	Menus.menu();
            opcao = Ler.inteiro();
            switch(opcao){
            case 1:
            	//chama o metodo da classe SelectionSort para efetuar a ordenção por esse metodo//
            	SelectionSort.metodoPrincipal();
                break;
            case 2:
            	//chama o metodo da classe InsertionSort para efetuar a ordenção por esse metodo//
            	InsertionSort.metodoPrincipal();
                break;
            case 3:
            	//chama o metodo da classe QuickSort para efetuar a ordenção por esse metodo//
            	QuickSort.metodoPrincipal();
                break;
            case 4:
            	//chama o metodo da classe HeapSort para efetuar a ordenção por esse metodo//
            	HeapSort.metodoPrincipal();
                break;
            case 5:
            	//chama o metodo da classe MergeSort para efetuar a ordenção por esse metodo//
            	MergeSort.metodoPrincipal();
                break;
            case 6:
            	//chama o metodo da classe CoutingSort para efetuar a ordenção por esse metodo//
            	CoutingSort.metodoPrincipal();
                break;
            case 0:
            	System.out.println("Programa encerrado");
                break;
            default:
                System.out.println("Opção inválida.");
            }
        } while(opcao != 0);
       
    }

}
