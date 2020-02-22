package exer.dao.impl;

import java.util.List;

import exer.dao.BookDao;
import exer.pojo.Book;

public class BookDaoImpl extends BaseDao implements BookDao {

	@Override
	public int saveBook(Book book) {
		String sql = "insert into t_book (`name`,`author`,`price`,`sales`,`stock`,`img_path`) values(?,?,?,?,?,?)";

		return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(),
				book.getImgPath());
	}

	@Override
	public int updateBook(Book book) {
		String sql = "update t_book set `name`=?,`author`=?,`price`=?,`sales`=?,`stock`=?,`img_path`=? where id = ?";
		
		return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(),
				book.getImgPath(),book.getId());
	}

	@Override
	public int deleteBookById(Integer id) {
		String sql = "delete from t_book where id = ?";
		
		return update(sql, id);
	}

	@Override
	public Book queryBookById(Integer id) {
		String sql = "select * from t_book where id = ?";
		
		return queryForOne(Book.class, sql, id);
	}

	@Override
	public List<Book> queryBooks() {
		String sql = "select * from t_book";
		
		return queryForList(Book.class, sql);
	}

	@Override
	public Integer queryForPageTotalCount() {
		String sql = "select count(*) from t_book";
		Long count = (Long) queryForSingleValue(sql);
		//System.out.println(count.getClass());
		//return new Integer(count.toString());
		return count.intValue();
	}

	@Override
	public List<Book> queryForPageItems(Integer begin, int pageSize) {
		String sql = "select * from t_book limit ? , ?";
		return queryForList(Book.class, sql, begin, pageSize);
	}

	@Override
	public Integer queryForPageTotalCountByPrice(int min, int max) {
		String sql = "select count(*) from t_book where price between ? and ?";
		Long count = (Long) queryForSingleValue(sql, min, max);
		return new Integer(count.toString());
	}

	@Override
	public List<Book> queryForPageItemsByPrice(Integer begin, Integer pageSize, int min, int max) {
		String sql = "select * from t_book where price between ? and ? order by price limit ? , ?";
		return queryForList(Book.class, sql, min, max, begin, pageSize);
	}

}
