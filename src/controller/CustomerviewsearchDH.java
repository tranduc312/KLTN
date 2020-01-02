package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Don_Hang;
import model.bean.Shop;
import model.bean.User;
import model.bo.DonHangBO;
import model.bo.ShopBO;

/**
 * Servlet implementation class Customersearch
 */
@WebServlet("/cus/searchdonhang")
public class CustomerviewsearchDH extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private static ArrayList<Don_Hang> listdonhang_search;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerviewsearchDH() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/customer/viewsearchDH.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//session
		HttpSession session = request.getSession();
		User loginuser = (User) session.getAttribute("loginuser");
		int ID_User = loginuser.getID_User();
		
		//
		DonHangBO donhangBO = new DonHangBO();
		ShopBO shopBO = new ShopBO();
		
		//lay list donhang_user
		ArrayList<Don_Hang> listdonhang = donhangBO.getlistDH_ID_User(ID_User);
		request.setAttribute("listdonhang", listdonhang);
		//lay ten shop
		ArrayList<Shop> listshop = shopBO.getListShop();
		request.setAttribute("listshop", listshop);
		
		ArrayList<Don_Hang> listdonhang_search;
		
		if("submit".equals(request.getParameter("submit"))) {
			int ID_DH = Integer.parseInt(request.getParameter("ID_DH"));
			String SDT_Nhan = request.getParameter("SDT_Nhan");
			int Tinh_Trang = Integer.parseInt(request.getParameter("Tinh_Trang"));
			listdonhang_search = donhangBO.searchdonhang(ID_DH, SDT_Nhan, Tinh_Trang, ID_User);
//			listdonhang_search = donhangBO.getListDH();
		} else {
			listdonhang_search = donhangBO.getListDH();
		}
		
		request.setAttribute("listdonhang_search", listdonhang_search);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/customer/viewsearchDH.jsp");
		dispatcher.forward(request, response);
		
		/////////////////////////////////////////////////////////////
		//search
//		if("submit".equals(request.getParameter("submit"))) {
//			int ID_DH = Integer.parseInt(request.getParameter("ID_DH"));
//			String SDT_Nhan = request.getParameter("SDT_Nhan");
//			int Tinh_Trang = Integer.parseInt(request.getParameter("Tinh_Trang"));
//			String Start_Day = request.getParameter("Start_Day");
//			String End_Day = request.getParameter("End_Day");
//			listdonhang_search = donhangBO.searchdonhang(ID_DH, SDT_Nhan, Tinh_Trang, Start_Day, End_Day);
//			
//			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/customer/viewsearchDH.jsp");
//			dispatcher.forward(request, response);
//		} else {
//			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/customer/viewsearchDH.jsp");
//			dispatcher.forward(request, response);
//		}
//		request.setAttribute("listdonhang_search", listdonhang_search);
//		try {
//			int ID_DH = Integer.parseInt(request.getParameter("ID_DH"));
//			String SDT_Nhan = request.getParameter("SDT_Nhan");
//			int Tinh_Trang = Integer.parseInt(request.getParameter("Tinh_Trang"));
//			String Start_Day = request.getParameter("Start_Day");
//			String End_Day = request.getParameter("End_Day");
//			listdonhang_search = donhangBO.searchdonhang(ID_DH, SDT_Nhan, Tinh_Trang, Start_Day, End_Day);
//			request.setAttribute("listdonhang_search", listdonhang_search);
//			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/customer/viewsearchDH.jsp");
//			dispatcher.forward(request, response);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
