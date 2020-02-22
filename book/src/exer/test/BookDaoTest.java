package exer.test;

import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import exer.dao.BookDao;
import exer.dao.impl.BookDaoImpl;
import exer.pojo.Book;

public class BookDaoTest {
	static BookDao bookDao = new BookDaoImpl();
	@Test
	public void testSaveBook() {
		bookDao.saveBook(new Book(null, "国哥在手，天下我有", "1010", new BigDecimal(
				10000), 100000, 1, null));
	}

	@Test
	public void testUpdateBook() {
		bookDao.updateBook(new Book(21, "国哥是个暖宝宝", "国哥", new BigDecimal(10000),
				1, 100000, null));
	}

	@Test
	public void testDeleteBookById() {
		bookDao.deleteBookById(21);
	}

	@Test
	public void testQueryBookById() {
		System.out.println(bookDao.queryBookById(15));
	}

	@Test
	public void testQueryBooks() {
		//bookDao.queryBooks().forEach(t->System.out.println(t));
		bookDao.queryBooks().forEach(System.out::println);
	}
	
	@Test
	public void testQueryForPageTotalCount() {
		Integer count = bookDao.queryForPageTotalCount();
		System.out.println(count);
	}

	@Test
	public void testQueryForPageItems() {
		bookDao.queryForPageItems(8, 4).forEach(System.out::println);
	}
	@Test
	public void testQueryForPageTotalCountByPrice() {
		Integer count = bookDao.queryForPageTotalCountByPrice(10,50);
		System.out.println(count);
	}
	
	@Test
	public void testQueryForPageItemsByPrice() {
		bookDao.queryForPageItemsByPrice(1, 4, 10, 50).forEach(System.out::println);
	}

}
