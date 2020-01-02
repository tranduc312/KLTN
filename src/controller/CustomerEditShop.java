package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Shop;
import model.bo.ShopBO;

/**
 * Servlet implementation class EditShop
 */
@WebServlet("/cus/editshop")
public class CustomerEditShop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerEditShop() {
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
	    
		int ID_Shop = Integer.parseInt(request.getParameter("ID_Shop"));
		ShopBO shopBO = new ShopBO();
		if("submit".equals(request.getParameter("submit"))) {
			String Ten_Shop = request.getParameter("Ten_Shop");
			String Dia_Chi = request.getParameter("Dia_Chi");
			String SDT = request.getParameter("SDT");
			shopBO.editShop(ID_Shop, Ten_Shop, Dia_Chi, SDT);
			response.sendRedirect("listshop");
		} else {
			Shop shop = shopBO.getByID(ID_Shop);
			request.setAttribute("shop", shop);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/customer/editshop.jsp");
			dispatcher.forward(request, response);
			
		}
	}

}
