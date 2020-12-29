package sec02.ex01;

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
	private DataSource datafactory;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envCtx = (Context)ctx.lookup("java:/comp/env");
			datafactory = (DataSource)envCtx.lookup("jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean overlappedId(String id) {
		boolean result = false;
		try {
			con = datafactory.getConnection();
			String SQL = "SELECT DECODE(COUNT(*), 1, 'true', 'false') as result from t_member where id=?";
			System.out.println("prepared statement: " + SQL);
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, id);
			
			ResultSet rs= pstmt.executeQuery();
			rs.next();
			result = Boolean.parseBoolean(rs.getString("result"));
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
