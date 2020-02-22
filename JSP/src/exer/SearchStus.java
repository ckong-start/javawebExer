package exer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchStus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> stus = new ArrayList<Student>();
		for(int i = 1; i <= 20; i++) {
			stus.add(new Student(i, "name" + i, i % 2 == 0 ? "男" : "女", 10 + i, "18999" + i));
		}
		request.setAttribute("stus", stus);
		request.getRequestDispatcher("/d.jsp").forward(request, response);
	}

	
}
