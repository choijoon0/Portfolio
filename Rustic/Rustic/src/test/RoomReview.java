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
import java.io.File;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.JList;

public class RoomReview extends JFrame {
	

	private JPanel contentPane;
	private JTextField WRITEtx;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomReview frame = new RoomReview();
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
	public RoomReview() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 937, 541);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("TITLE");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTitle.setBounds(37, 73, 54, 38);
		contentPane.add(lblTitle);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setForeground(new Color(255, 255, 255));
		lblDate.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDate.setBounds(37, 127, 54, 38);
		contentPane.add(lblDate);
		
		JLabel lblDetail = new JLabel("DETAIL");
		lblDetail.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetail.setForeground(Color.WHITE);
		lblDetail.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDetail.setBounds(37, 182, 157, 38);
		contentPane.add(lblDetail);
		
		JButton BACKbtn = new JButton("BACK");
		BACKbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyPage();
				setVisible(true);
			}
		});
		BACKbtn.setBackground(new Color(0, 128, 128));
		BACKbtn.setFont(new Font("Dialog", Font.BOLD, 14));
		BACKbtn.setBounds(779, 437, 100, 44);
		contentPane.add(BACKbtn);
		
		JTextPane Tx_Title = new JTextPane();
		Tx_Title.setBounds(99, 73, 250, 38);
		contentPane.add(Tx_Title);
		
		JTextPane Tx_Date = new JTextPane();
		Tx_Date.setBounds(99, 127, 203, 38);
		contentPane.add(Tx_Date);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(312, 121, 37, 44);
		contentPane.add(dateChooser);
		
		JLabel lblPhoto = new JLabel("PHOTO");
		lblPhoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoto.setForeground(Color.WHITE);
		lblPhoto.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPhoto.setBounds(469, 50, 157, 38);
		contentPane.add(lblPhoto);
		
		WRITEtx = new JTextField();
		WRITEtx.setBounds(40, 218, 359, 263);
		contentPane.add(WRITEtx);
		WRITEtx.setColumns(10);
		
		JList<File> list = new JList();
		list.setBounds(469, 88, 410, 339);
		contentPane.add(list);
		
		JLabel lblRoomReview = new JLabel("¡Þ ¼÷¹Ú ¸®ºäÀÛ¼ºÇÏ±â");
		lblRoomReview.setForeground(Color.WHITE);
		lblRoomReview.setFont(new Font("ÇÔÃÊ·Òµ¸¿ò", Font.BOLD, 15));
		lblRoomReview.setBounds(37, 10, 298, 38);
		contentPane.add(lblRoomReview);
		
		JButton btnWrite = new JButton("WRITE");
		btnWrite.setFont(new Font("Dialog", Font.BOLD, 14));
		btnWrite.setBackground(new Color(0, 128, 128));
		btnWrite.setBounds(665, 437, 100, 44);
		contentPane.add(btnWrite);
	}
}
