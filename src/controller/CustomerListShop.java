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

import model.bean.Shop;
import model.bean.User;
import model.bo.ShopBO;
import model.bo.UserBO;

/**
 * Servlet implementation class ListSh	op_User
 */
@WebServlet("/cus/listshop")
public class CustomerListShop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerListShop() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		//lay ten user
		UserBO userBO = new UserBO();
		ArrayList<User> listuser = userBO.getListUser();
		request.setAttribute("listuser", listuser);
		
		//truyen ID_User vao
		HttpSession session = request.getSession();
		User loginuser = (User) session.getAttribute("loginuser");
		int ID_User = loginuser.getID_User();
		
		
		//lay list shop theo user
		ShopBO shopBO = new ShopBO();
		ArrayList<Shop> listshop_user = shopBO.getListShop_ID_User(ID_User);
		request.setAttribute("listshop_user", listshop_user);
		
		//
//		User user = userBO.getByUser(ID_User);
//		request.setAttribute("user", user);
//		Shop shop = shopBO.getByID_User(ID_User);
//		request.setAttribute("shop", shop);
		
		//chuyentrang
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/customer/listshop.jsp");
		dispatcher.forward(request, response);
	}
	
	public int getID_User(HttpSession session) {
		User loginuser = (User) session.getAttribute("loginuser");
		int ID_User = loginuser.getID_User();
		return ID_User;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
