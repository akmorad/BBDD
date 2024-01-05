package db.map;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import db.AdministradorConexion;
import model.Club;

public class ClubBD {
	/**
	 * Obtiene de la base de datos el club con nombre igual al parámetro nombreClub, 
	 *    creando un objeto del tipo model.Club
	 * @param nombreClub
	 * @return
	 */
	public static Club getById(String nombreClub) {
		String sqlQuery = "SELECT * FROM club" + " WHERE nombre = '" + nombreClub + "';";
		PreparedStatement stm;
		ResultSet rs;
		Club result = null;
		
		try {
			stm = AdministradorConexion.prepareStatement(sqlQuery); //se declara el statement
			rs = stm.executeQuery(); //se ejecuta la sentencia SQL
			System.out.println("Tabla abierta");
			
             while(rs.next()){
		    	String nombre = rs.getString(1);  //asigna la respuesta de la posición 1 correspondiente a nombre
		    	String calle = rs.getString(2);  //asigna la respuesta de la posición 2 correspondiente a calle
		        int numero= rs.getInt(3);  //asigna la respuesta de la posición 3 correspondiente a numero
		        int piso = rs.getInt(4);  //asigna la respuesta de la posición 4 correspondiente a piso
		        int escalera = rs.getInt(5);  //asigna la respuesta de la posición 5 correspondiente a escalera
		        int cp = rs.getInt(6);  //asigna la respuesta de la posición 6 correspondiente a cp
		        String localidad = rs.getString(7);  //asigna la respuesta de la posición 7 correspondiente a  localidad
		        String telefono = rs.getString(8);  //asigna la respuesta de la posición 8 correspondiente a telefono
		        String persona_contacto = rs.getString(9);  //asigna la respuesta de la posición 9 correspondiente a persona_contacto
		        System.out.println( nombre + "\t" + calle + "\t" + numero + "\t" + piso + "\t" + escalera + "\t" + cp 
		        + "\t" + localidad + "\t" + telefono + "\t" + persona_contacto);
	        }
		    
		    rs.close();
	        stm.close (); //se cierra el statement para liberar memoria
		     
	    	} catch (SQLException e) {
	    		System.out.println("Mensaje error: " + e.getMessage());
	    	}
	    
		    return result; //retorna null en el caso que no se establezca conexión con la DB
	        
	    }
}
	
