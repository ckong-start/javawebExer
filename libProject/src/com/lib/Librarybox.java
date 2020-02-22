package com.lib;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Librarybox extends JFrame implements ActionListener {

	JLabel mlabel;
	JMenuBar mainmenu;
	static JMenu system, bookse, bookth, bookfo, bookfi, booksex, mi_system_manger;
	JMenuItem mi_system_login, mifi_system_adduser, mifi_system_moduser, mifi_system_deluser, mi_system_exit;
	JMenuItem se_book_addbook, se_book_modifybook, se_book_delbook;
	JMenuItem th_book_borrowmsg, th_book_borrowmsgmodif;
	JMenuItem fo_book_returnmsg, fo_book_returnmsgmodif;
	JMenuItem fi_msglabel_book, fi_msglabel_borrow, fi_msglabel_user;
	JMenuItem sex_edition;

	Loginfrm frml = new Loginfrm(this, "登录窗口");
	Adduser frma = new Adduser(this, "添加用户");
	Mdiuser frmm = new Mdiuser(this, "修改用户");
	Deluser frmd = new Deluser(this, "删除用户");

	Addbookfrm frmab;
	Mdibookfrm frmmb;
	Delbookfrm frmdb;
	Borbookfrm frmbb;
	BorMsgbookfrm frmbmb;
	Booklistfrm frmbl;
	Borlistbookfrm frmblb;
	Userlistfrm frmul;
	ReturnMsgbookfrm frmrmb;
	Returnbookfrm frmrb;
	Readme frmread;

	Librarybox() {

		super("图书管理系统");
		Font myFont = new Font("楷体_GB2312", Font.BOLD, 60);
		mlabel = new JLabel("    欢迎进入图书管理系统");
		mlabel.setFont(myFont);
		add(mlabel);
		mainmenu = new JMenuBar();
		system = new JMenu("系统管理");
		mi_system_login = new JMenuItem("用户登录");
		mi_system_manger = new JMenu("用户管理");
		mifi_system_adduser = new JMenuItem("添加用户");
		mifi_system_moduser = new JMenuItem("修改用户");
		mifi_system_deluser = new JMenuItem("删除用户");
		mi_system_manger.add(mifi_system_adduser);
		mi_system_manger.add(mifi_system_moduser);
		mi_system_manger.add(mifi_system_deluser);
		mi_system_exit = new JMenuItem("退出");
		mi_system_login.addActionListener(this);
		mi_system_exit.addActionListener(this);
		mifi_system_adduser.addActionListener(this);
		mifi_system_moduser.addActionListener(this);
		mifi_system_deluser.addActionListener(this);
		system.add(mi_system_login);
		system.add(mi_system_manger);
		system.addSeparator();
		system.add(mi_system_exit);
		mainmenu.add(system);

		bookse = new JMenu("书籍管理");
		se_book_addbook = new JMenuItem("添加书籍");
		se_book_modifybook = new JMenuItem("修改书籍");
		se_book_delbook = new JMenuItem("删除书籍");
		se_book_addbook.addActionListener(this);
		se_book_modifybook.addActionListener(this);
		se_book_delbook.addActionListener(this);
		bookse.add(se_book_addbook);
		bookse.add(se_book_modifybook);
		bookse.add(se_book_delbook);
		mainmenu.add(bookse);

		bookth = new JMenu("借阅管理");
		th_book_borrowmsg = new JMenuItem("当前出借信息");
		th_book_borrowmsgmodif = new JMenuItem("借出信息修改");
		th_book_borrowmsg.addActionListener(this);
		th_book_borrowmsgmodif.addActionListener(this);
		bookth.add(th_book_borrowmsg);
		bookth.add(th_book_borrowmsgmodif);
		mainmenu.add(bookth);

		bookfo = new JMenu("还书管理");
		fo_book_returnmsg = new JMenuItem("当前还书信息");
		fo_book_returnmsgmodif = new JMenuItem("还书信息修改");
		fo_book_returnmsg.addActionListener(this);
		fo_book_returnmsgmodif.addActionListener(this);
		bookfo.add(fo_book_returnmsg);
		bookfo.add(fo_book_returnmsgmodif);
		mainmenu.add(bookfo);

		bookfi = new JMenu("资料信息");
		fi_msglabel_book = new JMenuItem("书籍列表");
		fi_msglabel_borrow = new JMenuItem("借阅情况表");
		fi_msglabel_user = new JMenuItem("用户列表");
		fi_msglabel_book.addActionListener(this);
		fi_msglabel_borrow.addActionListener(this);
		fi_msglabel_user.addActionListener(this);
		bookfi.add(fi_msglabel_book);
		bookfi.add(fi_msglabel_borrow);
		bookfi.add(fi_msglabel_user);
		mainmenu.add(bookfi);

		booksex = new JMenu("关于");
		sex_edition = new JMenuItem("―版本―");
		sex_edition.addActionListener(this);
		booksex.add(sex_edition);
		mainmenu.add(booksex);

		this.setJMenuBar(mainmenu);

		setBounds(150, 60, 800, 600);
		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand() == "退出") {

			dispose();
			System.exit(0);

		} else if (e.getActionCommand() == "添加用户") {

			frma.setVisible(true);

		} else if (e.getActionCommand() == "用户登录") {

			this.setVisible(false);
			this.dispose();
			frml.setVisible(true);

		} else if (e.getActionCommand() == "修改用户") {

			frmm.setVisible(true);

		} else if (e.getActionCommand() == "删除用户") {

			frmd.setVisible(true);

		} else if (e.getActionCommand() == "添加书籍") {

			frmab = new Addbookfrm();
			frmab.setVisible(true);

		} else if (e.getActionCommand() == "修改书籍") {

			frmmb = new Mdibookfrm();
			frmmb.setVisible(true);

		} else if (e.getActionCommand() == "删除书籍") {

			frmdb = new Delbookfrm();
			frmdb.setVisible(true);

		} else if (e.getActionCommand() == "当前出借信息") {

			frmbb = new Borbookfrm();
			frmbb.setVisible(true);

		} else if (e.getActionCommand() == "借出信息修改") {

			frmbmb = new BorMsgbookfrm();
			frmbmb.setVisible(true);

		} else if (e.getActionCommand() == "当前还书信息") {

			frmrb = new Returnbookfrm();
			frmrb.setVisible(true);

		} else if (e.getActionCommand() == "还书信息修改") {

			frmrmb = new ReturnMsgbookfrm();
			frmrmb.setVisible(true);

		} else if (e.getActionCommand() == "书籍列表") {

			frmbl = new Booklistfrm();
			frmbl.setVisible(true);

		} else if (e.getActionCommand() == "借阅情况表") {

			frmblb = new Borlistbookfrm();
			frmblb.setVisible(true);

		} else if (e.getActionCommand() == "用户列表") {

			frmul = new Userlistfrm();
			frmul.setVisible(true);

		} else if (e.getActionCommand() == " 版 本") {

			frmread = new Readme();
			frmread.setVisible(true);

		}

	}

}
