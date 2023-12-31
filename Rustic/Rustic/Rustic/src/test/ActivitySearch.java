package test;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ActivitySearch extends JPanel {
	private JTextField SearchText;

	/**
	 * Create the panel.
	 */
	public ActivitySearch() {
		setBackground(new Color(0, 128, 128));
		setBounds(0,0,639, 498);
		setLayout(null);
		
		SearchText = new JTextField();
		SearchText.setBounds(41, 53, 455, 42);
		add(SearchText);
		SearchText.setColumns(10);
		
		JButton SEARCHbt = new JButton("검색");
		SEARCHbt.setFont(new Font("함초롬돋움", Font.BOLD, 14));
		SEARCHbt.setBounds(511, 53, 82, 42);
		add(SEARCHbt);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"가나다라", "가나다", "가나", "나", "가", "다", "라"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(42, 115, 551, 341);
		add(list);
		
		JLabel Search_acti = new JLabel("주변 놀 곳 검색하기");
		Search_acti.setHorizontalAlignment(SwingConstants.CENTER);
		Search_acti.setForeground(Color.WHITE);
		Search_acti.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		Search_acti.setBounds(41, 10, 246, 40);
		add(Search_acti);
		setVisible(true);
		
		
	}
}
