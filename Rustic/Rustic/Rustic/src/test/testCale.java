package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JCalendar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.VetoableChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.beans.PropertyChangeEvent;
import javax.swing.JButton;

public class testCale extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testCale frame = new testCale();
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
	public testCale() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 410, 190);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(12, 5, 398, 175);
		panel.add(calendar);

		JButton pdate = new JButton("\uB0A0\uC9DC \uC120\uD0DD \uC644\uB8CC");
		pdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			//	System.out.println(	calendar.getDate().getYear()+1900);

				DateFormat df = new SimpleDateFormat("yyyy³â MM¿ù ddÀÏ");
				String result = df.format(calendar.getDate());
				System.out.println(result);
			
	
			}
		});
		pdate.setBounds(280, 213, 127, 23);
		contentPane.add(pdate);
		
	
		
		
	}
}
