package exer.service;

import java.util.List;

import exer.pojo.Book;
import exer.pojo.Page;

public interface BookService {
	/**
	 * 添加图书
	 * 
	 * @param book
	 */
	public void addBook(Book book);
	/**
	 * 修改图书
	 * 
	 * @param book
	 */
	public void updateBook(Book book);
	/**
	 * 通过id删除图书
	 * 
	 * @param id
	 */
	public void deleteBookById(Integer id);
	/**
	 * 通过id查询图书
	 * @param id
	 * @return Book
	 */
	public Book queryBookById(Integer id);
	/**
	 * 查询全部图书
	 * @return List
	 */
	public List<Book> queryBooks();
	/**
	 * 处理分页功能
	 * @param pageNo
	 * @param pageSize
	 * @return page
	 */
	public Page<Book> page(int pageNo, int pageSize);
	/**
	 * 按价格处理分页功能
	 * @param pageNo
	 * @param pageSize
	 * @param min
	 * @param max
	 * @return
	 */
	public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
