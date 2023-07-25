package mainpage;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.AbstractListModel;

import dao.MainpageSearchDAO;
import dao.MemberDao;
import mainpage.panelTotSearch.RecentListTableModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class MyPage extends JPanel {
   
   /**
    * Create the panel.
    */
	RecentListTableModel model;
	MainpageSearchDAO dao2=null;
	private JTable table;
	private static int vnum=0;

	private static String id = null;
	private JTextField renum;
	
	
	
   public MyPage(String id, int gubun) {
	  this.id = id;
      setBackground(new Color(0, 128, 128));
      setBounds(0, 0, 639, 498);
      setLayout(null);
      setVisible(false);	//�̰� �³�? ������ �뽬���� ����� �갡 �̻��ϰ� ���� �־��..
      
     
      
      JPanel NamePanel = new JPanel();
      NamePanel.setBackground(new Color(0, 128, 128));
      NamePanel.setBounds(12, 60, 176, 55);
      add(NamePanel);
      NamePanel.setLayout(null);
      
      JLabel My_Name = new JLabel("NAME");
      My_Name.setForeground(new Color(255, 255, 255));
      My_Name.setFont(new Font("����", Font.BOLD, 14));
      My_Name.setBounds(12, 10, 67, 35);
      NamePanel.add(My_Name);
      
      JLabel Tx_Name = new JLabel();
      Tx_Name.setFont(new Font("����", Font.PLAIN, 13));
      Tx_Name.setForeground(Color.WHITE);
      Tx_Name.setBounds(72, 10, 99, 35);
      NamePanel.add(Tx_Name);
      Tx_Name.setText(id);
      
      JPanel AddrPanel = new JPanel();
      AddrPanel.setBackground(new Color(0, 128, 128));
      AddrPanel.setBounds(12, 190, 176, 55);
      add(AddrPanel);
      AddrPanel.setLayout(null);
      
      JLabel MyID = new JLabel("ID");
      MyID.setForeground(new Color(255, 255, 255));
      MyID.setFont(new Font("����", Font.BOLD, 14));
      MyID.setBounds(12, 10, 67, 35);
      AddrPanel.add(MyID);
      
      JLabel Tx_ID = new JLabel();
      Tx_ID.setFont(new Font("����", Font.PLAIN, 13));
      Tx_ID.setForeground(Color.WHITE);
      Tx_ID.setBounds(72, 10, 101, 35);
      AddrPanel.add(Tx_ID);
      Tx_ID.setText(id);
      
      JPanel PhPanel = new JPanel();
      PhPanel.setBackground(new Color(0, 128, 128));
      PhPanel.setBounds(12, 125, 176, 55);
      add(PhPanel);
      PhPanel.setLayout(null);
      
      JLabel My_Phone = new JLabel("PHONE");
      My_Phone.setForeground(new Color(255, 255, 255));
      My_Phone.setFont(new Font("����", Font.BOLD, 14));
      My_Phone.setBounds(12, 10, 67, 35);
      PhPanel.add(My_Phone);
      
      JLabel Tx_Phone = new JLabel();
      Tx_Phone.setFont(new Font("����", Font.PLAIN, 13));
      Tx_Phone.setForeground(Color.WHITE);
      Tx_Phone.setBounds(72, 10, 102, 35);
      PhPanel.add(Tx_Phone);
      
      //DAO ����
      MemberDao dao = MemberDao.getInstance();
      ArrayList mypageList = dao.find_info(id, gubun);
      String name= mypageList.get(0).toString();
      String phone= mypageList.get(1).toString();
      Tx_Name.setText(name);
      Tx_Phone.setText(phone);
      
      JLabel My_Info = new JLabel("MY PAGE");
      My_Info.setForeground(new Color(255, 255, 255));
      My_Info.setHorizontalAlignment(SwingConstants.CENTER);
      My_Info.setFont(new Font("����", Font.BOLD, 16));
      My_Info.setBounds(12, 10, 246, 40);
      add(My_Info);
      
      JLabel My_Info_1 = new JLabel("RESERVATION LIST");
      My_Info_1.setForeground(new Color(255, 255, 255));
      My_Info_1.setHorizontalAlignment(SwingConstants.CENTER);
      My_Info_1.setFont(new Font("����", Font.BOLD, 16));
      My_Info_1.setBounds(270, 10, 357, 40);
      add(My_Info_1);
      
    
      
      JButton NObtn = new JButton("���");
      NObtn.setForeground(Color.BLACK);
      NObtn.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		String rnum = renum.getText();
      		
      		try {
				dao2.reservnotcheck(rnum);
				JOptionPane.showMessageDialog(null, "������ ��ҵǾ����ϴ�!");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
      		
      		
      		///
      	}
      });
      NObtn.setFont(new Font("����", Font.BOLD, 15));
      NObtn.setBackground(UIManager.getColor("Button.background"));
      NObtn.setBounds(185, 428, 120, 45);
      add(NObtn);
      
      JButton DETAILbtn = new JButton("���೻��");
      DETAILbtn.setForeground(Color.BLACK);
      DETAILbtn.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		
      		////
      	test ts = new test(id);
      	ts.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      		
      	ts.setModal(true);
      	
      	ts.setVisible(true);
      		
      	}
      });
      DETAILbtn.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		
      		
      	}
      });
      DETAILbtn.setFont(new Font("����", Font.BOLD, 15));
      DETAILbtn.setBackground(UIManager.getColor("Button.background"));
      DETAILbtn.setBounds(335, 428, 120, 45);
      add(DETAILbtn);
      
      JButton MYREbtn = new JButton("���� ����");
      MYREbtn.setForeground(Color.BLACK);
      MYREbtn.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		
      		MyReview mr = new MyReview(id);
          	mr.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
          		
          	mr.setModal(true);
          	
          	mr.setVisible(true);
      	}
      });
      MYREbtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            //���⿡ ������������ �����
         }
      });
      MYREbtn.setFont(new Font("����", Font.BOLD, 15));
      MYREbtn.setBackground(UIManager.getColor("Button.background"));
      MYREbtn.setBounds(485, 428, 120, 45);
      add(MYREbtn);
      
 
      
      //������� UI
      
      model = new RecentListTableModel();
	  table	= new JTable( model );
      
      JPanel panel = new JPanel();
      panel.setBackground(new Color(0, 128, 128));
      panel.setBounds(195, 60, 432, 287);
      add("Center",panel);
      panel.setLayout(null);
      
      JScrollPane scrollPane = new JScrollPane( table );
      scrollPane.setBounds(12, 10, 408, 270);
      panel.add(scrollPane);
      
      renum = new JTextField();
      renum.setFont(new Font("����", Font.PLAIN, 13));
      renum.setBounds(98, 370, 106, 21);
      add(renum);
      renum.setColumns(10);
      
      
      
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
	            
	            String rnum = table.getValueAt(row, col).toString();   
	            renum.setText(rnum);
		
				
				
			}
		});	
		
		
		  JButton OKbtn = new JButton("Ȯ��");
		  OKbtn.setForeground(Color.BLACK);
	      OKbtn.addMouseListener(new MouseAdapter() {
	      	@Override
	      	public void mouseClicked(MouseEvent e) {
	      		String rnum = renum.getText();
	      		
	      		try {
					dao2.reservcheck(rnum);
					JOptionPane.showMessageDialog(null, "������ Ȯ���Ǿ����ϴ�!");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	      		
	      		
	      	}
	      });
	      OKbtn.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      	}
	      });
	      OKbtn.setBackground(UIManager.getColor("Button.background"));
	      OKbtn.setFont(new Font("����", Font.BOLD, 15));
	      OKbtn.setBounds(35, 428, 120, 45);
	      add(OKbtn);
	      
	      JLabel lblNewLabel = new JLabel("\uC120\uD0DD \uBC88\uD638 : ");
	      lblNewLabel.setForeground(Color.WHITE);
	      lblNewLabel.setFont(new Font("����", Font.BOLD, 14));
	      lblNewLabel.setBounds(12, 365, 97, 29);
	      add(lblNewLabel);
	      
	      JButton btnNewButton = new JButton("\uC0C8\uB85C\uACE0\uCE68");
	      btnNewButton.setFont(new Font("����", Font.BOLD, 13));
	      btnNewButton.addMouseListener(new MouseAdapter() {
	      	@Override
	      	public void mouseClicked(MouseEvent e) {
	      		
	      		try {
					selectTable();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	      	}
	      });
	      btnNewButton.setBounds(521, 369, 106, 25);
	      add(btnNewButton);
		

   }
   
   class RecentListTableModel extends AbstractTableModel { 
		  
		ArrayList data = new ArrayList();
		
		String [] columnNames = {"���� ��ȣ", "���� ����", "Ȯ�� ����", "�Խ���", "�����"};
		
		
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
				
				ArrayList list = dao2.MypageList(custnum);

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