/*
 *Mycode
 *
 *@author Admin
 *@date Oct 11, 2019
 *@version 1.0
*/
package model.bean;

public class Kho {
		private int ID_kho;
		private String Ten_Kho;
		private String Dia_Chi;
		public Kho() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Kho(int iD_kho, String ten_Kho, String dia_Chi) {
			super();
			ID_kho = iD_kho;
			Ten_Kho = ten_Kho;
			Dia_Chi = dia_Chi;
		}
		
		public int getID_kho() {
			return ID_kho;
		}
		public void setID_kho(int iD_kho) {
			ID_kho = iD_kho;
		}
		public String getTen_Kho() {
			return Ten_Kho;
		}
		public void setTen_Kho(String ten_Kho) {
			Ten_Kho = ten_Kho;
		}
		public String getDia_Chi() {
			return Dia_Chi;
		}
		public void setDia_Chi(String dia_Chi) {
			Dia_Chi = dia_Chi;
		}
		
		

}
