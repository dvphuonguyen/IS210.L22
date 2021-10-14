package design;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import Class.HoaDon;
import Class.PhieuDatPhong;
public class HoaDon_Modifiers {
	public static Connection getJDBCConnection() {
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##demo", "123456");
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
		}
		return null;
	}
	public static ArrayList findAll_PhieuThuefromSDT(String sdt){
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		ArrayList ptp = new ArrayList();
		try {
			//tao truy vấn SELECT đến csdl.
			String sql = "select MAPTP, MANV, PHIEUTHUEPHONG.MAKH, TENKH, SDTKH, CCCDKH ,TIENPHONG, MAPDP  from PHIEUTHUEPHONG" + 
					" JOIN KHACHHANG ON KHACHHANG.MAKH = PHIEUTHUEPHONG.MAKH" +
					" WHERE KHACHHANG.SDTKH = ? AND PHIEUTHUEPHONG.MATT = 1";
			statement = conn.prepareStatement(sql);
			statement.setString(1, sdt);
			ResultSet resultset = statement.executeQuery();
			
			while (resultset.next()) {
				HashMap<String, String> p = new HashMap<>();
				p.put("MAPTP", resultset.getString("MAPTP"));
				p.put("MANV", resultset.getString("MANV"));
				p.put("MAKH", resultset.getString("MAKH"));
				p.put("TENKH", resultset.getString("TENKH"));
				p.put("SDTKH", resultset.getString("SDTKH"));
				p.put("CCCDKH", resultset.getString("CCCDKH"));
				p.put("TIENPHONG", resultset.getString("TIENPHONG"));
				p.put("MAPDP", resultset.getString("MAPDP"));
				ptp.add(p);
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
		return ptp;
	}
	public static ArrayList findAll(){
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		ArrayList hd = new ArrayList();
		try {
	
			//tao truy vấn SELECT đến csdl.
			String sql = "select MAHD, MANV, HOADON.MAKH, TENKH, SDTKH, MAPTP, MAPDV ,TONGTIEN, NGAYTT from HOADON" + 
						 " Join KHACHHANG on  HOADON.MAKH = KHACHHANG.MAKH";
	
			statement = conn.prepareStatement(sql);
		
			ResultSet resultset = statement.executeQuery();
			
			while (resultset.next()) {
				HashMap<String, String> p = new HashMap<>();
				p.put("MAHD", resultset.getString("MAHD"));
				p.put("MANV", resultset.getString("MANV"));
				p.put("MAKH", resultset.getString("MAKH"));
				p.put("TENKH", resultset.getString("TENKH"));
				p.put("SDTKH", resultset.getString("SDTKH"));
				p.put("MAPTP", resultset.getString("MAPTP"));
				p.put("MAPDV", resultset.getString("MAPDV"));
				p.put("TONGTIEN", resultset.getString("TONGTIEN"));
				p.put("NGAYTT", String.valueOf(resultset.getDate("NGAYTT")));
				hd.add(p);
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
		return hd;
	}
	public static ArrayList findAll_bySDT(String sdt){
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		ArrayList hd = new ArrayList();
		try {
	
			//tao truy vấn SELECT đến csdl.
			String sql = "select MAHD, MANV, HOADON.MAKH, TENKH, SDTKH, MAPTP, MAPDV ,TONGTIEN, NGAYTT from HOADON" + 
						 " Join KHACHHANG on  HOADON.MAKH = KHACHHANG.MAKH" +
						 " where SDTKH = ?";
	
			statement = conn.prepareStatement(sql);
			statement.setString(1, sdt);
			ResultSet resultset = statement.executeQuery();
			
			while (resultset.next()) {
				HashMap<String, String> p = new HashMap<>();
				p.put("MAHD", resultset.getString("MAHD"));
				p.put("MANV", resultset.getString("MANV"));
				p.put("MAKH", resultset.getString("MAKH"));
				p.put("TENKH", resultset.getString("TENKH"));
				p.put("SDTKH", resultset.getString("SDTKH"));
				p.put("MAPTP", resultset.getString("MAPTP"));
				p.put("MAPDV", resultset.getString("MAPDV"));
				p.put("TONGTIEN", resultset.getString("TONGTIEN"));
				p.put("NGAYTT", String.valueOf(resultset.getDate("NGAYTT")));
				hd.add(p);
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
		return hd;
	}
	public static void AddHD(HoaDon hd) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		
		try {
			//mở kết nối
	
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "insert into HOADON(MAHD, MANV, MAKH, MAPTP, MAPDV, TONGTIEN, NGAYTT)"
						+ "values(HD_S.nextval, ?, ?, ?, ?, ?, ?)";
			statement = conn.prepareStatement(sql);
		
			statement.setInt(1, hd.getMaNV());
			statement.setInt(2, hd.getMaKH());
			statement.setInt(3, hd.getMaPTP());
			statement.setInt(4, hd.getMaPDV());
			statement.setInt(5, hd.getTongTien());
			statement.setDate(6, (Date) hd.getNgayTT());
			
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
	public static ArrayList findAll_PDVfromSDT(String sdt){
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		ArrayList pdv = new ArrayList();
		try {
	
			//tao truy vấn SELECT đến csdl.
			String sql = "select MAPDV, MANV, PHIEUDICHVU.MAKH, TENKH, SDTKH ,TIENDV from PHIEUDICHVU" + 
						 " Join KHACHHANG on  PHIEUDICHVU.MAKH = KHACHHANG.MAKH" +
						 " Where KHACHHANG.SDTKH = ? AND PHIEUDICHVU.MATT = 1";
	
			statement = conn.prepareStatement(sql);
			statement.setString(1, sdt);
			ResultSet resultset = statement.executeQuery();
			
			while (resultset.next()) {
				HashMap<String, String> p = new HashMap<>();
				p.put("MAPDV", resultset.getString("MAPDV"));
				p.put("MANV", resultset.getString("MANV"));
				p.put("MAKH", resultset.getString("MAKH"));
				p.put("TENKH", resultset.getString("TENKH"));
				p.put("SDTKH", resultset.getString("SDTKH"));
				p.put("TIENDV", resultset.getString("TIENDV"));
			
				pdv.add(p);
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
		return pdv;
	}
//	public static ArrayList findAll_CTPTP(String sdt){
//		Connection conn = getJDBCConnection();
//		PreparedStatement statement = null;
//		ArrayList ptp = new ArrayList();
//		try {
//			//tao truy vấn SELECT đến csdl.
//			String sql = "select TENPHONG, DONGIA, SOLUONG PHIEUTHUEPHONG.MAKH, TENKH, SDTKH, CCCDKH ,TIENPHONG, MAPDP  from PHIEUTHUEPHONG" + 
//					" JOIN KHACHHANG ON KHACHHANG.MAKH = PHIEUTHUEPHONG.MAKH" +
//					" WHERE KHACHHANG.SDTKH = ?";
//			statement = conn.prepareStatement(sql);
//			statement.setString(1, sdt);
//			ResultSet resultset = statement.executeQuery();
//			
//			while (resultset.next()) {
//				HashMap<String, String> p = new HashMap<>();
//				p.put("MAPTP", resultset.getString("MAPTP"));
//				p.put("MANV", resultset.getString("MANV"));
//				p.put("MAKH", resultset.getString("MAKH"));
//				p.put("TENKH", resultset.getString("TENKH"));
//				p.put("SDTKH", resultset.getString("SDTKH"));
//				p.put("CCCDKH", resultset.getString("CCCDKH"));
//				p.put("TIENPHONG", resultset.getString("TIENPHONG"));
//				p.put("MAPDP", resultset.getString("MAPDP"));
//				ptp.add(p);
//			}
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		//đóng kết nối.
//		
//		finally {
//			if (statement != null) {
//				try {
//					statement.close();
//				} catch (SQLException e2) {
//					// TODO Auto-generated catch block
//					e2.printStackTrace();
//				}
//			}
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e1) {	
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//		}
//		return ptp;
//	}
	public static ArrayList findAll_ChiTietPTP(int maptp){
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		ArrayList ctptp = new ArrayList();
		try {
			
			
			//tao truy vấn SELECT đến csdl.
			String sql = "select  TENPHONG, GIAPHONG, NGAYNP, NGAYTPTT, SLNGUOI, PHUTHU from CHITIETPTP" + 
					" JOIN PHONG ON PHONG.MAPHONG = CHITIETPTP.MAPHONG"+
					" JOIN LOAIPHONG ON PHONG.MALP = LOAIPHONG.MALP"+
					" WHERE MAPTP = ?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1,maptp);
			ResultSet resultset = statement.executeQuery();
		
			//resultSet là 1 array sẽ hứng toàn bộ dữ liệu lấy được khi chạy lệnh Select
			
			while (resultset.next()) {
				HashMap<String, String> p = new HashMap<>();
				p.put("TENPHONG", resultset.getString("TENPHONG"));
				p.put("GIAPHONG", resultset.getString("GIAPHONG"));
				p.put("NGAYNP", String.valueOf(resultset.getDate("NGAYNP")));
				p.put("NGAYTPTT", String.valueOf(resultset.getDate("NGAYTPTT")));
				p.put("SLNGUOI", resultset.getString("SLNGUOI"));
				p.put("PHUTHU", resultset.getString("PHUTHU"));
				ctptp.add(p);
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
		return ctptp;
	}
	public static ArrayList findAll_ChiTietPDV(int mapdv){
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		ArrayList ctptp = new ArrayList();
		try {
			
			
			//tao truy vấn SELECT đến csdl.
			String sql = "select tendv , giadv, sldv from chitietpdv" + 
					" join dichvu on chitietpdv.madv = dichvu.madv"+
					" WHERE MAPDV = ?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1,mapdv);
			ResultSet resultset = statement.executeQuery();
		
			//resultSet là 1 array sẽ hứng toàn bộ dữ liệu lấy được khi chạy lệnh Select
			
			while (resultset.next()) {
				HashMap<String, String> p = new HashMap<>();
				p.put("TENDV", resultset.getString("TENDV"));
				p.put("GIADV", resultset.getString("GIADV"));
				p.put("SLDV",  resultset.getString("SLDV"));
			
				ctptp.add(p);
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
		return ctptp;
	}
	public static void Delete(int mahd) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "delete from HoaDon where mahd = ?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, mahd);
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
