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
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class ChiTiet_PTP extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel tableModel;
	ArrayList ctptp = new ArrayList();
	String ngayNP = null, ngayTP = null;
	static int SLnguoi = 0;
	static float phuThu = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChiTiet_PTP frame = new ChiTiet_PTP();
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
	public void showAll() {
		
		// xoá dữ liêu table trước khi export dữ liệu mới
		for( int i = tableModel.getRowCount() - 1; i >= 0; i-- ) {
			 tableModel.removeRow(i);
		    }
		
		ctptp = DATvaTHUEphong_Modifiers.findAll_ChiTietPTP(PhieuThuePhong_view.PTP);
		HashMap<String, String> p;
		
		for(int i = 0; i < ctptp.size(); i++) {
			p = (HashMap<String, String>) ctptp.get(i);
			tableModel.addRow(new Object[] {
				p.get("MAPTP"),p.get("MAPHONG") , p.get("TENPHONG"),p.get("NGAYNP"),p.get("NGAYTPTT"),
				p.get("SLNGUOI"), p.get("PHUTHU")
				});
		}
	}
	public ChiTiet_PTP() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 720, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(217, 232, 243));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChiTitPhiu_1 = new JLabel("CHI TI\u1EBET PHI\u1EBEU THU\u00CA PH\u00D2NG");
		lblChiTitPhiu_1.setForeground(new Color(4, 51, 134));
		lblChiTitPhiu_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblChiTitPhiu_1.setBounds(112, 10, 508, 37);
		contentPane.add(lblChiTitPhiu_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 56, 686, 339);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MAPTP", "MAPHONG", "TENPHONG", "NGAYNP", "NGAYTP", "SLNGUOI", "PHUTHU"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class, String.class, String.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableModel = (DefaultTableModel) table.getModel();
		showAll();
		scrollPane.setViewportView(table);
	}
}
