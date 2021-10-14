package Class;

import java.util.Date;

public class ChiTietPDV {
	private int maPDV, maDV, soLuong;
	Date ngaySD;
	
	
	public ChiTietPDV(int maPDV, int maDV, int soLuong, Date ngaySD) {
		super();
		this.maPDV = maPDV;
		this.maDV = maDV;
		this.soLuong = soLuong;
		this.ngaySD = ngaySD;
	}
	public int getMaPDV() {
		return maPDV;
	}
	public void setMaPDV(int maPDV) {
		this.maPDV = maPDV;
	}
	public int getMaDV() {
		return maDV;
	}
	public void setMaDV(int maDV) {
		this.maDV = maDV;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public Date getNgaySD() {
		return ngaySD;
	}
	public void setNgaySD(Date ngaySD) {
		this.ngaySD = ngaySD;
	}
	
}
