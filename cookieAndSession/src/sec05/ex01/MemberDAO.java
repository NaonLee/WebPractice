package sec05.ex01;

import java.sql.Connection;
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
	private static Connection con;
	private static PreparedStatement pstmt;
	private static DataSource dataFactory;
	
	public MemberDAO() {
		Context ctx;
		try {
			ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isExisted(MemberVO memberVO) {
		boolean result = false;
		
		try {
			con = dataFactory.getConnection();
			String query = "SELECT DECODE(count(*), 1, 'true', 'false') AS result FROM t_member WHERE id = ? and pwd = ?";
			System.out.println("id:" + memberVO.getId() + " pwd: " + memberVO.getPwd());
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPwd());
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			System.out.println(rs.getString("result"));
			
			result = Boolean.parseBoolean(rs.getString("result"));
			System.out.println("result = " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return result;
	}
	
	public List<MemberVO> listMembers(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			con = dataFactory.getConnection();
			String query = "SELECT * FROM t_member";
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO  vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setJoinDate(rs.getDate("joinDate"));
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void addMember(MemberVO memberVO) {
		try {
			con = dataFactory.getConnection();
			String query = "INSERT INTO t_member VALUES (?, ?, ?, ?, sysDate)";
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPwd());
			pstmt.setString(3, memberVO.getName());
			pstmt.setString(4, memberVO.getEmail());
			
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteMember(String id) {
		try {
			con = dataFactory.getConnection();
			String query = "DELETE FROM t_member WHERE id = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


}