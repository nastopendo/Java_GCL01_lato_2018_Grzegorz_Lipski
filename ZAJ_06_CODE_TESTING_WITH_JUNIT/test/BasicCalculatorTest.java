import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BasicCalculatorTest {

    BasicCalculator basicCalculator;

    @BeforeEach
    void setUp() {
        basicCalculator = new BasicCalculator();
    }

    @AfterEach
    void tearDown() {
        basicCalculator = null;
    }

    @Test
    void calculateSum() {
        assertEquals(200.0,basicCalculator.calculateSum(154.2,45.8));
        assertEquals(-13.004,basicCalculator.calculateSum(-3.0,-10.004));
        assertEquals(0.0,basicCalculator.calculateSum(45.8,-45.8));
    }

    @Test
    void caclulateDifference() {
        assertEquals(123.0,basicCalculator.caclulateDifference(154.0,31.0));
        assertEquals(-12.0,basicCalculator.caclulateDifference(-100.0,-88.0));
        assertEquals(0.0,basicCalculator.caclulateDifference(124.8,124.8));
    }

    @Test
    void calculateMultiplication() {
        assertEquals(200.0,basicCalculator.calculateMultiplication(50.0,4.0));
        assertEquals(0.0,basicCalculator.calculateMultiplication(434.6,0.0));
        assertEquals(-58.2,basicCalculator.calculateMultiplication(2.0,-29.1),0.001);
    }

    @Test
    void calculateDivision() {
        try {
            basicCalculator.calculateDivision(4.0,0.0);
            fail("Fail because exception was not thrown");
        } catch(IllegalArgumentException e) {
            assertEquals("You can not divide by 0.0", e.getMessage());
        }
        assertEquals(5.2, basicCalculator.calculateDivision(15.6,3.0));
        assertEquals(-3.03, basicCalculator.calculateDivision(12.12,-4.0));
        assertEquals(4.4, basicCalculator.calculateDivision(8.8,2.0));
    }

    @Test
    void calculatePow() {
        try {
            basicCalculator.calculatePow(0.0,0);
            fail("Fail because exception was not thrown");
        } catch(IllegalArgumentException e) {
            assertEquals("0.0^0 - undefined expression", e.getMessage());
        }
        assertEquals(9, basicCalculator.calculatePow(3.0,2));
        assertEquals(0.01, basicCalculator.calculatePow(-10.0,-2));
        assertEquals(0.04, basicCalculator.calculatePow(5.0,-2));
    }

    @Test
    void calculateSqlr() {
        try {
            basicCalculator.calculateSqlr(4.05,0);
            fail("Fail because exception was not thrown");
        } catch(IllegalArgumentException e) {
            assertEquals("The exponent [0] must be greater than 1", e.getMessage());
        }
        try {
            basicCalculator.calculateSqlr(-98.0,6);
            fail("Fail because exception was not thrown");
        } catch(IllegalArgumentException e) {
            assertEquals("The exponent of power [6]from the negative number [-98.0] must be even", e.getMessage());
        }
        assertEquals(1.5, basicCalculator.calculateSqlr(2.25,2));
        assertEquals(-0.1, basicCalculator.calculateSqlr(-0.001,3),0.0000000000000001);
        assertEquals(56.9, basicCalculator.calculateSqlr(3237.61,2));
    }
}