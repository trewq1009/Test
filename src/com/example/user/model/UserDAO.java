package com.example.user.model;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.swing.JButton;

import com.example.util.JdbcUtil;

public class UserDAO {

	private static UserDAO instance = new UserDAO();
	
	private UserDAO() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
			
		} catch (Exception e) {
			System.out.println("드라이버 호출 에러");
		}
	}
	
	public static UserDAO getInstance() {
		return instance;
	}
	
	private String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	private String uid = "hr";
	private String upw = "hr";
	
	private DataSource ds;
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public int join(UserVO vo) {
		
		int result = 0;
		String sql = "insert into users(id, pw, name, email, email_provider, phone_first, phone_second, phone_third, address, address_detail) values(?,?,?,?,?,?,?,?,?,?)";
		
		try {
			conn = ds.getConnection(); 
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getEmailProvider());
			pstmt.setString(6, vo.getPhoneFirst());
			pstmt.setString(7, vo.getPhoneSecond());
			pstmt.setString(8, vo.getPhoneThird());
			pstmt.setString(9, vo.getAddress());
			pstmt.setString(10, vo.getAddressDetail());

			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			JdbcUtil.close(conn, pstmt, null);
		}

		return result;
	}
	
	public int checkId(String id) {
		int result = 0;
		
		String sql = "select * from users where id = ?";
		
		try {
			conn = ds.getConnection(); 
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if(rs.next()) result = 1;
			else result = 0;
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return result;
	}
	
	public UserVO login(String id, String pw) {
		
		UserVO vo = null;
		String sql = "select * from users where id = ? and pw = ?";
		
		try {
			conn = ds.getConnection(); 
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id );
			pstmt.setString(2, pw );
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new UserVO();
				vo.setId( rs.getString("id")  );
				vo.setName( rs.getString("name") );
				vo.setEmail( rs.getString("email") );
				vo.setEmailProvider( rs.getString("email_provider") );
				vo.setPhoneFirst( rs.getString("phone_first") );
				vo.setPhoneSecond( rs.getString("phone_second") );
				vo.setPhoneThird( rs.getString("phone_third") );
				vo.setAddress( rs.getString("address") );
				vo.setAddressDetail( rs.getString("address_detail") );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return vo;
	}
	
	public int update(UserVO vo) {
		int result = 0;
		
		String sql = "update users set pw = ?, name = ?, email = ?, email_provider = ?, phone_first = ?, phone_second = ?, phone_third = ?, address = ?, address_detail = ? where id = ?";
				
		try {
			
			conn = ds.getConnection(); 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1 , vo.getPw());
			pstmt.setString(2 , vo.getName());
			pstmt.setString(3 , vo.getEmail());
			pstmt.setString(4 , vo.getEmailProvider());
			pstmt.setString(5 , vo.getPhoneFirst());
			pstmt.setString(6 , vo.getPhoneSecond());
			pstmt.setString(7 , vo.getPhoneThird());
			pstmt.setString(8 , vo.getAddress());
			pstmt.setString(9 , vo.getAddressDetail());
			pstmt.setString(10 , vo.getId());

			result = pstmt.executeUpdate();
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return result;
	}

	public int delete(String id) {
		int result = 0;
		
		String sql = "delete from users where id = ?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
				
		return result;
	}
}

