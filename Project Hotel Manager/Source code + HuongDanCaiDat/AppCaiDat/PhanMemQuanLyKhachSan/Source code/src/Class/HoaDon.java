package Class;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HoaDon {
	private int maHD, maNV, maKH, maPTP, maPDV, tongTien;
	private Date ngayTT;
	
	public HoaDon(int maHD, int maNV, int maKH, int maPTP, int maPDV, int tongTien, Date ngayTT) {
		super();
		this.maHD = maHD;
		this.maNV = maNV;
		this.maKH = maKH;
		this.maPTP = maPTP;
		this.maPDV = maPDV;
		this.tongTien = tongTien;
		this.ngayTT = ngayTT;
	}
	
	public HoaDon(int maNV, int maKH, int maPTP, int maPDV, int tongTien, Date ngayTT) {
		super();
		this.maNV = maNV;
		this.maKH = maKH;
		this.maPTP = maPTP;
		this.maPDV = maPDV;
		this.tongTien = tongTien;
		this.ngayTT = ngayTT;
	}

	public int getMaHD() {
		return maHD;
	}
	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}
	public int getMaNV() {
		return maNV;
	}
	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}
	public int getMaKH() {
		return maKH;
	}
	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}
	public int getMaPTP() {
		return maPTP;
	}
	public void setMaPTP(int maPTP) {
		this.maPTP = maPTP;
	}
	public int getMaPDV() {
		return maPDV;
	}
	public void setMaPDV(int maPDV) {
		this.maPDV = maPDV;
	}
	public int getTongTien() {
		return tongTien;
	}
	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}
	public Date getNgayTT() {
		return ngayTT;
	}
	public void setNgayTT(Date ngayTT) {
		this.ngayTT = ngayTT;
	}
	
	
	

	
}
