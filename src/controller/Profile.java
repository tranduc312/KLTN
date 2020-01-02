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
 * Servlet implementation class Profile
 */
@WebServlet({"/cus/profile","/admin/profile"})
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//truyen ID_User vao
		HttpSession session = request.getSession();
		User loginuser = (User) session.getAttribute("loginuser");
		int ID_User = loginuser.getID_User();
		//lay vai tro
		VaiTroBO vaitroBO = new VaiTroBO();
		ArrayList<Vai_Tro> listvaitro = vaitroBO.getListVaiTro();
		request.setAttribute("listvaitro", listvaitro);
		
		//
		UserBO userBO = new UserBO();
		User user = userBO.getByUser(ID_User);
		request.setAttribute("user", user);
		
		//
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/customer/profile.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
