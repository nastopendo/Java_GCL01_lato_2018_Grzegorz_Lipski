import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class FieldCalculatorTest {

    FieldCalcuklator fieldCalcuklator;

    @BeforeEach
    void setUp() {
        fieldCalcuklator = new FieldCalcuklator();
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    public void calculateSquare() {
        try {
            fieldCalcuklator.calculateSquare(-5.2);
            fail("Fail because exception was not thrown");
        } catch(IllegalArgumentException e) {
            assertEquals("The side length of the square [" + -5.2 + "] can not be negative", e.getMessage());
        }
        assertEquals(9.0, fieldCalcuklator.calculateSquare(3.0));
        assertEquals(0.16, fieldCalcuklator.calculateSquare(0.4),0.00000000000001);
        assertEquals(25.6036, fieldCalcuklator.calculateSquare(5.06),0.00000000000001);
    }

    @Test
    void calculateCircle() {
        try {
            fieldCalcuklator.calculateCircle(-5.2);
            fail("Fail because exception was not thrown");
        } catch(IllegalArgumentException e) {
            assertEquals("The radious length of the circle [" + -5.2 + "] can not be negative", e.getMessage());
        }
        assertEquals(28.2743338823, fieldCalcuklator.calculateCircle(3.0), 0.00000000001);
        assertEquals(0.50265482457, fieldCalcuklator.calculateCircle(0.4),0.00000000001);
        assertEquals(80.4360816655, fieldCalcuklator.calculateCircle(5.06),0.0000001);
    }

    @Test
    void calculateTriangle() {
        try {
            fieldCalcuklator.calculateTriangle(-5.2,5.0);
            fail("Fail because exception was not thrown");
        } catch(IllegalArgumentException e) {
            assertEquals("The base length of the triangle [" + -5.2 + "] can not be negative", e.getMessage());
        }
        try {
            fieldCalcuklator.calculateTriangle(5.2, -5.3);
            fail("Fail because exception was not thrown");
        } catch(IllegalArgumentException e) {
            assertEquals("The height length of the triangle [" + -5.3 + "] can not be negative", e.getMessage());
        }
        assertEquals(9.3, fieldCalcuklator.calculateTriangle(3.0,6.2), 0.00000000001);
        assertEquals(25.0, fieldCalcuklator.calculateTriangle(50.0,1.0), 0.00000000001);
        assertEquals(6.8, fieldCalcuklator.calculateTriangle(6.8,2.0), 0.00000000001);
    }

    @Test
    void calculateRectangle() {
        try {
            fieldCalcuklator.calculateRectangle(-5.2,5.0);
            fail("Fail because exception was not thrown");
        } catch(IllegalArgumentException e) {
            assertEquals("The side length of the rectangle [" + -5.2 + "] can not be negative", e.getMessage());
        }
        try {
            fieldCalcuklator.calculateRectangle(5.2, -5.3);
            fail("Fail because exception was not thrown");
        } catch(IllegalArgumentException e) {
            assertEquals("The side length of the rectangle [" + -5.3 + "] can not be negative", e.getMessage());
        }
        assertEquals(18.6, fieldCalcuklator.calculateRectangle(3.0,6.2), 0.00000000001);
        assertEquals(50.0, fieldCalcuklator.calculateRectangle(50.0,1.0), 0.00000000001);
        assertEquals(13.6, fieldCalcuklator.calculateRectangle(6.8,2.0), 0.00000000001);
    }
}