package exer;

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
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = "girl.jpg";
		String path = "/file/" + fileName;
		//获取ServletContext对象
		ServletContext servletContext = getServletContext();
		//获取下载文件的数据类型
		String mimeType = servletContext.getMimeType(path);
		//告诉客户端返回的数据类型
		response.setContentType(mimeType);
		String header = request.getHeader("User-Agent");
		if(header.contains("Firefox")) {
			String str = "attachment; fileName=" + "=?utf-8?B?" + new BASE64Encoder()
					.encode("gilr.jpg".getBytes("utf-8")) + "?=";
			response.setHeader("Context-Disposition", str);
		}else {
			String str = "attachment; fileName=" + URLEncoder.
					encode("girl.jpg", "utf-8");
			response.setHeader("Content-Disposition", str);
		}
		
		//读取下载的文件
		InputStream is = servletContext.getResourceAsStream(path);
		//得到字节输出流
		ServletOutputStream os = response.getOutputStream();
		//读取输入流中的数据，输出给字节流
		IOUtils.copy(is, os);
		//关闭流
		is.close();
		os.close();
	}

}
