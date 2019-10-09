package cn.com.clearlight.question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Log extends JFrame implements ActionListener,ItemListener{
	JPanel p1=null;
	JPanel p2=null;
	JLabel userName=new JLabel("�û�:");
	JTextField txtUser=new JTextField();
	JLabel password=new JLabel("���룺");
	JPasswordField txtPwd=new JPasswordField(6);
	JLabel role=new JLabel("��ɫ:");
	JComboBox cbrole=new JComboBox();
	JButton btnLogin=new JButton("��¼");
	JButton btnCancel=new JButton("ȡ��");
	//JLabel imageLabel;
	//Icon image;
	static int OK=1;
	static int Cancel=0;
	int actionCode=0;
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	int qxian=0;
	public Log() {
		super("��¼����");
		p1=new JPanel();
		p2=new JPanel();
		cbrole.addItem("����Ա");
		this.setLayout(new FlowLayout());
		this.setBounds(100,100,246,345);
		p1.setLayout(new GridLayout(4,2));
		p1.add(userName);
		p1.add(txtUser);
		p1.add(password);
		p1.add(txtPwd);
		p1.add(role);
		p1.add(cbrole);
		p2.add(btnLogin);
		p2.add(btnCancel);
		this.add(p1);
		this.add(p2);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.show();
		btnLogin.addActionListener(this);
		cbrole.addItem(this);
		btnCancel.addActionListener(this);
		
	}
	
		
	
	public void connDB() {
		try {
			Class.forName("com.mircrosoft.sqlserver.jdbc.SQLServerDriver");
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
	public void closeDB()
	{
		try{
			stmt.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void itemStateChanged(ItemEvent e){
		if(e.getStateChange()==ItemEvent.SELECTED){
			JComboBox jcb=(JComboBox)e.getSource();
			qxian=jcb.getSelectedIndex();
		}
	}
	public void actionPerformed(ActionEvent e){
		Object source=e.getSource();
		String un=null;
		String pw=null;
		boolean success=false;
		if(source==btnLogin){
			if(txtUser.getText().equals("")||txtPwd.getText().equals("")){
				JOptionPane.showMessageDialog(null, "��½�������벻��Ϊ�գ�");
			}else{
				this.connDB();
				try{
					rs=stmt.executeQuery("select*from unpw where qx="+qxian);
					while(rs.next()){
						un=rs.getString("un").trim();
						pw=rs.getString("pw").trim();
						if(txtUser.getText().equals(un)){
							if(txtPwd.getText().equals(pw)){
								actionCode=OK;
								this.setVisible(false);
								new ManagerFrane();
								success=true;
								break;
								
							}else{
								JOptionPane.showMessageDialog(null,"�������");
								txtPwd.setText("");
								success=true;
							}
						}
					}
					if(!success){
						JOptionPane.showMessageDialog(null,"��¼������");
						txtUser.setText("");
						txtPwd.setText("");
						
					}
				}catch(SQLException e1){
					e1.printStackTrace();
				}
			}
		}else if(source==btnCancel){
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new Log();
	}
	


	}
	
	

