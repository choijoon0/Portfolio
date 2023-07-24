package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.table.DefaultTableModel;

import model.FeTicketInfoDAO;

import java.awt.Font;

public class FeTicketInfoView extends JPanel implements ActionListener {
	JLabel lblTitle;
	JPanel pFestList, pConList;
	JScrollPane spFestList, spConList;
	FestListTableModel tmFestList;
	ConListTableModel tmConList;
	JTable tableFestList, tableConList;
	
	FeTicketInfoDAO dao = null;
	ArrayList list = null;
	int memcode, fest;
	public FeTicketInfoView(FestMainView FestMainView, int pk) {
		newObject();
		addLayout();
		eventProc();
		memcode = pk;
		
		try {
			dao = new FeTicketInfoDAO();
			selectFestList(pk);
			selectConList(pk);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// --------------------------------------------------
	// 멤버 변수 객체 생성
	void newObject() {
		lblTitle = new JLabel("예매 등록 정보");
		pFestList = new JPanel();
		spFestList = new JScrollPane();
		tmFestList = new FestListTableModel();
		tableFestList = new JTable(tmFestList);
		
		pConList = new JPanel();
		spConList = new JScrollPane();
		tmConList = new ConListTableModel();
		tableConList = new JTable(tmConList);
	}

	void addLayout() {
		setLayout(null);
		
		lblTitle.setFont(new Font("굴림", Font.BOLD, 18));
		lblTitle.setBounds(269, 0, 234, 45);
		add(lblTitle);

		pFestList.setBounds(12, 45, 693, 215);
		add(pFestList);
		pFestList.setLayout(null);

		spFestList.setBounds(0, 0, 693, 215);
		pFestList.add(spFestList);

		spFestList.setViewportView(tableFestList);
		
		
		pConList.setBounds(12, 270, 693, 236);
		add(pConList);
		pConList.setLayout(null);
		
		
		spConList.setBounds(0, 0, 693, 236);
		pConList.add(spConList);
		
		
		spConList.setViewportView(tableConList);
	}
	void eventProc() {
		tableConList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int col = 0;
				int row = tableConList.getSelectedRow();
				int festcode = (Integer)tableConList.getValueAt(row, col);
				FeResSeatView frsView;
				frsView = new FeResSeatView(festcode);
				frsView.setVisible(true);
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	void selectFestList(int pk) {
		try {
			list = dao.festList(pk);
			tmFestList.data = list;
			tableFestList.setModel(tmFestList);
			tmFestList.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	void selectConList(int pk) {
		try {
			list = dao.conList(pk);
			tmConList.data = list;
			tableConList.setModel(tmConList);
			tmConList.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

class FestListTableModel extends AbstractTableModel {
	ArrayList data = new ArrayList();
	String[] columnNames = {"축제코드", "축제명", "축제분류명", "축제시작일", "축제종료일", "잔여부스개수"};
	
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

class ConListTableModel extends AbstractTableModel {
	ArrayList data = new ArrayList();
	String[] columnNames = {"축제코드", "축제명", "축제분류명", "축제시작일", "축제종료일", "잔여좌석개수"};
	
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
