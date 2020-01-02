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
import model.bean.Lay_Hang;
import model.bean.Shop;
import model.bean.User;
import model.bo.DonHangBO;
import model.bo.LayHangBO;
import model.bo.ShopBO;
import model.bo.UserBO;

/**
 * Servlet implementation class ListLayHang
 */
@WebServlet("/admin/listlayhang")
public class AdminListLayHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminListLayHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//lay thong tin shop
		ShopBO shopBO = new ShopBO();
		ArrayList<Shop> listshop = shopBO.getListShop();
		request.setAttribute("listshop", listshop);
		//lay ten user
		UserBO userBO = new UserBO();
		ArrayList<User> listuser = userBO.getListUser();
		request.setAttribute("listuser", listuser);
		//lay thong tin don hang
		DonHangBO donhangBO = new DonHangBO();
		ArrayList<Don_Hang> listdonhang = donhangBO.getListDH();
		request.setAttribute("listdonhang", listdonhang);
		
		//lay list layhang
		LayHangBO layhangBO = new LayHangBO();
		ArrayList<Lay_Hang> listlayhang = layhangBO.getListLayHang();
		request.setAttribute("listlayhang", listlayhang);
		
		//chuyen trang
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/admin/listlayhang.jsp");
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
