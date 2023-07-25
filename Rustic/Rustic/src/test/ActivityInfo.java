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

public class ActivityInfo extends JFrame {

	private JPanel contentPane;
	private JTable PHOTOtb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActivityInfo frame = new ActivityInfo();
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
	public ActivityInfo() {
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
		lblTitle.setBounds(28, 71, 54, 38);
		contentPane.add(lblTitle);
		
		JTextPane Tx_Title = new JTextPane();
		Tx_Title.setBounds(90, 71, 250, 38);
		contentPane.add(Tx_Title);
		
		JLabel lblPhoto = new JLabel("PHOTO");
		lblPhoto.setForeground(Color.WHITE);
		lblPhoto.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPhoto.setBounds(28, 119, 94, 38);
		contentPane.add(lblPhoto);
		
		PHOTOtb = new JTable();
		PHOTOtb.setBounds(28, 165, 428, 268);
		contentPane.add(PHOTOtb);
		
		JLabel lblContent = new JLabel("CONTENT");
		lblContent.setForeground(Color.WHITE);
		lblContent.setFont(new Font("Dialog", Font.BOLD, 14));
		lblContent.setBounds(492, 51, 94, 38);
		contentPane.add(lblContent);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(491, 97, 386, 139);
		contentPane.add(textPane);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAddress.setBounds(492, 267, 94, 38);
		contentPane.add(lblAddress);
		
		JTextPane Tx_Address = new JTextPane();
		Tx_Address.setBounds(490, 303, 387, 38);
		contentPane.add(Tx_Address);
		
		JButton btnReview = new JButton("∏Æ∫‰∫∏±‚");
		btnReview.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 14));
		btnReview.setBounds(500, 415, 188, 55);
		contentPane.add(btnReview);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Dialog", Font.BOLD, 14));
		btnBack.setBounds(723, 416, 188, 55);
		contentPane.add(btnBack);
		
		JLabel lblActivityInfo = new JLabel("°ﬁ ¡÷∫Ø ≥Ó ∞˜ ¡§∫∏");
		lblActivityInfo.setForeground(Color.WHITE);
		lblActivityInfo.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 15));
		lblActivityInfo.setBounds(28, 10, 298, 38);
		contentPane.add(lblActivityInfo);
	}
}
