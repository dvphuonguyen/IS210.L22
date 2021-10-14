package Class;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KhuyenMai {
	private int maKM;
	private String  tenKM;
	private Date tuNgay, denNgay;
	
	
	public KhuyenMai(int maKM, String tenKM, Date tuNgay, Date denNgay) {
		super();
		this.maKM = maKM;
		this.tenKM = tenKM;
		this.tuNgay = tuNgay;
		this.denNgay = denNgay;
	}
	public KhuyenMai(String tenKM, Date tuNgay, Date denNgay) {
		super();
	
		this.tenKM = tenKM;
		this.tuNgay = tuNgay;
		this.denNgay = denNgay;
	}
	
	public int getMaKM() {
		return maKM;
	}
	public void setMaKM(int maKM) {
		this.maKM = maKM;
	}
	public String getTenKM() {
		return tenKM;
	}
	public void setTenKM(String tenKM) {
		this.tenKM = tenKM;
	}
	public Date getTuNgay() {
		return tuNgay;
	}
	public void setTuNgay(Date tuNgay) {
		this.tuNgay = tuNgay;
	}
	public Date getDenNgay() {
		return denNgay;
	}
	public void setDenNgay(Date denNgay) {
		this.denNgay = denNgay;
	}
	
}
