import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class roomDAO {
	private Statement stmt;
	private Connection conn;
	
	public ArrayList<roomDTO> list() {
		ArrayList<roomDTO> list = new ArrayList<roomDTO>();
		try {
			connDB();
			String query ="select * from room";
			this.stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				roomDTO rdto = new roomDTO();
				rdto.setTypenum(rs.getInt("typenum"));
				rdto.setHotel_type(rs.getString("hotel_type"));
				list.add(rdto);
			}
			rs.close(); 
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return list; 
	}
	
	public void update(hotelDTO hdto) {
		try {
			connDB();
			String query ="update hotel set hotelname=? ,hoteltype=?,people=?,price=? where hotel_num=?";
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setString(1, hdto.getHotelname());
			psmt.setInt(2, hdto.getHoteltype());
			psmt.setInt(3, hdto.getPeople());
			psmt.setInt(4, hdto.getPrice());
			psmt.setInt(5, hdto.getHotel_num());
			psmt.executeUpdate();
			psmt.close();
			conn.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addnew(hotelDTO hdto) {
		try {
			connDB();
			String query ="insert into hotel values(hotel_num.nextval,?,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setString(1, hdto.getHotelname());
			psmt.setInt(2, hdto.getHoteltype());
			psmt.setInt(3, hdto.getPeople());
			psmt.setInt(4, hdto.getPrice());
			psmt.executeUpdate();
			psmt.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void delete(int hotel_num) {
		try {
			connDB();
			String query ="delete from hotel where hotel_num=?";
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setInt(1,hotel_num);
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
