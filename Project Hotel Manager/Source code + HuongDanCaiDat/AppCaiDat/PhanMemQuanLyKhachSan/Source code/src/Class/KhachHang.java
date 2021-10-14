package Class;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KhachHang{
	private int MaKH;
	private String tenKH, cccdKH, sdtKH, diaChiKH, gioiTinhKH, quocTich, email;
	private Date ngaySinhKH;
	private int doanhSo, maLoaiKH;
	public KhachHang() {}
	public KhachHang(int maKH, String tenKH, String cccdKH, String sdtKH,  String gioiTinhKH,
			Date date, String quocTich, int doanhSo ,int maLoaiKH) {
		super();
		this.doanhSo = doanhSo;
		MaKH = maKH;
		this.tenKH = tenKH;
		this.cccdKH = cccdKH;
		this.email = email;
		this.sdtKH = sdtKH;
		this.diaChiKH = diaChiKH;
		this.gioiTinhKH = gioiTinhKH;
		this.ngaySinhKH = date;
		this.quocTich = quocTich;
		this.maLoaiKH = maLoaiKH;
		
	}
	
	public KhachHang(int maKH, String tenKH, String sdtKH, String cccdKH) {
		super();
		MaKH = maKH;
		this.tenKH = tenKH;
		this.cccdKH = cccdKH;
		this.sdtKH = sdtKH;
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public KhachHang(String tenKH, String cccdKH, String sdtKH,  String gioiTinhKH,
			Date date, String quocTich,int doanhSo ,int maLoaiKH) {
		super();
		this.doanhSo = doanhSo;
		this.maLoaiKH = maLoaiKH;
		this.tenKH = tenKH;
		this.cccdKH = cccdKH;
		this.email = email;
		this.sdtKH = sdtKH;
		this.diaChiKH = diaChiKH;
		this.gioiTinhKH = gioiTinhKH;
		this.ngaySinhKH = date;
		this.quocTich = quocTich;
	}
	public KhachHang(String tenKH, String sdtKH, String cccd ,String gioiTinhKH,
			Date date, String quocTich) {
		super();
		this.tenKH = tenKH;
		this.email = email;
		this.sdtKH = sdtKH;
		this.diaChiKH = diaChiKH;
		this.gioiTinhKH = gioiTinhKH;
		this.ngaySinhKH = date;
		this.quocTich = quocTich;
		this.cccdKH = cccd;
	}
	
	
	
	public KhachHang(int maKH, String tenKH, String cccdKH, String email, String sdtKH, String diaChiKH, String gioiTinhKH,
			 Date ngaySinhKH,String quocTich) {
		super();
		MaKH = maKH;
		this.tenKH = tenKH;
		this.cccdKH = cccdKH;
		this.sdtKH = sdtKH;
		this.diaChiKH = diaChiKH;
		this.gioiTinhKH = gioiTinhKH;
		this.quocTich = quocTich;
		this.email = email;
		this.ngaySinhKH = ngaySinhKH;
	}
	public int getMaKH() {
		return MaKH;
	}
	public void setMaKH(int maKH) {
		MaKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getCccdKH() {
		return cccdKH;
	}
	public void setCccdKH(String cccdKH) {
		this.cccdKH = cccdKH;
	}
	public String getSdtKH() {
		return sdtKH;
	}
	public void setSdtKH(String sdtKH) {
		this.sdtKH = sdtKH;
	}
	public String getDiaChiKH() {
		return diaChiKH;
	}
	public void setDiaChiKH(String diaChiKH) {
		this.diaChiKH = diaChiKH;
	}
	public String getGioiTinhKH() {
		return gioiTinhKH;
	}
	public void setGioiTinhKH(String gioiTinhKH) {
		this.gioiTinhKH = gioiTinhKH;
	}
	public String getQuocTich() {
		return quocTich;
	}
	public void setQuocTich(String quocTich) {
		this.quocTich = quocTich;
	}
	public int getMaLoaiKH() {
		return maLoaiKH;
	}
	public void setMaLoaiKH(int maLoaiKH) {
		this.maLoaiKH = maLoaiKH;
	}
	
	public Date getNgaySinh() 
	{
		return ngaySinhKH;
	}
	public String getNgaySinh_str() {
		return String.valueOf(ngaySinhKH);
	}
	
	public void setngaySinhKH(Date ngaySinhKH)
	{
		this.ngaySinhKH = ngaySinhKH;
	}
	@Override
	public String toString() {
		return "KhachHang [MaKH=" + MaKH + ", tenKH=" + tenKH + ", cccdKH=" + cccdKH + ", sdtKH=" + sdtKH
				+ ", diaChiKH=" + diaChiKH + ", gioiTinhKH=" + gioiTinhKH + ", quocTich=" + quocTich + ", email="
				+ email + ", ngaySinhKH=" + ngaySinhKH + ", maLoaiKH=" + maLoaiKH + "]";
	}
	public int getDoanhSo() {
		return doanhSo;
	}
	public void setDoanhSo(int doanhSo) {
		this.doanhSo = doanhSo;
	}

	
	
}
