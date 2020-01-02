package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.CTGD;

public class CTGDDAO extends DBconnect {
	
	//hien thi danh sach CTGD
	public ArrayList<CTGD> getListCTGD() throws SQLException{
		connect();
		String sql = "select * from CTGD ";
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		ArrayList<CTGD> listctgd = new ArrayList<CTGD>();
		while(rs.next()) {
			CTGD ctgd = new CTGD();
			ctgd.setID_GD(rs.getInt("ID_GD"));
			ctgd.setID_DH(rs.getInt("ID_DH"));
			listctgd.add(ctgd);
		}
		return listctgd;
	}
	
	//hien thi danh sach CTGD theo IDGD
	public ArrayList<CTGD> getListCTGD_ID_GD(int ID_GD) throws SQLException{
		connect();
		String sql = String.format("select * from CTGD where ID_GD='%s'",
				ID_GD);
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		ArrayList<CTGD> listctgd = new ArrayList<CTGD>();
		while(rs.next()) {
			CTGD ctgd = new CTGD();
			ctgd.setID_GD(ID_GD);
			ctgd.setID_DH(rs.getInt("ID_DH"));
			listctgd.add(ctgd);
		}
		return listctgd;
	}
	
	//getBYID
	public CTGD getByID(int ID_GD, int ID_DH) throws SQLException {
		connect();
		String sql = String.format("select * from CTGD where ID_GD='%s' and ID_DH='%s'",
				ID_GD, ID_DH);
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		CTGD ctgd = null;
		while(rs.next()) {
			ctgd = new CTGD();
			ctgd.setID_GD(ID_GD);
			ctgd.setID_DH(ID_DH);
		}
		return ctgd;
	}
	//them
	public void addctgd(int ID_GD, int ID_DH) {
		connect();
		String sql = String.format("insert into CTGD(ID_GD,ID_DH) values('%s','%s')",
				ID_GD,ID_DH);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
