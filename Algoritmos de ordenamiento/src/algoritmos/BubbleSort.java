package algoritmos;

import java.util.Random;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=1000; //cantidad de elementos del array
		int[] array=numerosAleatorios(n); //genera el array
		
		/*System.out.println("Array original");
		imprimirArray(array);*/
		
		long inicio=System.currentTimeMillis();
		bubbleSort(array, array.length);
		long Final=System.currentTimeMillis();
		
		
		/*System.out.println("Array ordenado");
		imprimirArray(array);*/
		
		long tiempoTotal= Final-inicio; //calcula el tiempo total de ejecución del algoritmo 
		System.out.println("Tiempo de  ejecución: "+ tiempoTotal);
	}
	
	public static int[] numerosAleatorios(int n) {
		int[] array=new int[n];
		Random rand=new Random();
		
		for(int i=0; i<n; i++) {
			array[i]=rand.nextInt(1000000000);
		}
		return array;
	}
	
	public static void imprimirArray(int[] array) {
		for(int num:array) {
			System.out.println(num+" ");
		}
		System.out.println();
	}
	
	public static void bubbleSort(int arr[], int a){
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < a - 1; i++) {
            swapped = false;
            for (j = 0; j < a - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                     
                    // cambia arr[j] y arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
 

            //Si dos elementos no fueron
            //cambiados de lugar, se rompe el ciclo
            if (swapped == false)
                break;
        }
    }

}
