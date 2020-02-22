package com.lib;

//借书

import java.awt.*;
import java.sql.*;
import java.text.DateFormat;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;

public class Borbookfrm extends JFrame implements ActionListener {
	JLabel l_msg, l_user, l_bookname, l_data, l_memo;
	JTextField t_user, t_bookname, t_data, t_memo;
	JButton b_enter, b_clear, b_back;
	JPanel pan1, pan2, pan3, pan4, pan5, pan6;
	Date d;
	NetConn sql;
	Statement sqll;

	Borbookfrm() {
		// 界面布局
		l_msg = new JLabel("借书窗口    ");
		l_user = new JLabel("借阅者：");
		l_bookname = new JLabel("书  名：");
		l_data = new JLabel("日  期：");
		l_memo = new JLabel("备  注：");
		t_user = new JTextField("", 11);
		t_bookname = new JTextField("", 11);
		t_data = new JTextField("", 11);
		d = new Date();
		t_data.setText(DateFormat.getDateInstance().format(d));
		t_memo = new JTextField("", 11);
		b_enter = new JButton("确定");
		b_clear = new JButton("清除");
		b_back = new JButton("返回");
		b_enter.addActionListener(this);
		b_clear.addActionListener(this);
		b_back.addActionListener(this);
		pan1 = new JPanel();
		pan2 = new JPanel();
		pan3 = new JPanel();
		pan4 = new JPanel();
		pan5 = new JPanel();
		pan6 = new JPanel();
		pan1.add(l_msg);
		pan2.add(l_user);
		pan2.add(t_user);
		pan3.add(l_bookname);
		pan3.add(t_bookname);
		pan4.add(l_data);
		pan4.add(t_data);
		pan5.add(l_memo);
		pan5.add(t_memo);
		pan6.add(b_enter);
		pan6.add(b_clear);
		pan6.add(b_back);
		setLayout(new GridLayout(6, 1));
		add(pan1);
		add(pan2);
		add(pan3);
		add(pan4);
		add(pan5);
		add(pan6);
		// 建立数据库连接
		sql = new NetConn();
		// 设置窗口大小
		setBounds(400, 100, 400, 500);
	}

	public void actionPerformed(ActionEvent ed) {

		// 单击退出按钮的事件处理程序
		if (ed.getSource() == b_back) {

			dispose();

		}
		// 单击清空按钮的事件处理程序
		else if (ed.getSource() == b_clear) {

			t_user.setText("");
			t_memo.setText("");
			t_bookname.setText("");
			l_msg.setText(" 借书窗口");
		}
		// 单击确定按钮的事件处理程序
		else if (ed.getSource() == b_enter) {
			if (t_user.getText().equals("") || t_bookname.getText().equals("")) {
				l_msg.setText(" 借阅者和书名不能为空");
			} else {
				try {

					sqll = sql.connect();
					// 获取用户借阅图书的信息
					String s2 = "'" + t_user.getText().trim() + "'";
					String s3 = "'" + t_bookname.getText().trim() + "'";
					String s4 = "'" + t_data.getText().trim() + "'";
					String s5 = "'" + t_memo.getText().trim() + "'";
					String s6 = "'" + "n" + "'";
					l_msg.setText("1");
					// 将用户借阅信息插入数据库中
					String temp = "INSERT INTO bookbrowse (username, bookname," + "borrowdata, memo, isreturn) VALUES ("
							+ s2 + "," + s3 + "," + s4 + "," + s5 + "," + s6 + ")";
					sqll.executeUpdate(temp);
					l_msg.setText("用户借书成功");
					t_user.setText("");
					t_memo.setText("");
					t_bookname.setText("");

				} catch (SQLException er) {

					System.out.println(er);

				}

			}
		}
	}

}