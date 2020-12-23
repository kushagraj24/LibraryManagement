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

@WebServlet("/editUser")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* SETTING TYPE HTML */
		response.setContentType("text/html");

		/* CREATING PRINTWRITER OBJECT FOR PRINTING */
		PrintWriter out = response.getWriter();

		/* GETTING PARAMETER FROM JSP FILE */
		String userid = request.getParameter("id");
		int userId = Integer.parseInt(userid);
		String name = request.getParameter("name");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String expiryDate = request.getParameter("expirydate");

		/* LOADING USER DETAILS FOR EDITING */
		UserDetails ud = (UserDetails) HibernateUtil.getSession().load(UserDetails.class, userId);
		if (name != null) {
			ud.setName(name);
		}
		if (userName != null) {
			ud.setUserName(userName);
		}
		if (email != null) {
			ud.setEmail(email);
		}
		if (password != null) {
			ud.setPassword(password);
		}
		if (expiryDate != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			try {
				ud.setExpiryDate(formatter.parse(expiryDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		/* CALLING UTIL CLASS FOR PERFORMING OPERATIONS */
		HibernateUtil.getSession().persist(ud);
		HibernateUtil.getTransaction(HibernateUtil.getSession()).commit();
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();

		out.println("<html>");
		out.println("<body>");
		out.println("<h4 style='color:green'>One User Details Edited</h4>");
		out.println("</body>");
		out.println("</html>");

	}

}
