package Class;

import java.util.Date;

public class PhieuThuePhong {
	private int maPTP, maNV, maKH, tienPhong, MAPDP, maTT;

	public PhieuThuePhong(int maPTP, int maNV, int maKH, int tienPhong, int mAPDP, int maTT) {
		super();
		this.maPTP = maPTP;
		this.maNV = maNV;
		this.maKH = maKH;
		this.tienPhong = tienPhong;
		MAPDP = mAPDP;
		this.maTT = maTT;
	}

	public int getMaTT() {
		return maTT;
	}

	public void setMaTT(int maTT) {
		this.maTT = maTT;
	}

	public PhieuThuePhong(int maNV, int maKH, int tienPhong, int mAPDP , int maTT) {
		super();
		this.maNV = maNV;
		this.maKH = maKH;
		this.tienPhong = tienPhong;
		MAPDP = mAPDP;
		this.maTT = maTT;
	}
	public PhieuThuePhong(int maNV, int maKH, int tienPhong , int maTT) {
		super();
		this.maNV = maNV;
		this.maKH = maKH;
		this.tienPhong = tienPhong;
		this.maTT = maTT;
	}
	public PhieuThuePhong(int maPTP) {
		this.maPTP = maPTP;
	}

	public int getMaPTP() {
		return maPTP;
	}

	public void setMaPTP(int maPTP) {
		this.maPTP = maPTP;
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

	public int getTienPhong() {
		return tienPhong;
	}

	public void setTienPhong(int tienPhong) {
		this.tienPhong = tienPhong;
	}

	public int getMAPDP() {
		return MAPDP;
	}

	public void setMAPDP(int mAPDP) {
		MAPDP = mAPDP;
	}
	
}
