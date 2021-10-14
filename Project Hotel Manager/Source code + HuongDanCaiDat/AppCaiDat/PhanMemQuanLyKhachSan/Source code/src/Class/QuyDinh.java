package Class;

public class QuyDinh {
	private int maQD;
	private String  tenQD, moTa;
	
	
	public QuyDinh(int maQD, String tenQD, String moTa) {
		super();
		this.maQD = maQD;
		this.tenQD = tenQD;
		this.moTa = moTa;
	}
	public QuyDinh( String tenQD, String moTa) {
		super();
		this.tenQD = tenQD;
		this.moTa = moTa;
	}
	public int getMaQD() {
		return maQD;
	}

	public void setMaQD(int maQD) {
		this.maQD = maQD;
	}

	public String getTenQD() {
		return tenQD;
	}

	public void setTenQD(String tenQD) {
		this.tenQD = tenQD;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	
}
