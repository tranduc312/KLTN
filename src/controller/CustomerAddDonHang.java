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

import model.bean.Shop;
import model.bean.User;
import model.bo.DonHangBO;
import model.bo.ShopBO;

/**
 * Servlet implementation class AddDonHang
 */
@WebServlet("/cus/adddonhang")
public class CustomerAddDonHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAddDonHang() {
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
		//truyen ID_User vao
	    HttpSession session = request.getSession();
	    User loginuser = (User) session.getAttribute("loginuser");
	    int ID_User= loginuser.getID_User();
	    //lay ten shop theo user
		ShopBO shopBO = new ShopBO();
		String Trang_Thai="0";
		ArrayList<Shop> listshop_user = shopBO.getListShop_AddDH(ID_User, Trang_Thai);
		request.setAttribute("listshop_user", listshop_user);
		
		//them
		DonHangBO donhangBO = new DonHangBO();
		if("submit".equals(request.getParameter("submit"))) {
			int ID_Shop = Integer.parseInt(request.getParameter("ID_Shop"));
			String Ten_Nguoi_Nhan = request.getParameter("Ten_Nguoi_Nhan");
			String SDT_Nhan = request.getParameter("SDT_Nhan");
			String DC_Nhan = request.getParameter("DC_Nhan");
			int Khoi_Luong = Integer.parseInt(request.getParameter("Khoi_Luong"));
			int Cao = Integer.parseInt(request.getParameter("Cao"));
			int Rong = Integer.parseInt(request.getParameter("Rong"));
			int Tien_Thu_Ho = Integer.parseInt(request.getParameter("Tien_Thu_Ho"));
			int Cuoc_Phi = Integer.parseInt(request.getParameter("Cuoc_Phi"));
			int Tinh_Trang = Integer.parseInt("1") ;
			donhangBO.addDonHang(ID_Shop, Ten_Nguoi_Nhan, SDT_Nhan, DC_Nhan, Khoi_Luong, Cao, Rong, Tien_Thu_Ho, Cuoc_Phi, Tinh_Trang);
			response.sendRedirect("listdonhang");
		} else {
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/customer/adddonhang.jsp");
			dispatcher.forward(request, response);
		}
	}

}
