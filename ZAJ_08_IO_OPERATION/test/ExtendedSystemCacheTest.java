import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ExtendedSystemCacheTest {

    ExtendedSystemCache extendedCacheToExport;
    ExtendedSystemCache extendedCacheToImport;
    ScatterSystem system;
    String path = new String("testHashMap.csv");
    double[] input = {2.8, -2.6, -6.55, 32.6};

    @BeforeEach
    void setUp() {
        extendedCacheToExport = new ExtendedSystemCache();
        extendedCacheToImport = new ExtendedSystemCache();
        system  = new ScatterSystem();
    }

    @AfterEach
    void tearDown() {
        extendedCacheToExport = null;
        extendedCacheToImport = null;
    }

    @Test
    void testImportExportIsTheSame() {
        Double output = system.makeOperation( input );
        extendedCacheToExport.put( input, output );
       // ExtendedSystemCache beforeExport = extendedCache;

        try {
            extendedCacheToExport.exportCSV(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            extendedCacheToImport.importCSV(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(extendedCacheToExport, extendedCacheToImport);
    }
}