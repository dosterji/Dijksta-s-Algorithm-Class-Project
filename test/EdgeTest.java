import Graph.Edge;
import org.junit.Test;

import static org.junit.Assert.*;

public class EdgeTest {

    @Test
    public void testConstructor() {
        Edge e = new Edge("Moses Lake, Ritzville, 42");
        assertEquals("Moses Lake", e.city1);
        assertEquals("Ritzville", e.city2);
        assertEquals(42, e.length);
    }

}