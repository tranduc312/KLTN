/*
 *Mycode
 *
 *@author Admin
 *@date Oct 11, 2019
 *@version 1.0
*/
package model.bean;

public class Giao_Hang {
	private int ID_GH;
	private int ID_User;
	private int ID_DH;
	private String Ngay_Giao;
	public Giao_Hang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Giao_Hang(int iD_GH, int iD_User, int iD_DH, String ngay_Giao) {
		super();
		ID_GH = iD_GH;
		ID_User = iD_User;
		ID_DH = iD_DH;
		Ngay_Giao = ngay_Giao;
	}
	public int getID_GH() {
		return ID_GH;
	}
	public void setID_GH(int iD_GH) {
		ID_GH = iD_GH;
	}
	public int getID_User() {
		return ID_User;
	}
	public void setID_User(int iD_User) {
		ID_User = iD_User;
	}
	public int getID_DH() {
		return ID_DH;
	}
	public void setID_DH(int iD_DH) {
		ID_DH = iD_DH;
	}
	public String getNgay_Giao() {
		return Ngay_Giao;
	}
	public void setNgay_Giao(String ngay_Giao) {
		Ngay_Giao = ngay_Giao;
	}
	
	
}
