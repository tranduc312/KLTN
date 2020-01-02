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

import model.bean.Don_Hang;
import model.dao.DonHangDAO;

public class DonHangBO {
	DonHangDAO donhangDAO = new DonHangDAO();
	
	public ArrayList<Don_Hang> getListDH() {
		try {
			return donhangDAO.getListDH();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public ArrayList<Don_Hang> getlistDH_ID_User(int ID_User){
		try {
			return donhangDAO.getListDH_ID_User(ID_User);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Don_Hang> getlistDH_ID_Shop(int ID_Shop){
		try {
			return donhangDAO.getListDH_ID_Shop(ID_Shop);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Don_Hang> getListDH_TinhTrang(String Tinh_Trang){
		try {
			return donhangDAO.getListDH_TinhTrang(Tinh_Trang);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Don_Hang getByID(int ID_DH)  {
		try {
			return donhangDAO.getByID(ID_DH);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Don_Hang getByTinhTrang(int Tinh_Trang) {
		try {
			return donhangDAO.getByTinhTrang(Tinh_Trang);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Don_Hang> searchdonhang(int ID_DH, String SDT_Nhan, int Tinh_Trang, int ID_User){
		try {
			return donhangDAO.searchdonhang(ID_DH, SDT_Nhan, Tinh_Trang, ID_User);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void addDonHang(int ID_Shop, String Ten_Nguoi_Nhan, String SDT_Nhan, String DC_Nhan, int Khoi_Luong,
			int Cao, int Rong, int Tien_Thu_Ho, int Cuoc_Phi, int Tinh_Trang) {
		donhangDAO.addDonHang(ID_Shop, Ten_Nguoi_Nhan, SDT_Nhan, DC_Nhan, Khoi_Luong, Cao, Rong, Tien_Thu_Ho, Cuoc_Phi, Tinh_Trang);
	}
	
	public void editDonHang(int ID_DH, String Ten_Nguoi_Nhan, String SDT_Nhan, String DC_Nhan, int Khoi_Luong,
			int Cao, int Rong, int Tien_Thu_Ho) {
		donhangDAO.editDonHang(ID_DH, Ten_Nguoi_Nhan, SDT_Nhan, DC_Nhan, Khoi_Luong, Cao, Rong, Tien_Thu_Ho);
	}
	
	public void cancelDonHang(int ID_DH) {
		donhangDAO.cancelDonHang(ID_DH);
	}
	
	public void undoDonHang(int ID_DH) {
		donhangDAO.undoDonHang(ID_DH);
	}
	
	public void deleteDonHang(int ID_DH) {
		donhangDAO.deleteDonHang(ID_DH);
	}
}
