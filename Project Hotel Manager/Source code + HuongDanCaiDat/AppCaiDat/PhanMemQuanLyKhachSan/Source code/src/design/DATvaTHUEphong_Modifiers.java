package design;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import Class.CHITIETPTP;
import Class.ChiTietPDP;
import Class.DichVu;
import Class.KhachHang;
import Class.LoaiPhong;
import Class.NhanVien;
import Class.PhieuDatPhong;
import Class.PhieuThuePhong;
import Class.Phong;

public class DATvaTHUEphong_Modifiers {
	public static Connection getJDBCConnection() {
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##demo", "123456");
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
		}
	
		return null;
	}
	public static ArrayList findAll_PhieuDat(){
		Connection conn = getJDBCConnection();
		Statement statement = null;
		ArrayList pdp = new ArrayList();
		try {
			statement = conn.createStatement();
			
			//tao truy vấn SELECT đến csdl.
			String sql = "select MAPDP, MANV, PHIEUDATPHONG.MAKH ,TENKH, SDTKH, CCCDKH ,NGAYDT, MATT FROM PHIEUDATPHONG" + 
					" JOIN KHACHHANG ON KHACHHANG.MAKH = PHIEUDATPHONG.MAKH ORDER BY MAPDP ASC"; 
			ResultSet resultset = statement.executeQuery(sql);
			//resultSet là 1 array sẽ hứng toàn bộ dữ liệu lấy được khi chạy lệnh Select
			
			while (resultset.next()) {
				HashMap<String, String> p = new HashMap<>();
				p.put("MAPDP", resultset.getString("MAPDP"));
				p.put("MANV", resultset.getString("MANV"));
				p.put("MAKH", resultset.getString("MAKH"));
				p.put("TENKH", resultset.getString("TENKH"));
				p.put("SDTKH", resultset.getString("SDTKH"));
				p.put("CCCDKH", resultset.getString("CCCDKH"));
				p.put("NGAYDT", String.valueOf(resultset.getDate("NGAYDT")));
				p.put("MATT", resultset.getString("MATT"));
				pdp.add(p);
				
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
		return pdp;
	}
	public static void Add(PhieuDatPhong pdp) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		
		try {
			//mở kết nối
	
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "insert into PHIEUDATPHONG(MAPDP, MANV, MAKH, NGAYDT, MATT)"
						+ "values(PDP_S.nextval, ?, ?, ?, ?)";
			statement = conn.prepareStatement(sql);
		
			statement.setInt(1, pdp.getMANV());
			statement.setInt(2, pdp.getMAKH());
			statement.setDate(3, (Date) pdp.getNGAYDT());
			statement.setInt(4, pdp.getMaTT());
			
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
	public static ArrayList findAll_CTPDP(int mapdp){
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		ArrayList ctpdp = new ArrayList();
		try {
			
			
			//tao truy vấn SELECT đến csdl.
			String sql = "select MAPDP, CHITIETPDT.MAPHONG, TENPHONG ,NGAYNP, NGAYTPDD FROM CHITIETPDT" + 
					" JOIN PHONG ON PHONG.MAPHONG = CHITIETPDT.MAPHONG" +
					" WHERE MAPDP = ?";
			
			statement = conn.prepareStatement(sql);
			statement.setInt(1, mapdp);
			ResultSet resultSet = statement.executeQuery();
			//resultSet là 1 array sẽ hứng toàn bộ dữ liệu lấy được khi chạy lệnh Select
			
			while (resultSet.next()) {
				HashMap<String, String> p = new HashMap<>();
				p.put("MAPDP", resultSet.getString("MAPDP"));
				p.put("MAPHONG", resultSet.getString("MAPHONG"));
				p.put("TENPHONG", resultSet.getString("TENPHONG"));
				p.put("NGAYNP", String.valueOf(resultSet.getDate("NGAYNP")));
				p.put("NGAYTPDD", String.valueOf(resultSet.getDate("NGAYTPDD")));
				ctpdp.add(p);
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
		return ctpdp;
	}

	public static ArrayList<ChiTietPDP>   FindMaPhong_fromCTPDP(int MaPDP) {
		ArrayList<ChiTietPDP> maphongList = new ArrayList<>();
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			
			String sql = "select maphong from CHITIETPDT where MAPDP = ?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, MaPDP);
			
			ResultSet resultSet = statement.executeQuery();

			 while (resultSet.next()) {                
				 ChiTietPDP a  = new ChiTietPDP( resultSet.getInt("maphong") );
	                maphongList.add(a);
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
		return maphongList;
	}
	public static void Add_CTPDP(ChiTietPDP ctpdp) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		
		try {
			//mở kết nối
	
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "insert into CHITIETPDT(MAPDP, MAPHONG, NGAYNP, NGAYTPDD)"
						+ "values(?, ?, ?, ?)";
			statement = conn.prepareStatement(sql);
		
			statement.setInt(1, ctpdp.getMAPDP());
			statement.setInt(2, ctpdp.getMAPHONG());
			statement.setDate(3, (Date) ctpdp.getNGAYNP());
			statement.setDate(4, (Date) ctpdp.getNGAYTP_DUKIEN());
			
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
	public static void Add_CTPTP(CHITIETPTP ctptp) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		
		try {
			//mở kết nối
	
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "insert into CHITIETPTP(MAPTP, MAPHONG, NGAYNP, NGAYTPTT, SLNGUOI ,PHUTHU )"
						+ "values(?, ?, ?, ?, ?, ?)";
			statement = conn.prepareStatement(sql);
		
			statement.setInt(1, ctptp.getMAPTP());
			statement.setInt(2, ctptp.getMAPHONG());
			statement.setDate(3, (Date) ctptp.getNGAYNP());
			statement.setDate(4, (Date) ctptp.getNGAYTPTT());
			statement.setInt(5, ctptp.getSLNGUOI());
			statement.setFloat(6, ctptp.getPHUTHU());
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
	
	public static void Add_ThuePhong(PhieuThuePhong ptp) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		
		try {
			//mở kết nối
	
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "insert into PHIEUTHUEPHONG(MAPTP, MANV, MAKH, TIENPHONG ,MAPDP, MATT)"
						+ "values(PTP_S.nextval, ?, ?, ?, ?, ?)";
			statement = conn.prepareStatement(sql);
		
			
			
			statement.setInt(1, ptp.getMaNV());
			statement.setInt(2, ptp.getMaKH());
			statement.setInt(3, ptp.getTienPhong());
			statement.setInt(4, ptp.getMAPDP());
			statement.setInt(5, ptp.getMaTT());
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
	public static void Add_ThuePhong_NoPDT(PhieuThuePhong ptp) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		
		try {
			//mở kết nối
	
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "insert into PHIEUTHUEPHONG(MAPTP, MANV, MAKH, TIENPHONG , MATT)"
						+ "values(PTP_S.nextval, ?, ?, ?, ?)";
			statement = conn.prepareStatement(sql);
		
			statement.setInt(1, ptp.getMaNV());
			statement.setInt(2, ptp.getMaKH());
			statement.setInt(3, ptp.getTienPhong());
			statement.setInt(4, ptp.getMaTT());
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
	
	public static int  FindGiaPhong(String TenPhong) {
		int GiaPhong = 0;
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			
			String sql = "select giaPhong from loaiphong,phong  where loaiphong.malp = phong.malp and phong.tenphong = ?";
			statement = conn.prepareStatement(sql);
			statement.setString(1, TenPhong);
			
			ResultSet resultSet = statement.executeQuery();

			 while (resultSet.next()) {                
	                GiaPhong = resultSet.getInt("giaPhong");
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
		return GiaPhong;
	}
	public static ArrayList findAll_PhieuThue(){
		Connection conn = getJDBCConnection();
		Statement statement = null;
		ArrayList ptp = new ArrayList();
		try {
			statement = conn.createStatement();
			
			//tao truy vấn SELECT đến csdl.
			String sql = "select MAPTP, MANV, PHIEUTHUEPHONG.MAKH, TENKH, SDTKH, CCCDKH ,TIENPHONG, MAPDP, MATT  from PHIEUTHUEPHONG" + 
					" JOIN KHACHHANG ON KHACHHANG.MAKH = PHIEUTHUEPHONG.MAKH ORDER BY MAPTP ASC";
			ResultSet resultset = statement.executeQuery(sql);
			//resultSet là 1 array sẽ hứng toàn bộ dữ liệu lấy được khi chạy lệnh Select
			
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
				p.put("MATT", resultset.getString("MATT"));
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
	public static ArrayList findAll_ChiTietPTP(int maptp){
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		ArrayList ctptp = new ArrayList();
		try {
			
			
			//tao truy vấn SELECT đến csdl.
			String sql = "select MAPTP, CHITIETPTP.MAPHONG, TENPHONG, NGAYNP, NGAYTPTT, PHUTHU, SLNGUOI  from CHITIETPTP" + 
					" JOIN PHONG ON PHONG.MAPHONG = CHITIETPTP.MAPHONG"+
					" WHERE MAPTP = ?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, maptp);
			ResultSet resultset = statement.executeQuery();
		
			//resultSet là 1 array sẽ hứng toàn bộ dữ liệu lấy được khi chạy lệnh Select
			
			while (resultset.next()) {
				HashMap<String, String> p = new HashMap<>();
				p.put("MAPTP", resultset.getString("MAPTP"));
				p.put("MAPHONG", resultset.getString("MAPHONG"));
				p.put("TENPHONG", resultset.getString("TENPHONG"));
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
	public static void DeletePhieuThue(int MaPTP) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "delete from PhieuThuePhong where MAPTP = ?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, MaPTP);
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
	public static void DeletePhieuDat(int MaPDP) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "delete from PhieuDatPhong where MAPDP = ?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, MaPDP);
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
	public static void DeletePhong_fromPhieuDat(int maPDP) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "delete from CHITIETPDT where MAPDP = ?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, maPDP);
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
	public static void DeletePhong_fromCTPhieuDat(int maPhong) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "delete from CHITIETPDT where maPhong = ?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, maPhong);
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
	public static void DeletePhong_fromCTPhieuThue(int maPhong) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "delete from CHITIETPTP where maPhong = ?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, maPhong);
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
	public static ArrayList<Phong>   FindPhongTrong(Date ngaynp, Date ngaytp) {
		ArrayList<Phong> emptyList = new ArrayList<>();
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			
			String sql = "SELECT TENPHONG" + 
					" FROM PHONG P JOIN CHITIETTTP CTTTP ON CTTTP.MAPHONG = P.MAPHONG" + 
					" WHERE MATTP = 1 AND TRUNC(NGAYBD) <= TRUNC(?) AND TRUNC(?) <= TRUNC(NGAYKT)";
			statement = conn.prepareStatement(sql);
			statement.setDate(1, ngaynp);
			statement.setDate(2, ngaytp);
			ResultSet resultSet = statement.executeQuery();

			 while (resultSet.next()) {                
	                Phong a  = new Phong( resultSet.getString("TENPHONG") );
	                emptyList.add(a);
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
		return emptyList;
	}
	public static void Update_CTPTP(CHITIETPTP nv, int maP) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		
		
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "Update CHITIETPTP set  NGAYNP = ?, NGAYTPTT = ?, SLNGUOI = ?, PHUTHU = ? where MAPHONG  = ?";
			statement = conn.prepareCall(sql)			;
			
			statement.setDate(1, (Date) nv.getNGAYNP());
			statement.setDate(2, (Date) nv.getNGAYTPTT());
			statement.setInt(3,  nv.getSLNGUOI() );
			statement.setFloat(4, nv.getPHUTHU());
			statement.setInt(5, maP);
			
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
	public static ArrayList<PhieuThuePhong> FindMAPTP(int  maPDP) {
		ArrayList<PhieuThuePhong> ListPDP = new ArrayList<>();
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			
			String sql = "select MAPTP from PhieuThuePhong  where MAPDP = ?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, maPDP);
			
			ResultSet resultSet = statement.executeQuery();

			 while (resultSet.next()) {                
	                PhieuThuePhong a  = new PhieuThuePhong( resultSet.getInt("MAPTP") );
	                ListPDP.add(a);
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
		return ListPDP;
	}
	public static int FindTienPhong(int  maPTP) {
		int TienPhong = 0;
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			
			String sql = "select TIENPHONG from PhieuThuePhong  where MAPTP = ?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, maPTP);
			
			ResultSet resultSet = statement.executeQuery();

			 while (resultSet.next())                
				 TienPhong = resultSet.getInt("TIENPHONG") ;
	             
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
		return TienPhong;
	}
	public static void Update_TienPhong(int  tongTien, int maPTP) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		
		
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "Update PhieuThuePhong set  TIENPHONG = ? where maPTP  = ?";
			statement = conn.prepareCall(sql)			;
		
			statement.setInt(1, tongTien);
			statement.setInt(2, maPTP);
			
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
	
	public static ArrayList<CHITIETPTP>   FindMPfromPTP(int  maPTP) {
		ArrayList<CHITIETPTP> listMP = new ArrayList<>();
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			
			String sql = "select MAPHONG from CHITIETPTP  where MAPTP = ?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, maPTP);
			
			ResultSet resultSet = statement.executeQuery();

			 while (resultSet.next()) {                
				 CHITIETPTP a  = new CHITIETPTP( resultSet.getInt("MAPHONG") );
				 listMP.add(a);
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
		return listMP;
	}
	public static void Update_TinhTrangPDP( int maTT, int maPDP) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		
		
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "Update PhieuDatPhong set  maTT = ? where maPDP = ?";
			statement = conn.prepareCall(sql)			;
		
			statement.setInt(1, maTT);
			statement.setInt(2, maPDP);
			
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
	public static void Update_TinhTrangPTP( int maTT, int maPTP) {
		Connection conn = getJDBCConnection();
		PreparedStatement statement = null;
		
		try {
			//mở kết nối
			
			
			//tao truy vấn insert - update -  delete đến csdl.
			String sql = "Update PhieuThuePhong set  maTT = ? where maPTP = ?";
			statement = conn.prepareCall(sql);
		
			statement.setInt(1, maTT);
			statement.setInt(2, maPTP);
			
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
