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

import model.bean.Lay_Hang;

public class LayHangDAO extends DBconnect {
	
	//hien thi danh sach lay hang
	public ArrayList<Lay_Hang> getListLayHang() throws SQLException{
		connect();
		String sql = "select ID_LH,ID_User,Ngay_Lay,ID_Kho,ID_DH from Lay_Hang";
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		ArrayList<Lay_Hang> listlayhang = new ArrayList<Lay_Hang>();
		while(rs.next()) {
			Lay_Hang layhang = new Lay_Hang();
			layhang.setID_LH(rs.getInt("ID_LH"));
			layhang.setID_User(rs.getInt("ID_User"));
			layhang.setNgay_Lay(rs.getString("Ngay_Lay"));
			layhang.setID_Kho(rs.getInt("ID_Kho"));
			layhang.setID_DH(rs.getInt("ID_DH"));
			listlayhang.add(layhang);
		}
		return listlayhang;
 	}
	
	//hien thi danh sach lay hang theo user-nvlay
	public ArrayList<Lay_Hang> getListLH_ID_User(int ID_User) throws SQLException{
		connect();
		String sql = String.format("select Giao_Hang.ID_DH as [Mã đơn hàng], [dbo].[User].Ten_User as [Nhân viên giao], Giao_Hang.Ngay_Giao,\r\n" + 
				"	Ten_Shop,Ten_Nguoi_Nhan,SDT_Nhan,DC_Nhan,(Tien_Thu_Ho + Cuoc_Phi) as [Tổng tiền]\r\n, Tinh_Trang" + 
				"from Shop inner join Don_Hang on shop.ID_Shop=Don_Hang.ID_Shop inner join Giao_Hang on Don_Hang.ID_DH=Giao_Hang.ID_DH\r\n" + 
				"	inner join [dbo].[User] on [dbo].[User].ID_User = Giao_Hang.ID_User\r\n" + 
				"	where Giao_Hang.ID_User= '%s'", ID_User);
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		ArrayList<Lay_Hang> listlayhang = new  ArrayList<Lay_Hang>();
		while(rs.next()) {
			Lay_Hang layhang = new Lay_Hang();
			layhang.setID_LH(rs.getInt("ID_LH"));
			layhang.setID_User(rs.getInt("ID_User"));
			layhang.setNgay_Lay(rs.getString("Ngay_Lay"));
			layhang.setID_DH(rs.getInt("ID_DH"));
			layhang.setID_DH(rs.getInt("ID_DH"));
			listlayhang.add(layhang);
		}
		return listlayhang;
	}
	
	//tim kiem theoID
	public Lay_Hang getByID(int ID_LH) {
		connect();
		String sql = String.format("select * from Lay_Hang where ID_LH='%s'", ID_LH);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		Lay_Hang layhang = null;
		try {
			while(rs.next()) {
				layhang = new Lay_Hang();
				layhang.setID_LH(ID_LH);
				layhang.setID_User(rs.getInt("ID_User"));
				layhang.setNgay_Lay(rs.getString("Ngay_Lay"));
				layhang.setID_Kho(rs.getInt("ID_Kho"));
				layhang.setID_DH(rs.getInt("ID_DH"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return layhang;
	}
	
	//tim kiem theo DH
	public Lay_Hang getByID_DH(int ID_DH) {
		connect();
		String sql = String.format("select * from Lay_Hang where ID_DH='%s'", ID_DH);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		Lay_Hang layhang = null;
		try {
			while(rs.next()) {
				layhang = new Lay_Hang();
				layhang.setID_DH(ID_DH);
				layhang.setID_LH(rs.getInt("ID_LH"));
				layhang.setID_User(rs.getInt("ID_User"));
				layhang.setNgay_Lay(rs.getString("Ngay_Lay"));
				layhang.setID_Kho(rs.getInt("ID_Kho"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return layhang;
	}
	//tim kiem theo User
	public Lay_Hang getByID_User(int ID_User) {
		connect();
		String sql = String.format("select * from Lay_Hang where ID_User='%s'", ID_User);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		Lay_Hang layhang = null;
		try {
			while(rs.next()) {
				layhang = new Lay_Hang();
				layhang.setID_User(ID_User);
				layhang.setID_LH(rs.getInt("ID_LH"));
				layhang.setNgay_Lay(rs.getString("Ngay_Lay"));
				layhang.setID_Kho(rs.getInt("ID_Kho"));
				layhang.setID_DH(rs.getInt("ID_DH"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return layhang;
	}
	
	//them
	public void addLayHang(int ID_User, String Ngay_Lay, int ID_kho, int ID_DH) {
		connect();
		String sql = String.format("insert into lay_hang values('%s','%s','%s','%s')", ID_User, Ngay_Lay, ID_kho, ID_DH);
		String sql1 = String.format("update don_hang set tinh_trang=2 where ID_DH='%s'", ID_DH);
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
	public void editLayHang(int ID_LH, int ID_User, String Ngay_Lay, int ID_DH) {
		connect();
		String sql = String.format("update lay_hang set ID_User = '%s', Ngay_Lay = '%s', ID_DH = '%s' where ID_LH = '%s'",
				ID_LH, ID_User, Ngay_Lay, ID_DH);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	//xoa
	public void deleteLayHang(int ID_LH) {
		connect();
		String sql = String.format("delete from Lay_Hang where ID_LH='%s'", ID_LH);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
