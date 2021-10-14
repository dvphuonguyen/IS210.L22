package design;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Class.KhachHang;
import Class.NhanVien;

import java.awt.SystemColor;

public class Find_NV_view extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Name;
	private JTextField textField_CMND;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lbReturn;
	DefaultTableModel tableModel;
	JTable table;
	ArrayList <NhanVien> ListNV = new ArrayList<NhanVien>();
	ArrayList <NhanVien> ListNV1 = new ArrayList<NhanVien>();
	ArrayList <NhanVien> ListNV2 = new ArrayList<NhanVien>();
	Update_NhanVien update;
	static int ma = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Find_NV_view frame = new Find_NV_view();
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
		  ListNV = NV_Modifiers.findAll();
		
		for (NhanVien nv : ListNV)
		{
			tableModel.addRow(new Object[] {
				nv.getMaNV(), nv.getTenNV(),nv.getEmail() ,nv.getNgaySinh(), nv.getGioiTinh(), nv.getCCCD(),
				nv.getChucVu(), nv.getNgayVL(), nv.getMaQL(), nv.getUsername(), nv.getPassword()
			});
		}
	}
	public Find_NV_view() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 848, 664);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(217, 232, 243));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbInput_Name = new JLabel("Nhập tên nhân viên : ");
		lbInput_Name.setFont(new Font("Calibri", Font.BOLD, 20));
		lbInput_Name.setForeground(new Color(4, 51, 134));
		lbInput_Name.setBounds(62, 113, 216, 30);
		contentPane.add(lbInput_Name);
		
		JLabel lbInput_CMND = new JLabel("Nh\u1EADp CMND : ");
		lbInput_CMND.setFont(new Font("Calibri", Font.BOLD, 20));
		lbInput_CMND.setForeground(new Color(4, 51, 134));
		lbInput_CMND.setBounds(124, 173, 134, 22);
		contentPane.add(lbInput_CMND);
		
		textField_Name = new JTextField();
		textField_Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Name.setBounds(277, 109, 207, 34);
		contentPane.add(textField_Name);
		textField_Name.setColumns(10);
		
		textField_CMND = new JTextField();
		textField_CMND.setBounds(277, 167, 207, 34);
		contentPane.add(textField_CMND);
		textField_CMND.setColumns(10);
		
		lblNewLabel = new JLabel("TRA CỨU NHÂN VIÊN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setForeground(new Color(4, 51, 134));
		lblNewLabel.setBounds(271, 31, 419, 42);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("K\u1EBFt qu\u1EA3");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(392, 231, 99, 36);
		lblNewLabel_1.setForeground(new Color(4, 51, 134));
		contentPane.add(lblNewLabel_1);
		
		lbReturn = new JLabel("");
		lbReturn.setBounds(772, 529, 52, 51);
		lbReturn.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\logout.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
		lbReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				QL_NV_view ql = new QL_NV_view();
				ql.setVisible(true);
				close();
			}
		});
		contentPane.add(lbReturn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Calibri", Font.PLAIN, 14));
		scrollPane.setBounds(0, 276, 834, 180);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(217, 232, 243));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MANV", "TENNV", "EMAIL", "NGAYSINH", "GIOITINH", "CCCD", "CHUCVU", "NGAYVL", "MAQL", "USERNAME", "PASSWORD"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class, Object.class, Integer.class, Object.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableModel = (DefaultTableModel) table.getModel();
		scrollPane.setViewportView(table);
		
		JPanel panel_find = new JPanel();
		panel_find.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textField_Name.getText().trim().length() > 0)
				{
					ListNV1 = NV_Modifiers.FindbyName(textField_Name.getText());
					tableModel.setRowCount(0);
			        
					ListNV1.forEach((nv) -> {
					tableModel.addRow(new Object[] {
								nv.getMaNV(), nv.getTenNV(),nv.getEmail() ,nv.getNgaySinh(), nv.getGioiTinh(), nv.getCCCD(),
								nv.getChucVu(), nv.getNgayVL(), nv.getMaQL(), nv.getUsername(), nv.getPassword()
							});
		            });     
				}
				else if (textField_CMND.getText().trim().length() > 0)
				{
					ListNV2 = NV_Modifiers.FindbyCCCD(textField_CMND.getText());
					tableModel.setRowCount(0);
			        
					ListNV2.forEach((nv) -> {
					tableModel.addRow(new Object[] {
								nv.getMaNV(), nv.getTenNV(),nv.getEmail() ,nv.getNgaySinh(), nv.getGioiTinh(), nv.getCCCD(),
								nv.getChucVu(), nv.getNgayVL(), nv.getMaQL(), nv.getUsername(), nv.getPassword()
							});
		            });     
				}
			}
			
		});
		panel_find.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_find.setBounds(522, 83, 181, 72);
		panel_find.setBackground(new Color(217, 232, 243));
		contentPane.add(panel_find);
		panel_find.setLayout(null);
		
		JLabel lblTmKim = new JLabel("Tìm kiếm");
		lblTmKim.setForeground(new Color(4, 51, 134));
		lblTmKim.setFont(new Font("Calibri", Font.BOLD, 22));
		lblTmKim.setBackground(new Color(217, 232, 243));
		lblTmKim.setBounds(66, 33, 98, 30);
		panel_find.add(lblTmKim);
		
		JLabel lbAdd_icon = new JLabel("");
		lbAdd_icon.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\search.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
		
		lbAdd_icon.setBounds(10, 20, 46, 43);
		panel_find.add(lbAdd_icon);
		
		JPanel panel_findAll = new JPanel();
		panel_findAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showAll();
			}
		});
		panel_findAll.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_findAll.setLayout(null);
		panel_findAll.setBackground(new Color(217, 232, 243));
		panel_findAll.setBounds(532, 169, 228, 51);
		contentPane.add(panel_findAll);
		
		JLabel lblHinThTt = new JLabel("Hiển thị tất cả");
		lblHinThTt.setForeground(new Color(4, 51, 134));
		lblHinThTt.setFont(new Font("Calibri", Font.BOLD, 22));
		lblHinThTt.setBackground(new Color(217, 232, 243));
		lblHinThTt.setBounds(55, 10, 140, 30);
		panel_findAll.add(lblHinThTt);
		
		JLabel lbAdd_icon_1 = new JLabel("");
		lbAdd_icon_1.setBounds(0, 0, 45, 43);
		lbAdd_icon_1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\searchall.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
		
		panel_findAll.add(lbAdd_icon_1);
		
		JPanel panel_update = new JPanel();
		panel_update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectedIndex = table.getSelectedRow();
				
				if (SelectedIndex > -1) {
					
					ma = (int) table.getValueAt(SelectedIndex, 0);
					
					int option = JOptionPane.showConfirmDialog(null, "Bạn muốn sửa nhân viên này?" ,"Warning", 2);
					
					if (option == 0) {
						
						for (NhanVien nv : ListNV) {
							if(nv.getMaNV() == ma) {
								update = new Update_NhanVien();
								update.nv = nv;
								update.gui();
							}
						}
				
						update.setVisible(true);
					}
				}
			}
		});
		panel_update.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_update.setLayout(null);
		panel_update.setBackground(new Color(217, 232, 243));
		panel_update.setBounds(158, 491, 228, 60);
		contentPane.add(panel_update);
		
		JLabel lblSaNhnVin = new JLabel("Sửa nhân viên");
		lblSaNhnVin.setForeground(new Color(4, 51, 134));
		lblSaNhnVin.setFont(new Font("Calibri", Font.BOLD, 22));
		lblSaNhnVin.setBackground(new Color(217, 232, 243));
		lblSaNhnVin.setBounds(55, 23, 140, 30);
		panel_update.add(lblSaNhnVin);
		
		JLabel lbAdd_icon_1_1 = new JLabel("");
		lbAdd_icon_1_1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\update.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
		
		lbAdd_icon_1_1.setBounds(10, 13, 51, 43);
		panel_update.add(lbAdd_icon_1_1);
		
		JPanel panel_update_1 = new JPanel();
		panel_update_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectedIndex = table.getSelectedRow();
				
				if (SelectedIndex > -1) {
					NhanVien Selected_NV = ListNV.get(SelectedIndex);
					
					int option = JOptionPane.showConfirmDialog(null, "Bạn muốn xoá nhân viên này?" ,"Warning", 2);
					
					if (option == 0) {
						NV_Modifiers.Delete(Selected_NV.getCCCD());
						showAll();
					}
				}
			}
		});
		panel_update_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_update_1.setLayout(null);
		panel_update_1.setBackground(new Color(217, 232, 243));
		panel_update_1.setBounds(475, 497, 228, 60);
		contentPane.add(panel_update_1);
		
		JLabel lblXoNhnVin = new JLabel("Xoá nhân viên");
		lblXoNhnVin.setForeground(new Color(4, 51, 134));
		lblXoNhnVin.setFont(new Font("Calibri", Font.BOLD, 22));
		lblXoNhnVin.setBackground(new Color(217, 232, 243));
		lblXoNhnVin.setBounds(55, 18, 140, 30);
		panel_update_1.add(lblXoNhnVin);
		
		JLabel lbAdd_icon_1_1_1 = new JLabel("");
		lbAdd_icon_1_1_1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\delete.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
		
		lbAdd_icon_1_1_1.setBounds(10, 7, 35, 43);
		panel_update_1.add(lbAdd_icon_1_1_1);
	}
}
