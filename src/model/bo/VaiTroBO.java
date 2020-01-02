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

import model.bean.Vai_Tro;
import model.dao.VaiTroDAO;

public class VaiTroBO {
	VaiTroDAO vaitroDAO = new VaiTroDAO();
	public ArrayList<Vai_Tro> getListVaiTro(){
		try {
			return vaitroDAO.getListVaiTro();
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}
}
