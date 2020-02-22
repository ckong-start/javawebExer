package exer.dao;

import java.util.List;

import exer.pojo.Book;

public interface BookDao {
	/**
	 * 保存图书
	 * 
	 * @param book
	 * @return int
	 */
	public int saveBook(Book book);
	/**
	 * 修改图书
	 * 
	 * @param book
	 * @return int
	 */
	public int updateBook(Book book);
	/**
	 * 通过id删除图书
	 * 
	 * @param id
	 * @return int
	 */
	public int deleteBookById(Integer id);
	/**
	 * 通过id查询图书
	 * 
	 * @param id
	 * @return book
	 */
	public Book queryBookById(Integer id);
	/**
	 * 查询全部图书
	 * 
	 * @return List
	 */
	public List<Book> queryBooks();
	/**
	 * 求总记录数
	 * @return Integer
	 */
	public Integer queryForPageTotalCount();
	/**
	 * 求当前页码数据
	 * @param begin
	 * @param pageSize
	 * @return List<T>
	 */
	public List<Book> queryForPageItems(Integer begin, int pageSize);
	/**
	 * 通过价格求总记录数
	 * @return Integer
	 */
	public Integer queryForPageTotalCountByPrice(int min, int max);
	/**
	 * 通过价格求页数据
	 * @param begin
	 * @param pageSize
	 * @param min
	 * @param max
	 * @return List<T>
	 */
	public List<Book> queryForPageItemsByPrice(Integer begin, Integer pageSize, int min, int max);
}
