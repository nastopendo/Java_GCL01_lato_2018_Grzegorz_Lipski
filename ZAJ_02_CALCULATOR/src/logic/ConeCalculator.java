package logic;

import basic.Calculator;
import java.util.Scanner;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class ConeCalculator implements Calculator {

    double r;
    @Override
    public double calculateBaseArea() {
        System.out.println("Podaj promien: ");
        Scanner in = new Scanner(System.in);
        r = in.nextDouble();
        double result = PI*pow(r,2);
        System.out.println("Pole podstawy stozka wynosi: " + result);
        return result;
    }

    @Override
    public double calculateBasePerimeter() {
        System.out.println("Podaj promien: ");
        Scanner in = new Scanner(System.in);
        r = in.nextDouble();
        double result = 2*PI*r;
        System.out.println("Obwod stozka wynosi: " + result);
        return result;
    }
}
