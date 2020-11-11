package com.example.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.example.util.JdbcUtil;

public class BoardDAO {
	private static BoardDAO instance = new BoardDAO();

	private BoardDAO() {
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			System.out.println("드라이버 호출 에러");
		}
	}
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	private DataSource ds;
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public void register(String writer, String title, String content) {
		String sql = "insert into board_post(bno, writer, title, content) values(board_seq.nextval, ?, ?, ?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
	}
	
	public ArrayList<BoardVO> getPrivateList(String id) {
		ArrayList<BoardVO> list = new ArrayList<>();

		//String sql = "select * from board_post where writer=? order by bno desc";
		String sql = "select id, b.* from USERS u join BOARD_POST b on WRITER = id where id = ?";

		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int bno = rs.getInt("bno");
				String title = rs.getString("title");
				Timestamp regdate = rs.getTimestamp("regdate");
				int hit = rs.getInt("hit");
				
				BoardVO vo = new BoardVO(bno, null, title, null, regdate, hit);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public ArrayList<BoardVO> getList(int pageNum, int amount) {
		ArrayList<BoardVO> list = new ArrayList<>();
		
		String sql = "select *\r\n" + 
					"from(select rownum rn,\r\n" + 
					"            bno,\r\n" + 
					"            writer,\r\n" + 
					"            title,\r\n" + 
					"            content,\r\n" + 
					"            regdate,\r\n" + 
					"            hit\r\n" + 
					"     from (select *\r\n" + 
					"           from board_post\r\n" + 
					"           order by bno desc)\r\n" + 
					") where rn > ? and rn <= ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNum - 1) * amount  ); //(페이지번호 -1) * 데이터개수
			pstmt.setInt(2, pageNum * amount );
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				int bno = rs.getInt("bno");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp regdate = rs.getTimestamp("regdate");
				int hit = rs.getInt("hit");
				
				BoardVO vo = new BoardVO(bno, writer, title, content, regdate, hit);//한 행을 vo에 저장
				list.add(vo); //리스트에 추가
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
				
		
		return list;
	}
	
	//전체 게시글 수
	public int getTotal() {
		int total = 0;
		
		String sql = "select count(*) as total from board_post";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt("total");
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return total;
	}
	

	//상세보기
	public BoardVO getWriter(String bno) {
		BoardVO vo = new BoardVO();
		
		String sql = "select writer from board_post where bno = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) vo.setWriter( rs.getString("writer") );
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return vo;
	}
	
	//상세보기
	public BoardVO getContent(String bno) {
		BoardVO vo = new BoardVO();
		
		String sql = "select * from board_post where bno = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);//pstmt.setInt(1, Integer.parseInt(bno) );
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setBno( rs.getInt("bno") );
				vo.setWriter( rs.getString("writer") );
				vo.setTitle( rs.getString("title") );
				vo.setContent( rs.getString("content") );
				vo.setRegdate( rs.getTimestamp("regdate")  );
				vo.setHit( rs.getInt("hit") );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return vo;
	}
	
	//글 업데이트 메서드
	public void update(String bno, String title, String content) {
		
		String sql = "update board_post set title = ?, content = ? where bno = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title );
			pstmt.setString(2, content);
			pstmt.setString(3, bno);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}

	}
	
	//글 삭제 메서드
	public void delete(String bno) {
		
		String sql = "delete from board_post where bno = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
	}
	
	//조회수 업데이트 메서드
	public void upHit(String bno) {
		
		String sql = "update board_post set hit = hit + 1 where bno = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);			
		}
		
	}
	
	
	
}




