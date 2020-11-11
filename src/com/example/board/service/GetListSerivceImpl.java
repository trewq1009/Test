package com.example.board.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.board.model.BoardDAO;
import com.example.board.model.BoardVO;
import com.example.util.PageVO;

public class GetListSerivceImpl implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		BoardDAO dao = BoardDAO.getInstance();		
		//ArrayList<BoardVO> list = dao.getList();
		
		int pageNum = 1; 
		int amount = 10;
		
		if(request.getParameter("pageNum") != null || request.getParameter("amount") != null) {
			pageNum = Integer.parseInt( request.getParameter("pageNum") );
			amount = Integer.parseInt( request.getParameter("amount") );
		}
		
		ArrayList<BoardVO> list = dao.getList(pageNum, amount);
		int total = dao.getTotal();
		PageVO pageVO = new PageVO(pageNum, amount, total);
		
		request.setAttribute("list", list);
		request.setAttribute("pageVO", pageVO);
	}

}
