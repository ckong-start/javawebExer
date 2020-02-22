package buffered;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class printTest {
	public static void main(String[] args) {

		Thread write = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					FileOutputStream fos = new FileOutputStream("a.txt");
					int i = 0;
					while (true) {
						try {
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							fos.write(i);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}, "写");
		Thread read = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					FileInputStream fis = new FileInputStream("a.txt");
					int i = 0;
					while (true) {
						try {
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							int j = fis.read();
							System.out.println(j);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}, "读");
		write.start();
		read.start();
	}
}
