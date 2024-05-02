package Calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationTest {

    @Test
    public void testCalculateAddition() {
        Calculation calculation = new Calculation();
        float result = calculation.calculate(10, 5, "+");
        assertEquals(15, result);
    }

    @Test
    public void testCalculateSubtraction() {
        Calculation calculation = new Calculation();
        float result = calculation.calculate(10, 5, "-");
        assertEquals(5, result);
    }

    @Test
    public void testCalculateMultiplication() {
        Calculation calculation = new Calculation();
        float result = calculation.calculate(10, 5, "x");
        assertEquals(50, result);
    }

    @Test
    public void testCalculateDivision() {
        Calculation calculation = new Calculation();
        float result = calculation.calculate(10, 5, "/");
        assertEquals(2, result);
    }

    @Test
    public void testCalculateDivisionByZero() {
        Calculation calculation = new Calculation();
        float result = calculation.calculate(10, 0, "/");
        assertEquals(0, result);
    }
}

