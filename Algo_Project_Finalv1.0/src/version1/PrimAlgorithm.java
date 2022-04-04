package version1;

import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Comparator;

public class PrimAlgorithm {
	double answer=0;
	double[][] x;
	public String[] output;
	
	class node1 {

		// Stores destination vertex in adjacency list
		int dest;

		// Stores weight of a vertex in the adjacency list
		double weight;

		// Constructor
		node1(int a, double b)
		{
			dest = a;
			weight = b;
		}
	}
	static class Graphs {

		// Number of vertices in the graph
		int V;

		// List of adjacent nodes of a given vertex
		LinkedList<node1>[] adj;

		// Constructor
		Graphs(int e)
		{
			V = e;
			adj = new LinkedList[V];
			for (int o = 0; o < V; o++)
				adj[o] = new LinkedList<>();
		}
	}

	// class to represent a node in PriorityQueue
	// Stores a vertex and its corresponding
	// key value
	class node {
		int vertex;
		double key;
	}

	// Comparator class created for PriorityQueue
	// returns 1 if node0.key > node1.key
	// returns 0 if node0.key < node1.key and
	// returns -1 otherwise
	class comparator implements Comparator<node> {

		@Override
		public int compare(node node0, node node1)
		{
			return (int)((node0.key - node1.key)*1000);
		}
	}

	// method to add an edge
	// between two vertices
	void addEdge(Graphs graph, int src, int dest, double weight)
	{

		node1 node0 = new node1(dest, weight);
		node1 node = new node1(src, weight);
		graph.adj[src].addLast(node0);
		graph.adj[dest].addLast(node);
	}
	
	// method used to find the mst
	double[][] prims_mst(Graphs graph)
	{

		// Whether a vertex is in PriorityQueue or not
		Boolean[] mstset = new Boolean[graph.V];
		node[] e = new node[graph.V];

		// Stores the parents of a vertex
		int[] parent = new int[graph.V];

		for (int o = 0; o < graph.V; o++)
			e[o] = new node();

		for (int o = 0; o < graph.V; o++) {

			// Initialize to false
			mstset[o] = false;

			// Initialize key values to infinity
			e[o].key = Double.MAX_VALUE;
			e[o].vertex = o;
			parent[o] = -1;
		}

		// Include the source vertex in mstset
		mstset[0] = true;

		// Set key value to 0
		// so that it is extracted first
		// out of PriorityQueue
		e[0].key = 0;

		// Use TreeSet instead of PriorityQueue as the remove function of the PQ is O(n) in java.
		TreeSet<node> queue = new TreeSet<node>(new comparator());

		for (int o = 0; o < graph.V; o++)
			queue.add(e[o]);

		// Loops until the queue is not empty
		while (!queue.isEmpty()) {

			// Extracts a node with min key value
			node node0 = queue.pollFirst();

			// Include that node into mstset
			mstset[node0.vertex] = true;

			// For all adjacent vertex of the extracted vertex V
			for (node1 iterator : graph.adj[node0.vertex]) {

				// If V is in queue
				if (mstset[iterator.dest] == false) {
					// If the key value of the adjacent vertex is
					// more than the extracted key
					// update the key value of adjacent vertex
					// to update first remove and add the updated vertex
					if (e[iterator.dest].key > iterator.weight) {
						queue.remove(e[iterator.dest]);
						e[iterator.dest].key = iterator.weight;
						queue.add(e[iterator.dest]);
						parent[iterator.dest] = node0.vertex;
					}
				}
			}
		}

		
		x = new double[graph.V][graph.V];
		for(int i=0;i<graph.V;i++)
		{
			for(int j=0;j<graph.V;j++)
			{
				x[i][j]=0;
			}
		}
		output =new String[graph.V-1];
		// Prints the vertex pair of mstuu
				for (int o = 1; o < graph.V; o++) {
					System.out.println(parent[o] + " " +  "-" + " " + o + " " + e[o].key);
					x[parent[o]][o]=e[o].key;
					answer=answer+e[o].key;
					output[o-1]=String.valueOf(parent[o]);
					output[o-1]=output[o-1].concat(" - ");
					output[o-1]=output[o-1].concat(String.valueOf(o));
					output[o-1]=output[o-1].concat(" :     ");
					output[o-1]=output[o-1].concat(String.valueOf(e[o].key));
					//System.out.println(output[o-1]);
				}
		return x;
	}

}
