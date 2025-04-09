package com.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class InputQuestionsServlet
 */

public class InputQuestionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int num = (Integer) request.getSession().getAttribute("num");
	        List<Map<String, Object>> questions = new ArrayList<>();

	        for (int i = 1; i <= num; i++) {
	            Map<String, Object> q = new HashMap<>();
	            q.put("question", request.getParameter("q" + i));
	            q.put("options", new String[] {
	                request.getParameter("q" + i + "o1"),
	                request.getParameter("q" + i + "o2"),
	                request.getParameter("q" + i + "o3"),
	                request.getParameter("q" + i + "o4")
	            });
	            questions.add(q);
	        }

	        HttpSession session = request.getSession();
	        session.setAttribute("questions", questions);
	        session.setAttribute("currentIndex", 0);
	        response.sendRedirect("TakeSurvey.jsp");
	    }
	}
