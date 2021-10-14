package design;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import Class.DichVu;
import Class.DonVi;
import Class.NhanVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.UIManager;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class Add_DichVu extends JFrame {

	private JPanel contentPane;
	private JTextField textField_tenDV;
	private JTextField textField_giaDV;
	ArrayList<DonVi> listDonVi = new ArrayList<>();
	int flag = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_DichVu frame = new Add_DichVu();
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
	public Add_DichVu() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 558, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(217, 232, 243));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblThmKhchHng = new JLabel("TH\u00CAM D\u1ECACH V\u1EE4");
		lblThmKhchHng.setForeground(new Color(4, 51, 134));
		lblThmKhchHng.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblThmKhchHng.setBounds(167, 20, 214, 50);
		contentPane.add(lblThmKhchHng);
		
		JLabel lbInput_tendv = new JLabel("Nh\u1EADp t\u00EAn d\u1ECBch v\u1EE5 : ");
		lbInput_tendv.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbInput_tendv.setForeground(new Color(4, 51, 134));
		lbInput_tendv.setBounds(39, 97, 176, 22);
		contentPane.add(lbInput_tendv);
		
		JLabel lbInput_giadv = new JLabel("Nh\u1EADp gi\u00E1 d\u1ECBch v\u1EE5 : ");
		lbInput_giadv.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbInput_giadv.setForeground(new Color(4, 51, 134));
		lbInput_giadv.setBounds(39, 162, 134, 22);
		contentPane.add(lbInput_giadv);
		
		JLabel lbInput_donvi = new JLabel("Ch\u1ECDn \u0111\u01A1n v\u1ECB :");
		lbInput_donvi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbInput_donvi.setForeground(new Color(4, 51, 134));
		lbInput_donvi.setBounds(39, 226, 134, 22);
		contentPane.add(lbInput_donvi);
		
		textField_tenDV = new JTextField();
		textField_tenDV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_tenDV.setColumns(10);
		textField_tenDV.setBounds(195, 97, 226, 29);
		contentPane.add(textField_tenDV);
		
		textField_giaDV = new JTextField();
		textField_giaDV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_giaDV.setColumns(10);
		textField_giaDV.setBounds(195, 159, 226, 29);
		contentPane.add(textField_giaDV);
		
		JComboBox cb_DonVi = new JComboBox();
		cb_DonVi.setModel(new DefaultComboBoxModel(new String[] {"Ch\u1ECDn..."}));
		cb_DonVi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_DonVi.setFocusable(false);
		cb_DonVi.setBounds(195, 223, 165, 29);
		listDonVi = DichVu_Modifiers.FindDonVi();
		for (DonVi donvi : listDonVi)
		{
			cb_DonVi.addItem(donvi.getTenDonVi());
		}
		contentPane.add(cb_DonVi);
		
		JLabel lbReturn = new JLabel("");
		lbReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				QL_DichVu_view dv = new QL_DichVu_view();
				dv.setVisible(true);
				close();
			}
		});
		lbReturn.setBounds(489, 303, 45, 42);
		lbReturn.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\logout.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
		
		contentPane.add(lbReturn);
		
		JPanel panel_add = new JPanel();
		panel_add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String tenDV = textField_tenDV.getText();
				int giaDV = Integer.valueOf(textField_giaDV.getText());
				
				String DonVi = String.valueOf(cb_DonVi.getSelectedItem());
				int MaDonVi = 0;
				ArrayList<DonVi> listMaDonVi = new ArrayList<DonVi>();
				listMaDonVi = DichVu_Modifiers.Find_MaDonVi(DonVi);
				for (DonVi donvi : listMaDonVi)
				{
					MaDonVi = donvi.getMaDonVi();
				}
				flag = cb_DonVi.getSelectedIndex();
				try {
					if (tenDV.trim().length() > 0 && textField_giaDV.getText().trim().length() > 0)
					{
						DichVu dv = new DichVu(tenDV, giaDV, MaDonVi) ;
						DichVu_Modifiers.Add(dv);
						
						textField_tenDV.setText(null);
						textField_giaDV.setText(null);
						cb_DonVi.setSelectedIndex(0);
					}
					else
					{
						
						textField_tenDV.setText(null);
					}
				
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		panel_add.setLayout(null);
		panel_add.setBackground(new Color(217, 232, 243));
		panel_add.setBounds(195, 291, 158, 55);
		contentPane.add(panel_add);
		
		JLabel lblThm = new JLabel("THÊM");
		lblThm.setForeground(new Color(4, 51, 134));
		lblThm.setFont(new Font("Calibri", Font.BOLD, 25));
		lblThm.setBounds(68, 10, 107, 45);
		panel_add.add(lblThm);
		
		JLabel lbAdd_icon = new JLabel("");
		lbAdd_icon.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\plus_32px.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));
		
		lbAdd_icon.setBounds(26, 0, 32, 55);
		panel_add.add(lbAdd_icon);
	}
}

