package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import model.FeResSeatDAO;
import model.rec.ResSeatVO;

public class FeResSeatView extends JFrame{

	JPanel pBack = new JPanel(); // JPanel생성
	JButton[] jbtn = null;
	JLabel lblNewLabel;
	FeResSeatDAO dao;
	ResSeatVO vo;
	JPanel pRight;
	int countSeat, reset, mem, fest, total;// 좌석 선택 수
	JPanel pBottom;
	String seatchoice; // 선택 저장
	JPanel pLeft;
	ArrayList seatSave = new ArrayList(); // 선택된 좌석 저장공간
	JPanel pButtonGroup;
	JPanel pTop;
	JLabel lblNewLabel_1;
	JLabel lblNewLabel_1_1;
	String all = null;
	
	public FeResSeatView(/*int seatchoice, int memcode, */int festCode/*, int paycode, int tot*/) {
		super("CalculatorStyleExam");
		
//		countSeat = seatchoice;
//		mem = memcode;
		fest = festCode;
//		total = tot;
		newObject();
		addLayout();

		try {
			dao = new FeResSeatDAO();
			try {
				String str = String.valueOf(dao.leftSeat(festCode));
				all = str;
				try {
					String[] btnNum = null;
					int max = dao.maxseat(festCode);
					btnNum = new String[max];
					jbtn = new JButton[max];
					for (int i = 0; i < max; i++) {
						int num = i+1;
						String a= String.valueOf(num);
					
						String total = String.valueOf(a);
						btnNum[i] = total;
					}
					
					
					for (int i = 0; i < btnNum.length; i++) { // 좌석수 변경 여기서
						pButtonGroup.add(jbtn[i] = new JButton(btnNum[i])); // 좌석 1개씩 생성

						// 버튼생성하여 JButton 타입의 jbtn배열에 저장
						jbtn[i].setBounds(0, 300, 50, 50);
						jbtn[i].setBackground(Color.white);
						jbtn[i].setFont(new Font("굴림", Font.BOLD, 10));

					}

				} catch (Exception e) {
					// TODO: handle exception
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		alreadySelect();

	}

	void newObject() {
		
		pButtonGroup = new JPanel();
		pTop = new JPanel();
		lblNewLabel = new JLabel("공연장");
		pLeft = new JPanel();
		pBottom = new JPanel();
		pBottom.setLayout(null);
		
		pRight = new JPanel();
		lblNewLabel_1 = new JLabel("■   예약가능");
		lblNewLabel_1_1 = new JLabel("■  예약 불가능");
	}

	void addLayout() {

		getContentPane().setLayout(null);
		pBack.setBackground(Color.BLACK);
		pBack.setBounds(0, 0, 989, 847);

		getContentPane().add(pBack);
		pBack.setLayout(null);
		// 크기지정
		setSize(1012, 886);
		// 보이기
		super.setVisible(true);
		// x =>활성er.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		sup

		pBack.add(pButtonGroup);

		pButtonGroup.setBackground(Color.WHITE);
		pButtonGroup.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pButtonGroup.setBounds(197, 128, 606, 550);

		pTop.setBackground(Color.WHITE);
		pTop.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pTop.setBounds(197, 10, 606, 108);
		pTop.setLayout(null);

		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 582, 88);
		pTop.add(lblNewLabel);
		pBack.add(pTop);

		pLeft.setBackground(Color.WHITE);
		pLeft.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pLeft.setBounds(12, 128, 173, 550);
		pBack.add(pLeft);
		pLeft.setLayout(null);

		pBottom.setBackground(Color.WHITE);
		pBottom.setBounds(12, 688, 967, 149);
		pBack.add(pBottom);

		pRight.setBackground(Color.WHITE);
		pRight.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pRight.setBounds(815, 128, 164, 550);
		pBack.add(pRight);
		pRight.setLayout(null);

		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(815, 57, 76, 29);
		pBack.add(lblNewLabel_1);

		lblNewLabel_1_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setBackground(Color.RED);
		lblNewLabel_1_1.setBounds(815, 89, 89, 29);
		pBack.add(lblNewLabel_1_1);

	}
	
	//이미 예매된 좌석은 false
	public void alreadySelect() {
		try {
			ArrayList list = new ArrayList();

			list = dao.alreadySelectSeat(fest);

			for (int i = 0; i < list.size(); i++) {
				String a = String.valueOf(list.get(i));
				String b = a.replace("[", "");
				String c = b.replace("]", "");
				int d = Integer.parseInt(c);
				jbtn[d - 1].setBackground(Color.red);
				jbtn[d - 1].setEnabled(false);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
