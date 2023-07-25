package ownerWrite;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.MemberDao;
import dao.MenuDAO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class budong extends JFrame {
	   private JTextField introtx;
	   private JTextField addrtext;
	   private JTextField directx;
	   /**
	    * Create the panel.
	    */
	   public budong(int numnum) {
	   	getContentPane().setBackground(new Color(0, 128, 128));
	   	getContentPane().setForeground(new Color(0, 128, 128));
		
		  MemberDao dao = MemberDao.getInstance();
	      setBackground(new Color(0, 128, 128));
	      setBounds(0, 0, 639, 553);
	      getContentPane().setLayout(null);
	      setVisible(false);   //¿Ã∞‘ ∏¬≥™? «¡∑π¿” ¥ÎΩ¨∫∏µÂ Ω««‡Ω√ æÍ∞° ¿ÃªÛ«œ∞‘ ∂∞º≠ ≥÷æÓµ“..
	      
	      JPanel saleRoomPanel = new JPanel();
	      saleRoomPanel.setBackground(new Color(0, 128, 128));
	      saleRoomPanel.setBounds(12, 126, 240, 25);
	      getContentPane().add(saleRoomPanel);
	      saleRoomPanel.setLayout(null);
	      
	      JLabel saleRoomName = new JLabel("\uBC29\uC774\uB984");
	      saleRoomName.setForeground(new Color(255, 255, 255));
	      saleRoomName.setFont(new Font("πŸ≈¡", Font.BOLD, 13));
	      saleRoomName.setBounds(10, 0, 67, 21);
	      saleRoomPanel.add(saleRoomName);
	      
	      JTextPane nametx = new JTextPane();
	      nametx.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
	      nametx.setBounds(68, 0, 162, 21);
	      saleRoomPanel.add(nametx);
	      
	      
	      JLabel roomSaleInfoTitle = new JLabel("Rustic");
	      roomSaleInfoTitle.setForeground(new Color(255, 255, 255));
	      roomSaleInfoTitle.setHorizontalAlignment(SwingConstants.LEFT);
	      roomSaleInfoTitle.setFont(new Font("Segoe Print", Font.BOLD, 15));
	      roomSaleInfoTitle.setBounds(22, 10, 54, 25);
	      getContentPane().add(roomSaleInfoTitle);
	      
	      JButton saleRoomPhotoRegBtn = new JButton("\uC0AC\uC9C4\uB4F1\uB85D");
	      saleRoomPhotoRegBtn.setFont(new Font("πŸ≈¡", Font.BOLD, 14));
	      saleRoomPhotoRegBtn.setBackground(UIManager.getColor("Button.background"));
	      saleRoomPhotoRegBtn.setBounds(364, 393, 120, 45);
	      getContentPane().add(saleRoomPhotoRegBtn);
	      
	     
	      
	     
	      
	      
	      JPanel adressPanel = new JPanel();
	      adressPanel.setBackground(new Color(0, 128, 128));
	      adressPanel.setBounds(12, 45, 289, 34);
	      getContentPane().add(adressPanel);
	      adressPanel.setLayout(null);
	      
	      JLabel lblNewLabel = new JLabel("\uC8FC\uC18C");
	      lblNewLabel.setFont(new Font("πŸ≈¡", Font.BOLD, 13));
	      lblNewLabel.setForeground(new Color(255, 255, 255));
	      lblNewLabel.setBounds(10, 8, 28, 15);
	      adressPanel.add(lblNewLabel);
	      
	      addrtext = new JTextField();
	      addrtext.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
	      addrtext.setBounds(68, 6, 188, 21);
	      adressPanel.add(addrtext);
	      addrtext.setColumns(10);
	      
	      JPanel saleRoomDetailTextPanel = new JPanel();
	      saleRoomDetailTextPanel.setBackground(new Color(0, 128, 128));
	      saleRoomDetailTextPanel.setBounds(12, 240, 331, 198);
	      getContentPane().add(saleRoomDetailTextPanel);
	      saleRoomDetailTextPanel.setLayout(null);
	      
	      introtx = new JTextField();
	      introtx.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
	      introtx.setBounds(0, 32, 331, 173);
	      saleRoomDetailTextPanel.add(introtx);
	      introtx.setColumns(10);
	      
	      JLabel saleRoomDetailLabel = new JLabel("\uC124\uBA85");
	      saleRoomDetailLabel.setBounds(0, 0, 45, 22);
	      saleRoomDetailTextPanel.add(saleRoomDetailLabel);
	      saleRoomDetailLabel.setForeground(new Color(255, 255, 255));
	      saleRoomDetailLabel.setHorizontalAlignment(SwingConstants.CENTER);
	      saleRoomDetailLabel.setFont(new Font("πŸ≈¡", Font.BOLD, 13));
	      
	      JPanel saleRoomPhotoPanel = new JPanel();
	      saleRoomPhotoPanel.setBackground(new Color(102, 205, 170));
	      saleRoomPhotoPanel.setBounds(364, 125, 254, 242);
	      getContentPane().add(saleRoomPhotoPanel);
	      saleRoomPhotoPanel.setLayout(null);
	      
	      JLabel saleRoomPhotoLabel = new JLabel("\uC0AC\uC9C4\uB4F1\uB85D");
	      saleRoomPhotoLabel.setBounds(10, 10, 50, 18);
	      saleRoomPhotoLabel.setForeground(new Color(255, 255, 255));
	      saleRoomPhotoLabel.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
	      saleRoomPhotoPanel.add(saleRoomPhotoLabel);
	      
	      JLabel roomSaleInfoTitle_1 = new JLabel("\uBC29 \uB9E4\uB9E4 \uC815\uBCF4 \uB4F1\uB85D");
	      roomSaleInfoTitle_1.setHorizontalAlignment(SwingConstants.LEFT);
	      roomSaleInfoTitle_1.setForeground(Color.WHITE);
	      roomSaleInfoTitle_1.setFont(new Font("πŸ≈¡", Font.BOLD, 15));
	      roomSaleInfoTitle_1.setBounds(71, 10, 202, 25);
	      getContentPane().add(roomSaleInfoTitle_1);
	      
	      JPanel countToiletRoomPanel = new JPanel();
	      countToiletRoomPanel.setLayout(null);
	      countToiletRoomPanel.setBackground(new Color(0, 128, 128));
	      countToiletRoomPanel.setBounds(12, 196, 331, 34);
	      getContentPane().add(countToiletRoomPanel);
	      
	      JComboBox roomcntcombo = new JComboBox();
	      roomcntcombo.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
	      roomcntcombo.setBounds(66, 5, 68, 23);
	      countToiletRoomPanel.add(roomcntcombo);
	      
	      JLabel countRoomcLabel = new JLabel("\uAC1C");
	      countRoomcLabel.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
	      countRoomcLabel.setForeground(Color.WHITE);
	      countRoomcLabel.setBounds(135, 9, 16, 15);
	      countToiletRoomPanel.add(countRoomcLabel);
	      
	      JComboBox toiletcntcombo = new JComboBox();
	      toiletcntcombo.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
	      toiletcntcombo.setBounds(237, 5, 68, 23);
	      countToiletRoomPanel.add(toiletcntcombo);
	      
	      JLabel countToiletcLabel = new JLabel("\uAC1C");
	      countToiletcLabel.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
	      countToiletcLabel.setForeground(Color.WHITE);
	      countToiletcLabel.setBounds(305, 9, 16, 15);
	      countToiletRoomPanel.add(countToiletcLabel);
	      
	      JLabel countRoomLabel = new JLabel("\uBC29\uAC2F\uC218");
	      countRoomLabel.setForeground(Color.WHITE);
	      countRoomLabel.setFont(new Font("πŸ≈¡", Font.BOLD, 13));
	      countRoomLabel.setBounds(10, 8, 46, 15);
	      countToiletRoomPanel.add(countRoomLabel);
	      
	      JLabel countToiletLabel = new JLabel("\uD654\uC7A5\uC2E4\uAC2F\uC218");
	      countToiletLabel.setForeground(Color.WHITE);
	      countToiletLabel.setFont(new Font("πŸ≈¡", Font.BOLD, 13));
	      countToiletLabel.setBounds(161, 8, 77, 15);
	      countToiletRoomPanel.add(countToiletLabel);
	      
	      JPanel countToiletRoomPanel_1 = new JPanel();
	      countToiletRoomPanel_1.setLayout(null);
	      countToiletRoomPanel_1.setBackground(new Color(0, 128, 128));
	      countToiletRoomPanel_1.setBounds(408, 41, 162, 34);
	      getContentPane().add(countToiletRoomPanel_1);
	      
	      JTextField fttx = new JTextField();
	      fttx.setBounds(66, 5, 68, 23);
	      countToiletRoomPanel_1.add(fttx);
	      
	      JLabel countRoomcLabel_1 = new JLabel("\uD3C9\uD615");
	      countRoomcLabel_1.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
	      countRoomcLabel_1.setForeground(Color.WHITE);
	      countRoomcLabel_1.setBounds(135, 9, 34, 15);
	      countToiletRoomPanel_1.add(countRoomcLabel_1);
	      
	      JLabel countRoomLabel_1 = new JLabel("\uBA74\uC801");
	      countRoomLabel_1.setForeground(Color.WHITE);
	      countRoomLabel_1.setFont(new Font("πŸ≈¡", Font.BOLD, 13));
	      countRoomLabel_1.setBounds(10, 8, 46, 15);
	      countToiletRoomPanel_1.add(countRoomLabel_1);
	      
	      JPanel addDetailPanel = new JPanel();
	      addDetailPanel.setLayout(null);
	      addDetailPanel.setBackground(new Color(0, 128, 128));
	      addDetailPanel.setBounds(12, 90, 240, 25);
	      getContentPane().add(addDetailPanel);
	      
	      JLabel adddetail = new JLabel("\uC0C1\uC138\uC8FC\uC18C");
	      adddetail.setForeground(Color.WHITE);
	      adddetail.setFont(new Font("πŸ≈¡", Font.BOLD, 13));
	      adddetail.setBounds(10, 0, 67, 21);
	      addDetailPanel.add(adddetail);
	      
	      JTextPane detailtx = new JTextPane();
	      detailtx.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
	      detailtx.setBounds(68, 0, 162, 21);
	      addDetailPanel.add(detailtx);
	      
	      JPanel rentcountToiletRoomPanel_1_1 = new JPanel();
	      rentcountToiletRoomPanel_1_1.setLayout(null);
	      rentcountToiletRoomPanel_1_1.setBackground(new Color(0, 128, 128));
	      rentcountToiletRoomPanel_1_1.setBounds(12, 161, 240, 34);
	      getContentPane().add(rentcountToiletRoomPanel_1_1);
	      
	      JLabel rentcountRoomcLabel_1_1 = new JLabel("\uD5A5");
	      rentcountRoomcLabel_1_1.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
	      rentcountRoomcLabel_1_1.setForeground(Color.WHITE);
	      rentcountRoomcLabel_1_1.setBounds(176, 9, 34, 15);
	      rentcountToiletRoomPanel_1_1.add(rentcountRoomcLabel_1_1);
	      
	      JLabel direcLabel = new JLabel("\uC9D1 \uBC29\uD5A5");
	      direcLabel.setForeground(Color.WHITE);
	      direcLabel.setFont(new Font("πŸ≈¡", Font.BOLD, 13));
	      direcLabel.setBounds(10, 8, 46, 15);
	      rentcountToiletRoomPanel_1_1.add(direcLabel);
	      
	      directx = new JTextField();
	      directx.setFont(new Font("πŸ≈¡", Font.PLAIN, 12));
	      directx.setColumns(10);
	      directx.setBounds(82, 6, 82, 21);
	      rentcountToiletRoomPanel_1_1.add(directx);
	      
	      JLabel lblNewLabel_1 = new JLabel("X");
	      lblNewLabel_1.setForeground(new Color(255, 255, 255));
	      lblNewLabel_1.setFont(new Font("±º∏≤", Font.BOLD, 16));
	      lblNewLabel_1.setBounds(594, 17, 24, 15);
	      getContentPane().add(lblNewLabel_1);
	      
	      
	      MenuDAO dao1 = MenuDAO.getInstance();
	      ArrayList list = dao1.select(numnum);
	      // MENUNAME, ADDRESS, ADDRESSDETAIL, BANGCOUNT, SQUAREMESURE, SUNDIRECTION, MENUINTRODUCE, OWNERNUM
	       //≥◊¿”, ¡÷º“, ªÛºº¡÷º“, πÊ∞≥ºˆ, ∆Úºˆ, πËªÍ¿”ºˆ, ∏ﬁ¥∫º“∞≥, ø¿¥ı≥—

	      nametx.setText(list.get(0).toString());
	      addrtext.setText(list.get(1).toString());
	      detailtx.setText(list.get(2).toString());
	      roomcntcombo.setSelectedItem(list.get(3).toString());
	      fttx.setText(list.get(4).toString());
	      directx.setText(list.get(5).toString());
	      introtx.setText(list.get(6).toString());
	      toiletcntcombo.setSelectedItem(list.get(7).toString());
	      
	      JButton btnNewButton = new JButton("ºˆ¡§ «œ±‚");
	      btnNewButton.setBackground(UIManager.getColor("Button.background"));
	      btnNewButton.setFont(new Font("πŸ≈¡", Font.BOLD, 14));
	      btnNewButton.addMouseListener(new MouseAdapter() {
	      	@Override
	      	public void mouseClicked(MouseEvent e) {
	      		//ºˆ¡§πˆ∆∞
	      		
	      		try {
					dao.bumodify(nametx.getText(), addrtext.getText(), detailtx.getText(), roomcntcombo.getSelectedItem().toString(),fttx.getText(),directx.getText(),introtx.getText(),toiletcntcombo.getSelectedItem().toString(),numnum);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	      		
	      	}
	      });
	      btnNewButton.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      	}
	      });
	      btnNewButton.setBounds(496, 393, 122, 45);
	      getContentPane().add(btnNewButton);
	      
	 
	      
	      lblNewLabel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					lblNewLabel_1.setForeground(Color.red);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					lblNewLabel_1.setForeground(Color.white);
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
				}
			});
	      
	      setLocationRelativeTo(null);
	   }
	}
