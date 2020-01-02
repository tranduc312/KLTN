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
import model.bean.Shop;
import model.bean.User;
import model.bo.CTGDBO;
import model.bo.DonHangBO;
import model.bo.GiaoDichBO;
import model.bo.ShopBO;
import model.bo.UserBO;

/**
 * Servlet implementation class AdminListgdctgd
 */
@WebServlet("/admin/listgd&ctgd")
public class AdminListgdctgd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminListgdctgd() {
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
	    response.setContentType("text/html; charset=UTF-8");
	    
	    GiaoDichBO giaodichBO = new GiaoDichBO();
	    CTGDBO ctgdBO = new CTGDBO();
	    ShopBO shopBO = new ShopBO();
	    UserBO userBO = new UserBO();
	    DonHangBO donhangBO = new DonHangBO();

  		
  		Giao_Dich idmax= giaodichBO.getIDMax();
	    request.setAttribute("idmax", idmax);
	    int ID_GD = idmax.getID_GD();
	  //lay list giao dich theo ID_GD
	    ArrayList<Giao_Dich> listgiaodich = giaodichBO.getListGD();
	    request.setAttribute("listgiaodich", listgiaodich);
	    //lay list giao dich theo ID_GD
	    Giao_Dich giaodich_id = giaodichBO.getByID(ID_GD);
	    request.setAttribute("giaodich_id", giaodich_id);
	  //lay list CTGD theo ID_GD
  		ArrayList<CTGD> listctgd = ctgdBO.getListCTGDGD_ID_GD(ID_GD);
  		request.setAttribute("listctgd", listctgd);
	    //lay ten shop
	    ArrayList<Shop> listshop = shopBO.getListShop();
	    request.setAttribute("listshop", listshop);
	    //lay ten nguoi lap
	    ArrayList<User> listuser = userBO.getListUser();
	    request.setAttribute("listuser", listuser);
	    //lay tien thu ho trong don hang
	    ArrayList<Don_Hang> listdonhang = donhangBO.getListDH();
	    request.setAttribute("listdonhang", listdonhang);
	    
	    //chuyen trang
	    RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/admin/listgd&ctgd.jsp");
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
