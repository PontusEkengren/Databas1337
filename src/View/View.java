package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class View extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	
	//{ "1", "Avicii", "House", "5" }
	Object[][] rowData = {{"asd","sad","sda","das"}};
	
						//	 0	  1	   2    3
	Object columnNames[] = {"1", "2", "3", "4"};
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("");
			}
		});
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<4; i++)
				{
					insertRow(0,i, new Object[]{"Hej"});
					tableModel.fireTableDataChanged();
					tableModel.fireTableStructureChanged();
					tableModel.fireTableCellUpdated(0, 0);
				}
				
			}
		});
		panel_2.add(btnNewButton_2);
		
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		table = new JTable(rowData, columnNames);
		scrollPane.setViewportView(table);
		
	}
	
	public void initView(){
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		tableModel = new DefaultTableModel((Object[][]) rowData, columnNames);
		table.setModel(tableModel);
		//table = new JTable((Object[][]) rowData, columnNames);
		scrollPane.setViewportView(table);
		tableModel.fireTableDataChanged();
	}
	public void updateView(){
		tableModel.fireTableDataChanged();
	}
	
	public void printAnything(String anything){
		System.out.println(anything);
		//System.out.println("HEJ TEST");
	}
	
	public void setColumns(int c, String columnName) {
		// TODO Auto-generated method stub
		columnNames[c] = columnName;
		columnNames[0] = new Object[]{"hej"};
		tableModel.fireTableDataChanged();
		tableModel.fireTableDataChanged();
		tableModel.fireTableStructureChanged();
		tableModel.fireTableCellUpdated(0, 0);
		repaint();
	}
	public void insertRow(int row, int column, Object row_data){
		rowData[row][column] = row_data;
	}
	
//(Object object,int c
	public void insertAll(int row, Object object,int column) {
		// TODO Auto-generated method stub
		// Object object = new Object;
		Object[][] rowData = new Object[80][40];
		rowData[row][column]=object +  "\t";
		System.out.println(rowData[row][column].toString());
		
	}

}
