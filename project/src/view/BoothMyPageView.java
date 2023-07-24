package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import model.BoothMyPageDAO;
import model.rec.BoothMyPageVO;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class BoothMyPageView extends JPanel implements ActionListener{
	JLabel lblMyTitle;
	JPanel pBthMyInfoList;
	JScrollPane spBthMyInfoList;
	MyBthInfoListTableModel tmMyBthInfoList;
	JTable tableBthMyInfoList;
	JLabel lblCheckPw, lblChPw;
	JTextField tfCheckPw, tfChPw;
	JButton btnChPw;
	BoothMyPageDAO dao = null;
	BoothMyPageVO vo = null;
	ArrayList list = new ArrayList();
	int memcode;
	 
	public BoothMyPageView(BoothMainView boothMyPageView, int pk) {
		setBackground(Color.WHITE);
		setLayout(null);
		newObject();
		addLayout();
		eventProc(pk);
		memcode = pk;
		
		try {
			dao = new BoothMyPageDAO();
			selectMyBthInfo(pk);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	void newObject() {
		lblMyTitle = new JLabel("내 정보");
		
		pBthMyInfoList = new JPanel();
		spBthMyInfoList = new JScrollPane();
		tmMyBthInfoList = new MyBthInfoListTableModel();
		tableBthMyInfoList = new JTable(tmMyBthInfoList);
		tableBthMyInfoList.setFont(new Font("양재인장체M", Font.PLAIN, 12));
		
		lblCheckPw = new JLabel("PW:");
		lblCheckPw.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));
		tfCheckPw = new JTextField();
		tfCheckPw.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));
		lblChPw = new JLabel("PW 변경:");
		lblChPw.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));
		tfChPw = new JTextField();
		tfChPw.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));
		btnChPw = new JButton("PW 변경");
		btnChPw.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));
	}
	
	void addLayout() {
		lblMyTitle.setFont(new Font("양재튼튼체B", Font.BOLD, 20));
		lblMyTitle.setBounds(299, 31, 78, 36);
		add(lblMyTitle);
		
		pBthMyInfoList.setBounds(55, 88, 556, 179);
		add(pBthMyInfoList);
		pBthMyInfoList.setLayout(null);
		
		spBthMyInfoList.setBounds(0, 0, 556, 179);
		pBthMyInfoList.add(spBthMyInfoList);
		
		spBthMyInfoList.setViewportView(tableBthMyInfoList);
		
		lblCheckPw.setBounds(140, 301, 40, 25);
		add(lblCheckPw);
		
		tfCheckPw.setBounds(214, 301, 183, 25);
		add(tfCheckPw);
		tfCheckPw.setColumns(10);
		
		lblChPw.setBounds(108, 348, 78, 25);
		add(lblChPw);
		
		tfChPw.setBounds(214, 348, 183, 25);
		add(tfChPw);
		tfChPw.setColumns(10);
		
		btnChPw.setBounds(469, 350, 97, 25);
		add(btnChPw);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\04-09\\eclipse-workspace\\project\\src\\img\\dddddddgdsgasga.png"));
		lblNewLabel.setBounds(249, 24, 190, 55);
		add(lblNewLabel);
	}
	
	void eventProc(int pk) {
		btnChPw.addActionListener(this);
		tableBthMyInfoList.addMouseListener(new MouseAdapter() {
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
	public void actionPerformed(ActionEvent ee) {
		// TODO Auto-generated method stub
		Object o = ee.getSource();
		if(o == btnChPw) {
			String pw = tfChPw.getText();
			vo = new BoothMyPageVO(pw);
			try {
				dao.ModMyPass(vo, memcode);
				JOptionPane.showMessageDialog(null, "수정 성공!!");
				selectMyBthInfo(memcode);
				clearScreen();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	void selectMyBthInfo(int pk) {
		try {
			list = dao.MyBthInfoList(pk);
			tmMyBthInfoList.data = list;
			tableBthMyInfoList.setModel(tmMyBthInfoList);
			tmMyBthInfoList.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "리스트 출력 실패 : " + e.getMessage());
		}
	}
	
	void clearScreen() {
		tfCheckPw.setText("");
		tfChPw.setText("");
	}
}
class MyBthInfoListTableModel extends AbstractTableModel {
	ArrayList data = new ArrayList();
	String[] columnNames = {"회원코드명", "회원명", "전화번호", "ID", "PW", "내 부스개수"};
	
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