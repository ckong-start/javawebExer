package exer2;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;




public class Upload2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
		if(ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> fileItems = servletFileUpload.parseRequest(request);
				for (FileItem fileItem : fileItems) {
					if(fileItem.isFormField()) {
						fileItem.getFieldName();
						fileItem.getString();
					}else {
						fileItem.getFieldName();
						fileItem.getString();
						fileItem.write(new File("D:\\" + fileItem.getName()));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
