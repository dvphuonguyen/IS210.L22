package design;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Class.KhachHang;
import Class.QuyDinh;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class NV_QuyDinh_view extends JFrame {

	private JPanel contentPane;
	ArrayList<QuyDinh> QDList = new ArrayList<QuyDinh>();
	DefaultTableModel tableModel;

	Color xanhnhat = new Color(217, 232, 243);
	Color xanhdam = new Color(4, 51, 134);
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NV_QuyDinh_view frame = new NV_QuyDinh_view();
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
	public void showAll() {
		// xoá dữ liêu table trước khi export dữ liệu mới
		 for( int i = tableModel.getRowCount() - 1; i >= 0; i-- ) {
			 tableModel.removeRow(i);
		    }
		 QDList = QuyDinh_Modifiers.findAll();
		
		for (QuyDinh a : QDList)
		{
			tableModel.addRow(new Object[] {
			a.getMaQD(), a.getTenQD()	
			});
		}
	}
	public void close()
	{
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
	public NV_QuyDinh_view() {
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 315);
		contentPane = new JPanel();
		contentPane.setBackground(xanhnhat);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQuynh = new JLabel("QUẢN LÝ QUY ĐỊNH");
		lblQuynh.setForeground(new Color(4, 51, 134));
		lblQuynh.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblQuynh.setBounds(193, 10, 260, 50);
		contentPane.add(lblQuynh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 71, 268, 102);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MAQD", "TENQD"
			}
		));
		tableModel = (DefaultTableModel) table.getModel();
		showAll();
		scrollPane.setViewportView(table);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Calibri", Font.PLAIN, 18));
		textArea.setLineWrap(true);
		textArea.setBounds(316, 107, 297, 66);
		contentPane.add(textArea);
		
		JPanel panel_update_2 = new JPanel();
		panel_update_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectedIndex = table.getSelectedRow();
				
				if (SelectedIndex > -1) {
					textArea.setText(QuyDinh_Modifiers.FindQD((int) table.getValueAt(SelectedIndex, 0)));
				}
			}
		});
		panel_update_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_update_2.setLayout(null);
		panel_update_2.setBackground(new Color(217, 232, 243));
		panel_update_2.setBounds(193, 193, 224, 60);
		contentPane.add(panel_update_2);
		
		JLabel lblThmQuynh = new JLabel("Xem chi tiết");
		lblThmQuynh.setForeground(new Color(4, 51, 134));
		lblThmQuynh.setFont(new Font("Calibri", Font.BOLD, 22));
		lblThmQuynh.setBackground(new Color(217, 232, 243));
		lblThmQuynh.setBounds(91, 19, 123, 37);
		panel_update_2.add(lblThmQuynh);
		
		JLabel lbAdd_icon = new JLabel("");
		lbAdd_icon.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\search.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
		
		lbAdd_icon.setBounds(35, 13, 51, 43);
		panel_update_2.add(lbAdd_icon);
		
		JLabel lbReturn = new JLabel("");
		lbReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NhanVien_view a = new NhanVien_view();
				a.setVisible(true);
				close();
			}
		});
		lbReturn.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\QuanLyKhachSan\\icon\\logout.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
		
		lbReturn.setBounds(581, 230, 45, 51);
		contentPane.add(lbReturn);
		
		JLabel lblMT = new JLabel("Mô tả : ");
		lblMT.setForeground(new Color(4, 51, 134));
		lblMT.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblMT.setBounds(316, 71, 97, 36);
		contentPane.add(lblMT);
	}
}
