package design;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Class.ChiTietKM;
import Class.KhachHang;
import Class.KhuyenMai;
import Class.NhanVien;

public class KhuyenMai_Modifiers {
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
	public static ArrayList<ChiTietKM> findAll_CTKM(){
		Connection conn = getJDBCConnection();
		Statement statement = null;
		ArrayList<ChiTietKM> ctkm = new ArrayList<ChiTietKM>();
		try {
			statement = conn.createStatement();
			
			//tao truy vấn SELECT đến csdl.
			String sql = "select * from CHITIETKM";
			ResultSet resultset = statement.executeQuery(sql);
			//resultSet là 1 array sẽ hứng toàn bộ dữ liệu lấy được khi chạy lệnh Select
			
			while (resultset.next()) {
				ChiTietKM a = new ChiTietKM (
				resultset.getInt("MALKH"),resultset.getInt("MAKM"),resultset.getInt("PHANTRAMKM"));
				ctkm.add(a);
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
		return ctkm;
	}
	public static ArrayList<KhuyenMai> findAll(){
		Connection conn = getJDBCConnection();
		Statement statement = null;
		ArrayList<KhuyenMai> km = new ArrayList<KhuyenMai>();
		try {
			statement = conn.createStatement();
			
			//tao truy vấn SELECT đến csdl.
			String sql = "select * from KhuyenMai";
			ResultSet resultset = statement.executeQuery(sql);
			//resultSet là 1 array sẽ hứng toàn bộ dữ liệu lấy được khi chạy lệnh Select
			
			while (resultset.next()) {
				KhuyenMai a = new KhuyenMai (
				resultset.getInt("MAKM"),resultset.getString("TENKM"),resultset.getDate("TUNGAY"), resultset.getDate("DENNGAY"));
				km.add(a);
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
		return km;
	}
	public static void Add(KhuyenMai km) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		
		try {
			//mở kết nối
	
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "insert into KhuyenMai(TENKM, TUNGAY, DENNGAY)"
						+ "values(?, ?, ?)";
			statement = conn.prepareStatement(sql);
		
			statement.setString(1, km.getTenKM());
			statement.setDate(2, (Date) km.getTuNgay());
			statement.setDate(3, (Date) km.getDenNgay());
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
	public static void Add_CTKM(ChiTietKM ctkm) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		
		try {
			//mở kết nối
	
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "insert into CHITIETKM(MALKH, MAKM, PHANTRAMKM)"
						+ "values(?, ?, ?)";
			statement = conn.prepareStatement(sql);
		
			statement.setInt(1, ctkm.getMaLKH());
			statement.setInt(2, ctkm.getMaKM());
			statement.setInt(3, ctkm.getPhanTram());
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
	public static void Delete(int  maKM) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "delete from KhuyenMai where maKM = ?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, maKM);
			statement.execute() ;

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
	}
	public static int Find_MaKM (String TenKM)
	{
		int maKM = 0;
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
		
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "select MAKM from KHUYENMAI WHERE TenKM = ? ";
				
			statement = conn.prepareStatement(sql);
			statement.setString(1, TenKM);
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) 
				maKM = resultset.getInt("MAKM");
			
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
		return maKM;
	}
	public static float Find_giamGia (int maKM, int maLKH)
	{
		float giamGia = 0;
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
		
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "select PHANTRAMKM from CHITIETKM WHERE MAKM = ? and MaLKH = ?";
				
			statement = conn.prepareStatement(sql);
			statement.setInt(1, maKM);
			statement.setInt(2, maLKH);
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) 
				giamGia = resultset.getFloat("PHANTRAMKM");
			
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
		return giamGia;
	}
	public static ArrayList<KhuyenMai> Find_ngay (String TenKM)
	{
		ArrayList<KhuyenMai> list = new ArrayList<>();
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
		
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "select * from KHUYENMAI WHERE TenKM = ? ";
				
			statement = conn.prepareStatement(sql);
			statement.setString(1, TenKM);
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				KhuyenMai a = new KhuyenMai (
						resultset.getInt("MAKM"),resultset.getString("TENKM"),resultset.getDate("TUNGAY"), resultset.getDate("DENNGAY"));
						list.add(a);
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
		return list;
	}
}

