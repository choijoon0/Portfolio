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

public class RoomSearch extends JPanel {
	private JTextField SearchText;

	/**
	 * Create the panel.
	 */
	public RoomSearch() {
		setBackground(new Color(0, 128, 128));
		setBounds(0,0,639, 498);
		setLayout(null);
		
		SearchText = new JTextField();
		SearchText.setBounds(41, 53, 455, 42);
		add(SearchText);
		SearchText.setColumns(10);
		
		JButton SEARCHbt = new JButton("�˻�");
		SEARCHbt.setFont(new Font("���ʷҵ���", Font.BOLD, 14));
		SEARCHbt.setBounds(511, 53, 82, 42);
		add(SEARCHbt);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"�����ٶ�", "������", "����", "��", "��", "��", "��"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(42, 115, 551, 341);
		add(list);
		
		JLabel Search_room = new JLabel("���� �˻��ϱ�");
		Search_room.setHorizontalAlignment(SwingConstants.CENTER);
		Search_room.setForeground(Color.WHITE);
		Search_room.setFont(new Font("���ʷҵ���", Font.BOLD, 15));
		Search_room.setBounds(41, 10, 246, 40);
		add(Search_room);
		setVisible(true);
		
		
	}
}
