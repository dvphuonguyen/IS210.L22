package design;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

public class DoiMatKhau_view extends JFrame {

	private JPanel contentPane;
	private JTextField textField_username;
	private JPanel panel;
	private JLabel lblXcNhn;
	private JLabel iconLogin;
	private JTextField textfield_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoiMatKhau_view frame = new DoiMatKhau_view();
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
	public DoiMatKhau_view() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 455, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(217, 232, 243));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(217, 232, 243));
		separator_2.setBackground(new Color(4, 51, 134));
		separator_2.setBounds(135, 105, 207, 29);
		contentPane.add(separator_2);
		
		textField_username = new JTextField();
		textField_username.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_username.setText(null);
			}
		});
		textField_username.setText("Tên đăng nhập");
		textField_username.setForeground(new Color(4, 51, 134));
		textField_username.setFont(new Font("Calibri", Font.PLAIN, 23));
		textField_username.setColumns(10);
		textField_username.setBorder(null);
		textField_username.setBackground(new Color(217, 232, 243));
		textField_username.setBounds(135, 76, 207, 26);
		contentPane.add(textField_username);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(new Color(217, 232, 243));
		separator_3.setBackground(new Color(4, 51, 134));
		separator_3.setBounds(135, 181, 207, 29);
		contentPane.add(separator_3);
		
		panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NV_Modifiers.UpdatePassword(textfield_password.getText(),textField_username.getText() );
				close();
			}
		});
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.setLayout(null);
		panel.setBackground(new Color(217, 232, 243));
		panel.setBounds(122, 220, 207, 57);
		contentPane.add(panel);
		
		lblXcNhn = new JLabel(" Xác nhận");
		lblXcNhn.setForeground(new Color(4, 51, 134));
		lblXcNhn.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblXcNhn.setBackground(new Color(217, 232, 243));
		lblXcNhn.setBounds(59, 13, 88, 34);
		panel.add(lblXcNhn);
		
		iconLogin = new JLabel("");
		iconLogin.setBounds(24, 10, 40, 34);
		panel.add(iconLogin);
		
		JLabel lbUserName = new JLabel();
		lbUserName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbUserName.setBounds(70, 67, 55, 46);
		lbUserName.setIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\users_40px.png"));
		
		contentPane.add(lbUserName);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\locks_40px.png"));
		
		lblNewLabel_2.setBounds(70, 147, 55, 34);
		contentPane.add(lblNewLabel_2);
		
		textfield_password = new JTextField();
		textfield_password.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textfield_password.setText(null);
			}
		});
		textfield_password.setText("Mật khẩu mới");
		textfield_password.setForeground(new Color(4, 51, 134));
		textfield_password.setFont(new Font("Calibri", Font.PLAIN, 23));
		textfield_password.setColumns(10);
		textfield_password.setBorder(null);
		textfield_password.setBackground(new Color(217, 232, 243));
		textfield_password.setBounds(135, 144, 165, 32);
		contentPane.add(textfield_password);
	}
}
