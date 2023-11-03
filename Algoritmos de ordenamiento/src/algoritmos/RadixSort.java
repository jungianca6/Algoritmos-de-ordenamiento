package algoritmos;

import java.util.Arrays;
import java.util.Random;

public class RadixSort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=1000000; //cantidad de elementos del array
		int[] array=numerosAleatorios(n); //genera el array
		
		/*System.out.println("Array original");
		imprimirArray(array);*/
		
		long inicio=System.currentTimeMillis();
		radixSort(array, n);
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
	
	//Funcion para obtener el valor maximo
    static int getMax(int arr[], int n){
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
 
    //Funcion para ordenar el array por conteo
    //de auerdo al digito contenido en exp
    static void countSort(int arr[], int n, int exp){
        int output[] = new int[n]; // array de salida
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
 
        //Almacena el recuento de ocurrencias en count[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;
 
        //Cambia a count[i] así count[i] ahora contiene
        // la posición actual del digito en output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        //Contruye el array de salida
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        //Copia la salida a arr[], de esta manera arr[]
        //ahora contiene los numeros ordenados de acuerdo 
        //al digito actual
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
 
    //Funcion principal que ordena array[] usando RadixSort
    static void radixSort(int arr[], int n){
    	//Encuentra el numero maximo para conocer
    	//la cantidad de elementos
        int m = getMax(arr, n);
        
        //Hace el ordenamiento por cuenta para cada digito
        //En lugar de pasarse el digito del numero se pasa exp
        //Exp is 10^i donde i es el digito actual
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
}
