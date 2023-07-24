package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.SignUpDAO;
import model.rec.SignUpVO;
import java.awt.Color;
import javax.swing.ImageIcon;

public class SignUpView extends JFrame implements ActionListener {

	JPanel contentPane;
	JTextField tfMemName;
	JTextField tfMemTel;
	JTextField tfMemFrontJumin;
	JTextField tfMemID;
	JTextField tfMemPW;
	JTextField tfMemBackJumin;

	JLabel lbMemName;
	JLabel lbMemTel;
	JLabel lbMemJumin;
	JLabel lbMemID;
	JLabel lbMemPW;

	JLabel lbJuminGubun;

	JComboBox comboBox;
	SignUpDAO dao;
	SignUpVO vo;
	JButton btnSignUp;
	LoginView view;
	private JLabel lblNewLabel;

	public SignUpView() {
		newObject();
		addLayout();
		eventProc();

		try {
			dao = new SignUpDAO();
			System.out.println("DB연결 성공");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "DB 연결 실패" + e.getMessage());
		}

	}

	void newObject() {
		lbMemName = new JLabel("성 명");
		lbMemTel = new JLabel("전화번호");
		lbMemJumin = new JLabel("주민번호");

		lbMemID = new JLabel("아이디");
		lbMemPW = new JLabel("비밀번호");

		comboBox = new JComboBox();

		btnSignUp = new JButton("회원가입");

		tfMemName = new JTextField();
		tfMemTel = new JTextField();
		tfMemFrontJumin = new JTextField();
		tfMemID = new JTextField();
		tfMemPW = new JTextField();
		lbJuminGubun = new JLabel("-");

		tfMemBackJumin = new JTextField();
	}

	void addLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1005, 544);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lbMemName.setBounds(235, 108, 57, 30);
		contentPane.add(lbMemName);
		lbMemName.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));

		lbMemTel.setBounds(230, 163, 73, 30);
		contentPane.add(lbMemTel);
		lbMemTel.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));

		lbMemJumin.setBounds(230, 224, 73, 30);
		contentPane.add(lbMemJumin);
		lbMemJumin.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));

		lbMemID.setBounds(242, 285, 50, 21);
		contentPane.add(lbMemID);
		lbMemID.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));

		lbMemPW.setBounds(230, 329, 73, 30);
		contentPane.add(lbMemPW);
		lbMemPW.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));

		comboBox.setModel(new DefaultComboBoxModel(new String[] { "축제관리자", "부스관리자", "일반회원" }));
		comboBox.setBounds(235, 43, 147, 30);
		contentPane.add(comboBox);
		comboBox.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));

		tfMemName.setBounds(315, 110, 147, 30);
		contentPane.add(tfMemName);
		tfMemName.setColumns(10);

		tfMemTel.setBounds(315, 165, 147, 30);
		contentPane.add(tfMemTel);
		tfMemTel.setColumns(10);

		tfMemFrontJumin.setBounds(315, 226, 147, 30);
		contentPane.add(tfMemFrontJumin);
		tfMemFrontJumin.setColumns(10);

		tfMemID.setBounds(315, 282, 147, 30);
		contentPane.add(tfMemID);
		tfMemID.setColumns(10);

		tfMemPW.setBounds(315, 331, 157, 30);
		contentPane.add(tfMemPW);
		tfMemPW.setColumns(10);

		lbJuminGubun.setFont(new Font("양재튼튼체B", Font.BOLD, 30));
		lbJuminGubun.setBounds(476, 223, 29, 25);
		contentPane.add(lbJuminGubun);

		tfMemBackJumin.setBounds(517, 226, 147, 30);
		contentPane.add(tfMemBackJumin);
		tfMemBackJumin.setColumns(10);

		btnSignUp.setBounds(629, 329, 147, 30);
		contentPane.add(btnSignUp);
		btnSignUp.setForeground(Color.black);
		btnSignUp.setBackground(Color.white);
		btnSignUp.setFont(new Font("양재튼튼체B", Font.BOLD, 15));
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\workspace\\Project\\Image\\sign.jpg"));
		lblNewLabel.setBounds(0, 0, 989, 511);
		contentPane.add(lblNewLabel);

	}

	void eventProc() {
		btnSignUp.addActionListener(this);
	}

	void clear() {
		comboBox.setSelectedIndex(0);
		tfMemName.setText("");
		tfMemID.setText("");
		tfMemPW.setText("");
		tfMemTel.setText("");
		tfMemBackJumin.setText("");
		tfMemFrontJumin.setText("");
	}

	public void actionPerformed(ActionEvent ev) {
		Object o = ev.getSource();
		if (o == btnSignUp) {
			btnSignUp.setOpaque(true);
			btnSignUp.setBackground(Color.orange);
			int memcode = comboBox.getSelectedIndex() + 1;
			System.out.println(memcode);
			String name = tfMemName.getText();
			String tel = tfMemTel.getText();
			String jumin = tfMemFrontJumin.getText() + "-" + tfMemBackJumin.getText();
			String id = tfMemID.getText();
			String pw = tfMemPW.getText();

			vo = new SignUpVO(name, tel, jumin, id, pw, memcode);

			try {

				dao.signUp(name, tel, jumin, id, pw, memcode);
				System.out.println("회원가입 성공");
				clear();
				setVisible(false);
				view = new LoginView();
				view.setVisible(true);

				JOptionPane.showMessageDialog(null, "회원가입 성공");

			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "회원가입 실패" + e.getMessage());
			}

		}
	}
}
