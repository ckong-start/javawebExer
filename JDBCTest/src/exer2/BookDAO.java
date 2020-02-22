package exer2;

import java.sql.Connection;
import java.util.List;

public class BookDAO extends BaseDAO<Book>{

	public int saveBook(Connection conn,Book book) {//保存
		String sql = "insert into t_book('name','author','price','sales','stock','publishing')values(?,?,?,?,?,?)";
		return	update(conn,sql,book.getName(),
					book.getAuthor(),book.getPrice(),
					book.getSales(),book.getStock(),
					book.getPublishing());
	}

	public int updateBook(Connection conn,Book book) {// 修改

		String sql = "update t_book set 'name' = ?,'author' = ?,'price' = ?,'sales' = ?,'stock' = ?,'publishing' = ? where = ?";
		return update(conn,sql,book.getName(),
					book.getAuthor(),book.getPrice(),
					book.getSales(),book.getStock(),
					book.getPublishing(),book.getId());
	}

	public int deleteBookById(Connection conn,Integer id) {// 根据主键删除

		String sql = "delete from t_book where = ?";
		return update(conn,sql,id);
	}

	public Book queryBookById(Connection conn,Integer id) {// 根据主键查询
		String sql = "select id,name,author,price,sales,stock,publishing from t_book where id = ?";
		return queryOne(conn,sql,id);
		
	}

	public List<Book> queryBooks(Connection conn,Book book) {// 查询所有
		
		String sql = "select id,name,author,price,sales,stock,publishing from t_book";
		return queryAll(conn,sql);
	}
}
