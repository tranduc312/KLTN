package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.CTGD;
import model.dao.CTGDDAO;

public class CTGDBO {
	CTGDDAO ctgdDAO = new CTGDDAO();
	//hien thi listctgd
	public ArrayList<CTGD> getListCTGD(){
		try {
			return ctgdDAO.getListCTGD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//hien thi listctgd theo id_gd
	public ArrayList<CTGD> getListCTGDGD_ID_GD(int ID_GD){
		try {
			return ctgdDAO.getListCTGD_ID_GD(ID_GD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//getByID
	public CTGD getByID(int ID_GD, int ID_DH) {
		try {
			return ctgdDAO.getByID(ID_GD, ID_DH);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//them
	public void addctgd(int ID_GD, int ID_DH) {
		ctgdDAO.addctgd(ID_GD, ID_DH);
	}
}
