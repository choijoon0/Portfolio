package view;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.BoothMainDAO;
import model.rec.BoothMainVO;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class BoothMainView extends JFrame implements ActionListener {

	JPanel contentPane, aaa;
	CardLayout cards = new CardLayout();
	JButton btnFeList;
	JButton btnBoothYN;
	JButton btnGoodsinfo;
	JButton btnGoMain;
	BoothFestView dao;
	BoothYNView yndao;
	int a;
	BoothMainDAO ddao;
	String name;
	BoothMainVO vo;
	
	JLabel bbb;
	private JButton btnMyInfo;
	public BoothMainView(int pk) {
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
		
		aaa.add("1", new BoothFestView(this, pk));
		aaa.add("2", new BoothYNView(this, pk));
		aaa.add("3", new BthGoodsInView(this, pk));
		aaa.add("4", new BoothMyPageView(this, pk));
		
		

		bbb.setBounds(9, 156, 159, 51);
		contentPane.add(bbb);
		


	}


	void newObject() {
		aaa = new JPanel();
		btnFeList = new JButton("축제리스트");
		btnBoothYN = new JButton("부스 내역");
		btnGoodsinfo = new JButton("재고관리");
		btnMyInfo = new JButton("내 정보");
		contentPane = new JPanel();
		btnGoMain = new JButton("홈");

		bbb = new JLabel("");
	}

	void addLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1396, 923);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		aaa.setBounds(213, 156, 1141, 704);
		contentPane.add(aaa);
		aaa.setLayout(cards);

		btnFeList.setBounds(9, 222, 137, 43);
		contentPane.add(btnFeList);

		btnBoothYN.setBounds(9, 275, 137, 43);
		contentPane.add(btnBoothYN);

		btnGoodsinfo.setBounds(9, 328, 137, 43);
		contentPane.add(btnGoodsinfo);
		
		btnMyInfo.setBounds(9, 381, 137, 43);
		contentPane.add(btnMyInfo);

		btnGoMain.setBounds(12, 21, 146, 125);
		contentPane.add(btnGoMain);
	}

	void eventProc() {
		btnFeList.addActionListener(this);
		btnBoothYN.addActionListener(this);
		btnGoodsinfo.addActionListener(this);
		btnMyInfo.addActionListener(this);
		btnGoMain.addActionListener(this);
	}

	public void changePanel() {
		cards.next(this.getContentPane());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnFeList) {
			cards.show(aaa, "1");

		} else if (e.getSource() == btnBoothYN) {
			cards.show(aaa, "2");

		} else if (e.getSource() == btnGoodsinfo) {
			cards.show(aaa, "3");
			
		}else if (e.getSource() == btnMyInfo) {
			cards.show(aaa, "4");
			
		}else if (e.getSource() == btnGoMain) {
			cards.show(aaa, "1");
			
		}
	}
}
