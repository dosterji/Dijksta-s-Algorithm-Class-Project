/**
 Name: John Doster
 Assignment: Programming Assignment 5
 Course/Semester: CS 371 - Fall 2017
 Instructor: Dr. Wolff
 Sources consulted: Java API online
 Known Bugs: n/a
 Special instructions: Run it from the main method.  It will
 automatically use roads.in
 */
package Graph;

/**
 * This class represents the edges in the graph.
 * It purely functions as a data holder.  The fields
 * have been made public for ease of use.
 *
 * @author dosterji
 * @date 12/4/2017
 */
public class Edge {
    //FIELDS (made public for ease of use)
    public String city1, city2;     //the names of the two cities involved
    public int length;              //length of the edge

    public Edge(String line) {
        String[] data = line.split("\\s*, \\s*");
        city1 = data[0];
        city2 = data[1];
        length = Integer.parseInt(data[2]);
    }

    /**
     * A method for seeing if a given city is connected
     * to this edge.
     *
     * @param city The city to be looked for
     * @return True if city is either city1 or city2.  False otherwise.
     */
    public boolean contains(String city) {
        if(city.equals(city1) || city.equals(city2))
            return true;
        else
            return false;
    }

    /**
     * Returns the name of the city opposite the given city on this
     * road if it exists
     *
     * @param city On of the cities on this edge, either city1 or city2
     * @return The name of the other city
     */
    public String getOtherCity(String city) {
        if(city.equals(city1))
            return city2;
        else if(city.equals(city2))
            return city1;
        else
            return null;
    }

    public String toString() {
        return city1 + ", " + city2 + ", " +length;
    }
}
