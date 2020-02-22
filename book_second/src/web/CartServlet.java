package web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import pojo.Book;
import pojo.Cart;
import pojo.CartItem;
import service.BookService;
import service.impl.BookServiceImpl;
import util.WebUtils;

public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	BookService bookService = new BookServiceImpl();
	
	protected void clear(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		cart.clear();
		response.sendRedirect(request.getHeader("referer"));
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = WebUtils.parse2Integer(request.getParameter("id"), 0);
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		cart.deleteItem(id);
		response.sendRedirect(request.getHeader("referer"));
	}

	protected void ajaxAddItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer itemId = WebUtils.parse2Integer(request.getParameter("itemId"), 0);
		Book book = bookService.queryBookById(itemId);
		HttpSession session = request.getSession();
		if (book != null) {
			
			Cart cart = (Cart) session.getAttribute("cart");
			if (cart == null) {
				cart = new Cart();
				session.setAttribute("cart", cart);
			}
			session.setAttribute("lastName", book.getName());
			CartItem item = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
			cart.addItem(item);
		
			HashMap<String, Object> result = new HashMap<String, Object>();
			result.put("bookName", book.getName());
			result.put("bookCount", cart.getTotalCount());
			String json = new Gson().toJson(result);
			response.getWriter().write(json);
		}
	}

	protected void ajaxUpdateCount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String itemId = request.getParameter("itemId");
		String count = request.getParameter("count");
		
	}

}
