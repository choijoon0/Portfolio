package test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JDialogEx01 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	// 데이터
	private String shareData;
	
	// setter랑 getter로 데이터 전달
	public void setShareData(String shareData) {
		this.shareData = shareData;
	}
	
	public String getShareData() {
		return shareData;
	}
	
	// setter, getter 데이터 부르는 메서드
	public void printShareData() {
		System.out.println(this.shareData);
	}

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			JDialogEx01 dialog = new JDialogEx01();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public JDialogEx01() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// 창닫기
						JDialogEx01.this.setShareData("완료된 데이터");
						JDialogEx01.this.dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// 창닫기
						// this.dispose()하면 안됨 여기서 this는 MouseEvent이다.
						JDialogEx01.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	// 생성자로 데이터 전달
	// 생성자 오버로딩 / JDialogEx01() 안에 써도됨
	public JDialogEx01(String shareData) {
		this();
		this.shareData = shareData;
		 
		System.out.println("shareData : " + shareData);
	}

}