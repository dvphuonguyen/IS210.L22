package design;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import java.awt.Dimension;

public class NhanVien_view extends JFrame {

	
	private JPanel contentPane;
	static int flagPhong = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVien_view frame = new NhanVien_view();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close()
	{
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
	/**
	 * Create the frame.
	 */
	public NhanVien_view() {
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setTitle("Qu\u1EA3n l\u00FD kh\u00E1ch s\u1EA1n");
		setFont(new Font("Tahoma", Font.BOLD, 44));
		setBounds(100, 100, 982, 677);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0,24,66));

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\Best memories start here. (15).png").getImage().getScaledInstance(610, 180, Image.SCALE_SMOOTH)));
		lblNewLabel_1.setBounds(193, 22, 609, 164); 
		contentPane.add(lblNewLabel_1);
		
		
		JPanel pnControl = new JPanel();
		pnControl.setBackground(new Color(0,24,66));

		pnControl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnControl.setBounds(10, 227, 967, 413);
		contentPane.add(pnControl);
		pnControl.setLayout(null);
		
		JPanel pnKH =  new JPanel();
		pnKH.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnKH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				NV_KhachHang_view kh = new NV_KhachHang_view();
				kh.setVisible(true);
			
				close();
			}
			
		});
		
		JLabel lbLogOut = new JLabel("");
		lbLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login = new Login();
				login.setVisible(true);
				close();
			}
		});
		lbLogOut.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\logout_rounded_left_30px.png").getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT)));
		lbLogOut.setBounds(914, 361, 43, 42);
		pnControl.add(lbLogOut);
		pnKH.setBackground(new Color(0,24,66));
		pnKH.setBounds(35, 58, 294, 104);
		pnControl.add(pnKH);
		pnKH.setLayout(null);
		
		JLabel lbKH = new JLabel("KH\u00C1CH \r\nH\u00C0NG");
		lbKH.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lbKH.setForeground(SystemColor.textHighlightText);
		lbKH.setFont(new Font("Tahoma", Font.BOLD, 21));
		lbKH.setBounds(120, 24, 160, 66);
		pnKH.add(lbKH);
		
		JLabel lbKH_Icon = new JLabel("");
		lbKH_Icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	
		lbKH_Icon.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\member_50px.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		lbKH_Icon.setBounds(50, 10, 70, 86);
		pnKH.add(lbKH_Icon);
		
		JPanel pnPhong = new JPanel();
		pnPhong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnPhong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				flagPhong = 1;
				Phong_view phong = new Phong_view();
				phong.setVisible(true);
				close();
			}
		});
		pnPhong.setBackground(new Color(0,24,66));
		pnPhong.setBounds(662, 58, 295, 105);
		pnControl.add(pnPhong);
		pnPhong.setLayout(null);
		
		JLabel lbPhong = new JLabel("PH\u00D2NG");
		lbPhong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbPhong.setForeground(SystemColor.textHighlightText);

		lbPhong.setFont(new Font("Tahoma", Font.BOLD, 21));
		lbPhong.setBounds(111, 44, 81, 26);
		pnPhong.add(lbPhong);
		
		JLabel lbPhong_Icon = new JLabel("");
		lbPhong_Icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lbPhong_Icon.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\bunch_of_keys_50px.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		lbPhong_Icon.setBounds(50, 10, 100, 100);
		pnPhong.add(lbPhong_Icon);
		
		JPanel pnDV = new JPanel();
		pnDV.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnDV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				NV_DichVu_view dv = new NV_DichVu_view();
				dv.setVisible(true);
				close();
			}
		});
		pnDV.setBackground(new Color(0,24,66));
		pnDV.setBounds(357, 48, 295, 105);
		pnControl.add(pnDV);
		pnDV.setLayout(null);
		
		JLabel lbDV = new JLabel("D\u1ECACH V\u1EE4");
		lbDV.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbDV.setFont(new Font("Tahoma", Font.BOLD, 21));
		lbDV.setForeground(SystemColor.textHighlightText);


		lbDV.setBounds(135, 51, 99, 26);
		pnDV.add(lbDV);
		
		JLabel lbDV_Icon = new JLabel("");
		lbDV_Icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbDV_Icon.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\bell_service_50px.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		
		lbDV_Icon.setBounds(60, 10, 85, 100);
		pnDV.add(lbDV_Icon);
		
		JPanel pnHoaDon = new JPanel();
		pnHoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			
				NV_HoaDon_view qlhd = new NV_HoaDon_view();
				qlhd.setVisible(true);
				close();
			}
		});
		pnHoaDon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnHoaDon.setLayout(null);
		pnHoaDon.setBackground(new Color(0,24,66));
		pnHoaDon.setBounds(662, 185, 295, 105);
		pnControl.add(pnHoaDon);
		
		JLabel lbHoaDon = new JLabel("HO\u00C1 \u0110\u01A0N");
		lbHoaDon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbHoaDon.setFont(new Font("Tahoma", Font.BOLD, 21));
		lbHoaDon.setBounds(118, 52, 129, 26);
		lbHoaDon.setForeground(SystemColor.textHighlightText);

		pnHoaDon.add(lbHoaDon);
		
		JLabel lbHoaDon_icon = new JLabel("");
		
		lbHoaDon_icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbHoaDon_icon.setBounds(50, 21, 70, 84);
		lbHoaDon_icon.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\bill_50px.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));

		pnHoaDon.add(lbHoaDon_icon);
		
		JPanel pnHoaDon_1 = new JPanel();
		pnHoaDon_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnHoaDon_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NV_KhuyenMai_view qlkm = new NV_KhuyenMai_view();
				qlkm.setVisible(true);
		
			}
		});
		pnHoaDon_1.setLayout(null);
		pnHoaDon_1.setBackground(new Color(0, 24, 66));
		pnHoaDon_1.setBounds(31, 206, 295, 80);
		pnControl.add(pnHoaDon_1);
		
		JLabel lbHoaDon_1 = new JLabel("KHUY\u1EBEN M\u00C3I");
		lbHoaDon_1.setForeground(Color.WHITE);
		lbHoaDon_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lbHoaDon_1.setBounds(118, 33, 155, 26);
		pnHoaDon_1.add(lbHoaDon_1);
		
		JLabel lbHoaDon_icon_1 = new JLabel("");
		lbHoaDon_icon_1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\gift_50px.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		
		lbHoaDon_icon_1.setBounds(50, 0, 70, 84);
		pnHoaDon_1.add(lbHoaDon_icon_1);
		
		JPanel pnHoaDon_1_1 = new JPanel();
		pnHoaDon_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnHoaDon_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NV_QuyDinh_view  a = new NV_QuyDinh_view();
				a.setVisible(true);
				close();
			}
		});
		pnHoaDon_1_1.setLayout(null);
		pnHoaDon_1_1.setBackground(new Color(0, 24, 66));
		pnHoaDon_1_1.setBounds(357, 206, 295, 80);
		pnControl.add(pnHoaDon_1_1);
		
		JLabel lbHoaDon_1_1 = new JLabel("QUY \u0110\u1ECANH");
		lbHoaDon_1_1.setForeground(Color.WHITE);
		lbHoaDon_1_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lbHoaDon_1_1.setBounds(135, 32, 136, 26);
		pnHoaDon_1_1.add(lbHoaDon_1_1);
		
		JLabel lbHoaDon_icon_1_1 = new JLabel("");
		lbHoaDon_icon_1_1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\rules_50px.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));

		lbHoaDon_icon_1_1.setBounds(60, 0, 70, 84);
		pnHoaDon_1_1.add(lbHoaDon_icon_1_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 197, 977, 2);
		contentPane.add(separator);
		
	}
}
