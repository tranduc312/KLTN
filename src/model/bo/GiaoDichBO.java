package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Giao_Dich;
import model.dao.GiaoDichDAO;

public class GiaoDichBO {
	GiaoDichDAO giaodichDAO = new GiaoDichDAO();
	//hien thi list
	public ArrayList<Giao_Dich> getListGD(){
		try {
			return giaodichDAO.getListGD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//hien thi giao dich theo id
	public ArrayList<Giao_Dich> getListGD_ID_GD(int ID_GD){
		try {
			giaodichDAO.getListID_ID_GD(ID_GD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//getID_GD max
	public Giao_Dich getIDMax(){
		try {
			return giaodichDAO.getIDMax();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//getByID
	public Giao_Dich getByID(int ID_GD) {
		try {
			return giaodichDAO.getByID(ID_GD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//them
	public void addgiaodich(int ID_Shop, int ID_User) {
		giaodichDAO.addgiaodich(ID_Shop, ID_User);
	}
}
