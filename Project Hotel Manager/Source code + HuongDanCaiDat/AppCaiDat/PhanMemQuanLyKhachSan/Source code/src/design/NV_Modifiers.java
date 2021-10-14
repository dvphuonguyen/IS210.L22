package design;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Class.NhanVien;
public class NV_Modifiers {
	private static Statement statement;
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
	public static ArrayList<NhanVien> findAll(){
		Connection conn = getJDBCConnection();
		Statement statement = null;
		ArrayList<NhanVien> NVList = new ArrayList<NhanVien>();
		try {
			statement = conn.createStatement();
			
			//tao truy vấn SELECT đến csdl.
			String sql = "select * from NhanVien order by manv asc";
			ResultSet resultset = statement.executeQuery(sql);
			//resultSet là 1 array sẽ hứng toàn bộ dữ liệu lấy được khi chạy lệnh Select
			
			while (resultset.next()) {
				NhanVien a = new NhanVien (
				resultset.getInt("MANV"),resultset.getString("TENNV"),resultset.getString("EMAILNV"),resultset.getDate("NGAYSINHNV"),
				resultset.getString("GIOITINHNV"),resultset.getString("CCCDNV"),resultset.getString("CHUCVU"),
				resultset.getDate("NGAYVL"),resultset.getInt("MAQL"),resultset.getString("USERNAME"),resultset.getString("PASSWORD"));
				NVList.add(a);
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
		return NVList;
	}
	public static void Add(NhanVien nv) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		
		try {
			//mở kết nối
	
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "insert into NhanVien(manv, tenNV, EMAILNV, NGAYSINHNV, GIOITINHNV, CCCDNV, CHUCVU ,ngayVL, MAQL, USERNAME, PASSWORD) "
						+ "values(NV_S.nextval,?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			statement = conn.prepareStatement(sql);
		
			statement.setString(1, nv.getTenNV() );
			statement.setString(2, nv.getEmail());
			statement.setDate(3, (Date) nv.getNgaySinh() );
			statement.setString(4, nv.getGioiTinh());
			statement.setString(5, nv.getCCCD() );
			statement.setString(6, nv.getChucVu());
			statement.setDate(7, (Date) nv.getNgayVL());
			statement.setInt(8, nv.getMaQL());
			statement.setString(9, nv.getUsername());
			statement.setString(10, nv.getPassword());
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
	public static  ArrayList<NhanVien> FindQL() {
		ArrayList<NhanVien> QLList = new ArrayList<>();
		Connection conn = getJDBCConnection();
		Statement statement = null;
		try {
			//mở kết nối
			statement = conn.createStatement();
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "Select TENNV from NhanVien where ChucVu ='Quản lý'";
			ResultSet resultset = statement.executeQuery(sql);
			while (resultset.next()) {
				NhanVien a = new NhanVien (resultset.getString("tenNV"));
				QLList.add(a);
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
		return QLList;
	}
	public static void Delete(String cccd) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "delete from NhanVien where CCCDNV = ?";
			statement = conn.prepareStatement(sql);
			statement.setString(1, cccd);
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
	public static void Update(NhanVien nv, int manv) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		
		
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "Update NHANVIEN set tenNV = ?,EMAILNV = ? ,NGAYSINHNV = ?, GIOITINHNV = ? , CHUCVU = ? ,ngayVL = ?, USERNAME = ?, PASSWORD = ? ,CCCDNV= ?  where MaNV = ?";
			statement = conn.prepareCall(sql)			;
			
			statement.setString(1, nv.getTenNV() );
			statement.setString(2, nv.getEmail());
			statement.setDate(3, (Date) nv.getNgaySinh() );
			statement.setString(4, nv.getGioiTinh());
			statement.setString(5, nv.getChucVu());
			statement.setDate(6, (Date) nv.getNgayVL());
			statement.setString(7, nv.getUsername());
			statement.setString(8, nv.getPassword());
			statement.setString(9, nv.getCCCD());
			statement.setInt(10, manv);
			
			statement.execute() ;
			JOptionPane.showMessageDialog(null, "Cập nhật thành công!!");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Cập nhật thất bại!!");
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
	public static ArrayList<NhanVien> FindAccount ()
	{
		ArrayList<NhanVien> NVList = new ArrayList<>();
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
		
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "select MANV, USERNAME, PASSWORD, CHUCVU from NHANVIEN ";		
			statement = conn.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				NhanVien a = new NhanVien (resultset.getInt("MANV"), resultset.getString("USERNAME"), 
										   resultset.getString("PASSWORD"),  resultset.getString("CHUCVU"));
				NVList.add(a);
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
		return NVList;
	}
	public static ArrayList<NhanVien> Find_MaNV (String TenNV)
	{
		ArrayList<NhanVien> NVList = new ArrayList<>();
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
		
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "select MANV from NHANVIEN WHERE TENNV = ? ";
				
			statement = conn.prepareStatement(sql);
			statement.setString(1, TenNV);
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				NhanVien a = new NhanVien (
				resultset.getInt("maNV"));
				NVList.add(a);
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
		return NVList;
	}
	public static ArrayList<NhanVien>   FindbyName(String TenNV) {
		ArrayList<NhanVien> NVList = new ArrayList<>();
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "select * from NHANVIEN where UPPER(TENNV) LIKE UPPER(?)";
			statement = conn.prepareStatement(sql);
			statement.setString(1, "%"+TenNV+"%");
		

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				NhanVien a = new NhanVien (
				resultset.getInt("MANV"), resultset.getString("TENNV"),resultset.getString("EMAILNV") ,resultset.getDate("NGAYSINHNV"),
				resultset.getString("GIOITINHNV"),resultset.getString("CCCDNV"),resultset.getString("chucVu"),
				resultset.getDate("ngayVL"),resultset.getInt("maQL"),
				resultset.getString("Username") ,resultset.getString("Password") );
				NVList.add(a);
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
		return NVList;
	}
	public static ArrayList<NhanVien>   FindbyCCCD(String CCCD) {
		ArrayList<NhanVien> NVList = new ArrayList<>();
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "select * from NHANVIEN where CCCDNV = ?";
			statement = conn.prepareStatement(sql);
			statement.setString(1, CCCD);
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				NhanVien a = new NhanVien (
				resultset.getInt("MANV"), resultset.getString("TENNV"),resultset.getString("EMAILNV") ,resultset.getDate("NGAYSINHNV"),
				resultset.getString("GIOITINHNV"),resultset.getString("CCCDNV"),resultset.getString("chucVu"),
				resultset.getDate("ngayVL"),resultset.getInt("maQL"),
				resultset.getString("Username") ,resultset.getString("Password") );
				NVList.add(a);
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
		return NVList;
	}
	public static ArrayList<NhanVien>   Find(String TenNV, String CCCD) {
		ArrayList<NhanVien> NVList = new ArrayList<>();
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "select * from NHANVIEN where  UPPER(TENNV) LIKE UPPER(?) or CCCDNV = ?";
			statement = conn.prepareStatement(sql);
			statement.setString(1, "%"+TenNV+"%");
			statement.setString(2, CCCD);
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				NhanVien a = new NhanVien (
				resultset.getInt("MANV"), resultset.getString("TENNV"),resultset.getString("EMAILNV") ,resultset.getDate("NGAYSINHNV"),
				resultset.getString("GIOITINHNV"),resultset.getString("CCCDNV"),resultset.getString("chucVu"),
				resultset.getDate("ngayVL"),resultset.getInt("maQL"),
				resultset.getString("Username") ,resultset.getString("Password") );
				NVList.add(a);
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
		return NVList;
	}
	public static void UpdatePassword(String password, String username) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		
		
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "Update NHANVIEN set PASSWORD = ? where USERNAME = ?";
			statement = conn.prepareCall(sql)			;
			
			statement.setString(1,password  );
			statement.setString(2, username);
			
			
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
	public static ArrayList<NhanVien> Find_SLNV ()
	{
		ArrayList<NhanVien> NVList = new ArrayList<>();
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
		
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "select * from nhanvien where maql != 0 ";
				
			statement = conn.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				NhanVien a = new NhanVien (
				resultset.getInt("maNV"));
				NVList.add(a);
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
		return NVList;
	}
	public static ArrayList<NhanVien> Find_SLQL ()
	{
		ArrayList<NhanVien> NVList = new ArrayList<>();
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
		
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "select * from nhanvien where maql is null or maql = 0 ";
				
			statement = conn.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				NhanVien a = new NhanVien (
				resultset.getInt("maNV"));
				NVList.add(a);
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
		return NVList;
	}
}
