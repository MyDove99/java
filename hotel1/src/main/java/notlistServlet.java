

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class notlistServlet
 */
@WebServlet("/notlist")
public class notlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public notlistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		orderDAO dao = new orderDAO();
		JSONArray ja = new JSONArray();		
		
		orderDTO odto = new orderDTO();
		odto.setHoteltype(Integer.parseInt(request.getParameter("hoteltype")));
		odto.setCheckin(request.getParameter("checkin"));
		odto.setCheckout(request.getParameter("checkout"));
		
		ArrayList<orderDTO> list = dao.notlist(odto);
		for(int i=0; i<list.size(); i++) {
			orderDTO data = new orderDTO();
			data=list.get(i);
			
			JSONObject jo = new JSONObject();
			
			jo.put("hotel_num",data.getHotel_num());
			jo.put("hotelname", data.getHotelname());
			jo.put("roomname", data.getRoomname());
			jo.put("people", data.getPeople());
			jo.put("price", data.getPrice());
			ja.add(jo);
		}
		response.getWriter().print(ja.toJSONString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
