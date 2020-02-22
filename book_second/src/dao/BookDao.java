package dao;

import java.util.List;

import pojo.Book;

public interface BookDao {
	int saveBook(Book book);
	int updateBook(Book book);
	int deleteBookById(Integer id);
	Book queryBookById(Integer id);
	List<Book> queryBooks();
	Integer queryForPageTotalCount();
	List<Book> queryForPageItems(Integer begin, Integer pageSize);
	Integer queryForPageTotalCountByPrice(Integer min, Integer max);
	List<Book> queryForPageItemsByPrice(Integer min, Integer max, Integer begin, Integer pageSize);
}
