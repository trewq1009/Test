package com.example.util.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.board.model.BoardDAO;
import com.example.board.model.BoardVO;
import com.example.user.model.UserVO;

@WebFilter({"/modify.board", "/update.board", "/delete.board"})
public class BoardFilter2 implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = req.getSession();
		UserVO user = (UserVO)session.getAttribute("user");
		
		if(user == null) {
			res.sendRedirect("login.user");
			return;
		}
		
		BoardVO vo = BoardDAO.getInstance().getContent(req.getParameter("bno"));
		
		String id = user.getId();
		String writer = vo.getWriter();

		if(writer == null || !id.equals(writer)) {
			
			res.setContentType("text/html; charset=UTF-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");

			out.println("alert('권한이 없습니다.');");
			out.println("location.href='list.board';");
			
			out.println("</script>");
			return;
		}
		
		chain.doFilter(request, response);
	}

}
