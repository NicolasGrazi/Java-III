package Datos;
import java.sql.*;
public class Operario extends Persona{

	private int nro;
	private String contrasenea;

Conexion con = new Conexion();
	
	Connection conexion = con.conectar();
	
	PreparedStatement stmt;

	public int getNro() {
		return nro;
	}
	public String getcontrasenea() {
		return contrasenea;
	}
	
	public void setNro(int nro) {
		this.nro = nro;
	}
	
	public void setcontrasenea(String contrasenea) {
		this.contrasenea = contrasenea;
	}
	
	public boolean sesion (Operario control) {
		String sql ="SELECT * FROM `operario` WHERE contraseña = '?' and usuario = '?'"; 
		try {
			stmt = conexion.prepareStatement(sql);
			stmt.setString(1,control.getcontrasenea());
			stmt.setInt(2,control.getDni());
		    stmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error ");
			return false;
		}
	}

}
