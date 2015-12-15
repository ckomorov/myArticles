package tritpo;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
import java.io.IOException;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.SystemColor;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class window {

	public JFrame frame;
	Connection connection=null;
	Statement statmt = null;
	String adress = "http://vk.com";
	static JTable table;
	static JTextField textFieldAdress;
	static JTextField textFieldArticle;
	static JTextField textFieldId;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window window = new window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public window() throws SQLException {
		initialize();
		btnAction.refreshArticle();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		connection=sqlConnection.dbConnector();
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.setBackground(new Color(123, 104, 238));
		frame.getContentPane().setBackground(SystemColor.scrollbar);
		frame.getContentPane().setLayout(null);
		
		                             /* BUTTONS */
        /*----------------------------------------------------------------------------------*/
		JButton btnNewButton_1 = new JButton("Добавить");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(e.getSource()==btnNewButton_1){
						btnAction.addArticle();				
						}
					}
				});
		btnNewButton_1.setBounds(136, 253, 100, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Удалить");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win2 window2 = new win2();
				window2.setVisible(true);
				}
			});
		btnNewButton_2.setBounds(541, 100, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Открыть");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					win3 window3 = new win3();
					window3.setVisible(true);
				}
			});
		btnNewButton_3.setBounds(280, 100, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
      /*------------------------------------------------------------------------------------------------------*/
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(280, 131, 350, 260);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		
		scrollPane.setViewportView(table);
		
		JList list = new JList();
		scrollPane.setColumnHeaderView(list);
		
		JLabel lblMyArticles = new JLabel("My Articles");
		lblMyArticles.setForeground(SystemColor.controlLtHighlight);
		lblMyArticles.setFont(new Font("SketchFlow Print", Font.PLAIN, 46));
		lblMyArticles.setBounds(58, 11, 339, 75);
		frame.getContentPane().add(lblMyArticles);
		
		JPanel panel = new JPanel();
		panel.setBounds(103, 171, 167, 30);
		frame.getContentPane().add(panel);
		
		textFieldAdress = new JTextField();
		panel.add(textFieldAdress);
		textFieldAdress.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(103, 212, 167, 30);
		frame.getContentPane().add(panel_1);
		
		textFieldArticle = new JTextField();
		textFieldArticle.setColumns(10);
		panel_1.add(textFieldArticle);
		
		JLabel label = new JLabel("\u041E\u043F\u0438\u0441\u0430\u043D\u0438\u0435");
		label.setFont(new Font("Arial", Font.PLAIN, 15));
		label.setBounds(17, 179, 76, 22);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u0421\u0441\u044B\u043B\u043A\u0430 ");
		label_1.setFont(new Font("Arial", Font.PLAIN, 15));
		label_1.setBounds(29, 219, 64, 23);
		frame.getContentPane().add(label_1);
		
		JLabel lblPoweredByKomarov = new JLabel("Powered by Komarov Sergey/ 350503 / 2015.");
		lblPoweredByKomarov.setFont(new Font("SketchFlow Print", Font.PLAIN, 20));
		lblPoweredByKomarov.setBounds(129, 430, 528, 14);
		frame.getContentPane().add(lblPoweredByKomarov);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(103, 131, 167, 30);
		frame.getContentPane().add(panel_2);
		
		textFieldId = new JTextField();
		textFieldId.setColumns(10);
		panel_2.add(textFieldId);
		
		JLabel lblId = new JLabel("       ID");
		lblId.setFont(new Font("Arial", Font.PLAIN, 15));
		lblId.setBounds(17, 137, 76, 22);
		frame.getContentPane().add(lblId);
		
		JList list_1 = new JList();
		list_1.setBounds(126, 372, 1, 1);
		frame.getContentPane().add(list_1);
		
		
		
		frame.setBounds(100, 100, 683, 494);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
		
		
	
	
		

