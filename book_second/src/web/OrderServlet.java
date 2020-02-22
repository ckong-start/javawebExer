package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Cart;
import pojo.Order;
import pojo.OrderItem;
import pojo.User;
import service.OrderItemService;
import service.OrderService;
import service.impl.OrderItemServiceImpl;
import service.impl.OrderServiceImpl;

public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private OrderService orderService = new OrderServiceImpl();
	private OrderItemService orderItemService = new OrderItemServiceImpl();
	
	protected void listOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		List<Order> orderList = orderService.queryOrdersByUserId(user.getId());
		request.setAttribute("orderList", orderList);
		request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);
	}
	
	protected void details(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String orderId = request.getParameter("orderId");
		List<OrderItem> orderItems = orderItemService.queryOrderItems(orderId);
		request.setAttribute("orderItems", orderItems);
		request.getRequestDispatcher("/pages/order/orderItem.jsp").forward(request, response);
	}

	protected void createOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		User user = (User) session.getAttribute("user");
		if (user == null) {
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
			//请求转发和重定向后，不再执行后面的代码
			return;
		}
		
		String orderId = orderService.createOrder(cart, user.getId());
		session.setAttribute("orderId", orderId);
		response.sendRedirect(request.getContextPath() + "/pages/cart/checkout.jsp");
	}

}
