/*
 *Mycode
 *
 *@author Admin
 *@date Oct 17, 2019
 *@version 1.0
*/
package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Lay_Hang;
import model.dao.LayHangDAO;

public class LayHangBO {
	LayHangDAO layhangDAO = new LayHangDAO();
	
	public ArrayList<Lay_Hang> getListLayHang(){
		try {
			return layhangDAO.getListLayHang();
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}
	
	public ArrayList<Lay_Hang> getListLayHang_ID_User(int ID_User){
		try {
			return layhangDAO.getListLH_ID_User(ID_User);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}
	
	public Lay_Hang getByID(int ID_LH) {
		return layhangDAO.getByID(ID_LH);
	}
	
	public Lay_Hang getByID_DH(int ID_DH) {
		return layhangDAO.getByID_DH(ID_DH);
	}
	
	public Lay_Hang getByID_User(int ID_User) {
		return layhangDAO.getByID_User(ID_User);
	}
	
	public void addLay_Hang(int ID_User, String Ngay_Lay, int ID_kho, int ID_DH) {
		 layhangDAO.addLayHang(ID_User, Ngay_Lay, ID_kho, ID_DH);
	}
	
	public void editLayHang(int ID_LH, int ID_User, String Ngay_Lay, int ID_DH) {
		layhangDAO.editLayHang(ID_LH, ID_User, Ngay_Lay, ID_DH);
	}
	
	public void deleteLayHang(int ID_LH) {
		layhangDAO.deleteLayHang(ID_LH);
	}
}
