package com.kushagra.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kushagra.entity.UserDetails;
import com.kushagra.hibernateUtil.HibernateUtil;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* SETTING TYPE HTML */
		response.setContentType("text/html");

		/* CREATING PRINTWRITER OBJECT FOR PRINTING */
		PrintWriter out = response.getWriter();

		/* GETTING PARAMETER FROM JSP FILE */
		String userid = request.getParameter("userid");
		int userId = Integer.parseInt(userid);

		/* DELETEING USER BY ID */
		UserDetails ud = (UserDetails) HibernateUtil.getSession().load(UserDetails.class, userId);
		HibernateUtil.getSession().delete(ud);
		HibernateUtil.getTransaction(HibernateUtil.getSession()).commit();
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();

		out.println("<html>");
		out.println("<body>");
		out.println("<h4 style='color:green'>One User Deleted</h4>");
		out.println("</body>");
		out.println("</html>");

	}

}
