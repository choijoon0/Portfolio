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
import javax.swing.JList;
import javax.swing.JButton;

public class ActivityShowRe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActivityShowRe frame = new ActivityShowRe();
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
	public ActivityShowRe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 937, 541);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGogekInfo = new JLabel("// ∞Ì∞¥ ¡§∫∏ 1");
		lblGogekInfo.setForeground(new Color(255, 255, 255));
		lblGogekInfo.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 12));
		lblGogekInfo.setBounds(27, 72, 100, 39);
		contentPane.add(lblGogekInfo);
		
		JLabel lblGogekInfo2 = new JLabel("// ∞Ì∞¥ ¡§∫∏ 2");
		lblGogekInfo2.setForeground(Color.WHITE);
		lblGogekInfo2.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 12));
		lblGogekInfo2.setBounds(27, 152, 100, 39);
		contentPane.add(lblGogekInfo2);
		
		JLabel lblGogekInfo3 = new JLabel("// ∞Ì∞¥ ¡§∫∏ 3");
		lblGogekInfo3.setForeground(Color.WHITE);
		lblGogekInfo3.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 12));
		lblGogekInfo3.setBounds(27, 232, 100, 39);
		contentPane.add(lblGogekInfo3);
		
		JLabel lblGogekInfo4 = new JLabel("// ∞Ì∞¥ ¡§∫∏ 4");
		lblGogekInfo4.setForeground(Color.WHITE);
		lblGogekInfo4.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 12));
		lblGogekInfo4.setBounds(27, 312, 100, 39);
		contentPane.add(lblGogekInfo4);
		
		JLabel lblGogekInfo5 = new JLabel("// ∞Ì∞¥ ¡§∫∏ 5");
		lblGogekInfo5.setForeground(Color.WHITE);
		lblGogekInfo5.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 12));
		lblGogekInfo5.setBounds(27, 392, 100, 39);
		contentPane.add(lblGogekInfo5);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(27, 105, 352, 37);
		contentPane.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(27, 185, 352, 37);
		contentPane.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(27, 265, 352, 37);
		contentPane.add(textPane_2);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(27, 345, 352, 37);
		contentPane.add(textPane_3);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setBounds(27, 425, 352, 37);
		contentPane.add(textPane_4);
		
		JLabel lblNewLabel = new JLabel("PHOTO");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(447, 38, 148, 37);
		contentPane.add(lblNewLabel);
		
		JList list = new JList();
		list.setBounds(447, 85, 432, 318);
		contentPane.add(list);
		
		JButton BACKbtn = new JButton("BACK");
		BACKbtn.setFont(new Font("Dialog", Font.BOLD, 14));
		BACKbtn.setBackground(new Color(0, 128, 128));
		BACKbtn.setBounds(776, 429, 100, 44);
		contentPane.add(BACKbtn);
		
		JLabel lblActivityShowRe = new JLabel("°ﬁ ¡÷∫Ø ≥Ó ∞˜ ∏Æ∫‰∫∏±‚");
		lblActivityShowRe.setForeground(Color.WHITE);
		lblActivityShowRe.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 15));
		lblActivityShowRe.setBounds(27, 24, 298, 38);
		contentPane.add(lblActivityShowRe);
	}

}
