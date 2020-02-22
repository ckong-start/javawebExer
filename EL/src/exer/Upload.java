package exer;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {

		if(ServletFileUpload.isMultipartContent(request)) {
			System.out.println("hello");
			FileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
			try {
				List<FileItem> fileItems = servletFileUpload.parseRequest(request);
				for (FileItem fileItem : fileItems) {
					if(fileItem.isFormField()) {
						System.out.println("表单项的name属性值是：" + fileItem.getFieldName());
						System.out.println("表单项的值是：" + fileItem.getString("UTF-8"));
					}else {
						System.out.println("表单项的name属性值是：" + fileItem.getFieldName());
						System.out.println("上传的文件名：" + fileItem.getName());
						fileItem.write(new File("d:\\" + fileItem.getName()));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
