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
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.UIManager;
import java.awt.Cursor;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


public class QL_HoaDon_view extends JFrame {

	private JPanel contentPane;
	private JTextField textField_sdt;
	private JTable table;
	private JLabel lbReturn;
	DefaultTableModel tableModel;
	ArrayList listHD = new ArrayList();
	ArrayList listHD_bySDT = new ArrayList();
	static int maptp = 0, mapdv = 0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QL_HoaDon_view frame = new QL_HoaDon_view();
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
	public void showAll_bySDT(String sdt)
	{
		for( int i = tableModel.getRowCount() - 1; i >= 0; i-- ) {
			tableModel.removeRow(i);
		    }
		HashMap<String, String> p;
		listHD_bySDT = HoaDon_Modifiers.findAll_bySDT(sdt);
		for(int i = 0; i < listHD_bySDT.size(); i++) {
			p = (HashMap<String, String>) listHD_bySDT.get(i);
			tableModel.addRow(new Object[] {
				p.get("MAHD"),p.get("MANV"),p.get("MAKH"),p.get("TENKH"),p.get("SDTKH"),
				p.get("MAPTP"), p.get("MAPDV"), p.get("TONGTIEN"), p.get("NGAYTT")
				});
		}
	}
	public void showAll()
	{
		for( int i = tableModel.getRowCount() - 1; i >= 0; i-- ) {
			tableModel.removeRow(i);
		    }
		HashMap<String, String> p;
		listHD = HoaDon_Modifiers.findAll();
		for(int i = 0; i < listHD.size(); i++) {
			p = (HashMap<String, String>) listHD.get(i);
			tableModel.addRow(new Object[] {
				p.get("MAHD"),p.get("MANV"),p.get("MAKH"),p.get("TENKH"),p.get("SDTKH"),
				p.get("MAPTP"), p.get("MAPDV"), p.get("TONGTIEN"), p.get("NGAYTT")
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
		HashMap map = new HashMap();
		JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\src\\design\\hoaDon.jrxml");
        net.sf.jasperreports.engine.JasperReport jreport = JasperCompileManager.compileReport(jdesign);
		//JasperReport rp =  JasperCompileManager.compileReport(jreport);
		map.put("MAHOADON", maHD );
		JasperPrint p  = JasperFillManager.fillReport(jreport, map, getJDBCConnection());
		JasperViewer.viewReport(p, false);
	}
	public QL_HoaDon_view() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 795, 612);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(217, 232, 243));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQunLHo = new JLabel("QU\u1EA2N L\u00DD HO\u00C1 \u0110\u01A0N");
		lblQunLHo.setForeground(new Color(4, 51, 134));
		lblQunLHo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblQunLHo.setBounds(229, 22, 336, 42);
		contentPane.add(lblQunLHo);
		
		JLabel lbInput_sdt = new JLabel("Nhập số điện thoại KH:\r\n ");
		lbInput_sdt.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbInput_sdt.setForeground(new Color(4, 51, 134));
		lbInput_sdt.setBounds(61, 104, 201, 22);
		contentPane.add(lbInput_sdt);
		
		textField_sdt = new JTextField();
		textField_sdt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_sdt.setColumns(10);
		textField_sdt.setBounds(279, 95, 207, 41);
		contentPane.add(textField_sdt);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Kết quả");
		lblNewLabel_1.setForeground(new Color(4, 51, 134));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(345, 154, 88, 36);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 200, 738, 223);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MAHD", "MANV", "MAKH", "TENKH", "SDTKH", "MAPTP", "MAPDV", "TONGTIEN", "NGAYLAP"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, Integer.class, String.class, String.class, Integer.class, Integer.class, Integer.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableModel = (DefaultTableModel) table.getModel();
		showAll();
		scrollPane.setViewportView(table);
		
		lbReturn = new JLabel("");
		lbReturn.setBounds(726, 514, 45, 62);
		lbReturn.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\logout.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
		lbReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				QuanLy_view ql = new QuanLy_view();
					ql.setVisible(true);
					close();
			}
		});
		contentPane.add(lbReturn);
		
		JPanel panel_add = new JPanel();
		panel_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showAll_bySDT(textField_sdt.getText());
			}
		});
		panel_add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add.setLayout(null);
		panel_add.setBackground(new Color(217, 232, 243));
		panel_add.setBounds(529, 90, 158, 55);
		contentPane.add(panel_add);
		
		JLabel lblThm = new JLabel("Tìm kiếm");
		lblThm.setForeground(new Color(4, 51, 134));
		lblThm.setFont(new Font("Calibri", Font.PLAIN, 23));
		lblThm.setBounds(68, 10, 107, 45);
		panel_add.add(lblThm);
		
		JLabel lbAdd_icon = new JLabel("");
		lbAdd_icon.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\search_32px.png")
						.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));

		lbAdd_icon.setBounds(26, 0, 32, 55);
		panel_add.add(lbAdd_icon);
		
		JPanel panel_add_2_1_2 = new JPanel();
		panel_add_2_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Add_HoaDon addhd = new Add_HoaDon();
				addhd.setVisible(true);
			}
		});
		panel_add_2_1_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add_2_1_2.setLayout(null);
		panel_add_2_1_2.setBackground(new Color(217, 232, 243));
		panel_add_2_1_2.setBounds(279, 448, 224, 55);
		contentPane.add(panel_add_2_1_2);
		
		JLabel lblThm_2_1_2 = new JLabel("Thêm hoá đơn");
		lblThm_2_1_2.setForeground(new Color(4, 51, 134));
		lblThm_2_1_2.setFont(new Font("Calibri", Font.PLAIN, 23));
		lblThm_2_1_2.setBounds(68, 10, 146, 45);
		panel_add_2_1_2.add(lblThm_2_1_2);
		
		JLabel lbAdd_icon_2_1_2 = new JLabel("");
		lbAdd_icon_2_1_2.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\images\\plus1.png")
						.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH)));

		
		lbAdd_icon_2_1_2.setBounds(26, 0, 32, 55);
		panel_add_2_1_2.add(lbAdd_icon_2_1_2);
		
		JPanel panel_add_2_1_1 = new JPanel();
		panel_add_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectedIndex = table.getSelectedRow();
				if (SelectedIndex > -1) {
//					maptp = Integer.valueOf(String.valueOf(table.getValueAt(SelectedIndex, 5)) );
//					mapdv = Integer.valueOf(String.valueOf(table.getValueAt(SelectedIndex, 6)) );
					int mahd = Integer.valueOf(String.valueOf(table.getValueAt(SelectedIndex, 0)) );
					try {
						xuatHD(mahd);
					} catch (JRException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
			}
		});
		panel_add_2_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add_2_1_1.setLayout(null);
		panel_add_2_1_1.setBackground(new Color(217, 232, 243));
		panel_add_2_1_1.setBounds(42, 448, 207, 55);
		contentPane.add(panel_add_2_1_1);
		
		JLabel lblThm_2_1_1 = new JLabel(" Xuất hoá đơn");
		lblThm_2_1_1.setForeground(new Color(4, 51, 134));
		lblThm_2_1_1.setFont(new Font("Calibri", Font.PLAIN, 23));
		lblThm_2_1_1.setBounds(61, 10, 136, 45);
		panel_add_2_1_1.add(lblThm_2_1_1);
		
		JLabel lbAdd_icon_2_1_1 = new JLabel("");
		lbAdd_icon_2_1_1.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\images\\invoice.png")
						.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));

		lbAdd_icon_2_1_1.setBounds(26, 0, 32, 55);
		panel_add_2_1_1.add(lbAdd_icon_2_1_1);
		
		JPanel panel_add_2_1_2_1 = new JPanel();
		panel_add_2_1_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectedIndex = table.getSelectedRow();
				if (SelectedIndex > -1) {
					int option = JOptionPane.showConfirmDialog(null, "Bạn muốn xoá hoá đơn này?", "Warning", 2);

					if (option == 0) {
					HoaDon_Modifiers.Delete(Integer.valueOf((String) table.getValueAt(SelectedIndex, 0)));
					showAll();
					}
				}
			}
		});
		panel_add_2_1_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add_2_1_2_1.setLayout(null);
		panel_add_2_1_2_1.setBackground(new Color(217, 232, 243));
		panel_add_2_1_2_1.setBounds(536, 448, 224, 55);
		contentPane.add(panel_add_2_1_2_1);
		
		JLabel lblThm_2_1_2_1 = new JLabel("Xoá hoá đơn");
		lblThm_2_1_2_1.setForeground(new Color(4, 51, 134));
		lblThm_2_1_2_1.setFont(new Font("Calibri", Font.PLAIN, 23));
		lblThm_2_1_2_1.setBounds(68, 10, 146, 45);
		panel_add_2_1_2_1.add(lblThm_2_1_2_1);
		
		JLabel lbAdd_icon_2_1_2_1 = new JLabel("");
		lbAdd_icon_2_1_2_1.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\images\\clear.png")
						.getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH)));

		lbAdd_icon_2_1_2_1.setBounds(26, 0, 32, 55);
		panel_add_2_1_2_1.add(lbAdd_icon_2_1_2_1);
		
		JLabel lbAdd_icon_4 = new JLabel("");
		lbAdd_icon_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showAll();
			}
		});
		lbAdd_icon_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbAdd_icon_4.setIcon(new ImageIcon(
				new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\refresh_32px.png").getImage()
						.getScaledInstance(22, 22, Image.SCALE_DEFAULT)));

		lbAdd_icon_4.setBounds(435, 154, 51, 43);
		contentPane.add(lbAdd_icon_4);
	}
}
