package exer;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPTest {
	public static void main(String[] args) throws IOException {
		InetAddress address = InetAddress.getByName("192.168.11.68");
		Socket socket = new Socket(address,9091);
		OutputStream os = socket.getOutputStream();
		FileInputStream fis = new FileInputStream("a.jpg");
		
		byte[] buffer = new byte[1024];
		int len;
		while((len = fis.read(buffer)) != -1){
			os.write(buffer,0,len);
		}
		os.flush();
		socket.shutdownOutput();
		InputStream is = socket.getInputStream();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		byte[] b = new byte[10];
		int len1;
		while((len1 = is.read(b)) != -1){
			baos.write(b, 0, len1);
		}
		System.out.println(baos.toString());
		is.close();
		baos.close();
		os.close();
		fis.close();
		socket.close();
	}
	
	
}
