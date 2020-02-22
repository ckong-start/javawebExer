package com.lib;

//用户信息修改

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

class Mdiuser extends Dialog implements ActionListener {

	JLabel l_addname, l_fenge, l_name, l_pass, l_enter, l_unit;
	JTextField t_mname;
	Choice c_munit;
	JPasswordField t_mpass, t_menter;
	JButton b_mdiname, b_cancle;
	JPanel pan1, pan2, pan3, pan4, pan5, pan6, pan7;

	NetConn sql;
	Statement sqll;
	ResultSet rs;
	String a1, a2, a3, a4, a5;

	Mdiuser(Frame f, String s) {

		// 界面布局
		super(f, s);
		l_addname = new JLabel("修改用户信息        ");
		l_fenge = new JLabel("______________________________");
		l_name = new JLabel("名字：");
		l_pass = new JLabel("原密：");
		l_enter = new JLabel("新密：");
		l_unit = new JLabel("权限：");
		t_mname = new JTextField("", 10);
		t_mpass = new JPasswordField("", 10);
		t_menter = new JPasswordField("", 10);
		t_menter.setEchoChar('*');
		c_munit = new Choice();
		c_munit.add("1");
		c_munit.add("2");
		c_munit.add("3");
		b_mdiname = new JButton("修改");
		b_mdiname.addActionListener(this);
		b_cancle = new JButton("返回");
		b_cancle.addActionListener(this);
		pan1 = new JPanel();
		pan2 = new JPanel();
		pan3 = new JPanel();
		pan4 = new JPanel();
		pan5 = new JPanel();
		pan6 = new JPanel();
		pan7 = new JPanel();
		pan1.add(l_addname);
		pan2.add(l_fenge);
		pan2.add(l_name);
		pan2.add(t_mname);
		pan3.add(l_pass);
		pan3.add(t_mpass);
		pan4.add(l_enter);
		pan4.add(t_menter);
		pan5.add(b_mdiname);
		pan5.add(b_cancle);
		pan6.add(l_fenge);
		pan7.add(l_unit);
		pan7.add(c_munit);
		// 建立数据库连接
		sql = new NetConn();

		setLayout(new GridLayout(7, 1));
		add(pan1);
		add(pan6);
		add(pan2);
		add(pan3);
		add(pan4);
		add(pan7);
		add(pan5);
		setBounds(450, 150, 250, 300);

	}

	public void actionPerformed(ActionEvent e) {

		// 单击放弃按钮的事件处理程序
		if (e.getSource() == b_cancle) {
			t_mname.setText("");
			t_mpass.setText("");
			t_menter.setText("");
			dispose();

		}
		// 单击修改按钮的事件处理程序
		else if (e.getSource() == b_mdiname) {

			try {

				sqll = sql.connect();
				// 通过用户姓名从数据库中查找记录
				rs = sqll.executeQuery("SELECT * FROM users where username=" + "'" + t_mname.getText() + "'");
				// 遍历查找到的记录集
				while (rs.next()) {

					a2 = rs.getString(2);
					// 匹配记录中的密码和用户输入的密码
					if (t_mpass.getText().equals(a2)) {

						a3 = "'" + t_mname.getText().trim() + "'";
						a4 = "'" + t_menter.getText().trim() + "'";
						a5 = "'" + c_munit.getSelectedItem().trim() + "'";
						// 根据用户输入的信息，更新记录
						String tem = "UPDATE users SET password=" + a4 + ",unit=" + a5 + " WHERE username=" + a3;
						sqll.executeUpdate(tem);
						l_addname.setText("用户修改成功");

					} else {

						l_addname.setText("用户名或密码错误！");

					}

				}

			} catch (SQLException e2) {

			}

		}

	}

}
