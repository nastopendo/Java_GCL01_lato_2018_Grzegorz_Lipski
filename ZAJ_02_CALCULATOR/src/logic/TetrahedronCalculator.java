package logic;

import basic.Calculator;

import java.util.Scanner;

import static java.lang.Math.pow;

public class TetrahedronCalculator implements Calculator {

    double a;
    @Override
    public double calculateBaseArea() {
        System.out.println("Podaj bok trojkata : ");
        Scanner in = new Scanner(System.in);
        a = in.nextDouble();
        double result = a*a*pow(3,1/2.0)/4;
        System.out.println("Pole podstawy czworoscianu wynosi: " + result);
        return result;
    }

    @Override
    public double calculateBasePerimeter() {
        System.out.println("Podaj bok trojkata : ");
        Scanner in = new Scanner(System.in);
        a = in.nextDouble();
        double result = 3*a;
        System.out.println("Obwod podstawy czworoscianu wynosi: " + result);
        return result;
    }
}
