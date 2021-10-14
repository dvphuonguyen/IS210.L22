package Class;

import java.util.Date;

public class ChiTietPDP {
	private int MAPDP, MAPHONG;
	private Date NGAYNP, NGAYTP_DUKIEN;
	public ChiTietPDP() {}
	public ChiTietPDP(int mAPDP, int mAPHONG, Date nGAYNP, Date nGAYTP_DUKIEN) {
		super();
		MAPDP = mAPDP;
		MAPHONG = mAPHONG;
		NGAYNP = nGAYNP;
		NGAYTP_DUKIEN = nGAYTP_DUKIEN;
	}
	
	
	public ChiTietPDP(int mAPHONG) {
		super();
		MAPHONG = mAPHONG;
	}


	public ChiTietPDP(int mAPHONG, Date nGAYNP, Date nGAYTP_DUKIEN) {
		super();
		MAPHONG = mAPHONG;
		NGAYNP = nGAYNP;
		NGAYTP_DUKIEN = nGAYTP_DUKIEN;
	}


	public int getMAPDP() {
		return MAPDP;
	}
	public void setMAPDP(int mAPDP) {
		MAPDP = mAPDP;
	}
	public int getMAPHONG() {
		return MAPHONG;
	}
	public void setMAPHONG(int mAPHONG) {
		MAPHONG = mAPHONG;
	}
	public Date getNGAYNP() {
		return NGAYNP;
	}
	public void setNGAYNP(Date nGAYNP) {
		NGAYNP = nGAYNP;
	}
	public Date getNGAYTP_DUKIEN() {
		return NGAYTP_DUKIEN;
	}
	public void setNGAYTP_DUKIEN(Date nGAYTP_DUKIEN) {
		NGAYTP_DUKIEN = nGAYTP_DUKIEN;
	}
	
}
