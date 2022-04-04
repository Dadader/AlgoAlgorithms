package version1;

import org.jgrapht.*;
import org.jgrapht.alg.scoring.ClusteringCoefficient;
import org.jgrapht.generate.*;
import org.jgrapht.graph.*;
import org.jgrapht.util.*;

class Clustering_Coefficient{
	int v;
	
	Clustering_Coefficient(int a)
	{
		this.v=a;
	}
	public void Graph_Scores(double[][] a)
	{
		Graph<Integer, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);

        for (int i = 0; i <v; i++) {
            graph.addVertex(i);
        }
        
		for(int i=0;i<v;i++)
		{
			for(int j=i;j<v;j++)
			{
				if(a[i][j]>0.0)
				{
				graph.addEdge(i, j);
				
//				k.edge[l].src=i;
//				k.edge[l].dest=j;
//				k.edge[l].weight=Graph_Edges[i][j];
//				l++;
//				System.out.println(l);
				}
			}
		}
		
		ClusteringCoefficient<Integer, DefaultEdge> clusteringCoefficient =
	            new ClusteringCoefficient<>(graph);
		
		System.out.println("-----Local Clustering Coeficient-----");
		System.out.println("Vertex \t Local Coefficient");
		for(int i=0;i<v;i++)
		{
			System.out.println(i+" :\t  "+clusteringCoefficient.getVertexScore(i));
		}
		System.out.println("\n\n-----Average Clustering Coeficient-----");
		System.out.println(clusteringCoefficient.getAverageClusteringCoefficient());
	}
	
}