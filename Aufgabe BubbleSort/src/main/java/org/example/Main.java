package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 50,23, 3279, 32, 20, 12, 2149, 214, 124, 125, 13, 4, 5}; // das Array welches sortiert werden soll
        bubbleSort(array);
    }

    /**
     * Sortiert ein Array mit dem BubbleSort Algorithmus
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length; // Länge des Arrays
        int temp; // Hilfsvariable für das Tauschen der Werte
        for (int i = 0; i < n; i++) { // Durchläuft das Array n mal
            for (int j = 1; j < (n - i); j++) { // Durchläuft das Array n-i mal
                if (arr[j - 1] > arr[j]) { // Wenn das aktuelle Element größer als das nächste ist
                    temp = arr[j - 1]; // Tausche die Werte
                    arr[j - 1] = arr[j]; // Tausche die Werte
                    arr[j] = temp; // Tausche die Werte
                }
            }
        }
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

}