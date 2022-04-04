package version1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSplitPane;

public class Result extends JFrame {

	private JPanel contentPane;
	public JList list;
	public JLabel lblSourceNode_1;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Result(String[] a) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edges");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(38, 27, 96, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setFont(new Font("Arial", Font.BOLD, 12));
		lblWeight.setBounds(86, 27, 96, 22);
		contentPane.add(lblWeight);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 71, 130, 138);
		contentPane.add(scrollPane);
		
		list = new JList();
		list.setModel(new AbstractListModel() {
			//String[] values = new String[] {"1","2"};
			public int getSize() {
				return a.length;
			}
			public Object getElementAt(int index) {
				return a[index];
			}
		});
		scrollPane.setViewportView(list);
		
		JLabel lblSourceNode = new JLabel("Source: 0 Node");
		//lblSourceNode.setText(arg0);
		lblSourceNode.setFont(new Font("Arial", Font.BOLD, 12));
		lblSourceNode.setBounds(228, 73, 130, 37);
		contentPane.add(lblSourceNode);
		
		lblSourceNode_1 = new JLabel(" ");
		lblSourceNode_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblSourceNode_1.setBounds(228, 121, 130, 37);
		contentPane.add(lblSourceNode_1);
	}
}
