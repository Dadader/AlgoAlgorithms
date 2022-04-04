package version1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import org.w3c.dom.css.Rect;

import version1.PrimAlgorithm.Graphs;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Algo_Selection_GUI {
	private String [] output;
	private JFrame frame;
	private String Algorithm;
	private String File_Name;
	List<point> Graph_Nodes = new ArrayList<>();
	double[][] Graph_Edges;
	double [][] Result;
	int Nodes;
	int Edges;
	int flag=0;
	double answer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Algo_Selection_GUI window = new Algo_Selection_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Algo_Selection_GUI() {
		initialize();
	}
	private void print()
	{
		System.out.println("hello");
	}
	 public void createAndShowGui() {

	    /* Main panel */
      Graph_GUI mainPanel = new Graph_GUI(Graph_Nodes,Graph_Edges,Nodes);
     /* creating the frame */
      JFrame frame = new JFrame("Sample Graph");
      frame.setPreferredSize(new Dimension(1600, 1600));
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.setBackground(Color.DARK_GRAY);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
  }
	 public void create_And_ShowGui() {

		    /* Main panel */
	      Graph_GUI mainPanel = new Graph_GUI(Graph_Nodes,Result,Nodes);
	     /* creating the frame */
	      JFrame frame = new JFrame("Sample Graph");
	      frame.setPreferredSize(new Dimension(1600, 1600));
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.getContentPane().add(mainPanel);
	      frame.setBackground(Color.DARK_GRAY);
	      frame.pack();
	      frame.setLocationRelativeTo(null);
	      frame.setVisible(true);
	  }

	public void kruskal()
	{
		int l=0;
		Kruskal_MST k =new Kruskal_MST(Nodes,Edges);
		for(int i=0;i<Nodes;i++)
		{
			for(int j=0;j<Nodes;j++)
			{
				if(Graph_Edges[i][j]>0.0)
				{
				k.edge[l].src=i;
				k.edge[l].dest=j;
				k.edge[l].weight=Graph_Edges[i][j];
				l++;
				System.out.println(l);
				}
			}
		}
		//Graph_Edges=new double[Nodes][Nodes];
		Result = k.KruskalMST();
		output = k.output;
		answer = k.answer;
	}
	
	
	public void Bellman_Ford()
	{
		int l=0;
		BellmanFord_Graph k =new BellmanFord_Graph(Nodes,Edges);
		for(int i=0;i<Nodes;i++)
		{
			for(int j=0;j<Nodes;j++)
			{
				if(Graph_Edges[i][j]>0.0)
				{
				k.edge[l].src=i;
				k.edge[l].dest=j;
				k.edge[l].weight= Graph_Edges[i][j];
				l++;
				System.out.println(l);
				}
			}
		}
		//Graph_Edges=new double[Nodes][Nodes];
		//Graph_Edges = 
		Result= k.BellmanFord(k, 0);
		output=k.output;
	}
	
	
	public void Dijkstra()
	{
		int l=0;
		ShortestPath k =new ShortestPath(Nodes);
//		for(int i=0;i<Nodes;i++)
//		{
//			for(int j=0;j<Nodes;j++)
//			{
//				if(Graph_Edges[i][j]>0.0)
//				{
//				k.edge[l].src=i;
//				k.edge[l].dest=j;
//				k.edge[l].weight= Graph_Edges[i][j];
//				l++;
//				System.out.println(l);
//				}
//			}
//		}
		//Graph_Edges=new double[Nodes][Nodes];
		//Graph_Edges = 
		Result=k.dijkstra(Graph_Edges, 0);
		output = k.output;
	}
	
	void Borukas()
	{
		Boruvka g = new Boruvka(Nodes,Edges);
		for(int i=0;i<Nodes;i++)
		{
			for(int j=0;j<Nodes;j++)
			{
				if(Graph_Edges[i][j]>0.0)
				{
				g.addEdge(i, j, Graph_Edges[i][j]);
				
//				k.edge[l].src=i;
//				k.edge[l].dest=j;
//				k.edge[l].weight=Graph_Edges[i][j];
//				l++;
//				System.out.println(l);
				}
			}
		}
		Result = g.BorukaMST();
		output=g.answer;
		answer= g.ans_MST;
		for(int i=0;i<10;i++)
		{
			System.out.println(output[i]);
		}
		// Find MST
//		Result=g.boruvkaMST();
//		output=g.output;
//		answer= g.answer;
		
	}
	void clsteringcoefficient()
	{
		Clustering_Coefficient k =new Clustering_Coefficient(Nodes);
		k.Graph_Scores(Graph_Edges);
		
	}
	void prim()
	{
		Graphs g =new Graphs(Nodes);
		PrimAlgorithm p = new PrimAlgorithm();
		for(int i=0;i<Nodes;i++)
		{
			for(int j=0;j<Nodes;j++)
			{
				if(Graph_Edges[i][j]>0.0)
				{
				p.addEdge(g, i, j, Graph_Edges[i][j]);
//				k.edge[l].src=i;
//				k.edge[l].dest=j;
//				k.edge[l].weight=Graph_Edges[i][j];
//				l++;
//				System.out.println(l);
				}
			}
		}
		Result=p.prims_mst(g);
		output=p.output;
		System.out.println(p.output[8]);
		answer=p.answer;
	}
	
	void FloydWarshall() {
		double[][] temp =new double[Nodes][Nodes];
		for(int i=0;i<Nodes;i++)
		{
			for(int j=0;j<Nodes;j++)
			{
				if(i!=j)
				{
					if(Graph_Edges[i][j]>0.0)
					{
						temp[i][j]=Graph_Edges[i][j];
					}
					else
					{
						temp[i][j]=99999;
					}
				}
				else
				{
					temp[i][j]=0.0;
				}
				System.out.print(temp[i][j] + " ");
			}
			System.out.println("\n");
			
		}
		AllPairShortestPath k =new AllPairShortestPath(Nodes);
		Result=k.floydWarshall(temp);
		output=k.output;

	}
    /*the main method runs createAndShowGui*/

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GREEN);
		frame.getContentPane().setLayout(null);
		JButton Show_Button = new JButton("Show");
		JLabel lblNewLabel = new JLabel("ALGORITHM'S IMPLEMENTATION");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 424, 58);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Algorithms:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_1.setBounds(10, 89, 90, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nodes");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_1_1.setBounds(10, 128, 90, 28);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton Graph_Button = new JButton("Show Graph");
		Graph_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Extraction e = new Extraction(Graph_Nodes,File_Name,Graph_Edges);
				try {
					e.extract();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(Graph_Edges[6][0]);
				//Graph g= new Graph(Graph_Nodes,Graph_Edges,Nodes);
				//g.
				SwingUtilities.invokeLater(new Runnable() {
			         public void run() {
			            createAndShowGui();
			         }
			      });
				//createAndShowGui();
			}
		});
		Graph_Button.setFont(new Font("Arial Black", Font.BOLD, 12));
		Graph_Button.setForeground(Color.BLACK);
		Graph_Button.setBackground(Color.GRAY);
		Graph_Button.setBounds(10, 167, 301, 28);
		frame.getContentPane().add(Graph_Button);
		
		JComboBox Algo_Comb = new JComboBox();
		Algo_Comb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				Algorithm = (String) Algo_Comb.getSelectedItem();
				System.out.println(Algorithm);
				Show_Button.setVisible(false);
				
				
			}
		});
		Algo_Comb.setModel(new DefaultComboBoxModel(new String[] {"prim's", "kruskal", "BellmanFord","Dijkstra","FloydWarshall","Boruvka's","ClusteringCoefficient"}));
		Algo_Comb.setSelectedIndex(0);
		Algo_Comb.setBounds(110, 89, 189, 28);
		frame.getContentPane().add(Algo_Comb);
		
		JComboBox Node_Comb = new JComboBox();
		Node_Comb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File_Name="F:\\benchmark\\input";
				String nodes= (String) Node_Comb.getSelectedItem();			
				File_Name = File_Name.concat(nodes);
				File_Name = File_Name.concat(".txt");
				System.out.println(File_Name);
				 Nodes = Integer.valueOf(nodes);
				Graph_Edges = new double[Nodes][Nodes];
				Show_Button.setVisible(false);
			}
		});
		Node_Comb.setModel(new DefaultComboBoxModel(new String[] {"10", "20", "30", "40", "50", "60", "70", "80", "90", "100"}));
		Node_Comb.setSelectedIndex(0);
		Node_Comb.setBounds(110, 128, 189, 28);
		frame.getContentPane().add(Node_Comb);
		
		JButton Graph_Button_1 = new JButton("Show Derived Graph");
		Graph_Button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Extraction e = new Extraction(Graph_Nodes,File_Name,Graph_Edges);
				try {
					e.extract();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(Graph_Edges[6][0]);
				Edges = e.edges();
				if((String)Algo_Comb.getSelectedItem()=="prim's")
				{
					prim();
					 flag=1;
				}
				if((String)Algo_Comb.getSelectedItem()=="kruskal")
				{
					kruskal();
					flag=1;
				}
			//Dijkstra();
				if((String)Algo_Comb.getSelectedItem()=="FloydWarshall")
				{
					FloydWarshall();
					flag=0;
				}
				if((String)Algo_Comb.getSelectedItem()=="BellmanFord")
				{
					Bellman_Ford();
					flag=0;
				}
				if((String)Algo_Comb.getSelectedItem()=="Dijkstra")
				{
					Dijkstra();
					flag=0;
				}
				if((String)Algo_Comb.getSelectedItem()=="Boruvka's")
				{
					System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
					Borukas();
					flag=1;
				}
				//FloydWarshall();
			//kruskal();
			//	Bellman_Ford();
				//MST m= new MST();
				//m.primMST(Graph_Edges);
				//Graph g= new Graph(Graph_Nodes,Graph_Edges,Nodes);
				//g.
				if((String)Algo_Comb.getSelectedItem()!="ClusteringCoefficient")
				{
					//System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
					//Borukas();
				
				SwingUtilities.invokeLater(new Runnable() {
			         public void run() {
			            create_And_ShowGui();
			         }
			      });
			}
				else
				{
					clsteringcoefficient();
					flag=0;
				}
				Show_Button.setVisible(true);
			}
		});
		Graph_Button_1.setForeground(Color.BLACK);
		Graph_Button_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		Graph_Button_1.setBackground(Color.GRAY);
		Graph_Button_1.setBounds(10, 206, 301, 28);
		frame.getContentPane().add(Graph_Button_1);
		
		
		Show_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String[] res= {"1","2"};
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Result frame = new Result(output);
							frame.setVisible(true);
							if(flag==1)
							{
								frame.lblSourceNode_1.setText("Cost:     "+String.valueOf(answer));
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
				
			}
		});
		
		Show_Button.setForeground(Color.BLACK);
		Show_Button.setFont(new Font("Arial Black", Font.BOLD, 12));
		Show_Button.setBackground(Color.GRAY);
		Show_Button.setBounds(321, 167, 103, 67);
		frame.getContentPane().add(Show_Button);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
