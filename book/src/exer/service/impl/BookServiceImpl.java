package exer.service.impl;

import java.util.List;

import exer.dao.BookDao;
import exer.dao.impl.BookDaoImpl;
import exer.pojo.Book;
import exer.pojo.Page;
import exer.service.BookService;

public class BookServiceImpl implements BookService {
	private BookDao bookDao = new BookDaoImpl();
	@Override
	public void addBook(Book book) {
		
		bookDao.saveBook(book);
	}

	@Override
	public void updateBook(Book book) {
		
		bookDao.updateBook(book);

	}

	@Override
	public void deleteBookById(Integer id) {
		
		bookDao.deleteBookById(id);
	}

	@Override
	public Book queryBookById(Integer id) {
		
		return bookDao.queryBookById(id);
	}

	@Override
	public List<Book> queryBooks() {
		
		return bookDao.queryBooks();
	}

	@Override
	public Page<Book> page(int pageNo, int pageSize) {
		Page<Book> page = new Page<>();
		//设置每页显示数量
		page.setPageSize(pageSize);
		//求总记录数
		Integer pageTotalCount = bookDao.queryForPageTotalCount();
		//设置总记录数
		page.setPageTotalCount(pageTotalCount);
		//求总页码数
		Integer pageTotal = pageTotalCount / pageSize;
		if( pageTotalCount % pageSize > 0) {
			pageTotal++;
		}
		//设置总页码数
		page.setPageTotal(pageTotal);
		
		//设置当前页码
		page.setPageNo(pageNo);
		//求begin
		Integer begin = (page.getPageNo() - 1) * page.getPageSize();
		//求当前也数据
		List<Book> items = bookDao.queryForPageItems(begin, page.getPageSize());
		//设置当前页数据
		page.setItems(items);
		return page;
	}

	@Override
	public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
		Page<Book> page = new Page<>();
		//设置每页显示数量
		page.setPageSize(pageSize);
		//求总记录数
		Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min, max);
		//设置总记录数
		page.setPageTotalCount(pageTotalCount);
		//求总页码数
		Integer pageTotal = pageTotalCount / pageSize;
		if( pageTotalCount % pageSize > 0) {
			pageTotal++;
		}
		//设置总页码数
		page.setPageTotal(pageTotal);
		
		//设置当前页码
		page.setPageNo(pageNo);
		//求begin
		Integer begin = (page.getPageNo() - 1) * page.getPageSize();
		//求当前页数据
		List<Book> items = bookDao.queryForPageItemsByPrice(begin, page.getPageSize(), min, max);
		//设置当前页数据
		page.setItems(items);
		return page;
	}

}
