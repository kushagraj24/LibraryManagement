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

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* SETTING TYPE HTML */
		response.setContentType("text/html");

		/* CREATING PRINTWRITER OBJECT FOR PRINTING */
		PrintWriter out = response.getWriter();

		/* GETTING PARAMETER FROM JSP FILE */
		String title = request.getParameter("booktitle");
		String year = request.getParameter("bookyear");
		String isbnNo = request.getParameter("isbnno");
		String availableBook = request.getParameter("bookavailable");
		String authorName = request.getParameter("authorname");
		String publisherName = request.getParameter("publishername");

		/* CREATING OBJECT OF POJO CLASS FOR SAVING DATA */
		BookDetails bd = new BookDetails();
		bd.setBookTitle(title);
		bd.setBookYear(Integer.parseInt(year));
		bd.setBookIsbnNo(Integer.parseInt(isbnNo));
		bd.setBookAvailable(Integer.parseInt(availableBook));
		bd.setAuthorName(authorName);
		bd.setPublisherName(publisherName);

		/* CALLING UTIL CLASS FOR SESSION SAVE */
		HibernateUtil.getSession().save(bd);
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();

		out.println("<html>");
		out.println("<body>");
		out.println("<h4 style='color:green'>One Book Details Saved</h4>");
		out.println("</body>");
		out.println("</html>");

	}

}
