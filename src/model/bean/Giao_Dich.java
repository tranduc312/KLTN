/*
 *Mycode
 *
 *@author Admin
 *@date Oct 11, 2019
 *@version 1.0
*/
package model.bean;

public class Giao_Dich {
	private int ID_GD;
	private int ID_User;
	private int ID_Shop;
	private String Ngay_Tra;
	public Giao_Dich() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Giao_Dich(int iD_GD, int iD_User, int iD_Shop, String ngay_Tra) {
		super();
		ID_GD = iD_GD;
		ID_User = iD_User;
		ID_Shop = iD_Shop;
		Ngay_Tra = ngay_Tra;
	}
	public int getID_GD() {
		return ID_GD;
	}
	public void setID_GD(int iD_GD) {
		ID_GD = iD_GD;
	}
	public int getID_User() {
		return ID_User;
	}
	public void setID_User(int iD_User) {
		ID_User = iD_User;
	}
	public int getID_Shop() {
		return ID_Shop;
	}
	public void setID_Shop(int iD_Shop) {
		ID_Shop = iD_Shop;
	}
	public String getNgay_Tra() {
		return Ngay_Tra;
	}
	public void setNgay_Tra(String ngay_Tra) {
		Ngay_Tra = ngay_Tra;
	}
	
	
}
