package version1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import version1.point;

public class Extraction {
	
	List<point> graphPoints;
	String file;
	double[][] Graph;
	int Edges;
	
	public Extraction(List<point> Pooints,String f,double[][] g) {
		this.graphPoints = Pooints;
		this.file = f;
		this.Graph =g;
		Edges=0;
	}
	public int edges()
	{
		return Edges;
	}
	
	public void extract() throws FileNotFoundException
	{
		
		String data;
		File myObj= new File(file);
		System.out.println(file);
		
		
		Scanner myread =new Scanner(myObj);
		myread.nextLine();
		myread.nextLine();
		
		data = myread.nextLine();
		
		int a= Integer.valueOf(data);
		System.out.println(a);
		//System.out.println("....a....."+a);
		myread.nextLine();
		//Graph=new double[a][a];
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				Graph[i][j]=0.0;
				System.out.println(Graph[i][j] + " ");
			}
			//System.out.println("\n");
	
		}
		for(int i=0;i<a;i++)
		{
			data = myread.nextLine();
			String[] g= data.split("\t");
			double x1 = Double.valueOf(g[1]);
			double x2 = Double.valueOf(g[2]);
	//		System.out.println(g[0]);
			graphPoints.add(new point(x1,x2));
		}
		System.out.println("x1=   "+graphPoints.get(0).getX());
		myread.nextLine();
		//String ak;
		int cols=0,rows=0,flag;
		while(myread.hasNext())
		{
			 flag=0;
			 data = myread.nextLine();
			 String [] hg=data.split("\t");
			// System.out.println("....." + hg[0] + "....");
			 for( String ak : hg)
			 {
				 if(flag==0)
				 {
					 rows=Integer.valueOf(ak);
					 flag=1;
				 }
				 else if(flag==1)
				 {
					  System.out.println("....." + flag + "....");
					  System.out.println("....." + ak + "....");
					  cols=Integer.valueOf(ak);
					  flag=2;
				 }
				 else if(flag==2)
				 {
					 flag=3;
				 }
				 else if(flag==3)
				 {
					 if(rows != cols)
					 {
					 double weight = Double.valueOf(ak);
					 weight/=10000000;
					 double alk=Graph[rows][cols];
					 if(alk> weight && alk>0.0)
					 {
					 Graph[rows][cols]=weight;
					 Graph[cols][rows]=weight;
					 //Edges++;
					 }
					 else 
					 if(alk==0.0 )
					 {
						 Graph[rows][cols]=weight;
						  Graph[cols][rows]=weight;
						 Edges+=2;
					 }
					 }
					 flag=4;
					 System.out.println(".....jjj...");
	
				 }
				 else if(flag==4)
				 {
					 flag=1;
				 }
				 
			 }
			//System.out.println(data);
			System.out.println("\n....\n");
		}
		myread.close();
		System.out.println(Edges);
		for(int i=0;i<a;i++)
		{
			for(int j=0;j<a;j++)
			{
				System.out.print(Graph[i][j] + " ");
			}
			System.out.println("\n");
	
		}
	}

}
