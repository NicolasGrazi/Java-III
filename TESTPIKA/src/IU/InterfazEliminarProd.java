package IU;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Datos.Producto;
import Negocio.Almacen;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazEliminarProd extends JFrame {

	private JPanel contentPane;
	private JTextField input_EliminarProd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazEliminarProd frame = new InterfazEliminarProd();
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
	public InterfazEliminarProd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngreseElId = new JLabel("Ingrese el ID del producto que desea eliminar");
		lblIngreseElId.setBounds(10, 24, 424, 14);
		lblIngreseElId.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblIngreseElId);
		
		input_EliminarProd = new JTextField();
		input_EliminarProd.setColumns(10);
		input_EliminarProd.setBounds(190, 86, 58, 37);
		contentPane.add(input_EliminarProd);
		
		JButton ButtonEliminarProd = new JButton("Eliminar producto");
		ButtonEliminarProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Almacen a1 = new Almacen();
				Producto p1 = new Producto();
				p1.setId_producto(Integer.parseInt(input_EliminarProd.getText()));
				
				if(a1.borrarProdDB(p1)) {
					JOptionPane.showMessageDialog(null, "Se elimino el producto correctamente");
				}else {
					JOptionPane.showMessageDialog(null, "Error al eliminar");
				}
			}
		});
		ButtonEliminarProd.setBounds(156, 171, 122, 23);
		contentPane.add(ButtonEliminarProd);
		
		JButton ButtonAtras = new JButton("Atras");
		ButtonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		ButtonAtras.setBounds(175, 227, 89, 23);
		contentPane.add(ButtonAtras);
	}
}
