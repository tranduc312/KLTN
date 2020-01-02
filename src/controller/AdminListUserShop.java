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
import model.bean.Vai_Tro;
import model.bo.ShopBO;
import model.bo.UserBO;
import model.bo.VaiTroBO;

/**
 * Servlet implementation class AdminListUserShop
 */
@WebServlet("/admin/listusershop")
public class AdminListUserShop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminListUserShop() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserBO userBO = new UserBO();
		ArrayList<User> listuser = userBO.getListUser();
		request.setAttribute("listuser",listuser );
		//lay list vaitro
		VaiTroBO vaitroBO = new VaiTroBO();
		ArrayList<Vai_Tro> listvaitro = vaitroBO.getListVaiTro();
		request.setAttribute("listvaitro", listvaitro);
		//lay thong tin shop
		ShopBO shopBO = new ShopBO();
		ArrayList<Shop> listshop = shopBO.getListShop();
		request.setAttribute("listshop", listshop);
		
		//chuyen trang
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/admin/listusershop.jsp");
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
