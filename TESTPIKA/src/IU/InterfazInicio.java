package IU;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class InterfazInicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
			public void run() {
				try {
					InterfazInicio frame = new InterfazInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the frame.
	 */
	public InterfazInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Conteiner");
		btnNewButton.setBounds(40, 147, 137, 54);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazAgregarCont icont1 = new InterfazAgregarCont();
				icont1.setVisible(true);
				}
		});
		
		
		JLabel lblNewLabel = new JLabel("Bienvendio al Inicio del programa");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(79, 11, 271, 44);
		contentPane.add(lblNewLabel);
		
		JButton btnProducto = new JButton("Producto");
		btnProducto.setBounds(240, 147, 137, 54);
		contentPane.add(btnProducto);
		
		btnProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazAgregarProd iprod1 = new InterfazAgregarProd();
				iprod1.setVisible(true);
				}
		});
	}
}
