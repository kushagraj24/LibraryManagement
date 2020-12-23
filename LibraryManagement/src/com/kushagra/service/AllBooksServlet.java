package com.kushagra.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;

import com.kushagra.entity.BookDetails;
import com.kushagra.hibernateUtil.HibernateUtil;

@WebServlet("/getAllBooks")
public class AllBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* SETTING TYPE HTML */
		response.setContentType("text/html");

		/* CREATING PRINTWRITER OBJECT FOR PRINTING */
		PrintWriter out = response.getWriter();

		Criteria cri = HibernateUtil.getCriteria();
		cri = HibernateUtil.getSession().createCriteria(BookDetails.class);

		List<?> list = cri.list();
		Iterator<?> itr = list.iterator();
		out.println("<html>");
		out.println("<head>\r\n" + 
				"  <title>Book List</title>\r\n" + 
				"  <meta charset=\"utf-8\">\r\n" + 
				"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n" + 
				"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n" + 
				"  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n" + 
				"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n" + 
				"</head>");
		out.println("<body>");
		out.println("<div class=\"container\">            \r\n" + 
				"  <table class=\"table\">\r\n" + 
				"    <thead>\r\n" + 
				"      <tr>\r\n" + 
				"        <th>Tile</th>\r\n" + 
				"        <th>Year</th>\r\n" + 
				"        <th>Isbn</th>\r\n" + 
				"        <th>Author Name</th>\r\n" + 
				"        <th>Publisher Name</th>\r\n" + 
				"        <th>Available</th>\r\n" + 
				"      </tr>\r\n" + 
				"    </thead>"
				+ "<tbody>");
		while (itr.hasNext()) {
			BookDetails bd = (BookDetails) itr.next();
			out.println("<tr>");
			out.println("<td>"+bd.getBookTitle()+"</td>");
			out.println("<td>"+bd.getBookYear()+"</td>");
			out.println("<td>"+bd.getBookIsbnNo()+"</td>");
			out.println("<td>"+bd.getAuthorName()+"</td>");
			out.println("<td>"+bd.getPublisherName()+"</td>");
			out.println("<td>"+bd.getBookAvailable()+"</td>");
				
		out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("</table>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
		
	}

}
