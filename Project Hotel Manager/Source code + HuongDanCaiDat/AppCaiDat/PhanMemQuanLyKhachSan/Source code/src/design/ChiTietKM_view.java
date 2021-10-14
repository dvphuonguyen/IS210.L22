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
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Class.ChiTietKM;
import Class.KhuyenMai;

import javax.swing.ScrollPaneConstants;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class ChiTietKM_view extends JFrame {

	private JPanel contentPane;
	private JTextField textField_phantram;
	private JTable table;
	DefaultTableModel tableModel;
	ArrayList<ChiTietKM> Listctkm = new ArrayList<ChiTietKM>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChiTietKM_view frame = new ChiTietKM_view();
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
		 Listctkm = KhuyenMai_Modifiers.findAll_CTKM();
		
		for (ChiTietKM km : Listctkm)
		{
			tableModel.addRow(new Object[] {
				km.getMaLKH(), km.getMaKM(), km.getPhanTram()
			});
		}
	}
	public ChiTietKM_view() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 611, 434);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(217, 232, 243));

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChiTitKhuyn = new JLabel("CHI TI\u1EBET KHUY\u1EBEN M\u00C3I");
		lblChiTitKhuyn.setForeground(new Color(4, 51, 134));
		lblChiTitKhuyn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblChiTitKhuyn.setBounds(163, 23, 324, 50);
		contentPane.add(lblChiTitKhuyn);
		
		JLabel lbInput_sdt = new JLabel("Ch\u1ECDn m\u00E3 lo\u1EA1i kh\u00E1ch h\u00E0ng:\r\n");
		lbInput_sdt.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbInput_sdt.setForeground(new Color(4, 51, 134));
		lbInput_sdt.setBounds(62, 100, 196, 22);
		contentPane.add(lbInput_sdt);
		
		JComboBox cb_malkh = new JComboBox();
		cb_malkh.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		cb_malkh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cb_malkh.setFocusable(false);
		cb_malkh.setBounds(263, 95, 50, 24);
		contentPane.add(cb_malkh);
		
		JLabel lbInput_sdt_1 = new JLabel("Ph\u1EA7n tr\u0103m gi\u1EA3m gi\u00E1: \r\n");
		lbInput_sdt_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbInput_sdt_1.setForeground(new Color(4, 51, 134));
		lbInput_sdt_1.setBounds(62, 150, 160, 22);
		contentPane.add(lbInput_sdt_1);
		
		JLabel lbInput_sdt_1_1 = new JLabel("%");
		lbInput_sdt_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbInput_sdt_1_1.setBounds(323, 146, 38, 22);
		contentPane.add(lbInput_sdt_1_1);
		
		textField_phantram = new JTextField();
		textField_phantram.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_phantram.setColumns(10);
		textField_phantram.setBounds(263, 143, 50, 29);
		contentPane.add(textField_phantram);
		
		JPanel panel_them = new JPanel();
		panel_them.setBackground(new Color(217, 232, 243));

		panel_them.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ChiTietKM ctkm = new ChiTietKM(
							Integer.valueOf((String) cb_malkh.getSelectedItem()),
							QL_KhuyenMai_view.maKM,
							Integer.valueOf(textField_phantram.getText())
					);
					KhuyenMai_Modifiers.Add_CTKM(ctkm);
					JOptionPane.showMessageDialog(null, "Thêm thành công");
					textField_phantram.setText(null);
					cb_malkh.setSelectedIndex(0);
					showAll();
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		panel_them.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_them.setBounds(383, 103, 172, 48);
		contentPane.add(panel_them);
		panel_them.setLayout(null);
		
		JLabel lblThm = new JLabel("THÊM");
		lblThm.setForeground(new Color(4, 51, 134));
		lblThm.setBounds(61, 10, 101, 33);
		lblThm.setFont(new Font("Calibri", Font.PLAIN, 23));
		panel_them.add(lblThm);
		
		JLabel lbAdd_icon_2_1_1_1 = new JLabel("");
		lbAdd_icon_2_1_1_1.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\images\\plus1.png")
						.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));

		lbAdd_icon_2_1_1_1.setBounds(23, 0, 32, 43);
		panel_them.add(lbAdd_icon_2_1_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setBounds(119, 193, 368, 168);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MALKH", "MAKM", "GIAMGIA"
			}
		));
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableModel = (DefaultTableModel) table.getModel();
		showAll();
		scrollPane.setViewportView(table);
	}

}
