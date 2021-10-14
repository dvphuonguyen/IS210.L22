package Class;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NhanVien{
	int MaNV, MaQL;
	String TenNV, GioiTinh, ChucVu, CCCD ,Email, Username, Password;
	Date NgaySinh, NgayVL;

	public NhanVien()
	{
	
	}
	public NhanVien(int maNV)
	{
		MaNV = maNV;
	}
	public NhanVien(int maNV,  String tenNV, String Email, Date ngaySinh, String gioiTinh, String CCCD, String chucVu, 
			Date ngayVL, int maQL, String Username, String Password) {
		this.MaNV = maNV;
		this.MaQL = maQL;
		this.TenNV = tenNV;
		GioiTinh = gioiTinh;
		ChucVu = chucVu;
		this.CCCD = CCCD;
		NgaySinh = ngaySinh;
		NgayVL = ngayVL;
		this.Email = Email;
		this.Username = Username;
		this.Password = Password;
	}
	public NhanVien(int MANV, String Username, String Password, String chucVu)
	{
		this.MaNV = MANV;
		this.Username = Username;
		this.Password = Password;
		this.ChucVu = chucVu;
	}
	public NhanVien(String tenNV,String Email, Date ngaySinh, String gioiTinh, String CCCD, String chucVu, 
			Date ngayVL, int maQL,  String Username, String Password) {
		super();
		MaQL = maQL;
		TenNV = tenNV;
		GioiTinh = gioiTinh;
		ChucVu = chucVu;
		this.CCCD = CCCD;
		NgaySinh = ngaySinh;
		NgayVL = ngayVL;
		this.Email = Email;
		this.Username = Username;
		this.Password = Password;
	}
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public NhanVien(String tenNV,String Email, Date ngaySinh, String gioiTinh, String CCCD, String chucVu, 
			Date ngayVL, String Username, String Password) {
		super();
		
		TenNV = tenNV;
		GioiTinh = gioiTinh;
		ChucVu = chucVu;
		this.CCCD = CCCD;
		NgaySinh = ngaySinh;
		NgayVL = ngayVL;
		this.Email = Email;
		this.Username = Username;
		this.Password = Password;
	}
	public NhanVien(String tenNV)
	{
		this.TenNV = tenNV;
	}
	public int getMaNV() {
		return MaNV;
	}
	public void setMaNV(int maNV) {
		MaNV = maNV;
	}
	public int getMaQL() {
		return MaQL;
	}
	public void setMaQL(int maQL) {
		MaQL = maQL;
	}

	public String getTenNV() {
		return TenNV;
	}
	public void setTenNV(String tenNV) {
		TenNV = tenNV;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public String getChucVu() {
		return ChucVu;
	}
	public void setChucVu(String chucVu) {
		ChucVu = chucVu;
	}
	public String getCCCD() {
		return this.CCCD;
	}
	public void setCCCD(String cCCD) {
		this.CCCD = cCCD;
	}
	public Date getNgaySinh() {
		return NgaySinh;
	}
	public String getNgaySinh_str() {
		return String.valueOf(NgaySinh);
	}
	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public Date getNgayVL() {
		return NgayVL;
	}
	public String getNgayVL_str() {
		return String.valueOf(NgayVL);
	}
	public void setNgayVL(Date ngayVL) {
		NgayVL = ngayVL;
	}
	
	
}

