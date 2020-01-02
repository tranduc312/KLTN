/*
 *Mycode
 *
 *@author Admin
 *@date Oct 11, 2019
 *@version 1.0
*/
package model.bo;


import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.User;
import model.dao.UserDAO;

public class UserBO {

	UserDAO userDAO = new UserDAO();
	//kiem tra dang nhap
	public boolean CheckLogin(String Email, String Mat_Khau) throws SQLException {
		return userDAO.CheckLogin(Email, Mat_Khau);
	}
	//checkvaitro
	public int checkvaitro(int ID_Role, String Email) throws SQLException {
		return userDAO.checkvaitro(ID_Role, Email);
	}
	
	//hien thi danh sach
	public ArrayList<User> getListUser() {
		try {
			return userDAO.getListUser();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//tim kiem theo id
	public User getByUser(int ID_User) {
		return userDAO.getByUser(ID_User);
	}
	
	//tim kiem theo email
	public User getByEmail(String Email) {
		return userDAO.getByEmail(Email);
	}
	
	//check matkhau
	public boolean checkMatKhau(String Mat_Khau) {
		try {
			return userDAO.Checkmatkhau(Mat_Khau);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//them user
	public void addUser(String Ten_User, String Mat_Khau, String SDT, String Email, String Dia_Chi, int ID_Role, int ID_Kho, int Trang_Thai) {
		 userDAO.addUser(Ten_User, Mat_Khau, SDT, Email, Dia_Chi, ID_Role, ID_Kho, Trang_Thai);
	}
	
	//dang ky usershop
	public void register(String Ten_User, String Mat_Khau, String SDT, String Email, String Dia_Chi) {
		userDAO.register(Ten_User, Mat_Khau, SDT, Email, Dia_Chi);
	}
	
	//sua thong tin user
	public void editUser(String Ten_User, String Mat_Khau, String SDT, String Dia_Chi,int ID_User) {
		userDAO.editUser( Ten_User, Mat_Khau, SDT, Dia_Chi,ID_User);
	}
	
	//sua thong tin profile
	public void editprofile(String Ten_User, String SDT, String Dia_Chi, int ID_User) {
		userDAO.editprofile(Ten_User, SDT, Dia_Chi, ID_User);
	}
	
	//thay doi mat khau-profile
	public void changeMatKhau(int ID_User, String Mat_Khau_moi) {
		userDAO.changeMatKhau(ID_User, Mat_Khau_moi);
	}
	
	//xoa user
	public void deleteUser(int ID_User) {
		userDAO.deleteUser(ID_User);
	}
	//blockuser
	public void blockuser(int ID_User) {
		userDAO.blockuser(ID_User);
	}
	//unblockuser
	public void unblockuser(int ID_User) {
		userDAO.unblockuser(ID_User);
	}
}
