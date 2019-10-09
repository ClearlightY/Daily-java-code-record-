package cn.com.clearlight.question;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.sql.*;
public class CAdd extends JFrame implements ActionListener {
	JLabel lcno=new JLabel("�γ̺ţ�");
	JLabel lcname=new JLabel("�γ�����");
	JLabel lcredit=new JLabel("ѧ�֣�");
	JTextField tcno=new JTextField(10);
	JTextField tcname=new JTextField(10);
	JTextField tcredit=new JTextField(10);
	JButton btnOK=new JButton("ȷ��");
	JButton btnCancel=new JButton("ȡ��");
	JPanel p=new JPanel();
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	boolean isNewsm=true;
	public CAdd() {
		this.setTitle("����");
		this.setBounds(200,200,146,235);
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		p.add(lcno);
		p.add(tcno);
		p.add(lcname);
		p.add(tcname);
		p.add(lcredit);
		p.add(tcredit);
		p.add(btnOK);
		p.add(btnCancel);
		this.add(p);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnOK.addActionListener(this);
		btnCancel.addActionListener(this);
		this.show();
		
	}
	public void connDB() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		 try {

	          Connection con = DriverManager.getConnection("com.mircrosoft.sqlserver.jdbc.SQLServerDriver","sa","123");
	          stmt = con.createStatement();
			}catch(SQLException e){
				e.printStackTrace();
			}
	}
	public void closeDB() {
		try {
			stmt.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void insertst() {
		String kch=null;
		String kcm=null;
		String xxkch=null;
		kch=tcno.getText();
		kcm=tcname.getText();
		xxkch=tcredit.getText();
		if(this.getTitle()=="�޸�") {
			try {
				this.connDB();
				int rsl=stmt.executeUpdate("delete from c where cno='"+kch+"'");
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		String str="insert into c values('"+kch+"','"+kcm+xxkch+"')";
		this.connDB();
		try {
			stmt.executeUpdate(str);
			JOptionPane.showMessageDialog(null, this.getTitle()+"�ɹ���","��ʾ",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("menu4.gif"));
			this.setVisible(false);
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "�γ̺��Ѵ��ڣ�");
			tcno.setText("");
		}
	}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand()=="ȷ��") {
				this.insertst();
				if(isNewsm) {
					new CM("�γ���Ϣ����").display();
				}
				isNewsm=true;
			}
			if(e.getActionCommand()=="ȡ��") {
				this.setVisible(false);
				new CM("�γ���Ϣ����").display();
				
			}
		}
	

}
