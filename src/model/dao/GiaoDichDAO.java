package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import model.bean.Giao_Dich;

public class GiaoDichDAO extends DBconnect {
	
	
	//hien thi listgiaodich
	public ArrayList<Giao_Dich> getListGD() throws SQLException{
		connect();
		String sql = "select * from Giao_Dich";
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		ArrayList<Giao_Dich> listgiaodich = new ArrayList<Giao_Dich>();
		while(rs.next()) {
			Giao_Dich giaodich = new Giao_Dich();
			giaodich.setID_GD(rs.getInt("ID_GD"));
			giaodich.setID_Shop(rs.getInt("ID_Shop"));
			giaodich.setID_User(rs.getInt("ID_User"));
			giaodich.setNgay_Tra(rs.getString("Ngay_Tra"));
			listgiaodich.add(giaodich);
		}
		return listgiaodich;
	}
	//hien thi giao dich theo ID
	public ArrayList<Giao_Dich> getListID_ID_GD(int ID_GD) throws SQLException{
		connect();
		String sql = String.format("select * from Giao_Dich where ID_GD='%s'",
				ID_GD);
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		ArrayList<Giao_Dich> listgiaodich = new ArrayList<Giao_Dich>();
		while(rs.next()) {
			Giao_Dich giaodich = new Giao_Dich();
			giaodich.setID_GD(ID_GD);
			giaodich.setID_Shop(rs.getInt("ID_Shop"));
			giaodich.setID_User(rs.getInt("ID_User"));
			giaodich.setNgay_Tra(rs.getString("Ngay_Tra"));
			listgiaodich.add(giaodich);
		}
		return listgiaodich;
	}
	//get ID_GD max
	public Giao_Dich getIDMax() throws SQLException {
		connect();
		String sql = "select ID_GD,ID_Shop from Giao_Dich where ID_GD= (select max(ID_GD) from Giao_Dich)";
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		Giao_Dich giaodich = null;
		while(rs.next()) {
			giaodich = new Giao_Dich();
			giaodich.setID_GD(rs.getInt("ID_GD"));
			giaodich.setID_Shop(rs.getInt("ID_Shop"));
		}
		return giaodich;
	}
	//getbyID
	public Giao_Dich getByID(int ID_GD) throws SQLException {
		connect();
		String sql = String.format("select * from Giao_Dich where ID_GD='%s'", ID_GD);
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		Giao_Dich giaodich = null;
		while(rs.next()) {
			giaodich = new Giao_Dich();
			giaodich.setID_GD(ID_GD);
			giaodich.setID_Shop(rs.getInt("ID_Shop"));
			giaodich.setID_User(rs.getInt("ID_User"));
			giaodich.setNgay_Tra(rs.getString("Ngay_Tra"));
		}
		return giaodich;
	}
	//them giao dich
	public void addgiaodich(int ID_Shop, int ID_User) {
		connect();
		String sql = String.format("insert into Giao_Dich(ID_User,ID_Shop,Ngay_Tra) values('%s','%s',GETDATE())",
				ID_Shop, ID_User);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
