package com.lib;

//关于界面

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Readme extends JFrame implements ActionListener {

	JLabel l_ver, l_lib;

	Readme() {

		super("版本");
		Font myfont = new Font("楷体_GB2312", Font.BOLD, 60);
		l_ver = new JLabel("                                                           -ver1.0-");
		l_lib = new JLabel("欢迎进入图书管理系统");
		l_lib.setFont(myfont);
		add(l_lib);
		add(l_ver);
		setBounds(350, 150, 400, 300);

	}

	public void actionPerformed(ActionEvent e) {

	}

}
