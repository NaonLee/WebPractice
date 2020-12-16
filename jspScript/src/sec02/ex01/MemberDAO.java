package sec02.ex01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private static Connection con;
	private static PreparedStatement pstmt;
	private DataSource datafactory;
	
	public MemberDAO() {
		Context ctx;
		try {
			ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			datafactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> listMembers(){
		List list = new ArrayList();
		
		try {
			con = datafactory.getConnection();
			String SQL = "SELECT * FROM t_member";
			pstmt = con.prepareStatement(SQL);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setJoinDate(rs.getDate("joinDate"));	
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<MemberVO> searchMember(MemberVO member){
		List list = new ArrayList();
		
		try {
			con = datafactory.getConnection();
			String SQL = "SELECT * FROM t_member";
			
			if(member.getId() != null && member.getId().length() != 0) {
				SQL += " WHERE id=?";
				pstmt = con.prepareStatement(SQL);
				pstmt.setString(1, member.getId());
			} else if(member.getName() != null && member.getName().length() != 0) {
				SQL += " WHERE name=?";
				pstmt = con.prepareStatement(SQL);
				pstmt.setString(1, member.getName());
			} else {
				pstmt = con.prepareStatement(SQL);
			}
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();
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
	
	public void delMember(String id) {
		try {
			con = datafactory.getConnection();
			String SQL = "DELETE FROM t_member WHERE id = ?";
			pstmt = con.prepareStatement(SQL);
			
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void addMember(MemberVO member) {
		try {
			con = datafactory.getConnection();
			String SQL = "INSERT INTO t_member VALUES (?, ?, ?, ?, sysdate)";
			pstmt = con.prepareStatement(SQL);
			
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}