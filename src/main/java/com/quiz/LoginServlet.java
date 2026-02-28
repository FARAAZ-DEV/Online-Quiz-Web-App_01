package com.quiz;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 protected void doPost(HttpServletRequest req, HttpServletResponse res)
         throws IOException, ServletException {

  String u = req.getParameter("username");
  String p = req.getParameter("password");

  try {
   Class.forName("com.mysql.cj.jdbc.Driver");

   Connection con = DriverManager.getConnection(
     "jdbc:mysql://localhost:3306/online_quiz?useSSL=false&serverTimezone=UTC",
     "root",
     "Faraz@MYSQL8!2025"
   );

   PreparedStatement ps =
     con.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
   ps.setString(1, u);
   ps.setString(2, p);

   ResultSet rs = ps.executeQuery();

   if (rs.next()) {
    HttpSession s = req.getSession();
    s.setAttribute("user", u);
    res.sendRedirect("quiz.jsp");
   } else {
    res.getWriter().println("Invalid Login");
   }

  }catch (Exception e) {
	    res.setContentType("text/html");
	    res.getWriter().println("<h3>ERROR OCCURRED</h3>");
	    res.getWriter().println(e.toString());
	    e.printStackTrace();
	}
 }
}
