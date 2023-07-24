package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.BoothMainDAO;
import model.rec.BoothMainVO;
import view.MemberFestView;
import view.MemberJumunInfoView;
import view.MemberMyPageView;

public class MemberMainView extends JFrame implements ActionListener {

	JPanel contentPane, aaa;
	CardLayout cards = new CardLayout();
	JButton btnOne;
	JButton btnTwo;
	JButton btnBoothYN;
	JButton btnGoMain,btnRes;
	BoothFestView dao;
	BoothYNView yndao;
	int a;
	BoothMainDAO ddao;
	String name;
	BoothMainVO vo;
	
	JLabel bbb;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	
	public MemberMainView(int pk) {
		int a = pk;
		newObject();
		addLayout();
		eventProc();
		
		try {
			int mempk=pk;
			ddao = new BoothMainDAO();
			String name = ddao.selectMemName(mempk);
			bbb.setText(name+"님 환영합니다!");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		aaa.add("1", new MemberFestView(this, pk));
		
		aaa.add("2", new ReservationView(this, pk));
		aaa.add("3", new MemberJumunInfoView(this, pk));
		aaa.add("4", new MemberMyPageView(this, pk));
	
		
	}


	void newObject() {
		aaa = new JPanel();
		btnOne = new JButton("축제리스트");
		btnTwo = new JButton("좌석예약");
		btnBoothYN = new JButton("주문내역");
		lblNewLabel_1 = new JLabel("");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		btnGoMain = new JButton("");
		btnGoMain.setIcon(new ImageIcon("C:\\Users\\04-09\\eclipse-workspace\\project\\src\\img\\mem.png"));
		btnRes = new JButton("내정보");
		bbb = new JLabel("");
		bbb.setFont(new Font("양재튼튼체B", Font.PLAIN, 17));
	}

	void addLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1339, 919);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		aaa.setBounds(192, 146, 1119, 724);
		contentPane.add(aaa);
		aaa.setLayout(cards);

		lblNewLabel = new JLabel("회원");
		lblNewLabel.setFont(new Font("양재튼튼체B", Font.PLAIN, 40));
		lblNewLabel.setBounds(207, 31, 581, 100);
		contentPane.add(lblNewLabel);
		
		btnOne.setBounds(12, 366, 171, 64);
		btnOne.setFont(new Font("양재튼튼체B", Font.PLAIN, 20));
		btnOne.setBackground(Color.white);
		contentPane.add(btnOne);

		btnTwo.setBounds(12, 440, 168, 64);
		btnTwo.setFont(new Font("양재튼튼체B", Font.PLAIN, 20));
		btnTwo.setBackground(Color.white);
		contentPane.add(btnTwo);

		btnBoothYN.setBounds(12, 514, 171, 64);
		btnBoothYN.setFont(new Font("양재튼튼체B", Font.PLAIN, 20));
		btnBoothYN.setBackground(Color.white);
		contentPane.add(btnBoothYN);

		btnGoMain.setBounds(12, 21, 146, 125);
		btnGoMain.setBackground(Color.white);
		btnGoMain.setBorderPainted(false);
		contentPane.add(btnGoMain);
		
		bbb.setBounds(9, 212, 179, 51);
		contentPane.add(bbb);
		
		
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\04-09\\eclipse-workspace\\project\\src\\img\\pngwing.com (30) (1).png"));
		lblNewLabel_1.setBounds(917, 0, 406, 104);
		contentPane.add(lblNewLabel_1);
		
		
		btnRes.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnRes.setBounds(12, 588, 168, 64);
		contentPane.add(btnRes);
	}

	void eventProc() {
		btnOne.addActionListener(this);
		btnTwo.addActionListener(this);
		btnBoothYN.addActionListener(this);
		btnGoMain.addActionListener(this);
		btnRes.addActionListener(this);
	}

	public void changePanel() {
		cards.next(this.getContentPane());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnOne) {
			btnOne.setOpaque(true);
			btnOne.setBackground(Color.white);
			cards.show(aaa, "1");

		} else if (e.getSource() == btnTwo) {
			btnTwo.setOpaque(true);
			btnTwo.setBackground(Color.white);
			cards.show(aaa, "2");

		} else if (e.getSource() == btnBoothYN) {
			cards.show(aaa, "3");
			
		} else if (e.getSource() == btnGoMain) {
			cards.show(aaa, "1");
			
		}else if(e.getSource() == btnRes) {
			cards.show(aaa, "4");
		}
	}
}
