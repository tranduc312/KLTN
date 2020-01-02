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
 * Servlet implementation class CustomerSearchDH
 */
@WebServlet("/cus/viewdonhang")
public class CustomerSearchDH extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerSearchDH() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//session
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
				
		
		//session
		HttpSession session = request.getSession();
	    User loginuser = (User) session.getAttribute("loginuser");
	    int ID_User= loginuser.getID_User();
		
		
		
		//lay ten shop
		ShopBO shopBO = new ShopBO();
		ArrayList<Shop> listshop = shopBO.getListShop();
		request.setAttribute("listshop", listshop);
		
		
		//lay list don hang
		DonHangBO donhangBO = new DonHangBO();
		ArrayList<Don_Hang> listdonhang = donhangBO.getListDH();
		request.setAttribute("listdonhang", listdonhang);
		
		//lay list donhangtheo user
		ArrayList<Don_Hang> listdonhang_user = donhangBO.getlistDH_ID_User(ID_User);
		request.setAttribute("listdonhang_user", listdonhang_user);
		
	
		//search
		
		if("submit".equals(request.getParameter("submit"))) {
			int ID_DH = Integer.parseInt(request.getParameter("ID_DH"));
			String SDT_Nhan = request.getParameter("SDT_Nhan");
			int Tinh_Trang = Integer.parseInt(request.getParameter("Tinh_Trang"));
			donhangBO.searchdonhang(ID_DH, SDT_Nhan, Tinh_Trang, ID_User);
			response.sendRedirect("");
		} else {
			RequestDispatcher dispatcher = request.getServletContext().getNamedDispatcher("/WEB-INF/customer/searchdonhang.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
