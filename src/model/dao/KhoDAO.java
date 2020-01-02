/*
 *Mycode
 *
 *@author Admin
 *@date Oct 16, 2019
 *@version 1.0
*/
package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Kho;

public class KhoDAO extends DBconnect {
	public ArrayList<Kho> getListKho() throws SQLException{
		connect();
		String sql = "select ID_Kho,Ten_Kho,Dia_Chi from Kho";
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		ArrayList<Kho> listkho = new ArrayList<Kho>();
		while(rs.next()) {
			Kho kho = new Kho();
			kho.setID_kho(rs.getInt("ID_Kho"));
			kho.setTen_Kho(rs.getString("Ten_Kho"));
			kho.setDia_Chi(rs.getString("Dia_Chi"));
			listkho.add(kho);
		}
		return listkho;
	}
}
