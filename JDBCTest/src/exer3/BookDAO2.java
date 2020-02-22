package exer3;

import java.util.List;

import exer2.Book;

public class BookDAO2 extends BaseDAO2 {
	public int saveBook(Book book) {//保存
		String sql = "insert into t_book('name','author','price','sales','stock','publishing')values(?,?,?,?,?,?)";
		return updateDB(sql,book.getName(),
					book.getAuthor(),book.getPrice(),
					book.getSales(),book.getStock(),
					book.getPublishing());
	}

	public int updateBook(Book book) {// 修改

		String sql = "update t_book set 'name' = ?,'author' = ?,'price' = ?,'sales' = ?,'stock' = ?,'publishing' = ? where id = ?";
		return updateDB(sql,book.getName(),
					book.getAuthor(),book.getPrice(),
					book.getSales(),book.getStock(),
					book.getPublishing(),book.getId());
	}

	public int deleteBookById(Integer id) {// 根据主键删除

		String sql = "delete from t_book where id = ?";
		return updateDB(sql,id);
	}

	public Book queryBookById(Integer id) {// 根据主键查询
		String sql = "select id,name,author,price,sales,stock,publishing from t_book where id = ?";
		return queryOne(Book.class,sql,id);
	}

	public List<Book> queryBooks(Book book) {// 查询所有
		
		String sql = "select id,name,author,price,sales,stock,publishing from t_book";
		return queryAll(Book.class, sql);
	}
}
