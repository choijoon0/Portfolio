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

public class RoomSearch extends JPanel {

	
	
	RecentListTableModel model;
	MainpageSearchDAO dao=null;
	private static int vnum=0;
	private JTable table;
	private JTextField textField;
	JComboBox comboBox;
	
	
	public RoomSearch(String id) {
		setBackground(new Color(0, 128, 128));
		setBounds(0,0,639, 498);
		setLayout(null);
		
		model = new RecentListTableModel();
		table	= new JTable( model );
		table.setFont(new Font("����", Font.PLAIN, 12));
		
		JLabel Search_budong = new JLabel("\uBD80\uB3D9\uC0B0(\uC7A5\uAE30\uC219\uBC15)");
		Search_budong.setHorizontalAlignment(SwingConstants.CENTER);
		Search_budong.setForeground(Color.WHITE);
		Search_budong.setFont(new Font("����", Font.BOLD, 15));
		Search_budong.setBounds(32, 47, 174, 40);
		add(Search_budong);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(30, 97, 577, 371);
		add("Center",panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane( table );
		scrollPane.setBounds(12, 5, 553, 356);
		panel.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 128));
		panel_1.setBounds(247, 47, 360, 40);
		add(panel_1);
		panel_1.setLayout(null);
		
		
		String searchText[] =  { "�̸�", "�ּ�", "�� �ּ�" };
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uC774\uB984", "\uC8FC\uC18C", "\uC0C1\uC138 \uC8FC\uC18C"}));
		
		textField = new JTextField();
		textField.setFont(new Font("����", Font.PLAIN, 12));
		textField.setBounds(105, 11, 144, 21);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\uAC80\uC0C9");
		btnNewButton.setFont(new Font("����", Font.PLAIN, 12));
		btnNewButton.setBounds(275, 10, 71, 23);
		panel_1.add(btnNewButton);
		
		String tt[] =  {"�̸�","�ּ�","���ּ�"};
		comboBox = new JComboBox(tt);
		comboBox.setFont(new Font("����", Font.PLAIN, 12));
		comboBox.setBounds(12, 10, 71, 23);
		panel_1.add(comboBox);
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				searchTable();
				
			}
		});
		setVisible(true);


		
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
		
		
		//����Ʈ ���
		void selectTable() throws Exception {

			try {
				ArrayList list = dao.totalList();

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
		
		
		//�˻�
		public void searchTable() {
			int sel = comboBox.getSelectedIndex();
		      String text = textField.getText();
		      
		      try {
		         ArrayList list = dao.rmsearch(sel, text);
		         model.data=list;
		         table.setModel(model);
		         model.fireTableDataChanged();
		         
		      }catch(Exception e) {
		         JOptionPane.showMessageDialog(null, "�˻� ����: " + e.getMessage());   
		      }
		      
		   }
}
