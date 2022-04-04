package version1;

// A Java program for Floyd Warshall All Pairs Shortest
// Path algorithm.
import java.util.*;
import java.lang.*;
import java.io.*;


class AllPairShortestPath
{
	public String[] output;
	final static double INF = 99999;
	int V = 10;
	
	public AllPairShortestPath(int a)
	{
		this.V=a;
	}

	double[][] floydWarshall(double graph[][])
	{
		double edges[][] = new double[V][V];
		double dist[][] = new double[V][V];
		int i, j, k;

		/* Initialize the solution matrix
		same as input graph matrix.
		Or we can say the initial values
		of shortest distances
		are based on shortest paths
		considering no intermediate
		vertex. */
		for (i = 0; i < V; i++)
			for (j = 0; j < V; j++)
				dist[i][j] = graph[i][j];
		for (i = 0; i < V; i++)
			for (j = 0; j < V; j++)
				edges[i][j] = 0;

		/* Add all vertices one by one
		to the set of intermediate
		vertices.
		---> Before start of an iteration,
			we have shortest
			distances between all pairs
			of vertices such that
			the shortest distances consider
			only the vertices in
			set {0, 1, 2, .. k-1} as
			intermediate vertices.
		----> After the end of an iteration,
				vertex no. k is added
				to the set of intermediate
				vertices and the set
				becomes {0, 1, 2, .. k} */
		for (k = 0; k < V; k++)
		{
			// Pick all vertices as source one by one
			for (i = 0; i < V; i++)
			{
				// Pick all vertices as destination for the
				// above picked source
				for (j = 0; j < V; j++)
				{
					// If vertex k is on the shortest path from
					// i to j, then update the value of dist[i][j]
					if (dist[i][k] + dist[k][j] < dist[i][j])
					{	dist[i][j] = dist[i][k] + dist[k][j];
						edges[i][k]=graph[i][k];
						edges[k][j]=graph[k][j];
					}
				}
			}
		}
		for (i=0; i<V; ++i)
		{
			for (j=0; j<V; ++j)
			{
				if (edges[i][j]==99999)
					edges[i][j]=0;
				//	System.out.print("INF ");
			//	else
					System.out.print(edges[i][j]+" ");
			}
			System.out.println();
		}

		// Print the shortest distance matrix
		printSolution(dist);
		return edges;
	}

	void printSolution(double dist[][])
	{
		int k=0;
		output =new String[(V*V)];
		System.out.println("The following matrix shows the shortest "+
						"distances between every pair of vertices");
		for (int i=0; i<V; ++i)
		{
			for (int j=0; j<V; ++j)
			{
				if (dist[i][j]==99999)
				{
				System.out.print("INF ");
				output[k]=String.valueOf(i);
				output[k]=output[k].concat(" - ");
				output[k]=output[k].concat(String.valueOf(j));
				output[k]=output[k].concat(" :     ");
				output[k]=output[k].concat("INF");
				}
				else
				{
					System.out.print(dist[i][j]+" ");
					output[k]=String.valueOf(i);
					output[k]=output[k].concat(" - ");
					output[k]=output[k].concat(String.valueOf(j));
					output[k]=output[k].concat(" :     ");
					output[k]=output[k].concat(String.valueOf(dist[i][j]));
				}
				k++;
			}
			System.out.println();
		}
	}

	// Driver program to test above function
	
}

// Contributed by Aakash Hasija
