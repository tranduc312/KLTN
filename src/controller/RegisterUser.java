package controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.bo.UserBO;


/**
 * Servlet implementation class AddUser
 */
@WebServlet("/register")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/register.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//dang ky
		UserBO userBO = new UserBO();
		if("submit".equals(request.getParameter("submit"))) {
			String Ten_User = request.getParameter("Ten_User");
			String Mat_Khau = request.getParameter("Mat_Khau");
			String SDT = request.getParameter("SDT");
			String Email = request.getParameter("Email");
			String Dia_Chi = request.getParameter("Dia_Chi");
			userBO.register(Ten_User, Mat_Khau, SDT, Email, Dia_Chi);
			//chuyen toi thong tin ca nhan
			request.setAttribute("thongbao1", "Đăng Ký thành công xin vui lòng đăng nhập");
			response.sendRedirect("login");
			
		} else {
			request.setAttribute("thongbao", "Đăng Ký không thành công");
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/register.jsp");
			dispatcher.forward(request, response);
		}
	}

}
