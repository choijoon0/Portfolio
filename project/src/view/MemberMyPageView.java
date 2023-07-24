package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import model.MemberMyPageDAO;
import model.rec.MemberMyPageVO;
import java.awt.Color;

public class MemberMyPageView extends JPanel implements ActionListener {
	JLabel lblMyTitle;
	JPanel pMyInfoList;
	JScrollPane spMyInfoList;
	MyInfoListTableModel tmMyInfoList;
	JTable tableMyInfoList;
	JLabel lblCheckPw, lblChPw;
	JTextField tfCheckPw, tfChPw;
	JButton btnChpw;
	MemberMyPageDAO dao = null;
	MemberMyPageVO vo = null;
	ArrayList list = null;
	int memcode;

	public MemberMyPageView(MemberMainView memberMainView, int pk) {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		newObject();
		addLayout();
		eventProc(pk);
		memcode = pk;

		try {
			dao = new MemberMyPageDAO();
			selectMyInfo(pk);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	void newObject() {
		lblMyTitle = new JLabel("내 정보");

		pMyInfoList = new JPanel();
		spMyInfoList = new JScrollPane();
		tmMyInfoList = new MyInfoListTableModel();
		tableMyInfoList = new JTable(tmMyInfoList);
		tableMyInfoList.setFont(new Font("양재인장체M", Font.PLAIN, 12));

		lblCheckPw = new JLabel("현재 PW:");
		lblCheckPw.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));
		tfCheckPw = new JTextField();

		lblChPw = new JLabel("PW 변경:");
		lblChPw.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));
		tfChPw = new JTextField();
		btnChpw = new JButton("PW 변경");
		btnChpw.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));
	}

	void addLayout() {
		lblMyTitle.setFont(new Font("양재튼튼체B", Font.BOLD, 30));
		lblMyTitle.setBounds(541, 66, 127, 36);
		add(lblMyTitle);

		pMyInfoList.setBounds(212, 150, 742, 263);
		add(pMyInfoList);
		pMyInfoList.setLayout(null);
		spMyInfoList.setBounds(0, 0, 742, 263);
		pMyInfoList.add(spMyInfoList);
		spMyInfoList.setViewportView(tableMyInfoList);

		lblCheckPw.setBounds(350, 464, 71, 36);
		add(lblCheckPw);
		tfCheckPw.setBounds(435, 466, 206, 36);
		add(tfCheckPw);
		tfCheckPw.setColumns(10);

		btnChpw.setBounds(737, 539, 121, 36);
		add(btnChpw);

		lblChPw.setBounds(350, 530, 71, 36);
		add(lblChPw);

		tfChPw.setBounds(435, 527, 206, 36);
		add(tfChPw);
		tfChPw.setColumns(10);
	}

	void eventProc(int pk) {
		btnChpw.addActionListener(this);
		tableMyInfoList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent v) {
				try {
					String memPw = dao.checkPw(pk);
					tfCheckPw.setText(memPw);
				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		// TODO Auto-generated method stub
		Object o = ev.getSource();
		if (o == btnChpw) {
			String pw = tfChPw.getText();
			vo = new MemberMyPageVO(pw);
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
			tmMyInfoList.data = list;
			tableMyInfoList.setModel(tmMyInfoList);
			tmMyInfoList.fireTableDataChanged();
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

class MyInfoListTableModel extends AbstractTableModel {
	ArrayList data = new ArrayList();
	String[] columnNames = { "회원코드명", "회원명", "전화번호", "ID", "PW", "주문횟수" };

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
