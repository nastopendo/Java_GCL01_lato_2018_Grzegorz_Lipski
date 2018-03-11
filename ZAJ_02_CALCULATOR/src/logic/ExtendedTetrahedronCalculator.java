package logic;

import basic.ExtendedCalculator;

import java.util.Scanner;

public class ExtendedTetrahedronCalculator extends TetrahedronCalculator implements ExtendedCalculator {
    Scanner in = new Scanner(System.in);
    double h, d, l, result, baseArea, sideArea;
    @Override
    public void calculateArea() throws Exception {
        baseArea = calculateBaseArea();
        System.out.println("Podaj wysokosc czworoscainu: ");
        h = in.nextDouble();
        d=a*Math.sqrt(3.0)/6;
        l=Math.sqrt(d*d+h*h);
        sideArea = 3*(1/2.0*a*l);
        result = baseArea + sideArea;
        System.out.println("Pole powierzchni czworoscianu wynosi: " + result);
    }

    @Override
    public void calculateVolume() throws Exception {
        baseArea = calculateBaseArea();
        System.out.println("Podaj wysokosc czworoscianu: ");
        h = in.nextDouble();
        result = 1/3.0*baseArea*h;
        System.out.println("Objetosc czworoscianu wynosi: " + result);
    }
}
