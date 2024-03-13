package com.salimkhani;

import com.salimkhani.PolyNomia.Processor.Polynomia;

public class Main {
    public static void main(String[] args) {
        int x = 3;
        Polynomia polynomia = new Polynomia("x^2+x+1");
        System.out.println(polynomia);
        System.out.println("Answer for x="+x+" is "+polynomia.calculate(x));
    }
}