package design;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import Class.CHITIETTTP;
import Class.ChiTietPDP;
import Class.PhieuDatPhong;
import Class.Phong;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Add_ChiTietPDP extends JFrame {

	private JPanel contentPane;
	ArrayList<Phong> emptyList = new ArrayList<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_ChiTietPDP frame = new Add_ChiTietPDP();
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
	public Add_ChiTietPDP() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 521, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(217, 232, 243));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cb_emptyRoom = new JComboBox();
		cb_emptyRoom.setModel(new DefaultComboBoxModel(new String[] {"Chọn..."}));
	
		cb_emptyRoom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_emptyRoom.setFocusable(false);
		cb_emptyRoom.setBounds(138, 300, 226, 24);
		contentPane.add(cb_emptyRoom);
		
		JLabel lbInput_Name_2_1 = new JLabel("Ngày nhận phòng:");
		lbInput_Name_2_1.setFont(new Font("Calibri", Font.PLAIN, 19));
		lbInput_Name_2_1.setBounds(91, 83, 154, 22);
		lbInput_Name_2_1.setForeground(new Color(4, 51, 134));

		contentPane.add(lbInput_Name_2_1);
		
		JComboBox cb_dayNP = new JComboBox();
		cb_dayNP.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cb_dayNP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_dayNP.setFocusable(false);
		cb_dayNP.setBounds(138, 128, 50, 24);
		contentPane.add(cb_dayNP);
		
		JComboBox cb_monthNP = new JComboBox();
		cb_monthNP.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		cb_monthNP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_monthNP.setFocusable(false);
		cb_monthNP.setBounds(210, 130, 50, 21);
		contentPane.add(cb_monthNP);
		
		JComboBox cb_yearNP = new JComboBox();
		cb_yearNP.setModel(new DefaultComboBoxModel(new String[] {"2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990"}));
		cb_yearNP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_yearNP.setFocusable(false);
		cb_yearNP.setBounds(275, 130, 89, 21);
		contentPane.add(cb_yearNP);
		
		JLabel lbInput_Name_2_1_1 = new JLabel("Ngày trả phòng dự kiến:");
		lbInput_Name_2_1_1.setFont(new Font("Calibri", Font.PLAIN, 19));
		lbInput_Name_2_1_1.setBounds(91, 169, 201, 33);
		lbInput_Name_2_1_1.setForeground(new Color(4, 51, 134));

		contentPane.add(lbInput_Name_2_1_1);
		
		JComboBox cb_dayTP = new JComboBox();
		cb_dayTP.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cb_dayTP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_dayTP.setFocusable(false);
		cb_dayTP.setBounds(138, 212, 50, 24);
		contentPane.add(cb_dayTP);
		
		JComboBox cb_monthTP = new JComboBox();
		cb_monthTP.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		cb_monthTP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_monthTP.setFocusable(false);
		cb_monthTP.setBounds(210, 214, 50, 21);
		contentPane.add(cb_monthTP);
		
		JComboBox cb_yearTP = new JComboBox();
		cb_yearTP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String dateNP = String.valueOf(cb_dayNP.getSelectedItem());
				String monthNP = String.valueOf(cb_monthNP.getSelectedItem());
				String yearNP = String.valueOf(cb_yearNP.getSelectedItem());
				String ngayNP = yearNP + "-" + monthNP + "-" + dateNP;
				
				String dateTP = String.valueOf(cb_dayTP.getSelectedItem());
				String monthTP = String.valueOf(cb_monthTP.getSelectedItem());
				String yearTP = String.valueOf(cb_yearTP.getSelectedItem());
				String ngayTP = yearTP + "-" + monthTP + "-" + dateTP;
				
				
				emptyList = DATvaTHUEphong_Modifiers.FindPhongTrong(java.sql.Date.valueOf(ngayNP), java.sql.Date.valueOf(ngayTP));
				System.out.println(emptyList.size());
				for (Phong a : emptyList)
				{
						cb_emptyRoom.addItem(a.getTenPhong());
				}
			}
		});
		cb_yearTP.setModel(new DefaultComboBoxModel(new String[] {"2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990"}));
		cb_yearTP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_yearTP.setFocusable(false);
		cb_yearTP.setBounds(275, 214, 89, 21);
		contentPane.add(cb_yearTP);
		
		JLabel lbInput_Name_2_1_2 = new JLabel("Chọn phòng:");
		lbInput_Name_2_1_2.setFont(new Font("Calibri", Font.PLAIN, 19));
		lbInput_Name_2_1_2.setBounds(91, 256, 139, 22);
		lbInput_Name_2_1_2.setForeground(new Color(4, 51, 134));

		contentPane.add(lbInput_Name_2_1_2);
		
		
		
		JLabel lblChiTitPhiu = new JLabel("THÊM PHIẾU ĐẶT PHÒNG");
		
		lblChiTitPhiu.setForeground(new Color(4, 51, 134));
		lblChiTitPhiu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblChiTitPhiu.setBounds(55, 21, 391, 42);
		contentPane.add(lblChiTitPhiu);
		
		JPanel panel_add = new JPanel();
		panel_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PhieuDatPhong_view pdp = new PhieuDatPhong_view();
				
				
				
				String tenPhong = (String) cb_emptyRoom.getSelectedItem();
				Phong a = new Phong();
				a = Phong_Modifiers.Find_NAME(tenPhong);
				System.out.println(a.getMaPhong());
				
				String dateNP = String.valueOf(cb_dayNP.getSelectedItem());
				String monthNP = String.valueOf(cb_monthNP.getSelectedItem());
				String yearNP = String.valueOf(cb_yearNP.getSelectedItem());
				String ngayNP = yearNP + "-" + monthNP + "-" + dateNP;
				
				String dateTP = String.valueOf(cb_dayTP.getSelectedItem());
				String monthTP = String.valueOf(cb_monthTP.getSelectedItem());
				String yearTP = String.valueOf(cb_yearTP.getSelectedItem());
				String ngayTP = yearTP + "-" + monthTP + "-" + dateTP;
				
				ChiTietPDP ctpdp = new ChiTietPDP( pdp.PDP, a.getMaPhong(), java.sql.Date.valueOf(ngayNP), java.sql.Date.valueOf(ngayTP));
				CHITIETTTP ctttp = new CHITIETTTP(a.getMaPhong(), 2, java.sql.Date.valueOf(ngayNP), java.sql.Date.valueOf(ngayTP));
				//Exception e2 = null;
				try {
					DATvaTHUEphong_Modifiers.Add_CTPDP(ctpdp);
					System.out.println("Không lỗi");
					//Phong_Modifiers.Add(ctttp);
				}		
				catch (Exception e1)
				{
					System.out.println("Có lỗi");
				}

				
			}
		});
		panel_add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add.setLayout(null);
		panel_add.setBackground(new Color(217, 232, 243));
		panel_add.setBounds(125, 356, 255, 55);
		contentPane.add(panel_add);
		
		JLabel lblLpPhiut = new JLabel("LẬP PHIẾU ĐẶT");
		lblLpPhiut.setForeground(new Color(4, 51, 134));
		lblLpPhiut.setFont(new Font("Calibri", Font.BOLD, 23));
		lblLpPhiut.setBounds(80, 10, 165, 45);
		panel_add.add(lblLpPhiut);
		
		JLabel lbAdd_icon = new JLabel("");
		lbAdd_icon.setBounds(29, 0, 50, 55);
		lbAdd_icon.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\plus_32px.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));
		
		panel_add.add(lbAdd_icon);
	}

}
