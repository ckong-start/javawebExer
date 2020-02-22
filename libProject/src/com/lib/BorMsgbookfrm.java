package com.lib;

//借书信息查询

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class BorMsgbookfrm extends JFrame implements ActionListener {
	JLabel l_msg, l_user, l_bookname, l_data, l_memo;
	JTextField t_user, t_bookname, t_data, t_memo;
	JButton b_enter, b_clear, b_update, b_back;
	JPanel pan1, pan2, pan3, pan4, pan5, pan6, pan7;
	String a2, a3, a4, a5;
	NetConn sql;
	Statement sqll;
	ResultSet rs;

	BorMsgbookfrm() {
		// 界面布局
		l_msg = new JLabel("借书信息修改窗口 ");
		l_user = new JLabel("借阅者：");

		l_bookname = new JLabel("书  名：");
		l_data = new JLabel("日  期：");
		l_memo = new JLabel("备  注：");
		t_user = new JTextField("", 10);

		t_bookname = new JTextField("", 10);
		t_data = new JTextField("", 10);
		t_memo = new JTextField("", 10);
		b_enter = new JButton("确定");
		b_clear = new JButton("清除");
		b_update = new JButton("更新");
		b_back = new JButton("返回");
		b_enter.addActionListener(this);
		b_clear.addActionListener(this);
		b_update.addActionListener(this);
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
		pan6.add(b_update);
		pan6.add(b_clear);
		pan6.add(b_back);
		pan2.add(b_enter);
		setLayout(new GridLayout(6, 1));
		add(pan1);
		add(pan2);
		add(pan3);
		add(pan4);
		add(pan5);
		add(pan6);
		// 建立数据库连接
		sql = new NetConn();
		setBounds(400, 100, 400, 500);

	}

	public void actionPerformed(ActionEvent ed) {

		// 单击返回按钮的事件处理程序
		if (ed.getSource() == b_back) {

			this.dispose();

		}
		// 单击清除按钮的事件处理程序
		else if (ed.getSource() == b_clear) {

			t_user.setText("");
			t_memo.setText("");
			t_bookname.setText("");
			t_data.setText("");
			l_msg.setText("借书信息修改窗口 ");

		}
		// 单击确定按钮的事件处理程序
		else if (ed.getSource() == b_enter) {
			if (t_user.getText().equals("")) {
				l_msg.setText("用户不能为空");
			} else {

				try {

					sqll = sql.connect();
					// 查询借阅用户的信息
					rs = sqll.executeQuery("SELECT * FROM bookbrowse where username=" + "'" + t_user.getText() + "'");
					while (rs.next()) {

						t_user.setText(rs.getString(1));
						t_bookname.setText(rs.getString(2));
						t_data.setText(rs.getString(3));
						t_memo.setText(rs.getString(5));
						l_msg.setText("查询信息成功");

					}

				} catch (SQLException e2) {

				}

			}
		}
		// 单击更新按钮的事件处理程序
		if (ed.getSource() == b_update) {

			try {

				sqll = sql.connect();
				a2 = "'" + t_memo.getText().trim() + "'";
				a3 = "'" + t_user.getText().trim() + "'";
				a4 = "'" + t_bookname.getText().trim() + "'";
				a5 = "'" + t_data.getText().trim() + "'";
				// 更新数据库中的借阅信息
				String tem = "UPDATE bookbrowse SET username=" + a3 + ",bookname=" + a4 + ",borrowdata=" + a5
						+ ",beizhu=" + a2 + " WHERE studentname=" + a3;
				sqll.executeUpdate(tem);
				l_msg.setText("借阅信息修改成功");

			} catch (SQLException dd) {

			}

		}

	}

}


