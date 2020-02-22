package test;

import org.junit.BeforeClass;
import org.junit.Test;

import pojo.Page;
import service.BookService;
import service.impl.BookServiceImpl;

public class BookServiceTest {
	BookService bookService = new BookServiceImpl();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testPage() {
		Page page = bookService.page(10, 4);
		System.out.println(page);
	}
	@Test
	public void testPageByPrice() {
		Page page = bookService.pageByPrice(10, 50, 3, 4);
		System.out.println(page);
	}

}
