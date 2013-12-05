import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class View extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Object rowData[][] = { 	{ "1", "Avicii", "House", "5" },
							{ "Row2-Column1", "Row2-Column2", "Row2-Column3", "5" },
							{ "Row2-Column1", "Row2-Column2", "Row2-Column3", "5" },
							{ "Row2-Column1", "Row2-Column2", "Row2-Column3", "5" },
							{ "Row2-Column1", "Row2-Column2", "Row2-Column3", "5" },
							{ "Row2-Column1", "Row2-Column2", "Row2-Column3", "5" },
							{ "Row2-Column1", "Row2-Column2", "Row2-Column3", "5" },
							{ "Row2-Column1", "Row2-Column2", "Row2-Column3", "5" },
							{ "Row2-Column1", "Row2-Column2", "Row2-Column3", "5" },
							{ "Row2-Column1", "Row2-Column2", "Row2-Column3", "5" },
							{ "Row2-Column1", "Row2-Column2", "Row2-Column3", "5" },
							{ "Row2-Column1", "Row2-Column2", "Row2-Column3", "5" },
							{ "Row2-Column1", "Row2-Column2", "Row2-Column3", "5" },
							{ "Row2-Column1", "Row2-Column2", "Row2-Column3", "5" } };
	
	Object columnNames[] = { "id", "Artist", "Genre", "Rating" };
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

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
				
			}
		});
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Rate");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_2.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		table = new JTable(rowData, columnNames);
		scrollPane.setViewportView(table);
		

	}

}
