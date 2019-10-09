package cn.com.clearlight.question;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
public class CM extends JFrame implements ActionListener{
	JPanel p=new JPanel();
	JButton btnAdd=new JButton("����");
	JButton btnDelete=new JButton("ɾ��");
	JButton btnAlter=new JButton("�޸�");
	JButton btnSearch=new JButton("��ѯ");
	JButton btnDisplay=new JButton("��ʾ");
	JMenuBar mb=new JMenuBar();
	JPanel p1=new JPanel();
	JTable sTable;
	JScrollPane scroll;
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	Object[][]playerInfo;
	CSelect cst;
	String mkch=null;
	boolean bstd=false;
	CM(String title){
		super(title);
		add("South",p);
		this.add("Center",p1);
		mb.add(btnAdd);
		mb.add(btnDelete);
		mb.add(btnAlter);
		mb.add(btnSearch);
		mb.add(btnDisplay);
		this.connDB();
		this.setBounds(200,200,400,260);
		btnAdd.addActionListener(this);
		btnDelete.addActionListener(this);
		btnAlter.addActionListener(this);
		btnSearch.addActionListener(this);
		btnDisplay.addActionListener(this);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		show();
	}
	CM(CSelect cst,String title){
		super(title);
		this.cst=cst;
		bstd=true;
		add("South",p);
		this.add("Center",p1);
		mb.add(btnAdd);
		mb.add(btnDelete);
		mb.add(btnAlter);
		mb.add(btnSearch);
		mb.add(btnDisplay);
		this.connDB();
		this.setBounds(200,200,400,260);
		btnAdd.addActionListener(this);
		btnDelete.addActionListener(this);
		btnAlter.addActionListener(this);
		btnSearch.addActionListener(this);
		btnDisplay.addActionListener(this);
		this.setJMenuBar(mb);
		this.setResizable(false);
		show();
		
		
	}
	public void display() {
		int i=0;
		int j=0;
		int k=0;
		List al=new ArrayList();
		try {
			rs=stmt.executeQuery("select*from c");
			while(rs.next()) {
				al.add(rs.getShort("cno"));
				al.add(rs.getShort("cn"));
				al.add(rs.getShort("cre"));
				i++;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		playerInfo=new Object[i][3];
		String[] columnNames= {"�γ̺�","�γ���","ѧ��"};
		try {
			rs=stmt.executeQuery("select*from c order by cno");
			while(rs.next()) {
				playerInfo[j][0]=rs.getString("cno");
				playerInfo[j][1]=rs.getString("cn");
				playerInfo[j][2]=rs.getString("cre");
				j++;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		sTable=new JTable(playerInfo,columnNames);
		p1.add(sTable);
		scroll=new JScrollPane(sTable);
		this.add(scroll);
	}
	public void connDB() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection("com.mircrosoft.sqlserver.jdbc.SQLServerDriver","sa","123");
			stmt=con.createStatement();
		}catch(SQLException e) {
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
	public void delete() {
		String kch=null;
		String kcm=null;
		String xxkch=null;
		int row=-1;
		row=sTable.getSelectedRow();
		if(row==-1) {
			JOptionPane.showMessageDialog(null,"��ѡ��Ҫɾ���ļ�¼");
		}else {
			if(!bstd) {
				int j1=0;
				try {
					rs=stmt.executeQuery("select*from c");
					while(rs.next()&&j1<=row) {
						kch=rs.getString("cno");
						kcm=rs.getString("cn");
						xxkch=rs.getString("cre");
						j1++;
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
				int i1=0;
				try {
					int rs1=stmt.executeUpdate("delete from c where cno='"+kch+"'");
					JOptionPane.showMessageDialog(null,"��¼ɾ���ɹ�");
					this.dispose();
					new CM("�γ���Ϣ����").display();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}else {
				try {
					int rs1=stmt.executeUpdate("delete from c where cno='"+mkch+"'");
					JOptionPane.showMessageDialog(null, "��¼ɾ���ɹ�");
					this.dispose();
					new CM("�γ���Ϣ����").display();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void update() {
		String kch=null;
		String kcm=null;
		String xxkch=null;
		int row=-1;
		row=sTable.getSelectedRow();
		if(row==-1) {
			JOptionPane.showMessageDialog(null,"��ѡ��Ҫ�޸ĵļ�¼");
		}else {
			int j1=0;
			try {
				if(!bstd) {
					rs=stmt.executeQuery("select*from c");
				}else {
					rs=stmt.executeQuery("select*from c where cno='"+mkch+"'");
				}
				while(rs.next()&&j1<=row){
					kch=rs.getString("cno");
					kcm=rs.getString("cn");
					xxkch=rs.getString("cre");
					j1++;
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			CAdd cadd=new CAdd();
			cadd.setTitle("�޸�");
			cadd.tcno.setText(kch);
			cadd.tcname.setText(kcm);
			cadd.tcre.setText(xxkch);
			cadd.tcno.setEnable(false);
			this.dispose();
		}
	}
	public void select(){
		mkch=cst.kch;
		playerInfo=new Object[1][3];
		String[] columnNames={"�γ̺�","�γ���","ѧ��"};
		try{
			rs=stmt.executeQuery("select*from c where cno='"+mkch+"'");
			while(rs.next()){
				playerInfo[0][0]=rs.getString("cno");
				playerInfo[0][1]=rs.getString("cn");
				playerInfo[0][2]=rs.getString("cre");
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		if(playerInfo[0][1]==null){
			this.dispose();
			JOptionPane.showMessageDialog(null, "�γ̺Ų�����");
			new CM("�γ���Ϣ����").display();
		}else{
			sTable=new JTable(playerInfo,columnNames);
			p1.add(sTable);
			scroll=new JScrollPane(sTable);
			this.add(scroll);
		}
	}
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand()=="����"){
			new CAdd();
			this.dispose();
		}
		if(e.getActionCommand()=="ɾ��"){
			this.delete();
		}
		if(e.getActionCommand()=="�޸�"){
			this.update();
		}
		if(e.getActionCommand()=="��ѯ"){
			cst=new CSelect();
			this.dispose();
		}
		if(e.getActionCommand()=="��ʾ"){
			this.dispose();
			new CM("�γ���Ϣ����").display();
		}
	}
	

}
