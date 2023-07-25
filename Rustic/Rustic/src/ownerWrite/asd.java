package ownerWrite;


import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import dao.MemberDao;
import dao.MenuDAO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class asd extends JFrame {
	   private JTextField rentAddrTxBox;
	  private JTextField rentRoomTextbox;
private JTextField addrdetailtxbox;
private JTextField squareftTxbox;
private JTextField direcTxbox;
private JComboBox rentcountRoomCombobox;
private JComboBox rentcountToiletCombobox;
private JTextField rentRoomDetailText;
private JPanel rentOwnerPhoneText;



public asd(int menunum) {
	getContentPane().setBackground(new Color(0, 128, 128));

   setBackground(new Color(0, 128, 128));
   setBounds(0, 0, 692, 503);
   getContentPane().setLayout(null);
   setVisible(false);   //이게 맞나? 프레임 대쉬보드 실행시 얘가 이상하게 떠서 넣어둠..
   
   JPanel rentRoomPanel = new JPanel();
   rentRoomPanel.setBackground(new Color(0, 128, 128));
   rentRoomPanel.setBounds(12, 125, 240, 25);
   getContentPane().add(rentRoomPanel);
   rentRoomPanel.setLayout(null);
   
   JLabel rentRoomName = new JLabel("\uBC29\uC774\uB984");
   rentRoomName.setForeground(new Color(255, 255, 255));
   rentRoomName.setFont(new Font("Dialog", Font.BOLD, 14));
   rentRoomName.setBounds(10, 0, 67, 21);
   rentRoomPanel.add(rentRoomName);
  
   JTextPane rentRoomTextbox = new JTextPane();
   rentRoomTextbox.setBounds(68, 0, 162, 21);
   rentRoomPanel.add(rentRoomTextbox);
   
   MemberDao dao = MemberDao.getInstance();
   
   JLabel roomRentInfoTitle = new JLabel("Rustic");
   roomRentInfoTitle.setForeground(new Color(255, 255, 255));
   roomRentInfoTitle.setHorizontalAlignment(SwingConstants.LEFT);
   roomRentInfoTitle.setFont(new Font("Segoe Print", Font.BOLD, 15));
   roomRentInfoTitle.setBounds(22, 10, 54, 25);
   getContentPane().add(roomRentInfoTitle);
   
   JButton rentRoomPhotoRegBtn = new JButton("\uC0AC\uC9C4\uB4F1\uB85D");
   rentRoomPhotoRegBtn.setFont(new Font("함초롬돋움", Font.BOLD, 14));
   rentRoomPhotoRegBtn.setBackground(new Color(0, 128, 128));
   rentRoomPhotoRegBtn.setBounds(364, 393, 120, 45);
   getContentPane().add(rentRoomPhotoRegBtn);
   
   JPanel rentAdressPanel = new JPanel();
   rentAdressPanel.setBackground(new Color(0, 128, 128));
   rentAdressPanel.setBounds(12, 45, 379, 34);
   getContentPane().add(rentAdressPanel);
   rentAdressPanel.setLayout(null);
   
   JLabel rentRoomAdress = new JLabel("\uC8FC\uC18C");
   rentRoomAdress.setFont(new Font("Dialog", Font.BOLD, 13));
   rentRoomAdress.setForeground(new Color(255, 255, 255));
   rentRoomAdress.setBounds(10, 8, 28, 15);
   rentAdressPanel.add(rentRoomAdress);
   
   rentAddrTxBox = new JTextField();
   rentAddrTxBox.setBounds(50, 6, 236, 21);
   rentAdressPanel.add(rentAddrTxBox);
   rentAddrTxBox.setColumns(10);
   //
   

   
   JPanel rentRoomDetailTextPanel = new JPanel();
   rentRoomDetailTextPanel.setBackground(new Color(0, 128, 128));
   rentRoomDetailTextPanel.setBounds(12, 240, 331, 198);
   getContentPane().add(rentRoomDetailTextPanel);
   rentRoomDetailTextPanel.setLayout(null);
   
   rentRoomDetailText = new JTextField();
   rentRoomDetailText.setBounds(0, 25, 331, 173);
   rentRoomDetailTextPanel.add(rentRoomDetailText);
   rentRoomDetailText.setColumns(10);
   
   JLabel rentRoomDetailLabel = new JLabel("\uC124\uBA85");
   rentRoomDetailLabel.setBounds(0, 0, 45, 22);
   rentRoomDetailTextPanel.add(rentRoomDetailLabel);
   rentRoomDetailLabel.setForeground(new Color(255, 255, 255));
   rentRoomDetailLabel.setHorizontalAlignment(SwingConstants.CENTER);
   rentRoomDetailLabel.setFont(new Font("Dialog", Font.BOLD, 15));
   
   JPanel rentRoomPhotoPanel = new JPanel();
   rentRoomPhotoPanel.setBackground(new Color(102, 205, 170));
   rentRoomPhotoPanel.setBounds(364, 125, 254, 242);
   getContentPane().add(rentRoomPhotoPanel);
   rentRoomPhotoPanel.setLayout(null);
   
   JLabel rentRoomPhotoLabel = new JLabel("\uC0AC\uC9C4\uB4F1\uB85D");
   rentRoomPhotoLabel.setBounds(10, 10, 50, 18);
   rentRoomPhotoLabel.setForeground(new Color(255, 255, 255));
   rentRoomPhotoLabel.setFont(new Font("Dialog", Font.BOLD, 12));
   rentRoomPhotoPanel.add(rentRoomPhotoLabel);
   
   JLabel roomRentInfoTitle_1 = new JLabel("\uC219\uBC15 \uB9E4\uBB3C \uC815\uBCF4 \uB4F1\uB85D");
   roomRentInfoTitle_1.setHorizontalAlignment(SwingConstants.LEFT);
   roomRentInfoTitle_1.setForeground(Color.WHITE);
   roomRentInfoTitle_1.setFont(new Font("Dialog", Font.BOLD, 15));
   roomRentInfoTitle_1.setBounds(71, 11, 140, 25);
   getContentPane().add(roomRentInfoTitle_1);
   
   JPanel rentcountToiletRoomPanel = new JPanel();
   rentcountToiletRoomPanel.setLayout(null);
   rentcountToiletRoomPanel.setBackground(new Color(0, 128, 128));
   rentcountToiletRoomPanel.setBounds(12, 196, 331, 34);
   getContentPane().add(rentcountToiletRoomPanel);
   
   JComboBox rentcountRoomCombobox = new JComboBox();
   rentcountRoomCombobox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
   rentcountRoomCombobox.setBounds(66, 5, 68, 23);
   rentcountToiletRoomPanel.add(rentcountRoomCombobox);
   
   JLabel countRoomcLabel = new JLabel("\uAC1C");
   countRoomcLabel.setForeground(Color.WHITE);
   countRoomcLabel.setBounds(135, 9, 16, 15);
   rentcountToiletRoomPanel.add(countRoomcLabel);
   
   JLabel rentcountRoomLabel = new JLabel("\uBC29\uAC2F\uC218");
   rentcountRoomLabel.setForeground(Color.WHITE);
   rentcountRoomLabel.setFont(new Font("Dialog", Font.BOLD, 13));
   rentcountRoomLabel.setBounds(8, 8, 46, 15);
   rentcountToiletRoomPanel.add(rentcountRoomLabel);
   
   JPanel rentcountToiletRoomPanel_1 = new JPanel();
   rentcountToiletRoomPanel_1.setLayout(null);
   rentcountToiletRoomPanel_1.setBackground(new Color(0, 128, 128));
   rentcountToiletRoomPanel_1.setBounds(403, 41, 162, 34);
   getContentPane().add(rentcountToiletRoomPanel_1);
   
   JLabel rentcountRoomcLabel_1 = new JLabel("\uD3C9\uD615");
   rentcountRoomcLabel_1.setForeground(Color.WHITE);
   rentcountRoomcLabel_1.setBounds(135, 9, 34, 15);
   rentcountToiletRoomPanel_1.add(rentcountRoomcLabel_1);
   
   JLabel squareftLabel = new JLabel("\uBA74\uC801");
   squareftLabel.setForeground(Color.WHITE);
   squareftLabel.setFont(new Font("Dialog", Font.BOLD, 13));
   squareftLabel.setBounds(10, 8, 46, 15);
   rentcountToiletRoomPanel_1.add(squareftLabel);
   
   squareftTxbox = new JTextField();
   squareftTxbox.setBounds(47, 6, 79, 21);
   rentcountToiletRoomPanel_1.add(squareftTxbox);
   squareftTxbox.setColumns(10);
   
   JPanel detailaddrPanel = new JPanel();
   detailaddrPanel.setLayout(null);
   detailaddrPanel.setBackground(new Color(0, 128, 128));
   detailaddrPanel.setBounds(12, 89, 240, 25);
   getContentPane().add(detailaddrPanel);
   
   JLabel addrdetail = new JLabel("\uC0C1\uC138\uC8FC\uC18C");
   addrdetail.setForeground(Color.WHITE);
   addrdetail.setFont(new Font("Dialog", Font.BOLD, 14));
   addrdetail.setBounds(10, 0, 67, 21);
   detailaddrPanel.add(addrdetail);
   
   addrdetailtxbox= new JTextField();
   addrdetailtxbox.setBounds(72, 0, 144, 21);
   detailaddrPanel.add(addrdetailtxbox);
   addrdetailtxbox.setColumns(10);
   
   
   JPanel rentcountToiletRoomPanel_1_1 = new JPanel();
   rentcountToiletRoomPanel_1_1.setLayout(null);
   rentcountToiletRoomPanel_1_1.setBackground(new Color(0, 128, 128));
   rentcountToiletRoomPanel_1_1.setBounds(12, 149, 273, 45);
   getContentPane().add(rentcountToiletRoomPanel_1_1);
   
   JLabel rentcountRoomcLabel_1_1 = new JLabel("\uD5A5");
   rentcountRoomcLabel_1_1.setForeground(Color.WHITE);
   rentcountRoomcLabel_1_1.setBounds(191, 9, 34, 26);
   rentcountToiletRoomPanel_1_1.add(rentcountRoomcLabel_1_1);
   
   JLabel direcLabel = new JLabel("\uC9D1 \uBC29\uD5A5");
   direcLabel.setForeground(Color.WHITE);
   direcLabel.setFont(new Font("Dialog", Font.BOLD, 13));
   direcLabel.setBounds(10, 8, 46, 27);
   rentcountToiletRoomPanel_1_1.add(direcLabel);
   
   direcTxbox = new JTextField();
   direcTxbox.setBounds(60, 9, 119, 26);
   rentcountToiletRoomPanel_1_1.add(direcTxbox);
   direcTxbox.setFont(new Font("굴림", Font.PLAIN, 14));
   direcTxbox.setForeground(new Color(0, 0, 0));
   direcTxbox.setColumns(10);
   
 
   MenuDAO dao1 = MenuDAO.getInstance();
		ArrayList list = dao1.select_All(menunum);
		// MENUNAME, ADDRESS, ADDRESSDETAIL, BANGCOUNT, SQUAREMESURE, SUNDIRECTION, MENUINTRODUCE, OWNERNUM
		 //네임, 주소, 상세주소, 방개수, 평수, 배산임수, 메뉴소개, 오더넘
		rentRoomTextbox.setText(list.get(0).toString());
		rentAddrTxBox.setText(list.get(1).toString());
		addrdetailtxbox.setText(list.get(2).toString());
		rentcountRoomCombobox.setSelectedItem(list.get(3).toString());
		squareftTxbox.setText(list.get(4).toString());
		direcTxbox.setText(list.get(5).toString());
		rentRoomDetailText.setText(list.get(6).toString());
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setForeground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setForeground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 17));
		lblNewLabel.setBounds(589, 16, 36, 15);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\uC218\uC815\uD558\uAE30");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//숙박 수정
				
				try {
					
					dao.menumodify(rentRoomTextbox.getText(), rentAddrTxBox.getText(),addrdetailtxbox.getText(),rentcountRoomCombobox.getSelectedItem().toString(),squareftTxbox.getText(),direcTxbox.getText(),rentRoomDetailText.getText(),menunum);
					JOptionPane.showMessageDialog(null, "수정 완료");
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(496, 393, 122, 45);
		getContentPane().add(btnNewButton);
	
   
   
		setLocationRelativeTo(null);
   

}
}