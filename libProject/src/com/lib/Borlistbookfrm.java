package com.lib;

//借书列表

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Borlistbookfrm extends JFrame implements ActionListener {
	Object a[][];
	Object colname[] = { "用户", "书名", "借书时间", "还书时间", "备注", "是否归还" };
	JLabel l_name, l_bookname;
	JTextField t_name, t_bookname;
	JTable table;
	Container container;
	JButton b_enter, b_back;
	JProgressBar p_bar;
	JPanel pan1, pan2, pan3;
	String a1, a2;
	NetConn sql;
	Statement sqll;
	ResultSet rs;

	Borlistbookfrm() {
		// 界面布局
		super("借书列表");
		l_name = new JLabel("用户：");
		l_bookname = new JLabel("书名：");
		t_name = new JTextField("", 10);
		t_bookname = new JTextField("", 10);
		a = new Object[30][6];
		table = new JTable(a, colname);
		setSize(300, 300);
		setVisible(true);
		b_enter = new JButton("确定");
		b_back = new JButton("返回");

		b_enter.addActionListener(this);
		b_back.addActionListener(this);
		pan1 = new JPanel();
		pan2 = new JPanel();
		pan3 = new JPanel();
		pan1.add(l_name);
		pan1.add(t_name);
		pan1.add(l_bookname);
		pan1.add(t_bookname);
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
		setBounds(230, 150, 650, 350);

	}

	public void actionPerformed(ActionEvent eb) {

		// 单击返回按钮的事件处理程序
		if (eb.getSource() == b_back) {

			dispose();

		}

		// 单击确定按钮的事件处理程序
		if (eb.getSource() == b_enter) {

			try {

				int i = 0;

				sqll = sql.connect();
				// 获取借阅者的名称和借阅图书的名字
				a1 = "'" + "%" + t_name.getText().trim() + "%" + "'";

				a2 = "'" + "%" + t_bookname.getText().trim() + "%" + "'";

				// 根据借阅者名称和借阅图书的名字进行查询
				String temp = "select * from bookbrowse" + " where username like " + a1 + " and bookname like " + a2;
				rs = sqll.executeQuery(temp);
				// 将结果集中的记录显示
				while (rs.next()) {

					a[i][0] = rs.getString(1);
					a[i][1] = rs.getString(2);
					a[i][2] = rs.getDate(3);
					a[i][3] = rs.getDate(4);
					a[i][4] = rs.getString(5);
					a[i][5] = rs.getString(6);
					i++;
					p_bar.setValue(i);
					p_bar.setString("查询了" + i + "条记录");

				}

			} catch (SQLException ed) {

				System.out.print(ed);

			}
			t_name.setText("");
			t_bookname.setText("");
		}
		// 单击清除按钮的事件处理程序

	}

}

