package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import model.ReservationDAO;
import model.rec.FeSignupVO;
import model.rec.ResSeatVO;
import model.rec.ReservationVO;

public class ReservationView extends JPanel implements ActionListener {				//예약 화면
	
	JPanel pTop,pLeft,pRight, pRightSearchBox;
	
	JTextField tfFeSearch;
	
	
	JComboBox cbFeSearch, cbReHowpayCode;
	JTextArea taContent;
	
	JButton btFeSearch, btTkSeat, btnReSet;
	
	JSpinner TkResCount;
	
	JTable tbList;
	ReservationListModel ReservationListModel;
	
	ReservationDAO dao = null;
	ReservationVO vo = null;
	ArrayList<String> listSeat = null;
	ArrayList list = null;
	int pk;	// 회원코드
	int res; // 예매코드
	ResSeatView rsview;
	JTextField tfFeName, tfFeLocation, tfFeStartDay, tfFeEndDay, tfFeCompany, tfFePrice, tfFeCtCode;
	JTextField tfReSeatcnt;
	JTextField tfFestCode;
	
	
	public ReservationView(MemberMainView memberMainView, int pk) {		// 회원로그인 오버로딩
		this.pk = pk;	//회원코드
		
		newObject();
		addLayout();
		setStyle();
		eventProc();

		try {
			dao = new ReservationDAO();
			showJTable();
			
			System.out.println("예매 데이터베이스 연결 성공!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "데이터베이스 연결 실패!!: " + e.getMessage());
		}
		
	}
	
	
	
	
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	
	
	void newObject() {
		
		String[] cbFeSearchText = {"축제 이름","축제 장소"};	//검색 콤보박스
		cbFeSearch = new JComboBox(cbFeSearchText);
		
		String[] cbReHowpayCodeText = {"카드 결제","계좌 이체"};	// 결제 선택 콤보박스
		cbReHowpayCode = new JComboBox(cbReHowpayCodeText);
		
		TkResCount = new JSpinner();
		Integer[] Rescount = new Integer[] {0,1,2,3,4,5,6,7,8};
		SpinnerListModel spinnerListModel = new SpinnerListModel(Rescount);
		TkResCount.setModel(spinnerListModel);
		
		
		
		taContent = new JTextArea();
		
		tfFeSearch = new JTextField();
		btFeSearch = new JButton("검색");
		btTkSeat = new JButton("좌석 확인");
		btnReSet = new JButton("새로고침");
		ReservationListModel = new ReservationListModel();		// Jtable 
		tbList = new JTable(ReservationListModel);
		tbList.setFont(new Font("굴림", Font.PLAIN, 11));
		
		tfFeLocation = new JTextField();
		tfFeName = new JTextField();
		tfFeStartDay = new JTextField();
		tfFeEndDay = new JTextField();
		tfFeCompany = new JTextField();
		tfFePrice = new JTextField();
		pRightSearchBox = new JPanel();
		tfReSeatcnt = new JTextField();
		tfFestCode = new JTextField();
		
	}
	
	void addLayout() {
		JPanel pTop = new JPanel();	
		JPanel pLeft = new JPanel();
		JPanel pRight = new JPanel();
		JPanel pSearchBox = new JPanel();
		
		
		// Top 상단
		pTop.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pTop.setBounds(0, 0, 864, 50);
		pTop.setLayout(null);
		JLabel lbTfReservationInfo = new JLabel("축제 티켓 예매");
		lbTfReservationInfo.setFont(new Font("굴림", Font.PLAIN, 24));
		lbTfReservationInfo.setBounds(12, 10, 539, 28);
		pTop.add(lbTfReservationInfo);
		
		JLabel lbFestCode = new JLabel("축제 코드");
		lbFestCode.setHorizontalAlignment(SwingConstants.CENTER);
		lbFestCode.setFont(new Font("굴림", Font.PLAIN, 16));
		lbFestCode.setBounds(15, 17, 94, 35);
		pRight.add(lbFestCode);
		
		
		
		tfFestCode.setBounds(121, 21, 169, 33);
		pRight.add(tfFestCode);
		
		//------------------------------------------------------------------------------------top 끝
		
		JLabel lbFeCtCode = new JLabel("축제 유형");
		lbFeCtCode.setHorizontalAlignment(SwingConstants.CENTER);
		lbFeCtCode.setFont(new Font("굴림", Font.PLAIN, 16));
		lbFeCtCode.setBounds(15, 62, 94, 35);
		pRight.add(lbFeCtCode);
		
		tfFeCtCode = new JTextField();
		tfFeCtCode.setBounds(121, 64, 169, 33);
		pRight.add(tfFeCtCode);

		JLabel lbFeName = new JLabel("축제 이름");
		lbFeName.setHorizontalAlignment(SwingConstants.CENTER);
		lbFeName.setFont(new Font("굴림", Font.PLAIN, 16));
		lbFeName.setBounds(15, 107, 94, 35);
		pRight.add(lbFeName);
		tfFeName.setBounds(121, 107, 169, 33);
		pRight.add(tfFeName);
		
		// Right 시작
		JLabel lbFeLocation = new JLabel("축제 장소");
		lbFeLocation.setFont(new Font("굴림", Font.PLAIN, 16));
		lbFeLocation.setHorizontalAlignment(SwingConstants.CENTER);
		lbFeLocation.setBounds(15, 152, 94, 33);
		pRight.add(lbFeLocation);
		
		pRight.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pRight.setBounds(673, 49, 299, 548);
		pRight.setLayout(null);
		tfFeLocation.setBounds(121, 152, 169, 33);
		pRight.add(tfFeLocation);
		
		JLabel lbFeStartDay = new JLabel("축제 시작일");
		lbFeStartDay.setFont(new Font("굴림", Font.PLAIN, 16));
		lbFeStartDay.setHorizontalAlignment(SwingConstants.CENTER);
		lbFeStartDay.setBounds(15, 191, 94, 40);
		pRight.add(lbFeStartDay);
		
		tfFeStartDay.setBounds(121, 193, 169, 33);
		pRight.add(tfFeStartDay);
		
		JLabel lbFeEndDay = new JLabel("축제 종료일");
		lbFeEndDay.setHorizontalAlignment(SwingConstants.CENTER);
		lbFeEndDay.setFont(new Font("굴림", Font.PLAIN, 16));
		lbFeEndDay.setBounds(15, 236, 94, 33);
		pRight.add(lbFeEndDay);
		tfFeEndDay.setBounds(121, 236, 169, 33);
		pRight.add(tfFeEndDay);
		
		JLabel lbFeCompany = new JLabel("축제 주최측");
		lbFeCompany.setHorizontalAlignment(SwingConstants.CENTER);
		lbFeCompany.setFont(new Font("굴림", Font.PLAIN, 16));
		lbFeCompany.setBounds(15, 279, 94, 33);
		pRight.add(lbFeCompany);
		tfFeCompany.setBounds(121, 282, 169, 33);
		pRight.add(tfFeCompany);
		
		JLabel lbFePrice = new JLabel("축제 이용료");
		lbFePrice.setHorizontalAlignment(SwingConstants.CENTER);
		lbFePrice.setFont(new Font("굴림", Font.PLAIN, 16));
		lbFePrice.setBounds(15, 326, 97, 31);
		pRight.add(lbFePrice);
		tfFePrice.setBounds(121, 324, 169, 33);
		pRight.add(tfFePrice);
		
		JLabel lbReHowpayCode = new JLabel("결제 수단");
		lbReHowpayCode.setHorizontalAlignment(SwingConstants.CENTER);
		lbReHowpayCode.setFont(new Font("굴림", Font.PLAIN, 14));
		lbReHowpayCode.setBounds(12, 409, 97, 33);
		pRight.add(lbReHowpayCode);
		
		
		cbReHowpayCode.setBounds(121, 412, 169, 26);
		pRight.add(cbReHowpayCode);
		
		JLabel lbReSeatcnt = new JLabel("축제 좌석 수");
		lbReSeatcnt.setHorizontalAlignment(SwingConstants.CENTER);
		lbReSeatcnt.setFont(new Font("굴림", Font.PLAIN, 16));
		lbReSeatcnt.setBounds(15, 367, 97, 31);
		pRight.add(lbReSeatcnt);
		
		
		
		tfReSeatcnt.setBounds(121, 367, 169, 33);
		pRight.add(tfReSeatcnt);
		
		JLabel lbTkSeatcnt = new JLabel("티켓 예매 수");
		lbTkSeatcnt.setHorizontalAlignment(SwingConstants.CENTER);
		lbTkSeatcnt.setFont(new Font("굴림", Font.PLAIN, 16));
		lbTkSeatcnt.setBounds(15, 448, 94, 35);
		pRight.add(lbTkSeatcnt);
		
		btTkSeat.setBounds(121, 507, 169, 31);
		pRight.add(btTkSeat);
		setLayout(null);
		//------------------------------------------------------------------------------------Right 끝
		
		
		// Left 축제 관리 리스트
		pLeft.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pLeft.setBounds(0, 92, 671, 578);
		pLeft.setLayout(new BorderLayout(0, 0));
		
		JScrollPane spJtableBox = new JScrollPane();
		spJtableBox.setFont(new Font("굴림", Font.PLAIN, 12));
		pLeft.add(spJtableBox, BorderLayout.CENTER);
		spJtableBox.setViewportView(tbList);
		
		pSearchBox.setBounds(0, 48, 405, 44);
		pSearchBox.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pSearchBox.setLayout(null);
		
		cbFeSearch.setBounds(12, 10, 91, 26);	
		pSearchBox.add(cbFeSearch);
		tfFeSearch.setBounds(110, 10, 196, 26);	
		pSearchBox.add(tfFeSearch);
		btFeSearch.setBounds(318, 10, 71, 25);
		pSearchBox.add(btFeSearch);
		
		TkResCount.setBounds(121, 448, 74, 31);
		pRight.add(TkResCount);
		//------------------------------------------------------------------------------------Left 끝
		
		add(pTop);
		add(pRight);
		
		add(pLeft);
		add(pSearchBox);
		
		
		btnReSet.setBounds(564, 59, 97, 23);
		add(btnReSet);
		
		
		
		
	}
	void setStyle() {
		tfFeCtCode.setEditable(false);
		tfFeName.setEditable(false);
		tfFeStartDay.setEditable(false);
		tfFeLocation.setEditable(false);
		tfFeEndDay.setEditable(false);
		tfFeCompany.setEditable(false);
		tfFePrice.setEditable(false);
		tfReSeatcnt.setEditable(false);
		tfFestCode.setEditable(false);
		
		
	}
	
	void eventProc(){
		btTkSeat.addActionListener(this);		//좌석 버튼 이벤트
		btFeSearch.addActionListener(this);		//검색 버튼 이벤트
		btnReSet.addActionListener(this);
		
		tbList.addMouseListener(new MouseAdapter() {					
			public void mouseClicked(MouseEvent e) {
				int col = 0;										// 쿼리에 fest_code자리수 맞춰야함 컬럼행 = 1번자리
				int row = tbList.getSelectedRow();					// 축제 목록 선택시 텍스트 박스로 정보 이동 
				
				int vNum = (Integer)tbList.getValueAt(row, col);	
				try {
					vo = dao.selectFestivallist(vNum);
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Jtable에 정보가 없습니다. " + e2.getMessage());
				}
				
				tfFestCode.setText(String.valueOf(vo.getFestcode()));
				tfFeCtCode.setText(String.valueOf(vo.getCtcode()));	//-------------------------------- TextField에 선택된 리스트 출력
				tfFeName.setText(vo.getFestname());
				tfFeLocation.setText(vo.getLoc());
				
				SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd");
				tfFeStartDay.setText(vo.getStartday());
				tfFeEndDay.setText(vo.getEndday());
				tfFePrice.setText(String.valueOf(vo.getPrice()));
				tfFeCompany.setText(vo.getCompany());
				tfReSeatcnt.setText(String.valueOf(vo.getSeatcnt()));
				
				
				//------------------------------------------------------ 텍스트 출력 여기까지
				
			}
		});
		
		
		
	}
	
	
		
	
	@Override
	public void actionPerformed(ActionEvent ev) {				// 클릭 이벤트
		Object o = ev.getSource();
		
		if (o == btTkSeat) { // 좌석 선택 버튼
			int seatchoice = (Integer)TkResCount.getValue();
			int festCode = Integer.parseInt(tfFestCode.getText());
			int memcode = pk;
			
				
			int row = tbList.getSelectedRow();
			int cnt = (int) tbList.getValueAt(row, 6);
			int price = (int) tbList.getValueAt(row, 5);
			int tot = seatchoice * price;
			
			
			if((Integer)TkResCount.getValue()>cnt || cnt ==0) {
				JOptionPane.showMessageDialog(null, "남은 좌석이 없습니다!");
			}else {
				int paycode = cbReHowpayCode.getSelectedIndex()+1;
				rsview = new ResSeatView(seatchoice,memcode,festCode,paycode,tot); 		
			}
			
		
		} else if (o == btFeSearch) { // 목록 검색 버튼
			searchFestival();
		}else if(o==btnReSet) {
			showJTable();
		}

	}
	
	void showJTable() {		// 축제 목록 계속 보이게
		try {
			list = dao.showFestivalList();
			ReservationListModel.data = list;
			tbList.setModel(ReservationListModel);
			ReservationListModel.fireTableDataChanged();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Jtalbe 리스트 출력 실패!"+e.getMessage());
		}
	}
	

	
	
	void searchFestival() {								//선택되었을때 보이게
		int sel = cbFeSearch.getSelectedIndex();
		String text = tfFeSearch.getText();
		
		try {
			list = dao.searchTableList(sel, text);
			ReservationListModel.data = list;
			tbList.setModel(ReservationListModel);
			ReservationListModel.fireTableDataChanged();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Jtalbe 리스트 출력 실패!"+e.getMessage());
		}
	}
}// 끝

	



	class ReservationListModel extends AbstractTableModel{			// Jtable Model로 만들기
		
		ArrayList data = new ArrayList();
		String [] columnNames = {"축제 코드","축제 이름","축제 장소","축제 시작일","축제 종료일","축제 이용료","축제 좌석수"};
		
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
			ArrayList temp = (ArrayList)data.get(row);
			return temp.get(col);
		}
		
		public String getColumnName(int col) {
			
			return columnNames[col];
		}
	}
