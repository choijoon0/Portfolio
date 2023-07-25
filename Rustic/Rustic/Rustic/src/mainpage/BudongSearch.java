package mainpage;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;

import dao.MainpageSearchDAO;
import mainpage.panelTotSearch.RecentListTableModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BudongSearch extends JPanel {

	
	
	RecentListTableModel model;
	MainpageSearchDAO dao=null;
	private JTable table;
	private static int vnum=0;
	private JTextField textField;
	
	JComboBox combobox;

	
	
	
	public BudongSearch(String id) {
		setBackground(new Color(0, 128, 128));
		setBounds(0,0,639, 498);
		setLayout(null);
		
		model = new RecentListTableModel();
		table	= new JTable( model );
		
		JLabel Search_budong = new JLabel("부동산(장기숙박) 검색하기");
		Search_budong.setHorizontalAlignment(SwingConstants.CENTER);
		Search_budong.setForeground(Color.WHITE);
		Search_budong.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		Search_budong.setBounds(41, 10, 246, 40);
		add(Search_budong);
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 97, 577, 371);
		add("Center",panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane( table );
		scrollPane.setBounds(12, 5, 553, 356);
		panel.add(scrollPane);
		
		String searchText[] =  {"이름","주소","상세주소"};
		combobox = new JComboBox(searchText);
		//combobbox.setModel(new DefaultComboBoxModel(new String[] {"\uBC88\uD638", "\uC774\uB984", "\uC8FC\uC18C", "\uC0C1\uC138 \uC8FC\uC18C"}));
		combobox.setBounds(84, 64, 56, 23);
		add(combobox);
		
		textField = new JTextField();
		textField.setBounds(162, 66, 178, 21);
		add(textField);
		textField.setColumns(10);
		
		JButton searchTx = new JButton("\uAC80\uC0C9");
		searchTx.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				searchTable();
				
			}
		});
		
		searchTx.setBounds(352, 64, 95, 23);
		add(searchTx);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(87, 64, 32, 23);
		add(comboBox);
		


		
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
				
				Reservation2 login = new Reservation2(vnum, id);
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
		
		void selectTable() throws Exception {

			try {
				ArrayList list = dao.totalList2();

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
		
		public void searchTable() {

			int sel =  combobox.getSelectedIndex();
		      String text = textField.getText();
		      try {
		         ArrayList list =dao.busearch(sel, text);
		         model.data=list;
		         table.setModel(model);
		         model.fireTableDataChanged();
		         
		      }catch(Exception e) {
		         JOptionPane.showMessageDialog(null, "검색 실패: " + e.getMessage());   
		      }
		      
		   }
}
