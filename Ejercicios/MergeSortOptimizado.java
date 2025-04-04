package Ejercicios;

public class MergeSortOptimizado {
private static int[] auxiliar; 
    
    private static final int UMBRAL = 10;

    public static void mergeSort(int[] arr) {
        auxiliar = new int[arr.length]; 
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int izquierda, int derecha) {
        if (derecha - izquierda <= UMBRAL) { 
            insertionSort(arr, izquierda, derecha);
            return;
        }
        
        int medio = izquierda + (derecha - izquierda) / 2;
        mergeSort(arr, izquierda, medio);
        mergeSort(arr, medio + 1, derecha);
        
        if (arr[medio] <= arr[medio + 1]) return;
        
        merge(arr, izquierda, medio, derecha);
    }

    private static void merge(int[] arr, int izquierda, int medio, int derecha) {
        System.arraycopy(arr, izquierda, auxiliar, izquierda, derecha - izquierda + 1);

        int i = izquierda, j = medio + 1, k = izquierda;
        
        while (i <= medio && j <= derecha) {
            if (auxiliar[i] <= auxiliar[j]) {
                arr[k++] = auxiliar[i++];
            } else {
                arr[k++] = auxiliar[j++];
            }
        }

        while (i <= medio) {
            arr[k++] = auxiliar[i++];
        }
    }

    private static void insertionSort(int[] arr, int izquierda, int derecha) {
        for (int i = izquierda + 1; i <= derecha; i++) {
            int clave = arr[i];
            int j = i - 1;
            while (j >= izquierda && arr[j] > clave) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = clave;
        }
    }

    public static void imprimirArreglo(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arreglo = {12, 11, 13, 5, 6, 7, 3, 15, 2, 9, 1, 8};
        System.out.println("Arreglo original:");
        imprimirArreglo(arreglo);

        mergeSort(arreglo);

        System.out.println("Arreglo ordenado:");
        imprimirArreglo(arreglo);
    }

}
