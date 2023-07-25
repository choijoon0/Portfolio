package SignUp;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.*;

import dao.MemberDao;
import mainpage.FrameDashboard;
import ownerWrite.FrameDashboard_owner;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Button;

public class FrameLogin extends JFrame {

	private Image img_userID = new ImageIcon(FrameLogin.class.getResource("/res/log.png")).getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);        
	private Image img_pass = new ImageIcon(FrameLogin.class.getResource("/res/key.png")).getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);  
	private Image img_logo = new ImageIcon(FrameLogin.class.getResource("/res/logo.png")).getImage().getScaledInstance(326,400, Image.SCALE_SMOOTH);  
	
	private JPanel contentPane;
	private JTextField UserID;
	private JPasswordField UserPass;
	private JPanel LoginBtn;
	private JLabel lblNewLabel;
	private JLabel lblx;
	private JLabel Logo;
	private JLabel userIdImg;
	
	private JLabel userPwImg;
	private JPanel panel_2;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLogin frame = new FrameLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameLogin() {

		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(12, 116, 250, 40);
		contentPane.add(panel);
		panel.setLayout(null);
			
		JRadioButton radiobtn2 = new JRadioButton("\uC18C\uC720\uC8FC");
		radiobtn2.setFont(new Font("굴림", Font.PLAIN, 13));
		radiobtn2.setForeground(new Color(255, 255, 255));
		radiobtn2.setBackground(new Color(0, 128, 0));
		radiobtn2.setHorizontalAlignment(SwingConstants.CENTER);
		radiobtn2.setBounds(148, 67, 94, 23);
		contentPane.add(radiobtn2);
		
		JRadioButton radiobtn1 = new JRadioButton("고객");
		radiobtn1.setFont(new Font("굴림", Font.PLAIN, 13));
		radiobtn1.setForeground(new Color(255, 255, 255));
		radiobtn1.setBackground(new Color(0, 128, 0));
		radiobtn1.setHorizontalAlignment(SwingConstants.CENTER);
		radiobtn1.setBounds(36, 67, 94, 23);
		contentPane.add(radiobtn1);
		setLocationRelativeTo(null);

		//라디오 버튼 그룹화
		ButtonGroup groupRd = new ButtonGroup();
		groupRd.add(radiobtn1);
		groupRd.add(radiobtn2);
		
		
		
		UserID = new JTextField();
		UserID.addFocusListener(new FocusAdapter() {
			//유저 텍스트필드 포커스 됬을 때 
			@Override
			public void focusGained(FocusEvent e) {
				if(UserID.getText().equals("ID")) {
					UserID.setText("");
				}
				else {
					UserID.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(UserID.getText().equals("")) {
					UserID.setText("ID");
					
				}
			}
		});
		
		UserID.setBorder(null);
		UserID.setText("ID");
		UserID.setBounds(12, 10, 169, 21);
		panel.add(UserID);
		UserID.setColumns(10);
		
		userIdImg = new JLabel("");
		userIdImg.setHorizontalAlignment(SwingConstants.CENTER);
		userIdImg.setBounds(193, 0, 57, 40);
		panel.add(userIdImg);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(12, 171, 250, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		UserPass = new JPasswordField();
		UserPass.addFocusListener(new FocusAdapter() {
			//텍스트필드 선택됬을 때 
			@Override
			public void focusGained(FocusEvent e) {
				if(UserPass.getText().equals("Password")) {
					UserPass.setEchoChar('●');
					UserPass.setText("");
				}
				else {
					UserPass.selectAll();
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(UserPass.getText().equals("")) {
					UserPass.setText("Password");
					UserPass.setEchoChar((char)0);
				}
			}
		});
		UserPass.setBorder(null);
		UserPass.setEchoChar((char)0);
		UserPass.setText("Password");
		UserPass.setBounds(12, 10, 169, 21);
		panel_1.add(UserPass);
		
		userPwImg = new JLabel("");
		userPwImg.setHorizontalAlignment(SwingConstants.CENTER);
		userPwImg.setBounds(193, 0, 57, 40);
		panel_1.add(userPwImg);
		
		
		//로그인
		LoginBtn = new JPanel();

		LoginBtn.setBackground(new Color(0, 100, 0));
		LoginBtn.setBounds(12, 274, 250, 52);
		contentPane.add(LoginBtn);
		LoginBtn.setLayout(null);
		
		lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel.setBounds(106, 10, 116, 32);
		LoginBtn.add(lblNewLabel);
		
		
		
		
		
		//로그인시 
		LoginBtn.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseEntered(MouseEvent e) {
				LoginBtn.setBackground(new Color(0, 150, 0));
				 // SoftBevelBorder b5 = new SoftBevelBorder(SoftBevelBorder.LOWERED);
				 // LoginBtn.setBorder(b5);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				LoginBtn.setBackground(new Color(0, 100, 0));
			}
			
			
			public void mouseClicked(MouseEvent e) {

			String ownerid = UserID.getText();
			String ownerpw = UserPass.getText();
			
			MemberDao dao = MemberDao.getInstance();
			
			if(radiobtn1.isSelected()) {

				int result = dao.findByUsernameAndPassword_Customer(ownerid, ownerpw);
				
				if(result == 1) {
					//로그인 성공 메시지
					//고객 로그인
					FrameDashboard frame = new FrameDashboard(ownerid, 1);
					frame.setUndecorated(true);
					frame.setVisible(true);
					dispose();
					//MemberListFrame mlf = new MemberListFrame(username);
					//현재 화면 종료
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "로그인 실패");
				}
				
			}
			else if(radiobtn2.isSelected()) {
				//집주인 로그인
				int result = dao.findByUsernameAndPassword(ownerid, ownerpw);
				if(result == 1) {
					//로그인 성공 메시지
					
					FrameDashboard_owner frame = new FrameDashboard_owner(ownerid, 2);
					frame.setUndecorated(true);
					frame.setVisible(true);
					dispose();
					//MemberListFrame mlf = new MemberListFrame(username);
					//현재 화면 종료
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "로그인 실패");
				}
			}
						
			}
			
			
			
		});
		
		
		
		lblx = new JLabel("X");
		lblx.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "종료?", "테스트문장", JOptionPane.YES_NO_OPTION)==0) {
					FrameLogin.this.dispose();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblx.setForeground(Color.RED);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblx.setForeground(Color.white);
			}
		});
		lblx.setForeground(new Color(255, 255, 255));
		lblx.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblx.setBackground(new Color(255, 255, 255));
		lblx.setHorizontalAlignment(SwingConstants.CENTER);
		lblx.setBounds(568, 10, 20, 20);
		contentPane.add(lblx);
		
		Logo = new JLabel("");
		Logo.setHorizontalAlignment(SwingConstants.CENTER);
		Logo.setBounds(274, 0, 326, 400);
		contentPane.add(Logo);
		
		//로고띄우는 부분
		Logo.setIcon(new ImageIcon(img_logo));
		userIdImg.setIcon(new ImageIcon(img_userID));
		userPwImg.setIcon(new ImageIcon(img_pass));
		
		panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2.setBackground(new Color(0, 178, 128));
				 // SoftBevelBorder b5 = new SoftBevelBorder(SoftBevelBorder.LOWERED);
				 // LoginBtn.setBorder(b5);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2.setBackground(new Color(0, 128, 128));
			}
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Home home = new Home();
				home.setUndecorated(true);
				home.setVisible(true);
				dispose();
			}
		});

		panel_2.setBackground(new Color(0, 128, 128));
		panel_2.setBounds(12, 240, 250, 27);
		contentPane.add(panel_2);
		
		//회원가입
		lblNewLabel_1 = new JLabel("Join MemeberShip");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_1.setForeground(Color.WHITE);
		panel_2.add(lblNewLabel_1);
		

		
		
		
	}
}
