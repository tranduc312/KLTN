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

import model.bean.Giao_Dich;
import model.bean.Shop;
import model.bean.User;
import model.bo.GiaoDichBO;
import model.bo.ShopBO;

/**
 * Servlet implementation class AdminAddGiaoDich
 */
@WebServlet("/admin/addgiaodich")
public class AdminAddGiaoDich extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddGiaoDich() {
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
	    //lay ten shop
	    ShopBO shopBO = new ShopBO();
	    ArrayList<Shop> listshop = shopBO.getListShop();
	    request.setAttribute("listshop", listshop);
	    //lay listgiaodich
	    GiaoDichBO giaodichBO = new GiaoDichBO();
	    
	    Giao_Dich idmax= giaodichBO.getIDMax();
	    request.setAttribute("idmax", idmax);
	    
	    ArrayList<Giao_Dich> listgiaodich = giaodichBO.getListGD();
	    request.setAttribute("listgiaodich", listgiaodich);
	    //session
		HttpSession session = request.getSession();
		User loginuser = (User) session.getAttribute("loginuser");
		int ID_User = loginuser.getID_User();

		
		
	    
		if("submit".equals(request.getParameter("submit"))) {
			int ID_Shop = Integer.parseInt(request.getParameter("ID_Shop"));
	    	giaodichBO.addgiaodich(ID_Shop, ID_User);
	    	response.sendRedirect("listgd&ctgd");
	    } else {
	    	RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/admin/addgiaodich.jsp");
	    	dispatcher.forward(request, response);
	    }
	}

}
