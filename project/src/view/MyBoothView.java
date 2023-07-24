package view;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.swing.table.AbstractTableModel;

import model.MyBoothDAO;
import javax.swing.table.DefaultTableModel;

public class MyBoothView extends JPanel {
	RecentListTableModel rListTable;
	ArrayList list = null;
	MyBoothDAO dao = null;
	JTable listTable;
	JScrollPane scrollPane;
	

	/*
	 * Create the panel.
	 * 
	 * @param boothMainView
	 */
	public MyBoothView(BoothMainView boothMainView, int pk) {
		newObject();
		addLayout();
		eventProc();
		
		try {
			dao = new MyBoothDAO();
			System.out.println("부스 DB 연결 성공");
			selectTable();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	void newObject() {
		rListTable = new RecentListTableModel();
		listTable = new JTable(rListTable);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 54, 532, 416);
	}

	void addLayout() {
		setLayout(null);
		add(scrollPane);

		scrollPane.setViewportView(listTable);
	}

	void eventProc() {
	}

	void selectTable() {
		try {
			
			list = dao.recentList();
			
			rListTable.data = list;
			
			listTable.setModel(rListTable);
			
			rListTable.fireTableDataChanged();

		} catch (Exception e) {
			// TODO: handle exception
			
			//JOptionPane.showMessageDialog(null, "검색 실패: " + e.getMessage());
		}
	}

	class RecentListTableModel extends AbstractTableModel {

		ArrayList data = new ArrayList();
		
		String[] columnNames = { "축제명", "부스명", "오픈", "마감", "전화번호", "오픈여부", "예약확정여부" };

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return data.size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return columnNames.length;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			ArrayList temp = (ArrayList) data.get(rowIndex);
			return temp.get(columnIndex);
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}
	}
}
