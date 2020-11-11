package com.example.board.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.board.model.BoardDAO;

public class UpHitServiceImpl implements BoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String bno = request.getParameter("bno");
		
		Cookie[] arr = request.getCookies();
		boolean flag = true;
		if(arr != null) {
			for(Cookie c :arr ) {
				if(c.getName().equals(bno)) {
					flag = false;
					break;
				}
			}
		}
		
		if(flag) {
			BoardDAO dao = BoardDAO.getInstance();
			dao.upHit(bno);
		}

		Cookie cookie = new Cookie(bno, bno);
		cookie.setMaxAge(30);
		response.addCookie(cookie);
			
		
	}

}
