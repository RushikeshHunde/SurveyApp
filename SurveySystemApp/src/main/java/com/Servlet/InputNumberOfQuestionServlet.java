package com.Servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class InputNumberOfQuestion
 */
@WebServlet("/InputNumberOfQuestionServlet")
public class InputNumberOfQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  int num = Integer.parseInt(request.getParameter("num"));
	        HttpSession session = request.getSession();
	        session.setAttribute("num", num);
	        response.sendRedirect("InputQuestions.jsp");
	    }
	}