import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class menuDAO {
	private Statement stmt;
	private Connection conn;
	
	public ArrayList<menuDTO> listMember() {
		ArrayList<menuDTO> list = new ArrayList<menuDTO>();
		try {
			connDB();
			String query ="select * from cafe";
			this.stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				menuDTO mvo = new menuDTO();
				mvo.setName(rs.getString("name"));
				mvo.setPrice(rs.getString("price"));
				mvo.setSeqno(rs.getString("seqno"));
				list.add(mvo);
			}
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
//	public boolean exist(String userid,String passwd) {
//		boolean result=false;
//		try {
//			connDB();
//			String query ="select * from cafe where id='"+userid+"'and pwd='"+passwd+"'";
//			this.stmt=conn.createStatement();
//			ResultSet rs = stmt.executeQuery(query);
//			int n=0;
//			while(rs.next()) {
//				n++;
//			}
//			if(n==1) {
//				result=true;
//			}else {
//				result=false;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
	
	public void update(menuDTO mvo) {
		try {
			connDB();
			String query ="update cafe set name=?,price=? where name=?";
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setString(1, mvo.getNewname());
			psmt.setString(2, mvo.getPrice());
			psmt.setString(3, mvo.getName());
			psmt.executeUpdate();
			psmt.close();
			conn.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public MemberVO getMember(String id) {
//		MemberVO mvo = new MemberVO();
//		try {
//			connDB();
//			String query ="select * from t_member where id='"+id+"'";
//			this.stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery(query);
//			rs.next();
//			mvo.setId(rs.getString("id"));
//			mvo.setName(rs.getString("name"));
//			mvo.setPwd(rs.getString("pwd"));
//			mvo.setMobile(rs.getString("mobile"));
//			mvo.setJoinDate(rs.getString("joindate"));
//			this.stmt.close();
//			rs.close();
//			conn.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return mvo;
//	}
	
	public void delete(String name) {
		try {
			connDB();
			String query ="delete from cafe where name=?";
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setString(1,name);
			psmt.executeUpdate();
			psmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addnew(menuDTO mvo) {
		try {
			connDB();
			String query ="insert into cafe values(sq.nextval,?,?)";
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setString(1, mvo.getName());
			psmt.setString(2, mvo.getPrice());
			psmt.executeUpdate();
			psmt.close();
			conn.close();
		} 
		catch (Exception e) {
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
