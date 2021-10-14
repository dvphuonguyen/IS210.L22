package Class;

public class TinhTrangPhong {
	private int MaTTP;
	private String TenTTP;
	
	public TinhTrangPhong(int maTTP, String tenTTP) {
		super();
		MaTTP = maTTP;
		TenTTP = tenTTP;
	}
	public int getMaTTP() {
		return MaTTP;
	}
	public void setMaTTP(int maTTP) {
		MaTTP = maTTP;
	}
	public String getTenTTP() {
		return TenTTP;
	}
	public void setTenTTP(String tenTTP) {
		TenTTP = tenTTP;
	}
	
}
