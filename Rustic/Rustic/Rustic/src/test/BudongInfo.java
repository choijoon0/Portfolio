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

public class BudongInfo extends JFrame {

	private JPanel contentPane;
	private JTable PHOTOtb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BudongInfo frame = new BudongInfo();
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
	public BudongInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 937, 541);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPrice.setBounds(27, 89, 54, 38);
		contentPane.add(lblPrice);
		
		JTextPane Tx_Title = new JTextPane();
		Tx_Title.setText(" // ������ | ���� | ����");
		Tx_Title.setBounds(89, 89, 250, 38);
		contentPane.add(Tx_Title);
		
		JLabel lblPhoto = new JLabel("PHOTO");
		lblPhoto.setForeground(Color.WHITE);
		lblPhoto.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPhoto.setBounds(27, 137, 94, 38);
		contentPane.add(lblPhoto);
		
		PHOTOtb = new JTable();
		PHOTOtb.setBounds(27, 183, 428, 268);
		contentPane.add(PHOTOtb);
		
		JLabel lblContent = new JLabel("CONTENT");
		lblContent.setForeground(Color.WHITE);
		lblContent.setFont(new Font("Dialog", Font.BOLD, 14));
		lblContent.setBounds(492, 27, 94, 38);
		contentPane.add(lblContent);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(492, 61, 386, 38);
		contentPane.add(textPane);
		
		JLabel lblRoomInfo = new JLabel("ACTIVITY");
		lblRoomInfo.setForeground(Color.WHITE);
		lblRoomInfo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblRoomInfo.setBounds(494, 109, 94, 38);
		contentPane.add(lblRoomInfo);
		
		JTextPane Tx_Activity = new JTextPane();
		Tx_Activity.setText(" // �� ���� | ��� | ȭ��� ����");
		Tx_Activity.setBounds(492, 143, 387, 38);
		contentPane.add(Tx_Activity);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAddress.setBounds(494, 239, 94, 38);
		contentPane.add(lblAddress);
		
		JTextPane Tx_Address = new JTextPane();
		Tx_Address.setBounds(492, 275, 387, 38);
		contentPane.add(Tx_Address);
		
		JButton btnReview = new JButton("���亸��");
		btnReview.setFont(new Font("���ʷҵ���", Font.BOLD, 14));
		btnReview.setBounds(492, 415, 188, 55);
		contentPane.add(btnReview);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Dialog", Font.BOLD, 14));
		btnBack.setBounds(723, 416, 188, 55);
		contentPane.add(btnBack);
		
		JLabel lblCount = new JLabel("�ִ� ���� ������ �ο� ��");
		lblCount.setForeground(Color.WHITE);
		lblCount.setFont(new Font("���ʷҵ���", Font.BOLD, 14));
		lblCount.setBounds(492, 191, 188, 38);
		contentPane.add(lblCount);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(762, 191, 64, 38);
		contentPane.add(textPane_1);
		
		JLabel lblCount_1 = new JLabel("��");
		lblCount_1.setForeground(Color.WHITE);
		lblCount_1.setFont(new Font("���ʷҵ���", Font.BOLD, 14));
		lblCount_1.setBounds(838, 191, 54, 38);
		contentPane.add(lblCount_1);
		
		JLabel lblOwnerPhone = new JLabel("������ ����ó");
		lblOwnerPhone.setForeground(Color.WHITE);
		lblOwnerPhone.setFont(new Font("���ʷҵ���", Font.BOLD, 14));
		lblOwnerPhone.setBounds(491, 323, 188, 38);
		contentPane.add(lblOwnerPhone);
		
		JTextPane Tx_OwnerPhone = new JTextPane();
		Tx_OwnerPhone.setBounds(492, 357, 387, 38);
		contentPane.add(Tx_OwnerPhone);
		
		JLabel lblBudongInfo = new JLabel("�� �ε���(������) ����");
		lblBudongInfo.setForeground(Color.WHITE);
		lblBudongInfo.setFont(new Font("���ʷҵ���", Font.BOLD, 15));
		lblBudongInfo.setBounds(27, 27, 298, 38);
		contentPane.add(lblBudongInfo);
	}
}
