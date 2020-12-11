package sec02.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class MemberDAO {
/*	will use connection pool
 * 
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private static final String user = "naon";
	private static final String pwd = "password01";
	*/
	private static Connection con;
	private static PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public MemberDAO() {			//constructor
		try {
			Context ctx = new InitialContext();		
			Context envContext = (Context) ctx.lookup("java:/comp/env");	//JNDI에 접근하기 위해 기본 경로 지정
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");	//context.xml 의 name에 접근, 톰캣이 연결한 DataSource 받아옴
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> listMember(){
		List<MemberVO> list = new ArrayList<MemberVO>();
				
		try {
			//connDB();
			con = dataFactory.getConnection();
			pstmt = con.prepareStatement("select * from t_member");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	/*
	 * // private void connDB() { // try { // Class.forName(driver); //
	 * System.out.println("Oracle driver loading."); // con =
	 * DriverManager.getConnection(url, user, pwd); //
	 * System.out.println("Created connection"); // }catch(Exception e) { //
	 * e.printStackTrace(); // } // }
	 */
	}
