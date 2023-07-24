package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import model.ConcertGoPayDAO;
import model.rec.ConcertGoPayVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ConcertGoPayView extends JFrame implements ActionListener{
	JPanel contentPane;
	JLabel lblNewLabel, lblNewLabel_1, lblNewLabel_2, lblNewLabel_3, lblNewLabel_4;
	JTextField tfPayName, tfPayCode, tfTot;
	
	JComboBox comBank;
	JButton btnPayGo;
	ConcertGoPayDAO dao;
	int memcode;
	int rescode;
	ConcertGoPayVO vo;
	ArrayList list2;
	
	public ConcertGoPayView(int pk, int resnum, ArrayList list, int total) {
		newObject();
		addLayout();
		eventProc();
		memcode = pk;
		rescode = resnum;
		list2 = list;
		try {
			dao = new ConcertGoPayDAO();
			tfTot.setText(String.valueOf(total));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	void newObject() {
		lblNewLabel_4 = new JLabel("계좌이체");
		
		
		lblNewLabel_3 = new JLabel("총 결제금액");
		tfTot = new JTextField();
		
		lblNewLabel = new JLabel("은행명");
		comBank = new JComboBox();
		comBank.setModel(new DefaultComboBoxModel(new String[] { "국민은행", "신한은행", "기업은행", "농협", "카카오뱅크", "신협" }));
		lblNewLabel_1 = new JLabel("예금주명");
		tfPayName = new JTextField();
		lblNewLabel_2 = new JLabel("계좌번호");
		tfPayCode = new JTextField();
		btnPayGo = new JButton("결제하기");
	}
	
	void addLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_4.setBounds(244, 10, 107, 21);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_3.setBounds(396, 204, 71, 15);
		contentPane.add(lblNewLabel_3);

		tfTot.setEditable(false);
		tfTot.setBounds(479, 201, 116, 21);
		contentPane.add(tfTot);
		tfTot.setColumns(10);
		
		lblNewLabel.setBounds(12, 249, 57, 15);
		contentPane.add(lblNewLabel);

		comBank.setBounds(81, 239, 116, 34);
		contentPane.add(comBank);
		
		lblNewLabel_1.setBounds(12, 306, 57, 15);
		contentPane.add(lblNewLabel_1);

		tfPayName.setBounds(81, 303, 116, 21);
		contentPane.add(tfPayName);
		tfPayName.setColumns(10);
		
		lblNewLabel_2.setBounds(12, 361, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		tfPayCode.setBounds(81, 352, 242, 34);
		contentPane.add(tfPayCode);
		tfPayCode.setColumns(10);
		
		btnPayGo.setBounds(472, 357, 123, 34);
		contentPane.add(btnPayGo);
	}
	
	void eventProc() {
		btnPayGo.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ee) {
		Object o = ee.getSource();
		if(o == btnPayGo) {
			try {
				//예매좌석 인서트
				dao.inResLocation(list2, rescode);
				try {
					String bank = String.valueOf(comBank.getSelectedItem());
					String name = tfPayName.getText();
					String account = tfPayCode.getText();
					vo = new ConcertGoPayVO(bank, name, account, rescode);
					//계좌 인서트
					dao.resGoPayIn(vo);
					JOptionPane.showMessageDialog(null, "결제성공!");
					dispose();
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "결제실패!");
				}
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "예매 실패!" + e.getMessage());
			}
		}
	}
}


