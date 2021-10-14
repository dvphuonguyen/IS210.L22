package Class;

public class ChiTietKM {
	private int MaLKH, MaKM, phanTram;

	public ChiTietKM(int maLKH, int maKM, int phanTram) {
		super();
		MaLKH = maLKH;
		MaKM = maKM;
		this.phanTram = phanTram;
	}

	public int getMaLKH() {
		return MaLKH;
	}

	public void setMaLKH(int maLKH) {
		MaLKH = maLKH;
	}

	public int getMaKM() {
		return MaKM;
	}

	public void setMaKM(int maKM) {
		MaKM = maKM;
	}

	public int getPhanTram() {
		return phanTram;
	}

	public void setPhanTram(int phanTram) {
		this.phanTram = phanTram;
	}
	
}
