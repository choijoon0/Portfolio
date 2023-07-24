package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import model.FeMyPageDAO;
import model.rec.FeMyPageVO;

public class FeMyPageView extends JPanel implements ActionListener{
	JLabel lblMyTitle;

	JPanel pMyInfoList;
	JScrollPane spMyInfoList;
	FeMyInfoListTableModel tmFeMyInfoList;
	JTable tableFeMyInfoList;
	JLabel lblCheckPw, lblChPw;
	JTextField tfCheckPw, tfChPw;
	JButton btnChpw;
	FeMyPageDAO dao = null;
	FeMyPageVO vo = null;
	ArrayList list = null;
	int memcode;

	 
	 
	public FeMyPageView(FestMainView festMainView, int pk) {
		setBackground(new Color(255, 255, 255));
		setLocationRelativeTo(null);
		newObject();
		addLayout();
		eventProc(pk);
		memcode = pk;
		
		try {
			dao = new FeMyPageDAO();
			selectMyInfo(pk);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void setLocationRelativeTo(Object object) {   //**************setLocationRelativeTo(null);하려고
		// TODO Auto-generated method stub
		
	}

	void newObject() {
		lblMyTitle = new JLabel("내 정보");
		
		pMyInfoList = new JPanel();
		spMyInfoList = new JScrollPane();
		tmFeMyInfoList = new FeMyInfoListTableModel();
		tableFeMyInfoList = new JTable(tmFeMyInfoList);
		
		lblCheckPw = new JLabel("PW:");
		tfCheckPw = new JTextField();
		lblChPw = new JLabel("PW 변경:");
		tfChPw = new JTextField();
		btnChpw = new JButton("PW 변경");
		
	}
	
	void addLayout() {
		setLayout(null);
		lblMyTitle.setFont(new Font("양재튼튼체B", Font.BOLD, 25));
		lblMyTitle.setBounds(96, 61, 138, 37);
		add(lblMyTitle);
		
		pMyInfoList.setBounds(96, 127, 687, 209);
		add(pMyInfoList);
		pMyInfoList.setLayout(null);
		
		spMyInfoList.setBounds(0, 0, 687, 209);
		pMyInfoList.add(spMyInfoList);
		
		spMyInfoList.setViewportView(tableFeMyInfoList);
		
		lblCheckPw.setBounds(308, 370, 34, 30);
		lblCheckPw.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));
		add(lblCheckPw);
		
		tfCheckPw.setBounds(354, 372, 199, 30);
		tfCheckPw.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));
		add(tfCheckPw);
		tfCheckPw.setColumns(10);
		
		lblChPw.setBounds(272, 436, 70, 30);
		lblChPw.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));
		add(lblChPw);
		
		tfChPw.setBounds(354, 438, 199, 30);
		tfChPw.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));
		tfChPw.setBackground(Color.white);
		add(tfChPw);
		tfChPw.setColumns(10);
		
		btnChpw.setBounds(594, 438, 97, 30);
		btnChpw.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));
		btnChpw.setBackground(Color.white);
		add(btnChpw);
	}
	
	void eventProc(int pk) {
		btnChpw.addActionListener(this);
		tableFeMyInfoList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent v) {
				try {
					String memPw = dao.checkPw(pk);
					tfCheckPw.setText(memPw);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		// TODO Auto-generated method stub
		Object o = ev.getSource();
		if(o == btnChpw) {
			String pw = tfChPw.getText();
			vo = new FeMyPageVO(pw);
			try {
				dao.ModMyPass(vo, memcode);
				JOptionPane.showMessageDialog(null, "수정 성공!!");
				selectMyInfo(memcode);
				clearScreen();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	void selectMyInfo(int pk) {
		try {
			list = dao.MyInfoList(pk);
			tmFeMyInfoList.data = list;
			tableFeMyInfoList.setModel(tmFeMyInfoList);
			tmFeMyInfoList.fireTableDataChanged();
		}catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "리스트 출력 실패 : " + e.getMessage());
		}
	}
	void clearScreen() {
		tfCheckPw.setText("");
		tfChPw.setText("");
	}
}

class FeMyInfoListTableModel extends AbstractTableModel {
	ArrayList data = new ArrayList();
	String[] columnNames = {"회원코드명", "회원명", "전화번호", "ID", "PW", "내 축제개수"};
	
	public int getColumnCount() {
		return columnNames.length;
	}
	
	public int getRowCount() {
		return data.size();
	}
	
	public Object getValueAt(int row, int col) {
		ArrayList temp = (ArrayList) data.get(row);
		return temp.get(col);
	}
	
	public String getColumnName(int col) {
		return columnNames[col];
	}
}

