package design;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Class.QuyDinh;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

public class Add_QuyDinh extends JFrame {

	private JPanel contentPane;
	Color xanhnhat = new Color(217, 232, 243);
	Color xanhdam = new Color(4, 51, 134);
	private JTextField tenQD;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_QuyDinh frame = new Add_QuyDinh();
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
	public Add_QuyDinh() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(xanhnhat);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblThmQuynh = new JLabel("TH\u00CAM QUY \u0110\u1ECANH");
		lblThmQuynh.setForeground(new Color(4, 51, 134));
		lblThmQuynh.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblThmQuynh.setBounds(101, 10, 218, 50);
		contentPane.add(lblThmQuynh);
		
		JLabel lbInput_sdt = new JLabel("T\u00EAn quy \u0111\u1ECBnh : ");
		lbInput_sdt.setForeground(new Color(4, 51, 134));
		lbInput_sdt.setFont(new Font("Calibri", Font.PLAIN, 19));
		lbInput_sdt.setBounds(45, 86, 151, 22);
		contentPane.add(lbInput_sdt);
		
		tenQD = new JTextField();
		tenQD.setFont(new Font("Calibri", Font.PLAIN, 18));
		tenQD.setColumns(10);
		tenQD.setBounds(194, 80, 171, 29);
		contentPane.add(tenQD);
		
		JLabel lbInput_sdt_1 = new JLabel("M\u00F4 t\u1EA3 :");
		lbInput_sdt_1.setForeground(new Color(4, 51, 134));
		lbInput_sdt_1.setFont(new Font("Calibri", Font.PLAIN, 19));
		lbInput_sdt_1.setBounds(45, 130, 151, 22);
		contentPane.add(lbInput_sdt_1);
		
		JTextArea MoTa = new JTextArea();
		MoTa.setFont(new Font("Calibri", Font.PLAIN, 18));
		MoTa.setLineWrap(true);
		MoTa.setBounds(45, 157, 320, 74);
		contentPane.add(MoTa);
		
		JPanel panel_add = new JPanel();
		panel_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				QuyDinh a = new QuyDinh(tenQD.getText(), MoTa.getText());
				QuyDinh_Modifiers.Add(a);
				close();
			}
		});
		panel_add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add.setLayout(null);
		panel_add.setBackground(new Color(217, 232, 243));
		panel_add.setBounds(136, 247, 158, 55);
		contentPane.add(panel_add);
		
		JLabel lblThm = new JLabel("THÊM");
		lblThm.setForeground(new Color(4, 51, 134));
		lblThm.setFont(new Font("Calibri", Font.BOLD, 25));
		lblThm.setBounds(68, 10, 107, 45);
		panel_add.add(lblThm);
		
		JLabel lbAdd_icon = new JLabel("");
		
		lbAdd_icon.setIcon(
				new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\plus_32px.png")
						.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));

		lbAdd_icon.setBounds(26, 0, 32, 55);
		panel_add.add(lbAdd_icon);
	}
}
