package com.lib;

//删除图书

import java.util.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class Delbookfrm extends JFrame implements ActionListener {
	JLabel l_info;
	JTextField t_bookname;
	JButton b_delbook, b_back;
	JPanel pan1, pan2, pan3;

	NetConn sql;
	Statement sqll;

	Delbookfrm() {

		// 界面布局
		l_info = new JLabel("输入你要删除的书籍的名称：");
		t_bookname = new JTextField("", 10);
		b_delbook = new JButton("删除");
		b_back = new JButton("返回");
		b_delbook.addActionListener(this);
		b_back.addActionListener(this);
		pan1 = new JPanel();
		pan2 = new JPanel();
		pan3 = new JPanel();
		pan1.add(l_info);
		pan2.add(t_bookname);
		pan3.add(b_delbook);
		pan3.add(b_back);
		setLayout(new GridLayout(3, 1));
		add(pan1);
		add(pan2);
		add(pan3);
		setBounds(400, 300, 300, 350);
		// 建立数据库连接
		sql = new NetConn();

	}

	public void actionPerformed(ActionEvent ed) {

		// 单击删除按钮的事件处理程序
		if (ed.getSource() == b_delbook) {

			try {

				sqll = sql.connect();
				// 根据给定图书信息将其从数据库中删除
				sqll.executeUpdate("delete from books where bookname=" + "'" + t_bookname.getText() + "'");
				l_info.setText("书籍删除成功");
				t_bookname.setText("");

			} catch (SQLException e6) {

			}

		} else if (ed.getSource() == b_back) {

			dispose();

		}

	}

}
