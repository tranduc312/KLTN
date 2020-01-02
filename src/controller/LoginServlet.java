package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.User;
import model.bo.UserBO;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int ID_Role = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//dang nhap
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String Email = request.getParameter("Email");
		String Mat_Khau  = request.getParameter("Mat_Khau");
		UserBO userBO = new UserBO();
		//session
//		ArrayList<User> listuser = userBO.getListUser();
//		HttpSession sessionuser = request.getSession();
//		sessionuser.setAttribute("listuser", listuser);
		
		User loginuser = userBO.getByEmail(Email);
		try {
			if(userBO.CheckLogin(Email, Mat_Khau)) {
				HttpSession session = request.getSession();
				session.setAttribute("Email", Email);
				session.setAttribute("loginuser", loginuser);
				switch (userBO.checkvaitro(ID_Role, Email)) {
				case 1:
					response.sendRedirect("admin/listshop");
					break;
				case 2:
					response.sendRedirect("cus/listdonhang");
					break;
				case 3:
					response.sendRedirect("admin/listlayhang");
					break;
				case 4:
					response.sendRedirect("admin/listgiaohang");
					break;
				case 5:
					response.sendRedirect("home");
				}
			} else {
				request.setAttribute("thongbao","Đăng Nhập không thành công");
				RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
