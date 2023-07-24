package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import model.BoothFestDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class BoothFestView extends JPanel implements ActionListener {
	JTable table;
	JScrollPane scrollPane;
	BoothFestDAO dao;
	ArrayList list;
	RecentListTableModel rListTable;
	JTextField tfSearch;
	JComboBox festComboBox;
	JButton btnFestSearch;
	BoothMainView v;
	JButton btnReSet;
	/**
	 * Create the panel.
	 * 
	 * @param boothMainView
	 * @param pk 
	 */
	public BoothFestView(BoothMainView boothMainView, int pk) {

		newObject();
		addLayout();
		eventProc(pk);
		
		try {
			dao = new BoothFestDAO();
			System.out.println("부스 DB 연결 성공");
			selectTable();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	void newObject() {
		table = new JTable();
		scrollPane = new JScrollPane();
		scrollPane.setBounds(86, 116, 452, 402);
		rListTable = new RecentListTableModel();
		table = new JTable(rListTable);
		festComboBox = new JComboBox();

		
		tfSearch = new JTextField();
		btnFestSearch = new JButton("검색");
		btnReSet = new JButton("새로고침");
	}

	void addLayout() {
		setLayout(null);

		add(scrollPane);

		scrollPane.setViewportView(table);

		festComboBox.setBounds(112, 83, 63, 23);
		add(festComboBox);

		tfSearch.setBounds(187, 85, 158, 21);
		add(tfSearch);
		tfSearch.setColumns(10);

		btnFestSearch.setBounds(357, 83, 85, 23);
		add(btnFestSearch);
		festComboBox.setModel(new DefaultComboBoxModel(new String[] { "축제명", "장소", "축제시작일", "축제종료일", "주최측" }));
		
		
		btnReSet.setBounds(232, 33, 97, 23);
		add(btnReSet);
	}

	void eventProc(int pk) {
		btnFestSearch.addActionListener(this);
		btnReSet.addActionListener(this);

		// 검색리스트 클릭 시
		table.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				
				
				int col = 0;
				int row =  table.getSelectedRow();
				String name = String.valueOf(table.getValueAt(row, col));
				
				int cnt = (int) table.getValueAt(row, 4);
				if(cnt==0) {
					JOptionPane.showMessageDialog(null, "이미 예약이 마감되었습니다!");
				}else {
					BoothResView view = new BoothResView(name, pk);
					view.setVisible(true);
					
				}
		
			
			}

		});
	}

	public void actionPerformed(ActionEvent ev) {
		Object o = ev.getSource();
		if (o == btnFestSearch) {
			searchTable();

		}else if(o==btnReSet) {
			selectTable();
		}
	}

	//전체뽑
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

	//검색 뽑
	void searchTable() {
		int sel = festComboBox.getSelectedIndex();
		String text = tfSearch.getText();
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
		
		}
	}

	class RecentListTableModel extends AbstractTableModel {

		ArrayList data = new ArrayList();
		String[] columnNames = { "축제명", "축제시작일", "축제종료일", "주최측", "잔여부스석", "축제지역" };

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

