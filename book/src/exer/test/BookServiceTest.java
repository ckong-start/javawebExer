package exer.test;

import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import exer.pojo.Book;
import exer.pojo.Page;
import exer.service.BookService;
import exer.service.impl.BookServiceImpl;

public class BookServiceTest {
	static BookService bookService = new BookServiceImpl();
	@Test
	public void testAddBook() {
		bookService.addBook(new Book(null, "1010是最棒的", "1010", new BigDecimal(
				100000), 100, 100, null));
	}

	@Test
	public void testUpdateBook() {
		bookService.updateBook(new Book(22, "国哥也是最棒的", "1010",
				new BigDecimal(100000), 100, 100, null));
	}

	@Test
	public void testDeleteBookById() {
		bookService.deleteBookById(22);
	}

	@Test
	public void testQueryBookById() {
		System.out.println(bookService.queryBookById(17));
	}

	@Test
	public void testQueryBooks() {
		bookService.queryBooks().forEach(System.out::println);
	}

	@Test
	public void testPage() {
		Page page = bookService.page(2, 4);
		System.out.println(page);
	}
	@Test
	public void testPageByPrice() {
		Page page = bookService.pageByPrice(2, 4, 10, 50);
		System.out.println(page);
	}
}
