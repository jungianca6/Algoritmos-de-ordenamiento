package algoritmos;

import java.util.Random;

public class MergeSort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=1000000; //cantidad de elementos del array
		int[] array=numerosAleatorios(n); //genera el array
		
		/*System.out.println("Array original");
		imprimirArray(array);*/
		
		long inicio=System.currentTimeMillis();
		sort(array, 0, n-1);
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
	
	static void merge(int arr[], int l, int m, int r)
    {
        
		//Encuentra el tamaño de los dos subarrays a combinar
        int n1 = m - l + 1;
        int n2 = r - m;
 
        
        //Crea arrays temporales
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        //Copia los datos a los arrays temporales
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        //Combina los array temporales
 
        //Inicializa los indices de los subarrays
        int i = 0, j = 0;
 
        // Indice inicial del array combinado
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        //Copia los elementos restantes de L[] (si quedaron)
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        // Copia los elementos restantes de R[] (si quedaron)
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    
	//Funcion principal que ordenena el array usando merge()
    
    static void sort(int arr[], int l, int r)
    {
        if (l < r) {
 
            // Find the middle point
            int m = l + (r - l) / 2;
 
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}
