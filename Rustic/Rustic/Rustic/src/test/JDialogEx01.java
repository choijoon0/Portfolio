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
	// ������
	private String shareData;
	
	// setter�� getter�� ������ ����
	public void setShareData(String shareData) {
		this.shareData = shareData;
	}
	
	public String getShareData() {
		return shareData;
	}
	
	// setter, getter ������ �θ��� �޼���
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
						// â�ݱ�
						JDialogEx01.this.setShareData("�Ϸ�� ������");
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
						// â�ݱ�
						// this.dispose()�ϸ� �ȵ� ���⼭ this�� MouseEvent�̴�.
						JDialogEx01.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	// �����ڷ� ������ ����
	// ������ �����ε� / JDialogEx01() �ȿ� �ᵵ��
	public JDialogEx01(String shareData) {
		this();
		this.shareData = shareData;
		 
		System.out.println("shareData : " + shareData);
	}

}