package com.kushagra.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kushagra.entity.UserDetails;
import com.kushagra.hibernateUtil.HibernateUtil;

@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* SETTING TYPE HTML */
		response.setContentType("text/html");

		/* CREATING PRINTWRITER OBJECT FOR PRINTING */
		PrintWriter out = response.getWriter();

		/* GETTING PARAMETER FROM JSP FILE */
		String name = request.getParameter("name");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String expiryDate = request.getParameter("expirydate");

		/* CREATING OBJECT OF POJO CLASS FOR SAVING DATA */
		UserDetails ud = new UserDetails();
		ud.setName(name);
		ud.setUserName(userName);
		ud.setPassword(password);
		ud.setEmail(email);

		/* PARSING DATE FROM STRING TO DATE FORMAT */
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			ud.setExpiryDate(formatter.parse(expiryDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		/* CALLING UTIL CLASS FOR SESSION SAVE */
		HibernateUtil.getSession().save(ud);
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();

		out.println("<html>");
		out.println("<body>");
		out.println("<h4 style='color:green'>One User Details Saved</h4>");
		out.println("</body>");
		out.println("</html>");
	}

}
