


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class incomeDAO {
	private Statement stmt;
	private Connection conn;
	
	public ArrayList<incomeDTO> list() {
		ArrayList<incomeDTO> list = new ArrayList<incomeDTO>();
		try {
			connDB();
			String query ="select b.income_date, b.mobile , a.name, b.qty, b.price "
					+ " from cafe a, income b "
					+ " where a.seqno=b.seqno";
			this.stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				incomeDTO mvo = new incomeDTO();
				mvo.setPrice(rs.getString("price"));
				mvo.setMobile(rs.getString("mobile"));
				mvo.setName(rs.getString("name"));
				mvo.setQty(rs.getString("qty"));
				mvo.setIncome_date(rs.getString("income_date"));
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
	
	public void addnew(incomeDTO mvo) {
		try {
			connDB();
			String query ="insert into income values(order_seq.nextval,?,?,?,?,to_char(sysdate,'YYYY-MM-DD HH24:MI:SS'))";
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setString(1, mvo.getMobile());
			System.out.println("모바일번호"+mvo.getMobile());
			
			psmt.setString(2, mvo.getSeqno());
			System.out.println("시퀀스넘버"+mvo.getSeqno());
			
			psmt.setString(3, mvo.getQty());
			System.out.println("갯수"+mvo.getQty());
			
			psmt.setString(4, mvo.getPrice());
			System.out.println("가격"+mvo.getPrice());
			
			psmt.executeUpdate();
			psmt.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public String getseq(String name) {
		incomeDTO mvo = new incomeDTO();
		String a = "";
		try {
			connDB();
			String query ="select seqno from cafe where name='"+name+"'";
			this.stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			mvo.setSeqno(rs.getString("seqno"));
			a = rs.getString("seqno");
			this.stmt.close();
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
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
