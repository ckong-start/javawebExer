package com.lib;

import java.awt.*;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.JFrame;

public class Addbookfrm extends JFrame implements ActionListener {
	JLabel l_msg, l_bookname, l_company, l_author, l_pdata, l_price, l_number, l_memo, l_idd;
	JTextField t_bookname, t_company, t_author, t_pdata, t_price, t_number, t_memo, t_idd;
	JButton b_clear, b_add, b_back;
	JPanel pan0, pan1, pan2, pan3, pan4, pan5, pan6, pan7, pan8, pan9;
	NetConn sql;
	Statement sqll;
	String a1, a2, a3, a4, a5, a6, a7, a8;

	Addbookfrm() {
		// 界面布局
		super("添加书籍窗口");
		l_msg = new JLabel("输入添加的书籍        ");
		l_idd = new JLabel("输入 i d：   ");
		l_bookname = new JLabel("书　名：　 ");
		l_company = new JLabel("出版社：　");
		l_author = new JLabel("作  者：  ");
		l_pdata = new JLabel("出版日期：");
		l_price = new JLabel("价　　格：");
		l_number = new JLabel("新书数量：");
		l_memo = new JLabel("备　　注：");
		t_idd = new JTextField("", 10);
		t_bookname = new JTextField("", 10);
		t_company = new JTextField("", 10);
		t_author = new JTextField("", 10);
		t_pdata = new JTextField("", 10);
		t_price = new JTextField("", 10);
		t_number = new JTextField("", 10);
		t_memo = new JTextField("", 10);
		b_add = new JButton("添加");
		b_clear = new JButton("清空");
		b_back = new JButton("返回");
		b_add.addActionListener(this);
		b_clear.addActionListener(this);
		b_back.addActionListener(this);
		pan0 = new JPanel();
		pan1 = new JPanel();
		pan2 = new JPanel();
		pan3 = new JPanel();
		pan4 = new JPanel();
		pan5 = new JPanel();
		pan6 = new JPanel();
		pan7 = new JPanel();
		pan8 = new JPanel();
		pan9 = new JPanel();
		pan0.add(l_msg);
		pan1.add(l_idd);
		pan1.add(t_idd);
		pan2.add(l_bookname);
		pan2.add(t_bookname);
		pan3.add(l_company);
		pan3.add(t_company);
		pan4.add(l_author);
		pan4.add(t_author);
		pan5.add(l_pdata);
		pan5.add(t_pdata);
		pan6.add(l_price);
		pan6.add(t_price);
		pan7.add(l_number);
		pan7.add(t_number);
		pan8.add(l_memo);
		pan8.add(t_memo);
		pan9.add(b_add);
		pan9.add(b_clear);
		pan9.add(b_back);
		setLayout(new GridLayout(10, 1));
		add(pan0);
		add(pan1);
		add(pan2);
		add(pan3);
		add(pan4);
		add(pan5);
		add(pan6);
		add(pan7);
		add(pan8);
		add(pan9);
		// 建立数据库连接
		sql = new NetConn();
		// 设置窗体大小
		setBounds(350, 150, 400, 500);

	}

	public void actionPerformed(ActionEvent ec) {

		// 单击退出按钮的事件处理程序
		if (ec.getSource() == b_back) {

			dispose();

		}
		// 单击清空按钮的事件处理程序
		else if (ec.getSource() == b_clear) {
			t_idd.setText("");
			t_bookname.setText("");
			t_company.setText("");
			t_author.setText("");
			t_pdata.setText("");
			t_price.setText("");
			t_number.setText("");
			t_memo.setText("");
			l_msg.setText("输入添加的书籍");

		}
		// 单击添加按钮的事件处理程序
		else if (ec.getSource() == b_add) {

			// 如果输入项有为空的，则显示提示信息
			if (t_bookname.getText().equals("") || t_company.getText().equals("") || t_author.getText().equals("")) {

				l_msg.setText("书名，出版社和作者不能为空！");

			} else {

				try {

					sqll = sql.connect();
					a1 = "'" + t_bookname.getText().trim() + "'";
					a2 = "'" + t_company.getText().trim() + "'";
					a3 = "'" + t_author.getText().trim() + "'";
					a4 = "'" + t_pdata.getText().trim() + "'";
					a5 = "'" + t_price.getText().trim() + "'";
					a6 = "'" + t_number.getText().trim() + "'";
					a7 = "'" + t_memo.getText().trim() + "'";
					a8 = "'" + t_idd.getText().trim() + "'";
					l_msg.setText("1");
					// 向数据库中插入记录
					String temp = "insert into books  (bookname, company, author, pressdata, price, conun, memo, bookid) "
							+ "VALUES (" + a1 + "," + a2 + "," + a3 + "," + a4 + "," + a5 + "," + a6 + "," + a7 + ","
							+ a8 + ")";
					sqll.executeUpdate(temp);
					l_msg.setText("书籍添加成功");

				} catch (SQLException e3) {

				}

			}

		}

	}

}