package design;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import javax.swing.JOptionPane;

import Class.PhieuDatPhong;
import Class.CHITIETTTP;
import Class.DichVu;
import Class.Phong;
import Class.LoaiPhong;
import Class.NhanVien;

public class Phong_Modifiers {
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
	public static ArrayList findAll(){
		Connection conn = getJDBCConnection();
		Statement statement = null;
		ArrayList list = new ArrayList();
		try {
			statement = conn.createStatement();
			
			//tao truy vấn SELECT đến csdl.
			String sql = "select MAPHONG, TENPHONG, TENLP, GIAPHONG FROM PHONG, LOAIPHONG WHERE PHONG.MALP = LOAIPHONG.MALP  ORDER BY MAPHONG ASC";
			ResultSet resultset = statement.executeQuery(sql);
		
			//resultSet là 1 array sẽ hứng toàn bộ dữ liệu lấy được khi chạy lệnh Select
			
			while (resultset.next()) {
				HashMap<String, String> p = new HashMap<>();
				p.put("maP", resultset.getString("MAPHONG"));
				p.put("tenP", resultset.getString("TENPHONG"));
				p.put("tenLP", resultset.getString("TENLP"));
				p.put("giaP", resultset.getString("GIAPHONG"));
			
				list.add(p);
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
/*	public static void Update_xoa(int maP, java.util.Date date, java.util.Date date2) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		
		
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "delete from chitietttp where MAPHONG = ?"
					+ " and ngaybd = ? and ngaykt = ?";
			statement = conn.prepareCall(sql)			;
			statement.setInt(1, maP);
			statement.setDate(2, (Date) date);
			statement.setDate(3, (Date) date2);
			
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
	*/
	public static Phong  Find_NAME(String tenP) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		Phong p = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			
			String sql = "select MAPHONG from Phong where TENPHONG = ? ";
			statement = conn.prepareStatement(sql);
			statement.setString(1, tenP);
			
			ResultSet resultSet = statement.executeQuery();

			 while (resultSet.next()) {                
				 	int maP = resultSet.getInt("MAPHONG");
	                 p = new Phong();
	                 p.setMaPhong(maP);
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
		return p;
	}
	public static ArrayList<Phong>   FindTT(int maTTP) {
		ArrayList<Phong> PList = new ArrayList<>();
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			
			String sql = "select  unique  tenphong from phong join chitietttp " + 
					" on phong.maphong = chitietttp.maphong" + 
					" and chitietttp.mattp = ?" + 
					" and ngaybd <= sysdate and ngaykt >= sysdate";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, maTTP);
			ResultSet resultset = statement.executeQuery();

			 while (resultset.next()) {                
	                Phong a = new Phong();
	                PList.add(a);
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
		return PList;
	}
	public static ArrayList findAll_ChiTietTTP(int maPhong){
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		ArrayList list = new ArrayList();
		try {
			
			//tao truy vấn SELECT đến csdl.
			String sql = "select MAPHONG, NGAYBD, NGAYKT, TENTTP FROM CHITIETTTP, TINHTRANGPHONG WHERE CHITIETTTP.MATTP = TINHTRANGPHONG.MATTP and maPhong = ? order by ngaybd";
			
		
			statement = conn.prepareStatement(sql);
			statement.setInt(1, maPhong);
			
		
			ResultSet resultset = statement.executeQuery();

			
			
			//resultSet là 1 array sẽ hứng toàn bộ dữ liệu lấy được khi chạy lệnh Select
			
			while (resultset.next()) {
				HashMap<String, String> p = new HashMap<>();
				p.put("MAPHONG", resultset.getString("MAPHONG"));
				p.put("NGAYBD", String.valueOf(resultset.getDate("NGAYBD")));
				p.put("NGAYKT", String.valueOf(resultset.getDate("NGAYKT")));
				p.put("TENTTP", resultset.getString("TENTTP"));
			
				list.add(p);
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
	public static void Add(CHITIETTTP a) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		
		try {
			//mở kết nối
	
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "Insert into CHITIETTTP (MAPHONG,MATTP,NGAYBD,NGAYKT) "
						+ "values(?, ?, ?, ?)";
			statement = conn.prepareStatement(sql);
		
			statement.setInt(1, a.getMaPhong() );
			statement.setInt(2, a.getMaTTP() );
			statement.setDate(3, (Date) a.getNgayBD() );
			statement.setDate(4, (Date) a.getNgayKT());
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
	public static void Update_CTTTP(int maP, Date ngayBD, Date ngayKT) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "Update CHITIETTTP set maTTP = 3 where maphong = ? and ngaybd = ? and ngaykt = ?";
			statement = conn.prepareCall(sql);
			statement.setInt(1, maP);
			statement.setDate(2, ngayBD);
			statement.setDate(3, ngayKT);
		
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
	public static void Delete_CTTTP(int maP, java.util.Date date, java.util.Date date2) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "Delete from CHITIETTTP where maphong = ? and ngaybd = ? and ngaykt = ?";
			statement = conn.prepareCall(sql);
			statement.setInt(1, maP);
			statement.setDate(2, (Date) date);
			statement.setDate(3, (Date) date2);
		
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
}
