package com.example.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.board.model.BoardDAO;
import com.example.user.model.UserDAO;
import com.example.user.model.UserVO;

public class RegisterServiceImpl implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		UserVO vo = (UserVO) session.getAttribute("user");
		
		String writer = vo.getId();
		String title = request.getParameter("title");
		String content =request.getParameter("content");
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.register(writer, title, content);
	}
}