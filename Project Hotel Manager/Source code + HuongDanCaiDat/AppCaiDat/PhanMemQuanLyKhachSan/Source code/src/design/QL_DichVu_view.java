package design;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Class.ChiTietKM;
import Class.ChiTietPDP;
import Class.DichVu;
import Class.KhachHang;
import Class.NhanVien;
import Class.PhieuDatPhong;
import Class.PhieuDichVu;


import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.border.LineBorder;
import javax.swing.JTree;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;



public class QL_DichVu_view extends JFrame {

	private JPanel contentPane;
	private JTextField textField_tenDV;
	private JLabel lbReturn;
	private JTable table;
	DefaultTableModel tableModel;
	ArrayList<DichVu> ListDV = new ArrayList<DichVu>();
	ArrayList<KhachHang> listKH = new ArrayList<KhachHang>();
	ArrayList pdv = new ArrayList();
	static int TongTien = 0;
	Update_DichVu update;
	private JTextField textField_sdt;
	Login a = new Login();
	static int MaNV;
	DefaultTableModel tableModel_1;
	private JTable table_1;
	static int mapdv = 0, flagAddPDV = 0;
	private JLabel lbName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QL_DichVu_view frame = new QL_DichVu_view();
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
	public void showAll() {
		// xoá dữ liêu table trước khi export dữ liệu mới
		for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
		ListDV = DichVu_Modifiers.findAll();

		for (DichVu dv : ListDV) {
			tableModel.addRow(new Object[] { dv.getMaDV(), dv.getTenDV(), dv.getGiaDV(), dv.getMaDonVi() });
		}
	}

	public void showAll_PDV() {
		// xoá dữ liêu table trước khi export dữ liệu mới
		for (int i = tableModel_1.getRowCount() - 1; i >= 0; i--) {
			tableModel_1.removeRow(i);
		}
		pdv = DichVu_Modifiers.findAll_PDV();

		HashMap<String, String> p;

		for (int i = 0; i < pdv.size(); i++) {
			p = (HashMap<String, String>) pdv.get(i);
			tableModel_1.addRow(
					new Object[] { p.get("MAPDV"), p.get("MANV"), p.get("MAKH"), 
							p.get("TENKH"), p.get("TIENDV"), p.get("MATT") });
		}
	}
	
	public void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}

	public QL_DichVu_view() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1316, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(217, 232, 243));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox cb_sdt = new JComboBox();
		cb_sdt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cb_sdt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (KhachHang kh : listKH) {
					textField_sdt.setText(kh.getSdtKH());
					lbName.setText(kh.getTenKH());
				}
				cb_sdt.setVisible(false);
			}
		});
		cb_sdt.setVisible(false);
		cb_sdt.setBounds(979, 188, 252, 31);
		contentPane.add(cb_sdt);

		JLabel lblNewLabel = new JLabel("QUẢN LÝ DỊCH VỤ");
		lblNewLabel.setForeground(new Color(4, 51, 134));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(533, 21, 387, 65);
		contentPane.add(lblNewLabel);

		JLabel lbInput_Name = new JLabel("Nhập tên dịch vụ : ");
		lbInput_Name.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbInput_Name.setForeground(new Color(4, 51, 134));
		lbInput_Name.setBounds(195, 193, 145, 22);
		contentPane.add(lbInput_Name);

		textField_tenDV = new JTextField();
		textField_tenDV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_tenDV.setColumns(10);
		textField_tenDV.setBounds(350, 185, 215, 34);
		contentPane.add(textField_tenDV);

		JLabel lblNewLabel_1 = new JLabel("Kết quả");
		lblNewLabel_1.setForeground(new Color(4, 51, 134));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(211, 305, 88, 36);
		contentPane.add(lblNewLabel_1);
		lbReturn = new JLabel("");
		lbReturn.setBounds(1247, 612, 45, 51);
		lbReturn.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\logout.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
		
		lbReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				QuanLy_view ql = new QuanLy_view();
				ql.setVisible(true);
				close();
			}
		});
		contentPane.add(lbReturn);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 344, 424, 215);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "MaDV", "TenDV", "GiaDV", "MaDonVi" }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class, Integer.class, Integer.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableModel = (DefaultTableModel) table.getModel();
		scrollPane.setViewportView(table);

		JLabel lblTmKimDch = new JLabel("TÌM KIẾM DỊCH VỤ");
		lblTmKimDch.setForeground(new Color(4, 51, 134));
		lblTmKimDch.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTmKimDch.setBounds(245, 96, 303, 42);
		contentPane.add(lblTmKimDch);

		JLabel lblTmKimDch_1 = new JLabel("___________________");
		lblTmKimDch_1.setForeground(new Color(4, 51, 134));
		lblTmKimDch_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTmKimDch_1.setBounds(215, 111, 324, 42);
		contentPane.add(lblTmKimDch_1);

		JLabel lblTmKimDch_1_1 = new JLabel("___________________");
		lblTmKimDch_1_1.setForeground(new Color(4, 51, 134));
		lblTmKimDch_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTmKimDch_1_1.setBounds(856, 111, 324, 42);
		contentPane.add(lblTmKimDch_1_1);

		JLabel lbInput_Name_1 = new JLabel("Nhập sdt khách hàng:");
		lbInput_Name_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbInput_Name_1.setForeground(new Color(4, 51, 134));
		lbInput_Name_1.setBounds(801, 171, 168, 22);
		contentPane.add(lbInput_Name_1);

		textField_sdt = new JTextField();
		textField_sdt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				listKH = KH_Modifiers.FindbySDT(textField_sdt.getText());
				for (KhachHang kh : listKH) {
					cb_sdt.addItem(kh.getSdtKH());
					cb_sdt.setVisible(true);
				}
			}
		});
		textField_sdt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_sdt.setColumns(10);
		textField_sdt.setBounds(979, 163, 252, 34);
		contentPane.add(textField_sdt);

		JLabel lblNewLabel_1_1 = new JLabel("Kết quả");
		lblNewLabel_1_1.setForeground(new Color(4, 51, 134));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(979, 305, 88, 36);
		contentPane.add(lblNewLabel_1_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(800, 344, 431, 208);
		contentPane.add(scrollPane_1);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MAPDV", "MANV", "MAKH", "TENKH", "TONGTIEN", "MATT"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, Integer.class, String.class, Integer.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableModel_1 = (DefaultTableModel) table_1.getModel();

		scrollPane_1.setViewportView(table_1);

		JLabel lblPhiuDchV = new JLabel("PHIẾU DỊCH VỤ");
		lblPhiuDchV.setForeground(new Color(4, 51, 134));
		lblPhiuDchV.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPhiuDchV.setBounds(907, 96, 239, 42);
		contentPane.add(lblPhiuDchV);

		JLabel lbInput_Name_1_1 = new JLabel("Tên khách hàng:");
		lbInput_Name_1_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbInput_Name_1_1.setBounds(801, 213, 159, 22);
		lbInput_Name_1_1.setForeground(new Color(4, 51, 134));
		contentPane.add(lbInput_Name_1_1);

		lbName = new JLabel("");
		lbName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbName.setBounds(978, 207, 144, 32);
		contentPane.add(lbName);

		JPanel panel_add = new JPanel();
		panel_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ListDV = DichVu_Modifiers.Find(textField_tenDV.getText());

				tableModel.setRowCount(0);

				ListDV.forEach((dv) -> {
					tableModel.addRow(new Object[] { dv.getMaDV(), dv.getTenDV(), dv.getGiaDV(), dv.getMaDonVi() });
				});
			}
		});
		panel_add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add.setLayout(null);
		panel_add.setBackground(new Color(217, 232, 243));
		panel_add.setBounds(20, 245, 158, 55);
		contentPane.add(panel_add);

		JLabel lblThm = new JLabel("Tìm kiếm");
		lblThm.setForeground(new Color(4, 51, 134));
		lblThm.setFont(new Font("Calibri", Font.PLAIN, 23));
		lblThm.setBounds(68, 10, 107, 45);
		panel_add.add(lblThm);

		JLabel lbAdd_icon = new JLabel("");
		lbAdd_icon.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\search_32px.png")
						.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));

		lbAdd_icon.setBounds(26, 0, 32, 55);
		panel_add.add(lbAdd_icon);

		JPanel panel_add_1 = new JPanel();
		panel_add_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showAll();
			}
		});
		panel_add_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add_1.setLayout(null);
		panel_add_1.setBackground(new Color(217, 232, 243));
		panel_add_1.setBounds(242, 245, 207, 55);
		contentPane.add(panel_add_1);

		JLabel lblThm_1 = new JLabel("Hiển thị tất cả");
		lblThm_1.setForeground(new Color(4, 51, 134));
		lblThm_1.setFont(new Font("Calibri", Font.PLAIN, 23));
		lblThm_1.setBounds(68, 10, 134, 45);
		panel_add_1.add(lblThm_1);

		JLabel lbAdd_icon_1 = new JLabel("");
		lbAdd_icon_1.setBounds(26, 0, 32, 55);
		lbAdd_icon_1.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\search_32px.png")
						.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));

		panel_add_1.add(lbAdd_icon_1);

		JPanel panel_add_2 = new JPanel();
		panel_add_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Add_DichVu add_dv = new Add_DichVu();
				add_dv.setVisible(true);
				close();
			}
		});
		panel_add_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add_2.setLayout(null);
		panel_add_2.setBackground(new Color(217, 232, 243));
		panel_add_2.setBounds(510, 245, 215, 55);
		contentPane.add(panel_add_2);

		JLabel lblThm_2 = new JLabel("Thêm dịch vụ");
		lblThm_2.setForeground(new Color(4, 51, 134));
		lblThm_2.setFont(new Font("Calibri", Font.PLAIN, 23));
		lblThm_2.setBounds(68, 10, 137, 45);
		panel_add_2.add(lblThm_2);

		JLabel lbAdd_icon_2 = new JLabel("");
		lbAdd_icon_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lbAdd_icon_2.setBounds(26, 0, 32, 55);
		lbAdd_icon_2.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\plus_32px.png")
						.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));

		panel_add_2.add(lbAdd_icon_2);

		JPanel panel_add_3 = new JPanel();
		panel_add_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectedIndex = table.getSelectedRow();
				if (SelectedIndex > -1) {

					int ma = (int) table.getValueAt(SelectedIndex, 0);

					int option = JOptionPane.showConfirmDialog(null, "Bạn muốn sửa dịch vụ này?", "Warning", 2);

					if (option == 0) {

						for (DichVu dv : ListDV) {
							if (dv.getMaDV() == ma) {
								update = new Update_DichVu();
								update.dv = dv;
								update.gui();
							}
						}
						update.setVisible(true);
					}
				}
			}
		});
		panel_add_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add_3.setLayout(null);
		panel_add_3.setBackground(new Color(217, 232, 243));
		panel_add_3.setBounds(475, 332, 220, 55);
		contentPane.add(panel_add_3);

		JLabel lblSaDchV = new JLabel("Sửa dịch vụ");
		lblSaDchV.setForeground(new Color(4, 51, 134));
		lblSaDchV.setFont(new Font("Calibri", Font.PLAIN, 23));
		lblSaDchV.setBounds(65, 10, 125, 45);
		panel_add_3.add(lblSaDchV);

		JLabel lbAdd_icon_3 = new JLabel("");
		lbAdd_icon_3.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\images\\refresh.png")
						.getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH)));

		lbAdd_icon_3.setBounds(23, 3, 32, 50);
		panel_add_3.add(lbAdd_icon_3);

		JPanel panel_add_4 = new JPanel();
		panel_add_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectedIndex = table.getSelectedRow();

				if (SelectedIndex > -1) {
					DichVu Selected_DV = ListDV.get(SelectedIndex);

					int option = JOptionPane.showConfirmDialog(null, "Bạn muốn xoá dịch vụ này?", "Warning", 2);

					if (option == 0) {
						DichVu_Modifiers.Delete(Selected_DV.getTenDV());
						showAll();
					}
				}
			}
		});
		panel_add_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add_4.setLayout(null);
		panel_add_4.setBackground(new Color(217, 232, 243));
		panel_add_4.setBounds(475, 424, 220, 55);
		contentPane.add(panel_add_4);

		JLabel lblXoDchV = new JLabel("Xoá dịch vụ");
		lblXoDchV.setForeground(new Color(4, 51, 134));
		lblXoDchV.setFont(new Font("Calibri", Font.PLAIN, 23));
		lblXoDchV.setBounds(68, 10, 119, 45);
		panel_add_4.add(lblXoDchV);

		JLabel lbAdd_icon_4 = new JLabel("");
		lbAdd_icon_4.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\images\\clear.png")
						.getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH)));

		lbAdd_icon_4.setBounds(26, 0, 32, 55);
		panel_add_4.add(lbAdd_icon_4);

		JPanel panel_add_5 = new JPanel();
		panel_add_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				QL_DonVi_view qldv = new QL_DonVi_view();
				qldv.setVisible(true);
				close();
			}
		});
		panel_add_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add_5.setLayout(null);
		panel_add_5.setBackground(new Color(217, 232, 243));
		panel_add_5.setBounds(475, 515, 215, 55);
		contentPane.add(panel_add_5);

		JLabel lblQunLn = new JLabel("Quản lý đơn vị");

		lblQunLn.setForeground(new Color(4, 51, 134));
		lblQunLn.setFont(new Font("Calibri", Font.PLAIN, 23));
		lblQunLn.setBounds(68, 10, 159, 45);
		panel_add_5.add(lblQunLn);

		JLabel lbAdd_icon_5 = new JLabel("");
		lbAdd_icon_5.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\images\\settings.png")
						.getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH)));

		lbAdd_icon_5.setBounds(26, 0, 32, 55);
		panel_add_5.add(lbAdd_icon_5);

		JPanel panel_add_2_1 = new JPanel();
		panel_add_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MaNV = a.MaNV;

				int MaKH = 0;
				String sdt = textField_sdt.getText();
				ArrayList<KhachHang> Listkh = new ArrayList<>();
				Listkh = KH_Modifiers.FindbySDT(sdt);
				System.out.println(Listkh.size());
				for (KhachHang kh : Listkh)
					MaKH = kh.getMaKH();
				System.out.println(MaNV);
				System.out.println(MaKH);

				try {
					PhieuDichVu pdv = new PhieuDichVu(MaNV, MaKH, TongTien,1);
					DichVu_Modifiers.Add_PDV(pdv);
					textField_sdt.setText(null);
					lbName.setText(null);
					lbName.setVisible(false);
					JOptionPane.showMessageDialog(null, "Thêm phiếu dịch vụ thành công");

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		panel_add_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add_2_1.setLayout(null);
		panel_add_2_1.setBackground(new Color(217, 232, 243));
		panel_add_2_1.setBounds(779, 245, 145, 55);
		contentPane.add(panel_add_2_1);

		JLabel lblThm_2_1 = new JLabel("Thêm");
		lblThm_2_1.setForeground(new Color(4, 51, 134));
		lblThm_2_1.setFont(new Font("Calibri", Font.PLAIN, 23));
		lblThm_2_1.setBounds(68, 10, 58, 45);
		panel_add_2_1.add(lblThm_2_1);

		JLabel lbAdd_icon_2_1 = new JLabel("");
		lbAdd_icon_2_1.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\images\\plus1.png")
						.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH)));

		lbAdd_icon_2_1.setBounds(26, 0, 32, 55);
		panel_add_2_1.add(lbAdd_icon_2_1);

		JPanel panel_add_2_2 = new JPanel();
		panel_add_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showAll_PDV();
			}
		});
		panel_add_2_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add_2_2.setLayout(null);
		panel_add_2_2.setBackground(new Color(217, 232, 243));
		panel_add_2_2.setBounds(947, 245, 145, 55);
		contentPane.add(panel_add_2_2);

		JLabel lblThm_2_2 = new JLabel("Refresh");
		
		lblThm_2_2.setForeground(new Color(4, 51, 134));
		lblThm_2_2.setFont(new Font("Calibri", Font.PLAIN, 23));
		lblThm_2_2.setBounds(68, 10, 86, 45);
		panel_add_2_2.add(lblThm_2_2);

		JLabel lbAdd_icon_2_2 = new JLabel("");
		lbAdd_icon_2_2.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\images\\refresh.png")
				.getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH)));

		lbAdd_icon_2_2.setBounds(26, 0, 32, 55);
		panel_add_2_2.add(lbAdd_icon_2_2);

		JPanel panel_add_2_2_1 = new JPanel();
		panel_add_2_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectedIndex = table_1.getSelectedRow();

				if (SelectedIndex > -1) {

					int MaPDV = Integer.valueOf((String) table_1.getValueAt(SelectedIndex, 0));
					int option = JOptionPane.showConfirmDialog(null, "Bạn muốn xoá phiếu này?", "Warning", 2);

					if (option == 0) {
						DichVu_Modifiers.DeleteAllDichVu_from_CTPDV(MaPDV);
						DichVu_Modifiers.Delete_FromPDV(MaPDV);
						showAll_PDV();
					}
				}
			}
		});
		panel_add_2_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add_2_2_1.setLayout(null);
		panel_add_2_2_1.setBackground(new Color(217, 232, 243));
		panel_add_2_2_1.setBounds(1136, 249, 108, 55);
		contentPane.add(panel_add_2_2_1);

		JLabel lblThm_2_2_1 = new JLabel("Xoá");
		lblThm_2_2_1.setForeground(new Color(4, 51, 134));
		lblThm_2_2_1.setFont(new Font("Calibri", Font.PLAIN, 23));
		lblThm_2_2_1.setBounds(56, 10, 51, 45);
		panel_add_2_2_1.add(lblThm_2_2_1);

		JLabel lbAdd_icon_2_2_1 = new JLabel("");
		lbAdd_icon_2_2_1.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\images\\clear.png")
						.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));

		
		lbAdd_icon_2_2_1.setBounds(20, 0, 32, 55);
		panel_add_2_2_1.add(lbAdd_icon_2_2_1);
		
		JPanel panel_add_2_1_1 = new JPanel();
		panel_add_2_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectedIndex = table_1.getSelectedRow();

				if (SelectedIndex > -1) {
					mapdv = Integer.valueOf((String) table_1.getValueAt(SelectedIndex, 0));
					ChiTietPDV_view pdv = new ChiTietPDV_view();
					pdv.setVisible(true);
				}
			}
		});
		panel_add_2_1_1.setLayout(null);
		panel_add_2_1_1.setBackground(new Color(217, 232, 243));
		panel_add_2_1_1.setBounds(779, 565, 189, 55);
		contentPane.add(panel_add_2_1_1);
		
		JLabel lblThm_2_1_1 = new JLabel("Chi Tiết PDV");
		lblThm_2_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblThm_2_1_1.setForeground(new Color(4, 51, 134));
		lblThm_2_1_1.setFont(new Font("Calibri", Font.PLAIN, 23));
		lblThm_2_1_1.setBounds(68, 10, 128, 45);
		panel_add_2_1_1.add(lblThm_2_1_1);
		
		JLabel lbAdd_icon_2_1_1 = new JLabel("");
		lbAdd_icon_2_1_1.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\images\\invoice.png")
						.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));

		lbAdd_icon_2_1_1.setBounds(26, 0, 32, 55);
		panel_add_2_1_1.add(lbAdd_icon_2_1_1);
		
		JPanel panel_add_2_1_2 = new JPanel();
		panel_add_2_1_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add_2_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectedIndex = table_1.getSelectedRow();

				if (SelectedIndex > -1) {
					flagAddPDV = 1;
					mapdv = Integer.valueOf((String) table_1.getValueAt(SelectedIndex, 0));
					Add_DichVuKH dvkh = new Add_DichVuKH();
					dvkh.setVisible(true);
				}
			}
		});
		panel_add_2_1_2.setLayout(null);
		panel_add_2_1_2.setBackground(new Color(217, 232, 243));
		panel_add_2_1_2.setBounds(984, 565, 260, 55);
		contentPane.add(panel_add_2_1_2);
		
		JLabel lblThm_2_1_2 = new JLabel("Thêm DV vào phiếu");
		lblThm_2_1_2.setForeground(new Color(4, 51, 134));
		lblThm_2_1_2.setFont(new Font("Calibri", Font.PLAIN, 23));
		lblThm_2_1_2.setBounds(68, 10, 183, 45);
		panel_add_2_1_2.add(lblThm_2_1_2);
		
		JLabel lbAdd_icon_2_1_2 = new JLabel("");
		lbAdd_icon_2_1_2.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\images\\plus1.png")
						.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH)));

		
		lbAdd_icon_2_1_2.setBounds(26, 0, 32, 55);
		panel_add_2_1_2.add(lbAdd_icon_2_1_2);

	}
}
