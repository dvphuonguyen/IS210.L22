package design;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import Class.KhachHang;

import java.sql.*;
public class KH_Modifiers {
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
	
	
	public static ArrayList<KhachHang> findAll(){
		Connection conn = getJDBCConnection();
		Statement statement = null;
		ArrayList<KhachHang> kh = new ArrayList<KhachHang>();
		try {
			statement = conn.createStatement();
			
			//tao truy vấn SELECT đến csdl.
			String sql = "select * from KhachHang ORDER BY MAKH ASC";
			ResultSet resultset = statement.executeQuery(sql);
			//resultSet là 1 array sẽ hứng toàn bộ dữ liệu lấy được khi chạy lệnh Select
			
			while (resultset.next()) {
				KhachHang a = new KhachHang (
				resultset.getInt("maKH"),resultset.getString("tenKH"),resultset.getString("cccdKH"),
				resultset.getString("sdtKH"),resultset.getString("gioiTinhKH"),resultset.getDate("ngaySinhKH"),resultset.getString("quocTich"),
				resultset.getInt("DoanhSo"), resultset.getInt("maLKH") );
				kh.add(a);
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
		return kh;
	}
	
	public static void Add(KhachHang kh) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		
		try {
			//mở kết nối
	
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "insert into KhachHang(maKH, tenKH, cccdKH, sdtKH ,gioiTinhKH, ngaySinhKH, quocTich, DoanhSo, MALKH)"
						+ "values(KH_S.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
			statement = conn.prepareStatement(sql);
		
			statement.setString(1, kh.getTenKH());
			statement.setString(2, kh.getCccdKH());
			statement.setString(3, kh.getSdtKH());
			statement.setString(4, kh.getGioiTinhKH());
			statement.setDate(5, (Date) kh.getNgaySinh());
			statement.setString(6, kh.getQuocTich());
			statement.setInt(7, kh.getDoanhSo());
			statement.setInt(8, kh.getMaLoaiKH());
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
	
	public static void Delete(int maKH) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "delete from khachhang where maKH = ?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, maKH);
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
	
	public static void Update(KhachHang kh, int makh) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		
		
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "Update KhachHang set tenKH = ? ,sdtKH = ? ,gioiTinhKH = ?, ngaySinhKH = ?, quocTich = ? , cccdKH = ? where makh = ?";
			statement = conn.prepareCall(sql)			;
			statement.setString(1, kh.getTenKH());
			statement.setString(2, kh.getSdtKH());
			statement.setString(3, kh.getGioiTinhKH());
			statement.setDate(4,(Date) kh.getNgaySinh());
			statement.setString(5, kh.getQuocTich());
			statement.setString(6, kh.getCccdKH());
			statement.setInt(7, makh);
			
			
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
	
	public static ArrayList<KhachHang>   FindbyName(String TenKH) {
		ArrayList<KhachHang> khList = new ArrayList<>();
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			
			String sql = "select * from khachhang where UPPER(tenKH) LIKE UPPER(?) ORDER BY MAKH ASC";
			statement = conn.prepareStatement(sql);
			statement.setString(1, "%"+TenKH+"%");
			ResultSet resultset = statement.executeQuery();

			 while (resultset.next()) {                
	                KhachHang kh = new KhachHang( 
	                		resultset.getInt("maKH"),resultset.getString("tenKH"),resultset.getString("cccdKH"),
	        				resultset.getString("sdtKH"),
	        				resultset.getString("gioiTinhKH"),resultset.getDate("ngaySinhKH"),resultset.getString("quocTich"),
	        				resultset.getInt("DoanhSo"), resultset.getInt("maLKH") );
	                khList.add(kh);
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
		return khList;
	}
	public static String  Find_quocTich(int maKH) {
		String quocTich = "";
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			
			String sql = "select quocTich from khachhang where maKH = ?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, maKH);
			ResultSet resultset = statement.executeQuery();

			 while (resultset.next())                 
	                quocTich = resultset.getString("quocTich");
	            
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
		return quocTich;
	}
	public static ArrayList<KhachHang>   FindbyCCCD(String cccdKH) {
		ArrayList<KhachHang> khList = new ArrayList<>();
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			
			String sql = "select * from khachhang where cccdKH = ? ";
			statement = conn.prepareStatement(sql);
			statement.setString(1, cccdKH);
			
			ResultSet resultset = statement.executeQuery();

			 while (resultset.next()) {                
	                KhachHang kh = new KhachHang( 
	                		resultset.getInt("maKH"),resultset.getString("tenKH"),resultset.getString("cccdKH"),
	        				resultset.getString("sdtKH"),resultset.getString("gioiTinhKH"),resultset.getDate("ngaySinhKH"),resultset.getString("quocTich"),
	        				resultset.getInt("DoanhSo"), resultset.getInt("maLKH") );
	                khList.add(kh);
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
		return khList;
	}
	public static ArrayList<KhachHang>   FindbySDT(String sdt) {
		ArrayList<KhachHang> khList = new ArrayList<>();
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			
			String sql = "select * from khachhang where sdtKH = ? ";
			statement = conn.prepareStatement(sql);
			statement.setString(1, sdt);
			
			ResultSet resultset = statement.executeQuery();

			 while (resultset.next()) {                
	                KhachHang kh = new KhachHang( 
	                		resultset.getInt("maKH"),resultset.getString("tenKH"),resultset.getString("cccdKH"),
	        				resultset.getString("sdtKH"),resultset.getString("gioiTinhKH"),resultset.getDate("ngaySinhKH"),resultset.getString("quocTich"),
	        				resultset.getInt("DoanhSo"), resultset.getInt("maLKH") );
	                khList.add(kh);
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
		return khList;
	}
	
	public static void UpdateDoanhSo(int DoanhSo, int  MaKH) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		
		
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "Update KhachHang set DoanhSo = ? where maKH = ?";
			statement = conn.prepareCall(sql)			;
			statement.setInt(1, DoanhSo);
			statement.setInt(2, MaKH);
			
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
	public static int   FindDoanhSo(int  MaKH) {
		int DoanhSo = 0;
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			
			String sql = "select DoanhSo from khachhang where MaKH = ? ";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, MaKH);
			
			ResultSet resultset = statement.executeQuery();

			 while (resultset.next()) {                
	                DoanhSo = resultset.getInt("DoanhSo");
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
		return DoanhSo;
	}
	public static void UpdateMaLKH(int MaLKH, int  MaKH) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "Update KhachHang set maLKH = ? where maKH = ?";
			statement = conn.prepareCall(sql)			;
			statement.setInt(1, MaLKH);
			statement.setInt(2, MaKH);
			
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
	public static int Find_MaLKH (int  MaKH)
	{
		int maLKH = 0;
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
		
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "select maLKH from KHACHHANG WHERE MaKH = ? ";
				
			statement = conn.prepareStatement(sql);
			statement.setInt(1, MaKH);
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) 
				maLKH = resultset.getInt("maLKH");
			
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
		return maLKH;
	}
	public static ArrayList<KhachHang>   Find_LKH(int MALKH) {
		ArrayList<KhachHang> khList = new ArrayList<>();
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			
			String sql = "select * from khachhang where MALKH = ?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, MALKH);
			ResultSet resultset = statement.executeQuery();

			 while (resultset.next()) {                
	                KhachHang kh = new KhachHang( 
	                		resultset.getInt("maKH"),resultset.getString("tenKH"),resultset.getString("cccdKH"),
	        				resultset.getString("sdtKH"),resultset.getString("gioiTinhKH"),resultset.getDate("ngaySinhKH"),resultset.getString("quocTich"),
	        				resultset.getInt("DoanhSo"), resultset.getInt("maLKH") );
	                khList.add(kh);
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
		return khList;
	}
}
