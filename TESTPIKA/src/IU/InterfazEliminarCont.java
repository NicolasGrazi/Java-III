package IU;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Datos.Container;
import Datos.Producto;
import Negocio.Almacen;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazEliminarCont extends JFrame {

	private JPanel contentPane;
	private JTextField input_EliminarCont;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazEliminarCont frame = new InterfazEliminarCont();
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
	public InterfazEliminarCont() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngreseElId = new JLabel("Ingrese el ID del container que desea eliminar");
		lblIngreseElId.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreseElId.setBounds(0, 23, 424, 14);
		contentPane.add(lblIngreseElId);
		
		input_EliminarCont = new JTextField();
		input_EliminarCont.setColumns(10);
		input_EliminarCont.setBounds(188, 73, 58, 37);
		contentPane.add(input_EliminarCont);
		
		JButton ButtonEliminarCont = new JButton("Eliminar container");
		ButtonEliminarCont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Almacen a1 = new Almacen();
				Container c1 = new Container();
				c1.setnroContainer(Integer.parseInt(input_EliminarCont.getText()));
				
				if(a1.eliminarConteiner(c1)) {
					JOptionPane.showMessageDialog(null, "Se elimino el producto correctamente");
				}else {
					JOptionPane.showMessageDialog(null, "Error al eliminar");
				}
			}
			
		});
		ButtonEliminarCont.setBounds(152, 155, 122, 23);
		contentPane.add(ButtonEliminarCont);
		
		JButton ButtonAtras = new JButton("Atras");
		ButtonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			
		});
		ButtonAtras.setBounds(172, 214, 89, 23);
		contentPane.add(ButtonAtras);
	}

}
