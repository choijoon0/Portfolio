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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.ConcertCardPayDAO;
import model.rec.ConcertCardPayVO;

public class ConcertCardPayView extends JFrame implements ActionListener{

	JPanel contentPane;
	JTextField tfCardNum1, tfCardNum2, tfCardNum3, tfCardNum4, tfCVC, tfTot;
	JLabel lblNewLabel, lblNewLabel_1, lblNewLabel_2, lblNewLabel_3, lblNewLabel_4_1, lblNewLabel_4_2, lblNewLabel_4_3,
			lblNewLabel_4, lblNewLabel_4_4, lblNewLabel_5, lblNewLabel_6;
	JComboBox comBank, comMonth, comYears;
	JButton btnPay;
	ConcertCardPayDAO dao;
	ArrayList list2;
	RecentListTableModel rListTable;
	int res;
	ConcertCardPayVO vo;
	int memcode;
	
	public ConcertCardPayView(int mem, int resnum, ArrayList list, int total) {
		newObject();
		addLayout();
		eventProc();
		res = resnum;
		list2 = list;
		memcode = mem;
		try {

			dao = new ConcertCardPayDAO();
			tfTot.setText(String.valueOf(total));
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	void newObject() {
		contentPane = new JPanel();
		lblNewLabel = new JLabel("카드사");
		lblNewLabel_1 = new JLabel("카드번호");
		lblNewLabel_2 = new JLabel("CVC");
		lblNewLabel_3 = new JLabel("유효기간");
		lblNewLabel_4_1 = new JLabel("-");
		lblNewLabel_4_2 = new JLabel("-");
		lblNewLabel_4_3 = new JLabel("-");
		lblNewLabel_4 = new JLabel("월");
		lblNewLabel_4_4 = new JLabel("년");
		lblNewLabel_5 = new JLabel("총결제금액");
		lblNewLabel_6 = new JLabel("카드결제");

		comBank = new JComboBox();
		comMonth = new JComboBox();
		comYears = new JComboBox();
		tfCardNum1 = new JTextField();
		tfCardNum2 = new JTextField();
		tfCardNum3 = new JTextField();
		tfCardNum4 = new JTextField();
		tfCVC = new JTextField();
		tfTot = new JTextField();

		btnPay = new JButton("결제");
		
		
		rListTable = new RecentListTableModel();
	}

	void addLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 473);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel.setBounds(36, 185, 57, 15);
		contentPane.add(lblNewLabel);

		lblNewLabel_1.setBounds(36, 220, 57, 15);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2.setBounds(36, 269, 57, 15);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3.setBounds(36, 322, 57, 15);
		contentPane.add(lblNewLabel_3);

		comBank.setModel(new DefaultComboBoxModel(new String[] { "BC카드", "현대카드", "삼성카드", "국민카드", "신한카드" }));
		comBank.setBounds(105, 181, 98, 19);
		contentPane.add(comBank);

		tfCardNum1.setBounds(105, 217, 67, 21);
		contentPane.add(tfCardNum1);
		tfCardNum1.setColumns(10);

		tfCardNum2.setBounds(196, 217, 67, 21);
		contentPane.add(tfCardNum2);
		tfCardNum2.setColumns(10);

		tfCardNum3.setBounds(286, 217, 67, 21);
		contentPane.add(tfCardNum3);
		tfCardNum3.setColumns(10);

		tfCardNum4.setBounds(375, 217, 67, 21);
		contentPane.add(tfCardNum4);
		tfCardNum4.setColumns(10);

		lblNewLabel_4_1.setBounds(184, 220, 19, 15);
		contentPane.add(lblNewLabel_4_1);

		lblNewLabel_4_2.setBounds(265, 220, 19, 15);
		contentPane.add(lblNewLabel_4_2);

		lblNewLabel_4_3.setBounds(352, 220, 19, 15);
		contentPane.add(lblNewLabel_4_3);

		tfCVC.setBounds(98, 266, 67, 21);
		contentPane.add(tfCVC);
		tfCVC.setColumns(10);

		comMonth.setModel(new DefaultComboBoxModel(
				new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
		comMonth.setBounds(101, 318, 71, 23);
		contentPane.add(comMonth);

		comYears.setModel(
				new DefaultComboBoxModel(new String[] { "2023", "2024", "2025", "2026", "2027", "2028", "2029" }));
		comYears.setBounds(222, 318, 87, 23);
		contentPane.add(comYears);

		lblNewLabel_4.setBounds(179, 322, 57, 15);
		contentPane.add(lblNewLabel_4);

		lblNewLabel_4_4.setBounds(321, 322, 57, 15);
		contentPane.add(lblNewLabel_4_4);

		btnPay.setBounds(429, 349, 131, 41);
		contentPane.add(btnPay);

		tfTot.setEditable(false);
		tfTot.setBounds(466, 167, 116, 21);
		contentPane.add(tfTot);
		tfTot.setColumns(10);

		lblNewLabel_5.setBounds(352, 170, 102, 15);
		contentPane.add(lblNewLabel_5);

		lblNewLabel_6.setBounds(246, 10, 131, 41);
		contentPane.add(lblNewLabel_6);
	}
	
	
	
	void eventProc() {
		btnPay.addActionListener(this);
	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o== btnPay) {
			try {
				dao.inResLocation(list2, res);
			
				try {
					String bank = String.valueOf(comBank.getSelectedItem());
					String cardnum = tfCardNum1.getText()+"-"+tfCardNum2.getText()+"-"+tfCardNum3.getText()+"-"+tfCardNum4.getText();
					int cvc = Integer.parseInt(tfCVC.getText());
					String yuhyo = String.valueOf(comMonth.getSelectedItem())+"월"+String.valueOf(comYears.getSelectedItem())+"년";
					vo = new ConcertCardPayVO(bank, cardnum, yuhyo, cvc, res);

					dao.resCardIn(vo);
					
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "결제실패!");
				}
				JOptionPane.showMessageDialog(null, "예매가 완료되었습니다!");
				dispose();
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "예매 실패!" + e2.getMessage());
			}
	
		}
		
		
	}
	



}
