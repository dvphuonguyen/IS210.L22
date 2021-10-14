package design;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Class.NhanVien;
import Class.QuyDinh;

public class QuyDinh_Modifiers {
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
	public static ArrayList<QuyDinh> findAll(){
		Connection conn = getJDBCConnection();
		Statement statement = null;
		ArrayList<QuyDinh> QDList = new ArrayList<QuyDinh>();
		try {
			statement = conn.createStatement();
			
			//tao truy vấn SELECT đến csdl.
			String sql = "select * from QuyDinh order by maqd asc";
			ResultSet resultset = statement.executeQuery(sql);
			//resultSet là 1 array sẽ hứng toàn bộ dữ liệu lấy được khi chạy lệnh Select
			
			while (resultset.next()) {
				QuyDinh a = new QuyDinh(resultset.getInt("MAQD"),resultset.getString("TENQD"), resultset.getString("MOTA") );
				QDList.add(a);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//đóng kết nối.
		
		finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {	
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		return QDList;
	}
	public static void Add(QuyDinh a) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		
		try {
			//mở kết nối
	
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "Insert into QUYDINH (MAQD,TENQD,MOTA) "
						+ "values (QD_S.nextval,?, ?)";
			statement = conn.prepareStatement(sql);
		
			statement.setString(1, a.getTenQD() );
			statement.setString(2, a.getMoTa());
		
			statement.execute() ;
			JOptionPane.showMessageDialog(null, "Thêm thành công!!");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Thêm thất bại!!");
			e1.printStackTrace();
		}
		
		//đóng kết nối.
		finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {	
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	public static String FindQD (int maQD)
	{
		String quydinh  = "";
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
		
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "select mota from quydinh WHERE maqd = ? ";
				
			statement = conn.prepareStatement(sql);
			statement.setInt(1, maQD);
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				quydinh = resultset.getString("MOTA");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//đóng kết nối.
		finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {	
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		return quydinh;
	}
}
