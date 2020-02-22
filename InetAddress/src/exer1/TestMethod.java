package exer1;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import org.junit.Test;


public class TestMethod {

	public static void main(String[] args) throws Exception {
		InetAddress localHost = InetAddress.getLocalHost();
		Socket socket = new Socket("192.168.11.21",12345);
//		FileInputStream fis = new FileInputStream("D:\\Workspace\\IO\\hello.txt");
		OutputStream os = socket.getOutputStream();
		os.write("服务端，你好，我是客户端".getBytes());
		System.out.println("传输完成");
		socket.shutdownOutput();
		InputStream is = socket.getInputStream();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int len;
		byte[] buffer = new byte[1024];
		while((len = is.read(buffer)) != -1){
			baos.write(buffer, 0, len);
		}
		System.out.println(baos);
		
		/*int len;
		byte[] buffer = new byte[1024];
		while((len = fis.read(buffer)) != -1){
			os.write(buffer,0,len);
		}*/
		
		baos.close();
		os.close();
//		fis.close();
		socket.close();
	}
	@Test
	public void test1() throws Exception{
		ServerSocket ss = new ServerSocket(12345);
		FileOutputStream fos = new FileOutputStream("D:\\Workspace\\IO\\hello_2.txt");
		Socket accept = ss.accept();
		InputStream is = accept.getInputStream();
		OutputStream os = accept.getOutputStream();
		int len;
		byte[] buffer = new byte[1024];
		
		os.write("客户端，你好".getBytes());
		
		while((len = is.read(buffer)) != -1){
			fos.write(buffer,0,len);
		}
		System.out.println("接受完毕");
		os.close();
		is.close();
		ss.close();
		fos.close();
		accept.close();
	}
	
	/*@Test
	public void test() throws Exception{
		InetAddress lh = InetAddress.getLocalHost();
		System.out.println(lh);
		System.out.println();
		
		InetAddress byName = InetAddress.getByName("192.168.11.40");
		System.out.println(byName);
		System.out.println();
		String hostName = byName.getHostName();
		String hostAddress = byName.getHostAddress();
		System.out.println(hostName);
		System.out.println(hostAddress);
		
	}*/
	
	@Test
	public void test2() throws IOException {
		String str;
		DatagramSocket ds = new DatagramSocket();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("请输入字符串");
			str = sc.next();
			if ("886".equals(str))
				break;
			byte[] bys = str.getBytes();
			int len = bys.length;
			InetAddress ip = InetAddress.getByName("192.168.11.40");
			DatagramPacket dp = new DatagramPacket(bys, len, ip, 12345);
			ds.send(dp);
		}
		ds.close();
	}	
	@Test
	public void test123(){
		
	}
}
