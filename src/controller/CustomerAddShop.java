package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.User;
import model.bo.ShopBO;

/**
 * Servlet implementation class AddShop
 */
@WebServlet("/cus/addshop")
public class CustomerAddShop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAddShop() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		//lay list user
	    
	    //truyen ID_User vao
	    HttpSession session = request.getSession();
	    User loginuser = (User) session.getAttribute("loginuser");
		int ID_User = loginuser.getID_User();
		ShopBO shopBO = new ShopBO();
		if("submit".equals(request.getParameter("submit"))) {
			String Ten_Shop = request.getParameter("Ten_Shop");
			String Dia_Chi = request.getParameter("Dia_Chi");
			String SDT = request.getParameter("SDT");
			shopBO.addShop(Ten_Shop, Dia_Chi, ID_User, SDT);
			response.sendRedirect("listshop");
		} else {
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/customer/addshop.jsp");
			dispatcher.forward(request, response);
		}
	}

}
