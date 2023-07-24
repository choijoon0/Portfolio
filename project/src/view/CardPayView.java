package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import model.PayCardDAO;
import model.rec.PayCardVO;

public class CardPayView extends JFrame implements ActionListener {

	JPanel contentPane;
	JPanel panel;
	JTextField tfCVC, tfCardNum1, tfCardNum2, tfCardNum3, tfCardNum4, tfGoodsTot;
	JTable table;
	JScrollPane scrollPane;
	JLabel lblNewLabel, lblNewLabel_1, lblNewLabel_2, lblNewLabel_3, lblNewLabel_4, lblNewLabel_5, lblNewLabel_6,
			lblNewLabel_7, lblNewLabel_8, lblNewLabel_9,lblNewLabel_10;
	JComboBox comBank, comMonth, comYear;

	JButton btnPay;
	RecentListTableModel rListTable;

	PayCardVO vo;
	PayCardDAO dao;
	int pk, jpk, totel;
	String requset;
	ArrayList list;
	public CardPayView(int mempk, int jumuncode, int tot, String req) {
		newObject();
		addLayout();
		eventProc();
		pk = mempk;
		jpk = jumuncode;
		totel = tot;
		requset = req;
		try {
			dao = new PayCardDAO();
			tfGoodsTot.setText(String.valueOf(tot));
			selectBuyTable(jumuncode);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	void addLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 512);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel.setBounds(38, 202, 57, 15);
		contentPane.add(lblNewLabel);

		lblNewLabel_1.setBounds(38, 241, 57, 15);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2.setBounds(38, 291, 57, 15);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3.setBounds(38, 339, 57, 15);
		contentPane.add(lblNewLabel_3);

		comBank.setBounds(114, 198, 88, 19);
		contentPane.add(comBank);

		comMonth.setBounds(124, 335, 78, 19);
		contentPane.add(comMonth);

		comYear.setBounds(243, 335, 88, 19);
		contentPane.add(comYear);

		lblNewLabel_4.setBounds(209, 339, 57, 15);
		contentPane.add(lblNewLabel_4);

		lblNewLabel_5.setBounds(343, 339, 57, 15);
		contentPane.add(lblNewLabel_5);

		tfCVC.setBounds(100, 288, 116, 21);
		contentPane.add(tfCVC);
		tfCVC.setColumns(10);

		tfCardNum1.setBounds(100, 238, 116, 21);
		contentPane.add(tfCardNum1);
		tfCardNum1.setColumns(10);

		tfCardNum2.setBounds(253, 238, 116, 21);
		contentPane.add(tfCardNum2);
		tfCardNum2.setColumns(10);

		tfCardNum3.setBounds(393, 238, 116, 21);
		contentPane.add(tfCardNum3);
		tfCardNum3.setColumns(10);

		tfCardNum4.setBounds(529, 238, 116, 21);
		contentPane.add(tfCardNum4);
		tfCardNum4.setColumns(10);

		lblNewLabel_6.setBounds(222, 241, 57, 15);
		contentPane.add(lblNewLabel_6);

		lblNewLabel_7.setBounds(378, 241, 57, 15);
		contentPane.add(lblNewLabel_7);

		lblNewLabel_8.setBounds(509, 241, 57, 15);
		contentPane.add(lblNewLabel_8);

		btnPay.setBounds(469, 335, 116, 52);
		contentPane.add(btnPay);

		lblNewLabel_9.setBounds(408, 202, 88, 15);
		contentPane.add(lblNewLabel_9);

		tfGoodsTot.setEditable(false);
		tfGoodsTot.setBounds(517, 199, 116, 21);
		contentPane.add(tfGoodsTot);
		tfGoodsTot.setColumns(10);

		panel.setBounds(61, 52, 482, 112);
		contentPane.add(panel);
		panel.setLayout(null);

		scrollPane.setBounds(12, 10, 458, 92);
		panel.add(scrollPane);

		scrollPane.setViewportView(table);

		lblNewLabel_10.setBounds(222, 10, 135, 30);
		contentPane.add(lblNewLabel_10);
	}

	void newObject() {
		contentPane = new JPanel();
		panel = new JPanel();
		rListTable = new RecentListTableModel();
		table = new JTable(rListTable);
		scrollPane = new JScrollPane();
		lblNewLabel = new JLabel("카드사");
		lblNewLabel_1 = new JLabel("카드번호");
		lblNewLabel_3 = new JLabel("유효기간");
		lblNewLabel_2 = new JLabel("CVC");
		lblNewLabel_4 = new JLabel("월");
		lblNewLabel_5 = new JLabel("년");
		lblNewLabel_6 = new JLabel("-");
		lblNewLabel_7 = new JLabel("-");
		lblNewLabel_8 = new JLabel("-");
		lblNewLabel_9 = new JLabel("총 결제금액");
		lblNewLabel_10 = new JLabel("카드결제");
		comBank = new JComboBox();
		comBank.setModel(new DefaultComboBoxModel(new String[] { "BC카드", "현대카드", "삼성카드", "국민카드", "신한카드" }));
		comMonth = new JComboBox();
		comMonth.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comYear = new JComboBox();
		comYear.setModel(
				new DefaultComboBoxModel(new String[] { "2023", "2024", "2025", "2026", "2027", "2028", "2029" }));

		tfCVC = new JTextField();
		tfCardNum1 = new JTextField();
		tfCardNum2 = new JTextField();
		tfCardNum3 = new JTextField();
		tfCardNum4 = new JTextField();
		tfGoodsTot = new JTextField();

		btnPay = new JButton("결제하기");

	}

	void eventProc() {
		btnPay.addActionListener(this);
	}
	
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
		if (o == btnPay) {
			try {
				String bankname = String.valueOf(comBank.getSelectedItem());
				String cardnum = tfCardNum1.getText() + "-" + tfCardNum2.getText() + "-" + tfCardNum3.getText() + "-"
						+ tfCardNum4.getText();
				int cvc = Integer.parseInt(tfCVC.getText());
				String yuhyo = String.valueOf(comMonth.getSelectedItem()) + "월"
						+ String.valueOf(comYear.getSelectedItem()) + "년";
				vo = new PayCardVO(bankname, cardnum, cvc, yuhyo, jpk, requset);
				dao.incardpay(vo);
				try {
					vo = new PayCardVO(jpk, requset, pk);
					dao.upjumun(vo);
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "업주문 ㄴㄴ!!" + e2.getMessage());
				}
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "카드인서트 ㄴㄴ!!" + e2.getMessage());
			}
			JOptionPane.showMessageDialog(null, "결제완료!!");
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
