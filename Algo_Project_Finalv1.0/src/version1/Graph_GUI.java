package version1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Graph_GUI extends JPanel{

    
 
    //private static final long serialVersionUID = 1L;
    private int labelPadding = 25;
    /**change the line color to the best you want;*/
    private Color lineColor = new Color(255,255,254);
    private Color pointColor = new Color(255,0,255 );
    private Color gridColor = new Color(200, 200, 200, 200);
    private static final Stroke GRAPH_STROKE = new BasicStroke(2f);
    private static int pointWidth = 10;
    private int numberYDivisions = 10;
    //private List<Double> scores;
    private int padding = 20;
    List<point> graphPoints;
    List<point> Edges;
    double[][] Adjancey_Matrix;

    	
	/**
	 * Math_Graph is a constructor method
	 * @returns List scores;
	 */
    public Graph_GUI(List<point> p, double [][] a, int size) {
        this.graphPoints = p;
        this.Adjancey_Matrix =a;
        this.numberYDivisions = size;
        System.out.println(size);
        
    }
public Graph_GUI()
{
	
}
    @Override
    protected void paintComponent(Graphics g) {
    	
        super.paintComponent(g);
        System.out.println("kkkkkkk");
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        double xScale = ((double) getWidth() - (2 * padding) - labelPadding) / 10;
        double yScale = ((double) getHeight() - 2 * padding - labelPadding) / 10;
     //   double a= getWidth();
        System.out.println(xScale);

//        Random random = new Random();
//        List<point> graphPoints = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            double x1= random.nextDouble() * 0.9;
//            double y1= random.nextDouble() * 0.9;
//            graphPoints.add(new point(x1, y1));
//        }

        g2.setColor(Color.green);
	    //fill the rect
        
        g2.fillRect(padding + labelPadding, padding, getWidth() - (2 * padding) - 
        		labelPadding, getHeight() - 2 * padding - labelPadding);
        //g2.setColor(Color.red);
        	
          double kh=0.1;
        for (int i = 0; i < numberYDivisions+1; i++) {
            int x0 = padding + labelPadding;
            int x1 = pointWidth + padding + labelPadding;
            System.out.println(numberYDivisions);
            int y0 = getHeight() - ((i * (getHeight() - padding * 2 -labelPadding)) / numberYDivisions + padding + labelPadding);
            int y1 = y0;
           // if (scores.size() > 0) {
                g2.setColor(Color.red);
                //g2.drawLine(padding + labelPadding +6+ pointWidth, y0, getWidth() - padding, y1);
                g2.setColor(Color.BLACK);
                kh= (double)i/10;
                String yLabel =  Double.toString(kh);
                //+((double)i/10);
                System.out.println(" kh = "+ kh);
               // FontMetrics metrics = g2.getFontMetrics();
                int labelWidth = yLabel.length(); //metrics.stringWidth(yLabel);
                //g2.draws
                g2.drawString(yLabel, x0 - labelWidth -20 , y0);
           // }
            g2.setColor(Color.BLACK);
            g2.drawLine(x0, y0, x1, y1);
        }

        for (int i = 0; i < numberYDivisions+1; i++) {
          //  if (scores.size() > 1) {
                int x0 = i * (getWidth() - padding * 2 - labelPadding) / (10 ) + padding + labelPadding;
                int x1 = x0;
                int y0 = getHeight() - padding - labelPadding;
                int y1 = y0 - pointWidth;
                //if ((i % ((int) ((scores.size() / 8.0)) + 3)) == 0) { 
                   // g2.setColor(gridColor);
                    //g2.drawLine(x0, getHeight() - padding - labelPadding - 1 - pointWidth, x1, padding);
                    g2.setColor(Color.BLACK);
                    String xLabel = (double)i/10 + "";
                    FontMetrics metrics = g2.getFontMetrics();
                    int labelWidth = metrics.stringWidth(xLabel);
                    g2.drawString(xLabel, x0 - labelWidth / 2, y0 + metrics.getHeight() + 3);
               // }
                g2.drawLine(x0, y0, x1, y1);
            //}
        }
        for(point p : graphPoints)
        {
        	System.out.println("p.x= "+p.getX() + "p.y= " + p.getY()+ "\n");
        }
//        
//
        g2.setColor(Color.BLUE);
        g2.drawLine(padding + labelPadding, getHeight() - padding - labelPadding, padding + labelPadding, padding);
        g2.drawLine(padding + labelPadding, getHeight() - padding - labelPadding, getWidth() -
        		padding, getHeight() - padding - labelPadding);
        
        
        //List<point> graphPoints1 = new ArrayList<>();
        //graphPo
//
        Stroke oldStroke = g2.getStroke();
        g2.setColor(Color.magenta);
        g2.setStroke(GRAPH_STROKE);
        for(int i=0;i<numberYDivisions;i++)
        {
        	for(int j=0;j<numberYDivisions;j++)
        	{
        		if(Adjancey_Matrix[i][j]>0.0)
        		{
        			int x1 =  (int)((graphPoints.get(i).getX() * (xScale/0.1) ) + labelPadding +padding  );
                    int y1 =  (int)( getHeight() - ((graphPoints.get(i).getY() * (yScale/0.1) )+ labelPadding +padding ) );
                    int x2 =  (int)((graphPoints.get(j).getX() * (xScale/0.1) ) + labelPadding +padding  );
                    int y2 =  (int)( getHeight() - ((graphPoints.get(j).getY() * (yScale/0.1) )+ labelPadding +padding ) );
                    String weight= String .valueOf(Adjancey_Matrix[i][j]);//Double.valueOf(Adjancey_Matrix[i][j]);


//                    double y1 = graphPoints.get(i).getY();
//                    double x2 = graphPoints.get(i + 1).getX();
//                    double y2 = graphPoints.get(i + 1).getY();
                    g2.drawString(weight, (int)((x1+x2)/2)-2,(int)(y1+y2)/2 );
                    g2.drawLine(x1, y1, x2, y2);
        			//Edges.add(new point<>)
        		}
        	}
        }
//        for (int i = 0; i < graphPoints.size() - 1; i++) {
//            int x1 =  (int)(graphPoints.get(i).getX() * (xScale/0.1) );
//            int y1 =  (int)(graphPoints.get(i).getY() * (yScale/0.1) );
//            int x2 =  (int)(graphPoints.get(i+1).getX() * (xScale/0.1) );
//            int y2 =  (int)(graphPoints.get(i+1).getY() * (yScale/0.1) );
//
//
//
////            double y1 = graphPoints.get(i).getY();
////            double x2 = graphPoints.get(i + 1).getX();
////            double y2 = graphPoints.get(i + 1).getY();
//            g2.drawString("4", (int)((x1+x2)/2)-2,(int)(y1+y2)/2 );
//            g2.drawLine(x1, y1, x2, y2);
//        }

        g2.setStroke(GRAPH_STROKE);
        System.out.println("................................................");
        System.out.println(yScale);
        System.out.println(yScale);
        System.out.println(getHeight());
        System.out.println(getWidth());
        System.out.println("..................................................");
        g2.setColor(pointColor);
        for (int i = 0; i < graphPoints.size(); i++) {
            int x = (int)(((graphPoints.get(i).getX() * (xScale/0.1) ) + labelPadding +padding  )-pointWidth);
            int y = (int)(( getHeight() - ((graphPoints.get(i).getY() * (yScale/0.1) )+ labelPadding +padding ) )- pointWidth);
            int ovalW = pointWidth+10;
            int ovalH = pointWidth+10;
            g2.setColor(Color.WHITE);
            g2.fillOval(x, y, ovalW, ovalH);
            g2.setColor(Color.RED);
            String fill_label = i +"";
            g2.drawString(fill_label,x+10,y+13);
        }
    }

/*
 *  getting the min score using Math();
 * getMinScore is an accessor method
 * @Return the minScore
 */

//
//    private double getMinScore() {
//        double minScore = Double.MAX_VALUE;
//        for (Double score : scores) {
//            minScore = Math.min(minScore, score);
//        }
//        return minScore;
//    }
/*
 *  getting the max score using Math();
 * getMaxScore is an accessor method 
 * @Return the maxScore;
 */
//	
//    private double getMaxScore() {
//        double maxScore = Double.MIN_VALUE;
//        for (Double score : scores) {
//            maxScore = Math.max(maxScore, score);
//        }
//        return maxScore;
//    }
/////* setting scores */
//    public void setScores(List<Double> scores) {
//        this.scores = scores;
//        invalidate();
//        this.repaint();
//    }
//
//    public List<Double> getScores() {
//        return scores;
    
/* creating the method createAndShowGui in the main method, where we create the frame too and pack it in the panel*/
    public void createAndShowGui() {
//        List<Double> scores = new ArrayList<>();
//        Random random = new Random();
//        int maxDataPoints = 20;
//        int maxScore = 8;
//        for (int i = 0; i < maxDataPoints; i++) {
//            scores.add((double) random.nextDouble() * maxScore);
//       
//        }
	    /* Main panel */
        Graph_GUI mainPanel = new Graph_GUI(graphPoints,Adjancey_Matrix,numberYDivisions);
        mainPanel.setPreferredSize(new Dimension(800, 700));
       /* creating the frame */
        JFrame frame = new JFrame("Sample Graph");
       // frame.setPreferredSize(new Dimension(1600, 700));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.setBackground(Color.DARK_GRAY);
        Graphics l = null;
        paintComponent(l);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
      /*the main method runs createAndShowGui*/
  
}
