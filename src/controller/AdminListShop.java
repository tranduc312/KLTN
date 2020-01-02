package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Shop;
import model.bean.User;
import model.bo.ShopBO;
import model.bo.UserBO;

/**
 * Servlet implementation class ListShop
 */
@WebServlet("/admin/listshop")
public class AdminListShop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminListShop() {
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
		
		//lay list shop
		ShopBO shopBO = new ShopBO();
		ArrayList<Shop> listshop  = shopBO.getListShop();
		request.setAttribute("listshop", listshop);
		
		//chuyentrang
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/admin/listshop.jsp");
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
