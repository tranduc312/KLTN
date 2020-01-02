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
import model.bean.Kho;
import model.bean.User;
import model.bo.DonHangBO;
import model.bo.KhoBO;
import model.bo.LayHangBO;
import model.bo.UserBO;

/**
 * Servlet implementation class AddLayHang
 */
@WebServlet("/admin/addlayhang")
public class AdminAddLayHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddLayHang() {
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
		//lay ten user
		UserBO userBO = new UserBO();
		ArrayList<User> listuser = userBO.getListUser();
		request.setAttribute("listuser", listuser);
		//lay ten kho
		KhoBO khoBO = new KhoBO();
		ArrayList<Kho> listkho = khoBO.getListKho();
		request.setAttribute("listkho", listkho);
		//lay list don hang
		DonHangBO donhangBO = new DonHangBO();
		ArrayList<Don_Hang> listdonhang = donhangBO.getListDH();
		request.setAttribute("listdonhang", listdonhang);
		
		//them
		LayHangBO layhangBO = new LayHangBO();
		if("submit".equals(request.getParameter("submit"))) {
			int ID_User = Integer.parseInt(request.getParameter("ID_User"));
			String Ngay_Lay = request.getParameter("Ngay_Lay");
			int ID_DH = Integer.parseInt(request.getParameter("ID_DH"));
			//co 1 kho khoi can truyen
			int ID_kho=1;
			layhangBO.addLay_Hang(ID_User, Ngay_Lay, ID_kho, ID_DH);
			response.sendRedirect("listlayhang");
		} else {
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/admin/addlayhang.jsp");
			dispatcher.forward(request, response);
		}
	}

}
