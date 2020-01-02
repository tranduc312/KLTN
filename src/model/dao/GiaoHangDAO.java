/*
 *Mycode
 *
 *@author Admin
 *@date Oct 17, 2019
 *@version 1.0
*/
package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Giao_Hang;

public class GiaoHangDAO extends DBconnect {
	
	//hien thi danh sach gh
	public ArrayList<Giao_Hang> getListGH() throws SQLException{
		connect();
		String sql = "select * from Giao_Hang";
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		ArrayList<Giao_Hang> listgiaohang = new  ArrayList<Giao_Hang>();
		while(rs.next()) {
			Giao_Hang giaohang = new Giao_Hang();
			giaohang.setID_GH(rs.getInt("ID_GH"));
			giaohang.setID_User(rs.getInt("ID_User"));
			giaohang.setID_DH(rs.getInt("ID_DH"));
			giaohang.setNgay_Giao(rs.getString("Ngay_Giao"));
			listgiaohang.add(giaohang);
		}
		return listgiaohang;
	}
	
	//hien thi danh sach theo ID_User
	public ArrayList<Giao_Hang> getListGH_ID_User(int ID_User) throws SQLException{
		connect();
		String sql = String.format("select Giao_Hang.ID_DH as [Mã đơn hàng], [dbo].[User].Ten_User as [Nhân viên giao], Giao_Hang.Ngay_Giao,\r\n" + 
				"	Ten_Shop,Ten_Nguoi_Nhan,SDT_Nhan,DC_Nhan,(Tien_Thu_Ho + Cuoc_Phi) as [Tổng tiền]\r\n, Tinh_Trang" + 
				"from Shop inner join Don_Hang on shop.ID_Shop=Don_Hang.ID_Shop inner join Giao_Hang on Don_Hang.ID_DH=Giao_Hang.ID_DH\r\n" + 
				"	inner join [dbo].[User] on [dbo].[User].ID_User = Giao_Hang.ID_User\r\n" + 
				"	where Giao_Hang.ID_User= '%s'", ID_User);
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		ArrayList<Giao_Hang> listgiaohang = new  ArrayList<Giao_Hang>();
		while(rs.next()) {
			Giao_Hang giaohang = new Giao_Hang();
			giaohang.setID_GH(rs.getInt("ID_GH"));
			giaohang.setID_User(rs.getInt("ID_User"));
			giaohang.setID_DH(rs.getInt("ID_DH"));
			giaohang.setNgay_Giao(rs.getString("Ngay_Giao"));
			listgiaohang.add(giaohang);
		}
		return listgiaohang;
	}
	
	//tim kiem theo ID
	public Giao_Hang getByID_GH(int ID_GH) {
		connect();
		String sql = String.format("select * from Giao_Hang where ID_GH='%s'", ID_GH);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs= stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		Giao_Hang giaohang = null;
		
		try {
			while(rs.next()) {
				giaohang  = new Giao_Hang();
				giaohang.setID_GH(ID_GH);
				giaohang.setID_User(rs.getInt("ID_User"));
				giaohang.setNgay_Giao(rs.getString("Ngay_Giao"));
				giaohang.setID_User(rs.getInt("ID_User"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return giaohang;
	}
	//tim kiem theo User
	public Giao_Hang getByID_User(int ID_User) {
		connect();
		String sql = String.format("select * from Giao_Hang where ID_User = '%s'", ID_User);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		Giao_Hang giaohang = null;
		try {
			while(rs.next()) {
				giaohang = new Giao_Hang();
				giaohang.setID_User(ID_User);
				giaohang.setID_GH(rs.getInt("ID_GH"));
				giaohang.setID_DH(rs.getInt("ID_DH"));
				giaohang.setNgay_Giao(rs.getString("Ngay_Giao"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return giaohang;
	}
	
	//tim kiem theo ID_DH
	public Giao_Hang getByID_DH(int ID_DH) {
		connect();
		String sql = String.format("select * from Giao_Hang where ID_DH = '%s'", ID_DH);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		Giao_Hang giaohang = null;
		try {
			while(rs.next()) {
				giaohang = new Giao_Hang();
				giaohang.setID_DH(ID_DH);
				giaohang.setID_GH(rs.getInt("ID_GH"));
				giaohang.setID_User(rs.getInt("ID_User"));
				giaohang.setNgay_Giao(rs.getString("Ngay_Giao"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return giaohang;
	}
	
	//them
	public void addGH(int ID_User, int ID_DH, String Ngay_Giao) {
		connect();
		String sql = String.format("insert into giao_hang values('%s','%s','%s') ", ID_User, ID_DH, Ngay_Giao);
		String sql1 = String.format("update don_hang set tinh_trang=3 where ID_DH='%s' ", ID_DH);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
			stmt.executeUpdate(sql1);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	//sua
	
	public void editGH(int ID_GH, int ID_User, int ID_DH, String Ngay_Giao) {
		connect();
		String sql = String.format("update giao_hang set ID_User = '%s', ID_DH = '%s', Ngay_Giao = '%s' where ID_GH = '%s'",
				ID_User, ID_DH, Ngay_Giao, ID_GH);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	//xoa
	public void deleteGH(int ID_GH) {
		connect();
		String sql = String.format("delete from Giao_Hang where ID_GH='%s'", ID_GH);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
