package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import model.BoothYNDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ImageIcon;



public class BoothYNView extends JPanel implements ActionListener {
	JLabel lblBthNO, lblBthYES;
	JPanel pBthNo, pBthYES;
	JScrollPane spBthNO, spBthYES;
	JTable tableBthNO, tableBthYES;
	BthNoModel tmBthNO;
	BthYesModel tmBthYES;
	BoothYNDAO dao = null;
	ArrayList list = null;
	JButton btnCancel;
	int memcode;
	JButton btnReset;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	
	
	public BoothYNView(BoothMainView boothMainView, int pk) {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		newObject();
		setLayout();
		eventProc();
		memcode = pk;
		try {
			dao = new BoothYNDAO();
			System.out.println("DB 연결 성공");
			selectNoTable(pk);		
			selectYesTable(pk);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, " DB연결 실패 : " + e.getMessage());
		}

	}

	void newObject() {
		lblBthNO = new JLabel("확정 여부 NO");
		lblBthNO.setBackground(new Color(255, 255, 202));
		
		pBthNo = new JPanel();
		pBthNo.setLayout(null);
		spBthNO = new JScrollPane();
		tmBthNO = new BthNoModel();
		btnCancel = new JButton("신청취소");
		
		tableBthNO = new JTable(tmBthNO);
		tableBthNO.setFont(new Font("양재인장체M", Font.PLAIN, 12));
		btnReset = new JButton("");
		btnReset.setBorderPainted(false);
		btnReset.setIcon(new ImageIcon("C:\\Users\\04-09\\eclipse-workspace\\project\\src\\img\\reset.png"));
		
		lblBthYES = new JLabel("확정 여부 YES");
		
		pBthYES = new JPanel();
		spBthYES = new JScrollPane();
		tmBthYES = new BthYesModel();
		tableBthYES = new JTable(tmBthYES);
		tableBthYES.setFont(new Font("양재인장체M", Font.PLAIN, 12));

	}

	void setLayout() {
		
		lblNewLabel_1 = new JLabel("부스 확정 뷰");
		lblNewLabel_1.setFont(new Font("양재튼튼체B", Font.BOLD, 25));
		lblNewLabel_1.setBounds(140, 31, 195, 42);
		add(lblNewLabel_1);
		// 확정 여부 No
		lblBthNO.setBounds(447, 94, 204, 42);
		lblBthNO.setFont(new Font("양재튼튼체B", Font.BOLD, 20));
		add(lblBthNO);

		pBthNo.setBounds(212, 162, 671, 226);
		add(pBthNo);

		spBthNO.setBounds(0, 0, 671, 226);
		pBthNo.add(spBthNO);

		spBthNO.setViewportView(tableBthNO);

		// 확정 여부 YES
		lblBthYES.setBounds(447, 412, 145, 23);
		lblBthYES.setFont(new Font("양재튼튼체B", Font.BOLD, 20));
		add(lblBthYES);

		pBthYES.setBounds(212, 458, 671, 230);
		add(pBthYES);
		pBthYES.setLayout(null);

		spBthYES.setBounds(0, 0, 671, 230);
		pBthYES.add(spBthYES);

		spBthYES.setViewportView(tableBthYES);
		
		
		btnCancel.setBounds(773, 121, 110, 23);
		btnCancel.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));
		btnCancel.setBackground(Color.white);
		add(btnCancel);
		
		
		btnReset.setBounds(908, 102, 75, 42);
		btnReset.setFont(new Font("양재튼튼체B", Font.PLAIN, 20));
		btnReset.setBackground(Color.white);
		add(btnReset);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\04-09\\eclipse-workspace\\project\\src\\img\\btitle.png"));
		lblNewLabel.setBounds(85, 20, 276, 67);
		add(lblNewLabel);
	}

	void eventProc() {
		btnCancel.addActionListener(this);
		btnReset.addActionListener(this);
		
		tableBthYES.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int col = 0;
				int row = tableBthYES.getSelectedRow();
				
				int num = (int)tableBthYES.getValueAt(row, col);
				AddGoodsView addGoods;
				addGoods = new AddGoodsView(num);
				addGoods.setVisible(true);

			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == btnCancel){
			int row = tableBthNO.getSelectedRow();
			int col = 0;
			int vNum = (int) tableBthNO.getValueAt(row, col);
			try {
				dao.resCancel(vNum);
				selectNoTable(memcode);
			
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}else if(o==btnReset) {
			selectNoTable(memcode);
			selectYesTable(memcode);
		}
	}
	
	void selectNoTable(int pk) {
		try {
			
			list = dao.BthNoList(pk);
			tmBthNO.data = list;
			tableBthNO.setModel(tmBthNO);
			tmBthNO.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "No 리스트 출력 실패 : " + e.getMessage());
		}
	}

	void selectYesTable(int pk) {
		try {
			
			list = dao.BthYesList(pk);
			tmBthYES.data = list;
			tableBthYES.setModel(tmBthYES);
			tmBthYES.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Yes 리스트 출력 실패 : " + e.getMessage());
		}
	}


}

class BthNoModel extends AbstractTableModel {
	ArrayList data = new ArrayList();
	String[] columnNames = { "부스코드","축제명", "축제장소", "축제시작일", "축제종료일", "부스명", "부스분류명", "예약확정여부" };

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

class BthYesModel extends AbstractTableModel {
	ArrayList data = new ArrayList();
	String[] columnNames = { "부스코드","축제명", "축제장소", "축제시작일", "축제종료일", "부스명", "부스분류명", "예약확정여부" };

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
