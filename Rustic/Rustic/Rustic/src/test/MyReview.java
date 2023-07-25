package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class MyReview extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyReview frame = new MyReview();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	
	
	public MyReview() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 937, 541);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox_Cate = new JComboBox();
		comboBox_Cate.setBackground(new Color(255, 255, 255));
		comboBox_Cate.setFont(new Font("함초롬돋움", Font.BOLD, 14));
		comboBox_Cate.setModel(new DefaultComboBoxModel(new String[] {"숙박", "부동산", "주변 놀 곳"}));
		comboBox_Cate.setBounds(164, 27, 248, 38);
		contentPane.add(comboBox_Cate);
		
		JLabel Category = new JLabel("이용 카테고리");
		Category.setHorizontalAlignment(SwingConstants.CENTER);
		Category.setFont(new Font("함초롬돋움", Font.BOLD, 14));
		Category.setForeground(new Color(255, 255, 255));
		Category.setBounds(32, 27, 120, 38);
		contentPane.add(Category);
		
		JButton BACKbtn = new JButton("BACK");
		BACKbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyPage();
				setVisible(true);
			}
		});
		BACKbtn.setBackground(new Color(0, 128, 128));
		BACKbtn.setFont(new Font("Dialog", Font.BOLD, 14));
		BACKbtn.setBounds(759, 427, 120, 54);
		contentPane.add(BACKbtn);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"\uB0A0\uC9DC", "\uC774\uC6A9\uD55C \uACF3", "\uAE00"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBounds(40, 86, 839, 331);
		contentPane.add(table);
	}
}
