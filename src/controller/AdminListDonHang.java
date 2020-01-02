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
import model.bean.Shop;
import model.bo.DonHangBO;
import model.bo.ShopBO;

/**
 * Servlet implementation class ListDonHang
 */
@WebServlet("/admin/listdonhang")
public class AdminListDonHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminListDonHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//lay ten shop
		ShopBO shopBO = new ShopBO();
		ArrayList<Shop> listshop = shopBO.getListShop();
		request.setAttribute("listshop", listshop);
		
		//lay list don hang
		DonHangBO donhangBO = new DonHangBO();
		ArrayList<Don_Hang> listdonhang = donhangBO.getListDH();
		request.setAttribute("listdonhang", listdonhang);
		
		//chuyen trang
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/admin/listdonhang.jsp");
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
