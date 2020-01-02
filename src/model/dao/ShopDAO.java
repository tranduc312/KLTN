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

import model.bean.Shop;

public class ShopDAO extends DBconnect {
	
	//hien thi danh sach cho admin
	public ArrayList<Shop> getListShop() throws SQLException{
		connect();
		String sql = "select * from Shop";
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		ArrayList<Shop> listShop = new ArrayList<Shop>();
		while(rs.next()) {
			Shop shop = new Shop();
			shop.setID_Shop(rs.getInt("ID_Shop"));
			shop.setTen_Shop(rs.getString("Ten_Shop"));
			shop.setDia_Chi(rs.getString("Dia_Chi"));
			shop.setID_User(rs.getInt("ID_User"));
			shop.setSDT(rs.getString("SDT"));
			shop.setTrang_Thai(rs.getString("Trang_Thai"));
			listShop.add(shop);
		}
		return listShop;
	}
	
	
	//hien thi danh sach shop theo id_user (cho kh)
	public ArrayList<Shop> getListShop_ID_User(int ID_User) throws SQLException{
		connect();
		String sql = String.format("select  shop.ID_Shop,Ten_Shop,shop.Dia_Chi,shop.SDT,Ten_User,Shop.Trang_Thai as [Quản Lý]\r\n" + 
				"from [dbo].[User] inner join shop on [dbo].[User].ID_User=shop.ID_User where [dbo].[User].ID_User ='%s'",
				ID_User);
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		ArrayList<Shop> listShop = new ArrayList<Shop>();
		while(rs.next()) {
			Shop shop = new Shop();
			shop.setID_User(ID_User);
			shop.setID_Shop(rs.getInt("ID_Shop"));
			shop.setTen_Shop(rs.getString("Ten_Shop"));
			shop.setDia_Chi(rs.getString("Dia_Chi"));
			shop.setSDT(rs.getString("SDT"));
			shop.setTrang_Thai(rs.getString("Trang_Thai"));
			listShop.add(shop);
		}
		return listShop;
	}
	//hien thi danh sach shop ADD DONHANG
	public ArrayList<Shop> getListShop_AddDH(int ID_User, String Trang_Thai) throws SQLException{
		connect();
		String sql = String.format("select  *\r\n" + 
				"from [dbo].[User] inner join shop on [dbo].[User].ID_User=shop.ID_User where [dbo].[User].ID_User ='%s' and Shop.Trang_Thai=0",
				ID_User, Trang_Thai);
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		ArrayList<Shop> listShop = new ArrayList<Shop>();
		while(rs.next()) {
			Shop shop = new Shop();
			shop.setID_User(ID_User);
			shop.setID_Shop(rs.getInt("ID_Shop"));
			shop.setTen_Shop(rs.getString("Ten_Shop"));
			shop.setDia_Chi(rs.getString("Dia_Chi"));
			shop.setSDT(rs.getString("SDT"));
			shop.setTrang_Thai(rs.getString("Trang_Thai"));
			listShop.add(shop);
		}
		return listShop;
	}
		
		
	//tim kiem shop theo id
	public Shop getByID(int ID_Shop)  {
		connect();
		String sql = String.format("select * from shop where ID_Shop = '%s'", ID_Shop);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Shop shop = null;
		try {
			while(rs.next()) {
				shop = new Shop();
				shop.setID_Shop(ID_Shop);
				shop.setTen_Shop(rs.getString("Ten_Shop"));
				shop.setDia_Chi(rs.getString("Dia_Chi"));
				shop.setID_User(rs.getInt("ID_User"));
				shop.setSDT(rs.getString("SDT"));
				shop.setTrang_Thai(rs.getString("Trang_Thai"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shop;
	}
	
	//tim kiem shop theo ID_User
		public Shop getByID_User(int ID_User)  {
			connect();
			String sql = String.format("select * from shop where ID_User = '%s'", ID_User);
			ResultSet rs = null;
			try {
				Statement stmt = connection.createStatement();
				rs = stmt.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Shop shop = null;
			try {
				while(rs.next()) {
					shop = new Shop();
					shop.setID_User(ID_User);
					shop.setTen_Shop(rs.getString("Ten_Shop"));
					shop.setDia_Chi(rs.getString("Dia_Chi"));
					shop.setSDT(rs.getString("SDT"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return shop;
		}
	
	//them 1 shop moi
	public void addShop(String Ten_Shop, String Dia_Chi, int ID_User, String SDT) {
		connect();
		String sql = String.format("insert into Shop(Ten_Shop,Dia_Chi,ID_User,SDT,Trang_Thai) values(N'%s',N'%s','%s',N'%s',0)",
				Ten_Shop, Dia_Chi, ID_User, SDT);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//sua thong tin shop
	public void editShop(int ID_Shop, String Ten_Shop, String Dia_Chi, String SDT) {
		connect();
		String sql = String.format("update Shop set Ten_Shop = N'%s', Dia_Chi = N'%s', SDT=N'%s' where ID_Shop = '%s'", Ten_Shop, Dia_Chi, ID_Shop, SDT);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//xoa 1 shop(admin)
	public void deleteShop(int ID_Shop) {
		connect();
		String sql =String.format("delete from Shop where ID_Shop = '%s' ", ID_Shop);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//blockshop
	public void blockshop(int ID_Shop) {
		connect();
		String sql =String.format( "update Shop set trang_thai=1 where ID_Shop='%s' ",
				ID_Shop);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//unblockshop
	public void unblockshop(int ID_Shop) {
		connect();
		String sql = String.format("update Shop set trang_thai=0 where ID_Shop='%s' ",
				ID_Shop);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
