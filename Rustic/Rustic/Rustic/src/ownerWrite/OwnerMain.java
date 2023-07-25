package ownerWrite;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import dao.MainpageSearchDAO;

import javax.swing.JComboBox;
import javax.swing.JButton;


public class OwnerMain extends JPanel {

	
	RecentListTableModel model;
	RecentListTableModel2 model2;
	MainpageSearchDAO dao=null;
	private JTable table;
	private JTable table2;
	
	private JTextField textField;
	
	private static String id = null;

	/**
	 * Create the panel.
	 */
	public OwnerMain(String id) {
		setBounds(0,0, 639, 498);
		setLayout(null);
		setVisible(true);
		
		this.id = id;
		//eventProc();		//�̺�Ʈ ��ϸ޼ҵ�
		
		model = new RecentListTableModel();
		model2 = new RecentListTableModel2();
		table	= new JTable( model );
		table2	= new JTable( model2 );
	
		//�ӽ� �󺧵�
		JLabel lblNewLabel = new JLabel("\uB0B4 \uC219\uBC15 \uB4F1\uB85D \uB9AC\uC2A4\uD2B8");
		lblNewLabel.setForeground(new Color(255, 140, 0));
		lblNewLabel.setFont(new Font("����", Font.BOLD, 17));
		lblNewLabel.setBounds(78, 57, 184, 51);
		add(lblNewLabel);
	
		
		JPanel panel = new JPanel();
		panel.setBounds(37, 118, 565, 285);
		add("Center",panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane( table );
		scrollPane.setBounds(0, 0, 272, 285);
		panel.add(scrollPane );
		
		JScrollPane scrollPane_1 = new JScrollPane(table2);
		scrollPane_1.setBounds(283, 0, 282, 285);
		panel.add(scrollPane_1);
		
		JLabel lblNewLabel_1 = new JLabel("\uB0B4 \uBD80\uB3D9\uC0B0 \uB4F1\uB85D \uB9AC\uC2A4\uD2B8");
		lblNewLabel_1.setForeground(new Color(255, 140, 0));
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 17));
		lblNewLabel_1.setBounds(372, 57, 184, 51);
		add(lblNewLabel_1);
		
		
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

		
	
		
		
		void selectTable() throws Exception {

			int ownernum = 0;
			
			try {
				ownernum = dao.checkownernunm(id);
				ArrayList list = dao.bububu(ownernum);

				model.data = list;
				table.setModel(model);
				//���� ���濡 ���� �ǽð� ü����
				model.fireTableDataChanged();
			}	
			catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "��Ż����Ʈ ��� ���� : " + e.getMessage());
			}
		}
		
		//����
		void selectTable2() throws Exception {

			int ownernunm = 0;
			
			
			try {
				ownernunm = dao.checkownernunm(id);
				
				ArrayList list = dao.memenu(ownernunm);

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
}
