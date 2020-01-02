package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.CTGD;
import model.bean.Don_Hang;
import model.bo.CTGDBO;
import model.bo.DonHangBO;

/**
 * Servlet implementation class AdminListCTGD
 */
@WebServlet("/admin/listctgd")
public class AdminListCTGD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminListCTGD() {
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
		DonHangBO donhangBO = new DonHangBO();
		CTGDBO ctgdBO = new CTGDBO();
		//lay list don hang
		ArrayList<Don_Hang> listdonhang = donhangBO.getListDH();
		request.setAttribute("listdonhang", listdonhang);
		//lay list CTGD 
		ArrayList<CTGD> listctgd = ctgdBO.getListCTGD();
		request.setAttribute("listctgd", listctgd);
		//lay list CTGD theo ID_GD
		int ID_GD = Integer.parseInt(request.getParameter("ID_GD"));
		ArrayList<CTGD> listctgd_id_gd = ctgdBO.getListCTGDGD_ID_GD(ID_GD);
		request.setAttribute("listctgd_id_gd", listctgd_id_gd);
		//chuyen trang
		
		
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/admin/listctgd.jsp");
		dispatcher.forward(request, response);
	}

}
