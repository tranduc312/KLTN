/*
 *Mycode
 *
 *@author Admin
 *@date Oct 11, 2019
 *@version 1.0
*/
package model.bean;

public class Vai_Tro {
	private int ID_Role;
	private String Vai_Tro;
	
	public Vai_Tro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vai_Tro(int iD_Role, String vai_Tro) {
		super();
		ID_Role = iD_Role;
		Vai_Tro = vai_Tro;
	}

	public int getID_Role() {
		return ID_Role;
	}

	public void setID_Role(int iD_Role) {
		ID_Role = iD_Role;
	}

	public String getVai_Tro() {
		return Vai_Tro;
	}

	public void setVai_Tro(String vai_Tro) {
		Vai_Tro = vai_Tro;
	}
	
	
}
