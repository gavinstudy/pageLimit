package com.gavin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gavin.entity.Page;
import com.gavin.service.PageService;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
		
		PageService pageService = new PageService();
		int currentPage = 1;
		int totalCount = 10;
		String value = request.getParameter("page");
		if(value!=null&&!"".equals(value)){
            currentPage += Integer.parseInt(value);
        }
		Page page  = pageService.findPage(currentPage, totalCount);
		
		request.setAttribute("page", page);
		request.getRequestDispatcher("index.jsp?page="+currentPage).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
