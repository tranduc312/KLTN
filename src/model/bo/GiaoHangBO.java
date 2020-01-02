/*
 *Mycode
 *
 *@author Admin
 *@date Oct 18, 2019
 *@version 1.0
*/
package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Giao_Hang;
import model.dao.GiaoHangDAO;

public class GiaoHangBO {
	GiaoHangDAO giaohangDAO = new GiaoHangDAO();
	public ArrayList<Giao_Hang> getListGH(){
		try {
			return giaohangDAO.getListGH();
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}
	
	public Giao_Hang getByID_GH(int ID_GH) {
		return giaohangDAO.getByID_GH(ID_GH);
	}
	
	public Giao_Hang getByID_User(int ID_User) {
		return giaohangDAO.getByID_User(ID_User);
	}
	
	public Giao_Hang getByID_DH(int ID_DH) {
		return giaohangDAO.getByID_DH(ID_DH);
	}
	
	public void addGH(int ID_User, int ID_DH, String Ngay_Giao) {
		giaohangDAO.addGH(ID_User, ID_DH, Ngay_Giao);
	}
	
	public void editGH(int ID_GH, int ID_User, int ID_DH, String Ngay_Giao) {
		giaohangDAO.editGH(ID_GH, ID_User, ID_DH, Ngay_Giao);
	}
	
	public void deleteGH(int ID_GH) {
		giaohangDAO.deleteGH(ID_GH);
	}
}
