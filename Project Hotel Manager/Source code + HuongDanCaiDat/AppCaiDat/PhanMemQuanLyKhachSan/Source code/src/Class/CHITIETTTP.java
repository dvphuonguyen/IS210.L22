package Class;

import java.util.Date;

public class CHITIETTTP {
	private int MaPhong, MaTTP;
	private Date NgayBD, NgayKT;
	public CHITIETTTP() {}
	public CHITIETTTP(int maPhong, int maTTP,  Date ngayBD, Date ngayKT) {
		super();
		MaPhong = maPhong;
		MaTTP = maTTP;
		NgayBD = ngayBD;
		NgayKT = ngayKT;
	}
	public int getMaPhong() {
		return MaPhong;
	}
	public void setMaPhong(int maPhong) {
		MaPhong = maPhong;
	}
	public int getMaTTP() {
		return MaTTP;
	}
	public void setMaTTP(int maTTP) {
		MaTTP = maTTP;
	}
	public Date getNgayBD() {
		return NgayBD;
	}
	public String getgetNgayBD_str() {
		return String.valueOf(NgayBD);
	}
	public void setNgayBD(Date ngayBD) {
		NgayBD = ngayBD;
	}
	public Date getNgayKT() {
		return NgayKT;
	}
	public String getNgayKT_str() {
		return String.valueOf(NgayKT);
	}
	public void setNgayKT(Date ngayKT) {
		NgayKT = ngayKT;
	}
	
}
