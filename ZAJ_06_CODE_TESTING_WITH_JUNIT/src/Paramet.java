import java.util.Arrays;
import java.util.Collection;

//import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
//import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


@RunWith(value = Parameterized.class)
public class Paramet {

    BasicCalculator basicCalculator = new BasicCalculator();

    @Parameter(value = 0)
    public double sub1;

    @Parameter(value = 1)
    public double sub2;

    @Parameter(value = 2)
    public double expected;


    @Parameters(name = "{index}: calculateSum({0},{1})= {2}")
    public static Collection<Double[]>data(){
        return Arrays.asList( new Double[][]{
                {0.0,0.0,0.0},
                {-100.0,100.0,0.0},
                {14.0,3.5,17.5},
                {4.0,3.5,7.5}
        });
    }

    @Test
    public void testCalculateSum(){
        assertEquals(basicCalculator.calculateSum(sub1, sub2), expected,0.0001);
    }
}