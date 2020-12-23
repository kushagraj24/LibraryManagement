package com.kushagra.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login2.0")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* SETTING TYPE HTML */
		response.setContentType("text/html");

		/* CREATING PRINTWRITER OBJECT FOR PRINTING */
		PrintWriter out = response.getWriter();

		/* GETTING PARAMETER FROM JSP FILE */
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		if (userName.equals("admin") && password.equals("password")) {
			out.println("<html>");
			out.println("<body>");
			out.println("<h4 style='color:green'>You are successfully logged in</h4>");
			out.println("<h3 style='color:green'>Welcome " + userName + "</h3>");
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);
			request.getRequestDispatcher("books.jsp").forward(request, response);
		} else {
			out.println("<h3 style='color:red'>Sorry User name or password error</h3>");

		}
		out.println("</body>");
		out.println("</html>");
	}

}
