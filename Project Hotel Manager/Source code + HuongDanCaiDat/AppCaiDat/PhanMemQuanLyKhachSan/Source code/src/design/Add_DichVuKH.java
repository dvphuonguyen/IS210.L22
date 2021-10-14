package design;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Class.ChiTietPDV;
import Class.DichVu;
import Class.KhachHang;
import Class.NhanVien;
import Class.PhieuDichVu;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.design.JRDesignQuery;
//import net.sf.jasperreports.engine.design.JasperDesign;
//import net.sf.jasperreports.view.JasperViewer;

public class Add_DichVuKH extends JFrame {

	private JPanel contentPane;
	private JTextField textField_SL;
	ArrayList <DichVu> ListDV2 = new ArrayList<DichVu>();
	int TongTien = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_DichVuKH frame = new Add_DichVuKH();
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
	public static Connection getJDBCConnection() {
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##demo", "123456");
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
	

	public Add_DichVuKH() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 475, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(217, 232, 243));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbInput_Name_2 = new JLabel("Chọn dịch vụ : ");
		lbInput_Name_2.setFont(new Font("Calibri", Font.PLAIN, 19));
		lbInput_Name_2.setBounds(31, 80, 136, 22);		
		lbInput_Name_2.setForeground(new Color(4, 51, 134));

		contentPane.add(lbInput_Name_2);
		
		JComboBox cb_tenDV = new JComboBox();
		cb_tenDV.setModel(new DefaultComboBoxModel(new String[] {"Chọn..."}));
		cb_tenDV.setFocusable(false);
		ListDV2 = DichVu_Modifiers.findAll();
		for (DichVu dv : ListDV2)
		{
			cb_tenDV.addItem(dv.getTenDV());
		}
		cb_tenDV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cb_tenDV.setBounds(207, 75, 215, 31);
		contentPane.add(cb_tenDV);
		
		JLabel lbInput_Name_2_1 = new JLabel("Nhập số lượng : ");
		lbInput_Name_2_1.setFont(new Font("Calibri", Font.PLAIN, 19));
		lbInput_Name_2_1.setBounds(31, 148, 136, 22);
		lbInput_Name_2_1.setForeground(new Color(4, 51, 134));

		contentPane.add(lbInput_Name_2_1);
		
		textField_SL = new JTextField();
		textField_SL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_SL.setColumns(10);
		textField_SL.setBounds(207, 140, 45, 34);
		contentPane.add(textField_SL);
		
		JLabel lbInput_Name_2_1_1 = new JLabel("Ngày sử dụng:");
		lbInput_Name_2_1_1.setFont(new Font("Calibri", Font.PLAIN, 19));
		lbInput_Name_2_1_1.setBounds(31, 218, 139, 22);
		lbInput_Name_2_1_1.setForeground(new Color(4, 51, 134));

		contentPane.add(lbInput_Name_2_1_1);
		
		JComboBox cb_daySD = new JComboBox();
		cb_daySD.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cb_daySD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_daySD.setFocusable(false);
		cb_daySD.setBounds(207, 215, 50, 24);
		contentPane.add(cb_daySD);
		
		JComboBox cb_monthSD = new JComboBox();
		cb_monthSD.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		cb_monthSD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_monthSD.setFocusable(false);
		cb_monthSD.setBounds(276, 217, 50, 21);
		contentPane.add(cb_monthSD);
		
		JComboBox cb_yearSD = new JComboBox();
		cb_yearSD.setModel(new DefaultComboBoxModel(new String[] {"2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990"}));
		cb_yearSD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_yearSD.setFocusable(false);
		cb_yearSD.setBounds(344, 217, 78, 21);
		contentPane.add(cb_yearSD);
		
		JLabel lblThmDchV = new JLabel("THÊM DỊCH VỤ");
		lblThmDchV.setForeground(new Color(4, 51, 134));
		lblThmDchV.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblThmDchV.setBounds(117, 14, 248, 42);
		contentPane.add(lblThmDchV);
		
		JPanel panel_add = new JPanel();
		panel_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String dateSD = String.valueOf(cb_daySD.getSelectedItem());
				String monthSD = String.valueOf(cb_monthSD.getSelectedItem());
				String yearSD = String.valueOf(cb_yearSD.getSelectedItem());
				String ngaySD = yearSD + "-" + monthSD + "-" + dateSD;
				
				int SL = Integer.valueOf(textField_SL.getText());
				int MaDV = 0;
				int donGia = 0;
				String tenDV = String.valueOf(cb_tenDV.getSelectedItem());
				ArrayList<DichVu> Listdv = new ArrayList<>();
				Listdv = DichVu_Modifiers.Find_Exactly(tenDV);
				for(DichVu dv : Listdv) 
				{
					MaDV = dv.getMaDV();
					donGia = dv.getGiaDV();
				}
				int mapdv = 0;
				if (QL_DichVu_view.flagAddPDV == 1)
					mapdv= QL_DichVu_view.mapdv;
				else mapdv = NV_DichVu_view.mapdv;
				
				ArrayList<PhieuDichVu> Listpdv = new ArrayList<>();
				
				Listpdv = DichVu_Modifiers.FindTongTien(mapdv);
				for (PhieuDichVu pdv : Listpdv)
					TongTien = pdv.getTongTien();
				TongTien = TongTien + donGia * SL;
				
				try {
					DichVu_Modifiers.Update(TongTien, mapdv);
					ChiTietPDV ctpdv = new ChiTietPDV(mapdv, MaDV, SL, java.sql.Date.valueOf(ngaySD) );
					DichVu_Modifiers.Add_CTPDV(ctpdv);
					textField_SL.setText(null);
					cb_tenDV.setSelectedIndex(0);
					cb_daySD.setSelectedIndex(0);
					cb_monthSD.setSelectedIndex(0);
					cb_yearSD.setSelectedIndex(0);
					JOptionPane.showMessageDialog(null, "Thêm phiếu dịch vụ thành công");
					
					close();
				}
				catch (Exception e1)
				{
					
					JOptionPane.showMessageDialog(null, "Thêm phiếu dịch vụ thành công");
					e1.printStackTrace();
				}
			}
		});
		panel_add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add.setLayout(null);
		panel_add.setBackground(new Color(217, 232, 243));
		panel_add.setBounds(153, 259, 158, 55);
		contentPane.add(panel_add);
		
		JLabel lblThm = new JLabel("THÊM");
		lblThm.setForeground(new Color(4, 51, 134));
		lblThm.setFont(new Font("Calibri", Font.BOLD, 25));
		lblThm.setBounds(75, 10, 68, 45);
		panel_add.add(lblThm);
		
		JLabel lbAdd_icon = new JLabel("");
		lbAdd_icon.setBounds(29, 0, 50, 55);
		lbAdd_icon.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\plus_32px.png").getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));
		
		panel_add.add(lbAdd_icon);
	}
}
