package com.example.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.user.model.UserDAO;
import com.example.user.model.UserVO;

public class UserUpdateServiceImpl implements UserService{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		String name =request.getParameter("name");
		
		String phone_first = request.getParameter("phone_first");
		String phone_second = request.getParameter("phone_second");
		String phone_third = request.getParameter("phone_third");

		String email_first = request.getParameter("email");
		String email_provider = request.getParameter("email_provider");

		String address = request.getParameter("address");
		String address_detail = request.getParameter("address_detail");

		UserVO vo = new UserVO(id, pw, name, 
				email_first, email_provider,
				phone_first, phone_second, phone_third,
				address, address_detail, null);
		
		UserDAO dao = UserDAO.getInstance();
		int result = dao.update(vo);
		
		if(result == 1) {
			HttpSession session = request.getSession();
			vo.setPw("");
			session.setAttribute("user", vo);
		}
		
		return result;
	}

	
	
}
