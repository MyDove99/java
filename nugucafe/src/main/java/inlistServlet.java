

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
 * Servlet implementation class inlistServlet
 */
@WebServlet("/inlist")
public class inlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inlistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		incomeDAO dao = new incomeDAO();
		
		ArrayList<incomeDTO> list = dao.list();
		
		JSONArray ja = new JSONArray();
		
		for(int i=0; i<list.size(); i++) {
			incomeDTO data = new incomeDTO();
			data=list.get(i);
			
			JSONObject jo = new JSONObject();
			jo.put("income_date",data.getIncome_date());
			jo.put("mobile",data.getMobile());
			jo.put("qty", data.getQty());
			jo.put("name", data.getName());
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
