package com.example.user.service;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.user.model.UserDAO;
import com.example.user.model.UserVO;

public class UserLoginServiceImpl implements UserService {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("password");

		UserDAO dao = UserDAO.getInstance();
		UserVO user = dao.login(id, pw);
		
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return 1;
		}
		return 0;
		
	}

	
}
