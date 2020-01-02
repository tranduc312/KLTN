package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Don_Hang;
import model.bean.Giao_Dich;
import model.bean.Shop;
import model.bean.User;
import model.bo.DonHangBO;
import model.bo.GiaoDichBO;
import model.bo.ShopBO;
import model.bo.UserBO;

/**
 * Servlet implementation class AdminListGiaoDich
 */
@WebServlet("/admin/listgiaodich")
public class AdminListGiaoDich extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminListGiaoDich() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		GiaoDichBO giaodichBO = new GiaoDichBO();
		UserBO userBO = new UserBO();
		ShopBO shopBO = new ShopBO();
		DonHangBO donhangBO = new DonHangBO();
		
		//lay ten user
		ArrayList<User> listuser = userBO.getListUser();
		request.setAttribute("listuser", listuser);
		//lay ten shop
		ArrayList<Shop> listshop = shopBO.getListShop();
		request.setAttribute("listshop", listshop);
		//lay tien thu ho o don hang
		ArrayList<Don_Hang> listdonhang = donhangBO.getListDH();
		request.setAttribute("listdonhang", listdonhang);
		//lay list giao dich
		ArrayList<Giao_Dich> listgiaodich = giaodichBO.getListGD();
		request.setAttribute("listgiaodich", listgiaodich);
		//chuyen trang
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/admin/listgiaodich.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
