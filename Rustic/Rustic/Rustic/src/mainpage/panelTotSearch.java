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
	
	//���̺�
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
		//eventProc();		//�̺�Ʈ ��ϸ޼ҵ�
	
		//�ӽ� �󺧵�
		JLabel lblNewLabel = new JLabel("����/�Ź� ���հ˻� ������");
		lblNewLabel.setForeground(new Color(255, 140, 0));
		lblNewLabel.setFont(new Font("����", Font.BOLD, 17));
		lblNewLabel.setBounds(96, 5, 230, 35);
		add(lblNewLabel);
		
		
		//���̺� ����
		model = new RecentListTableModel();
		table	= new JTable( model );
		
		JPanel panel = new JPanel();
		panel.setBounds(37, 118, 565, 285);
		add("Center",panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane( table );
		scrollPane.setBounds(0, 0, 565, 285);
		panel.add(scrollPane );
		
		
		String searchText[] =  {"�̸�","�ּ�","���ּ�"};
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
		
		
		//������� �� ����
		try {
			dao = new MainpageSearchDAO();
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
	
	public void searchTable() {
		
		
		int sel = comboBox1.getSelectedIndex();
	      String text = searchtx.getText();
	      try {
	    	 
	         ArrayList list =dao.totsearch(sel, text);
	         model.data=list;
	         table.setModel(model);
	         model.fireTableDataChanged();
	         
	      }catch(Exception e) {
	         JOptionPane.showMessageDialog(null, "�˻� ����: " + e.getMessage());   
	      }
	      
	   }
	
	void selectTable() throws Exception {

		
		try {
			ArrayList list = dao.total();
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
}
