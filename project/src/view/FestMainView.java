package view;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.BoothMainDAO;

public class FestMainView extends JFrame implements ActionListener {

	JPanel contentPane, aaa;
	CardLayout cards = new CardLayout();
	JButton btnOne, btnTwo, btnThree, btnFour;
	JLabel lblFesTitle,lblNewLabel;
	BoothMainDAO ddao;
	JButton btnFirstPane;
	private JButton btnHome;
	public FestMainView(int pk) {
		
		newObject();
		addLayout();
		eventProc();

		try {
			int mempk=pk;
			ddao = new BoothMainDAO();
			String name = ddao.selectMemName(mempk);
			lblNewLabel.setText(name);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		aaa.add("1", new FeAllListView(this, pk));
		aaa.add("2", new FeSignupView(this, pk));
		aaa.add("3", new FeFixBoothView(this,pk));
		aaa.add("4", new FeTicketInfoView(this, pk));
		aaa.add("5", new FeMyPageView(this,pk));
		
		
	
		
		
		
		

		
		
		
	}
	
	void newObject() {
		contentPane = new JPanel();
		lblFesTitle = new JLabel("축제 정보 및 부스 관리 시스템");
		lblNewLabel = new JLabel("");
		aaa = new JPanel();
		
		btnHome = new JButton("홈");
		btnOne = new JButton("축제 관리");
		btnFirstPane = new JButton("전체 축제목록");
		btnTwo = new JButton("부스 등록 관리");
		
		btnThree = new JButton("티켓 예매 관리");
		btnFour = new JButton("내 정보");

	}

	void  addLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1339, 919);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblFesTitle.setFont(new Font("한컴 소망 M", Font.BOLD, 40));
		lblFesTitle.setBounds(204, 31, 942, 84);
		contentPane.add(lblFesTitle);
		
		aaa.setBounds(192, 146, 1119, 724);
		contentPane.add(aaa);
		aaa.setLayout(cards);

		btnFirstPane.setBounds(9, 217, 137, 43);
		contentPane.add(btnFirstPane);
		
		btnOne.setBounds(9, 270, 137, 43);
		contentPane.add(btnOne);
		
		btnTwo.setBounds(9, 323, 137, 43);
		contentPane.add(btnTwo);
		
		btnThree.setBounds(9, 376, 137, 43);
		contentPane.add(btnThree);
		
		btnFour.setBounds(9, 429, 137, 43);
		contentPane.add(btnFour);
		btnHome.setBounds(12, 27, 134, 110);
		contentPane.add(btnHome);

		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel.setBounds(12, 164, 134, 64);
		contentPane.add(lblNewLabel);
	
	}
	
	void eventProc() {
		btnFirstPane.addActionListener(this);
		btnOne.addActionListener(this);
		btnTwo.addActionListener(this);
		btnThree.addActionListener(this);
		btnFour.addActionListener(this);
		btnHome.addActionListener(this);
	}
	
	public void changePanel() {
		cards.next(this.getContentPane());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnOne) {
			cards.show(aaa, "2");
		} else if (e.getSource() == btnTwo) {
			cards.show(aaa, "3");
		} else if (e.getSource() == btnThree) {
			cards.show(aaa, "4");
		} else if (e.getSource() == btnFour) {
			cards.show(aaa, "5");
		} else if(e.getSource() == btnFirstPane) {
			cards.show(aaa, "1");
		} else if(e.getSource()==btnHome) {
			cards.show(aaa,"1");
		}
			
	}
}