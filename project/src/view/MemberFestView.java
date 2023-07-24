package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import model.MemberFestDAO;

public class MemberFestView extends JPanel implements ActionListener {
	MemberFestDAO dao;
	JTextField tfSearch;
	JTable table;
	JButton btnFestSearch;
	JScrollPane scrollPane;
	JComboBox comboBox;
	RecentListTableModel rListTable;
	ArrayList list;
	MemberBoothView mview;

	public MemberFestView(MemberMainView memberMainView, int pk) {

		newObject();
		addLayout();
		eventProc(pk);
		try {
			dao = new MemberFestDAO();
			System.out.println("멤버 DB 연결 성공!");
			selectTable();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	void newObject() {
		btnFestSearch = new JButton("검색");
		scrollPane = new JScrollPane();
		rListTable = new RecentListTableModel();
		table = new JTable(rListTable);
		comboBox = new JComboBox();
		tfSearch = new JTextField();
	}

	void addLayout() {
		setLayout(null);
		btnFestSearch.setBounds(356, 72, 57, 30);
		add(btnFestSearch);

		scrollPane.setBounds(81, 102, 452, 402);
		add(scrollPane);

		scrollPane.setViewportView(table);

		comboBox.setModel(new DefaultComboBoxModel(new String[] { "축제명", "장소", "종료일", "입장료" }));
		comboBox.setBounds(81, 72, 80, 30);
		add(comboBox);

		tfSearch.setBounds(161, 72, 196, 30);
		add(tfSearch);
		tfSearch.setColumns(10);
	}

	void eventProc(int pk) {
		btnFestSearch.addActionListener(this);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				int col = 0;
				int row = table.getSelectedRow();
				int fcode = (int)table.getValueAt(row, col);
				
				mview = new MemberBoothView(pk, fcode);
				mview.setVisible(true);
				
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o == btnFestSearch) {
			searchTable();
		}

	}

	// 축제전체 뽐
	void selectTable() {
		try {

			ArrayList list = new ArrayList();

			list = dao.searchFest();

			rListTable.data = list;

			table.setModel(rListTable);

			rListTable.fireTableDataChanged();

		} catch (Exception e) {
			// TODO: handle exception
			// JOptionPane.showMessageDialog(null, "검색 실패: " + e.getMessage());
		}
	}

	void searchTable() {
		int sel = comboBox.getSelectedIndex();
		String text = tfSearch.getText();
		if(sel < 3) {
			try {
				ArrayList list = new ArrayList();
				list = dao.searchBtn(sel, text);
				rListTable.data = list;
				table.setModel(rListTable);
				rListTable.fireTableDataChanged();
			
			} catch (Exception e) {
				// TODO: handle exception
				// JOptionPane.showMessageDialog(null, "검색 실패: " + e.getMessage());
			}	
		}else if(sel == 3) {
			try {
				ArrayList list = new ArrayList();
				list = dao.searchPrBtn(sel, text);
				rListTable.data = list;
				table.setModel(rListTable);
				rListTable.fireTableDataChanged();
			
			} catch (Exception e2) {
				// TODO: handle exception
				 JOptionPane.showMessageDialog(null, "검색 실패: " + e2.getMessage());
			}
		}
		
		
	}

	class RecentListTableModel extends AbstractTableModel {

		ArrayList data = new ArrayList();
		String[] columnNames = { "축제코드", "축제명", "축제장소", "입장료", "축제내용", "축제 종료일" };

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
