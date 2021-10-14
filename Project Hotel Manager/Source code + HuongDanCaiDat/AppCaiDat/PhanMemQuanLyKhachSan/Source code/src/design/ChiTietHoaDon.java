package design;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.view.JasperViewer;
public class ChiTietHoaDon extends JFrame {

	private JPanel contentPane;
	private JTable tablePhong;
	private JTable tableDichVu;
	DefaultTableModel tableModel_PTP, tableModel_PDV;
	ArrayList ctptp = new ArrayList();
	ArrayList ctpdv = new ArrayList();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChiTietHoaDon frame = new ChiTietHoaDon();
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
	public void showAll_PTP() {
		
		// xoá dữ liêu table trước khi export dữ liệu mới
		for( int i = tableModel_PTP.getRowCount() - 1; i >= 0; i-- ) {
			tableModel_PTP.removeRow(i);
		    }
		
		ctptp = HoaDon_Modifiers.findAll_ChiTietPTP(QL_HoaDon_view.maptp);
		HashMap<String, String> p;
		
		for(int i = 0; i < ctptp.size(); i++) {
			p = (HashMap<String, String>) ctptp.get(i);
			tableModel_PTP.addRow(new Object[] {
				p.get("TENPHONG"),p.get("GIAPHONG") ,p.get("NGAYNP"),p.get("NGAYTPTT"),
				p.get("SLNGUOI"), p.get("PHUTHU")
				});
		}
	}
	public void showAll_PDV() {
		
		// xoá dữ liêu table trước khi export dữ liệu mới
		for( int i = tableModel_PDV.getRowCount() - 1; i >= 0; i-- ) {
			tableModel_PDV.removeRow(i);
		    }
		
		ctpdv = HoaDon_Modifiers.findAll_ChiTietPDV(QL_HoaDon_view.mapdv);
		HashMap<String, String> p;
		
		for(int i = 0; i < ctpdv.size(); i++) {
			p = (HashMap<String, String>) ctpdv.get(i);
			tableModel_PDV.addRow(new Object[] {
				p.get("TENDV"),p.get("GIADV") ,p.get("SLDV")
				});
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
	public void xuatHD(int maHD) throws JRException {
		HashMap<String, Object> map = new HashMap<String, Object>();
		JasperReport rp =  JasperCompileManager.compileReport("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\src\\design\\hoaDon.jrxml");
		map.put("MAHOADON", maHD );
		JasperPrint p  = JasperFillManager.fillReport(rp, map, getJDBCConnection());
		JasperViewer.viewReport(p, false);
	}
	public ChiTietHoaDon() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 534, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(217, 232, 243));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChiTitHo = new JLabel("CHI TI\u1EBET HO\u00C1 \u0110\u01A0N");
		lblChiTitHo.setForeground(new Color(4, 51, 134));
		lblChiTitHo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblChiTitHo.setBounds(98, 23, 344, 42);
		contentPane.add(lblChiTitHo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 128, 463, 107);
		contentPane.add(scrollPane);
		
		tablePhong = new JTable();
		tablePhong.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"TENPHONG", "DONGIA", "CHECK IN", "CHECK OUT", "SLNGUOI", "PHUTHU"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, String.class, String.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tablePhong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tableModel_PTP = (DefaultTableModel) tablePhong.getModel();
		showAll_PTP();
		
		scrollPane.setViewportView(tablePhong);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(27, 298, 463, 107);
		contentPane.add(scrollPane_1);
		
		tableDichVu = new JTable();
		tableDichVu.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"TEN", "DONGIA", "SOLUONG"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableModel_PDV = (DefaultTableModel) tableDichVu.getModel();
		showAll_PDV();
		scrollPane_1.setViewportView(tableDichVu);
		
		JLabel lblPhng = new JLabel("PH\u00D2NG");
		lblPhng.setForeground(new Color(4, 51, 134));
		lblPhng.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPhng.setBounds(223, 75, 80, 42);
		contentPane.add(lblPhng);
		
		JLabel lblPhng_1 = new JLabel("________");
		lblPhng_1.setForeground(new Color(4, 51, 134));
		lblPhng_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPhng_1.setBounds(211, 82, 98, 42);
		contentPane.add(lblPhng_1);
		
		JLabel lblDchV = new JLabel("D\u1ECACH V\u1EE4");
		lblDchV.setForeground(new Color(4, 51, 134));
		lblDchV.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDchV.setBounds(219, 244, 80, 42);
		contentPane.add(lblDchV);
		
		JLabel lblPhng_1_1 = new JLabel("________");
		lblPhng_1_1.setForeground(new Color(4, 51, 134));
		lblPhng_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPhng_1_1.setBounds(211, 252, 98, 42);
		contentPane.add(lblPhng_1_1);
		
		JPanel panel_add_2_1_1 = new JPanel();
//		panel_add_2_1_1.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				try {
//					xuatHD(QL_HoaDon_view.mahd);
//				} catch (JRException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//		});
		panel_add_2_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add_2_1_1.setLayout(null);
		panel_add_2_1_1.setBackground(new Color(217, 232, 243));
		panel_add_2_1_1.setBounds(157, 424, 189, 55);
		contentPane.add(panel_add_2_1_1);
		
		JLabel lblThm_2_1_1 = new JLabel("Xuất hoá đơn");
		lblThm_2_1_1.setForeground(new Color(4, 51, 134));
		lblThm_2_1_1.setFont(new Font("Calibri", Font.PLAIN, 23));
		lblThm_2_1_1.setBounds(51, 10, 128, 45);
		panel_add_2_1_1.add(lblThm_2_1_1);
		
		JLabel lbAdd_icon_2_1_1 = new JLabel("");
		lbAdd_icon_2_1_1.setBounds(26, 0, 32, 55);
		panel_add_2_1_1.add(lbAdd_icon_2_1_1);
	}
}
