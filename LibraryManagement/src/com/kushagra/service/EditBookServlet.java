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

@WebServlet("/editBook")
public class EditBookServlet extends HttpServlet {
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
		String title = request.getParameter("title");
		String year = request.getParameter("bookyear");
		String isbnNo = request.getParameter("isbnno");
		String availableBook = request.getParameter("bookavailable");
		String authorName = request.getParameter("authorname");
		String publisherName = request.getParameter("publishername");

		/* LOADING BOOK DETAILS FOR EDITING */
		BookDetails bd = (BookDetails) HibernateUtil.getSession().load(BookDetails.class, userId);
		if (title != null) {
			bd.setBookTitle(title);
		}
		if (year != null) {
			bd.setBookYear(Integer.parseInt(year));
		}
		if (isbnNo != null) {
			bd.setBookIsbnNo(Integer.parseInt(isbnNo));
		}
		if (availableBook != null) {
			bd.setBookAvailable(Integer.parseInt(availableBook));
		}
		if (authorName != null) {
			bd.setAuthorName(authorName);
		}
		if (publisherName != null) {
			bd.setPublisherName(publisherName);
		}

		/* CALLING UTIL CLASS FOR PERFORMING OPERATIONS */
		HibernateUtil.getSession().persist(bd);
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
