package Class;

public class LoaiPhong {
	
	private String maLP, tenLP;
	private int giaPhong, slToiDa;
	
	public LoaiPhong() {}
	public LoaiPhong(int giaPhong) {
		super();
		
		this.giaPhong = giaPhong;
		
	}
	public LoaiPhong(String maLP, String tenLP, int giaPhong, int slToiDa) {
		super();
		this.maLP = maLP;
		this.tenLP = tenLP;
		this.giaPhong = giaPhong;
		this.slToiDa = slToiDa;
	}

	public LoaiPhong(String tenLP, int giaPhong) {
		super();
		this.tenLP = tenLP;
		this.giaPhong = giaPhong;
	}

	public String getMaLP() {
		return maLP;
	}
	public void setMaLP(String maLP) {
		this.maLP = maLP;
	}
	public String getTenLP() {
		return tenLP;
	}
	public void setTenL(String tenL) {
		this.tenLP = tenL;
	}
	public int getGiaPhong() {
		return giaPhong;
	}
	public void setGiaPhong(int giaPhong) {
		this.giaPhong = giaPhong;
	}
	public int getSlToiDa() {
		return slToiDa;
	}
	public void setSlToiDa(int slToiDa) {
		this.slToiDa = slToiDa;
	}
	
	
	
}
