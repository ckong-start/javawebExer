package service;

import java.util.List;

import pojo.Book;
import pojo.Page;

public interface BookService {
	void saveBook(Book book);
	void deleteBookById(Integer id);
	void updateBook(Book book);
	Book queryBookById(Integer id);
	List<Book> queryBooks();
	Page page(Integer pageNo, Integer pageSize);
	Page<Book> pageByPrice(Integer min, Integer max, Integer pageNo, Integer pageSize);
}
