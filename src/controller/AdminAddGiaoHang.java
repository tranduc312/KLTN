package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Don_Hang;
import model.bean.User;
import model.bo.DonHangBO;
import model.bo.GiaoHangBO;
import model.bo.UserBO;

/**
 * Servlet implementation class AdminAddGiaoHang
 */
@WebServlet("/admin/addgiaohang")
public class AdminAddGiaoHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddGiaoHang() {
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
	    //lay list ten user
	    UserBO userBO = new UserBO();
	    ArrayList<User> listuser = userBO.getListUser();
	    request.setAttribute("listuser", listuser);
	    //lay list ID_DH
	    DonHangBO donhangBO = new DonHangBO();
	    ArrayList<Don_Hang> listdonhang = donhangBO.getListDH();
	    request.setAttribute("listdonhang", listdonhang);
	    //them
	    GiaoHangBO giaohangBO = new GiaoHangBO();
	    //convert datetime to string
	    
	   
	    if("submit".equals(request.getParameter("submit"))) {
	    	 int ID_User = Integer.parseInt(request.getParameter("ID_User"));
	    	 int ID_DH = Integer.parseInt(request.getParameter("ID_DH"));
	    	 String Ngay_Giao =request.getParameter("Ngay_Giao");
	    	 giaohangBO.addGH(ID_User, ID_DH, Ngay_Giao);
	    	 response.sendRedirect("listgiaohang");
	    } else {
	    	RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/admin/addgiaohang.jsp");
	    	dispatcher.forward(request, response);
	    }
	}

}
