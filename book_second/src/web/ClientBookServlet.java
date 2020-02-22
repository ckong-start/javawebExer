package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Book;
import pojo.Page;
import service.BookService;
import service.impl.BookServiceImpl;
import util.WebUtils;

public class ClientBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	BookService bookService = new BookServiceImpl();

	protected void pageByPrice(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer pageNo = WebUtils.parse2Integer(request.getParameter("pageNo"), 1);
		Integer pageSize = WebUtils.parse2Integer(request.getParameter("pageSzie"), Page.PAGE_SIZE);
		Integer min = WebUtils.parse2Integer(request.getParameter("min"), 0);
		Integer max = WebUtils.parse2Integer(request.getParameter("max"), Integer.MAX_VALUE);
		Page<Book> page = bookService.pageByPrice(min, max, pageNo, pageSize);
		page.setUri("client/bookServlet?action=pageByPrice&min=" + request.getParameter("min") + "&max="
				+ request.getParameter("max"));
		request.setAttribute("page", page);
		request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
	}

	protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer pageNo = WebUtils.parse2Integer(request.getParameter("pageNo"), 1);
		Integer pageSize = WebUtils.parse2Integer(request.getParameter("pageSzie"), Page.PAGE_SIZE);
		Page<Book> page = bookService.page(pageNo, pageSize);
		page.setUri("client/bookServlet?action=page");
		request.setAttribute("page", page);
		request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
	}

}
