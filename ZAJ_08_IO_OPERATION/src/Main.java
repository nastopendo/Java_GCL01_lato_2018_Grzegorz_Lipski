import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ScatterSystem system = new ScatterSystem();

        SystemCache staraTomka = new SystemCache();
        ExtendedSystemCache extendedCache = new ExtendedSystemCache();

// Import form CSV file
        try{
            extendedCache.importCSV("hashMap.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }


// Deserialization
        try {
            extendedCache.deserialize("hashMap.ser");
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

// Cache-System use
        double[] input = {99.8, -2.66, -6.55, 432.6, 432.74};
        Double output = extendedCache.get( input );
        if( output == null )
        {
            System.out.println("Liczenie operacji....");
            output = system.makeOperation( input );
            extendedCache.put( input, output );
        }

// Result use
        System.out.print("Result: ");
        for (double number:input) {
            System.out.print(number + " + ");
        }
        System.out.println(" = " + output);


// Export to CSV
        try{
            extendedCache.exportCSV("hashMap.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

// Serialization
        try{
            extendedCache.serialize("hashMap.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
