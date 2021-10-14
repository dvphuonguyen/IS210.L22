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

public class Add_KhachHang extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Name;
	private JTextField textField_CMND;
	private JTextField textField_sdt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox cb_Country;
	private JComboBox cb_day;
	private JComboBox cb_month;
	private JComboBox cb_year;
	private JLabel lbError_Name;
	private JLabel lbError_SDT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_KhachHang frame = new Add_KhachHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}

	/**
	 * Create the frame.
	 */
	public Add_KhachHang() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 561, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(217, 232, 243));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbInput_sdt = new JLabel("Nh\u1EADp t\u00EAn kh\u00E1ch h\u00E0ng : ");
		lbInput_sdt.setFont(new Font("Calibri", Font.PLAIN, 19));
		lbInput_sdt.setBounds(32, 90, 188, 22);
		lbInput_sdt.setForeground(new Color(4, 51, 134));

		contentPane.add(lbInput_sdt);

		JLabel lbInput_sdt_1 = new JLabel("Nh\u1EADp s\u1ED1 \u0111i\u1EC7n tho\u1EA1i : ");
		lbInput_sdt_1.setFont(new Font("Calibri", Font.PLAIN, 19));
		lbInput_sdt_1.setForeground(new Color(4, 51, 134));

		lbInput_sdt_1.setBounds(32, 182, 176, 22);
		contentPane.add(lbInput_sdt_1);

		JLabel lbInput_CMND = new JLabel("Nh\u1EADp CMND : ");
		lbInput_CMND.setFont(new Font("Calibri", Font.PLAIN, 19));
		lbInput_CMND.setForeground(new Color(4, 51, 134));

		lbInput_CMND.setBounds(32, 136, 134, 22);
		contentPane.add(lbInput_CMND);

		JLabel lbInput_NgaySinh = new JLabel("Nh\u1EADp ng\u00E0y sinh : ");
		lbInput_NgaySinh.setFont(new Font("Calibri", Font.PLAIN, 19));
		lbInput_NgaySinh.setBounds(32, 279, 134, 22);
		lbInput_NgaySinh.setForeground(new Color(4, 51, 134));

		contentPane.add(lbInput_NgaySinh);

		JLabel lbInput_gender = new JLabel("Gi\u1EDBi t\u00EDnh : ");
		lbInput_gender.setFont(new Font("Calibri", Font.PLAIN, 19));
		lbInput_gender.setForeground(new Color(4, 51, 134));

		lbInput_gender.setBounds(32, 229, 89, 22);
		contentPane.add(lbInput_gender);

		JRadioButton rdbtnNam = new JRadioButton("Nam");
		buttonGroup.add(rdbtnNam);
		rdbtnNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNam.setForeground(new Color(4, 51, 134));
		rdbtnNam.setBackground(new Color(217, 232, 243));
		rdbtnNam.setBounds(218, 225, 63, 21);
		contentPane.add(rdbtnNam);

		JRadioButton rdbtnNu = new JRadioButton("N\u1EEF");
		buttonGroup.add(rdbtnNu);
		rdbtnNu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNu.setBounds(312, 225, 103, 21);
		rdbtnNu.setBackground(new Color(217, 232, 243));
		rdbtnNu.setForeground(new Color(4, 51, 134));

		contentPane.add(rdbtnNu);

		textField_Name = new JTextField();
		textField_Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Name.setBounds(218, 83, 226, 29);
		contentPane.add(textField_Name);
		textField_Name.setColumns(10);

		textField_CMND = new JTextField();
		textField_CMND.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_CMND.setColumns(10);
		textField_CMND.setBounds(218, 130, 226, 29);
		contentPane.add(textField_CMND);

		textField_sdt = new JTextField();
		textField_sdt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_sdt.setColumns(10);
		textField_sdt.setBounds(218, 176, 226, 29);
		contentPane.add(textField_sdt);

		JLabel lbReturn = new JLabel("");
		lbReturn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				QL_KhachHang_view kh = new QL_KhachHang_view();
				kh.setVisible(true);
				close();
			}
		});
		lbReturn.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\logout.png")
						.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
		lbReturn.setBounds(479, 398, 45, 42);
		contentPane.add(lbReturn);

		JLabel lblThmKhchHng = new JLabel("TH\u00CAM KH\u00C1CH H\u00C0NG");
		lblThmKhchHng.setForeground(new Color(4, 51, 134));
		lblThmKhchHng.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblThmKhchHng.setBounds(125, 30, 280, 50);
		contentPane.add(lblThmKhchHng);

		cb_Country = new JComboBox();
		cb_Country.setFocusable(false);
		cb_Country.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_Country.setModel(new DefaultComboBoxModel(
				new String[] { "Việt Nam", "Lào", "Campuchia", "Anh", "Pháp", "Mỹ", "Đức", "Ý", "Nhật" }));
		cb_Country.setBounds(218, 324, 97, 29);
		contentPane.add(cb_Country);

		JLabel lbInput_NgaySinh_1 = new JLabel("Chọn quốc tịch :");
		lbInput_NgaySinh_1.setFont(new Font("Calibri", Font.PLAIN, 19));
		lbInput_NgaySinh_1.setForeground(new Color(4, 51, 134));

		lbInput_NgaySinh_1.setBounds(32, 331, 134, 22);
		contentPane.add(lbInput_NgaySinh_1);

		cb_day = new JComboBox();
		cb_day.setFocusable(false);
		cb_day.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_day.setModel(new DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
				"27", "28", "29", "30", "31" }));
		cb_day.setBounds(218, 274, 50, 24);
		contentPane.add(cb_day);

		cb_month = new JComboBox();
		cb_month.setFocusable(false);
		cb_month.setModel(new DefaultComboBoxModel(
				new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
		cb_month.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_month.setBounds(290, 276, 50, 21);
		contentPane.add(cb_month);

		cb_year = new JComboBox();
		cb_year.setFocusable(false);
		for (int i = 2021 ; i>=1932; i--)
		{
			String ns = String.valueOf(i);

			cb_year.addItem(ns);
		
		}
		cb_year.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_year.setBounds(355, 276, 89, 21);
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
				while (place.hasMoreElements()) {
					JRadioButton Radio = (JRadioButton) place.nextElement();
					if (Radio.isSelected())
						gender = Radio.getText();
				}

				String country;
				country = String.valueOf(cb_Country.getSelectedItem());

				try {
					if (tenKH.trim().length() > 0 && sdtKH.trim().length() > 0) {
						KhachHang kh = new KhachHang(tenKH, cccdKH,  sdtKH,  gender,
								java.sql.Date.valueOf(ngaySinh), country, 0, 1);
						System.out.println(kh.getMaLoaiKH());
						KH_Modifiers.Add(kh);
						
					} else
						
					textField_Name.setText(null);
					textField_CMND.setText(null);
			
					textField_sdt.setText(null);
			
				} catch (Exception e1) {
					
					e1.printStackTrace();
					
				}
			}
		});
		panel_add.setLayout(null);
		panel_add.setBackground(new Color(217, 232, 243));
		panel_add.setBounds(161, 382, 158, 55);
		contentPane.add(panel_add);

		JLabel lblThm = new JLabel("THÊM");
		lblThm.setForeground(new Color(4, 51, 134));
		lblThm.setFont(new Font("Calibri", Font.BOLD, 25));
		lblThm.setBounds(68, 10, 107, 45);
		panel_add.add(lblThm);

		JLabel lbAdd_icon = new JLabel("");
		lbAdd_icon.setBounds(26, 0, 32, 55);
		lbAdd_icon.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\plus_32px.png")
						.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));

		panel_add.add(lbAdd_icon);

	}
}
