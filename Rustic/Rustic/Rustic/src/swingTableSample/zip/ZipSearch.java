package swingTableSample.zip;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import ownerWrite.FrameDashboard_owner;

import javax.swing.JTextField;
import javax.swing.JButton;

public class ZipSearch extends JFrame {

	private JPanel contentPane;
    private JTable table;
    private JComboBox sidoBox;
    private JComboBox gugunBox;
    private JComboBox dongBox;
   
    private Connection conn = null;
    private PreparedStatement pstmt = null;      
    private ResultSet rs = null;         
    private JScrollPane scrollPane;
    private JPanel panel;
    private JTextField tfDong;
    private JButton pbtn;
    private JLabel seqNum = null;
    /**
     * Launch the application.
     */
    /*	일단 주석처리함
    public static void main(String[] args) {    
    	
           EventQueue.invokeLater(new Runnable() {
                   public void run() {
                          try {
                        	  	  
                                ZipSearch frame = new ZipSearch();
                                frame.setVisible(true);
                          } catch (Exception e) {
                                  e.printStackTrace();
                          }
                   }
           });
    }
	*/
    /**
     * Create the frame.
     */
    public ZipSearch(String id, int gubun, int roomgubun) {
    	 
    		//eventproc();		//이벤트 리스너 등록

    		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           setBounds(100, 100, 628, 515);
           contentPane = new JPanel();
           contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
           setContentPane(contentPane);
           contentPane.setLayout(null);
 
           panel = new JPanel();
           panel.setBorder(new TitledBorder(null, "우편번호 검색", TitledBorder.LEADING, TitledBorder.TOP, null, null));
           panel.setBounds(6, 10, 594, 70);
           contentPane.add(panel);
           panel.setLayout(null);
          
           scrollPane = new JScrollPane();
           scrollPane.setBounds(12, 153, 588, 313);
           contentPane.add(scrollPane);
          
           table = new JTable();
           table.setModel(new DefaultTableModel(
                   new Object[][] {
                          {" ", " ", " ", " ", " ", " ", " ", " "},
                   },
                   new String[] {
                          "일련번호", "우편번호", "시도", "구.군", "동", "리", "빌딩", "번지"
                   }
           ) {
                   boolean[] columnEditables = new boolean[] {
                          false, false, false, false, false, false, false, false
                   };
                   public boolean isCellEditable(int row, int column) {
                          return columnEditables[column];
                   }
           });
          
           scrollPane.setViewportView(table);
           
           //리스트 클릭 이벤트
           table.addMouseListener(new MouseAdapter() {
    		
    		public void mouseClicked(MouseEvent e) {
    			
    			int row = table.getSelectedRow();
    			
    			int col=0; //컬은 뭘 선택해도 상관없어서 0으로 고정
    		
    			String vNum = table.getValueAt(row, col).toString();
    
    			ZipDto dto = new ZipDto();
    			ZipDao dao = new ZipDao();
    		
    			try {
    				dto=dao.findByNum(vNum);
    				//dto가 받아온값으로 문자 지정
    		        //seqNum.setText(String.valueOf(vNum));
    			
    				seqNum.setText(vNum);
    				sidoBox.setSelectedItem(dto.getSido());
    				gugunBox.setSelectedItem(dto.getGugun());
    				dongBox.setSelectedItem(dto.getDong());
    				
    			}catch (Exception ex) {
    				// TODO: handle exception
    				JOptionPane.showMessageDialog(null, "검색 실패 : " + ex.getMessage());
    			}
    		}
    		
		});
          
          
           //첫번째 combobox 생성
           sidoBox = new JComboBox();  
           sidoBox.setBounds(146, 40, 100, 20);
           panel.add(sidoBox);
           sidoBox.addItem("시.도 선택");
          
           displaySido();
           //시.도 콤보박스=============================================
           sidoBox.addItemListener(new ItemListener() {
                   public void itemStateChanged(ItemEvent e) {
           if(e.getStateChange()==ItemEvent.SELECTED)
                   selectSido(sidoBox.getSelectedItem().toString());
                         
                   }
           });
           sidoBox.setToolTipText("");
          
          
           JLabel label = new JLabel("시.도");
           label.setBounds(146, 14, 100, 20);
           panel.add(label);
           label.setHorizontalAlignment(SwingConstants.CENTER);
          
           //구.군 ComboBox=============================================
           gugunBox = new JComboBox();
           gugunBox.setBounds(258, 40, 100, 20);
           panel.add(gugunBox);
          
           JLabel label_1 = new JLabel("구.군");
           label_1.setBounds(258, 14, 100, 20);
           panel.add(label_1);
           label_1.setHorizontalAlignment(SwingConstants.CENTER);
          
           gugunBox.addItemListener(new ItemListener() {
                   public void itemStateChanged(ItemEvent e) {
                          if(e.getStateChange()==ItemEvent.SELECTED)
                                  selectGugun(sidoBox.getSelectedItem().toString() ,gugunBox.getSelectedItem().toString());
                   }
           });
          
           //동 ComboBox=============================================
           dongBox = new JComboBox();
           dongBox.setBounds(370, 40, 100, 20);
           panel.add(dongBox);
          
           JLabel label_2 = new JLabel("동");
           label_2.setBounds(370, 14, 100, 20);
           panel.add(label_2);
           label_2.setHorizontalAlignment(SwingConstants.CENTER);
           
           seqNum = new JLabel("");
           seqNum.setBounds(43, 43, 75, 15);
           panel.add(seqNum);
 
           dongBox.addItemListener(new ItemListener() {
               public void itemStateChanged(ItemEvent e) {
                      if(e.getStateChange()==ItemEvent.SELECTED)
                     
                      //table에 집어넣기 실행=====================================
                      selectDong(sidoBox.getSelectedItem().toString(), gugunBox.getSelectedItem().toString(), dongBox.getSelectedItem().toString());
               }             
       });
           
//           동이름 검색 패널
           JPanel panel_1 = new JPanel();
           panel_1.setBorder(new TitledBorder(null, "동이름 우편번호 검색", TitledBorder.LEADING, TitledBorder.TOP, null, null));
           panel_1.setBounds(6, 86, 594, 57);
           contentPane.add(panel_1);
           panel_1.setLayout(null);
           
           JLabel lblNewLabel = new JLabel("동이름");
           lblNewLabel.setBounds(181, 26, 36, 15);
           panel_1.add(lblNewLabel);
           
           tfDong = new JTextField(20);
           tfDong.setBounds(222, 23, 116, 21);
           panel_1.add(tfDong);
           tfDong.setColumns(10);
           
           JButton btnDongSearce = new JButton("\uAC80 \uC0C9");
           btnDongSearce.setBounds(343, 22, 81, 23);
           panel_1.add(btnDongSearce);
       
           pbtn = new JButton("주소 지정완료");
           pbtn.addMouseListener(new MouseAdapter() {
           	@Override
           	public void mouseClicked(MouseEvent e) {
           		//주소 지정완료 클릭시 seq값 반환
           		String vnum=seqNum.getText();
           		String sido = sidoBox.getSelectedItem().toString();
           		String gugun = gugunBox.getSelectedItem().toString();
           		String dong=dongBox.getSelectedItem().toString();
           		String tot = vnum + "," + sido + "," + gugun + "," + dong;
           	
				FrameDashboard_owner frame = new FrameDashboard_owner(id, gubun,tot);
				if(roomgubun==1) {
					frame.menuClicked_roomRent();
				}
				else if (roomgubun==2) {
					frame.menuClicked_room();
				}
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
				
           	}
           });
           pbtn.setBounds(470, 22, 112, 23);
           panel_1.add(pbtn);
           btnDongSearce.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				searchDong(tfDong.getText());
			}
		});
           setLocationRelativeTo(null);  
    }
    
   
    
//    동이름으로 검색하는 메소드 
    public void searchDong(String dongName){
    	//선언
        ZipDao controller = new ZipDao();
        //DB연결
        controller.connection();   
 
        //
        ArrayList<ZipDto> addressList = controller.searchKeyDong(dongName);

        Object[][] arrAdd = new Object[addressList.size()][8];
    
        for(int i = 0 ; i < addressList.size() ; i++){
                ZipDto zipcode = addressList.get(i);
                
                arrAdd[i][0] = zipcode.getSeq();
                arrAdd[i][1] = zipcode.getZipcode();
                arrAdd[i][2] = zipcode.getSido();
                arrAdd[i][3] = zipcode.getGugun();
                arrAdd[i][4] = zipcode.getDong();
                arrAdd[i][5] = zipcode.getRi();
                arrAdd[i][6] = zipcode.getBldg();
                arrAdd[i][7] = zipcode.getBunji();
               
                table.setModel(new ZipTableModel(arrAdd));
                
        }             
        //DB연결 해제
        controller.disconnection();
    }
    
    //프로그램 시작시 시.도 보여주기====================================================================
    public void displaySido(){
           //선언
           ZipDao controller = new ZipDao();
           //DB연결
           controller.connection();             
           //
           ArrayList<ZipDto> sidoList = controller.searchSido();
           for(int i = 0 ; i < sidoList.size() ; i++){
                   ZipDto zipcode = sidoList.get(i);
                   sidoBox.addItem(zipcode.getSido());
           }             
           //DB연결 해제
           controller.disconnection();
    }
    //sido 선택(gugun 출력)====================================================================
    public void selectSido(String sido){
           System.out.println(sido);
           ZipDao controller = new ZipDao();
           //DB연결
           controller.connection();             
           //
           ArrayList<ZipDto> gugunList = controller.searchGugun(sido);
           gugunBox.removeAllItems();
           dongBox.removeAllItems();
           gugunBox.addItem("구.군 선택");
           for(int i = 0 ; i < gugunList.size() ; i++){
                   ZipDto zipcode = gugunList.get(i);
                   gugunBox.insertItemAt(zipcode.getGugun(), i);
           }
           table.setModel(new ZipTableModel());
           //DB연결 해제
           controller.disconnection();
    }      
    //gugun 선택(dong 출력)====================================================================
    public void selectGugun(String sido, String gugun){
           System.out.println(gugun);
           ZipDao controller = new ZipDao();
           //DB연결
           controller.connection();             
           //
           ArrayList<ZipDto> dongList = controller.searchDong(sido, gugun);
           dongBox.removeAllItems();
           dongBox.addItem("동 선택");
           for(int i = 0 ; i < dongList.size() ; i++){
                   ZipDto zipcode = dongList.get(i);
                   dongBox.insertItemAt(zipcode.getDong(),i);
           }
           table.setModel(new ZipTableModel());
           //DB연결 해제
           controller.disconnection();                 
    }
   
    //마지막 Dong 선택(테이블에 출력)====================================================================
    public void selectDong(String sido, String gugun, String dong){
          System.out.println("Selected Dong : " + dong);
           ZipDao controller = new ZipDao();
           //DB연결
           controller.connection();             
           //
           ArrayList<ZipDto> addressList = controller.searchAddress(sido, gugun, dong);
     
           Object[][] arrAdd = new Object[addressList.size()][8];
          
           for(int i = 0 ; i < addressList.size() ; i++){
                   ZipDto zipcode = addressList.get(i);
                   //출력!
                   System.out.println(zipcode.getSeq() + " " + zipcode.getZipcode()+ " " +zipcode.getSido()+ " " +zipcode.getGugun()+ " " +zipcode.getDong() + " " + zipcode.getRi() + " " + zipcode.getBldg() + " " + zipcode.getBunji());                      
                   //테이블에 넣기!
                   arrAdd[i][0] = zipcode.getSeq();
                   arrAdd[i][1] = zipcode.getZipcode();
                   arrAdd[i][2] = zipcode.getSido();
                   arrAdd[i][3] = zipcode.getGugun();
                   arrAdd[i][4] = zipcode.getDong();
                   arrAdd[i][5] = zipcode.getRi();
                   arrAdd[i][6] = zipcode.getBldg();
                   arrAdd[i][7] = zipcode.getBunji();
             
                   table.setModel(new ZipTableModel(arrAdd));
                   System.out.println("table Setting ");
                   
           }
           //DB연결 해제
           controller.disconnection();
          
    }
    
   
    //리스트 클릭 이벤트
    public void eventproc() {
    	

    	
    }
}
