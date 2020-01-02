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

import model.bean.Don_Hang;

public class DonHangDAO extends DBconnect {
	
	// hien thi tat ca don hang (admin)
	public ArrayList<Don_Hang> getListDH() throws SQLException{
		connect();
		String sql = "select * from Don_Hang";
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		ArrayList<Don_Hang> listDH = new ArrayList<Don_Hang>();
		while(rs.next()) {
			Don_Hang donhang = new Don_Hang();
			donhang.setID_DH(rs.getInt("ID_DH"));
			donhang.setID_Shop(rs.getInt("ID_Shop"));
			donhang.setTen_Nguoi_Nhan(rs.getString("Ten_Nguoi_Nhan"));
			donhang.setSDT_Nhan(rs.getString("SDT_Nhan"));
			donhang.setDC_Nhan(rs.getString("DC_Nhan"));
			donhang.setKhoi_Luong(rs.getInt("Khoi_Luong"));
			donhang.setCao(rs.getInt("Cao"));
			donhang.setRong(rs.getInt("Rong"));
			donhang.setNgay_Lap(rs.getString("Ngay_Lap"));
			donhang.setTien_Thu_Ho(rs.getInt("Tien_Thu_Ho"));
			donhang.setCuoc_Phi(rs.getInt("Cuoc_Phi"));
			donhang.setTinh_Trang(rs.getInt("Tinh_Trang"));
			listDH.add(donhang);
		}
		return listDH;
	}
	
	
	// hien thi tat ca don hang theo id_user
	public ArrayList<Don_Hang> getListDH_ID_User(int ID_User) throws SQLException{
		connect();
		String sql = String.format("select don_hang.ID_DH,shop.ID_Shop,shop.Ten_Shop,Ten_Nguoi_Nhan,SDT_Nhan,DC_Nhan,Ngay_Lap,Tien_Thu_Ho,Cuoc_Phi,Tinh_Trang from don_hang inner join shop on don_hang.ID_Shop=shop.ID_Shop inner join [dbo].[User] on shop.ID_User=[dbo].[User].ID_User where [dbo].[User].ID_User= '%s'", ID_User);
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		ArrayList<Don_Hang> listDH = new ArrayList<Don_Hang>();
		while(rs.next()) {
			Don_Hang donhang = new Don_Hang();
			donhang.setID_DH(rs.getInt("ID_DH"));
			donhang.setID_Shop(rs.getInt("ID_Shop"));
			donhang.setTen_Nguoi_Nhan(rs.getString("Ten_Nguoi_Nhan"));
			donhang.setSDT_Nhan(rs.getString("SDT_Nhan"));
			donhang.setDC_Nhan(rs.getString("DC_Nhan"));
			donhang.setNgay_Lap(rs.getString("Ngay_Lap"));
			donhang.setTien_Thu_Ho(rs.getInt("Tien_Thu_Ho"));
			donhang.setCuoc_Phi(rs.getInt("Cuoc_Phi"));
			donhang.setTinh_Trang(rs.getInt("Tinh_Trang"));
			listDH.add(donhang);
		}
		return listDH;
	}
	// hien thi tat ca don hang theo id_user
	public ArrayList<Don_Hang> getListDH_ID_Shop(int ID_Shop) throws SQLException{
		connect();
//		String sql = String.format("select ID_DH,shop.ID_Shop,shop.Ten_Shop,Ten_Nguoi_Nhan,SDT_Nhan,DC_Nhan,Ngay_Lap,Tien_Thu_Ho,Cuoc_Phi,Tinh_Trang from don_hang inner join shop on don_hang.ID_Shop=shop.ID_Shop inner join [dbo].[User] on shop.ID_User=[dbo].[User].ID_User where Shop.ID_Shop = '%s' and Don_Hang.Tinh_Trang=4",
//				ID_Shop);
		String sql = String.format("select * from Don_Hang where ID_Shop='%s' and Tinh_Trang=4 and ID_DH not in (select ID_DH from CTGD)",
				ID_Shop);
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		ArrayList<Don_Hang> listDH = new ArrayList<Don_Hang>();
		while(rs.next()) {
			Don_Hang donhang = new Don_Hang();
			donhang.setID_DH(rs.getInt("ID_DH"));
			donhang.setID_Shop(ID_Shop);
			donhang.setTen_Nguoi_Nhan(rs.getString("Ten_Nguoi_Nhan"));
			donhang.setSDT_Nhan(rs.getString("SDT_Nhan"));
			donhang.setDC_Nhan(rs.getString("DC_Nhan"));
			donhang.setNgay_Lap(rs.getString("Ngay_Lap"));
			donhang.setTien_Thu_Ho(rs.getInt("Tien_Thu_Ho"));
			donhang.setCuoc_Phi(rs.getInt("Cuoc_Phi"));
			donhang.setTinh_Trang(rs.getInt("Tinh_Trang"));
			listDH.add(donhang);
		}
		return listDH;
	}
	// hien thi tat ca don hang theo id_user
	public ArrayList<Don_Hang> getListDH_TinhTrang(String Tinh_Trang) throws SQLException{
		connect();
		String sql = String.format( "select shop.ID_Shop,ID_DH,shop.Ten_Shop,Ten_Nguoi_Nhan,SDT_Nhan,DC_Nhan,Ngay_Lap,Tien_Thu_Ho,Cuoc_Phi,Tinh_Trang from don_hang inner join shop on don_hang.ID_Shop=shop.ID_Shop inner join [dbo].[User] on shop.ID_User=[dbo].[User].ID_User where Tinh_Trang= '%s'", Tinh_Trang);
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		ArrayList<Don_Hang> listDH = new ArrayList<Don_Hang>();
		while(rs.next()) {
			Don_Hang donhang = new Don_Hang();
			donhang.setID_DH(rs.getInt("ID_DH"));
			donhang.setID_Shop(rs.getInt("ID_Shop"));
			donhang.setTen_Nguoi_Nhan(rs.getString("Ten_Nguoi_Nhan"));
			donhang.setSDT_Nhan(rs.getString("SDT_Nhan"));
			donhang.setDC_Nhan(rs.getString("DC_Nhan"));
			donhang.setNgay_Lap(rs.getString("Ngay_Lap"));
			donhang.setTien_Thu_Ho(rs.getInt("Tien_Thu_Ho"));
			donhang.setCuoc_Phi(rs.getInt("Cuoc_Phi"));
			donhang.setTinh_Trang(rs.getInt("Tinh_Trang"));
			listDH.add(donhang);
		}
		return listDH;
	}
	//tim kiem theo IDDH
	public Don_Hang getByID(int ID_DH) throws SQLException {
		connect();
		String sql = String.format("select ID_Shop,Ten_Nguoi_Nhan,SDT_Nhan,DC_Nhan,Khoi_Luong,Cao,Rong,Ngay_Lap,Tien_Thu_Ho,Tinh_Trang "
				+ "from don_hang where ID_DH = '%s'", ID_DH);
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		Don_Hang donhang = null;
		while(rs.next()) {
			donhang = new Don_Hang();
			donhang.setID_DH(ID_DH);
			donhang.setID_Shop(rs.getInt("ID_Shop"));
			donhang.setTen_Nguoi_Nhan(rs.getString("Ten_Nguoi_Nhan"));
			donhang.setSDT_Nhan(rs.getString("SDT_Nhan"));
			donhang.setDC_Nhan(rs.getString("DC_Nhan"));
			donhang.setKhoi_Luong(rs.getInt("Khoi_Luong"));
			donhang.setCao(rs.getInt("Cao"));
			donhang.setRong(rs.getInt("Rong"));
			donhang.setNgay_Lap(rs.getString("Ngay_Lap"));
			donhang.setTien_Thu_Ho(rs.getInt("Tien_Thu_Ho"));
			donhang.setTinh_Trang(rs.getInt("Tinh_Trang"));
		}
		return donhang;
	}
	//tim kiem theo tinh trang
	public Don_Hang getByTinhTrang(int Tinh_Trang) throws SQLException {
		connect();
		String sql = String.format("select * from Don_Hang where Tinh_Trang = '%s'", Tinh_Trang);
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		Don_Hang donhang = null;
		while(rs.next()) {
			donhang = new Don_Hang();
			donhang.setTinh_Trang(Tinh_Trang);
			donhang.setID_Shop(rs.getInt("ID_Shop"));
			donhang.setTen_Nguoi_Nhan(rs.getString("Ten_Nguoi_Nhan"));
			donhang.setSDT_Nhan(rs.getString("SDT_Nhan"));
			donhang.setDC_Nhan(rs.getString("DC_Nhan"));
			donhang.setKhoi_Luong(rs.getInt("Khoi_Luong"));
			donhang.setCao(rs.getInt("Cao"));
			donhang.setRong(rs.getInt("Rong"));
			donhang.setNgay_Lap(rs.getString("Ngay_Lap"));
			donhang.setTien_Thu_Ho(rs.getInt("Tien_Thu_Ho"));
		}
		return donhang;
	}
	
	
	
	//searchdonhang
	public ArrayList<Don_Hang> searchdonhang(int ID_DH, String SDT_Nhan, int Tinh_Trang, int ID_User) throws SQLException{
		connect();
		String sql = String.format("select * from Don_Hang inner join Shop on Don_Hang.ID_Shop=Shop.ID_Shop where ID_DH like '%s' or SDT_Nhan like '%s' or Tinh_Trang like '%s' and ID_User='%s' ",
				ID_DH,SDT_Nhan,Tinh_Trang,ID_User);
		Statement stmt  = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		ArrayList<Don_Hang> list = new ArrayList<Don_Hang>();
		while(rs.next()) {
			Don_Hang donhang = new Don_Hang();
			donhang.setID_DH(rs.getInt("ID_DH"));
			donhang.setID_Shop(rs.getInt("ID_Shop"));
			donhang.setTen_Nguoi_Nhan(rs.getString("Ten_Nguoi_Nhan"));
			donhang.setSDT_Nhan(rs.getString("SDT_Nhan"));
			donhang.setDC_Nhan(rs.getString("DC_Nhan"));
			donhang.setKhoi_Luong(rs.getInt("Khoi_Luong"));
			donhang.setCao(rs.getInt("Cao"));
			donhang.setRong(rs.getInt("Rong"));
			donhang.setNgay_Lap(rs.getString("Ngay_Lap"));
			donhang.setTien_Thu_Ho(rs.getInt("Tien_Thu_Ho"));
			donhang.setCuoc_Phi(rs.getInt("Cuoc_Phi"));
			donhang.setTinh_Trang(rs.getInt("Tinh_Trang"));
			list.add(donhang);
		}
		return list;
	}
	
	//them 1 don hang (usershop)
	public void addDonHang(int ID_Shop, String Ten_Nguoi_Nhan, String SDT_Nhan, String DC_Nhan, int Khoi_Luong,
			int Cao, int Rong,  int Tien_Thu_Ho, int Cuoc_Phi, int Tinh_Trang) {
		connect();
		String sql = String.format("insert into don_hang (ID_Shop,Ten_Nguoi_Nhan,SDT_Nhan,DC_Nhan,Khoi_Luong,Cao,Rong,Ngay_Lap,Tien_Thu_Ho,Cuoc_Phi,Tinh_Trang) values('%s',N'%s',N'%s',N'%s','%s','%s','%s',GETDATE(),'%s','%s','%s')",
				ID_Shop, Ten_Nguoi_Nhan, SDT_Nhan, DC_Nhan, Khoi_Luong, Cao, Rong, Tien_Thu_Ho, Cuoc_Phi, Tinh_Trang);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//sua thong tin don hang(usershop)
//	public void editDonHang(int ID_DH, String Ten_Nguoi_Nhan, String SDT_Nhan, String DC_Nhan, int Khoi_Luong,
//			int Cao, int Rong, String Ngay_Giao, int Tien_Thu_Ho) {
//		connect();
//		String sql =String.format("update Don_Hang set  Ten_Nguoi_Nhan = N'%s', SDT_Nhan='%s',"
//		+ " DC_Nhan=N'%s', Khoi_Luong ='%s', Cao = '%s', Rong = '%s', Ngay_Giao = '%s', Tien_Thu_Ho = '%s' where ID_DH = '%s'",
//				ID_DH, Ten_Nguoi_Nhan, SDT_Nhan, DC_Nhan, Khoi_Luong, Cao, Rong, Ngay_Giao, Tien_Thu_Ho);
//		try {
//			Statement stmt = connection.createStatement();
//			stmt.executeUpdate(sql);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	public void editDonHang(int ID_DH, String Ten_Nguoi_Nhan, String SDT_Nhan, String DC_Nhan, int Khoi_Luong, int Cao, int Rong,
			 int Tien_Thu_Ho) {
		connect();
		String sql = String.format("update Don_Hang set Ten_Nguoi_Nhan=N'%s',SDT_Nhan='%s',DC_Nhan=N'%s',Khoi_Luong='%s',Cao='%s',Rong='%s',Tien_Thu_Ho='%s' where ID_DH='%s'",
				Ten_Nguoi_Nhan, SDT_Nhan, DC_Nhan, Khoi_Luong, Cao, Rong, Tien_Thu_Ho, ID_DH);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
	
	//huy don hang
	public void cancelDonHang(int ID_DH) {
		connect();
		String sql = String.format("update don_hang set tinh_trang=5 where ID_DH='%s'", ID_DH);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	//hoan tac don hang
	public void undoDonHang(int ID_DH) {
		connect();
		String sql = String.format("update don_hang set tinh_trang=1 where ID_DH='%s'", ID_DH);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	//xoa 1 don hang(admin)
	public void deleteDonHang(int ID_DH) {
		connect();
		String sql = String.format("delete from Don_Hang where ID_DH = '%s'", ID_DH);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
