package com.example.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.user.model.UserDAO;
import com.example.user.model.UserVO;

public class UserDeleteServiceImpl implements UserService{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		UserVO vo = (UserVO) session.getAttribute("user");
		
		UserDAO dao = UserDAO.getInstance();
		int result = dao.delete(vo.getId());
		
		if(result == 1) session.invalidate();
		
		return result;
	}

	
	
}
