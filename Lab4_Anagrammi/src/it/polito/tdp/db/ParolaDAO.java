package it.polito.tdp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ParolaDAO {
	
	private int idParola;
	private String parola;
	
	public boolean contains(String parola){
		
		try {
			Connection conn = DBConnect.getConnection();

			String sql = "SELECT * FROM parola where nome = ?;";

			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,parola);
			ResultSet res = st.executeQuery();
			
			//ora uso l' IF perchè ho al più una riga
			if (res.next()) {
				// found
				
				//prima libero la memoria...
				res.close();
				conn.close();

				//...e poi faccio return
				return true;
			} else {
				// not found
				res.close();
				conn.close();
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return false; //dopo il catch devo sempre metterci un return
	}

}
