package XMLTest;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class GetXML2 {
	@Test
	public void getDocument() throws Exception {
		//创建SAXReader对象
		SAXReader reader = new SAXReader();
		//通过对象读取xml，获得document对象
		Document document =reader.read("src/books.xml");
		//通过document对象的到root根目录
		Element root = document.getRootElement();
		//
		List<Element> books = root.elements("book");
		List<Book> list = new ArrayList<>();
		for (Element book : books) {
			String name = book.elementText("name");
			String author = book.elementText("author");
			double price = Double.parseDouble(book.elementText("price"));
			String publish = book.elementText("publish");
			list.add(new Book(name,author,price,publish));
		}
		System.out.println(list);
	}
	@Test
	public void test() throws DocumentException {
		String name = new SAXReader().read("src/books.xml")
						.getRootElement()
						.elementTextTrim("name");
		System.out.println(name);
	}
	
}
