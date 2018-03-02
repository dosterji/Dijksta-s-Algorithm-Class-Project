import Graph.Vertex;
import org.junit.Test;

import static org.junit.Assert.*;

public class VertexTest {

    @Test
    public void testConstructor() {
        Vertex v = new Vertex("John");
        assertEquals("John", v.name );
        assertEquals(null, v.parent);
        assertEquals(0, v.distance);
    }

    @Test
    public void testConstructor2() {
        Vertex v = new Vertex("John");
        Vertex v1 = new Vertex("Jacob", v, 20 );
        assertEquals("Jacob", v1.name );
        assertEquals(v, v1.parent);
        assertEquals(20, v1.distance);
    }

    @Test
    public void testCompareTo() {
        Vertex v = new Vertex("John", null, 20);
        Vertex v2 = new Vertex("Jacob", null, 30);
        Vertex v3 = new Vertex("Johnson", null, 20);
        Vertex v4 = new Vertex("JingleHeimer", null, 20);

        assertEquals(1, v.compareTo(v2));
        assertEquals(1, v.compareTo(v3));
        assertEquals(1, v.compareTo(v3));
        assertEquals(-1, v.compareTo(v4));
    }
}