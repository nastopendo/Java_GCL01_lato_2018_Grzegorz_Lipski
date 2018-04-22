import java.io.*;
import java.util.HashMap;

public class ExtendedSystemCache extends SystemCache implements Serializable{
    private HashMap<Parameter, Double> cache = new HashMap<>();


// ------------------- EXPORT TO CSV -------------------------


    // wyeksportuje wszystkie przechowywane w mapie obiekty do pliku CSV
    void exportCSV( String path ) throws IOException {
        File file = new File(path);
        FileWriter fileWriter = new FileWriter(file);
        StringBuilder builder = new StringBuilder();
        for (HashMap.Entry<Parameter, Double> entry : cache.entrySet()) {
            Parameter key = entry.getKey();
            Double value = entry.getValue();
            builder.append(key.toString());
            builder.append(value.toString());
            builder.append("\n");
        }
        fileWriter.write(builder.toString());
        System.out.println("Done2");
        fileWriter.close();
    }
    void exportCSV( File file ) throws IOException{

    }
    void exportCSV( OutputStream stream ) throws IOException{

    }


    // zaimportuje wszystkie rekordy z pliku CSV do mapy
    void importCSV( String path ) throws IOException{

    }
    void importCSV( File file ) throws IOException{

    }
    void importCSV( InputStream stream ) throws IOException{

    }


// ------------------- SERIALIZATION -------------------------


    // zapisze do pliku wszystkie pola znajdujące się w ExtendedSystemCache wykorzystując mechanizm serializacji
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


    // odczyta z pliku wszystkie pola znajdujące się w ExtendedSystemCache wykorzystując mechanizm serializacji
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
