package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JDialogMainEx01 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JDialogMainEx01 frame = new JDialogMainEx01();
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
	public JDialogMainEx01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// �����ڷ� ������ ����
				JDialogEx01 dialog = new JDialogEx01("�ʱ� ������");
				//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); �� ��
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				
				System.out.println("1");
				dialog.setModal(true);
				System.out.println("2");
				// ȭ�鿡�� ��� �ڽ�â�� ����
				// setter, getter�� ������ ����
				dialog.setShareData("���� ������");
				dialog.printShareData();
				
				// ���⿡ ������ ���°� ����. 
				dialog.setVisible(true);
				// �׷��� ���� �������� �Ʒ� �� �����Ͱ� �ٸ��� ����.
				
				// �θ�â���� ���� /  �ڽ�â ������ �θ�â���� �����
				System.out.println("3");
				System.out.println(dialog.getShareData());
			}
		});
		btnNewButton.setBounds(14, 12, 105, 27);
		contentPane.add(btnNewButton);
	}

}