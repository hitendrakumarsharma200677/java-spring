package com.robert.book;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Books
 */
@WebServlet("/Books")
public class Books extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Books() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		PrintWriter out = response.getWriter();
		try {
			int cur_page = 1;
			if(request.getParameter("cur_page") != null) {
				cur_page = Integer.valueOf(request.getParameter("cur_page"));
			}
			if(cur_page<=0  ) {
				cur_page = 1;
			}
			BookDao bookDao = new BookDao();
			List<Map<String, Object>> list = bookDao.getList(cur_page);
			request.setAttribute("list", list);
			request.setAttribute("cur_page", cur_page);
		    request.getRequestDispatcher("/book/book.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
