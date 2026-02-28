package com.quiz;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        int score = Integer.parseInt(req.getParameter("score"));

        res.setContentType("text/html");
        res.getWriter().println("<!DOCTYPE html>");
        res.getWriter().println("<html>");
        res.getWriter().println("<head>");
        res.getWriter().println("<title>Quiz Result</title>");
        res.getWriter().println("<link rel='stylesheet' href='style.css'>");
        res.getWriter().println("</head>");
        res.getWriter().println("<body>");
        res.getWriter().println("<div class='result-container'>");
        res.getWriter().println("<h2>Quiz Result</h2>");
        res.getWriter().println("<p>Your Score: <b>" + score + " / 50</b></p>");
        res.getWriter().println("<div class='btn-container'>");
        res.getWriter().println("<a href='start.jsp' class='btn'>Exit</a>");
        res.getWriter().println("<a href='quiz.jsp' class='btn replay'>Replay</a>");
        res.getWriter().println("</div>");
        res.getWriter().println("</div>");
        res.getWriter().println("<footer class=\"footer\">\r\n"
        		+ "    <p>&copy; 2025 Online Quiz System. Made with Love by - Mohammad Faraz</p>");
        res.getWriter().println("</footer>");
        res.getWriter().println("</body>");
        res.getWriter().println("</html>");
    }
}
