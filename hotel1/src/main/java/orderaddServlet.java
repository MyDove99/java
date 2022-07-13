

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class orderaddServlet
 */
@WebServlet("/orderadd")
public class orderaddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderaddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		orderDTO odto = new orderDTO();
		odto.setHotel_num(Integer.parseInt(request.getParameter("hotel_num")));
		odto.setHoteltype(Integer.parseInt(request.getParameter("type")));
		odto.setBpeople(Integer.parseInt(request.getParameter("bpeople")));
		odto.setCheckin(request.getParameter("checkin"));
		odto.setCheckout(request.getParameter("checkout"));
		odto.setLeader(request.getParameter("leader"));
		odto.setMobile(Integer.parseInt(request.getParameter("mobile")));
		odto.setBprice(Integer.parseInt(request.getParameter("bprice")));
		orderDAO dao = new orderDAO();
		dao.orderadd(odto);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
