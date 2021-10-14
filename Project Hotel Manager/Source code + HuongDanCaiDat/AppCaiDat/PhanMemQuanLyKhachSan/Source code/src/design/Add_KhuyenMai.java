package design;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Class.KhachHang;
import Class.KhuyenMai;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Cursor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

public class Add_KhuyenMai extends JFrame {

	private JPanel contentPane;
	private JTextField textField_tenKM;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_KhuyenMai frame = new Add_KhuyenMai();
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
	public Add_KhuyenMai() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 581, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(217, 232, 243));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblThmKhuynMi = new JLabel("TH\u00CAM KHUY\u1EBEN M\u00C3I");
		lblThmKhuynMi.setForeground(new Color(4, 51, 134));
		lblThmKhuynMi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblThmKhuynMi.setBounds(164, 10, 280, 50);
		contentPane.add(lblThmKhuynMi);
		
		JLabel lbtenKM = new JLabel("Nh\u1EADp t\u00EAn khuy\u1EBFn m\u00E3i : ");
		lbtenKM.setForeground(new Color(4, 51, 134));
		lbtenKM.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbtenKM.setBounds(32, 88, 176, 22);
		contentPane.add(lbtenKM);
		
		textField_tenKM = new JTextField();
		textField_tenKM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_tenKM.setColumns(10);
		textField_tenKM.setBounds(218, 85, 339, 29);
		contentPane.add(textField_tenKM);
		
		JLabel lbngayBD = new JLabel("Ng\u00E0y b\u1EAFt \u0111\u1EA7u:");
		lbngayBD.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbngayBD.setForeground(new Color(4, 51, 134));
		lbngayBD.setBounds(32, 146, 134, 22);
		contentPane.add(lbngayBD);
		
		JComboBox cb_dayBD = new JComboBox();
		cb_dayBD.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cb_dayBD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_dayBD.setFocusable(false);
		cb_dayBD.setBounds(218, 145, 50, 24);
		contentPane.add(cb_dayBD);
		
		JComboBox cb_monthBD = new JComboBox();
		cb_monthBD.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		cb_monthBD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_monthBD.setFocusable(false);
		cb_monthBD.setBounds(290, 147, 50, 21);
		contentPane.add(cb_monthBD);
		
		JComboBox cb_yearBD = new JComboBox();
		cb_yearBD.setModel(new DefaultComboBoxModel(new String[] {"2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990"}));
		cb_yearBD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_yearBD.setFocusable(false);
		cb_yearBD.setBounds(355, 147, 89, 21);
		contentPane.add(cb_yearBD);
		
		JLabel lbngayKT = new JLabel("Ng\u00E0y k\u1EBFt th\u00FAc");
		lbngayKT.setForeground(new Color(4, 51, 134));
		lbngayKT.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbngayKT.setBounds(32, 206, 134, 22);
		contentPane.add(lbngayKT);
		
		JComboBox cb_dayKT = new JComboBox();
		cb_dayKT.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cb_dayKT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_dayKT.setFocusable(false);
		cb_dayKT.setBounds(218, 205, 50, 24);
		contentPane.add(cb_dayKT);
		
		JComboBox cb_monthKT = new JComboBox();
		cb_monthKT.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		cb_monthKT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_monthKT.setFocusable(false);
		cb_monthKT.setBounds(290, 207, 50, 21);
		contentPane.add(cb_monthKT);
		
		JComboBox cb_yearKT = new JComboBox();
		cb_yearKT.setModel(new DefaultComboBoxModel(new String[] {"2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990"}));
		cb_yearKT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_yearKT.setFocusable(false);
		cb_yearKT.setBounds(355, 207, 89, 21);
		contentPane.add(cb_yearKT);
		
		JPanel panel_them = new JPanel();
		panel_them.setBackground(new Color(217, 232, 243));

		panel_them.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String dateBD = String.valueOf(cb_dayBD.getSelectedItem());
				String monthBD = String.valueOf(cb_monthBD.getSelectedItem());
				String yearBD = String.valueOf(cb_yearBD.getSelectedItem());
				String ngayBD = yearBD + "-" + monthBD + "-" + dateBD;
				

				String dateKT = String.valueOf(cb_dayKT.getSelectedItem());
				String monthKT = String.valueOf(cb_monthKT.getSelectedItem());
				String yearKT = String.valueOf(cb_yearKT.getSelectedItem());
				String ngayKT = yearKT + "-" + monthKT + "-" + dateKT;
				try {
					KhuyenMai km = new KhuyenMai(textField_tenKM.getText() ,java.sql.Date.valueOf(ngayBD), java.sql.Date.valueOf(ngayKT));
					JOptionPane.showMessageDialog(null, "Thêm khuyến mãi thành công");
					KhuyenMai_Modifiers.Add(km);
					QL_KhuyenMai_view a = new QL_KhuyenMai_view();
					a.setVisible(true);
					close();
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		panel_them.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_them.setLayout(null);
		panel_them.setBounds(198, 263, 172, 48);
		contentPane.add(panel_them);
		
		JLabel lblThm = new JLabel("THÊM");
		lblThm.setForeground(new Color(4, 51, 134));
		lblThm.setFont(new Font("Calibri", Font.PLAIN, 23));
		lblThm.setBounds(61, 10, 101, 33);
		panel_them.add(lblThm);
		
		JLabel lbthemIcon = new JLabel("");
		lbthemIcon.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\plus_32px.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));

		lbthemIcon.setBounds(19, 0, 32, 43);
		panel_them.add(lbthemIcon);
	}
}
