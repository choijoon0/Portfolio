package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import model.MemberJumunInfoDAO;

public class MemberJumunInfoView extends JPanel implements ActionListener{
	JLabel lblTitle;
	JComboBox comSearchJumun;
	JTextField tfSearchJumun;
	JButton btnSearchJumun;
	JPanel pMyJumun;
	JScrollPane spMyJumun;
	MyJumunTableModel tmMyJumun;
	JTable tableMyJumun;
	MemberJumunInfoDAO dao = null;
	ArrayList list = null;
	int memcode;

	public MemberJumunInfoView(MemberMainView memberMainView, int pk) {
		setLayout(null);
		newObject();
		addLayout();
		eventProc();
		memcode = pk;
		try {
			dao = new MemberJumunInfoDAO();
			selectMyJumun(pk);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	void newObject() {
		lblTitle = new JLabel("주문내역");
		String[] searchText = {"상품명", "주문날짜", "결제방식", "주문금액"};
		comSearchJumun = new JComboBox(searchText);
		tfSearchJumun = new JTextField();
		btnSearchJumun = new JButton("검색");
		
		pMyJumun = new JPanel();
		spMyJumun = new JScrollPane();
		tmMyJumun = new MyJumunTableModel();
		tableMyJumun = new JTable(tmMyJumun);
		
	}
	
	void addLayout() {
		lblTitle.setFont(new Font("굴림", Font.BOLD, 16));
		lblTitle.setBounds(243, 0, 73, 32);
		add(lblTitle);
		
		pMyJumun.setBounds(12, 62, 556, 279);
		add(pMyJumun);
		pMyJumun.setLayout(null);
		
		spMyJumun.setBounds(0, 0, 556, 279);
		pMyJumun.add(spMyJumun);
		
		spMyJumun.setViewportView(tableMyJumun);
		
		
		comSearchJumun.setBounds(12, 30, 80, 32);
		add(comSearchJumun);
		
		
		tfSearchJumun.setBounds(90, 30, 396, 33);
		add(tfSearchJumun);
		tfSearchJumun.setColumns(10);
		
		
		btnSearchJumun.setFont(new Font("굴림", Font.BOLD, 12));
		btnSearchJumun.setBounds(485, 30, 83, 33);
		add(btnSearchJumun);
	}
	
	void eventProc() {
		btnSearchJumun.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent ee) {
		Object o = ee.getSource();
		if (o == btnSearchJumun) {
			searchMyJumun(memcode);
		}
	}
	
	void selectMyJumun(int pk) {
		try {
			list = dao.myJumunList(pk);
			tmMyJumun.data = list;
			tableMyJumun.setModel(tmMyJumun);
			tmMyJumun.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	void searchMyJumun(int pk) {
		int sel = comSearchJumun.getSelectedIndex();
		String text = tfSearchJumun.getText();
		if(sel < 3) {
			try {
				list = dao.myJumunSearch(sel, text, pk);
				tmMyJumun.data = list;
				tableMyJumun.setModel(tmMyJumun);
				tmMyJumun.fireTableDataChanged();
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "검색 실패 : " + e.getMessage());
			}	
		}else if(sel == 3) {
			try {
				list = dao.jumunSearchPr(sel, text, pk);
				tmMyJumun.data = list;
				tableMyJumun.setModel(tmMyJumun);
				tmMyJumun.fireTableDataChanged();
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "검색 실패 : " + e2.getMessage());
			}
		}
		
	}

}

class MyJumunTableModel extends AbstractTableModel {
	ArrayList data = new ArrayList();
	String[] columnNames = {"회원명", "주문 번호", "상품명", "주문 수량", "주문 금액", "주문 날짜", "결제 방식"};
	
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
