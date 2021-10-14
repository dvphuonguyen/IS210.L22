package Class;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaoCao {
	private String maBC,  ngayLBC, maQL;
	private int tongTienThu, soPD, soPTr, soPTh;
	public Date getngayLBC() 
	{
		Date date = null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = formatter.parse(this.ngayLBC);
        } catch (ParseException e) {
            e.printStackTrace();
        }
		return date;
	}
	public void setngayLBC(Date ngayLBC)
	{
		Date date = null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = formatter.parse(this.ngayLBC);
            date = ngayLBC;
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}
	public String getMaBC() {
		return maBC;
	}
	public void setMaBC(String maBC) {
		this.maBC = maBC;
	}
	public String getMaQL() {
		return maQL;
	}
	public void setMaQL(String maQL) {
		this.maQL = maQL;
	}
	public int getTongTienThu() {
		return tongTienThu;
	}
	public void setTongTienThu(int tongTienThu) {
		this.tongTienThu = tongTienThu;
	}
	public int getSoPD() {
		return soPD;
	}
	public void setSoPD(int soPD) {
		this.soPD = soPD;
	}
	public int getSoPTr() {
		return soPTr;
	}
	public void setSoPTr(int soPTr) {
		this.soPTr = soPTr;
	}
	public int getSoPTh() {
		return soPTh;
	}
	public void setSoPTh(int soPTh) {
		this.soPTh = soPTh;
	}
	
	
}
