package design;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import Class.ChiTietPDV;
import Class.DichVu;
import Class.DonVi;
import Class.KhachHang;
import Class.NhanVien;
import Class.PhieuDichVu;
public class DichVu_Modifiers {
	public static Connection getJDBCConnection() {
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##demo", "123456");
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block.
			e1.printStackTrace();
		}
	
		return null;
}
	public static ArrayList<DichVu> findAll(){
		Connection conn = getJDBCConnection();
		Statement statement = null;
		ArrayList<DichVu> dv = new ArrayList<DichVu>();
		try {
			statement = conn.createStatement();
			
			//tao truy vấn SELECT đến csdl.
			String sql = "select * from DichVu ORDER BY MADV ASC";
			ResultSet resultset = statement.executeQuery(sql);
			//resultSet là 1 array sẽ hứng toàn bộ dữ liệu lấy được khi chạy lệnh Select
			
			while (resultset.next()) {
				DichVu a = new DichVu (
				resultset.getInt("MADV"),resultset.getString("TENDV"),resultset.getInt("GIADV"),
				resultset.getInt("MADONVI"));
				dv.add(a);
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
		return dv;
	}
	public static void Add(DichVu dv) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		
		try {
			//mở kết nối
	
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "insert into DICHVU(madv, TENDV, GIADV, MADONVI)"
						+ "values(DV_S.nextval, ?, ?, ?)";
			statement = conn.prepareStatement(sql);
		
			statement.setString(1, dv.getTenDV());
			statement.setInt(2, dv.getGiaDV());
			statement.setInt(3, dv.getMaDonVi());
			
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
	public static void Delete(String tenDV) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "delete from DICHVU where TENDV = ?";
			statement = conn.prepareStatement(sql);
			statement.setString(1, tenDV);
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
	public static void Update(DichVu dv, String tenDV) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		
		
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "Update DichVu set GIADV = ?, MADONVI = ? WHERE TENDV = ?";
			statement = conn.prepareCall(sql)			;
			
			statement.setInt(1, dv.getGiaDV() );
			statement.setInt(2, dv.getMaDonVi());
			statement.setString(3, dv.getTenDV() );
			
			
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
	public static ArrayList<DichVu>   Find(String TenDV) {
		ArrayList<DichVu> DVList = new ArrayList<>();
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "select * from DICHVU where UPPER(TENDV) LIKE UPPER(?)";
			statement = conn.prepareStatement(sql);
			statement.setString(1, TenDV+"%");
			

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				DichVu dv = new DichVu  (
				resultset.getInt("MADV"), resultset.getString("TENDV"),
				resultset.getInt("GIADV"), resultset.getInt("MADONVI") );
				DVList.add(dv);
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
		
		return DVList;
	}
	public static ArrayList<DichVu>   Find_Exactly(String TenDV) {
		ArrayList<DichVu> DVList = new ArrayList<>();
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "select * from DICHVU where UPPER(TENDV) = UPPER(?)";
			statement = conn.prepareStatement(sql);
			statement.setString(1, TenDV);
			

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				DichVu dv = new DichVu  (
				resultset.getInt("MADV"), resultset.getString("TENDV"),
				resultset.getInt("GIADV"), resultset.getInt("MADONVI") );
				DVList.add(dv);
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
		
		return DVList;
	}
	public static ArrayList<DonVi> Find_MaDonVi (String TenDonVi)
	{
		ArrayList<DonVi> DVList = new ArrayList<>();
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
		
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "select MADONVI from DONVI WHERE TENDONVI = ? ";
				
			statement = conn.prepareStatement(sql);
			statement.setString(1, TenDonVi);
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				DonVi a = new DonVi (
				resultset.getInt("MADONVI"));
				DVList.add(a);
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
		return DVList;
	}
	public static  ArrayList<DonVi> FindDonVi() {
		ArrayList<DonVi> DonViList = new ArrayList<>();
		Connection conn = getJDBCConnection();
		Statement statement = null;
		try {
			//mở kết nối
			statement = conn.createStatement();
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "Select TENDONVI from DONVI";
			ResultSet resultset = statement.executeQuery(sql);
			while (resultset.next()) {
				DonVi a = new DonVi (resultset.getString("TENDONVI"));
				DonViList.add(a);
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
		return DonViList;
	}
	public static ArrayList<DonVi> findAll_DonVi(){
		Connection conn = getJDBCConnection();
		Statement statement = null;
		ArrayList<DonVi> donvi = new ArrayList<DonVi>();
		try {
			statement = conn.createStatement();
			
			//tao truy vấn SELECT đến csdl.  
			String sql = "select * from DonVi";
			ResultSet resultset = statement.executeQuery(sql);
			//resultSet là 1 array sẽ hứng toàn bộ dữ liệu lấy được khi chạy lệnh Select
			
			while (resultset.next()) {
				DonVi a = new DonVi (
				resultset.getInt("MADONVI"),resultset.getString("TENDONVI"));
				donvi.add(a);
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
		return donvi;
	}
	public static void Add_DonVi(DonVi dv) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		
		try {
			//mở kết nối
	
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "insert into DONVI(MADONVI, TENDONVI)"
						+ "values(DONVI_S.nextval,?)";
			statement = conn.prepareStatement(sql);
		
			
			statement.setString(1, dv.getTenDonVi());
		
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

	// THAO TÁC VỚI PHIẾU DỊCH VỤ
	public static void Add_PDV(PhieuDichVu pdv) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		
		try {
			//mở kết nối
	
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "insert into PHIEUDICHVU(MAPDV, MANV, MAKH, TIENDV, MATT)"
						+ "values(PDV_S.nextval, ?, ?, ?, ?)";
			statement = conn.prepareStatement(sql);
		
			statement.setInt(1, pdv.getMaNV());
			statement.setInt(2, pdv.getMaKH());
			statement.setInt(3, pdv.getTongTien());
			statement.setInt(4, pdv.getMaTT());
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
	public static ArrayList findAll_CTPDV(int mapdv){
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		ArrayList pdv = new ArrayList();
		try {
			
			
			//tao truy vấn SELECT đến csdl.
			String sql = "select MAPDV, CHITIETPDV.MADV, TENDV, SLDV, NGAYSD from CHITIETPDV" + 
						 " Join DICHVU on  CHITIETPDV.MADV = DICHVU.MADV" +
						 " WHERE MAPDV = ?";
	
			statement = conn.prepareStatement(sql);
			statement.setInt(1, mapdv);
			ResultSet resultset = statement.executeQuery();
			
			while (resultset.next()) {
				HashMap<String, String> p = new HashMap<>();
				p.put("MAPDV", resultset.getString("MAPDV"));
				p.put("MADV", resultset.getString("MADV"));
				p.put("TENDV", resultset.getString("TENDV"));
				p.put("SLDV", resultset.getString("SLDV"));
				p.put("NGAYSD",String.valueOf(resultset.getDate("NGAYSD")));
			
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
	public static ArrayList findAll_PDV(){
		Connection conn = getJDBCConnection();
		Statement statement = null;
		ArrayList pdv = new ArrayList();
		try {
			statement = conn.createStatement();
			
			//tao truy vấn SELECT đến csdl.
			String sql = "select MAPDV, MANV, PHIEUDICHVU.MAKH, TENKH, TIENDV, MATT from PHIEUDICHVU" + 
						 " Join KHACHHANG on  PHIEUDICHVU.MAKH = KHACHHANG.MAKH order by MAPDV asc" ;
	
			ResultSet resultset = statement.executeQuery(sql);
			//resultSet là 1 array sẽ hứng toàn bộ dữ liệu lấy được khi chạy lệnh Select
			
			while (resultset.next()) {
				HashMap<String, String> p = new HashMap<>();
				p.put("MAPDV", resultset.getString("MAPDV"));
				p.put("MANV", resultset.getString("MANV"));
				p.put("MAKH", resultset.getString("MAKH"));
				p.put("TENKH", resultset.getString("TENKH"));
				p.put("TIENDV", resultset.getString("TIENDV"));
				p.put("MATT", resultset.getString("MATT"));
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
	public static void Add_CTPDV(ChiTietPDV ctpdv) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		
		try {
			//mở kết nối
	
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "insert into CHITIETPDV(MAPDV, MADV, SLDV, NGAYSD)"
						+ "values(?, ?, ?, ?)";
			statement = conn.prepareStatement(sql);
		
			statement.setInt(1, ctpdv.getMaPDV());
			statement.setInt(2, ctpdv.getMaDV());
			statement.setInt(3, ctpdv.getSoLuong());
			statement.setDate(4, (Date) ctpdv.getNgaySD());
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

	public static void Update_Tongtien(int maPDV, int TongTien) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		
	
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "Update PhieuDichVu set TIENDV = ? where MAPDV = ?";
			statement = conn.prepareCall(sql)			;
			statement.setInt(1, TongTien);
			statement.setInt(2, maPDV);
		
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
	public static ArrayList<DichVu>   FindSoTien(int MaDV) {
		ArrayList<DichVu> DVList = new ArrayList<>();
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			
			String sql = "select * from DICHVU where MADV = ?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, MaDV);
	
			ResultSet resultSet = statement.executeQuery();

			 while (resultSet.next()) {                
	                DichVu dv = new DichVu( 
	                resultSet.getInt("MADV"), resultSet.getString("tenDV") ,resultSet.getInt("GIADV"), resultSet.getInt("MADONVI") 
	                );
	                
	                DVList.add(dv);
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
		return DVList;
	}	
	public static void DeleteAllDichVu_from_CTPDV(int MaPDV) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "delete from CHITIETPDV where MAPDV = ?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, MaPDV);
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
	public static void Delete_FromPDV(int MaPDV) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "delete from PhieuDichVu where MAPDV = ?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, MaPDV);
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
	public static void Delete_from_CTPDV(int MaDV) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "delete from CHITIETPDV where MADV = ?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, MaDV);
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
	public static void Update(int tienDV, int mapdv) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		
		
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "Update PHIEUDICHVU set TIENDV = ? where MAPDV = ?";
			statement = conn.prepareCall(sql)			;
			statement.setInt(1, tienDV);
			statement.setInt(2, mapdv);
		
			
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
	public static ArrayList<PhieuDichVu>   FindTongTien(int MaPDV) {
		ArrayList<PhieuDichVu> PDVList = new ArrayList<>();
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			//tao truy vấn insert - update -  delete đến csdl.
			
			String sql = "select TIENDV from PHIEUDICHVU where MAPDV = ?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, MaPDV);
	
			ResultSet resultSet = statement.executeQuery();

			 while (resultSet.next()) {                
	                PhieuDichVu pdv = new PhieuDichVu( 
	                resultSet.getInt("TIENDV"));
	                
	                PDVList.add(pdv);
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
		return PDVList;
	}	
	public static void Update_TinhTrangPDV( int maTT, int maPDV) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "Update PhieuDichVu set  maTT = ? where maPDV = ?";
			statement = conn.prepareCall(sql);
		
			statement.setInt(1, maTT);
			statement.setInt(2, maPDV);
			
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
