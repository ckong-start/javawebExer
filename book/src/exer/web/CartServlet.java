package exer.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import exer.pojo.Book;
import exer.pojo.Cart;
import exer.pojo.CartItem;
import exer.service.BookService;
import exer.service.impl.BookServiceImpl;
import exer.util.WebUtils;

public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookServiceImpl();
	
	/**
	 * 使用Ajax请求编写修改购物车的数量的操作
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void ajaxUpdateItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = WebUtils.parseInt(request.getParameter("id"), 0);
		int count = WebUtils.parseInt(request.getParameter("count"), 1);
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		BigDecimal updateItemTotalPrice = cart.updateCount(id, count);
		Map<String, Object> result = new HashMap<>();
		// 返回 三个信息，给客户端。
		result.put("updateItemTotalPrice", updateItemTotalPrice);
		result.put("cartTotalCount", cart.getTotalCount());
		result.put("cartTotalPrice", cart.getTotalPrice());
		String resultJsonString = new Gson().toJson(result);
		response.getWriter().write(resultJsonString);
	}
	
	/**
	 * 使用Ajax请求编写加入购物车的显示功能
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void ajaxAddItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = WebUtils.parseInt(request.getParameter("id"), 0);
		Book book = bookService.queryBookById(id);
		CartItem cartItem = new CartItem(id, book.getName(), 1, book.getPrice(), book.getPrice());
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if(cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		cart.addItem(cartItem);
		request.getSession().setAttribute("lastName", cartItem.getName());
		Map<String, Object> result = new HashMap<>();
		result.put("cartTotalCount", cart.getTotalCount());
		result.put("lastName", cartItem.getName());
		String resultJsonString = new Gson().toJson(result);
		response.getWriter().write(resultJsonString);
	}

	protected void addItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获取请求的参数，商品编号
		int id = WebUtils.parseInt(request.getParameter("id"), 0);
		//2.获取完整的商品信息，调用bookService.queryBookById();
		Book book = bookService.queryBookById(id);
		//3.把book图书的信息转换为CartItem对象
		CartItem item = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
		//4.调用Cart.addItem(cartItem)
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if(cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		cart.addItem(item);
		request.getSession().setAttribute("lastName", book.getName());
		//System.out.println(cart);
		//5.跳回添加商品的页面
		response.sendRedirect(request.getHeader("referer"));
	}
	
	protected void deleteItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = WebUtils.parseInt(request.getParameter("id"), 0);
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		cart.deleteItem(id);
		response.sendRedirect(request.getHeader("referer"));
	}
	
	protected void clearCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cart cart = (Cart) request.getSession().getAttribute("cart");
		cart.clear();
		response.sendRedirect(request.getHeader("referer"));
	}
	
	protected void updateItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = WebUtils.parseInt(request.getParameter("id"), 0);
		int count = WebUtils.parseInt(request.getParameter("count"), 1);
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		cart.updateCount(id, count);
		response.sendRedirect(request.getHeader("referer"));
	}

}
