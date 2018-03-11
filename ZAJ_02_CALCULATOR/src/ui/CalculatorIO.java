package ui;

import java.util.Scanner;
import logic.*;
import basic.*;

public class CalculatorIO {
    static ConeCalculator coneCalculator = new ConeCalculator();
    static TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculator();
    static ExtendedConeCalculator extendedConeCalculator = new ExtendedConeCalculator();
    static ExtendedTetrahedronCalculator extendedTetrahedronCalculator = new ExtendedTetrahedronCalculator();
    static Scanner in = new Scanner(System.in);
    static int choice;

    public static void menu(){
        boolean exit = false;
        while(!exit){

            System.out.println("\nMenu: ");
            System.out.println("1 - pole podstawy stozka");
            System.out.println("2 - obwod podstawy stozka");
            System.out.println("3 - pole stozka");
            System.out.println("4 - objetosc stozka");
            System.out.println("5 - pole podstawy czworoscianu prostego");
            System.out.println("6 - obwod podstawy czworoscianu prostego");
            System.out.println("7 - pole czworoscianu prostego");
            System.out.println("8 - objetosc czworoscianu prostego\n");
            System.out.println("0 - wyjscie\n");
            choice = in.nextInt();
            switch (choice) {
                case 1: {
                    try {
                        coneCalculator.calculateBaseArea();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
                case 2: {
                    try {
                        tetrahedronCalculator.calculateBaseArea();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
                case 3: {
                    try {
                        extendedConeCalculator.calculateArea();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
                case 4: {
                    try {
                        extendedConeCalculator.calculateVolume();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
                case 5: {
                    try {
                        coneCalculator.calculateBasePerimeter();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
                case 6: {
                    try {
                        tetrahedronCalculator.calculateBasePerimeter();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
                case 7: {
                    try {
                        extendedTetrahedronCalculator.calculateArea();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
                case 8: {
                    try {
                        extendedTetrahedronCalculator.calculateVolume();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
                case 0:
                    exit = true;
                    break;
            }
        }
    }
}
