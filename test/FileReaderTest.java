import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class FileReaderTest {


    @Test
    public void read() throws Exception {
        FileReader fr = new FileReader("roads.in");
        fr.read();
    }

    @Test
    public void printArray() throws Exception {
    }

}