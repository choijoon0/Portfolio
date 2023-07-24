package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.LoginDAO;
import model.rec.LoginVO;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JPasswordField;

public class LoginView extends JFrame implements ActionListener {

	JPanel contentPane;

	JTextField idtf;
	JTextField tfpassword;

	JButton btnLogin;
	JButton btninsert;

	JRadioButton rdbtnFestOwn;
	JRadioButton rdbtnBoothOwn;
	JRadioButton rdbtnCustomerOwn;

	ButtonGroup group;

	LoginDAO dao;
	LoginVO vo;
	BoothMainView bview;
	FestMainView fview;
	MemberMainView mview;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPasswordField passwordField;

	//
	public LoginView() {
		newObject();
		addLayout();
		eventProc();
		setLocationRelativeTo(null);
		rdbtnFestOwn.setSelected(true);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("함초롬돋움", Font.PLAIN, 20));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\04-09\\eclipse-workspace\\project\\src\\img\\white.jpg"));
		lblNewLabel.setBounds(0, 0, 982, 511);
		contentPane.add(lblNewLabel);
		
		
		
		try {
			dao = new LoginDAO();
			System.out.println("DB연결 성공");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "DB 연결 실패" + e.getMessage());
		}

	}

	//
	void newObject() {
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);

		idtf = new JTextField();
		idtf.setFont(new Font("양재튼튼체B", Font.PLAIN, 20));
		idtf.setBackground(new Color(226, 226, 226));
		tfpassword = new JTextField();
		tfpassword.setFont(new Font("양재튼튼체B", Font.PLAIN, 20));
		tfpassword.setBackground(new Color(226, 226, 226));

		btnLogin = new JButton("로그인");

		btninsert = new JButton("회원가입");

		group = new ButtonGroup();

		rdbtnFestOwn = new JRadioButton("축제관리자");

		rdbtnBoothOwn = new JRadioButton("부스관리자");

		rdbtnCustomerOwn = new JRadioButton("고객");
		passwordField = new JPasswordField();
		group.add(rdbtnFestOwn);
		group.add(rdbtnBoothOwn);
		group.add(rdbtnCustomerOwn);

	}

	// 레이아웃
	void addLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1000,550);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		lblNewLabel_2 = new JLabel("\r\n");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\04-09\\eclipse-workspace\\project\\src\\img\\pw.png"));
		lblNewLabel_2.setBounds(312, 277, 75, 66);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("\r\n");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\04-09\\eclipse-workspace\\project\\src\\img\\jin.png"));
		lblNewLabel_1.setBounds(312, 173, 87, 78);
		contentPane.add(lblNewLabel_1);

		idtf.setBounds(423, 187, 235, 46);
		contentPane.add(idtf);
		idtf.setColumns(10);

		btnLogin.setBounds(312, 393, 145, 52);
		btnLogin.setFont(new Font("양재튼튼체B", Font.PLAIN, 20));
		contentPane.add(btnLogin);
		btnLogin.setBorderPainted(true);
		btnLogin.setBackground(Color.white);

		tfpassword.setBounds(423, 285, 235, 46);
		contentPane.add(tfpassword);
		tfpassword.setColumns(10);

		btninsert.setBounds(533, 393, 178, 52);
		btninsert.setFont(new Font("양재튼튼체B", Font.PLAIN, 20));
		contentPane.add(btninsert);
		btninsert.setBorderPainted(true);
		btninsert.setBackground(Color.white);

		rdbtnFestOwn.setBounds(232, 92, 132, 23);
		contentPane.add(rdbtnFestOwn);
		rdbtnFestOwn.setBackground(new Color(226, 226, 226));
		rdbtnFestOwn.setFont(new Font("양재튼튼체B", Font.PLAIN, 20));
		rdbtnFestOwn.setForeground(new Color(0, 0, 0));

		rdbtnBoothOwn.setBounds(414, 92, 132, 23);
		rdbtnBoothOwn.setBackground(new Color(226, 226, 226));
		rdbtnBoothOwn.setFont(new Font("양재튼튼체B", Font.PLAIN, 20));
		contentPane.add(rdbtnBoothOwn);

		rdbtnCustomerOwn.setBounds(608, 92, 97, 25);
		rdbtnCustomerOwn.setBackground(new Color(226, 226, 226));
		rdbtnCustomerOwn.setFont(new Font("양재튼튼체B", Font.PLAIN, 20));
		contentPane.add(rdbtnCustomerOwn);
		passwordField.setBounds(423, 343, 235, 40);
		contentPane.add(passwordField);
	}

	// 이벤트
	void eventProc() {
		// 로그인
		btnLogin.addActionListener(this);
//		btnLogin.addMouseListener(new mouseEvent());

		// 회원가입
		btninsert.addActionListener(this);
//		btninsert.addMouseListener(new mouseEvent());
	}



	// 이벤트 실행
	public void actionPerformed(ActionEvent ev) {
		Object o = ev.getSource();

		// 로그인 기능
		if (o == btnLogin) {

			String id = idtf.getText();
			String pw = tfpassword.getText();
			String pp = passwordField.getText();

			int num = 0;
			if (rdbtnFestOwn.isSelected()) {
				// 축제
				num = 1;
			} else if (rdbtnBoothOwn.isSelected()) {
				// 부스
				num = 2;
			} else if (rdbtnCustomerOwn.isSelected()) {
				// 일반고객
				num = 3;
			}

			LoginVO vo = new LoginVO(id, pp, num);
			try {

				int code = dao.login(id, pp, num);
				if (code == 1 && num == 1) {
					// 축제페이지 열기
					int pk = dao.searchMemberPk(new LoginVO(id, pp));
					fview = new FestMainView(pk);
					setVisible(false);
					fview.setVisible(true);
					System.out.println("축제관리측 로그인 성공");

				} else if (code == 1 && num == 2) {
					// 부스 페이지 열기

					int pk = dao.searchMemberPk(new LoginVO(id, pp));

					bview = new BoothMainView(pk);
					setVisible(false);
					bview.setVisible(true);
					System.out.println("부스관리측 로그인 성공");

				} else if (code == 1 && num == 3) {
					// 일반회원
					int pk = dao.searchMemberPk(new LoginVO(id, pp));
					mview = new MemberMainView(pk);
					setVisible(false);
					mview.setVisible(true);

					System.out.println("일반회원 로그인 성공");

				} else {
					System.out.println("로그인 실패");
				}
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "로그인 실패" + e.getMessage());
			}
		} else if (o == btninsert) {
			// 회원가입에대한 코드
			this.setVisible(false);
			SignUpView sg = new SignUpView();
			sg.setVisible(true);

		}

	}
}
