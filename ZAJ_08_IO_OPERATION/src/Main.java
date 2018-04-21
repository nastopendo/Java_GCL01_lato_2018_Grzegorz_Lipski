import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //…
        ScatterSystem system = new ScatterSystem(); // można umieścić wewnątrz dowolną funkcję matematyczna
        SystemCache cache = new SystemCache();
        ExtendedSystemCache extendedCache = new ExtendedSystemCache();
//…
// Wykorzystanie systemu z mechanizmem cache-ującym:
        double[] input = {4.5, 5.66, -76.55}; // np. tablica losowych wartości
        Double output = extendedCache.get( input );
        if( output == null )
        {
            output = system.makeOperation( input );
            extendedCache.put( input, output );
        }
// Wykorzystanie wyniku operacji, itp. …
//…
        System.out.print("Result: ");
        for (double number:input) {
            System.out.print(number + " + ");
        }
        System.out.println(" = " + output);

        //extendedCache.exportCSV("/test.csv");
        System.out.println(extendedCache.get(input));
    }
}
