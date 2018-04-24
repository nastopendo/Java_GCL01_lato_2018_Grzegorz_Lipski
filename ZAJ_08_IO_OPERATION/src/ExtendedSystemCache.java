import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class ExtendedSystemCache extends SystemCache implements Serializable{



// ------------------- EXPORT TO CSV -------------------------

    void exportCSV( String path ) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        exportCSV(fileOutputStream);
    }
    void exportCSV( FileOutputStream fileOutputStream ) throws IOException{
        OutputStream outputStream = fileOutputStream;
        exportCSV(outputStream);
    }
    void exportCSV( OutputStream outputStream ) throws IOException{
        StringBuilder builder = new StringBuilder();
        for (HashMap.Entry<Parameter, Double> entry : cache.entrySet()) {
            Parameter key = entry.getKey();
            for (Double x: key.values) {
                builder.append(x.toString());
                builder.append(", ");
            }
            Double value = entry.getValue();
            builder.append(value.toString());
            builder.append("\n");
        }
        Writer outputStreamWriter = new OutputStreamWriter(outputStream);
        outputStreamWriter.write(builder.toString());
        outputStreamWriter.close();
    }

    // ------------------- IMPORT FROM CSV -------------------------

    void importCSV( String path ) throws IOException{
        File file = new File(path);
        importCSV(file);
    }
    void importCSV( File file ) throws IOException{
        Scanner scanner = new Scanner(file);
        importCSV(scanner);
        scanner.close();
    }
    void importCSV( Scanner scanner ) throws IOException{
        while(scanner.hasNextLine()){
            String str[] = scanner.nextLine().split(", ");
            double tab[] = new double[str.length-1];
            for (int i = 0; i < str.length-1; i++) {
                tab[i] = Double.parseDouble(str[i]);
            }
            double value = Double.parseDouble(str[str.length-1]);
            cache.put(new Parameter(tab), value);
        }
    }


// ------------------- SERIALIZATION -------------------------

    void serialize( String path ) throws IOException{
        FileOutputStream file = new FileOutputStream(path);
        serialize(file);
        file.close();
    }
    void serialize ( FileOutputStream file ) throws IOException{
        ObjectOutputStream stream = new ObjectOutputStream(file);
        serialize(stream);
        stream.close();
    }
    void serialize ( ObjectOutputStream stream ) throws IOException{
        stream.writeObject(cache);
    }


// ------------------- DESERIALIZATION -------------------------

    void deserialize( String path ) throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(path);
        deserialize(file);
        file.close();
    }
    void deserialize( FileInputStream file ) throws IOException, ClassNotFoundException {
        ObjectInputStream stream = new ObjectInputStream(file);
        deserialize(stream);
        stream.close();
    }
    void deserialize( ObjectInputStream stream ) throws IOException, ClassNotFoundException {
        cache = (HashMap<Parameter,Double>) stream.readObject();
    }
}
