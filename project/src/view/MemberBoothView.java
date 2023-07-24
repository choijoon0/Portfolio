package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import model.MemberBoothDAO;
import view.MemBoothGoodsVIew;

public class MemberBoothView extends JFrame implements ActionListener {

	JPanel contentPane;
	MemberBoothDAO dao;
	JTextField tfSearch;
	JButton btnBoothSearch;
	JComboBox comboBox;
	RecentListTableModel rListTable;
	JScrollPane scrollPane;
	JTable table;
	int code = 0;

	public MemberBoothView(int pk, int fcode) {
		newObject();
		addLayout();
		eventProc(pk);
		code = fcode;
		
		try {
			dao = new MemberBoothDAO();
			selectTable(fcode);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	void newObject() {
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		btnBoothSearch = new JButton("검색");
		btnBoothSearch.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));
		tfSearch = new JTextField();
		tfSearch.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));

		comboBox = new JComboBox();
		comboBox.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));
		rListTable = new RecentListTableModel();

		table = new JTable(rListTable);
		table.setFont(new Font("양재인장체M", Font.PLAIN, 12));
		scrollPane = new JScrollPane();
	}

	void addLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1066, 602);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);

		tfSearch.setBounds(353, 165, 314, 47);
		contentPane.add(tfSearch);
		tfSearch.setColumns(10);

		btnBoothSearch.setBounds(723, 165, 124, 53);
		contentPane.add(btnBoothSearch);

		comboBox.setModel(new DefaultComboBoxModel(new String[] { "부스명", "부스분류" }));
		comboBox.setBounds(212, 165, 101, 47);
		contentPane.add(comboBox);

		scrollPane.setBounds(131, 245, 809, 274);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
	}

	void eventProc(int pk) {
		btnBoothSearch.addActionListener(this);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int col = 0;
				int row =  table.getSelectedRow();
				int bcode = (int)table.getValueAt(row, col);
				try {
					int num = dao.checkActivity(bcode);
					if(num == 2) {
						JOptionPane.showMessageDialog(null, "체험형 부스에는 상품이 없습니다!");
					}else {
						MemBoothGoodsVIew gview = new MemBoothGoodsVIew(bcode, pk);
						gview.setVisible(true);
					}
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "체험형 부스에는 상품이 없습니다!");
				}	
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o == btnBoothSearch) {
			searchTable(code);
		}
	}

	// 전체리스트 출력
	void selectTable(int fcode) {
		try {

			ArrayList list = new ArrayList();

			list = dao.searchBooth(fcode);

			rListTable.data = list;

			table.setModel(rListTable);

			rListTable.fireTableDataChanged();

		} catch (Exception e) {
			// TODO: handle exception
			// JOptionPane.showMessageDialog(null, "검색 실패: " + e.getMessage());
		}
	}

	// 부스 검색
	void searchTable(int fcode) {

		int sel = comboBox.getSelectedIndex();
		String text = tfSearch.getText();
		try {
			ArrayList list = new ArrayList();

			sel = comboBox.getSelectedIndex();
			text = tfSearch.getText();

			list = dao.searchBtn(sel, text, fcode);

			rListTable.data = list;

			table.setModel(rListTable);

			rListTable.fireTableDataChanged();

		} catch (Exception e) {
			// TODO: handle exception
			// JOptionPane.showMessageDialog(null, "검색 실패: " + e.getMessage());
		}
	}

	class RecentListTableModel extends AbstractTableModel {

		ArrayList data = new ArrayList();
		String[] columnNames = { "부스코드", "부스명", "부스분류", "부스시작시간", "부스종료시간", "전화번호" };

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
