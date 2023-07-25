package mainpage;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class ReviewFrame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField reviewcontent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReviewFrame dialog = new ReviewFrame();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReviewFrame() {
		setBounds(100, 100, 830, 558);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			reviewcontent = new JTextField();
			reviewcontent.setBounds(26, 271, 468, 227);
			contentPanel.add(reviewcontent);
			reviewcontent.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("\uB0B4\uC6A9 \uC785\uB825");
			lblNewLabel.setBounds(26, 237, 52, 24);
			contentPanel.add(lblNewLabel);
		}
		{
			JButton btnNewButton = new JButton("\uC791\uC131 \uD558\uAE30");
			btnNewButton.setBounds(664, 470, 95, 23);
			contentPanel.add(btnNewButton);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("\uBC29 \uC774\uB984");
			lblNewLabel_1.setBounds(26, 24, 52, 15);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("\uC785\uC2E4\uC77C");
			lblNewLabel_2.setBounds(26, 145, 52, 15);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("\uD1F4\uC2E4\uC77C");
			lblNewLabel_3.setBounds(26, 184, 52, 15);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("\uC8FC\uC18C");
			lblNewLabel_4.setBounds(26, 92, 52, 15);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel roomnameLable = new JLabel("New label");
			roomnameLable.setBounds(90, 24, 52, 15);
			contentPanel.add(roomnameLable);
		}
		{
			JLabel addrLabel = new JLabel("New label");
			addrLabel.setBounds(79, 92, 52, 15);
			contentPanel.add(addrLabel);
		}
		{
			JLabel detailLabel = new JLabel("New label");
			detailLabel.setBounds(198, 92, 52, 15);
			contentPanel.add(detailLabel);
		}
		{
			JLabel indateLabel = new JLabel("New label");
			indateLabel.setBounds(133, 145, 52, 15);
			contentPanel.add(indateLabel);
		}
		{
			JLabel outdateLabel = new JLabel("New label");
			outdateLabel.setBounds(112, 184, 52, 15);
			contentPanel.add(outdateLabel);
		}
	}

}
