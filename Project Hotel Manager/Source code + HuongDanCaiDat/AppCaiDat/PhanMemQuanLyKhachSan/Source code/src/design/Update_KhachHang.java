package design;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Class.KhachHang;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import java.awt.Cursor;

public class Update_KhachHang extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1005773989329151449L;
	/**
	 * 
	 */

	private JPanel contentPane;
	private JTextField textField_Name;
	private JTextField textField_CMND;
	private JTextField textField_sdt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox comboBox_Country;
	private JComboBox cb_day;
	private JComboBox cb_month;
	private JComboBox cb_year;
	KhachHang kh;
	private JRadioButton rdbtnNam;
	private JRadioButton rdbtnNu;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Add_KhachHang frame = new Add_KhachHang();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	public void close()
	{
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
	/**
	 * Create the frame.
	 */
	public Update_KhachHang() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 495, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(217, 232, 243));
		setContentPane(contentPane);
		
		System.out.println(kh);
		contentPane.setLayout(null);
		
		JLabel lbInput_sdt = new JLabel("Tên khách hàng : ");
		lbInput_sdt.setBounds(30, 72, 199, 22);
		lbInput_sdt.setForeground(new Color(4, 51, 134));
		lbInput_sdt.setFont(new Font("Calibri", Font.PLAIN, 19));
		contentPane.add(lbInput_sdt);
		
		JLabel lbInput_sdt_1 = new JLabel("Nh\u1EADp s\u1ED1 \u0111i\u1EC7n tho\u1EA1i : ");
		lbInput_sdt_1.setBounds(30, 188, 176, 22);
		lbInput_sdt_1.setFont(new Font("Calibri", Font.PLAIN, 19));
		lbInput_sdt_1.setForeground(new Color(4, 51, 134));
		contentPane.add(lbInput_sdt_1);
		
		JLabel lbInput_CMND = new JLabel("CMND : ");
		lbInput_CMND.setBounds(30, 132, 134, 22);
		lbInput_CMND.setFont(new Font("Calibri", Font.PLAIN, 19));
		lbInput_CMND.setForeground(new Color(4, 51, 134));
		contentPane.add(lbInput_CMND);
		
		JLabel lbInput_NgaySinh = new JLabel("Nh\u1EADp ng\u00E0y sinh : ");
		lbInput_NgaySinh.setBounds(30, 298, 134, 22);
		lbInput_NgaySinh.setFont(new Font("Calibri", Font.PLAIN, 19));
		lbInput_NgaySinh.setForeground(new Color(4, 51, 134));

		contentPane.add(lbInput_NgaySinh);
		
		JLabel lbInput_gender = new JLabel("Gi\u1EDBi t\u00EDnh : ");
		lbInput_gender.setBounds(30, 242, 97, 22);
		lbInput_gender.setFont(new Font("Calibri", Font.PLAIN, 19));
		lbInput_gender.setForeground(new Color(4, 51, 134));

		contentPane.add(lbInput_gender);
		
		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setEnabled(false);
		rdbtnNam.setBounds(216, 236, 63, 21);
		rdbtnNam.setBackground(new Color(217, 232, 243));

		buttonGroup.add(rdbtnNam);
		rdbtnNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(rdbtnNam);
		
		rdbtnNu = new JRadioButton("N\u1EEF");
		rdbtnNu.setEnabled(false);
		rdbtnNu.setBounds(310, 236, 103, 21);
		rdbtnNu.setBackground(new Color(217, 232, 243));
		buttonGroup.add(rdbtnNu);
		rdbtnNu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(rdbtnNu);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(216, 68, 226, 29);
		textField_Name.setEditable(false);
		textField_Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(textField_Name);
		textField_Name.setColumns(10);

		
		textField_CMND = new JTextField();
		textField_CMND.setBounds(216, 127, 226, 29);
		textField_CMND.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_CMND.setColumns(10);
		contentPane.add(textField_CMND);

		
		textField_sdt = new JTextField();
		textField_sdt.setBounds(216, 183, 226, 29);
		textField_sdt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_sdt.setColumns(10);
		contentPane.add(textField_sdt);
		
		JLabel lblThmKhchHng = new JLabel("SỬA KHÁCH HÀNG");
		lblThmKhchHng.setBounds(145, 13, 268, 49);
		lblThmKhchHng.setForeground(new Color(96, 163, 188));
		lblThmKhchHng.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 28));
		lblThmKhchHng.setForeground(new Color(4, 51, 134));
		contentPane.add(lblThmKhchHng);
		
		comboBox_Country = new JComboBox();
		comboBox_Country.setBounds(216, 349, 97, 29);
		comboBox_Country.setFocusable(false);
		comboBox_Country.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_Country.setModel(new DefaultComboBoxModel(new String[] {"Việt Nam", "Lào", "Campuchia", "Anh", "Pháp", "Mỹ", "Đức", "Ý", "Nhật"}));
		contentPane.add(comboBox_Country);
		
		JLabel lbInput_NgaySinh_1 = new JLabel("Chọn quốc tịch :");
		lbInput_NgaySinh_1.setBounds(30, 356, 134, 22);
		lbInput_NgaySinh_1.setForeground(new Color(4, 51, 134));
		lbInput_NgaySinh_1.setFont(new Font("Calibri", Font.PLAIN, 19));
		contentPane.add(lbInput_NgaySinh_1);
		
		cb_day = new JComboBox();
		cb_day.setEnabled(false);
		cb_day.setBounds(216, 291, 45, 24);
		cb_day.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cb_day.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_day.setFocusable(false);
		contentPane.add(cb_day);
		
		cb_month = new JComboBox();
		cb_month.setEnabled(false);
		cb_month.setBounds(288, 291, 45, 24);
		cb_month.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		cb_month.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_month.setFocusable(false);
		contentPane.add(cb_month);
		
		cb_year = new JComboBox();
		cb_year.setEnabled(false);
		cb_year.setBounds(353, 291, 89, 24);
		for (int i = 2021 ; i>=1932; i--)
		{
			String ns = String.valueOf(i);

			cb_year.addItem(ns);
		
		}
		cb_year.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_year.setFocusable(false);
		contentPane.add(cb_year);
		
		JPanel panel_add = new JPanel();
		panel_add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String tenKH = textField_Name.getText();
				String cccdKH = textField_CMND.getText();
				
				String sdtKH = textField_sdt.getText();
			
			
				String date = String.valueOf(cb_day.getSelectedItem());
				String month = String.valueOf(cb_month.getSelectedItem());
				String year = String.valueOf(cb_year.getSelectedItem());
				String ngaySinh = year + "-" + month + "-" + date;
				
				String gender = null;
				Enumeration<AbstractButton> place = buttonGroup.getElements();
				while (place.hasMoreElements())
				{
					JRadioButton Radio = (JRadioButton)place.nextElement();
					if(Radio.isSelected())
						gender = Radio.getText();
				}
				
				String country;
				country = String.valueOf(comboBox_Country.getSelectedItem());
				
				
				try {
					int flag  = 0;
					flag = NV_KhachHang_view.flagUpdate;
					
					KhachHang kh = new KhachHang(tenKH,  sdtKH, cccdKH ,gender, java.sql.Date.valueOf(ngaySinh) , country );
					if (flag == 1)
						KH_Modifiers.Update(kh, NV_KhachHang_view.maKH);
					else if (flag == 0)
						KH_Modifiers.Update(kh, QL_KhachHang_view.maKH);
					
					
					
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
				
		        close();
			}
		});
		panel_add.setLayout(null);
		panel_add.setBackground(new Color(217, 232, 243));
		panel_add.setBounds(184, 403, 176, 55);
		contentPane.add(panel_add);
		
		JLabel lblSa = new JLabel("SỬA");
		lblSa.setForeground(new Color(4, 51, 134));
		lblSa.setFont(new Font("Calibri", Font.BOLD, 25));
		lblSa.setBounds(74, 13, 74, 40);
		panel_add.add(lblSa);
		
		JLabel lbAdd_icon = new JLabel("");
		lbAdd_icon.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\update.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
		
		lbAdd_icon.setBounds(22, 0, 50, 55);
		panel_add.add(lbAdd_icon);
		
		
	}
	public void gui() {
		
		if(kh != null) {
			textField_Name.setText(kh.getTenKH());
			textField_CMND.setText(kh.getCccdKH());
		
			textField_sdt.setText(kh.getSdtKH());
			if(kh.getGioiTinhKH().contains("Nam")){
				rdbtnNam.setSelected(true);
			}else if (kh.getGioiTinhKH().contains("Nữ")){
				rdbtnNu.setSelected(true);
			}
			
			String dateNS = String.valueOf(kh.getNgaySinh());
			System.out.println(dateNS);
			
			cb_year.setSelectedItem(dateNS.substring(0, 4)) ;
			cb_month.setSelectedItem(dateNS.substring(5, 7));
			cb_day.setSelectedItem(dateNS.substring(8, 10));
		}
	}
}
