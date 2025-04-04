package Actividades;

public class Actividades {
	public static void main(String[] args) {
        System.out.println(potencia(2, 3));
    }

    public static int[] intercambia(int x, int y) {
        int aux; // 1
        aux = x; // 1
        x = y;   // 1
        y = aux; // 1
        return new int[]{x, y};
    }

    public static int maximo(int x, int y) {
        int result;         // 1
        if (x >= y) {       // 1
            result = x;     // 1
        } else {        
            result = y;     // 1
        }
        return result;      // 1
    }
    // O(1)

    public static int suma(int[] v, int tamaño) {
        int result = 0;                         // 1
        for (int i = 0; i < tamaño-1; i++) {    // n
            result += v[i];                     // n
        }
        return result;                          // 1
    }
    // O(n)

    public static void ordenar(int[] v, int tamaño) {
        int aux;                                    // 1
        for (int i = 0; i < tamaño-1; i++) {        // n
            for (int j = 0; j < tamaño-1; j++) {    // n^2
                if (v[j] > v[j+1]) {                // n^2
                    aux = v[j];                     // n^2
                    v[j] = v[j+1];                  // n^2
                    v[j+1] = aux;                   // n^2
                }
            }
        }
    }
    // O(n^2)

    public static double potencia(double x, int y) {
        double t;                               // 1
        if (y == 0)                             // 1
            return 1.0;                         // 1 
        if (y % 2 == 1) {                 
            System.out.println(x * potencia(x, y - 1));
            return x * potencia(x, y - 1);
        }
        else {

            t = potencia(x, y / 2); 
            return t * t;
        }

    }
}


