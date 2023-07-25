package mainpage;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextPane;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JMonthChooser;
import com.toedter.components.JSpinField;

import SignUp.FrameLogin;

import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JDayChooser;

import dao.MemberDao;
import dao.MenuDAO;

import dao.resDAO;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Reservation extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservation frame = new Reservation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 * @param id 
	 */
	public Reservation(int select_menuNum, String id) {	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 555);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCustomerInfo = new JLabel("CUSTOMER INFO");
		lblCustomerInfo.setForeground(Color.WHITE);
		lblCustomerInfo.setFont(new Font("πŸ≈¡", Font.BOLD, 14));
		lblCustomerInfo.setBounds(28, 20, 162, 38);
		contentPane.add(lblCustomerInfo);
		
		 JTextPane Tx_Title = new JTextPane();
		 Tx_Title.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
	      Tx_Title.setBounds(28, 56, 317, 38);
	      contentPane.add(Tx_Title);
	      Tx_Title.setText(String.valueOf(select_menuNum));
	      JPanel panel = new JPanel();
	      panel.setBounds(28, 104, 451, 300);
	      contentPane.add(panel);
	      panel.setLayout(null);
		
		JLabel startdateText = new JLabel("\uC785\uC2E4\uB0A0\uC9DC");
		startdateText.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
		startdateText.setBounds(12, 10, 150, 34);
		panel.add(startdateText);
		
		JLabel enddateText = new JLabel("\uD1F4\uC2E4\uB0A0\uC9DC");
		enddateText.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
		enddateText.setBounds(12, 84, 150, 34);
		panel.add(enddateText);
		
		JLabel startdateBox = new JLabel("");
		startdateBox.setBounds(12, 42, 150, 21);
		panel.add(startdateBox);
		
		JLabel enddateBox = new JLabel("");
		enddateBox.setBounds(12, 117, 150, 21);
		panel.add(enddateBox);
		//¿‘Ω« ≥Ø¬•
		JButton checkinBtn = new JButton("≥Ø¬• º±≈√");
		checkinBtn.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
		checkinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		checkinBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String chckin;
				clenderView celvw = new clenderView();
				celvw.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				
				//Ω√¿€
				celvw.setModal(true);
				
				
				celvw.setVisible(true);
				
				chckin = celvw.getCals();
				
				startdateBox.setText(chckin);
	
			
	            
			}
		});
		checkinBtn.setBounds(184, 42, 97, 23);
		panel.add(checkinBtn);
		
		//≈Ω«≥Ø¬•
		JButton checkoutBtn = new JButton("≥Ø¬• º±≈√");
		checkoutBtn.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
		checkoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		checkoutBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String chckout;
				clenderView celvw = new clenderView();
				celvw.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				
				//Ω√¿€
				celvw.setModal(true);
				
				
				celvw.setVisible(true);
				
				chckout = celvw.getCals();
				
				enddateBox.setText(chckout);
	
			
	            
			}
		});
		
		checkoutBtn.setBounds(184, 115, 97, 23);
		panel.add(checkoutBtn);
		
		JComboBox paymethodCombo = new JComboBox();
		paymethodCombo.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
		paymethodCombo.setModel(new DefaultComboBoxModel(new String[] {"\uCE74\uB4DC", "\uACC4\uC88C\uC774\uCCB4"}));
		paymethodCombo.setBounds(74, 251, 66, 23);
		panel.add(paymethodCombo);
		
		JLabel lblNewLabel_1 = new JLabel("\uACB0\uC81C\uC218\uB2E8");
		lblNewLabel_1.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(12, 255, 52, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC778\uC6D0");
		lblNewLabel_2.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(12, 176, 52, 15);
		panel.add(lblNewLabel_2);
		
		JComboBox peoplecntcombo = new JComboBox();
		peoplecntcombo.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
		peoplecntcombo.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		peoplecntcombo.setBounds(74, 172, 66, 23);
		panel.add(peoplecntcombo);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
		textPane.setBounds(28, 437, 466, 38);
		contentPane.add(textPane);
		
		JLabel lblDateView = new JLabel("DATE VIEW");
		lblDateView.setForeground(Color.WHITE);
		lblDateView.setFont(new Font("πŸ≈¡", Font.BOLD, 14));
		lblDateView.setBounds(28, 398, 146, 38);
		contentPane.add(lblDateView);
		
		JLabel lblRoomInfo = new JLabel("ROOM INFORMATION");
		lblRoomInfo.setForeground(Color.WHITE);
		lblRoomInfo.setFont(new Font("πŸ≈¡", Font.BOLD, 14));
		lblRoomInfo.setBounds(535, 41, 251, 38);
		contentPane.add(lblRoomInfo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(534, 89, 385, 332);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel menunameBox = new JLabel("\uBA54\uB274\uBA85");
		menunameBox.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
		menunameBox.setBounds(48, 30, 123, 15);
		panel_1.add(menunameBox);
		
		JLabel AddrDtBox = new JLabel("\uC0C1\uC138\uC8FC\uC18C");
		AddrDtBox.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
		AddrDtBox.setBounds(193, 55, 123, 15);
		panel_1.add(AddrDtBox);
		
		JLabel addrBox = new JLabel("\uC8FC\uC18C");
		addrBox.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
		addrBox.setBounds(58, 55, 123, 15);
		panel_1.add(addrBox);
		
		JLabel bongcntBox = new JLabel("\uBC29\uAC1C\uC218");
		bongcntBox.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
		bongcntBox.setBounds(79, 80, 123, 15);
		panel_1.add(bongcntBox);
		
		JLabel menuintroduceBox = new JLabel("\uBA54\uB274\uC18C\uAC1C");
		menuintroduceBox.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
		menuintroduceBox.setBounds(26, 178, 319, 77);
		panel_1.add(menuintroduceBox);
		
		JLabel squaremesureBox = new JLabel("\uD3C9\uC218");
		squaremesureBox.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
		squaremesureBox.setBounds(79, 105, 123, 15);
		panel_1.add(squaremesureBox);
		
		JLabel sunBox = new JLabel("\uBC30\uC0B0\uC784\uC218");
		sunBox.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
		sunBox.setBounds(79, 128, 123, 15);
		panel_1.add(sunBox);
		
		JLabel ownerNameBox = new JLabel("\uC9D1\uC8FC\uC778 \uC774\uB984");
		ownerNameBox.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
		ownerNameBox.setBounds(79, 265, 123, 15);
		panel_1.add(ownerNameBox);
		
		JLabel ownerPhoneBox = new JLabel("\uC9D1\uC8FC\uC778 \uD3F0\uB118\uBC84");
		ownerPhoneBox.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
		ownerPhoneBox.setBounds(119, 297, 123, 15);
		panel_1.add(ownerPhoneBox);
		
		JButton btnNewButton = new JButton("øπæ‡«œ±‚");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		//daoø¨∞·
		MemberDao dao = MemberDao.getInstance();
	    //int mypageList = dao.find_custnum(id);
		resDAO resdao = resDAO.getInstance();
		
	   
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//øπæ‡»Æ¿Œ πˆ∆∞
				
				String start = startdateBox.getText();
				String end = enddateBox.getText();
				long diffDays=0;
				int custnum = 0;
				custnum= dao.find_custnum(id);
				try {
					
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					Date beginDate = formatter.parse(start);
					Date endDate = formatter.parse(end);
					
					// Ω√∞£¬˜¿Ã∏¶ Ω√∞£,∫–,√ ∏¶ ∞ˆ«— ∞™¿∏∑Œ ≥™¥©∏È «œ∑Á ¥‹¿ß∞° ≥™ø»
					long diff = endDate.getTime() - beginDate.getTime();
					diffDays = diff / (24 * 60 * 60 * 1000);
					
			
					try {
						resdao.insertres(paymethodCombo.getSelectedItem().toString(), select_menuNum, custnum, startdateBox.getText(), enddateBox.getText(), peoplecntcombo.getSelectedItem().toString(), diffDays);
						JOptionPane.showMessageDialog(null, "øπæ‡ øœ∑·");
						dispose();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (ParseException e4) {
					e4.printStackTrace();
				}
				
				
			}
		});
		
																
		
		btnNewButton.setFont(new Font("πŸ≈¡", Font.BOLD, 14));
		btnNewButton.setBounds(774, 437, 146, 38);
		contentPane.add(btnNewButton);
		
		MenuDAO dao1 = MenuDAO.getInstance();
		ArrayList list = dao1.select_All(select_menuNum);
		// MENUNAME, ADDRESS, ADDRESSDETAIL, BANGCOUNT, SQUAREMESURE, SUNDIRECTION, MENUINTRODUCE, OWNERNUM
		 //≥◊¿”, ¡÷º“, ªÛºº¡÷º“, πÊ∞≥ºˆ, ∆Úºˆ, πËªÍ¿”ºˆ, ∏ﬁ¥∫º“∞≥, ø¿¥ı≥—
		menunameBox.setText(list.get(0).toString());
		addrBox.setText(list.get(1).toString());
		AddrDtBox.setText(list.get(2).toString());
		bongcntBox.setText(list.get(3).toString());
		squaremesureBox.setText(list.get(4).toString());
		sunBox.setText(list.get(5).toString());
		menuintroduceBox.setText(list.get(6).toString());
	
		int ownernum = (Integer)list.get(7);
		ArrayList list_ow = dao1.select_owner(ownernum);
		ownerNameBox.setText(list_ow.get(0).toString());

		ownerPhoneBox.setText(list_ow.get(1).toString());
		
		JLabel lblNewLabel_3 = new JLabel("\uBC29 :");
		lblNewLabel_3.setFont(new Font("πŸ≈¡", Font.BOLD, 14));
		lblNewLabel_3.setBounds(12, 28, 52, 15);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uC8FC\uC18C :");
		lblNewLabel_4.setFont(new Font("πŸ≈¡", Font.BOLD, 14));
		lblNewLabel_4.setBounds(12, 54, 52, 15);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\uBC29 \uAC1C\uC218 :");
		lblNewLabel_5.setFont(new Font("πŸ≈¡", Font.BOLD, 14));
		lblNewLabel_5.setBounds(12, 80, 76, 15);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\uD3C9\uC218 :");
		lblNewLabel_6.setFont(new Font("πŸ≈¡", Font.BOLD, 14));
		lblNewLabel_6.setBounds(12, 102, 52, 15);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\uD3C9");
		lblNewLabel_7.setFont(new Font("πŸ≈¡", Font.BOLD, 14));
		lblNewLabel_7.setBounds(119, 105, 52, 15);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("\uBC29\uD5A5 :");
		lblNewLabel_8.setFont(new Font("πŸ≈¡", Font.BOLD, 14));
		lblNewLabel_8.setBounds(12, 127, 52, 15);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("\uD5A5");
		lblNewLabel_9.setFont(new Font("πŸ≈¡", Font.BOLD, 14));
		lblNewLabel_9.setBounds(119, 130, 52, 15);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("\uBC29 \uC124\uBA85 :");
		lblNewLabel_10.setFont(new Font("πŸ≈¡", Font.BOLD, 14));
		lblNewLabel_10.setBounds(12, 153, 76, 15);
		panel_1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("\uC8FC\uC778\uBA85 :");
		lblNewLabel_11.setFont(new Font("πŸ≈¡", Font.BOLD, 14));
		lblNewLabel_11.setBounds(12, 265, 76, 15);
		panel_1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("\uC8FC\uC778 \uC5F0\uB77D\uCC98 :");
		lblNewLabel_12.setFont(new Font("πŸ≈¡", Font.BOLD, 14));
		lblNewLabel_12.setBounds(12, 296, 99, 15);
		panel_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setForeground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setForeground(Color.white);
			}
		});
		lblNewLabel.setFont(new Font("±º∏≤", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(936, 10, 18, 26);
		contentPane.add(lblNewLabel);
		
		setLocationRelativeTo(null);
		
	}
}
