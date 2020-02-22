package com.lib;

//图书信息修改

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

class Mdibookfrm extends JFrame implements ActionListener {
	JLabel l_msg, l_idd, l_bookname, l_company, l_author, l_pdata, l_price, l_number, l_memo;
	JTextField t_idd, t_bookname, t_company, t_author, t_pdata, t_price, t_number, t_memo;
	JButton b_clear, b_enter, b_update, b_back;
	JPanel pan1, pan2, pan3, pan4, pan5, pan6, pan7, pan8, pan9, pan10;
	NetConn sql;
	Statement sqll;
	ResultSet rs;
	String a1, a2, a3, a4, a5, a6, a7, a8;

	Mdibookfrm() {
		// 界面布局
		super("修改书籍窗口");
		l_msg = new JLabel("修改书籍        ");
		l_idd = new JLabel("输入id修改：");
		l_bookname = new JLabel("书名：      ");
		l_company = new JLabel("出版社：  ");
		l_author = new JLabel("作者：      ");
		l_pdata = new JLabel("出版日期：");
		l_price = new JLabel("价格 ：     ");
		l_number = new JLabel("新书数量：");
		l_memo = new JLabel("备注：      ");
		t_idd = new JTextField("", 10);
		t_bookname = new JTextField("", 10);
		t_company = new JTextField("", 10);
		t_author = new JTextField("", 10);
		t_pdata = new JTextField("", 10);
		t_price = new JTextField("", 10);
		t_number = new JTextField("", 10);
		t_memo = new JTextField("", 10);
		b_clear = new JButton("清空");
		b_enter = new JButton("查询");
		b_update = new JButton("更新");
		b_back = new JButton("返回");
		b_clear.addActionListener(this);
		b_enter.addActionListener(this);
		b_update.addActionListener(this);
		b_back.addActionListener(this);
		pan1 = new JPanel();
		pan2 = new JPanel();
		pan3 = new JPanel();
		pan4 = new JPanel();
		pan5 = new JPanel();
		pan6 = new JPanel();
		pan7 = new JPanel();
		pan8 = new JPanel();
		pan9 = new JPanel();
		pan10 = new JPanel();
		pan1.add(l_msg);
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
		pan9.add(b_update);
		pan9.add(b_clear);
		pan9.add(b_back);
		pan10.add(l_idd);
		pan10.add(t_idd);
		pan10.add(b_enter);
		setLayout(new GridLayout(10, 1));
		add(pan1);
		add(pan10);
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
		// 设置窗口大小
		setBounds(350, 150, 400, 500);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent ef) {
		if (ef.getSource() == b_enter && t_idd.getText().equals("")) {
			l_msg.setText("id输入不能为空！");
		}
		// 单击退出按钮的事件处理程序
		else if (ef.getSource() == b_back) {

			dispose();

		}
		// 单击清除按钮的事件处理程序
		else if (ef.getSource() == b_clear) {
			t_idd.setText("");
			t_bookname.setText("");
			t_company.setText("");
			t_author.setText("");
			t_pdata.setText("");
			t_price.setText("");
			t_number.setText("");
			t_memo.setText("");
			l_msg.setText("修改书籍        ");

		}
		// 单击确定按钮的事件处理程序
		else if (ef.getSource() == b_enter) {

			try {

				sqll = sql.connect();
				// 根据图书Id号，进行查询
				String temp = "SELECT * FROM books where bookid=" + Integer.valueOf(t_idd.getText()).intValue();
				rs = sqll.executeQuery(temp);
				if (rs.next()) {

					t_bookname.setText(rs.getString(1));
					t_company.setText(rs.getString(2));
					t_author.setText(rs.getString(3));
					t_pdata.setText(String.valueOf(rs.getDate(4)));
					t_price.setText(String.valueOf(rs.getInt(5)));
					t_number.setText(String.valueOf(rs.getInt(6)));
					t_memo.setText(rs.getString(7));

					l_msg.setText("找到书籍！");

				} else {

					l_msg.setText("没有找到书籍！");
					t_bookname.setText("");
					t_company.setText("");
					t_author.setText("");
					t_pdata.setText("");
					t_price.setText("");
					t_number.setText("");
					t_memo.setText("");
				}

			} catch (SQLException e3) {

			}

		}

		// 单击更新按钮的事件处理程序
		if (ef.getSource() == b_update) {

			if (t_bookname.getText().equals("") || t_company.getText().equals("") || t_author.getText().equals("")) {

				l_msg.setText("书名，出版社和作者不能为空！");

			}
			// 根据得到的用户输入信息，更新数据库中的记录
			else {

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
					String tem = "update books SET bookname=" + a1 + ", company=" + a2 + ", author=" + a3
							+ ", pressdata=" + a4 + ", price=" + a5 + ", conun=" + a6 + ", memo=" + a7 + "where bookid="
							+ a8;
					sqll.executeUpdate(tem);
					l_msg.setText("书籍修改成功");
				} catch (SQLException e4) {

				}

			}

		}

	}

}