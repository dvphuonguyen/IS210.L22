package design;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Class.CHITIETPTP;
import Class.CHITIETTTP;
import Class.ChiTietPDP;
import Class.KhachHang;
import Class.KhuyenMai;
import Class.LoaiPhong;
import Class.PhieuDatPhong;
import Class.PhieuThuePhong;
import Class.Phong;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Add_PTP_fromPDP_view extends JFrame {

	private JPanel contentPane;
	private JTextField textField_name;
	private JTextField textField_sdt;
	private JTextField textField_cmnd;
	ArrayList<KhachHang> listKH = new ArrayList<KhachHang>();
	ArrayList ListPDP = new ArrayList();
	HashMap<String, String> abc;
	Login a = new Login();
	long soNgay = 0;
	static int flag = 0;
	static int MaNV, MaKH, MaPhong, MaPDP;
	static String tenPhong;
	PhieuDatPhong_view pdp = new PhieuDatPhong_view();
	private JTable table;
	DefaultTableModel tableModel;
	ArrayList<PhieuThuePhong> listMapdp = new ArrayList();
	private JComboBox cb_SLKhach;
	ArrayList<KhuyenMai> listKM = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_PTP_fromPDP_view frame = new Add_PTP_fromPDP_view();
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
		ListPDP = DATvaTHUEphong_Modifiers.findAll_CTPDP(PhieuDatPhong_view.PDP);
		HashMap<String, String> p;

		for (int i = 0; i < ListPDP.size(); i++) {
			p = (HashMap<String, String>) ListPDP.get(i);
			tableModel.addRow(new Object[] { p.get("TENPHONG"), p.get("NGAYNP"), p.get("NGAYTPDD") });
		}
	}

	public Add_PTP_fromPDP_view() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 858, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(217, 232, 243));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		KH_Modifiers mo = new KH_Modifiers();
		listKH = mo.findAll();
		JComboBox cb_cmnd = new JComboBox();
		cb_cmnd.setVisible(false);
		cb_cmnd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_cmnd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (KhachHang kh : listKH) {
					textField_cmnd.setText(kh.getCccdKH());
					textField_name.setText(kh.getTenKH());
					textField_sdt.setText(kh.getSdtKH());
				}
				cb_cmnd.setVisible(false);
			}
		});

		JComboBox cb_sdt = new JComboBox();
		cb_sdt.setVisible(false);
		cb_sdt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_sdt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (KhachHang kh : listKH) {
					textField_sdt.setText(kh.getSdtKH());
					textField_cmnd.setText(kh.getCccdKH());
					textField_name.setText(kh.getTenKH());
				}
				cb_sdt.setVisible(false);
			}
		});
		cb_sdt.setBounds(157, 260, 196, 30);
		contentPane.add(cb_sdt);
		cb_cmnd.setBounds(157, 319, 196, 30);
		contentPane.add(cb_cmnd);

		JLabel lblLpPhiuThu = new JLabel("L\u1EACP PHI\u1EBEU THU\u00CA PH\u00D2NG");
		lblLpPhiuThu.setForeground(new Color(4, 51, 134));
		lblLpPhiuThu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblLpPhiuThu.setBounds(223, 28, 391, 42);
		contentPane.add(lblLpPhiuThu);

		JLabel lblThngTinKhch = new JLabel("Thông tin khách hàng");
		lblThngTinKhch.setForeground(new Color(4, 51, 134));
		lblThngTinKhch.setFont(new Font("Calibri", Font.PLAIN, 23));
		lblThngTinKhch.setBounds(89, 99, 233, 42);
		contentPane.add(lblThngTinKhch);

		JLabel lblThngTinThu = new JLabel("Thông tin thuê phòng");
		lblThngTinThu.setForeground(new Color(4, 51, 134));
		lblThngTinThu.setFont(new Font("Calibri", Font.PLAIN, 23));
		lblThngTinThu.setBounds(500, 99, 222, 42);
		contentPane.add(lblThngTinThu);

		JLabel lblThngTinKhch_1 = new JLabel("________________________");
		lblThngTinKhch_1.setForeground(new Color(4, 51, 134));
		lblThngTinKhch_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThngTinKhch_1.setBounds(57, 111, 310, 42);
		contentPane.add(lblThngTinKhch_1);

		JLabel lblThngTinKhch_1_1 = new JLabel("______________________________");
		lblThngTinKhch_1_1.setForeground(new Color(4, 51, 134));
		lblThngTinKhch_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThngTinKhch_1_1.setBounds(433, 111, 389, 42);
		contentPane.add(lblThngTinKhch_1_1);

		JLabel lbInput_Name_2 = new JLabel("Họ tên:");
		lbInput_Name_2.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbInput_Name_2.setForeground(new Color(4, 51, 134));
		lbInput_Name_2.setBounds(30, 182, 107, 22);
		contentPane.add(lbInput_Name_2);

		textField_name = new JTextField();
		textField_name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_name.setColumns(10);
		textField_name.setBounds(157, 178, 196, 34);
		contentPane.add(textField_name);

		JLabel lbInput_Name = new JLabel("Số điện thoại : ");
		lbInput_Name.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbInput_Name.setForeground(new Color(4, 51, 134));
		lbInput_Name.setBounds(30, 243, 122, 22);
		contentPane.add(lbInput_Name);

		textField_sdt = new JTextField();

		textField_sdt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				ArrayList<KhachHang> list = new ArrayList<KhachHang>();
				list = KH_Modifiers.FindbySDT(textField_sdt.getText());
				for (KhachHang kh : list) {
					cb_sdt.addItem(kh.getSdtKH());

					cb_sdt.setVisible(true);
				}
			}
		});

		textField_sdt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_sdt.setColumns(10);
		textField_sdt.setBounds(157, 239, 196, 34);
		contentPane.add(textField_sdt);

		JLabel lbInput_Name_1 = new JLabel("CMND:");
		lbInput_Name_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbInput_Name_1.setBounds(30, 304, 107, 22);
		lbInput_Name_1.setForeground(new Color(4, 51, 134));
		contentPane.add(lbInput_Name_1);

		textField_cmnd = new JTextField();

		textField_cmnd.addKeyListener(new KeyAdapter() {
			@Override

			public void keyReleased(KeyEvent e) {
				ArrayList<KhachHang> list = new ArrayList<KhachHang>();
				list = KH_Modifiers.FindbyCCCD(textField_cmnd.getText());
				for (KhachHang kh : list) {
					cb_cmnd.addItem(kh.getCccdKH());
					cb_cmnd.setVisible(true);
				}
			}
		});

		textField_cmnd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_cmnd.setColumns(10);
		textField_cmnd.setBounds(157, 300, 196, 34);
		contentPane.add(textField_cmnd);

		JLabel lbInput_Name_3 = new JLabel("Số lượng khách:");
		lbInput_Name_3.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbInput_Name_3.setBounds(406, 355, 124, 22);
		lbInput_Name_3.setForeground(new Color(4, 51, 134));
		contentPane.add(lbInput_Name_3);

		cb_SLKhach = new JComboBox();
		cb_SLKhach
				.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		cb_SLKhach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_SLKhach.setFocusable(false);
		cb_SLKhach.setBounds(569, 351, 50, 24);
		
		contentPane.add(cb_SLKhach);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(406, 177, 389, 156);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "TENPHONG", "NGAYNP", "NGAYTP" }) {
			Class[] columnTypes = new Class[] { String.class, Object.class, Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableModel = (DefaultTableModel) table.getModel();
		showAll();
		scrollPane.setViewportView(table);
		JComboBox cb_km = new JComboBox();
		cb_km.setModel(new DefaultComboBoxModel(new String[] { "Chọn..." }));
		listKM = KhuyenMai_Modifiers.findAll();
		for (KhuyenMai km : listKM)
			cb_km.addItem(km.getTenKM());
		cb_km.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_km.setFocusable(false);
		cb_km.setBounds(569, 397, 226, 24);
		contentPane.add(cb_km);

		JLabel lbInput_Name_2_1_2_1 = new JLabel("Chọn khuyến mãi:");
		lbInput_Name_2_1_2_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbInput_Name_2_1_2_1.setBounds(405, 401, 139, 22);
		lbInput_Name_2_1_2_1.setForeground(new Color(4, 51, 134));
		contentPane.add(lbInput_Name_2_1_2_1);
		
		JPanel panel_add = new JPanel();
		panel_add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ten = textField_name.getText();
				String sdt = textField_sdt.getText();
				String cmnd = textField_cmnd.getText();

				MaKH = 0;
				listKH = KH_Modifiers.FindbyCCCD(textField_cmnd.getText());
				for (KhachHang kh : listKH) {
					MaKH = kh.getMaKH();
				}
				MaNV = a.MaNV;
				MaPDP = pdp.PDP;
				try {

					PhieuThuePhong ptp = new PhieuThuePhong(MaNV, MaKH, 0, MaPDP , 1);
					DATvaTHUEphong_Modifiers.Add_ThuePhong(ptp);
					DATvaTHUEphong_Modifiers.Update_TinhTrangPDP(2, MaPDP);
					JOptionPane.showMessageDialog(null, "Thêm thông tin phiếu thuê thành công.");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		panel_add.setLayout(null);
		panel_add.setBackground(new Color(217, 232, 243));
		panel_add.setBounds(140, 372, 158, 55);
		contentPane.add(panel_add);
		
		JLabel lblThm = new JLabel("THÊM");
		lblThm.setForeground(new Color(4, 51, 134));
		lblThm.setFont(new Font("Calibri", Font.BOLD, 25));
		lblThm.setBounds(68, 10, 107, 45);
		panel_add.add(lblThm);
		
		JLabel lbAdd_icon = new JLabel("");
		lbAdd_icon.setBounds(26, 0, 32, 55);
		lbAdd_icon.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\plus_32px.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));

		panel_add.add(lbAdd_icon);
		
		JPanel panel_add_1 = new JPanel();
		panel_add_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SL = 0, maPTP = 0, maPhong = 0;
				double PhuThu = 0;
				String tenPhong = null, ngayNP = null, ngayTP = null;
				Phong a = new Phong();

				listMapdp = DATvaTHUEphong_Modifiers.FindMAPTP(PhieuDatPhong_view.PDP);
				for (PhieuThuePhong abc : listMapdp)
					maPTP = abc.getMaPTP();

				int SelectedIndex = table.getSelectedRow();
				if (SelectedIndex > -1) {
					tenPhong = String.valueOf(table.getValueAt(SelectedIndex, 0));
					a = Phong_Modifiers.Find_NAME(tenPhong);
					ngayNP = String.valueOf(table.getValueAt(SelectedIndex, 1));
					ngayTP = String.valueOf(table.getValueAt(SelectedIndex, 2));
					SL = Integer.valueOf((String) cb_SLKhach.getSelectedItem());
					int test = -1;
					if (tenPhong.contains("Connecting") == true) {
						if (SL == 5)
							PhuThu = PhuThu + 0.1;
						else if (SL > 5)
							test = JOptionPane.showConfirmDialog(null,
									"Số lượng khách vượt quy định. Vui lòng đặt thêm phòng", "Warning", 2);

					}

					else if (tenPhong.contains("Connecting") == false) {
						if (SL == 3)
							PhuThu = PhuThu + 0.1;
						else if (SL > 3)
							test = JOptionPane.showConfirmDialog(null,
									"Số lượng khách vượt quy định. Vui lòng đặt thêm phòng", "Warning", 2);
					} else
						PhuThu = 0;

					String quocTich = KH_Modifiers.Find_quocTich(PhieuDatPhong_view.makh);
					if (quocTich.contains("Việt Nam") == false)
						PhuThu += 0.25;

					String tenKM = String.valueOf(cb_km.getSelectedItem());
					int maKM = KhuyenMai_Modifiers.Find_MaKM(tenKM);
					float giamGia = KhuyenMai_Modifiers.Find_giamGia(maKM,
							KH_Modifiers.Find_MaLKH(PhieuDatPhong_view.makh));

					ArrayList<KhuyenMai> list = new ArrayList<>();
					list = KhuyenMai_Modifiers.Find_ngay(tenKM);
					long soNgayKM = 0;
					for (KhuyenMai km : list) {
						if (java.sql.Date.valueOf(ngayNP).compareTo(km.getTuNgay()) >= 0
								&& java.sql.Date.valueOf(ngayTP).compareTo(km.getDenNgay()) <= 0) {
							DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

							Calendar cal = Calendar.getInstance();
							cal.setTime(new Date(soNgayKM));
							cal.add(Calendar.HOUR, 24);

							java.util.Date date1 = null;
							java.util.Date date2 = null;

							try {
								date1 = simpleDateFormat.parse(ngayNP);
								date2 = simpleDateFormat.parse(ngayTP);
								long getDiff = date2.getTime() - date1.getTime();
								soNgayKM = TimeUnit.MILLISECONDS.toDays(getDiff) + 1;
							} catch (Exception e3) {
								e3.printStackTrace();
							}
						} else if (java.sql.Date.valueOf(ngayNP).compareTo(km.getTuNgay()) >= 0
								&& java.sql.Date.valueOf(ngayTP).compareTo(km.getDenNgay()) >= 0) {
							DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

							Calendar cal = Calendar.getInstance();
							cal.setTime(new Date(soNgayKM));
							cal.add(Calendar.HOUR, 24);

							java.util.Date date1 = null;
							java.util.Date date2 = null;

							try {
								date1 = simpleDateFormat.parse(ngayNP);
								date2 = simpleDateFormat.parse(String.valueOf(km.getDenNgay()));
								long getDiff = date2.getTime() - date1.getTime();
								soNgayKM = TimeUnit.MILLISECONDS.toDays(getDiff) + 1;
							} catch (Exception e3) {
								e3.printStackTrace();
							}
						} else if (java.sql.Date.valueOf(ngayNP).compareTo(km.getTuNgay()) <= 0
								&& java.sql.Date.valueOf(ngayTP).compareTo(km.getDenNgay()) <= 0) {
							DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

							Calendar cal = Calendar.getInstance();
							cal.setTime(new Date(soNgayKM));
							cal.add(Calendar.HOUR, 24);

							java.util.Date date1 = null;
							java.util.Date date2 = null;

							try {
								date1 = simpleDateFormat.parse(String.valueOf(km.getTuNgay()));
								date2 = simpleDateFormat.parse(ngayTP);
								long getDiff = date2.getTime() - date1.getTime();
								soNgayKM = TimeUnit.MILLISECONDS.toDays(getDiff) + 1;
							} catch (Exception e3) {
								e3.printStackTrace();
							}
						} else if (java.sql.Date.valueOf(ngayNP).compareTo(km.getTuNgay()) <= 0
								&& java.sql.Date.valueOf(ngayTP).compareTo(km.getDenNgay()) >= 0) {
							DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

							Calendar cal = Calendar.getInstance();
							cal.setTime(new Date(soNgayKM));
							cal.add(Calendar.HOUR, 24);

							java.util.Date date1 = null;
							java.util.Date date2 = null;

							try {
								date1 = simpleDateFormat.parse(String.valueOf(km.getTuNgay()));
								date2 = simpleDateFormat.parse(String.valueOf(km.getDenNgay()));
								long getDiff = date2.getTime() - date1.getTime();
								soNgayKM = TimeUnit.MILLISECONDS.toDays(getDiff) + 1;
							} catch (Exception e3) {
								e3.printStackTrace();
							}
						}
					}
					if (soNgayKM < 0)
						soNgayKM = 0;

					long soNgay = 0;

					DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

					Calendar cal = Calendar.getInstance();
					cal.setTime(new Date(soNgay));
					cal.add(Calendar.HOUR, 24);

					java.util.Date date1 = null;
					java.util.Date date2 = null;

					try {
						date1 = simpleDateFormat.parse(ngayNP);
						date2 = simpleDateFormat.parse(ngayTP);
						long getDiff = date2.getTime() - date1.getTime();
						soNgay = TimeUnit.MILLISECONDS.toDays(getDiff) + 1;
					} catch (Exception e3) {
						e3.printStackTrace();
					}

					int GiaPhong = DATvaTHUEphong_Modifiers.FindGiaPhong(tenPhong);
					float temp_TongTien = 0;
					if (soNgayKM < soNgay) {
						temp_TongTien = (float) ((float) GiaPhong * (float) soNgayKM * (1 - giamGia / 100)
								+ (float) GiaPhong * ((float) soNgay - (float) soNgayKM)
								+ (float) GiaPhong * (float) soNgay * PhuThu);
					} else if (soNgayKM == soNgay) {
						temp_TongTien = (float) ((float) GiaPhong * (float) soNgay * (1 - giamGia / 100)
								+ (float) GiaPhong * (float) soNgay * PhuThu);
					} else if (soNgayKM == 0) {
						temp_TongTien = (float) ((float) GiaPhong * (float) soNgay
								+ (float) GiaPhong * (float) soNgay * PhuThu);
					}

					int old_TongTien = DATvaTHUEphong_Modifiers.FindTienPhong(maPTP);
					int TongTien = (int) temp_TongTien + old_TongTien;
//					System.out.println("soNgayKM: " + soNgayKM);
//					System.out.println("soNgay: " + soNgay);
//					System.out.println("GiaPhong: " + GiaPhong);
//					System.out.println("giamGia: " + giamGia);
//					System.out.println("PhuThu: " + PhuThu);
//					System.out.println("temp_TongTien: " + (int) temp_TongTien);
//					System.out.println("TongTien: " + (int) TongTien);
//					System.out.println("test: " + test);

					if (test == -1) {
						try {

							CHITIETPTP ctptp = new CHITIETPTP(maPTP, a.getMaPhong(),
									java.sql.Date.valueOf(ngayNP), java.sql.Date.valueOf(ngayTP), SL, (float) PhuThu);
							DATvaTHUEphong_Modifiers.Add_CTPTP(ctptp);
						
							Phong_Modifiers.Update_CTTTP(a.getMaPhong(), java.sql.Date.valueOf(ngayNP), java.sql.Date.valueOf(ngayTP));
							DATvaTHUEphong_Modifiers.Update_TienPhong(TongTien, maPTP);
							JOptionPane.showMessageDialog(null, "Thêm phòng vào phiếu thuê thành công");
							
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		panel_add_1.setLayout(null);
		panel_add_1.setBackground(new Color(217, 232, 243));
		panel_add_1.setBounds(514, 450, 158, 55);
		contentPane.add(panel_add_1);
		
		JLabel lblThm_1 = new JLabel("THÊM");
		lblThm_1.setForeground(new Color(4, 51, 134));
		lblThm_1.setFont(new Font("Calibri", Font.BOLD, 25));
		lblThm_1.setBounds(68, 10, 107, 45);
		panel_add_1.add(lblThm_1);
		
		JLabel lbAdd_icon_1 = new JLabel("");
		lbAdd_icon_1.setBounds(26, 0, 32, 55);
		lbAdd_icon_1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\plus_32px.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));

		panel_add_1.add(lbAdd_icon_1);
		
		JLabel lbReturn_1 = new JLabel("");
		lbReturn_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Phong_view qlp = new Phong_view();
				qlp.setVisible(true);
				close();
			}
		});
		lbReturn_1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\logout.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));

		lbReturn_1.setBounds(789, 503, 45, 42);
		contentPane.add(lbReturn_1);
	}

	public void gui() {
		if (abc != null) {
			textField_name.setText(abc.get("TENKH"));
			textField_sdt.setText(abc.get("SDTKH"));
			textField_cmnd.setText(abc.get("CCCDKH"));

		}
	}
}
