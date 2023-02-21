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

public class InterfazAgregarProd extends JFrame {

	private JPanel contentPane;
	private JTextField inputId_Producto;
	private JTextField inputId;
	private JTextField inputNro_Almacen;
	private JTextField inputNombre;
	private JTextField inputPrecio;
	private JTextField inputCategoria;
	private JTextField inputCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazAgregarProd frame = new InterfazAgregarProd();
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
	public InterfazAgregarProd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Complete los datos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(60, 11, 302, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID Producto");
		lblNewLabel_1.setBounds(10, 43, 87, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID");
		lblNewLabel_1_1.setBounds(10, 73, 87, 22);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Categoria");
		lblNewLabel_1_2.setBounds(200, 73, 87, 22);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("NRO Almacen");
		lblNewLabel_1_3.setBounds(10, 106, 87, 22);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Cantidad");
		lblNewLabel_1_4.setBounds(200, 106, 87, 22);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Precio");
		lblNewLabel_1_5.setBounds(200, 43, 87, 22);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Nombre");
		lblNewLabel_1_6.setBounds(10, 139, 87, 22);
		contentPane.add(lblNewLabel_1_6);
		
		inputId_Producto = new JTextField();
		inputId_Producto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		inputId_Producto.setBounds(93, 44, 99, 20);
		contentPane.add(inputId_Producto);
		inputId_Producto.setColumns(10);
		
		inputId = new JTextField();
		inputId.setColumns(10);
		inputId.setBounds(91, 76, 99, 20);
		contentPane.add(inputId);
		
		inputNro_Almacen = new JTextField();
		inputNro_Almacen.setColumns(10);
		inputNro_Almacen.setBounds(91, 108, 99, 20);
		contentPane.add(inputNro_Almacen);
		
		inputNombre = new JTextField();
		inputNombre.setColumns(10);
		inputNombre.setBounds(93, 139, 99, 20);
		contentPane.add(inputNombre);
		
		inputPrecio = new JTextField();
		inputPrecio.setColumns(10);
		inputPrecio.setBounds(266, 44, 99, 20);
		contentPane.add(inputPrecio);
		
		inputCategoria = new JTextField();
		inputCategoria.setColumns(10);
		inputCategoria.setBounds(266, 74, 99, 20);
		contentPane.add(inputCategoria);
		
		inputCantidad = new JTextField();
		inputCantidad.setColumns(10);
		inputCantidad.setBounds(266, 106, 99, 20);
		contentPane.add(inputCantidad);
		
		JButton ButtonAtras = new JButton("Atras");
		ButtonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		ButtonAtras.setBounds(170, 210, 111, 28);
		contentPane.add(ButtonAtras);
		
		JButton ButtonAgregar = new JButton("Agregar producto");
		ButtonAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Almacen a1 = new Almacen();
				Producto p1 = new Producto();
				p1.setNombre(inputNombre.getText());
				p1.setCategoria(inputCategoria.getText());
				p1.setId(Integer.parseInt(inputId.getText()));
				p1.setId_producto(Integer.parseInt(inputId_Producto.getText()));
				p1.setPrecio(Integer.parseInt(inputPrecio.getText()));
				p1.setnro_almacen(Integer.parseInt(inputNro_Almacen.getText()));
				p1.setCantidad(Integer.parseInt(inputCantidad.getText()));
				
				if(a1.addProductosDB(p1)) {
					JOptionPane.showMessageDialog(null, "Se agrego correctamente");
				}else {
					JOptionPane.showMessageDialog(null, "Error al agregar");
				}
				

			}
		});
		ButtonAgregar.setBounds(10, 212, 150, 25);
		contentPane.add(ButtonAgregar);
		
		JButton ButtonVerLista = new JButton("Ver lista");
		ButtonVerLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazVerLista iver1 = new InterfazVerLista();
				iver1.setVisible(true);
			}
		});
		ButtonVerLista.setBounds(8, 172, 89, 23);
		contentPane.add(ButtonVerLista);
		
		JButton ButtonEliminar = new JButton("Eliminar producto");
		ButtonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazEliminarProd iep1 = new InterfazEliminarProd();
				iep1.setVisible(true);
			}
		});
		ButtonEliminar.setBounds(220, 173, 160, 23);
		contentPane.add(ButtonEliminar);
		
		JButton ButtonModificarProd = new JButton("Modificar producto");
		ButtonModificarProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Almacen a1 = new Almacen();
				Producto p1 = new Producto();
				p1.setNombre(inputNombre.getText());
				p1.setCategoria(inputCategoria.getText());
				p1.setId(Integer.parseInt(inputId.getText()));
				p1.setId_producto(Integer.parseInt(inputId_Producto.getText()));
				p1.setPrecio(Integer.parseInt(inputPrecio.getText()));
				p1.setnro_almacen(Integer.parseInt(inputNro_Almacen.getText()));
				p1.setCantidad(Integer.parseInt(inputCantidad.getText()));
				
				if(a1.modificarProdDB(p1)) {
					JOptionPane.showMessageDialog(null, "Se modifico correctamente");
				}else {
					JOptionPane.showMessageDialog(null, "Error al modificar");
				}
			}
		});
		ButtonModificarProd.setBounds(210, 139, 180, 23);
		contentPane.add(ButtonModificarProd);
	}
}
