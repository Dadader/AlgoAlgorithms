package version1;

import java.util.*;


public class Boruvka
{ 

class Graph_Edge
{
    int v;
    int u;
    double cost;
    Graph_Edge(int v,int u,double cost)
    {
        this.v=v;
        this.u=u;
        this.cost=cost;
    }
}

static int root(int v)
  {
      if(parent[v]==v)
      return v;
      
      return parent[v]=root(parent[v]);
  }
  
static boolean merge(int v,int u)
  {
      v=root(v);
      u=root(u);
      if(v==u)
      return false;
      parent[v]=u;
      return true;
  }
 
static void init(int n)
  {
      for(int i=0;i<n;i++)
      {
          parent[i]=i;
      }
  }
  
Boruvka(int a,int b)
{
	this.V=a;
	parent = new int[this.V];
	Min = new int[V];
	g=new Graph_Edge[b];
}

public void addEdge(int src,int dest,double weight)
{
	g[edges] = new Graph_Edge(src,dest,weight);
	edges++;
}
  static int V;
  static int parent[]; 
  static int Min[]; 
  Graph_Edge g[];
  static int edges=0;
  public String[] answer;
  public double ans_MST=0;

  public double[][] BorukaMST()
  {
  
  // Initializes parent of all nodes.
  init(V);
  double output[][] = new double[V][V];
		for (int i = 0; i < V; i++)
			for (int j = 0; j < V; j++)
				output[i][j] = 0;
  
  //int edges = g.length-1;
  
  int components = V;
  
  
  while(components>1)
  {
      // Initialize Min for each component as -1.
      for(int i=0;i<V;i++)
      {
          Min[i]=-1;
      }
      for(int i=0;i<edges;i++)
      {
          // If both source and end are from same component we don't process them.
          if(root(g[i].v)==root(g[i].u))
          continue;
          
          int r_v=root(g[i].v);
          if(Min[r_v]==-1 || g[i].cost < g[Min[r_v]].cost)
          Min[r_v]=i;
          
          int r_u=root(g[i].u);
          if(Min[r_u]==-1 || g[i].cost < g[Min[r_u]].cost)
          Min[r_u]=i;
          
      }
      answer=new String[this.V];
      //int k=0;
      for(int i=0;i<V;i++)
      {
          if(Min[i]!=-1)
          {
              if(merge(g[Min[i]].v,g[Min[i]].u))
              {
            	  output[g[Min[i]].v][g[Min[i]].u]=g[Min[i]].cost;
//            	  System.out.println("vfg...."+g[Min[i]].u);
      			ans_MST+=g[Min[i]].cost;
      		//	System.out.println(answer[k] + " "+k);
                  components--;
                 // k++;
              }
          }
      }
  }
  int k=0;
  for(int i=0;i<10;i++)
	{
	  for(int j=0;j<10;j++)
	  {
		  if(output[i][j]>0)
		  {
			  answer[k]=String.valueOf(i);
    			answer[k]=answer[k].concat(" - ");
    			answer[k]=answer[k].concat(String.valueOf(j));
    			answer[k]=answer[k].concat(" - ");
    			answer[k]=answer[k].concat(String.valueOf(output[i][j]));
    			//ans_MST+=g[Min[i]].cost;
    			k++;
		  }
	  }
		//System.out.println(answer[i]);
	}
  System.out.println("The Total Weight of Minimum Spanning Tree is : "+ans_MST);
  return output;
}

  }
 
  
