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

public class QL_KhuyenMai_view extends JFrame {

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
					QL_KhuyenMai_view frame = new QL_KhuyenMai_view();
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
	public QL_KhuyenMai_view() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 733, 535);
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
		panel_chitiet.setBounds(21, 379, 172, 48);
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
		
		JPanel panel_them = new JPanel();
		panel_them.setBackground(new Color(217, 232, 243));
		panel_them.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Add_KhuyenMai addkm = new Add_KhuyenMai();
				addkm.setVisible(true);
				close();
			}
		});
		panel_them.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_them.setBounds(278, 379, 172, 48);
		contentPane.add(panel_them);
		panel_them.setLayout(null);
		
		JLabel lblThem = new JLabel("TH\u00CAM");
		lblThem.setForeground(new Color(4, 51, 134));
		lblThem.setFont(new Font("Calibri", Font.PLAIN, 23));
		lblThem.setBounds(61, 10, 101, 33);
		panel_them.add(lblThem);
		
		JLabel lbthemIcon = new JLabel("");
		lbthemIcon.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\images\\plus1.png")
						.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));

		lbthemIcon.setBounds(24, 0, 32, 43);
		panel_them.add(lbthemIcon);
		
		JPanel panel_them_1 = new JPanel();
		panel_them_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectedIndex = table.getSelectedRow();
				if (SelectedIndex > -1) {
					maKM = Integer.valueOf(String.valueOf(table.getValueAt(SelectedIndex, 0)));
					KhuyenMai_Modifiers.Delete(maKM);
					showAll();
				}
			}
		});
		panel_them_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_them_1.setLayout(null);
		panel_them_1.setBackground(new Color(217, 232, 243));
		panel_them_1.setBounds(547, 379, 172, 48);
		contentPane.add(panel_them_1);
		
		JLabel lbxoa = new JLabel("XO\u00C1");
		lbxoa.setForeground(new Color(4, 51, 134));
		lbxoa.setFont(new Font("Calibri", Font.PLAIN, 23));
		lbxoa.setBounds(81, 10, 67, 33);
		lbxoa.setBackground(new Color(217, 232, 243));
		panel_them_1.add(lbxoa);
		
		JLabel lbxoaIcon = new JLabel("");
		lbxoaIcon.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\images\\clear.png")
						.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));

		lbxoaIcon.setBounds(39, 0, 32, 43);
		panel_them_1.add(lbxoaIcon);
		
		JLabel lbReturn = new JLabel("");
		lbReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				QuanLy_view a = new QuanLy_view();
				a.setVisible(true);
				close();
			}
		});
		lbReturn.setBounds(664, 447, 45, 51);
		lbReturn.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\logout.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
		
		contentPane.add(lbReturn);
		tableModel = (DefaultTableModel) table.getModel();

	}
}
