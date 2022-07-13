import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class orderDAO {
	private Statement stmt;
	private Connection conn;
	
	public ArrayList<orderDTO> orderlist(orderDTO odto) {
		ArrayList<orderDTO> list = new ArrayList<orderDTO>();
		try {
			connDB();
			String query ="select * from booking a, hotel b, room c where "+
						  "a.hotel_num=b.hotel_num and b.hoteltype = c.typenum and a.hoteltype=? and "+
						  "((a.checkin between ? and "+
						  "? or a.checkout between "+
						  "? and ?)or (a.checkin <= ? and a.checkout >= ?))";
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setInt(1, odto.getHoteltype());
	
			psmt.setString(2, odto.getCheckin());
			psmt.setString(3, odto.getCheckout());
			psmt.setString(4, odto.getCheckin());
			psmt.setString(5, odto.getCheckout());
			psmt.setString(6, odto.getCheckin());
			psmt.setString(7, odto.getCheckout());
			
			psmt.executeUpdate();
			ResultSet rs = psmt.executeQuery(query);
			while (rs.next()) {
				orderDTO odto1 = new orderDTO();
				odto1.setPreorder(rs.getInt("preorder"));
				odto1.setHotel_num(rs.getInt("hotel_num"));
				odto1.setRoomname(rs.getString("hotel_type"));
				odto1.setBpeople(rs.getInt("bpeople"));
				odto1.setCheckin(rs.getString("checkin"));
				odto1.setCheckout(rs.getString("checkout"));
				odto1.setLeader(rs.getString("leader"));
				odto1.setMobile(rs.getInt("mobile"));
				odto1.setPrice(rs.getInt("price"));
				odto1.setHotelname(rs.getString("hotelname"));
				odto1.setPeople(rs.getInt("people"));
				list.add(odto1);
			}
			rs.close(); 
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return list; 
	}
	
	public ArrayList<orderDTO> notlist(orderDTO odto) {
		ArrayList<orderDTO> list = new ArrayList<orderDTO>();
		try {
			connDB();
			String query ="select * from hotel a , room b where a.hoteltype=b.typenum and a.hoteltype=? and a.hotel_num not in "+
						  "(select hotel_num from booking where hoteltype=? and ((checkin between "+
						  "? and ? or checkout between ? and ?)or (checkin <= ? and checkout >= ?)))";
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setInt(1, odto.getHoteltype());
			psmt.setInt(2, odto.getHoteltype());
			
			psmt.setString(3, odto.getCheckin());
			psmt.setString(4, odto.getCheckout());
			psmt.setString(5, odto.getCheckin());
			psmt.setString(6, odto.getCheckout());
			psmt.setString(7, odto.getCheckin());
			psmt.setString(8, odto.getCheckout());
			
			psmt.executeUpdate();
			ResultSet rs = psmt.executeQuery(query);
			while (rs.next()) {
				orderDTO odto1 = new orderDTO();
				odto1.setHotel_num(rs.getInt("hotel_num"));
				odto1.setHotelname(rs.getString("hotelname"));
				odto1.setRoomname(rs.getString("hotel_type"));
				odto1.setPeople(rs.getInt("people"));
				odto1.setPrice(rs.getInt("price"));
				list.add(odto1);
			}
			rs.close(); 
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return list; 
	}
	
	public void orderadd(orderDTO odto) {
		try {
			connDB();
			String query ="insert into booking values(preorder.nextval,?,?,?,?,?,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(query);
			
			psmt.setInt(1, odto.getHotel_num());
			psmt.setInt(2, odto.getHoteltype());
			psmt.setInt(3, odto.getBpeople());
			psmt.setString(4, odto.getCheckin());
			psmt.setString(5, odto.getCheckout());
			psmt.setString(6, odto.getLeader());
			psmt.setInt(7, odto.getMobile());
			psmt.setInt(8, odto.getBprice());
			
			psmt.executeUpdate();
			psmt.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void delete(int preorder) {
		try {
			connDB();
			String query ="delete from booking where preorder=?";
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setInt(1,preorder);
			psmt.executeUpdate();
			psmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(orderDTO odto) {
		try {
			connDB();
			String query ="update booking set bpeople=? ,checkin=?, checkout=?, leader=? , mobile=?, price=? where preorder=?";
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setInt(1, odto.getBpeople());
			psmt.setString(2, odto.getCheckin());
			psmt.setString(3, odto.getCheckout());
			psmt.setString(4, odto.getLeader());
			psmt.setInt(5, odto.getMobile());
			psmt.setInt(6, odto.getPrice());
			psmt.setInt(7, odto.getPreorder());
			psmt.executeUpdate();
			psmt.close();
			conn.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void connDB() {
		String driver="oracle.jdbc.driver.OracleDriver";
		String url ="jdbc:oracle:thin:@localhost:1521:orcl";
		String userid="ora_user";
		String passcode="human123";
		try {
			Class.forName(driver);
			this.conn = DriverManager.getConnection(url,userid,passcode);
			if(conn==null) {
				System.out.println("데이터 베이스 접속 실패");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}