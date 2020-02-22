package exer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.junit.Test;

public class URLTest {
	
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://localhost:8080/examples/beauty.jpg");
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		urlConnection.connect();
		InputStream is = urlConnection.getInputStream();
		FileOutputStream fos = new FileOutputStream("beauty.jpg");
		
		byte[] buffer = new byte[1024];
		int len;
		while((len = is.read(buffer)) != -1){
			fos.write(buffer,0,len);
		}
		System.out.println("下载完成");
		fos.close();
		is.close();
		urlConnection.disconnect();
	}
	
	@Test
	public void testMethod() throws IOException{
		URL url = new URL("http://localhost:8080/examples/beauty.jpg?username=Tom");
		System.out.println(url.getProtocol());
		System.out.println();
		System.out.println(url.getHost());
		System.out.println();
		System.out.println(url.getPort());
		System.out.println();
		System.out.println(url.getPath());
		System.out.println();
		System.out.println(url.getFile());
		System.out.println();
		System.out.println(url.getQuery());
	}
}
