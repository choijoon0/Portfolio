package mainpage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JCalendar;

import test.JDialogEx01;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.VetoableChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.beans.PropertyChangeEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class clenderView  extends JDialog {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clenderView  frame = new clenderView ();
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
	private String result=null;

	public clenderView () {
	
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

		JButton pdate = new JButton("��¥ ���� �Ϸ�");
		pdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			//	System.out.println(	calendar.getDate().getYear()+1900);

				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				result = df.format(calendar.getDate());
				//System.out.println(result);
				clenderView.this.dispose();
	
			}
		});
		pdate.setBounds(280, 213, 127, 23);
		contentPane.add(pdate);
		
	}
	public String getCals() {
		return result;
	}
}
