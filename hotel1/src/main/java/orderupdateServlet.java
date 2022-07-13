

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class orderupdateServlet
 */
@WebServlet("/orderupdate")
public class orderupdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderupdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		orderDTO odto = new orderDTO();
		
		odto.setBpeople(Integer.parseInt(request.getParameter("bpeople")));
		odto.setCheckin(request.getParameter("checkin"));
		odto.setCheckout(request.getParameter("checkout"));
		odto.setLeader(request.getParameter("leader"));
		odto.setMobile(Integer.parseInt(request.getParameter("mobile")));
		odto.setPrice(Integer.parseInt(request.getParameter("bprice")));
		odto.setPreorder(Integer.parseInt(request.getParameter("preorder")));
		orderDAO dao = new orderDAO();
		dao.update(odto);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
