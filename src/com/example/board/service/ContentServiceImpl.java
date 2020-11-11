package com.example.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.board.model.BoardDAO;
import com.example.board.model.BoardVO;

public class ContentServiceImpl implements BoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String bno = request.getParameter("bno");
		
		System.out.println(bno);
	
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = dao.getContent(bno);
			
		request.setAttribute("vo", vo);
	}
}
