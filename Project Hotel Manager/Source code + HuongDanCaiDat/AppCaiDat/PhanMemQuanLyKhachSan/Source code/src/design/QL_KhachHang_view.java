package design;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Objects;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Class.KhachHang;

import javax.swing.border.LineBorder;
import java.awt.Point;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class QL_KhachHang_view extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 817736487691835493L;
	private JPanel contentPane;
	private JTextField textField_Name;
	private JTextField textField_SDT;
	private JTextField textField_CMND;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lbReturn;
	private JScrollPane scrollPane;
	private JTable table;
	DefaultTableModel tableModel;
	static ArrayList<KhachHang> khList = new ArrayList<KhachHang>();
	ArrayList<KhachHang> khList1 = new ArrayList<KhachHang>();
	ArrayList<KhachHang> khList2 = new ArrayList<KhachHang>();
	ArrayList<KhachHang> khList3 = new ArrayList<KhachHang>();
	Update_KhachHang add;
	private JPanel panel_find;
	private JLabel lblTmKim;
	private JLabel lbFind_icon;
	private JPanel panel_findAll;
	private JLabel lblHinThTt;
	private JLabel lbFindall_icon;
	private JPanel panel_update;
	private JLabel lblSaNhnVin;
	private JLabel lbUpdate_icon;
	private JPanel panel_update_1;
	private JLabel lblXoNhnVin;
	private JLabel lbDelete_icon_;
	private JPanel panel_update_2;
	private JLabel lblThmKhchHng;
	private JLabel lbAdd_icon;
	static int maKH = 0;
	private JPanel panel_3;
	private JLabel lblVip;
	private JPanel panel_1_2;
	private JLabel lb_SLNV_1;
	private JLabel lbAdd_icon_1;
	private JLabel lbAdd_icon_2;
	private JLabel lbAdd_icon_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QL_KhachHang_view frame = new QL_KhachHang_view();
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
	public void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}

	public void showAll() {
		// xoá dữ liêu table trước khi export dữ liệu mới
		for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
		khList = KH_Modifiers.findAll();

		for (KhachHang khachhang : khList) {
			tableModel.addRow(new Object[] { khachhang.getMaKH(), khachhang.getTenKH(), khachhang.getCccdKH(),
					khachhang.getSdtKH(), khachhang.getGioiTinhKH(), khachhang.getNgaySinh(), khachhang.getQuocTich(),
					khachhang.getDoanhSo(), khachhang.getMaLoaiKH() });
		}
	}

	public QL_KhachHang_view() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1053, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(217, 232, 243));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbInput_Name = new JLabel("Nh\u1EADp t\u00EAn kh\u00E1ch h\u00E0ng : ");
		lbInput_Name.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbInput_Name.setBounds(135, 95, 176, 22);
		lbInput_Name.setForeground(new Color(4, 51, 134));

		contentPane.add(lbInput_Name);

		JLabel lbInput_sdt = new JLabel("Nhập số điện thoại : ");
		lbInput_sdt.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbInput_sdt.setBounds(155, 146, 176, 22);
		lbInput_sdt.setForeground(new Color(4, 51, 134));
		contentPane.add(lbInput_sdt);

		JLabel lbInput_CMND = new JLabel("Nh\u1EADp CMND : ");
		lbInput_CMND.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbInput_CMND.setBounds(201, 199, 134, 22);
		lbInput_CMND.setForeground(new Color(4, 51, 134));
		contentPane.add(lbInput_CMND);

		textField_Name = new JTextField();
		textField_Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Name.setBounds(341, 84, 258, 34);
		contentPane.add(textField_Name);
		textField_Name.setColumns(10);

		textField_SDT = new JTextField();
		textField_SDT.setBounds(341, 137, 258, 34);
		contentPane.add(textField_SDT);
		textField_SDT.setColumns(10);

		textField_CMND = new JTextField();
		textField_CMND.setBounds(341, 190, 258, 34);
		contentPane.add(textField_CMND);
		textField_CMND.setColumns(10);

		lblNewLabel = new JLabel("QUẢN LÝ KHÁCH HÀNG");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setForeground(new Color(4, 51, 134));

		lblNewLabel.setBounds(376, 20, 362, 42);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("K\u1EBFt qu\u1EA3");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(345, 234, 90, 36);

		lblNewLabel_1.setForeground(new Color(4, 51, 134));

		contentPane.add(lblNewLabel_1);

		lbReturn = new JLabel("");
		lbReturn.setBounds(970, 550, 45, 51);
		lbReturn.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\logout.png")
						.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
		lbReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				QuanLy_view ql = new QuanLy_view();
				ql.setVisible(true);
				close();
			}
		});
		contentPane.add(lbReturn);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 280, 715, 119);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "MaKH", "TenKH", "CMND", "SDT",
				"GioiTinh", "NgaySinh", "QuocTich", "DoanhSo", "MaLKH" }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class, String.class, String.class, String.class,
					Object.class, String.class, Integer.class, Integer.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBounds(new Rectangle(0, 0, 500, 500));
		scrollPane.setViewportView(table);

		tableModel = (DefaultTableModel) table.getModel();

		panel_find = new JPanel();
		panel_find.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textField_Name.getText().trim().length() > 0) {
					khList1 = KH_Modifiers.FindbyName(textField_Name.getText());
					tableModel.setRowCount(0);

					khList1.forEach((khachhang) -> {
						tableModel.addRow(new Object[] {

								khachhang.getMaKH(), khachhang.getTenKH(), khachhang.getCccdKH(), khachhang.getSdtKH(),
								khachhang.getGioiTinhKH(), khachhang.getNgaySinh(), khachhang.getQuocTich(),
								khachhang.getDoanhSo(), khachhang.getMaLoaiKH(),

						});
					});
				} else if (textField_SDT.getText().trim().length() > 0) {
					khList2 = KH_Modifiers.FindbySDT(textField_SDT.getText());
					tableModel.setRowCount(0);

					khList2.forEach((khachhang) -> {
						tableModel
								.addRow(new Object[] { khachhang.getMaKH(), khachhang.getTenKH(), khachhang.getCccdKH(),
										khachhang.getSdtKH(), khachhang.getGioiTinhKH(), khachhang.getNgaySinh(),
										khachhang.getQuocTich(), khachhang.getDoanhSo(), khachhang.getMaLoaiKH(), });
					});
				} else if (textField_CMND.getText().trim().length() > 0) {
					khList3 = KH_Modifiers.FindbyCCCD(textField_CMND.getText());
					tableModel.setRowCount(0);
					khList3.forEach((khachhang) -> {
						tableModel
								.addRow(new Object[] { khachhang.getMaKH(), khachhang.getTenKH(), khachhang.getCccdKH(),
										khachhang.getSdtKH(), khachhang.getGioiTinhKH(), khachhang.getNgaySinh(),
										khachhang.getQuocTich(), khachhang.getDoanhSo(), khachhang.getMaLoaiKH(), });
					});
				}
			}
		});
		panel_find.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_find.setBackground(new Color(217, 232, 243));
		panel_find.setBounds(791, 74, 181, 72);
		contentPane.add(panel_find);
		panel_find.setLayout(null);

		lblTmKim = new JLabel("Tìm kiếm");
		lblTmKim.setBounds(59, 32, 98, 30);
		lblTmKim.setForeground(new Color(4, 51, 134));
		lblTmKim.setFont(new Font("Calibri", Font.BOLD, 22));
		lblTmKim.setBackground(new Color(217, 232, 243));
		panel_find.add(lblTmKim);

		lbFind_icon = new JLabel("");
		lbFind_icon.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\search.png")
						.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));

		lbFind_icon.setBounds(10, 20, 46, 43);
		panel_find.add(lbFind_icon);

		panel_findAll = new JPanel();
		panel_findAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showAll();
			}
		});
		panel_findAll.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_findAll.setLayout(null);
		panel_findAll.setBackground(new Color(217, 232, 243));
		panel_findAll.setBounds(791, 187, 199, 51);
		contentPane.add(panel_findAll);

		lblHinThTt = new JLabel("Hiển thị tất cả");
		lblHinThTt.setForeground(new Color(4, 51, 134));
		lblHinThTt.setFont(new Font("Calibri", Font.BOLD, 22));
		lblHinThTt.setBackground(new Color(217, 232, 243));
		lblHinThTt.setBounds(59, 13, 140, 30);
		panel_findAll.add(lblHinThTt);

		lbFindall_icon = new JLabel("");
		lbFindall_icon.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\searchall.png")
						.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));

		lbFindall_icon.setBounds(10, 0, 45, 43);
		panel_findAll.add(lbFindall_icon);

		panel_update = new JPanel();
		panel_update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectedIndex = table.getSelectedRow();

				if (SelectedIndex > -1) {

					maKH = (int) table.getValueAt(SelectedIndex, 0);

					int option = JOptionPane.showConfirmDialog(null, "Bạn muốn sửa khách hàng này?", "Warning", 2);

					if (option == 0) {

						for (KhachHang khachHang : khList) {
							if (khachHang.getMaKH() == maKH) {

								add = new Update_KhachHang();
								add.kh = khachHang;
								add.gui();
							}
						}

						add.setVisible(true);
					}
				}
			}
		});
		panel_update.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_update.setLayout(null);
		panel_update.setBackground(new Color(217, 232, 243));
		panel_update.setBounds(791, 373, 224, 60);
		contentPane.add(panel_update);

		lblSaNhnVin = new JLabel("Sửa khách hàng");
		lblSaNhnVin.setForeground(new Color(4, 51, 134));
		lblSaNhnVin.setFont(new Font("Calibri", Font.BOLD, 22));
		lblSaNhnVin.setBackground(new Color(217, 232, 243));
		lblSaNhnVin.setBounds(55, 23, 159, 30);
		panel_update.add(lblSaNhnVin);

		lbUpdate_icon = new JLabel("");
		lbUpdate_icon.setBounds(10, 13, 51, 43);
		lbUpdate_icon.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\update.png")
						.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));

		panel_update.add(lbUpdate_icon);

		panel_update_1 = new JPanel();
		panel_update_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectedIndex = table.getSelectedRow();

				if (SelectedIndex > -1) {
					KhachHang Selected_KH = khList.get(SelectedIndex);

					int option = JOptionPane.showConfirmDialog(null, "Bạn muốn xoá khách hàng này?", "Warning", 2);

					if (option == 0) {
						KH_Modifiers.Delete(Selected_KH.getMaKH());
						showAll();
					}
				}
			}
		});
		panel_update_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_update_1.setLayout(null);
		panel_update_1.setBackground(new Color(217, 232, 243));
		panel_update_1.setBounds(791, 472, 214, 60);
		contentPane.add(panel_update_1);

		lblXoNhnVin = new JLabel("Xoá khách hàng");
		lblXoNhnVin.setForeground(new Color(4, 51, 134));
		lblXoNhnVin.setFont(new Font("Calibri", Font.BOLD, 22));
		lblXoNhnVin.setBackground(new Color(217, 232, 243));
		lblXoNhnVin.setBounds(55, 23, 149, 30);
		panel_update_1.add(lblXoNhnVin);

		lbDelete_icon_ = new JLabel("");
		lbDelete_icon_.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\delete.png")
						.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));

		lbDelete_icon_.setBounds(10, 13, 35, 43);
		panel_update_1.add(lbDelete_icon_);

		panel_update_2 = new JPanel();
		panel_update_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Add_KhachHang addKH = new Add_KhachHang();
				addKH.setVisible(true);
			}
		});
		panel_update_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_update_2.setLayout(null);
		panel_update_2.setBackground(new Color(217, 232, 243));
		panel_update_2.setBounds(791, 271, 224, 60);
		contentPane.add(panel_update_2);

		lblThmKhchHng = new JLabel("Thêm khách hàng");
		lblThmKhchHng.setForeground(new Color(4, 51, 134));
		lblThmKhchHng.setFont(new Font("Calibri", Font.BOLD, 22));
		lblThmKhchHng.setBackground(new Color(217, 232, 243));
		lblThmKhchHng.setBounds(47, 23, 177, 30);
		panel_update_2.add(lblThmKhchHng);

		lbAdd_icon = new JLabel("");
		lbAdd_icon.setBounds(10, 13, 51, 43);
		lbAdd_icon.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\plus_32px.png")
						.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));

		panel_update_2.add(lbAdd_icon);
		ArrayList<KhachHang> khList1 = new ArrayList<>();
		khList1 = KH_Modifiers.Find_LKH(1);
		ArrayList<KhachHang> khList2 = new ArrayList<>();
		khList2 = KH_Modifiers.Find_LKH(2);
		ArrayList<KhachHang> khList3 = new ArrayList<>();
		khList3 = KH_Modifiers.Find_LKH(3);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(224, 22, 213));
		panel.setBounds(34, 428, 208, 45);
		contentPane.add(panel);

		JLabel lbQL = new JLabel("THÀNH VIÊN");
		lbQL.setForeground(new Color(0, 24, 66));
		lbQL.setFont(new Font("Calibri", Font.BOLD, 20));
		lbQL.setBounds(55, 5, 130, 45);
		panel.add(lbQL);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(224, 143, 22));
		panel_2.setBounds(288, 428, 208, 45);
		contentPane.add(panel_2);

		JLabel lbNV = new JLabel("THÂN THIẾT");
		lbNV.setForeground(new Color(0, 24, 66));
		lbNV.setFont(new Font("Calibri", Font.BOLD, 20));
		lbNV.setBounds(55, 5, 110, 45);
		panel_2.add(lbNV);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 131, 224));
		panel_1.setBounds(34, 472, 208, 60);
		contentPane.add(panel_1);

		JLabel lb_SLQL = new JLabel("1");
		ArrayList<KhachHang> khList1_1 = new ArrayList<>();
		khList1 = KH_Modifiers.Find_LKH(1);
		lb_SLQL.setText(String.valueOf(khList1.size()));
		lb_SLQL.setForeground(Color.WHITE);
		lb_SLQL.setFont(new Font("Calibri", Font.BOLD, 30));
		lb_SLQL.setBounds(100, 15, 50, 45);
		panel_1.add(lb_SLQL);

		lbAdd_icon_1 = new JLabel("");
		lbAdd_icon_1.setIcon(new ImageIcon(
				new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\new-normality.png").getImage()
						.getScaledInstance(35, 35, Image.SCALE_DEFAULT)));

		lbAdd_icon_1.setBounds(58, 10, 43, 43);
		panel_1.add(lbAdd_icon_1);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(0, 131, 224));
		panel_1_1.setBounds(288, 472, 208, 60);
		contentPane.add(panel_1_1);

		JLabel lb_SLNV = new JLabel("9");
		ArrayList<KhachHang> khList2_1 = new ArrayList<>();
		khList2 = KH_Modifiers.Find_LKH(2);
		lb_SLNV.setText(String.valueOf(khList2.size()));
		lb_SLNV.setForeground(Color.WHITE);
		lb_SLNV.setFont(new Font("Calibri", Font.BOLD, 30));
		lb_SLNV.setBounds(91, 15, 50, 45);
		panel_1_1.add(lb_SLNV);

		lbAdd_icon_2 = new JLabel("");
		lbAdd_icon_2.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\tag.png")
						.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));

		lbAdd_icon_2.setBounds(49, 10, 43, 43);
		panel_1_1.add(lbAdd_icon_2);

		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(77, 224, 11));
		panel_3.setBounds(541, 428, 208, 45);
		contentPane.add(panel_3);

		lblVip = new JLabel("VIP");
		lblVip.setForeground(new Color(0, 24, 66));
		lblVip.setFont(new Font("Calibri", Font.BOLD, 20));
		lblVip.setBounds(90, 5, 42, 45);
		panel_3.add(lblVip);

		panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(new Color(0, 131, 224));
		panel_1_2.setBounds(541, 472, 208, 60);
		contentPane.add(panel_1_2);

		lb_SLNV_1 = new JLabel("9");
		ArrayList<KhachHang> khList3_1 = new ArrayList<>();
		khList3 = KH_Modifiers.Find_LKH(3);
		lb_SLNV_1.setText(String.valueOf(khList3.size()));
		lb_SLNV_1.setForeground(Color.WHITE);
		lb_SLNV_1.setFont(new Font("Calibri", Font.BOLD, 30));
		lb_SLNV_1.setBounds(96, 15, 50, 45);
		panel_1_2.add(lb_SLNV_1);

		lbAdd_icon_3 = new JLabel("");
		lbAdd_icon_3.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\vip-card.png")
						.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT)));

		lbAdd_icon_3.setBounds(54, 10, 43, 43);
		panel_1_2.add(lbAdd_icon_3);
	}
}
