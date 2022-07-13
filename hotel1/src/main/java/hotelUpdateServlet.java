

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class hotelUpdateServlet
 */
@WebServlet("/hotelUpdate")
public class hotelUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hotelUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		hotelDTO hdto = new hotelDTO();
		
		hdto.setHotelname(request.getParameter("name"));
		hdto.setHoteltype(Integer.parseInt(request.getParameter("type")));
		hdto.setPeople(Integer.parseInt(request.getParameter("people")));
		hdto.setPrice(Integer.parseInt(request.getParameter("price")));
		hdto.setHotel_num(Integer.parseInt(request.getParameter("hotel_num")));
		hotelDAO dao = new hotelDAO();
		dao.update(hdto);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
