package design;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Class.DichVu;
import Class.DonVi;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.UIManager;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Update_DichVu extends JFrame {

	private JPanel contentPane;
	private JTextField textField_tenDV;
	private JTextField textField_giaDV;
	ArrayList<DonVi> listDonVi = new ArrayList<>();
	DichVu dv;
	private JComboBox cb_DonVi;
	Color xanhnhat = new Color(217, 232, 243);
	Color xanhdam = new Color(4, 51, 134);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_DichVu frame = new Update_DichVu();
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
	public Update_DichVu() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 568, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(xanhnhat);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 554, 362);
		contentPane_1.setBackground(xanhnhat);
		contentPane.add(contentPane_1);
		
		JLabel lblSaDchV = new JLabel("SỬA DỊCH VỤ");
		lblSaDchV.setForeground(xanhdam);
		lblSaDchV.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblSaDchV.setBounds(196, 22, 214, 50);
		contentPane_1.add(lblSaDchV);
		
		JLabel lbInput_tendv = new JLabel("Nhập tên dịch vụ : ");
		lbInput_tendv.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbInput_tendv.setBounds(68, 99, 176, 22);
		lbInput_tendv.setForeground(xanhdam);
		contentPane_1.add(lbInput_tendv);
		
		JLabel lbInput_giadv = new JLabel("Nhập giá dịch vụ : ");
		lbInput_giadv.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbInput_giadv.setBounds(68, 164, 134, 22);
		lbInput_giadv.setForeground(xanhdam);
		contentPane_1.add(lbInput_giadv);
		
		JLabel lbInput_donvi = new JLabel("Chọn đơn vị :");
		lbInput_donvi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbInput_donvi.setBounds(68, 228, 134, 22);
		lbInput_donvi.setForeground(xanhdam);
		contentPane_1.add(lbInput_donvi);
		
		textField_tenDV = new JTextField();
		textField_tenDV.setEditable(false);
		textField_tenDV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_tenDV.setColumns(10);
		textField_tenDV.setBounds(224, 99, 226, 29);
		contentPane_1.add(textField_tenDV);
		
		textField_giaDV = new JTextField();
		textField_giaDV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_giaDV.setColumns(10);
		textField_giaDV.setBounds(224, 161, 226, 29);
		
		contentPane_1.add(textField_giaDV);
		
		cb_DonVi = new JComboBox();
		cb_DonVi.setModel(new DefaultComboBoxModel(new String[] {"chọn..."}));
		cb_DonVi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_DonVi.setFocusable(false);
		cb_DonVi.setBounds(224, 225, 165, 29);
		listDonVi = DichVu_Modifiers.FindDonVi();
		for (DonVi donvi : listDonVi)
		{
			cb_DonVi.addItem(donvi.getTenDonVi());
		}
		contentPane_1.add(cb_DonVi);
		
		JLabel lbReturn = new JLabel("");
		lbReturn.setBounds(489, 303, 45, 42);
		contentPane_1.add(lbReturn);
		
		JPanel panel_update_2_4 = new JPanel();
		panel_update_2_4.addMouseListener(new MouseAdapter() {
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
				
				try {
					if (tenDV.trim().length() > 0 && textField_giaDV.getText().trim().length() > 0)
					{
						DichVu dv = new DichVu(tenDV, giaDV, MaDonVi) ;
						DichVu_Modifiers.Update(dv, tenDV);
						JOptionPane.showMessageDialog(null, "Sửa dịch vụ thành công");
						textField_tenDV.setText(null);
						textField_giaDV.setText(null);
						cb_DonVi.setSelectedIndex(0);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Sửa dịch vụ thất bại");
						textField_tenDV.setText(null);
					}
				
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
		panel_update_2_4.setBounds(196, 278, 161, 60);
		contentPane_1.add(panel_update_2_4);
		
		JLabel lblSa = new JLabel("SỬA");
		lblSa.setForeground(new Color(4, 51, 134));
		lblSa.setFont(new Font("Calibri", Font.BOLD, 22));
		lblSa.setBackground(new Color(217, 232, 243));
		lblSa.setBounds(70, 16, 51, 40);
		panel_update_2_4.add(lblSa);
		
		JLabel lbAdd_icon_4 = new JLabel("");
		lbAdd_icon_4.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\images\\refresh.png").getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)));
		
		lbAdd_icon_4.setBounds(28, 10, 51, 43);
		panel_update_2_4.add(lbAdd_icon_4);
	}
	public void gui() {
		if(dv != null) {
			
			textField_tenDV.setText(dv.getTenDV());;
			textField_giaDV.setText(String.valueOf(dv.getGiaDV()));
		
	}
}
}
