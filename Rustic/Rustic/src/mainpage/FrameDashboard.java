package mainpage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SignUp.FrameLogin;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class FrameDashboard extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	
	private Image img_logo = new ImageIcon(FrameDashboard.class.getResource("/res/logo.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
	//private Image img_home = new ImageIcon(FrameDashboard.class.getResource("/res/home.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	

	private MyPage panelmypage;
	private RoomSearch roomsearch;
	private BudongSearch budongsearch;
	private panelTotSearch paneltotsearch;

	/**
	 * Launch the application.
	 */
	
	//메인 삭제가능성 있음
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameDashboard frame = new FrameDashboard();
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
//	public FrameDashboard() {
//		
//	}
	public FrameDashboard(String id, int gubun) {

		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 980, 555);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(47, 79, 79));
		panel.setBounds(0, 0, 303, 555);
		contentPane.add(panel);
		panel.setLayout(null);
		
		paneltotsearch = new panelTotSearch(id);
		

		panelmypage = new MyPage(id, gubun);
		roomsearch = new RoomSearch(id);
		budongsearch = new BudongSearch(id);
		

		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon(img_logo));
		lblLogo.setBounds(0, 1, 303, 189);
		panel.add(lblLogo);
		
		JPanel Home = new JPanel();
		Home.addMouseListener(new PanelButtonMouseAdapter(Home) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(paneltotsearch);	
			}
		});

		
		Home.setBackground(new Color(47, 79, 79));
		Home.setBounds(0, 200, 303, 50);
		panel.add(Home);
		Home.setLayout(null);
		
		JLabel lblHome = new JLabel("\uD1B5\uD569\uAC80\uC0C9");
		lblHome.setFont(new Font("바탕", Font.BOLD, 15));
		lblHome.setForeground(new Color(255, 255, 255));
		lblHome.setBounds(80, 10, 210, 30);
		Home.add(lblHome);
		
		JPanel sukbak = new JPanel();
		sukbak.addMouseListener(new PanelButtonMouseAdapter(sukbak) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(roomsearch);	
			}
		});
		sukbak.setBackground(new Color(47, 79, 79));
		sukbak.setBounds(0, 250, 303, 50);
		panel.add(sukbak);
		sukbak.setLayout(null);
		
		JLabel lblOrders = new JLabel("\uC219\uBC15");


		lblOrders.setForeground(Color.WHITE);
		lblOrders.setFont(new Font("바탕", Font.BOLD, 15));
		lblOrders.setBounds(80, 10, 210, 30);
		sukbak.add(lblOrders);
		
		JPanel budong = new JPanel();
		budong.addMouseListener(new PanelButtonMouseAdapter(budong) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(budongsearch);	
			}
		});
		
		
		budong.addMouseListener(new PanelButtonMouseAdapter(budong));
		budong.setBackground(new Color(47, 79, 79));
		budong.setBounds(0, 300, 303, 50);
		panel.add(budong);
		budong.setLayout(null);
		
		
		JLabel lblCustomers = new JLabel("\uB9E4\uB9E4");
		lblCustomers.setForeground(Color.WHITE);
		lblCustomers.setFont(new Font("바탕", Font.BOLD, 15));
		lblCustomers.setBounds(80, 10, 210, 30);
		budong.add(lblCustomers);
		
		
		JPanel SignOut = new JPanel();
		SignOut.addMouseListener(new PanelButtonMouseAdapter(SignOut) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelmypage);	
			}
		});
		SignOut.setBackground(new Color(47, 79, 79));
		SignOut.setBounds(0, 349, 303, 50);
		panel.add(SignOut);
		SignOut.setLayout(null);
		
		JLabel lblSignOut = new JLabel("\uB9C8\uC774\uD398\uC774\uC9C0");
		lblSignOut.setForeground(Color.WHITE);
		lblSignOut.setFont(new Font("바탕", Font.BOLD, 15));
		lblSignOut.setBounds(80, 10, 210, 30);
		SignOut.add(lblSignOut);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(315, 10, 639, 498);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		//판넬등록

		panel_1.add(panelmypage);
		panel_1.add(paneltotsearch);
		panel_1.add(roomsearch);
		panel_1.add(budongsearch);
		
		panelmypage.setVisible(false);
	      paneltotsearch.setVisible(true);
	      roomsearch.setVisible(false);
	      budongsearch.setVisible(false);
		
		JLabel lblx = new JLabel("X");
		lblx.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "종료하시겠습니까?", "테스트문장", JOptionPane.YES_NO_OPTION)==0) {
					FrameDashboard.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblx.setForeground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblx.setForeground(Color.white);
			}
		
		});
		lblx.setHorizontalAlignment(SwingConstants.CENTER);
		lblx.setForeground(Color.WHITE);
		lblx.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblx.setBackground(Color.WHITE);
		lblx.setBounds(960, 0, 20, 20);
		contentPane.add(lblx);
		setLocationRelativeTo(null);	//창 중앙 생성 마지막에 써야만 되는듯
	}
	
	public void menuClicked(JPanel panel) {

		panelmypage.setVisible(false);
		paneltotsearch.setVisible(false);
		roomsearch.setVisible(false);
		budongsearch.setVisible(false);
		panel.setVisible(true);
	
		//MyReview frame = new MyReview();
		//frame.setUndecorated(true);
	//	frame.setVisible(true);
	//	dispose();
	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter{
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel= panel;
		}
		
		public void MouseEntered(MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
		}
		
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(47, 79, 79));
		}
		
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(60, 179, 113));
		}
		
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
		}
		
	}
}
