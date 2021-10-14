package design;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Class.CHITIETPTP;
import Class.CHITIETTTP;
import Class.ChiTietPDP;
import Class.KhuyenMai;
import Class.LoaiPhong;
import Class.Phong;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.UIManager;
import java.awt.Cursor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Add_PTP_TrucTiep extends JFrame {

	private JPanel contentPane;
	ArrayList<Phong> emptyList = new ArrayList<>();
	ArrayList<KhuyenMai> listKM = new ArrayList<>();
	private JComboBox cb_SL;
	private JComboBox cb_emptyRoom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_PTP_TrucTiep frame = new Add_PTP_TrucTiep();
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

	public Add_PTP_TrucTiep() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 807, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(217, 232, 243));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblThmPhiuThu = new JLabel("TH\u00CAM PHI\u1EBEU THU\u00CA PH\u00D2NG");
		lblThmPhiuThu.setForeground(new Color(4, 51, 134));
		lblThmPhiuThu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblThmPhiuThu.setBounds(204, 22, 419, 42);
		contentPane.add(lblThmPhiuThu);

		JLabel lbInput_Name_2_1_2 = new JLabel("Chọn phòng:");
		lbInput_Name_2_1_2.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbInput_Name_2_1_2.setForeground(new Color(4, 51, 134));
		lbInput_Name_2_1_2.setBounds(93, 260, 139, 22);
		contentPane.add(lbInput_Name_2_1_2);

		cb_emptyRoom = new JComboBox();
		cb_emptyRoom.setModel(new DefaultComboBoxModel(new String[] { "Chọn..." }));
		

		cb_emptyRoom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_emptyRoom.setFocusable(false);
		cb_emptyRoom.setBounds(140, 304, 226, 24);
		contentPane.add(cb_emptyRoom);

		JLabel lbInput_Name_2_1 = new JLabel("Ngày nhận phòng:");
		lbInput_Name_2_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbInput_Name_2_1.setForeground(new Color(4, 51, 134));
		lbInput_Name_2_1.setBounds(93, 74, 139, 22);
		contentPane.add(lbInput_Name_2_1);

		JComboBox cb_km = new JComboBox();
		cb_km.setModel(new DefaultComboBoxModel(new String[] { "Chọn..." }));
		listKM = KhuyenMai_Modifiers.findAll();
		for (KhuyenMai km : listKM)
			cb_km.addItem(km.getTenKM());
		cb_km.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_km.setFocusable(false);
		cb_km.setBounds(498, 224, 226, 24);
		contentPane.add(cb_km);

		JComboBox cb_dayNP = new JComboBox();
		cb_dayNP.setModel(new DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
				"27", "28", "29", "30", "31" }));
		cb_dayNP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_dayNP.setFocusable(false);
		cb_dayNP.setBounds(140, 119, 50, 24);
		contentPane.add(cb_dayNP);

		JComboBox cb_monthNP = new JComboBox();
		cb_monthNP.setModel(new DefaultComboBoxModel(
				new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
		cb_monthNP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_monthNP.setFocusable(false);
		cb_monthNP.setBounds(212, 121, 50, 21);
		contentPane.add(cb_monthNP);

		JComboBox cb_yearNP = new JComboBox();
		cb_yearNP.setModel(new DefaultComboBoxModel(
				new String[] { "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011",
						"2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999",
						"1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990" }));
		cb_yearNP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_yearNP.setFocusable(false);
		cb_yearNP.setBounds(277, 121, 89, 21);
		contentPane.add(cb_yearNP);

		JLabel lbInput_Name_2_1_1 = new JLabel("Ngày trả phòng:");
		lbInput_Name_2_1_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbInput_Name_2_1_1.setForeground(new Color(4, 51, 134));
		lbInput_Name_2_1_1.setBounds(93, 169, 186, 22);
		contentPane.add(lbInput_Name_2_1_1);

		JComboBox cb_dayTP = new JComboBox();
		cb_dayTP.setModel(new DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
				"27", "28", "29", "30", "31" }));
		cb_dayTP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_dayTP.setFocusable(false);
		cb_dayTP.setBounds(140, 212, 50, 24);
		contentPane.add(cb_dayTP);

		JComboBox cb_monthTP = new JComboBox();
		cb_monthTP.setModel(new DefaultComboBoxModel(
				new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
		cb_monthTP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_monthTP.setFocusable(false);
		cb_monthTP.setBounds(212, 214, 50, 21);
		contentPane.add(cb_monthTP);

		JComboBox cb_yearTP = new JComboBox();
		cb_yearTP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String dateNP = String.valueOf(cb_dayNP.getSelectedItem());
				String monthNP = String.valueOf(cb_monthNP.getSelectedItem());
				String yearNP = String.valueOf(cb_yearNP.getSelectedItem());
				String ngayNP = yearNP + "-" + monthNP + "-" + dateNP;
				
				String dateTP = String.valueOf(cb_dayTP.getSelectedItem());
				String monthTP = String.valueOf(cb_monthTP.getSelectedItem());
				String yearTP = String.valueOf(cb_yearTP.getSelectedItem());
				String ngayTP = yearTP + "-" + monthTP + "-" + dateTP;
				
				
				emptyList = DATvaTHUEphong_Modifiers.FindPhongTrong(java.sql.Date.valueOf(ngayNP), java.sql.Date.valueOf(ngayTP));
				for (Phong a : emptyList)
				{
						cb_emptyRoom.addItem(a.getTenPhong());
				}
			}
		});
		cb_yearTP.setModel(new DefaultComboBoxModel(
				new String[] { "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011",
						"2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999",
						"1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990" }));
		cb_yearTP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_yearTP.setFocusable(false);
		cb_yearTP.setBounds(277, 214, 89, 21);
		contentPane.add(cb_yearTP);

		JLabel lbInput_Name_2_1_1_1 = new JLabel("Số lượng khách: ");
		lbInput_Name_2_1_1_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbInput_Name_2_1_1_1.setForeground(new Color(4, 51, 134));
		lbInput_Name_2_1_1_1.setBounds(451, 92, 131, 22);
		contentPane.add(lbInput_Name_2_1_1_1);

		cb_SL = new JComboBox();
		cb_SL.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		cb_SL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_SL.setFocusable(false);
		cb_SL.setBounds(498, 136, 50, 24);
		contentPane.add(cb_SL);

		JLabel lbInput_Name_2_1_2_1 = new JLabel("Chọn khuyến mãi");
		lbInput_Name_2_1_2_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbInput_Name_2_1_2_1.setForeground(new Color(4, 51, 134));
		lbInput_Name_2_1_2_1.setBounds(451, 179, 139, 22);
		contentPane.add(lbInput_Name_2_1_2_1);
		
		JPanel panel_add = new JPanel();
		panel_add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String tenPhong = (String) cb_emptyRoom.getSelectedItem();
				Phong a = new Phong();
				a = Phong_Modifiers.Find_NAME(tenPhong);

				String dateNP = String.valueOf(cb_dayNP.getSelectedItem());
				String monthNP = String.valueOf(cb_monthNP.getSelectedItem());
				String yearNP = String.valueOf(cb_yearNP.getSelectedItem());
				String ngayNP = yearNP + "-" + monthNP + "-" + dateNP;

				String dateTP = String.valueOf(cb_dayTP.getSelectedItem());
				String monthTP = String.valueOf(cb_monthTP.getSelectedItem());
				String yearTP = String.valueOf(cb_yearTP.getSelectedItem());
				String ngayTP = yearTP + "-" + monthTP + "-" + dateTP;

				double PhuThu = 0;
				int SL = Integer.valueOf(String.valueOf(cb_SL.getSelectedItem()));
				if (tenPhong.contains("Connecting") == true) {
					if (SL == 5)
						PhuThu = PhuThu + 0.1;
					else if (SL > 5)
						JOptionPane.showConfirmDialog(null, "Số lượng khách vượt quy định. Vui lòng đặt thêm phòng",
								"Warning", 2);
				}

				else if (tenPhong.contains("Connecting") == false) {
					if (SL == 3)
						PhuThu = PhuThu + 0.1;
					else if (SL > 3)
						JOptionPane.showConfirmDialog(null, "Số lượng khách vượt quy định. Vui lòng đặt thêm phòng",
								"Warning", 2);
				} else
					PhuThu = 0;

				String quocTich = KH_Modifiers.Find_quocTich(PhieuThuePhong_view.MaKH);
				if (quocTich.contains("Việt Nam") == false)
					PhuThu += 0.25;

				String tenKM = String.valueOf(cb_km.getSelectedItem());
				int maKM = KhuyenMai_Modifiers.Find_MaKM(tenKM);
				float giamGia = KhuyenMai_Modifiers.Find_giamGia(maKM,
						KH_Modifiers.Find_MaLKH(PhieuThuePhong_view.MaKH));

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
//				System.out.println(giamGia);
//				System.out.println("maPTP: "+PhieuThuePhong_view.PTP);
//				System.out.println("maP: "+a.getMaPhong());
//				System.out.println("SL: "+SL);
//				System.out.println("PhuThu: "+PhuThu);
		
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
					temp_TongTien = (float) ((float) GiaPhong *  (float)soNgayKM * (1-giamGia/100)
							 + (float) GiaPhong * ((float) soNgay - (float) soNgayKM)
							 + (float) GiaPhong * (float) soNgay * PhuThu);
				}
				else if (soNgayKM == soNgay) {
					temp_TongTien = (float) ((float) GiaPhong *  (float)soNgay * (1-giamGia/100)
							 + (float) GiaPhong * (float) soNgay * PhuThu);
				}
				else if (soNgayKM == 0) {
					temp_TongTien = (float) ((float) GiaPhong *  (float)soNgay
							 + (float) GiaPhong * (float) soNgay * PhuThu);
				}
				System.out.println("soNgayKM: " + soNgayKM);
				System.out.println("soNgay: " + soNgay);
				System.out.println("GiaPhong: " + GiaPhong);
				System.out.println("giamGia: " + giamGia);
				System.out.println("PhuThu: " + PhuThu);
				System.out.println("temp_TongTien: " + (int)temp_TongTien);
				int old_TongTien = DATvaTHUEphong_Modifiers.FindTienPhong(PhieuThuePhong_view.PTP);
				int TongTien = (int)temp_TongTien + old_TongTien;
				try {
					
					CHITIETPTP ctptp = new CHITIETPTP( PhieuThuePhong_view.PTP, a.getMaPhong(), java.sql.Date.valueOf(ngayNP), java.sql.Date.valueOf(ngayTP),
							SL, (float)PhuThu);
					DATvaTHUEphong_Modifiers.Add_CTPTP(ctptp);;
					
					CHITIETTTP ctttp = new CHITIETTTP(a.getMaPhong(), 3, java.sql.Date.valueOf(ngayNP), java.sql.Date.valueOf(ngayTP));
					Phong_Modifiers.Add(ctttp);
					//Phong_Modifiers.Update(a.getMaPhong(), 3);
					DATvaTHUEphong_Modifiers.Update_TienPhong(TongTien, PhieuThuePhong_view.PTP);
					
					close();
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		panel_add.setLayout(null);
		panel_add.setBackground(new Color(217, 232, 243));
		panel_add.setBounds(498, 288, 158, 55);
		contentPane.add(panel_add);
		
		JLabel lblThm = new JLabel("THÊM");
		lblThm.setForeground(new Color(4, 51, 134));
		lblThm.setFont(new Font("Calibri", Font.BOLD, 25));
		lblThm.setBounds(68, 10, 107, 45);
		panel_add.add(lblThm);
		
		JLabel lbAdd_icon = new JLabel("");
		lbAdd_icon.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\plus_32px.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));

		lbAdd_icon.setBounds(26, 0, 32, 55);
		panel_add.add(lbAdd_icon);

	}
}
