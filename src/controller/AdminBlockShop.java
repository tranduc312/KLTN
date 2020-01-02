package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Shop;
import model.bo.ShopBO;

/**
 * Servlet implementation class AdminBlockShop
 */
@WebServlet("/admin/blockshop")
public class AdminBlockShop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBlockShop() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ShopBO shopBO = new ShopBO();
		int ID_Shop = Integer.parseInt(request.getParameter("ID_Shop"));
		Shop shop = shopBO.getByID(ID_Shop);
		if(Integer.parseInt(shop.getTrang_Thai())==0) {
			shopBO.blockshop(ID_Shop);
		} else {
			shopBO.unblockshop(ID_Shop);
		}
		response.sendRedirect("listshop");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
