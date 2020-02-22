package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Book;
import pojo.Page;
import service.BookService;
import service.impl.BookServiceImpl;
import util.WebUtils;

public class BookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	BookService bookService = new BookServiceImpl();
	
	protected void page(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer pageNo = WebUtils.parse2Integer(request.getParameter("pageNo"), 0);
		Integer pageSize = WebUtils.parse2Integer(request.getParameter("pageSzie"), Page.PAGE_SIZE);
		Page<Book> page = bookService.page(pageNo, pageSize);
		page.setUri("manager/bookServlet?action=page");
		request.setAttribute("page", page);
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
	}
	
	protected void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer pageNo = WebUtils.parse2Integer(request.getParameter("pageNo"), 1);
		Book book = WebUtils.copy2Bean(new Book(), request.getParameterMap());
		bookService.saveBook(book);
		response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + (pageNo + 1));
		
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = WebUtils.parse2Integer(request.getParameter("id"), 0);
		Integer pageNo = WebUtils.parse2Integer(request.getParameter("pageNo"), 1);
		bookService.deleteBookById(id);
		response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Book book = WebUtils.copy2Bean(new Book(), request.getParameterMap());
		Integer pageNo = WebUtils.parse2Integer(request.getParameter("pageNo"), 1);
		bookService.updateBook(book);
		response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
	}
	
	protected void getBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = WebUtils.parse2Integer(request.getParameter("id"), 0);
		Integer pageNo = WebUtils.parse2Integer(request.getParameter("pageNo"), 1);
		Book book = bookService.queryBookById(id);
		request.setAttribute("book", book);
		request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
	}
	@Deprecated
	protected void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Book> books = bookService.queryBooks();
		request.setAttribute("books", books);
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
	}

}
