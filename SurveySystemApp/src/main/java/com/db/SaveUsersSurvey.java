package com.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SaveUsersSurvey extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("questions") == null) {
            response.sendRedirect("error.jsp");
            return;
        }

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> questions = (List<Map<String, Object>>) session.getAttribute("questions");

        List<String> userAnswers = new ArrayList<>();

        for (int i = 0; i < questions.size(); i++) {
            String answer = request.getParameter("q" + i);
            if (answer == null || answer.isEmpty()) {
                response.sendRedirect("TakeSurvey.jsp?error=Please answer all questions.");
                return;
            }
            userAnswers.add(answer);
        }

        // Get user info from session
        String name = (String) session.getAttribute("name");
        String email = (String) session.getAttribute("email");

        // Save answers to DB
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String jdbcURL = "jdbc:mysql://localhost:3306/UsersSurveyDB";
            String dbUser = "root";
            String dbPassword = "password";

            Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

            // Create a new table if you want or use existing
            String sql = "INSERT INTO UsersSurveyInfo (name, email, question, selected_option) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            for (int i = 0; i < questions.size(); i++) {
                Map<String, Object> q = questions.get(i);
                String question = (String) q.get("question");
                String selectedOption = request.getParameter("q" + i);

                pstmt.setString(1, name);
                pstmt.setString(2, email);
                pstmt.setString(3, question);
                pstmt.setString(4, selectedOption);
                pstmt.addBatch();
            }

            pstmt.executeBatch();
            pstmt.close();
            conn.close();

            session.setAttribute("userAnswers", userAnswers); // Optional: for thank you page
            response.sendRedirect("Thankyou.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error saving responses to database.");
        }
    }
}
