package mainpage;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dao.MenuDAO;
import dao.resDAO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
public class ReviewFrame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField reviewcontent;
	private JTextField startext;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			ReviewFrame dialog = new ReviewFrame();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	/**
	 * Create the dialog.
	 */
	public ReviewFrame(int renum) {
		setBounds(100, 100, 531, 377);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(new Color(255, 255, 255));
		contentPanel.setBackground(new Color(0, 128, 128));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		reviewcontent = new JTextField();
		reviewcontent.setFont(new Font("바탕", Font.PLAIN, 12));
		reviewcontent.setBounds(26, 165, 468, 125);
		contentPanel.add(reviewcontent);
		reviewcontent.setColumns(10);
	
	
		JLabel lblNewLabel = new JLabel("\uB0B4\uC6A9 \uC785\uB825");
		lblNewLabel.setFont(new Font("바탕", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(26, 124, 70, 24);
		contentPanel.add(lblNewLabel);
	
	
		JButton btnNewButton = new JButton("\uC791\uC131 \uD558\uAE30");
		btnNewButton.setFont(new Font("바탕", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnNewButton.setBounds(399, 300, 95, 23);
		contentPanel.add(btnNewButton);
	
	
		JLabel lblNewLabel_1 = new JLabel("\uBC29 \uC774\uB984");
		lblNewLabel_1.setFont(new Font("바탕", Font.BOLD, 13));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(26, 24, 52, 15);
		contentPanel.add(lblNewLabel_1);
	
	
		JLabel lblNewLabel_2 = new JLabel("\uC785\uC2E4\uC77C");
		lblNewLabel_2.setFont(new Font("바탕", Font.BOLD, 13));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(26, 74, 52, 15);
		contentPanel.add(lblNewLabel_2);
	
	
		JLabel lblNewLabel_3 = new JLabel("\uD1F4\uC2E4\uC77C");
		lblNewLabel_3.setFont(new Font("바탕", Font.BOLD, 13));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(26, 99, 52, 15);
		contentPanel.add(lblNewLabel_3);
	
	
		JLabel lblNewLabel_4 = new JLabel("\uC8FC\uC18C");
		lblNewLabel_4.setFont(new Font("바탕", Font.BOLD, 13));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(26, 49, 52, 15);
		contentPanel.add(lblNewLabel_4);

	
		JLabel roomnameLable = new JLabel("New label");
		roomnameLable.setFont(new Font("바탕", Font.PLAIN, 12));
		roomnameLable.setForeground(new Color(255, 255, 255));
		roomnameLable.setBounds(90, 24, 219, 15);
		contentPanel.add(roomnameLable);
	
	
		JLabel addrLabel = new JLabel("New label");
		addrLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		addrLabel.setForeground(new Color(255, 255, 255));
		addrLabel.setBounds(79, 49, 161, 15);
		contentPanel.add(addrLabel);
	
	
		JLabel detailLabel = new JLabel("New label");
		detailLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		detailLabel.setForeground(new Color(255, 255, 255));
		detailLabel.setBounds(217, 49, 129, 15);
		contentPanel.add(detailLabel);
	
	
		JLabel indateLabel = new JLabel("New label");
		indateLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		indateLabel.setForeground(new Color(255, 255, 255));
		indateLabel.setBounds(79, 74, 128, 15);
		contentPanel.add(indateLabel);
	
	
		JLabel outdateLabel = new JLabel("New label");
		outdateLabel.setFont(new Font("바탕", Font.PLAIN, 12));
		outdateLabel.setForeground(new Color(255, 255, 255));
		outdateLabel.setBounds(79, 99, 128, 15);
		contentPanel.add(outdateLabel);
		
		


		MenuDAO mdao = MenuDAO.getInstance();
		int mnum= mdao.getMenuNum(renum);	//예약번호를 통해 메뉴넘버 반환
		
		
		//메뉴넘버를 넘겨서 mlist에 다른 값을 전부 가져옴
		ArrayList mlist = mdao.select_All(mnum);
		roomnameLable.setText(mlist.get(0).toString());
		addrLabel.setText(mlist.get(1).toString());
		detailLabel.setText(mlist.get(2).toString());
		
		//리뷰넘버를 통해 체크인,체크아웃 시간 리턴
		resDAO rdao = resDAO.getInstance();
		ArrayList rlist = rdao.getCheck(renum);
		indateLabel.setText(rlist.get(0).toString());
		outdateLabel.setText(rlist.get(1).toString());
		
		startext = new JTextField();
		startext.setFont(new Font("바탕", Font.PLAIN, 12));
		startext.setBounds(319, 126, 116, 21);
		contentPanel.add(startext);
		startext.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\uBCC4\uC810(1~5)");
		lblNewLabel_5.setFont(new Font("바탕", Font.BOLD, 13));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(237, 129, 70, 15);
		contentPanel.add(lblNewLabel_5);
		setLocationRelativeTo(null);
		
		//리뷰 들어가자, 작성하기 버튼 클릭시 
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String retext = reviewcontent.getText();
				int star = Integer.parseInt(startext.getText());
				try {
					
					mdao.insert_MenuReview(renum, retext, star);
					JOptionPane.showMessageDialog(null, "리뷰 작성 완료");
					dispose();
					
					
					
				} catch (Exception er) {
					// TODO Auto-generated catch block
					er.printStackTrace();
				}
				
			}
		});

	}
}
