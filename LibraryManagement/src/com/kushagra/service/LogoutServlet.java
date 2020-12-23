package com.kushagra.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout2")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//request.getRequestDispatcher("index.jsp").include(request, response);
		HttpSession session = request.getSession(false);
		String name = (String) session.getAttribute("userName");
		if (session != null && name !=null) {
			session.invalidate();
			out.println("<html>");
			out.println("<body>");
			out.println("<h4 style='color:green'>You are successfully logged out</h4>");
			out.println("</body>");
			out.println("</html>");
		} else {
			out.println("<h3 style='color:red'>Please login first</h3>");
		}
		/*session.invalidate();
		out.println("<html>");
		out.println("<body>");
		out.println("<h4 style='color:green'>You are successfully logged out</h4>");
		out.println("</body>");
		out.println("</html>");*/
	}

}
