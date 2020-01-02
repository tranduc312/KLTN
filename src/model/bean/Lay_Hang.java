/*
 *Mycode
 *
 *@author Admin
 *@date Oct 11, 2019
 *@version 1.0
*/
package model.bean;

public class Lay_Hang {
	private int ID_LH;
	private int ID_User;
	private String Ngay_Lay;
	private int ID_Kho;
	private int ID_DH;
	public Lay_Hang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Lay_Hang(int iD_LH,int iD_User, String ngay_Lay, int iD_Kho, int iD_DH) {
		super();
		ID_LH = iD_LH;
		ID_User = iD_User;
		Ngay_Lay = ngay_Lay;
		ID_Kho = iD_Kho;
		ID_DH = iD_DH;
	}
	public int getID_User() {
		return ID_User;
	}
	public void setID_User(int iD_User) {
		ID_User = iD_User;
	}
	public int getID_LH() {
		return ID_LH;
	}
	public void setID_LH(int iD_LH) {
		ID_LH = iD_LH;
	}
	public String getNgay_Lay() {
		return Ngay_Lay;
	}
	public void setNgay_Lay(String ngay_Lay) {
		Ngay_Lay = ngay_Lay;
	}
	public int getID_Kho() {
		return ID_Kho;
	}
	public void setID_Kho(int iD_Kho) {
		ID_Kho = iD_Kho;
	}
	public int getID_DH() {
		return ID_DH;
	}
	public void setID_DH(int iD_DH) {
		ID_DH = iD_DH;
	}
	
	
}
