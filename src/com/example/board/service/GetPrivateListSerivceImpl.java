package com.example.board.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.board.model.BoardDAO;
import com.example.board.model.BoardVO;
import com.example.user.model.UserVO;

public class GetPrivateListSerivceImpl implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		UserVO vo = (UserVO) session.getAttribute("user");
		String id = vo.getId();
		
		BoardDAO dao = BoardDAO.getInstance();		
		ArrayList<BoardVO> list = dao.getPrivateList(id);
		request.setAttribute("myList", list);
	}

}
