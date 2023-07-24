package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import model.BoothResDAO;
import model.BoothYNDAO;
import model.rec.BoothResVO;

public class BoothResView extends JFrame implements ActionListener {

	JPanel pSubBooth, pSubBthList;
	JLabel lblFestName, lblBthCtcode, lblBoothCt, lblBoothName, lblBoothTel, lblBthSttime, lblBthEndtime;
	JTextField tfFestName, tfBoothName, tfBoothTel, tfBthSttime, tfBthEndtime;
	JComboBox comBoothCt;
	JButton btnSubBooth;
	JScrollPane spSubBthList;
	JTable tableSubBthList;
	SubBthListModel tmSubBthList;
	BoothResDAO dao;
	BoothResVO vo;
	ArrayList list = null;
	JLabel lblNewLabel;
	JButton btnupdate;
	int memcode = 0;
	JButton btnResCancel;
	JButton btnback;
	BoothMainView v;
	String fname = null;


	public BoothResView(String name, int pk) {
		newObject();
		addLayout();
		eventProc();
		
		memcode = pk;
		fname = name;
		tfFestName.setText(name);

		

		try {
			dao = new BoothResDAO();
			try {
				
				selectTable(name);
				System.out.println("DB 연결 성공");
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, " DB연결 실패 : " + e.getMessage());
		}
	}

	void newObject() {
		// 입력 패널
		pSubBooth = new JPanel();
		pSubBooth.setLayout(null);

		lblFestName = new JLabel("축제명");
		tfFestName = new JTextField();

		lblBoothCt = new JLabel("부스분류");
		String boothCt[] = { "식품", "체험", "통합" };
		comBoothCt = new JComboBox(boothCt);

		lblBoothName = new JLabel("부스명");
		tfBoothName = new JTextField();

		lblBoothTel = new JLabel("전화번호");
		tfBoothTel = new JTextField();

		lblBthSttime = new JLabel("시작시간");
		tfBthSttime = new JTextField();

		lblBthEndtime = new JLabel("종료시간");
		tfBthEndtime = new JTextField();

		btnSubBooth = new JButton("부스 신청");
		lblNewLabel = new JLabel("내 신청현황");
		btnupdate = new JButton("수정");
		btnResCancel = new JButton("신청취소");
		btnback = new JButton();
		// 리스트 패널
		pSubBthList = new JPanel();
		spSubBthList = new JScrollPane();

		tmSubBthList = new SubBthListModel();
		tableSubBthList = new JTable(tmSubBthList);
	}

	void addLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 386);
		pSubBooth.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pSubBooth);
		btnResCancel.setBounds(11, 252, 232, 54);
		pSubBooth.add(btnResCancel);
		
		
		btnback.setSelectedIcon(new ImageIcon("C:\\Users\\04-09\\Desktop\\bback.png"));
		btnback.setIcon(new ImageIcon("C:\\Users\\04-09\\Desktop\\bback.png"));
		btnback.setBounds(517, 10, 40, 40);
		pSubBooth.add(btnback);
		//btnback.setBorderPainted(false); // 버튼 테두리 설정


		//btnback.setContentAreaFilled(false); // 버튼 영역 배경 표시 설정


		//btnback.setFocusPainted(false); // 포커스 표시 설정
		// 입력 패널
		lblFestName.setBounds(0, 10, 57, 15);
		pSubBooth.add(lblFestName);

		tfFestName.setEditable(false);
		tfFestName.setBounds(60, 7, 183, 21);
		pSubBooth.add(tfFestName);
		tfFestName.setColumns(10);

		lblNewLabel.setBounds(258, 35, 87, 38);
		pSubBooth.add(lblNewLabel);

		btnupdate.setBounds(460, 50, 97, 23);
		pSubBooth.add(btnupdate);

		lblBoothCt.setBounds(0, 77, 57, 15);
		pSubBooth.add(lblBoothCt);

		comBoothCt.setBounds(60, 73, 183, 23);
		pSubBooth.add(comBoothCt);

		lblBoothName.setBounds(0, 35, 57, 15);
		pSubBooth.add(lblBoothName);

		tfBoothName.setBounds(60, 32, 183, 21);
		pSubBooth.add(tfBoothName);
		tfBoothName.setColumns(10);

		lblBoothTel.setBounds(0, 106, 57, 15);
		pSubBooth.add(lblBoothTel);

		tfBoothTel.setBounds(60, 102, 183, 21);
		pSubBooth.add(tfBoothTel);
		tfBoothTel.setColumns(10);

		lblBthSttime.setBounds(0, 131, 57, 15);
		pSubBooth.add(lblBthSttime);

		tfBthSttime.setBounds(60, 125, 35, 21);
		pSubBooth.add(tfBthSttime);
		tfBthSttime.setColumns(10);

		lblBthEndtime.setBounds(0, 156, 57, 15);
		pSubBooth.add(lblBthEndtime);

		tfBthEndtime.setBounds(60, 153, 35, 21);
		pSubBooth.add(tfBthEndtime);
		tfBthEndtime.setColumns(10);

		btnSubBooth.setBounds(11, 181, 232, 61);
		pSubBooth.add(btnSubBooth);

		// 내역 리스트 패널
		pSubBthList.setBounds(255, 77, 302, 257);
		pSubBooth.add(pSubBthList);
		pSubBthList.setLayout(null);

		spSubBthList.setBounds(0, 0, 302, 247);
		pSubBthList.add(spSubBthList);

		spSubBthList.setViewportView(tableSubBthList);
	}

	void eventProc() {
		btnSubBooth.addActionListener(this);
		btnupdate.addActionListener(this);
		btnResCancel.addActionListener(this);
		btnback.addActionListener(this);

		// 리스트클릭이벤트
		tableSubBthList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = tableSubBthList.getSelectedRow();
				int col = 0;
				int vNum = (int) tableSubBthList.getValueAt(row, col);
			
					try {
						vo = dao.findByFest(vNum, memcode);

						
						tfBoothName.setText(vo.getBoothname());
						comBoothCt.setSelectedItem(vo.getBoothctname());
						tfBoothTel.setText(vo.getBoothtel());
						tfBthSttime.setText(String.valueOf(vo.getBoothopen()));
						tfBthEndtime.setText(String.valueOf(vo.getBoothclose()));

					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "오엥 : " + e2.getMessage());
					}
		
				
			
			}
		});
	}

	public void actionPerformed(ActionEvent ev) {
		Object o = ev.getSource();
		// 부스등록
		if (o == btnSubBooth) {
			String bthName = tfBoothName.getText();
			int bthCode = comBoothCt.getSelectedIndex() + 1;
			String festName = tfFestName.getText();

			String bthTel = tfBoothTel.getText();
			int bthOptime = Integer.parseInt(tfBthSttime.getText());
			int bthCltime = Integer.parseInt(tfBthEndtime.getText());

			try {
				int num = dao.returnFestPK(festName);

				try {
					vo = new BoothResVO(bthName, bthCode, num, bthTel, bthOptime, bthCltime, memcode);
					dao.resBooth(vo);
					clearScreen();
					selectTable(fname);
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "예약 실패 : " + e.getMessage());
				}

			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "예약 실패!! : " + e.getMessage());
			}
		} else if (o == btnupdate) {
			// 부스 수정
			String name = tfBoothName.getText();
			int boothct = comBoothCt.getSelectedIndex() + 1;
			String tel = tfBoothTel.getText();
			int open = Integer.parseInt(tfBthSttime.getText());
			int close = Integer.parseInt(tfBthEndtime.getText());

			try {
				int row = tableSubBthList.getSelectedRow();
				int col = 0;
				int vNum = (int) tableSubBthList.getValueAt(row, col);
				vo = new BoothResVO(name, boothct, tel, open, close, vNum);
				dao.updateResBooth(vo);
				clearScreen();
				selectTable(fname);

			} catch (Exception e) {
				// TODO: handle exception
			}

		} else if (o == btnResCancel) {
			//신청취소
			int row = tableSubBthList.getSelectedRow();
			int col = 0;
			int vNum = (int) tableSubBthList.getValueAt(row, col);
			try {
				dao.resCancel(vNum);
				selectTable(fname);
				clearScreen();
			
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else if (o == btnback) {
			//돌아가기
			
			v= new BoothMainView(memcode);
			setVisible(false);
		}
	}

	// 화면 초기화
	void clearScreen() {
		
		tfBoothName.setText("");
		tfBoothTel.setText("");
		tfBthSttime.setText("");
		tfBthEndtime.setText("");
		comBoothCt.setSelectedIndex(0);
	}

	// 리스트 출력
	void selectTable(String name) {
		try {
			int fcode = dao.returnFestPK(name);	
			try {
				list = dao.myResList(memcode,fcode);

				tmSubBthList.data = list;

				tableSubBthList.setModel(tmSubBthList);

				tmSubBthList.fireTableDataChanged();

			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "테이블 출력 실패 :" + e.getMessage());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}

class SubBthListModel extends AbstractTableModel {
	ArrayList data = new ArrayList();
	String[] columnNames = { "부스코드", "축제명", "부스명", "부스분류", "시작시간", "종료시간", "확정여부" };

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
