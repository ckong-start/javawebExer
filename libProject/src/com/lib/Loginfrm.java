package com.lib;

//登录界面

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class Loginfrm extends Dialog implements ActionListener {
	JLabel l_name, l_pass, l_error;
	JTextField t_name;
	JButton b_enter, b_cancle, b_clear;
	JPanel pan1, pan2, pan3, pan4;
	JPasswordField t_pass;
	String sname, spass;
	int sunit;
	NetConn sql;
	Statement sqll;
	ResultSet rs;
	Librarybox lbox;
	int until = 0;

	Loginfrm(Frame f, String s) { // 界面布局
		super(f, s);
		l_name = new JLabel("名字：");
		l_pass = new JLabel("密码：");
		l_error = new JLabel("请输入用户名和密码登录");
		t_name = new JTextField("", 10);
		t_pass = new JPasswordField("", 10);
		t_pass.setEchoChar('*');
		b_enter = new JButton("确定");
		b_enter.addActionListener(this);
		b_cancle = new JButton("取消");
		b_cancle.addActionListener(this);
		b_clear = new JButton("清除");
		b_clear.addActionListener(this);
		pan1 = new JPanel();
		pan2 = new JPanel();
		pan3 = new JPanel();
		pan4 = new JPanel();
		pan1.add(l_name);
		pan1.add(t_name);
		pan2.add(l_pass);
		pan2.add(t_pass);
		pan3.add(l_error);
		pan4.add(b_enter);
		pan4.add(b_cancle);
		pan4.add(b_clear);
		setLayout(new GridLayout(4, 1));
		add(pan1);
		add(pan2);
		add(pan3);
		add(pan4);
		// 建立数据库连接
		sql = new NetConn();
		// 设置窗口大小
		setBounds(400, 200, 300, 300);
		// setVisible(false);

	}

	public void actionPerformed(ActionEvent e) {
		// 单击取消按钮的事件处理程序
		if (e.getSource() == b_cancle) {

			dispose();

		}
		// 单击确定按钮的事件处理程序
		if (e.getSource() == b_enter) {

			// 如果连续登录次数小于4
			if (until <= 4) {

				// 如果用户名或者密码为空，将显示提示信息
				if (t_name.getText().equals("") || t_pass.getText().equals("")) {

					l_error.setText("用户名和密码不能为空");

				} else {

					try {

						sqll = sql.connect();
						// 根据用户名查询
						rs = sqll.executeQuery("SELECT * FROM users where username=" + "'" + t_name.getText() + "'");
						// 遍历查询得到的结果集
						while (rs.next()) {

							sname = rs.getString(2);
							spass = rs.getString(3);
							// 得到登录用户的级别
							sunit = Integer.parseInt(rs.getString(4));
							// 如果密码正确
							if (t_pass.getText().equals(spass)) {

								// 判断用户的级别，根据不同的级别，显示不同的菜单
								switch (sunit) {

								case 1: {

									l_error.setText("登录成功");
									t_name.setText("");
									t_pass.setText("");
									lbox = new Librarybox();
									lbox.bookfi.setEnabled(true);
									lbox.bookse.setEnabled(true);
									lbox.bookth.setEnabled(true);
									lbox.bookfo.setEnabled(true);
									lbox.mi_system_manger.setEnabled(true);
									lbox.setVisible(true);
									this.dispose();
									break;

								}
								case 2: {

									l_error.setText("登录成功");
									t_name.setText("");
									t_pass.setText("");
									lbox = new Librarybox();
									lbox.bookfi.setEnabled(false);
									lbox.bookse.setEnabled(false);
									lbox.bookth.setEnabled(true);
									lbox.bookfo.setEnabled(false);
									lbox.mi_system_manger.setEnabled(false);
									lbox.setVisible(true);
									this.dispose();
									break;

								}
								case 3: {

									l_error.setText("登录成功");
									t_name.setText("");
									t_pass.setText("");
									lbox = new Librarybox();
									lbox.bookfi.setEnabled(true);
									lbox.bookse.setEnabled(false);
									lbox.bookth.setEnabled(false);
									lbox.bookfo.setEnabled(true);
									lbox.mi_system_manger.setEnabled(false);
									lbox.fi_msglabel_user.setEnabled(false);
									lbox.setVisible(true);
									this.dispose();
									break;

								}

								}

							} else {

								l_error.setText("用户名或密码错误！");
								until++;

							}
						}

					}

					catch (SQLException e2) {

					}

				}

			}
			// 超出登录次数
			else {
				l_error.setText("你已经超出登录次数");
				t_name.setEnabled(false);
				t_pass.setEnabled(false);
				b_enter.setEnabled(false);

			}
		}
		// 单击清除按钮的事件处理程序
		if (e.getSource() == b_clear) {
			t_name.setEnabled(true);
			t_pass.setEnabled(true);
			b_enter.setEnabled(true);
			t_name.setText("");
			t_pass.setText("");
			l_error.setText("请输入用户名和密码登录");
			until = 0;

		}

	}

}

/*import java.sql.*;

import javax.swing.*;

class Loginfrm extends JFrame implements ActionListener {
	Object a[][];
	Object colname[] = { "id", "用户名", "密码" };
	JTable table;
	Container container;
	JButton b_enter, b_back;
	JProgressBar p_bar;
	JPanel pan1;
	NetConn sql;
	Statement sqll;
	ResultSet rs;

	Loginfrm() {
		// 界面布局
		super("用户列表");
		a = new Object[30][3];
		table = new JTable(a, colname);
		setSize(300, 300);
		setVisible(true);
		b_enter = new JButton("确定");
		b_back = new JButton("返回");
		b_enter.addActionListener(this);
		b_back.addActionListener(this);
		pan1 = new JPanel();
		pan1.add(b_enter);
		pan1.add(b_back);
		p_bar = new JProgressBar(JProgressBar.VERTICAL, 0, 50);
		p_bar.setStringPainted(true);
		container = getContentPane();
		container.add(pan1, BorderLayout.SOUTH);
		container.add(new JScrollPane(table), BorderLayout.CENTER);
		container.add(p_bar, BorderLayout.WEST);
		// 建立数据库连接
		sql = new NetConn();
		// 设置窗体大小
		setBounds(250, 150, 600, 350);

	}

	public void actionPerformed(ActionEvent eb) {

		// 单击返回按钮的事件处理程序
		if (eb.getSource() == b_back) {

			dispose();

		}
		// 单击确定按钮的事件处理程序
		else if (eb.getSource() == b_enter) {

			try {

				int i = 0;
				sqll = sql.connect();
				// 查询所有用户
				rs = sqll.executeQuery("select * from users");
				// 循环显示所有用户列表
				while (rs.next()) {

					a[i][0] = rs.getString(2);
					a[i][1] = rs.getString(3);
					a[i][2] = rs.getString(4);
					i++;
					p_bar.setValue(i);

					p_bar.setString("查询了" + i + "条记录");

				}

			} catch (SQLException ed) {

			}

		}

	}

}*/
