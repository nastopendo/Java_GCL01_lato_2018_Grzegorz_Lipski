package logic;

import basic.ExtendedCalculator;
import logic.ConeCalculator;

import java.util.Scanner;

public class ExtendedConeCalculator extends ConeCalculator implements ExtendedCalculator {
   Scanner in = new Scanner(System.in);
    double h, l, baseArea, sideArea, result;
    @Override
    public void calculateArea() throws Exception {
        baseArea = calculateBaseArea();
        System.out.println("Podaj wysokosc stozka: ");
        h = in.nextDouble();
        l=Math.sqrt(r*r+h*h);
        sideArea = Math.PI*r*l;
        result = baseArea + sideArea;
        System.out.println("Pole stozka wynosi: " + result);
    }

    @Override
    public void calculateVolume() throws Exception {
        baseArea = calculateBaseArea();
        System.out.println("Podaj wysokosc stozka: ");
        h = in.nextDouble();
        result = 1/3.0*baseArea*h;
        System.out.println("Objetosc stozka wynosi: " + result);
    }
}
