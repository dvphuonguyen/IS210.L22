package design;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.awt.Cursor;
import javax.swing.JSeparator;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
public class QuanLy_view extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLy_view frame = new QuanLy_view();
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
	public static Connection getJDBCConnection() {
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##demo", "123456");
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
	public void xuatRP() throws JRException {
		//HashMap<String, Object> map = new HashMap<String, Object>();
		JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\src\\design\\baocao (2).jrxml");;
		JasperReport rp =  JasperCompileManager.compileReport(jdesign);
		//map.put("MAHOADON", maHD );
		JasperPrint p  = JasperFillManager.fillReport(rp, null, getJDBCConnection());
		
		JasperViewer.viewReport(p, false);
	}
	public QuanLy_view() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setTitle("Qu\u1EA3n l\u00FD kh\u00E1ch s\u1EA1n");
		setFont(new Font("Tahoma", Font.BOLD, 44));
		setBounds(100, 100, 982, 745);
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
		pnControl.setBounds(10, 227, 967, 488);
		contentPane.add(pnControl);
		pnControl.setLayout(null);
		
		JPanel pnKH =  new JPanel();
		pnKH.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnKH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				QL_KhachHang_view kh = new QL_KhachHang_view();
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
		lbLogOut.setBounds(914, 423, 43, 42);
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
		
		JPanel pnNV = new JPanel();
		pnNV.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnNV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				QL_NV_view qlnv = new QL_NV_view();
				qlnv.setVisible(true);
				close();
			}
		});
		pnNV.setBackground(new Color(0,24,66));
		pnNV.setBounds(346, 57, 295, 105);
		pnControl.add(pnNV);
		pnNV.setLayout(null);
		
		JLabel lbNV = new JLabel("NH\u00C2N VI\u00CAN");
		lbNV.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbNV.setForeground(SystemColor.textHighlightText);

		lbNV.setFont(new Font("Tahoma", Font.BOLD, 21));
		lbNV.setBounds(117, 36, 144, 45);
		pnNV.add(lbNV);
		
		JLabel lbNV_icon = new JLabel("");
		lbNV_icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lbNV_icon.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\user_groups_50px.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		lbNV_icon.setBounds(50, 10, 100, 100);
		pnNV.add(lbNV_icon);
		
		JPanel pnPhong = new JPanel();
		pnPhong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnPhong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
				QL_DichVu_view dv = new QL_DichVu_view();
				dv.setVisible(true);
				close();
			}
		});
		pnDV.setBackground(new Color(0,24,66));
		pnDV.setBounds(35, 187, 295, 105);
		pnControl.add(pnDV);
		pnDV.setLayout(null);
		
		JLabel lbDV = new JLabel("D\u1ECACH V\u1EE4");
		lbDV.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbDV.setFont(new Font("Tahoma", Font.BOLD, 21));
		lbDV.setForeground(SystemColor.textHighlightText);


		lbDV.setBounds(123, 51, 99, 26);
		pnDV.add(lbDV);
		
		JLabel lbDV_Icon = new JLabel("");
		lbDV_Icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbDV_Icon.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\bell_service_50px.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		
		lbDV_Icon.setBounds(48, 10, 85, 100);
		pnDV.add(lbDV_Icon);
		
		JPanel pnHoaDon = new JPanel();
		pnHoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				QL_HoaDon_view qlhd = new QL_HoaDon_view();
				qlhd.setVisible(true);
				close();
			}
		});
		pnHoaDon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnHoaDon.setLayout(null);
		pnHoaDon.setBackground(new Color(0,24,66));
		pnHoaDon.setBounds(346, 187, 295, 105);
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
		
		JPanel pnReport = new JPanel();
		pnReport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					xuatRP();
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		pnReport.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnReport.setBounds(662, 187, 295, 105);
		pnControl.add(pnReport);
		pnReport.setBackground(new Color(0,24,66));
		pnReport.setLayout(null);
		
		JLabel lbReport = new JLabel("B\u00C1O C\u00C1O");
		lbReport.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbReport.setFont(new Font("Tahoma", Font.BOLD, 21));
		lbReport.setBounds(117, 51, 129, 26);
		pnReport.add(lbReport);
		lbReport.setForeground(SystemColor.textHighlightText);

		JLabel lbReport_icon = new JLabel("");
		lbReport_icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbReport_icon.setBounds(52, 40, 45, 44);
		lbReport_icon.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\graph_report_50px.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		pnReport.add(lbReport_icon);
		
		JPanel pnHoaDon_1 = new JPanel();
		pnHoaDon_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnHoaDon_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				QL_KhuyenMai_view qlkm = new QL_KhuyenMai_view();
				qlkm.setVisible(true);
				close();
			}
		});
		pnHoaDon_1.setLayout(null);
		pnHoaDon_1.setBackground(new Color(0, 24, 66));
		pnHoaDon_1.setBounds(32, 326, 295, 80);
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
		pnHoaDon_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				QL_QuyDinh_view a = new QL_QuyDinh_view();
				a.setVisible(true);
				close();
			}
		});
		pnHoaDon_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnHoaDon_1_1.setLayout(null);
		pnHoaDon_1_1.setBackground(new Color(0, 24, 66));
		pnHoaDon_1_1.setBounds(349, 326, 295, 80);
		pnControl.add(pnHoaDon_1_1);
		
		JLabel lbHoaDon_1_1 = new JLabel("QUY \u0110\u1ECANH");
		lbHoaDon_1_1.setForeground(Color.WHITE);
		lbHoaDon_1_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lbHoaDon_1_1.setBounds(118, 33, 136, 26);
		pnHoaDon_1_1.add(lbHoaDon_1_1);
		
		JLabel lbHoaDon_icon_1_1 = new JLabel("");
		lbHoaDon_icon_1_1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\rules_50px.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));

		lbHoaDon_icon_1_1.setBounds(50, 0, 70, 84);
		pnHoaDon_1_1.add(lbHoaDon_icon_1_1);
		
		JPanel pnHoaDon_1_1_1 = new JPanel();
		pnHoaDon_1_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnHoaDon_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Chart_report a = new Chart_report();
				a.setVisible(true);
			}
		});
		pnHoaDon_1_1_1.setLayout(null);
		pnHoaDon_1_1_1.setBackground(new Color(0, 24, 66));
		pnHoaDon_1_1_1.setBounds(663, 326, 295, 80);
		pnControl.add(pnHoaDon_1_1_1);
		
		JLabel lbHoaDon_1_1_1 = new JLabel("TH\u1ED0NG K\u00CA");
		lbHoaDon_1_1_1.setForeground(Color.WHITE);
		lbHoaDon_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lbHoaDon_1_1_1.setBounds(118, 33, 136, 26);
		pnHoaDon_1_1_1.add(lbHoaDon_1_1_1);
		
		JLabel lbHoaDon_icon_1_1_1 = new JLabel("");
		lbHoaDon_icon_1_1_1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\graph_report_50px.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		
		lbHoaDon_icon_1_1_1.setBounds(53, 0, 50, 84);
		pnHoaDon_1_1_1.add(lbHoaDon_icon_1_1_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 197, 977, 2);
		contentPane.add(separator);
	}
}
