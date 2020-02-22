package dao.impl;

import java.sql.SQLException;
import java.util.List;

import dao.BookDao;
import pojo.Book;

public class BookDaoImpl extends BaseDao implements BookDao {

	@Override
	public int saveBook(Book book) {
		String sql = "insert into t_book(`name` , `author` , `price` , `sales` , `stock` , `img_path`) values(?,?,?,?,?,?)";
		return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(),
				book.getImgPath());
	}

	@Override
	public int updateBook(Book book) {
		String sql = "update t_book set `name`=?,`author`=?,`price`=?,`sales`=?,`stock`=?,`img_path`=? where id = ?";
		return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getPrice(), book.getStock(),
				book.getImgPath(), book.getId());
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
		Long count = (Long) queryForSimpleValue(sql);
		return count.intValue();
	}

	@Override
	public List<Book> queryForPageItems(Integer begin, Integer pageSize) {
		String sql = "select * from t_book limit ?, ?";
		return queryForList(Book.class, sql, begin, pageSize);
	}

	@Override
	public Integer queryForPageTotalCountByPrice(Integer min, Integer max) {
		String sql = "select count(*) from t_book where price between ? and ? order by price";
		Long count = (Long) queryForSimpleValue(sql, min, max);
		return count.intValue();
	}

	@Override
	public List<Book> queryForPageItemsByPrice(Integer min, Integer max, Integer begin, Integer pageSize) {
		String sql = "select * from t_book where price between ? and ? order by price limit ?, ?";
		return queryForList(Book.class, sql, min, max, begin, pageSize);
	}

}
