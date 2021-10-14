package Class;

public class DonVi {
	private int MaDonVi;
	private String TenDonVi;
	
	public DonVi(int maDonVi, String tenDonVi) {
		super();
		MaDonVi = maDonVi;
		TenDonVi = tenDonVi;
	}
	public DonVi(int maDonVi) {
		super();
		MaDonVi = maDonVi;
	}
	public DonVi(String tenDonVi) {
		super();
		TenDonVi = tenDonVi;
	}
	public int getMaDonVi() {
		return MaDonVi;
	}
	public void setMaDonVi(int maDonVi) {
		MaDonVi = maDonVi;
	}
	public String getTenDonVi() {
		return TenDonVi;
	}
	public void setTenDonVi(String tenDonVi) {
		TenDonVi = tenDonVi;
	}
	

}
