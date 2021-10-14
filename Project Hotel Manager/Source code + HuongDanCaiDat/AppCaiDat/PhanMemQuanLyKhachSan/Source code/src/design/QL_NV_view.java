package design;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import java.awt.Cursor;

public class QL_NV_view extends JFrame {

	private JPanel contentPane;
	private JLabel lbFind_icon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QL_NV_view frame = new QL_NV_view();
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
	public QL_NV_view() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 841, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0,24,66));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(72, 67, 280, 45);
		panel.setBackground(new Color(255,195,0));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbQL = new JLabel("S\u1ED0 L\u01AF\u1EE2NG QU\u1EA2N L\u00DD");
		lbQL.setBounds(33, 5, 223, 45);
		panel.add(lbQL);
		lbQL.setForeground(new Color(0,24,66));
		lbQL.setFont(new Font("Calibri", Font.BOLD, 25));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(144,12,62));  
		panel_1.setBounds(72, 111, 280, 80);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbQL_icon = new JLabel("");
		lbQL_icon.setBounds(86, 15, 50, 55);
		panel_1.add(lbQL_icon);
		lbQL_icon.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\manager.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		
		JLabel lb_SLQL = new JLabel("");
		int slql = NV_Modifiers.Find_SLQL().size();
		lb_SLQL.setText(String.valueOf(slql));
		lb_SLQL.setForeground(Color.white);
		lb_SLQL.setFont(new Font("Calibri", Font.BOLD, 30));
		lb_SLQL.setBounds(146, 25, 50, 45);
		panel_1.add(lb_SLQL);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(473, 67, 280, 45); 
		panel_2.setBackground(new Color(173,211,92));  
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lbNV = new JLabel("S\u1ED0 L\u01AF\u1EE2NG NH\u00C2N VI\u00CAN");
		lbNV.setBounds(23, 5, 247, 45);
		panel_2.add(lbNV);
		lbNV.setForeground(new Color(0,24,66));
		lbNV.setFont(new Font("Calibri", Font.BOLD, 25));
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(144, 12, 62));
		panel_1_1.setBounds(473, 111, 280, 80);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lbNV_icon = new JLabel("");
		lbNV_icon.setBounds(101, 15, 58, 55);
		panel_1_1.add(lbNV_icon);
		lbNV_icon.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\employee.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		
		JLabel lb_SLNV = new JLabel("");
		int SLNV = NV_Modifiers.Find_SLNV().size();
		lb_SLNV.setText(String.valueOf(SLNV));
		lb_SLNV.setForeground(Color.WHITE);
		lb_SLNV.setFont(new Font("Calibri", Font.BOLD, 30));
		lb_SLNV.setBounds(161, 25, 50, 45);
		panel_1_1.add(lb_SLNV);
		
		JPanel panel_add = new JPanel();
		panel_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Add_NhanVien a = new Add_NhanVien();
				a.setVisible(true);
				close();
			}
		});
		panel_add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_add.setBounds(72, 265, 280, 55);
		panel_add.setBackground(new Color(0,24,66));
		contentPane.add(panel_add);
		panel_add.setLayout(null);
		
		JLabel lbAdd = new JLabel("TH\u00CAM NH\u00C2N VI\u00CAN");
		lbAdd.setForeground(Color.white);
		lbAdd.setFont(new Font("Calibri", Font.BOLD, 25));
		lbAdd.setBounds(68, 10, 223, 45);
		panel_add.add(lbAdd);
		
		JLabel lbAdd_icon = new JLabel("");
		lbAdd_icon.setBounds(22, 0, 50, 55);
		panel_add.add(lbAdd_icon);
		lbAdd_icon.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\plus.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
		
		JPanel panel_find = new JPanel();
		panel_find.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Find_NV_view a = new Find_NV_view();
				a.setVisible(true);
				close();
				
			}
		});
		panel_find.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_find.setLayout(null);
		panel_find.setBackground(new Color(0,24,66));
		panel_find.setBounds(519, 265, 224, 55);
		contentPane.add(panel_find);
		
		JLabel lbFInd = new JLabel("TRA C\u1EE8U");
		lbFInd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbFInd.setForeground(Color.white);
		lbFInd.setFont(new Font("Calibri", Font.BOLD, 25));
		lbFInd.setBounds(69, 10, 133, 45);
		panel_find.add(lbFInd);
		
		lbFind_icon = new JLabel("");
		lbFind_icon.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\find.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
		
		lbFind_icon.setBounds(22, 0, 50, 55);
		panel_find.add(lbFind_icon);
		
		JLabel lbLogOut = new JLabel("");
		lbLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				QuanLy_view a = new QuanLy_view();
				a.setVisible(true);
				close();
			}
		});
		lbLogOut.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\logout_rounded_left_30px.png").getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT)));
		
		lbLogOut.setBounds(761, 352, 43, 42);
		contentPane.add(lbLogOut);
	}
}
