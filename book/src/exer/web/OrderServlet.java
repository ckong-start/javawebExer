package exer.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exer.pojo.Cart;
import exer.pojo.User;
import exer.service.OrderService;
import exer.service.impl.OrderServiceImpl;

public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	OrderService orderService = new OrderServiceImpl();

	protected void createOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取session对象，从session中取出userId和cart
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Integer id = user.getId();
		Cart cart = (Cart) session.getAttribute("cart");
		//调用OrderServcie.createOrder(Userid,Cart)
		String orderId = orderService.createOrder(id, cart);
		// 把订单号保存到session域中
		session.setAttribute("orderId", orderId);
		response.sendRedirect(request.getContextPath() + "/pages/cart/checkout.jsp");
	}

}
