package Graph; /**
 Name: John Doster
 Assignment: Programming Assignment 5
 Course/Semester: CS 371 - Fall 2017
 Instructor: Dr. Wolff
 Sources consulted: Java API online
 Known Bugs: n/a
 Special instructions: Run it from the main method.  It will
 automatically use roads.in
 */

/**
 * This is a class that represents a vertex in the "road-map"
 *
 * It is to be used in the adjacency list/adjacency matrix used to solve the
 * problem using Dijkstra's Algorithm
 *
 * @author dosterji
 * @date 12/3/2017
 */
public class Vertex implements Comparable {
    //FIELDS (made public for ease of use)
    public int distance;        //The distance from the source vertex
    public String name;         //The name of this Graph.Graph.Vertex
    public Vertex parent;       //The parent vertex to this
    private boolean visited;

    ////////////////
    //CONSTRUCTORS//
    ////////////////
    public Vertex(String name) {this(name, null, 0); }
    public Vertex(String name, Vertex parent, int distance) {
        this.name = name;
        this.distance = distance;
        this.parent = parent;
        visited = false;
    }//END CONSTRUCTORS


    /////////////////
    //OTHER METHODS//
    /////////////////

    public boolean visit() { return visited = true; }
    public boolean wasVisited() { return visited; }
    public void resetVisit() { visited = false; }
    /**
     * A method for comparing two Vertices.  Is based on the distance from the source vertex.
     * If there is a tie between this vertex and the parameter, alphabetical order determines
     * the outcome.
     *
     * @param o The object to be compared to this
     * @return  An integer.  -1 if this has a shorter distance or 1 if other does.
     */
    @Override
    public int compareTo(Object o) {
        if( distance>((Vertex) o).distance )
            return 1;
        else if( distance<((Vertex) o).distance )
            return -1;
        else
            return determineAlfabeticalOrder(((Vertex) o).name);    //Choose the alphabetically first Graph.Graph.Vertex
    }

    /**
     * This method is for determining the alphabetical order of two strings (and thus this vertex and another
     *
     * @param other The name of the other vertex
     * @return An integer. -1 if this is alphabetically first and 1 otherwise.
     */
    private int determineAlfabeticalOrder( String other) {
        int n;
        if( name.length() > other.length() )
            n = other.length();
        else
            n = name.length();

        //loop for determining alphabetical preference
        for(int i = 0; i<n; i++) {
            if( name.charAt(i)>other.charAt(i) )
                return -1;
            else if( name.charAt(i)<other.charAt(i) )
                return 1;
        }
        if( name.length()>other.length() )
            return -1;  //If other is a sub-word of this, other is alphabetically first.
        else
            return 1;
    }

    //TO STRING
    public String toString() {
        return name;
    }
}
