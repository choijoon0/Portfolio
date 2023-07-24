package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import model.FeAllListDAO;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class FeAllListView extends JPanel implements ActionListener {

	JTextField tfFesearch;
	JComboBox cbFesSearch;
	JScrollPane spAllFest;
	JTable AllFestList;
	FeTableModel tmFe;
	FeAllListDAO dao;
	ArrayList list;
	JButton btnFeAllSearch;

	/**
	 * Create the panel.
	 */
	public FeAllListView(FestMainView FestMainView, int pk) {
		setBackground(new Color(255, 255, 255));	//
		newObject();
		addLayout();
		eventProc();
		try {
			dao = new FeAllListDAO();
			System.out.println("전체 축제L 디비 연결 성공");
			allfestSearch();
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "축제L DB연결 실패 : " + e.getMessage());
		}

	}

	void newObject() {
		String[]searchText ={ "축제이름", "축제장소" };
		cbFesSearch = new JComboBox(searchText);
		cbFesSearch.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));
		cbFesSearch.setModel(new DefaultComboBoxModel(new String[] {"축제이름", "축제장소", "축제시작일", "축제종료일", "주최"}));
		tfFesearch = new JTextField();		//상단
		tfFesearch.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));

		
		tmFe = new FeTableModel();
		AllFestList = new JTable(tmFe);		//하단 리스트테이블
		AllFestList.setFont(new Font("양재인장체M", Font.PLAIN, 13));
	}
	

	void addLayout() {
		setLayout(null);

		JLabel lblAllListView = new JLabel("전체 축제 검색");
		lblAllListView.setFont(new Font("양재튼튼체B", Font.BOLD, 30));
		lblAllListView.setBounds(118, 58, 220, 60);
		add(lblAllListView);

//		cbFesSearch.setModel(new DefaultComboBoxModel(new String[] { "축제코드", "축제이름" }));
		cbFesSearch.setBounds(266, 195, 131, 35);
		add(cbFesSearch);
		tfFesearch.setBounds(431, 195, 272, 35);
		add(tfFesearch);
		tfFesearch.setColumns(10);
		
		btnFeAllSearch = new JButton("검색");
		btnFeAllSearch.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));
		btnFeAllSearch.setBounds(732, 195, 88, 35);
		add(btnFeAllSearch);

		spAllFest = new JScrollPane();
		spAllFest.setBounds(200, 270, 722, 338);
		add(spAllFest);

//		AllFestList.setModel(new DefaultTableModel(new Object[][] {},
//				new String[] { "축제 코드", "축제 이름", "축제장소",	"축제 시작일", "축제 종료일","축제 시간", "축제 주최측", "진행 여부" }));
					
						
		spAllFest.setViewportView(AllFestList);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\04-09\\eclipse-workspace\\project\\src\\img\\btitle.png"));
		lblNewLabel.setBounds(97, 53, 254, 74);
		add(lblNewLabel);
	}

	void eventProc() {
		tfFesearch.addActionListener(this);
		btnFeAllSearch.addActionListener(this);

	}

	public void actionPerformed(ActionEvent ev) {
		Object o = ev.getSource();
		//축제 검색 시 
		if (o == tfFesearch) {
			searchTable();
		//축제 전체 리스트 출력하는 것
		}else if (o==btnFeAllSearch){
			searchTable();	
		}
	}
	
	void allfestSearch() {
		try {		
			searchTable(); 
		}catch(Exception ee) {
			JOptionPane.showMessageDialog(null, "축제 출력 실패:" + ee.getMessage());
		}
		
	}

	//축제 검색시 받아오는 정보를 리스트로 뽑아염
	void searchTable() {
		int sel=cbFesSearch.getSelectedIndex();
		String text = tfFesearch.getText();
		try {
			list =dao.festSearch(sel, text);
			tmFe.data=list;
			AllFestList.setModel(tmFe);
			tmFe.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "축제 검색 실패:" + e.getMessage());
		}
	}
}

	class FeTableModel extends AbstractTableModel {
		
		ArrayList data = new ArrayList();
		String[] columNames = { "축제 코드", "축제 이름", "축제 장소", "축제 시작일", "축제 종료일", "축제 시간", "축제 주최측", "진행 여부" };

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return data.size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return columNames.length;
		}

		@Override
		public Object getValueAt(int row, int col) {
			// TODO Auto-generated method stub
			ArrayList temp = (ArrayList) data.get(row);
			return temp.get(col);
		}

		public String getColumnName(int col) {
			return columNames[col];
		}
	}

