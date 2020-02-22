package exer.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import exer.pojo.Person;

public class AjaxServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	protected void jquerySerialize(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("jquerySerialize方法被调用了");
		System.out.println("用户名是：" + request.getParameter("username"));
		System.out.println("密码是：" + request.getParameter("password"));
		Person person = new Person(1,"杨六麻子");
		String personToJson = new Gson().toJson(person);
		response.getWriter().write(personToJson);
	}
	
	protected void jqueryGetJSON(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("jqueryGetJSON方法被调用了");
		Person person = new Person(1,"七七");
		String personToJson = new Gson().toJson(person);
		response.getWriter().write(personToJson);
	}
	
	protected void jqueryPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("jqueryPost方法被调用了");
		Person person = new Person(1,"王五");
		String personToJson = new Gson().toJson(person);
		response.getWriter().write(personToJson);
	}
	
	protected void jqueryGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("jqueryGet方法被调用了");
		Person person = new Person(1,"李四");
		String personToJson = new Gson().toJson(person);
		response.getWriter().write(personToJson);
	}
	
	protected void jqueryAjax(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("jqueryAjax方法被调用了");
		Person person = new Person(1,"张三");
		String personToJson = new Gson().toJson(person);
		response.getWriter().write(personToJson);
	}
	
	protected void javaScriptAjax(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("收到了Ajax的请求");
		Person person = new Person(1,"张三");
		String personToJson = new Gson().toJson(person);
		response.getWriter().write(personToJson);
	}

}
