package Class;

public class DichVu {
	private int MaDV, GiaDV, maDonVi;
	private String TenDV;

	public DichVu() {}

	
	public DichVu(int maDV, String tenDV, int giaDV, int maDonVi) {
		super();
		MaDV = maDV;
		GiaDV = giaDV;
		this.maDonVi = maDonVi;
		TenDV = tenDV;
	}
	
	public DichVu(int maDV) {
		super();
		MaDV = maDV;
	}
	
	
	

	public DichVu(String tenDV, int giaDV, int maDonVi) {
		super();

		GiaDV = giaDV;
		this.maDonVi = maDonVi;
		TenDV = tenDV;
	}

	public int getMaDV() {
		return MaDV;
	}

	public void setMaDV(int maDV) {
		MaDV = maDV;
	}

	public int getGiaDV() {
		return GiaDV;
	}

	public void setGiaDV(int giaDV) {
		GiaDV = giaDV;
	}

	public int getMaDonVi() {
		return maDonVi;
	}

	public void setMaDonVi(int maDonVi) {
		this.maDonVi = maDonVi;
	}

	public String getTenDV() {
		return TenDV;
	}

	public void setTenDV(String tenDV) {
		TenDV = tenDV;
	}
	
	
	
	
	
	

}
