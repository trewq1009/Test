package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.board.service.BoardService;
import com.example.board.service.GetPrivateListSerivceImpl;
import com.example.user.service.UserDeleteServiceImpl;
import com.example.user.service.UserJoinServiceImpl;
import com.example.user.service.UserLoginServiceImpl;
import com.example.user.service.UserService;
import com.example.user.service.UserUpdateServiceImpl;

@WebServlet("*.user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dispatchServlet(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dispatchServlet(request, response);
	}

	protected void dispatchServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring( conPath.length() );
		
		UserService service;
		BoardService boardService;
		int result;

		  switch(command) { 
		  
		  case "/join.user":
			  request.getRequestDispatcher("user_join.jsp").forward(request, response);
			  break;
		  
		  case "/login.user":
			  request.getRequestDispatcher("user_login.jsp").forward(request, response);
			  break;
		  
		  case "/mypage.user":
			  boardService = new GetPrivateListSerivceImpl();
			  boardService.execute(request, response);
			  request.getRequestDispatcher("user_mypage.jsp").forward(request, response);
			  break;

		  case "/update.user":
			  request.getRequestDispatcher("user_mypageinfo.jsp").forward(request, response);
			  break;
		  
		  case "/delete.user":
			  new UserDeleteServiceImpl().execute(request, response);
			  break;
		  
		  case "/logout.user":
			  HttpSession session = request.getSession();
			  session.invalidate();
			  response.sendRedirect( request.getContextPath() );
			  break; 

		  case "/loginForm.user":
				service = new UserLoginServiceImpl();
				result = service.execute(request, response);

				if(result == 1) response.sendRedirect("mypage.user");
				else {
					request.setAttribute("msg", "아이디 비밀번호를 확인하세요");
					request.getRequestDispatcher("user_login.jsp").forward(request, response);
				}
			  break; 
			  
		  case "/joinForm.user":
				service = new UserJoinServiceImpl();
				result = service.execute(request, response);

				if(result == 1) {
					request.setAttribute("msg", "이미존재하는 회원입니다");
					request.getRequestDispatcher("user_join.jsp").forward(request, response);

				} else response.sendRedirect("login.user");
				
			  break; 
			  
		  case "/updateForm.user":
				service = new UserUpdateServiceImpl();
				result = service.execute(request, response);

				if(result == 1) {
					response.setContentType("text/html; charset=UTF-8");
					
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('회원정보 수정이 정상 처리되었습니다'); ");
					out.println("location.href='mypage.user'; ");
					out.println("</script>");
					
				} else response.sendRedirect("mypage.user");
				
			  break; 
		  }
	}
		
}
