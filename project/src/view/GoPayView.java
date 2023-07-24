package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import model.PayGoDAO;
import model.rec.PayGoVO;
import view.CardPayView.RecentListTableModel;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

public class GoPayView extends JFrame implements ActionListener {

	JPanel contentPane;
	JTextField tfGoodsTot, tfPayName, tfPayCode;
	JPanel panel;
	JScrollPane scrollPane;
	JLabel lblNewLabel, lblNewLabel_1, lblNewLabel_2, lblNewLabel_3, lblNewLabel_4;
	JComboBox comBank;
	JButton btnPayGo;
	RecentListTableModel rListTable;
	ArrayList list;
	PayGoDAO dao;
	PayGoVO vo;
	int pk, jucode;
	String req;
	private JTable table;

	public GoPayView(int mempk, int jumuncode, int tot, String request) {
		newObject();
		addLayout();
		eventProc();
		jucode = jumuncode;
		req = request;
		pk = mempk;
		try {
			dao = new PayGoDAO();
			selectBuyTable(jumuncode);
			tfGoodsTot.setText(String.valueOf(tot));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	void newObject() {
		contentPane = new JPanel();
		panel = new JPanel();
		scrollPane = new JScrollPane();
		rListTable = new RecentListTableModel();
		table = new JTable();
		scrollPane.setViewportView(table);

		lblNewLabel = new JLabel("총 결제금액");
		lblNewLabel_1 = new JLabel("은행명");
		lblNewLabel_2 = new JLabel("예금주명");
		lblNewLabel_3 = new JLabel("계좌번호");
		lblNewLabel_4 = new JLabel("계좌이체");

		comBank = new JComboBox();
		comBank.setModel(new DefaultComboBoxModel(new String[] {"BC카드", "현대카드", "삼성카드", "국민카드", "신한카드"}));

		tfGoodsTot = new JTextField();
		tfPayName = new JTextField();
		tfPayCode = new JTextField();

		btnPayGo = new JButton("결제하기");
	}

	void addLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 518);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel.setBounds(29, 74, 554, 138);
		contentPane.add(panel);
		panel.setLayout(null);

		scrollPane.setBounds(12, 10, 530, 118);
		panel.add(scrollPane);

		lblNewLabel.setBounds(388, 222, 75, 25);
		contentPane.add(lblNewLabel);

		tfGoodsTot.setEditable(false);
		tfGoodsTot.setBounds(475, 224, 116, 21);
		contentPane.add(tfGoodsTot);
		tfGoodsTot.setColumns(10);

		lblNewLabel_1.setBounds(29, 280, 57, 15);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2.setBounds(29, 324, 57, 15);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3.setBounds(29, 379, 57, 15);
		contentPane.add(lblNewLabel_3);

		comBank.setBounds(98, 261, 125, 34);
		contentPane.add(comBank);

		tfPayName.setBounds(98, 321, 116, 21);
		contentPane.add(tfPayName);
		tfPayName.setColumns(10);

		tfPayCode.setBounds(98, 376, 231, 25);
		contentPane.add(tfPayCode);
		tfPayCode.setColumns(10);

		btnPayGo.setBounds(447, 375, 116, 42);
		contentPane.add(btnPayGo);

		lblNewLabel_4.setBounds(157, 10, 172, 42);
		contentPane.add(lblNewLabel_4);
	}

	void eventProc() {
		btnPayGo.addActionListener(this);
	}
	//구매한 상품 리스트 출력
	void selectBuyTable(int jumuncode) {
		try {
			list = dao.buyTable(jumuncode);
			rListTable.data = list;
			table.setModel(rListTable);
			rListTable.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "검색 실패"+ e.getMessage());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o == btnPayGo) {
			String bankname = String.valueOf(comBank.getSelectedItem());
			String goname = tfPayName.getText();
			String gonum = tfPayCode.getText();

			vo = new PayGoVO(bankname, goname, gonum, jucode);
			try {
				dao.ingopay(vo);
				try {
					vo = new PayGoVO(jucode, req, pk);
					dao.upjumun(vo);
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "주문 테이블 ㄴㄴ!!");
				}
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "카드정보 인서트 ㄴㄴ!!");
			}
			JOptionPane.showMessageDialog(null, "결제가 완료되었습니다!!");
			dispose();
		}
	}
	class RecentListTableModel extends AbstractTableModel {

		ArrayList data = new ArrayList();
		String[] columnNames = { "상품명", "상품가격", "구매수량", "금액" };

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

//          기본적으로 A, B, C, D 라는 이름으로 컬럼명이 지정된다
		public String getColumnName(int col) {
			return columnNames[col];
		}
	}
}
