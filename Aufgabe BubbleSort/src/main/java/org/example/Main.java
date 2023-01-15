package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 50,23, 3279, 32, 20, 12, 2149, 214, 124, 125, 13, 4, 5}; // das Array welches sortiert werden soll
        bubbleSort(array);
    }

    /**
     * Sortiert ein Array mit dem BubbleSort Algorithmus
     *
     * Das Laufzeitverhalten von Bubble sort ist O(n^2) im worst-case und im average-case.
     * Das bedeutet, dass die Zeit, die der Algorithmus benötigt, um eine Liste mit n Elementen zu sortieren,
     *      quadratisch zunimmt, je größer die Liste wird.
     * Dies liegt daran, dass der Algorithmus jedes Element mit jedem anderen Element im Array vergleicht und tauscht,
     *      wenn es in der falschen Reihenfolge ist, was insgesamt n^2 Vergleiche und Vertauschungen erfordert.
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