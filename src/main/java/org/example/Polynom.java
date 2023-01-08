package org.example;

import java.math.BigInteger;
import java.util.Arrays;

public class Polynom {

    int[] koeffizienten;
    int grad;

    /**
     * Konstruktor
     *
     * @param koeffizienten
     */
    public Polynom(int[] koeffizienten) {
        this.koeffizienten = koeffizienten;
        this.grad = koeffizienten.length - 1; //Siehe Beschreibung der Aufgabe
    }

    /**
     * Vergleiche ein bereits existierendes Polynom mit einem anderen
     *
     * @param anderesPolynom
     * @return true||false
     */
    public boolean vergleiche(Polynom anderesPolynom) {
        return Arrays.equals(koeffizienten, anderesPolynom.koeffizienten);
    }

    /**
     * Addiere ein bereits existierendes Polynom mit einem anderen
     * Dabei wird berücksichtigt, ob zwei Polynome unterschiedliche Grad haben
     *
     * @param anderesPolynom
     * @return
     */
    public Polynom addiere(Polynom anderesPolynom) {
        int[] koeffizienten1 = this.koeffizienten;
        int[] koeffizienten2 = anderesPolynom.koeffizienten;
        int[] koeffizienten3 = new int[Math.max(koeffizienten1.length, koeffizienten2.length)]; //Das neue Array hat die Länge des größeren Arrays

        if (koeffizienten1.length > koeffizienten2.length) {
            int breakpoint = koeffizienten2.length; //Der Breakpoint ist die Länge des kleineren Arrays
            for (int i = 0; i < breakpoint; i++) {
                koeffizienten3[i] = koeffizienten1[i] + koeffizienten2[i]; //Die ersten Elemente des neuen Arrays sind die Summe der ersten Elemente der beiden Arrays
            }
            int[] rest = Arrays.copyOfRange(koeffizienten1, breakpoint, koeffizienten1.length); //Das Array wird ab dem breakpoint kopiert
            for (int i = breakpoint; i < koeffizienten3.length; i++) {
                koeffizienten3[i] = rest[i - breakpoint]; //i-breakpoint ist die Position im rest-Array
            }
        } else if (koeffizienten1.length < koeffizienten2.length) {
            int breakpoint = koeffizienten1.length;
            for (int i = 0; i < breakpoint; i++) {
                koeffizienten3[i] = koeffizienten1[i] + koeffizienten2[i];
            }
            int[] rest = Arrays.copyOfRange(koeffizienten2, breakpoint, koeffizienten2.length);
            for (int i = breakpoint; i < koeffizienten3.length; i++) {
                koeffizienten3[i] = rest[i - breakpoint];
            }
        } else {
            for (int i = 0; i < koeffizienten3.length; i++) {
                koeffizienten3[i] = koeffizienten1[i] + koeffizienten2[i];
            }
        }


        return new Polynom(koeffizienten3);
    }

    /**
     * Multipliziere ein bereits existierendes Polynom mit einem anderen
     * @param anderesPolynom
     * @return
     */
    public Polynom multipliziere(Polynom anderesPolynom) {
        int[] resultCoefficients = new int[this.grad + anderesPolynom.grad + 1];
        for (int i = 0; i <= this.grad; i++) {
            resultCoefficients[i+i] += this.koeffizienten[i] * anderesPolynom.koeffizienten[i]; //Die Koeffizienten werden an der richtigen Stelle multipliziert und addiert

        }
        return new Polynom(resultCoefficients);
    }

    /**
     * Werte das Polynom für einen bestimmten Wert aus
     * @param x
     * @return
     */
    public double berechneFürx(int x) {
        double result = 0;
        for (int i = 0; i <= grad; i++) {
            result += koeffizienten[i] * Math.pow(x, i);
        }
        return result;
    }


    /**
     * Gibt das Polynom aus
     */
    public void print() {
        for (int i = 0; i < koeffizienten.length; i++) {
            if (koeffizienten[i] != 0) { //Wenn der Koeffizient nicht 0 ist, dann wird er ausgegeben
                if (i == 0) {
                    System.out.print(koeffizienten[i]); //Erster Koeffizient ohne x
                } else {
                    System.out.print(" + " + koeffizienten[i] + "x^" + i); //das i repräsentiert zugleich den Grad des aktuellen Koeffizienten
                }
            }
        }
    }
}


