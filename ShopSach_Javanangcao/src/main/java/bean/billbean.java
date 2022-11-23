package bean;

public class billbean {
	 private String MaHoaDon	;
	   private String tenkh; 
	   private String NgayMua;
	public billbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public billbean(String maHoaDon, String tenkh, String ngayMua) {
		super();
		MaHoaDon = maHoaDon;
		this.tenkh = tenkh;
		NgayMua = ngayMua;
	}
	public String getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public String getTenkh() {
		return tenkh;
	}
	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}
	public String getNgayMua() {
		return NgayMua;
	}
	public void setNgayMua(String ngayMua) {
		NgayMua = ngayMua;
	}

}
