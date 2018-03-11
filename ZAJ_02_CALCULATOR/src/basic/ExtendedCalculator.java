package basic;

import basic.Calculator;

public interface ExtendedCalculator extends Calculator {
    void calculateArea() throws Exception;
    void calculateVolume() throws Exception;
}
