

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
 * Servlet implementation class hotellistServlet
 */
@WebServlet("/hotellist")
public class hotellistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hotellistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		hotelDAO dao = new hotelDAO();
		
		JSONArray ja = new JSONArray();		

		ArrayList<hotelDTO> list = dao.list();
		for(int i=0; i<list.size(); i++) {
			hotelDTO data = new hotelDTO();
			data=list.get(i);
			
			JSONObject jo = new JSONObject();
			jo.put("hotel_num",data.getHotel_num());
			jo.put("hotelname", data.getHotelname());
			jo.put("hoteltype", data.getRoomname());
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
