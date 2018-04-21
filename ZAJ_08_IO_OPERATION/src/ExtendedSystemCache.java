import java.io.*;
import java.util.HashMap;

public class ExtendedSystemCache extends SystemCache{
    private HashMap<Parameter, Double> cache = new HashMap<>();

    // wyeksportuje wszystkie przechowywane w mapie obiekty do pliku CSV
    void exportCSV( String path ) throws IOException {
        File file = new File(path);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            StringBuilder builder = new StringBuilder();
            builder.append(cache);
            fileWriter.write(builder.toString());
            System.out.println("Done2");
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //close resources
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    void exportCSV( File file ) throws IOException{
        //File file = new File("/Users/pankaj/FileWriter.txt");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            StringBuilder builder = new StringBuilder();
            builder.append(cache);
            fileWriter.write(builder.toString());
            System.out.println("Done1");
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //close resources
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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


    // zapisze do pliku wszystkie pola znajdujące się w ExtendedSystemCache wykorzystując mechanizm serializacji
    void serialize( String path ) throws IOException{

    }
    void serialize ( File file ) throws IOException{

    }
    void serialize ( OutputStream stream ) throws IOException{

    }


    // odczyta z pliku wszystkie pola znajdujące się w ExtendedSystemCache wykorzystując mechanizm serializacji
    void deserialize( String path ) throws IOException{

    }
    void deserialize( File file ) throws IOException{

    }
    void deserialize( InputStream stream ) throws IOException{

    }

// nie wolno powielać kodu dla różnych przeładowań metod
}
