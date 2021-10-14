package Class;

public class Phong {
	private String  Note, MaLP, TenPhong;
	private int MaPhong;

	public Phong() {
		
		
	}

	
	public Phong(int maPhong) {
		
		MaPhong = maPhong;
	}
	public Phong(String tenPhong) {
		this.TenPhong = tenPhong;
	}
	public Phong(int maPhong, String TenPhong, String note, String maLP) {
		super();
		MaPhong = maPhong;
		Note = note;
		MaLP = maLP;
		this.TenPhong = TenPhong;
	}
	public Phong(int maPhong, String TenPhong) {
		super();
		MaPhong = maPhong;
		this.TenPhong = TenPhong;
	}
	public String getTenPhong() {
		return TenPhong;
	}

	public void setTenPhong(String tenPhong) {
		TenPhong = tenPhong;
	}

	public int getMaPhong() {
		return MaPhong;
	}

	public void setMaPhong(int maPhong) {
		MaPhong = maPhong;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}

	public String getMaLP() {
		return MaLP;
	}

	public void setMaLP(String maLP) {
		MaLP = maLP;
	}
	
	
	
	
}
