package Class;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class ConNguoi {
	protected String  HoTen;
	protected String soCMND;
	protected String DiaChi;
	protected String SDT;
	protected String NgaySinh;
	protected String GioiTinh;
	public ConNguoi(){};
	
	public ConNguoi(String hoTen, String soCMND, String diaChi, String sDT, String ngaySinh, String gioiTinh) {
		super();
		HoTen = hoTen;
		this.soCMND = soCMND;
		DiaChi = diaChi;
		SDT = sDT;
		NgaySinh = ngaySinh;
		GioiTinh = gioiTinh;
	}

	public String getHoTen() {
		return this.HoTen;
	}
	public String getsoCMND() {
		return this.soCMND;
	}
	public String getDiaChi() {
		return this.DiaChi;
	}
	public String getSDT() {
		return this.SDT;
	}
	public String getGioiTinh() {
		return this.GioiTinh;
	}
	public Date getNgaySinh() 
	{
		Date date = null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = formatter.parse(this.NgaySinh);
        } catch (ParseException e) {
            e.printStackTrace();
        }
		return date;
	}
	public void setHoTen(String Hoten)
	{
		this.HoTen = Hoten;
	}
	public void setsoCMND(String soCMND)
	{
		this.soCMND = soCMND;
	}
	public void setDiaChi(String DiaChi)
	{
		this.DiaChi = DiaChi;
	}
	public void setSDT(String SDT)
	{
		this.SDT = SDT;
	}
	public void setGioiTinh(String GioiTinh)
	{
		this.GioiTinh = GioiTinh;
	}
	public void setNgaySinh(Date NgaySinh)
	{
		Date date = null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = formatter.parse(this.NgaySinh);
            date = NgaySinh;
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}
}
