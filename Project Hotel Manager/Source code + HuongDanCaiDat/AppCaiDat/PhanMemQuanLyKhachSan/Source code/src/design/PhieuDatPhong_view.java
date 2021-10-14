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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Class.ChiTietPDP;
import Class.KhachHang;
import Class.NhanVien;
import Class.PhieuDatPhong;
import Class.PhieuThuePhong;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.UIManager;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PhieuDatPhong_view extends JFrame {

	private JPanel contentPane;
	DefaultTableModel tableModel;
	JTable table;
	Add_PTP_fromPDP_view ptp;
	ArrayList ListPDP = new ArrayList();
	static int PDP = 0, makh = 0;
	static String tenPhong = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhieuDatPhong_view frame = new PhieuDatPhong_view();
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
	public void close()
	{
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
	public void showAll() {
		// xoá dữ liêu table trước khi export dữ liệu mới
		for( int i = tableModel.getRowCount() - 1; i >= 0; i-- ) {
			 tableModel.removeRow(i);
		    }
		ListPDP = DATvaTHUEphong_Modifiers.findAll_PhieuDat();
		HashMap<String, String> p;
		
		for(int i = 0; i < ListPDP.size(); i++) {
			p = (HashMap<String, String>) ListPDP.get(i);
			tableModel.addRow(new Object[] {
				p.get("MAPDP"),p.get("MANV"), p.get("MAKH"),p.get("TENKH"),p.get("SDTKH"), 
				p.get("CCCDKH"), p.get("NGAYDT"), p.get("MATT")
				});
		}
	}
	public PhieuDatPhong_view() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 794, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(217, 232, 243));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQunLPhiu = new JLabel("QU\u1EA2N L\u00DD PHI\u1EBEU \u0110\u1EB6T PH\u00D2NG");
		lblQunLPhiu.setBounds(168, 22, 508, 37);
		lblQunLPhiu.setForeground(new Color(4, 51, 134));
		lblQunLPhiu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		contentPane.add(lblQunLPhiu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 81, 721, 322);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MAPDT", "MANV", "MAKH", "TENKH", "SDTKH", "CCCDKH", "NGAYDT", "MATT"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, Integer.class, String.class, String.class, String.class, Object.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableModel = (DefaultTableModel) table.getModel();
		showAll();
		scrollPane.setViewportView(table);
		
		JLabel lbReturn = new JLabel("");
		lbReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Phong_view qlp = new Phong_view();
				qlp.setVisible(true);
				close();
			}
		});
		lbReturn.setBounds(735, 534, 45, 42);
		lbReturn.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\logout.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
		
		contentPane.add(lbReturn);
		
		JPanel panel_add = new JPanel();
		panel_add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectedIndex = table.getSelectedRow();
				if (SelectedIndex > -1) {
					PDP = Integer.valueOf((String) table.getValueAt(SelectedIndex, 0)) ;
					System.out.println(PDP);
					Add_ChiTietPDP ctpdp = new Add_ChiTietPDP();
					ctpdp.setVisible(true);
				}
			}
		});
		panel_add.setLayout(null);
		panel_add.setBackground(new Color(217, 232, 243));
		panel_add.setBounds(60, 422, 158, 55);
		contentPane.add(panel_add);
		
		JLabel lblThm = new JLabel("THÊM");
		lblThm.setForeground(new Color(4, 51, 134));
		lblThm.setFont(new Font("Calibri", Font.BOLD, 25));
		lblThm.setBounds(68, 10, 107, 45);
		panel_add.add(lblThm);
		
		JLabel lbAdd_icon = new JLabel("");
		lbAdd_icon.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\plus_32px.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));

		lbAdd_icon.setBounds(28, 0, 32, 55);
		panel_add.add(lbAdd_icon);
		
		JPanel panel_add_1 = new JPanel();
		panel_add_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectedIndex = table.getSelectedRow();
				
				if (SelectedIndex > -1) {
					PDP = Integer.valueOf((String) table.getValueAt(SelectedIndex, 0)) ;
					
					ChiTiet_PDP_view a = new ChiTiet_PDP_view();
					a.setVisible(true);
					
				}
			}
		});
		panel_add_1.setLayout(null);
		panel_add_1.setBackground(new Color(217, 232, 243));
		panel_add_1.setBounds(290, 422, 158, 55);
		contentPane.add(panel_add_1);
		
		JLabel lblChiTit = new JLabel("CHI TIẾT");
		lblChiTit.setForeground(new Color(4, 51, 134));
		lblChiTit.setFont(new Font("Calibri", Font.BOLD, 25));
		lblChiTit.setBounds(63, 10, 107, 45);
		panel_add_1.add(lblChiTit);
		
		JLabel lbAdd_icon_1 = new JLabel("");
		lbAdd_icon_1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\search_more_30px.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));

		lbAdd_icon_1.setBounds(22, 0, 38, 55);
		panel_add_1.add(lbAdd_icon_1);
		
		JPanel panel_add_1_1 = new JPanel();
		panel_add_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectedIndex = table.getSelectedRow();
				
				if (SelectedIndex > -1) {

					int MaPDP = Integer.valueOf((String) table.getValueAt(SelectedIndex, 0)) ;
					int option = JOptionPane.showConfirmDialog(null, "Bạn muốn xoá phiếu đặt này?" ,"Warning", 2);
					
					if (option == 0) {
						ArrayList<ChiTietPDP> maphongList = new ArrayList<>();
						maphongList = DATvaTHUEphong_Modifiers.FindMaPhong_fromCTPDP(MaPDP);
						for (ChiTietPDP a : maphongList)
					//	Phong_Modifiers.Update_xoa(a.getMAPHONG(), a.getNGAYNP(), a.getNGAYTP_DUKIEN());
						DATvaTHUEphong_Modifiers.DeletePhong_fromPhieuDat(MaPDP);
						DATvaTHUEphong_Modifiers.DeletePhieuDat(MaPDP);
						showAll();
					}
				}
			}
		});
		panel_add_1_1.setLayout(null);
		panel_add_1_1.setBackground(new Color(217, 232, 243));
		panel_add_1_1.setBounds(508, 422, 195, 55);
		contentPane.add(panel_add_1_1);
		
		JLabel lblXoPhng = new JLabel("XOÁ PHIẾU");
		lblXoPhng.setForeground(new Color(4, 51, 134));
		lblXoPhng.setFont(new Font("Calibri", Font.BOLD, 25));
		lblXoPhng.setBounds(66, 10, 119, 45);
		panel_add_1_1.add(lblXoPhng);
		
		JLabel lbAdd_icon_1_1 = new JLabel("");
		lbAdd_icon_1_1.setBounds(22, 0, 50, 55);
		lbAdd_icon_1_1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\delete_30px.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));

		panel_add_1_1.add(lbAdd_icon_1_1);
		
		JPanel panel_add_2 = new JPanel();
		panel_add_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
int SelectedIndex = table.getSelectedRow();
				
				if (SelectedIndex > -1) {
					PDP = Integer.valueOf((String) table.getValueAt(SelectedIndex, 0)) ;

					int maKH = Integer.valueOf((String) table.getValueAt(SelectedIndex, 2)) ;
					makh = Integer.valueOf((String) table.getValueAt(SelectedIndex, 2)) ;
					int option = JOptionPane.showConfirmDialog(null, "Bạn muốn tạo phiếu thuê phòng?" ,"Warning", 2);
					
					if (option == 0) {
						
						ListPDP = DATvaTHUEphong_Modifiers.findAll_PhieuDat();
						HashMap<String, String> p;
						
						for(int i = 0; i < ListPDP.size(); i++) {
							p = (HashMap<String, String>) ListPDP.get(i);
							if (maKH == Integer.valueOf(p.get("MAKH")))
							{
								ptp = new Add_PTP_fromPDP_view();
								ptp.abc = p;
								ptp.gui();
							}
						}
					ptp.setVisible(true);
					}
				}
			}
		});
		panel_add_2.setLayout(null);
		panel_add_2.setBackground(new Color(217, 232, 243));
		panel_add_2.setBounds(207, 498, 355, 55);
		contentPane.add(panel_add_2);
		
		JLabel lblToPhiuThu = new JLabel("TẠO PHIẾU THUÊ PHÒNG");
		lblToPhiuThu.setForeground(new Color(4, 51, 134));
		lblToPhiuThu.setFont(new Font("Calibri", Font.BOLD, 25));
		lblToPhiuThu.setBounds(78, 10, 277, 45);
		panel_add_2.add(lblToPhiuThu);
		
		JLabel lbAdd_icon_2 = new JLabel("");
		lbAdd_icon_2.setBounds(28, 0, 32, 55);
		lbAdd_icon_2.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\plus_32px.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));

		panel_add_2.add(lbAdd_icon_2);
		
	}
}
