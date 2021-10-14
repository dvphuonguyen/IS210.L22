package design;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Class.NhanVien;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JSeparator;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txt_username;
	private JPasswordField passwordfield;
	private JLabel lbError;
	ArrayList<NhanVien> ListNV = new ArrayList<NhanVien>();
	static int MaNV;

	/**
	 * Launch the application..
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}

	public Login() {
		setTitle("Qu\u1EA3n l\u00FD kh\u00E1ch s\u1EA1n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(217, 232, 243));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JSeparator separator_2 = new JSeparator();

		separator_2.setBounds(306, 245, 207, 29);
		separator_2.setForeground(new Color(217, 232, 243));
		separator_2.setBackground(new Color(4, 51, 134));
		contentPane.add(separator_2);
		JLabel lbUserName = new JLabel();
		lbUserName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbUserName.setBounds(241, 208, 55, 46);
		lbUserName.setIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\users_40px.png"));
		contentPane.add(lbUserName);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(241, 288, 55, 34);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\locks_40px.png"));
		contentPane.add(lblNewLabel_2);

		txt_username = new JTextField();
		txt_username.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_username.setText(null);
			}
		});
		txt_username.setText("Tên đăng nhập");
		txt_username.setBorder(null);
		txt_username.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				lbError.setVisible(false);
			}
		});
		txt_username.setForeground(new Color(4, 51, 134));
		txt_username.setFont(new Font("Calibri", Font.PLAIN, 23));
		txt_username.setBounds(306, 216, 207, 26);
		txt_username.setBackground(new Color(217, 232, 243));
		txt_username.setColumns(10);
		contentPane.add(txt_username);

		passwordfield = new JPasswordField();
		passwordfield.setEchoChar((char) 0);
		passwordfield.setText("Mật khẩu");
		passwordfield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordfield.setText(null);
				passwordfield.setEchoChar('*');
			}
		});
		passwordfield.setForeground(new Color(4, 51, 134));
		passwordfield.setBackground(new Color(217, 232, 243));
		passwordfield.setBorder(null);
		passwordfield.setFont(new Font("Calibri", Font.PLAIN, 23));
		passwordfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				lbError.setVisible(false);
			}
		});
		passwordfield.setBounds(306, 286, 207, 35);
		contentPane.add(passwordfield);
		// contentPane.add(btnLogin);

		lbError = new JLabel("");
		lbError.setForeground(Color.RED);
		lbError.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbError.setBounds(241, 342, 310, 35);
		contentPane.add(lbError);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(38, 25, 665, 145);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\AnhLogin .png"));

		contentPane.add(lblNewLabel);

		JSeparator separator_3 = new JSeparator();

		separator_3.setBounds(306, 321, 207, 29);
		separator_3.setForeground(new Color(217, 232, 243));
		separator_3.setBackground(new Color(4, 51, 134));
		contentPane.add(separator_3);

		JPanel panel = new JPanel();
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.setBackground(new Color(217, 232, 243));
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int flag = 0;
				String username = txt_username.getText();
				String password = String.valueOf(passwordfield.getPassword());
				ListNV = NV_Modifiers.FindAccount();
				for (NhanVien nv : ListNV) {

					if (nv.getUsername().equals(username) && nv.getPassword().equals(password)) {
						MaNV = nv.getMaNV();

						if (nv.getChucVu().equals("Quản lý")) {

							QuanLy_view ql = new QuanLy_view();
							ql.setVisible(true);
							close();
						} else if (nv.getChucVu().equals("Nhân viên lễ tân")) {
							NhanVien_view nv1 = new NhanVien_view();
							nv1.setVisible(true);
							close();
						}
						break;
					} else if (nv.getUsername().equals(username) == false
							|| nv.getPassword().equals(password) == false) {
						flag++;
//									lbError.setText("Sai tên đăng nhập hoặc mật khẩu");
//									lbError.setVisible(true);
					}
				}
				if (flag == ListNV.size()) {
					lbError.setText("Sai tên đăng nhập hoặc mật khẩu");
					lbError.setVisible(true);
				}
			}
		});
		panel.setBounds(168, 387, 207, 57);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lbLogin = new JLabel("Đăng nhập");
		lbLogin.setForeground(new Color(4, 51, 134));
		lbLogin.setBackground(new Color(217, 232, 243));
		lbLogin.setFont(new Font("Calibri", Font.PLAIN, 22));
		lbLogin.setBounds(73, 13, 98, 34);
		panel.add(lbLogin);

		JLabel iconLogin = new JLabel("");
		iconLogin.setBounds(24, 10, 40, 34);
		panel.add(iconLogin);

		iconLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		iconLogin.setIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\login_40px.png"));
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DoiMatKhau_view a = new DoiMatKhau_view();
				a.setVisible(true);
			}
		});
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(217, 232, 243));
		panel_1.setBounds(410, 387, 207, 57);
		contentPane.add(panel_1);
		
		JLabel lbliMtKhu = new JLabel(" Đổi mật khẩu");
		lbliMtKhu.setForeground(new Color(4, 51, 134));
		lbliMtKhu.setFont(new Font("Calibri", Font.PLAIN, 22));
		lbliMtKhu.setBackground(new Color(217, 232, 243));
		lbliMtKhu.setBounds(69, 13, 138, 34);
		panel_1.add(lbliMtKhu);
		
		JLabel iconLogin_1 = new JLabel("");
		iconLogin_1.setBounds(24, 10, 40, 34);
		iconLogin_1.setIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\help.png"));
		
		panel_1.add(iconLogin_1);

	}
}
