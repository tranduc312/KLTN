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
import model.bean.Lay_Hang;
import model.bean.User;
import model.bo.DonHangBO;
import model.bo.LayHangBO;
import model.bo.UserBO;

/**
 * Servlet implementation class EditLayHang
 */
@WebServlet("/admin/editlayhang")
public class AdminEditLayHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditLayHang() {
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
		//lay list don hang
		DonHangBO donhangBO = new DonHangBO();
		ArrayList<Don_Hang> listdonhang = donhangBO.getListDH();
		request.setAttribute("listdonhang", listdonhang);
		
		//sua
		LayHangBO layhangBO = new LayHangBO();
		int ID_LH = Integer.parseInt(request.getParameter("ID_LH"));
		if("submit".equals(request.getParameter("submit"))) {
			int ID_User = Integer.parseInt(request.getParameter("ID_User"));
			String Ngay_Lay = request.getParameter("Ngay_Lay");
			int ID_DH = Integer.parseInt(request.getParameter("ID_DH"));
			layhangBO.editLayHang(ID_LH, ID_User, Ngay_Lay, ID_DH);
			response.sendRedirect("listlayhang");
		} else {
			Lay_Hang layhang = layhangBO.getByID(ID_LH);
			request.setAttribute("layhang", layhang);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/admin/editlayhang.jsp");
			dispatcher.forward(request, response);
		}
	}

}
