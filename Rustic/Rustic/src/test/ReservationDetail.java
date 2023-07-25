package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JButton;

public class ReservationDetail extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationDetail frame = new ReservationDetail();
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
	public ReservationDetail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 555);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"\uC774\uC6A9 \uCE74\uD14C\uACE0\uB9AC", "\uB0A0\uC9DC", "\uC774\uC6A9\uD55C \uACF3", "\uAC00\uACA9", "\uB9AC\uBDF0"},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"\uC774\uC6A9 \uCE74\uD14C\uACE0\uB9AC", "\uB0A0\uC9DC", "\uC774\uC6A9\uD55C \uACF3", "\uAC00\uACA9", "\uB9AC\uBDF0"
			}
		));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.setBounds(38, 33, 876, 387);
		contentPane.add(table);
		
		JButton btnBACK = new JButton("BACK");
		btnBACK.setFont(new Font("Dialog", Font.BOLD, 14));
		btnBACK.setBounds(781, 438, 133, 46);
		contentPane.add(btnBACK);
	}

}
