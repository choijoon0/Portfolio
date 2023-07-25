package ownerWrite;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import SignUp.FrameLogin;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import dao.MainpageSearchDAO;
import dao.MemberDao;

//여기부터
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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import dao.MemberDao;
import dao.MenuDAO;
import swingTableSample.zip.*;
import mainpage.FrameDashboard;
import mainpage.Reservation;
import models.Member;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import ownerWrite.*;
import ownerWrite.FrameDashboard_owner.asd;
import ownerWrite.FrameDashboard_owner.budong;
import ownerWrite.OwnerMain.RecentListTableModel;
import ownerWrite.OwnerMain.RecentListTableModel2;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JList;
import javax.swing.SwingConstants;

import dao.MemberDao;
import swingTableSample.zip.ZipSearch;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class FrameDashboard_owner extends JFrame {

   private JPanel contentPane;
   private final JPanel panel = new JPanel();
   
   private Image img_logo = new ImageIcon(FrameDashboard_owner.class.getResource("/res/logo.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
   //private Image img_home = new ImageIcon(FrameDashboard.class.getResource("/res/home.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
   
   private panelRoomRentWrite panelRoomRent;
   private PanelRoomWrite panelRoom;
   private OwnerMain ownerMain;
  
   
   
   private String seq=null;
   private String tot=null;	//전달받은 문자열
   private String sido=null;
   private String gugun=null;
   private String dong=null;
   


   /**
    * Launch the application.
    */
   
   //메인 삭제가능성 있음
   /*
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
            //   FrameDashboard_owner frame = new FrameDashboard_owner();
            //   frame.setVisible(true);

            
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
         
   }
*/
   /**
    * Create the frame.
    */

   public FrameDashboard_owner(Object ...n) {

	   		String id= n[0].toString();
	   		int gubun=Integer.parseInt(n[1].toString()); 
	   	
		  try {
			  
			  String tot=n[2].toString();
			
			  if(tot!=null) {
				  //panelRoomRent= new panelRoomRentWrite(id, gubun, seq);
				 
				 String totText[] = tot.split(",");
				 seq=totText[0];
				 sido=totText[1];
				 gugun=totText[2];
				 dong=totText[3];
				 System.out.println(tot);
				 
				  
			  }
			  
		  }
		  catch (Exception e) {
			// TODO: handle exception
		}  	  
 
	   
      setUndecorated(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setBounds(100, 100, 980, 555);
      contentPane = new JPanel();
      contentPane.setBackground(new Color(0, 128, 128));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      panel.setBackground(new Color(47, 79, 79));
      panel.setBounds(0, 0, 303, 555);
      contentPane.add(panel);
      panel.setLayout(null);
      

      panelRoomRent = new panelRoomRentWrite(id, gubun);
      //panelRoomRent = new JPanel();
      panelRoom = new PanelRoomWrite(id, gubun);
      ownerMain = new OwnerMain(id);
      
      
  

      JLabel lblLogo = new JLabel("");
      lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
      lblLogo.setIcon(new ImageIcon(img_logo));
      lblLogo.setBounds(0, 1, 303, 189);
      panel.add(lblLogo);
      
      JPanel Home = new JPanel();
      Home.addMouseListener(new PanelButtonMouseAdapter(Home) {
         @Override
         public void mouseClicked(MouseEvent e) {
            menuClicked(ownerMain);
         }
      });

      
      Home.setBackground(new Color(47, 79, 79));
      Home.setBounds(0, 200, 303, 50);
      panel.add(Home);
      Home.setLayout(null);
      
      JLabel lblHome = new JLabel("\uD1B5\uD569\uAC80\uC0C9");
      lblHome.setFont(new Font("바탕", Font.BOLD, 15));
      lblHome.setForeground(new Color(255, 255, 255));
      lblHome.setBounds(80, 10, 210, 30);
      Home.add(lblHome);
      
      JPanel Orders = new JPanel();
      Orders.addMouseListener(new PanelButtonMouseAdapter(Orders) {
         @Override
         public void mouseClicked(MouseEvent e) {
        	 //숙박 매물 등록 클릭시
            menuClicked(panelRoomRent); 

         }
      });
      Orders.setBackground(new Color(47, 79, 79));
      Orders.setBounds(0, 250, 303, 50);
      panel.add(Orders);
      Orders.setLayout(null);
      
      JLabel lblOrders = new JLabel("\uC219\uBC15 \uB4F1\uB85D");


      lblOrders.setForeground(Color.WHITE);
      lblOrders.setFont(new Font("바탕", Font.BOLD, 15));
      lblOrders.setBounds(80, 10, 210, 30);
      Orders.add(lblOrders);
      
      
      JPanel Setting = new JPanel();
      Setting.addMouseListener(new PanelButtonMouseAdapter(Setting) {
         @Override
         public void mouseClicked(MouseEvent e) {
        	 //매매 물품 등록 클릭시
             menuClicked(panelRoom);   
            
         }
      });
      Setting.setBackground(new Color(47, 79, 79));
      Setting.setBounds(0, 298, 303, 50);
      panel.add(Setting);
      Setting.setLayout(null);
      
      JLabel lblSettings = new JLabel("\uB9E4\uB9E4 \uB4F1\uB85D");
      lblSettings.setForeground(Color.WHITE);
      lblSettings.setFont(new Font("바탕", Font.BOLD, 15));
      lblSettings.setBounds(80, 10, 210, 30);
      Setting.add(lblSettings);
      
      JPanel SignOut = new JPanel();
      SignOut.addMouseListener(new PanelButtonMouseAdapter(SignOut) {
         @Override
         public void mouseClicked(MouseEvent e) {
          //menuClicked(manual);   
         }
      });
      SignOut.setBackground(new Color(47, 79, 79));
      SignOut.setBounds(0, 348, 303, 50);
      panel.add(SignOut);
      SignOut.setLayout(null);
      
      JLabel lblSignOut = new JLabel("");
      lblSignOut.setForeground(Color.WHITE);
      lblSignOut.setFont(new Font("바탕", Font.BOLD, 15));
      lblSignOut.setBounds(80, 10, 210, 30);
      SignOut.add(lblSignOut);
      
      JPanel panel_1 = new JPanel();
      panel_1.setBounds(315, 10, 639, 498);
      contentPane.add(panel_1);
      panel_1.setLayout(null);
      
      //판넬등록
      panel_1.add(panelRoom);
      panel_1.add(panelRoomRent);
      panel_1.add(ownerMain);
      
      



      JLabel lblx = new JLabel("X");
      lblx.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if(JOptionPane.showConfirmDialog(null, "종료하시겠습니까?", "테스트문장", JOptionPane.YES_NO_OPTION)==0) {
               FrameDashboard_owner.this.dispose();
            }
         }
     	@Override
		public void mouseEntered(MouseEvent e) {
			lblx.setForeground(Color.red);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			lblx.setForeground(Color.white);
		}
      });
      lblx.setHorizontalAlignment(SwingConstants.CENTER);
      lblx.setForeground(Color.WHITE);
      lblx.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
      lblx.setBackground(Color.WHITE);
      lblx.setBounds(960, 0, 20, 20);
      contentPane.add(lblx);
      setLocationRelativeTo(null);   //창 중앙 생성 마지막에 써야만 되는듯
   }

   public void menuClicked(JPanel panel) {
      panelRoom.setVisible(false);
      panelRoomRent.setVisible(false);
      ownerMain.setVisible(false);
      
      

      panel.setVisible(true);
   
      //MyReview frame = new MyReview();
      //frame.setUndecorated(true);
   //   frame.setVisible(true);
   //   dispose();
   }
   
   //숙박 매물 등록 후 돌아왔을 때 실행
   public void menuClicked_roomRent() {
	   	  panelRoom.setVisible(false);
	   	ownerMain.setVisible(false);
	   	
	      panelRoomRent.setVisible(true);
	      panelRoomRent.setAddrBox(sido+" " + gugun+ " " + dong);

	   }
   public void menuClicked_room() {
	   	  panelRoomRent.setVisible(false);
	   	ownerMain.setVisible(false);
	   	
	      panelRoom.setVisible(true);
	      panelRoom.setAddrBox(sido+" " + gugun+ " " + dong);

	   }
   
   private class PanelButtonMouseAdapter extends MouseAdapter{
	   
      JPanel panel;
      public PanelButtonMouseAdapter(JPanel panel) {
         this.panel= panel;
      }
      
      public void MouseEntered(MouseEvent e) {
         panel.setBackground(new Color(112, 128, 144));
      }
      
      public void mouseExited(MouseEvent e) {
         panel.setBackground(new Color(47, 79, 79));
      }
      
      public void mousePressed(MouseEvent e) {
         panel.setBackground(new Color(60, 179, 113));
      }
      
      public void mouseReleased(MouseEvent e) {
         panel.setBackground(new Color(112, 128, 144));
      }
      
   }

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
   setVisible(false);   //이게 맞나? 프레임 대쉬보드 실행시 얘가 이상하게 떠서 넣어둠..
   
   JPanel rentRoomPanel = new JPanel();
   rentRoomPanel.setBackground(new Color(0, 128, 128));
   rentRoomPanel.setBounds(12, 125, 240, 25);
   add(rentRoomPanel);
   rentRoomPanel.setLayout(null);
   
   JLabel rentRoomName = new JLabel("\uBC29\uC774\uB984");
   rentRoomName.setForeground(new Color(255, 255, 255));
   rentRoomName.setFont(new Font("바탕", Font.BOLD, 14));
   rentRoomName.setBounds(10, 0, 67, 21);
   rentRoomPanel.add(rentRoomName);
  
   JTextPane rentRoomTextbox = new JTextPane();
   rentRoomTextbox.setFont(new Font("바탕", Font.PLAIN, 12));
   rentRoomTextbox.setBounds(72, 0, 155, 21);
   rentRoomPanel.add(rentRoomTextbox);
   
   JPanel rentRoomOwnerPhone = new JPanel();
   rentRoomOwnerPhone.setBackground(new Color(0, 128, 128));
   rentRoomOwnerPhone.setBounds(12, 161, 312, 25);
   add(rentRoomOwnerPhone);
   rentRoomOwnerPhone.setLayout(null);
   
   JLabel rentOwnerPhone = new JLabel("\uB9E4\uB9E4\uC778 \uC5F0\uB77D\uCC98");
   rentOwnerPhone.setForeground(new Color(255, 255, 255));
   rentOwnerPhone.setFont(new Font("바탕", Font.BOLD, 14));
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
   rentRoomPhotoRegBtn.setFont(new Font("바탕", Font.BOLD, 14));
   rentRoomPhotoRegBtn.setBackground(UIManager.getColor("Button.background"));
   rentRoomPhotoRegBtn.setBounds(364, 393, 120, 45);
   add(rentRoomPhotoRegBtn);

   JButton rentRoomWriteBtn = new JButton("\uBC29\uB4F1\uB85D\uC644\uB8CC");

  

   rentRoomWriteBtn.setFont(new Font("바탕", Font.BOLD, 14));
   rentRoomWriteBtn.setBackground(UIManager.getColor("Button.background"));
   rentRoomWriteBtn.setBounds(498, 393, 120, 45);
   add(rentRoomWriteBtn);
   
   JPanel rentAdressPanel = new JPanel();
   rentAdressPanel.setBackground(new Color(0, 128, 128));
   rentAdressPanel.setBounds(12, 45, 379, 34);
   add(rentAdressPanel);
   rentAdressPanel.setLayout(null);
   
   JLabel rentRoomAdress = new JLabel("\uC8FC\uC18C");
   rentRoomAdress.setFont(new Font("바탕", Font.BOLD, 13));
   rentRoomAdress.setForeground(new Color(255, 255, 255));
   rentRoomAdress.setBounds(10, 8, 28, 15);
   rentAdressPanel.add(rentRoomAdress);
   
   rentAddrTxBox = new JTextField();
   rentAddrTxBox.setFont(new Font("바탕", Font.PLAIN, 12));
   rentAddrTxBox.setBounds(50, 6, 199, 21);
   rentAdressPanel.add(rentAddrTxBox);
   rentAddrTxBox.setColumns(10);
   //
   
   JButton btnNewButton = new JButton("\uC8FC\uC18C\uAC80\uC0C9");
   btnNewButton.setFont(new Font("바탕", Font.PLAIN, 12));
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
   rentRoomDetailText.setFont(new Font("바탕", Font.PLAIN, 12));
   rentRoomDetailText.setBounds(0, 25, 331, 173);
   rentRoomDetailTextPanel.add(rentRoomDetailText);
   rentRoomDetailText.setColumns(10);
   
   JLabel rentRoomDetailLabel = new JLabel("\uC124\uBA85");
   rentRoomDetailLabel.setBounds(0, 0, 45, 22);
   rentRoomDetailTextPanel.add(rentRoomDetailLabel);
   rentRoomDetailLabel.setForeground(new Color(255, 255, 255));
   rentRoomDetailLabel.setHorizontalAlignment(SwingConstants.CENTER);
   rentRoomDetailLabel.setFont(new Font("바탕", Font.BOLD, 15));
   
   JPanel rentRoomPhotoPanel = new JPanel();
   rentRoomPhotoPanel.setBackground(new Color(102, 205, 170));
   rentRoomPhotoPanel.setBounds(364, 125, 254, 242);
   add(rentRoomPhotoPanel);
   rentRoomPhotoPanel.setLayout(null);
   
   JLabel rentRoomPhotoLabel = new JLabel("\uC0AC\uC9C4\uB4F1\uB85D");
   rentRoomPhotoLabel.setBounds(10, 10, 50, 18);
   rentRoomPhotoLabel.setForeground(new Color(255, 255, 255));
   rentRoomPhotoLabel.setFont(new Font("바탕", Font.BOLD, 12));
   rentRoomPhotoPanel.add(rentRoomPhotoLabel);
   
   JLabel roomRentInfoTitle_1 = new JLabel("\uC219\uBC15 \uB9E4\uBB3C \uC815\uBCF4 \uB4F1\uB85D");
   roomRentInfoTitle_1.setHorizontalAlignment(SwingConstants.LEFT);
   roomRentInfoTitle_1.setForeground(Color.WHITE);
   roomRentInfoTitle_1.setFont(new Font("바탕", Font.BOLD, 15));
   roomRentInfoTitle_1.setBounds(71, 10, 162, 25);
   add(roomRentInfoTitle_1);
   
   JPanel rentcountToiletRoomPanel = new JPanel();
   rentcountToiletRoomPanel.setLayout(null);
   rentcountToiletRoomPanel.setBackground(new Color(0, 128, 128));
   rentcountToiletRoomPanel.setBounds(12, 196, 331, 34);
   add(rentcountToiletRoomPanel);
   
   JComboBox rentcountRoomCombobox = new JComboBox();
   rentcountRoomCombobox.setFont(new Font("바탕", Font.PLAIN, 12));
   rentcountRoomCombobox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
   rentcountRoomCombobox.setBounds(66, 5, 68, 23);
   rentcountToiletRoomPanel.add(rentcountRoomCombobox);
   
   JLabel countRoomcLabel = new JLabel("\uAC1C");
   countRoomcLabel.setFont(new Font("바탕", Font.PLAIN, 12));
   countRoomcLabel.setForeground(Color.WHITE);
   countRoomcLabel.setBounds(135, 9, 16, 15);
   rentcountToiletRoomPanel.add(countRoomcLabel);
   
   JLabel rentcountRoomLabel = new JLabel("\uBC29\uAC2F\uC218");
   rentcountRoomLabel.setForeground(Color.WHITE);
   rentcountRoomLabel.setFont(new Font("바탕", Font.BOLD, 13));
   rentcountRoomLabel.setBounds(8, 8, 46, 15);
   rentcountToiletRoomPanel.add(rentcountRoomLabel);
   
   JPanel rentcountToiletRoomPanel_1 = new JPanel();
   rentcountToiletRoomPanel_1.setLayout(null);
   rentcountToiletRoomPanel_1.setBackground(new Color(0, 128, 128));
   rentcountToiletRoomPanel_1.setBounds(403, 41, 162, 34);
   add(rentcountToiletRoomPanel_1);
   
   JLabel rentcountRoomcLabel_1 = new JLabel("\uD3C9\uD615");
   rentcountRoomcLabel_1.setFont(new Font("바탕", Font.PLAIN, 12));
   rentcountRoomcLabel_1.setForeground(Color.WHITE);
   rentcountRoomcLabel_1.setBounds(135, 9, 34, 15);
   rentcountToiletRoomPanel_1.add(rentcountRoomcLabel_1);
   
   JLabel squareftLabel = new JLabel("\uBA74\uC801");
   squareftLabel.setForeground(Color.WHITE);
   squareftLabel.setFont(new Font("바탕", Font.BOLD, 13));
   squareftLabel.setBounds(10, 8, 46, 15);
   rentcountToiletRoomPanel_1.add(squareftLabel);
   
   squareftTxbox = new JTextField();
   squareftTxbox.setFont(new Font("바탕", Font.PLAIN, 12));
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
   addrdetail.setFont(new Font("바탕", Font.BOLD, 14));
   addrdetail.setBounds(10, 0, 67, 21);
   detailaddrPanel.add(addrdetail);
   
   addrdetailtxbox= new JTextField();
   addrdetailtxbox.setFont(new Font("바탕", Font.PLAIN, 12));
   addrdetailtxbox.setBounds(72, 0, 156, 21);
   detailaddrPanel.add(addrdetailtxbox);
   addrdetailtxbox.setColumns(10);
   
   
   JPanel rentcountToiletRoomPanel_1_1 = new JPanel();
   rentcountToiletRoomPanel_1_1.setLayout(null);
   rentcountToiletRoomPanel_1_1.setBackground(new Color(0, 128, 128));
   rentcountToiletRoomPanel_1_1.setBounds(403, 81, 162, 34);
   add(rentcountToiletRoomPanel_1_1);
   
   JLabel rentcountRoomcLabel_1_1 = new JLabel("\uD5A5");
   rentcountRoomcLabel_1_1.setFont(new Font("바탕", Font.PLAIN, 12));
   rentcountRoomcLabel_1_1.setForeground(Color.WHITE);
   rentcountRoomcLabel_1_1.setBounds(135, 9, 34, 15);
   rentcountToiletRoomPanel_1_1.add(rentcountRoomcLabel_1_1);
   
   JLabel direcLabel = new JLabel("\uC9D1 \uBC29\uD5A5");
   direcLabel.setForeground(Color.WHITE);
   direcLabel.setFont(new Font("바탕", Font.BOLD, 13));
   direcLabel.setBounds(10, 8, 46, 15);
   rentcountToiletRoomPanel_1_1.add(direcLabel);
   
   direcTxbox = new JTextField();
   direcTxbox.setFont(new Font("바탕", Font.PLAIN, 12));
   direcTxbox.setColumns(10);
   direcTxbox.setBounds(85, 6, 46, 21);
   rentcountToiletRoomPanel_1_1.add(direcTxbox);
 
   
   rentRoomWriteBtn.addMouseListener(new MouseAdapter() {
       @Override
       public void mouseClicked(MouseEvent e) {
          //등록 버튼
     
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
       JOptionPane.showMessageDialog(null, "숙박 물품 등록 완료");
       
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

   
//판넬 매매   

   public class PanelRoomWrite extends JPanel {
	   private JTextField saleRoomDetailText;
	   private JTextField textField;
	   private JTextField textField_1;
	   /**
	    * Create the panel.
	    */
	   public PanelRoomWrite(Object ...n) {
			  String id= n[0].toString();
			  int gubun=Integer.parseInt(n[1].toString()); 
			  try {
				  int seq=Integer.parseInt(n[2].toString());	
				  System.out.println(seq);
				
			  }
			  catch (Exception e) {
				// TODO: handle exception
			}  
		  MemberDao dao = MemberDao.getInstance();
	      setBackground(new Color(0, 128, 128));
	      setBounds(0, 0, 639, 553);
	      setLayout(null);
	      setVisible(false);   //이게 맞나? 프레임 대쉬보드 실행시 얘가 이상하게 떠서 넣어둠..
	      
	      JPanel saleRoomPanel = new JPanel();
	      saleRoomPanel.setBackground(new Color(0, 128, 128));
	      saleRoomPanel.setBounds(12, 126, 240, 25);
	      add(saleRoomPanel);
	      saleRoomPanel.setLayout(null);
	      
	      JLabel saleRoomName = new JLabel("\uBC29\uC774\uB984");
	      saleRoomName.setForeground(new Color(255, 255, 255));
	      saleRoomName.setFont(new Font("바탕", Font.BOLD, 14));
	      saleRoomName.setBounds(10, 0, 67, 21);
	      saleRoomPanel.add(saleRoomName);
	      
	      JTextPane saleRoomTextbox = new JTextPane();
	      saleRoomTextbox.setFont(new Font("바탕", Font.PLAIN, 12));
	      saleRoomTextbox.setBounds(68, 0, 162, 21);
	      saleRoomPanel.add(saleRoomTextbox);
	      
	      JPanel saleRoomOwnerPhone = new JPanel();
	      saleRoomOwnerPhone.setBackground(new Color(0, 128, 128));
	      saleRoomOwnerPhone.setBounds(12, 161, 312, 25);
	      add(saleRoomOwnerPhone);
	      saleRoomOwnerPhone.setLayout(null);
	      
	      JLabel My_Phone = new JLabel("\uB9E4\uB9E4\uC778 \uC5F0\uB77D\uCC98");
	      My_Phone.setForeground(new Color(255, 255, 255));
	      My_Phone.setFont(new Font("바탕", Font.BOLD, 14));
	      My_Phone.setBounds(10, 0, 92, 21);
	      saleRoomOwnerPhone.add(My_Phone);
	      
	      JLabel Tx_Phone = new JLabel();
	      Tx_Phone.setBounds(112, 0, 191, 21);
	      saleRoomOwnerPhone.add(Tx_Phone);
	      String phone = dao.find_phone(id);
	      Tx_Phone.setText(phone);
	      
	      JLabel roomSaleInfoTitle = new JLabel("Rustic");
	      roomSaleInfoTitle.setForeground(new Color(255, 255, 255));
	      roomSaleInfoTitle.setHorizontalAlignment(SwingConstants.LEFT);
	      roomSaleInfoTitle.setFont(new Font("Segoe Print", Font.BOLD, 15));
	      roomSaleInfoTitle.setBounds(22, 10, 54, 25);
	      add(roomSaleInfoTitle);
	      
	      JButton saleRoomPhotoRegBtn = new JButton("\uC0AC\uC9C4\uB4F1\uB85D");
	      saleRoomPhotoRegBtn.setFont(new Font("바탕", Font.BOLD, 14));
	      saleRoomPhotoRegBtn.setBackground(new Color(0, 128, 128));
	      saleRoomPhotoRegBtn.setBounds(364, 393, 120, 45);
	      add(saleRoomPhotoRegBtn);
	      
	      JButton saleRoomWriteBtn = new JButton("\uBC29\uB4F1\uB85D\uC644\uB8CC");
	      
	     
	      saleRoomWriteBtn.setFont(new Font("바탕", Font.BOLD, 14));
	      saleRoomWriteBtn.setBackground(UIManager.getColor("Button.background"));
	      saleRoomWriteBtn.setBounds(498, 393, 120, 45);
	      add(saleRoomWriteBtn);
	      
	      JPanel adressPanel = new JPanel();
	      adressPanel.setBackground(new Color(0, 128, 128));
	      adressPanel.setBounds(12, 45, 367, 34);
	      add(adressPanel);
	      adressPanel.setLayout(null);
	      
	      JLabel lblNewLabel = new JLabel("\uC8FC\uC18C");
	      lblNewLabel.setFont(new Font("바탕", Font.BOLD, 13));
	      lblNewLabel.setForeground(new Color(255, 255, 255));
	      lblNewLabel.setBounds(10, 8, 28, 15);
	      adressPanel.add(lblNewLabel);
	      
	      textField = new JTextField();
	      textField.setFont(new Font("바탕", Font.PLAIN, 12));
	      textField.setBounds(68, 6, 188, 21);
	      adressPanel.add(textField);
	      textField.setColumns(10);
	      
	      JButton btnNewButton = new JButton("\uC8FC\uC18C\uAC80\uC0C9");
	      btnNewButton.setFont(new Font("바탕", Font.PLAIN, 12));
	      btnNewButton.setBounds(258, 5, 97, 23);
	      adressPanel.add(btnNewButton);
	      btnNewButton.addMouseListener(new MouseAdapter() {
	      	@Override
	      	public void mouseClicked(MouseEvent e) {
	      		ZipSearch frame = new ZipSearch(id, gubun, 2);
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
	      	}
	      });
	      
	      JPanel saleRoomDetailTextPanel = new JPanel();
	      saleRoomDetailTextPanel.setBackground(new Color(0, 128, 128));
	      saleRoomDetailTextPanel.setBounds(12, 240, 331, 198);
	      add(saleRoomDetailTextPanel);
	      saleRoomDetailTextPanel.setLayout(null);
	      
	      saleRoomDetailText = new JTextField();
	      saleRoomDetailText.setFont(new Font("바탕", Font.PLAIN, 12));
	      saleRoomDetailText.setBounds(0, 32, 331, 173);
	      saleRoomDetailTextPanel.add(saleRoomDetailText);
	      saleRoomDetailText.setColumns(10);
	      
	      JLabel saleRoomDetailLabel = new JLabel("\uC124\uBA85");
	      saleRoomDetailLabel.setBounds(0, 0, 45, 22);
	      saleRoomDetailTextPanel.add(saleRoomDetailLabel);
	      saleRoomDetailLabel.setForeground(new Color(255, 255, 255));
	      saleRoomDetailLabel.setHorizontalAlignment(SwingConstants.CENTER);
	      saleRoomDetailLabel.setFont(new Font("바탕", Font.BOLD, 15));
	      
	      JPanel saleRoomPhotoPanel = new JPanel();
	      saleRoomPhotoPanel.setBackground(new Color(102, 205, 170));
	      saleRoomPhotoPanel.setBounds(364, 125, 254, 242);
	      add(saleRoomPhotoPanel);
	      saleRoomPhotoPanel.setLayout(null);
	      
	      JLabel saleRoomPhotoLabel = new JLabel("\uC0AC\uC9C4\uB4F1\uB85D");
	      saleRoomPhotoLabel.setBounds(10, 10, 50, 18);
	      saleRoomPhotoLabel.setForeground(new Color(255, 255, 255));
	      saleRoomPhotoLabel.setFont(new Font("바탕", Font.BOLD, 12));
	      saleRoomPhotoPanel.add(saleRoomPhotoLabel);
	      
	      JLabel roomSaleInfoTitle_1 = new JLabel("\uBC29 \uB9E4\uB9E4 \uC815\uBCF4 \uB4F1\uB85D");
	      roomSaleInfoTitle_1.setHorizontalAlignment(SwingConstants.LEFT);
	      roomSaleInfoTitle_1.setForeground(Color.WHITE);
	      roomSaleInfoTitle_1.setFont(new Font("바탕", Font.BOLD, 15));
	      roomSaleInfoTitle_1.setBounds(71, 10, 139, 25);
	      add(roomSaleInfoTitle_1);
	      
	      JPanel countToiletRoomPanel = new JPanel();
	      countToiletRoomPanel.setLayout(null);
	      countToiletRoomPanel.setBackground(new Color(0, 128, 128));
	      countToiletRoomPanel.setBounds(12, 196, 331, 34);
	      add(countToiletRoomPanel);
	      
	      JComboBox countRoomCombobox = new JComboBox();
	      countRoomCombobox.setFont(new Font("바탕", Font.PLAIN, 12));
	      countRoomCombobox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
	      countRoomCombobox.setBounds(66, 5, 68, 23);
	      countToiletRoomPanel.add(countRoomCombobox);
	      
	      JLabel countRoomcLabel = new JLabel("\uAC1C");
	      countRoomcLabel.setFont(new Font("바탕", Font.PLAIN, 12));
	      countRoomcLabel.setForeground(Color.WHITE);
	      countRoomcLabel.setBounds(135, 9, 16, 15);
	      countToiletRoomPanel.add(countRoomcLabel);
	      
	      JComboBox countToiletCombobox = new JComboBox();
	      countToiletCombobox.setFont(new Font("바탕", Font.PLAIN, 12));
	      countToiletCombobox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
	      countToiletCombobox.setBounds(237, 5, 68, 23);
	      countToiletRoomPanel.add(countToiletCombobox);
	      
	      JLabel countToiletcLabel = new JLabel("\uAC1C");
	      countToiletcLabel.setFont(new Font("바탕", Font.PLAIN, 12));
	      countToiletcLabel.setForeground(Color.WHITE);
	      countToiletcLabel.setBounds(305, 9, 16, 15);
	      countToiletRoomPanel.add(countToiletcLabel);
	      
	      JLabel countRoomLabel = new JLabel("\uBC29\uAC2F\uC218");
	      countRoomLabel.setForeground(Color.WHITE);
	      countRoomLabel.setFont(new Font("바탕", Font.BOLD, 13));
	      countRoomLabel.setBounds(10, 8, 46, 15);
	      countToiletRoomPanel.add(countRoomLabel);
	      
	      JLabel countToiletLabel = new JLabel("\uD654\uC7A5\uC2E4\uAC2F\uC218");
	      countToiletLabel.setForeground(Color.WHITE);
	      countToiletLabel.setFont(new Font("바탕", Font.BOLD, 13));
	      countToiletLabel.setBounds(161, 8, 77, 15);
	      countToiletRoomPanel.add(countToiletLabel);
	      
	      JPanel countToiletRoomPanel_1 = new JPanel();
	      countToiletRoomPanel_1.setLayout(null);
	      countToiletRoomPanel_1.setBackground(new Color(0, 128, 128));
	      countToiletRoomPanel_1.setBounds(408, 41, 162, 34);
	      add(countToiletRoomPanel_1);
	      
	      JTextField countRoomCombobox_1 = new JTextField();
	      countRoomCombobox_1.setFont(new Font("바탕", Font.PLAIN, 12));
	      countRoomCombobox_1.setBounds(68, 5, 46, 23);
	      countToiletRoomPanel_1.add(countRoomCombobox_1);
	      
	      JLabel countRoomcLabel_1 = new JLabel("\uD3C9\uD615");
	      countRoomcLabel_1.setFont(new Font("바탕", Font.PLAIN, 12));
	      countRoomcLabel_1.setForeground(Color.WHITE);
	      countRoomcLabel_1.setBounds(126, 9, 34, 15);
	      countToiletRoomPanel_1.add(countRoomcLabel_1);
	      
	      JLabel countRoomLabel_1 = new JLabel("\uBA74\uC801");
	      countRoomLabel_1.setForeground(Color.WHITE);
	      countRoomLabel_1.setFont(new Font("바탕", Font.BOLD, 13));
	      countRoomLabel_1.setBounds(10, 8, 46, 15);
	      countToiletRoomPanel_1.add(countRoomLabel_1);
	      
	      JPanel addDetailPanel = new JPanel();
	      addDetailPanel.setLayout(null);
	      addDetailPanel.setBackground(new Color(0, 128, 128));
	      addDetailPanel.setBounds(12, 90, 240, 25);
	      add(addDetailPanel);
	      
	      JLabel adddetail = new JLabel("\uC0C1\uC138\uC8FC\uC18C");
	      adddetail.setForeground(Color.WHITE);
	      adddetail.setFont(new Font("바탕", Font.BOLD, 14));
	      adddetail.setBounds(10, 0, 67, 21);
	      addDetailPanel.add(adddetail);
	      
	      JTextPane adddetailTxBox = new JTextPane();
	      adddetailTxBox.setFont(new Font("바탕", Font.PLAIN, 12));
	      adddetailTxBox.setBounds(68, 0, 162, 21);
	      addDetailPanel.add(adddetailTxBox);
	      
	      JPanel rentcountToiletRoomPanel_1_1 = new JPanel();
	      rentcountToiletRoomPanel_1_1.setLayout(null);
	      rentcountToiletRoomPanel_1_1.setBackground(new Color(0, 128, 128));
	      rentcountToiletRoomPanel_1_1.setBounds(408, 81, 162, 34);
	      add(rentcountToiletRoomPanel_1_1);
	      
	      JLabel rentcountRoomcLabel_1_1 = new JLabel("\uD5A5");
	      rentcountRoomcLabel_1_1.setFont(new Font("바탕", Font.PLAIN, 12));
	      rentcountRoomcLabel_1_1.setForeground(Color.WHITE);
	      rentcountRoomcLabel_1_1.setBounds(126, 9, 34, 15);
	      rentcountToiletRoomPanel_1_1.add(rentcountRoomcLabel_1_1);
	      
	      JLabel direcLabel = new JLabel("\uC9D1 \uBC29\uD5A5");
	      direcLabel.setForeground(Color.WHITE);
	      direcLabel.setFont(new Font("바탕", Font.BOLD, 13));
	      direcLabel.setBounds(10, 8, 46, 15);
	      rentcountToiletRoomPanel_1_1.add(direcLabel);
	      
	      textField_1 = new JTextField();
	      textField_1.setFont(new Font("바탕", Font.PLAIN, 12));
	      textField_1.setColumns(10);
	      textField_1.setBounds(68, 6, 46, 21);
	      rentcountToiletRoomPanel_1_1.add(textField_1);
	      
	      
	      saleRoomWriteBtn.addMouseListener(new MouseAdapter() {
	      	@Override
	      	public void mouseClicked(MouseEvent e) {
	              //등록 버튼
	              
	              MenuDAO dao = MenuDAO.getInstance();
	              
	              String num = dao.comenum(phone);
	           
	          
	              
	           try {
	           
	           dao.insert_bu_menu(saleRoomTextbox.getText(), textField.getText(), adddetailTxBox.getText(),
	                 Integer.parseInt(countRoomCombobox.getSelectedItem().toString()), Integer.parseInt(countRoomCombobox_1.getText()),
	                 saleRoomDetailText.getText(), textField_1.getText(), Integer.parseInt(num),Integer.parseInt(countToiletCombobox.getSelectedItem().toString()) );
	           JOptionPane.showMessageDialog(null, "매매 물품 등록 완료");
	           
	           saleRoomTextbox.setText("");
	           textField.setText("");
	           adddetailTxBox.setText("");
	           countRoomCombobox.setSelectedIndex(0);
	           countToiletCombobox.setSelectedIndex(0);
	           saleRoomDetailText.setText("");
	           countRoomCombobox_1.setText("");
	           textField_1.setText("");
	           
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
	 	  
		   textField.setText(String.valueOf(tot));
	  	   
	     }
	}



   public class OwnerMain extends JPanel {

		
		RecentListTableModel model;
		RecentListTableModel2 model2;
		MainpageSearchDAO dao=null;
		private JTable table;
		private JTable table2;
		private static int vnum=0;
		private JTextField textField;
		
		private static String id = null;

		/**
		 * Create the panel.
		 */
		public OwnerMain(String id) {
			setBackground(new Color(0, 128, 128));
			
			setBounds(0,0, 639, 498);
			setLayout(null);
			setVisible(true);
			
			this.id = id;
			//eventProc();		//이벤트 등록메소드
			
			model = new RecentListTableModel();
			model2 = new RecentListTableModel2();
			table	= new JTable( model );
			table.setFont(new Font("바탕", Font.PLAIN, 14));
			table2	= new JTable( model2 );
			table2.setFont(new Font("바탕", Font.PLAIN, 14));
		
			JLabel lblNewLabel = new JLabel("\uB0B4 \uC219\uBC15 \uB4F1\uB85D \uB9AC\uC2A4\uD2B8");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("바탕", Font.BOLD, 17));
			lblNewLabel.setBounds(94, 57, 184, 51);
			add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("\uB0B4 \uBD80\uB3D9\uC0B0 \uB4F1\uB85D \uB9AC\uC2A4\uD2B8");
			lblNewLabel_1.setForeground(new Color(255, 255, 255));
			lblNewLabel_1.setFont(new Font("바탕", Font.BOLD, 17));
			lblNewLabel_1.setBounds(372, 57, 184, 51);
			add(lblNewLabel_1);
		
			
			JPanel panel = new JPanel();
			panel.setBounds(37, 118, 565, 285);
			add("Center",panel);
			panel.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane( table );
			scrollPane.setBounds(0, 0, 287, 285);
			panel.add(scrollPane );
			
			JScrollPane scrollPane_1 = new JScrollPane(table2);
			scrollPane_1.setBounds(283, 0, 282, 285);
			panel.add(scrollPane_1);
			
			JButton btnNewButton = new JButton("\uC0C8\uB85C\uACE0\uCE68");
			btnNewButton.setFont(new Font("바탕", Font.BOLD, 14));
			btnNewButton.setBackground(new Color(95, 158, 160));
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//
					
					try {
						selectTable();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						selectTable2();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//
					
					
					
				}
			});
			btnNewButton.setBounds(492, 424, 110, 31);
			add(btnNewButton);
			
			String searchText[] =  {"이름","주소","상세주소"};
			
			try {
				dao = new MainpageSearchDAO();
				System.out.println("메인페이지 서치 DB연결 성공");
				selectTable();
				
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "메인페이지 서치 DB연결 실패 : " + e.getMessage());
			}
			
			try {
				dao = new MainpageSearchDAO();
				System.out.println("메인페이지 서치 DB연결 성공");
				
				selectTable2();
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "메인페이지 서치 DB연결 실패 : " + e.getMessage());
			}
			table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					int row = table.getSelectedRow();
					int col=0; //맨 앞 비디오 번호 가져올거임
					vnum = Integer.parseInt(table.getValueAt(row, col).toString());	
					
					asd login = new asd(vnum);
		            login.setUndecorated(true);
		            login.setVisible(true);
			
					//tfReturnVideoNum.setText(String.valueOf(vNum));
					
				}
			});
			
			table2.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					int row = table2.getSelectedRow();
					int col=0; //맨 앞 비디오 번호 가져올거임
					vnum = Integer.parseInt(table2.getValueAt(row, col).toString());	
					
					budong login = new budong(vnum);
		            login.setUndecorated(true);
		            login.setVisible(true);
			
					//tfReturnVideoNum.setText(String.valueOf(vNum));
					
				}
			});
			
			
			 setLocationRelativeTo(null);
		
			
		}
		
		
		class RecentListTableModel extends AbstractTableModel { 
			  
			ArrayList data = new ArrayList();
			String [] columnNames = {"등록번호", "이름", "주소", "상세 주소"};
			
			
			//String [] columnNames = {"이름", "전화번호","아이디", "비밀번호", "반납예정일", "반납여부" };
			//=============================================================
			// 1. 기본적인 TabelModel  만들기
			// 아래 세 함수는 TabelModel 인터페이스의 추상함수인데
			// AbstractTabelModel에서 구현되지 않았기에...
			// 반드시 사용자 구현 필수!!!!
			
			    public int getColumnCount() { 
			        return columnNames.length; 
			    } 
			     
			    public int getRowCount() { 
			        return data.size(); 
			    } 
			
			    public Object getValueAt(int row, int col) { 
			    	ArrayList temp = (ArrayList)data.get( row );
			        return temp.get( col ); 
			    }
			

			    
				public String getColumnName(int col) { 
			       return columnNames[col]; 
			    } 
			
			}
		
		class RecentListTableModel2 extends AbstractTableModel { 
			  
			ArrayList data = new ArrayList();
			String [] columnNames = {"등록번호", "이름", "주소", "상세 주소"};
			
			
			//String [] columnNames = {"이름", "전화번호","아이디", "비밀번호", "반납예정일", "반납여부" };
			//=============================================================
			// 1. 기본적인 TabelModel  만들기
			// 아래 세 함수는 TabelModel 인터페이스의 추상함수인데
			// AbstractTabelModel에서 구현되지 않았기에...
			// 반드시 사용자 구현 필수!!!!
			
			    public int getColumnCount() { 
			        return columnNames.length; 
			    } 
			     
			    public int getRowCount() { 
			        return data.size(); 
			    } 
			
			    public Object getValueAt(int row, int col) { 
			    	ArrayList temp = (ArrayList)data.get( row );
			        return temp.get( col ); 
			    }
			

			    
				public String getColumnName(int col) { 
			       return columnNames[col]; 
			    } 
			
			}
		
		
		
			//이벤트 등록(연결) 메소드
			public void eventProc() {
						
			}
			
			
			public int getvnum() {
				return vnum;
			}
			
			
			
			
			
			void selectTable() throws Exception {

				int ownernum = 0;
				
				try {
					ownernum = dao.checkownernunm(id);
					ArrayList list = dao.bububu(ownernum);

					model2.data = list;
					table.setModel(model2);
					//정보 변경에 따른 실시간 체인지
					model2.fireTableDataChanged();
				}	
				catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "토탈리스트 출력 실패 : " + e.getMessage());
				}
			}
			
			void selectTable2() throws Exception {

				int ownernunm = 0;
				
				
				try {
					ownernunm = dao.checkownernunm(id);
					
					ArrayList list1 = dao.memenu(ownernunm);

					model.data = list1;
					table.setModel(model);
					//정보 변경에 따른 실시간 체인지
					model.fireTableDataChanged();
				}	
				catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "토탈리스트 출력 실패 : " + e.getMessage());
				}
				
			
			}
			
	}




   
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
   rentRoomName.setFont(new Font("바탕", Font.BOLD, 14));
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
   rentRoomPhotoRegBtn.setFont(new Font("바탕", Font.BOLD, 14));
   rentRoomPhotoRegBtn.setBackground(new Color(0, 128, 128));
   rentRoomPhotoRegBtn.setBounds(364, 393, 120, 45);
   getContentPane().add(rentRoomPhotoRegBtn);
   
   JPanel rentAdressPanel = new JPanel();
   rentAdressPanel.setBackground(new Color(0, 128, 128));
   rentAdressPanel.setBounds(12, 45, 379, 34);
   getContentPane().add(rentAdressPanel);
   rentAdressPanel.setLayout(null);
   
   JLabel rentRoomAdress = new JLabel("\uC8FC\uC18C");
   rentRoomAdress.setFont(new Font("바탕", Font.BOLD, 13));
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
					
					dao.menumodify(rentRoomTextbox.getText(), rentAddrTxBox.getText(), addrdetailtxbox.getText(), rentcountRoomCombobox.getSelectedItem().toString(), squareftTxbox.getText(), direcTxbox.getText(), rentRoomDetailText.getText(), menunum);
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
	      setVisible(false);   //이게 맞나? 프레임 대쉬보드 실행시 얘가 이상하게 떠서 넣어둠..
	      
	      JPanel saleRoomPanel = new JPanel();
	      saleRoomPanel.setBackground(new Color(0, 128, 128));
	      saleRoomPanel.setBounds(12, 126, 240, 25);
	      getContentPane().add(saleRoomPanel);
	      saleRoomPanel.setLayout(null);
	      
	      JLabel saleRoomName = new JLabel("\uBC29\uC774\uB984");
	      saleRoomName.setForeground(new Color(255, 255, 255));
	      saleRoomName.setFont(new Font("바탕", Font.BOLD, 14));
	      saleRoomName.setBounds(10, 0, 67, 21);
	      saleRoomPanel.add(saleRoomName);
	      
	      JTextPane nametx = new JTextPane();
	      nametx.setBounds(68, 0, 162, 21);
	      saleRoomPanel.add(nametx);
	      
	      
	      JLabel roomSaleInfoTitle = new JLabel("Rustic");
	      roomSaleInfoTitle.setForeground(new Color(255, 255, 255));
	      roomSaleInfoTitle.setHorizontalAlignment(SwingConstants.LEFT);
	      roomSaleInfoTitle.setFont(new Font("Segoe Print", Font.BOLD, 15));
	      roomSaleInfoTitle.setBounds(22, 10, 54, 25);
	      getContentPane().add(roomSaleInfoTitle);
	      
	      JButton saleRoomPhotoRegBtn = new JButton("\uC0AC\uC9C4\uB4F1\uB85D");
	      saleRoomPhotoRegBtn.setFont(new Font("바탕", Font.BOLD, 14));
	      saleRoomPhotoRegBtn.setBackground(new Color(0, 128, 128));
	      saleRoomPhotoRegBtn.setBounds(364, 393, 120, 45);
	      getContentPane().add(saleRoomPhotoRegBtn);
	      
	      
	      
	      JPanel adressPanel = new JPanel();
	      adressPanel.setBackground(new Color(0, 128, 128));
	      adressPanel.setBounds(12, 45, 289, 34);
	      getContentPane().add(adressPanel);
	      adressPanel.setLayout(null);
	      
	      JLabel lblNewLabel = new JLabel("\uC8FC\uC18C");
	      lblNewLabel.setFont(new Font("바탕", Font.BOLD, 13));
	      lblNewLabel.setForeground(new Color(255, 255, 255));
	      lblNewLabel.setBounds(10, 8, 28, 15);
	      adressPanel.add(lblNewLabel);
	      
	      addrtext = new JTextField();
	      addrtext.setBounds(68, 6, 188, 21);
	      adressPanel.add(addrtext);
	      addrtext.setColumns(10);
	      
	      JPanel saleRoomDetailTextPanel = new JPanel();
	      saleRoomDetailTextPanel.setBackground(new Color(0, 128, 128));
	      saleRoomDetailTextPanel.setBounds(12, 240, 331, 198);
	      getContentPane().add(saleRoomDetailTextPanel);
	      saleRoomDetailTextPanel.setLayout(null);
	      
	      introtx = new JTextField();
	      introtx.setBounds(0, 32, 331, 173);
	      saleRoomDetailTextPanel.add(introtx);
	      introtx.setColumns(10);
	      
	      JLabel saleRoomDetailLabel = new JLabel("\uC124\uBA85");
	      saleRoomDetailLabel.setBounds(0, 0, 45, 22);
	      saleRoomDetailTextPanel.add(saleRoomDetailLabel);
	      saleRoomDetailLabel.setForeground(new Color(255, 255, 255));
	      saleRoomDetailLabel.setHorizontalAlignment(SwingConstants.CENTER);
	      saleRoomDetailLabel.setFont(new Font("바탕", Font.BOLD, 15));
	      
	      JPanel saleRoomPhotoPanel = new JPanel();
	      saleRoomPhotoPanel.setBackground(new Color(102, 205, 170));
	      saleRoomPhotoPanel.setBounds(364, 125, 254, 242);
	      getContentPane().add(saleRoomPhotoPanel);
	      saleRoomPhotoPanel.setLayout(null);
	      
	      JLabel saleRoomPhotoLabel = new JLabel("\uC0AC\uC9C4\uB4F1\uB85D");
	      saleRoomPhotoLabel.setBounds(10, 10, 50, 18);
	      saleRoomPhotoLabel.setForeground(new Color(255, 255, 255));
	      saleRoomPhotoLabel.setFont(new Font("바탕", Font.BOLD, 12));
	      saleRoomPhotoPanel.add(saleRoomPhotoLabel);
	      
	      JLabel roomSaleInfoTitle_1 = new JLabel("\uBC29 \uB9E4\uB9E4 \uC815\uBCF4 \uB4F1\uB85D");
	      roomSaleInfoTitle_1.setHorizontalAlignment(SwingConstants.LEFT);
	      roomSaleInfoTitle_1.setForeground(Color.WHITE);
	      roomSaleInfoTitle_1.setFont(new Font("바탕", Font.BOLD, 15));
	      roomSaleInfoTitle_1.setBounds(71, 10, 125, 25);
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
	      countRoomcLabel.setForeground(Color.WHITE);
	      countRoomcLabel.setBounds(135, 9, 16, 15);
	      countToiletRoomPanel.add(countRoomcLabel);
	      
	      JComboBox toiletcntcombo = new JComboBox();
	      toiletcntcombo.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
	      toiletcntcombo.setBounds(237, 5, 68, 23);
	      countToiletRoomPanel.add(toiletcntcombo);
	      
	      JLabel countToiletcLabel = new JLabel("\uAC1C");
	      countToiletcLabel.setForeground(Color.WHITE);
	      countToiletcLabel.setBounds(305, 9, 16, 15);
	      countToiletRoomPanel.add(countToiletcLabel);
	      
	      JLabel countRoomLabel = new JLabel("\uBC29\uAC2F\uC218");
	      countRoomLabel.setForeground(Color.WHITE);
	      countRoomLabel.setFont(new Font("바탕", Font.BOLD, 13));
	      countRoomLabel.setBounds(10, 8, 46, 15);
	      countToiletRoomPanel.add(countRoomLabel);
	      
	      JLabel countToiletLabel = new JLabel("\uD654\uC7A5\uC2E4\uAC2F\uC218");
	      countToiletLabel.setForeground(Color.WHITE);
	      countToiletLabel.setFont(new Font("바탕", Font.BOLD, 13));
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
	      addDetailPanel.setBounds(12, 90, 240, 25);
	      getContentPane().add(addDetailPanel);
	      
	      JLabel adddetail = new JLabel("\uC0C1\uC138\uC8FC\uC18C");
	      adddetail.setForeground(Color.WHITE);
	      adddetail.setFont(new Font("Dialog", Font.BOLD, 14));
	      adddetail.setBounds(10, 0, 67, 21);
	      addDetailPanel.add(adddetail);
	      
	      JTextPane detailtx = new JTextPane();
	      detailtx.setBounds(68, 0, 162, 21);
	      addDetailPanel.add(detailtx);
	      
	      JPanel rentcountToiletRoomPanel_1_1 = new JPanel();
	      rentcountToiletRoomPanel_1_1.setLayout(null);
	      rentcountToiletRoomPanel_1_1.setBackground(new Color(0, 128, 128));
	      rentcountToiletRoomPanel_1_1.setBounds(12, 161, 240, 34);
	      getContentPane().add(rentcountToiletRoomPanel_1_1);
	      
	      JLabel rentcountRoomcLabel_1_1 = new JLabel("\uD5A5");
	      rentcountRoomcLabel_1_1.setForeground(Color.WHITE);
	      rentcountRoomcLabel_1_1.setBounds(176, 9, 34, 15);
	      rentcountToiletRoomPanel_1_1.add(rentcountRoomcLabel_1_1);
	      
	      JLabel direcLabel = new JLabel("\uC9D1 \uBC29\uD5A5");
	      direcLabel.setForeground(Color.WHITE);
	      direcLabel.setFont(new Font("Dialog", Font.BOLD, 13));
	      direcLabel.setBounds(10, 8, 46, 15);
	      rentcountToiletRoomPanel_1_1.add(direcLabel);
	      
	      directx = new JTextField();
	      directx.setColumns(10);
	      directx.setBounds(82, 6, 82, 21);
	      rentcountToiletRoomPanel_1_1.add(directx);
	      
	      JLabel lblNewLabel_1 = new JLabel("X");
	      lblNewLabel_1.setForeground(new Color(255, 255, 255));
	      lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 16));
	      lblNewLabel_1.setBounds(594, 17, 24, 15);
	      getContentPane().add(lblNewLabel_1);
	      
	      
	      MenuDAO dao1 = MenuDAO.getInstance();
	      ArrayList list = dao1.select(numnum);
	      // MENUNAME, ADDRESS, ADDRESSDETAIL, BANGCOUNT, SQUAREMESURE, SUNDIRECTION, MENUINTRODUCE, OWNERNUM
	       //네임, 주소, 상세주소, 방개수, 평수, 배산임수, 메뉴소개, 오더넘

	      nametx.setText(list.get(0).toString());
	      addrtext.setText(list.get(1).toString());
	      detailtx.setText(list.get(2).toString());
	      roomcntcombo.setSelectedItem(list.get(3).toString());
	      fttx.setText(list.get(4).toString());
	      directx.setText(list.get(5).toString());
	      introtx.setText(list.get(6).toString());
	      toiletcntcombo.setSelectedItem(list.get(7).toString());
	      
	      JButton btnNewButton = new JButton("수정 하기");
	      btnNewButton.addMouseListener(new MouseAdapter() {
	      	@Override
	      	public void mouseClicked(MouseEvent e) {
	      		//수정버튼
	      		
	      		try {
					dao.bumodify(nametx.getText(), addrtext.getText(), detailtx.getText(), roomcntcombo.getSelectedItem().toString(),fttx.getText(),directx.getText(),introtx.getText(),toiletcntcombo.getSelectedItem().toString(),numnum);
					JOptionPane.showMessageDialog(null, "수정 완료");
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
   
   


   
 
   
}