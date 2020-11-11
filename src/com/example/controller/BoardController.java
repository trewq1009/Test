package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.board.service.BoardService;
import com.example.board.service.ContentServiceImpl;
import com.example.board.service.DeleteServiceImpl;
import com.example.board.service.GetListSerivceImpl;
import com.example.board.service.RegisterServiceImpl;
import com.example.board.service.UpHitServiceImpl;
import com.example.board.service.UpdateServiceImpl;

//1. 글 컨트롤러
@WebServlet("*.board")
public class BoardController extends HttpServlet {
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
		
		BoardService service;

		switch(command) {
		  case "/list.board":
				service = new GetListSerivceImpl();
				service.execute(request, response);
				request.getRequestDispatcher("bbs.jsp").forward(request, response);
				break;
			  
		  case "/write.board":
			  request.getRequestDispatcher("bbs_write.jsp").forward(request, response);
			  break;

		  case "/content.board":
			  service = new UpHitServiceImpl();
				service.execute(request, response);
				
				service = new ContentServiceImpl();
				service.execute(request, response);
			
			  request.getRequestDispatcher("bbs_content.jsp").forward(request, response);
			  break;

		  case "/modify.board":
			  service = new ContentServiceImpl();
			  service.execute(request, response);
			  request.getRequestDispatcher("bbs_modify.jsp").forward(request, response);
			  break;

		  case "/register.board":
			service = new RegisterServiceImpl();
			service.execute(request, response);
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('성공적으로 등록되었습니다'); ");
			out.println("location.href='list.board'; ");
			out.println("</script>");
			break;

		  case "/update.board":
			service = new UpdateServiceImpl();
			service.execute(request, response);
			response.sendRedirect("content.board?bno=" + request.getParameter("bno") );
			  break;
			  
		  case "/delete.board":
				service = new DeleteServiceImpl();
				service.execute(request, response);
				response.sendRedirect("list.board");	
			  break;
		  }
	}
}
