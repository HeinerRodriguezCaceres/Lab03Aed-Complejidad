package Ejercicios;

public class MergeSort {
	public static void mergeSort(int[] arr, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            
            mergeSort(arr, izquierda, medio);
            
            mergeSort(arr, medio + 1, derecha);
            
            merge(arr, izquierda, medio, derecha);
        }
    }

    public static void merge(int[] arr, int izquierda, int medio, int derecha) {
        int n1 = medio - izquierda + 1;
        int n2 = derecha - medio;

        int[] izquierdaArr = new int[n1];
        int[] derechaArr = new int[n2];

        for (int i = 0; i < n1; i++)
            izquierdaArr[i] = arr[izquierda + i];

        for (int j = 0; j < n2; j++)
            derechaArr[j] = arr[medio + 1 + j];

        int i = 0, j = 0, k = izquierda;
        while (i < n1 && j < n2) {
            if (izquierdaArr[i] <= derechaArr[j]) {
                arr[k] = izquierdaArr[i];
                i++;
            } else {
                arr[k] = derechaArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = izquierdaArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = derechaArr[j];
            j++;
            k++;
        }
    }

    public static void imprimirArreglo(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arreglo = {12, 11, 13, 5, 6, 7};
        System.out.println("Arreglo original:");
        imprimirArreglo(arreglo);

        mergeSort(arreglo, 0, arreglo.length - 1);

        System.out.println("Arreglo ordenado:");
        imprimirArreglo(arreglo);
    }

}
