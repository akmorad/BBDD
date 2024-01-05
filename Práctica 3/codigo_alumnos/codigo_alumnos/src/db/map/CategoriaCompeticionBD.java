package db.map;

import java.sql.*;
import db.*;
import model.CategoriaCompeticion;

public class CategoriaCompeticionBD {
	
	static String sqlQuery = "SELECT * FROM balonmano.categoria_competicion";
	/**
	 * 
	 * @param categoriaCompeticion
	 * @return Obtiene de la base de datos la categoría de competición con id igual al parámetro categoriaCompeticion, 
	 *    creando un objeto del tipo model.CategoriaCompeticion
	 */
	public static CategoriaCompeticion getById(int categoriaCompeticion) {
		String sqlQuery = "SELECT * FROM categoria_competicion" + " WHERE id = ' " + categoriaCompeticion + "';";
		PreparedStatement stm;
		ResultSet rs;
		CategoriaCompeticion result = null;
		
	    try {
	    	stm = AdministradorConexion.prepareStatement(sqlQuery);  //se declara el statement
	    	rs = stm.executeQuery(sqlQuery); //se ejecuta la sentencia SQL

			
			while (rs.next()){
				int id = rs.getInt(1);  //asigna la respuesta de la posición 1 correspondiente a id
			    String nombre = rs.getString(2);  //asigna la respuesta de la posición 2 correspondiente a nombre
			    String descripcion = rs.getString(3);  //asigna la respuesta de la posición 3 correspondiente a descripcion
			    int numero_max_equipos = rs.getInt(4);  //asigna la respuesta de la posición 4 correspondiente a numero_max_equipos
			    System.out.println(id + "\t" + nombre + "\t" + descripcion + "\t" + numero_max_equipos);
		     }
			
			 rs.close();
		     stm.close (); //se cierra el statement para liberar memoria
		     
	    } catch (SQLException e) {
	    	 System.out.println("Mensaje error: " + e.getMessage());}
	      
		return result; //retorna null en el caso que no se establezca conexión con la DB
	    
	 }
}
	    
