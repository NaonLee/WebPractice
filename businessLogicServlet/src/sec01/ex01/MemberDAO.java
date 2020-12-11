package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private static final String user = "naon";
	private static final String pwd = "password01";
	
	private static Statement stmt;
	private static Connection con;
	
	public List<MemberVO> listMember(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
				connDB();
				String query = "select * from t_member";
				System.out.println(query);
				ResultSet rs = stmt.executeQuery(query);
				
				while(rs.next()) {
					String id = rs.getString("id");
					String pwd = rs.getString("pwd");
					String name = rs.getString("name");
					String email = rs.getString("email");
					Date joinDate = rs.getDate("joinDate");
					
					MemberVO vo = new MemberVO();
					vo.setId(id);
					vo.setPwd(pwd);
					vo.setEmail(email);
					vo.setName(name);
					vo.setJoinDate(joinDate);
					list.add(vo);
				}
				rs.close();
				stmt.close();
				con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	private void connDB() {
		try {
				Class.forName(driver);
				System.out.println("Oracle driver loaded.");
				con = DriverManager.getConnection(url, user, pwd);
				System.out.println("Created connection.");
				stmt = con.createStatement();
				System.out.println("Created statement.");
				
		}catch(Exception e) {
				e.printStackTrace();
		}
	}
}
