package org.example;

public class Main {
    public static void main(String[] args) {
        Polynom polynom1 = new Polynom(new int[]{3, 0, 4, 7, 8, 192});
        Polynom polynom2 = new Polynom(new int[]{4, 0, 5, -5, 0, 13, 2});

        System.out.println(polynom2.vergleiche(polynom1));
        Polynom polynom3= polynom2.addiere(polynom1);
        polynom3.print();

        System.out.println("");

        System.out.println(polynom1.berechneFürx(2));

    }
}