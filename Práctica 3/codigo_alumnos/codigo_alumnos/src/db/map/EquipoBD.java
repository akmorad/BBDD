package db.map;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import db.AdministradorConexion;
import model.Equipo;

public class EquipoBD {

	/**
	 * Obtiene de la base de datos el equipo con licencia igual al parámetro licenciaEquipo, 
	 *    creando un objeto del tipo model.Equipo
	 * @param licenciaEquipo
	 * @return
	 */
	public static Equipo getById(String licenciaEquipo) {
		String sqlQuery = "SELECT * FROM equipo " + " WHERE licencia = '" + licenciaEquipo + "';";
		PreparedStatement stm;
		ResultSet rs;
		Equipo result = null;
		
		try {
			stm = AdministradorConexion.prepareStatement(sqlQuery); //se declara el statement
			rs = stm.executeQuery();  //se ejecuta la sentencia SQL
			
			while (rs.next()){
				String licencia = rs.getString(1); //asigna la respuesta de la posición 1 correspondiente a licencia
				String nombre = rs.getString(2); //asigna la respuesta de la posición 2 correspondiente a nombre
				int telefono = rs.getInt(3); //asigna la respuesta de la posición 3 correspondiente a telefono
			    String nombre_club = rs.getString(4); //asigna la respuesta de la posición 4 correspondiente a nombreClub
			    int id_categoria_edad = rs.getInt(5); //asigna la respuesta de la posición 5 correspondiente a categoriaEdad
			    int id_categoria_competicion = rs.getInt(6); //asigna la respuesta de la posición 6 correspondiente a categoriaCompeticion
			    System.out.println(licencia + "\t" + nombre + "\t" + telefono + "\t" + nombre_club + "\t" +
			    		id_categoria_edad + "\t" + id_categoria_competicion);
		     }
			
			 rs.close();
		     stm.close ();  //se cierra el statement para liberar memoria
		     
	    } catch (SQLException e) {
	    	System.out.println("Mensaje error: " + e.getMessage());
	    }
	    
	     
		return result; 
	    }
	
}
