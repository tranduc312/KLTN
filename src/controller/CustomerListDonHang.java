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
import model.bo.UserBO;

/**
 * Servlet implementation class CustomerListDonHang
 */
@WebServlet("/cus/listdonhang")
public class CustomerListDonHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerListDonHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
		//truyen ID_User
	    HttpSession session = request.getSession();
		User loginuser = (User) session.getAttribute("loginuser");
		int ID_User = loginuser.getID_User();
//		String Tinh_Trang = "dangnhan";
		DonHangBO donhangBO = new DonHangBO();
		ShopBO shopBO = new ShopBO();
		UserBO userBO = new UserBO();
		
		
		//lay list user
		ArrayList<User> listuser = userBO.getListUser();
		request.setAttribute("listuser", listuser);
		
		//lay ten shop
		ArrayList<Shop> listshop = shopBO.getListShop();
		request.setAttribute("listshop", listshop);
		
		//lay list don hang
		ArrayList<Don_Hang> listdonhang = donhangBO.getListDH();
		request.setAttribute("listdonhang", listdonhang);
		
		
		//lay list donhangtheo user
		ArrayList<Don_Hang> listdonhang_user = donhangBO.getlistDH_ID_User(ID_User);
		request.setAttribute("listdonhang_user", listdonhang_user);
		
		//lay list don hang theo tinh trang
//		ArrayList<Don_Hang> listdonhang_tinhtrang = donhangBO.getListDH_TinhTrang(Tinh_Trang);
//		request.setAttribute("listdonhang_tinhtrang", listdonhang_tinhtrang);
		
		//chuyen trang
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/customer/listdonhang.jsp");
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
