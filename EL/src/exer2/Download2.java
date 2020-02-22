package exer2;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import sun.misc.BASE64Encoder;

public class Download2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fileName = "1.jpg";
		String path = "/file/" + fileName;
		ServletContext servletContext = getServletContext();
		String mimeType = servletContext.getMimeType(path);
		response.setContentType(mimeType);
		String ua = request.getHeader("User-Agent");
		String str;
		if(ua.contains("Firefox")) {
			str = "=?utf-8?B?" + new BASE64Encoder().encode(fileName.getBytes("utf-8"));
		}else {
			
			str = URLEncoder.encode(fileName, "utf-8");
		}
		response.setHeader("Context-Disposition", "attachment;filename=" + str);
		//response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		InputStream is = servletContext.getResourceAsStream(path);
		ServletOutputStream os = response.getOutputStream();
		IOUtils.copy(is, os);
		is.close();
		os.close();
	}
}
