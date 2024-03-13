package com.salimkhani.PolyNomia.Processor;


import com.salimkhani.Modules.Property;

import java.util.ArrayList;
import java.util.Locale;

/*
* Mahdi Salimkhani
* Working with Polynomials*/

class PolyPart
{
    final Property<Double> Zarib;
    final Property<Double> Tavan;
    public PolyPart(Double zarib, Double tavan)
    {
        Zarib = new Property<>(zarib);
        Tavan = new Property<>(tavan);
    }
    public double Value(Double x)
    {
        return (Zarib.get() * Math.pow(x, Tavan.get()));
    }
}
public class Polynomia{

    private final String _polyString;
    private ArrayList<PolyPart> polyParts;
    public Polynomia(String polyString) {
        _polyString = polyString;
        polyParts = new ArrayList<>();
        process();
    }
    public double calculate(double x)
    {
        double res = 0;
        for (var item : polyParts)
        {
            res += item.Value(x);
        }
        return res;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Polynomia{");
        sb.append("\n_polyString='").append(_polyString).append('\'');
        sb.append(",\npolyParts=");
        for (var item : polyParts)
        {
            sb.append("\n\tPolyPart{").append("\n\t\tZarib=").append(item.Zarib.get()).append("\n\t\tTavan=").append(item.Tavan.get()).append("\n\t\t}");
        }
        sb.append("\n}");
        return sb.toString();
    }

    private void process()
    {
        String formatted = _polyString.toLowerCase(Locale.ROOT).replace("+","@+").replace("-","@-");
        String[] splitted = formatted.split("@",-2);
        for (var item : splitted)
        {
            processPart(item);
        }
    }
    private void processPart(String value)
    {
        boolean powState = value.contains("^");
        boolean xState = value.contains("x");
        if(powState && xState)
        {
            String[] sp = value.replace("@","").split("\\^",-2);
            String sp0 = sp[0].replace("x","");
            if(sp0.equals("+") || sp0.equals("-") || sp0.isEmpty())
                sp0 += "1";
            PolyPart part = new PolyPart(Double.parseDouble(sp0), Double.parseDouble(sp[1]));
            polyParts.add(part);
        }
        if(!powState && xState)
        {
            String sp = value.replace("@","");

            String sp0 = sp.replace("x","");

            if(sp0.equals("+") || sp0.equals("-") || sp0.isEmpty())
                sp0 += "1";
            PolyPart part = new PolyPart(Double.parseDouble(sp0), 1.0);
            polyParts.add(part);
        }
        if(!powState && !xState)
        {
            String sp = value.replace("@","");
            PolyPart polyPart = new PolyPart(Double.parseDouble(sp), 0.0);
            polyParts.add(polyPart);
        }
    }
}
