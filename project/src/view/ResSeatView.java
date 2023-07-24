package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import model.ResSeatDAO;
import model.rec.ResSeatVO;

public class ResSeatView extends JFrame implements ActionListener { // 좌석 선택 창

	JTextField tfFeSeatCount, tfFeAllSeat, tfFeLastSeat, tfReSeatList;

	JPanel pBack = new JPanel(); // JPanel생성
	JButton[] jbtn = null;
	  // JButton을 담을수있는 그릇생성
	JButton btFeSeatReset = new JButton("좌석 초기화");
	JButton btFeSeatback = new JButton("결제하기");
	JLabel lblNewLabel;
	ResSeatDAO dao;
	ResSeatVO vo;
	JPanel pRight;
	int countSeat, reset, mem, fest, total;// 좌석 선택 수
	JPanel pBottom;
	String seatchoice; // 선택 저장
	JPanel pLeft;
	ArrayList seatSave = new ArrayList(); // 선택된 좌석 저장공간
	JPanel pButtonGroup;
	JPanel pTop;
	JLabel lbFeAllSeat;
	JLabel lbFeLastSeat;
	JLabel lbFeSeatCount;
	JLabel lblNewLabel_1;
	JLabel lblNewLabel_1_1;
	JScrollPane scrollPane;
	String all = null;
	public ResSeatView(int seatchoice, int memcode, int festCode, int paycode, int tot) {
		super("CalculatorStyleExam");
		
		countSeat = seatchoice;
		mem = memcode;
		fest = festCode;
		total = tot;
		newObject();
		addLayout();
		eventProc();

		try {
			dao = new ResSeatDAO();
			vo = new ResSeatVO(paycode);
			vo = new ResSeatVO(paycode, seatchoice, memcode, festCode);
			try {
				String str = String.valueOf(dao.leftSeat(festCode));
				tfFeAllSeat.setText(str);
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

					for (int i = 0; i < btnNum.length; i++) { // 배열에 버튼에 각각 ActionListener적용
						jbtn[i].addActionListener(this);
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
		pRight = new JPanel();
		lbFeAllSeat = new JLabel("총 좌석 수");
		tfFeAllSeat = new JTextField();
		lbFeLastSeat = new JLabel("남은 좌석 수");
		tfFeLastSeat = new JTextField();
		lbFeSeatCount = new JLabel("선택된 좌석 수");
		tfFeSeatCount = new JTextField();
		lblNewLabel_1 = new JLabel("■   예약가능");
		lblNewLabel_1_1 = new JLabel("■  예약 불가능");
		scrollPane = new JScrollPane();
		tfReSeatList = new JTextField();
		
	
		
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
		// x =>활성
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

		lbFeAllSeat.setHorizontalAlignment(SwingConstants.CENTER);
		lbFeAllSeat.setFont(new Font("굴림", Font.PLAIN, 12));
		lbFeAllSeat.setBounds(67, 10, 85, 26);
		pRight.add(lbFeAllSeat);

		tfFeAllSeat.setEditable(false);
		tfFeAllSeat.setColumns(10);
		tfFeAllSeat.setBounds(12, 11, 44, 26);
		pRight.add(tfFeAllSeat);

		lbFeLastSeat.setHorizontalAlignment(SwingConstants.CENTER);
		lbFeLastSeat.setFont(new Font("굴림", Font.PLAIN, 12));
		lbFeLastSeat.setBounds(67, 49, 85, 26);
		pRight.add(lbFeLastSeat);

		tfFeLastSeat.setEditable(false);
		tfFeLastSeat.setColumns(10);
		tfFeLastSeat.setBounds(12, 50, 44, 26);
		pRight.add(tfFeLastSeat);

		lbFeSeatCount.setHorizontalAlignment(SwingConstants.CENTER);
		lbFeSeatCount.setFont(new Font("굴림", Font.PLAIN, 12));
		lbFeSeatCount.setBounds(67, 85, 85, 26);
		pRight.add(lbFeSeatCount);

		tfFeSeatCount.setEditable(false);
		tfFeSeatCount.setBounds(12, 86, 44, 26);
		pRight.add(tfFeSeatCount);
		tfFeSeatCount.setColumns(10);

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

		scrollPane.setViewportBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(160, 160, 160)), "선택된 자리 수",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollPane.setBounds(12, 238, 140, 66);
		pRight.add(scrollPane);

		scrollPane.setViewportView(tfReSeatList);
		tfReSeatList.setEditable(false);
		tfReSeatList.setHorizontalAlignment(SwingConstants.CENTER);
		tfReSeatList.setColumns(10);

		btFeSeatReset.setBounds(12, 121, 140, 33);
		pRight.add(btFeSeatReset);

		btFeSeatback.setBounds(12, 507, 140, 33);
		pRight.add(btFeSeatback);

	}

	void eventProc() {
		btFeSeatReset.addActionListener(this);
		btFeSeatback.addActionListener(this);
	}

	// 이벤트 처리부분
	public void actionPerformed(ActionEvent e) {
		JButton click = (JButton) e.getSource();
		String ac = e.getActionCommand();

		if (click.getText().equals("좌석 초기화")) { // 좌석 초기화 버튼

			ResetSeat();// 전부 초기화

		} else if (click.getText().equals("결제하기")) { // 뒤로가기 버튼
			// 1.결제창 열림
			// 2. 예매 테이블에 인서트

			if (vo.getPaycode() == 1) {
				try {
					// 카드결제
					ArrayList list = new ArrayList();
					list = seatSave;
					int resnum = dao.concertRes(vo);
					ConcertCardPayView cpview = new ConcertCardPayView(mem, resnum, list, total);
					cpview.setVisible(true);
					dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}

			} else if (vo.getPaycode() == 2) {
				try {
					// 계좌이체
					ArrayList list = new ArrayList();
					list = seatSave;
					int resnum = dao.concertRes(vo);
					ConcertGoPayView gpview = new ConcertGoPayView(mem, resnum, list, total);
					gpview.setVisible(true);
					dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}

		else if (click.getText().equals(ac) && seatSave.size() < countSeat) { // 마우스 클릭은 인원수만큼만 선택 가능
			click.setOpaque(true);
			click.setBackground(Color.red);
			click.setEnabled(false);
			tfFeSeatCount.setText(ac);
			seatSave.add(ac);

			seatCheck();
		}
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
//			// TODO: handle exception
		}

	}

	public void ResetSeat() { // 좌석 초기화
		for (int i = 0; i < jbtn.length; i++) {
			jbtn[i].setBackground(Color.white);
			jbtn[i].setEnabled(true);

		}
		seatSave.removeAll(seatSave);
		tfFeSeatCount.setText(String.valueOf(seatSave.size()));
		tfReSeatList.setText(String.valueOf(seatSave));

	}

	public void seatCheck() {
		int num = Integer.parseInt(all);
		tfReSeatList.setText(String.valueOf(seatSave)); // 총 좌석 목록
		tfFeLastSeat.setText(String.valueOf(num - seatSave.size())); // 남은 좌석 수
		tfFeSeatCount.setText(String.valueOf(seatSave.size())); // 선택한 좌석 수

	}
}
