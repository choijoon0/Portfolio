package mainpage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import dao.MainpageSearchDAO;


import javax.swing.table.TableModel;

import SignUp.FrameLogin;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class panelTotSearch extends JPanel {
	
	//테이블
	RecentListTableModel model;
	MainpageSearchDAO dao=null;
	private JTable table;
	private static int vnum=0;
	private JTextField searchtx;
	
	JComboBox comboBox1;
	
	
	
	
	
	public panelTotSearch(String id) {

		setBounds(0,0, 639, 498);
		setLayout(null);
		setVisible(true);
		//eventProc();		//이벤트 등록메소드
	
		//임시 라벨들
		JLabel lblNewLabel = new JLabel("숙방/매물 통합검색 페이지");
		lblNewLabel.setForeground(new Color(255, 140, 0));
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 17));
		lblNewLabel.setBounds(96, 5, 230, 35);
		add(lblNewLabel);
		
		
		//테이블 구간
		model = new RecentListTableModel();
		table	= new JTable( model );
		
		JPanel panel = new JPanel();
		panel.setBounds(37, 118, 565, 285);
		add("Center",panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane( table );
		scrollPane.setBounds(0, 0, 565, 285);
		panel.add(scrollPane );
		
		
		String searchText[] =  {"이름","주소","상세주소"};
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(68, 66, 318, 35);
		add(panel_1);
		comboBox1 = new JComboBox( searchText );
		//comboBox1.setModel(new DefaultComboBoxModel(new String[] {"\uC774\uB984", "\uC8FC\uC18C", "\uC0C1\uC138 \uC8FC\uC18C"}));
		panel_1.add(comboBox1);
		
		searchtx = new JTextField();
		panel_1.add(searchtx);
		searchtx.setColumns(10);
		
		JButton searchBtn = new JButton("\uAC80\uC0C9");
		panel_1.add(searchBtn);
		
			
			
			searchBtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					searchTable();
					
		
					
				}
			});
		
		
		//여기부터 찐 시작
		try {
			dao = new MainpageSearchDAO();
			System.out.println("메인페이지 서치 DB연결 성공");
			selectTable();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "메인페이지 서치 DB연결 실패 : " + e.getMessage());
		}
		
		
		
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int col=0; //맨 앞 비디오 번호 가져올거임
				vnum = Integer.parseInt(table.getValueAt(row, col).toString());	
				
				Reservation login = new Reservation(vnum, id);
	            login.setUndecorated(true);
	            login.setVisible(true);
		
				//tfReturnVideoNum.setText(String.valueOf(vNum));
				
			}
		});
		
		
		

	}
	
	
	class RecentListTableModel extends AbstractTableModel { 
		  
	ArrayList data = new ArrayList();
	String [] columnNames = {"등록번호", "이름", "주소", "상세 주소"};
	
	
	//String [] columnNames = {"이름", "전화번호","아이디", "비밀번호", "반납예정일", "반납여부" };
	//=============================================================
	// 1. 기본적인 TabelModel  만들기
	// 아래 세 함수는 TabelModel 인터페이스의 추상함수인데
	// AbstractTabelModel에서 구현되지 않았기에...
	// 반드시 사용자 구현 필수!!!!
	
	    public int getColumnCount() { 
	        return columnNames.length; 
	    } 
	     
	    public int getRowCount() { 
	        return data.size(); 
	    } 
	
	    public Object getValueAt(int row, int col) { 
	    	ArrayList temp = (ArrayList)data.get( row );
	        return temp.get( col ); 
	    }
	

	    
		public String getColumnName(int col) { 
	       return columnNames[col]; 
	    } 
	
	}
	//이벤트 등록(연결) 메소드
	public void eventProc() {
				
	}
	public int getvnum() {
		return vnum;
	}
	
	public void searchTable() {
		
		
		int sel = comboBox1.getSelectedIndex();
	      String text = searchtx.getText();
	      try {
	    	 
	         ArrayList list =dao.totsearch(sel, text);
	         model.data=list;
	         table.setModel(model);
	         model.fireTableDataChanged();
	         
	      }catch(Exception e) {
	         JOptionPane.showMessageDialog(null, "검색 실패: " + e.getMessage());   
	      }
	      
	   }
	
	void selectTable() throws Exception {

		
		try {
			ArrayList list = dao.total();
			model.data = list;
			table.setModel(model);
			//정보 변경에 따른 실시간 체인지
			model.fireTableDataChanged();
		}	
		catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "토탈리스트 출력 실패 : " + e.getMessage());
		}
	}
}
