package Datos;
import java.sql.*;
public class Producto {

	private int id_producto;
	private int id;
	private int nro_almacen;
	private String nombre;
	private int precio;
	private String categoria;
	private int cantidad;

	
	
	
Conexion con = new Conexion();
	
	Connection conexion = con.conectar();
	
	PreparedStatement stmt;
	
	public int getnro_almacen() {
		return nro_almacen;
	}
	
	public void setnro_almacen(int nro_almacen) {
		this.nro_almacen = nro_almacen;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "\nID: " + id_producto + "\nNombre: " + nombre + "\nPrecio: " + precio + "\nCategoria:" + categoria + "\n";
	}
	public boolean modificarProducto(Producto prod) {
		String sql ="UPDATE producto SET nombre=?, precio= ? , cantidad= ? ,categoria= ?  WHERE id_producto= ?  "; 
		
		try {
			stmt = conexion.prepareStatement(sql);
			
			
			stmt.setString(1 ,prod.getNombre());
			stmt.setInt(2 ,prod.getPrecio());
			stmt.setInt(3 ,prod.getCantidad());
			stmt.setString(4 ,prod.getCategoria());
			stmt.setInt(5 ,prod.getId_producto());
			
		    stmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	public boolean eliminarProducto(Producto prod) {
		String sql ="DELETE FROM `producto` WHERE id_producto=?"; 
		
		try {
			stmt = conexion.prepareStatement(sql);
			
			stmt.setInt(1,prod.getId_producto());
		    stmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error "+e);
			return false;
		}
		
	}
	public boolean crearProducto(Producto prod) {
		String sql ="INSERT INTO `producto`(`id_producto`, `id`, `nro_almacen`, `nombre`, `precio`, `categoria`, `cantidad`) VALUES (?,?,?,?,?,?,?)"; 
		
		try {
			stmt = conexion.prepareStatement(sql);
			
			stmt.setInt(1,prod.getId_producto());
			stmt.setInt(2,prod.getId());
			stmt.setInt(3,prod.getnro_almacen());
			stmt.setString(4,prod.getNombre());
			stmt.setInt(5,prod.getPrecio());
			stmt.setString(6,prod.getCategoria());
			stmt.setInt(7,prod.getCantidad());
			
			
			
		    stmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error "+ e);
			return false;
		}
	}
	public boolean buscarProducto(Producto prod) {
		
		String sql ="SELECT * FROM `producto` WHERE id_producto = ? "; 
 		
 		String[] datos = new String[7];
 		
 		
 		try {
			stmt = conexion.prepareStatement(sql);
			stmt.setInt(1,prod.getId_producto());
			
			ResultSet result =  stmt.executeQuery();
			
			while(result.next()) {
				datos[0] = result.getString(1);
				datos[1] = result.getString(2);
				datos[2] = result.getString(3);
				datos[3] = result.getString(4);
				datos[4] = result.getString(5);
				datos[5] = result.getString(6);
				datos[6] = result.getString(7);
				
			}
			System.out.println("id_producto: " + datos[0] + " nombre: " + datos[1]+ " precio: "+ datos[2] + " categoria: "+ datos[3]+ " cantidad: "+ datos[4]+datos[5]+datos[6]);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error ");
			return false;
		}
		
	}
	
	
}
