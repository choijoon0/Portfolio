package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import com.toedter.calendar.JDateChooser;

import model.FeSignupDAO;
import model.rec.FeSignupVO;
import javax.swing.DefaultComboBoxModel;

public class FeSignupView extends JPanel implements ActionListener {

	JPanel pTop, pLeft, pLeftButtonBox, pRight, pBottom;
	JTextField tfFeName, tfFeLoc, tfFeStartTime, tfFeEndTime, tfFePrice, tfFeCompany, tfFeBoose, tfFeSearch;
	JComboBox cbFeCtCode, cbFeSearch;
	JTextArea taContent;
	JDateChooser dcFeStartTerm, dcFeEndTerm;
	JButton btFeInsert, btFeDelete, btFeModify, btFeSearch;
	JTable tbList;
	FestivalTableModel tmFestival;

	FeSignupDAO dao = null;
	FeSignupVO vo = null;
	ArrayList list = null;

	Date stchange = null; // JTable에 있는 날짜 형식 변환해서 JChoose에 불러오기
	Date endchange = null;
	Calendar stcal = Calendar.getInstance();
	Calendar endcal = Calendar.getInstance();

	int mcode = 0;
	private JTextField tfFestDetail;
	private JLabel lblFestSeat;
	private JTextField tfFestSeat;

	public FeSignupView(FestMainView FestMainView, int pk) {
		newObject();
		addLayout();
		setStyle();
		eventProc();
		mcode = pk;
		try {
			dao = new FeSignupDAO();
			showJTable();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "데이터베이스 연결 실패!!: " + e.getMessage());
		}
	}

	void newObject() {
		//
		String[] cbFeTopicCodeText = { "지역 축제", "가수 축제" }; // 축제 주제 콤보 박스
		cbFeCtCode = new JComboBox(cbFeTopicCodeText);
		cbFeCtCode.setModel(new DefaultComboBoxModel(new String[] {"문화예술", "전통문화", "지역특산품", "자연관광", "콘서트"}));

		String[] cbFeSearchText = { "축제 이름", "축제 장소", "축제 주최측" }; // 검색 콤보박스
		cbFeSearch = new JComboBox(cbFeSearchText);
		tfFeName = new JTextField();
		tfFeLoc = new JTextField();
		dcFeStartTerm = new JDateChooser();
		dcFeEndTerm = new JDateChooser();
		tfFeStartTime = new JTextField();
		tfFePrice = new JTextField();
		tfFeCompany = new JTextField();
		tfFeBoose = new JTextField();
		taContent = new JTextArea();
		tfFeSearch = new JTextField();

		tmFestival = new FestivalTableModel(); // Jtable
		tbList = new JTable(tmFestival);
		tbList.setFont(new Font("굴림", Font.PLAIN, 6));

		btFeInsert = new JButton("축제 등록"); // 등록,삭제,수정,검색 Button
		btFeDelete = new JButton("축제 삭제");
		btFeModify = new JButton("축제 수정");
		btFeSearch = new JButton("검색");

	}

	void addLayout() {
		JPanel pTop = new JPanel();
		JPanel pLeft = new JPanel();
		JPanel pRight = new JPanel();
		JPanel pRightSearchBox = new JPanel();
		JPanel pBottom = new JPanel();
		JPanel pLeftButtonBox = new JPanel();

		// Top 상단
		pTop.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pTop.setBounds(0, 0, 880, 82);

		pTop.setLayout(null);
		JLabel lblNewLabel = new JLabel("관리자번호");
		lblNewLabel.setBounds(12, 38, 67, 34);
		pTop.add(lblNewLabel);

		// ------------------------------------------------------------------------------------top
		// 끝

		// Left 축제 등록,삭제,수정 텍스트 입력
		JLabel lbFeCtCode = new JLabel("축제 유형");
		lbFeCtCode.setFont(new Font("굴림", Font.PLAIN, 16));
		lbFeCtCode.setHorizontalAlignment(SwingConstants.CENTER);
		lbFeCtCode.setBounds(12, 10, 153, 24);
		pLeft.add(lbFeCtCode);

		cbFeCtCode.setBounds(243, 10, 140, 26);
		pLeft.add(cbFeCtCode);

		pLeft.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), " 축제 관리 ",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pLeft.setBounds(0, 92, 395, 413);
		pLeft.setLayout(null);

		JLabel lbFeName = new JLabel("축제 이름");
		lbFeName.setHorizontalAlignment(SwingConstants.CENTER);
		lbFeName.setFont(new Font("굴림", Font.PLAIN, 16));
		lbFeName.setBounds(0, 64, 153, 26);
		pLeft.add(lbFeName);

		tfFeName.setBounds(177, 66, 206, 26);
		pLeft.add(tfFeName);

		JLabel lbFeLoc = new JLabel("축제 장소");
		lbFeLoc.setHorizontalAlignment(SwingConstants.CENTER);
		lbFeLoc.setFont(new Font("굴림", Font.PLAIN, 16));
		lbFeLoc.setBounds(0, 94, 153, 26);
		pLeft.add(lbFeLoc);

		tfFeLoc.setBounds(177, 96, 206, 26);
		pLeft.add(tfFeLoc);

		JLabel lbFeTerm = new JLabel("축제 기간");
		lbFeTerm.setHorizontalAlignment(SwingConstants.CENTER);
		lbFeTerm.setFont(new Font("굴림", Font.PLAIN, 16));
		lbFeTerm.setBounds(0, 130, 153, 26);
		pLeft.add(lbFeTerm);

		dcFeStartTerm.setDateFormatString("y/MM/dd"); // 축제 기간
		dcFeStartTerm.setBounds(177, 132, 97, 21);
		pLeft.add(dcFeStartTerm);

		dcFeEndTerm.setDateFormatString("y/MM/dd");
		dcFeEndTerm.setBounds(278, 132, 105, 21);
		pLeft.add(dcFeEndTerm);

		JLabel lbFeTime = new JLabel("축제 시간");
		lbFeTime.setHorizontalAlignment(SwingConstants.CENTER);
		lbFeTime.setFont(new Font("굴림", Font.PLAIN, 16));
		lbFeTime.setBounds(0, 166, 153, 26);
		pLeft.add(lbFeTime);

		tfFeStartTime.setBounds(177, 163, 97, 26);
		pLeft.add(tfFeStartTime);

		tfFeEndTime = new JTextField();
		tfFeEndTime.setBounds(279, 163, 104, 25);
		pLeft.add(tfFeEndTime);

		JLabel lbFePrice = new JLabel("축제 이용료");
		lbFePrice.setHorizontalAlignment(SwingConstants.CENTER);
		lbFePrice.setFont(new Font("굴림", Font.PLAIN, 16));
		lbFePrice.setBounds(0, 190, 153, 26);
		pLeft.add(lbFePrice);

		tfFePrice.setBounds(177, 192, 206, 26);
		pLeft.add(tfFePrice);

		JLabel lbFeCompany = new JLabel("축제 주최측");
		lbFeCompany.setHorizontalAlignment(SwingConstants.CENTER);
		lbFeCompany.setFont(new Font("굴림", Font.PLAIN, 16));
		lbFeCompany.setBounds(0, 217, 153, 26);
		pLeft.add(lbFeCompany);

		tfFeCompany.setBounds(177, 219, 206, 26);
		pLeft.add(tfFeCompany);

		JLabel lbFeBoose = new JLabel("참가 부스 수");
		lbFeBoose.setHorizontalAlignment(SwingConstants.CENTER);
		lbFeBoose.setFont(new Font("굴림", Font.PLAIN, 16));
		lbFeBoose.setBounds(12, 253, 153, 26);
		pLeft.add(lbFeBoose);

		tfFeBoose.setBounds(177, 255, 206, 26);
		pLeft.add(tfFeBoose);

		pLeftButtonBox.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pLeftButtonBox.setBounds(12, 347, 371, 58);
		pLeft.add(pLeftButtonBox);
		pLeftButtonBox.setLayout(null);

		// 추가,삭제,수정 버튼
		btFeInsert.setBounds(12, 10, 97, 38);
		pLeftButtonBox.add(btFeInsert);

		btFeDelete.setBounds(138, 10, 97, 38);
		pLeftButtonBox.add(btFeDelete);

		btFeModify.setBounds(262, 10, 97, 38);
		pLeftButtonBox.add(btFeModify);

		// ------------------------------------------------------------------------------------left
		// 끝

		// Right 축제 내용 입력
		pRight.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), " 축제 내용 ",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pRight.setBounds(399, 92, 481, 363);

		pRight.setLayout(new BorderLayout(0, 0));
		JScrollPane spContent = new JScrollPane();
		pRight.add(spContent, BorderLayout.CENTER);
		taContent = new JTextArea();
		spContent.setViewportView(taContent);

		pRightSearchBox.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pRightSearchBox.setBounds(399, 459, 481, 46);

		pRightSearchBox.setLayout(null);

		cbFeSearch.setBounds(12, 10, 112, 26); // 오른쪽 콤보박스
		pRightSearchBox.add(cbFeSearch);

		tfFeSearch.setBounds(133, 10, 227, 26);
		pRightSearchBox.add(tfFeSearch);

		btFeSearch.setBounds(372, 11, 71, 23);
		pRightSearchBox.add(btFeSearch);

		// ------------------------------------------------------------------------------------right
		// 끝

		// Bottom 축제 관리 리스트
		pBottom.setBorder(new TitledBorder(null, " 축제 관리 리스트 ", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		pBottom.setBounds(0, 515, 880, 207);

		pBottom.setLayout(new BorderLayout(0, 0));
		JScrollPane spJtableBox = new JScrollPane();
		spJtableBox.setFont(new Font("굴림", Font.PLAIN, 12));
		pBottom.add(spJtableBox, BorderLayout.CENTER);
		spJtableBox.setViewportView(tbList);

		// ------------------------------------------------------------------------------------bottom
		// 끝

		// 전체 붙이기
		add(pTop);
		add(pLeft);

		JLabel lblNewLabel_1 = new JLabel("주요주제");
		lblNewLabel_1.setBounds(50, 37, 73, 27);
		pLeft.add(lblNewLabel_1);

		tfFestDetail = new JTextField();
		tfFestDetail.setBounds(177, 40, 206, 21);
		pLeft.add(tfFestDetail);
		tfFestDetail.setColumns(10);
		
		lblFestSeat = new JLabel("축제 좌석");
		lblFestSeat.setBounds(36, 289, 87, 24);
		pLeft.add(lblFestSeat);
		
		tfFestSeat = new JTextField();
		tfFestSeat.setText("0");
		tfFestSeat.setEditable(false);
		tfFestSeat.setBounds(177, 291, 206, 21);
		pLeft.add(tfFestSeat);
		tfFestSeat.setColumns(10);
		add(pRight);
		add(pRightSearchBox);
		add(pBottom);
		setLayout(null);
	}

	void setStyle() {

	}

	void eventProc() {
		btFeInsert.addActionListener(this); // 버튼 이벤트
		btFeDelete.addActionListener(this);
		btFeModify.addActionListener(this);
		btFeSearch.addActionListener(this);
		cbFeCtCode.addActionListener(this);

		tbList.addMouseListener(new MouseAdapter() { // JTable 선택시 정보가 textfield에 출력

			public void mouseClicked(MouseEvent e) {
				int col = 0; // 쿼리에 fest_code자리수 맞춰야함 컬럼행 = 1번자리
				int row = tbList.getSelectedRow();
				int vNum = (Integer) tbList.getValueAt(row, col);

				try {
					vo = dao.FindByNum(vNum);

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Jtable에 정보가 없습니다. " + e2.getMessage());
				}

				// TextField에 선택된 리스트 출력
				cbFeCtCode.setSelectedIndex(vo.getCtcode() - 1);
				tfFeName.setText(vo.getName());
				tfFeLoc.setText(vo.getLoc());
				tfFeStartTime.setText(String.valueOf(vo.getStarttime()));
				tfFeEndTime.setText(String.valueOf(vo.getEndtime()));
				tfFePrice.setText(String.valueOf(vo.getPrice()));
				tfFeCompany.setText(vo.getCompany());
				tfFeBoose.setText(String.valueOf(vo.getBoose()));
				taContent.setText(vo.getContent());
				tfFestDetail.setText(vo.getFestdetail());

				try { // JTable에 있는 날짜 형식 변환해서 JChoose에 불러오기
					stchange = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String) vo.getStartday()); // 타입 완전
																												// 일치하게
																												// 써줘야함
					endchange = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String) vo.getEndday());
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, "날짜 가져오기 실패 " + e1.getMessage());
				}
				stcal.setTime(stchange);
				endcal.setTime(endchange);

				dcFeStartTerm.setDate(stcal.getTime());
				dcFeEndTerm.setDate(endcal.getTime()); // ------------------------------------------------------ 텍스트 출력
														// 여기까지

			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		Object o = ev.getSource();
		if (o == btFeInsert) { // 축제 등록 버튼 이벤트

			int FeTopicCode = cbFeCtCode.getSelectedIndex() + 1;// 카테고리번호
			String festDetail = tfFestDetail.getText();// 상세
			int FeStartTime = Integer.parseInt(tfFeStartTime.getText());// 시작시간
			int FeEndTime = Integer.parseInt(tfFeEndTime.getText());// 종료시간
			int FePrice = Integer.parseInt(tfFePrice.getText());// 가격
			int FeBoose = Integer.parseInt(tfFeBoose.getText());// 최대부스수
			String FeName = tfFeName.getText();// 축제이름
			String FeLoc = tfFeLoc.getText();// 축제지역
			String FeCompany = tfFeCompany.getText();// 주최
			String FeContent = taContent.getText();// 내용
			int FeFestSeat = Integer.parseInt(tfFestSeat.getText());

			SimpleDateFormat FeStDay = new SimpleDateFormat("yy/MM/dd"); // 캘린더 시작일
			String FeStartDay = FeStDay.format(dcFeStartTerm.getDate());

			SimpleDateFormat FeEnDay = new SimpleDateFormat("yy/MM/dd"); // 캘린더 종료일
			String FeEndDay = FeEnDay.format(dcFeEndTerm.getDate());

			try {
				FeSignupVO vo = new FeSignupVO(FeTopicCode, FeStartTime, FeEndTime, FePrice, FeBoose, FeStartDay,
						FeEndDay, FeName, FeLoc, FeCompany, FeContent, festDetail, mcode, FeFestSeat);
				dao.FestivalInsert(vo);
				showJTable();
				System.out.println("축제 등록 성공!");
				clearScreen();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "축제 등록 실패!!:" + e.getMessage());
			}

		}

		else if (o == btFeDelete) {
			int col = 0; // 쿼리에 fest_code자리수 맞춰야함 컬럼행 = 1번자리
			int row = tbList.getSelectedRow();
			int vNum = (Integer) tbList.getValueAt(row, col);// 축제 삭제 버튼 이벤트

			try {
				int count = dao.FestivalDelete(vNum);
				if (count > 0 || count < 2) {

					clearScreen();
					System.out.println("테이블이 정상적으로 삭제되었습니다.");
				}

				showJTable();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "축제 삭제 실패!!:" + e.getMessage());
			}

		} else if (o == btFeModify) { // 축제 수정 버튼 이벤트

			int col = 0; // 쿼리에 fest_code자리수 맞춰야함 컬럼행 = 1번자리
			int row = tbList.getSelectedRow();
			int vNum = (Integer) tbList.getValueAt(row, col);

			int FeTopicCode = cbFeCtCode.getSelectedIndex() + 1;// 콤보박스 String으로 보이게 하고 Index번호를 불러온다.
			int FeStartTime = Integer.parseInt(tfFeStartTime.getText());
			int FeEndTime = Integer.parseInt(tfFeEndTime.getText());
			int FePrice = Integer.parseInt(tfFePrice.getText());
			int FeBoose = Integer.parseInt(tfFeBoose.getText());
			String FeName = tfFeName.getText();
			String FeLoc = tfFeLoc.getText();
			String FeCompany = tfFeCompany.getText();
			String FeContent = taContent.getText();
			String festDetail = tfFestDetail.getText();

			SimpleDateFormat FeStDay = new SimpleDateFormat("yy/MM/dd"); // 캘린더 시작일
			String FeStartDay = FeStDay.format(dcFeStartTerm.getDate());

			SimpleDateFormat FeEnDay = new SimpleDateFormat("yy/MM/dd"); // 캘린더 종료일
			String FeEndDay = FeEnDay.format(dcFeEndTerm.getDate());

			FeSignupVO vo = new FeSignupVO(vNum, FeTopicCode, FeStartTime, FeEndTime, FePrice, FeBoose, FeStartDay,
					FeEndDay, FeName, FeLoc, FeCompany, FeContent, mcode, festDetail);

			try {
				int count = dao.FestModify(vo);
				System.out.println(count);
				clearScreen();
				if (count == 1) {
					System.out.println("수정이 완료 되었습니다.");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "축제 수정 실패!!:" + e.getMessage());
			}

			showJTable(); // 수정된 리스트 다시 보이기
		} else if (o == btFeSearch) {
			selectJTable();
		} else if (o == cbFeCtCode) {
			if(cbFeCtCode.getSelectedIndex() == 4) {
				tfFestSeat.setEditable(true);
			}else {
				tfFestSeat.setEditable(false);
			}
		}

	}

	void selectJTable() { // 검색
		int sel = cbFeSearch.getSelectedIndex();
		String text = tfFeSearch.getText();

		try {
			list = dao.selectTableList(sel, text);
			tmFestival.data = list;
			tbList.setModel(tmFestival);
			tmFestival.fireTableDataChanged();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Jtalbe 리스트 출력 실패!" + e.getMessage());
		}
	}

	void showJTable() { // 평상시 리스트 보이게
		try {
			list = dao.showJTable();
			tmFestival.data = list;
			tbList.setModel(tmFestival);
			tmFestival.fireTableDataChanged();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Jtalbe 리스트 출력 실패!" + e.getMessage());
		}
	}

	void clearScreen() { // 모든 텍스트박스 아무것도없게

		tfFeName.setText("");
		tfFeLoc.setText("");
		dcFeStartTerm.setCalendar(null);
		dcFeEndTerm.setCalendar(null);
		tfFeStartTime.setText("");
		tfFePrice.setText("");
		tfFeCompany.setText("");
		tfFeStartTime.setText("");
		tfFeEndTime.setText("");
		tfFeBoose.setText("");
		taContent.setText("");
		tfFestDetail.setText("");
		tfFestSeat.setText("");
	}
}

class FestivalTableModel extends AbstractTableModel { // Jtable Model로 만들기

	ArrayList data = new ArrayList();
	String[] columnNames = { "축제 코드", "축제 유형", "분류상세", "축제 이름", "축제 장소", "축제 시작일", "축제 종료일", "축제 시작시간", "축제 종료시간",
			"축제 이용료", "축제 주최측", "참가 부스 수", "축제 내용" };

	@Override
	public int getColumnCount() {

		return columnNames.length;
	}

	@Override
	public int getRowCount() {

		return data.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		ArrayList temp = (ArrayList) data.get(row);
		return temp.get(col);
	}

	public String getColumnName(int col) {

		return columnNames[col];
	}
}
