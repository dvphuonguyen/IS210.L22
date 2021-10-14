package design;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Cursor;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Class.DichVu;
import Class.LoaiPhong;
import Class.NhanVien;
import Class.Phong;

import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Phong_view extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel tableModel;
	ArrayList phong = new ArrayList();
	Add_ThongTinKH_view a = new Add_ThongTinKH_view();
	Phong p;
	static int flag = 0;
	static int flagReturn = NhanVien_view.flagPhong, maP = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Phong_view frame = new Phong_view();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 */

	public void showAll() {
		// xoá dữ liêu table trước khi export dữ liệu mới
		for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
		phong = Phong_Modifiers.findAll();

		HashMap<String, String> p;

		for (int i = 0; i < phong.size(); i++) {
			p = (HashMap<String, String>) phong.get(i);
			tableModel.addRow(
					new Object[] { p.get("maP"), p.get("tenP"), p.get("tenLP"), p.get("giaP") });
		}

	}

	public void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}

	public Phong_view() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 785, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(217, 232, 243));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblQunLPhng = new JLabel("QUẢN LÝ PHÒNG");
		lblQunLPhng.setForeground(new Color(4, 51, 134));
		lblQunLPhng.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 30));
		lblQunLPhng.setBounds(283, 10, 217, 51);
		contentPane.add(lblQunLPhng);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
		scrollPane.setBounds(41, 111, 708, 309);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MAPHONG", "TENPHONG", "TENLOAIPHONG", "DONGIA"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(2).setPreferredWidth(88);
		table.getColumnModel().getColumn(2).setMinWidth(88);
		tableModel = (DefaultTableModel) table.getModel();
		showAll();
		scrollPane.setViewportView(table);
		JLabel lbReturn = new JLabel("");
		
		lbReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (flagReturn == 1) {
					NhanVien_view nv = new NhanVien_view();
					nv.setVisible(true);
					close();
				} else if (flagReturn == 0) {
					QuanLy_view ql = new QuanLy_view();
					ql.setVisible(true);
					close();
				}
			}
		});
		lbReturn.setBounds(716, 631, 45, 42);
		lbReturn.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\logout.png")
						.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));

		contentPane.add(lbReturn);

		JPanel panel_update_2 = new JPanel();
		panel_update_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_update_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				flag = 1;
				Add_ThongTinKH_view pdp = new Add_ThongTinKH_view();
				pdp.setVisible(true);
			}
		});
		panel_update_2.setLayout(null);
		panel_update_2.setBackground(new Color(217, 232, 243));
		panel_update_2.setBounds(122, 500, 224, 60);
		contentPane.add(panel_update_2);

		JLabel lblThmPhiut = new JLabel("Thêm phiếu đặt");
		lblThmPhiut.setForeground(new Color(4, 51, 134));
		lblThmPhiut.setFont(new Font("Calibri", Font.BOLD, 22));
		lblThmPhiut.setBackground(new Color(217, 232, 243));
		lblThmPhiut.setBounds(50, 23, 177, 30);
		panel_update_2.add(lblThmPhiut);

		JLabel lbAdd_icon = new JLabel("");
		lbAdd_icon.setBounds(10, 13, 51, 43);
		lbAdd_icon.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\plus_32px.png")
						.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));

		panel_update_2.add(lbAdd_icon);

		JPanel panel_update_2_1 = new JPanel();
		panel_update_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_update_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				flag = 2;
				Add_ThongTinKH_view pdp = new Add_ThongTinKH_view();
				pdp.setVisible(true);
			}
		});
		panel_update_2_1.setLayout(null);
		panel_update_2_1.setBackground(new Color(217, 232, 243));
		panel_update_2_1.setBounds(122, 581, 224, 60);
		contentPane.add(panel_update_2_1);

		JLabel lblThmPhiuThu = new JLabel("Thêm phiếu thuê");
		lblThmPhiuThu.setForeground(new Color(4, 51, 134));
		lblThmPhiuThu.setFont(new Font("Calibri", Font.BOLD, 22));
		lblThmPhiuThu.setBackground(new Color(217, 232, 243));
		lblThmPhiuThu.setBounds(50, 23, 177, 30);
		panel_update_2_1.add(lblThmPhiuThu);

		JLabel lbAdd_icon_1 = new JLabel("");
		lbAdd_icon_1.setBounds(10, 13, 51, 43);
		lbAdd_icon_1.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\plus_32px.png")
						.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));

		panel_update_2_1.add(lbAdd_icon_1);

		JPanel panel_update_2_2 = new JPanel();
		panel_update_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PhieuDatPhong_view pdp = new PhieuDatPhong_view();
				pdp.setVisible(true);
				close();
			}
		});
		panel_update_2_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_update_2_2.setLayout(null);
		panel_update_2_2.setBackground(new Color(217, 232, 243));
		panel_update_2_2.setBounds(428, 500, 252, 60);
		contentPane.add(panel_update_2_2);

		JLabel lblQunLPhiu = new JLabel("Quản lý phiếu đặt");
		lblQunLPhiu.setForeground(new Color(4, 51, 134));
		lblQunLPhiu.setFont(new Font("Calibri", Font.BOLD, 22));
		lblQunLPhiu.setBackground(new Color(217, 232, 243));
		lblQunLPhiu.setBounds(50, 23, 177, 30);
		panel_update_2_2.add(lblQunLPhiu);

		JLabel lbAdd_icon_2 = new JLabel("");
		lbAdd_icon_2.setBounds(10, 13, 51, 43);
		lbAdd_icon_2.setIcon(new ImageIcon(
				new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\settings_32px.png").getImage()
						.getScaledInstance(32, 32, Image.SCALE_DEFAULT)));

		panel_update_2_2.add(lbAdd_icon_2);

		JPanel panel_update_2_3 = new JPanel();
		panel_update_2_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PhieuThuePhong_view ptp = new PhieuThuePhong_view();
				ptp.setVisible(true);
				close();
			}
		});
		panel_update_2_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_update_2_3.setLayout(null);
		panel_update_2_3.setBackground(new Color(217, 232, 243));
		panel_update_2_3.setBounds(428, 581, 252, 60);
		contentPane.add(panel_update_2_3);

		JLabel lblQunLPhiu_1 = new JLabel("Quản lý phiếu thuê\r\n");
		lblQunLPhiu_1.setForeground(new Color(4, 51, 134));
		lblQunLPhiu_1.setFont(new Font("Calibri", Font.BOLD, 22));
		lblQunLPhiu_1.setBackground(new Color(217, 232, 243));
		lblQunLPhiu_1.setBounds(50, 23, 177, 30);
		panel_update_2_3.add(lblQunLPhiu_1);

		JLabel lbAdd_icon_3 = new JLabel("");
		lbAdd_icon_3.setBounds(10, 13, 51, 43);
		lbAdd_icon_3.setIcon(new ImageIcon(
				new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\settings_32px.png").getImage()
						.getScaledInstance(32, 32, Image.SCALE_DEFAULT)));
		panel_update_2_3.add(lbAdd_icon_3);
		
		JLabel lblKtQu = new JLabel("Trống:");
		lblKtQu.setForeground(new Color(4, 51, 134));
		lblKtQu.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblKtQu.setBackground(new Color(217, 232, 243));
		lblKtQu.setBounds(103, 71, 53, 30);
		contentPane.add(lblKtQu);
		
		JLabel lblCKhch = new JLabel("Có khách: ");
		lblCKhch.setForeground(new Color(4, 51, 134));
		lblCKhch.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblCKhch.setBackground(new Color(217, 232, 243));
		lblCKhch.setBounds(578, 71, 84, 30);
		contentPane.add(lblCKhch);
		
		JLabel lb_SLempty = new JLabel("0");
		ArrayList<Phong> PList1 = new ArrayList<>();
		PList1 = Phong_Modifiers.FindTT(1);
		lb_SLempty.setText(String.valueOf(PList1.size()));
		lb_SLempty.setForeground(new Color(4, 51, 134));
		lb_SLempty.setFont(new Font("Calibri", Font.PLAIN, 20));
		lb_SLempty.setBackground(new Color(217, 232, 243));
		lb_SLempty.setBounds(165, 71, 28, 30);
		contentPane.add(lb_SLempty);
		
		JLabel lb_SLfull = new JLabel("0");
		ArrayList<Phong> PList2 = new ArrayList<>();
		PList2 = Phong_Modifiers.FindTT(3);
		lb_SLfull.setText(String.valueOf(PList2.size()));
		lb_SLfull.setForeground(new Color(4, 51, 134));
		lb_SLfull.setFont(new Font("Calibri", Font.PLAIN, 20));
		lb_SLfull.setBackground(new Color(217, 232, 243));
		lb_SLfull.setBounds(666, 71, 28, 30);
		contentPane.add(lb_SLfull);
		
		JLabel lbltTrc = new JLabel("Đặt trước:");
		lbltTrc.setForeground(new Color(4, 51, 134));
		lbltTrc.setFont(new Font("Calibri", Font.PLAIN, 20));
		lbltTrc.setBackground(new Color(217, 232, 243));
		lbltTrc.setBounds(325, 71, 93, 30);
		contentPane.add(lbltTrc);
		
		JLabel lb_SLorder = new JLabel("0");
		ArrayList<Phong> PList3 = new ArrayList<>();
		PList3 = Phong_Modifiers.FindTT(2);
		lb_SLorder.setText(String.valueOf(PList3.size()));
		lb_SLorder.setForeground(new Color(4, 51, 134));
		lb_SLorder.setFont(new Font("Calibri", Font.PLAIN, 20));
		lb_SLorder.setBackground(new Color(217, 232, 243));
		lb_SLorder.setBounds(419, 71, 28, 30);
		contentPane.add(lb_SLorder);
		
		JPanel panel_update_2_4 = new JPanel();
		panel_update_2_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectedIndex = table.getSelectedRow();
				
				if (SelectedIndex > -1) {
					maP = Integer.valueOf(String.valueOf(table.getValueAt(SelectedIndex, 0)));
					ChiTiet_TTP a = new ChiTiet_TTP();
					a.setVisible(true);
				}
			}
		});
		panel_update_2_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_update_2_4.setLayout(null);
		panel_update_2_4.setBackground(new Color(217, 232, 243));
		panel_update_2_4.setBounds(283, 430, 224, 60);
		contentPane.add(panel_update_2_4);
		
		JLabel lblXemChiTit = new JLabel("Xem chi tiết");
		lblXemChiTit.setForeground(new Color(4, 51, 134));
		lblXemChiTit.setFont(new Font("Calibri", Font.BOLD, 22));
		lblXemChiTit.setBackground(new Color(217, 232, 243));
		lblXemChiTit.setBounds(88, 16, 126, 40);
		panel_update_2_4.add(lblXemChiTit);
		
		JLabel lbAdd_icon_4 = new JLabel("");
		lbAdd_icon_4.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\search.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
		
		lbAdd_icon_4.setBounds(35, 13, 51, 43);
		panel_update_2_4.add(lbAdd_icon_4);
	}
}
