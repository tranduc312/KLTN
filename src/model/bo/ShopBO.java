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

import model.bean.Shop;
import model.dao.ShopDAO;

public class ShopBO {
	ShopDAO shopDAO = new ShopDAO();
	
	public ArrayList<Shop> getListShop(){
		try {
			return shopDAO.getListShop();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public ArrayList<Shop> getListShop_ID_User(int ID_User){
		try {
			return shopDAO.getListShop_ID_User(ID_User);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}
	
	//hien thi shop adddonhang
	public ArrayList<Shop> getListShop_AddDH(int ID_User, String Trang_Thai){
		try {
			return shopDAO.getListShop_AddDH(ID_User, Trang_Thai);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Shop getByID(int ID_Shop) {
		return shopDAO.getByID(ID_Shop);
	}
	
	public Shop getByID_User(int ID_User) {
		return shopDAO.getByID_User(ID_User);
	}
	
	public void addShop(String Ten_Shop, String Dia_Chi, int ID_User, String SDT) {
		shopDAO.addShop(Ten_Shop, Dia_Chi, ID_User, SDT);
	}
	
	public void editShop(int ID_Shop,String Ten_Shop, String Dia_Chi, String SDT) {
		shopDAO.editShop(ID_Shop, Ten_Shop, Dia_Chi, SDT);
	}
	
	public void deleteShop(int ID_Shop) {
		shopDAO.deleteShop(ID_Shop);
	}
	
	//blockshop
	public void blockshop(int ID_Shop) {
		shopDAO.blockshop(ID_Shop);
	}
	//unblockshop
	public void unblockshop(int ID_Shop) {
		shopDAO.unblockshop(ID_Shop);
	}
}
