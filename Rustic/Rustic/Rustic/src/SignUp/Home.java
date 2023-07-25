package SignUp;

import dao.MemberDao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

   private JPanel contentPane;
   private JTextField namebox;
   private JTextField idbox;
   private JPasswordField pwbox;
   
   int xx,xy;
   private JTextField juminbox1;
   private JPasswordField juminbox2;
   private JTextField telbox;
   private Image img_login = new ImageIcon(Home.class.getResource("/res/login.png")).getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH);  
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Home frame = new Home();
               frame.setUndecorated(true);
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }
   
   
   // going to borrow code from a gist to move frame.
   

   /**
    * Create the frame.
    */
   public Home() {
      setUndecorated(true);
      setBackground(Color.WHITE);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 735, 519);
      contentPane = new JPanel();
      contentPane.setBackground(Color.WHITE);
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      JRadioButton ownerBox = new JRadioButton("\uC18C\uC720\uC8FC \uD68C\uC6D0");
      
      JRadioButton custBox  = new JRadioButton("고객 회원");
      ownerBox.setBackground(Color.WHITE);
      ownerBox.setBounds(541, 88, 119, 23);
      contentPane.add(ownerBox);
      custBox.setBackground(Color.WHITE);
      custBox.setBounds(377, 88, 119, 23);
      contentPane.add(custBox);
      
      
      //
      ButtonGroup grouprd = new ButtonGroup();
      grouprd.add(custBox);
      grouprd.add(ownerBox);
      
      
      
      JPanel panel = new JPanel();
      panel.setBackground(Color.DARK_GRAY);
      panel.setBounds(0, 0, 346, 490);
      contentPane.add(panel);
      panel.setLayout(null);

      JLabel label = new JLabel("");
      label.setBounds(-70, 0, 416, 517);
      panel.add(label);
      
      label.addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {
            
             xx = e.getX();
              xy = e.getY();
         }
      });
      label.addMouseMotionListener(new MouseMotionAdapter() {
         @Override
         public void mouseDragged(MouseEvent arg0) {
            
            int x = arg0.getXOnScreen();
               int y = arg0.getYOnScreen();
               Home.this.setLocation(x - xx, y - xy);  
         }
      });
      label.setVerticalAlignment(SwingConstants.TOP);
      label.setIcon(new ImageIcon(Home.class.getResource("/res/logo.png")));
      
      Button button = new Button("SignUp");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
         }
      });
      button.addMouseListener(new MouseAdapter() {
         @Override
          public void mouseEntered(MouseEvent e) {
             button.setBackground(new Color(0, 178, 128));
              // SoftBevelBorder b5 = new SoftBevelBorder(SoftBevelBorder.LOWERED);
              // LoginBtn.setBorder(b5);
          }
          
          @Override
          public void mouseExited(MouseEvent e) {
             button.setBackground(new Color(0, 128, 128));
          }
         
         
         
         
         
         //사인업 버튼 클릭시 이벤트
         @Override
         public void mouseClicked(MouseEvent e) {
            MemberDao dao = MemberDao.getInstance();
            String juminNum = juminbox1.getText() + "-" + juminbox2.getText();

            if(custBox.isSelected()){
               try {
                  dao.insertmember_cus(idbox.getText(), pwbox.getText(), namebox.getText(),telbox.getText(), juminNum );
                  //System.out.println("회원가입 성공");
                  JOptionPane.showMessageDialog(null, "회원가입성공");
                  
               }
               catch (Exception e2) {
                  // TODO: handle exception
                  JOptionPane.showMessageDialog(null, "회원가입실패 : " + e2.getMessage());
            }
            }
               
            else if(ownerBox.isSelected()) {
               try {
                  dao.insertmember(idbox.getText(), pwbox.getText(), namebox.getText(),telbox.getText(), juminNum );
                  //System.out.println("회원가입 성공");
                  JOptionPane.showMessageDialog(null, "회원가입성공");
                  
               }
               catch (Exception e2) {
                  // TODO: handle exception
                  JOptionPane.showMessageDialog(null, "회원가입실패 : " + e2.getMessage());
               }
               
            }
   
            
         }
      });
      
      
      
      
      
      button.setForeground(Color.WHITE);
      button.setBackground(new Color(0, 128, 128));
      button.setBounds(377, 420, 283, 51);
      contentPane.add(button);
      
      namebox = new JTextField();
      namebox.setBounds(377, 33, 283, 36);
      contentPane.add(namebox);
      namebox.setColumns(10);
      
      JLabel lblUsername = new JLabel("USERNAME");
      lblUsername.setBounds(377, 9, 114, 14);
      contentPane.add(lblUsername);
      
      JLabel lblEmail = new JLabel("ID");
      lblEmail.setBounds(375, 132, 54, 14);
      contentPane.add(lblEmail);
      
      idbox = new JTextField();
      idbox.setColumns(10);
      idbox.setBounds(377, 156, 283, 36);
      contentPane.add(idbox);
      
      JLabel lblPassword = new JLabel("PASSWORD");
      lblPassword.setBounds(378, 202, 96, 14);
      contentPane.add(lblPassword);
      
      JLabel lblRepeatPassword = new JLabel("\uC8FC\uBBFC\uBC88\uD638");
      lblRepeatPassword.setBounds(377, 272, 133, 14);
      contentPane.add(lblRepeatPassword);
      
      pwbox = new JPasswordField();
      pwbox.setBounds(377, 226, 283, 36);
      contentPane.add(pwbox);
      
      JLabel lbl_close = new JLabel("X");
      lbl_close.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            
            System.exit(0);
         }
      });
      lbl_close.setHorizontalAlignment(SwingConstants.CENTER);
      lbl_close.setForeground(new Color(241, 57, 83));
      lbl_close.setFont(new Font("Tahoma", Font.PLAIN, 18));
      lbl_close.setBounds(698, 0, 37, 27);
      contentPane.add(lbl_close);
      
      juminbox1 = new JTextField();
      juminbox1.setBounds(377, 296, 122, 36);
      contentPane.add(juminbox1);
      juminbox1.setColumns(10);
      
      JLabel lblNewLabel = new JLabel("-");
      lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setBounds(500, 306, 29, 14);
      contentPane.add(lblNewLabel);
      
      juminbox2 = new JPasswordField();
      juminbox2.setBounds(527, 296, 133, 36);
      contentPane.add(juminbox2);
      
      JLabel lblNewLabel_1 = new JLabel("\uC804\uD654\uBC88\uD638");
      lblNewLabel_1.setBounds(377, 342, 52, 15);
      contentPane.add(lblNewLabel_1);
      
      telbox = new JTextField();
      telbox.setBounds(377, 367, 283, 36);
      contentPane.add(telbox);
      telbox.setColumns(10);
      
      JLabel loginpage = new JLabel("");
      loginpage.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            FrameLogin login = new FrameLogin();
            login.setUndecorated(true);
            login.setVisible(true);
            dispose();
         }
      });
      loginpage.setHorizontalTextPosition(SwingConstants.CENTER);
      loginpage.setBounds(661, 0, 29, 27);
      contentPane.add(loginpage);
      
      //
   

      
      //로그인 페이지로 가기
      loginpage.setIcon(new ImageIcon(img_login));
      

            

      
      
      setLocationRelativeTo(null);      //이거 붙이면 실행시 가운데에 창이 뜸
   }
}