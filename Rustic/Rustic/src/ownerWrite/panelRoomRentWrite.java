package ownerWrite;


import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import dao.MemberDao;
import dao.MenuDAO;
import swingTableSample.zip.*;
import mainpage.FrameDashboard;
import models.Member;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;


public class panelRoomRentWrite extends JPanel {
	   private JTextField rentAddrTxBox;
	  private JTextField rentRoomTextbox;
private JTextField addrdetailtxbox;
private JTextField squareftTxbox;
private JTextField direcTxbox;
private JComboBox rentcountRoomCombobox;
private JComboBox rentcountToiletCombobox;
private JTextField rentRoomDetailText;
private JPanel rentOwnerPhoneText;

/**
 * Create the panel.
 */
/*
public panelRoomRentWrite(Object ... n) {
	   n[0]=1;
	   n[1]="test";
	   
}*/

public panelRoomRentWrite(Object ...n) {
	  String id= n[0].toString();
	  int gubun=Integer.parseInt(n[1].toString()); 
	  try {
		  int seq=Integer.parseInt(n[2].toString());	
		  System.out.println(seq);
		
	  }
	  catch (Exception e) {
		// TODO: handle exception
	}

   setBackground(new Color(0, 128, 128));
   setBounds(0, 0, 639, 528);
   setLayout(null);
   setVisible(false);   //¿Ã∞‘ ∏¬≥™? «¡∑π¿” ¥ÎΩ¨∫∏µÂ Ω««‡Ω√ æÍ∞° ¿ÃªÛ«œ∞‘ ∂∞º≠ ≥÷æÓµ“..
   
   JPanel rentRoomPanel = new JPanel();
   rentRoomPanel.setBackground(new Color(0, 128, 128));
   rentRoomPanel.setBounds(12, 125, 240, 25);
   add(rentRoomPanel);
   rentRoomPanel.setLayout(null);
   
   JLabel rentRoomName = new JLabel("\uBC29\uC774\uB984");
   rentRoomName.setForeground(new Color(255, 255, 255));
   rentRoomName.setFont(new Font("πŸ≈¡", Font.BOLD, 14));
   rentRoomName.setBounds(10, 0, 67, 21);
   rentRoomPanel.add(rentRoomName);
  
   JTextPane rentRoomTextbox = new JTextPane();
   rentRoomTextbox.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
   rentRoomTextbox.setBounds(72, 0, 155, 21);
   rentRoomPanel.add(rentRoomTextbox);
   
   JPanel rentRoomOwnerPhone = new JPanel();
   rentRoomOwnerPhone.setBackground(new Color(0, 128, 128));
   rentRoomOwnerPhone.setBounds(12, 161, 312, 25);
   add(rentRoomOwnerPhone);
   rentRoomOwnerPhone.setLayout(null);
   
   JLabel rentOwnerPhone = new JLabel("\uB9E4\uB9E4\uC778 \uC5F0\uB77D\uCC98");
   rentOwnerPhone.setForeground(new Color(255, 255, 255));
   rentOwnerPhone.setFont(new Font("πŸ≈¡", Font.BOLD, 14));
   rentOwnerPhone.setBounds(10, 0, 92, 21);
   rentRoomOwnerPhone.add(rentOwnerPhone);
   
   MemberDao dao = MemberDao.getInstance();
   JLabel rentOwnerPhoneText = new JLabel();
   rentOwnerPhoneText.setBounds(114, 0, 191, 21);
   rentRoomOwnerPhone.add(rentOwnerPhoneText);
   String phone = dao.find_phone(id);
   rentOwnerPhoneText.setText(phone);
   
   JLabel roomRentInfoTitle = new JLabel("Rustic");
   roomRentInfoTitle.setForeground(new Color(255, 255, 255));
   roomRentInfoTitle.setHorizontalAlignment(SwingConstants.LEFT);
   roomRentInfoTitle.setFont(new Font("Segoe Print", Font.BOLD, 15));
   roomRentInfoTitle.setBounds(22, 10, 54, 25);
   add(roomRentInfoTitle);
   
   JButton rentRoomPhotoRegBtn = new JButton("\uC0AC\uC9C4\uB4F1\uB85D");
   rentRoomPhotoRegBtn.setFont(new Font("πŸ≈¡", Font.BOLD, 14));
   rentRoomPhotoRegBtn.setBackground(UIManager.getColor("Button.background"));
   rentRoomPhotoRegBtn.setBounds(364, 393, 120, 45);
   add(rentRoomPhotoRegBtn);

   JButton rentRoomWriteBtn = new JButton("\uBC29\uB4F1\uB85D\uC644\uB8CC");

  

   rentRoomWriteBtn.setFont(new Font("πŸ≈¡", Font.BOLD, 14));
   rentRoomWriteBtn.setBackground(UIManager.getColor("Button.background"));
   rentRoomWriteBtn.setBounds(498, 393, 120, 45);
   add(rentRoomWriteBtn);
   
   JPanel rentAdressPanel = new JPanel();
   rentAdressPanel.setBackground(new Color(0, 128, 128));
   rentAdressPanel.setBounds(12, 45, 379, 34);
   add(rentAdressPanel);
   rentAdressPanel.setLayout(null);
   
   JLabel rentRoomAdress = new JLabel("\uC8FC\uC18C");
   rentRoomAdress.setFont(new Font("πŸ≈¡", Font.BOLD, 13));
   rentRoomAdress.setForeground(new Color(255, 255, 255));
   rentRoomAdress.setBounds(10, 8, 28, 15);
   rentAdressPanel.add(rentRoomAdress);
   
   rentAddrTxBox = new JTextField();
   rentAddrTxBox.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
   rentAddrTxBox.setBounds(50, 6, 199, 21);
   rentAdressPanel.add(rentAddrTxBox);
   rentAddrTxBox.setColumns(10);
   //
   
   JButton btnNewButton = new JButton("\uC8FC\uC18C\uAC80\uC0C9");
   btnNewButton.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
   btnNewButton.setBounds(261, 5, 99, 23);
   rentAdressPanel.add(btnNewButton);
   btnNewButton.addMouseListener(new MouseAdapter() {
   	@Override
   	public void mouseClicked(MouseEvent e) {
   		
   		ZipSearch frame = new ZipSearch(id, gubun, 1);
			frame.setUndecorated(true);
			frame.setVisible(true);
			
   	}
   });
   
   JPanel rentRoomDetailTextPanel = new JPanel();
   rentRoomDetailTextPanel.setBackground(new Color(0, 128, 128));
   rentRoomDetailTextPanel.setBounds(12, 240, 331, 198);
   add(rentRoomDetailTextPanel);
   rentRoomDetailTextPanel.setLayout(null);
   
   rentRoomDetailText = new JTextField();
   rentRoomDetailText.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
   rentRoomDetailText.setBounds(0, 25, 331, 173);
   rentRoomDetailTextPanel.add(rentRoomDetailText);
   rentRoomDetailText.setColumns(10);
   
   JLabel rentRoomDetailLabel = new JLabel("\uC124\uBA85");
   rentRoomDetailLabel.setBounds(0, 0, 45, 22);
   rentRoomDetailTextPanel.add(rentRoomDetailLabel);
   rentRoomDetailLabel.setForeground(new Color(255, 255, 255));
   rentRoomDetailLabel.setHorizontalAlignment(SwingConstants.CENTER);
   rentRoomDetailLabel.setFont(new Font("πŸ≈¡", Font.BOLD, 15));
   
   JPanel rentRoomPhotoPanel = new JPanel();
   rentRoomPhotoPanel.setBackground(new Color(102, 205, 170));
   rentRoomPhotoPanel.setBounds(364, 125, 254, 242);
   add(rentRoomPhotoPanel);
   rentRoomPhotoPanel.setLayout(null);
   
   JLabel rentRoomPhotoLabel = new JLabel("\uC0AC\uC9C4\uB4F1\uB85D");
   rentRoomPhotoLabel.setBounds(10, 10, 50, 18);
   rentRoomPhotoLabel.setForeground(new Color(255, 255, 255));
   rentRoomPhotoLabel.setFont(new Font("πŸ≈¡", Font.BOLD, 12));
   rentRoomPhotoPanel.add(rentRoomPhotoLabel);
   
   JLabel roomRentInfoTitle_1 = new JLabel("\uC219\uBC15 \uB9E4\uBB3C \uC815\uBCF4 \uB4F1\uB85D");
   roomRentInfoTitle_1.setHorizontalAlignment(SwingConstants.LEFT);
   roomRentInfoTitle_1.setForeground(Color.WHITE);
   roomRentInfoTitle_1.setFont(new Font("πŸ≈¡", Font.BOLD, 15));
   roomRentInfoTitle_1.setBounds(71, 10, 162, 25);
   add(roomRentInfoTitle_1);
   
   JPanel rentcountToiletRoomPanel = new JPanel();
   rentcountToiletRoomPanel.setLayout(null);
   rentcountToiletRoomPanel.setBackground(new Color(0, 128, 128));
   rentcountToiletRoomPanel.setBounds(12, 196, 331, 34);
   add(rentcountToiletRoomPanel);
   
   JComboBox rentcountRoomCombobox = new JComboBox();
   rentcountRoomCombobox.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
   rentcountRoomCombobox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
   rentcountRoomCombobox.setBounds(66, 5, 68, 23);
   rentcountToiletRoomPanel.add(rentcountRoomCombobox);
   
   JLabel countRoomcLabel = new JLabel("\uAC1C");
   countRoomcLabel.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
   countRoomcLabel.setForeground(Color.WHITE);
   countRoomcLabel.setBounds(135, 9, 16, 15);
   rentcountToiletRoomPanel.add(countRoomcLabel);
   
   JLabel rentcountRoomLabel = new JLabel("\uBC29\uAC2F\uC218");
   rentcountRoomLabel.setForeground(Color.WHITE);
   rentcountRoomLabel.setFont(new Font("πŸ≈¡", Font.BOLD, 13));
   rentcountRoomLabel.setBounds(8, 8, 46, 15);
   rentcountToiletRoomPanel.add(rentcountRoomLabel);
   
   JPanel rentcountToiletRoomPanel_1 = new JPanel();
   rentcountToiletRoomPanel_1.setLayout(null);
   rentcountToiletRoomPanel_1.setBackground(new Color(0, 128, 128));
   rentcountToiletRoomPanel_1.setBounds(403, 41, 162, 34);
   add(rentcountToiletRoomPanel_1);
   
   JLabel rentcountRoomcLabel_1 = new JLabel("\uD3C9\uD615");
   rentcountRoomcLabel_1.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
   rentcountRoomcLabel_1.setForeground(Color.WHITE);
   rentcountRoomcLabel_1.setBounds(135, 9, 34, 15);
   rentcountToiletRoomPanel_1.add(rentcountRoomcLabel_1);
   
   JLabel squareftLabel = new JLabel("\uBA74\uC801");
   squareftLabel.setForeground(Color.WHITE);
   squareftLabel.setFont(new Font("πŸ≈¡", Font.BOLD, 13));
   squareftLabel.setBounds(10, 8, 46, 15);
   rentcountToiletRoomPanel_1.add(squareftLabel);
   
   squareftTxbox = new JTextField();
   squareftTxbox.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
   squareftTxbox.setBounds(85, 6, 46, 21);
   rentcountToiletRoomPanel_1.add(squareftTxbox);
   squareftTxbox.setColumns(10);
   
   JPanel detailaddrPanel = new JPanel();
   detailaddrPanel.setLayout(null);
   detailaddrPanel.setBackground(new Color(0, 128, 128));
   detailaddrPanel.setBounds(12, 89, 240, 25);
   add(detailaddrPanel);
   
   JLabel addrdetail = new JLabel("\uC0C1\uC138\uC8FC\uC18C");
   addrdetail.setForeground(Color.WHITE);
   addrdetail.setFont(new Font("πŸ≈¡", Font.BOLD, 14));
   addrdetail.setBounds(10, 0, 67, 21);
   detailaddrPanel.add(addrdetail);
   
   addrdetailtxbox= new JTextField();
   addrdetailtxbox.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
   addrdetailtxbox.setBounds(72, 0, 156, 21);
   detailaddrPanel.add(addrdetailtxbox);
   addrdetailtxbox.setColumns(10);
   
   
   JPanel rentcountToiletRoomPanel_1_1 = new JPanel();
   rentcountToiletRoomPanel_1_1.setLayout(null);
   rentcountToiletRoomPanel_1_1.setBackground(new Color(0, 128, 128));
   rentcountToiletRoomPanel_1_1.setBounds(403, 81, 162, 34);
   add(rentcountToiletRoomPanel_1_1);
   
   JLabel rentcountRoomcLabel_1_1 = new JLabel("\uD5A5");
   rentcountRoomcLabel_1_1.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
   rentcountRoomcLabel_1_1.setForeground(Color.WHITE);
   rentcountRoomcLabel_1_1.setBounds(135, 9, 34, 15);
   rentcountToiletRoomPanel_1_1.add(rentcountRoomcLabel_1_1);
   
   JLabel direcLabel = new JLabel("\uC9D1 \uBC29\uD5A5");
   direcLabel.setForeground(Color.WHITE);
   direcLabel.setFont(new Font("πŸ≈¡", Font.BOLD, 13));
   direcLabel.setBounds(10, 8, 46, 15);
   rentcountToiletRoomPanel_1_1.add(direcLabel);
   
   direcTxbox = new JTextField();
   direcTxbox.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
   direcTxbox.setColumns(10);
   direcTxbox.setBounds(85, 6, 46, 21);
   rentcountToiletRoomPanel_1_1.add(direcTxbox);
 
   
   rentRoomWriteBtn.addMouseListener(new MouseAdapter() {
       @Override
       public void mouseClicked(MouseEvent e) {
          //µÓ∑œ πˆ∆∞
     
          MenuDAO dao = MenuDAO.getInstance();
          
          String num = dao.comenum(phone);
       
          System.out.println(rentRoomTextbox.getText() + "1");
          System.out.println(rentAddrTxBox.getText() + "2");
          System.out.println(addrdetailtxbox.getText() + "3");
          System.out.println(rentcountRoomCombobox.getSelectedItem().toString()+ "4");
          System.out.println(Integer.parseInt(squareftTxbox.getText()) + "5");
          System.out.println(rentRoomDetailText.getText() + "6");
          
       try {
       
       dao.insertmenu(rentRoomTextbox.getText(), rentAddrTxBox.getText(), addrdetailtxbox.getText(),
             Integer.parseInt(rentcountRoomCombobox.getSelectedItem().toString()), Integer.parseInt(squareftTxbox.getText()),
              rentRoomDetailText.getText(), direcTxbox.getText(), Integer.parseInt(num) );
       JOptionPane.showMessageDialog(null, "º˜π⁄ π∞«∞ µÓ∑œ øœ∑·");
       
       rentRoomTextbox.setText("");
       rentAddrTxBox.setText("");
       addrdetailtxbox.setText("");
       rentcountRoomCombobox.setSelectedIndex(0);
       direcTxbox.setText("");
       rentRoomDetailText.setText("");
       squareftTxbox.setText("");
    } catch (NumberFormatException e1) {
       // TODO Auto-generated catch block
       e1.printStackTrace();
    } catch (Exception e1) {
       // TODO Auto-generated catch block
       e1.printStackTrace();
    }
       
          
          
       }
    }); 
   
   
}

public void setAddrBox(String tot) {
	  
	    rentAddrTxBox.setText(String.valueOf(tot));
	   
}

}