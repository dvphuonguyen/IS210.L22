package Class;

public class LoaiKH{
	private int maLKH;
	private String tenLKH;
	
	public LoaiKH(int maLKH, String tenLKH) {
		super();
		this.maLKH = maLKH;
		this.tenLKH = tenLKH;
	}
	public int getMaLKH() {
		return maLKH;
	}
	public String getTenLKH() {
		return tenLKH;
	}
	public void setMaLKH(int maLKH) {
		this.maLKH = maLKH;
	}
	public void setTenLKH(String tenLKH) {
		this.tenLKH = tenLKH;
	}
	
}
