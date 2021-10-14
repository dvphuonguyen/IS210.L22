package design;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class ChiTiet_TTP extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel tableModel;
	ArrayList CHITIETTTP = new ArrayList();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChiTiet_TTP frame = new ChiTiet_TTP();
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
		for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
		CHITIETTTP = Phong_Modifiers.findAll_ChiTietTTP(Phong_view.maP);

		HashMap<String, String> p;

		for (int i = 0; i < CHITIETTTP.size(); i++) {
			p = (HashMap<String, String>) CHITIETTTP.get(i);
			tableModel.addRow(
					new Object[] { p.get("MAPHONG"), p.get("NGAYBD"), p.get("NGAYKT"), p.get("TENTTP") });
		}

	}
	public ChiTiet_TTP() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 688, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(217, 232, 243));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChiTitTnh = new JLabel("CHI TI\u1EBET T\u00CCNH TR\u1EA0NG PH\u00D2NG");
		lblChiTitTnh.setForeground(new Color(4, 51, 134));
		lblChiTitTnh.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblChiTitTnh.setBounds(105, 10, 461, 42);
		contentPane.add(lblChiTitTnh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(78, 78, 524, 152);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MAPHONG", "NGAYBD", "NGAYKT", "TINHTRANG"
			}
		));
		tableModel = (DefaultTableModel) table.getModel();
		showAll();
		scrollPane.setViewportView(table);
	}
}
