package algoritmos;

import java.util.Random;

public class QuickSort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=1000000; //cantidad de elementos del array
		int[] array=numerosAleatorios(n); //genera el array
		
		/*System.out.println("Array original");
		imprimirArray(array);*/
		
		long inicio=System.currentTimeMillis();
		quickSort(array, 0, n-1);
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
			array[i]=rand.nextInt(1000);
		}
		return array;
	}
	
	public static void imprimirArray(int[] array) {
		for(int num:array) {
			System.out.println(num+" ");
		}
		System.out.println();
	}
	
	//Función que intercambia dos elemetos
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    /* Esta función toma el ultimo elemento como pivote,
     *coloca el pivote en su lugar correcto en el array
     *ordenado y coloca los elementos más pequeños
     *a la izquierda y los grandes a la derecha
     */
    static int partition(int[] arr, int low, int high){
    	//Elige el pivote
        int pivot = arr[high];
 
        //Indice del elemeto más pequeño
        //Indica la posición correcta del pivote
        int i = (low - 1);
 
        for (int j = low; j <= high - 1; j++) {
 
        	//Si el elemento actual is menor que el pivote
            if (arr[j] < pivot) {
 
            	//Incrementa el indice del elemento pequeño
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
 
    /* Funcion principal que implementa el algoritmo 
      low: indice de inicio
      high: indice de finalización
     */
    static void quickSort(int[] arr, int low, int high){
        if (low < high) {
 
        	// pi es el inidice de partición
        	// array[p]ahora está en el lugar correcto
            int pi = partition(arr, low, high);
 
            //Organiza separadamente los elementos antes
            //de la partición y luego de esta
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
	
}
