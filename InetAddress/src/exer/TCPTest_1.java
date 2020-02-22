package exer;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest_1 {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(9091);
		Socket socket = ss.accept();
		InputStream is = socket.getInputStream();
		FileOutputStream fos = new FileOutputStream("a_2.jpg");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		byte[] buffer = new byte[1024];
		int len;
		while((len = is.read(buffer)) != -1){
			bos.write(buffer,0,len);
		}
		
		OutputStream os = socket.getOutputStream();
		os.write("照片已经收到，谢谢".getBytes());
		os.close();
		fos.close();
		is.close();
		socket.close();
		ss.close();
	}
}
