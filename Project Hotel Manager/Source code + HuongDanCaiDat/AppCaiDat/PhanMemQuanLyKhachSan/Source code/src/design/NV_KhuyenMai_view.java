package design;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Class.KhachHang;
import Class.KhuyenMai;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NV_KhuyenMai_view extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lbchitiet;
	DefaultTableModel tableModel;
	ArrayList <KhuyenMai> listKM = new ArrayList<>();
	static int maKM = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NV_KhuyenMai_view frame = new NV_KhuyenMai_view();
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
		 listKM = KhuyenMai_Modifiers.findAll();
		
		for (KhuyenMai km : listKM)
		{
			tableModel.addRow(new Object[] {
				km.getMaKM(), km.getTenKM(), km.getTuNgay(), km.getDenNgay()
			});
		}
	}
	public NV_KhuyenMai_view() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 733, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(217, 232, 243));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQunLKhuyn = new JLabel("QU\u1EA2N L\u00DD KHUY\u1EBEN M\u00C3I");
		lblQunLKhuyn.setForeground(new Color(4, 51, 134));
		lblQunLKhuyn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblQunLKhuyn.setBounds(151, 23, 447, 65);
		contentPane.add(lblQunLKhuyn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 109, 688, 250);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MAKM", "TENKM", "TUNGAY", "DENNGAY"
			}
		));
		tableModel = (DefaultTableModel) table.getModel();
		scrollPane.setViewportView(table);
		showAll();
		
		JPanel panel_chitiet = new JPanel();
		panel_chitiet.setBackground(new Color(217, 232, 243));
		panel_chitiet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectedIndex = table.getSelectedRow();
				if (SelectedIndex > -1) {
					maKM = Integer.valueOf(String.valueOf(table.getValueAt(SelectedIndex, 0)) );
					ChiTietKM_view a = new ChiTietKM_view();
					a.setVisible(true);
				}
			}
		});
		panel_chitiet.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_chitiet.setBounds(282, 379, 172, 48);
		contentPane.add(panel_chitiet);
		panel_chitiet.setLayout(null);
		
		lbchitiet = new JLabel("CHI TI\u1EBET");
		lbchitiet.setForeground(new Color(4, 51, 134));
		lbchitiet.setBounds(61, 10, 101, 33);
		lbchitiet.setFont(new Font("Calibri", Font.PLAIN, 23));
		panel_chitiet.add(lbchitiet);
		
		JLabel lbChitietIcon = new JLabel("");
		lbChitietIcon.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\images\\invoice.png")
						.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));

		lbChitietIcon.setBounds(27, 0, 32, 43);
		panel_chitiet.add(lbChitietIcon);
		
		JLabel lbReturn = new JLabel("");
		lbReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NhanVien_view a = new NhanVien_view();
				a.setVisible(true);
				close();
			}
		});
		lbReturn.setBounds(664, 401, 45, 51);
		lbReturn.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\logout.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
		
		contentPane.add(lbReturn);
		tableModel = (DefaultTableModel) table.getModel();

	}
}
