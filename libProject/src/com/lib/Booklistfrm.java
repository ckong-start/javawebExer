package com.lib;

//图书列表

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Booklistfrm extends JFrame implements ActionListener {
	Object a[][];
	Object colname[] = { "图书id", "书名", "出版社", "作者", "出版日期", "价格", "新书数量", "备注" };
	JLabel l_name, l_author, l_company;
	JTextField t_name, t_author, t_company;
	JTable table;
	Container container;
	JButton b_enter, b_back;
	JProgressBar p_bar;
	JPanel pan1;
	String a1, a2, a3;
	NetConn sql;
	Statement sqll;
	ResultSet rs;

	Booklistfrm() {
		// 界面布局
		super("书籍列表");
		l_name = new JLabel("名称：");
		l_author = new JLabel("作者：");
		l_company = new JLabel("出版社：");
		t_name = new JTextField("", 10);
		t_author = new JTextField("", 10);
		t_company = new JTextField("", 10);
		a = new Object[30][8];
		table = new JTable(a, colname);
		setSize(300, 300);
		setVisible(true);
		b_enter = new JButton("确定");
		b_back = new JButton("返回");
		b_enter.addActionListener(this);
		b_back.addActionListener(this);
		b_enter.addActionListener(this);
		b_back.addActionListener(this);
		pan1 = new JPanel();
		pan1.add(l_name);
		pan1.add(t_name);
		pan1.add(l_author);
		pan1.add(t_author);
		pan1.add(l_company);
		pan1.add(t_company);
		pan1.add(b_enter);
		pan1.add(b_back);
		p_bar = new JProgressBar(JProgressBar.VERTICAL, 0, 50);
		p_bar.setStringPainted(true);
		container = getContentPane();
		container.add(pan1, BorderLayout.SOUTH);
		container.add(new JScrollPane(table), BorderLayout.CENTER);
		container.add(p_bar, BorderLayout.WEST);
		sql = new NetConn();
		setBounds(230, 150, 650, 350);

	}

	public void actionPerformed(ActionEvent eb) {

		// 单击退出按钮的事件处理程序
		if (eb.getSource() == b_back) {

			dispose();

		}
		// 单击确定按钮的事件处理程序
		else if (eb.getSource() == b_enter) {

			try {

				int i = 0;
				sqll = sql.connect();
				a1 = "'" + "%" + t_name.getText().trim() + "%" + "'";
				a2 = "'" + "%" + t_author.getText().trim() + "%" + "'";
				a3 = "'" + "%" + t_company.getText().trim() + "%" + "'";
				// 根据跟定条件，进行查询
				String temp = "select * from books" + " where bookname like " + a1 + " and company like " + a3
						+ " and author like " + a2;
				rs = sqll.executeQuery(temp);
				// 显示符合要求的所有图书信息
				while (rs.next()) {

					a[i][0] = rs.getString(8);
					a[i][1] = rs.getString(1);
					a[i][2] = rs.getString(2);
					a[i][3] = rs.getString(3);
					a[i][4] = rs.getDate(4);
					a[i][5] = rs.getString(5);
					a[i][6] = rs.getString(6);
					a[i][7] = rs.getString(7);
					i++;
					p_bar.setValue(i);
					;
					p_bar.setString("查询了" + i + "条记录");

				}

			} catch (SQLException ed) {

				System.out.println(ed);

			}
			t_name.setText("");
			t_author.setText("");
			t_company.setText("");
		}

	}

}