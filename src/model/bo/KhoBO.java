/*
 *Mycode
 *
 *@author Admin
 *@date Oct 16, 2019
 *@version 1.0
*/
package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Kho;
import model.dao.KhoDAO;

public class KhoBO {
	KhoDAO khoDAO = new KhoDAO();
	public ArrayList<Kho> getListKho(){
		try {
			return khoDAO.getListKho();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
