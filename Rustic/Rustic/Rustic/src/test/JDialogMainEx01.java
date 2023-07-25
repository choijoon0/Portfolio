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
				// 생성자로 데이터 전달
				JDialogEx01 dialog = new JDialogEx01("초기 데이터");
				//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 랑 비교
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				
				System.out.println("1");
				dialog.setModal(true);
				System.out.println("2");
				// 화면에의 제어를 자식창에 위임
				// setter, getter로 데이터 전달
				dialog.setShareData("변경 데이터");
				dialog.printShareData();
				
				// 여기에 정지된 상태가 들어간다. 
				dialog.setVisible(true);
				// 그래서 여길 기점으로 아래 위 데이터가 다른게 들어간다.
				
				// 부모창으로 변경 /  자식창 닫으면 부모창으로 변경됨
				System.out.println("3");
				System.out.println(dialog.getShareData());
			}
		});
		btnNewButton.setBounds(14, 12, 105, 27);
		contentPane.add(btnNewButton);
	}

}