package design;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Class.ChiTietPDP;

import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChiTiet_PDP_view extends JFrame {

	JLabel lbReturn1;
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel tableModel;
	ArrayList ctpdp = new ArrayList();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChiTiet_PDP_view frame = new ChiTiet_PDP_view();
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
		
	
		ctpdp = DATvaTHUEphong_Modifiers.findAll_CTPDP(PhieuDatPhong_view.PDP);
		HashMap<String, String> p;
		
		for(int i = 0; i < ctpdp.size(); i++) {
			p = (HashMap<String, String>) ctpdp.get(i);
			tableModel.addRow(new Object[] {
				p.get("MAPDP"),p.get("MAPHONG") , p.get("TENPHONG"),p.get("NGAYNP"),p.get("NGAYTPDD")
				});
		}
	}
	public void close()
	{
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
	public ChiTiet_PDP_view() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 691, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(217, 232, 243));
		setContentPane(contentPane);
		contentPane.setLayout(null);

	
		
		JLabel lblChiTitPhiu = new JLabel("CHI TI\u1EBET PHI\u1EBEU \u0110\u1EB6T PH\u00D2NG");
		lblChiTitPhiu.setForeground(new Color(4, 51, 134));
		lblChiTitPhiu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblChiTitPhiu.setBounds(113, 32, 508, 37);
		contentPane.add(lblChiTitPhiu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 87, 593, 283);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MAPDP", "MAPHONG", "TENPHONG", "NGAYNP", "NGAYTP_DUKIEN"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableModel = (DefaultTableModel) table.getModel();
		showAll();
	
		scrollPane.setViewportView(table);
		
		JPanel panel_them_1 = new JPanel();
		panel_them_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectedIndex = table.getSelectedRow();
				
				if (SelectedIndex > -1) {
					int option = JOptionPane.showConfirmDialog(null, "Bạn muốn xoá phòng này?" ,"Warning", 2);
					
					if (option == 0) {
						int MaPhong = Integer.valueOf((String) table.getValueAt(SelectedIndex, 1)) ;
						Date ngaynp = Date.valueOf((String) table.getValueAt(SelectedIndex, 3)) ;
						Date ngaytp = Date.valueOf((String) table.getValueAt(SelectedIndex, 3)) ;

						DATvaTHUEphong_Modifiers.DeletePhong_fromCTPhieuDat(MaPhong);
						
						///Phong_Modifiers.Update_xoa(MaPhong, ngaynp, ngaytp);

						showAll();
					}
					
				}
			}
		});
		panel_them_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_them_1.setLayout(null);
		panel_them_1.setBackground(new Color(217, 232, 243));
		panel_them_1.setBounds(261, 398, 172, 48);
		contentPane.add(panel_them_1);
		
		JLabel lbxoa = new JLabel("XOÁ");
		lbxoa.setForeground(new Color(4, 51, 134));
		lbxoa.setFont(new Font("Calibri", Font.PLAIN, 23));
		lbxoa.setBackground(new Color(217, 232, 243));
		lbxoa.setBounds(81, 10, 67, 33);
		panel_them_1.add(lbxoa);
		
		JLabel lbxoaIcon = new JLabel("");
		lbxoaIcon.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\images\\clear.png")
						.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));

		lbxoaIcon.setBounds(39, 0, 32, 43);
		panel_them_1.add(lbxoaIcon);
		

	}
}
