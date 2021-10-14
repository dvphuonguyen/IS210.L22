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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.Cursor;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Class.DichVu;
import Class.PhieuDichVu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.view.JasperViewer;

public class ChiTietPDV_view extends JFrame {

	private JPanel contentPane;
	static JTable table;
	DefaultTableModel tableModel;
	ArrayList listPDV = new ArrayList();
	int DonGia = 0, tongTien = 0;
	static int maPDV = 0;
	int count_SLDV = 0;
	private JPanel panel_add_2_2;
	private JLabel lblThm_2_2;
	private JLabel lbAdd_icon_2_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChiTietPDV_view frame = new ChiTietPDV_view();
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

		listPDV = DichVu_Modifiers.findAll_CTPDV(QL_DichVu_view.mapdv);

		HashMap<String, String> p;

		for (int i = 0; i < listPDV.size(); i++) {
			p = (HashMap<String, String>) listPDV.get(i);
			tableModel.addRow(
					new Object[] { p.get("MAPDV"), p.get("MADV"), p.get("TENDV"), p.get("SLDV"), p.get("NGAYSD") });
		}

	}
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
	public void xuatPDV(int maPDV, int maDV) throws JRException {
		HashMap<String, Object> map = new HashMap<String, Object>();
		JasperReport rp =  JasperCompileManager.compileReport("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\src\\design\\phieudichvu.jrxml");
		map.put("maphieudichvu",maPDV );
		map.put("madichvu",maDV );
		JasperPrint p  = JasperFillManager.fillReport(rp, map, getJDBCConnection());
		JasperViewer.viewReport(p, false);
	}

	public ChiTietPDV_view() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 639, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(217, 232, 243));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblQunLPhiu = new JLabel("CHI TIẾT PHIẾU DỊCH VỤ");
		lblQunLPhiu.setForeground(new Color(4, 51, 134));
		lblQunLPhiu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblQunLPhiu.setBounds(108, 23, 434, 42);
		contentPane.add(lblQunLPhiu);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 90, 562, 242);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "MAPDV", "MADV", "TENDV", "SLDV", "NGAYSD" }) {
					Class[] columnTypes = new Class[] { Integer.class, Integer.class, String.class, Integer.class,
							String.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
		tableModel = (DefaultTableModel) table.getModel();
		showAll();

//		int Madv = 0;
//		ArrayList <DichVu> dv = new ArrayList <DichVu>();
//	
//		for( int i = table.getRowCount() - 1; i >= 0; i-- ) {
//			count_SLDV = count_SLDV + Integer.valueOf((String) table.getValueAt(i, 3));
//			Madv = Integer.valueOf((String) table.getValueAt(i, 1));
//			maPDV =  Integer.valueOf((String) table.getValueAt(i, 0));
//			dv = DichVu_Modifiers.FindSoTien(Madv);
//			for (DichVu a : dv)
//			{
//				tongTien = tongTien + a.getGiaDV() * count_SLDV;
//			}
//			
//		}

		scrollPane.setViewportView(table);

		panel_add_2_2 = new JPanel();
		panel_add_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectedIndex = table.getSelectedRow();

				if (SelectedIndex > -1) {
					int option = JOptionPane.showConfirmDialog(null, "Bạn muốn xoá dịch vụ này?", "Warning", 2);
					int MaDV = 0;
					if (option == 0) {
						MaDV = Integer.valueOf((String) table.getValueAt(SelectedIndex, 1));
						ArrayList<DichVu> dv = new ArrayList<DichVu>();
						count_SLDV = count_SLDV + Integer.valueOf((String) table.getValueAt(SelectedIndex, 3));
						maPDV = Integer.valueOf((String) table.getValueAt(SelectedIndex, 0));
						dv = DichVu_Modifiers.FindSoTien(MaDV);

						ArrayList<PhieuDichVu> Listpdv = new ArrayList<>();
						Listpdv = DichVu_Modifiers.FindTongTien(maPDV);
						for (PhieuDichVu pdv : Listpdv)
							tongTien = pdv.getTongTien();
						// System.out.println("Tong tien trc khi tru:" + tongTien);
						for (DichVu a : dv)
							tongTien = tongTien - a.getGiaDV() * count_SLDV;
						// System.out.println("Tong tien sau khi tru:" + tongTien);
					}
					DichVu_Modifiers.Update(tongTien, maPDV);
					DichVu_Modifiers.Delete_from_CTPDV(MaDV);
					showAll();

				}
			}
		});
		panel_add_2_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add_2_2.setLayout(null);
		panel_add_2_2.setBackground(new Color(217, 232, 243));
		panel_add_2_2.setBounds(139, 335, 108, 55);
		contentPane.add(panel_add_2_2);

		lblThm_2_2 = new JLabel("Xoá");
		lblThm_2_2.setForeground(new Color(4, 51, 134));
		lblThm_2_2.setFont(new Font("Calibri", Font.PLAIN, 23));
		lblThm_2_2.setBounds(56, 10, 51, 45);
		panel_add_2_2.add(lblThm_2_2);

		lbAdd_icon_2_2 = new JLabel("");
		lbAdd_icon_2_2.setBounds(20, 0, 32, 55);
		lbAdd_icon_2_2.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\images\\clear.png")
						.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));

		panel_add_2_2.add(lbAdd_icon_2_2);
		
		JPanel panel_add_2_2_1 = new JPanel();
		panel_add_2_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectedIndex = table.getSelectedRow();

				if (SelectedIndex > -1) {
					int mapdv = Integer.valueOf((String) table.getValueAt(SelectedIndex, 0));
					int MaDV = Integer.valueOf((String) table.getValueAt(SelectedIndex, 1));
					try {
						xuatPDV(mapdv,MaDV);
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		panel_add_2_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add_2_2_1.setLayout(null);
		panel_add_2_2_1.setBackground(new Color(217, 232, 243));
		panel_add_2_2_1.setBounds(327, 335, 188, 55);
		contentPane.add(panel_add_2_2_1);
		
		JLabel lblThm_2_2_1 = new JLabel("Xuất phiếu");
		lblThm_2_2_1.setForeground(new Color(4, 51, 134));
		lblThm_2_2_1.setFont(new Font("Calibri", Font.PLAIN, 23));
		lblThm_2_2_1.setBounds(62, 10, 108, 45);
		panel_add_2_2_1.add(lblThm_2_2_1);
		
		JLabel lbAdd_icon_2_2_1 = new JLabel("");
		lbAdd_icon_2_2_1.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\export_30px.png")
						.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));

		lbAdd_icon_2_2_1.setBounds(20, 0, 32, 55);
		panel_add_2_2_1.add(lbAdd_icon_2_2_1);
	}
}
