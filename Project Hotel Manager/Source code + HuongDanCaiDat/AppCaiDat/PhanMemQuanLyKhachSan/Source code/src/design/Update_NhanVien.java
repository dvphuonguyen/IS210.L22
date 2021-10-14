package design;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
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

import Class.NhanVien;

public class Update_NhanVien extends JFrame {

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
	NhanVien nv;
	private JTextField textField_email;
	private JTextField textField_username;
	private JTextField textField_password;
	Color xanhnhat = new Color(217, 232, 243);
	Color xanhdam = new Color(4, 51, 134);
	private JRadioButton rdbtnNam;
	private JRadioButton rdbtnNu;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_NhanVien frame = new Update_NhanVien();
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
	public Update_NhanVien() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 646, 675);
		contentPane = new JPanel();
		contentPane.setBackground(xanhnhat);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbInput_sdt = new JLabel("Nhập tên nhân viên : ");
		lbInput_sdt.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbInput_sdt.setForeground(xanhdam);
		lbInput_sdt.setBounds(87, 70, 176, 22);
		contentPane.add(lbInput_sdt);
		
		JLabel lbInput_CMND = new JLabel("Nh\u1EADp CMND : ");
		lbInput_CMND.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbInput_CMND.setForeground(xanhdam);
		lbInput_CMND.setBounds(87, 116, 134, 22);
		contentPane.add(lbInput_CMND);
		
		JLabel lbInput_NgaySinh = new JLabel("Nh\u1EADp ng\u00E0y sinh : ");
		lbInput_NgaySinh.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbInput_NgaySinh.setBounds(87, 162, 134, 22);
		lbInput_NgaySinh.setForeground(xanhdam);
		contentPane.add(lbInput_NgaySinh);
		
		listNQL = NV_Modifiers.FindQL();
		
		JLabel lbInput_gender = new JLabel("Gi\u1EDBi t\u00EDnh : ");
		lbInput_gender.setForeground(xanhdam);
		lbInput_gender.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbInput_gender.setBounds(87, 254, 79, 22);
		contentPane.add(lbInput_gender);
		
		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setEnabled(false);
		buttonGroup.add(rdbtnNam);
		rdbtnNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNam.setBackground(xanhnhat);
		rdbtnNam.setBounds(273, 257, 63, 21);
		contentPane.add(rdbtnNam);
		
		rdbtnNu = new JRadioButton("N\u1EEF");
		rdbtnNu.setEnabled(false);
		buttonGroup.add(rdbtnNu);
		rdbtnNu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNu.setBackground(xanhnhat);
		rdbtnNu.setBounds(367, 257, 103, 21);
		contentPane.add(rdbtnNu);
		
		textField_Name = new JTextField();
		textField_Name.setEditable(false);
		textField_Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Name.setBounds(273, 67, 226, 29);
		contentPane.add(textField_Name);
		textField_Name.setColumns(10);
		
		textField_CMND = new JTextField();
		textField_CMND.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_CMND.setColumns(10);
		textField_CMND.setBounds(273, 109, 226, 29);
		contentPane.add(textField_CMND);
		
		JLabel lbReturn = new JLabel("");
		lbReturn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Find_NV_view nv = new Find_NV_view();
				nv.setVisible(true);
				close();
			}
		});
		lbReturn.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\logout.png")
						.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
lbReturn.setBounds(577, 586, 45, 42);
		contentPane.add(lbReturn);
		
		JLabel lblThmKhchHng = new JLabel("SỬA NHÂN VIÊN");
		lblThmKhchHng.setForeground(xanhdam);
		lblThmKhchHng.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblThmKhchHng.setBounds(208, 10, 280, 50);
		contentPane.add(lblThmKhchHng);
		
		cb_ChucVu = new JComboBox();
		cb_ChucVu.setEditable(true);
		cb_ChucVu.setFocusable(false);
		cb_ChucVu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_ChucVu.setModel(new DefaultComboBoxModel(new String[] {"Chọn...", "Quản lý", "Nhân viên lễ tân"}));
		cb_ChucVu.setBounds(273, 297, 150, 29);
		contentPane.add(cb_ChucVu);
		
		JLabel lbInput_ChucVu = new JLabel("Chọn chức vụ :");
		lbInput_ChucVu.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbInput_ChucVu.setForeground(xanhdam);
		lbInput_ChucVu.setBounds(87, 302, 134, 22);
		contentPane.add(lbInput_ChucVu);
		
		cb_dayNS = new JComboBox();
		cb_dayNS.setEnabled(false);
		cb_dayNS.setFocusable(false);
		cb_dayNS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_dayNS.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cb_dayNS.setBounds(273, 161, 50, 24);
		contentPane.add(cb_dayNS);
		
		cb_monthNS = new JComboBox();
		cb_monthNS.setEnabled(false);
		cb_monthNS.setFocusable(false);
		cb_monthNS.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		cb_monthNS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_monthNS.setBounds(345, 163, 50, 21);
		contentPane.add(cb_monthNS);
		
		cb_yearNS = new JComboBox();
		cb_yearNS.setEnabled(false);
		cb_yearNS.setFocusable(false);
		for (int i = 2021 ; i>=1932; i--)
		{
			String ns = String.valueOf(i);

			cb_yearNS.addItem(ns);
		
		}
		cb_yearNS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_yearNS.setBounds(410, 163, 89, 21);
		contentPane.add(cb_yearNS);
		
		JLabel lbInput_NVL = new JLabel("Nhập vào làm : ");
		lbInput_NVL.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbInput_NVL.setForeground(xanhdam);
		lbInput_NVL.setBounds(87, 209, 134, 22);
		contentPane.add(lbInput_NVL);
		
		cb_dayNVL = new JComboBox();
		cb_dayNVL.setEnabled(false);
		cb_dayNVL.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cb_dayNVL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_dayNVL.setFocusable(false);
		cb_dayNVL.setBounds(273, 208, 50, 24);
		contentPane.add(cb_dayNVL);
		
		cb_monthNVL = new JComboBox();
		cb_monthNVL.setEnabled(false);
		cb_monthNVL.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		cb_monthNVL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_monthNVL.setFocusable(false);
		cb_monthNVL.setBounds(345, 210, 50, 21);
		contentPane.add(cb_monthNVL);
		
		cb_yearNVL = new JComboBox();
		cb_yearNVL.setEnabled(false);
		for (int i = 2021 ; i>=1932; i--)
		{
			String ns = String.valueOf(i);

			cb_yearNVL.addItem(ns);
		
		}
		cb_yearNVL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_yearNVL.setFocusable(false);
		cb_yearNVL.setBounds(410, 210, 89, 21);
		contentPane.add(cb_yearNVL);
		
		JLabel lbInput_NguoiQuanLy = new JLabel("Chọn người quản lí :");
		lbInput_NguoiQuanLy.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbInput_NguoiQuanLy.setForeground(xanhdam);
		lbInput_NguoiQuanLy.setBounds(87, 350, 150, 22);
		contentPane.add(lbInput_NguoiQuanLy);
		
		cb_NQL = new JComboBox();
		
		for (NhanVien nv : listNQL)
		{
			cb_NQL.addItem(nv.getTenNV());
		}
		cb_NQL.setEditable(true);
		cb_NQL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_NQL.setFocusable(false);
		cb_NQL.setBounds(273, 349, 150, 29);
		
		contentPane.add(cb_NQL);
		
		JLabel lbInput_CMND_1 = new JLabel("Nhập E-mail : ");
		lbInput_CMND_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbInput_CMND_1.setForeground(xanhdam);
		lbInput_CMND_1.setBounds(87, 405, 134, 22);
		contentPane.add(lbInput_CMND_1);
		
		textField_email = new JTextField();
		textField_email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_email.setColumns(10);
		textField_email.setBounds(273, 402, 226, 29);
		contentPane.add(textField_email);
		
		JLabel lbInput_CMND_1_1 = new JLabel("Nhập username : ");
		lbInput_CMND_1_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbInput_CMND_1_1.setForeground(xanhdam);
		lbInput_CMND_1_1.setBounds(87, 458, 134, 22);
		contentPane.add(lbInput_CMND_1_1);
		
		textField_username = new JTextField();
		textField_username.setEditable(false);
		textField_username.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_username.setColumns(10);
		textField_username.setBounds(273, 455, 226, 29);
		contentPane.add(textField_username);
		
		JLabel lbInput_CMND_1_2 = new JLabel("Nhập password : ");
		lbInput_CMND_1_2.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbInput_CMND_1_2.setForeground(xanhdam);
		lbInput_CMND_1_2.setBounds(87, 510, 134, 22);
		contentPane.add(lbInput_CMND_1_2);
		
		textField_password = new JTextField();
		textField_password.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_password.setColumns(10);
		textField_password.setBounds(273, 507, 226, 29);
		contentPane.add(textField_password);
		
		JPanel panel_update_2_4 = new JPanel();
		panel_update_2_4.addMouseListener(new MouseAdapter() {
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
				while (place.hasMoreElements())
				{
					JRadioButton Radio = (JRadioButton)place.nextElement();
					if(Radio.isSelected())
						gender = Radio.getText();
				}
				String ChucVu;
				ChucVu = String.valueOf(cb_ChucVu.getSelectedItem());
				
				int MaQL = 0;
				for (NhanVien nv : listNQL)
				{
					if  (cb_ChucVu.getSelectedIndex()==2 && String.valueOf(cb_NQL.getSelectedItem()) == nv.getTenNV() )
					{
						MaQL = nv.getMaNV();
					}
				}
				
				try {
					NhanVien nv = new NhanVien(tenNV,email ,java.sql.Date.valueOf(ngaySinh), gender, cccd, ChucVu, java.sql.Date.valueOf(ngayVL) ,MaQL, username, password);
					NV_Modifiers.Update(nv, Find_NV_view.ma);
					
					close();
					
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
					
				}
				
			}
		});
		panel_update_2_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_update_2_4.setLayout(null);
		panel_update_2_4.setBackground(new Color(217, 232, 243));
		panel_update_2_4.setBounds(244, 556, 161, 60);
		contentPane.add(panel_update_2_4);
		
		JLabel lblSa = new JLabel("SỬA");
		lblSa.setForeground(new Color(4, 51, 134));
		lblSa.setFont(new Font("Calibri", Font.BOLD, 22));
		lblSa.setBackground(new Color(217, 232, 243));
		lblSa.setBounds(70, 16, 51, 40);
		panel_update_2_4.add(lblSa);
		
		JLabel lbAdd_icon_4 = new JLabel("");
		lbAdd_icon_4.setBounds(28, 10, 51, 43);
		lbAdd_icon_4.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\images\\refresh.png").getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)));
		
		panel_update_2_4.add(lbAdd_icon_4);
	}
		public void gui() {
			if(nv != null) {
			textField_Name.setText(nv.getTenNV());
			textField_CMND.setText(nv.getCCCD());
			textField_email.setText(nv.getEmail());
			textField_username.setText(nv.getUsername());
			textField_password.setText(nv.getPassword());
			
			if (nv.getGioiTinh().contains("Nam") == true)
				rdbtnNam.setSelected(true);
			else if (nv.getGioiTinh().contains("Nữ") == true)
			rdbtnNu.setSelected(true);
			String dateNS = String.valueOf(nv.getNgaySinh());
			System.out.println(dateNS);
			
			cb_yearNS.setSelectedItem(dateNS.substring(0, 4)) ;
			cb_monthNS.setSelectedItem(dateNS.substring(5, 7));
			cb_dayNS.setSelectedItem(dateNS.substring(8, 10));
			
			String dateNVL = String.valueOf(nv.getNgayVL());
			
			cb_yearNVL.setSelectedItem(dateNVL.substring(0, 4)) ;
			cb_monthNVL.setSelectedItem(dateNVL.substring(5, 7));
			cb_dayNVL.setSelectedItem(dateNVL.substring(8, 10));
		}
	}
}
