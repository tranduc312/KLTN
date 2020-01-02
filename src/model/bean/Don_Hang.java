/*
 *Mycode
 *
 *@author Admin
 *@date Oct 11, 2019
 *@version 1.0
*/
package model.bean;

public class Don_Hang {
	private int ID_DH;
	private int ID_Shop;
	private String Ten_Nguoi_Nhan;
	private String SDT_Nhan;
	private String DC_Nhan;
	private int Khoi_Luong;
	private int Cao;
	private int Rong;
	private String Ngay_Lap;
	private int Tien_Thu_Ho;
	private int Cuoc_Phi;
	private int Tinh_Trang;
	public Don_Hang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Don_Hang(int iD_DH, int iD_Shop, String ten_Nguoi_Nhan, String sDT_Nhan, String dC_Nhan,
			int khoi_Luong, int cao, int rong, String ngay_Lap, int tien_Thu_Ho,
			int tong_Tien, int tinh_Trang) {
		super();
		ID_DH = iD_DH;
		ID_Shop = iD_Shop;
		Ten_Nguoi_Nhan = ten_Nguoi_Nhan;
		SDT_Nhan = sDT_Nhan;
		DC_Nhan = dC_Nhan;
		Khoi_Luong = khoi_Luong;
		Cao = cao;
		Rong = rong;
		Ngay_Lap = ngay_Lap;
		Tien_Thu_Ho = tien_Thu_Ho;
		Cuoc_Phi = tong_Tien;
		Tinh_Trang = tinh_Trang;
	}
	public int getID_DH() {
		return ID_DH;
	}
	public void setID_DH(int iD_DH) {
		ID_DH = iD_DH;
	}
	public int getID_Shop() {
		return ID_Shop;
	}
	public void setID_Shop(int iD_Shop) {
		ID_Shop = iD_Shop;
	}
	public String getTen_Nguoi_Nhan() {
		return Ten_Nguoi_Nhan;
	}
	public void setTen_Nguoi_Nhan(String ten_Nguoi_Nhan) {
		Ten_Nguoi_Nhan = ten_Nguoi_Nhan;
	}
	public String getSDT_Nhan() {
		return SDT_Nhan;
	}
	public void setSDT_Nhan(String sDT_Nhan) {
		SDT_Nhan = sDT_Nhan;
	}
	public String getDC_Nhan() {
		return DC_Nhan;
	}
	public void setDC_Nhan(String dC_Nhan) {
		DC_Nhan = dC_Nhan;
	}
	public int getKhoi_Luong() {
		return Khoi_Luong;
	}
	public void setKhoi_Luong(int khoi_Luong) {
		Khoi_Luong = khoi_Luong;
	}
	public int getCao() {
		return Cao;
	}
	public void setCao(int cao) {
		Cao = cao;
	}
	public int getRong() {
		return Rong;
	}
	public void setRong(int rong) {
		Rong = rong;
	}
	public String getNgay_Lap() {
		return Ngay_Lap;
	}
	public void setNgay_Lap(String ngay_Lap) {
		Ngay_Lap = ngay_Lap;
	}
	public int getTien_Thu_Ho() {
		return Tien_Thu_Ho;
	}
	public void setTien_Thu_Ho(int tien_Thu_Ho) {
		Tien_Thu_Ho = tien_Thu_Ho;
	}
	public int getCuoc_Phi() {
		return Cuoc_Phi;
	}
	public void setCuoc_Phi(int cuoc_Phi) {
		Cuoc_Phi = cuoc_Phi;
	}
	public int getTinh_Trang() {
		return Tinh_Trang;
	}
	public void setTinh_Trang(int tinh_Trang) {
		Tinh_Trang = tinh_Trang;
	}
	
	
}
