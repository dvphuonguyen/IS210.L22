package design;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Class.DichVu;
import Class.DonVi;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QL_DonVi_view extends JFrame {

	private JPanel contentPane;
	JTable table;
	private JTextField textField_donvi;
	DefaultTableModel tableModel;
	ArrayList<DonVi> ListDonVi = new ArrayList<DonVi>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QL_DonVi_view frame = new QL_DonVi_view();
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

	public void showAll() {
		// xoá dữ liêu table trước khi export dữ liệu mới
		for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
		ListDonVi = DichVu_Modifiers.findAll_DonVi();

		for (DonVi donvi : ListDonVi) {
			tableModel.addRow(new Object[] { donvi.getMaDonVi(), donvi.getTenDonVi() });

		}
	}

	public QL_DonVi_view() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 755, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(217, 232, 243));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblnVDch = new JLabel("\u0110\u01A0N V\u1ECA D\u1ECACH V\u1EE4");
		lblnVDch.setForeground(new Color(4, 51, 134));
		lblnVDch.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblnVDch.setBounds(234, 26, 274, 42);
		contentPane.add(lblnVDch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(86, 176, 207, 135);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "MaDonVi", "TenDonVi" }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		tableModel = (DefaultTableModel) table.getModel();
		showAll();
		scrollPane.setViewportView(table);

		JLabel lblTmnV = new JLabel("Đơn vị hiện có");
		lblTmnV.setForeground(new Color(4, 51, 134));
		lblTmnV.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTmnV.setBounds(100, 90, 196, 42);
		contentPane.add(lblTmnV);

		JLabel lblThmnV = new JLabel("Thêm đơn vị");
		lblThmnV.setForeground(new Color(4, 51, 134));
		lblThmnV.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblThmnV.setBounds(475, 90, 182, 42);
		contentPane.add(lblThmnV);

		JLabel lbInput_Name_1 = new JLabel("Nhập tên đơn vị : ");
		lbInput_Name_1.setForeground(new Color(4, 51, 134));
		lbInput_Name_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbInput_Name_1.setBounds(450, 176, 136, 22);
		contentPane.add(lbInput_Name_1);

		textField_donvi = new JTextField();
		textField_donvi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_donvi.setColumns(10);
		textField_donvi.setBounds(450, 220, 207, 34);
		contentPane.add(textField_donvi);

		JLabel lbReturn = new JLabel("");
		lbReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				QL_DichVu_view dv = new QL_DichVu_view();
				dv.setVisible(true);
				close();
			}
		});
		lbReturn.setBounds(686, 341, 45, 51);
		lbReturn.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\logout.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
		
		contentPane.add(lbReturn);

		JLabel lblTmnV_1 = new JLabel("___________");
		lblTmnV_1.setForeground(new Color(4, 51, 134));
		lblTmnV_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTmnV_1.setBounds(102, 105, 213, 42);
		contentPane.add(lblTmnV_1);

		JLabel lblTmnV_1_1 = new JLabel("___________");
		lblTmnV_1_1.setForeground(new Color(4, 51, 134));
		lblTmnV_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTmnV_1_1.setBounds(463, 105, 213, 42);
		contentPane.add(lblTmnV_1_1);

		JPanel panel_them = new JPanel();
		panel_them.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String tenDonVi = textField_donvi.getText();

				try {
					if (tenDonVi.trim().length() > 0) {
						DonVi dv = new DonVi(tenDonVi);
						DichVu_Modifiers.Add_DonVi(dv);
						JOptionPane.showMessageDialog(null, "Thêm đơn vị thành công");
						textField_donvi.setText(null);
					} else {
						JOptionPane.showMessageDialog(null, "Thêm đơn vị thất bại");
						textField_donvi.setText(null);
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		panel_them.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_them.setLayout(null);
		panel_them.setBackground(new Color(217, 232, 243));
		panel_them.setBounds(475, 275, 172, 48);
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
