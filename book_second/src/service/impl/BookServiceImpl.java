package service.impl;

import java.util.List;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import pojo.Book;
import pojo.Page;
import service.BookService;

public class BookServiceImpl implements BookService {
	BookDao bookDao = new BookDaoImpl();
	@Override
	public void saveBook(Book book) {
		bookDao.saveBook(book);

	}

	@Override
	public void deleteBookById(Integer id) {
		bookDao.deleteBookById(id);

	}

	@Override
	public void updateBook(Book book) {
		bookDao.updateBook(book);

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
	public Page<Book> page(Integer pageNo, Integer pageSize) {
		Page<Book> page = new Page<>();
		//new Page<>(pageNo, pageSize, pageTotal, pageTotalCount, items)
		page.setPageSize(pageSize);
		Integer pageTotalCount = bookDao.queryForPageTotalCount();
		page.setPageTotalCount(pageTotalCount);
		Integer pageTotal = pageTotalCount / pageSize;
		if(pageTotalCount % pageSize > 0)pageTotal++;
		page.setPageTotal(pageTotal);
		page.setPageNo(pageNo);
		Integer begin = (page.getPageNo() - 1) * pageSize;
		List<Book> items = bookDao.queryForPageItems(begin,pageSize);
		page.setItems(items);
		return page;
	}

	@Override
	public Page<Book> pageByPrice(Integer min, Integer max, Integer pageNo, Integer pageSize) {
		Page<Book> page = new Page<>();
		//new Page<>(pageNo, pageSize, pageTotal, pageTotalCount, items)
		page.setPageSize(pageSize);
		Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min, max);
		page.setPageTotalCount(pageTotalCount);
		Integer pageTotal = pageTotalCount / pageSize;
		if(pageTotalCount % pageSize > 0)pageTotal++;
		page.setPageTotal(pageTotal);
		page.setPageNo(pageNo);
		Integer begin = (page.getPageNo() - 1) * pageSize;
		List<Book> items = bookDao.queryForPageItemsByPrice(min, max, begin,pageSize);
		page.setItems(items);
		return page;
	}

}
