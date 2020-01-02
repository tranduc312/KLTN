package controller;

import java.io.IOException;

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
 * Servlet implementation class CustomerEditMatKhau
 */
@WebServlet({"/cus/changematkhau","/admin/changematkhau"})
public class CustomerChangeMatKhau extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerChangeMatKhau() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		UserBO userBO = new UserBO();
		
		//session
		HttpSession session = request.getSession();
		User loginuser = (User) session.getAttribute("loginuser");
		int ID_User= loginuser.getID_User();
		User user = userBO.getByUser(ID_User);
		
		
		// truyen ID_User sida
//		UserBO userBO = new UserBO();
//		int ID_User = Integer.parseInt(request.getParameter("ID_User"));
//		User user = userBO.getByUser(ID_User);
		
		if("submit".equals(request.getParameter("submit"))) {
			String Mat_Khau = request.getParameter("Mat_Khau");
			String Mat_Khau_moi = request.getParameter("Mat_Khau_moi");
			if(userBO.checkMatKhau(Mat_Khau)) {
				userBO.changeMatKhau(ID_User, Mat_Khau_moi);
				response.sendRedirect("profile");
			} else {
				request.setAttribute("user", user);
				request.setAttribute("thongbao", "Sai mật khẩu rồi cu");
				RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/customer/changematkhau.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			
			request.setAttribute("user", user);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/customer/changematkhau.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
