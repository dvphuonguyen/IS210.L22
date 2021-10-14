package design;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Class.DichVu;
import Class.KhachHang;
import Class.PhieuDichVu;

public class NV_DichVu_view extends JFrame {

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
	static int mapdv = 0;
	private JLabel lbName;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NV_DichVu_view frame = new NV_DichVu_view();
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
					new Object[] { p.get("MAPDV"), p.get("MANV"), p.get("MAKH"), p.get("TENKH"), p.get("TIENDV"), p.get("MATT") });
		}
	}

	public void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
	public NV_DichVu_view() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1251, 700);
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
		cb_sdt.setBounds(894, 188, 252, 31);
		contentPane.add(cb_sdt);

		JLabel lblNewLabel = new JLabel("QUẢN LÝ DỊCH VỤ");
		lblNewLabel.setForeground(new Color(4, 51, 134));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(448, 21, 387, 65);
		contentPane.add(lblNewLabel);

		JLabel lbInput_Name = new JLabel("Nhập tên dịch vụ : ");
		lbInput_Name.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbInput_Name.setForeground(new Color(4, 51, 134));
		lbInput_Name.setBounds(110, 193, 145, 22);
		contentPane.add(lbInput_Name);

		textField_tenDV = new JTextField();
		textField_tenDV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_tenDV.setColumns(10);
		textField_tenDV.setBounds(265, 185, 215, 34);
		contentPane.add(textField_tenDV);

		JLabel lblNewLabel_1 = new JLabel("Kết quả");
		lblNewLabel_1.setForeground(new Color(4, 51, 134));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(246, 305, 88, 36);
		contentPane.add(lblNewLabel_1);
		lbReturn = new JLabel("");
		lbReturn.setBounds(1162, 612, 45, 51);
		lbReturn.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\logout.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
		
		lbReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				NhanVien_view ql = new NhanVien_view();
				ql.setVisible(true);
				close();
			}
		});
		contentPane.add(lbReturn);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(76, 344, 424, 215);
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
		lblTmKimDch.setBounds(160, 96, 303, 42);
		contentPane.add(lblTmKimDch);

		JLabel lblTmKimDch_1 = new JLabel("___________________");
		lblTmKimDch_1.setForeground(new Color(4, 51, 134));
		lblTmKimDch_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTmKimDch_1.setBounds(130, 111, 324, 42);
		contentPane.add(lblTmKimDch_1);

		JLabel lblTmKimDch_1_1 = new JLabel("___________________");
		lblTmKimDch_1_1.setForeground(new Color(4, 51, 134));
		lblTmKimDch_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTmKimDch_1_1.setBounds(771, 111, 324, 42);
		contentPane.add(lblTmKimDch_1_1);

		JLabel lbInput_Name_1 = new JLabel("Nhập sdt khách hàng:");
		lbInput_Name_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbInput_Name_1.setForeground(new Color(4, 51, 134));
		lbInput_Name_1.setBounds(716, 171, 168, 22);
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
		textField_sdt.setBounds(894, 163, 252, 34);
		contentPane.add(textField_sdt);

		JLabel lblNewLabel_1_1 = new JLabel("Kết quả");
		lblNewLabel_1_1.setForeground(new Color(4, 51, 134));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(894, 305, 88, 36);
		contentPane.add(lblNewLabel_1_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(715, 344, 431, 208);
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
		lblPhiuDchV.setBounds(822, 96, 239, 42);
		contentPane.add(lblPhiuDchV);

		JLabel lbInput_Name_1_1 = new JLabel("Tên khách hàng:");
		lbInput_Name_1_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbInput_Name_1_1.setBounds(716, 213, 159, 22);
		lbInput_Name_1_1.setForeground(new Color(4, 51, 134));
		contentPane.add(lbInput_Name_1_1);

		lbName = new JLabel("");
		lbName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbName.setBounds(893, 207, 144, 32);
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
		panel_add.setBounds(55, 245, 158, 55);
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
		panel_add_1.setBounds(277, 245, 207, 55);
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
					PhieuDichVu pdv = new PhieuDichVu(MaNV, MaKH, TongTien, 1);
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
		panel_add_2_1.setBounds(694, 245, 145, 55);
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
		panel_add_2_2.setBounds(862, 245, 145, 55);
		contentPane.add(panel_add_2_2);

		JLabel lblThm_2_2 = new JLabel("Refresh");
		lblThm_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showAll_PDV();
			}
		});
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
		panel_add_2_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add_2_2_1.setLayout(null);
		panel_add_2_2_1.setBackground(new Color(217, 232, 243));
		panel_add_2_2_1.setBounds(1051, 249, 108, 55);
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

		lbAdd_icon_2_2_1.addMouseListener(new MouseAdapter() {
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
		panel_add_2_1_1.setBounds(694, 565, 189, 55);
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
					mapdv = Integer.valueOf((String) table_1.getValueAt(SelectedIndex, 0));
					Add_DichVuKH dvkh = new Add_DichVuKH();
					dvkh.setVisible(true);
				}
			}
		});
		panel_add_2_1_2.setLayout(null);
		panel_add_2_1_2.setBackground(new Color(217, 232, 243));
		panel_add_2_1_2.setBounds(899, 565, 260, 55);
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
