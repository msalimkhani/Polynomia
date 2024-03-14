package com.salimkhani;

import com.salimkhani.PolyNomia.Processor.Polynomial;

public class Main {
    public static void main(String[] args) {
        int x = 3;
        Polynomial polynomial = new Polynomial("x^2+x+1");
        System.out.println(polynomial);
        System.out.println("polynomial : Answer for x="+x+" is "+polynomial.calculate(x));
    }
}