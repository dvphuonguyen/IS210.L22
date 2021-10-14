package Class;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class PhieuDatPhong {
	private int MAPDT, MANV, MAKH, maTT;
	private Date NGAYDT;
	public int getMaTT() {
		return maTT;
	}

	public void setMaTT(int maTT) {
		this.maTT = maTT;
	}
	
	public PhieuDatPhong(int mAPDT, int mANV, int mAKH, Date nGAYDT, int maTT) {
		super();
		MAPDT = mAPDT;
		MANV = mANV;
		MAKH = mAKH;
		NGAYDT = nGAYDT;
		this.maTT = maTT;
	}
	
	public PhieuDatPhong(int mANV, int mAKH, Date nGAYDT , int maTT) {
		super();
		MANV = mANV;
		MAKH = mAKH;
		NGAYDT = nGAYDT;
		this.maTT = maTT;
	}

	public int getMAPDT() {
		return MAPDT;
	}
	public void setMAPDT(int mAPDT) {
		MAPDT = mAPDT;
	}
	public int getMANV() {
		return MANV;
	}
	public void setMANV(int mANV) {
		MANV = mANV;
	}
	public int getMAKH() {
		return MAKH;
	}
	public void setMAKH(int mAKH) {
		MAKH = mAKH;
	}
	public Date getNGAYDT() {
		return NGAYDT;
	}
	public void setNGAYDT(Date nGAYDT) {
		NGAYDT = nGAYDT;
	}
	
	
	
	
	

	
	
}
