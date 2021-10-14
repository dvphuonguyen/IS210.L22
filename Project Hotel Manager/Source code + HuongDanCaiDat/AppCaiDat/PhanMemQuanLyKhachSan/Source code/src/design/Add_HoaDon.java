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
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Class.CHITIETPTP;
import Class.ChiTietPDP;
import Class.HoaDon;
import Class.KhuyenMai;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Add_HoaDon extends JFrame {

	private JPanel contentPane;
	private JTextField textField_sdt;
	private JTable table_PTP;
	private JTable table_PDV;
	DefaultTableModel tableModel_PTP, tableModel_PDV;
	ArrayList listPTP = new ArrayList();
	ArrayList listPDV = new ArrayList();
	ArrayList <KhuyenMai> listKM = new ArrayList<>();
	private JLabel lb_maptp;
	private JLabel lb_tienphong;
	private JLabel lb_tiendv;
	private JLabel lb_mapdv;
	static int makh = 0;
	private JLabel lb_total;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_HoaDon frame = new Add_HoaDon();
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
	public void showAll_ptp(String sdt)
	{
		for( int i = tableModel_PTP.getRowCount() - 1; i >= 0; i-- ) {
			tableModel_PTP.removeRow(i);
		    }
		listPTP = HoaDon_Modifiers.findAll_PhieuThuefromSDT(sdt);
		HashMap<String, String> p;
	
		for(int i = 0; i < listPTP.size(); i++) {
			p = (HashMap<String, String>) listPTP.get(i);
			tableModel_PTP.addRow(new Object[] {
				p.get("MAPTP"),p.get("MAKH"),p.get("TENKH"),p.get("TIENPHONG")
				});
		}
	}
	public void showAll_pdv(String sdt) {
		// xoá dữ liêu table trước khi export dữ liệu mới
		for( int i = tableModel_PDV.getRowCount() - 1; i >= 0; i-- ) {
			tableModel_PDV.removeRow(i);
		    }
		listPDV = HoaDon_Modifiers.findAll_PDVfromSDT(sdt);
		
		HashMap<String, String> p;
		
		for(int i = 0; i < listPDV.size(); i++) {
			p = (HashMap<String, String>) listPDV.get(i);
			tableModel_PDV.addRow(new Object[] {
				p.get("MAPDV"),p.get("MAKH"),p.get("TENKH"),p.get("TIENDV")
				});
		}
	}
	public Add_HoaDon() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1317, 627);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(217, 232, 243));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblThmHon = new JLabel("TH\u00CAM HO\u00C1 \u0110\u01A0N M\u1EDAI");
		lblThmHon.setForeground(new Color(4, 51, 134));
		lblThmHon.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblThmHon.setBounds(520, 26, 344, 42);
		contentPane.add(lblThmHon);
		
		textField_sdt = new JTextField();
		textField_sdt.setColumns(10);
		textField_sdt.setBounds(578, 93, 207, 41);
		contentPane.add(textField_sdt);
		
		JLabel lbInput_sdt = new JLabel("Nhập số điện thoại KH:\r\n ");
		lbInput_sdt.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbInput_sdt.setForeground(new Color(4, 51, 134));
		lbInput_sdt.setBounds(364, 104, 201, 22);
		contentPane.add(lbInput_sdt);
		
		JLabel lblPhiuThuPhng = new JLabel("Phiếu thuê phòng tương ứng");
		lblPhiuThuPhng.setForeground(new Color(4, 51, 134));
		lblPhiuThuPhng.setFont(new Font("Calibri", Font.BOLD, 20));
		lblPhiuThuPhng.setBounds(88, 166, 260, 42);
		contentPane.add(lblPhiuThuPhng);
		
		JLabel lblPhiuDchV = new JLabel("Phiếu dịch vụ tương ứng");
		lblPhiuDchV.setForeground(new Color(4, 51, 134));
		lblPhiuDchV.setFont(new Font("Calibri", Font.BOLD, 20));
		lblPhiuDchV.setBounds(538, 166, 218, 42);
		contentPane.add(lblPhiuDchV);
		
		JLabel lblThngTinHo = new JLabel("Thông tin hoá đơn");
		lblThngTinHo.setForeground(new Color(4, 51, 134));
		lblThngTinHo.setFont(new Font("Calibri", Font.BOLD, 20));
		lblThngTinHo.setBounds(1007, 166, 188, 42);
		contentPane.add(lblThngTinHo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 218, 375, 270);
		contentPane.add(scrollPane);
		
		table_PTP = new JTable();
		table_PTP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table_PTP.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MAPTP", "MAKH", "TENKH", "TONGTIEN"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableModel_PTP = (DefaultTableModel) table_PTP.getModel();

		scrollPane.setViewportView(table_PTP);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(464, 216, 375, 272);
		contentPane.add(scrollPane_1);
		
		table_PDV = new JTable();
		table_PDV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table_PDV.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MAPDV", "MAKH", "TENKH", "TONGTIEN"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableModel_PDV = (DefaultTableModel) table_PDV.getModel();
		scrollPane_1.setViewportView(table_PDV);
		
		JLabel lbmaptp = new JLabel("Mã phiếu thuê phòng:");
		lbmaptp.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbmaptp.setForeground(new Color(4, 51, 134));
		lbmaptp.setBounds(894, 218, 167, 22);
		contentPane.add(lbmaptp);
		
		JLabel lbmapdv = new JLabel("Mã phiếu dịch vụ:");
		lbmapdv.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbmapdv.setForeground(new Color(4, 51, 134));
		lbmapdv.setBounds(894, 334, 140, 22);
		contentPane.add(lbmapdv);
		
		JLabel lbtotal_tienphong = new JLabel("Tổng tiền thuê phòng:");
		lbtotal_tienphong.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbtotal_tienphong.setForeground(new Color(4, 51, 134));
		lbtotal_tienphong.setBounds(894, 276, 188, 22);
		contentPane.add(lbtotal_tienphong);
		
		JLabel lbtotal_tiendv = new JLabel("Tổng tiền dịch vụ:");
		lbtotal_tiendv.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbtotal_tiendv.setForeground(new Color(4, 51, 134));
		lbtotal_tiendv.setBounds(894, 393, 161, 22);
		contentPane.add(lbtotal_tiendv);
		
		JLabel lblPhiuThuPhng_1_1_2_1_1 = new JLabel("TỔNG CỘNG:");
		lblPhiuThuPhng_1_1_2_1_1.setForeground(new Color(4, 51, 134));
		lblPhiuThuPhng_1_1_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int temp_total = Integer.valueOf(lb_tienphong.getText()) + Integer.valueOf(lb_tiendv.getText());
				lb_total.setText(String.valueOf(temp_total));
			}
		});
		lblPhiuThuPhng_1_1_2_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPhiuThuPhng_1_1_2_1_1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		lblPhiuThuPhng_1_1_2_1_1.setBounds(894, 466, 161, 33);
		contentPane.add(lblPhiuThuPhng_1_1_2_1_1);
		
		lb_maptp = new JLabel("");
		lb_maptp.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_maptp.setBounds(1092, 216, 167, 22);
		contentPane.add(lb_maptp);
		
		lb_tienphong = new JLabel("");
		lb_tienphong.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_tienphong.setBounds(1092, 274, 167, 22);
		contentPane.add(lb_tienphong);
		
		lb_mapdv = new JLabel("");
		lb_mapdv.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_mapdv.setBounds(1092, 332, 167, 22);
		contentPane.add(lb_mapdv);
		
		lb_tiendv = new JLabel("");
		lb_tiendv.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_tiendv.setBounds(1092, 391, 167, 22);
		contentPane.add(lb_tiendv);
		
		lb_total = new JLabel("");
		lb_total.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_total.setBounds(1092, 464, 167, 22);
		contentPane.add(lb_total);
		
		JPanel panel_add = new JPanel();
		panel_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectedIndex = table_PTP.getSelectedRow();
				if (SelectedIndex > -1) {
					makh = Integer.valueOf((String) table_PTP.getValueAt(SelectedIndex, 1));
					lb_maptp.setText((String) table_PTP.getValueAt(SelectedIndex, 0));
					lb_tienphong.setText((String) table_PTP.getValueAt(SelectedIndex, 3));
				}
			}
		});
		panel_add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add.setLayout(null);
		panel_add.setBackground(new Color(217, 232, 243));
		panel_add.setBounds(132, 498, 158, 55);
		contentPane.add(panel_add);
		
		JLabel lblChn = new JLabel("Chọn");
		lblChn.setForeground(new Color(4, 51, 134));
		lblChn.setFont(new Font("Calibri", Font.PLAIN, 23));
		lblChn.setBounds(52, 10, 65, 45);
		panel_add.add(lblChn);
		
		JLabel lbAdd_icon_2 = new JLabel("");
		lbAdd_icon_2.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\checkmark_32px.png")
						.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)));

		lbAdd_icon_2.setBounds(10, 0, 32, 55);
		panel_add.add(lbAdd_icon_2);
		
		JPanel panel_add_1 = new JPanel();
		panel_add_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectedIndex = table_PDV.getSelectedRow();
				if (SelectedIndex > -1) {
				lb_mapdv.setText((String) table_PDV.getValueAt(SelectedIndex, 0));
				lb_tiendv.setText((String) table_PDV.getValueAt(SelectedIndex, 3));
				}
			}
		});
		panel_add_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add_1.setLayout(null);
		panel_add_1.setBackground(new Color(217, 232, 243));
		panel_add_1.setBounds(587, 498, 158, 55);
		contentPane.add(panel_add_1);
		
		JLabel lblChn_1 = new JLabel("Chọn");
		lblChn_1.setForeground(new Color(4, 51, 134));
		lblChn_1.setFont(new Font("Calibri", Font.PLAIN, 23));
		lblChn_1.setBounds(52, 10, 65, 45);
		panel_add_1.add(lblChn_1);
		
		JLabel lbAdd_icon_2_1 = new JLabel("");
		lbAdd_icon_2_1.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\checkmark_32px.png")
						.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)));

		lbAdd_icon_2_1.setBounds(10, 0, 32, 55);
		panel_add_1.add(lbAdd_icon_2_1);
		
		JPanel panel_add_2 = new JPanel();
		panel_add_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showAll_ptp(textField_sdt.getText());
				showAll_pdv(textField_sdt.getText());
			}
		});
		panel_add_2.setLayout(null);
		panel_add_2.setBackground(new Color(217, 232, 243));
		panel_add_2.setBounds(806, 92, 158, 55);
		contentPane.add(panel_add_2);
		
		JLabel lblThm = new JLabel("Tìm kiếm");
		lblThm.setForeground(new Color(4, 51, 134));
		lblThm.setFont(new Font("Calibri", Font.PLAIN, 23));
		lblThm.setBounds(68, 10, 107, 45);
		panel_add_2.add(lblThm);
		
		JLabel lbAdd_icon = new JLabel("");
		lbAdd_icon.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\search_32px.png")
						.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));

		lbAdd_icon.setBounds(26, 0, 32, 55);
		panel_add_2.add(lbAdd_icon);
		
		JPanel panel_add_3 = new JPanel();
		panel_add_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				long millis= System.currentTimeMillis();   
				java.sql.Date date=new java.sql.Date(millis);   
				System.out.println(date);
				
				float total = Float.valueOf(lb_total.getText());
				
				int DoanhSo = KH_Modifiers.FindDoanhSo(makh) + (int) total;
				
				try {
					HoaDon a = new HoaDon(
							Login.MaNV, 
							makh,
							Integer.valueOf(lb_maptp.getText()),
							Integer.valueOf(lb_mapdv.getText()),
							(int) total,
							date
					);
					ArrayList <CHITIETPTP> mplist = new ArrayList();
					mplist = DATvaTHUEphong_Modifiers.FindMPfromPTP(Integer.valueOf(lb_maptp.getText()));
					for (CHITIETPTP ab : mplist)
						Phong_Modifiers.Delete_CTTTP(ab.getMAPHONG(), ab.getNGAYNP(), ab.getNGAYTPTT());
					
					HoaDon_Modifiers.AddHD(a);
					
					DichVu_Modifiers.Update_TinhTrangPDV(2, Integer.valueOf(lb_mapdv.getText()));
					DATvaTHUEphong_Modifiers.Update_TinhTrangPTP(2, Integer.valueOf(lb_maptp.getText()));
					
					
					
					KH_Modifiers.UpdateDoanhSo(DoanhSo, makh);
					
					if (DoanhSo >=50000000 && DoanhSo < 100000000) {
						KH_Modifiers.UpdateMaLKH(2, makh);
					}
					else if (DoanhSo >= 100000000) {
						KH_Modifiers.UpdateMaLKH(3, makh);
					}
					JOptionPane.showMessageDialog(null, "Thêm hoá đơn thành công");
					close();
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		panel_add_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add_3.setLayout(null);
		panel_add_3.setBackground(new Color(217, 232, 243));
		panel_add_3.setBounds(989, 496, 206, 55);
		contentPane.add(panel_add_3);
		
		JLabel lblThm_1 = new JLabel("Tạo hoá đơn");
		
		lblThm_1.setForeground(new Color(4, 51, 134));
		lblThm_1.setFont(new Font("Calibri", Font.PLAIN, 23));
		lblThm_1.setBounds(68, 10, 128, 45);
		panel_add_3.add(lblThm_1);
		
		JLabel lbAdd_icon_1 = new JLabel("");
		lbAdd_icon_1.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\images\\plus1.png")
						.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH)));

		lbAdd_icon_1.setBounds(26, 0, 32, 55);
		panel_add_3.add(lbAdd_icon_1);
		
		
	}
}
