package mainpage;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import dao.MainpageSearchDAO;
import mainpage.test.RecentListTableModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;

public class MyReview extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private static String id = null;
	RecentListTableModel model;
	MainpageSearchDAO dao2=null;
	private JTable table;
	private static int vnum=0;

	public static void main(String[] args) {
		try {
			MyReview dialog = new MyReview(id);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MyReview(String id) {
		this.id = id;
		
		model = new RecentListTableModel();
		table = new JTable( model );
		table.setFont(new Font("바탕", Font.PLAIN, 12));
			
		setBounds(100, 100, 614, 449);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 128, 128));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(12, 111, 576, 268);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane( table );
		scrollPane.setBounds(12, 5, 552, 253);
		panel.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("\uB0B4\uAC00 \uC791\uC131\uD55C \uB9AC\uBDF0");
		lblNewLabel.setFont(new Font("바탕", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(23, 70, 173, 31);
		contentPanel.add(lblNewLabel);
		
		 try {
				dao2 = new MainpageSearchDAO();
				System.out.println("메인페이지 서치 DB연결 성공");
				
				
				selectTable();
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "메인페이지 서치 DB연결 실패 : " + e.getMessage());
			}
		
		 setLocationRelativeTo(null);
	}
	 class RecentListTableModel extends AbstractTableModel { 
		  
			ArrayList data = new ArrayList();
			
			String [] columnNames = {"리뷰 내용", "평점", "리뷰 작성일"};
			
			
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
				int num2=0;
			
				
				try {
					custnum = dao2.checknunm(id);//custnum임
					
					num2 = dao2.gaboja(custnum); //reservnum
					
					ArrayList list = dao2.reviewlist(num2);

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
