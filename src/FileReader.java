import Graph.Edge;
import Graph.Vertex;
import Graph.Graph;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is designed to do all of the file-reading.  That's bascially all it does.  Here's an
 * example of the file that it reads:
 *
 * 8                            //number of vertices
 * Connell                      //Graph.Vertex Names
 * Coulee City
 * Davenport
 * George
 * Moses Lake
 * Ritzville
 * Sprague
 * Wilbur
 * Connell, Moses Lake, 46      //Roads
 * Connell, Ritzville, 45
 * Connell, Wilbur , 99
 * Coulee City, George , 55
 * Coulee City, Moses Lake, 52
 * Coulee City, Wilbur, 35
 * Davenport, Sprague , 38
 * Davenport, Wilbur , 32
 * George,Moses Lake , 31
 * Moses Lake, Ritzville , 42
 * Ritzville, Sprague, 23
 * .
 * Coulee City, Moses Lake      //Routes to determine shortest path to (closes the road between these two cities)
 * George, Moses Lake
 * Seattle, Spokane
 *
 * @author dosterji
 * @date 12/4/2017
 */
public class FileReader {
    private Scanner scan;                //The scanner to use
    private ArrayList<Vertex> verts;     //The array of vertices
    private ArrayList<Edge> edges;       //The array of edges
    private boolean has_read = false;

    public FileReader(String fileName) throws IOException {
        File f = new File(fileName);
        scan = new Scanner(f);
    }

    /**
     * Read in the file and returns a data structure that can be used in Dijkstra class
     * to solve te algorithm
     */
    public Graph read() {
        has_read = true;
        readVerts();
        readEdges();
        //printVerts();
        //printEdges();
        return new Graph(verts, edges);
    }

    /**
     * Does the vertex establishment part of the reading
     */
    public void readVerts() {
        int n;
        n = scan.nextInt();
        verts = new ArrayList<Vertex>();

        scan.nextLine();    //Get to the nextLine

        for(int i=0; i<n; i++) {
            verts.add(new Vertex(scan.nextLine()));
        }
    }

    /**
     * Does the edge establishment part of the reading
     */
    public void readEdges() {
        edges = new ArrayList<Edge>();
        String line = scan.nextLine();
        while(!line.equals(".")) {
            edges.add(new Edge(line));
            line = scan.nextLine();
        }
    }

    /**
     * A method for getting the problem instance.
     * Must be called after read.
     *
     * @return A String array containing the two cities to find
     *          the shortest distance between
     * @throws IllegalStateException if read has not been called
     *          before this method
     */
    public String[] getProblemInstance() {
        if(!has_read)
            throw new IllegalStateException();
        if(!scan.hasNextLine())
            return null;
        String line = scan.nextLine();
        return line.split("\\s*, \\s*");  //split the String around the comma
    }

    /**
     * The following two methods were for bug-catching
     */
    public void printVerts() {
        String s = "";
        for(int i=0; i<verts.size(); i++) {
            s += verts.get(i).name + " ";
        }
        System.out.println(s);
    }
    public void printEdges() {
        String s = "";
        for(int i=0; i<edges.size(); i++) {
            s += edges.get(i).city1 + " ";
            s += edges.get(i).city2 + " ";
            s += edges.get(i).length + " ";
        }
        System.out.println(s);
    }
}
