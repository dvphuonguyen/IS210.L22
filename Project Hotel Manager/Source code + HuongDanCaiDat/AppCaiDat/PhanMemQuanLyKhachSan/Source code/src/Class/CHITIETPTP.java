package Class;

import java.util.Date;

public class CHITIETPTP {
	private int MAPTP, MAPHONG;
	private Date NGAYNP, NGAYTPTT;
	private float PHUTHU;
	private int  SLNGUOI;
	public CHITIETPTP(int mAPTP, int mAPHONG, Date nGAYNP, Date nGAYTPTT, int sLNGUOI, float pHUTHU) {
		super();
		MAPTP = mAPTP;
		MAPHONG = mAPHONG;
		NGAYNP = nGAYNP;
		NGAYTPTT = nGAYTPTT;
		PHUTHU = pHUTHU;
		SLNGUOI = sLNGUOI;
	}
	public CHITIETPTP(Date nGAYNP, Date nGAYTPTT, int sLNGUOI, float pHUTHU) {
		super();
		
		NGAYNP = nGAYNP;
		NGAYTPTT = nGAYTPTT;
		PHUTHU = pHUTHU;
		SLNGUOI = sLNGUOI;
	}
	public CHITIETPTP(int mAPHONG, Date nGAYNP, Date nGAYTPTT, int sLNGUOI, float pHUTHU) {
		super();
		MAPHONG = mAPHONG;
		NGAYNP = nGAYNP;
		NGAYTPTT = nGAYTPTT;
		PHUTHU = pHUTHU;
		SLNGUOI = sLNGUOI;
	}
	
	public CHITIETPTP(int mAPHONG) {
		super();
		MAPHONG = mAPHONG;
	}
	public int getMAPTP() {
		return MAPTP;
	}
	public void setMAPTP(int mAPTP) {
		MAPTP = mAPTP;
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
	public Date getNGAYTPTT() {
		return NGAYTPTT;
	}
	public void setNGAYTPTT(Date nGAYTPTT) {
		NGAYTPTT = nGAYTPTT;
	}
	public float getPHUTHU() {
		return PHUTHU;
	}
	public void setPHUTHU(float pHUTHU) {
		PHUTHU = pHUTHU;
	}
	public int getSLNGUOI() {
		return SLNGUOI;
	}
	public void setSLNGUOI(int sLNGUOI) {
		SLNGUOI = sLNGUOI;
	}
	
}
