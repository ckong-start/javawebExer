package test;

import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import pojo.Book;
import util.JdbcUtils;

public class BookDaoTest {
	BookDao bookDao = new BookDaoImpl();
	@Test
	public void testSaveBook() {
		bookDao.saveBook(new Book(null, "11", "22", new BigDecimal(20), 20, 30, null));
		JdbcUtils.commitAndClose();
	}

	@Test
	public void testUpdateBook() {
		bookDao.updateBook(new Book(29,"11", "22", new BigDecimal(20), 20, 40, null));
		JdbcUtils.commitAndClose();
	}

	@Test
	public void testDeleteBookById() {
		bookDao.deleteBookById(29);
		JdbcUtils.commitAndClose();
	}

	@Test
	public void testQueryBookById() {
		System.out.println(bookDao.queryBookById(20));
	}

	@Test
	public void testQueryBooks() {
		List<Book> list = bookDao.queryBooks();
		for (Book book : list) {
			System.out.println(book);
		}
	}
	@Test
	public void testQueryForPageTotalCount() {
		Integer count = bookDao.queryForPageTotalCount();
		System.out.println(count);
	}
	@Test
	public void testQueryForPageItems() {
		List<Book> list = bookDao.queryForPageItems(8, 4);
		list.forEach(System.out::println);
	}
	@Test
	public void testQueryForPageTotalCountByPrice() {
		Integer count = bookDao.queryForPageTotalCountByPrice(10, 50);
		System.out.println(count);
	}
	@Test
	public void testQueryForPageItemsByPrice() {
		List<Book> list = bookDao.queryForPageItemsByPrice(10, 50, 4, 4);
		list.forEach(System.out::println);
	}

}
