package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.file.attribute.AclEntry;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import model.FeFixBoothDAO;
import javax.swing.table.DefaultTableModel;

public class FeFixBoothView extends JPanel implements ActionListener {
	JLabel lblFixBoothInfo;
	JTextField tfBoothSearch, tfFixBooth;
	JComboBox cbBoothSearch, cbFixBoothSearch; // 위 콤보박스,아래 콤보박스
	JButton btnSearch, btnFix, btnFSearch; // 위(확정전)검색버튼,확정버튼,아래(확정후)검색버튼
	JTable tableAf, tableBf;

	FeFixBoothDAO dao = null;
	BeforeBoothTableModel tmBfBooth;
	AfterBoothTableModel tmAfBooth;
	ArrayList list = null;
	JPanel PanelTop, PanelMid, panelbtt;
	JScrollPane scMid;
	JScrollPane scbtt;
	int memcode;

	JLabel lblBthCnt, lblAddNoBth, lblAddYesBth, lblBalance;
	JTextField tfMyFeSearch, tfBthCnt, tfAddNoBth, tfAddYesBth, tfBalance;
	SearchFeTableModel tmSearchFe;
	JTable tableSearchFe;
	JScrollPane scTop;
	JComboBox cbMyFeSearch;
	JButton btnMyFeSearch;
	private JButton btnReset;

	public FeFixBoothView(FestMainView FestMainView, int pk) {
		setBackground(new Color(255, 255, 255));
		newObject();
		addLayout();
		eventProc(pk);
		memcode = pk;
		try {
			dao = new FeFixBoothDAO();
			selectMyFeTable(pk);

			System.out.println("비디오 디비 연결 성공");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "내정보 DB연결 실패 : " + e.getMessage());
		}

	}

	void newObject() {
		// 우측 상단
		lblBthCnt = new JLabel("최대 부스 개수");
		tfBthCnt = new JTextField();
		lblAddNoBth = new JLabel("승인 대기 부스 개수");
		tfAddNoBth = new JTextField();
		lblAddYesBth = new JLabel("승인된 부스 개수");
		tfAddYesBth = new JTextField();
		lblBalance = new JLabel("승인 가능한 부스 개수");
		tfBalance = new JTextField();

		// 내 축제 리스트
		String feText[] = { "축제 명", "부스 이름", "축제 시작일", "축제 종료일" };
		cbMyFeSearch = new JComboBox(feText);
		tfMyFeSearch = new JTextField();
		btnMyFeSearch = new JButton("검색");
		PanelTop = new JPanel();
		scTop = new JScrollPane();
		tableSearchFe = new JTable();
		tmSearchFe = new SearchFeTableModel();
		tableSearchFe = new JTable(tmSearchFe);

		// N부스 리스트
		lblFixBoothInfo = new JLabel("관리자가 등록한 부스 정보");
		cbBoothSearch = new JComboBox();
		tfBoothSearch = new JTextField();
		btnSearch = new JButton("검색");
		btnFix = new JButton("확정버튼");
		PanelMid = new JPanel(); // 위쪽 판넬 리스트
		scMid = new JScrollPane();
		tableBf = new JTable();

		// Y부스 리스트
		cbFixBoothSearch = new JComboBox();
		tfFixBooth = new JTextField();
		btnFSearch = new JButton("검색");
		btnReset = new JButton("새로고침");
		panelbtt = new JPanel();
		scbtt = new JScrollPane();
		tableAf = new JTable();
	}

	public void addLayout() {
		setLayout(null);

		lblFixBoothInfo.setFont(new Font("굴림", Font.BOLD, 25));
		lblFixBoothInfo.setBounds(22, 10, 403, 51);
		add(lblFixBoothInfo);

		lblBthCnt.setBounds(32, 58, 84, 15);
		add(lblBthCnt);

		tfBthCnt.setEditable(false);
		tfBthCnt.setBounds(129, 55, 116, 21);
		add(tfBthCnt);
		tfBthCnt.setColumns(10);

		lblAddNoBth.setBounds(12, 86, 116, 15);
		add(lblAddNoBth);

		tfAddNoBth.setEditable(false);
		tfAddNoBth.setBounds(129, 83, 116, 21);
		add(tfAddNoBth);
		tfAddNoBth.setColumns(10);
		
		lblAddYesBth.setBounds(274, 58, 101, 15);
		add(lblAddYesBth);
		
		tfAddYesBth.setEditable(false);
		tfAddYesBth.setBounds(387, 55, 116, 21);
		add(tfAddYesBth);
		tfAddYesBth.setColumns(10);

		lblBalance.setBounds(257, 86, 125, 15);
		add(lblBalance);

		tfBalance.setEditable(false);
		tfBalance.setBounds(387, 83, 116, 21);
		add(tfBalance);
		tfBalance.setColumns(10);

		// 내 축제 리스트
		cbMyFeSearch.setBounds(12, 111, 120, 30);
		add(cbMyFeSearch);

		tfMyFeSearch.setBounds(139, 112, 266, 30);
		add(tfMyFeSearch);
		tfMyFeSearch.setColumns(10);

		btnMyFeSearch.setBounds(406, 111, 73, 30);
		add(btnMyFeSearch);

		PanelTop.setLayout(null);
		PanelTop.setBounds(12, 145, 658, 164);
		add(PanelTop);

		scTop.setBounds(0, 0, 658, 164);
		PanelTop.add(scTop);

		scTop.setViewportView(tableSearchFe);

		// N부스 리스트
		cbBoothSearch.setModel(new DefaultComboBoxModel(new String[] { "축제 명", "부스 이름", "부스 종류", "시작시간", "종료시간" }));
		cbBoothSearch.setBounds(12, 313, 120, 30);
		add(cbBoothSearch);

		tfBoothSearch.setBounds(139, 314, 266, 30);
		add(tfBoothSearch);
		tfBoothSearch.setColumns(10);

		btnSearch.setBounds(406, 313, 73, 31);
		add(btnSearch);

		btnFix.setBounds(480, 313, 120, 30);
		add(btnFix);

		tmBfBooth = new BeforeBoothTableModel();
		tableBf = new JTable(tmBfBooth);

		tmAfBooth = new AfterBoothTableModel();
		tableAf = new JTable(tmAfBooth);

		PanelMid.setBounds(12, 346, 658, 164);
		add(PanelMid);
		PanelMid.setLayout(null);

		panelbtt.setBounds(12, 547, 658, 164);
		add(panelbtt);
		panelbtt.setLayout(null);

		scbtt.setBounds(0, 0, 658, 164);
		panelbtt.add(scbtt);

		scbtt.setViewportView(tableAf);
		scMid.setBounds(0, 0, 658, 164);
		PanelMid.add(scMid);

		scMid.setViewportView(tableBf);

		// Y부스 리스트
		cbFixBoothSearch.setModel(new DefaultComboBoxModel(new String[] { "축제 명", "부스 이름", "부스 종류", "시작시간", "종료시간" }));
		cbFixBoothSearch.setBounds(12, 513, 120, 30);
		add(cbFixBoothSearch);

		tfFixBooth.setBounds(139, 514, 266, 30);
		add(tfFixBooth);
		tfFixBooth.setColumns(10);

		btnFSearch.setBounds(406, 513, 73, 30);
		add(btnFSearch);
		
		
		btnReset.setBounds(487, 115, 97, 23);
		add(btnReset);

	}

	void eventProc(int pk) {
		tfBoothSearch.addActionListener(this);
		btnSearch.addActionListener(this);// 확정전
		btnFix.addActionListener(this);// 확정버튼
		tfFixBooth.addActionListener(this);
		btnFSearch.addActionListener(this);// 확정확인
		btnMyFeSearch.addActionListener(this);
		btnReset.addActionListener(this);

		tableBf.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent x) {
				
			}
		});

		tableSearchFe.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent v) {
				int col = 0;
				int row = tableSearchFe.getSelectedRow();
				int fcode = (Integer)tableSearchFe.getValueAt(row, col);
				try {
					int maxBth = dao.bthCnt(fcode);
					tfBthCnt.setText(String.valueOf(maxBth));
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					int addNoBth = dao.addNoBthCnt(fcode);
					tfAddNoBth.setText(String.valueOf(addNoBth));
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					int addYesBth = dao.addYesBthCnt(fcode);
					tfAddYesBth.setText(String.valueOf(addYesBth));
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					int balanceBth = dao.balanceBthCnt(fcode);
					tfBalance.setText(String.valueOf(balanceBth));
				} catch (Exception e) {
					// TODO: handle exception
				}
					selectFeNoTable(pk);
					selectFeYesTable(pk);
			}
			
		});

	}

	void selectNoTable(int pk) {
		try {
			list = dao.TotNoList(pk);
			tmBfBooth.data = list;
			tableBf.setModel(tmBfBooth);
			tmBfBooth.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	void selectFeNoTable(int pk) {
		int col = 0;
		int row = tableSearchFe.getSelectedRow();
		int fcode = (Integer)tableSearchFe.getValueAt(row, col);
		try {
			list = dao.FeNoList(pk, fcode);
			tmBfBooth.data = list;
			tableBf.setModel(tmBfBooth);
			tmBfBooth.fireTableDataChanged();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	void selectYesTable(int pk) {
		try {
			list = dao.TotYesList(pk);
			tmAfBooth.data = list;
			tableAf.setModel(tmAfBooth);
			tmAfBooth.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	void selectFeYesTable(int pk) {
		int col = 0;
		int row = tableSearchFe.getSelectedRow();
		int fcode = (Integer)tableSearchFe.getValueAt(row, col);
		try {
			list = dao.FeYesList(pk, fcode);
			tmAfBooth.data = list;
			tableAf.setModel(tmAfBooth);
			tmAfBooth.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	void selectMyFeTable(int pk) {
		try {
			list = dao.TotMyFeList(pk);
			tmSearchFe.data = list;
			tableSearchFe.setModel(tmSearchFe);
			tmSearchFe.fireTableDataChanged();
		} catch (Exception e) {
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		// 확정 전 부스 검색할때
		if (o == btnSearch) {
			noFixTable(memcode);

		} else if (o == btnFSearch) {
			fixTable(memcode);

		} else if (o == btnMyFeSearch) {
			searchFeTable(memcode);

		} else if (o == btnFix) {
			// 확정 버튼 누를 때
			int col = 0;
			int row = tableBf.getSelectedRow();
			int bcode = (int) tableBf.getValueAt(row, col);
			if(Integer.parseInt(tfBalance.getText()) > 0) {
				try {
					dao.changeResOk(bcode);

					selectNoTable(memcode);
					selectYesTable(memcode);
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				int col2 = 0;
				int row2 = tableSearchFe.getSelectedRow();
				int fcode = (Integer)tableSearchFe.getValueAt(row2, col2);
				try {
					int maxBth = dao.bthCnt(fcode);
					tfBthCnt.setText(String.valueOf(maxBth));
				} catch (Exception e2) {
					// TODO: handle exception
				}
				try {
					int addNoBth = dao.addNoBthCnt(fcode);
					tfAddNoBth.setText(String.valueOf(addNoBth));
				} catch (Exception e2) {
					// TODO: handle exception
				}
				try {
					int addYesBth = dao.addYesBthCnt(fcode);
					tfAddYesBth.setText(String.valueOf(addYesBth));
				} catch (Exception e2) {
					// TODO: handle exception
				}
				try {
					int balanceBth = dao.balanceBthCnt(fcode);
					tfBalance.setText(String.valueOf(balanceBth));
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}else {

				JOptionPane.showMessageDialog(null, "이미 허용 가능한 최대 부스개수를 채우셨습니다.");
			}
			
		}else if(o ==btnReset) {
			selectMyFeTable(memcode);
		}
	}

	void noFixTable(int pk) {
		int sel = cbBoothSearch.getSelectedIndex();
		String text = tfBoothSearch.getText();
		try {
			list = dao.noFixboothSearch(sel, text, pk);
			tmBfBooth.data = list;
			tableBf.setModel(tmBfBooth);
			tmBfBooth.fireTableDataChanged();

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "bf부스 검색 실패:" + e.getMessage());
		}
	}

	void fixTable(int pk) {
		int sel = cbFixBoothSearch.getSelectedIndex();
		String text = tfFixBooth.getText();
		try {
			list = dao.fixBoothSearch(sel, text, pk);
			tmAfBooth.data = list;
			tableAf.setModel(tmAfBooth);
			tmAfBooth.fireTableDataChanged();

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "af부스 검색 실패:" + e.getMessage());
		}
	}

	
	void searchFeTable(int pk) {
		int sel = cbMyFeSearch.getSelectedIndex();
		String text = tfMyFeSearch.getText();
		try {
			list = dao.searchFe(sel, text, pk);
			tmSearchFe.data = list;
			tableSearchFe.setModel(tmSearchFe);
			tmSearchFe.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "내 축제 검색 실패 : " + e.getMessage());
		}
	}

}

//확정전 리스트 값 table
class BeforeBoothTableModel extends AbstractTableModel {
	

	ArrayList data = new ArrayList();
	String[] columnNames = { "부스코드", "축제명", "부스이름", "부스 종류", "부스 시작시간", "부스 종료시간", "회원이름", "예약 확정유무" };

//=============================================================
// 1. 기본적인 TabelModel  만들기
// 아래 세 함수는 TabelModel 인터페이스의 추상함수인데
// AbstractTabelModel에서 구현되지 않았기에...
// 반드시 사용자 구현 필수!!!!

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

//===============================================================
// 2. 지정된 컬럼명으로 변환하기
//
//      기본적으로 A, B, C, D 라는 이름으로 컬럼명이 지정된다
	public String getColumnName(int col) {
		return columnNames[col];
	}

}

//확정후 리스트 값 table
class AfterBoothTableModel extends AbstractTableModel {

	ArrayList data = new ArrayList();
	String[] columnNames = { "부스코드", "축제명", "부스이름", "부스 종류", "부스 시작시간", "부스 종료시간", "회원이름", "예약 확정유무" };

//=============================================================
// 1. 기본적인 TabelModel  만들기
// 아래 세 함수는 TabelModel 인터페이스의 추상함수인데
// AbstractTabelModel에서 구현되지 않았기에...
// 반드시 사용자 구현 필수!!!!

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

//===============================================================
// 2. 지정된 컬럼명으로 변환하기
//
//      기본적으로 A, B, C, D 라는 이름으로 컬럼명이 지정된다
	public String getColumnName(int col) {
		return columnNames[col];
	}

}

class SearchFeTableModel extends AbstractTableModel {
	ArrayList data = new ArrayList();
	String[] columnNames = { "축제코드", "축제이름", "축제장소", "축제시작일", "축제종료일" };

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
