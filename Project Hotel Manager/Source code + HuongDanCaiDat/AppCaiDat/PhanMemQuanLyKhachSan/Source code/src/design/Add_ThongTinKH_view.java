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
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import java.util.ArrayList;


import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Class.PhieuDatPhong;
import Class.PhieuThuePhong;
import Class.KhachHang;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
public class Add_ThongTinKH_view extends JFrame {

	private JPanel contentPane;
	private JTextField textField_sdt;
	private JTextField textField_cmnd;
	private JTextField textField_name;
	ArrayList<KhachHang> listKH = new ArrayList<KhachHang>();
	private JComboBox cb_cmnd;
	private JComboBox cb_sdt;
	
	Login a = new Login();
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_ThongTinKH_view frame = new Add_ThongTinKH_view();
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
	public Add_ThongTinKH_view() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 443, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(217, 232, 243));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		KH_Modifiers khmo = new KH_Modifiers();
		listKH = khmo.findAll();
		
		cb_cmnd = new JComboBox();
		cb_cmnd.setVisible(false);
		cb_cmnd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (KhachHang kh : listKH)
				{
					textField_cmnd.setText(kh.getCccdKH());
					textField_name.setText(kh.getTenKH());
					textField_sdt.setText(kh.getSdtKH());
				}
				cb_cmnd.setVisible(false);
			}
		});
		
		cb_sdt = new JComboBox();
		cb_sdt.setVisible(false);
		
		cb_sdt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (KhachHang kh : listKH)
				{
					textField_sdt.setText(kh.getSdtKH());
					textField_cmnd.setText(kh.getCccdKH());
					textField_name.setText(kh.getTenKH());
				}
				cb_sdt.setVisible(false);
			}
		});
		cb_sdt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_sdt.setFocusable(false);
		cb_sdt.setBounds(176, 201, 196, 24);
		contentPane.add(cb_sdt);
		cb_cmnd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_cmnd.setFocusable(false);
		cb_cmnd.setBounds(176, 263, 196, 24);
		contentPane.add(cb_cmnd);
		
		JLabel lblThngTinKhch = new JLabel("Th\u00F4ng tin kh\u00E1ch h\u00E0ng");
		lblThngTinKhch.setForeground(new Color(4, 51, 134));
		lblThngTinKhch.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblThngTinKhch.setBounds(70, 37, 310, 42);
		contentPane.add(lblThngTinKhch);
		
		JLabel lblThngTinKhch_1 = new JLabel("________________________");
		lblThngTinKhch_1.setForeground(new Color(4, 51, 134));
		lblThngTinKhch_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThngTinKhch_1.setBounds(55, 57, 310, 42);
		contentPane.add(lblThngTinKhch_1);
		
		textField_sdt = new JTextField();
		textField_sdt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				listKH = KH_Modifiers.FindbySDT(textField_sdt.getText());
				for (KhachHang kh : listKH) {
					cb_sdt.addItem(kh.getSdtKH());
					cb_sdt.setVisible(true);
				}
			}
		});
		
		textField_sdt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_sdt.setColumns(10);
		textField_sdt.setBounds(176, 179, 196, 34);
		contentPane.add(textField_sdt);
		
		JLabel lbInput_Name = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i : ");
		lbInput_Name.setFont(new Font("Calibri", Font.PLAIN, 19));
		lbInput_Name.setBounds(51, 184, 117, 22);
		lbInput_Name.setForeground(new Color(4, 51, 134));
		contentPane.add(lbInput_Name);
		
		JLabel lbInput_Name_1 = new JLabel("CMND:");
		lbInput_Name_1.setFont(new Font("Calibri", Font.PLAIN, 19));
		lbInput_Name_1.setBounds(51, 240, 107, 22);
		lbInput_Name_1.setForeground(new Color(4, 51, 134));
		contentPane.add(lbInput_Name_1);
		
		textField_cmnd = new JTextField();
		textField_cmnd.addKeyListener(new KeyAdapter() {
			@Override
			
			
			public void keyReleased(KeyEvent e) {
				
				listKH = KH_Modifiers.FindbyCCCD(textField_cmnd.getText());
				for (KhachHang kh : listKH) {
					cb_cmnd.addItem(kh.getCccdKH());
					cb_cmnd.setVisible(true);
				}
				

			}
		});
		textField_cmnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_cmnd.setColumns(10);
		textField_cmnd.setBounds(176, 235, 196, 34);
		contentPane.add(textField_cmnd);
		
		JLabel lbInput_Name_2 = new JLabel("H\u1ECD t\u00EAn:");
		lbInput_Name_2.setFont(new Font("Calibri", Font.PLAIN, 19));
		lbInput_Name_2.setBounds(51, 125, 107, 22);
		lbInput_Name_2.setForeground(new Color(4, 51, 134));
		contentPane.add(lbInput_Name_2);
		
		textField_name = new JTextField();
		textField_name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_name.setColumns(10);
		textField_name.setBounds(176, 120, 196, 34);
		contentPane.add(textField_name);
		
		JPanel panel_add = new JPanel();
		panel_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int MaKH = 0;
				listKH = KH_Modifiers.FindbySDT(textField_sdt.getText());
				
				for (KhachHang kh : listKH) {
					MaKH = kh.getMaKH();
				}
				int MaNV = a.MaNV;
				
				long millis= System.currentTimeMillis();   
				java.sql.Date date=new java.sql.Date(millis);   
				System.out.println(date);
		
				if(Phong_view.flag == 1)
				{
					try {
						PhieuDatPhong pdt = new PhieuDatPhong(MaNV, MaKH,date, 1 );
						DATvaTHUEphong_Modifiers.Add(pdt);
						textField_name.setText(null);
						textField_sdt.setText(null);
						textField_cmnd.setText(null);
					
						close();
					}
					catch (Exception e1)
					{
						e1.printStackTrace();
					}
				}
				if(Phong_view.flag == 2)
				{
					try {
						PhieuThuePhong ptt = new PhieuThuePhong(MaNV, MaKH, 0, 1);
						DATvaTHUEphong_Modifiers.Add_ThuePhong_NoPDT(ptt);
						textField_name.setText(null);
						textField_sdt.setText(null);
						textField_cmnd.setText(null);
					
				
						close();
					}
					catch (Exception e1)
					{
						e1.printStackTrace();
					}
				}
			}
		});
		panel_add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add.setLayout(null);
		panel_add.setBackground(new Color(217, 232, 243));
		panel_add.setBounds(153, 298, 158, 55);
		contentPane.add(panel_add);
		
		JLabel lblTo = new JLabel("TẠO");
		
		lblTo.setForeground(new Color(4, 51, 134));
		lblTo.setFont(new Font("Calibri", Font.BOLD, 25));
		lblTo.setBounds(64, 10, 62, 45);
		panel_add.add(lblTo);
		
		JLabel lbAdd_icon = new JLabel("");
		lbAdd_icon.setBounds(22, 0, 50, 55);
		lbAdd_icon.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\plus_32px.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));
		
		panel_add.add(lbAdd_icon);
	}

}
