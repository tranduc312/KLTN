/*
 *Mycode
 *
 *@author Admin
 *@date Oct 11, 2019
 *@version 1.0
*/
package model.bean;

public class Shop {
	private int ID_Shop;
	private String Ten_Shop;
	private String Dia_Chi;
	private int ID_User;
	private String SDT;
	private String Trang_Thai;
	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Shop(int iD_Shop, String ten_Shop, String dia_Chi, int iD_User, String sDT, String trang_Thai) {
		super();
		ID_Shop = iD_Shop;
		Ten_Shop = ten_Shop;
		Dia_Chi = dia_Chi;
		ID_User = iD_User;
		SDT = sDT;
		Trang_Thai=trang_Thai;
	}

	
	public String getTrang_Thai() {
		return Trang_Thai;
	}
	public void setTrang_Thai(String trang_Thai) {
		Trang_Thai = trang_Thai;
	}
	public int getID_Shop() {
		return ID_Shop;
	}
	public void setID_Shop(int iD_Shop) {
		ID_Shop = iD_Shop;
	}
	public String getTen_Shop() {
		return Ten_Shop;
	}
	public void setTen_Shop(String ten_Shop) {
		Ten_Shop = ten_Shop;
	}
	public String getDia_Chi() {
		return Dia_Chi;
	}
	public void setDia_Chi(String dia_Chi) {
		Dia_Chi = dia_Chi;
	}
	public int getID_User() {
		return ID_User;
	}
	public void setID_User(int iD_User) {
		ID_User = iD_User;
	}
	
	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}
}
