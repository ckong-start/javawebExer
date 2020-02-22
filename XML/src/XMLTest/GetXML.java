package XMLTest;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class GetXML {
	@Test
	public void getDocument() throws Exception {
		//先创建一个SAXReader对象
		SAXReader reader = new SAXReader();
		
		//用创建好的对象读取xml文件，然后返回一个Document
		Document document = reader.read("src/books.xml");
		
		//通过Document对象拿到XML的根元素对象
		Element root = document.getRootElement();
		
		//通过根元素对象，获取所有的book标签对象
		List<Element> list = root.elements("book");
		for (Element book : list) {
//			System.out.println(book.elements());
			String name = book.element("name").getText();
			String author = book.element("author").getText();
			String price = book.element("price").getText();
			String publish = book.element("publish").getText();
			System.out.println(new Book(name, author, Double.parseDouble(price), publish));
		}
	}
	
}
