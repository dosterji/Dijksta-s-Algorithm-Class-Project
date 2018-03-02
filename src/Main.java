/**
Name: John Doster
Assignment: Programming Assignment 5
Course/Semester: CS 371 - Fall 2017
Instructor: Dr. Wolff
Sources consulted: Java API online
Known Bugs: n/a
Special instructions: Run it from the main method.  It will
                        automatically use roads.in.
                      The three classes making up graph may need
                      to be placed in their own package "Graph" to work.
*/
import Graph.Vertex;

import java.io.IOException;

/**
 * Functions as the intermediary between the user
 * and the rest of the program.  When run, it should take in
 * data from "roads.in" automatically.
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Dijkstra d = new Dijkstra("roads.in");
        String arrow_str = " <--> ";

        Vertex v = d.solveProblem();
        while(v!=null) {
            int total_distance = v.distance;
            String s = "";
            s += v.name;
            while (v.parent != null) {
                s += arrow_str;
                v = v.parent;
                s += v.name;
            }
            System.out.println(s);
            if( v.distance != -1)
                System.out.println("Total distance: " + total_distance +" miles\n");
            v = d.solveProblem();
        }//End while
    }
}