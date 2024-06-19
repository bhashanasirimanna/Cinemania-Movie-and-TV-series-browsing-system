package com.oop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop", "root", "#Induwa2001");
			String n = request.getParameter("username");
			String p = request.getParameter("password");

			if (n.contains("admin")) {
				PreparedStatement ps = con
						.prepareStatement("SELECT admin_name FROM login WHERE admin_name=? AND admin_password=?");
				ps.setString(1, n);
				ps.setString(2, p);

				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					RequestDispatcher rd = request.getRequestDispatcher("AdminPanel.jsp");
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/NotFound.jsp");
					rd.forward(request, response);
				}

			} else {
				PreparedStatement ps = con
						.prepareStatement("SELECT userName FROM user WHERE userName=? AND password=?");
				ps.setString(1, n);
				ps.setString(2, p);

				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/NotFound.jsp");
					rd.forward(request, response);
				}

			}

		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
