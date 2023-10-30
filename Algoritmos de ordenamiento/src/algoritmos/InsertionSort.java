package algoritmos;

import java.util.Random;

public class InsertionSort {
	public static void main(String[]args) {
		int n=100; //cantidad de elementos del array
		int[] array=numerosAleatorios(n); //genera el array
		
		System.out.println("Array original");
		imprimirArray(array);
		
		long inicio=System.currentTimeMillis();
		insertionSort(array);
		long Final=System.currentTimeMillis();
		
		
		System.out.println("Array ordenado");
		imprimirArray(array);
		
		long tiempoTotal= Final-inicio; //calcula el tiempo total de ejecución del algoritmo 
		System.out.println("Tiempo de  ejecución: "+ tiempoTotal);
	}
	//Asigna los numeros aleatorios al array
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
	
	public static void insertionSort(int arr[]){
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
	}
}
