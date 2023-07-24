package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import model.AddGoodsDAO;
import model.rec.AddGoodsVO;

public class AddGoodsView extends JFrame implements ActionListener {
	JPanel contentPane, pGoodsList;
	JTextField tfBthName, tfGoodsName, tfJungPrice, tfOnePrice, tfGoodsCnt, tfAddImg;
	JLabel lblBthName, lblGoodsCt, lblGoodsGD, lblGoodsName, lblJungPrice, lblOnePrice, lbGoodsCnt, lblAddImg, lblImg;
	JComboBox comGT, comGD;
	JButton btnAddGoods, btnModGoods, btnDelGoods, btnAddImg,btnClose;
	JScrollPane spGoodsList;
	GoodsListTableModel tmGoodsList;
	JTable tableGoodsList;
	JFileChooser fc;
	AddGoodsDAO dao = null;
	AddGoodsVO vo = null;
	ArrayList list = null;
	HashMap<String, String[]> map;
	int code;
	int boothcode;
	JLabel lblTape;
	String url;
	File f;
	String ff;
	ImageIcon ii;

	public AddGoodsView(int num) {
		newObject();
		addLayout();
		eventProc();
		setLocationRelativeTo(null);
		
		boothcode = num;

		try {
			dao = new AddGoodsDAO();
			System.out.println("상품 DB 연결 성공!");
			selectTable();

			String name = dao.selectBoothName(num);
			tfBthName.setText(name);
			
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "상품 DB연결 실패 : " + e.getMessage());
		}

	}

	void newObject() {
		// 상품 등록
		contentPane = new JPanel();
		
		lblBthName = new JLabel("부스명");
		
		tfBthName = new JTextField();
		
		lblGoodsCt = new JLabel("상품유형");

		String[] goodsGt = { "식품", "기념품" };
		comGT = new JComboBox(goodsGt);
		comGT.setFont(new Font("양재튼튼체B", Font.PLAIN, 12));

		String[][] goodsCt = {

				{ "음식", "사이드", "간식" }, { "악세서리", "도서", "기타" } };

		map = new HashMap<>();

		map.put("식품", goodsCt[0]);
		map.put("기념품", goodsCt[1]);

		comGD = new JComboBox();
		lblTape = new JLabel("");

		lblGoodsName = new JLabel("상품명");
		tfGoodsName = new JTextField();
		
		lblJungPrice = new JLabel("정가");
		tfJungPrice = new JTextField();
		
		lblOnePrice = new JLabel("원가");
		tfOnePrice = new JTextField();
		
		lbGoodsCnt = new JLabel("재고수량");
		tfGoodsCnt = new JTextField();
		
		lblAddImg = new JLabel("이미지 넣기");
		tfAddImg = new JTextField();
		
		tfAddImg.setEditable(false);
		btnAddGoods = new JButton("상품 등록");
		btnClose = new JButton("");

		
		btnModGoods = new JButton("상품 수정");
		btnDelGoods = new JButton("상품 삭제");
		btnAddImg = new JButton("이미지 넣기");
	
		fc = new JFileChooser();
		lblImg = new JLabel("");

		// 등록 상품 내역
		pGoodsList = new JPanel();
		spGoodsList = new JScrollPane();
		tmGoodsList = new GoodsListTableModel();
		tableGoodsList = new JTable(tmGoodsList);
		
	}

	void addLayout() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1108, 721);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(255, 255, 255));

		// 상품 등록
		lblBthName.setBounds(551, 64, 49, 23);
		contentPane.add(lblBthName);
		lblBthName.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));

		tfBthName.setEditable(false);
		tfBthName.setBounds(653, 61, 170, 30);
		tfBthName.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));
		contentPane.add(tfBthName);
		tfBthName.setColumns(10);

		lblGoodsCt.setBounds(535, 110, 65, 23);
		contentPane.add(lblGoodsCt);
		lblGoodsCt.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));

		comGT.setBounds(653, 106, 73, 30);
		contentPane.add(comGT);

		comGD.setBounds(758, 106, 65, 30);
		contentPane.add(comGD);
		comGD.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));

		lblGoodsName.setBounds(553, 158, 47, 23);
		contentPane.add(lblGoodsName);
		lblGoodsName.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));

		tfGoodsName.setBounds(653, 155, 170, 30);
		contentPane.add(tfGoodsName);
		tfGoodsName.setColumns(10);
		tfGoodsName.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));

		lblJungPrice.setBounds(561, 204, 30, 23);
		contentPane.add(lblJungPrice);
		lblJungPrice.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));

		tfJungPrice.setBounds(653, 197, 170, 30);
		contentPane.add(tfJungPrice);
		tfJungPrice.setColumns(10);
		tfJungPrice.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));

		lblOnePrice.setBounds(563, 244, 35, 15);
		contentPane.add(lblOnePrice);
		lblOnePrice.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));

		tfOnePrice.setBounds(653, 237, 170, 30);
		contentPane.add(tfOnePrice);
		tfOnePrice.setColumns(10);
		tfOnePrice.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));

		lbGoodsCnt.setBounds(535, 283, 73, 23);
		contentPane.add(lbGoodsCnt);
		lbGoodsCnt.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));

		tfGoodsCnt.setBounds(653, 280, 170, 30);
		contentPane.add(tfGoodsCnt);
		tfGoodsCnt.setColumns(10);
		tfGoodsCnt.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));

		btnAddGoods.setBounds(872, 91, 106, 48);
		contentPane.add(btnAddGoods);
		btnAddGoods.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));
		btnAddGoods.setBackground(Color.white);

		btnModGoods.setBounds(872, 165, 106, 48);
		btnModGoods.setBackground(Color.white);
		contentPane.add(btnModGoods);
		btnModGoods.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));

		btnDelGoods.setBounds(872, 234, 106, 48);
		contentPane.add(btnDelGoods);
		btnDelGoods.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));

		lblImg.setBounds(56, 257, 320, 201);
		contentPane.add(lblImg);

		// 등록 상품 내역
		pGoodsList.setBounds(461, 346, 571, 290);
		contentPane.add(pGoodsList);
		pGoodsList.setLayout(null);

		spGoodsList.setBounds(0, 0, 571, 290);
		pGoodsList.add(spGoodsList);

		spGoodsList.setViewportView(tableGoodsList);
		tableGoodsList.setFont(new Font("양재인장체M", Font.PLAIN, 12));

		lblAddImg.setBounds(23, 154, 98, 15);
		contentPane.add(lblAddImg);
		lblAddImg.setFont(new Font("양재튼튼체B", Font.PLAIN, 15));
		tfAddImg.setBounds(118, 148, 191, 30);
		contentPane.add(tfAddImg);
		tfAddImg.setColumns(10);
		tfAddImg.setFont(new Font("양재튼튼체B", Font.PLAIN, 12));

		btnAddImg.setBounds(321, 147, 106, 30);
		contentPane.add(btnAddImg);
		btnAddImg.setFont(new Font("양재튼튼체B", Font.PLAIN, 12));
		
		btnClose.setIcon(new ImageIcon("C:\\Users\\04-09\\eclipse-workspace\\project\\src\\img\\bacccck).png"));
		btnClose.setBackground(Color.white);
		btnClose.setBorderPainted(false);
		btnClose.setBounds(952, 22, 75, 50);
		contentPane.add(btnClose);
		
		
		lblTape.setIcon(new ImageIcon("C:\\Users\\04-09\\eclipse-workspace\\project\\src\\img\\tape.png"));
		lblTape.setBounds(140, 212, 170, 55);
		contentPane.add(lblTape);
	}

	void eventProc() {
		btnAddGoods.addActionListener(this);
		btnModGoods.addActionListener(this);
		btnDelGoods.addActionListener(this);
		btnAddImg.addActionListener(this);
		comGT.addActionListener(this);
		btnClose.addActionListener(this);
		
		
		tableGoodsList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				try {
					int col = 0;
					int row = tableGoodsList.getSelectedRow();
					int gnum = (int) tableGoodsList.getValueAt(row, col);
					vo = dao.findByName(gnum);

				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "상품 리스트 가져오기 실패 : " + e2.getMessage());
				}
				try {
					int col = 0;
					int row = tableGoodsList.getSelectedRow();
					int goodscode = (int) tableGoodsList.getValueAt(row, col);
					String url = dao.getImage(goodscode);
					
					ImageIcon ii = new ImageIcon(url);
					lblImg.setIcon(ii);
				} catch (Exception e2) {
					// TODO: handle exception
				}
				comGT.setSelectedItem(vo.getGtName());
				comGD.setSelectedItem(vo.getGdName());
				tfGoodsName.setText(vo.getGoodsName());
				tfJungPrice.setText(String.valueOf(vo.getJungPrice()));
				tfOnePrice.setText(String.valueOf(vo.getOnePrice()));
				tfGoodsCnt.setText(String.valueOf(vo.getGoodsCnt()));
				tfAddImg.setText(vo.getGoodsImg());
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent ev) {
		Object o = ev.getSource();
		if (o == btnAddGoods) {
			// 상품추가
			try {
				int gt = comGT.getSelectedIndex() + 1;

				if (comGT.getSelectedIndex() == 0) {
					int gd1 = comGD.getSelectedIndex() + 1;
					code = dao.gctCode(gt, gd1);// 상품카테고리코드
				} else if (comGT.getSelectedIndex() == 1) {
					int gd2 = comGD.getSelectedIndex() + 4;
					code = dao.gctCode(gt, gd2);// 상품카테고리코드
				}
				try {
					String goodsname = tfGoodsName.getText();
					int jungprice = Integer.parseInt(tfJungPrice.getText());
					int oneprice = Integer.parseInt(tfOnePrice.getText());
					int cnt = Integer.parseInt(tfGoodsCnt.getText());
					try {
						vo = new AddGoodsVO(boothcode, goodsname, jungprice, oneprice, cnt, url);
						dao.AddGoods(vo, code);
					} catch (Exception e) {
						// TODO: handle exception
					}

				} catch (Exception e) {
					// TODO: handle exception
				}
				clearScreen();
			} catch (Exception e) {
				// TODO: handle exception
			}
			selectTable();
		} else if (o == btnModGoods) {
			int col = 0;
			int row = tableGoodsList.getSelectedRow();
			int goodscode = (int) tableGoodsList.getValueAt(row, col);
			String goodsname = tfGoodsName.getText();
			int jungprice = Integer.parseInt(tfJungPrice.getText());
			int oneprice = Integer.parseInt(tfOnePrice.getText());
			int goodscnt = Integer.parseInt(tfGoodsCnt.getText());
			
			vo = new AddGoodsVO(goodsname, jungprice, oneprice, goodscnt);
			try {
				dao.ModGoods(vo, goodscode);
				JOptionPane.showMessageDialog(null, "상품 수정 성공");
				selectTable();
				clearScreen();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "상품 수정 실패 : " + e.getMessage());
			}
		} else if (o == btnAddImg) { // 문제
			int returnValue = fc.showOpenDialog(this);
			if (returnValue == 0) {
				f = fc.getSelectedFile();
				ff = f.getAbsolutePath();
				
				ii = new ImageIcon(f.getAbsolutePath());
				vo =new AddGoodsVO(ff);
				url = ff;
				lblImg.setIcon(ii);
			}
		} else if (o == comGT) {
			String selectedDepartment = (String) comGT.getSelectedItem();
			String[] teams = map.get(selectedDepartment);
			comGD.setModel(new DefaultComboBoxModel<String>(teams));
		} else if( o ==btnClose) {
			dispose();
		}
	}

	void clearScreen() {
		tfGoodsName.setText("");
		tfJungPrice.setText("");
		tfOnePrice.setText("");
		tfGoodsCnt.setText("");
		tfAddImg.setText("");
		lblImg.setIcon(null);
	}

	void selectTable() {
		String boothName = tfBthName.getText();
		try {

			try {
				list = dao.goodsList(boothcode);
				tmGoodsList.data = list;
				tableGoodsList.setModel(tmGoodsList);
				tmGoodsList.fireTableDataChanged();
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "상품 리스트 출력 실패 : " + e.getMessage());
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "출력 실패 : " + e.getMessage());
		}
	}
}

class GoodsListTableModel extends AbstractTableModel {
	ArrayList data = new ArrayList();
	String[] columnNames = { "상품번호", "부스명", "상품명", "정가", "원가", "재고수량" };

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return data.size();
	}

	public Object getValueAt(int row, int col) {
		ArrayList temp = (ArrayList) data.get(row);
		return temp.get(col);
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}
}
