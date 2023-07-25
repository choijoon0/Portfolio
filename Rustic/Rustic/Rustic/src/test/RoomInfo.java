package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class RoomInfo extends JFrame {

	private JPanel contentPane;
	private JTable PHOTOtb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomInfo frame = new RoomInfo();
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
	public RoomInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 937, 541);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("TITLE");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTitle.setBounds(28, 27, 54, 38);
		contentPane.add(lblTitle);
		
		JTextPane Tx_Title = new JTextPane();
		Tx_Title.setBounds(90, 27, 250, 38);
		contentPane.add(Tx_Title);
		
		JLabel lblPhoto = new JLabel("PHOTO");
		lblPhoto.setForeground(Color.WHITE);
		lblPhoto.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPhoto.setBounds(28, 75, 94, 38);
		contentPane.add(lblPhoto);
		
		PHOTOtb = new JTable();
		PHOTOtb.setBounds(28, 121, 428, 268);
		contentPane.add(PHOTOtb);
		
		JLabel lblContent = new JLabel("CONTENT");
		lblContent.setForeground(Color.WHITE);
		lblContent.setFont(new Font("Dialog", Font.BOLD, 14));
		lblContent.setBounds(492, 27, 94, 38);
		contentPane.add(lblContent);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(491, 73, 386, 139);
		contentPane.add(textPane);
		
		JLabel lblRoomInfo = new JLabel("ACTIVITY");
		lblRoomInfo.setForeground(Color.WHITE);
		lblRoomInfo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblRoomInfo.setBounds(492, 222, 94, 38);
		contentPane.add(lblRoomInfo);
		
		JTextPane Tx_Activity = new JTextPane();
		Tx_Activity.setBounds(490, 259, 387, 38);
		contentPane.add(Tx_Activity);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAddress.setBounds(492, 307, 94, 38);
		contentPane.add(lblAddress);
		
		JTextPane Tx_Address = new JTextPane();
		Tx_Address.setBounds(490, 343, 387, 38);
		contentPane.add(Tx_Address);
		
		JButton btnReview = new JButton("리뷰보기");
		btnReview.setFont(new Font("함초롬돋움", Font.BOLD, 14));
		btnReview.setBounds(31, 416, 188, 55);
		contentPane.add(btnReview);
		
		JButton btnReservation = new JButton("예약");
		btnReservation.setFont(new Font("함초롬돋움", Font.BOLD, 14));
		btnReservation.setBounds(268, 416, 188, 55);
		contentPane.add(btnReservation);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Dialog", Font.BOLD, 14));
		btnBack.setBounds(723, 416, 188, 55);
		contentPane.add(btnBack);
	}
}
