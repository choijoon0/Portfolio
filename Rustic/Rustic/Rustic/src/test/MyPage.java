package test;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.AbstractListModel;

public class MyPage extends JPanel {
	
	/**
	 * Create the panel.
	 */
	public MyPage() {
		setBackground(new Color(0, 128, 128));
		setBounds(0, 0, 639, 498);
		setLayout(null);
		setVisible(true);
		
		JPanel NamePanel = new JPanel();
		NamePanel.setBackground(new Color(0, 128, 128));
		NamePanel.setBounds(12, 60, 246, 55);
		add(NamePanel);
		NamePanel.setLayout(null);
		
		JLabel My_Name = new JLabel("NAME");
		My_Name.setForeground(new Color(255, 255, 255));
		My_Name.setFont(new Font("Dialog", Font.BOLD, 14));
		My_Name.setBounds(12, 10, 67, 35);
		NamePanel.add(My_Name);
		
		JTextPane Tx_Name = new JTextPane();
		Tx_Name.setBounds(72, 10, 162, 35);
		NamePanel.add(Tx_Name);
		
		JPanel AddrPanel = new JPanel();
		AddrPanel.setBackground(new Color(0, 128, 128));
		AddrPanel.setBounds(12, 125, 246, 55);
		add(AddrPanel);
		AddrPanel.setLayout(null);
		
		JLabel My_Address = new JLabel("ADDR");
		My_Address.setForeground(new Color(255, 255, 255));
		My_Address.setFont(new Font("Dialog", Font.BOLD, 14));
		My_Address.setBounds(12, 10, 67, 35);
		AddrPanel.add(My_Address);
		
		JTextPane Tx_Addr = new JTextPane();
		Tx_Addr.setBounds(72, 10, 162, 35);
		AddrPanel.add(Tx_Addr);
		
		JPanel PhPanel = new JPanel();
		PhPanel.setBackground(new Color(0, 128, 128));
		PhPanel.setBounds(12, 190, 246, 55);
		add(PhPanel);
		PhPanel.setLayout(null);
		
		JLabel My_Phone = new JLabel("PHONE");
		My_Phone.setForeground(new Color(255, 255, 255));
		My_Phone.setFont(new Font("Dialog", Font.BOLD, 14));
		My_Phone.setBounds(12, 10, 67, 35);
		PhPanel.add(My_Phone);
		
		JTextPane Tx_Phone = new JTextPane();
		Tx_Phone.setBounds(72, 10, 162, 35);
		PhPanel.add(Tx_Phone);
		
		JList<Object> list = new JList<Object>();
		list.setModel(new AbstractListModel<Object>() {
			String[] values = new String[] {"가나다", "가나", "다"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(270, 60, 357, 347);
		add(list);
		
		JLabel My_Info = new JLabel("MY PAGE");
		My_Info.setForeground(new Color(255, 255, 255));
		My_Info.setHorizontalAlignment(SwingConstants.CENTER);
		My_Info.setFont(new Font("Dialog", Font.BOLD, 15));
		My_Info.setBounds(12, 10, 246, 40);
		add(My_Info);
		
		JLabel My_Info_1 = new JLabel("RESERVATION LIST");
		My_Info_1.setForeground(new Color(255, 255, 255));
		My_Info_1.setHorizontalAlignment(SwingConstants.CENTER);
		My_Info_1.setFont(new Font("Dialog", Font.BOLD, 15));
		My_Info_1.setBounds(270, 10, 357, 40);
		add(My_Info_1);
		
		JButton OKbtn = new JButton("확정");
		OKbtn.setBackground(new Color(255, 215, 0));
		OKbtn.setFont(new Font("함초롬돋움", Font.BOLD, 14));
		OKbtn.setBounds(35, 428, 120, 45);
		add(OKbtn);
		
		JButton NObtn = new JButton("취소");
		NObtn.setFont(new Font("함초롬돋움", Font.BOLD, 14));
		NObtn.setBackground(new Color(0, 128, 128));
		NObtn.setBounds(185, 428, 120, 45);
		add(NObtn);
		
		JButton DETAILbtn = new JButton("예약내역");
		DETAILbtn.setFont(new Font("함초롬돋움", Font.BOLD, 14));
		DETAILbtn.setBackground(new Color(0, 128, 128));
		DETAILbtn.setBounds(335, 428, 120, 45);
		add(DETAILbtn);
		
		JButton MYREbtn = new JButton("나의 리뷰");
		MYREbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		MYREbtn.setFont(new Font("함초롬돋움", Font.BOLD, 14));
		MYREbtn.setBackground(new Color(0, 128, 128));
		MYREbtn.setBounds(485, 428, 120, 45);
		add(MYREbtn);
		setVisible(true);
		
		
	}
}
