package mainpage;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import dao.MainpageSearchDAO;
import mainpage.MyPage.RecentListTableModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;

public class test extends JDialog {

	private final JPanel contentPanel = new JPanel();

	
	
	private static String id = null;
	RecentListTableModel model;
	MainpageSearchDAO dao2=null;
	private JTable table;
	private static int vnum=0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			test dialog = new test(id);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public test(String id) {
		this.id =id;
		
	    model = new RecentListTableModel();
		table = new JTable( model );
		
		setBounds(100, 100, 692, 471);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 67, 654, 357);
		contentPanel.add("Center",panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane( table );
		scrollPane.setBounds(12, 5, 630, 342);
		panel.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("\uB098\uC758 \uC608\uC57D \uD655\uC815 \uB9AC\uC2A4\uD2B8");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 17));
		lblNewLabel.setBounds(58, 25, 285, 32);
		contentPanel.add(lblNewLabel);
	
		
		
		
		
		
		 
	      try {
				dao2 = new MainpageSearchDAO();
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
					
					// 리뷰창 띄우기
					ReviewFrame rw = new ReviewFrame();
					
					rw.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		      		
			      	rw.setModal(true);
			      	
			      	rw.setVisible(true);
					
		 
			
					//tfReturnVideoNum.setText(String.valueOf(vNum));
					
				}
			});
		
		
	      setLocationRelativeTo(null);
	}
	
	

	
	   class RecentListTableModel extends AbstractTableModel { 
			  
			ArrayList data = new ArrayList();
			
			String [] columnNames = {"예약 번호", "예약 일자", "예약 수단", "입실일", "퇴실일"};
			
			
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
				int custnum=0;
			
				
				try {
					custnum = dao2.checknunm(id);
					
					ArrayList list = dao2.MypageList2(custnum);

					model.data = list;
					//System.out.println(list.get(0)); //확인용
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
