package exer.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import exer.pojo.Book;
import exer.pojo.Page;
import exer.service.BookService;
import exer.service.impl.BookServiceImpl;
import exer.util.WebUtils;

public class BookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookServiceImpl();
	
	@Deprecated
	protected void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Book> list = bookService.queryBooks();
		request.setAttribute("books", list);
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
	}

	protected void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Book book = WebUtils.copyParamToBean(new Book(), request.getParameterMap());
		bookService.addBook(book);
		int pageNo = WebUtils.parseInt(request.getParameter("pageNo"),1);
		response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + (pageNo + 1));
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = WebUtils.parseInt(request.getParameter("id"), 0);
		bookService.deleteBookById(id);
		String pageNo = request.getParameter("pageNo");
		response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
	}
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)) {
			FileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
			try {
				List<FileItem> fileItems = servletFileUpload.parseRequest(request);
				for (FileItem fileItem : fileItems) {
					if(fileItem.isFormField()) {
						System.out.println("表单项的name属性值是：" + fileItem.getFieldName());
						System.out.println("表单项的值是：" + fileItem.getString("UTF-8"));
					}else {
						System.out.println("上传的文件名：" + fileItem.getName());
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}
		Book book = WebUtils.copyParamToBean(new Book(), request.getParameterMap());
		bookService.updateBook(book);
		String pageNo = request.getParameter("pageNo");
		response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
	}
	protected void getBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = WebUtils.parseInt(request.getParameter("id"), 0);
		Book book = bookService.queryBookById(id);
		request.setAttribute("book", book);
		request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
	}
	protected void page(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
		Integer pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
		Page<Book> page = bookService.page(pageNo, pageSize);
		
		page.setUri("manager/bookServlet?action=page");
		
		request.setAttribute("page", page);
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
	}
}
