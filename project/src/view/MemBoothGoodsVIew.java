package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import model.MemBoothGoodsDAO;
import model.rec.AddGoodsVO;
import model.rec.MemBoothGoodsVO;

public class MemBoothGoodsVIew extends JFrame implements ActionListener {

	JPanel contentPane;
	JTable tableAllGoods, tableBuyGoods;
	JScrollPane scrollPane, scrollPane_1;
	JButton btnAddGoods, btnPay;
	JLabel lblBoothName, lblimg, lblNewLabel;
	MemBoothGoodsDAO dao;
	RecentListTableModel rListTable;
	JButton btnCancel;
	int mempk = 0;
	int jumuncode = 0;
	int tot = 0;
	MemBoothGoodsVO vo;
	AddGoodsVO vo2;
	JTextArea textArea;
	JComboBox comPhow;

	public MemBoothGoodsVIew(int bcode, int pk) {
		newObject();
		addLayout();
		eventProc();
		mempk = pk;
		try {
			dao = new MemBoothGoodsDAO();
			String name = dao.boothName(bcode);
			lblBoothName.setText(name);

			selectTable(bcode);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public class SpinnerEditor extends DefaultCellEditor {
		JSpinner sp;
		DefaultEditor defaultEdit;
		JTextField text;

		public SpinnerEditor() {
			super(new JTextField());
			sp = new JSpinner();
			defaultEdit = (DefaultEditor) sp.getEditor();
			text = defaultEdit.getTextField();
		}

		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			sp.setValue(value);
			return sp;
		}

		public Object getCellEditorValue() {
			return sp.getValue();
		}

	}

	void newObject() {
		contentPane = new JPanel();

		scrollPane = new JScrollPane();
		scrollPane_1 = new JScrollPane();

		lblBoothName = new JLabel("");
		lblNewLabel = new JLabel("요청사항");
		lblimg = new JLabel("");

		rListTable = new RecentListTableModel();
		tableAllGoods = new JTable(rListTable);

		textArea = new JTextArea();

		tableBuyGoods = new JTable();
		tableBuyGoods.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "상품코드", "상품명", "가격", "수량" }));
		comPhow = new JComboBox();

		TableColumnModel model = tableBuyGoods.getColumnModel();
		TableColumn col = model.getColumn(3);
		col.setCellEditor(new SpinnerEditor());

		btnAddGoods = new JButton("담기");
		btnPay = new JButton("결제하기");
		btnCancel = new JButton("삭제");
	}

	void addLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1014, 714);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		getContentPane().setLayout(null);

		scrollPane.setBounds(68, 80, 326, 352);
		getContentPane().add(scrollPane);

		scrollPane.setViewportView(tableAllGoods);

		scrollPane_1.setBounds(544, 73, 351, 345);
		getContentPane().add(scrollPane_1);

		scrollPane_1.setViewportView(tableBuyGoods);

		btnAddGoods.setBounds(416, 182, 97, 23);
		getContentPane().add(btnAddGoods);

		btnPay.setBounds(798, 576, 97, 32);
		getContentPane().add(btnPay);

		lblBoothName.setBounds(58, 29, 130, 40);
		getContentPane().add(lblBoothName);

		btnCancel.setBounds(416, 247, 97, 23);
		contentPane.add(btnCancel);

		textArea.setBounds(544, 447, 351, 119);
		contentPane.add(textArea);

		lblNewLabel.setBounds(544, 422, 57, 15);
		contentPane.add(lblNewLabel);

		comPhow.setModel(new DefaultComboBoxModel(new String[] { "카드결제", "계좌이체" }));
		comPhow.setBounds(676, 581, 105, 32);
		contentPane.add(comPhow);

		lblimg.setBounds(45, 441, 377, 212);
		contentPane.add(lblimg);

	}

	void eventProc() {
		btnPay.addActionListener(this);
		btnAddGoods.addActionListener(this);
		btnCancel.addActionListener(this);

		tableAllGoods.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					int col = 0;
					int row = tableAllGoods.getSelectedRow();
					int goodscode = (int) tableAllGoods.getValueAt(row, col);
					String url = dao.getImage(goodscode);

					ImageIcon ii = new ImageIcon(url);

					lblimg.setIcon(ii);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o == btnCancel) {
			// 상품취소
			cancelGoods();
		} else if (o == btnAddGoods) {
			// 상품등록

			int row = tableAllGoods.getSelectedRow();
			int cnt = (int) tableAllGoods.getValueAt(row, 3);
			int code = (int) tableAllGoods.getValueAt(row, 0);
			String name = String.valueOf(tableAllGoods.getValueAt(row, 1));
			int price = (int) tableAllGoods.getValueAt(row, 2);
			int rcnt = tableBuyGoods.getRowCount();
			int a = 0;
			if (cnt == 0) {
				JOptionPane.showMessageDialog(null, "품절된 상품입니다!");
			} else {
				if (rcnt <= 0) {
					addGoods(code, name, price);
				} else {
					for (int i = 0; i < rcnt; i++) {
						int num = (int) tableBuyGoods.getValueAt(i, 0);
						if (code == num) {
							a = a + 1;
						}
					}
					if (a == 1) {
						JOptionPane.showMessageDialog(null, "이미 추가된 상품입니다!");
						a = 0;
					} else {
						addGoods(code, name, price);
					}
				}
			}

		} else if (o == btnPay) {
			// 결제
			int rcnt = tableBuyGoods.getRowCount();
			if(rcnt == 0) {
				JOptionPane.showMessageDialog(null, "담은 상품이 없습니다!");
			}else {
				int num = 0;
				for(int i = 0; i < rcnt; i++) {
					try {
						int amount2 = (int) tableBuyGoods.getModel().getValueAt(i, 3);
						int goodscode2 = (int) tableBuyGoods.getModel().getValueAt(i, 0);
						int goodsamount2 = dao.getGoodsCnt(goodscode2);
						if(goodsamount2 - amount2 <0) {
							num++;
						}
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
				}
				if (num == 0) {
					//결제 코드
					try {
						int jucode = dao.createJumunCode();
						jumuncode = jucode;
						int total = 0;
						for (int i = 0; i < rcnt; i++) {
							try {
								int amount = (int) tableBuyGoods.getModel().getValueAt(i, 3);
								int goodscode = (int) tableBuyGoods.getModel().getValueAt(i, 0);
								int price = (int) tableBuyGoods.getModel().getValueAt(i, 2);
								int sum = amount * price;
								total += sum;
								tot = total;
								int goodsamount = dao.getGoodsCnt(goodscode);
								System.out.println(goodsamount + "재고");
								vo = new MemBoothGoodsVO(amount, jucode, goodscode);
								if (goodsamount - amount >= 0) {
									try {
										// 상품 주문내역
										dao.inBuyInfo(vo);
										if (comPhow.getSelectedIndex() == 0) {
											// 카드결제시
											String request = textArea.getText();
											CardPayView pview = new CardPayView(mempk, jumuncode, tot, request);
											pview.setVisible(true);
											setVisible(false);

										} else if (comPhow.getSelectedIndex() == 1) {
											// 계좌이체시
											String request = textArea.getText();
											GoPayView gview = new GoPayView(mempk, jumuncode, tot, request);
											gview.setVisible(true);
											setVisible(false);
										}

									} catch (Exception e2) {
										// TODO: handle exception

									}
								} else {
									JOptionPane.showMessageDialog(null, "재고보다 주문수량이 더 많습니다!");
									break;
								}
							} catch (Exception e2) {
								// TODO: handle exception
							}
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
					num = 0;
				} else {
					//결제 안됌
					JOptionPane.showMessageDialog(null, "재고보다 주문수량이 더 많습니다!");
					
				}
				

			}
			
			
		}
	}

	// 전체상품리스트 출력
	void selectTable(int bcode) {
		try {

			ArrayList list = new ArrayList();

			list = dao.searchAllGoods(bcode);

			rListTable.data = list;

			tableAllGoods.setModel(rListTable);

			rListTable.fireTableDataChanged();

		} catch (Exception e) {
			// TODO: handle exception
			// JOptionPane.showMessageDialog(null, "검색 실패: " + e.getMessage());
		}
	}

	void addGoods(int code, String name, int price) {

		Vector goods = new Vector();
		goods.add(code);
		goods.add(name);
		goods.add(price);
		goods.add(1);

		DefaultTableModel model = (DefaultTableModel) tableBuyGoods.getModel();
		model.addRow(goods);
	}

	void cancelGoods() {
		DefaultTableModel model = (DefaultTableModel) tableBuyGoods.getModel();
		int index = tableBuyGoods.getSelectedRow();
		if (index < 0) {
			System.out.println("행 선택하세요");
		} else {
			model.removeRow(index);
		}
	}

	// 전체상품리스트
	class RecentListTableModel extends AbstractTableModel {

		ArrayList data = new ArrayList();
		String[] columnNames = { "상품코드", "상품명", "가격", "남은 재고" };

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return data.size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return columnNames.length;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			ArrayList temp = (ArrayList) data.get(rowIndex);
			return temp.get(columnIndex);
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}
	}
}
