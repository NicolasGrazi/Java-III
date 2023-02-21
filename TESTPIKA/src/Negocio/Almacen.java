package Negocio;

import java.sql.DriverManager;
import java.util.LinkedList;

import javax.swing.JOptionPane;
import IU.InterfazInicio;
import Datos.*;

public class Almacen {
	
	
	public static void main(String[] args) 
	{
		//Interfaz i1 = new Interfaz();
		//i1.Login();
		InterfazInicio i2 = new InterfazInicio();
		i2.run();
		
		
	}
	
	/*Producto*/
	public boolean addProductosDB(Producto producto) 
	{
		if(producto.getPrecio() < 1 && producto.getNombre() == null) {
			
		
			if(producto.crearProducto(producto)) {			
				return true;
			}
		}
	return false;
}
	public boolean modificarProdDB(Producto producto) 
	{
		if(producto.modificarProducto(producto)) {			
		return true;
	}
	return false;
}
	public boolean borrarProdDB(Producto producto) 
	{
		if(producto.eliminarProducto(producto)) {			
		return true;
	}
	return false;
}
	public boolean buscarProdDB(Producto producto) 
	{
		if(producto.buscarProducto(producto)) {			
		return true;
	}
	return false;
}
		
		/*Persona*/
	public boolean addPersonaDB(Persona perso) 
	{
		if(perso.crearPersona(perso)) {			
		return true;
	}
	return false;
}	
	
	
	public boolean modificarPersonaDB(Persona perso) 
	{
		if(perso.modificarPersona(perso)) {			
		return true;
	}
	return false;
}
	public boolean buscarPersonaDB(Persona perso) 
	{
		if(perso.buscarPersona(perso)) {			
		return true;
	}
	return false;
}
	
	
	public boolean borrarPersonaDB(Persona perso) 
	{
		if(perso.eliminarPersona(perso)) {			
		return true;
	}
	return false;
}
	
	/*Container*/
	public boolean crearConteiner(Container conteiner) 
	{
		if(conteiner.crearConteiner(conteiner)) {			
		return true;
	}
	return false;
}


public boolean modificarConteiner(Container conteiner) 
	{
		if(conteiner.modificarConteiner(conteiner)) {			
		return true;
	}
	return false;
}


public boolean eliminarConteiner(Container conteiner) 
	{
		if(conteiner.eliminarConteiner(conteiner)) {			
		return true;
	}
	return false;
}


public boolean buscarContainerDB(Container conteiner) 
	{
		if(conteiner.buscarContainer(conteiner)) {			
		return true;
	}
	return false;
}

	
} 