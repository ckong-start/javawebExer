package exer.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exer.pojo.Book;
import exer.pojo.Page;
import exer.service.BookService;
import exer.service.impl.BookServiceImpl;
import exer.util.WebUtils;

public class ClientBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookServiceImpl();

	protected void pageByPrice(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
		int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
		int min = WebUtils.parseInt(request.getParameter("min"), 0);
		int max = WebUtils.parseInt(request.getParameter("max"), Integer.MAX_VALUE);
		Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);
		page.setUri("client/bookServlet?action=pageByPrice&min=" + request.getParameter("min") + "&max="
				+ request.getParameter("max"));//此处使用request.getParameter()的好处是，如果没有输入值，则不会显示。
		request.setAttribute("page", page);
		request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
	}

	protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
		int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
		Page<Book> page = bookService.page(pageNo, pageSize);
		page.setUri("client/bookServlet?action=page");
		request.setAttribute("page", page);

		request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
	}

}
