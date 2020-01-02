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
import model.bean.Giao_Dich;
import model.bo.CTGDBO;
import model.bo.DonHangBO;
import model.bo.GiaoDichBO;

/**
 * Servlet implementation class AdminAddCTGD
 */
@WebServlet("/admin/addctgd")
public class AdminAddCTGD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddCTGD() {
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
	    
	    CTGDBO ctgdBO = new CTGDBO();
	    DonHangBO donhangBO = new DonHangBO();
	    GiaoDichBO giaodichBO = new GiaoDichBO();
	    
	    //lay list ctgd
	    ArrayList<CTGD> listctgd = new ArrayList<CTGD>();
	    request.setAttribute("listctgd", listctgd);
	    //lay id giao dich va id_shop
	    Giao_Dich idmax= giaodichBO.getIDMax();
	    request.setAttribute("idmax", idmax);
	    int ID_GD = idmax.getID_GD();
	    int ID_Shop = idmax.getID_Shop();
	    
	    // lay listdonhang theo shop 
	    ArrayList<Don_Hang> listdonhang = donhangBO.getlistDH_ID_Shop(ID_Shop);
	    request.setAttribute("listdonhang", listdonhang);
	    //them
	    if("submit".equals(request.getParameter("submit"))) {
	    	int ID_DH = Integer.parseInt(request.getParameter("ID_DH"));
	    	ctgdBO.addctgd(ID_GD, ID_DH);
	    	response.sendRedirect("listgd&ctgd");
	    } else {
	    	RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/admin/addctgd.jsp");
	    	dispatcher.forward(request, response);
	    }
	}

}
