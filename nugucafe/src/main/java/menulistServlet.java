

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
 * Servlet implementation class menulistServlet
 */
@WebServlet("/menulist")
public class menulistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public menulistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		menuDAO dao = new menuDAO();
		
		JSONArray ja = new JSONArray();		

		ArrayList<menuDTO> list = dao.listMember();
		for(int i=0; i<list.size(); i++) {
			menuDTO data = new menuDTO();
			data=list.get(i);
			
			JSONObject jo = new JSONObject();
			jo.put("seqno",data.getSeqno());
			jo.put("name", data.getName());
			jo.put("price", data.getPrice());
			
			System.out.println(data.getSeqno());
			System.out.println(data.getName());
			System.out.println(data.getPrice());
			ja.add(jo);
			
//			outsrt += "<option>"+data.getName()+":"+data.getPrice()+"</option>";
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
