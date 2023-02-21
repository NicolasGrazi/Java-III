package Datos;
import java.sql.*;
public class Container {
	public int nrocontainer;
	public String nombre;
	private int dni;
	
Conexion con = new Conexion();
	
	Connection conexion = con.conectar();
	
	PreparedStatement stmt;
	
	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		
		 return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setnroContainer(int nroContainer) {
		this.nrocontainer = nroContainer;
	}
	
	
	public int getnroContainer() {
		return nrocontainer ;
	}

	@Override
	public String toString() {
		return "container [nrocontainer=" + nrocontainer + ", nombre=" + nombre + "]";
	}
	public boolean crearConteiner(Container nuevo) {
		String sql ="INSERT INTO `container`(`id`, `dni`, `nombre`) VALUES (?,?,?)";
		try {
			stmt = conexion.prepareStatement(sql);
			stmt.setInt(1,nuevo.getnroContainer());
			stmt.setInt(2,nuevo.getDni());
			stmt.setString(3,nuevo.getNombre());
			;
		    stmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error "+ e);
			return false;
		}
		
	}
	
	public boolean modificarConteiner(Container nuevo) {
		String sql ="UPDATE container SET nombre=? WHERE id=? ";
		try {
			stmt = conexion.prepareStatement(sql);
			
			stmt.setString(1,nuevo.getNombre());
			stmt.setInt(2,nuevo.getnroContainer());
		    stmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error "+ e);
			return false;
		}
		
	}
	
	public boolean eliminarConteiner(Container nuevo) {
		
		String sql ="DELETE FROM `container` WHERE id=?"; 
		
		try {
			stmt = conexion.prepareStatement(sql);
			
			stmt.setInt(1,nuevo.getnroContainer());
		    stmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error ");
			return false;
		}
		
		
	}
	
	
	public boolean buscarContainer(Container nuevo) {
   	 
   	 
    	String sql ="SELECT * FROM `container` WHERE id = ? "; 
 		
 		String[] datos = new String[3];
 		
 		
 		try {
			stmt = conexion.prepareStatement(sql);
			stmt.setInt(1,nuevo.getnroContainer());
			
			ResultSet result =  stmt.executeQuery();
			
			while(result.next()) {
				datos[0] = result.getString(1);
				datos[2] = result.getString(2);
				
				
			}
			System.out.println("nrocontainer: " + datos[0] + " nombre: " + datos[2] );
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error ");
			return false;
		}
    	 
    	 
    	 
     }

}
