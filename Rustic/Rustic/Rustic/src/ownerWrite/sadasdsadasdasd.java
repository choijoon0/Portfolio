package ownerWrite;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
import swingTableSample.zip.ZipSearch;

public class sadasdsadasdasd extends JFrame {
   private JTextField saleRoomDetailText;
   private JTextField textField;
   private JTextField textField_1;
   /**
    * Create the panel.
    */
   public sadasdsadasdasd() {
		 
	  MemberDao dao = MemberDao.getInstance();
      setBackground(new Color(0, 128, 128));
      setBounds(0, 0, 639, 553);
      setLayout(null);
      setVisible(false);   //이게 맞나? 프레임 대쉬보드 실행시 얘가 이상하게 떠서 넣어둠..
      
      JPanel saleRoomPanel = new JPanel();
      saleRoomPanel.setBackground(new Color(0, 128, 128));
      saleRoomPanel.setBounds(12, 41, 240, 25);
      add(saleRoomPanel);
      saleRoomPanel.setLayout(null);
      
      JLabel saleRoomName = new JLabel("\uBC29\uC774\uB984");
      saleRoomName.setForeground(new Color(255, 255, 255));
      saleRoomName.setFont(new Font("Dialog", Font.BOLD, 14));
      saleRoomName.setBounds(10, 0, 67, 21);
      saleRoomPanel.add(saleRoomName);
      
      JTextPane saleRoomTextbox = new JTextPane();
      saleRoomTextbox.setBounds(68, 0, 162, 21);
      saleRoomPanel.add(saleRoomTextbox);
      
      JPanel saleRoomOwnerPhone = new JPanel();
      saleRoomOwnerPhone.setBackground(new Color(0, 128, 128));
      saleRoomOwnerPhone.setBounds(12, 161, 312, 25);
      add(saleRoomOwnerPhone);
      saleRoomOwnerPhone.setLayout(null);
      
      JLabel My_Phone = new JLabel("\uB9E4\uB9E4\uC778 \uC5F0\uB77D\uCC98");
      My_Phone.setForeground(new Color(255, 255, 255));
      My_Phone.setFont(new Font("Dialog", Font.BOLD, 14));
      My_Phone.setBounds(10, 0, 92, 21);
      saleRoomOwnerPhone.add(My_Phone);
      
      JLabel Tx_Phone = new JLabel();
      Tx_Phone.setBounds(112, 0, 191, 21);
      saleRoomOwnerPhone.add(Tx_Phone);
    
      Tx_Phone.setText(phone);
      
      JLabel roomSaleInfoTitle = new JLabel("Rustic");
      roomSaleInfoTitle.setForeground(new Color(255, 255, 255));
      roomSaleInfoTitle.setHorizontalAlignment(SwingConstants.LEFT);
      roomSaleInfoTitle.setFont(new Font("Segoe Print", Font.BOLD, 15));
      roomSaleInfoTitle.setBounds(22, 10, 54, 25);
      add(roomSaleInfoTitle);
      
      JButton saleRoomPhotoRegBtn = new JButton("\uC0AC\uC9C4\uB4F1\uB85D");
      saleRoomPhotoRegBtn.setFont(new Font("함초롬돋움", Font.BOLD, 14));
      saleRoomPhotoRegBtn.setBackground(new Color(0, 128, 128));
      saleRoomPhotoRegBtn.setBounds(364, 393, 120, 45);
      add(saleRoomPhotoRegBtn);
      
      JButton saleRoomWriteBtn = new JButton("\uBC29\uB4F1\uB85D\uC644\uB8CC");
      
     
      saleRoomWriteBtn.setFont(new Font("함초롬돋움", Font.BOLD, 14));
      saleRoomWriteBtn.setBackground(new Color(0, 128, 128));
      saleRoomWriteBtn.setBounds(498, 393, 120, 45);
      add(saleRoomWriteBtn);
      
      JPanel adressPanel = new JPanel();
      adressPanel.setBackground(new Color(0, 128, 128));
      adressPanel.setBounds(12, 67, 331, 34);
      add(adressPanel);
      adressPanel.setLayout(null);
      
      JLabel lblNewLabel = new JLabel("\uC8FC\uC18C");
      lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 13));
      lblNewLabel.setForeground(new Color(255, 255, 255));
      lblNewLabel.setBounds(10, 8, 28, 15);
      adressPanel.add(lblNewLabel);
      
      textField = new JTextField();
      textField.setBounds(68, 6, 251, 21);
      adressPanel.add(textField);
      textField.setColumns(10);
      
      JPanel saleRoomDetailTextPanel = new JPanel();
      saleRoomDetailTextPanel.setBackground(new Color(0, 128, 128));
      saleRoomDetailTextPanel.setBounds(12, 240, 331, 198);
      add(saleRoomDetailTextPanel);
      saleRoomDetailTextPanel.setLayout(null);
      
      saleRoomDetailText = new JTextField();
      saleRoomDetailText.setBounds(0, 32, 331, 173);
      saleRoomDetailTextPanel.add(saleRoomDetailText);
      saleRoomDetailText.setColumns(10);
      
      JLabel saleRoomDetailLabel = new JLabel("\uC124\uBA85");
      saleRoomDetailLabel.setBounds(0, 0, 45, 22);
      saleRoomDetailTextPanel.add(saleRoomDetailLabel);
      saleRoomDetailLabel.setForeground(new Color(255, 255, 255));
      saleRoomDetailLabel.setHorizontalAlignment(SwingConstants.CENTER);
      saleRoomDetailLabel.setFont(new Font("Dialog", Font.BOLD, 15));
      
      JPanel saleRoomPhotoPanel = new JPanel();
      saleRoomPhotoPanel.setBackground(new Color(102, 205, 170));
      saleRoomPhotoPanel.setBounds(364, 125, 254, 242);
      add(saleRoomPhotoPanel);
      saleRoomPhotoPanel.setLayout(null);
      
      JLabel saleRoomPhotoLabel = new JLabel("\uC0AC\uC9C4\uB4F1\uB85D");
      saleRoomPhotoLabel.setBounds(10, 10, 50, 18);
      saleRoomPhotoLabel.setForeground(new Color(255, 255, 255));
      saleRoomPhotoLabel.setFont(new Font("Dialog", Font.BOLD, 12));
      saleRoomPhotoPanel.add(saleRoomPhotoLabel);
      
      JLabel roomSaleInfoTitle_1 = new JLabel("\uBC29 \uB9E4\uB9E4 \uC815\uBCF4 \uB4F1\uB85D");
      roomSaleInfoTitle_1.setHorizontalAlignment(SwingConstants.LEFT);
      roomSaleInfoTitle_1.setForeground(Color.WHITE);
      roomSaleInfoTitle_1.setFont(new Font("Dialog", Font.BOLD, 15));
      roomSaleInfoTitle_1.setBounds(71, 10, 125, 25);
      add(roomSaleInfoTitle_1);
      
      JPanel countToiletRoomPanel = new JPanel();
      countToiletRoomPanel.setLayout(null);
      countToiletRoomPanel.setBackground(new Color(0, 128, 128));
      countToiletRoomPanel.setBounds(12, 196, 331, 34);
      add(countToiletRoomPanel);
      
      JComboBox countRoomCombobox = new JComboBox();
      countRoomCombobox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
      countRoomCombobox.setBounds(66, 5, 68, 23);
      countToiletRoomPanel.add(countRoomCombobox);
      
      JLabel countRoomcLabel = new JLabel("\uAC1C");
      countRoomcLabel.setForeground(Color.WHITE);
      countRoomcLabel.setBounds(135, 9, 16, 15);
      countToiletRoomPanel.add(countRoomcLabel);
      
      JComboBox countToiletCombobox = new JComboBox();
      countToiletCombobox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
      countToiletCombobox.setBounds(237, 5, 68, 23);
      countToiletRoomPanel.add(countToiletCombobox);
      
      JLabel countToiletcLabel = new JLabel("\uAC1C");
      countToiletcLabel.setForeground(Color.WHITE);
      countToiletcLabel.setBounds(305, 9, 16, 15);
      countToiletRoomPanel.add(countToiletcLabel);
      
      JLabel countRoomLabel = new JLabel("\uBC29\uAC2F\uC218");
      countRoomLabel.setForeground(Color.WHITE);
      countRoomLabel.setFont(new Font("Dialog", Font.BOLD, 13));
      countRoomLabel.setBounds(10, 8, 46, 15);
      countToiletRoomPanel.add(countRoomLabel);
      
      JLabel countToiletLabel = new JLabel("\uD654\uC7A5\uC2E4\uAC2F\uC218");
      countToiletLabel.setForeground(Color.WHITE);
      countToiletLabel.setFont(new Font("Dialog", Font.BOLD, 13));
      countToiletLabel.setBounds(161, 8, 77, 15);
      countToiletRoomPanel.add(countToiletLabel);
      
      JPanel countToiletRoomPanel_1 = new JPanel();
      countToiletRoomPanel_1.setLayout(null);
      countToiletRoomPanel_1.setBackground(new Color(0, 128, 128));
      countToiletRoomPanel_1.setBounds(408, 41, 162, 34);
      add(countToiletRoomPanel_1);
      
      JTextField countRoomCombobox_1 = new JTextField();
      countRoomCombobox_1.setBounds(66, 5, 68, 23);
      countToiletRoomPanel_1.add(countRoomCombobox_1);
      
      JLabel countRoomcLabel_1 = new JLabel("\uD3C9\uD615");
      countRoomcLabel_1.setForeground(Color.WHITE);
      countRoomcLabel_1.setBounds(135, 9, 34, 15);
      countToiletRoomPanel_1.add(countRoomcLabel_1);
      
      JLabel countRoomLabel_1 = new JLabel("\uBA74\uC801");
      countRoomLabel_1.setForeground(Color.WHITE);
      countRoomLabel_1.setFont(new Font("Dialog", Font.BOLD, 13));
      countRoomLabel_1.setBounds(10, 8, 46, 15);
      countToiletRoomPanel_1.add(countRoomLabel_1);
      
      JPanel addDetailPanel = new JPanel();
      addDetailPanel.setLayout(null);
      addDetailPanel.setBackground(new Color(0, 128, 128));
      addDetailPanel.setBounds(12, 111, 240, 25);
      add(addDetailPanel);
      
      JLabel adddetail = new JLabel("\uC0C1\uC138\uC8FC\uC18C");
      adddetail.setForeground(Color.WHITE);
      adddetail.setFont(new Font("Dialog", Font.BOLD, 14));
      adddetail.setBounds(10, 0, 67, 21);
      addDetailPanel.add(adddetail);
      
      JTextPane adddetailTxBox = new JTextPane();
      adddetailTxBox.setBounds(68, 0, 162, 21);
      addDetailPanel.add(adddetailTxBox);
      


      btnNewButton.setBounds(264, 41, 97, 23);
      add(btnNewButton);
      
      JPanel rentcountToiletRoomPanel_1_1 = new JPanel();
      rentcountToiletRoomPanel_1_1.setLayout(null);
      rentcountToiletRoomPanel_1_1.setBackground(new Color(0, 128, 128));
      rentcountToiletRoomPanel_1_1.setBounds(408, 81, 162, 34);
      add(rentcountToiletRoomPanel_1_1);
      
      JLabel rentcountRoomcLabel_1_1 = new JLabel("\uD5A5");
      rentcountRoomcLabel_1_1.setForeground(Color.WHITE);
      rentcountRoomcLabel_1_1.setBounds(135, 9, 34, 15);
      rentcountToiletRoomPanel_1_1.add(rentcountRoomcLabel_1_1);
      
      JLabel direcLabel = new JLabel("\uC9D1 \uBC29\uD5A5");
      direcLabel.setForeground(Color.WHITE);
      direcLabel.setFont(new Font("Dialog", Font.BOLD, 13));
      direcLabel.setBounds(10, 8, 46, 15);
      rentcountToiletRoomPanel_1_1.add(direcLabel);
      
      textField_1 = new JTextField();
      textField_1.setColumns(10);
      textField_1.setBounds(85, 0, 46, 21);
      rentcountToiletRoomPanel_1_1.add(textField_1);
      
      JLabel lblNewLabel_1 = new JLabel("X");
      lblNewLabel_1.addMouseListener(new MouseAdapter() {
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
      		
      	}
      });
      lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 16));
      lblNewLabel_1.setForeground(new Color(255, 255, 255));
      lblNewLabel_1.setBounds(592, 17, 35, 15);
      add(lblNewLabel_1);
      
      

   
   public void setAddrBox(String tot) {
 	  
	   textField.setText(String.valueOf(tot));
  	   
     }
}
