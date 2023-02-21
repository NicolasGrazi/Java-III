package IU;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Datos.Conexion;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class InterfazVerLista extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazVerLista frame = new InterfazVerLista();
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
	public InterfazVerLista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton ButtonVerLista = new JButton("Actualizar lista");
		ButtonVerLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conexion con = new Conexion();
				
				Connection conexion = (Connection) con.conectar();
				
				PreparedStatement stmt;
				
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("id_producto");
				model.addColumn("nombre");
				model.addColumn("precio");
				model.addColumn("categoria");
				model.addColumn("cantidad");
				//model.addColumn("id");
				//model.addColumn("nro_almacen");
				table.setModel(model);
				
				String sql ="SELECT * FROM `producto`"; 
				
				String[] datos = new String[7];
				
				try {
					stmt = (PreparedStatement) conexion.prepareStatement(sql);
					
					ResultSet result =  stmt.executeQuery();
					while(result.next()) {
						datos[0] = result.getString(1);
						datos[1] = result.getString(2);
						datos[2] = result.getString(3);
						datos[3] = result.getString(4);
						datos[4] = result.getString(5);
						//datos[5] = result.getString(6);
						//datos[6] = result.getString(7);
						model.addRow(datos);
					}
				} catch (Exception e1) {
					// TODO: handle exception
					System.out.println("error ");
				}
				
			}
		});
		
		ButtonVerLista.setBounds(10, 11, 166, 23);
		contentPane.add(ButtonVerLista);
		
		table = new JTable();
		table.setBounds(20, 59, 391, 191);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(37, 46, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(104, 46, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Precio");
		lblNewLabel_2.setBounds(184, 46, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Categoria");
		lblNewLabel_3.setBounds(267, 46, 64, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Cantidad");
		lblNewLabel_4.setBounds(341, 46, 67, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton ButtonAtras = new JButton("Atras");
		ButtonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		ButtonAtras.setBounds(335, 11, 89, 23);
		contentPane.add(ButtonAtras);
	}
}
