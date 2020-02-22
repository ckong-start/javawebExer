package com.lib;

//用户列表

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Userlistfrm extends JFrame implements ActionListener {
	Object a[][];
	Object colname[] = { "用户名", "密码", "权限" };
	JTable table;
	Container container;
	JButton b_enter, b_back;
	JProgressBar p_bar;
	JPanel pan1;
	NetConn sql;
	Statement sqll;
	ResultSet rs;

	Userlistfrm() {
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

}
