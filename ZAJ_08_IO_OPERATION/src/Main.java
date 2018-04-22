import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ScatterSystem system = new ScatterSystem();

        SystemCache cache = new SystemCache();
        ExtendedSystemCache extendedCache = new ExtendedSystemCache();

//Deserializacja
        try {
            extendedCache.deserialize("hashMap.ser");
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

// Wykorzystanie systemu z mechanizmem cache-ującym:
        double[] input = {4.5, 5.66, -76.55}; // np. tablica losowych wartości
        Double output = extendedCache.get( input );
        if( output == null )
        {
            System.out.println("Liczenie operacji....");
            output = system.makeOperation( input );
            extendedCache.put( input, output );
        }

// Wykorzystanie wyniku operacji
        System.out.print("Result: ");
        for (double number:input) {
            System.out.print(number + " + ");
        }
        System.out.println(" = " + output);


 //Zapis do CSV
        try{
            extendedCache.exportCSV("hashMap.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

// Serializacja
        try{
            extendedCache.serialize("hashMap.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
