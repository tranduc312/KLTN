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
import model.bean.Giao_Hang;
import model.bean.User;
import model.bo.DonHangBO;
import model.bo.GiaoHangBO;
import model.bo.UserBO;

/**
 * Servlet implementation class AdminEditGiaoHang
 */
@WebServlet("/admin/editgiaohang")
public class AdminEditGiaoHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditGiaoHang() {
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
		
		//lay ten user
		UserBO userBO = new UserBO();
		ArrayList<User> listuser = userBO.getListUser();
		request.setAttribute("listuser", listuser);
		//lay listdonhang
		DonHangBO donhangBO = new DonHangBO();
		ArrayList<Don_Hang> listdonhang = donhangBO.getListDH();
		request.setAttribute("listdonhang", listdonhang);
		
		//sua giao hang
		GiaoHangBO giaohangBO = new GiaoHangBO();
		int ID_GH = Integer.parseInt(request.getParameter("ID_GH"));
		if("submit".equals(request.getParameter("submit"))) {
			int ID_User = Integer.parseInt(request.getParameter("ID_User"));
			int ID_DH = Integer.parseInt(request.getParameter("ID_DH"));
			String Ngay_Giao = request.getParameter("Ngay_Giao");
			giaohangBO.editGH(ID_GH, ID_User, ID_DH, Ngay_Giao);
			response.sendRedirect("listgiaohang");
		} else {
			Giao_Hang giaohang = giaohangBO.getByID_GH(ID_GH);
			request.setAttribute("giaohang", giaohang);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/admin/editgiaohang.jsp");
			dispatcher.forward(request, response);
 		}
	}

}
