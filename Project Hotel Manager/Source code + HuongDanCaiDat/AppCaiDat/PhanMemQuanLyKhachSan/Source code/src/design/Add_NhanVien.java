package design;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Class.KhachHang;
import Class.NhanVien;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Vector;

public class Add_NhanVien extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Name;
	private JTextField textField_CMND;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox cb_ChucVu;
	private JComboBox cb_dayNS;
	private JComboBox cb_monthNS;
	private JComboBox cb_yearNS;
	private JLabel lbError_Name;
	private JLabel lbError_SDT;
	private JComboBox cb_dayNVL;
	private JComboBox cb_monthNVL;
	private JComboBox cb_yearNVL;
	private final JComboBox cb_NQL;
	ArrayList<NhanVien> listNQL = new ArrayList<>();
	private JTextField textField_email;
	private JTextField textField_username;
	private JTextField textField_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_NhanVien frame = new Add_NhanVien();
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
	public Add_NhanVien() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 996, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(217, 232, 243));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbInput_sdt = new JLabel("Nhập tên nhân viên : ");
		lbInput_sdt.setFont(new Font("Calibri", Font.PLAIN, 19));
		lbInput_sdt.setForeground(new Color(4, 51, 134));
		lbInput_sdt.setBounds(54, 87, 176, 22);
		contentPane.add(lbInput_sdt);

		JLabel lbInput_CMND = new JLabel("Nh\u1EADp CMND : ");
		lbInput_CMND.setFont(new Font("Calibri", Font.PLAIN, 19));
		lbInput_CMND.setForeground(new Color(4, 51, 134));
		lbInput_CMND.setBounds(54, 137, 134, 22);
		contentPane.add(lbInput_CMND);

		JLabel lbInput_NgaySinh = new JLabel("Nh\u1EADp ng\u00E0y sinh : ");
		lbInput_NgaySinh.setFont(new Font("Calibri", Font.PLAIN, 19));
		lbInput_NgaySinh.setForeground(new Color(4, 51, 134));
		lbInput_NgaySinh.setBounds(54, 189, 134, 22);
		contentPane.add(lbInput_NgaySinh);

		listNQL = NV_Modifiers.FindQL();

		JLabel lbInput_gender = new JLabel("Gi\u1EDBi t\u00EDnh : ");
		lbInput_gender.setFont(new Font("Calibri", Font.PLAIN, 19));
		lbInput_gender.setForeground(new Color(4, 51, 134));
		lbInput_gender.setBounds(54, 293, 97, 22);
		contentPane.add(lbInput_gender);

		JRadioButton rdbtnNam = new JRadioButton("Nam");
		buttonGroup.add(rdbtnNam);
		rdbtnNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNam.setBackground(new Color(217, 232, 243));
		rdbtnNam.setBounds(240, 296, 63, 21);
		contentPane.add(rdbtnNam);

		JRadioButton rdbtnNu = new JRadioButton("N\u1EEF");
		buttonGroup.add(rdbtnNu);
		rdbtnNu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNu.setBackground(new Color(217, 232, 243));
		rdbtnNu.setBounds(334, 296, 103, 21);
		contentPane.add(rdbtnNu);

		textField_Name = new JTextField();
		textField_Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Name.setBounds(240, 84, 226, 29);
		contentPane.add(textField_Name);
		textField_Name.setColumns(10);

		textField_CMND = new JTextField();
		textField_CMND.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_CMND.setColumns(10);
		textField_CMND.setBounds(240, 130, 226, 29);
		contentPane.add(textField_CMND);

		JLabel lbReturn = new JLabel("");
		lbReturn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				QL_NV_view nv = new QL_NV_view();
				nv.setVisible(true);
				close();
			}
		});
		lbReturn.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\logout.png")
						.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
		lbReturn.setBounds(915, 373, 45, 42);
		contentPane.add(lbReturn);

		JLabel lblThmKhchHng = new JLabel("THÊM NHÂN VIÊN");
		lblThmKhchHng.setForeground(new Color(4, 51, 134));
		lblThmKhchHng.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblThmKhchHng.setBounds(377, 10, 280, 50);
		contentPane.add(lblThmKhchHng);

		cb_ChucVu = new JComboBox();
		cb_ChucVu.setEditable(true);
		cb_ChucVu.setFocusable(false);
		cb_ChucVu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_ChucVu.setModel(new DefaultComboBoxModel(new String[] {"Chọn...", "Quản lý", "Nhân viên lễ tân"}));
		cb_ChucVu.setBounds(700, 84, 150, 29);
		contentPane.add(cb_ChucVu);

		JLabel lbInput_ChucVu = new JLabel("Chọn chức vụ :");
		lbInput_ChucVu.setFont(new Font("Calibri", Font.PLAIN, 19));
		lbInput_ChucVu.setForeground(new Color(4, 51, 134));
		lbInput_ChucVu.setBounds(514, 89, 134, 22);
		contentPane.add(lbInput_ChucVu);

		cb_dayNS = new JComboBox();
		cb_dayNS.setFocusable(false);
		cb_dayNS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_dayNS.setModel(new DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
				"27", "28", "29", "30", "31" }));
		cb_dayNS.setBounds(240, 188, 50, 24);
		contentPane.add(cb_dayNS);

		cb_monthNS = new JComboBox();
		cb_monthNS.setFocusable(false);
		cb_monthNS.setModel(new DefaultComboBoxModel(
				new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
		cb_monthNS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_monthNS.setBounds(312, 190, 50, 21);
		contentPane.add(cb_monthNS);

		cb_yearNS = new JComboBox();
		cb_yearNS.setFocusable(false);
		for (int i = 2021 ; i>=1932; i--)
		{
			String ns = String.valueOf(i);

			cb_yearNS.addItem(ns);
		
		}
		cb_yearNS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_yearNS.setBounds(377, 190, 89, 21);
		contentPane.add(cb_yearNS);

		JLabel lbInput_NVL = new JLabel("Nhập vào làm : ");
		lbInput_NVL.setFont(new Font("Calibri", Font.PLAIN, 19));
		lbInput_NVL.setBounds(54, 242, 134, 22);
		lbInput_NVL.setForeground(new Color(4, 51, 134));
		contentPane.add(lbInput_NVL);

		cb_dayNVL = new JComboBox();
		cb_dayNVL.setModel(new DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
				"27", "28", "29", "30", "31" }));
		cb_dayNVL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_dayNVL.setFocusable(false);
		cb_dayNVL.setBounds(240, 241, 50, 24);
		contentPane.add(cb_dayNVL);

		cb_monthNVL = new JComboBox();
		cb_monthNVL.setModel(new DefaultComboBoxModel(
				new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
		cb_monthNVL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_monthNVL.setFocusable(false);
		cb_monthNVL.setBounds(312, 243, 50, 21);
		contentPane.add(cb_monthNVL);

		cb_yearNVL = new JComboBox();
		for (int i = 2021 ; i>=1932; i--)
		{
			String ns = String.valueOf(i);

			cb_yearNVL.addItem(ns);
		
		}
		cb_yearNVL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_yearNVL.setFocusable(false);
		cb_yearNVL.setBounds(377, 243, 89, 21);
		contentPane.add(cb_yearNVL);

		JLabel lbInput_NguoiQuanLy = new JLabel("Chọn người quản lí :");
		lbInput_NguoiQuanLy.setForeground(new Color(4, 51, 134));
		lbInput_NguoiQuanLy.setFont(new Font("Calibri", Font.PLAIN, 19));
		lbInput_NguoiQuanLy.setBounds(514, 137, 176, 22);
		contentPane.add(lbInput_NguoiQuanLy);

		cb_NQL = new JComboBox();
		cb_NQL.setModel(new DefaultComboBoxModel(new String[] { "Chọn..." }));

		for (NhanVien nv : listNQL) {
			cb_NQL.addItem(nv.getTenNV());
		}
		cb_NQL.setEditable(true);
		cb_NQL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_NQL.setFocusable(false);
		cb_NQL.setBounds(700, 136, 150, 29);

		contentPane.add(cb_NQL);

		JLabel lbInput_CMND_1 = new JLabel("Nhập E-mail : ");
		lbInput_CMND_1.setFont(new Font("Calibri", Font.PLAIN, 19));
		lbInput_CMND_1.setForeground(new Color(4, 51, 134));
		lbInput_CMND_1.setBounds(514, 190, 134, 22);
		contentPane.add(lbInput_CMND_1);

		textField_email = new JTextField();
		textField_email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_email.setColumns(10);
		textField_email.setBounds(700, 187, 226, 29);
		contentPane.add(textField_email);

		JLabel lbInput_CMND_1_1 = new JLabel("Nhập username : ");
		lbInput_CMND_1_1.setFont(new Font("Calibri", Font.PLAIN, 19));
		lbInput_CMND_1_1.setForeground(new Color(4, 51, 134));
		lbInput_CMND_1_1.setBounds(514, 243, 143, 22);
		contentPane.add(lbInput_CMND_1_1);

		JLabel lbInput_CMND_1_2 = new JLabel("Nhập password : ");
		lbInput_CMND_1_2.setFont(new Font("Calibri", Font.PLAIN, 19));
		lbInput_CMND_1_2.setBounds(514, 295, 143, 22);
		lbInput_CMND_1_2.setForeground(new Color(4, 51, 134));
		contentPane.add(lbInput_CMND_1_2);

		textField_username = new JTextField();
		textField_username.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_username.setColumns(10);
		textField_username.setBounds(700, 236, 226, 29);
		contentPane.add(textField_username);

		textField_password = new JTextField();
		textField_password.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_password.setColumns(10);
		textField_password.setBounds(700, 292, 226, 29);
		contentPane.add(textField_password);

		JPanel panel_add = new JPanel();
		panel_add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String tenNV = textField_Name.getText();
				String cccd = textField_CMND.getText();
				String email = textField_email.getText();
				String username = textField_username.getText();
				String password = textField_password.getText();
				String dateNS = String.valueOf(cb_dayNS.getSelectedItem());
				String monthNS = String.valueOf(cb_monthNS.getSelectedItem());
				String yearNS = String.valueOf(cb_yearNS.getSelectedItem());
				String ngaySinh = yearNS + "-" + monthNS + "-" + dateNS;

				String dateNVL = String.valueOf(cb_dayNVL.getSelectedItem());
				String monthNVL = String.valueOf(cb_monthNVL.getSelectedItem());
				String yearNVL = String.valueOf(cb_yearNVL.getSelectedItem());
				String ngayVL = yearNVL + "-" + monthNVL + "-" + dateNVL;

				String gender = null;
				Enumeration<AbstractButton> place = buttonGroup.getElements();
				while (place.hasMoreElements()) {
					JRadioButton Radio = (JRadioButton) place.nextElement();
					if (Radio.isSelected())
						gender = Radio.getText();
				}
				String ChucVu;
				ChucVu = String.valueOf(cb_ChucVu.getSelectedItem());

				int MaQL = 0;

				String QL = String.valueOf(cb_NQL.getSelectedItem());

				ArrayList<NhanVien> listMaNV = new ArrayList<NhanVien>();
				listMaNV = NV_Modifiers.Find_MaNV(QL);
				if (cb_ChucVu.getSelectedIndex() == 2) {
					for (NhanVien nv : listMaNV) {
						MaQL = nv.getMaNV();
					}
				}
				System.out.println(cb_ChucVu.getSelectedIndex());
				try {
					if (tenNV.trim().length() > 0 && email.trim().length() > 0 && cccd.trim().length() > 0
							&& username.trim().length() > 0 && password.trim().length() > 0
							&& cb_ChucVu.getSelectedIndex() != 0 ) {
						NhanVien nv = new NhanVien(tenNV, email, java.sql.Date.valueOf(ngaySinh), gender, cccd, ChucVu,
								java.sql.Date.valueOf(ngayVL), MaQL, username, password);
						NV_Modifiers.Add(nv);
						//JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công");

					} else
						JOptionPane.showMessageDialog(null, "Thêm thất bại !!!");
					textField_Name.setText(null);
					textField_CMND.setText(null);
					textField_email.setText(null);
					textField_password.setText(null);
					textField_username.setText(null);
					cb_ChucVu.setSelectedIndex(0);
					cb_NQL.setSelectedIndex(0);

				} catch (Exception e1) {

					e1.printStackTrace();
				}
			}
		});
		panel_add.setLayout(null);

		panel_add.setBackground(new Color(217, 232, 243));
		panel_add.setBounds(409, 348, 176, 55);
		contentPane.add(panel_add);

		JLabel lblThm = new JLabel("THÊM");
		lblThm.setForeground(new Color(4, 51, 134));
		lblThm.setFont(new Font("Calibri", Font.BOLD, 25));
		lblThm.setBounds(70, 15, 88, 35);
		panel_add.add(lblThm);

		JLabel lbAdd_icon = new JLabel("");
		lbAdd_icon.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\plus_32px.png")
						.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));

		lbAdd_icon.setBounds(22, 0, 50, 55);
		panel_add.add(lbAdd_icon);
	}
}
