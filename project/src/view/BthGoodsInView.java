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
import javax.swing.table.DefaultTableModel;

import model.BthGoodsInDAO;
import java.awt.Color;
import javax.swing.ImageIcon;

public class BthGoodsInView extends JPanel implements ActionListener{
	JLabel lblTitle, lblSum;
	JComboBox comSearchGoods, comJaeSearch;
	JTextField tfSearchGoods, tfSum;
	JButton btnSearchGoods, btnJaeSearch;
	JPanel pGoodsList, pJaego;
	JScrollPane spGoodsList, spJaego;
	JuGoodsListTableModel tmJuGoodsList;
	JaegoTableModel tmJaego;
	JTable tableJuGoodsList, tableJaego;
	BthGoodsInDAO dao = null;
	ArrayList list = null;
	int memcode;
	private JTextField tfJaeSearch;
	private JLabel lblNewLabel;
	
	
	
	public BthGoodsInView(BoothMainView moothMainView, int pk) {
		setBackground(Color.white);
		newObject();
		addLayout();
		eventProc();
		//setLocationRelativeTo(null);
		
		memcode = pk;
		try {
			dao = new BthGoodsInDAO();
			selectGoodsTable(pk);
			selectSumPrice(pk);
			selectJaego(pk);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	void newObject() {
		lblTitle = new JLabel("재 고 관 리");
		
		//순수익
		String[] searchText = {"상품명"};
		comSearchGoods = new JComboBox(searchText);
		comSearchGoods.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));
		tfSearchGoods = new JTextField();
		tfSearchGoods.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));
		btnSearchGoods = new JButton("검색");
		btnSearchGoods.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));
		btnSearchGoods.setBackground(Color.white);
		
		pGoodsList = new JPanel();
		spGoodsList = new JScrollPane();
		tmJuGoodsList = new JuGoodsListTableModel();
		tableJuGoodsList = new JTable(tmJuGoodsList);
		tableJuGoodsList.setFont(new Font("양재인장체M", Font.PLAIN, 12));
		lblSum = new JLabel("순수익 합계:");
		tfSum = new JTextField();
		tfSum.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));
		
		//재고
		String[] jaegoText = {"상품명"};
		comJaeSearch = new JComboBox(jaegoText);
		comJaeSearch.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));
		tfJaeSearch = new JTextField();
		tfJaeSearch.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));
		btnJaeSearch = new JButton("검색");
		btnJaeSearch.setBackground(Color.white);
		btnJaeSearch.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));
		pJaego = new JPanel();
		spJaego = new JScrollPane();
		tmJaego = new JaegoTableModel();
		tableJaego = new JTable(tmJaego);
		tableJaego.setFont(new Font("양재인장체M", Font.PLAIN, 12));
	}
	
	void addLayout() {
		setLayout(null);
		//타이틀
		lblTitle.setFont(new Font("양재튼튼체B", Font.BOLD, 25));
		lblTitle.setBounds(457, 66, 136, 30);
		add(lblTitle);
		
		//순수익
		btnSearchGoods.setBounds(735, 130, 77, 29);
		add(btnSearchGoods);
		
		
		tfSearchGoods.setBounds(353, 131, 363, 28);
		add(tfSearchGoods);
		tfSearchGoods.setColumns(10);
		
		comSearchGoods.setBounds(249, 130, 82, 28);
		add(comSearchGoods);
		
		pGoodsList.setBounds(230, 180, 599, 158);
		add(pGoodsList);
		pGoodsList.setLayout(null);
		
		spGoodsList.setBounds(0, 0, 599, 158);
		pGoodsList.add(spGoodsList);
		
		spGoodsList.setViewportView(tableJuGoodsList);
		
		lblSum.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));
		lblSum.setBounds(608, 374, 85, 29);
		add(lblSum);
		
		tfSum.setEditable(false);
		tfSum.setBounds(713, 375, 116, 28);
		add(tfSum);
		tfSum.setColumns(10);
		
		//재고
		pJaego.setBounds(230, 511, 599, 174);
		add(pJaego);
		pJaego.setLayout(null);
		
		
		spJaego.setBounds(0, 0, 599, 174);
		pJaego.add(spJaego);
		
		spJaego.setViewportView(tableJaego);
		
		comJaeSearch.setBounds(249, 449, 82, 28);
		add(comJaeSearch);
		
		tfJaeSearch.setBounds(353, 450, 363, 28);
		add(tfJaeSearch);
		tfJaeSearch.setColumns(10);
		
		btnJaeSearch.setBounds(735, 449, 77, 29);
		add(btnJaeSearch);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\04-09\\eclipse-workspace\\project\\src\\img\\jonge.jpg"));
		lblNewLabel.setBounds(128, 0, 790, 722);
		add(lblNewLabel);
	}
	
	void eventProc() {
		btnSearchGoods.addActionListener(this);
		btnJaeSearch.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ee) {
		Object o = ee.getSource();
		if(o == btnSearchGoods) {
			selectSearch(memcode);
			selectSearchSum(memcode);
		} else if(o == btnJaeSearch) {
			try {
				searchJaego(memcode);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	//상품 리스트
	void selectGoodsTable(int pk) {
		try {
			list = dao.goodsInList(pk);
			tmJuGoodsList.data = list;
			tableJuGoodsList.setModel(tmJuGoodsList);
			tmJuGoodsList.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "리스트 출력 실패 : " + e.getMessage());
		}
	}
	
	//순수익 합계
	void selectSumPrice(int pk) {
		try {
			int sum = dao.sumPrice(pk);
			tfSum.setText(String.valueOf(sum));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//상품 검색
	void selectSearch(int pk) {
		int sel = comSearchGoods.getSelectedIndex();
		String text = tfSearchGoods.getText();
		try {
			list = dao.searchInList(sel, text, pk);
			tmJuGoodsList.data = list;
			tableJuGoodsList.setModel(tmJuGoodsList);
			tmJuGoodsList.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "검색 실패 : " + e.getMessage());
		}
	}
	
	//검색 상품 순수익 합계
	void selectSearchSum(int pk) {
		int sel = comSearchGoods.getSelectedIndex();
		String text = tfSearchGoods.getText();
		try {
			int searchSum = dao.searchSum(sel, text, pk);
			tfSum.setText(String.valueOf(searchSum));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//재고 리스트
	void selectJaego(int pk) {
		try {
			list = dao.selectJaego(pk);
			tmJaego.data = list;
			tableJaego.setModel(tmJaego);
			tmJaego.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//재고 검색
	void searchJaego(int pk) {
		int sel = comJaeSearch.getSelectedIndex();
		String text = tfJaeSearch.getText();
		try {
			list = dao.searchJaego(sel, text, pk);
			tmJaego.data = list;
			tableJaego.setModel(tmJaego);
			tmJaego.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
//순수익
class JuGoodsListTableModel extends AbstractTableModel {
	ArrayList data = new ArrayList();
	String[] columnNames = { "주문코드", "부스명", "상품명", "주문 수량", "상품 정가", "상품 원가", "순수익"};
	
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
//재고
class JaegoTableModel extends AbstractTableModel {
	ArrayList data = new ArrayList();
	String[] columnNames = {"부스명", "상품 코드", "상품명", "상품 재고"};
	
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


