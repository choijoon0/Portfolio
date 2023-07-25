package ownerWrite;

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
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import dao.MainpageSearchDAO;
import ownerWrite.FrameDashboard_owner.asd;
import ownerWrite.FrameDashboard_owner.budong;
import ownerWrite.FrameDashboard_owner.OwnerMain.RecentListTableModel;
import ownerWrite.FrameDashboard_owner.OwnerMain.RecentListTableModel2;

import javax.swing.JComboBox;
import javax.swing.JButton;


public class OwnerMain extends JPanel {

	
	RecentListTableModel model;
	RecentListTableModel2 model2;
	MainpageSearchDAO dao=null;
	private JTable table;
	private JTable table2;
	private static int vnum=0;
	private JTextField textField;
	
	private static String id = null;

	/**
	 * Create the panel.
	 */
	public OwnerMain(String id) {
		setBackground(new Color(0, 128, 128));
		
		setBounds(0,0, 639, 498);
		setLayout(null);
		setVisible(true);
		
		this.id = id;
		//eventProc();		//이벤트 등록메소드
		
		model = new RecentListTableModel();
		model2 = new RecentListTableModel2();
		table	= new JTable( model );
		table.setFont(new Font("바탕", Font.PLAIN, 14));
		table2	= new JTable( model2 );
		table2.setFont(new Font("바탕", Font.PLAIN, 14));
	
		JLabel lblNewLabel = new JLabel("\uB0B4 \uC219\uBC15 \uB4F1\uB85D \uB9AC\uC2A4\uD2B8");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("바탕", Font.BOLD, 17));
		lblNewLabel.setBounds(94, 57, 184, 51);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uB0B4 \uBD80\uB3D9\uC0B0 \uB4F1\uB85D \uB9AC\uC2A4\uD2B8");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("바탕", Font.BOLD, 17));
		lblNewLabel_1.setBounds(372, 57, 184, 51);
		add(lblNewLabel_1);
	
		
		JPanel panel = new JPanel();
		panel.setBounds(37, 118, 565, 285);
		add("Center",panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane( table );
		scrollPane.setBounds(0, 0, 287, 285);
		panel.add(scrollPane );
		
		JScrollPane scrollPane_1 = new JScrollPane(table2);
		scrollPane_1.setBounds(283, 0, 282, 285);
		panel.add(scrollPane_1);
		
		JButton btnNewButton = new JButton("\uC0C8\uB85C\uACE0\uCE68");
		btnNewButton.setFont(new Font("바탕", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(95, 158, 160));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//
				
				try {
					selectTable();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					selectTable2();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//
				
				
				
			}
		});
		btnNewButton.setBounds(492, 424, 110, 31);
		add(btnNewButton);
		
		String searchText[] =  {"이름","주소","상세주소"};
		
		try {
			dao = new MainpageSearchDAO();
			System.out.println("메인페이지 서치 DB연결 성공");
			selectTable();
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "메인페이지 서치 DB연결 실패 : " + e.getMessage());
		}
		
		try {
			dao = new MainpageSearchDAO();
			System.out.println("메인페이지 서치 DB연결 성공");
			
			selectTable2();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "메인페이지 서치 DB연결 실패 : " + e.getMessage());
		}
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int col=0; //맨 앞 비디오 번호 가져올거임
				vnum = Integer.parseInt(table.getValueAt(row, col).toString());	
				
				asd login = new asd(vnum);
	            login.setUndecorated(true);
	            login.setVisible(true);
		
				//tfReturnVideoNum.setText(String.valueOf(vNum));
				
			}
		});
		
		table2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table2.getSelectedRow();
				int col=0; //맨 앞 비디오 번호 가져올거임
				vnum = Integer.parseInt(table2.getValueAt(row, col).toString());	
				
				budong login = new budong(vnum);
	            login.setUndecorated(true);
	            login.setVisible(true);
		
				//tfReturnVideoNum.setText(String.valueOf(vNum));
				
			}
		});
		
		
		 setLocationRelativeTo(null);
	
		
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
	
	class RecentListTableModel2 extends AbstractTableModel { 
		  
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

			int ownernum = 0;
			
			try {
				ownernum = dao.checkownernunm(id);
				ArrayList list = dao.bububu(ownernum);

				model2.data = list;
				table.setModel(model2);
				//정보 변경에 따른 실시간 체인지
				model2.fireTableDataChanged();
			}	
			catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "토탈리스트 출력 실패 : " + e.getMessage());
			}
		}
		
		void selectTable2() throws Exception {

			int ownernunm = 0;
			
			
			try {
				ownernunm = dao.checkownernunm(id);
				
				ArrayList list1 = dao.memenu(ownernunm);

				model.data = list1;
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
