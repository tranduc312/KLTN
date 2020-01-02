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

import model.bean.Vai_Tro;

public class VaiTroDAO extends DBconnect {
	public ArrayList<Vai_Tro> getListVaiTro() throws SQLException{
		connect();
		String sql = "select ID_Role,Vai_Tro from Vai_Tro";
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		ArrayList<Vai_Tro> listVaiTro = new ArrayList<Vai_Tro>();
		while(rs.next()) {
			Vai_Tro vaitro = new Vai_Tro();
			vaitro.setID_Role(rs.getInt("ID_Role"));
			vaitro.setVai_Tro(rs.getString("Vai_Tro"));
			listVaiTro.add(vaitro);
		}
		return listVaiTro;
	}
}
