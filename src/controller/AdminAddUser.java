package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Vai_Tro;
import model.bo.UserBO;
import model.bo.VaiTroBO;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/admin/adduser")
public class AdminAddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddUser() {
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
		//lay vai tro???
		VaiTroBO vaitroBO = new VaiTroBO();
		ArrayList<Vai_Tro> listvaitro = vaitroBO.getListVaiTro();
		request.setAttribute("listvaitro", listvaitro);
		
		//them
		UserBO userBO = new UserBO();
		if("submit".equals(request.getParameter("submit"))) {
			String Ten_User = request.getParameter("Ten_User");
			String Mat_Khau = request.getParameter("Mat_Khau");
			String SDT = request.getParameter("SDT");
			String Email = request.getParameter("Email");
			String Dia_Chi = request.getParameter("Dia_Chi");
			int ID_Kho = 1;
			int Trang_Thai=0;
			int ID_Role = Integer.parseInt(request.getParameter("ID_Role"));
			userBO.addUser(Ten_User, Mat_Khau, SDT, Email, Dia_Chi, ID_Role, ID_Kho, Trang_Thai);
			response.sendRedirect("listuser");
		} else {
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/admin/adduser.jsp");
			dispatcher.forward(request, response);
		}
	}

}
