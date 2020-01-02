/*
 *Mycode
 *
 *@author Admin
 *@date Oct 11, 2019
 *@version 1.0
*/
package model.bean;

public class User {
	private int ID_User;
	private String Ten_User;
	private String Mat_Khau;
	private String SDT;
	private String Email;
	private String Dia_Chi;
	private int ID_Role;
	private int ID_Kho;
	private String Trang_Thai;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int iD_User, String ten_User, String mat_Khau, String sDT, String email,
			String dia_Chi, int iD_Role, int iD_Kho,String trang_Thai) {
		super();
		ID_User = iD_User;
		Ten_User = ten_User;
		Mat_Khau = mat_Khau;
		SDT = sDT;
		Email = email;
		Dia_Chi = dia_Chi;
		ID_Role = iD_Role;
		ID_Kho = iD_Kho;
		Trang_Thai = trang_Thai;
	}
	
	public String getTrang_Thai() {
		return Trang_Thai;
	}
	public void setTrang_Thai(String trang_Thai) {
		Trang_Thai = trang_Thai;
	}
	public int getID_Kho() {
		return ID_Kho;
	}
	public void setID_Kho(int iD_Kho) {
		ID_Kho = iD_Kho;
	}
	public int getID_User() {
		return ID_User;
	}
	public void setID_User(int iD_User) {
		ID_User = iD_User;
	}
	public String getTen_User() {
		return Ten_User;
	}
	public void setTen_User(String ten_User) {
		Ten_User = ten_User;
	}
	public String getMat_Khau() {
		return Mat_Khau;
	}
	public void setMat_Khau(String mat_Khau) {
		Mat_Khau = mat_Khau;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getDia_Chi() {
		return Dia_Chi;
	}
	public void setDia_Chi(String dia_Chi) {
		Dia_Chi = dia_Chi;
	}
	public int getID_Role() {
		return ID_Role;
	}
	public void setID_Role(int iD_Role) {
		ID_Role = iD_Role;
	}
	
	
}
