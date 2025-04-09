package com.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String contact = request.getParameter("contact");

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MySQL
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/UsersLoginDB", "root", "password");

            // Insert data into usersinfo table
            String sql = "INSERT INTO UsersLoginInfo (name, email, password, age, gender, contact) VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.setString(4, age);
            pstmt.setString(5, gender);
            pstmt.setString(6, contact);

            int rows = pstmt.executeUpdate();

            // Output confirmation
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            if (rows > 0) {
                response.sendRedirect("success.jsp");
            } else {
                out.println("<h3>Error while saving data!</h3>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
					pstmt.close();
				}
                if (conn != null) {
					conn.close();
				}
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
