package version1;

// A Java program for Bellman-Ford's single source shortest path
// algorithm.
import java.util.*;
import java.lang.*;
import java.io.*;

// A class to represent a connected, directed and weighted graph
class BellmanFord_Graph {
	// A class to represent a weighted edge in graph
	class Edge {
		int src, dest;
		double weight;
		Edge()
		{
			src = dest = 0;
			weight=0.0;
		}
	};

	int V, E;
	Edge edge[];
	public String[] output;

	// Creates a graph with V vertices and E edges
	BellmanFord_Graph(int v, int e)
	{
		V = v;
		E = e;
		edge = new Edge[e];
		for (int i = 0; i < e; ++i)
			edge[i] = new Edge();
	}

	// The main function that finds shortest distances from src
	// to all other vertices using Bellman-Ford algorithm. The
	// function also detects negative weight cycle
	double[][] BellmanFord(BellmanFord_Graph graph, int src)
	{
		double edges[][] = new double[V][V];
		for (int i = 0; i < V; i++)
			for (int j = 0; j < V; j++)
				edges[i][j] = 0;

		int V = graph.V, E = graph.E;
		double dist[] = new double[V];

		// Step 1: Initialize distances from src to all other
		// vertices as INFINITE
		for (int i = 0; i < V; ++i)
			dist[i] = Double.MAX_VALUE;
		dist[src] = 0;

		// Step 2: Relax all edges |V| - 1 times. A simple
		// shortest path from src to any other vertex can
		// have at-most |V| - 1 edges
		for (int i = 1; i < V; ++i) {
			for (int j = 0; j < E; ++j) {
				int u = graph.edge[j].src;
				int v = graph.edge[j].dest;
				double weight = graph.edge[j].weight;
				if (dist[u] != Double.MAX_VALUE && dist[u] + weight < dist[v])
				{
					dist[v] = dist[u] + weight;
					System.out.println("...xx.."+ edges[0][v]);
					//edges[j][u]=graph.edge[j].weight;
					edges[u][v]=graph.edge[j].weight;
					//edges[v][u]=graph.edge[j].weight;
					for(int k=0;k<V;k++)
					{
						if(k!=v && k!=u)
						{
							edges[k][v]=0;
						}
					}
					System.out.println("....."+ edges[u][v]);
				}
			}
		}

		// Step 3: check for negative-weight cycles. The above
		// step guarantees shortest distances if graph doesn't
		// contain negative weight cycle. If we get a shorter
		// path, then there is a cycle.
		for (int j = 0; j < E; ++j) {
			int u = graph.edge[j].src;
			int v = graph.edge[j].dest;
			double weight = graph.edge[j].weight;
			if (dist[u] != Double.MAX_VALUE && dist[u] + weight < dist[v]) {
				System.out.println("Graph contains negative weight cycle");
			}
		}
		System.out.println("Vertex Distance from Source");
		output = new String[V];
		for (int k = 0; k < V; ++k)
		{
			output[k]=String.valueOf(0);
			output[k]=output[k].concat(" - ");
			output[k]=output[k].concat(String.valueOf(k));
			output[k]=output[k].concat(" :     ");
			output[k]=output[k].concat(String.valueOf(dist[k]));
			System.out.println(k + "\t\t" + dist[k]);
		}
		return edges;
	}

	// A utility function used to print the solution
//	void printArr(double dist[], int V)
//	{
//		System.out.println("Vertex Distance from Source");
//		for (int i = 0; i < V; ++i)
//			System.out.println(i + "\t\t" + dist[i]);
//	}

	// Driver method to test above function
	
}
// Contributed by Aakash Hasija
