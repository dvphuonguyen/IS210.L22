package Class;

import java.util.Date;

public class PhieuDichVu {
	private int maPDV, maNV, maKH, tongTien, maTT;

	

	public PhieuDichVu(int maPDV, int maNV, int maKH, int tongTien, int maTT) {
		super();
		this.maPDV = maPDV;
		this.maNV = maNV;
		this.maKH = maKH;
		this.tongTien = tongTien;
		this.maTT = maTT;
	}

	public PhieuDichVu(int maNV, int maKH, int tongTien , int maTT) {
		super();
		this.maNV = maNV;
		this.maKH = maKH;
		this.tongTien = tongTien;
		this.maTT = maTT;
	}

	public PhieuDichVu(int tongTien) {
		this.tongTien = tongTien;
	}

	public int getMaPDV() {
		return maPDV;
	}

	public void setMaPDV(int maPDV) {
		this.maPDV = maPDV;
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

	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}
	public int getMaTT() {
		return maTT;
	}

	public void setMaTT(int maTT) {
		this.maTT = maTT;
	}
}
