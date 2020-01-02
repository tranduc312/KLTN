package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.User;
import model.bean.Vai_Tro;
import model.bo.UserBO;
import model.bo.VaiTroBO;

/**
 * Servlet implementation class EditUser
 */
@WebServlet("/admin/edituser")
public class AdminEditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditUser() {
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
		//lay vai tro\
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
		VaiTroBO vaitroBO = new VaiTroBO();
		ArrayList<Vai_Tro> listvaitro = vaitroBO.getListVaiTro();
		request.setAttribute("listvaitro", listvaitro);
		//edit
		UserBO userBO = new UserBO();
		int ID_User = Integer.parseInt(request.getParameter("ID_User"));
		if("submit".equals(request.getParameter("submit"))) {
			String Ten_User = request.getParameter("Ten_User");
			String Mat_Khau = request.getParameter("Mat_khau");
			String SDT = request.getParameter("SDT");
			String Dia_Chi = request.getParameter("Dia_Chi");
			userBO.editUser(Ten_User, Mat_Khau, SDT, Dia_Chi, ID_User);
			response.sendRedirect("listuser");
		} else {
			User user = userBO.getByUser(ID_User);
			request.setAttribute("user", user);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/admin/edituser.jsp");
			dispatcher.forward(request, response);
		}
				
	}

}
