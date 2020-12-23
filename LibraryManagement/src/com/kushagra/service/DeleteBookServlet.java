package com.kushagra.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kushagra.entity.BookDetails;
import com.kushagra.hibernateUtil.HibernateUtil;

@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* SETTING TYPE HTML */
		response.setContentType("text/html");

		/* CREATING PRINTWRITER OBJECT FOR PRINTING */
		PrintWriter out = response.getWriter();

		/* GETTING PARAMETER FROM JSP FILE */
		String userid = request.getParameter("bookid");
		int userId = Integer.parseInt(userid);

		/* DELETEING USER BY ID */
		BookDetails bd = (BookDetails) HibernateUtil.getSession().load(BookDetails.class, userId);
		HibernateUtil.getSession().delete(bd);
		HibernateUtil.getTransaction(HibernateUtil.getSession()).commit();
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();

		out.println("<html>");
		out.println("<body>");
		out.println("<h4 style='color:green'>One Book Detail Deleted</h4>");
		out.println("</body>");
		out.println("</html>");

	}

}
