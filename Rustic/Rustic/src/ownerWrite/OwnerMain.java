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
		//eventProc();		//�̺�Ʈ ��ϸ޼ҵ�
		
		model = new RecentListTableModel();
		model2 = new RecentListTableModel2();
		table	= new JTable( model );
		table.setFont(new Font("����", Font.PLAIN, 14));
		table2	= new JTable( model2 );
		table2.setFont(new Font("����", Font.PLAIN, 14));
	
		JLabel lblNewLabel = new JLabel("\uB0B4 \uC219\uBC15 \uB4F1\uB85D \uB9AC\uC2A4\uD2B8");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("����", Font.BOLD, 17));
		lblNewLabel.setBounds(94, 57, 184, 51);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uB0B4 \uBD80\uB3D9\uC0B0 \uB4F1\uB85D \uB9AC\uC2A4\uD2B8");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 17));
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
		btnNewButton.setFont(new Font("����", Font.BOLD, 14));
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
		
		String searchText[] =  {"�̸�","�ּ�","���ּ�"};
		
		try {
			dao = new MainpageSearchDAO();
			System.out.println("���������� ��ġ DB���� ����");
			selectTable();
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "���������� ��ġ DB���� ���� : " + e.getMessage());
		}
		
		try {
			dao = new MainpageSearchDAO();
			System.out.println("���������� ��ġ DB���� ����");
			
			selectTable2();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "���������� ��ġ DB���� ���� : " + e.getMessage());
		}
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int col=0; //�� �� ���� ��ȣ �����ð���
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
				int col=0; //�� �� ���� ��ȣ �����ð���
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
		String [] columnNames = {"��Ϲ�ȣ", "�̸�", "�ּ�", "�� �ּ�"};
		
		
		//String [] columnNames = {"�̸�", "��ȭ��ȣ","���̵�", "��й�ȣ", "�ݳ�������", "�ݳ�����" };
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
	
	class RecentListTableModel2 extends AbstractTableModel { 
		  
		ArrayList data = new ArrayList();
		String [] columnNames = {"��Ϲ�ȣ", "�̸�", "�ּ�", "�� �ּ�"};
		
		
		//String [] columnNames = {"�̸�", "��ȭ��ȣ","���̵�", "��й�ȣ", "�ݳ�������", "�ݳ�����" };
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

			int ownernum = 0;
			
			try {
				ownernum = dao.checkownernunm(id);
				ArrayList list = dao.bububu(ownernum);

				model2.data = list;
				table.setModel(model2);
				//���� ���濡 ���� �ǽð� ü����
				model2.fireTableDataChanged();
			}	
			catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "��Ż����Ʈ ��� ���� : " + e.getMessage());
			}
		}
		
		void selectTable2() throws Exception {

			int ownernunm = 0;
			
			
			try {
				ownernunm = dao.checkownernunm(id);
				
				ArrayList list1 = dao.memenu(ownernunm);

				model.data = list1;
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
