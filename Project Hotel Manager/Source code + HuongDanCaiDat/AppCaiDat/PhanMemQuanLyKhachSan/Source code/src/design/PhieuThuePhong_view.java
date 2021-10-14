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

import Class.NhanVien;
import Class.PhieuDatPhong;
import Class.PhieuThuePhong;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class PhieuThuePhong_view extends JFrame {

	private JPanel contentPane;
	DefaultTableModel tableModel;
	JTable table;
	private JScrollPane scrollPane;
	ArrayList ListPTP = new ArrayList();
	static int PTP = 0, MaKH = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhieuThuePhong_view frame = new PhieuThuePhong_view();
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
		for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
		ListPTP = DATvaTHUEphong_Modifiers.findAll_PhieuThue();
		HashMap<String, String> p;

		for (int i = 0; i < ListPTP.size(); i++) {
			p = (HashMap<String, String>) ListPTP.get(i);
			tableModel.addRow(new Object[] { p.get("MAPTP"), p.get("MANV"), p.get("MAKH"), p.get("TENKH"),
					p.get("SDTKH"), p.get("CCCDKH"), p.get("TIENPHONG"), p.get("MAPDP"), p.get("MATT")  });
		}
	}

	public PhieuThuePhong_view() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 845, 688);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(217, 232, 243));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblQunLPhiu_1 = new JLabel("QU\u1EA2N L\u00DD PHI\u1EBEU THU\u00CA PH\u00D2NG");
		lblQunLPhiu_1.setForeground(new Color(4, 51, 134));
		lblQunLPhiu_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblQunLPhiu_1.setBounds(181, 31, 508, 37);
		contentPane.add(lblQunLPhiu_1);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 91, 744, 415);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MAPTP", "MANV", "MAKH", "TENKH", "SDTKH", "CCCDKH", "TIENPHONG", "MAPDP", "MATT"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, Integer.class, String.class, String.class, String.class, Integer.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableModel = (DefaultTableModel) table.getModel();

		scrollPane.setViewportView(table);

		showAll();

		JLabel lbReturn = new JLabel("");
		lbReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Phong_view qlp = new Phong_view();
				qlp.setVisible(true);
				close();
			}
		});
		lbReturn.setBounds(776, 600, 45, 42);
		lbReturn.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\logout.png")
						.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));

		contentPane.add(lbReturn);

		JPanel panel_update_2 = new JPanel();
		panel_update_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectedIndex = table.getSelectedRow();
				if (SelectedIndex > -1) {
					PTP = Integer.valueOf((String) table.getValueAt(SelectedIndex, 0));
					MaKH = Integer.valueOf((String) table.getValueAt(SelectedIndex, 2));
					System.out.println(PTP);
					Add_PTP_TrucTiep add = new Add_PTP_TrucTiep();
					add.setVisible(true);
				}
			}
		});
		panel_update_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_update_2.setLayout(null);
		panel_update_2.setBackground(new Color(217, 232, 243));
		panel_update_2.setBounds(37, 530, 186, 60);
		contentPane.add(panel_update_2);

		JLabel lblThmPhng = new JLabel("Thêm phòng");
		lblThmPhng.setForeground(new Color(4, 51, 134));
		lblThmPhng.setFont(new Font("Calibri", Font.BOLD, 22));
		lblThmPhng.setBackground(new Color(217, 232, 243));
		lblThmPhng.setBounds(50, 23, 177, 30);
		panel_update_2.add(lblThmPhng);

		JLabel lbAdd_icon = new JLabel("");
		lbAdd_icon.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\images\\plus1.png")
						.getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH)));

		lbAdd_icon.setBounds(10, 13, 51, 43);
		panel_update_2.add(lbAdd_icon);

		JPanel panel_update_2_1 = new JPanel();
		panel_update_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectedIndex = table.getSelectedRow();

				if (SelectedIndex > -1) {
					PTP = Integer.valueOf((String) table.getValueAt(SelectedIndex, 0));
					ChiTiet_PTP ctptp = new ChiTiet_PTP();
					ctptp.setVisible(true);
				}
			}
		});
		panel_update_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_update_2_1.setLayout(null);
		panel_update_2_1.setBackground(new Color(217, 232, 243));
		panel_update_2_1.setBounds(323, 530, 200, 60);
		contentPane.add(panel_update_2_1);

		JLabel lblXemChiTit = new JLabel("Xem chi tiết");
		lblXemChiTit.setForeground(new Color(4, 51, 134));
		lblXemChiTit.setFont(new Font("Calibri", Font.BOLD, 22));
		lblXemChiTit.setBackground(new Color(217, 232, 243));
		lblXemChiTit.setBounds(70, 23, 119, 30);
		panel_update_2_1.add(lblXemChiTit);

		JLabel lbAdd_icon_1 = new JLabel("");
		lbAdd_icon_1.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\images\\search.png")
						.getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH)));

		lbAdd_icon_1.setBounds(21, 10, 37, 43);
		panel_update_2_1.add(lbAdd_icon_1);

		JPanel panel_update_2_2 = new JPanel();
		panel_update_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showAll();
			}
		});
		panel_update_2_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_update_2_2.setLayout(null);
		panel_update_2_2.setBackground(new Color(217, 232, 243));
		panel_update_2_2.setBounds(656, 530, 140, 60);
		contentPane.add(panel_update_2_2);

		JLabel lblThmPhiut_2 = new JLabel("Refresh");
		lblThmPhiut_2.setForeground(new Color(4, 51, 134));
		lblThmPhiut_2.setFont(new Font("Calibri", Font.BOLD, 22));
		lblThmPhiut_2.setBackground(new Color(217, 232, 243));
		lblThmPhiut_2.setBounds(50, 23, 81, 30);
		panel_update_2_2.add(lblThmPhiut_2);

		JLabel lbAdd_icon_2 = new JLabel("");
		lbAdd_icon_2.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\images\\refresh.png")
						.getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH)));

		lbAdd_icon_2.setBounds(10, 13, 28, 43);
		panel_update_2_2.add(lbAdd_icon_2);
	}
}
