/*
 *Mycode
 *
 *@author Admin
 *@date Oct 11, 2019
 *@version 1.0
*/
package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.User;

public class UserDAO extends DBconnect {

	// Dang Nhap
	public boolean CheckLogin(String Email, String Mat_Khau) throws SQLException {
		connect();
		String sql = String.format(
				"Select Email,ID_Role from [dbo].[User] where Email = '%s' and Mat_Khau = '%s' and Trang_Thai=0",
				Email, Mat_Khau);
		ResultSet rs = null;
		Statement stmt = connection.createStatement();
		rs = stmt.executeQuery(sql);
		if (rs.next()) {
			return true;
		}
		return false;
	}

	//check mat khau thay doi mat khau
	public boolean Checkmatkhau( String Mat_Khau) throws SQLException {
		connect();
		String sql = String.format(
				"Select Email from [dbo].[User] where Mat_Khau = '%s' ",
				Mat_Khau);
		ResultSet rs = null;
		Statement stmt = connection.createStatement();
		rs = stmt.executeQuery(sql);
		if (rs.next()) {
			return true;
		}
		return false;
	}

	public int checkvaitro(int ID_Role, String Email) {
		connect();
		String sql =String.format("select ID_Role from [dbo].[User] where Email = '%s' ", Email);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while(rs.next()) {
				ID_Role = ((Number) rs.getObject(1)).intValue();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ID_Role;
		
	}
	 
	// Hien thi danh sach admin
	public ArrayList<User> getListUser() throws SQLException {
		connect();
		String sql = "Select * from [dbo].[User] ";
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		ArrayList<User> listUser = new ArrayList<User>();
		while (rs.next()) {
			User user = new User();
			user.setID_User(rs.getInt("ID_User"));
			user.setTen_User(rs.getString("Ten_User"));
			user.setSDT(rs.getString("SDT"));
			user.setEmail(rs.getString("Email"));
			user.setDia_Chi(rs.getString("Dia_Chi"));
			user.setID_Role(rs.getInt("ID_Role"));
			user.setID_Kho(rs.getInt("ID_Kho"));
			user.setTrang_Thai(rs.getString("Trang_Thai"));
			listUser.add(user);
		}
		return listUser;
	}

	// tim kiem bang idadmin
	public User getByUser(int ID_User) {
		connect();
		String sql = String.format("select * from [dbo].[User] where ID_User = '%s'", ID_User);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		User user = null;
		try {
			while (rs.next()) {
				user = new User();
				user.setID_User(ID_User);
				user.setTen_User(rs.getString("Ten_User"));
				user.setMat_Khau(rs.getString("Mat_Khau"));
				user.setSDT(rs.getString("SDT"));
				user.setEmail(rs.getString("Email"));
				user.setDia_Chi(rs.getString("Dia_Chi"));
				user.setID_Role(rs.getInt("ID_Role"));
				user.setTrang_Thai(rs.getString("Trang_Thai"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	//
	public User getByEmail(String Email) {
		connect();
		String sql = String.format("select * from [dbo].[User] where Email='%s'", Email);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		User user = null;
		try {
			while(rs.next()) {
				user = new User();
				user.setID_User(rs.getInt("ID_User"));
				user.setTen_User(rs.getString("Ten_User"));
				user.setMat_Khau(rs.getString("Mat_Khau"));
				user.setSDT(rs.getString("SDT"));
				user.setEmail(rs.getString("Email"));
				user.setDia_Chi(rs.getString("Dia_Chi"));
				user.setID_Role(rs.getInt("ID_Role"));
				user.setTrang_Thai(rs.getString("Trang_Thai"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	

	// them moi user
	public void addUser(String Ten_User, String Mat_Khau, String SDT, String Email, String Dia_Chi,int ID_Role, int ID_Kho,int Trang_Thai) {
		connect();
		String sql = String.format("insert into [dbo].[User] values(N'%s','%s','%s','%s',N'%s','%s','%s','%s')",
				Ten_User,Mat_Khau,SDT,Email,Dia_Chi,ID_Role,ID_Kho,Trang_Thai);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	//dang ky usershop
	public void register(String Ten_User, String Mat_Khau, String SDT, String Email,String Dia_Chi ) {
		connect();
		String sql = String.format("insert into [dbo].[User](Ten_User,Mat_Khau,SDT,Email,Dia_Chi,ID_Role,ID_Kho,Trang_Thai) values(N'%s','%s','%s','%s',N'%s',2,NULL,0)",
				Ten_User,Mat_Khau,SDT,Email,Dia_Chi);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	

	// sua thong tin user
	public void editUser( String Ten_User, String Mat_Khau, String SDT, String Dia_Chi,int ID_User) {
		connect();
		String sql = String.format("update [dbo].[User] set Ten_User=N'%s',Mat_Khau='%s',SDT='%s',Dia_Chi=N'%s' where ID_User='%s'",
				Ten_User,Mat_Khau, SDT, Dia_Chi, ID_User);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//sua thong tin profile-customer
	public void editprofile( String Ten_User,  String SDT, String Dia_Chi,int ID_User) {
		connect();
		String sql = String.format("update [dbo].[User] set Ten_User=N'%s',SDT='%s',Dia_Chi=N'%s' where ID_User='%s'",
				Ten_User, SDT, Dia_Chi, ID_User);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//thay doi mat khau
	public void changeMatKhau(int ID_User, String Mat_Khau_moi) {
		connect();
		String sql = String.format("update [dbo].[User] set Mat_Khau='%s' where ID_User='%s' ", Mat_Khau_moi, ID_User);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	// xoa user
	public void deleteUser(int ID_User) {
		connect();
		String sql = String.format("delete from [dbo].[User] where ID_User = '%s'", ID_User);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//khoa tai khoan
	public void blockuser(int ID_User) {
		connect();
		String sql = String.format("update [dbo].[User] set trang_thai=1 where ID_User='%s'",
				ID_User);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//mo tai khoan
	public void unblockuser(int ID_User) {
		connect();
		String sql = String.format("update [dbo].[User] set trang_thai=0 where ID_User='%s'",
				ID_User);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
