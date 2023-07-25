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
		lblNewLabel.setFont(new Font("����", Font.BOLD, 17));
		lblNewLabel.setBounds(58, 25, 285, 32);
		contentPanel.add(lblNewLabel);
	
		
		
		
		
		
		 
	      try {
				dao2 = new MainpageSearchDAO();
				System.out.println("���������� ��ġ DB���� ����");
				
				
				selectTable();
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "���������� ��ġ DB���� ���� : " + e.getMessage());
			}
			
	      table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					int row = table.getSelectedRow();
					int col=0; //�� �� ���� ��ȣ �����ð���
					
					// ����â ����
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
			
			String [] columnNames = {"���� ��ȣ", "���� ����", "���� ����", "�Խ���", "�����"};
			
			
			//=============================================================
			// 1. �⺻���� TabelModel  �����
			// �Ʒ� �� �Լ��� TabelModel �������̽��� �߻��Լ��ε�
			// AbstractTabelModel���� �������� �ʾұ⿡...
			// �ݵ�� ����� ���� �ʼ�!!!!
			
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
			//�̺�Ʈ ���(����) �޼ҵ�
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
					//System.out.println(list.get(0)); //Ȯ�ο�
					table.setModel(model);
					//���� ���濡 ���� �ǽð� ü����
					model.fireTableDataChanged();
				}	
				catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "��Ż����Ʈ ��� ���� : " + e.getMessage());
				}
			}
			
}
