package algoritmos;
import java.util.Random;
public class SelectionSort {
	public static void main(String[]args) {
		int n=100000; //cantidad de elementos del array
		int[] array=numerosAleatorios(n); //genera el array
		
		//System.out.println("Array original");
		//imprimirArray(array);
		
		long inicio=System.currentTimeMillis();
		selectionSort(array);
		long Final=System.currentTimeMillis();
		
		
		//System.out.println("Array ordenado");
		//imprimirArray(array);
		
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
	
	public static void selectionSort(int array[]){
        int n = array.length;
 
        // Uno por uno, mueve el indice del subarray no ordenado
        for (int i = 0; i < n-1; i++){
            // Encontrar el elemento mínimo en el array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (array[j] < array[min_idx])
                    min_idx = j;
 
            //cambia el elemento mas pequeño encontrado con el primer elemento
            int temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;
        }
    }
	
}


