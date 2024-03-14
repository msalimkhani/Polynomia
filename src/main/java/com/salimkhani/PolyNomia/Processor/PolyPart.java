package com.salimkhani.PolyNomia.Processor;

import com.salimkhani.Modules.Property;

public class PolyPart
{
    final Property<Double> Zarib;
    final Property<Integer> Tavan;
    public PolyPart(Double zarib, Integer tavan)
    {
        Zarib = new Property<>(zarib);
        Tavan = new Property<>(tavan);
    }
    public double Value(Double x)
    {
        return (Zarib.get() * Math.pow(x, Tavan.get()));
    }
}