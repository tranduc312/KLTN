package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Don_Hang;
import model.bean.Shop;
import model.bo.DonHangBO;
import model.bo.ShopBO;

/**
 * Servlet implementation class EditDonHang
 */
@WebServlet("/cus/editdonhang")
public class CustomerEditDonHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerEditDonHang() {
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
		
		//lay ten shop
		ShopBO shopBO = new ShopBO();
		ArrayList<Shop> listshop = shopBO.getListShop();
		request.setAttribute("listshop", listshop);
		
		//sua
		int ID_DH = Integer.parseInt(request.getParameter("ID_DH"));
		DonHangBO donhangBO = new DonHangBO();
		if("submit".equals(request.getParameter("submit"))) {
			String Ten_Nguoi_Nhan = request.getParameter("Ten_Nguoi_Nhan");
			String SDT_Nhan = request.getParameter("SDT_Nhan");
			String DC_Nhan = request.getParameter("DC_Nhan");
			int Khoi_Luong = Integer.parseInt(request.getParameter("Khoi_Luong"));
			int Cao = Integer.parseInt(request.getParameter("Cao"));
			int Rong = Integer.parseInt(request.getParameter("Rong"));
			int Tien_Thu_Ho = Integer.parseInt(request.getParameter("Tien_Thu_Ho"));
			donhangBO.editDonHang(ID_DH, Ten_Nguoi_Nhan, SDT_Nhan, DC_Nhan, Khoi_Luong, Cao, Rong, Tien_Thu_Ho);
			response.sendRedirect("listdonhang");
		} else {
			Don_Hang donhang = donhangBO.getByID(ID_DH);
			request.setAttribute("donhang", donhang);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/customer/editdonhang.jsp");
			dispatcher.forward(request, response);
		}
	}

}
