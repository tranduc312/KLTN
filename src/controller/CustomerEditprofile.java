package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.User;
import model.bean.Vai_Tro;
import model.bo.UserBO;
import model.bo.VaiTroBO;

/**
 * Servlet implementation class CustomerEditprofile
 */
@WebServlet({"/cus/editprofile","/admin/editprofile"})
public class CustomerEditprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerEditprofile() {
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
	    //lay list vai tro
		VaiTroBO vaitroBO = new VaiTroBO();
		ArrayList<Vai_Tro> listvaitro = vaitroBO.getListVaiTro();
		request.setAttribute("listvaitro", listvaitro);
		
		//session
		HttpSession session = request.getSession();
		User loginuser = (User) session.getAttribute("loginuser");
		int ID_User = loginuser.getID_User();
		//edit
		UserBO userBO = new UserBO();
		if("submit".equals(request.getParameter("submit"))) {
			String Ten_User = request.getParameter("Ten_User");
			String SDT = request.getParameter("SDT");	
			String Dia_Chi = request.getParameter("Dia_Chi");
			userBO.editprofile(Ten_User, SDT, Dia_Chi, ID_User);
			response.sendRedirect("profile");
		} else {
			User user = userBO.getByUser(ID_User);
			request.setAttribute("user", user);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/customer/editprofile.jsp");
			dispatcher.forward(request, response);
		}
	}

}
